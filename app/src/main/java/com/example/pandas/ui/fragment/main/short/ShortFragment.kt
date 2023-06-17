package com.example.pandas.ui.fragment.main.short

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.manager.VerticalPlayManager
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.databinding.FragmentVerticalVideoplayBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.VideoPagerAdapter
import com.example.pandas.ui.ext.startUserInfoActivity
import com.example.pandas.ui.view.dialog.ShortRightPopuWindow
import com.google.android.exoplayer2.util.Util
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.interfaces.XPopupCallback


/**
 * @description: 横屏视频,使用Viewpager2来实现
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class ShortFragment :
    BaseFragment<ShortVideoViewModel, FragmentVerticalVideoplayBinding>(), ExoPlayerListener,
    VideoPagerAdapter.VerticalVideoListener {

    private var isRefreshing = false

    var mMinimumVelocity: Int = 0
    var mMaximumVelocity: Int = 0
    var mTouchSlop: Int = 0
    private var hasMore = false
    var mVelocityTracker: VelocityTracker? = null //速度跟踪器
    private val mAdapter: VideoPagerAdapter by lazy { VideoPagerAdapter(listener = this) }

    private var manager: VerticalPlayManager? = null
    var popupView: ShortRightPopuWindow? = null

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    @SuppressLint("Recycle")
    override fun initView(savedInstanceState: Bundle?) {

        //bug:一句代码解决了两天的bug，关闭popuwindow时，edittext仍然有焦点，会反复弹出
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        manager = VerticalPlayManager(mActivity, this)


        mVelocityTracker = VelocityTracker.obtain()
        val viewConfig = ViewConfiguration.get(mActivity)
        mTouchSlop = viewConfig.scaledTouchSlop
        mMinimumVelocity = viewConfig.scaledMinimumFlingVelocity
        mMaximumVelocity = viewConfig.scaledMaximumFlingVelocity

        binding.vp2VideoVertical.run {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }

//        binding.ibnVerticalTopClose.setOnClickListener {
//            mVelocityTracker?.recycle()
//            manager?.release()
//        }

        binding.clayoutVerticalTop.post {
            val location = IntArray(2)
            binding.clayoutVerticalTop.getLocationOnScreen(location)
        }
    }

    override fun createObserver() {

        mViewModel.verticalVideos.observe(this) {

            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        if (isRefreshing) {
                            manager?.refreshPlayer(it.listData)
                            isRefreshing = false
                            binding.clayoutVerticalRefresh.visibility = View.GONE
                        } else {
                            manager?.initPlayer(it.listData)
                        }
                    }
                    it.hasMore -> {
                        mAdapter.loadMore(it.listData)
                        manager?.addMediaItems(it.listData)
                    }
                }
                hasMore = it.hasMore
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            manager?.initPlayer()
        }
    }

    override fun firstOnResume() {
        mViewModel.getVerticalVideos(true)
    }

    /**
     * 第一次进入会触发onPageSelected position=0
     * 只有手动滑动时，才会触发onPageScrollStateChanged回调，执行顺序如下
     *   --翻页时回调
     *      --SCROLL_STATE_DRAGGING
     *      --SCROLL_STATE_SETTLING
     *      --onPageSelected : 1
     *      --SCROLL_STATE_IDLE
     *
     *   --滑动后，仍然在当前页面，不会回调 onPageSelected
     *      --SCROLL_STATE_DRAGGING
     *      --SCROLL_STATE_SETTLING
     *      --SCROLL_STATE_IDLE
     *
     */
    private var currentPosition: Int = 0
    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageScrollStateChanged(state: Int) {
            when (state) {
                ViewPager2.SCROLL_STATE_IDLE -> {
                    mAdapter.startAnimation(currentPosition)
                }
                ViewPager2.SCROLL_STATE_DRAGGING -> {
                    mAdapter.pauseAnimation(currentPosition)
                }
                ViewPager2.SCROLL_STATE_SETTLING -> {
                }
            }
        }

        //界面初始化，第一次注册时也会被调用，所以要注意为null的判断
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            currentPosition = position
            //开启右下角的旋转动画

            popupView = null //切换到新页面时，不保存右侧评论弹出窗
            vh = null
            binding.vp2VideoVertical.post {

                val count = mAdapter.itemCount
                if (position == (count - 1) && hasMore) {
                    mViewModel.getVerticalVideos(false)
                }

                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(position) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.let { vh ->
                        vh.init()
                        manager?.seekTo(position, vh.playerView)
                    }
                }
            }
        }
    }

    override fun isPlayingChanged(isPlaying: Boolean) {
        super.isPlayingChanged(isPlaying)
        if (isPlaying) {
            mAdapter.startAnimation(currentPosition)
        } else {
            mAdapter.pauseAnimation(currentPosition)
        }
    }

    override fun onDoubleTap() {

    }

    override fun onSingleTap() {
        if (manager!!.isPlaying()) {
            manager?.pause()
        } else {
            manager?.continuePlayer()
        }
    }

    override fun updataVideoData(videoData: VideoData) {
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun collect(isAdd: Boolean, videoCode: Int) {
        mViewModel.updateCollect(isAdd, videoCode)
    }

    override fun updateUserAttention(userCode: Int) {
        mViewModel.updateAttention(userCode)
    }

    override fun startUserActivity(user: User) {

        if (manager!!.isPlaying()) {
            manager?.pause()
        } else {
            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(binding.vp2VideoVertical.currentItem) as? VideoPagerAdapter.MyViewHolder
                viewHolder?.init()
            }
        }
        startUserInfoActivity(mActivity, user)
    }

    private var vh: VideoPagerAdapter.MyViewHolder? = null
    override fun showComments(videoCode: Int, commentCounts: Int) {

        if (popupView == null) {
            popupView = ShortRightPopuWindow(mActivity, videoCode, commentCounts)
        }
        XPopup.setShadowBgColor(ContextCompat.getColor(mActivity, R.color.color_white_lucency))
        XPopup.Builder(mActivity).setPopupCallback(object : XPopupCallback {
            override fun onCreated(popupView: BasePopupView?) {
            }

            override fun beforeShow(popupView: BasePopupView?) {
                binding.clayoutVerticalTop.visibility = View.GONE
                if (vh == null) {
                    mAdapter.recyclerView?.let {
                        vh =
                            it.findViewHolderForAdapterPosition(currentPosition) as VideoPagerAdapter.MyViewHolder
                    }
                }
                vh?.hidePlayerView()
            }

            override fun onShow(popupView: BasePopupView?) {
            }

            override fun onDismiss(popupView: BasePopupView?) {
                binding.clayoutVerticalTop.visibility = View.VISIBLE
            }

            override fun beforeDismiss(popupView: BasePopupView?) {

            }

            override fun onBackPressed(popupView: BasePopupView?): Boolean {
                return false
            }

            override fun onKeyBoardStateChanged(popupView: BasePopupView?, height: Int) {
            }

            override fun onDrag(
                popupView: BasePopupView?,
                value: Int,
                percent: Float,
                upOrLeft: Boolean
            ) {
                if (vh == null) {
                    mAdapter.recyclerView?.let {
                        vh =
                            it.findViewHolderForAdapterPosition(currentPosition) as VideoPagerAdapter.MyViewHolder
                    }
                }
                vh?.playerChanged(value, percent, upOrLeft)
            }

            override fun onClickOutside(popupView: BasePopupView?) {
            }

        })
            .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
            .animationDuration(600)
            .asCustom(popupView)
            .show()



        popupView!!.setOnDragListener { v, event ->

            val dialogHeight = popupView!!.height
            Log.e("1mean", "start drah: $dialogHeight")

            true
        }
    }

    override fun addAttention(userCode: Int) {
        mViewModel.updateAttention(userCode)
    }

    private fun sendVideoComment(comment: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        mAdapter.clearAnimation()
    }

    override fun onPause() {
        super.onPause()
        manager?.let {
            if (it.isPlaying()) {
                it.release()
            }
        }
    }

    override fun againOnResume() {
        super.againOnResume()

        manager?.let {

            it.initPlayer()



        }

    }
}