package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityHistoryBinding
import com.example.pandas.ui.adapter.HistoryAdapter
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView2
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: HistoryActivity
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class HistoryActivity : BaseActivity<HistoryViewModeL, ActivityHistoryBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter: HistoryAdapter by lazy { HistoryAdapter(mutableListOf()) }
    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtils.setStatusBarMode(this, true, R.color.white)
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            setRefreshAdapter(mAdapter, this@HistoryActivity)
        }

        mViewModel.getPageHistory(true)
    }

    override fun createObserver() {

        mViewModel.historyResult.observe(this) {
            if (it.isSuccess) {
                if (it.isRefresh) {
                    if (!it.hasMore) {
                        binding.rvHistory.noMoreData()
                    }
                    mAdapter.refreshAdapter(it.listData)
                } else {
                    if (it.hasMore) {
                        binding.rvHistory.loadMoreFinished()
                    } else {
                        binding.rvHistory.noMoreData()
                    }
                    mAdapter.loadMore(it.listData)
                }
            }
        }
    }

    override fun onLoadMore() {
        mViewModel.getPageHistory(false)
    }

}