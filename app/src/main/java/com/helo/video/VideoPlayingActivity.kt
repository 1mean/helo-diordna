package com.helo.video

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
import com.example.pandas.biz.interaction.ItemClickListener
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
import com.example.pandas.ui.view.dialog.MoreBottomSheetDialog
import com.example.pandas.ui.view.dialog.VideoMoreFuncDialog
import com.example.pandas.ui.view.popuwindow.ShortRightPopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.interfaces.XPopupCallback
import kotlinx.coroutines.launch
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
    private var isVpDragging = false
    private var isTimeDragging = false//只要达到触发了时间拖拽的条件，就能无限拖拽，直至up
    private var screenWidth = 0
    private var finalPosition: Long = 0
    private var lastPosition: Long = 0
    private var shortBottomDialog: ShortBottomDialog? = null
    private var commentPopupView: ShortRightPopuWindow? = null
    private var flag = false
    private var moreFunDialog:VideoMoreFuncDialog?=null
    private var commentsMap = hashMapOf<Int, String>()

    //private var isVertical = true
    private val loginSuccess: Boolean
        get() = AppInstance.instance.isLoginSuccess

    //onStart -> 返回数据后 -> 然后执行onResume()
    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Log.e("2mean", "result…$result")
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                result.data?.let {
                    val userCode = it.getIntExtra("userCode", -1)
                    Log.e("2mean", "userCode: $userCode")
                    if (userCode > 0) {
                        mAdapter.recyclerView?.let {
                            val viewHolder =
                                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                            viewHolder?.updateAttention(currentPosition, userCode)
                        }
                    }
                }
                //manager?.continuePlayer()
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

        exoMedia = ExoMediaManager(this, this, this)

        screenWidth = ScreenUtil.getScreenWidth(this)

        with(binding.vp2VideoPlay) {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }

        binding.rlayoutVideoVp.post {
            Log.e(
                "1mean",
                "width=${binding.rlayoutVideoVp.width},height=${binding.rlayoutVideoVp.height}"
            )
        }
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
            if (loginSuccess) {
                showBottomCommentWindow()
            } else {
                startAnyActivity(this, LoginActivity::class.java)
            }
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
                            mAdapter.refreshAdapter(it.listData)
                            Log.e("1mean", "获取到刷新数据：size= " + it.listData.size)
                            exoMedia?.addMedidItems(it.listData)

