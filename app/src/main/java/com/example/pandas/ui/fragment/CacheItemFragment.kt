package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.FragmentMoreBinding
import com.example.pandas.ui.adapter.CacheItemAdapter
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView2

/**
 * @description: CacheItemFragment
 * @author: dongyiming
 * @date: 3/8/22 11:26 下午
 * @version: v1.0
 */
public class CacheItemFragment : BaseFragment<LocalCacheViewModel, FragmentMoreBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter by lazy { CacheItemAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLoad.apply {
            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, this@CacheItemFragment)
        }
    }

    override fun createObserver() {

        mViewModel.localVideos.observe(viewLifecycleOwner) {
            Log.e(
                "111111mean",
                "size: ${it.listData.size}, isRefresh: ${it.isRefresh}, hasMore: ${it.hasMore}"
            )
            if (it.isSuccess) {
                if (it.isRefresh) {
                    if (!it.hasMore) {
                        binding.recyclerLoad.noMoreData()
                    }
                    //mAdapter.refreshAdapter(it.listData)
                } else {
                    if (!it.hasMore) {
                        binding.recyclerLoad.noMoreData()
                    } else {
                        binding.recyclerLoad.loadMoreFinished()
                    }
                   // mAdapter.loadMore(it.listData)
                }
            }
        }
    }

    override fun firstOnResume() {
    }

    //Activity初始化时就创建，业务逻辑放在onHiddenChanged的可见状态里
    override fun onHiddenChanged(hidden: Boolean) {

        if (!hidden) {
            //mViewModel.getItemList(true, mActivity)
        } else {
            binding.recyclerLoad.clearState()
            mAdapter.clear()
        }
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun lazyLoadTime(): Long = 0

    override fun onLoadMore() {
        //mViewModel.getItemList(false, mActivity)
    }
}