package com.example.pandas.ui.fragment.main.live

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.manager.LivePlayManager
import com.example.pandas.biz.viewmodel.LiveViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.LiveVideoAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.ScreenUtil
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * @description: 动态-视频
 * @author: dongyiming
 * @date: 10/10/22 5:05 下午
 * @version: v1.0
 */
public class LiveVideoFragment : BaseLazyFragment<LiveViewModel, LayoutSwipRefreshBinding>(),
    LiveVideoAdapter.LiveVideoListener, ExoPlayerListener {

    private val mAdapter: LiveVideoAdapter by lazy { LiveVideoAdapter(listener = this) }

    private var playerManager: LivePlayManager? = null

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_10_dimens).toInt()
        binding.recyclerLayout.run {

            init(
                CommonItemDecoration(paddingBottom = padding),
                mAdapter,
                LinearLayoutManager(context),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getLiveVideo(false)
                    }
                })

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    when (newState) {
                        RecyclerView.SCROLL_STATE_IDLE -> {
                            startPlay()
                            //isScrolling = false
                            //startPlay(false, 0L)
                        }
                        RecyclerView.SCROLL_STATE_DRAGGING -> {
                            //isScrolling = true
                        }
                    }
                }
            })
            addOnChildAttachStateChangeListener(childAttachStateChangeListener)
        }

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_viewpager_bg)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getLiveVideo(true)
                binding.recyclerLayout.isRefreshing(true)
            }
        }

        playerManager = LivePlayManager(mActivity, this)
    }

    override fun createObserver() {

        mViewModel.liveVideos.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        Log.e("1mean", "videoCOutns: ${it.liveVides.lives.size}")
                        mAdapter.refresh(it.liveVides)
                        binding.recyclerLayout.isRefreshing(false)

                        binding.recyclerLayout.post {
                            startPlay()
                        }
                    }
                    else -> {
                        //mAdapter.updata(false, it.landscapeData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun onStart() {
        super.onStart()
        playerManager?.initPlayer(mActivity)
    }

    override fun firstOnResume() {
        mViewModel.getLiveVideo(true)
    }

    override fun updateVideoData(videoData: VideoData) {
        mViewModel.addOrUpdateVideoData(videoData)
    }

    private val childAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                val position = binding.recyclerLayout.getChildAdapterPosition(view)
                if (position == playerManager!!.getCurPosition()) {
                    playerManager?.stop()
                    val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
                    if (holder is LiveVideoAdapter.LiveViewHolder) {
                        (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(true)
                    }
                }
            }
        }

    override fun isPlayingChanged(isPlaying: Boolean) {
        super.isPlayingChanged(isPlaying)

        if (isPlaying) {
            Log.e(
                "LiveVIdeosss",
                "5555 isPlaying=$isPlaying, playPos=${playerManager!!.getCurPosition()}"
            )
            val holder =
                binding.recyclerLayout.findViewHolderForLayoutPosition(playerManager!!.getCurPosition())
            if (holder is LiveVideoAdapter.LiveViewHolder) {
                (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(!isPlaying)
            }
        }
    }

    private fun startPlay() {//是否是恢复
        val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager
        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()

        for (index in firstPos..lastPos) {

            Log.e("LiveVIdeosss", " -------------开始循环")
            if (mAdapter.getItemViewType(index) == 3) {
                val petVideo = mAdapter.getItemData(index)
                Log.e("LiveVIdeosss", "title: ${petVideo.title} ,index=$index")
                Log.e(
                    "LiveVIdeosss",
                    "index=$index, firstPos=$firstPos, playPos=${playerManager!!.getCurPosition()}"
                )
                val itemView = mRecyclerView.getChildAt(index - firstPos) ?: return
                //15 21 27 playerView 相同   5  29  17
                val playerView =
                    (((itemView as LinearLayoutCompat).getChildAt(1) as LinearLayoutCompat).getChildAt(
                        0
                    ) as CardView).getChildAt(0) ?: return
                //val playerView = itemView.findViewById<StyledPlayerView>(R.id.player_live)
                Log.e("LiveVIdeosss", "index: $index, playerView:$playerView")
                val playPos = playerManager!!.getCurPosition()

                val height = ScreenUtil.getLocationHeight(playerView)
                Log.e("LiveVIdeosss", "index:$index, ---------------------height:$height")
                val isOverHalfViewVisiable = ScreenUtil.isOverHalfViewVisiable(playerView)
                Log.e(
                    "LiveVIdeosss",
                    "playPos:$playPos, isOverHalfViewVisiable:$isOverHalfViewVisiable, firstPos: $firstPos, playerView:$playerView"
                )
                if (playerView is StyledPlayerView) {
                    if (height > -18.5) {
                        if (index == playPos) {
                            playerManager?.resumePlay(index)
                            return
                        } else {
                            if (playerManager!!.isPlaying()) {
                                playerManager?.stop()
                                val holder =
                                    binding.recyclerLayout.findViewHolderForLayoutPosition(playPos)
                                if (holder is LiveVideoAdapter.LiveViewHolder) {
                                    (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(true)
                                }

                                val file = getLocalFilePath(mActivity, petVideo.fileName!!)
                                val playInfo =
                                    MediaInfo(petVideo.code, file.absolutePath, 0)
                                playerManager!!.addPlayerView(playerView)
                                    .startPlay(true, playInfo, index)
                            } else {
                                Log.e("LiveVIdeosss", "4444")
                                val file = getLocalFilePath(mActivity, petVideo.fileName!!)
                                val playInfo =
                                    MediaInfo(petVideo.code, file.absolutePath, 0)
                                playerManager!!.addPlayerView(playerView)
                                    .startPlay(true, playInfo, index)
                            }
                            return
                        }
                    } else {
                        if (index == playPos) {
                            playerManager?.stop()
                            val holder =
                                binding.recyclerLayout.findViewHolderForLayoutPosition(index)
                            if (holder is LiveVideoAdapter.LiveViewHolder) {
                                (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(true)
                            }
                            continue
                        }
                    }
                }
            }
        }
    }
}