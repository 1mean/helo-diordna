package com.example.pandas.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.getUrl
import com.example.pandas.biz.interaction.CommentsListener
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.ActivityVideoBinding
import com.example.pandas.ui.adapter.VideoFragmentAdapter
import com.example.pandas.ui.ext.closeFullScreen
import com.example.pandas.ui.ext.fullScreen
import com.example.pandas.ui.fragment.CommentListFragment
import com.example.pandas.utils.KeyboardUtils
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.util.DebugTextViewHelper
import com.google.android.exoplayer2.util.EventLogger
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import java.io.File


/**
 * @description: video播放界面
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>(),
    CommentsListener {

    private val tabNames = arrayListOf("简介", "评论")
    private var mPlayer: ExoPlayer? = null

    private var vedioUrl: String? = null
    private var code: Int = -1
    private var isFullScreen: Boolean = false
    private var isAttachedToWindow: Boolean = false
    private val MAX_UPDATE_INTERVAL_MS = 1000L

    private var isFirstVisible: Boolean = true

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                mPlayer?.play()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

//        val eyepetozerBean = getIntent().getParcelableExtra<EyepetozerItem>("EyepetozerItem")
//        vedioUrl = eyepetozerBean?.playUrl

        code = intent.getIntExtra(AppInfos.VIDEO_PLAY_KEY, -1)

        lifecycleScope.launch {

            val viewPager = binding.vpVideo
            viewPager.adapter = VideoFragmentAdapter(supportFragmentManager, lifecycle)
            viewPager.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            TabLayoutMediator(
                binding.tabView, viewPager, true
            ) { tab, position ->
                tab.text = tabNames[position]
            }.attach()
        }
        val left = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_close)
        val full = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_full)
        val controllerView = binding.playView.findViewById<FrameLayout>(R.id.flayout_controller)
        left.setOnClickListener {
            //保存历史记录
            mPlayer?.let { play ->
                val currentPosition = play.currentPosition
                mViewModel.saveHistory(code, currentPosition)
            }
            mPlayer?.release()
            mPlayer = null
            finish()
        }

        full.setOnClickListener {
            isFullScreen = if (isFullScreen) {//全屏
                closeFullScreen()
                false
            } else {
                fullScreen()
                true
            }
        }

        binding.playView.setOnClickListener {

//            if (binding.playView.isControllerVisible) {//当前是否可见
//                binding.playView.hideController()
//            }else{
//                binding.playView.showController()
////                controllerView.visibility = View.VISIBLE
//
//            }
        }

        binding.playView.setControllerVisibilityListener {
            updateTimeBar(it == View.VISIBLE)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        if (isFirstVisible) {
            if (code != -1) {
                mViewModel.getVideoInfo(code)
            }
            isFirstVisible = false
        }
    }

    override fun createObserver() {

        mViewModel.videoInfo.observe(this) {

            if (mPlayer == null) {
                val file = getUrl(this, it.fileName!!)
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

        Log.e("1mean", "fileName: ${file.absolutePath}")
        //2.创建播放菜单并添加到播放器
        val firstLocalMediaItem = MediaItem.fromUri(Uri.fromFile(file))
        binding.playView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT

        mPlayer?.run {
            setRepeatMode()//设置重复播放模式
            addListener(listener)
            addMediaItem(firstLocalMediaItem)
            playWhenReady = true//3.设置播放方式为自动播放
            prepare()//设置播放器状态为prepare
        }
    }

    override fun onStop() {
        super.onStop()
        mPlayer?.pause()
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
        mPlayer?.let { play ->
            val currentPosition = play.currentPosition
            mViewModel.saveHistory(code, currentPosition)
        }
        mPlayer?.release()
        mPlayer = null
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_DOWN) {

            val view = currentFocus
            val isShow = KeyboardUtils.isShouldHideKeyboard(view, ev)
            if (isShow) {
                KeyboardUtils.hideKeyboard(this)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun showCommentsFragment(commentId: Int) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            setCustomAnimations(
                R.anim.animate_fragment_in,
                R.anim.animate_fragment_out
            )
            add(R.id.llayout_video_info, CommentListFragment.newInstance(commentId))
        }
    }

    override fun closeCommentFragment() {
        if (supportFragmentManager.fragments.isNotEmpty()) {
            supportFragmentManager.fragments.forEach {
                if (it is CommentListFragment) {
                    supportFragmentManager.beginTransaction().setCustomAnimations(
                        R.anim.animate_fragment_in,
                        R.anim.animate_fragment_out
                    ).remove(it).commit()
                    return@forEach
                }
            }
        }
    }

    override fun onkeyBack() {
        if (supportFragmentManager.fragments.isNotEmpty()) {
            supportFragmentManager.fragments.forEach {
                if (it is CommentListFragment) {
                    supportFragmentManager.beginTransaction().setCustomAnimations(
                        R.anim.animate_fragment_in,
                        R.anim.animate_fragment_out
                    ).remove(it).commit()
                    return
                }
            }
        }
        setResult(RESULT_OK)
        finish()
    }

}