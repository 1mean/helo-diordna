package com.example.pandas.ui.activity

import android.content.Context
import android.graphics.Rect
import android.os.*
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.commit
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.ext.launchVideoPlayActivity
import com.example.pandas.biz.interaction.CommentsListener
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.example.pandas.biz.manager.PlayerManager
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.ActivityVideoBinding
import com.example.pandas.ui.ext.closeFullScreen
import com.example.pandas.ui.ext.fullScreen
import com.example.pandas.ui.ext.initViewPager
import com.example.pandas.ui.ext.showTimeBar
import com.example.pandas.ui.fragment.CommentListFragment
import com.example.pandas.ui.view.VideoTabView
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.DefaultTimeBar
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.util.Util
import kotlin.math.abs


/**
 * @description: video播放界面
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>(),
    CommentsListener {

    val tabNames = arrayListOf("简介", "评论")

    private var vedioUrl: String? = null
    private var code: Int = -1
    private var isFullScreen: Boolean = false
    private val MAX_UPDATE_INTERVAL_MS = 1000L

    private var isFirstVisible: Boolean = true
    private var isPlayIng: Boolean = false
    private var isControllerShow = false
    private var isOnScroll = false
    private var exoProgress: DefaultTimeBar? = null

    var cnAdapter: CommonNavigatorAdapter? = null

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                //mPlayer?.play()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

        code = intent.getIntExtra("code", -1)
        isPlayIng = intent.getBooleanExtra("isPlaying", false)

        initViewPager()

        val left = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_close)
        //val full = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_full)
        val controllerView = binding.playView.findViewById<FrameLayout>(R.id.flayout_controller)
        exoProgress = binding.playView.findViewById(R.id.exo_play_progress)
        val fullScreenButton =
            binding.playView.findViewById<AppCompatImageButton>(R.id.btn_fullscreen)
        left.setOnClickListener {
            //保存历史记录
//            mPlayer?.let { play ->
//                val currentPosition = play.currentPosition
//                mViewModel.saveHistory(code, currentPosition)
//            }
//            mPlayer?.release()
//            mPlayer = null
            finish()
        }


        fullScreenButton.setOnClickListener {
            isFullScreen = if (isFullScreen) {//全屏
                closeFullScreen()
                false
            } else {
                fullScreen()
                true
            }
        }

        val screenWidth = ScreenUtil.getScreenWidth(this)
        binding.playView.controller(object : PlayerDoubleTapListener {

            var finalPosition = 0f

            override fun onDown() {
                super.onDown()
                Log.e("VideoPlayingActivity", "onDown")
                finalPosition = PlayerManager.instance.currentPosition().toFloat()
            }

            override fun onUp() {
                super.onUp()
                if (isOnScroll) {
                    PlayerManager.instance.seekTo(finalPosition.toLong())
                    isOnScroll = false
                }
                Log.e("VideoPlayingActivity", "onUp")
            }

            override fun onDoubleTapProgressUp(posX: Float, posY: Float) {
                super.onDoubleTapProgressUp(posX, posY)
                Log.e("VideoPlayingActivity", "onDoubleTapProgressUp")

                PlayerManager.instance.doubleTap()
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onScroll(distanceX: Float, distanceY: Float) {
                super.onScroll(distanceX, distanceY)

                isOnScroll = true
                val duration = PlayerManager.instance.duration()
                val updateDur = duration * abs(distanceX / screenWidth)
                binding.playView.showController()
                if (distanceX > 0) {//左滑
                    finalPosition -= updateDur
                } else {//右滑
                    finalPosition += updateDur
                }
                exoProgress?.setPosition(finalPosition.toLong())
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
                PlayerManager.instance.seekTo(position)
                isOnScroll = false
                Log.e("VideoPlayingActivity_1", "onScrubStop position: $position")
            }
        })
    }


    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            PlayerManager.instance.initPlayer(this)
        }
    }

    override fun onResume() {
        super.onResume()

        if (isFirstVisible) {

            if (isPlayIng) {
                PlayerManager.instance.addPlayerViewAndPlay(binding.playView)
            }
            if (code != -1) {
                mViewModel.getVideoInfoAndRelations(code)
            }
            isFirstVisible = false
        }
        updateTimeTask.sendEmptyMessage(0)
    }

    override fun createObserver() {

        mViewModel.videoInfo.observe(this) {

            val videoData = it.videoData
            val count = videoData?.comments ?: 0
            val childView = binding.tabView.getChildAt(0)
            if (childView != null && childView is CommonNavigator) {
                val view = (childView as CommonNavigator).getPagerTitleView(1)
                if (view != null && view is VideoTabView) {
                    (view as VideoTabView).updateTitle(count)
                }
            }

            if (!isPlayIng) {
                val file = getLocalFilePath(this, it.fileName!!)
                Log.e("1mean", "file: $file")
                if (file.exists()) {
                    //initPlayer(file)
                    val currentPos: Long = if (it.videoData == null) {
                        0L
                    } else {
                        it.videoData!!.playPosition
                    }
                    val mediaInfo = MediaInfo(it.code, file.absolutePath, currentPos)
                    PlayerManager.instance.setRepeatMode(Player.REPEAT_MODE_ONE)
                        .addPlayerView(binding.playView)
                        .startPlay(true, -1, mediaInfo)
                }
            }
        }

        mViewModel.isVideoItemClicked.observe(this) { code ->
            PlayerManager.instance.stopPlayer()
            launchVideoPlayActivity(this, code, false, requestLauncher)
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
        if (isVisibility == View.GONE && !isFullScreen) {//点击隐藏ControllerView
            showTimeBar(binding.exoTime)
            isControllerShow = false
        } else {
            showTimeBar(exoProgress)
            isControllerShow = true
            binding.exoTime.visibility = View.GONE
        }
    }

    private val updateTimeTask = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {

            Log.e("VideoPlayingActivity", "updateTimeTask")
            if (isControllerShow) {
                Log.e("VideoPlayingActivity", "showTimeBar: $isOnScroll")
                if (!isOnScroll) {//不要使用return中断循环
                    showTimeBar(exoProgress)
                }
            } else {
                showTimeBar(binding.exoTime)
            }
            sendEmptyMessageDelayed(0, MAX_UPDATE_INTERVAL_MS)
        }
    }

    override fun onStop() {
        super.onStop()
        //释放资源
        if (Util.SDK_INT > 23) {
            //暂停需要时间来处理，自己调用暂停
            PlayerManager.instance.stopPlayer()

            //在activity关闭时，必须释放掉绑定的视图，否则造成内存泄漏
            binding.playView.player = null
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_UP) {
            val view = currentFocus //界面里只给editext设置focus，其他地方点击为null
            //Log.e("VideoPlayingActivity2", "focusView: $view")
            if (view != null) {
                val consumed = super.dispatchTouchEvent(ev)
                val viewTmp = currentFocus
                val viewNew = viewTmp ?: view
                if (viewNew == view) {
                    val parentView = view.parent as ConstraintLayout
                    if (parentView != null) {
                        val rect = Rect()
                        val coordinates = IntArray(2)
//                    view.getLocationOnScreen(coordinates)
                        parentView.getLocationOnScreen(coordinates)
                        rect.set(
                            0,
                            coordinates[1],
                            parentView.width,
                            coordinates[1] + parentView.height
                        )
                        val x = ev.x.toInt()
                        val y = ev.y.toInt()
                        if (rect.contains(x, y)) {
                            return consumed
                        }
                    }
                } else if (viewNew is EditText) {
                    return consumed
                }
                val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                im.hideSoftInputFromWindow(viewNew.windowToken, 0)
                viewNew.clearFocus()
                return consumed
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

        updateTimeTask.removeMessages(0)
        //保存历史记录
        mViewModel.saveHistory(code, PlayerManager.instance.currentPosition())


//        //暂停需要时间来处理，自己调用暂停
//        PlayerManager.instance.stopPlayer()
//
//        //在activity关闭时，必须释放掉绑定的视图，否则造成内存泄漏
//        binding.playView.player = null


        finish()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                PlayerManager.instance.observeSystemVoice()
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                PlayerManager.instance.observeSystemVoice()
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}