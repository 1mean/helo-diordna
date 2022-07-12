package com.example.pandas.ui.activity

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.ext.getUrl
import com.example.pandas.biz.ext.launchVideoPlayActivity
import com.example.pandas.biz.interaction.CommentsListener
import com.example.pandas.biz.manager.PlayerManager
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.ActivityVideoBinding
import com.example.pandas.ui.adapter.VideoFragmentAdapter
import com.example.pandas.ui.ext.closeFullScreen
import com.example.pandas.ui.ext.fullScreen
import com.example.pandas.ui.fragment.CommentListFragment
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.Util
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch


/**
 * @description: video播放界面
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>(),
    CommentsListener {

    private val tabNames = arrayListOf("简介", "评论")

    private var vedioUrl: String? = null
    private var code: Int = -1
    private var isFullScreen: Boolean = false
    private var isAttachedToWindow: Boolean = false
    private val MAX_UPDATE_INTERVAL_MS = 1000L

    private var isFirstVisible: Boolean = true
    private var isPlayIng: Boolean = false

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
        //val full = binding.playView.findViewById<ConstraintLayout>(R.id.clayout_video_full)
        val controllerView = binding.playView.findViewById<FrameLayout>(R.id.flayout_controller)
        val fullScreenButton = binding.playView.findViewById<AppCompatImageButton>(R.id.btn_fullscreen)
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

        binding.playView.setOnClickListener {

//            if (binding.playView.isControllerVisible) {//当前是否可见
//                binding.playView.hideController()
//            }else{
//                binding.playView.showController()
////                controllerView.visibility = View.VISIBLE
//
//            }
        }

        binding.playView.setControllerVisibilityListener(StyledPlayerView.ControllerVisibilityListener { visibility ->
            updateTimeBar(
                visibility
            )
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
    }

    override fun createObserver() {

        mViewModel.videoInfo.observe(this) {

            if (!isPlayIng) {
                val file = getUrl(this, it.fileName!!)
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
        if (isVisibility == View.GONE && !isFullScreen) {
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

            binding.exoTime.run {
                setDuration(PlayerManager.instance.duration())
                setBufferedPosition(PlayerManager.instance.bufferedPos())
                setPosition(PlayerManager.instance.currentPosition())
            }
            sendEmptyMessageDelayed(0, MAX_UPDATE_INTERVAL_MS)
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

    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_UP) {
            val view = currentFocus //界面里只给editext设置focus，其他地方点击为null
            Log.e("VideoPlayingActivity2", "focusView: $view")
            if (view != null) {
                val consumed = super.dispatchTouchEvent(ev)
                Log.e("VideoPlayingActivity2", "consumed: $consumed")
                val viewTmp = currentFocus
                val viewNew = viewTmp ?: view
                Log.e("VideoPlayingActivity2", "viewNew: $viewNew , view: $view")
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
                        Log.e("VideoPlayingActivity2", "rect: $rect")
                        val x = ev.x.toInt()
                        val y = ev.y.toInt()
                        Log.e("VideoPlayingActivity2", "x: $x , y: $y ,${rect.contains(x, y)}")
                        if (rect.contains(x, y)) {
                            return consumed
                        }
                    }
                } else if (viewNew is EditText) {
                    return consumed
                }
                val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                im.hideSoftInputFromWindow(viewNew.windowToken, 0);
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