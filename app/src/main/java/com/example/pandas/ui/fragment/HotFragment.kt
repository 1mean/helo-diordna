package com.example.pandas.ui.fragment

import HotFragmentAdapter
import OnItemClickListener
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 热门
 * @author: dongyiming
 * @date: 4/20/22 11:20 下午
 * @version: v1.0
 */
public class HotFragment : BaseLazyFragment<HomePageViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: HotFragmentAdapter by lazy { HotFragmentAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.item_home_padding).toInt()

        binding.recyclerLayout.run {

            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getHotData(false)
                }
            })
        }

        binding.swipLayout.run {
            setRefreshColor()
            isRefreshing = true
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getHotData(true)
            }
        }
    }

    override fun createObserver() {
        mViewModel.hotDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        mViewModel.getHotData(true)
    }

}