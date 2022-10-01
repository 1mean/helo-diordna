package com.example.pandas.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewConfiguration
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.manager.VerticalPlayManager
import com.example.pandas.biz.viewmodel.VerticalVideoViewModel
import com.example.pandas.databinding.ActivityVerticalVideoplayBinding
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.VideoPagerAdapter
import com.example.pandas.ui.ext.addRefreshAnimation
import com.example.pandas.utils.StatusBarUtils
import com.example.pandas.utils.VibrateUtils
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.Util


/**
 * @description: 横屏视频,使用Viewpager2来实现
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class VerticalVideoActivity2 :
    BaseActivity<VerticalVideoViewModel, ActivityVerticalVideoplayBinding>(), ExoPlayerListener,
    VideoPagerAdapter.VerticalVideoListener {

    var mCurrentVelocity: Int = 0
    var mMinimumVelocity: Int = 0
    var mMaximumVelocity: Int = 0
    var mTouchSlop: Int = 0
    var mVelocityTracker: VelocityTracker? = null //速度跟踪器
    private val mAdapter: VideoPagerAdapter by lazy { VideoPagerAdapter(listener = this) }
    private val manager: VerticalPlayManager by lazy { VerticalPlayManager(this, this) }

    @SuppressLint("Recycle")
    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)


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
            manager.release()
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

            if (it.isSuccess) {
                mAdapter.refreshAdapter(it.listData)
            }

            if (it.isRefresh) {
                binding.vp2VideoVertical.post {
                    val list = it.listData
                    if (list.isNotEmpty()) {
                        val recyclerView = binding.vp2VideoVertical.getChildAt(0) as RecyclerView
                        recyclerView.getChildAt(0)?.let { view ->
                            val playerView =
                                view.findViewById<StyledPlayerView>(R.id.player_vertical)
                            playerView?.let {
                                manager.play(it, list)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            manager.initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getVerticalVideos(true)
    }

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var endX: Float = 0f
    private var endY: Float = 0f
    private var totalOffset = 0
    private var isMoving = false //只是下拉刷新操作
    private var quickFlag = false //是否是快速滑动
    private var isRefreshing = false


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

                if (distanceY > distanceX && distanceY > 0) {//下拉操作
                    if (y_velocity > 10000) {
                        Log.e("dispatchTouchEvent", "y_velocity: $y_velocity")
                        if (!quickFlag) {
                            totalOffset = 100
                            binding.clayoutVerticalTop.offsetTopAndBottom(totalOffset)
                            quickFlag = true
                            VibrateUtils.vibrate(this,50)
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
                                    binding.ibnVerticalTopClose.alpha = topAlpha
                                    binding.ibnVerticalTopMore.alpha = topAlpha
                                } else {
                                    val topAlpha = (totalOffset - 40).toFloat() / 60
                                    binding.txtVerticalTopTitle.alpha = topAlpha
                                }
                                totalOffset += offset
                                if (totalOffset >= 100) {
                                    VibrateUtils.vibrate(this,50)
                                }
                                binding.clayoutVerticalTop.offsetTopAndBottom(offset)
                            }
                            if (distanceY == 400f) {//开始刷新
                            }
                        }
                    }
                    isMoving = true
                }
            }
            MotionEvent.ACTION_UP -> {
                if (isMoving) {
                    mVelocityTracker?.addMovement(event)//速度追踪

                    //binding.txtVerticalTopTitle.alpha = 0f
                    //binding.clayoutVerticalTop.offsetTopAndBottom(-totalOffset)

                    addRefreshAnimation(binding.clayoutVerticalTop,totalOffset.toFloat())



                    totalOffset = 0
                    quickFlag = false
                }
            }

            MotionEvent.ACTION_CANCEL -> {
                mVelocityTracker?.clear()//清除状态，回到初始
            }
        }
        return super.dispatchTouchEvent(event)
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
            binding.vp2VideoVertical.post {
                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(position) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.let { vh ->
                        vh.init()
                        Log.e("asdasdadasd", "position: $position, playerView: ${vh.playerView}")
                        manager.seekTo(position, vh.playerView)
                    }
                }
            }
        }
    }

    override fun onDoubleTap() {

    }

    override fun onSingleTap() {
        if (manager.isPlaying()) {
            manager.pause()
        } else {
            manager.continuePlayer()
        }
    }

    override fun updataVideoData(videoData: VideoData) {

        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun collect(isAdd: Boolean, videoCode: Int) {
        mViewModel.updateCollect(isAdd, videoCode)
    }

    override fun onkeyBack() {
        mVelocityTracker?.recycle()
        manager.release()
        super.onkeyBack()
    }
}