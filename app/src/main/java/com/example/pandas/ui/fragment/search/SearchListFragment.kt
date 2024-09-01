package com.example.pandas.ui.fragment.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.LayoutLoadmoreBinding
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import kotlinx.coroutines.launch

/**
 * @description: SearchListFragment
 * @author: dongyiming
 * @date: 2/19/22 6:44 下午
 * @version: v1.0
 */
public class SearchListFragment : BaseFragment<SearchViewModel, LayoutLoadmoreBinding>() {

    companion object {
        fun newInstance() = SearchListFragment()
    }

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
        lifecycleScope.launch {
            mViewModel.searchResult.collect {
                if (it.isSuccess) {
                    when {
                        it.isRefresh -> {
                            if (it.isEmpty) {
                                binding.recyclerLoad.adapter = null
                                binding.recyclerLoad.visibility = View.GONE
                                binding.txtSearchNoData.visibility = View.VISIBLE
                            } else {
                                binding.recyclerLoad.visibility = View.VISIBLE
                                binding.txtSearchNoData.visibility = View.GONE
                                if (binding.recyclerLoad.adapter == null) {
                                    binding.recyclerLoad.adapter = mAdapter
                                }
                                mAdapter.refreshAdapter(mViewModel.keyWords, it.listData)
                            }
                        }
                        else -> {
                            mAdapter.loadMore(it.listData)
                        }
                    }
                    binding.recyclerLoad.loadMoreFinished(it.isEmpty, it.hasMore)
                }
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