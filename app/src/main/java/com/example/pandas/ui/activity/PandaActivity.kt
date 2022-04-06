package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.ActivityPandasBinding
import com.example.pandas.ui.adapter.ActivityPandaAdapter
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: PandaActivity
 * @author: dongyiming
 * @date: 3/27/22 11:46 下午
 * @version: v1.0
 */
public class PandaActivity : BaseActivity<PandaViewModel, ActivityPandasBinding>() {

    private val tabTitles = arrayListOf("宝宝", "妈妈", "幼年班", "成年")

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)
        val title = intent.getStringExtra("title")
        binding.tbPandas.title = title
        binding.tbPandas.setNavigationOnClickListener {
            finish()
        }

        binding.vpPandas.apply {
            adapter = ActivityPandaAdapter(this@PandaActivity, title!!, tabTitles)
            offscreenPageLimit = OFFSCREEN_PAGE_LIMIT_DEFAULT
            currentItem = 0
            isSaveEnabled = false
        }

        binding.tlPandas.addOnTabSelectedListener(listener)

        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            binding.tlPandas, binding.vpPandas, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()


    }

    override fun createObserver() {
    }

    private val listener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            //使用setCurrentItem(tab.position, false)会出现滑动tab错乱
            binding.vpPandas.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
        }

        override fun onTabReselected(tab: TabLayout.Tab) {
        }
    }
}