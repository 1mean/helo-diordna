package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.app.getHehuaBanner
import com.example.pandas.biz.ext.loadPandaBackGround
import com.example.pandas.biz.interaction.PagerChangedListener
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.ActivityCmBannerBinding
import com.example.pandas.ui.adapter.ActivityPandaAdapter
import com.example.pandas.ui.adapter.CommonBannerAdapter
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.viewColors
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

    private val tabTitles = arrayListOf("成和花", "幼年花", "月亮花", "小二班")

    fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    override fun initView(savedInstanceState: Bundle?) {
        initStatusView()
        val title = intent.getStringExtra("title")
        binding.txtCmBannerTitle.text = title

        //binding.btnCmBannerBack.setOnClickListener { finish() }

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

        val status = appViewModel.appColorType.value
        if (status == null || status == 0) {
            binding.tabCmBanner.setTabTextColors(
                ContextCompat.getColor(
                    this,
                    R.color.white
                ), ContextCompat.getColor(this, viewColors[APP_COLOR_STATUS])
            )
            binding.tabCmBanner.setSelectedTabIndicatorColor(
                ContextCompat.getColor(
                    this,
                    viewColors[APP_COLOR_STATUS]
                )
            )
        } else {
            binding.tabCmBanner.setTabTextColors(
                ContextCompat.getColor(
                    this,
                    R.color.white
                ), ContextCompat.getColor(this, viewColors[status])
            )
            binding.tabCmBanner.setSelectedTabIndicatorColor(
                ContextCompat.getColor(
                    this,
                    viewColors[status]
                )
            )
        }

        val list = getHehuaBanner()
        val adapter = CommonBannerAdapter(list)
        binding.bannerCmTop.setLifecycleRegistry(lifecycle)
            .setPagePadding(60, 60, 36)
            .addPageChangeListener(object : PagerChangedListener {
                override fun onChange(position: Int) {
                    list[position].cover?.let {
                        loadPandaBackGround(this@PandaActivity, it, binding.root)
                    }
                }
            }).setAdapter(adapter)
            .setAutoPlayed(true)

        binding.barCmBanner.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                binding.txtCmBannerTitle.visibility = View.GONE
                binding.btnCmBannerLeft.visibility = View.GONE
                //binding.btnCmBannerBack.visibility = View.VISIBLE
                binding.collapsCmBanner.contentScrim = null
            } else if (Math.abs(verticalOffset) >= 0.6 * appBarLayout.totalScrollRange) {
                if (!binding.txtCmBannerTitle.isVisible) {
                    binding.txtCmBannerTitle.visibility = View.VISIBLE
                    binding.btnCmBannerLeft.visibility = View.VISIBLE
                    binding.txtCmBannerTitle.text = "大熊猫和花"
                }
                //binding.btnCmBannerBack.visibility = View.GONE
                binding.collapsCmBanner.setContentScrimResource(R.color.color_bg_banner_top)
            } else {
                binding.txtCmBannerTitle.visibility = View.GONE
                binding.btnCmBannerLeft.visibility = View.GONE
                //binding.btnCmBannerBack.visibility = View.VISIBLE
                binding.collapsCmBanner.contentScrim = null
            }
        })
        binding.btnCmBannerLeft.setOnClickListener {
            finish()
        }
    }

    override fun createObserver() {

    }

    override fun firstOnResume() {
        super.firstOnResume()
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