package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseCMFragment
import com.example.pandas.bean.MediaInfo
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.manager.PlayerManager
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.RecommendAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.ScreenUtil
import com.google.android.exoplayer2.Player.REPEAT_MODE_ONE
import com.google.android.exoplayer2.ui.StyledPlayerView
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

    private var againOnstart = false
    private val mAdapter: RecommendAdapter by lazy {
        RecommendAdapter(
            lifecycle,
            RecommendData(),
            this
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.run {
            init(
                RecommendDecoration(mActivity), mAdapter,
                GridLayoutManager(activity, 2),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getRecommendData(false)
                    }
                })
            addOnScrollListener(recyclerViewScrollListener)
        }

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_reco)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getRecommendData(true)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23 && !againOnstart) {
            PlayerManager.instance.initPlayer(mActivity).addPlayerListener(playerListener)
            againOnstart = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        PlayerManager.instance.releasePlayer()
    }

    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            when (newState) {
                RecyclerView.SCROLL_STATE_IDLE -> {
                    startPlay()
                }
            }
        }

        //当顶部Appbar偏移为负时，向下拉出，
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            Log.e("1mean", "dy:$dy, dx:$dx")
//            if (recyclerView.childCount <= 0) return
//            recyclerView.getChildAt(0)?.let {
//                if (parentFragment is HomeFragment) {
//                    if ((parentFragment as HomeFragment).getVerticalOffset() < 0) {
//
//                    }
//                }
//            }
        }
    }

    /**
     * 关闭正在播放的视频，并且存储历史记录
     *  - 跳转进VideoPlayingActivity时也会触发，加以限制
     */
    override fun onPause() {
        super.onPause()
        if (PlayerManager.instance.isPlaying()) {
            PlayerManager.instance.stopPlayer()
            //mViewModel.addOrUpdateVideoData(videoCode, playPos)
        }
    }

    override fun againOnResume() {
        startResultPlay()
    }

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
            PlayerManager.instance.pausePlayer()
            startVideoPlayActivity(mActivity, videoCode, true)
        } else {
            startVideoPlayActivity(mActivity, videoCode, false)
        }
    }

    override fun itemDetachedFromWindow() {
        PlayerManager.instance.stopPlayer()
        //mViewModel.addOrUpdateVideoData(videoCode, playPos)
    }

    override fun updatePlayerVoice() {
        PlayerManager.instance.updateHomePageVolumn()
    }

    override fun addLaterPLay(videoCode: Int) {
        mViewModel.addLaterPlayer(videoCode)
        Toast.makeText(mActivity, "添加成功", Toast.LENGTH_SHORT).show()
    }

    private val playerListener = object : ExoPlayerListener {
        override fun updatePlayerView(isVisible: Boolean, curPos: Int) {
            Log.e("PlayerManager", "updatePlayerView：$isVisible, $curPos")
            val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(curPos)
            if (holder is RecommendAdapter.VideoHolder) {
                (holder as RecommendAdapter.VideoHolder).updateItemView(curPos, isVisible)
            }
        }
    }

    /**
     * 处理滑动，超过一半才播放，因最底部加载更多时type问题
     * 注意：
     *    1- RecyclerView.childCount：当前屏幕可见view的数目，LayoutManager.childCount
     *    2- RecyclerView.getChildAt(i): i为当前view在当前可见的几个view里的位置，而不是adapter容器里的position
     */
    private fun startPlay() {
        val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager
        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()
        for (position in firstPos..lastPos) {
            if (mAdapter.getItemViewType(position) == 3) {//横屏视频
                val itemData = mAdapter.getItemData(position)
                val videoCode = itemData.code
                val itemView = mRecyclerView.getChildAt(position - firstPos) ?: return
                if (itemView !is CardView) return
                val childView = (itemView as CardView).getChildAt(0) ?: return
                if (childView is StyledPlayerView) {
                    val isOverHalf = ScreenUtil.isOverHalfViewVisiable(childView)
                    if (PlayerManager.instance.handleOn(isOverHalf, videoCode, position)) {
                        return
                    }
                    val file = getLocalFilePath(mActivity, itemData.fileName!!)
                    val currentPos: Long = if (itemData.videoData == null) {
                        0L
                    } else {
                        itemData.videoData!!.playPosition
                    }
                    val playInfo =
                        MediaInfo(videoCode, file.absolutePath, currentPos)
                    PlayerManager.instance.setRepeatMode(REPEAT_MODE_ONE)
                        .addPlayerView(childView)
                        .startOneLocalPlayer(playInfo, position)
                }
                return
            }
        }
    }

    private fun startResultPlay() {

        PlayerManager.instance.addPlayerListener(playerListener)

        val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager
        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()
        for (position in firstPos..lastPos) {
            if (mAdapter.getItemViewType(position) == 3) {//横屏视频
                val itemData = mAdapter.getItemData(position)
                val videoCode = itemData.code
                val itemView = mRecyclerView.getChildAt(position - firstPos) ?: return
                if (itemView !is CardView) return
                val childView = (itemView as CardView).getChildAt(0) ?: return
                if (childView is StyledPlayerView) {
                    if (PlayerManager.instance.continueSameMedia(videoCode, childView)) {
                        return
                    }
                    val file = getLocalFilePath(mActivity, itemData.fileName!!)
                    val currentPos: Long = if (itemData.videoData == null) {
                        0L
                    } else {
                        itemData.videoData!!.playPosition
                    }
                    val playInfo =
                        MediaInfo(videoCode, file.absolutePath, currentPos)
                    PlayerManager.instance.addPlayerView(childView)
                        .addPlayerListener(playerListener)
                        .startPlay(true, position, playInfo)
                }
                return
            }
        }
    }
}