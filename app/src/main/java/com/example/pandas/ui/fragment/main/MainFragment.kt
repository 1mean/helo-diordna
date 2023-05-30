package com.example.pandas.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.view.get
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.FragmentMainBinding
import com.example.pandas.ui.adapter.HomeAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.internal.BaselineLayout

/**
 * @description: 首页fragment
 * @author: dongyiming
 * @date: 4/28/22 4:04 下午
 * @version: v1.0
 */
public class MainFragment : BaseLazyFragment<BaseViewModel, FragmentMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        binding.vpHome.apply {
            adapter = HomeAdapter(mActivity)
            offscreenPageLimit = 5
            //setCurrentItem(0, false)
            isUserInputEnabled = false //禁止滑动
        }

        binding.bnvMain.run {
            itemIconTintList = null //必须代码设置，点击后变化的图片才能显示
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> binding.vpHome.setCurrentItem(0, false)
                    R.id.menu_news -> binding.vpHome.setCurrentItem(1, false)
                    R.id.menu_add -> binding.vpHome.setCurrentItem(2, false)
                    R.id.menu_more -> binding.vpHome.setCurrentItem(3, false)
                    R.id.menu_mine -> binding.vpHome.setCurrentItem(4, false)
                }
                true //true表示拦截，不跳转
            }
        }

        val view = binding.bnvMain[0]
        if (view is BottomNavigationMenuView) {
            val item = (view as BottomNavigationMenuView)[2]
            if (item is BottomNavigationItemView) {
                val lineLayout =
                    item.findViewById<BaselineLayout>(R.id.navigation_bar_item_labels_group)
                val image = item.findViewById<ImageView>(R.id.navigation_bar_item_icon_view)
                image.visibility = View.GONE
                lineLayout.visibility = View.GONE
                val publishView = LayoutInflater.from(mActivity)
                    .inflate(R.layout.view_bottom_navigation_publish, null)
                (item as BottomNavigationItemView).addView(publishView)
            }
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}