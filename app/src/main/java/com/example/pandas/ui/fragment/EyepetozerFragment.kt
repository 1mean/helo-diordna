package com.example.pandas.ui.fragment

import CommonItemDecoration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.manager.ExoPlayerManager
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.EyepetozerAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.ScreenUtil
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.Util

/**
 * @description: 开眼
 * @author: dongyiming
 * @date: 2021/12/21 2:16 下午
 * @version: v1.0
 */
public class EyepetozerFragment :
    BaseLazyFragment<EyepetozerViewModel, LayoutSwipRefreshBinding>() {

    private var existDataInView = false//界面是否存在数据，下次出错不会影响界面显示

    private var curPos = -1 //当前要播放的ItemView的位置

    private val paddingBottom: Int
        get() = resources.getDimension(R.dimen.common_lh_10_dimens).toInt()

    private val mAdapter: EyepetozerAdapter by lazy { EyepetozerAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

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
            addOnChildAttachStateChangeListener(childAttachStateChangeListener)
        }

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.initData(true)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            ExoPlayerManager.instance.initPlayer(mActivity)
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.initData(true)
    }

    override fun createObserver() {

        mViewModel.eyepetozerWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> {
                        binding.recyclerLayout.visibility = View.GONE
                        binding.layoutError.llayoutError.visibility = View.GONE
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }
                    it.isRefresh -> {
                        existDataInView = true
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.isRefreshing(false)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                        preExoPlayer()
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                }
            } else {
                when {
                    it.isRefresh -> {
                        if (existDataInView) {
                            Toast.makeText(mActivity, "出现了错误，请稍后再试", Toast.LENGTH_SHORT).show()
                        } else {
                            binding.recyclerLayout.visibility = View.GONE
                            binding.layoutError.llayoutError.visibility = View.GONE
                            binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                        }
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
                    startPlay(pos, itemView)
                    break
                }
            }
        }
    }

    /**
     * 处理视频的播放，包括ExoPlayer逻辑和界面View的处理
     */
    private fun startPlay(position: Int, itemView: View) {

        if (ExoPlayerManager.instance.isPlayIng()) {

        }

        //1.先处理界面
        val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
        val playerView = itemView.findViewById<StyledPlayerView>(R.id.player_eye)

        //2.初始化播放器
        curPos = position
        val data = mAdapter.getItemData(position)
        ExoPlayerManager.instance.setUpPlay(playerView, 0, object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                when (playbackState) {
                    Player.STATE_BUFFERING -> {
                        Log.e("eyeFragment", "STATE_BUFFERING")
                    }
                    Player.STATE_READY -> {//拖动结束后也会触发
                        Log.e("eyeFragment", "STATE_READY")
                        mAdapter.prePlayView(position, holder, true)
                    }
                    Player.STATE_IDLE -> {//暂停不会触发
                        Log.e("eyeFragment", "STATE_IDLE")
                    }
                    Player.STATE_ENDED -> {//播放结束
                        Log.e("eyeFragment", "STATE_ENDED")
                    }
                }
            }
        }).play(ExoPlayerManager.PlayingInfo(data.videoId, data.playUrl!!))
    }

    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                //1,获取当前界面，可视的所有itemView,和其在adpter里的真实位置
                val mRecyclerView = binding.recyclerLayout
                val manager = mRecyclerView.layoutManager as LinearLayoutManager
                val firstPos = manager.findFirstVisibleItemPosition()
                val lastPos = manager.findLastVisibleItemPosition()

                if (firstPos == -1 || lastPos == -1) return

                //2,轮询可视ItemView，播放第一个满足(可视高度>=最大高度)的ItemView
                for (pos in firstPos..lastPos) {
                    val firstView = mRecyclerView.getChildAt(pos - firstPos)
                    val lastView = mRecyclerView.getChildAt(lastPos - firstPos)
                    //处理一、当正在播放的ItemView没有滑出可视范围，可视区域不足一半时关闭
                    if (curPos != -1 &&
                        ExoPlayerManager.instance.isPlayIng() &&
                        (curPos == firstPos || curPos == lastPos)
                    ) {
                        if (curPos == firstPos) {

                            if (ScreenUtil.isOverHalfViewVisiable(firstView)) {
                                return
                            } else {
                                ExoPlayerManager.instance.stopPlayer()
                            }
                        }
                        if (curPos == lastPos) {
                            if (ScreenUtil.isOverHalfViewVisiable(lastView)) {
                                return
                            } else {
                                ExoPlayerManager.instance.stopPlayer()
                            }
                        }

                        if (curPos in (firstPos + 1) until lastPos) {

                            if (ScreenUtil.isOverHalfViewVisiable(firstView)) {
                                ExoPlayerManager.instance.stopPlayer()
                            }
                        }

                    }


                    //getChildAt(i): i为当前view在当前可见的几个view里的位置，而不是adapter容器里的position
                    if (ScreenUtil.isOverHalfViewVisiable(firstView)) {//ItemView可视高度超过一半才满足播放条件
                        startPlay(pos, firstView)
                        break
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
                    curPos = -1
                    val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
                    ExoPlayerManager.instance.stopPlayer()
//                    if (mPlayer?.isPlaying == true) {
//                        mPlayer?.stop()
//                        holder.stopPlay()
//                    }
                }
            }

        }
}