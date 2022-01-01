package com.example.pandas.ui.activity

import StatusBarUtils
import VideoFragmentAdapter
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pandas.R
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.databinding.ActivityVideoBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.util.DebugTextViewHelper
import com.google.android.exoplayer2.util.EventLogger
import com.google.android.exoplayer2.util.Util
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    private val tabNames = arrayListOf<String>("简介", "评论")
    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var vedioUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

        val eyepetozerBean = getIntent().getParcelableExtra<EyepetozerBean>("EyepetozerBean")
        vedioUrl = eyepetozerBean?.playUrl
        val viewPager = binding.vpVideo

        viewPager.adapter = VideoFragmentAdapter(this)
        viewPager.offscreenPageLimit = 1

        TabLayoutMediator(
            binding.tabView, viewPager, true
        ) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }

    private fun initPlayer(playUri: String?) {

        if (playUri == null) {
            Log.d("ExoTest", "playUri is null!")
            return
        }

        if (_mPlayer == null) {

            /* 1.创建SimpleExoPlayer实例 */
            _mPlayer = ExoPlayer.Builder(this).build()
            binding.playView.player = mPlayer

            /* 2.创建播放菜单并添加到播放器 */
            val firstLocalMediaItem = MediaItem.fromUri(playUri)
            mPlayer.addMediaItem(firstLocalMediaItem)

            /* 3.设置播放方式为自动播放 */
            mPlayer.playWhenReady = true

            /* 4.将SimpleExoPlayer实例设置到StyledPlayerView中 */
            //mPlayerView.player = mPlayer

            /* 5，设置播放器状态为prepare */
            mPlayer.prepare()
        }
    }

    //设置播放模式
    //REPEAT_MODE_OFF（顺序播放）、REPEAT_MODE_ONE（仅播放一次）和REPEAT_MODE_ALL（重复播放）
    fun setRepeatMode() {
        mPlayer.repeatMode = Player.REPEAT_MODE_ALL
    }

    //监控其播放过程中的重要log信息，可以通过按钮点击实时监控信息
    fun loglistener() {
        /* 扩展：注册并添加listener */
        val trackSelector = DefaultTrackSelector(this)
        trackSelector.parameters = DefaultTrackSelector.ParametersBuilder(this).build()
        mPlayer.addAnalyticsListener(EventLogger(trackSelector))
    }

    //使用exoplayer自带的debug helper来显示实时调试信息
    fun debugHelper(debugTextView: TextView) {

        /* 扩展：使用exoplayer自带的debug helper来显示实时调试信息 */
        val debugViewHelper = DebugTextViewHelper(mPlayer, debugTextView)
        debugViewHelper.start()
    }


    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            Log.e("1mean","onStart")
            initPlayer(vedioUrl)
//            if (playerView != null) {
//                playerView.onResume()
//            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23) {
            Log.e("1mean","onResume")
            initPlayer(vedioUrl)
//            if (playerView != null) {
//                playerView.onResume()
//            }
        }
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
        mPlayer.release()
    }

    /*
    *
    * 想以本地流的方式来调试exoplayer，
    * 就会遇到作用域问题，从Android 10开始，
    * 每个应用程序只能有权在自己的外置存储空间关联目录下读取和创建文件，
    * 获取该关联目录的代码是：context.getExternalFilesDir()，关联目录对应的路径大致如下：
    *  /storage/emulated/0/Android/data/<包名>/files
    * */
}