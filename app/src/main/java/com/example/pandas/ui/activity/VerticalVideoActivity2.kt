package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
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

    private val mAdapter: VideoPagerAdapter by lazy { VideoPagerAdapter(listener = this) }
    private val manager: VerticalPlayManager by lazy { VerticalPlayManager(this, this) }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

        binding.vp2VideoVertical.run {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }
    }

    override fun createObserver() {

        mViewModel.verticalVideos.observe(this) {

            Log.e("1mean", "vertical data: ${it.listData}")
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

    override fun onkeyBack() {
        manager.release()
        super.onkeyBack()
    }
}