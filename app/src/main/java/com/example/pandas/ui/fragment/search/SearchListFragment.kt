package com.example.pandas.ui.fragment.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.LayoutLoadmoreBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import kotlinx.coroutines.launch

/**
 * @description: SearchListFragment
 * @author: dongyiming
 * @date: 2/19/22 6:44 下午
 * @version: v1.0
 */
public class SearchListFragment : BaseFragment<SearchViewModel, LayoutSwipRefreshBinding>() {

    companion object {
        fun newInstance() = SearchListFragment()
    }

    var keyWords:String = ""
    override fun onAttach(context: Context) {
        super.onAttach(context)
        keyWords = (context as NewSearchActivity).keyWords
    }

    private val mAdapter: SearchResultAdapter by lazy { SearchResultAdapter("") }

    override fun initView(savedInstanceState: Bundle?) {

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_home)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.searchRefresh(true, keyWords)
            }
        }

        binding.recyclerLayout.init(
            null,
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.searchRefresh(false, keyWords)
                }
            })
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.searchResult.collect {
                Log.e(
                    "1medadaaasdasdasdadan",
                    "ListFragment 获取数据 size:${it.listData.size} success=${it.isSuccess},refresh=${it.isRefresh},thread=${Thread.currentThread().name}"
                )
                if (it.isSuccess) {
                    when {
                        it.isRefresh -> {
                            if (it.isEmpty) {
                                binding.recyclerLayout.adapter = null
                                binding.recyclerLayout.visibility = View.GONE
                                binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                            } else {
                                binding.recyclerLayout.visibility = View.VISIBLE
                                binding.layoutEmpty.llayoutEmpty.visibility = View.GONE
                                if (binding.recyclerLayout.adapter == null) {
                                    binding.recyclerLayout.adapter = mAdapter
                                }
                                mAdapter.refreshAdapter(keyWords, it.listData)
                            }
                        }
                        else -> {
                            Log.e("1medadaaasdasdasdadan", "loadmore size=" + it.listData.size)
                            mAdapter.loadMore(it.listData)
                        }
                    }
                    binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
                }
                binding.swipLayout.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.searchRefresh(true, keyWords)
    }

    fun reSearch(key: String) {
        Log.e("1medadaaasdasdasdadan", "ListFragment接收Activity数据，并重新搜索:${key}")
        this.keyWords = key
        mViewModel.searchRefresh(true, key)
    }
}