package com.example.pandas.ui.fragment.main.short

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.FallsShortVideoAdapter
import com.example.pandas.ui.adapter.decoration.FallsVideoItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: PetChildFragment
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class ShortVideoFragment() :
    BaseLazyFragment<ShortVideoViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: FallsShortVideoAdapter by lazy { FallsShortVideoAdapter() }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_4_dimens).toInt()
        val paddingTop = mActivity.resources.getDimension(R.dimen.common_lh_5_dimens).toInt()
        val layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                //防止item交换位置
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
            }

        binding.recyclerLayout.init(
            FallsVideoItemDecoration(2, padding, paddingTop, padding),
            mAdapter,
            layoutManager,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getFallsShortVideos(false)
                }
            })

        binding.swipLayout.run {
            setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_falls_short))
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getFallsShortVideos(true)
            }
        }

        binding.recyclerLayout.addOnScrollListener(object : OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                layoutManager.invalidateSpanAssignments()
            }
        })
    }

    override fun createObserver() {

        mViewModel.fallsShortVideos.observe(viewLifecycleOwner) {

            Log.e("lidandan3", "listdata: ${it.listData}")
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
        mViewModel.getFallsShortVideos(true)
    }
}