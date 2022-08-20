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

    val video = videoInfo.videoInfo
    val videoData = video.videoData

    videoData?.let {
        if (it.isLike) {
            binding.imgLike.setImageResource(R.mipmap.img_like_pressed)
        } else {
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
        if (videoData != null && videoData.isLike) {
            binding.imgLike.setImageResource(R.mipmap.img_like_unpress)
            showToast("取消点赞")
            videoData.let {
                it.likes -= 1
                if (it.likes == 0) {
                    binding.txtVideoLike.text = "点赞"
                } else {
                    binding.txtVideoLike.text = it.likes.toString()
                }
                mViewModel.updateLike(it.videoCode, false)
            }
        } else {
            setAnimation(binding.imgLike)
            binding.imgLike.setImageResource(R.mipmap.img_like_pressed)
            if (videoData == null) {
                binding.txtVideoLike.text = "1"
            } else {
                binding.txtVideoLike.text = (videoData.likes + 1).toString()
            }
            mViewModel.updateLike(video.code, true)
            showToast("点赞收到！")
        }
    }

    binding.itemLove.setOnClickListener {
        if (videoData != null && videoData.isLove) {
            binding.imgLove.setImageResource(R.mipmap.img_love_unpress)
            mViewModel.updateLove(video.code, false)
        } else {
            binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
            mViewModel.updateLove(video.code, true)
            setAnimation(binding.imgLove)
        }
    }

    binding.itemCollect.setOnClickListener {
        Log.e("1mean", "videoData : $videoData")
        if (videoData != null && videoData.isCollect) {
            binding.imgCollect.setImageResource(R.mipmap.img_collect_unpress)
            mViewModel.updataCollect(video.code, false)
            mViewModel.deleteCollection(video.code, "默认收藏夹")
        } else {
            binding.imgCollect.setImageResource(R.mipmap.img_collect_pressed)
            mViewModel.updataCollect(video.code, true)
            mViewModel.addCollection(video.code, "默认收藏夹")
            setAnimation(binding.imgCollect)
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