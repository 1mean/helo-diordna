package com.example.pandas.ui.fragment.main.short

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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
import com.google.android.material.tabs.TabLayout
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

    private val tabTitles = arrayListOf("发现", "精选", "推荐")

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Short.run {
            offscreenPageLimit = tabTitles.size
            isSaveEnabled = false
            setCurrentItem(0, false)
            adapter = object : FragmentStateAdapter(this@ShortVideoFragment) {
                override fun getItemCount(): Int = 3

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> {
                            ShortVideoListFragment()
                        }
                        1 -> {
                            CutePetFragment()
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

        //获取TabLayout设置的字体颜色,包含tabTextColor及tabSelectedTextColor
        //获取TabLayout设置的字体颜色,包含tabTextColor及tabSelectedTextColor
        val colorStateList = binding.tbShort.tabTextColors
        for (i in 0 until binding.tbShort.tabCount) {
            val tab: TabLayout.Tab = binding.tbShort.getTabAt(i)!!
            if (tab.customView == null || tab.customView !is TextView) {
                val tv = TextView(binding.tbShort.context)
                val tabStr = Objects.requireNonNull(tab.text).toString()
                tv.setTextColor(colorStateList)
                tv.text = tabStr
                tv.textSize = if (tab.isSelected) 17f else 15f
                tab.customView = tv
            }
        }

        binding.tbShort.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tv = (tab.customView as TextView?)!!
                tv.setTextColor(ContextCompat.getColor(mActivity, R.color.black))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        //设置数字
        binding.tbShort.getTabAt(0)?.let { tab ->
            tab.orCreateBadge.apply {
                backgroundColor = ContextCompat.getColor(mActivity, R.color.red500)
                maxCharacterCount = 3
                number = 99
                badgeTextColor = Color.WHITE
            }
        }
        //设置红点
        binding.tbShort.getTabAt(2)?.let { tab ->
            tab.orCreateBadge.backgroundColor = ContextCompat.getColor(mActivity, R.color.orange)
        }

        binding.vp2Short.registerOnPageChangeCallback(object : OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("lidandan3", "onPageSelected position: $position")
                if (position == 2) {
                    for (i in 0 until binding.tbShort.tabCount){
                        val tab = binding.tbShort.getTabAt(i)!!
                        val tv = (tab.customView as TextView?)!!
                        tv.setTextColor(ContextCompat.getColor(mActivity, R.color.white))
                    }
                    mViewModel.updateBottomBackground(true)
                } else {

                    for (i in 0 until binding.tbShort.tabCount){
                        val tab = binding.tbShort.getTabAt(i)!!
                        val tv = (tab.customView as TextView?)!!
                        tv.setTextColor(ContextCompat.getColor(mActivity, R.color.black))
                    }
                    mViewModel.updateBottomBackground(false)
                }
            }
        })

    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}