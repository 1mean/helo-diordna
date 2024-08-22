package com.example.pandas.ui.fragment.main.pet

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.CutePetViewModel
import com.example.pandas.databinding.LayoutLoadingRefreshBinding
import com.example.pandas.ui.adapter.CutePetChildAdapter
import com.example.pandas.ui.adapter.decoration.PetChildItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: PetChildFragment
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class PetChildFragment() : BaseFragment<CutePetViewModel, LayoutLoadingRefreshBinding>() {

    private val mAdapter: CutePetChildAdapter by lazy {
        CutePetChildAdapter(mutableListOf()) {
            mViewModel.addOrUpdateVideoData(it)
        }
    }

    private var type = 0

    override fun initView(savedInstanceState: Bundle?) {

        val padding = resources.getDimension(R.dimen.dimen_padding_pet).toInt()
        type = requireArguments().getInt("type")

        binding.recyclerLayout.init(
//            CommonItemDecoration(false, 2, padding, padding),
            PetChildItemDecoration(padding),
            mAdapter,
            GridLayoutManager(mActivity, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getDataByPage(false, type)
                }
            })
    }

    override fun createObserver() {

        mViewModel.pageDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.clayoutLoading.visibility = View.GONE
        }
    }

    override fun firstOnResume() {
        mViewModel.getDataByPage(true, type)
    }

    /**
     * Fragment必须有空构造函数，否则会报错，传递值时处理
     */
    companion object {
        fun newInstance(id: Int) = PetChildFragment().apply {
            arguments = Bundle().apply {
                putInt("type", id)
            }
        }
    }
}