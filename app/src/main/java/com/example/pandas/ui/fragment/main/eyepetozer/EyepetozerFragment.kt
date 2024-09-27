package com.example.pandas.ui.fragment.main.eyepetozer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.PetVideo
import com.android.base.ui.fragment.BaseFragment
import com.android.base.utils.ScreenUtil
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.manager.ExoMediaManager
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.EyepetozerAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.helo.video.VideoPlayingActivity

/**
 * @description: 开眼
 * @author: dongyiming
 * @date: 2021/12/21 2:16 下午
 * @version: v1.0
 */
public class EyepetozerFragment : BaseFragment<EyepetozerViewModel, LayoutSwipRefreshBinding>(),
    ExoMediaManager.ExoListener, EyepetozerAdapter.EyeAdapterListener {

    private var existDataInView = false//界面是否存在数据，下次出错不会影响界面显示

    //BUG:快速下滑，加载更多。delayTime如果太久，会导致loadmore加载到第二页数据后，才进行startPlay
    //此时会是播放最顶部的视频，该视频是第一页的最后两个视频，该视频item会变成FooterView，无法播放
    private val delayTime = 50L

    override fun lazyLoadTime(): Long = 0

    //这里不能使用by lazy延迟，因为manager会加入生命周期的监听，如果等使用再加载，ExoMediaManager——OnStart会很晚执行，导致崩溃
    private var exoManager: ExoMediaManager? = null
    private var startActivity = false
    private var isBack = false
    private var playingPosition = -1

    private val mAdapter: EyepetozerAdapter by lazy { EyepetozerAdapter(mutableListOf(), this) }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingBottom: Int = resources.getDimension(R.dimen.common_lh_10_dimens).toInt()
        binding.recyclerLayout.run {
            init(
                CommonItemDecoration(paddingBottom = paddingBottom),
                mAdapter,
                LinearLayoutManager(mActivity),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getHots(false)
                    }
                })
            addOnChildAttachStateChangeListener(childAttachStateChangeListener)
            addOnScrollListener(recyclerViewScrollListener)
            //addOnChildAttachStateChangeListener(childAttachStateChangeListener)
        }

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getHots(true)
            }
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
        exoManager = ExoMediaManager(mActivity, this, this)
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getHots(true)
    }

    override fun refresh() {
        super.refresh()
        binding.swipLayout.isRefreshing = true
        mViewModel.getHots(true)
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

    override fun againOnResume() {
        if (isBack) {
            mHandler.postDelayed({ startPlay() }, delayTime)
        }
    }

    override fun onPause() {
        super.onPause()

        //取消所有延时任务，防止在滑动后 点击进入其他界面时，还触发startPlay()方法，导致了_mPlayer为null，导致播放崩溃
        mHandler.removeCallbacksAndMessages(null)
        exoManager?.let {
            if (it.isPlaying()) {
                val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(playingPosition)
                if (holder is EyepetozerAdapter.EyeViewHolder) {
                    (holder as EyepetozerAdapter.EyeViewHolder).updateItemView(true)
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

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }

        mViewModel.eyeHotList.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> {
                        binding.recyclerLayout.visibility = View.GONE
                        binding.layoutError.llayoutError.visibility = View.GONE
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }

                    it.isRefresh -> {
                        exoManager?.refreshPlayer()
                        playingPosition = -1
                        mAdapter.refresh(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.isRefreshing(false)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)

                        mHandler.postDelayed({ startPlay() }, 500)
                    }

                    else -> {
                        mAdapter.loadMore(it.listData)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                }
            } else {
                when {
                    it.isRefresh -> {
                        if (existDataInView) {
                            Toast.makeText(
                                mActivity,
                                "刷新出现了错误，请稍后再试",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            binding.recyclerLayout.visibility = View.GONE
                            binding.layoutError.llayoutError.visibility = View.GONE
                            binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                        }
                    }

                    else -> {
                        Toast.makeText(mActivity, "加载出现了错误，请稍后再试", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
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
                    if (holder is EyepetozerAdapter.EyeViewHolder) {
                        (holder as EyepetozerAdapter.EyeViewHolder).updateItemView(true)
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
            val eyepetozerItem = mAdapter.getItemData(index)
            val itemView = mRecyclerView.getChildAt(index - firstPos) ?: return
            //13是CommonFooter
            //15 21 27 playerView 相同   5  29  17
            if (itemView is CardView) {
                val playerView = findView(itemView as CardView, R.id.player_eye) ?: return
                val height = ScreenUtil.getLocationHeight(playerView)
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
                                            index
                                        )
                                    if (holder is EyepetozerAdapter.EyeViewHolder) {
                                        (holder as EyepetozerAdapter.EyeViewHolder).updateItemView(
                                            true
                                        )
                                    }
                                    eyepetozerItem.url?.let { url ->
                                        val playInfo =
                                            MediaInfo(eyepetozerItem.code, url, 0)
                                        it.play(playerView, playInfo)
                                        playingPosition = index
                                    }
                                } else {
                                    eyepetozerItem.url?.let { url ->
                                        val playInfo =
                                            MediaInfo(eyepetozerItem.code, url, 0)
                                        it.play(playerView, playInfo)
                                        playingPosition = index
                                    }
                                }
                            }
                            return
                        }
                    } else {
                        if (index == playingPosition) {
                            exoManager?.pausePlayer()
                            val holder =
                                binding.recyclerLayout.findViewHolderForLayoutPosition(index)
                            if (holder is EyepetozerAdapter.EyeViewHolder) {
                                (holder as EyepetozerAdapter.EyeViewHolder).updateItemView(true)
                            }
                            continue
                        }
                    }
                }
            }
        }
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
     * @version: v1.0     下拉刷新会触发
     */
    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

            /**
             * BUG_2
             * 理论上：下拉刷新数据后，会请求新的数据，在数据请求结束后再开始执行视频播放
             * BUG:下拉刷新会立马触发滑动监听，IDLE里会执行startPlay，此操作在获取新数据之前，导致播放的是旧数据，而且界面展示出问题
             * 两种修改方式：
             *      1，添加一个更长时间的延时，确保播放动作是在获取到新数据之后
             *      2，加入判断，在下拉刷新时，不触发播放，在刷新数据获取后再播放
             */
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                //下拉刷新也会触发
                if (!binding.swipLayout.isRefreshing) {
                    mHandler.postDelayed({ startPlay() }, delayTime)
                }
            }
        }
    }

    override fun OnPlayerViewShow(isShow: Boolean) {
        val holder =
            binding.recyclerLayout.findViewHolderForLayoutPosition(playingPosition)
        if (holder is EyepetozerAdapter.EyeViewHolder) {
            (holder as EyepetozerAdapter.EyeViewHolder).updateItemView(!isShow)
        }
    }

    override fun startVideoPLayActivity(eyepetozerItem: PetVideo) {
        startActivity = true
        val intent = Intent(mActivity, VideoPlayingActivity::class.java)
        intent.putExtra("PetVideo", eyepetozerItem)
        mActivity.startActivity(intent)
    }

    override fun startVideoCommentActivity(eyepetozerItem: PetVideo) {

    }

    override fun addLater(videoCode: Int) {
    }

    private fun findView(parentView: ViewGroup, id: Int): View? {

        if (parentView.id == id) {
            return parentView
        }

        for (i in 0 until parentView.childCount) {
            val childView = parentView.getChildAt(i)
            if (childView is ViewGroup) {
                val result = travel(childView, id)
                if (result != null) {
                    return result
                }
            } else {
                if (childView.id == id) {
                    return childView
                }
            }
        }
        return null
    }

    private fun travel(viewGroup: ViewGroup, id: Int): View? {
        if (viewGroup.id == id) {
            return viewGroup
        }
        for (i in 0 until viewGroup.childCount) {
            val view = viewGroup.getChildAt(i)
            if (view.id == id) {
                return view
            }
            if (view is ViewGroup) {
                val result = travel(view, id)
                if (result != null) {
                    return result
                }
            }
        }
        return null
    }
}