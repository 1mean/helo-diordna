package com.example.pandas.ui.fragment.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentMainBinding
import com.example.pandas.ui.activity.PublishActivity
import com.example.pandas.ui.adapter.HomeAdapter
import com.example.pandas.ui.ext.appColorObserver
import com.example.pandas.ui.ext.bottomStateObserver
import com.example.pandas.ui.ext.initBottom
import com.example.pandas.ui.ext.startAnyActivity
import com.google.android.material.badge.BadgeDrawable


/**
 * @description: 首页fragment
 * @author: dongyiming
 * @date: 4/28/22 4:04 下午
 * @version: v1.0
 */
public class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    private var indexArray = arrayOf(0, 1, 2, 3, 4)
    val tabTitles = arrayListOf("首页", "动态", "发布", "视频", "我的")

    private var curPosition = 0
    private var lastPosition = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.vpHome.apply {
            adapter = HomeAdapter(mActivity)
            offscreenPageLimit = 5
            //setCurrentItem(0, false)
            isUserInputEnabled = false //禁止滑动
        }

        binding.bnvMain.getOrCreateBadge(R.id.menu_news).run {
            badgeGravity = BadgeDrawable.TOP_END
            backgroundColor =
                ContextCompat.getColor(mActivity, R.color.color_groupbutton_text_selected)
            maxCharacterCount = 3 //101显示99+
            number = 23
            badgeTextColor = Color.WHITE
            verticalOffset = 15
        }

        binding.bnvMain.run {
            itemIconTintList = null //必须代码设置，点击后变化的图片才能显示
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> {
                        if (curPosition == 0) {
                            mViewModel.bottomState
                        }
                        curPosition = 0
                        binding.vpHome.setCurrentItem(0, false)
                    }
                    R.id.menu_news -> {
                        curPosition = 1
                        binding.vpHome.setCurrentItem(1, false)
                        binding.bnvMain.getOrCreateBadge(R.id.menu_news).isVisible = false
                    }
                    R.id.menu_add -> {
                        curPosition = 2
//                        binding.vpHome.setCurrentItem(2, false)
//                        mActivity.supportFragmentManager.fragments.forEach {
//                            if (it is PublishFragment) {
//                                it.startPublishActivity()
//                            }
//                        }
                        startAnyActivity(mActivity, PublishActivity::class.java)
                        mActivity.overridePendingTransition(
                            R.anim.animate_short_comment_in,
                            R.anim.animate_activity_out
                        )
                    }
                    R.id.menu_more -> {
                        curPosition = 3
                        binding.vpHome.setCurrentItem(3, false)
                    }
                    R.id.menu_mine -> {
                        curPosition = 4
                        binding.vpHome.setCurrentItem(4, false)
                    }
                }
                if (curPosition == lastPosition) {
                    Log.e("doubleCilik", "开始刷新了， lastPosition：$lastPosition")
                    mViewModel.updateRefreshPosition(curPosition)
                }
                lastPosition = curPosition
                true //true表示拦截，不跳转
            }
        }
        initBottom(indexArray)
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(this) { type ->
            appColorObserver(indexArray, type)
        }

        mViewModel.bottomState.observe(viewLifecycleOwner) { status ->
            bottomStateObserver(indexArray, status)
        }
    }

    override fun firstOnResume() {

    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}