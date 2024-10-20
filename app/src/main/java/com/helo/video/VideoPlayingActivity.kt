package com.helo.video

import AppInstance
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Rect
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_DRAGGING
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_IDLE
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_SETTLING
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoComment
import com.android.android_sqlite.entity.VideoData
import com.android.base.ui.activity.BaseActivity
import com.android.base.utils.ScreenUtil
import com.blankj.utilcode.util.VibrateUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.interaction.CommentWindowListener
import com.example.pandas.biz.manager.ExoMediaManager
import com.example.pandas.biz.manager.ExoMediaManager.ExoListener
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.ActivityVideoPlayBinding
import com.example.pandas.ui.activity.LoginActivity
import com.example.pandas.ui.activity.UserInfoActivity
import com.example.pandas.ui.adapter.VideoPlayingAdapter
import com.example.pandas.ui.adapter.VideoPlayingAdapter.VerticalVideoListener
import com.example.pandas.ui.dialog.ShortBottomDialog
import com.example.pandas.ui.ext.addShortEndAnimation
import com.example.pandas.ui.ext.addShortStartAnimation
import com.example.pandas.ui.ext.getParcelableExtra
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.view.dialog.VideoMoreFuncDialog
import com.example.pandas.ui.view.dialog.VideoMoreFuncDialog.MoreFunctionListener
import com.example.pandas.ui.view.popuwindow.ShortRightPopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.util.Util
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.interfaces.XPopupCallback
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch
import java.util.Formatter
import java.util.Locale
import kotlin.math.abs


/**
 * <最终的视频播放的统一入口>
 * @author: dongyiming
 * @date: 9/18/24 PM2:53
 * @version: v1.0
 */
