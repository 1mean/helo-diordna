package com.example.pandas.ui.fragment.main.short

import ShortManager
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.interaction.CommentWindowListener
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.databinding.FragmentVerticalVideoplayBinding
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.activity.UserInfoActivity
import com.example.pandas.ui.adapter.VideoPagerAdapter
import com.example.pandas.ui.view.dialog.ShortRightPopuWindow
import com.google.android.exoplayer2.util.Util
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.interfaces.XPopupCallback


/**
 * @description: 竖屏视频,使用Viewpager2来实现
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class ShortRecommendFragment :
    BaseFragment<ShortVideoViewModel, FragmentVerticalVideoplayBinding>(), ExoPlayerListener,
    VideoPagerAdapter.VerticalVideoListener {

    private var hasMore = false
    private var startActivity = false
    private val mAdapter: VideoPagerAdapter by lazy { VideoPagerAdapter(listener = this) }

    private var manager: ShortManager? = null
    var popupView: ShortRightPopuWindow? = null
    private val mHandler: Handler = Handler(Looper.getMainLooper())


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
                                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
                            viewHolder?.updateAttention(currentPosition, userCode)
                        }
                    }
                }
                manager?.continuePlayer()
            }
        }

    @SuppressLint("Recycle")
    override fun initView(savedInstanceState: Bundle?) {
        manager = ShortManager(mActivity, this)
        binding.vp2VideoVertical.run {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }
    }

    override fun createObserver() {
        mViewModel.verticalVideos.observe(this) {
            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        manager?.addMediaItems(it.listData)
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

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            manager?.initPlayer()
        }
    }

    override fun firstOnResume() {
        mViewModel.getVerticalVideos(true)
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

        //界面初始化，第一次注册时也会被调用，所以要注意为null的判断,而且肯定是在加载完数据，界面显示后才回调的
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if (currentPosition != position) {
                mAdapter.recyclerView?.let {
                    val viewHolder =
                        it.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
                    viewHolder?.coverShow(true, currentPosition)
                }
            }
            currentPosition = position
            //开启右下角的旋转动画

            popupView = null //切换到新页面时，不保存右侧评论弹出窗
            vh = null
            binding.vp2VideoVertical.post {

                val count = mAdapter.itemCount
                if (position == (count - 1) && hasMore) {
                    mViewModel.getVerticalVideos(false)
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

    override fun startUserActivity(userCode: Int) {

        val fragment = parentFragment
        if (fragment != null && fragment is ShortFragment) {
            (fragment as ShortFragment).isUpdate = false
        }

        if (manager!!.isPlaying()) {
            manager?.pause()
        }
        val intent = Intent(context, UserInfoActivity::class.java).apply {
            putExtra("userCode", userCode)
        }
        requestLauncher.launch(intent)
        startActivity = true
    }

    private var vh: VideoPagerAdapter.MyViewHolder? = null
    override fun showComments(videoCode: Int, commentCounts: Int) {

        if (popupView == null) {
            popupView = ShortRightPopuWindow(mActivity, videoCode, commentCounts, object :
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
        XPopup.setShadowBgColor(ContextCompat.getColor(mActivity, R.color.color_white_lucency))
        XPopup.Builder(mActivity).setPopupCallback(object : XPopupCallback {
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
            .animationDuration(600)
            .asCustom(popupView)
            .show()
//        popupView!!.setOnDragListener { v, event ->
//            val dialogHeight = popupView!!.height
//            true
//        }
    }

    override fun addAttention(userCode: Int) {
        mViewModel.updateAttention(userCode)
    }

    override fun onDestroy() {
        super.onDestroy()
        mAdapter.clearAnimation()
    }

    override fun onPause() {
        super.onPause()
        if (!startActivity) {
            manager?.release()
        }
        mAdapter.recyclerView?.let {
            val viewHolder =
                it.findViewHolderForAdapterPosition(currentPosition) as? VideoPagerAdapter.MyViewHolder
            viewHolder?.coverShow(true, currentPosition)
        }
    }

    override fun againOnResume() {
        super.againOnResume()
        val fragment = parentFragment
        if (fragment != null && fragment is ShortFragment) {
            (fragment as ShortFragment).isUpdate = true
        }

        startActivity = false
        mAdapter.recyclerView?.let {
            val viewHolder =
                it.findViewHolderForAdapterPosition(binding.vp2VideoVertical.currentItem) as? VideoPagerAdapter.MyViewHolder
            viewHolder?.let { vh ->
                vh.hidePlerView()
                manager?.againOnResume(vh.playerView, currentPosition)
            }
        }
    }
}