package com.example.pandas.ui.fragment.main.home.music

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutOnlyLoadmoreBinding
import com.example.pandas.ui.adapter.MusicChildAdapter
import com.example.pandas.ui.ext.init2
import com.example.pandas.ui.fragment.main.home.MusicFragment
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView2

/**
 * @description: MusicChildFragment
 * @author: dongyiming
 * @date: 6/28/22 12:33 下午
 * @version: v1.0
 */
public class MusicChildFragment : BaseFragment<HomePageViewModel, LayoutOnlyLoadmoreBinding>() {

    private val mAdapter: MusicChildAdapter by lazy { MusicChildAdapter(mutableListOf(), 0) }

    override fun lazyLoadTime(): Long = 0

    private var type: Int = -1

    override fun initView(savedInstanceState: Bundle?) {
        type = requireArguments().getInt("type")
        binding.rvLoadmore.run {
            init2(
                null, mAdapter,
                LinearLayoutManager(context),
                object : SwipRecyclerView2.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getSongData(false, type)
                    }
                })
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (recyclerView.childCount <= 0) return
                    recyclerView.getChildAt(0)?.let {
                        if (parentFragment is MusicFragment) {
                            if (it.top >= 0 && (parentFragment as MusicFragment).getBarVerticalOffset() >= 0) {
                                (parentFragment as MusicFragment).setSwipeRefreshEnable(true)
                            }
                        }
                    }
                }
            })
        }
    }

    //获取第一个item距离顶部的距离，当距离 <0 时，如果此时AppBarLayout偏移为0，会造成下拉刷新和RecyclerView冲突
    fun getChildTop(): Int {
        binding.rvLoadmore.getChildAt(0)?.let {
            return it.top
        }
        return 0
    }

    override fun againOnResume() {
        super.againOnResume()
        if (parentFragment is MusicFragment) {
            val parent = (parentFragment as MusicFragment)
            if (parent.getBarVerticalOffset() >= 0) {
                binding.rvLoadmore.getChildAt(0)?.let {
                    (parentFragment as MusicFragment).setSwipeRefreshEnable(it.top == 0)
                }
            }
        }
    }

    override fun createObserver() {

        mViewModel.songDataWrapper.observe(viewLifecycleOwner) {

            Log.e("1mean", "size: ${it.listData.size}, ${it.hasMore}")
            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.rvLoadmore.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.rvLoadmore.loadMoreFinished(it.isEmpty, it.hasMore)
                binding.rvLoadmore.visibility = View.VISIBLE
            }
            binding.clayoutLoading.visibility = View.GONE
        }
    }

    override fun firstOnResume() {
        mViewModel.getSongData(true, type)
    }

    companion object {
        fun newInstance(id: Int): MusicChildFragment {
            val args = Bundle().apply { putInt("type", id) }
            val fragment = MusicChildFragment()
            fragment.arguments = args
            return fragment
        }
    }
}