//                            mAdapter.recyclerView?.let { rv ->
//                                val holder =
//                                    rv.findViewHolderForLayoutPosition(0) as? VideoPlayingAdapter.MyViewHolder
//                                Log.e("1mean", "holder=$holder")
//                                holder?.let {hold->
//                                    exoMedia?.seekTo(0, hold.playerView)
//                                }
//                            }
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
            val video = mAdapter.getPetVide(currentPosition)
            val viewHolder =
                rv.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
            viewHolder?.let { vh ->
                vh.coverShow(false)
                //exoMedia?.seekTo(currentPosition, video.code, vh.playerView)
                exoMedia?.resumePlay()
            }
        }
    }

    /**
     * 每次切换到新视频，会先返回一次false，再返回一次true，即暂停上个视频，播放下个视频
     * 但是无法通过代码逻辑再这里处理界面，所以在onPageSelected时，就将上个视频的封面cover展示，再在此处，打开新视频的封面
     */
    override fun OnPlayerViewShow(isShow: Boolean) {
        if (isShow) {
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
            binding.exoProgress.apply {
                //visibility = View.VISIBLE
                exoMedia?.let { videoManager ->
                    setDuration(videoManager.getDuration())
                    setBufferedPosition(videoManager.bufferedPos())
                    setPosition(videoManager.getCurrentPos())
                }
            }
//            if (videoManager.isPlaying() && !isOnScroll) {//不要使用return中断循环
//                if (isFullScreen && fullPos!!.isVisible) {
//                    val formatBuilder = StringBuilder()
//                    val formatter = Formatter(formatBuilder, Locale.getDefault())
//                    fullPos?.text =
//                        Util.getStringForTime(
//                            formatBuilder,
//                            formatter,
//                            videoManager.getCurrentPos()
//                        )
//                } else {
//                    if (isControllerShow) {
//                        showTimeBar(exoProgress)
//                    } else {
//                        showTimeBar(binding.exoTime)
//                    }
//                }
//            }
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
                    isVpDragging = true
                    binding.exoProgress.visibility = View.GONE
                    updateTimeTask.removeCallbacksAndMessages(null)
                }

                SCROLL_STATE_SETTLING -> {
                }

                SCROLL_STATE_IDLE -> {//onPageSelected之后执行
                    isVpDragging = false
                    binding.exoProgress.visibility = View.VISIBLE
                    updateTimeTask.sendEmptyMessage(0)
                    Log.e("1mean", "SCROLL_STATE_IDLE")
                }
            }
        }

        //界面初始化，第一次注册时也会被调用，所以要注意为null的判断
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.exoProgress.visibility = View.VISIBLE
            Log.e("1mean", "onPageSelected : position=$position")
            Log.e("22222222", "selected")
            //1，将上个视频的封面展示出来,currentPosition在下面播放时再赋值为新的position
            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                viewHolder?.coverShow(true)
            }

            //2，播放新视频，传入新的playerView，并设置currentPosition = position
            binding.vp2VideoPlay.post {

                val count = mAdapter.itemCount
                if (position == (count - 1)) {
                    mViewModel.getVerticalVideos(false)
                }

                mAdapter.recyclerView?.let { rv ->
                    val viewHolder =
                        rv.findViewHolderForAdapterPosition(position) as? VideoPlayingAdapter.MyViewHolder
                    viewHolder?.let { vh ->
                        Log.e("1mean", "position=$position")
                        exoMedia?.seekTo(position, vh.playerView)
                    }
                }
                currentPosition = position
            }

            //3,修改底部视图
            val video = mAdapter.getPetVide(position)
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

    override fun onDoubleTap(videoData: VideoData) {
        addShortStartAnimation(binding.btnBottomLike)
        binding.btnBottomLike.setImageResource(R.mipmap.img_bottom_liked)
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun onSingleTap() {
        Log.e("1mean", "onSingleTap")
        exoMedia?.singleClick()
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

    var longPressed: Boolean = false
    private val longTask = Runnable {
        longPressed = true
        VibrateUtils.vibrate(50)
    }
    var startTime: Long = 0

    //最顶2150  最底2300
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("1mean", "activity down")
                startX = event.rawX
                startY = event.rawY
                Log.e("asdasdasdasd", "startY=$startY")
                exoMedia?.let {
                    finalPosition = it.getCurrentPos()
                }
                startTime = event.downTime

//                if (startY.toInt() in 100 until 2150
//                    && (startX.toInt() in 0..150 || startX.toInt() in 980..1080)
//                ) {
//                    HANDLER.postDelayed(longTask, 500)
//                }

                if (startY.toInt() in 100 until 2150) {
                    HANDLER.postDelayed(longTask, 500)
                }

                if (startY.toInt() in 2150..2300) {
                    return true
                }
            }

            MotionEvent.ACTION_MOVE -> {
                Log.e("1mean", "activity move")
                endX = event.rawX
                endY = event.rawY
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
                }else if (startX.toInt() in 150  until 980) {
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
            }

            MotionEvent.ACTION_UP -> {
                Log.e("1mean", "activity up")
                if (isTimeDragging) {
                    binding.clayoutVerticalBottom.visibility = View.VISIBLE
                    Log.e("asdasdd", "松开拖拽：finalPosition=$finalPosition")
                    exoMedia?.seekTo(lastPosition)
                    updateTimeTask.sendEmptyMessage(0)
                    isTimeDragging = false
                    finalPosition = 0
                    lastPosition = 0
                }
                HANDLER.removeCallbacks(longTask)//必须放外面，因为点击了隔500ms就会触发长按，必须在longPressed=true前取消
                if (longPressed) {
                    speedUp(false)
                    longPressed = false
                    return true//因为长视频空白区域，在长按结束后会再次触发adapter里写的点击事件，所以up后也不传递给子view
                }
                flag  = false
            }

            MotionEvent.ACTION_CANCEL -> {
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
                binding.clayoutVerticalBottom.visibility = View.GONE
                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                    viewHolder?.updateVideoInfos(true)
                }
                binding.clayoutBottomFunctionInfo.visibility = View.VISIBLE
                binding.txtBottomInfo.text = "2X加速中"
                val animation = binding.imgBottomSpeedup.background as? AnimationDrawable
                animation?.start()
                exoMedia?.setPlaySpeed(2.0f)
                flag = true
            }
        } else {
            if (flag) {
                binding.clayoutVerticalBottom.visibility = View.VISIBLE
                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(currentPosition) as? VideoPlayingAdapter.MyViewHolder
                    viewHolder?.updateVideoInfos(false)
                }
                binding.clayoutBottomFunctionInfo.visibility = View.GONE
                val animation = binding.imgBottomSpeedup.background as? AnimationDrawable
                animation?.stop()
                exoMedia?.setPlaySpeed(1.0f)
                flag = false
            }
        }
    }

    private fun showMoreFunction(){
        if (!flag) {
            if (moreFunDialog == null) {
                moreFunDialog = VideoMoreFuncDialog(this, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {

                    }
                })
            }
            moreFunDialog?.onShow()
            flag  = true
        }
    }
}
