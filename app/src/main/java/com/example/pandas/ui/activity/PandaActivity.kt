package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.example.pandas.R
import com.example.pandas.app.getHehuaBanner
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadLayoutBackGround
import com.example.pandas.biz.interaction.PagerChangedListener
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.ActivityCmBannerBinding
import com.example.pandas.ui.adapter.ActivityPandaAdapter
import com.example.pandas.ui.adapter.CommonBannerAdapter
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: PandaActivity
 * @author: dongyiming
 * @date: 3/27/22 11:46 下午
 * @version: v1.0
 */
public class PandaActivity : BaseActivity<PandaViewModel, ActivityCmBannerBinding>() {

    private val tabTitles = arrayListOf("视频", "熊猫宝宝", "熊猫妈妈", "幼年伙伴")

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
        val title = intent.getStringExtra("title")
        binding.txtCmBannerTitle.text = title

        binding.btnCmBannerBack.setOnClickListener { finish() }

        binding.vp2CmBanner.apply {
            adapter = ActivityPandaAdapter(this@PandaActivity, title!!, tabTitles)
            offscreenPageLimit = tabTitles.size
            currentItem = 0
            isSaveEnabled = false
        }

        binding.tabCmBanner.addOnTabSelectedListener(listener)

        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            binding.tabCmBanner, binding.vp2CmBanner, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        val list = getHehuaBanner()
        val adapter = CommonBannerAdapter(list)
        binding.bannerCmTop.setLifecycleRegistry(lifecycle)
            .setPagePadding(60, 60, 36)
            .addPageChangeListener(object : PagerChangedListener {
                override fun onChange(position: Int) {
                    Log.e("PandaActivity", "position: $position")
                    list[position].cover?.let {
                        loadLayoutBackGround(this@PandaActivity, it, binding.imgBgBanner)
                    }
                }
            }).setAdapter(adapter)
            .setAutoPlayed(true)

        binding.barCmBanner.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                binding.txtCmBannerTitle.visibility = View.GONE
                binding.btnCmBannerLeft.visibility = View.GONE
                binding.btnCmBannerBack.visibility = View.VISIBLE
                binding.collapsCmBanner.contentScrim = null
                Log.e("1mean", "展开状态")
            } else if (Math.abs(verticalOffset) >= 0.6 * appBarLayout.totalScrollRange) {
                Log.e("1mean", "折叠状态")
                if (!binding.txtCmBannerTitle.isVisible) {
                    binding.txtCmBannerTitle.visibility = View.VISIBLE
                    binding.btnCmBannerLeft.visibility = View.VISIBLE
                    binding.txtCmBannerTitle.text = "大熊猫和花"
                }
                binding.btnCmBannerBack.visibility = View.GONE
                binding.collapsCmBanner.setContentScrimResource(R.color.color_bg_banner_top)
            } else {
                binding.txtCmBannerTitle.visibility = View.GONE
                binding.btnCmBannerLeft.visibility = View.GONE
                binding.btnCmBannerBack.visibility = View.VISIBLE
                binding.collapsCmBanner.contentScrim = null
                Log.e("1mean", "中间状态")
            }
        })
        binding.btnCmBannerLeft.setOnClickListener {
            finish()
        }
    }

    override fun createObserver() {

//        mViewModel.banner.observe(this) {
//            if (it.isNotEmpty()) {
//                //避免重复创建，刷新banner位置到起始位
//
//            }
//        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
//        mViewModel.getBanner("和花")
    }

    private val listener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            //使用setCurrentItem(tab.position, false)会出现滑动tab错乱
            binding.vp2CmBanner.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
        }

        override fun onTabReselected(tab: TabLayout.Tab) {
        }
    }
}