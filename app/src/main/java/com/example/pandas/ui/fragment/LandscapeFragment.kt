package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
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

    private val mAdapter: LandscapeAdapter by lazy { LandscapeAdapter(LandscapeData()) }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.item_home_padding).toInt()

        binding.recyclerLayout.init(
            LandScapeItemDecoration(padding),
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getLandScapeData(false)
                }
            })

        binding.swipLayout.run {
            setRefreshColor()
            isRefreshing = true
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getLandScapeData(true)
            }
        }
    }

    override fun createObserver() {

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
        mViewModel.getLandScapeData(true)
    }

}