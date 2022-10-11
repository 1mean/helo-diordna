package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineBinding
import com.example.pandas.ui.adapter.SelfViewPagerAdapter


/**
 * @description: SelfFragment
 * @author: dongyiming
 * @date: 2021/11/25 3:57 下午
 * @version: v1.0
 */
public class SelfFragment : BaseLazyFragment<SelfViewModel, FragmentMineBinding>() {

    private val titles = arrayOf("设置", "缓存")
    private val pagerAdapter: SelfViewPagerAdapter by lazy { SelfViewPagerAdapter(mActivity) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Self.run {
            adapter = pagerAdapter
            currentItem = 0
        }

        binding.slideTabSetting.setViewPager(binding.vp2Self, titles)
    }

    override fun createObserver() {


    }

    override fun firstOnResume() {
    }

    override fun onResume() {
        super.onResume()
    }
}