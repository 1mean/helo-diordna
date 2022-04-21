package com.example.pandas.ui.fragment

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.MessageActivity
import com.example.pandas.ui.activity.SearchActivity
import com.example.pandas.ui.adapter.HomePagerAdapter
import com.example.pandas.ui.view.TabEntity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.google.android.material.tabs.TabLayout
import java.util.*


/**
 * @description: 首页
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>() {

    private val tabTitles = arrayListOf("大熊猫", "推荐", "热门", "最爱", "山水")

    override fun lazyLoadTime(): Long = 0
    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity
    override fun initView(savedInstanceState: Bundle?) {

        Glide.with(requireContext()).load(R.mipmap.jia).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgHead)

        binding.viewpager.run {
            adapter = HomePagerAdapter(tabTitles, requireActivity())
            offscreenPageLimit = tabTitles.size
            setCurrentItem(1, false)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tab.currentTab = position
                }
            })
        }

        val mTabEntities = ArrayList<CustomTabEntity>()
        for (i in tabTitles.indices) {
            mTabEntities.add(TabEntity(tabTitles[i]))
        }
        binding.tab.run {
            setTabData(mTabEntities)
            currentTab = 1
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    binding.viewpager.setCurrentItem(position, false)
                }

                override fun onTabReselect(position: Int) {
                }
            })
        }

        binding.edit.setOnClickListener {
            startActivity(Intent(mActivity, SearchActivity::class.java))
        }

        binding.imgHead.setOnClickListener {
            mViewModel.updateHeadState()
        }
        binding.ibMessage.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, MessageActivity::class.java))
        }

        //binding.bar.setExpanded(true,true)
    }

    private fun setTabTypeface(tab: TabLayout.Tab) {
        for (i in 0 until tab.view.childCount) {
            val tabViewChild: View = tab.view.getChildAt(i)
            if (tabViewChild is TextView) {
                (tabViewChild as TextView).typeface = Typeface.defaultFromStyle(Typeface.BOLD)
            }
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}