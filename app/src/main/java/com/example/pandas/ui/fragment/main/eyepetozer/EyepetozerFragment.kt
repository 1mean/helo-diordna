package com.example.pandas.ui.fragment.main.eyepetozer

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseCMFragment
import com.example.pandas.biz.manager.ExoPlayerManager
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.EyepetozerAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.ScreenUtil
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.Util

/**
 * @description: 开眼
 * @author: dongyiming
 * @date: 2021/12/21 2:16 下午
 * @version: v1.0
 */
public class EyepetozerFragment :
    BaseCMFragment<EyepetozerViewModel, LayoutSwipRefreshBinding>(),
    ExoPlayerManager.OnExoListListener {

    private var existDataInView = false//界面是否存在数据，下次出错不会影响界面显示

    override fun lazyLoadTime(): Long = 0

    private var lastPos = -1 //上一次播放的ItemView的位置
    private var curPos = lastPos //当前要播放的ItemView的位置

    private var isCurVideoDetach = false


    private val mAdapter: EyepetozerAdapter by lazy { EyepetozerAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingBottom: Int = resources.getDimension(R.dimen.common_lh_10_dimens).toInt()
        binding.recyclerLayout.run {
            init(
                CommonItemDecoration(paddingBottom = paddingBottom),
                mAdapter,
                LinearLayoutManager(mActivity),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.initData(false)
                    }
                })
            addOnScrollListener(recyclerViewScrollListener)
            //addOnChildAttachStateChangeListener(childAttachStateChangeListener)
        }

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.initData(true)
            }
        }

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(viewColors[it])
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            ExoPlayerManager.instance.initPlayer(mActivity).addExoListener(this)
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.initData(true)
    }

    override fun refresh() {
        super.refresh()
        binding.swipLayout.isRefreshing = true
        mViewModel.initData(true)
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

    override fun againOnResume() {
        if (!ExoPlayerManager.instance.isPlayIng()) {
            ExoPlayerManager.instance.prePare()
        }
        Log.e("eyeFragment", "state: ${lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        if (ExoPlayerManager.instance.isPlayIng()) {
            ExoPlayerManager.instance.stopPlayer()
        }
        Log.e("eyeFragment", "onPause")
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            binding.swipLayout.setColorSchemeResources(viewColors[it])
        }

        mViewModel.eyepetozerWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> {
                        binding.recyclerLayout.visibility = View.GONE
                        binding.layoutError.llayoutError.visibility = View.GONE
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }
                    it.isRefresh -> {
                        curPos = -1
                        lastPos = -1
                        ExoPlayerManager.instance.refreshMediaItem(it.listData)
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.isRefreshing(false)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                        preExoPlayer()
                    }
                    else -> {
                        Log.e("eyeFragment", "list: ${it.listData.size}")
                        ExoPlayerManager.instance.addMediaItems(it.listData)
                        mAdapter.loadMore(it.listData)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                }
            } else {
                when {
                    it.isRefresh -> {
                        if (existDataInView) {
                            Toast.makeText(mActivity, "刷新出现了错误，请稍后再试", Toast.LENGTH_SHORT).show()
                        } else {
                            binding.recyclerLayout.visibility = View.GONE
                            binding.layoutError.llayoutError.visibility = View.GONE
                            binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                        }
                    }
                    else -> {
                        Toast.makeText(mActivity, "加载出现了错误，请稍后再试", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    private fun preExoPlayer() {

        binding.recyclerLayout.post {

            //1,获取当前界面，可视的所有itemView,和其在adpter里的真实位置
            val mRecyclerView = binding.recyclerLayout
            val manager = mRecyclerView.layoutManager as LinearLayoutManager
            val firstPos = manager.findFirstVisibleItemPosition()
            val lastPos = manager.findLastVisibleItemPosition()

            if (firstPos == -1 || lastPos == -1) return@post

            //2,轮询可视ItemView，播放第一个满足(可视高度>=最大高度)的ItemView
            for (pos in firstPos..lastPos) {
                //getChildAt(i): i为当前view在当前可见的几个view里的位置，而不是adapter容器里的position
                val itemView = mRecyclerView.getChildAt(pos - firstPos)
                if (ScreenUtil.isOverHalfViewVisiable(itemView)) {//ItemView可视高度超过一半才满足播放条件
                    startPlay(true, pos, itemView)
                    break
                }
            }
        }
    }

    /**
     * 处理视频的播放，包括ExoPlayer逻辑和界面View的处理
     */
    private fun startPlay(isRefresh: Boolean, position: Int, itemView: View) {

        //1.先处理界面
        val playerView = itemView.findViewById<StyledPlayerView>(R.id.player_eye)

        existDataInView = true

        lastPos = if (isRefresh) -1 else curPos
        //2.初始化播放器
        curPos = position

        val data = mAdapter.getItemData(position)
        ExoPlayerManager.instance.addPlayerView(playerView, 1)
            .play(ExoPlayerManager.PlayingInfo(data.videoId, data.playUrl!!), position)
    }

    /**
     * RecyclerView滑动结束后，有以下几种情况需要处理(PlayerView可视高度超过一半，才满足播放条件)
     *  >> 这里只处理当前播放视频，滑动结束后仍然在屏幕内
     * - 1. 遍历屏幕内的所有Item，当前播放视频仍然在屏幕内，但是不满足播放条件(只能是第一个和最后一个)
     *      1.1- 关闭正在播放的视频
     *      1.2- 播放符合条件的第一个视频
     * - 2. 遍历屏幕内的所有Item，当前播放视频仍然在屏幕内，满足播放条件
     *      2.1- 如果当前视频是满足条件的第一个视频，不做处理，继续播放当前视频
     *      2.2- 如果当前视频不是满足条件的第一个视频，结束当前播放的视频，准备播放满足条件的第一个视频
     *
     * @date: 5/14/22 8:56 下午
     * @version: v1.0
     */
    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                //1,获取当前界面，可视的所有itemView,和其在adpter里的真实位置
                val mRecyclerView = binding.recyclerLayout
                val manager = mRecyclerView.layoutManager as LinearLayoutManager
                val firstPos = manager.findFirstVisibleItemPosition()
                val lastPos = manager.findLastVisibleItemPosition()

                if (firstPos == -1 || lastPos == -1) return

                //这里只处理当前播放视频，滑动结束后仍然在屏幕内

                for (pos in firstPos..lastPos) {
                    val itemView = mRecyclerView.getChildAt(pos - firstPos)
                    if (ScreenUtil.isOverHalfViewVisiable(itemView)) {
                        if (pos != curPos) {
                            startPlay(false, pos, itemView)
                        }
                        return
                    }
                }
            }
        }
    }

    /**
     *  处理二、当前正在播放的ItemVIew完全滑出可视区域
     * @date: 5/14/22 2:01 上午
     * @version: v1.0
     */
    private val childAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {

                val position = binding.recyclerLayout.getChildAdapterPosition(view)
                if (position == curPos) {//正在运行的视频被滑出屏幕
                    Log.e("eyeFragment", "$curPos 已经移出屏幕，准备关闭视频")
                    val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
                    isCurVideoDetach = true
                    ExoPlayerManager.instance.stopPlayer()
                }
            }

        }

    override fun closeLastPlayedView(lastPos: Int) {
        val holder =
            binding.recyclerLayout.findViewHolderForLayoutPosition(lastPos)
        holder?.let {
            mAdapter.updateItemView(lastPos, false, holder)
        }
    }

    override fun updateCurPlayerView(curPos: Int) {
        val holder =
            binding.recyclerLayout.findViewHolderForLayoutPosition(curPos)
        mAdapter.updateItemView(curPos, true, holder)
    }
}