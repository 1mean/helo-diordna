package com.example.pandas.ui.fragment

import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.biz.ext.getUrl
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.FragmentRecommendBinding
import com.example.pandas.ui.activity.VideoPlayingActivity
import com.example.pandas.ui.adapter.RecommendAdapter
import com.example.pandas.ui.ext.initReco
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
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
public class RecommendFragment : BaseLazyFragment<HomePageViewModel, FragmentRecommendBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener, OnItemmmmClickListener<Int> {

    private val mAdapter: RecommendAdapter by lazy {
        RecommendAdapter(
            lifecycle,
            RecommendData(),
            this
        )
    }

    private var mPlayer: ExoPlayer? = null
    private var mPosition = -1 //当前正在播放的视频的实际position

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                startPlay()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        binding.layoutReco.visibility = View.GONE
        binding.rview.initReco(GridLayoutManager(activity, 2), mAdapter, this)
        binding.refreshReco.run {
            setColorSchemeResources(R.color.green)
            setOnRefreshListener {
                binding.rview.isFreshing(true)
                mViewModel.getRecommendData(true)
            }
        }
        binding.rview.addOnScrollListener(recyclerViewScrollListener)
        binding.rview.addOnChildAttachStateChangeListener(childAttachStateChangeListener)
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            mPlayer = ExoPlayer.Builder(mActivity).build()
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

                    val mRecyclerView = recyclerView as LoadMoreRecyclerView
                    val manager = mRecyclerView.layoutManager as LinearLayoutManager
                    val count = manager.childCount
                    //val count = mRecyclerView.childCount
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
                    }
                }
                RecyclerView.SCROLL_STATE_DRAGGING -> {
                }
                RecyclerView.SCROLL_STATE_SETTLING -> {
                }
            }
        }
    }

    private val childAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {

                val position = binding.rview.getChildAdapterPosition(view)
                if (position == mPosition) {//正在运行的视频被滑出屏幕
                    val holder =
                        binding.rview.findViewHolderForLayoutPosition(position) as RecommendAdapter.VideoHolder
                    if (mPlayer?.isPlaying == true) {
                        mPlayer?.stop()
                        holder.stopPlay()
                    }
                }
            }

        }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {

        }
    }

    override fun onLoadMore() {
        mViewModel.getRecommendData(false)
    }

    override fun createObserver() {

        mViewModel.recommendDataWrapper.observe(viewLifecycleOwner) {

            binding.layoutReco.visibility = View.VISIBLE
            if (it.isSuccess) {//成功

                when {
                    //没有数据
                    it.isFirstEmpty -> {
                        binding.refreshReco.isRefreshing = false
                        binding.rview.noMoreData()
                    }
                    //刷新的第一页
                    it.isRefresh -> {
                        binding.rview.isFreshing(false)
                        mAdapter.refreshData(it.recoData)
                        binding.refreshReco.isRefreshing = false
                        if (!it.hasMore) {
                            binding.rview.noMoreData()
                        }
                    }
                    //加载更多
                    else -> {
                        if (it.hasMore) {//还有更多数据
                            binding.rview.loadMoreFinished()
                        } else {//已经是最后一页数据了
                            binding.rview.noMoreData()
                        }
                        mAdapter.addData(it.recoData)
                    }
                }
            } else {//失败
                binding.rview.noMoreData()
                binding.refreshReco.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        binding.refreshReco.isRefreshing = true
        binding.rview.isFreshing(true)
        mViewModel.getRecommendData(true)
    }

    override fun onClick(position: Int, t: Int) {

        if (mPlayer != null && mPlayer!!.isPlaying) {
            mPlayer!!.stop()
            mPosition = -1
        }
        val intent = Intent(mActivity, VideoPlayingActivity::class.java).apply {
            putExtra("code", t)
        }
        requestLauncher.launch(intent)
    }

    /**
     * 开始播放
     */
    private fun startPlay() {

        val mRecyclerView = binding.rview
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
        }
    }
}