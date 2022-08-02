package com.example.pandas.ui.ext;

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.helo_base.magic.ViewPagerHelper
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.helo_base.magic.commonnavigator.abs.IPagerIndicator
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.helo_base.magic.commonnavigator.indicators.LinePagerIndicator
import com.example.pandas.R
import com.example.pandas.bean.VideoInfo
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.startUserInfoActivity
import com.example.pandas.biz.manager.PlayerManager
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.activity.VideoPlayingActivity
import com.example.pandas.ui.adapter.VideoFragmentAdapter
import com.example.pandas.ui.fragment.VideoInfosFragment
import com.example.pandas.ui.view.VideoTabView
import com.google.android.exoplayer2.ui.DefaultTimeBar


fun VideoPlayingActivity.initViewPager() {

    binding.vpVideo.run {
        adapter = VideoFragmentAdapter(supportFragmentManager, lifecycle)
        offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
    }

    val commonNavigator = CommonNavigator(this)
    cnAdapter = object : CommonNavigatorAdapter() {

        override fun getCount(): Int = tabNames.size

        override fun getTitleView(context: Context?, index: Int): IPagerTitleView {

            val tabView = VideoTabView(this@initViewPager)
            tabView.setNormalColor(
                ContextCompat.getColor(
                    this@initViewPager,
                    R.color.color_tab_text
                )
            )
            tabView.setSelectedColor(
                ContextCompat.getColor(
                    this@initViewPager,
                    R.color.color_video_tab_selected
                )
            )
            if (index == 0) {
                tabView.hideNum()
            }
            tabView.setTextTitle(tabNames[index])
            tabView.setOnClickListener { binding.vpVideo.currentItem = index }
            return tabView
        }

        override fun getIndicator(context: Context?): IPagerIndicator {
            val linePagerIndicator = LinePagerIndicator(context)
            //补上margin的距离
            linePagerIndicator.xOffset = resources.getDimension(R.dimen.dimen_video_tabitem_margin)
            linePagerIndicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
            linePagerIndicator.setColors(
                ContextCompat.getColor(
                    this@initViewPager,
                    R.color.color_video_tab_selected
                )
            )
            return linePagerIndicator
        }
    }
    commonNavigator.adapter = cnAdapter
    binding.tabView.setNavigator(commonNavigator)
    ViewPagerHelper.bind(binding.tabView, binding.vpVideo)

//    tabNames.forEachIndexed { index, s ->
//        binding.tabView.addTab(binding.tabView.newTab(), index)
//        val tab = binding.tabView.getTabAt(index)
//        val view = View.inflate(this, R.layout.tb_item_videoplay, null)
//        val name = view?.findViewById<AppCompatTextView>(R.id.txt_tb_title_video)
//        val counts = view?.findViewById<AppCompatTextView>(R.id.txt_tb_comment_counts)
//        if (index == 1) {
//            counts?.visibility = View.VISIBLE
//            counts?.text = "2"
//        } else {
//            counts?.visibility = View.GONE
//        }
//        name?.text = s
//        tab?.customView = view
//    }
//
//    binding.vpVideo.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//
//        private var scrollState = ViewPager2.SCROLL_STATE_IDLE
//        private var previousScrollState = ViewPager2.SCROLL_STATE_IDLE
//
//        override fun onPageSelected(position: Int) {
//            super.onPageSelected(position)
//
//            if (binding.tabView != null && binding.tabView.getSelectedTabPosition() != position && position < binding.tabView.getTabCount()) {
//                // Select the tab, only updating the indicator if we're not being dragged/settled
//                // (since onPageScrolled will handle that).
//                val updateIndicator = (scrollState == ViewPager2.SCROLL_STATE_IDLE
//                        || (scrollState == ViewPager2.SCROLL_STATE_SETTLING
//                        && previousScrollState == ViewPager2.SCROLL_STATE_IDLE))
//                binding.tabView.selectTab(binding.tabView.getTabAt(position), updateIndicator)
//            }
//        }
//
//        override fun onPageScrolled(
//            position: Int,
//            positionOffset: Float,
//            positionOffsetPixels: Int
//        ) {
//            val updateText =
//                scrollState != ViewPager2.SCROLL_STATE_SETTLING || previousScrollState == ViewPager2.SCROLL_STATE_DRAGGING
//            val updateIndicator =
//                !(scrollState == ViewPager2.SCROLL_STATE_SETTLING && previousScrollState == ViewPager2.SCROLL_STATE_IDLE)
//            binding.tabView.setScrollPosition(position, positionOffset, updateText, updateIndicator)
//        }
//
//        override fun onPageScrollStateChanged(state: Int) {
//            previousScrollState = scrollState
//            scrollState = state
//        }
//    })
//
//    binding.tabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//        override fun onTabSelected(tab: TabLayout.Tab?) {
//            tab?.let {
//                it.customView?.let { view ->
//                    val title = view.findViewById<AppCompatTextView>(R.id.txt_tb_title_video)
//                    val paint = title.paint
//                    title.setTextColor(
//                        ContextCompat.getColor(
//                            this@initViewPager,
//                            R.color.color_video_tab_selected
//                        )
//                    )
//                }
//                binding.vpVideo.currentItem = it.position
//            }
//        }
//
//        override fun onTabUnselected(tab: TabLayout.Tab?) {
//            tab?.let {
//                it.customView?.let { view ->
//                    val title = view.findViewById<AppCompatTextView>(R.id.txt_tb_title_video)
//                    val paint = title.paint
//                    title.setTextColor(
//                        ContextCompat.getColor(
//                            this@initViewPager,
//                            R.color.color_tab_text
//                        )
//                    )
//                    title.background = null
//                }
//            }
//        }
//
//        override fun onTabReselected(tab: TabLayout.Tab?) {
//
//        }
//    })
}

