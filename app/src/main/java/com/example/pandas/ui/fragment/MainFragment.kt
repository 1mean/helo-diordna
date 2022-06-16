package com.example.pandas.ui.fragment

import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.databinding.FragmentMainBinding
import com.example.pandas.ui.adapter.HomeAdapter

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
                    R.id.menu_pet -> binding.vpHome.setCurrentItem(1, false)
                    R.id.menu_video -> binding.vpHome.setCurrentItem(2, false)
                    R.id.menu_face -> binding.vpHome.setCurrentItem(3, false)
                    R.id.menu_mine -> binding.vpHome.setCurrentItem(4, false)
                }
                true //true表示拦截，不跳转
            }
        }

    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}