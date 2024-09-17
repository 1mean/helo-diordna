package com.example.pandas.ui.fragment.main.live

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.base.ui.fragment.BaseFragment
import com.android.base.utils.ScreenUtil
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.manager.ExoMediaManager
import com.example.pandas.biz.manager.LivePlayManager
import com.example.pandas.biz.viewmodel.LiveViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.activity.VideoPlayingActivity
import com.example.pandas.ui.adapter.LiveVideoAdapter
import com.example.pandas.ui.adapter.RecommendAdapter
import com.example.pandas.ui.ext.*
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.google.android.exoplayer2.Player.REPEAT_MODE_ONE
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * @description: 动态-综合
 * @author: dongyiming
 * @date: 10/10/22 5:05 下午
 * @version: v1.0
 */
public class LiveVideoFragment : BaseFragment<LiveViewModel, LayoutSwipRefreshBinding>(),
    LiveVideoAdapter.LiveVideoListener, ExoMediaManager.ExoListener {

    private val delayTime = 500L

    private var mAdapter: LiveVideoAdapter? = null
    private var playingPosition = -1
    //private var playerManager: LivePlayManager? = null

    override fun lazyLoadTime(): Long = 0

    //这里不能使用by lazy延迟，因为manager会加入生命周期的监听，如果等使用再加载，ExoMediaManager——OnStart会很晚执行，导致崩溃
    private var exoManager: ExoMediaManager? = null
    private var startActivity = false
    private var isBack = true

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            isBack = true
        }

    override fun initView(savedInstanceState: Bundle?) {

        val status = appViewModel.appColorType.value
        if (status == null || status == 0) {
            binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
        } else {
            binding.swipLayout.setColorSchemeResources(viewColors[status])
        }
        mAdapter = LiveVideoAdapter(status, listener = this)
        binding.recyclerLayout.run {

            init(
                null,
                mAdapter!!,
                LinearLayoutManager(context),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getLiveVideo(false)
                    }
                })

            //下拉刷新时，允许播放，下拉刷新页面时也会触发该方法
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    when (newState) {
                        RecyclerView.SCROLL_STATE_IDLE -> {
                            mHandler.postDelayed({ startPlay() }, delayTime)
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
            setBackgroundResource(R.color.color_white_lucency)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getLiveVideo(true)
                binding.recyclerLayout.isRefreshing(true)
            }
        }

        exoManager = ExoMediaManager(mActivity, this, this)

