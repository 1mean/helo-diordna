package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import com.example.pandas.databinding.ActivityWanAndroidBinding
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.main.mine.WanAndroidFragment
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.launch

/**
 * @description: WanAndroidActivity
 * @author: dongyiming
 * @date: 8/22/24 11:53 PM
 * @version: v1.0
 */
public class WanAndroidActivity : BaseActivity<WanAndroidViewModel, ActivityWanAndroidBinding>() {

    private val mTitles = arrayListOf<String>()
    private val cardNos = arrayListOf<Int>()

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutWanTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnWanBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtWanTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    //binding.tabWan.indicatorColor = ContextCompat.getColor(this,lightViewColors[7])
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                    binding.ibtnWanSearch.setImageResource(R.mipmap.img_short_search_black)
                } else {
                    binding.ibtnWanSearch.setImageResource(R.mipmap.img_short_search_white)
                    //binding.tabWan.indicatorColor = ContextCompat.getColor(this,lightViewColors[it])
                    binding.ibnWanBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtWanTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        mViewModel.wxarticles()

        binding.ibtnWanSearch.setOnClickListener {
            startAnyActivity(this,WanSearchActivity::class.java)
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.wxarticles.collect {
                mTitles.clear()
                cardNos.clear()
                if (it.data.isNotEmpty()) {
                    mTitles.add("首页")
                    cardNos.add(0)
                    it.data.forEach { wxarticle ->
                        cardNos.add(wxarticle.id)
                        val name = wxarticle.name
                        mTitles.add(name)
                    }
                    binding.vp2Wanandroid.apply {
                        adapter = WanPagerAdapter(this@WanAndroidActivity)
                        offscreenPageLimit = mTitles.size
                        currentItem = 0
                        isSaveEnabled = false
                    }
                    binding.tabWan.setViewPager(binding.vp2Wanandroid, mTitles)
                }
            }
        }
    }

    private inner class WanPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = mTitles.size

        private val pageIds = mTitles.map { it.hashCode().toLong() }

        override fun createFragment(position: Int): Fragment {
            return WanAndroidFragment.newInstance(position, cardNos[position])
        }

        override fun getItemId(position: Int): Long = pageIds[position]

        override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)
    }
}