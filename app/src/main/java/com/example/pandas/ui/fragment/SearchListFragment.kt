package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.LayoutLoadmoreBinding
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: SearchListFragment
 * @author: dongyiming
 * @date: 2/19/22 6:44 下午
 * @version: v1.0
 */
public class SearchListFragment : BaseFragment<SearchViewModel, LayoutLoadmoreBinding>() {

    private val mAdapter: SearchResultAdapter by lazy { SearchResultAdapter("") }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLoad.init(
            null,
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.searchRefresh(false, mViewModel.keyWords)
                }
            })
    }

    override fun createObserver() {
        mViewModel.searchResult.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                binding.recyclerLoad.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter
                        mAdapter.refreshAdapter(mViewModel.keyWords, it.listData)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerLoad.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.searchRefresh(true, mViewModel.keyWords)
    }

    fun clear() {
        mAdapter.clear()
    }
}