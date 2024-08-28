package com.example.pandas.ui.fragment.main.mine

import AppInstance
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.app.appViewModel
import com.android.base.ui.fragment.BaseFragment
import com.android.base.vm.BaseViewModel
import com.example.pandas.R
import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import com.example.pandas.databinding.FragmentAuthenBinding
import com.example.pandas.databinding.LayoutOnlyLoadmoreBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.WanAndroidAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.ext.*
import com.example.pandas.ui.fragment.main.home.MusicFragment
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView2
import kotlinx.coroutines.launch

/**
 * @description: AuthenFragment
 * @author: dongyiming
 * @date: 10/8/23 11:12 PM
 * @version: v1.0
 */
public class WanAndroidFragment : BaseFragment<WanAndroidViewModel, LayoutSwipRefreshBinding>(),
    WanAndroidAdapter.CollectListener {

    private var currentPage = 0
    private var cardNo = 0
    private var position = 0
    private val mAdapter: WanAndroidAdapter by lazy { WanAndroidAdapter(listener = this) }

    companion object {
        fun newInstance(position: Int, card: Int) = WanAndroidFragment().apply {
            arguments = Bundle().apply {
                putInt("position", position)
                putInt("card_id", card)
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        cardNo = arguments?.getInt("card_id") ?: 0
        //有三个类型的界面需要使用到这个fragment
        position = arguments?.getInt("position") ?: 0

        val paddingTop = resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
        binding.recyclerLayout.init(
            CommonItemDecoration(paddingTop = paddingTop),
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    if (position == 0) {
                        mViewModel.homePageArticles(currentPage)
                    } else {
                        mViewModel.wxPageArticles(cardNo, currentPage++)
                    }
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_activity_setting)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                currentPage = 0
                if (position == 0) {
                    mViewModel.homePageArticles(currentPage)
                } else {
                    mViewModel.wxPageArticles(cardNo, currentPage)
                }
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
            mViewModel.pageArticles.collect {
                binding.recyclerLayout.visibility = View.VISIBLE
                if (it.errorCode == 0) {//成功
                    val list = it.data.datas
                    if (list.isNotEmpty()) {
                        if (currentPage == 0) {
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
                //binding.swipLayout.visibility = View.VISIBLE
                binding.swipLayout.isRefreshing = false
            }
        }

        lifecycleScope.launch {
            mViewModel.homePageArticles.collect {
                binding.recyclerLayout.visibility = View.VISIBLE
                if (it.errorCode == 0) {//成功
                    val list = it.data.datas
                    if (list.isNotEmpty()) {
                        if (currentPage == 0) {
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
                //binding.swipLayout.visibility = View.VISIBLE
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
        if (position == 0) {
            mViewModel.homePageArticles(currentPage)
        } else {
            mViewModel.wxPageArticles(cardNo, currentPage++)
        }
    }

    override fun collect(id: Int) {
        mViewModel.collectInnerArticle(id)
    }

    override fun removeCollect(id: Int, originId: Int) {
        Log.e("1mean", "id:$id")
        mViewModel.removeCollectedArticle(id, originId)
    }
}