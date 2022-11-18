package com.example.pandas.ui.fragment.main.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.PandasAdapter
import com.example.pandas.ui.adapter.decoration.PandaItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 首页-熊猫
 * @author: dongyiming
 * @date: 1/12/22 7:35 下午
 * @version: v1.0
 */
public class PandaFragment : BaseLazyFragment<HomePageViewModel, LayoutSwipRefreshBinding>() {

    private val pandasAdapter: PandasAdapter by lazy { PandasAdapter(arrayListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.init(
            PandaItemDecoration(
                resources.getDimension(R.dimen.item_panda_paddingTop).toInt(),
                resources.getDimension(R.dimen.item_panda_paddingLeft).toInt()
            ),
            pandasAdapter,
            GridLayoutManager(mActivity, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPagePet(false)
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_caption_bg)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getPagePet(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.petDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {//成功

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    //没有数据
                    it.isRefresh -> {
                        pandasAdapter.refreshData(it.listData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    //加载更多
                    else -> {
                        pandasAdapter.addData(it.listData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }

    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getPagePet(true)
    }
}