package com.example.pandas.ui.fragment.main.live

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.LiveViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.LiveVideoAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 动态-视频
 * @author: dongyiming
 * @date: 10/10/22 5:05 下午
 * @version: v1.0
 */
public class LiveVideoFragment : BaseLazyFragment<LiveViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: LiveVideoAdapter by lazy { LiveVideoAdapter() }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_10_dimens).toInt()
        binding.recyclerLayout.init(
            CommonItemDecoration(paddingBottom = padding),
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getLiveVideo(false)
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_viewpager_bg)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getLiveVideo(true)
                binding.recyclerLayout.isRefreshing(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.liveVideos.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        Log.e("1mean", "videoCOutns: ${it.liveVides.lives.size}")
                        mAdapter.refresh(it.liveVides)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        //mAdapter.updata(false, it.landscapeData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        mViewModel.getLiveVideo(true)
    }

}