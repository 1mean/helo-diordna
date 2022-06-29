package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.ext.init
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutOnlyLoadmoreBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.MusicChildAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.init2
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: MusicChildFragment
 * @author: dongyiming
 * @date: 6/28/22 12:33 下午
 * @version: v1.0
 */
public class MusicChildFragment : BaseLazyFragment<HomePageViewModel, LayoutOnlyLoadmoreBinding>() {

    private val mAdapter:MusicChildAdapter by lazy { MusicChildAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {
        val type = requireArguments().getInt("type")

        binding.rvLoadmore.run {
            init2(
                null, mAdapter,
                LinearLayoutManager(context),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getSongData(false)
                    }
                })
        }
    }

    override fun createObserver() {

        mViewModel.songDataWrapper.observe(viewLifecycleOwner){

            Log.e("1mean","size: ${it.listData.size}, ${it.isRefresh}")
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