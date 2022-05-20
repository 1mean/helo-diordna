package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.EyeOtherAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: EyeOtherFragment
 * @author: dongyiming
 * @date: 5/19/22 12:55 上午
 * @version: v1.0
 */
public class EyeOtherFragment : BaseLazyFragment<EyepetozerViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter by lazy { EyeOtherAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.run {
            init(
                null, mAdapter,
                LinearLayoutManager(mActivity),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.tabSelected(false)
                    }
                })
        }

        binding.swipLayout.run {
            setBackgroundResource(R.color.white)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.tabSelected(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.tabSelects.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> {
                        binding.recyclerLayout.visibility = View.GONE
                        binding.layoutError.llayoutError.visibility = View.GONE
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.isRefreshing(false)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                }
            } else {
                when {
                    it.isRefresh -> {
                        binding.recyclerLayout.visibility = View.GONE
                        binding.layoutError.llayoutError.visibility = View.GONE
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }
                    else -> {
                        Toast.makeText(mActivity, "加载出现了错误，请稍后再试", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.tabSelected(true)
    }

}