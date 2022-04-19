package com.example.pandas.ui.fragment

import CommonItemDecoration
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.CutePetViewModel
import com.example.pandas.databinding.FragmentCuteChildBinding
import com.example.pandas.ui.adapter.CutePetChildAdapter
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView2

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class PetChildFragment() :
    BaseLazyFragment<CutePetViewModel, FragmentCuteChildBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter: CutePetChildAdapter by lazy { CutePetChildAdapter(mutableListOf()) }

    private var type = 0

    override fun initView(savedInstanceState: Bundle?) {

        val padding = resources.getDimension(R.dimen.dimen_padding_pet).toInt()
        type = requireArguments().getInt("type")
        binding.recyclerLoad.visibility = View.GONE
        binding.recyclerLoad.run {
            layoutManager = GridLayoutManager(mActivity, 2)
            addItemDecoration(CommonItemDecoration(false, 2, padding, padding))
            setRefreshAdapter(mAdapter, this@PetChildFragment)
        }
    }

    override fun createObserver() {

        mViewModel.pageDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                when {
                    it.isRefresh -> {
                        if (!it.hasMore) {
                            binding.recyclerLoad.noMoreData()
                        }
                        mAdapter.refreshAdapter(it.listData)
                    }
                    it.isFirstEmpty -> {

                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                        binding.recyclerLoad.loadMoreFinished()
                        if (!it.hasMore) {//没有更多数据了
                            binding.recyclerLoad.noMoreData()
                        }
                    }
                }
            }
            binding.recyclerLoad.visibility = View.VISIBLE
        }
    }

    override fun firstOnResume() {
        mViewModel.getDataByPage(true, type)
    }

    override fun onLoadMore() {
        mViewModel.getDataByPage(false, type)
    }

    /**
     * Fragment必须有空构造函数，否则会报错，传递值时处理
     */
    companion object {

        fun newInstance(id: Int): PetChildFragment {

            val args = Bundle().apply {
                putInt("type", id)
            }
            val fragment = PetChildFragment()
            fragment.arguments = args
            return fragment
        }
    }
}