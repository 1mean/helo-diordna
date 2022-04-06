package com.example.pandas.ui.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MoreDataViewModel
import com.example.pandas.databinding.FragmentMoreBinding
import com.example.pandas.ui.adapter.VideoListAdapter
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView2

/**
 * @description: VideoListFragment
 * @author: dongyiming
 * @date: 3/2/22 12:45 上午
 * @version: v1.0
 */
public class VideoListFragment : BaseFragment<MoreDataViewModel, FragmentMoreBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter: VideoListAdapter by lazy { VideoListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLoad.run {
            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, this@VideoListFragment)
        }
    }

    override fun createObserver() {
        mViewModel.moreDataResult.observe(viewLifecycleOwner) {
            if (it.isSuccess && !it.isEmpty) {
                if (it.isRefresh) {
                    mAdapter.refreshAdapter(it.listData)
                    if (!it.hasMore) {
                        binding.recyclerLoad.noMoreData()
                    }
                } else {
                    binding.recyclerLoad.loadMoreFinished()
                    mAdapter.loadMore(it.listData)
                    if (!it.hasMore) {
                        binding.recyclerLoad.noMoreData()
                    }
                }
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getListResult()
    }

    override fun onLoadMore() {
        mViewModel.getListResult()
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

}