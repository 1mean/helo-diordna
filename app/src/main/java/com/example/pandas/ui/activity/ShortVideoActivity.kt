package com.example.pandas.ui.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.view.animation.LinearInterpolator
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.manager.KeyboardManager
import com.example.pandas.biz.manager.VerticalPlayManager
import com.example.pandas.biz.viewmodel.VerticalVideoViewModel
import com.example.pandas.databinding.ActivityVerticalVideoplayBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.VideoPagerAdapter
import com.example.pandas.ui.ext.addRefreshAnimation
import com.example.pandas.ui.ext.startUserInfoActivity
import com.example.pandas.ui.view.dialog.ShortInputPopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.example.pandas.utils.VibrateUtils
import com.google.android.exoplayer2.util.Util


/**
 * @description: 横屏视频,使用Viewpager2来实现
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class ShortVideoActivity :
    BaseActivity<VerticalVideoViewModel, ActivityVerticalVideoplayBinding>(), ExoPlayerListener,
    VideoPagerAdapter.VerticalVideoListener {

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var endX: Float = 0f
    private var endY: Float = 0f
    private var totalOffset = 0
    private var isMoving = false //只是下拉刷新操作
    private var quickFlag = false //是否是快速滑动
    private var isRefreshing = false

    var mCurrentVelocity: Int = 0
    var mMinimumVelocity: Int = 0
    var mMaximumVelocity: Int = 0
    var mTouchSlop: Int = 0
    private var hasMore = false
    var mVelocityTracker: VelocityTracker? = null //速度跟踪器
    private val mAdapter: VideoPagerAdapter by lazy { VideoPagerAdapter(listener = this) }

    private var manager: VerticalPlayManager? = null
    private var keyBoardManager: KeyboardManager? = null
    private var inputPopWindow: ShortInputPopuWindow? = null

    private val mHandler:Handler = Handler(Looper.getMainLooper())

    @SuppressLint("Recycle")
    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)

        //bug:一句代码解决了两天的bug，关闭popuwindow时，edittext仍然有焦点，会反复弹出
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        manager = VerticalPlayManager(this, this)

        keyBoardManager = KeyboardManager(this)
        keyBoardManager!!.setOnSoftKeyBoardChangeListener(keyBoardListener)

        mVelocityTracker = VelocityTracker.obtain()
        val viewConfig = ViewConfiguration.get(this)
        mTouchSlop = viewConfig.scaledTouchSlop
        mMinimumVelocity = viewConfig.scaledMinimumFlingVelocity
        mMaximumVelocity = viewConfig.scaledMaximumFlingVelocity

        binding.vp2VideoVertical.run {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }

        binding.ibnVerticalTopClose.setOnClickListener {
            mVelocityTracker?.recycle()
            manager?.release()
            finish()
        }

        binding.clayoutVerticalTop.post {
            val location = IntArray(2)
            binding.clayoutVerticalTop.getLocationOnScreen(location)
            val x = location[0]
            val y = location[1]
            Log.e("1mean", "x坐标：$x, y坐标：$y")
        }
    }

    override fun createObserver() {

        mViewModel.verticalVideos.observe(this) {

            Log.e("1mean", "createObserver")
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

    override fun againOnResume() {
        super.againOnResume()
        manager?.continuePlayer()
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getVerticalVideos(true)
    }

    /**
     * <处理下拉刷新时，top header的变化>
     *     问题一：在view向下拖动的过程中，alpha值从1到0，如果此时设置visibility=GONE，会导致所有控件立即回弹到起始位置
     *     - 所以为了展示从[40,100]区间内的渐变，可以把中间的title起始alpha设置为0，然后拖动到40f时才慢慢显示
     *     - 拖动过程中，不要使用任何 .visibility = View.GONE
     *
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 10/1/22 8:08 下午
     * @version: v1.0
     */
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        if (binding.vp2VideoVertical.currentItem != 0) {
            return super.dispatchTouchEvent(event)
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("onTouchEvent", "ACTION_DOWN")
                startX = event.rawX
                startY = event.rawY
                totalOffset = 0
                isMoving = false
                mCurrentVelocity = 0
                mVelocityTracker?.addMovement(event)//速度追踪初始化
            }
            MotionEvent.ACTION_MOVE -> {

                mVelocityTracker?.addMovement(event)//速度追踪
                ////一秒内运动了多少个像素
                mVelocityTracker?.computeCurrentVelocity(1000, mMaximumVelocity.toFloat())
                val y_velocity = mVelocityTracker!!.yVelocity

                endX = event.rawX
                endY = event.rawY
                val distanceX: Float = endX - startX
                val distanceY: Float = endY - startY

                if (distanceY > distanceX && distanceY > 0 && !isRefreshing) {//下拉操作
                    if (y_velocity > 10000) {//快速滑动，普遍都是13000
                        Log.e("dispatchTouchEvent", "y_velocity: $y_velocity")
                        if (!quickFlag) {
                            totalOffset = 100
                            binding.clayoutVerticalTop.offsetTopAndBottom(totalOffset)
                            quickFlag = true
                            VibrateUtils.vibrate(this, 50)
                            binding.ibnVerticalTopClose.alpha = 0f
                            binding.ibnVerticalTopMore.alpha = 0f
                        }
                    } else {
                        Log.e("dispatchTouchEvent", "y speed: ${mVelocityTracker?.yVelocity}")
                        if (distanceY > 100) {
                            val offset = ((distanceY - 100) / 100).toInt()
                            Log.e("dispatchTouchEvent", "distanceY: $distanceY, offset: $offset")
                            if (totalOffset <= 100) {
                                if (totalOffset <= 40) {
                                    val topAlpha = (40 - totalOffset).toFloat() / 40
                                    Log.e("1mean", "topAlpha: $topAlpha")
                                    binding.ibnVerticalTopClose.alpha = topAlpha //可能不为0f
                                    binding.ibnVerticalTopMore.alpha = topAlpha
                                } else {
                                    binding.ibnVerticalTopClose.alpha = 0f
                                    binding.ibnVerticalTopMore.alpha = 0f
                                    val topAlpha = (totalOffset - 40).toFloat() / 60
                                    binding.txtVerticalTopTitle.alpha = topAlpha
                                }
                                totalOffset += offset
                                if (totalOffset >= 100) {
                                    VibrateUtils.vibrate(this, 50)
                                }
                                binding.clayoutVerticalTop.offsetTopAndBottom(offset)
                            }
                        }
                    }
                    isMoving = true
                }
            }
            MotionEvent.ACTION_UP -> {
                if (isMoving && !isRefreshing) {
                    mVelocityTracker?.addMovement(event)//速度追踪

                    binding.txtVerticalTopTitle.alpha = 0f
                    val transAlpha =
                        ObjectAnimator.ofFloat(binding.txtVerticalTopTitle, "alpha", 1f, 0f)
                    transAlpha.run {
                        duration = 350
                        interpolator = LinearInterpolator()
                        start()
                    }
                    addRefreshAnimation(binding.clayoutVerticalTop, totalOffset.toFloat(), object :
                        Animator.AnimatorListener {
                        override fun onAnimationStart(animation: Animator?) {
                        }

                        override fun onAnimationEnd(animation: Animator?) {
                            binding.ibnVerticalTopClose.alpha = 1f
                            binding.ibnVerticalTopMore.alpha = 1f
                            if (totalOffset >= 100) {
                                isRefreshing = true
                                binding.clayoutVerticalRefresh.visibility = View.VISIBLE
                                mViewModel.getVerticalVideos(true)
                            }
                        }

                        override fun onAnimationCancel(animation: Animator?) {
                        }

                        override fun onAnimationRepeat(animation: Animator?) {
                        }

                    })
                    quickFlag = false
                }
            }

            MotionEvent.ACTION_CANCEL -> {
                mVelocityTracker?.clear()//清除状态，回到初始
            }
        }
        return super.dispatchTouchEvent(event)
    }

    //点击底部评论发送按钮
    override fun showCommentPopuWindow(view: View) {
        Log.e("keyBoardManager","keyBoardManager: $keyBoardManager")
       //keyBoardManager?.showKeyBoard(this, view)
    }

    private val keyBoardListener = object : KeyboardManager.OnSoftKeyBoardChangeListener {
        override fun keyBoardShow(height: Int) {

            inputPopWindow = ShortInputPopuWindow(this@ShortVideoActivity)
            inputPopWindow!!.setBackDark().onShow(this@ShortVideoActivity.currentFocus!!)

//            mHandler.postDelayed({
//                inputPopWindow = ShortInputPopuWindow(this@ShortVideoActivity)
//                inputPopWindow!!.setBackDark().onShow(this@ShortVideoActivity.window.decorView)
//            },500)
        }

        override fun keyBoardHide(height: Int) {
            Log.e("keyBoardManager","keyBoardHide")
        }
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        //界面初始化，第一次注册时也会被调用，所以要注意为null的判断
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Log.e("1mean", "onPageSelected")


            binding.vp2VideoVertical.post {

                val count = mAdapter.itemCount
                if (position == (count - 1) && hasMore) {
                    Log.e("1mean", "position:$position, count:$count 准备加载更多")
                    mViewModel.getVerticalVideos(false)
                }

                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(position) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.let { vh ->
                        vh.init()
                        Log.e("asdasdadasd", "position: $position, playerView: ${vh.playerView}")
                        manager?.seekTo(position, vh.playerView)
                    }
                }
            }
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
        startUserInfoActivity(this, user)
    }

    override fun onkeyBack() {
        mVelocityTracker?.recycle()
        manager?.release()
        manager = null
        super.onkeyBack()
    }
}