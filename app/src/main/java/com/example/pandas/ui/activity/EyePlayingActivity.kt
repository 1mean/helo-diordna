package com.example.pandas.ui.activity

import CommonItemDecoration
import EyeRecAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.ActivityEyePlayBinding
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.util.DebugTextViewHelper
import com.google.android.exoplayer2.util.EventLogger
import com.google.android.exoplayer2.util.Util
import kotlinx.coroutines.launch


/**
 * @description: video播放界面
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class EyePlayingActivity : BaseActivity<EyepetozerViewModel, ActivityEyePlayBinding>() {

    private var mPlayer: ExoPlayer? = null
    private var eyepetozerBean: EyepetozerBean? = null

    private var vedioUrl: String? = null
    private var isFullScreen: Boolean = false
    private var isAttachedToWindow: Boolean = false
    private val MAX_UPDATE_INTERVAL_MS = 1000L

    private val mAdapter: EyeRecAdapter by lazy { EyeRecAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

        val paddingBottom = resources.getDimension(R.dimen.common_lh_15_dimens).toInt()

        eyepetozerBean = intent.getParcelableExtra<EyepetozerBean>("EyepetozerBean")
        vedioUrl = eyepetozerBean?.playUrl


        lifecycleScope.launch {


        }
        val left = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_close)
        val full = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_full)
        left.setOnClickListener {
            //保存历史记录
            mPlayer?.let { play ->
                val currentPosition = play.currentPosition
                //mViewModel.saveHistory(code, currentPosition)
            }
            mPlayer?.release()
            mPlayer = null
            finish()
        }

        binding.rvEye.run {
            layoutManager = LinearLayoutManager(this@EyePlayingActivity)
            addItemDecoration(CommonItemDecoration(paddingBottom = paddingBottom))
            adapter = mAdapter
        }
//        full.setOnClickListener {
//            isFullScreen = if (isFullScreen) {//全屏
//                closeFullScreen()
//                false
//            } else {
//                fullScreen()
//                true
//            }
//        }

        binding.playView.setOnClickListener {

        }

        binding.playView.setControllerVisibilityListener {
            updateTimeBar(it == View.VISIBLE)
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
        eyepetozerBean?.let {
            val title = it.title
            val desc = it.description
            val category = it.category
            val authorUrl = it.user?.userIcon
            val authorDesc = it.user?.userDes
            val authorName = it.user?.userName
            title?.let { t ->
                binding.txtEyeTitle.text = t
            }
            desc?.let {
                binding.txtEyeDesc.text = it
            }
            category?.let {
                binding.txtEyeTag.text = StringBuilder("#").append(it).toString()
            }
            authorUrl?.let {
                loadCircleImage(this, it, binding.imgEyeCover)
            }
            authorDesc?.let {
                binding.txtAuthorDesc.text = it
            }
            authorName?.let {
                binding.txtEyeName.text = it
            }
            mViewModel.getRecommend(it.videoId)
        }
    }

    override fun createObserver() {

//        mViewModel.isVideoItemClicked.observe(this) { code ->
//            mPlayer?.pause()
//            val intent = Intent(this, EyePlayingActivity::class.java).apply {
//                putExtra("code", code)
//            }
//            requestLauncher.launch(intent)
//        }
        mViewModel.recoResult.observe(this) { list ->

            Log.e("1mean", "list: $list")
            if (list != null && list.isNotEmpty()) {

                mAdapter.refreshAdapter(list)
            }
        }
    }

    private fun initPlayer() {


        //1.创建SimpleExoPlayer实例
        mPlayer = ExoPlayer.Builder(this).build()
        binding.playView.player = mPlayer

        vedioUrl?.let { url ->

            //2.创建播放菜单并添加到播放器
            val firstLocalMediaItem = MediaItem.fromUri(url)
            binding.playView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT

            mPlayer?.run {
                setRepeatMode()//设置重复播放模式
                addListener(listener)
                addMediaItem(firstLocalMediaItem)
                playWhenReady = true//3.设置播放方式为自动播放
                prepare()//设置播放器状态为prepare
            }
        }
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
    private fun setRepeatMode() {
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

    private var lastClickTime: Long = 0
    private fun isFastClick(): Boolean {

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime < 500) {
            return true
        }
        lastClickTime = currentTime
        return false
    }

    /**
     * isVisibility: 控制器是否会显示/全屏，显示/全屏状态下隐藏时间进度条
     */
    private fun updateTimeBar(isVisibility: Boolean) {
        if (!isVisibility && !isFullScreen) {
            binding.exoTime.visibility = View.VISIBLE
            updateTimeTask.sendEmptyMessage(0)
        } else {
            binding.exoTime.visibility = View.GONE
            updateTimeTask.removeMessages(0)
        }
    }

    private val updateTimeTask = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {

            if (!isAttachedToWindow) {
                return
            }

            mPlayer?.let { player ->
                binding.exoTime.run {
                    setDuration(player.duration)
                    setBufferedPosition(player.bufferedPosition)
                    setPosition(player.currentPosition)
                }
                sendEmptyMessageDelayed(0, MAX_UPDATE_INTERVAL_MS)
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        isAttachedToWindow = true
        updateTimeTask.sendEmptyMessage(0)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        isAttachedToWindow = false
        updateTimeTask.removeMessages(0)
    }

    override fun onDestroy() {
        super.onDestroy()

        updateTimeTask.removeMessages(0)
        //保存历史记录
//        mPlayer?.let { play ->
//            val currentPosition = play.currentPosition
//            mViewModel.saveHistory(code, currentPosition)
//        }
        mPlayer?.release()
        mPlayer = null
    }
}