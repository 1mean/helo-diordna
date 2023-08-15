package com.example.pandas.ui.activity

import BestFragment
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.BannerViewModel
import com.example.pandas.databinding.ActivityBannerChildBinding
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * @description: BannerChildListActivity
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class BannerChildListActivity : BaseActivity<BannerViewModel, ActivityBannerChildBinding>() {

    private val tabTitles = arrayListOf("大熊猫", "萌宠", "娱乐", "飞鸟")

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2BannerList.apply {
            adapter = BannerPagerAdapter(this@BannerChildListActivity)
            offscreenPageLimit = tabTitles.size
            currentItem = 0
            isSaveEnabled = false
        }

        binding.tabBannerList.addOnTabSelectedListener(listener)

        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            binding.tabBannerList, binding.vp2BannerList, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        val title = intent.getStringExtra("title")
        binding.txtHistoryTitle.text = title

        binding.ibnHistoryBack.setOnClickListener {
            finish()
        }

        appViewModel.appColorType.value?.let {
            binding.clayoutHistoryTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.ibnHistoryBack.setImageResource(R.mipmap.img_top_leave)
                binding.txtHistoryTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
                binding.imgTopSearch.setImageResource(R.mipmap.img_topview_search)
            } else {
                binding.ibnHistoryBack.setImageResource(R.mipmap.img_top_leave_white)
                binding.txtHistoryTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                binding.imgTopSearch.setImageResource(R.mipmap.img_topview_search_white)
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
        }

        binding.clayoutTopSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
    }

    override fun createObserver() {

    }

    private val listener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            //使用setCurrentItem(tab.position, false)会出现滑动tab错乱
            binding.vp2BannerList.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
        }

        override fun onTabReselected(tab: TabLayout.Tab) {
        }
    }

    private inner class BannerPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = tabTitles.size

        private val pageIds = tabTitles.map { it.hashCode().toLong() }

        override fun createFragment(position: Int): Fragment =
            BestFragment.newInstance(position)

        override fun getItemId(position: Int): Long = pageIds[position]

        override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)
    }
}