package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.MyLoveFragmentAdapter
import com.example.pandas.ui.adapter.decoration.MyLoveItemDecoration
import com.example.pandas.ui.ext.initNoFooter
import com.example.pandas.ui.ext.setRefreshColor

/**
 * @description: 我爱看的
 * @author: dongyiming
 * @date: 1/28/22 8:51 下午
 * @version: v1.0
 */
public class MyLoveFragment : BaseLazyFragment<HomePageViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: MyLoveFragmentAdapter by lazy {
        MyLoveFragmentAdapter(PageCommonData())
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.initNoFooter(
            MyLoveItemDecoration(mActivity),
            mAdapter,
            LinearLayoutManager(mActivity),
            null
        )

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getLoveData(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.loveDataWrapper.observe(viewLifecycleOwner) {
            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refresh(it.loveData)
                        binding.swipLayout.isRefreshing = false
                    }
                }
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getLoveData(true)
    }

}