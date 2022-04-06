package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutRefreshLoadmoreBinding
import com.example.pandas.ui.adapter.MyLoveFragmentAdapter
import com.example.pandas.ui.adapter.decoration.MyLoveItemDecoration

/**
 * @description: 我爱看的
 * @author: dongyiming
 * @date: 1/28/22 8:51 下午
 * @version: v1.0
 */
public class MyLoveFragment : BaseLazyFragment<HomePageViewModel, LayoutRefreshLoadmoreBinding>() {

    private val mAdapter: MyLoveFragmentAdapter by lazy {
        MyLoveFragmentAdapter(
            viewLifecycleOwner,
            PageCommonData()
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.swipLayout.setOnRefreshListener {
            mViewModel.getLoveData(true)
        }

        binding.recyclerLayout.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(mActivity)
            addItemDecoration(MyLoveItemDecoration(mActivity))
        }
    }

    override fun createObserver() {

        mViewModel.loveDataWrapper.observe(viewLifecycleOwner) {
            if (it.isSuccess) {

                when {
                    it.isRefresh -> {
                        mAdapter.refresh(it.loveData)
                        binding.swipLayout.isRefreshing = false
                    }
                }
                binding.swipLayout.visibility = View.VISIBLE
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getLoveData(true)
        binding.swipLayout.isRefreshing = true
    }

}