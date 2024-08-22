package com.example.pandas.ui.activity

import AppInstance
import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.text.Editable
import android.util.Log
import android.view.*
import android.view.animation.LinearInterpolator
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.android.android_sqlite.entity.VideoComment
import com.android.android_sqlite.entity.VideoData
import com.android.base.ui.activity.BaseActivity
import com.android.base.utils.VibrateUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.android.base.ui.lifecycle.LifecycleHandler
import com.example.pandas.biz.interaction.CommentWindowListener
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.android.base.manager.SoftInputManager
import com.example.pandas.biz.manager.VerticalPlayManager
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.ActivityVerticalVideoplayBinding
import com.example.pandas.ui.adapter.VideoPagerAdapter
import com.example.pandas.ui.dialog.ShortBottomDialog
import com.example.pandas.ui.ext.addRefreshAnimation
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.view.popuwindow.ShortRightPopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.util.Util
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.interfaces.XPopupCallback
import kotlinx.coroutines.launch


/**
 * @description: 横屏视频,使用Viewpager2来实现
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class ShortVideoActivity :
    BaseActivity<ShortVideoViewModel, ActivityVerticalVideoplayBinding>(), ExoPlayerListener,
    VideoPagerAdapter.VerticalVideoListener {

    private val loginSuccess: Boolean
        get() = AppInstance.instance.isLoginSuccess

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var endX: Float = 0f
    private var endY: Float = 0f
    private var totalOffset = 0
    private var isMoving = false //只是下拉刷新操作
    private var quickFlag = false //是否是快速滑动
    private var isRefreshing = false

    var mCurrentVelocity: Int = 0
    var mMinimumVelocity: Int = 0
    var mMaximumVelocity: Int = 0
    var mTouchSlop: Int = 0
    private var hasMore = false
    var mVelocityTracker: VelocityTracker? = null //速度跟踪器
    private val mAdapter: VideoPagerAdapter by lazy { VideoPagerAdapter(listener = this) }

    private var manager: VerticalPlayManager? = null
    private var keyBoardManager: SoftInputManager? = null

    var rightPopupView: ShortRightPopuWindow? = null

    var videoCode: Int = -1

    var lastClickTime: Long = 0

    private val mHandler = LifecycleHandler(Looper.getMainLooper(), this)

    fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    @SuppressLint("Recycle")
    override fun initView(savedInstanceState: Bundle?) {

        initStatusView()
        //bug:一句代码解决了两天的bug，关闭popuwindow时，edittext仍然有焦点，会反复弹出
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        manager = VerticalPlayManager(this, this)

        videoCode = intent.getIntExtra("videoCode", -1)
        keyBoardManager = SoftInputManager(this)
        keyBoardManager!!.setOnSoftKeyBoardChangeListener(keyBoardListener)

        mVelocityTracker = VelocityTracker.obtain()
        val viewConfig = ViewConfiguration.get(this)
        mTouchSlop = viewConfig.scaledTouchSlop
        mMinimumVelocity = viewConfig.scaledMinimumFlingVelocity
        mMaximumVelocity = viewConfig.scaledMaximumFlingVelocity

        binding.vp2VideoVertical.run {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }

        binding.ibnVerticalTopClose.setOnClickListener {
            mVelocityTracker?.recycle()
            manager?.release()
            finish()
        }

        binding.clayoutVerticalTop.post {
            val location = IntArray(2)
            binding.clayoutVerticalTop.getLocationOnScreen(location)
//            val x = location[0]
//            val y = location[1]
        }

        binding.editVertical.setOnClickListener {
            if (loginSuccess) {
                showBottomCommentWindow(false, false)
            } else {
                startAnyActivity(this, LoginActivity::class.java)
            }
        }

        binding.btnVerticalInputSend.setOnClickListener {
            sendVideoComment(binding.editVertical.text.toString())
            binding.btnVerticalInputSend.post {
                binding.editVertical.text = null
                binding.editVertical.hint =
                    resources.getString(R.string.str_hint_edit_short)
                binding.btnVerticalInputSend.visibility = View.GONE
                shortBottomDialog?.clear()
            }
        }

        binding.btnShortEmotion.setOnClickListener {
            if (loginSuccess) {
                showBottomCommentWindow(true, false)
            } else {
                startAnyActivity(this, LoginActivity::class.java)
            }
        }
        binding.btnShortAt.setOnClickListener {
            if (loginSuccess) {
                showBottomCommentWindow(false, true)
            } else {
                startAnyActivity(this, LoginActivity::class.java)
            }
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.verticalVideosFlow1.collect {
                if (it.isSuccess) {
                    when {
                        it.isRefresh -> {
                            mAdapter.refreshAdapter(it.listData)
                            if (isRefreshing) {
                                manager?.refreshPlayer(it.listData)
                                isRefreshing = false
                                binding.clayoutVerticalRefresh.visibility = View.GONE
                            } else {
                                manager?.initPlayer(it.listData)
                            }
                        }
                        it.hasMore -> {
                            mAdapter.loadMore(it.listData)
                            manager?.addMediaItems(it.listData)
                        }
                    }
                    hasMore = it.hasMore
                }
            }
        }


        mViewModel.commentResult.observe(this) {
            if (it != null) {
                toastTopShow(this, "评论成功")
                mAdapter.recyclerView?.let { rv ->
                    val viewHolder =
                        rv.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.updateComments(currentPosition, it)
                }
                rightPopupView?.addComment(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            manager?.initPlayer()
        }
    }

    override fun againOnResume() {
        super.againOnResume()
        manager?.continuePlayer()
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getVerticalVideos(true, videoCode)
    }

    /**
     * <处理下拉刷新时，top header的变化>
     *     问题一：在view向下拖动的过程中，alpha值从1到0，如果此时设置visibility=GONE，会导致所有控件立即回弹到起始位置
     *     - 所以为了展示从[40,100]区间内的渐变，可以把中间的title起始alpha设置为0，然后拖动到40f时才慢慢显示
     *     - 拖动过程中，不要使用任何 .visibility = View.GONE
     *
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 10/1/22 8:08 下午
     * @version: v1.0
     */
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        if (binding.vp2VideoVertical.currentItem != 0) {
            return super.dispatchTouchEvent(event)
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.rawX
                startY = event.rawY
                totalOffset = 0
                isMoving = false
                mCurrentVelocity = 0
                mVelocityTracker?.addMovement(event)//速度追踪初始化
            }
            MotionEvent.ACTION_MOVE -> {

                mVelocityTracker?.addMovement(event)//速度追踪
                ////一秒内运动了多少个像素
                mVelocityTracker?.computeCurrentVelocity(1000, mMaximumVelocity.toFloat())
                val y_velocity = mVelocityTracker!!.yVelocity

                endX = event.rawX
                endY = event.rawY
                val distanceX: Float = endX - startX
                val distanceY: Float = endY - startY

                if (distanceY > distanceX && distanceY > 0 && !isRefreshing) {//下拉操作
                    if (y_velocity > 10000) {//快速滑动，普遍都是13000
                        if (!quickFlag) {
                            totalOffset = 100
                            binding.clayoutVerticalTop.offsetTopAndBottom(totalOffset)
                            quickFlag = true
                            VibrateUtils.vibrate(50)
                            binding.ibnVerticalTopClose.alpha = 0f
                            binding.ibnVerticalTopMore.alpha = 0f
                        }
                    } else {
                        if (distanceY > 100) {
                            val offset = ((distanceY - 100) / 100).toInt()
                            if (totalOffset <= 100) {
                                if (totalOffset <= 40) {
                                    val topAlpha = (40 - totalOffset).toFloat() / 40
                                    binding.ibnVerticalTopClose.alpha = topAlpha //可能不为0f
                                    binding.ibnVerticalTopMore.alpha = topAlpha
                                } else {
                                    binding.ibnVerticalTopClose.alpha = 0f
                                    binding.ibnVerticalTopMore.alpha = 0f
                                    val topAlpha = (totalOffset - 40).toFloat() / 60
                                    binding.txtVerticalTopTitle.alpha = topAlpha
                                }
                                totalOffset += offset
                                if (totalOffset >= 100) {
                                    VibrateUtils.vibrate(50)
                                }
                                binding.clayoutVerticalTop.offsetTopAndBottom(offset)
                            }
                        }
                    }
                    isMoving = true
                }
            }
            MotionEvent.ACTION_UP -> {
                if (isMoving && !isRefreshing) {
                    mVelocityTracker?.addMovement(event)//速度追踪

                    binding.txtVerticalTopTitle.alpha = 0f
                    val transAlpha =
                        ObjectAnimator.ofFloat(binding.txtVerticalTopTitle, "alpha", 1f, 0f)
                    transAlpha.run {
                        duration = 350
                        interpolator = LinearInterpolator()
                        start()
                    }
                    addRefreshAnimation(binding.clayoutVerticalTop, totalOffset.toFloat(), object :
                        Animator.AnimatorListener {
                        override fun onAnimationStart(animation: Animator) {
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            binding.ibnVerticalTopClose.alpha = 1f
                            binding.ibnVerticalTopMore.alpha = 1f
                            if (totalOffset >= 100) {
                                isRefreshing = true
                                binding.clayoutVerticalRefresh.visibility = View.VISIBLE
                                mViewModel.getVerticalVideos(true, videoCode)
                            }
                        }

                        override fun onAnimationCancel(animation: Animator) {
                        }

                        override fun onAnimationRepeat(animation: Animator) {
                        }
                    })
                    quickFlag = false
                }
            }

            MotionEvent.ACTION_CANCEL -> {
                mVelocityTracker?.clear()//清除状态，回到初始
            }
        }
        return super.dispatchTouchEvent(event)
    }

    /**
     * <弹出软键盘的功能，遇到问题颇多，总结一下>
     * - 实现功能：点击底部弹幕按钮，显示软键盘，同时缓缓弹出发送弹幕的popuwindow
     * - 实现过程：
     *      1，点击底部EditText，在监听方法里显示Popuwindow
     *      2，主动调用代码，弹出软键盘
     * - 遇到的问题：
     *      1，防止EditText有焦点，会反复弹出软键盘，必须先设置，这是基本条件，后续乱七八糟的都必须先基于这个
     *      window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
     *      2，底部EditText设置android:focusableInTouchMode="false"，让其第一次点击时就能触发点击方法
     *      3，设置android:focusableInTouchMode="false"后，activity的currentFocus获取不到任何view，此时
     *   点击Edittext时，是不会主动弹出软键盘的，当我们手动设置弹出软键盘功能时，如果传入的view是currentFocus时，
     *   也是不会弹出软键盘的，所以我设置了window.decorView
     *      4，如果设置android:focusableInTouchMode="true",此时底部Edittext是有焦点的，我们第一次点击它时，
     *   会自动弹出软键盘，但是不会监听到点击事件，此时如果我们监听了软键盘的弹出keyBoardShow()，并在该方法里显示
     *   popuwindow时，软键盘先弹出，然后popuwindow弹出，由于popuwindow里也有一个edittext，导致软键盘弹下去
     *   后又继续弹出来，此时传入的view是currentFocus还是window.decorView，都会出现这个问题
     *      5，弹出软键盘和popuwindow，使用延时加载，避免反复点击的卡顿
     *      6，这里popuwindow直接放置在中间位置，如果需要通过软键盘将它顶上去的话，需要整个布局实现Scroll相关的
     *   监听，同时在AndriodManifest.xml里设置相关属性，本例不使用
     *      7，主动设置偏移位置，将popuwindow放置在软键盘上面，使两者刚好重合，160是调试出来的位置
     *      showAtLocation(view, Gravity.CENTER, 0, 160)
     *      8，弹出动画，就是一个位移动画和一个渐隐动画
     *      9,软键盘要想弹起，就必须设置focus = true
     *
     * @author: dongyiming
     * @date: 12/4/22 6:19 PM
     * @version: v1.0
     */
    private var shortBottomDialog: ShortBottomDialog? = null

    private fun showBottomCommentWindow(showEmotion: Boolean, showet: Boolean) {
        if (shortBottomDialog == null) {
            shortBottomDialog = ShortBottomDialog(
                this,
                binding.editVertical.text.toString(),
                object : ShortBottomDialog.ShortPopuListener {
                    override fun openEmoji(view: View) {
                    }

                    override fun sendComment(comment: String) {
                        sendVideoComment(comment)
                    }

                    override fun dissmiss(comment: String, isSending: Boolean) {
                        Log.e("1mean", "isSending:$isSending")
                        if (isSending) {
                            binding.btnVerticalInputSend.post {
                                binding.editVertical.text = null
                                binding.editVertical.hint =
                                    resources.getString(R.string.str_hint_edit_short)
                                binding.btnVerticalInputSend.visibility = View.GONE
                            }
                        } else {
                            if (comment.isNotEmpty()) {
                                mHandler.post {
                                    val message =
                                        QqEmoticons.parseAndShowEmotion(
                                            this@ShortVideoActivity,
                                            comment
                                        )
                                    binding.editVertical.text =
                                        Editable.Factory.getInstance().newEditable(message)
                                    binding.btnVerticalInputSend.visibility = View.VISIBLE
                                }
                            } else {
                                binding.editVertical.text = null
                                binding.editVertical.hint =
                                    resources.getString(R.string.str_hint_edit_short)
                                binding.btnVerticalInputSend.visibility = View.GONE
                            }
                        }
                    }

                })
        }
        val builder = XPopup.Builder(this)
        builder.enableDrag(false)
            .animationDuration(100)//动画时长，不设置时长，就是默认的301ms，效果会很差
        // .popupAnimation(PopupAnimation.TranslateAlphaFromBottom)
        if (showEmotion) {
            builder.autoOpenSoftInput(false)
                .autoFocusEditText(false)
                .asCustom(shortBottomDialog)
                .show()
            shortBottomDialog?.postDelayed({
                shortBottomDialog!!.showEmotion()
            }, 300)
        } else {
            builder.autoOpenSoftInput(true)
                .autoFocusEditText(true)
                .asCustom(shortBottomDialog)
                .show()

//            if (showet) {
//                shortBottomDialog?.postDelayed({
//                    shortBottomDialog!!.showet()
//                }, 1000)
//            }
        }
    }

    private val keyBoardListener = object : SoftInputManager.OnSoftKeyBoardChangeListener {
        override fun keyBoardShow(height: Int) {
        }

        override fun keyBoardHide(height: Int) {
            Log.e("keyBoardManager", "keyBoardHide")
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
    private var currentPosition: Int = 0
    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageScrollStateChanged(state: Int) {
            when (state) {
                ViewPager2.SCROLL_STATE_IDLE -> {
                    mAdapter.startAnimation(currentPosition)
                }
                ViewPager2.SCROLL_STATE_DRAGGING -> {
                    mAdapter.pauseAnimation(currentPosition)
                }
                ViewPager2.SCROLL_STATE_SETTLING -> {
                }
            }
        }

        //界面初始化，第一次注册时也会被调用，所以要注意为null的判断
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            mAdapter.recyclerView?.let {

                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
                viewHolder?.coverShow(false, currentPosition)
            }

            currentPosition = position
            //开启右下角的旋转动画

            rightPopupView = null //切换到新页面时，不保存右侧评论弹出窗
            vh = null
            val hasEdit = binding.editVertical.text?.isNotEmpty()
            if (hasEdit == true) {
                binding.editVertical.post {
                    binding.editVertical.text = null
                    binding.btnVerticalInputSend.visibility = View.GONE
                    //binding.editVertical.isCursorVisible = false
                    shortBottomDialog?.clear()
                }
            }

            binding.vp2VideoVertical.post {

                val count = mAdapter.itemCount
                if (position == (count - 1) && hasMore) {
                    mViewModel.getVerticalVideos(false, videoCode)
                }

                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(position) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.let { vh ->
                        vh.init()
                        manager?.seekTo(position, vh.playerView)
                    }
                }
            }
        }
    }

    override fun isPlayingChanged(isPlaying: Boolean) {
        super.isPlayingChanged(isPlaying)
        if (isPlaying) {
            mAdapter.recyclerView?.let {
                val viewHolder =
                    it.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
                viewHolder?.coverShow(false, currentPosition)
            }
            mAdapter.startAnimation(currentPosition)
        } else {
            mAdapter.pauseAnimation(currentPosition)
        }
    }

    override fun onDoubleTap() {

    }

    override fun onSingleTap() {
        if (manager!!.isPlaying()) {
            manager?.pause()
        } else {
            manager?.continuePlayer()
        }
    }

    override fun updataVideoData(videoData: VideoData) {
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun collect(isAdd: Boolean, videoCode: Int) {
        mViewModel.updateCollect(isAdd, videoCode)
    }

    override fun updateUserAttention(userCode: Int) {
        mViewModel.updateAttention(userCode)
    }

    override fun onPause() {
        super.onPause()
        Log.e("1mean", "shortVideoActivity onPause")
        if (manager != null) {
            if (manager!!.isPlaying()) {
                manager?.pause()
            } else {
                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(binding.vp2VideoVertical.currentItem) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.init()
                }
            }
        }
    }

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                result.data?.let {
                    val userCode = it.getIntExtra("userCode", -1)
                    if (userCode > 0) {
                        mAdapter.recyclerView?.let {
                            val viewHolder =
                                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
                            viewHolder?.updateAttention(currentPosition, userCode)
                        }
                    }
                }
            }
        }

    override fun startUserActivity(userCode: Int) {

        val intent = Intent(this, UserInfoActivity::class.java).apply {
            putExtra("userCode", userCode)
        }
        requestLauncher.launch(intent)
    }

    private var vh: VideoPagerAdapter.MyViewHolder? = null
    override fun showComments(videoCode: Int, commentCounts: Int) {

        if (rightPopupView == null) {
            rightPopupView = ShortRightPopuWindow(this, videoCode, commentCounts, object :
                CommentWindowListener {
                override fun updateComments(commentCount: Int) {
                    mHandler.post {
                        mAdapter.recyclerView?.let {
                            vh =
                                it.findViewHolderForAdapterPosition(currentPosition) as VideoPagerAdapter.MyViewHolder
                            vh?.updateCommentCounts(currentPosition, commentCount)
                        }
                    }
                }
            })
        }
        XPopup.setShadowBgColor(ContextCompat.getColor(this, R.color.color_white_lucency))
        XPopup.Builder(this).setPopupCallback(object :
            XPopupCallback {
            override fun onCreated(popupView: BasePopupView?) {
            }

            override fun beforeShow(popupView: BasePopupView?) {
                binding.clayoutVerticalTop.visibility = View.GONE
                if (vh == null) {
                    mAdapter.recyclerView?.let {
                        vh =
                            it.findViewHolderForAdapterPosition(currentPosition) as VideoPagerAdapter.MyViewHolder
                    }
                }
                vh?.hidePlayerView()
            }

            override fun onShow(popupView: BasePopupView?) {
            }

            override fun onDismiss(popupView: BasePopupView?) {
                binding.clayoutVerticalTop.visibility = View.VISIBLE

            }

            override fun beforeDismiss(popupView: BasePopupView?) {

            }

            override fun onBackPressed(popupView: BasePopupView?): Boolean {
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
                if (vh == null) {
                    mAdapter.recyclerView?.let {
                        vh =
                            it.findViewHolderForAdapterPosition(currentPosition) as VideoPagerAdapter.MyViewHolder
                    }
                }
                vh?.playerChanged(value, percent, upOrLeft)
            }

            override fun onClickOutside(popupView: BasePopupView?) {
            }

        })
            .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
            .dismissOnTouchOutside(true)
            .animationDuration(600)
            .asCustom(rightPopupView)
            .show()
    }

    override fun addAttention(userCode: Int) {
        mViewModel.updateAttention(userCode)
    }

    override fun onkeyBack() {
        mVelocityTracker?.recycle()
        manager?.release()
        manager = null
        super.onkeyBack()
    }

    private fun sendVideoComment(content: String) {
        Log.e("1mean", "editStr: $content")
        val code = manager?.getCurrentVideoCode()
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

    override fun onDestroy() {
        super.onDestroy()
        mAdapter.clearAnimation()
    }
}