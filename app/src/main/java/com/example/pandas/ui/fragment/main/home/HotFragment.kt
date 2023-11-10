package com.example.pandas.ui.fragment.main.home

import HotFragmentAdapter
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 首页-热门
 * @author: dongyiming
 * @date: 4/20/22 11:20 下午
 * @version: v1.0
 */
public class HotFragment : BaseLazyFragment<HomePageViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: HotFragmentAdapter by lazy { HotFragmentAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getHotData(false)
                }
            })

        binding.swipLayout.run {
            setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_hot))
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getHotData(true)
            }
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }

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
        binding.swipLayout.isRefreshing = true
        mViewModel.getHotData(true)
    }

    override fun refresh() {
        super.refresh()
        binding.swipLayout.isRefreshing = true
        mViewModel.getHotData(true)
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

}