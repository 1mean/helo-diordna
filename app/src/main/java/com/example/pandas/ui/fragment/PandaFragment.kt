package com.example.pandas.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.FragmentPandasBinding
import com.example.pandas.ui.adapter.PandasAdapter
import com.example.pandas.ui.ext.initPanda
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView

/**
 * @description: PandaFragment
 * @author: dongyiming
 * @date: 1/12/22 7:35 下午
 * @version: v1.0
 */
public class PandaFragment : BaseLazyFragment<HomePageViewModel, FragmentPandasBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener {

    private val pandasAdapter: PandasAdapter by lazy { PandasAdapter(arrayListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.refreshLayoutPanda.setOnRefreshListener {
            binding.recyclerViewPanda.isFreshing(true)
            mViewModel.getPagePet(true)
        }

        val layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerViewPanda.initPanda(layoutManager, pandasAdapter, this)
    }

    override fun createObserver() {

        mViewModel.petDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {//成功
                when {
                    //没有数据
                    it.isFirstEmpty -> {
                        binding.refreshLayoutPanda.isRefreshing = false
                        binding.recyclerViewPanda.isFreshing(false)
                    }
                    //刷新的第一页
                    it.isRefresh -> {
                        binding.refreshLayoutPanda.isRefreshing = false
                        binding.recyclerViewPanda.isFreshing(false)
                        pandasAdapter.refreshData(it.listData)
                    }
                    //加载更多
                    else -> {
                        binding.recyclerViewPanda.loadMoreFinished()
                        pandasAdapter.addData(it.listData)
                    }
                }
            }
        }

    }

    override fun firstOnResume() {

        binding.refreshLayoutPanda.isRefreshing = true
        mViewModel.getPagePet(true)
    }

    override fun onLoadMore() {
        mViewModel.getPagePet(false)
    }
}