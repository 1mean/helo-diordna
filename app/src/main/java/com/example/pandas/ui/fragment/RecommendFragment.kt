package com.example.pandas.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.base.fragment.BaseCMFragment
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.biz.ext.getUrl
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.manager.ExoCommonManager
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.activity.VideoPlayingActivity
import com.example.pandas.ui.adapter.RecommendAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.ScreenUtil
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
    OnItemmmmClickListener<Int>,
    ExoCommonManager.OnExoListListener {

    private val mAdapter: RecommendAdapter by lazy {
        RecommendAdapter(
            lifecycle,
            RecommendData(),
            this
        )
    }

    private var mPosition = -1 //当前正在播放的视频的实际position

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                startPlay()
            }
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
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getRecommendData(true)
            }
        }

        binding.recyclerLayout.addOnScrollListener(recyclerViewScrollListener)
        binding.recyclerLayout.addOnChildAttachStateChangeListener(childAttachStateChangeListener)
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            ExoCommonManager.instance.initPlayer(mActivity).addExoListener(this)
        }
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

                            //1,一直在当前播放item的可视范围内滑动，那么不进行任何操作
                            val itemData = mAdapter.getItemData(position)

                            Log.e(
                                "RecommendFragment",
                                "${ExoCommonManager.instance.isCurrentPlayingVideo(itemData.code)}"
                            )
                            if (ExoCommonManager.instance.isCurrentPlayingVideo(itemData.code)) return

                            //2，上一个视频已经结束播放
                            val itemView = mRecyclerView.getChildAt(position - firstPos) ?: return

                            if (ExoCommonManager.instance.isCurrentStopVideo(itemData.code)) {
                                ExoCommonManager.instance.prePare()
                                return
                            }

                            if (ScreenUtil.isOverHalfViewVisiable(itemView)) {

                                val holder =
                                    mRecyclerView.findViewHolderForLayoutPosition(position) as RecommendAdapter.VideoHolder

                                val file = getUrl(mActivity, itemData.fileName!!)

                                val currentPos: Long = if (itemData.videoData == null) {
                                    0L
                                } else {
                                    itemData.videoData!!.playPosition.toLong()
                                }
                                val playInfo =
                                    ExoCommonManager.PlayingInfo(
                                        itemData.code,
                                        "",
                                        file,
                                        currentPos
                                    )

                                Log.e("1mean","playInfo: $playInfo")
                                ExoCommonManager.instance.addPlayerView(holder.playView, 1)
                                    .playLocalFile(playInfo,position)

                                break
                            }
                        }
                    }
                }
            }
        }
    }

    private val childAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                val position = binding.recyclerLayout.getChildAdapterPosition(view)
                val type = mAdapter.getItemViewType(position)
                if (type == 3) {
                    val videoData = mAdapter.getItemData(position)
                    if (ExoCommonManager.instance.isCurrentPlayingVideo(videoData.code)) {//正在运行的视频被滑出屏幕
                        val video = mAdapter.getItemData(position)
                        mViewModel.addOrUpdateVideoData(video.code,ExoCommonManager.instance.getCurrentPos())
                        updateCurPlayerView(position, false)
                        ExoCommonManager.instance.stopPlayer(videoData.code)
                    }
                }
            }
        }

    override fun onPause() {
        super.onPause()
        Log.e("1asdasdmean","onPause")
    }

    override fun closeLastPlayedView(lastPos: Int) {
    }

    override fun updateCurPlayerView(curPos: Int, isHide: Boolean) {

        val holder =
            binding.recyclerLayout.findViewHolderForLayoutPosition(curPos)
        if (holder is RecommendAdapter.VideoHolder) {
            holder.updateItemView(curPos, isHide)
        }
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

    override fun againOnResume() {
        Log.e("1asdasdmean","againOnResume")
    }

    override fun onClick(position: Int, t: Int) {

//        if (mPlayer != null && mPlayer!!.isPlaying) {
//            mPlayer!!.stop()
//            mPosition = -1
//        }
        val intent = Intent(mActivity, VideoPlayingActivity::class.java).apply {
            putExtra("code", t)
        }
        requestLauncher.launch(intent)
    }

    /**
     * 开始播放
     */
    private fun startPlay() {

        /*val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager

        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()
        //下一次滑动时，通过position来关闭当前已经在运行的view
        var currentItem = 0
        for (position in firstPos..lastPos) {

            val type = mRecyclerView.adapter?.getItemViewType(position)
            if (type == 3) {//横屏视频

                if (mPlayer!!.isPlaying && position == mPosition) {//在当前可视界面
                    return
                }

                val holder =
                    mRecyclerView.findViewHolderForLayoutPosition(position) as RecommendAdapter.VideoHolder
                val itemView = mRecyclerView.getChildAt(currentItem) ?: continue
//                            val holder = itemView.tag as RecommendAdapter.VideoHolder
                val rect = Rect()
                itemView.getLocalVisibleRect(rect)
                val visibleHeight = rect.height()//可见的高度
                val totalHeight = itemView.layoutParams.height//总高度
                if (visibleHeight >= (totalHeight / 2)) {

                    holder.startPlay()

                    holder.playView.player = null//黑屏的处理。看api注释
                    holder.playView.player = mPlayer

                    if (position == mPosition) {//回到上次播放的地方，播放列表里还是那个item
                        mPlayer?.prepare()
                    } else {
                        val file = getUrl(mActivity, holder.getFileName(position)!!)
                        val firstLocalMediaItem = MediaItem.fromUri(Uri.fromFile(file))

                        mPlayer?.run {
                            clearMediaItems()
                            repeatMode = Player.REPEAT_MODE_ALL
                            addMediaItem(firstLocalMediaItem)
                            playWhenReady = true//3.设置播放方式为自动播放
                            prepare()//设置播放器状态为prepare
                        }
                        mPosition = position
                    }
                    break
                }
            }
            currentItem += 1
        }*/
    }
}