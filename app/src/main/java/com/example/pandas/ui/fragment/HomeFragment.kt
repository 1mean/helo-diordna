package com.example.pandas.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadLocalCircleImage
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.MessageActivity
import com.example.pandas.ui.activity.SearchActivity
import com.example.pandas.ui.adapter.HomePagerAdapter
import com.example.pandas.ui.view.TabEntity
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import java.util.*


/**
 * @description: 首页
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>() {

    private val tabTitles = arrayListOf("分类", "推荐", "热门", "最爱", "山水", "熊猫")

    override fun lazyLoadTime(): Long = 0
    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity
    override fun initView(savedInstanceState: Bundle?) {

        binding.viewpager.run {
            adapter = HomePagerAdapter(tabTitles, childFragmentManager, lifecycle)
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

        binding.rlayoutHomeMusic.setOnClickListener {

        }

        //binding.bar.setExpanded(true,true)
    }

    override fun createObserver() {

        mViewModel.userInfo.observe(viewLifecycleOwner) {

            it.headUrl?.let { url ->
                loadCircleImage(mActivity, url, binding.imgHead)
            }
        }
        loadLocalCircleImage(mActivity,R.mipmap.img_fanren_1,binding.imgDark)
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