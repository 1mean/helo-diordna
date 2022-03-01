package com.example.pandas.ui.activity

import StatusBarUtils
import VideoFragmentAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.getUrl
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.ActivityVideoBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.util.DebugTextViewHelper
import com.google.android.exoplayer2.util.EventLogger
import com.google.android.exoplayer2.util.Util
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import java.io.File


/**
 * @description: video播放界面
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>() {

    private val tabNames = arrayListOf("简介", "评论")
    private var mPlayer: ExoPlayer? = null

    private var vedioUrl: String? = null
    private var code: Int = -1

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                mPlayer?.play()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

//        val eyepetozerBean = getIntent().getParcelableExtra<EyepetozerBean>("EyepetozerBean")
//        vedioUrl = eyepetozerBean?.playUrl

        code = intent.getIntExtra(AppInfos.VIDEO_PLAY_KEY, -1)

        lifecycleScope.launch {

            val viewPager = binding.vpVideo
            viewPager.adapter = VideoFragmentAdapter(this@VideoPlayingActivity)
            viewPager.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            TabLayoutMediator(
                binding.tabView, viewPager, true
            ) { tab, position ->
                tab.text = tabNames[position]
            }.attach()
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23) {
            initPlayer()
        }
    }

    override fun onkeyBack() {
        setResult(RESULT_OK)
        finish()
    }

    override fun createObserver() {

        mViewModel.videoInfo.observe(this) {

            if (mPlayer == null) {

                val file = getUrl(this, it.fileName!!)
                Log.e("1mean", "path: ${file.absolutePath}")
                if (file.exists()) {
                    initPlayer(file)
                }
            }
        }

        mViewModel.isVideoItemClicked.observe(this) { code ->
            mPlayer?.pause()
            val intent = Intent(this, VideoPlayingActivity::class.java).apply {
                putExtra("code", code)
            }
            requestLauncher.launch(intent)
        }
    }

    private fun initPlayer(file: File) {

        //1.创建SimpleExoPlayer实例
        mPlayer = ExoPlayer.Builder(this).build()
        binding.playView.player = mPlayer

        //2.创建播放菜单并添加到播放器
        val firstLocalMediaItem = MediaItem.fromUri(Uri.fromFile(file))

        mPlayer?.run {
            setRepeatMode()//设置重复播放模式
            addListener(listener)
            addMediaItem(firstLocalMediaItem)
            playWhenReady = true//3.设置播放方式为自动播放
            prepare()//设置播放器状态为prepare
        }
    }

    private fun initPlayer() {

        if (code == -1) {
            return
        }
        mViewModel.getVideoInfo(code)
    }

    private val listener = object : Player.Listener {

        override fun onPlayWhenReadyChanged(
            playWhenReady: Boolean,
            reason: Int
        ) {//playWhenReady标志来指示用户打算播放
            super.onPlayWhenReadyChanged(playWhenReady, reason)
        }

        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                Player.STATE_READY -> {//player 可以立即从当前位置进行播放
                }
                Player.STATE_IDLE -> {//这是初始状态，播放器停止时的状态以及播放失败时的状态
                }
                Player.STATE_BUFFERING -> {//player 无法立即从当前位置进行播放。这主要是因为需要加载更多数据
                }
                Player.STATE_ENDED -> {//播放器播放完所有媒体
                }
            }
        }

        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
        }

        override fun onPlayerError(error: PlaybackException) {

        }
    }

    //设置播放模式
    //REPEAT_MODE_OFF（顺序播放）、REPEAT_MODE_ONE（仅播放一次）和REPEAT_MODE_ALL（重复播放）
    fun setRepeatMode() {
        mPlayer?.repeatMode = Player.REPEAT_MODE_ALL
    }

    //监控其播放过程中的重要log信息，可以通过按钮点击实时监控信息
    fun loglistener() {
        /* 扩展：注册并添加listener */
        val trackSelector = DefaultTrackSelector(this)
        trackSelector.parameters = DefaultTrackSelector.ParametersBuilder(this).build()
        mPlayer?.addAnalyticsListener(EventLogger(trackSelector))
    }

    //使用exoplayer自带的debug helper来显示实时调试信息
    fun debugHelper(debugTextView: TextView) {

        /* 扩展：使用exoplayer自带的debug helper来显示实时调试信息 */
        val debugViewHelper = DebugTextViewHelper(mPlayer!!, debugTextView)
        debugViewHelper.start()
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
//            if (playerView != null) {
//                playerView.onPause()
//            }
//            releasePlayer()
        }

    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
//            if (playerView != null) {
//                playerView.onPause()
//            }
//            releasePlayer()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer?.release()
    }

    private var lastClickTime: Long = 0
    private fun isFastClick(): Boolean {

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime < 500) {
            return true
        }
        lastClickTime = currentTime
        return false
    }

}