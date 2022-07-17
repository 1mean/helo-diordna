package com.example.pandas.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentCacheListBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.CacheListAdapter

/**
 * @description: 我的-缓存
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class SelfChildCacheFragment : BaseFragment<SelfViewModel, FragmentCacheListBinding>()  {

    private val mAdapter: CacheListAdapter by lazy { CacheListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.rvCacheList.apply {
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }
    }

    override fun createObserver() {
        mViewModel.cacheList.observe(viewLifecycleOwner){
            mAdapter.refreshAdapter(it)
        }
    }

    override fun firstOnResume() {
        mViewModel.getCacheList(mActivity)
    }
}