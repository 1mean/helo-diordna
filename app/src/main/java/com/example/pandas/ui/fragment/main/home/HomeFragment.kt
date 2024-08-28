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
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.android.base.utils.ScreenUtil
import com.android.base.custom_tablayout.ViewPagerHelper
import com.android.base.custom_tablayout.commonnavigator.CommonNavigator
import com.android.base.custom_tablayout.commonnavigator.abs.CommonNavigatorAdapter
import com.android.base.custom_tablayout.commonnavigator.abs.IPagerIndicator
import com.android.base.custom_tablayout.commonnavigator.abs.IPagerTitleView
import com.android.base.custom_tablayout.commonnavigator.indicators.LinePagerIndicator
import com.android.base.custom_tablayout.commonnavigator.titles.SimplePagerTitleView
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.*
import com.example.pandas.ui.adapter.HomePagerAdapter
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.ScaleTransitionPagerTitleView
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

    private var indicatorColor: Int? = null

    override fun initView(savedInstanceState: Bundle?) {

        binding.viewpager.run {
            adapter = HomePagerAdapter(mActivity, tabTitles, childFragmentManager, lifecycle)
            offscreenPageLimit = tabTitles.size
            setCurrentItem(1, false)
        }

        val status = appViewModel.appColorType.value
        Log.e("1mean", "status;$status")
        indicatorColor =
            if (status == null) viewColors[APP_COLOR_STATUS] else viewColors[status]

        binding.tab.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.color_bg_home))
        commonNavigator = CommonNavigator(mActivity)
        commonNavigator!!.isAdjustMode = false
        commonNavigator!!.isSkimOver = false
        commonNavigator!!.adapter = object : CommonNavigatorAdapter() {

            private var tabTitleColors = intArrayOf(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_home_tab_normal
                ), ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_home_tab_selected
                )
            )

            override fun updateIndicatorColors(color: Int) {
                indicatorColor = color
                notifyDataSetChanged()
            }

            override fun getCount(): Int {
                return tabTitles.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val simplePagerTitleView: SimplePagerTitleView =
                    ScaleTransitionPagerTitleView(context)//textSize为选中大小，mMinScale为未选中的缩放比例
                simplePagerTitleView.text = tabTitles[index]
                simplePagerTitleView.textSize = resources.getDimension(R.dimen.common_sz_6_dimens)
                simplePagerTitleView.normalColor = tabTitleColors[0]
                simplePagerTitleView.selectedColor = tabTitleColors[1]

                simplePagerTitleView.setOnClickListener {
                    binding.viewpager.currentItem = index
                }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator {

                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.run {
                    mode = LinePagerIndicator.MODE_WRAP_CONTENT
                    //mode = LinePagerIndicator.MODE_EXACTLY //设置具体值
                    //lineWidth = ScreenUtil.dip2px(20f)
                    lineHeight = ScreenUtil.dip2px(3f)
                    //roundRadius = ScreenUtil.dip2px(3f)
                    startInterpolator = AccelerateInterpolator()
                    endInterpolator = DecelerateInterpolator(0.9f)
                }
                indicatorColor?.let {
                    linePagerIndicator.setColors(
                        ContextCompat.getColor(
                            context!!,
                            indicatorColor!!
                        )
                    )
                }
                return linePagerIndicator
            }

            override fun getTitleWeight(context: Context?, index: Int): Float {
                return 0f
            }
        }
        binding.tab.run {
            setNavigator(commonNavigator!!)
            onPageSelected(1)
        }
        ViewPagerHelper.bind(binding.tab, binding.viewpager)

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
            //startAnyActivity(mActivity, BannerListActivity::class.java)
            val intent = Intent(mActivity, WanContentActivity::class.java)
            intent.putExtra("url", "https://www.bilibili.com/blackboard/era/LuoConcert01.html")
            startActivity(intent)
        }
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

//        lifecycleScope.launch {
//            val bitmap = getUserHeader(mActivity)
//            if (bitmap == null) {
//                loadCenterImage(mActivity, AppInfos.HEAD_URL, binding.imgHead)
//            } else {
//                loadCircleBitmap(mActivity, bitmap, binding.imgHead)
//            }
//        }


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
        mHandler.postDelayed(animationTask, search_interval)
    }

    private fun updateTopView(it: Int) {

        binding.bar.setBackgroundResource(viewColors[it])
        binding.clayoutTopHeader.setBackgroundResource(viewColors[it])
        if (it == 0) {
            commonNavigator?.let { navigator ->
                val adapter = navigator.adapter as CommonNavigatorAdapter
                adapter.updateIndicatorColors(viewColors[APP_COLOR_STATUS])
            }
            binding.ibMessage.setImageResource(R.mipmap.img_home_message)
            binding.clayoutHomeSearch.setBackgroundResource(R.drawable.shape_home_search)
        } else {
            binding.ibMessage.setImageResource(R.mipmap.img_home_message_white)
            binding.clayoutHomeSearch.setBackgroundResource(R.drawable.shape_home_search_white)
            commonNavigator?.let { navigator ->
                val adapter = navigator.adapter as CommonNavigatorAdapter
                adapter.updateIndicatorColors(viewColors[it])
            }
        }
    }
}