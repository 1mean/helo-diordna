package com.example.pandas.ui.fragment.main.short

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentShortVideoBinding
import com.example.pandas.ui.fragment.main.pet.CutePetFragment
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.GRAVITY_CENTER
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

/**
 * @description: PetChildFragment
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class ShortVideoFragment() :
    BaseFragment<MainFragmentViewModel, FragmentShortVideoBinding>() {

    private val tabTitles = arrayListOf("关注", "发现", "推荐")

    private val tabTitleColors
        get() = arrayOf(
            ContextCompat.getColor(mActivity, R.color.color_vertical_played),
            ContextCompat.getColor(mActivity, R.color.color_txt_short_tab_unselected),
            ContextCompat.getColor(mActivity, R.color.color_txt_short_tab_selected),
            ContextCompat.getColor(mActivity, R.color.white)
        )

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Short.run {
            offscreenPageLimit = tabTitles.size
            isSaveEnabled = false
            setCurrentItem(1, false)
            adapter = object : FragmentStateAdapter(this@ShortVideoFragment) {
                override fun getItemCount(): Int = 3

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> {
                            ShortVideoAttentionFragment()
                        }
                        1 -> {
                            ShortVideoListFragment()
                        }
                        else -> {
                            ShortFragment()
                        }
                    }
                }
            }
        }
        TabLayoutMediator(
            binding.tbShort, binding.vp2Short, false
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.tbShort.getTabAt(1)?.select()

        //获取TabLayout设置的字体颜色,包含tabTextColor及tabSelectedTextColor
        for (i in 0 until binding.tbShort.tabCount) {
            val tab: TabLayout.Tab = binding.tbShort.getTabAt(i)!!
            if (tab.customView == null || tab.customView !is TextView) {
                val tv = TextView(binding.tbShort.context)
                val tabStr = Objects.requireNonNull(tab.text).toString()
                tv.text = tabStr
                tv.gravity = GRAVITY_CENTER
                tv.textSize =
                    if (tab.isSelected) resources.getDimension(R.dimen.common_sz_6_dimens) else
                        resources.getDimension(R.dimen.common_sz_5_7_dimens)
                tv.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                if (tab.isSelected) {
                    tv.setTextColor(tabTitleColors[2])
                } else {
                    tv.setTextColor(tabTitleColors[1])
                }
                tab.customView = tv
            }
        }

        binding.tbShort.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val selectedIndex = binding.tbShort.selectedTabPosition
                val tv = (tab.customView as TextView?)!!

                if (selectedIndex == 2) {
                    StatusBarUtils.updataStatus(
                        mActivity,
                        false,
                        true,
                        R.color.color_white_lucency
                    )
                    tv.setTextColor(tabTitleColors[3])
                    binding.tbShort.setSelectedTabIndicatorColor(tabTitleColors[3])

                    for (index in 0 until (tabTitles.size - 1)) {
                        val tabView = binding.tbShort.getTabAt(index)!!
                        val title = (tabView.customView as TextView?)!!
                        title.setTextColor(tabTitleColors[0])
                        title.textSize = resources.getDimension(R.dimen.common_sz_5_7_dimens)
                    }
                    mViewModel.updateBottomBackground(3)
                } else {

                    for (index in 0 until tabTitles.size) {
                        if (index == selectedIndex) {
                            tv.setTextColor(tabTitleColors[2])
                        } else {
                            val tabView = binding.tbShort.getTabAt(index)!!
                            val title = (tabView.customView as TextView?)!!
                            title.setTextColor(tabTitleColors[1])
                            title.textSize = resources.getDimension(R.dimen.common_sz_5_7_dimens)
                        }
                    }

                    binding.tbShort.setSelectedTabIndicatorColor(tabTitleColors[2])
                    StatusBarUtils.updataStatus(mActivity, true, true, R.color.color_white_lucency)
                    mViewModel.updateBottomBackground(1)
                }
                tv.textSize = resources.getDimension(R.dimen.common_sz_6_dimens)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {

    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onPause() {
        super.onPause()
        if (binding.tbShort.selectedTabPosition == 2) {
            val nightMode = DarkModeUtils.getNightModel(mActivity)
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {//夜间模式
                StatusBarUtils.updataStatus(mActivity, false, true, R.color.color_white_lucency)
            } else {
                StatusBarUtils.updataStatus(mActivity, true, true, R.color.color_white_lucency)
            }
        }
        mViewModel.updateBottomBackground(1)
    }

    override fun onResume() {
        super.onResume()
        if (binding.tbShort.selectedTabPosition == 2) {
            StatusBarUtils.updataStatus(mActivity, false, true, R.color.color_white_lucency)
            mViewModel.updateBottomBackground(3)
        } else {
            mViewModel.updateBottomBackground(1)
        }
    }
}