package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityHistoryBinding
import com.example.pandas.ui.adapter.HistoryAdapter
import com.example.pandas.ui.adapter.decoration.LandScapeItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: HistoryActivity
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class HistoryActivity : BaseActivity<HistoryViewModeL, ActivityHistoryBinding>(),
    HistoryAdapter.HistoryListener {

    private var selectAll: Boolean = false

    private val mAdapter: HistoryAdapter by lazy { HistoryAdapter(listener = this) }

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtils.setStatusBarMode(this, true, R.color.white)

        val padding = resources.getDimension(R.dimen.common_lh_6_dimens).toInt()

        binding.rvHistory.init(
            LandScapeItemDecoration(padding),
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPageHistory(false)
                }
            })

        binding.txtHistoryTitle.text = resources.getString(R.string.str_history)

        binding.txtHistoryManager.setOnClickListener {
            val manager = binding.txtHistoryManager.text
            if (manager == "管理") {
                mAdapter.manager(false)
                binding.clayoutHistoryBottom.visibility = View.VISIBLE
                binding.txtHistoryManager.text = resources.getString(R.string.str_cannel)
            } else {
                mAdapter.manager(true)
                binding.clayoutHistoryBottom.visibility = View.GONE
                binding.txtHistoryManager.text = resources.getString(R.string.str_manager)
            }
        }
        binding.clayoutSelectAll.setOnClickListener {

            mAdapter.isSelectAll(selectAll)
            if (selectAll) {
                binding.imgSelectAll.setImageResource(R.mipmap.img_history_unselect)
            } else {
                binding.imgSelectAll.setImageResource(R.mipmap.img_history_selected)
            }
            selectAll = !selectAll
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getPageHistory(true)
    }

    override fun createObserver() {

        mViewModel.historyResult.observe(this) {
            if (it.isSuccess) {
                if (it.isRefresh) {
                    mAdapter.refreshAdapter(it.listData)
                    binding.rvHistory.isRefreshing(false)
                } else {
                    mAdapter.loadMore(it.listData)
                }
                binding.rvHistory.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun onLongClick() {

        binding.clayoutHistoryBottom.visibility = View.VISIBLE
        binding.txtHistoryManager.text = resources.getString(R.string.str_cannel)
    }

}