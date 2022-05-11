package com.example.pandas.ui.fragment

import CommonItemDecoration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.EyepetozerViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.EyepetozerAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 开眼
 * @author: dongyiming
 * @date: 2021/12/21 2:16 下午
 * @version: v1.0
 */
public class EyepetozerFragment :
    BaseLazyFragment<EyepetozerViewModel, LayoutSwipRefreshBinding>() {

    private var existDataInView = false//界面是否存在数据，下次出错不会影响界面显示

    private val paddingBottom: Int
        get() = resources.getDimension(R.dimen.common_lh_10_dimens).toInt()

    private val mAdapter: EyepetozerAdapter by lazy { EyepetozerAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.init(
            CommonItemDecoration(paddingBottom = paddingBottom),
            mAdapter,
            LinearLayoutManager(mActivity),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.initData(false)
                }
            })

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.initData(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.eyepetozerWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> {
                        binding.recyclerLayout.visibility = View.GONE
                        binding.layoutError.llayoutError.visibility = View.GONE
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }
                    it.isRefresh -> {
                        existDataInView = true
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.isRefreshing(false)
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                    }
                }
            } else {
                when {
                    it.isRefresh -> {
                        if (existDataInView) {
                            Toast.makeText(mActivity, "出现了错误，请稍后再试", Toast.LENGTH_SHORT).show()
                        } else {
                            binding.recyclerLayout.visibility = View.GONE
                            binding.layoutError.llayoutError.visibility = View.GONE
                            binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                        }
                    }
                }
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.initData(true)
    }
}