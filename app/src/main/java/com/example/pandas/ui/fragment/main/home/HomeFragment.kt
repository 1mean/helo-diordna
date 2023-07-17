package com.example.pandas.ui.fragment.main.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import com.example.helo_base.magic.ViewPagerHelper
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.helo_base.magic.commonnavigator.abs.IPagerIndicator
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.helo_base.magic.commonnavigator.indicators.LinePagerIndicator
import com.example.helo_base.magic.commonnavigator.titles.ColorFlipPagerTitleView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.ext.loadLocalCircleImage
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.MessageActivity
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.activity.ShortVideoActivity2
import com.example.pandas.ui.adapter.HomePagerAdapter
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout


/**
 * @description: 首页
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<MainFragmentViewModel, FragmentHomeBinding>() {

    private val tabTitles = arrayListOf("熊猫", "推荐", "热门", "娱乐", "风景", "音乐")

    private var commonNavigator: CommonNavigator? = null

    private var verticalOffset: Int = 0 //Appbar偏移
    override fun lazyLoadTime(): Long = 0
    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity
    override fun initView(savedInstanceState: Bundle?) {

        binding.viewpager.run {
            adapter = HomePagerAdapter(mActivity,tabTitles, childFragmentManager, lifecycle)
            offscreenPageLimit = tabTitles.size
            setCurrentItem(1, false)
        }

        commonNavigator = CommonNavigator(mActivity)
        commonNavigator!!.isAdjustMode = true
        commonNavigator!!.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int = tabTitles.size
            private var indiColors = ContextCompat.getColor(
                context!!,
                R.color.color_home_tab_text_selected
            )

            private var titleColors = intArrayOf(
                ContextCompat.getColor(
                    context!!,
                    R.color.color_home_tab_text
                ), ContextCompat.getColor(
                    context!!,
                    R.color.color_home_tab_text_selected
                )
            )

            override fun updateIndicatorColors(color: Int) {
                indiColors = ContextCompat.getColor(context!!, color)
                notifyDataSetChanged()
            }

            override fun updateTextViewColors(colors: IntArray) {
                this.titleColors = colors
                notifyDataSetChanged()
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {

                val simplePagerTitleView = ColorFlipPagerTitleView(context)
                simplePagerTitleView.run {
                    text = tabTitles[index]
                    textSize = resources.getDimension(R.dimen.common_sz_5_dimens)
                    normalColor = titleColors[0]
                    selectedColor = titleColors[1]
                    setOnClickListener {
                        binding.viewpager.currentItem = index
                    }
                }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator {
                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.run {
                    mode = LinePagerIndicator.MODE_WRAP_CONTENT
                    lineHeight = ScreenUtil.dip2px(3f)
                    //lineWidth = ScreenUtil.dip2px(6f)
                    //roundRadius = ScreenUtil.dip2px(3f)
                    startInterpolator = AccelerateInterpolator()
                    endInterpolator = DecelerateInterpolator(0.9f)
                    setColors(indiColors)
                }
                return linePagerIndicator
            }
        }
        binding.tab.run {
            setNavigator(commonNavigator!!)
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

        binding.edit.setOnClickListener {
            startActivity(Intent(mActivity, NewSearchActivity::class.java))
        }

        binding.imgHead.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, ShortVideoActivity2::class.java))
        }
        binding.ibMessage.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, MessageActivity::class.java))
        }

        binding.ibMusic.setOnClickListener {

        }
        binding.bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->

            this.verticalOffset = verticalOffset

        })

        appViewModel.appColorType.value?.let {
            updateTopView(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun createObserver() {
        appViewModel.appColorType.observe(viewLifecycleOwner) {
            Log.e("1mean","9999")
            updateTopView(it)
        }
        loadImage(mActivity, AppInfos.HEAD_URL, binding.imgHead)
        loadLocalCircleImage(mActivity, R.mipmap.img_dota, binding.imgDark)

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

    override fun firstOnResume() {
    }

    override fun againOnResume() {
        super.againOnResume()
        if (AppInfos.APP_FLAG) {
            val color = SPUtils.getString(mActivity, AppInfos.THEME_COLOR)
            binding.tbHome.setBackgroundResource(R.color.red)
            StatusBarUtils.updataStatus(mActivity, false, true, R.color.red)
        }
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
                                AppInfos.bgColors[1]
                            )
                        )
                    )
                    adapter.updateIndicatorColors(AppInfos.bgColors[1])
                }
                binding.ibMessage.setImageResource(R.mipmap.img_home_message)
                binding.edit.setBackgroundResource(R.drawable.shape_home_search)
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
                binding.edit.setBackgroundResource(R.drawable.shape_home_search_white)
            }
            2 -> {//黑色
                binding.ibMessage.setImageResource(R.mipmap.img_home_message_gray)
                binding.edit.setBackgroundResource(R.drawable.shape_home_search_white)
            }
            else -> {
                binding.ibMessage.setImageResource(R.mipmap.img_home_message_white)
                binding.edit.setBackgroundResource(R.drawable.shape_home_search_white)
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