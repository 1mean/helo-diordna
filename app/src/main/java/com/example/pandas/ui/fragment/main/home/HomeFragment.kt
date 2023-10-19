package com.example.pandas.ui.fragment.main.home

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.example.helo_base.magic.UIUtil
import com.example.helo_base.magic.ViewPagerHelper
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.helo_base.magic.commonnavigator.abs.IPagerIndicator
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.helo_base.magic.commonnavigator.indicators.LinePagerIndicator
import com.example.helo_base.magic.commonnavigator.titles.SimplePagerTitleView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.BannerListActivity
import com.example.pandas.ui.activity.MessageActivity
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.activity.ShortVideoActivity2
import com.example.pandas.ui.adapter.HomePagerAdapter
import com.example.pandas.ui.ext.addAlphaAnimation
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.view.ScaleTransitionPagerTitleView
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * @description: 首页
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<MainFragmentViewModel, FragmentHomeBinding>() {

    private val tabTitles = arrayListOf("大熊猫", "推荐", "热门", "娱乐", "风景", "音乐")

    private var commonNavigator: CommonNavigator? = null
    private val search_interval = 3000L
    private var alphaAnimator1: ObjectAnimator? = null
    private var animatorSet: AnimatorSet? = null

    private val searchInfos
        get() = arrayOf("大熊猫和花", "刘亦菲", "快乐足球四天王")
    private var searchIndex = 0
    private val mHandler = Handler(Looper.getMainLooper())

    private var verticalOffset: Int = 0 //Appbar偏移
    override fun lazyLoadTime(): Long = 0
    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity
    override fun initView(savedInstanceState: Bundle?) {

        binding.viewpager.run {
            adapter = HomePagerAdapter(mActivity, tabTitles, childFragmentManager, lifecycle)
            offscreenPageLimit = tabTitles.size
            setCurrentItem(1, false)
        }

//        commonNavigator = CommonNavigator(mActivity)
//        commonNavigator!!.isAdjustMode = true
//        commonNavigator!!.adapter = object : CommonNavigatorAdapter() {
//
//            override fun getCount(): Int = tabTitles.size
//            private var indiColors = ContextCompat.getColor(
//                context!!,
//                R.color.color_bg_grey
//            )
//
//            private var titleColors = intArrayOf(
//                ContextCompat.getColor(
//                    context!!,
//                    R.color.color_home_tab_text
//                ), ContextCompat.getColor(
//                    context!!,
//                    R.color.color_bg_grey
//                )
//            )
//
//            override fun updateIndicatorColors(color: Int) {
//                indiColors = ContextCompat.getColor(context!!, color)
//                notifyDataSetChanged()
//            }
//
//            override fun updateTextViewColors(colors: IntArray) {
//                this.titleColors = colors
//                notifyDataSetChanged()
//            }
//
//            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
//
//                val simplePagerTitleView = ColorFlipPagerTitleView(context)
//                simplePagerTitleView.run {
//                    text = tabTitles[index]
//                    textSize = resources.getDimension(R.dimen.common_sz_5_dimens)
//                    normalColor = titleColors[0]
//                    selectedColor = titleColors[1]
//                    setOnClickListener {
//                        binding.viewpager.currentItem = index
//                    }
//                }
//                return simplePagerTitleView
//            }
//
//            override fun getIndicator(context: Context?): IPagerIndicator {
//                val linePagerIndicator = LinePagerIndicator(context)
//                linePagerIndicator.run {
//                    mode = LinePagerIndicator.MODE_WRAP_CONTENT
//                    lineHeight = ScreenUtil.dip2px(3f)
//                    //lineWidth = ScreenUtil.dip2px(6f)
//                    //roundRadius = ScreenUtil.dip2px(3f)
//                    startInterpolator = AccelerateInterpolator()
//                    endInterpolator = DecelerateInterpolator(0.9f)
//                    setColors(indiColors)
//                }
//                return linePagerIndicator
//            }
//        }
//        binding.tab.run {
//            setNavigator(commonNavigator!!)
//            onPageSelected(1)
//        }
//        ViewPagerHelper.bind(binding.tab, binding.viewpager)

        binding.tab.setBackgroundColor(Color.WHITE)
        val commonNavigator = CommonNavigator(mActivity)
        commonNavigator.isAdjustMode = false
        commonNavigator.isSkimOver = false
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            private var indiColors = ContextCompat.getColor(
                context!!,
                R.color.color_bg_sky
            )

            private var titleColors = intArrayOf(
                ContextCompat.getColor(
                    context!!,
                    R.color.color_home_tab_text
                ), ContextCompat.getColor(
                    context!!,
                    R.color.color_bg_sky
                )
            )

            override fun getCount(): Int {
                return tabTitles.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val simplePagerTitleView: SimplePagerTitleView =
                    ScaleTransitionPagerTitleView(context)//textSize为选中大小，mMinScale为未选中的缩放比例
                simplePagerTitleView.text = tabTitles[index]
                simplePagerTitleView.textSize = resources.getDimension(R.dimen.common_sz_6_dimens)
                simplePagerTitleView.normalColor = titleColors[0]
                simplePagerTitleView.selectedColor = titleColors[1]
                simplePagerTitleView.setOnClickListener {
                    binding.viewpager.currentItem = index
                }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator {

                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.run {
                    mode = LinePagerIndicator.MODE_EXACTLY
                    lineHeight = ScreenUtil.dip2px(2f)
                    lineWidth = ScreenUtil.dip2px(20f)
                    roundRadius = ScreenUtil.dip2px(3f)
                    startInterpolator = AccelerateInterpolator()
                    endInterpolator = DecelerateInterpolator(0.9f)
                    setColors(indiColors)
                }
                return linePagerIndicator

//                val indicator = LinePagerIndicator(context)
//                indicator.startInterpolator = AccelerateInterpolator()
//                indicator.endInterpolator = DecelerateInterpolator(1.6f)
//                indicator.yOffset = UIUtil.dip2px(mActivity, 39.0).toFloat()
//                indicator.lineHeight = UIUtil.dip2px(mActivity, 1.0).toFloat()
//                indicator.setColors(Color.parseColor("#f57c00"))
//                return indicator
            }

            override fun getTitleWeight(context: Context?, index: Int): Float {
                return 0f
            }
        }
        //binding.tab.setNavigator(commonNavigator)
        binding.tab.run {
            setNavigator(commonNavigator)
            onPageSelected(1)
        }
        ViewPagerHelper.bind(binding.tab, binding.viewpager)

//        val mTabEntities = ArrayList<CustomTabEntity>()
//        for (i in tabTitles.indices) {
//            mTabEntities.add(TabEntity(tabTitles[i]))
//        }
//        binding.tab.run {
//            setTabData(mTabEntities)
//            currentTab = 1
//            setOnTabSelectListener(object : OnTabSelectListener {
//                override fun onTabSelect(position: Int) {
//                    binding.viewpager.setCurrentItem(position, false)
//                }
//
//                override fun onTabReselect(position: Int) {
//                }
//            })
//        }

        binding.clayoutHomeSearch.setOnClickListener {
            val intent = Intent(mActivity, NewSearchActivity::class.java)
                .putExtra("search", binding.txtHomeSearch.text.toString())
            startActivity(intent)
        }

        binding.imgHead.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, ShortVideoActivity2::class.java))
        }
        binding.ibMessage.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, MessageActivity::class.java))
        }

        binding.bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            this.verticalOffset = verticalOffset
        })

        appViewModel.appColorType.value?.let {
            updateTopView(it)
        }

        binding.clayoutHomeTopMore.setOnClickListener {
            startAnyActivity(mActivity, BannerListActivity::class.java)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun createObserver() {

        appViewModel.headerUpdate.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    val bitmap = getUserHeader(mActivity)
                    if (bitmap != null) {
                        loadCircleBitmap(mActivity, bitmap, binding.imgHead)
                    }
                }
            }
        }


        appViewModel.appColorType.observe(viewLifecycleOwner) {
            updateTopView(it)
        }

        mViewModel.refreshPosition.observe(viewLifecycleOwner) { position ->
            Log.e("doubleCilik", "HomeFragment: $position")
            if (position == 0) {
                val currentItem = binding.viewpager.currentItem
                val fragments = childFragmentManager.fragments
                fragments.forEach {
                    when (currentItem) {
                        0 -> {
                            if (it is PandaFragment) {
                                (it as PandaFragment).refresh()
                            }
                        }
                        1 -> {
                            if (it is RecommendFragment) {
                                (it as RecommendFragment).refresh()
                            }
                        }
                        2 -> {
                            if (it is HotFragment) {
                                (it as HotFragment).refresh()
                            }
                        }
                        3 -> {
                            if (it is EntertainmentFragment) {
                                (it as EntertainmentFragment).refresh()
                            }
                        }
                        4 -> {
                            if (it is LandscapeFragment) {
                                (it as LandscapeFragment).refresh()
                            }
                        }
                        5 -> {
                            if (it is MusicFragment) {
                                (it as MusicFragment).refresh()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.e("1mean", "HomeFragment onPause()")

        if (alphaAnimator1 != null && alphaAnimator1!!.isRunning) {
            alphaAnimator1!!.cancel()
            alphaAnimator1 = null
        }

        if (animatorSet != null && animatorSet!!.isRunning) {
            animatorSet!!.cancel()
            animatorSet = null
        }

        mHandler.removeCallbacks(animationTask)

        binding.txtHomeSearch.alpha = 1.0f
        binding.txtHomeSearch.scaleX = 1.0f
        binding.txtHomeSearch.scaleY = 1.0f
        //binding.txtHomeSearch.clearAnimation()
    }

    private fun coroutineAnimation(
        time: Int,
        scope: CoroutineScope,
        onStart: ((Int) -> Unit)? = null,
        onFinish: (() -> Unit)? = null
    ): Job {
        return flow<Int> {
            emit(1)
        }
            .flowOn(Dispatchers.Main)
            .onStart {
                onStart?.invoke(2)
            }
            .onCompletion { onFinish?.invoke() }
            .launchIn(scope)
    }


    override fun firstOnResume() {

        lifecycleScope.launch {
            val bitmap = getUserHeader(mActivity)
            if (bitmap == null) {
                loadCenterImage(mActivity, AppInfos.HEAD_URL, binding.imgHead)
            } else {
                loadCircleBitmap(mActivity, bitmap, binding.imgHead)
            }
        }


        val jon2 = coroutineAnimation(0, lifecycleScope,
            onStart = {}, onFinish = {})

        mHandler.postDelayed(animationTask, search_interval)
    }

    private fun animationFun1() {
        alphaAnimator1 = ObjectAnimator.ofFloat(binding.txtHomeSearch, "alpha", 1f, 0f)
        alphaAnimator1!!.run {
            duration = 500
            start()
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    animationFun2()
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })
        }
    }

    private fun increaseIndex() {
        searchIndex += 1
        if (searchIndex > searchInfos.size - 1) {
            searchIndex = 0
        }
    }

    private fun animationFun2() {
        increaseIndex()
        binding.txtHomeSearch.text = searchInfos[searchIndex]
        val alphaAnimator1 =
            ObjectAnimator.ofFloat(binding.txtHomeSearch, "alpha", 0f, 1f)
        val starScaleYAnimator =
            ObjectAnimator.ofFloat(binding.txtHomeSearch, "scaleY", 0f, 1f)

        val starScaleXAnimator =
            ObjectAnimator.ofFloat(binding.txtHomeSearch, "scaleX", 0f, 1f)
        animatorSet = AnimatorSet()
        animatorSet!!.run {
            play(starScaleXAnimator).with(starScaleYAnimator).with(alphaAnimator1)
            duration = 1000
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    increaseIndex()
                    mHandler.postDelayed(animationTask, search_interval)
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })
            start()
        }
    }

    private val animationTask = Runnable {
        animationFun1()
    }

    override fun againOnResume() {
        super.againOnResume()
        if (AppInfos.APP_FLAG) {
            val color = SPUtils.getString(mActivity, AppInfos.THEME_COLOR)
            binding.tbHome.setBackgroundResource(R.color.red)
            StatusBarUtils.updataStatus(mActivity, false, true, R.color.red)
        }
        mHandler.postDelayed(animationTask, search_interval)
    }

    private fun updateTopView(it: Int) {
        binding.bar.setBackgroundResource(AppInfos.bgColors[it])
        binding.clayoutTopHeader.setBackgroundResource(AppInfos.bgColors[it])
        when (it) {
            0 -> {
                commonNavigator?.let { navigator ->
                    val adapter = navigator.adapter as CommonNavigatorAdapter
                    adapter.updateTextViewColors(
                        intArrayOf(
                            ContextCompat.getColor(
                                context!!,
                                R.color.color_home_tab_text
                            ), ContextCompat.getColor(
                                context!!,
                                AppInfos.bgColors[5]
                            )
                        )
                    )
                    adapter.updateIndicatorColors(AppInfos.bgColors[5])
                }
                binding.ibMessage.setImageResource(R.mipmap.img_home_message)
                binding.clayoutHomeSearch.setBackgroundResource(R.drawable.shape_home_search)
            }
            1 -> {
                commonNavigator?.let { navigator ->
                    val adapter = navigator.adapter as CommonNavigatorAdapter
                    adapter.updateTextViewColors(
                        intArrayOf(
                            ContextCompat.getColor(
                                context!!,
                                R.color.color_home_tab_text
                            ), ContextCompat.getColor(
                                context!!,
                                AppInfos.bgColors[it]
                            )
                        )
                    )
                    adapter.updateIndicatorColors(AppInfos.bgColors[it])
                }
                binding.ibMessage.setImageResource(R.mipmap.img_home_message_white)
                binding.clayoutHomeSearch.setBackgroundResource(R.drawable.shape_home_search_white)
            }
            2 -> {//黑色
                binding.ibMessage.setImageResource(R.mipmap.img_home_message_gray)
                binding.clayoutHomeSearch.setBackgroundResource(R.drawable.shape_home_search_white)
            }
            else -> {
                binding.ibMessage.setImageResource(R.mipmap.img_home_message_white)
                binding.clayoutHomeSearch.setBackgroundResource(R.drawable.shape_home_search_white)
                commonNavigator?.let { navigator ->
                    val adapter = navigator.adapter as CommonNavigatorAdapter
                    adapter.updateTextViewColors(
                        intArrayOf(
                            ContextCompat.getColor(
                                context!!,
                                R.color.color_home_tab_text
                            ), ContextCompat.getColor(
                                context!!,
                                AppInfos.bgColors[it]
                            )
                        )
                    )
                    adapter.updateIndicatorColors(AppInfos.bgColors[it])
                }
            }
        }
    }
}