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
import com.example.pandas.utils.StatusBarUtils
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
    private var touchFrag = false
    private var totalOffset = 0

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        if (binding.vp2VideoVertical.currentItem != 0) {
            return super.dispatchTouchEvent(event)
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("onTouchEvent", "ACTION_DOWN")
                startX = event.rawX
                startY = event.rawY
                touchFrag = true
                totalOffset = 0
                mCurrentVelocity = 0
                mVelocityTracker?.addMovement(event)//速度追踪初始化
            }
            MotionEvent.ACTION_MOVE -> {

                mVelocityTracker?.addMovement(event)//速度追踪
                ////一秒内运动了多少个像素
                mVelocityTracker?.computeCurrentVelocity(1000, mMaximumVelocity.toFloat())
                val y_velocity = mVelocityTracker!!.yVelocity
                if (y_velocity > 5000) {
                    binding.clayoutVerticalTop.scrollTo(0, -100)
                } else {
                    Log.e("1mean","y speed: ${mVelocityTracker?.yVelocity}")

                    endX = event.rawX
                    endY = event.rawY
                    val distanceX: Float = endX - startX
                    val distanceY: Float = endY - startY
                    if (distanceY > distanceX && distanceY > 0 && distanceY > 100 && touchFrag) {

//                    binding.clayoutVerticalTop.visibility = View.GONE
//                    binding.clayoutVerticalHeader.visibility = View.VISIBLE

                        val offset = ((distanceY - 100) / 100).toInt()
                        Log.e("1mean", "distanceY: $distanceY, offset: $offset")
                        totalOffset += offset
                        if (totalOffset <= 100) {
                            //binding.clayoutVerticalTop.scrollBy(0, -b)
                            binding.clayoutVerticalTop.offsetTopAndBottom(offset)
                            // binding.clayoutVerticalTop.scrollTo(0, -b)
                        } else {

                        }



                        if (distanceY == 400f) {//开始刷新

                        }

                        //touchFrag = false
                    }
                }
            }
            MotionEvent.ACTION_UP -> {
                mVelocityTracker?.addMovement(event)//速度追踪
                touchFrag = false

                if (totalOffset != 0) {
                    binding.clayoutVerticalTop.offsetTopAndBottom(-totalOffset)
                }

                totalOffset = 0
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