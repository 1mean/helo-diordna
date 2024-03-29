package com.example.pandas.ui.fragment.main.home.panda

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.PandaListAdapter
import com.example.pandas.ui.adapter.decoration.CommonBannerItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: PandaChildFragment
 * @author: dongyiming
 * @date: 3/28/22 1:07 上午
 * @version: v1.0
 */
public class PandaChildFragment : BaseFragment<PandaViewModel, LayoutSwipRefreshBinding>() {

    private var key: String? = null
    private var type = -1

    private val mAdapter: PandaListAdapter by lazy { PandaListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        type = requireArguments().getInt("type")
        key = requireArguments().getString("key")

        binding.recyclerLayout.init(
            CommonBannerItemDecoration(mActivity),
            mAdapter,
            GridLayoutManager(mActivity, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    key?.let {
                        mViewModel.getPandas(false, it, type)
                    }
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_home)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                key?.let {
                    mViewModel.getPandas(true, it, type)
                }
            }
        }

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }
    }

    override fun createObserver() {

        mViewModel.pandaResult.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isFirstEmpty -> {
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    }
                    it.isRefresh -> {
                        binding.recyclerLayout.isRefreshing(false)
                        mAdapter.refreshAdapter(it.listData)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
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
}