fun VideoPlayingActivity.showTimeBar(timeBar: DefaultTimeBar?) {

    timeBar?.run {
        visibility = View.VISIBLE
        setDuration(PlayerManager.instance.duration())
        setBufferedPosition(PlayerManager.instance.bufferedPos())
        setPosition(PlayerManager.instance.currentPosition())
    }
}


fun VideoInfosFragment.initLikeContainer(videoInfo: VideoInfo) {

    Log.e("1mean", "videoCode: ${videoInfo.videoInfo.videoData}")
    val video = videoInfo.videoInfo

    var videoData = video.videoData
    videoData?.let {
        if (it.isLike) {
            isLike = true
            binding.imgLike.setImageResource(R.mipmap.img_like_pressed)
        } else {
            isLike = false
            binding.imgLike.setImageResource(R.mipmap.img_like_unpress)
        }
        if (it.likes > 0) {
            binding.txtVideoLike.text = it.likes.toString()
        } else {
            binding.txtVideoLike.text = "点赞"
        }
        if (it.isLove) {
            binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
        } else {
            binding.imgLove.setImageResource(R.mipmap.img_love_unpress)
        }

        if (it.isCollect) {
            binding.imgCollect.setImageResource(R.mipmap.img_collect_pressed)
        } else {
            binding.imgCollect.setImageResource(R.mipmap.img_collect_unpress)
        }
    }

    binding.itemLike.setOnClickListener {
        Log.e("1mean","isLike: $isLike")
        if (isLike) {
            binding.imgLike.setImageResource(R.mipmap.img_like_unpress)
            showToast("取消点赞")
            videoData?.let {
                it.likes -= 1
                it.isLike = false
                if (it.likes == 0) {
                    binding.txtVideoLike.text = "点赞"
                } else {
                    binding.txtVideoLike.text = it.likes.toString()
                }
                mViewModel.addOrUpdateVideoData(it)
            }
            isLike = false
        } else {
            setAnimation(binding.imgLike)
            binding.imgLike.setImageResource(R.mipmap.img_like_pressed)
            Log.e("1mean","videoData: $videoData")
            if (videoData == null) {
                videoData = VideoData(videoCode = video.code, likes = 1, isLike = true)
                binding.txtVideoLike.text = videoData!!.likes.toString()
                mViewModel.addOrUpdateVideoData(videoData!!)
            } else {
                videoData!!.likes += 1
                videoData!!.isLike = true
                binding.txtVideoLike.text = videoData!!.likes.toString()
                mViewModel.addOrUpdateVideoData(videoData!!)
            }
            showToast("点赞收到！")
            isLike = true
        }
    }
}

fun VideoInfosFragment.initUser(user: User) {

    user.headUrl?.let { url ->
        loadCircleImage(mActivity, url, binding.imgVideoInfoHead)
    }

    if (user.isVip == 1) {//是会员
        binding.txtVideoInfoName.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
        binding.txtVideoInfoName.setTextColor(
            ContextCompat.getColor(
                mActivity,
                R.color.color_name_txt
            )
        )
    }

    binding.txtVideoInfoName.text = user.userName
    binding.txtVideoInfoVideos.text =
        StringBuilder(user.videoCounts.toString()).append("视频").toString()

    binding.imgVideoInfoHead.setOnClickListener {
        startUserInfoActivity(mActivity, user.userCode)
    }
}

fun VideoInfosFragment.initVideo(video: PetVideo) {

    video.title?.let { title ->
        binding.txtVideoInfoTitle.text = title
    }

    binding.txtInfoTime.text = video.releaseTime
    binding.txtVideoInfoFans.text = "1粉丝"
    binding.txtInfoComment.text = " -"

    val playCounts: Int
    if (video.videoData == null) {
        playCounts = 1
        val vd = VideoData(videoCode = video.code, plays = playCounts)
        mViewModel.addOrUpdateVideoData(vd)
    } else {
        playCounts = video.videoData!!.plays + 1
        video.videoData!!.plays = playCounts
        mViewModel.addOrUpdateVideoData(video.videoData!!)
    }
    binding.txtInfoCounts.text = playCounts.toString()
}

fun setAnimation(view: View) {

    //view.animate().rotationX(360f).setDuration(300)

    val starScaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", 0.2f, 1f)
    starScaleYAnimator.duration = 350
    starScaleYAnimator.startDelay = 250
    starScaleYAnimator.interpolator = OvershootInterpolator(4f)

    val starScaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 0.2f, 1f)
    starScaleXAnimator.duration = 350
    starScaleXAnimator.startDelay = 250
    starScaleXAnimator.interpolator = OvershootInterpolator(4f)

    val rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, -20f, 0f)
    rotation.duration = 200
//    val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.1f, 1.3f, 1.1f, 1f)
//    val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f, 1.3f, 1.1f, 1f)
    val translationX = ObjectAnimator.ofFloat(view, "translationX", 0f, view.width * 0.2f, 0f)
    translationX.interpolator = LinearInterpolator()
    translationX.duration = 200
    val translationY = ObjectAnimator.ofFloat(
        view,
        "translationY",
        0f,
        -view.height * 0.2f,
        -view.height * 0.2f,
        -view.height * 0.2f,
        0f
    )
    translationY.interpolator = DecelerateInterpolator()
    translationY.duration = 200

    val set = AnimatorSet()
//    set.interpolator = AccelerateDecelerateInterpolator()
//    set.playTogether(rotation, scaleX, scaleY, translationX, translationY)
    set.playTogether(starScaleYAnimator, starScaleXAnimator, rotation, translationX, translationY)
    set.start()
}