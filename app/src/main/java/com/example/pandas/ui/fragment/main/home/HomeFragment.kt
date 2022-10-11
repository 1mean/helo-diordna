package com.example.pandas.ui.fragment.main.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.example.helo_base.magic.ViewPagerHelper
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.helo_base.magic.commonnavigator.abs.IPagerIndicator
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.helo_base.magic.commonnavigator.indicators.LinePagerIndicator
import com.example.helo_base.magic.commonnavigator.titles.ColorFlipPagerTitleView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadLocalCircleImage
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.MessageActivity
import com.example.pandas.ui.activity.SearchActivity
import com.example.pandas.ui.activity.VerticalVideoActivity2
import com.example.pandas.ui.adapter.HomePagerAdapter
import com.example.pandas.ui.view.TabEntity
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.google.android.material.appbar.AppBarLayout
import java.util.*


/**
 * @description: 首页
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>() {

    private val tabTitles = arrayListOf("熊猫", "推荐", "热门", "最爱", "山水", "音乐")

    private var verticalOffset: Int = 0 //Appbar偏移
    override fun lazyLoadTime(): Long = 0
    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity
    override fun initView(savedInstanceState: Bundle?) {

        binding.viewpager.run {
            adapter = HomePagerAdapter(tabTitles, childFragmentManager, lifecycle)
            offscreenPageLimit = tabTitles.size
            setCurrentItem(1, false)
        }

        val commonNavigator = CommonNavigator(mActivity)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int = tabTitles.size

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {

                val simplePagerTitleView = ColorFlipPagerTitleView(context)
                simplePagerTitleView.run {
                    text = tabTitles[index]
                    textSize = resources.getDimension(R.dimen.common_sz_5_dimens)
                    normalColor = ContextCompat.getColor(
                        mActivity,
                        R.color.color_home_tab_text
                    )
                    selectedColor = ContextCompat.getColor(
                        mActivity,
                        R.color.color_home_tab_text_selected
                    )
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
                    setColors(
                        ContextCompat.getColor(
                            mActivity,
                            R.color.color_home_tab_text_selected
                        )
                    )
                }
                return linePagerIndicator
            }
        }
        binding.tab.setNavigator(commonNavigator)
        binding.tab.onPageSelected(1)
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
            startActivity(Intent(mActivity, SearchActivity::class.java))
        }

        binding.imgHead.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, VerticalVideoActivity2::class.java))
        }
        binding.ibMessage.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, MessageActivity::class.java))
        }

        binding.ibMusic.setOnClickListener {

        }
        binding.bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->

            this.verticalOffset = verticalOffset

        })

//        binding.bar.setExpanded(true,true)
    }

    fun getVerticalOffset(): Int = verticalOffset

    fun setSwipeRefreshEnable(isEnable: Boolean) {
    }

    override fun createObserver() {

        mViewModel.userInfo.observe(viewLifecycleOwner) {

            if (it != null) {
                it.headUrl?.let { url ->
                    loadCircleImage(mActivity, url, binding.imgHead)
                }
            }
        }
        loadLocalCircleImage(mActivity, R.mipmap.img_fanren_1, binding.imgDark)
    }

    override fun firstOnResume() {
        mViewModel.getUserInfo()
    }

    override fun againOnResume() {
        super.againOnResume()
        if (AppInfos.APP_FLAG) {
            val color = SPUtils.getString(mActivity, AppInfos.THEME_COLOR)
            binding.tbHome.setBackgroundResource(R.color.red)
            StatusBarUtils.updataStatus(mActivity, false, true, R.color.red)
        }
    }
}