//        playerManager = LivePlayManager(mActivity) { isPlaying ->
//            if (isPlaying) {
//                playerManager?.let {
//                    val holder =
//                        binding.recyclerLayout.findViewHolderForLayoutPosition(it.getCurPosition())
//                    if (holder is LiveVideoAdapter.LiveViewHolder) {
//                        (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(false)
//                    }
//                }
//            }
//        }
    }

    private var isNews = false
    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
            mAdapter?.updateStatus(it)
        }

        mViewModel.liveVideos.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        if (exoManager!!.isPlaying()) {
                            exoManager?.pausePlayer()
                        }
                        mAdapter?.refresh(it.liveVides)
                        binding.recyclerLayout.isRefreshing(false)

                        if (!isNews) {
                            toastTopShow(mActivity, "发现了23条新内容")
                            isNews = true
                        }
                        //直接切换到该界面，不会自动播放视频，只有当人为滑动后，才开始进行播放
                        //binding.recyclerLayout.postDelayed({ startPlay() }, delayTime)
                    }

                    else -> {
                        mAdapter?.loadMore(it.liveVides)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun onPause() {
        super.onPause()
        //取消所有延时任务，防止在滑动后 点击进入其他界面时，还触发startPlay()方法，导致了_mPlayer为null，导致播放崩溃
        mHandler.removeCallbacksAndMessages(null)
        exoManager?.let {
            if (it.isPlaying()) {
                val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(playingPosition)
                if (holder is LiveVideoAdapter.LiveViewHolder) {
                    (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(true)
                }
            }
        }

        if (startActivity) {
            exoManager!!.releasePlayer()
            playingPosition = -1
        } else {
            exoManager!!.pausePlayer()
        }
        startActivity = false
        isBack = false
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getLiveVideo(true)
    }

    override fun refresh() {
        super.refresh()
        binding.swipLayout.isRefreshing = true
        mViewModel.getLiveVideo(true)
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

    //1,从左右切换过来的，不会自动播放，手动滑动后才播放
    //2,从其他界面退回到该界面的，会自动播放，而且延续之前的播放进度
    override fun againOnResume() {
//        playerManager?.initPlayer(mActivity)
        if (isBack) {
            mHandler.postDelayed({ startPlay() }, delayTime)
        }
    }

    override fun updateVideoData(videoData: VideoData) {
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun startVideoPLayActivity(video: PetVideo) {
        val intent = Intent(mActivity, VideoPlayingActivity::class.java)
        intent.putExtra("petVideo", video)
        requestLauncher.launch(intent)
        startActivity = true
    }

    override fun startVideoCommentActivity(video: PetVideo) {
        val intent = Intent(mActivity, VideoPlayingActivity::class.java)
        intent.putExtra("petVideo", video)
        intent.putExtra("index", 1)
        requestLauncher.launch(intent)
        startActivity = true
    }

    override fun addLater(videoCode: Int) {
        mViewModel.addLaterPlayer(videoCode)
    }

    private val childAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                val position = binding.recyclerLayout.getChildAdapterPosition(view)
                if (position == playingPosition) {
                    exoManager?.pausePlayer()
                    val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
                    if (holder is RecommendAdapter.VideoHolder) {
                        (holder as RecommendAdapter.VideoHolder).updateItemView(true)
                    }
                }
            }
        }

    private fun startPlay() {//是否是恢复

        val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager
        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()

        if (firstPos < 0 || lastPos < 0) return
        for (index in firstPos..lastPos) {

            if (mAdapter?.getItemViewType(index) == 3) {
                val petVideo = mAdapter!!.getItemData(index)
                val itemView = mRecyclerView.getChildAt(index - firstPos) ?: return
                //15 21 27 playerView 相同   5  29  17
                val playerView =
                    ((itemView as ConstraintLayout).getChildAt(6) as CardView).getChildAt(0)
                        ?: return
                //val playerView = itemView.findViewById<StyledPlayerView>(R.id.player_live)
                val height = ScreenUtil.getLocationHeight(playerView)
                //val isOverHalfViewVisiable = ScreenUtil.isOverHalfViewVisiable(playerView)
                if (playerView is StyledPlayerView) {
                    if (height > -18.5) {
                        if (index == playingPosition) {
                            exoManager?.resumePlay()
                            return
                        } else {
                            exoManager?.let {
                                if (it.isPlaying()) {
                                    it.pausePlayer()
                                    val holder =
                                        binding.recyclerLayout.findViewHolderForLayoutPosition(
                                            playingPosition
                                        )
                                    if (holder is LiveVideoAdapter.LiveViewHolder) {
                                        (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(
                                            true
                                        )
                                    }
                                    val file = getLocalFilePath(mActivity, petVideo.fileName!!)
                                    val playInfo =
                                        MediaInfo(petVideo.code, file.absolutePath, 0)
                                    it.play(playerView, playInfo)
                                } else {
                                    val file = getLocalFilePath(mActivity, petVideo.fileName!!)
                                    val playInfo =
                                        MediaInfo(petVideo.code, file.absolutePath, 0)
                                    it.play(playerView, playInfo)
                                }
                                playingPosition = index
                            }
                            return
                        }
                    } else {
                        if (index == playingPosition) {
                            exoManager?.pausePlayer()
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

    override fun OnPlayerViewShow(isShow: Boolean) {
        val holder =
            binding.recyclerLayout.findViewHolderForLayoutPosition(playingPosition)
        if (holder is LiveVideoAdapter.LiveViewHolder) {
            (holder as LiveVideoAdapter.LiveViewHolder).updateItemView(!isShow)
        }
    }
}