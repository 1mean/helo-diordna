package com.example.pandas.ui.fragment.main.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.LandscapeData
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.LandscapeAdapter
import com.example.pandas.ui.adapter.decoration.LandScapeItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: LandscapeFragment
 * @author: dongyiming
 * @date: 2/4/22 4:44 下午
 * @version: v1.0
 */
public class LandscapeFragment :
    BaseLazyFragment<HomePageViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: LandscapeAdapter by lazy { LandscapeAdapter(lifecycle, LandscapeData()) }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop = mActivity.resources.getDimension(R.dimen.item_home_padding).toInt()
        val paddingHorizontal = mActivity.resources.getDimension(R.dimen.item_home_padding).toInt()

        binding.recyclerLayout.init(
            LandScapeItemDecoration(paddingTop,paddingHorizontal),
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getLandScapeData(false)
                }
            })

        binding.swipLayout.run {
            setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_hot))
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getLandScapeData(true)
            }
        }

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }

        mViewModel.landScapeDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.updata(true, it.landscapeData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.updata(false, it.landscapeData)
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
        mViewModel.getLandScapeData(true)
    }

    override fun refresh() {
        super.refresh()
        binding.swipLayout.isRefreshing = true
        mViewModel.getLandScapeData(true)
        binding.recyclerLayout.smoothScrollToPosition(0)
    }
}