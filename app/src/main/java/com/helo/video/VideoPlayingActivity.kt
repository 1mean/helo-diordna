/*
package com.helo.video

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.android.android_sqlite.entity.PetVideo
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.manager.ExoMediaManager
import com.example.pandas.biz.manager.ExoMediaManager.ExoListener
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.databinding.ActivityVideoPlayBinding
import com.example.pandas.ui.adapter.VideoPagerAdapter
import com.example.pandas.ui.adapter.VideoPlayingAdapter
import com.example.pandas.ui.ext.getParcelableExtra
import kotlinx.coroutines.launch

*/
/**
 * @description: 最终的视频播放的统一入口
 * @author: dongyiming
 * @date: 9/16/24 PM10:44
 * @version: v1.0
 *//*

public class VideoPlayingActivity : BaseActivity<ShortVideoViewModel, ActivityVideoPlayBinding>(),
    ExoListener {

    private val mAdapter: VideoPlayingAdapter by lazy { VideoPlayingAdapter(listener = this) }
    private var exoMedia: ExoMediaManager? = null
    private var currentPosition: Int = 0
    private var petVideo: PetVideo? = null
    private var eyepetozerItem: EyepetozerItem? = null

    override fun initView(savedInstanceState: Bundle?) {

        petVideo = getParcelableExtra(intent, "PetVideo", PetVideo::class.java)
        eyepetozerItem = getParcelableExtra(intent, "EyepetozerItem", EyepetozerItem::class.java)

        exoMedia = ExoMediaManager(this, this, this)

        with(binding.vp2VideoPlay) {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = mAdapter
            offscreenPageLimit = 1
            registerOnPageChangeCallback(pageChangeCallback)
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.verticalVideosFlow.collect {
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
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getVerticalVideos(true)
    }

    override fun againOnResume() {
        super.againOnResume()
        exoMedia?.resumePlay()
    }

    override fun OnPlayerViewShow(isShow: Boolean) {
    }

    */
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
     *//*

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

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

            popupView = null //切换到新页面时，不保存右侧评论弹出窗
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

            binding.vp2VideoPlay.post {

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
}*/
