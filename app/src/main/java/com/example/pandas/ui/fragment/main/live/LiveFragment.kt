package com.example.pandas.ui.fragment.main.live

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.LiveViewModel
import com.example.pandas.databinding.FragmentLivingBinding
import com.example.pandas.ui.fragment.main.eyepetozer.EyeOtherFragment
import com.example.pandas.ui.fragment.main.eyepetozer.EyepetozerFragment
import com.example.pandas.ui.view.TabEntity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import java.util.ArrayList

/**
 * @description: 动态
 * @author: dongyiming
 * @date: 10/10/22 10:17 上午
 * @version: v1.0
 */
public class LiveFragment : BaseLazyFragment<LiveViewModel, FragmentLivingBinding>() {

    private val tabTitles = arrayListOf("综合","视频")

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Living.run {
            //Bug:这里如果使用FragmentStateAdapter(mActivity)，app在首页时就会触发其onResume()
            adapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
                override fun getItemCount(): Int = 2

                override fun createFragment(position: Int): Fragment {
                    if (position == 0) {
                        return LiveVideoFragment()
                    } else {
                        return EyepetozerFragment()
                    }
                }
            }
            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tabLiving.currentTab = position
                }
            })
        }

        val mTabEntities = ArrayList<CustomTabEntity>()
        for (i in tabTitles.indices) {
            mTabEntities.add(TabEntity(tabTitles[i]))
        }
        binding.tabLiving.run {
            setTabData(mTabEntities)
            currentTab = 0
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    binding.vp2Living.setCurrentItem(position, false)
                }

                override fun onTabReselect(position: Int) {
                }
            })
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}