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
            //addOnChildAttachStateChangeListener(childAttachStateChangeListener)
        }

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                ExoPlayerManager.instance.stopPlayer()
                mViewModel.initData(true)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            ExoPlayerManager.instance.initPlayer(mActivity,object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    when (playbackState) {
                        Player.STATE_BUFFERING -> {
                            //Log.e("eyeFragment", "STATE_BUFFERING")
                        }
                        Player.STATE_READY -> {//拖动结束后也会触发
                            Log.e("eyeFragment", "STATE_READY")
                            val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(curPos)
                            mAdapter.prePlayView(curPos, holder, true)
                        }
                        Player.STATE_IDLE -> {//暂停不会触发
                            Log.e("eyeFragment", "STATE_IDLE")
                            startFirstItemView()
                        }
                        Player.STATE_ENDED -> {//播放结束
                            Log.e("eyeFragment", "STATE_ENDED")
                        }
                    }
                }
            })
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

        //1.先处理界面
        val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
        val playerView = itemView.findViewById<StyledPlayerView>(R.id.player_eye)

        //2.初始化播放器
        curPos = position
        val data = mAdapter.getItemData(position)
        ExoPlayerManager.instance.setUpPlay(playerView, 0).play(ExoPlayerManager.PlayingInfo(data.videoId, data.playUrl!!))
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
                if (curPos in firstPos..lastPos) {

                    val curIndex = curPos - firstPos
                    val curView = mRecyclerView.getChildAt(curIndex)
                    if (!ScreenUtil.isOverHalfViewVisiable(curView)) {//不满足播放条件
                        Log.e("eyeFragment", "eyeFragment curPos：$curPos，关闭当前视频，等待播放符合条件的第一个视频！！")
                        ExoPlayerManager.instance.stopPlayer()
                    } else {
                        if (curIndex == 0) {
                            Log.e("eyeFragment", "eyeFragment curPos：$curPos，符合条件，继续播放，不用停止")
                            return
                        } else if (curIndex == 1) {
                            val firstView = mRecyclerView.getChildAt(0)
                            if (ScreenUtil.isOverHalfViewVisiable(firstView)) {
                                Log.e("eyeFragment", "eyeFragment curPos：$curPos，关闭当前视频，等待播放符合条件的第一个视频！！")
                                ExoPlayerManager.instance.stopPlayer()
                            } else {
                                Log.e("eyeFragment", "eyeFragment curPos：$curPos，符合条件，继续播放，不用停止")
                                return
                            }
                        } else if (curIndex > 1) {//如果上面有两个视频，无论如何都需要关闭当前播放的视频
                            Log.e("eyeFragment", "eyeFragment curPos：$curPos，关闭当前视频，等待播放符合条件的第一个视频！！")
                            ExoPlayerManager.instance.stopPlayer()
                        }
                    }
                }

                //2,轮询可视ItemView，播放第一个满足(可视高度>=最大高度)的ItemView
                /*for (pos in firstPos..lastPos) {
                    val firstView = mRecyclerView.getChildAt(pos - firstPos)
                    val lastView = mRecyclerView.getChildAt(lastPos - firstPos)

                    //1.2- 如果不在第一的位置，关闭当前正在播放的视频，开始播放屏幕内排第一的那个视频
                    if (curPos in (firstPos + 1) until lastPos) {

                        val curView = mRecyclerView.getChildAt(curPos - firstPos)
                        if (ScreenUtil.isOverHalfViewVisiable(curView)) {

                            if (curPos == firstPos) {
                                Log.e("1mean", "eyeFragment curPos：$curPos，继续播放当前视频")
                                return
                            } else {
                                Log.e("1mean", "eyeFragment curPos：$curPos，关闭当前视频，等待第一个视频！！")
                                ExoPlayerManager.instance.stopPlayer()
                            }
                        } else {

                        }
                    }

                    //getChildAt(i): i为当前view在当前可见的几个view里的位置，而不是adapter容器里的position
                    if (ScreenUtil.isOverHalfViewVisiable(firstView)) {//ItemView可视高度超过一半才满足播放条件
                        startPlay(pos, firstView)
                        break
                    }
                }*/
            }
        }
    }

    private fun startFirstItemView(){
        val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager
        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()

        if (firstPos == -1 || lastPos == -1) return

        //这里只处理当前播放视频，滑动结束后仍然在屏幕内
        for (pos in firstPos..lastPos) {
            val itemView = mRecyclerView.getChildAt(pos - firstPos)
            if (ScreenUtil.isOverHalfViewVisiable(itemView)) {//ItemView可视高度超过一半才满足播放条件
                startPlay(pos, itemView)
                break
            }

        }
    }

    /**
     *  处理二、当前正在播放的ItemVIew完全滑出可视区域
     * @date: 5/14/22 2:01 上午
     * @version: v1.0
     */
    /*private val childAttachStateChangeListener =
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

        }*/
}