public class VideoPlayingActivity : BaseActivity<ShortVideoViewModel, ActivityVideoPlayBinding>(),
    ExoListener, VerticalVideoListener {

    private val mAdapter: VideoPlayingAdapter by lazy { VideoPlayingAdapter(listener = this) }
    private var exoMedia: ExoMediaManager? = null
    private var currentPosition: Int = -1
    private var petVideo: PetVideo? = null
    private val MAX_UPDATE_INTERVAL_MS = 1000L
    private var startX: Float = 0f
    private var startY: Float = 0f
    private var endX: Float = 0f
    private var endY: Float = 0f
    private var mTouchSlop: Int = 0
    private var isVpDragging = false//手动拖拽viewpager的标识
    private var isTimeDragging = false//只要达到触发了时间拖拽的条件，就能无限拖拽，直至up
    private var screenWidth = 0
    private var finalPosition: Long = 0
    private var lastPosition: Long = 0
    private var shortBottomDialog: ShortBottomDialog? = null
    private var commentPopupView: ShortRightPopuWindow? = null
    private var flag = false
    private var isFullScreen = false
    private var moreFunDialog: VideoMoreFuncDialog? = null
    private var commentsMap = hashMapOf<Int, String>()
    private var formatBuilder: StringBuilder? = null
    private var formatter: Formatter? = null

    private val DOUBLE_TAP_TIMEOUT: Int = ViewConfiguration.getDoubleTapTimeout()
    private val DOUBLE_TAP_MIN_TIME: Int = 40

    //private var isVertical = true
    private val loginSuccess: Boolean
        get() = AppInstance.instance.isLoginSuccess

    //onStart -> 返回数据后 -> 然后执行onResume()
    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                result.data?.let {
                    val userCode = it.getIntExtra("userCode", -1)
                    if (userCode > 0) {
                        mAdapter.recyclerView?.let {
                            val viewHolder =
                                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                            viewHolder?.updateAttention(currentPosition, userCode)
                        }
                    }
                }
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

        lifecycleScope.launchWhenCreated {
            val viewConfig = ViewConfiguration.get(this@VideoPlayingActivity)
            mTouchSlop = viewConfig.scaledTouchSlop
            binding.exoProgress.isEnabled = false
        }

        petVideo = getParcelableExtra(intent, "PetVideo", PetVideo::class.java)
        Log.e("12345668", "petVideo=$petVideo")

        exoMedia = ExoMediaManager(this, this, this)

        screenWidth = ScreenUtil.getScreenWidth(this)

        with(binding.vp2VideoPlay) {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }

        binding.btnFunction.setOnClickListener {
            showMoreFunction()
        }

        formatBuilder = StringBuilder()
        formatter = Formatter(formatBuilder, Locale.getDefault())

    }

    override fun clickFunction() {
        super.clickFunction()

        binding.btnBottomLike.setOnClickListener {
            if (currentPosition >= 0) {
                mAdapter.likedClick(currentPosition)
            }
        }

        binding.btnBottomCollect.setOnClickListener {
            if (currentPosition >= 0) {
                mAdapter.collectedClick(currentPosition)
            }
        }

        binding.btnBottomComments.setOnClickListener {
            showCommentDialog()
        }

        binding.clayoutVideoInput.setOnClickListener {
            Log.e("1madsadasdean", "clayoutVideoInput setOnClickListener")
            if (loginSuccess) {
                showBottomCommentWindow()
            } else {
                startAnyActivity(this, LoginActivity::class.java)
            }
        }

        binding.imgShowall.setOnClickListener {
            binding.clayoutVideoTop.visibility = View.VISIBLE
            hideVideoInfo(false)
            binding.imgShowall.visibility = View.GONE
        }

        binding.btnLeave.setOnClickListener { finish() }

        binding.btnVideoPause.setOnClickListener {
            Log.e("controller-gone", "btnVideoPause click")
            exoMedia?.let { manager ->
                if (manager.isPlaying()) {
                    manager.pausePlayer()
                    binding.btnVideoPause.setImageResource(R.mipmap.img_video_playing2)
                } else {
                    manager.resumePlay()
                    binding.btnVideoPause.setImageResource(R.mipmap.img_video_full_pause1)
                }
            }
        }

        binding.btnVideoLeave.setOnClickListener {
            leaveFullView()
        }

        binding.timeBarVideoFull.addListener(object : TimeBar.OnScrubListener {
            override fun onScrubStart(timeBar: TimeBar, position: Long) {
                //isOnScroll = true
                //binding.playView.showController()
            }

            override fun onScrubMove(timeBar: TimeBar, position: Long) {
            }

            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                exoMedia?.seekTo(position)
                //videoManager.seekTo(position)
                //isOnScroll = false
            }
        })

        binding.clayoutVideoSwitch.setOnClickListener {
            fullView()
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.verticalVideosFlow.collect {
                if (it.isSuccess) {
                    when {
                        it.isRefresh -> {
                            petVideo?.let { video ->
                                it.listData.add(0, video)
                            }
                            Log.e("12345668", "list size:${it.listData.size}")
                            mAdapter.refreshAdapter(it.listData)
                            Log.e("1mean", "获取到刷新数据：size= " + it.listData.size)
                            exoMedia?.addMedidItems(it.listData)
                        }

                        it.hasMore -> {
                            exoMedia?.addMedidItems(it.listData)
                            Log.e("1mean", "获取到更多数据：size= " + it.listData.size)
                            mAdapter.loadMore(it.listData)
                        }
                    }
                }
            }
        }

        lifecycleScope.launch {
            mViewModel.defaultCollectFlow.collect {
                toastTopShow(this@VideoPlayingActivity, it)
            }
        }

        mViewModel.commentResult.observe(this) {
            if (it != null) {
                toastTopShow(this, "评论已发布")
//                mAdapter.recyclerView?.let { rv ->
//                    val viewHolder =
//                        rv.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
//                    viewHolder?.updateComments(currentPosition, it)
//                }
//                rightPopupView?.addComment(it)
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getVerticalVideos(true)
    }

    override fun againOnResume() {
        super.againOnResume()
        mAdapter.recyclerView?.let { rv ->
            val viewHolder =
                rv.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
            viewHolder?.let { vh ->
                vh.coverShow(false)
                Log.e("1112333", "2222222222")
                vh.pauseViewShow(false)
                exoMedia?.resumePlay()
            }
        }
    }

    /**
     * 每次切换到新视频，会先返回一次false，再返回一次true，即暂停上个视频，播放下个视频
     * 但是无法通过代码逻辑再这里处理界面，所以在onPageSelected时，就将上个视频的封面cover展示，再在此处，打开新视频的封面
     */
    override fun OnIsPlayingChanged(isPlaying: Boolean) {
        if (isPlaying) {
            updateTimeTask.sendEmptyMessage(0)
            mAdapter.recyclerView?.let { rv ->
                val holder = rv.findViewHolderForLayoutPosition(currentPosition)
                if (holder != null && holder is VideoPlayingAdapter.MyViewHolder) {
                    (holder as VideoPlayingAdapter.MyViewHolder).coverShow(false)
                }
            }
        }
    }

    private val updateTimeTask = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (isFullScreen) {
                exoMedia?.let { videoManager ->
                    val duration = videoManager.getDuration()
                    val position = videoManager.getCurrentPos()
                    binding.txtVideoPosition.text = Util.getStringForTime(
                        formatBuilder!!,
                        formatter!!,
                        position
                    )
                    binding.txtVideoDuration.text = Util.getStringForTime(
                        formatBuilder!!,
                        formatter!!,
                        duration
                    )
                    binding.timeBarVideoFull.setDuration(duration)
                    binding.timeBarVideoFull.setPosition(position)
                    binding.timeBarVideoFull.setBufferedPosition(videoManager.bufferedPos())
                }

            } else {
                binding.exoProgress.apply {
                    //visibility = View.VISIBLE
                    exoMedia?.let { videoManager ->
                        setDuration(videoManager.getDuration())
                        setBufferedPosition(videoManager.bufferedPos())
                        setPosition(videoManager.getCurrentPos())
                    }
                }
            }
            sendEmptyMessageDelayed(0, MAX_UPDATE_INTERVAL_MS)
        }
    }

    private var STATE_CONTROLLER: Int = 0
    private val hideControllerRunnable = Runnable {

        if (STATE_CONTROLLER == 1) {
            binding.timeBarVideoFull.visibility = View.VISIBLE
        } else if (STATE_CONTROLLER == 2) {
            binding.timeBarVideoFull.visibility = View.GONE
        }

    }

    private val controllerHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (isFullScreen) {
                exoMedia?.let { videoManager ->
                    val duration = videoManager.getDuration()
                    val position = videoManager.getCurrentPos()
                    binding.txtVideoPosition.text = Util.getStringForTime(
                        formatBuilder!!,
                        formatter!!,
                        position
                    )
                    binding.txtVideoDuration.text = Util.getStringForTime(
                        formatBuilder!!,
                        formatter!!,
                        duration
                    )
                    binding.timeBarVideoFull.setDuration(duration)
                    binding.timeBarVideoFull.setPosition(position)
                    binding.timeBarVideoFull.setBufferedPosition(videoManager.bufferedPos())
                }

            } else {
                binding.exoProgress.apply {
                    //visibility = View.VISIBLE
                    exoMedia?.let { videoManager ->
                        setDuration(videoManager.getDuration())
                        setBufferedPosition(videoManager.bufferedPos())
                        setPosition(videoManager.getCurrentPos())
                    }
                }
            }
            sendEmptyMessageDelayed(0, MAX_UPDATE_INTERVAL_MS)
        }
    }

    /**
     * 第一次进入会触发onPageSelected position=0
     * 只有手动滑动时，才会触发onPageScrollStateChanged回调，执行顺序如下
     *   --翻页时回调
     *      --SCROLL_STATE_DRAGGING
     *      --SCROLL_STATE_SETTLING
     *      --onPageSelected : 1
     *      --SCROLL_STATE_IDLE
     *
     *   --滑动后，仍然在当前页面，不会回调 onPageSelected
     *      --SCROLL_STATE_DRAGGING
     *      --SCROLL_STATE_SETTLING
     *      --SCROLL_STATE_IDLE
     *
     */
    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            when (state) {
                SCROLL_STATE_DRAGGING -> {
                    Log.e("asdadasdasdsa", "vp draging˛˛")
                    isVpDragging = true
                    binding.clayoutVideoSwitch.visibility = View.GONE
                    binding.exoProgress.visibility = View.GONE
                    updateTimeTask.removeCallbacksAndMessages(null)
                }

                SCROLL_STATE_SETTLING -> {
                }

                SCROLL_STATE_IDLE -> {//onPageSelected之后执行
                    Log.e("asdadasdasdsa", "vp SCROLL_STATE_IDLE˛˛")
                    isVpDragging = false
                    binding.exoProgress.visibility = View.VISIBLE
                    updateTimeTask.sendEmptyMessage(0)
                }
            }
        }

        //界面初始化，第一次注册时也会被调用，所以要注意为null的判断
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Log.e("asdadasdasdsa", "vp onPageSelected˛˛")
            if (!binding.clayoutVideoTop.isVisible) {
                binding.clayoutVideoTop.visibility = View.VISIBLE
            }
            moreFunDialog = null
            binding.exoProgress.visibility = View.VISIBLE
            binding.imgShowall.visibility = View.GONE

            val video = mAdapter.getPetVide(position)
            val videoCode = video.code

            if (video.vertical) {
                binding.clayoutVideoSwitch.visibility = View.GONE
            } else {
                binding.clayoutVideoSwitch.post {
                    binding.clayoutVideoSwitch.visibility = View.VISIBLE
                }
            }

            Log.e("1mean", "onPageSelected : position=$position")
            Log.e("22222222", "selected: position=$position")
            //1，将上个视频的封面展示出来,currentPosition在下面播放时再赋值为新的position
            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                Log.e("12345668", "上一个viewholder:$viewHolder")
                viewHolder?.coverShow(true)
                Log.e("1112333", "33333333333")
                viewHolder?.pauseViewShow(false)
                viewHolder?.updateVideoInfos(false)
            }

            //2，播放新视频，传入新的playerView，并设置currentPosition = position
            binding.vp2VideoPlay.post {

                val count = mAdapter.itemCount
                Log.e("22222222", "list size=$count")
                if (position == (count - 1)) {
                    mViewModel.getVerticalVideos(false)
                }

                mAdapter.recyclerView?.let { rv ->
                    val viewHolder =
                        rv.findViewHolderForAdapterPosition(position) as? VideoPlayingAdapter.MyViewHolder
                    viewHolder?.let { vh ->
                        Log.e("12345668", "开始播放seekTo position:$position")
                        vh.getPlayerView()?.let { player ->
                            exoMedia?.play(player, videoCode)
                        }
                    }
                }
                currentPosition = position
            }

            //3,修改底部视图
            //isVertical = video.vertical
            Log.e("222222222", "position=$position")
            if (video.videoData == null) {
                binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_like)
                binding.btnBottomCollect.setImageResource(R.mipmap.img_bottom_collect)
            } else {
                video.videoData?.let { vd ->
                    if (vd.like) {
                        binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_liked)
                    } else {
                        binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_like)
                    }

                    if (vd.collect) {
                        binding.btnBottomCollect.setImageResource(R.mipmap.img_bottom_collected)
                    } else {
                        binding.btnBottomCollect.setImageResource(R.mipmap.img_bottom_collect)
                    }
                }
            }
        }
    }

    override fun onDoubleTap(videoData: VideoData?) {
        Log.e("1madsadasdean", "onDoubleTap")
        if (isFullScreen) {
            exoMedia?.let {
                if (it.isPlaying()) {
                    it.pausePlayer()
                    updateFullViewPause(true)
                } else if (it.isPauseing()) {
                    it.resumePlay()
                    updateFullViewPause(false)
                }
            }
        } else {
            addShortStartAnimation(binding.btnBottomLike)
            binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_liked)
            videoData?.let {
                mViewModel.addOrUpdateVideoData(it)
            }
        }
    }

    private fun updateFullViewPause(isPause: Boolean) {
        if (isPause) {//暂停
            binding.btnVideoPause.setImageResource(R.mipmap.img_video_playing2)
        } else {
            binding.btnVideoPause.setImageResource(R.mipmap.img_video_full_pause1)
        }
    }

    override fun onSingleTap(isOuter: Boolean) {
        Log.e("1madsadasdean", "onSingleTap")
        if (!isFullScreen) {
            exoMedia?.singleClick()
            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                Log.e("1112333", "5555555555")
                viewHolder?.updatePauseView()
            }
        } else {
            if (binding.clayoutVideoController.isVisible) {
                Log.e("controller-gone", "3333333")
                binding.clayoutVideoController.visibility = View.GONE
                binding.clayoutVideoController.removeCallbacks(controllerRunnable)
            } else {
                binding.clayoutVideoController.visibility = View.VISIBLE
                binding.clayoutVideoController.removeCallbacks(controllerRunnable)
                binding.clayoutVideoController.postDelayed(controllerRunnable, 5000)
            }
        }
    }

    override fun collectItemLongClick(petVideo: PetVideo) {
    }

    override fun updataVideoData(videoData: VideoData) {
    }

    override fun collect(isAdd: Boolean, petVideo: PetVideo) {
    }

    override fun updateUserAttention(userCode: Int) {
        mViewModel.updateAttention(userCode)
    }

    override fun startUserActivity(userCode: Int, user: User?) {
        val intent = Intent(this, UserInfoActivity::class.java).apply {
            putExtra("userCode", userCode)
            putExtra("user", user)
        }
        requestLauncher.launch(intent)
    }

    override fun showComments(videoCode: Int, commentCounts: Int) {
    }

    override fun addAttention(userCode: Int) {
    }

    override fun updateLikedView(liked: Boolean, videoData: VideoData) {
        if (liked) {
            addShortStartAnimation(binding.btnBottomLike)
            binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_liked)
        } else {
            addShortEndAnimation(binding.btnBottomLike)
            binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_like)
        }
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun updateCollectedView(collected: Boolean, petVideo: PetVideo) {
        if (collected) {
            addShortStartAnimation(binding.btnBottomCollect)
            binding.btnBottomCollect.setImageResource(R.mipmap.img_bottom_collected)
        } else {
            addShortEndAnimation(binding.btnBottomCollect)
            binding.btnBottomCollect.setImageResource(R.mipmap.img_bottom_collect)
        }
        petVideo.videoData?.let {
            mViewModel.addOrUpdateVideoData(it)
        }
        mViewModel.updateCollect(collected, petVideo)
    }

    private fun fullView() {
        isFullScreen = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            //Tell the window that we want to handle/fit any system windows
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val controller = window.insetsController
            controller?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }

        //记得AndroidManifest里添加设置，不然界面保存的还是之前的竖屏，后续界面的修改无效
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        binding.clayoutVideoTop.post {
            binding.clayoutVideoTop.visibility = View.GONE
            binding.exoProgress.visibility = View.GONE
            hideVideoInfo(true)

            binding.clayoutVerticalBottom.visibility = View.GONE
            //BUG:不设置bottomMargin时，总会有一个58dp的底部黑边
            val params = binding.rlayoutVideoVp.layoutParams as FrameLayout.LayoutParams
            params.bottomMargin = 0
            binding.rlayoutVideoVp.layoutParams = params

            binding.clayoutVideoSwitch.visibility = View.GONE

            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                viewHolder?.updateFullScreen(currentPosition, true)
            }

            binding.clayoutVideoController.visibility = View.VISIBLE

            binding.clayoutVideoController.removeCallbacks(controllerRunnable)
            binding.clayoutVideoController.postDelayed(controllerRunnable, 5000)

            val video = mAdapter.getPetVide(currentPosition)
            binding.txtVideoFullTitle.text = video.title
        }
    }

    private fun leaveFullView() {

        isFullScreen = false

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            //Tell the window that we want to handle/fit any system windows
            WindowCompat.setDecorFitsSystemWindows(window, true)
            val controller = window.insetsController
            controller?.show(WindowInsets.Type.statusBars())
        }
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding.clayoutVideoTop.post {
            binding.clayoutVideoTop.visibility = View.VISIBLE
            binding.exoProgress.visibility = View.VISIBLE
            hideVideoInfo(false)

            binding.clayoutVerticalBottom.visibility = View.VISIBLE
            //BUG:不设置bottomMargin时，总会有一个58dp的底部黑边
            val params = binding.rlayoutVideoVp.layoutParams as FrameLayout.LayoutParams
            params.bottomMargin = 174
            binding.rlayoutVideoVp.layoutParams = params

            binding.clayoutVideoSwitch.visibility = View.VISIBLE

            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                viewHolder?.updateFullScreen(currentPosition, false)

                exoMedia?.let { ex ->
                    if (ex.isPauseing()) {
                        Log.e("1112333", "44444444")
                        viewHolder?.pauseViewShow(true)
                    }
                }
            }

            Log.e("controller-gone", "444444")
            binding.clayoutVideoController.visibility = View.GONE
            binding.clayoutVideoController.removeCallbacks(controllerRunnable)
        }
    }

    var longPressed: Boolean = false
    private val longTask = Runnable {
        longPressed = true
        VibrateUtils.vibrate(50)
    }

    private val singleClick = Runnable {//点击和点击后的长按要区分
        if (eventState == -1) {
            //执行单击的操作
            firstUpTime = 0
            onSingleTap(true)
        } else if (eventState == STATE_MOVE) {//长按中
            Log.e("firstDownTime", "长按中")
        }
    }

    private fun isConsideredDoubleTap(firstUpTime: Long, secondDownTime: Long): Boolean {
        val deltaTime: Long = secondDownTime - firstUpTime
        Log.e("212112122", "event.eventTime=${secondDownTime}, deltaTime=$deltaTime")
        if (deltaTime > DOUBLE_TAP_TIMEOUT || deltaTime < DOUBLE_TAP_MIN_TIME) {
            return false
        }
        return true
    }

    var firstUpTime: Long = 0
    var firstDownTime: Long = 0
    private var mIsDoubleTapping = false
    private var eventState: Int = -1
    private val STATE_DOWN = 0
    private val STATE_MOVE = 1
    private val STATE_UP = 2

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        return super.onTouchEvent(event)
    }

    /**
     * 难解决：Activity上的控件点击后，也触发了此处逻辑，也触发了点击事件。即MotionEvent和控件的点击和长按的冲突
     */
    //最顶2150  最底2300
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        if (isVpDragging) {
            return super.dispatchTouchEvent(event)
        }
        var isInView = false
        if (isFullScreen) {
            val count = binding.clayoutVideoController.childCount
            for (i in 0 until count) {
                val child = binding.clayoutVideoController.getChildAt(i)
                val bounds = Rect()
                child.getHitRect(bounds)
                if (bounds.contains(event.x.toInt(), event.y.toInt())) {
                    isInView = true
                    break
                }
            }
        } else {
            mAdapter.recyclerView?.let {
                val vh =
                    it.findViewHolderForAdapterPosition(currentPosition) as VideoPlayingAdapter.MyViewHolder
                if (vh.isViewIn(event.y, null)) {
                    isInView = vh.isHeaderIn(event.x, event.y)
                } else if (vh.isViewIn(event.y, binding.clayoutVideoTop)) {
                    val count = binding.clayoutVideoTop.childCount
                    for (i in 0 until count) {
                        val child = binding.clayoutVideoTop.getChildAt(i)
                        Log.e("asdaddassssad", "child=$child")
                        val location = IntArray(2)
                        child.getLocationOnScreen(location)
                        val width = child.width
                        val height = child.height

                        Log.e(
                            "asdaddassssad",
                            "x=${location[0]},y=${location[1]},width=$width,height=$height"
                        )
                        if (event.x.toInt() in location[0]..(location[0] + width) && event.y.toInt() in location[1]..(location[1] + height)) {
                            isInView = true
                        }
                    }
                }
            }

            if (!isInView) {
                val location = IntArray(2)
                binding.clayoutVideoSwitch.getLocationInWindow(location)
                Log.e("controller-gone", "x=${location[0]} , y=${location[1]}")
                val width = binding.clayoutVideoSwitch.width
                val height = binding.clayoutVideoSwitch.height
                Log.e("controller-gone", "width=$width , height=$height")

                if (event.x.toInt() in location[0]..(location[0] + width) && event.y.toInt() in location[1]..(location[1] + height)) {
                    isInView = true
                }
            }
        }
        Log.e("controller-gone", "isInView=$isInView")
        if (isInView) {
            return super.dispatchTouchEvent(event)
        }
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                eventState = STATE_DOWN
                Log.e("1madsadasdean", "activity down")
                startX = event.rawX
                startY = event.rawY
                Log.e("asdasdasdasd", "startX=$startX, startY=$startY")
                exoMedia?.let {
                    finalPosition = it.getCurrentPos()
                }
                firstDownTime = event.downTime
                Log.e("firstDownTime", "firstDownTime=$firstDownTime")

                if (isFullScreen) {
                    HANDLER.postDelayed(longTask, 300)
                }

                if (!isFullScreen) {
                    if (startY.toInt() in 100 until 2150) {
                        HANDLER.postDelayed(longTask, 400)

                        if (firstUpTime > 0 && isConsideredDoubleTap(
                                firstUpTime,
                                System.currentTimeMillis()
                            )
                        ) {//第二次点击
                            Log.e("212112122", "2222222222")
                            HANDLER.removeCallbacks(singleClick)
                            mIsDoubleTapping = true
                            val videoData = mAdapter.getDoubleTapVideoData(currentPosition)
                            onDoubleTap(videoData)
                        } else {//第一次点击
                            Log.e("212112122", "11111111111")
                            HANDLER.postDelayed(singleClick, DOUBLE_TAP_TIMEOUT.toLong())
                        }
                    }
                } else {
                    if (firstUpTime > 0 && isConsideredDoubleTap(
                            firstUpTime,
                            System.currentTimeMillis()
                        )
                    ) {//第二次点击
                        Log.e("212112122", "2222222222")
                        HANDLER.removeCallbacks(singleClick)
                        mIsDoubleTapping = true
                        onDoubleTap(null)
                    } else {//第一次点击，点击逻辑不能写在此处，和长按冲突
                        Log.e("212112122", "11111111111")
                        HANDLER.postDelayed(singleClick, DOUBLE_TAP_TIMEOUT.toLong())
                    }
                }
            }

            MotionEvent.ACTION_MOVE -> {
                eventState = STATE_MOVE
                Log.e("1madsadasdean", "ACTION_MOVE")
                endX = event.rawX
                endY = event.rawY

                if (!isFullScreen) {
                    if (startY.toInt() in 2150..2300) {
                        val distanceX: Float = endX - startX
                        val distanceY: Float = endY - startY

                        //isVpDragging：只要viewpager触发了正在翻页，就不处理了
                        //三个条件
                        //1，首要条件isTimeDragging：只要触发了时间的拖拽，就不考虑其他任何条件了，一直拖拽到触发UP
                        //2，偏移必须大于mTouchSlop，正常也是y>mTouchSlop才触发翻页
                        //3，isVpDragging：如果Viewpager正在翻页了，就不要消耗事件了
                        //4，abs(distanceX) * 0.4 > abs(distanceY)：保证水平方向上的偏移大一些就触发时间的拖拽，避免超过mTouchSlop就触发vp的翻页，抑制翻页的条件
                        if (isTimeDragging || (!isVpDragging && (abs(distanceX) > mTouchSlop || abs(
                                distanceY
                            ) > mTouchSlop) && abs(distanceX) * 0.4 > abs(distanceY))
                        ) {//水平操作
                            Log.e("adadasdsadds", " View.VISIBLE  55555")
                            binding.clayoutVerticalBottom.visibility = View.GONE
                            updateTimeTask.removeCallbacksAndMessages(null)
                            exoMedia?.let {
                                val duration = it.getDuration()
                                binding.exoProgress.setDuration(duration)
                                val updateDur = duration * (abs(distanceX) / screenWidth)

                                lastPosition = if (distanceX > 0) {//右边
                                    finalPosition + updateDur.toLong()
                                } else {//右滑
                                    finalPosition - updateDur.toLong()
                                }
                                binding.exoProgress.setPosition(lastPosition)
                            }
                            isTimeDragging = true
                            return true
                        }
                    } else if (startX.toInt() in 0 until 150 || startX.toInt() in 980..1080) {
                        if (longPressed) {
                            Log.e("1mean", "长按中.......")
                            speedUp(true)
                            return true
                        } else {
                            if (endX != startX) {
                                HANDLER.removeCallbacks(longTask)
                            }
                        }
                    } else if (startX.toInt() in 150 until 980) {
                        if (longPressed) {
                            //Log.e("1mean", "长按中.......")
                            showMoreFunction()
                            return true
                        } else {
                            if (endX != startX) {
                                HANDLER.removeCallbacks(longTask)
                            }
                        }
                    }
                } else {
                    if (longPressed) {
                        Log.e("1mean", "长按中.......")
                        fullSpeedUp(true)
                        return true
                    } else {
                        if (endX != startX) {
                            HANDLER.removeCallbacks(longTask)
                        }
                    }
                }
            }

            MotionEvent.ACTION_UP -> {
                eventState = -1
                if (!isFullScreen) {
                    Log.e(
                        "1madsadasdean",
                        "activity up  isTimeDragging:$isTimeDragging, longPressed=$longPressed"
                    )
                    if (isTimeDragging) {
                        Log.e("adadasdsadds", " View.VISIBLE  1111")
                        binding.clayoutVerticalBottom.visibility = View.VISIBLE
                        Log.e("asdasdd", "松开拖拽：finalPosition=$finalPosition")
                        exoMedia?.seekTo(lastPosition)
                        mAdapter.recyclerView?.let {
                            val viewHolder =
                                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                            Log.e("1112333", "11111111")
                            viewHolder?.pauseViewShow(false)
                        }
                        updateTimeTask.sendEmptyMessage(0)
                        isTimeDragging = false
                        finalPosition = 0
                        lastPosition = 0
                        return true//避免控件区域上方的滑动后，会触发控件的点击效果
                    }
                }

                HANDLER.removeCallbacks(longTask)//必须放外面，因为点击了隔500ms就会触发长按，必须在longPressed=true前取消
                if (!isFullScreen) {
                    if (longPressed && (startX.toInt() in 0 until 150 || startX.toInt() in 980..1080)) {
                        speedUp(false)
                        return true//因为长视频空白区域，在长按结束后会再次触发adapter里写的点击事件，所以up后也不传递给子view
                    }
                } else {
                    fullSpeedUp(false)
                }
                longPressed = false
                flag = false

                if (mIsDoubleTapping) {
                    firstUpTime = 0//第二次点击后，重置第一次up
                } else {
                    firstUpTime = System.currentTimeMillis()
                }
                mIsDoubleTapping = false
            }

            MotionEvent.ACTION_CANCEL -> {
                if (!isFullScreen) {
                    Log.e("1mean", "activity cancel")
                    if (isTimeDragging) {
                        isTimeDragging = false
                        finalPosition = 0
                        lastPosition = 0
                    }

                    HANDLER.removeCallbacks(longTask)
                    if (longPressed) {
                        speedUp(false)
                        longPressed = false
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onPause() {
        super.onPause()
        updateTimeTask.removeCallbacksAndMessages(null)
        Log.e("1mean", "1111111pausePlayer")
        exoMedia?.pausePlayer()

        mAdapter.recyclerView?.let {
            val viewHolder =
                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
            viewHolder?.coverShow(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        updateTimeTask.removeCallbacksAndMessages(null)
    }

    private fun showBottomCommentWindow() {
        if (shortBottomDialog == null) {
            shortBottomDialog = ShortBottomDialog(
                this,
                commentsMap[currentPosition] ?: "",
                object : ShortBottomDialog.ShortPopuListener {
                    override fun openEmoji(view: View) {
                    }

                    override fun sendComment(comment: String) {
                        sendVideoComment(comment)
                    }

                    override fun dissmiss(comment: String, isSending: Boolean) {
                        if (isSending) {
                            commentsMap[currentPosition] = ""
                        } else {
                            if (comment.isNotEmpty()) {
                                val message =
                                    QqEmoticons.parseAndShowEmotion(
                                        this@VideoPlayingActivity,
                                        comment
                                    )
                                val content = Editable.Factory.getInstance().newEditable(message)
                                commentsMap[currentPosition] = content.toString()
                            } else {
                                commentsMap[currentPosition] = ""
                            }
                        }
                    }

                })
        }
        val builder = XPopup.Builder(this)
        builder.enableDrag(false)
            .animationDuration(100)//动画时长，不设置时长，就是默认的301ms，效果会很差
            // .popupAnimation(PopupAnimation.TranslateAlphaFromBottom)
            .autoOpenSoftInput(true)
            .autoFocusEditText(true)
            .asCustom(shortBottomDialog)
            .show()
    }

    private fun sendVideoComment(content: String) {
        Log.e("1mean", "editStr: $content")
        val code = mAdapter.getPetVide(currentPosition).code
        if (code == null || code == -1) {
            throw RuntimeException("videoCode = -1 is wrong")
        }
        val comment = VideoComment(
            fromUserName = AppInfos.AUTHOR_NAME,
            fromUserCode = AppInfos.AUTHOR_ID,
            type = 1,
            commitTime = System.currentTimeMillis(),
            content = content,
            commentType = 0,
            videoCode = code
        )
        mViewModel.sendComment(comment)
    }

    private var viewHolder: VideoPlayingAdapter.MyViewHolder? = null
    private fun showCommentDialog() {
        mAdapter.recyclerView?.let {
            viewHolder =
                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
        }
        if (commentPopupView == null) {
            val videoCode = mAdapter.getPetVide(currentPosition).code
            commentPopupView = ShortRightPopuWindow(this, videoCode, 0, object :
                CommentWindowListener {
                override fun updateComments(commentCount: Int) {
//                    mHandler.post {
//                        mAdapter.recyclerView?.let {
//                            vh =
//                                it.findViewHolderForAdapterPosition(currentPosition) as VideoPagerAdapter.MyViewHolder
//                            vh?.updateCommentCounts(currentPosition, commentCount)
//                        }
//                    }
                }
            })
        }
        XPopup.setShadowBgColor(ContextCompat.getColor(this, R.color.color_white_lucency))
        XPopup.Builder(this).setPopupCallback(object :
            XPopupCallback {
            override fun onCreated(popupView: BasePopupView?) {
            }

            override fun beforeShow(popupView: BasePopupView?) {
                Log.e("asdasdsadasdasd", "beforeShow")
                binding.clayoutVideoTop.visibility = View.GONE
                if (viewHolder == null) {
                    mAdapter.recyclerView?.let {
                        viewHolder =
                            it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                    }
                }
                viewHolder?.updateVideoInfos(true)
            }

            override fun onShow(popupView: BasePopupView?) {
                Log.e("asdasdsadasdasd", "onShow")
            }

            override fun onDismiss(popupView: BasePopupView?) {
                Log.e("asdasdsadasdasd", "onDismiss")
                binding.clayoutVideoTop.visibility = View.VISIBLE
                if (viewHolder == null) {
                    mAdapter.recyclerView?.let {
                        viewHolder =
                            it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                    }
                }
                viewHolder?.updateVideoInfos(false)
            }

            override fun beforeDismiss(popupView: BasePopupView?) {
            }

            override fun onBackPressed(popupView: BasePopupView?): Boolean {
                Log.e("asdasdsadasdasd", "onBackPressed")
                return false
            }

            override fun onKeyBoardStateChanged(popupView: BasePopupView?, height: Int) {
            }

            override fun onDrag(
                popupView: BasePopupView?,
                value: Int,
                percent: Float,
                upOrLeft: Boolean
            ) {
                if (viewHolder == null) {
                    mAdapter.recyclerView?.let {
                        viewHolder =
                            it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                    }
                }
                viewHolder?.playerChanged(currentPosition, value, percent, upOrLeft)
            }

            override fun onClickOutside(popupView: BasePopupView?) {
            }

        })
            .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
            .dismissOnTouchOutside(true)
            .animationDuration(600)
            .asCustom(commentPopupView)
            .show()
    }

    private fun speedUp(isUp: Boolean) {
        if (isUp) {
            if (!flag) {
                Log.e("adadasdsadds", " View.VISIBLE  22222")
                binding.clayoutVerticalBottom.visibility = View.GONE
                hideVideoInfo(true)
                binding.clayoutBottomFunctionInfo.visibility = View.VISIBLE
                binding.txtBottomInfo.text = "2X加速中"
                val animation = binding.imgBottomSpeedup.background as? AnimationDrawable
                animation?.start()
                exoMedia?.setPlaySpeed(2.0f)
                flag = true
            }
        } else {
            if (flag) {
                Log.e("adadasdsadds", " View.VISIBLE  33333")
                binding.clayoutVerticalBottom.visibility = View.VISIBLE
                hideVideoInfo(false)
                binding.clayoutBottomFunctionInfo.visibility = View.GONE
                val animation = binding.imgBottomSpeedup.background as? AnimationDrawable
                animation?.stop()
                exoMedia?.setPlaySpeed(1.0f)
                flag = false
            }
        }
    }

    private fun fullSpeedUp(isUp: Boolean) {
        if (isUp) {
            if (!flag) {
                exoMedia?.let {
                    if (it.isPlaying()) {
                        Log.e("controller-gone", "111111")
                        binding.clayoutVideoController.visibility = View.GONE
                        binding.clayoutVideoController.removeCallbacks(controllerRunnable)

                        binding.clayoutFullSpeedup.visibility = View.VISIBLE
                        exoMedia?.setPlaySpeed(2.0f)
                        flag = true
                    }
                }
            }
        } else {
            if (flag) {
                binding.clayoutVideoController.visibility = View.VISIBLE
                binding.clayoutFullSpeedup.visibility = View.GONE
                binding.clayoutVideoController.postDelayed(controllerRunnable, 5000)

                exoMedia?.setPlaySpeed(1.0f)
                flag = false
            }
        }
    }

    private val controllerRunnable = Runnable {
        Log.e("controller-gone", "222222")
        binding.clayoutVideoController.visibility = View.GONE
    }

    private fun showMoreFunction() {
        if (moreFunDialog == null) {
            moreFunDialog = VideoMoreFuncDialog(
                this,
                exoMedia?.getRepeatMode() ?: 0,
                object : MoreFunctionListener {
                    override fun updateSpeed(speed: Float) {
                        toastTopShow(this@VideoPlayingActivity, "已切换至${speed}倍速播放")
                        exoMedia?.updateSpeed(speed)
                    }

                    override fun unLike() {
                        exoMedia?.removeCurrentItem(currentPosition)
                        mAdapter.removePosition(currentPosition)

                        binding.vp2VideoPlay.adapter = null
                        binding.vp2VideoPlay.adapter = mAdapter
                        binding.vp2VideoPlay.setCurrentItem(currentPosition, false)

                        toastTopShow(this@VideoPlayingActivity, "看看新视频吧～")
                    }

                    override fun autoPlay(isAuto: Boolean) {
                        if (isAuto) {
                            toastTopShow(
                                this@VideoPlayingActivity,
                                "已开启，，将自动播放下一条视频"
                            )
                        } else {
                            toastTopShow(
                                this@VideoPlayingActivity,
                                "已关闭，，将循环播放当前视频"
                            )
                        }
                        exoMedia?.updatePlayType(isAuto)
                    }

                    override fun addLaterPlay() {
                        val videoCode = mAdapter.getPetVide(currentPosition).code
                        mViewModel.addLaterPlayer(videoCode)
                        toastTopShow(this@VideoPlayingActivity, "添加到稍后播放")
                    }

                    override fun screenClear() {
                        binding.clayoutVideoTop.visibility = View.GONE
                        //binding.clayoutVerticalBottom.visibility = View.GONE
                        hideVideoInfo(true)
                        binding.imgShowall.visibility = View.VISIBLE
                    }
                })
        }
        moreFunDialog?.onShow()
    }

    /**
     * 当设置了重复模式为REPEAT_MODE_OFF时。才会触发playingEnd()
     * - 无论是代码切换的翻页，还是手动翻页，都会触发playingEnd()，只要是REPEAT_MODE_OFF就会触发
     * - 手动翻页时，不允许执行playingEnd()里的逻辑，因为可能让上翻页
     */
    override fun playingEnd() {
        if (!isVpDragging) {//只有viewpager代码设置
            binding.vp2VideoPlay.setCurrentItem(currentPosition + 1, true)
        }
    }

    private fun hideVideoInfo(isHide: Boolean) {
        mAdapter.recyclerView?.let {
            val viewHolder =
                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
            viewHolder?.updateVideoInfos(isHide)
        }
    }
}
