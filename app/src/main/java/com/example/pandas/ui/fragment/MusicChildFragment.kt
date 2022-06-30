package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutOnlyLoadmoreBinding
import com.example.pandas.ui.adapter.MusicChildAdapter
import com.example.pandas.ui.ext.init2
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView2

/**
 * @description: MusicChildFragment
 * @author: dongyiming
 * @date: 6/28/22 12:33 下午
 * @version: v1.0
 */
public class MusicChildFragment : BaseLazyFragment<HomePageViewModel, LayoutOnlyLoadmoreBinding>() {

    private val mAdapter: MusicChildAdapter by lazy { MusicChildAdapter(mutableListOf()) }

    override fun lazyLoadTime(): Long {
        return 0
    }

    override fun initView(savedInstanceState: Bundle?) {
        val type = requireArguments().getInt("type")

        binding.rvLoadmore.run {
            init2(
                null, mAdapter,
                LinearLayoutManager(context),
                object : SwipRecyclerView2.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getSongData(false)
                    }
                })
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

//                    val topRowVerticalPosition =
//                        if (recyclerView.childCount == 0) 0 else recyclerView.getChildAt(0).top
//                    Log.e("MusicChildFragment", "topRowVerticalPosition: $topRowVerticalPosition")
//                    if (parentFragment is MusicFragment) {
//                        val offset = (parentFragment as MusicFragment).getBarVerticalOffset()
//                        Log.e("MusicChildFragment","offset: $offset")
//                        if (topRowVerticalPosition <= 0 && offset == 0) {
//                            (parentFragment as MusicFragment).stopSwipeRefreshLayout()
//                        }
//                    }
                }
            })
        }
    }

    fun getChildTop(): Int {
        binding.rvLoadmore.getChildAt(0)?.let {
            return it.top
        }
        return 0
    }

    override fun createObserver() {

        mViewModel.songDataWrapper.observe(viewLifecycleOwner) {

            Log.e("1mean", "size: ${it.listData.size}, ${it.isRefresh}")
            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)


                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.rvLoadmore.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getSongData(true)
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