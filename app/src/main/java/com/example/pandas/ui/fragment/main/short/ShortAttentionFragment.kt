package com.example.pandas.ui.fragment.main.short

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.databinding.FragmentListShortVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.FallsShortVideoAdapter
import com.example.pandas.ui.adapter.decoration.FallsItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 关注
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class ShortAttentionFragment() :
    BaseLazyFragment<ShortVideoViewModel, FragmentListShortVideoBinding>(),
    FallsShortVideoAdapter.ItemListener {

    private val mAdapter: FallsShortVideoAdapter by lazy { FallsShortVideoAdapter(listener = this) }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_4_dimens).toInt()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //1,条目闪动
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        binding.recyclerLayout.init(
            FallsItemDecoration(2, padding, padding, padding, padding),
            mAdapter,
            layoutManager,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getAttentionFallVideos(false)
                }
            })

        binding.swipLayout.run {
            //setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_falls_short))
            setBackgroundResource(R.drawable.shape_video_short)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getAttentionFallVideos(true)
            }
        }

        //2,下拉一段距离后回到顶部，发现两列之间的距离变大了，而且一直刷新后位置错乱也解决了
        binding.recyclerLayout.addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                // 滑动停止，刷新布局与分割线
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (recyclerView.layoutManager is StaggeredGridLayoutManager) {
                        (recyclerView.layoutManager as StaggeredGridLayoutManager?)!!.invalidateSpanAssignments()
                        recyclerView.invalidateItemDecorations()
                    }
                }
            }
        })

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }
    }

    override fun createObserver() {

        mViewModel.attentionShortVideos.observe(viewLifecycleOwner) {

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
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }
    }

    override fun firstOnResume() {
        mViewModel.getAttentionFallVideos(true)
        binding.swipLayout.isRefreshing = true
    }

    override fun refresh() {
        super.refresh()
        mViewModel.getAttentionFallVideos(true)
        binding.swipLayout.isRefreshing = true
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

    override fun updataVideoData(videoData: VideoData) {
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun updatePetVideo(video: PetVideo) {
    }
}