package com.example.pandas.ui.fragment

import CommonItemDecoration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.LayoutRefreshLoadmore2Binding
import com.example.pandas.ui.adapter.PandaListAdapter
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView2

/**
 * @description: PandaChildFragment
 * @author: dongyiming
 * @date: 3/28/22 1:07 上午
 * @version: v1.0
 */
public class PandaChildFragment : BaseFragment<PandaViewModel, LayoutRefreshLoadmore2Binding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private var key: String? = null
    private var type = -1

    private val mAdapter: PandaListAdapter by lazy { PandaListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = resources.getDimension(R.dimen.dimen_padding_panda_child).toInt()
        type = requireArguments().getInt("type")
        key = requireArguments().getString("key")

        binding.recyclerLayout.apply {
            layoutManager = GridLayoutManager(mActivity, 2)
            addItemDecoration(CommonItemDecoration(false, 2, padding, padding))
            setRefreshAdapter(mAdapter, this@PandaChildFragment)
        }
        binding.swipLayout.setOnRefreshListener {
            key?.let {
                mViewModel.getPandas(true, it, type)
            }
        }
    }

    override fun createObserver() {

        mViewModel.pandaResult.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                Log.e("1mean", "isFirstEmpty: ${it.isFirstEmpty}")
                when {
                    it.isFirstEmpty -> viewState(true)
                    it.isRefresh -> {
                        viewState(false)
                        binding.recyclerLayout.isFreshing(false)
                        binding.swipLayout.isRefreshing = false
                        if (!it.hasMore) {
                            binding.recyclerLayout.noMoreData()
                        }
                        mAdapter.refreshAdapter(it.listData)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                        if (it.hasMore) {
                            binding.recyclerLayout.loadMoreFinished()
                        } else {
                            binding.recyclerLayout.noMoreData()
                        }
                    }
                }
            }
            binding.swipLayout.visibility = View.VISIBLE
        }
    }

    override fun firstOnResume() {
        key?.let {
            mViewModel.getPandas(true, it, type)
        }
    }

    companion object {

        fun newInstance(key: String, id: Int): PandaChildFragment {

            val args = Bundle().apply {
                putInt("type", id)
                putString("key", key)
            }
            val fragment = PandaChildFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onLoadMore() {
        key?.let {
            mViewModel.getPandas(false, it, type)
        }
    }

    private fun viewState(isEmpty: Boolean) {
        if (isEmpty) {
            binding.recyclerLayout.visibility = View.GONE
            binding.txtEmpty.visibility = View.VISIBLE
        } else {
            binding.recyclerLayout.visibility = View.VISIBLE
            binding.txtEmpty.visibility = View.GONE
        }
    }
}