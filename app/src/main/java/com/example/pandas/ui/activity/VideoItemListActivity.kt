package com.example.pandas.ui.activity

import CommonItemDecoration
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.ActivityVideoListBinding
import com.example.pandas.ui.adapter.PandaListAdapter
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView2
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: VideoItemListActivity
 * @author: dongyiming
 * @date: 3/28/22 6:26 下午
 * @version: v1.0
 */
public class VideoItemListActivity : BaseActivity<PandaViewModel, ActivityVideoListBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter: PandaListAdapter by lazy { PandaListAdapter(mutableListOf()) }

    private var title: String? = null

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)
        val padding = resources.getDimension(R.dimen.dimen_padding_panda_list).toInt()
        title = intent.getStringExtra("title")
        binding.tbPandas.title = title
        binding.tbPandas.setNavigationOnClickListener {
            finish()
        }

        binding.rvVideoList.apply {
            layoutManager = GridLayoutManager(this@VideoItemListActivity, 2)
            addItemDecoration(CommonItemDecoration(false, 2, padding, padding))
            setRefreshAdapter(mAdapter, this@VideoItemListActivity)
        }
        binding.swipVideoList.setOnRefreshListener {
            title?.let { mViewModel.getPandas(true, it) }
        }
    }

    override fun onResume() {
        super.onResume()
        title?.let { mViewModel.getPandas(true, it) }
    }

    override fun createObserver() {

        mViewModel.pandaResult.observe(this) {
            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> viewState(true)
                    it.isRefresh -> {
                        viewState(false)
                        binding.rvVideoList.isFreshing(false)
                        binding.swipVideoList.isRefreshing = false
                        if (!it.hasMore) {
                            binding.rvVideoList.noMoreData()
                        }
                        mAdapter.refreshAdapter(it.listData)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                        if (it.hasMore) {
                            binding.rvVideoList.loadMoreFinished()
                        } else {
                            binding.rvVideoList.noMoreData()
                        }
                    }
                }
            }
        }
    }

    override fun onLoadMore() {
        title?.let { mViewModel.getPandas(false, it) }
    }

    private fun viewState(isEmpty: Boolean) {
        if (isEmpty) {
            binding.rvVideoList.visibility = View.GONE
            binding.txtEmpty.visibility = View.VISIBLE
        } else {
            binding.rvVideoList.visibility = View.VISIBLE
            binding.txtEmpty.visibility = View.GONE
        }
    }
}