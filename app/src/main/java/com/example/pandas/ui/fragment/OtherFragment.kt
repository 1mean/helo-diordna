package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.FragmentOtherBinding
import com.example.pandas.ui.view.TabEntity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import java.util.*

/**
 * @description: OtherFragment
 * @author: dongyiming
 * @date: 5/11/22 3:55 下午
 * @version: v1.0
 */
public class OtherFragment : BaseLazyFragment<EyepetozerViewModel, FragmentOtherBinding>() {

    private val tabTitles = arrayListOf("热门", "推荐")

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Eye.run {
            //Bug:这里如果使用FragmentStateAdapter(mActivity)，app在首页时就会触发其onResume()
            adapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
                override fun getItemCount(): Int = 2

                override fun createFragment(position: Int): Fragment {
                    if (position == 0) {
                        return EyepetozerFragment()
                    } else {
                        return EyeOtherFragment()
                    }
                }

            }
            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tabEye.currentTab = position
                }
            })
        }

        val mTabEntities = ArrayList<CustomTabEntity>()
        for (i in tabTitles.indices) {
            mTabEntities.add(TabEntity(tabTitles[i]))
        }
        binding.tabEye.run {
            setTabData(mTabEntities)
            currentTab = 0
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    binding.vp2Eye.setCurrentItem(position, false)
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