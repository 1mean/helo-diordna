package com.example.pandas.ui.fragment.search

import AppInstance
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.WanAndroidAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import kotlinx.coroutines.launch

/**
 * @description: wanandroid搜索结果
 * @author: dongyiming
 * @date: 8/25/24 2:27 AM
 * @version: v1.0
 */
public class WanSearchListFragment : BaseFragment<SearchViewModel, LayoutSwipRefreshBinding>() {
    private var currentPage = 0

    private val mAdapter: WanAndroidAdapter by lazy {
        WanAndroidAdapter(mutableListOf(), { id: Int ->
            mViewModel.collectInnerArticle(id)
        }, { id: Int, originId: Int ->
            mViewModel.removeCollectedArticle(id, originId)
        })
    }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop = resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
        binding.recyclerLayout.init(
            CommonItemDecoration(paddingTop = paddingTop),
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.pageSearch(currentPage, mViewModel.keyWords)
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_activity_setting)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                currentPage = 0
                mViewModel.pageSearch(currentPage, mViewModel.keyWords)
            }
        }

        if (AppInstance.instance.isNightMode) {
            binding.swipLayout.setColorSchemeResources(R.color.color_bg_sky)
        } else {
            appViewModel.appColorType.value?.let {
                when (it) {
                    0 -> {
                        binding.swipLayout.setColorSchemeResources(R.color.color_bg_sky)
                    }
                    else -> {
                        binding.swipLayout.setColorSchemeResources(viewColors[it])
                    }
                }
            }
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.pageSearch.collect {
                binding.recyclerLayout.visibility = View.VISIBLE
                if (it.errorCode == 0) {//成功
                    val curPage = it.data.curPage
                    val list = it.data.datas
                    if (list.isNotEmpty()) {
                        if (curPage == 1) {//第一页
                            currentPage = 0
                            mAdapter.refreshAdapter(list.toMutableList())
                            binding.recyclerLayout.isRefreshing(false)
                        } else {
                            mAdapter.loadMore(list.toMutableList())
                        }
                        binding.recyclerLayout.loadMoreFinished(false, true)
                        currentPage++
                    } else {
                        binding.recyclerLayout.loadMoreFinished(true, false)
                    }
                }
                binding.swipLayout.isRefreshing = false
            }
        }

        lifecycleScope.launch {
            mViewModel.collectInnerArticle.collect {
                if (it.errorCode == 0) {
                    toastTopShow(mActivity, "收藏成功")
                } else {
                    toastTopShow(mActivity, "收藏失败:${it.errorMsg}")
                }
            }
        }

        lifecycleScope.launch {
            mViewModel.removeCollectedArticle.collect {
                if (it.errorCode == 0) {
                    toastTopShow(mActivity, "取消收藏成功")
                } else {
                    toastTopShow(mActivity, "取消收藏失败:${it.errorMsg}")
                }
            }
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.pageSearch(currentPage, mViewModel.keyWords)
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}