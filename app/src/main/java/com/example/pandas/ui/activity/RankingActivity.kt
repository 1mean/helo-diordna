package com.example.pandas.ui.activity

import RankingChildFragment
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.RankViewModel
import com.example.pandas.databinding.ActivityRankingBinding
import com.example.pandas.ui.adapter.VideoListAdapter
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 播放榜单
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class RankingActivity : BaseActivity<RankViewModel, ActivityRankingBinding>() {

    private val tabTitles = arrayListOf("全部")

    override fun initView(savedInstanceState: Bundle?) {

        val status = appViewModel.appColorType.value
        if (status == null || status == 0) {
            StatusBarUtils.setStatusBarMode(this, true, R.color.color_white_lucency)
            binding.clayoutPlayTop.setBackgroundResource(R.color.white)
            binding.ibnPlayBack.setImageResource(R.mipmap.img_topview_back)
            binding.tabRanking.setTabTextColors(
                ContextCompat.getColor(this, R.color.color_tablayout_unselect_panda),
                ContextCompat.getColor(this, viewColors[APP_COLOR_STATUS])
            )
            binding.tabRanking.setSelectedTabIndicatorColor(
                ContextCompat.getColor(this, viewColors[APP_COLOR_STATUS])
            )
        } else {
            StatusBarUtils.setStatusBarMode(this, false, viewColors[status])
            binding.clayoutPlayTop.setBackgroundResource(viewColors[status])
            binding.ibnPlayBack.setImageResource(R.mipmap.img_topview_back_white)
            binding.tabRanking.setTabTextColors(
                ContextCompat.getColor(this, R.color.color_vertical_played),
                ContextCompat.getColor(this, R.color.white)
            )
            binding.tabRanking.setSelectedTabIndicatorColor(
                ContextCompat.getColor(this, R.color.white)
            )
        }

        binding.vp2Ranking.apply {
            adapter = RankingPagerAdapter(this@RankingActivity)
            offscreenPageLimit = tabTitles.size
            currentItem = 0
            isSaveEnabled = false
        }

        binding.tabRanking.addOnTabSelectedListener(listener)

        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            binding.tabRanking, binding.vp2Ranking, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.ibnPlayBack.setOnClickListener {
            finish()
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
            binding.vp2Ranking.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
        }

        override fun onTabReselected(tab: TabLayout.Tab) {
        }
    }

    private inner class RankingPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = tabTitles.size

        private val pageIds = tabTitles.map { it.hashCode().toLong() }

        override fun createFragment(position: Int): Fragment =
            RankingChildFragment.newInstance(position)

        override fun getItemId(position: Int): Long = pageIds[position]

        override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)
    }
}