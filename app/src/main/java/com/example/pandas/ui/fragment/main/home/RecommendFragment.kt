package com.example.pandas.ui.fragment.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.PetVideo
import com.android.base.utils.ScreenUtil
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.manager.ExoMediaManager
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.RecommendAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.adapter.decoration.RecommendDecoration2
import com.example.pandas.ui.ext.*
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
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
public class RecommendFragment : BaseFragment<HomePageViewModel, LayoutSwipRefreshBinding>(),
    RecommendAdapter.RecoViewListener, ExoMediaManager.ExoListener {

    private var startActivity = false
    private var playingPosition = -1
    private val mAdapter: RecommendAdapter by lazy { RecommendAdapter(lifecycle, listener = this) }

    //这里不能使用by lazy延迟，因为manager会加入生命周期的监听，如果等使用再加载，ExoMediaManager——OnStart会很晚执行，导致崩溃
    private var recoManager: ExoMediaManager? = null

    //onStart -> 返回数据后 -> 然后执行onResume()
    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                val backPosition = result.data?.getLongExtra("videoPosition", -1L)
                backPosition?.let {
                    if (it != -1L) {
                        startPlay()
                    }
                }
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        val type = appViewModel.recommendType.value
        if (type != null && type == 1) {
            val padding: Int = resources.getDimension(R.dimen.common_lh_5_3_dimens).toInt()
            binding.recyclerLayout.init(
                RecommendDecoration2(padding, padding, padding, padding, padding), mAdapter,
                GridLayoutManager(activity, 2),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getRecommendData(false)
                    }
                })
        } else {
            binding.recyclerLayout.init(
                RecommendDecoration(mActivity), mAdapter,
                GridLayoutManager(activity, 2),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getRecommendData(false)
                    }
                })
        }
        recoManager = ExoMediaManager(mActivity, this, this)

        with(binding.recyclerLayout) {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    when (newState) {
                        RecyclerView.SCROLL_STATE_IDLE -> {
                            Log.e("1mesdadan", "idle")
                            startPlay()
                        }

                        RecyclerView.SCROLL_STATE_DRAGGING -> {
                        }
                    }
                }
            })
            addOnChildAttachStateChangeListener(childAttachStateChangeListener)
        }

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_recommend)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getRecommendData(true)
            }
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getRecommendData(true)
    }

    override fun refresh() {
        super.refresh()
        binding.swipLayout.isRefreshing = true
        mViewModel.getRecommendData(true)
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

    override fun againOnResume() {
        startPlay()
    }

    /**
     * 关闭正在播放的视频，并且存储历史记录
     *  - 跳转进VideoPlayingActivity时也会触发，加以限制
     */
    override fun onPause() {
        super.onPause()
        if (recoManager!!.isPlaying()) {
            updatePlayerView(true)
        }
        if (startActivity) {
            recoManager!!.releasePlayer()
            playingPosition = -1
        } else {
            recoManager!!.pausePlayer()
        }
        startActivity = false
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }

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

    override fun onClick(video: PetVideo) {
        startVideoPlayingActivity(mActivity, video)
        startActivity = true
    }

    override fun updatePlayerVoice(isOpen: Boolean) {
        recoManager?.updateVolume(isOpen)
    }

    override fun addLaterPLay(videoCode: Int) {
        mViewModel.addLaterPlayer(videoCode)
        Toast.makeText(mActivity, "添加成功", Toast.LENGTH_SHORT).show()
    }

    /**
     * 划入，准备播放时，item里的PlayerView已绑定播放器，此时不应该使用notifyItemChanged进行item里视图的修改
     *      - 会解除播放器的绑定，导致没有画面只有声音
     * 划出，可使用刷新，视图重新绑定
     */
    private fun updatePlayerView(hidePlayer: Boolean) {
        if (playingPosition >= 0) {
            val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(playingPosition)
            if (holder is RecommendAdapter.VideoHolder) {
                (holder as RecommendAdapter.VideoHolder).updateItemView(hidePlayer)
            }
        }
    }

    /**
     * <Detached触发问题>
     *     当目标item完全从屏幕消失时，才会触发，但是其他对item的操作会导致，该回调不按预期触发,如刷新item时，明明还在屏幕内却触发了detach
     * @param:
     * @return:
     * @date: 8/27/22 10:47 上午
     * @version: v1.0
     */
    private val childAttachStateChangeListener =
        object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                val position = binding.recyclerLayout.getChildAdapterPosition(view)
                if (position == playingPosition) {
                    recoManager?.pausePlayer()
                    val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
                    if (holder is RecommendAdapter.VideoHolder) {
                        (holder as RecommendAdapter.VideoHolder).updateItemView(true)
                    }
                }
            }
        }

    /**
     * 处理滑动，超过一半才播放，因最底部加载更多时type问题
     * 注意：
     *    1- RecyclerView.childCount：当前屏幕可见view的数目，LayoutManager.childCount
     *    2- RecyclerView.getChildAt(i): i为当前view在当前可见的几个view里的位置，而不是adapter容器里的position
     */
    private fun startPlay() {//是否是恢复
        val mRecyclerView = binding.recyclerLayout
        val manager = mRecyclerView.layoutManager as LinearLayoutManager
        val firstPos = manager.findFirstVisibleItemPosition()
        val lastPos = manager.findLastVisibleItemPosition()
        //当前播放的item在屏幕内，我们继续播放或暂停
        Log.e("1mesdadan", "1111111")
        if (playingPosition != -1 && playingPosition in firstPos..lastPos) {
            val itemView = mRecyclerView.getChildAt(playingPosition - firstPos) ?: return
            if (itemView !is CardView) return
            val childView = (itemView as CardView).getChildAt(0) ?: return
            if (childView is StyledPlayerView) {
                val isOverHalf = ScreenUtil.isOverHalfViewVisiable(childView)
                if (isOverHalf) {
                    if (!recoManager!!.isPlaying()) {
                        recoManager!!.resumePlay()
                    }
                } else {
                    if (recoManager!!.isPlaying()) {
                        recoManager!!.pausePlayer()
                        updatePlayerView(true)
                    }
                }
            }
        } else {
            for (position in firstPos..lastPos) {
                if (mAdapter.getItemViewType(position) == 3) {//横屏视频
                    val petVideo = mAdapter.getItemData(position)
                    val itemView = mRecyclerView.getChildAt(position - firstPos) ?: return
                    if (itemView !is CardView) return
                    val childView = (itemView as CardView).getChildAt(0) ?: return
                    if (childView is StyledPlayerView) {
                        val isOverHalf = ScreenUtil.isOverHalfViewVisiable(childView)
                        if (isOverHalf) {
                            val file = getLocalFilePath(mActivity, petVideo.fileName!!)
                            Log.e("1mesdadan", "2222222")
                            val playInfo =
                                MediaInfo(petVideo.code, file.absolutePath, 0)
                            recoManager?.play(childView, playInfo)
                            playingPosition = position
                        }
                    }
                    return
                }
            }
        }
    }

    override fun OnIsPlayingChanged(isPlaying: Boolean) {
        val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(playingPosition)
        if (holder is RecommendAdapter.VideoHolder) {
            (holder as RecommendAdapter.VideoHolder).updateItemView(!isPlaying)
        }
    }

    override fun playingEnd() {
    }
}