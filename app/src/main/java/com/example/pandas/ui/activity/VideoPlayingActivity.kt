package com.example.pandas.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.*
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.interaction.CommentsListener
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.example.pandas.biz.interaction.VideoMoreSelectListener
import com.example.pandas.biz.manager.VideoPlayManager
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.ActivityVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.ext.*
import com.example.pandas.ui.fragment.video.CommentListFragment
import com.example.pandas.ui.view.VideoTabView
import com.example.pandas.ui.view.dialog.VideoMoreBottomSheetDialog
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.ui.DefaultTimeBar
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.util.Util
import com.lxj.xpopup.XPopup
import java.util.*
import kotlin.math.abs


/**
 * @description: video播放界面
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>(),
    CommentsListener, ExoPlayerListener, VideoMoreSelectListener {

    val tabNames = arrayListOf("简介", "评论")

    var commonNavigator: CommonNavigator? = null
    private var isFullScreen: Boolean = false
    private val MAX_UPDATE_INTERVAL_MS = 1000L

    private var isFirstVisible: Boolean = true
    private var isControllerShow = false
    private var isOnScroll = false
    private var exoProgress: DefaultTimeBar? = null

    var cnAdapter: CommonNavigatorAdapter? = null
    private var fullPos: AppCompatTextView? = null
    private var video: PetVideo? = null

    private val moreDialog by lazy { VideoMoreBottomSheetDialog(this, this) }

    val videoManager: VideoPlayManager by lazy { VideoPlayManager(this, this) }

    override fun initStatusView() {
        StatusBarUtils.setStatusBarMode(this, false, R.color.black)
    }

    override fun initView(savedInstanceState: Bundle?) {

        window.decorView.setBackgroundResource(R.color.white)//弹出软键盘背景会出现处理冷启动白屏的windowBackground

        video = intent.getParcelableExtra("petVideo")
        val index = intent.getIntExtra("index", 0)

        initViewPager(index)

        val left = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_close)
        //val full = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_full)
        val controllerView = binding.playView.findViewById<FrameLayout>(R.id.flayout_controller)
        val horView = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_horizontal)
        val more = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_top_more)
        val fullView = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_vertical)
        val title = binding.playView.findViewById<AppCompatTextView>(R.id.txt_full_title)
        val exit = binding.playView.findViewById<AppCompatImageButton>(R.id.img_full_leave)
        val stop = binding.playView.findViewById<AppCompatImageButton>(R.id.ib_full_stop)
        fullPos = binding.playView.findViewById<AppCompatTextView>(R.id.txt_full_position)
        val fullDur = binding.playView.findViewById<AppCompatTextView>(R.id.txt_full_duration)
        val fullTime = binding.playView.findViewById<DefaultTimeBar>(R.id.exo_progress)

        exoProgress = binding.playView.findViewById(R.id.exo_play_progress)
        val fullScreenButton =
            binding.playView.findViewById<AppCompatImageButton>(R.id.btn_fullscreen)

        left.setOnClickListener {
            val intent = Intent()
            val position = videoManager.getCurrentPos()
            intent.putExtra("position", position)
            setResult(RESULT_OK, intent)
            finish()
        }

        val status = appViewModel.appColorType.value
        Log.e("1mean", "==============$status")
        val r_color = if (status == null || status == 0) {
            ContextCompat.getColor(this, viewColors[APP_COLOR_STATUS])
        } else {
            ContextCompat.getColor(this, viewColors[status])
        }
        fullTime.setScrubberColor(r_color)
        exoProgress!!.setScrubberColor(r_color)
        fullTime.setPlayedColor(r_color)
        exoProgress!!.setPlayedColor(r_color)
        binding.exoTime.setPlayedColor(r_color)


        exit.setOnClickListener {
            isFullScreen = false
            closeFullScreen()
            fullView.visibility = View.GONE
            horView.visibility = View.VISIBLE
        }

        stop.setOnClickListener {
            if (videoManager.isPlaying()) {
                videoManager.onPause()
                stop.setImageResource(R.mipmap.img_video_full_play1)
            } else {
                videoManager.continuePlay()
                stop.setImageResource(R.mipmap.img_video_full_pause1)
            }
        }

        more.setOnClickListener {
            moreDialog.onShow()
        }

        fullTime.addListener(object : TimeBar.OnScrubListener {
            override fun onScrubStart(timeBar: TimeBar, position: Long) {
            }

            override fun onScrubMove(timeBar: TimeBar, position: Long) {
            }

            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                val formatBuilder = StringBuilder()
                val formatter = Formatter(formatBuilder, Locale.getDefault())
                fullPos?.text =
                    Util.getStringForTime(formatBuilder, formatter, position)
            }
        })

        fullScreenButton.setOnClickListener {
            isFullScreen = true
            fullScreen()
            fullView.visibility = View.VISIBLE
            horView.visibility = View.GONE

            val formatBuilder = StringBuilder()
            val formatter = Formatter(formatBuilder, Locale.getDefault())
            fullPos?.text =
                Util.getStringForTime(formatBuilder, formatter, videoManager.getCurrentPos())
            fullDur.text =
                Util.getStringForTime(formatBuilder, formatter, videoManager.getDuration())
            mViewModel.videoData.value?.let {
                title.text = it.title
            }
            if (videoManager.isPlaying()) {
                stop.setImageResource(R.mipmap.img_video_full_pause1)
            } else {
                stop.setImageResource(R.mipmap.img_video_full_play1)
            }
        }

        binding.playView.setFullscreenButtonClickListener {

        }

        val screenWidth = ScreenUtil.getScreenWidth(this)
        binding.playView.controller(object : PlayerDoubleTapListener {

            var finalPosition = 0f

            override fun onDown() {
                super.onDown()
                if (!isFullScreen) {
                    finalPosition = videoManager.getCurrentPos().toFloat()
                }
            }

            override fun onUp() {
                super.onUp()
                if (isOnScroll && !isFullScreen) {
                    videoManager.seekTo(finalPosition.toLong())
                    isOnScroll = false
                }
            }

            override fun onDoubleTapProgressUp(posX: Float, posY: Float) {
                super.onDoubleTapProgressUp(posX, posY)
                if (!isFullScreen) {
                    videoManager.doubleTap()
                }
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onScroll(distanceX: Float, distanceY: Float) {
                super.onScroll(distanceX, distanceY)

                if (!isFullScreen) {
                    isOnScroll = true
                    val duration = videoManager.getDuration()
                    val updateDur = duration * abs(distanceX / screenWidth)
                    binding.playView.showController()
                    if (distanceX > 0) {//左滑
                        finalPosition -= updateDur
                    } else {//右滑
                        finalPosition += updateDur
                    }
                    exoProgress?.setPosition(finalPosition.toLong())
                }
            }
        })

        binding.playView.setControllerVisibilityListener(StyledPlayerView.ControllerVisibilityListener { visibility ->
            updateTimeBar(visibility)
        })

        exoProgress?.addListener(object : TimeBar.OnScrubListener {
            override fun onScrubStart(timeBar: TimeBar, position: Long) {
                isOnScroll = true
                binding.playView.showController()
            }

            override fun onScrubMove(timeBar: TimeBar, position: Long) {
            }

            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                videoManager.seekTo(position)
                isOnScroll = false
            }
        })
    }


    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            videoManager.initPlayer()
        }
    }

    private var startTime: Long = 0
    override fun onResume() {
        super.onResume()
        if (isFirstVisible) {
            video?.let {
                mViewModel.getVideoData(it.code)
            }
            isFirstVisible = false
        }
        video?.let {

            val file = getLocalFilePath(this, it.fileName!!)
            if (file.exists()) {
                val mediaInfo =
                    MediaInfo(it.code, file.absolutePath, 0)
                videoManager.play(binding.playView, mediaInfo)
            }

            it.videoData?.let { data ->
                val file = getLocalFilePath(this, it.fileName!!)
                if (file.exists()) {
                    val mediaInfo =
                        MediaInfo(it.code, file.absolutePath, data.playPosition)
                    videoManager.play(binding.playView, mediaInfo)
                }
            }
        }
        startTime = System.currentTimeMillis()
        updateTimeTask.sendEmptyMessage(0)
    }

    override fun onStop() {
        super.onStop()
        //释放资源
        if (Util.SDK_INT > 23) {
            updateTimeTask.removeMessages(0)
            videoManager.releasePlayer()
        }
    }

    override fun createObserver() {

        mViewModel.videoData.observe(this) {

            val videoData = it.videoData
            val count = videoData?.comments ?: 0
            val childView = binding.tabView.getChildAt(0)
            if (childView != null && childView is CommonNavigator) {
                val view = (childView as CommonNavigator).getPagerTitleView(1)
                if (view != null && view is VideoTabView) {
                    (view as VideoTabView).updateTitle(count)
                }
            }
        }

        mViewModel.createComment.observe(this) {

            val childView = binding.tabView.getChildAt(0)
            if (childView != null && childView is CommonNavigator) {
                val view = (childView as CommonNavigator).getPagerTitleView(1)
                if (view != null && view is VideoTabView) {
                    (view as VideoTabView).updateComments()
                }
            }
        }
    }

    override fun isPlayingChanged(isPlaying: Boolean) {
        if (isPlaying && !isControllerShow) {//解决视频开始播放时,进度条显示错误，task会有1秒才会显示正确值
            binding.exoTime.run {
                visibility = View.VISIBLE
                setDuration(videoManager.getDuration())
                setBufferedPosition(videoManager.bufferedPos())
                setPosition(videoManager.getCurrentPos())
            }
        }
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
    private fun updateTimeBar(isVisibility: Int) {
        if (!isFullScreen) {
            if (isVisibility == View.GONE) {//点击隐藏ControllerView
                showTimeBar(binding.exoTime)
                isControllerShow = false
            } else {
                showTimeBar(exoProgress)
                isControllerShow = true
                binding.exoTime.visibility = View.GONE
            }
        }
    }

    private val updateTimeTask = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {

            if (videoManager.isPlaying() && !isOnScroll) {//不要使用return中断循环
                if (isFullScreen && fullPos!!.isVisible) {
                    val formatBuilder = StringBuilder()
                    val formatter = Formatter(formatBuilder, Locale.getDefault())
                    fullPos?.text =
                        Util.getStringForTime(
                            formatBuilder,
                            formatter,
                            videoManager.getCurrentPos()
                        )
                } else {
                    if (isControllerShow) {
                        showTimeBar(exoProgress)
                    } else {
                        showTimeBar(binding.exoTime)
                    }
                }
            }
            sendEmptyMessageDelayed(0, MAX_UPDATE_INTERVAL_MS)
        }
    }

    /**
     * 实现功能：
     *  - 点击软键盘外部区域，关闭软键盘
     *  - 当软键盘弹出时，点击软键盘外部时，不允许外部控件接收到点击事件
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                val view = currentFocus //界面里只给editext设置focus，其他地方点击为null
                view?.let {
                    if (it is EditText) {
                        val parentView = it.parent as ConstraintLayout
                        val rect = Rect()
                        val coordinates = IntArray(2)
                        parentView.getLocationOnScreen(coordinates)
                        rect.set(
                            0,
                            coordinates[1],
                            parentView.width,
                            coordinates[1] + parentView.height
                        )
                        val x = ev.x.toInt()
                        val y = ev.y.toInt()
                        if (!rect.contains(x, y)) {
                            val im =
                                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                            im.hideSoftInputFromWindow(it.windowToken, 0)
                            return true
                        }
                    }
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun showCommentsFragment(commentId: Int) {
        val fragments = supportFragmentManager.fragments
        addFragment(
            "comment_list", R.id.llayout_video_info, CommentListFragment.newInstance(commentId),
            intArrayOf(
                R.anim.animate_fragment_in,
                R.anim.animate_fragment_out,
                R.anim.animate_fragment_in,
                R.anim.animate_fragment_out
            )
        )
    }

    override fun closeCommentFragment() {
        popBack("comment_list")
    }

    override fun onkeyBack() {

        val fragment = supportFragmentManager.findFragmentByTag("comment_list")
        if (fragment != null) {
            supportFragmentManager.popBackStack()
            return
        }
        updateTimeTask.removeMessages(0)

        val intent = Intent()
        val position = videoManager.getCurrentPos()
        intent.putExtra("position", position)
        setResult(RESULT_OK, intent)

        //保存历史记录
        video?.let {
            mViewModel.saveHistory(it.code, videoManager.getCurrentPos())
        }
        videoManager.releasePlayer()


        finish()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP or KeyEvent.KEYCODE_VOLUME_DOWN -> {
                videoManager.updateVolume()
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun addPlayLater() {
        super.addPlayLater()
        video?.let {
            mViewModel.addLaterPlayer(it.code)
        }
        toast(this, "添加成功")
        moreDialog.dismiss()
    }

    private var checkPos = 3
    override fun setPlaySpeed() {
        super.setPlaySpeed()

        XPopup.Builder(this)
            .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
            .asBottomList(
                "",
                arrayOf("2.0", "1.5", "1.25", "1.0", "0.75", "0.5"),
                null,
                checkPos,
                { position, text ->
                    checkPos = position
                    videoManager.setPlaySpeed(text.toFloat())
                },
                R.layout.dialog_video_speed,
                R.layout.dialog_video_speed_item
            )
            .show()
        moreDialog.dismiss()
    }
}