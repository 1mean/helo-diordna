package com.example.pandas.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseCMFragment
import com.example.pandas.bean.MediaInfo
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.biz.ext.getUrl
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.manager.PlayerManager
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.activity.VideoPlayingActivity
import com.example.pandas.ui.adapter.RecommendAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.ScreenUtil
import com.google.android.exoplayer2.Player.REPEAT_MODE_ONE
import com.google.android.exoplayer2.util.Util

/**
 * @description: 首页-推荐
 * 当预加载设置为1时
 * 当banner可见时，滑动到左右两个item，还是在运行， 滑动位置超过1个时才会触发onDetachedFromWindow
 * 当切换到homeFragment外也是触发超过1个的会触发onDetachedFromWindow
 * @author: dongyiming
 * @date: 1/4/22 3:05 下午
 * @version: v1.0
 */
public class RecommendFragment : BaseCMFragment<HomePageViewModel, LayoutSwipRefreshBinding>(),
    RecommendAdapter.RecoViewListener {

    private val mAdapter: RecommendAdapter by lazy {
        RecommendAdapter(
            lifecycle,
            RecommendData(),
            this
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.init(
            RecommendDecoration(mActivity),
            mAdapter,
            GridLayoutManager(activity, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getRecommendData(false)
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_reco)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getRecommendData(true)
            }
        }
        binding.recyclerLayout.addOnScrollListener(recyclerViewScrollListener)
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            PlayerManager.instance.initPlayer(mActivity).addPlayerListener(playerListener)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        PlayerManager.instance.releasePlayer()
    }

    /**
     * 处理滑动，超过一半才播放，因最底部加载更多时type问题
     * 注意：
     *    1- RecyclerView.childCount：当前屏幕可见view的数目，LayoutManager.childCount
     *    2- RecyclerView.getChildAt(i): i为当前view在当前可见的几个view里的位置，而不是adapter容器里的position
     */
    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            when (newState) {
                RecyclerView.SCROLL_STATE_IDLE -> {

                    val mRecyclerView = recyclerView as SwipRecyclerView
                    val manager = mRecyclerView.layoutManager as LinearLayoutManager
                    val firstPos = manager.findFirstVisibleItemPosition()
                    val lastPos = manager.findLastVisibleItemPosition()
                    //下一次滑动时，通过position来关闭当前已经在运行的view
                    for (position in firstPos..lastPos) {

                        if (mAdapter.getItemViewType(position) == 3) {//横屏视频

                            Log.e("1mean", "type 3 position: $position")

                            val itemData = mAdapter.getItemData(position)
                            val itemView = mRecyclerView.getChildAt(position - firstPos) ?: return

                            //1,若可视区域显示的播放器视图 < 控件高度的一半，关闭播放
                            if (!ScreenUtil.isOverHalfViewVisiable(itemView)) {
                                PlayerManager.instance.stopPlayer()
                                return
                            } else {//是否是同一视频，在播放里已处理

                                val holder =
                                    mRecyclerView.findViewHolderForLayoutPosition(position) as RecommendAdapter.VideoHolder

                                val file = getUrl(mActivity, itemData.fileName!!)

                                val currentPos: Long = if (itemData.videoData == null) {
                                    0L
                                } else {
                                    itemData.videoData!!.playPosition.toLong()
                                }
                                val playInfo =
                                    MediaInfo(
                                        itemData.code,
                                        "",
                                        file,
                                        currentPos
                                    )

                                PlayerManager.instance.addPlayerView(holder.playView)
                                    .setRepeatMode(REPEAT_MODE_ONE)
                                    .startPlay(true, position, playInfo)

                            }
                            return
                        }
                    }
                }
            }
        }
    }

    /**
     * 关闭正在播放的视频，并且存储历史记录
     */
    override fun onPause() {
        super.onPause()
        PlayerManager.instance.stopPlayer()
//        mViewModel.addOrUpdateVideoData(
//            PlayerManager.instance.getCurrentVideoCode(),
//            PlayerManager.instance.getCurrentPos()
//        )
    }

    /**
     * 如果有video，播放
     */
    override fun againOnResume() {
        Log.e("1asdasdmean", "againOnResume")
        playVideo()
    }

//    override fun updateCurPlayerView(curPos: Int, isHide: Boolean) {
//
//        val holder =
//            binding.recyclerLayout.findViewHolderForLayoutPosition(curPos)
//        Log.e("RecommendFragment", "updateCurPlayerView: $holder")
//        if (holder is RecommendAdapter.VideoHolder) {
//            holder.updateItemView(curPos, isHide)
//        }
//    }

    override fun createObserver() {

        mViewModel.recommendDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshData(it.recoData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.addData(it.recoData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getRecommendData(true)
    }

    override fun onClick(position: Int, type: Int, videoCode: Int) {

        if (type == 3) {
            PlayerManager.instance.stopPlayer()
//            mViewModel.addOrUpdateVideoData(
//                PlayerManager.instance.getCurrentVideoCode(),
//                PlayerManager.instance.getCurrentPos()
//            )
        }
        val intent = Intent(mActivity, VideoPlayingActivity::class.java).apply {
            putExtra("code", videoCode)
        }
    }

    override fun itemDetachedFromWindow() {
        PlayerManager.instance.stopPlayer()
    }

    private val playerListener = object : ExoPlayerListener {
        override fun updatePlayerView(isVisible: Boolean, curPos: Int) {
            val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(curPos)
            if (holder is RecommendAdapter.VideoHolder) {
                (holder as RecommendAdapter.VideoHolder).updateItemView(curPos, isVisible)
            }
        }
    }

    /**
     * 播放屏幕中的横屏视频
     */
    private fun playVideo() {

//        val mRecyclerView = binding.recyclerLayout
//        val manager = mRecyclerView.layoutManager as LinearLayoutManager
//        val firstPos = manager.findFirstVisibleItemPosition()
//        val lastPos = manager.findLastVisibleItemPosition()
//        for (position in firstPos..lastPos) {
//            if (mAdapter.getItemViewType(position) == 3) {//横屏视频
//                val itemData = mAdapter.getItemData(position)
//                val itemView = mRecyclerView.getChildAt(position - firstPos) ?: return
//                if (ScreenUtil.isOverHalfViewVisiable(itemView)) {
//                    val holder = mRecyclerView.findViewHolderForLayoutPosition(position)
//                    if (holder is RecommendAdapter.VideoHolder) {
//                        PlayerManager.instance.continuePlay(itemData.code, 1, holder.playerView)
//                    }
//                }
//                return
//            }
//        }
    }

}