package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.CollectViewModeL
import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.FallsShortVideoAdapter
import com.example.pandas.ui.adapter.decoration.FallsItemDecoration
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import kotlinx.coroutines.launch

/**
 * @description: CollectFragment
 * @author: dongyiming
 * @date: 8/27/24 5:34 PM
 * @version: v1.0
 */
public class CollectFragment : BaseFragment<CollectViewModeL, LayoutSwipRefreshBinding>(),
    FallsShortVideoAdapter.ItemListener {

    private var pageCount = 10
    private var pageIndex = 0
    private var groupCode = 0
    private val mAdapter: FallsShortVideoAdapter by lazy { FallsShortVideoAdapter(listener = this) }
    override fun lazyLoadTime(): Long = 0

    companion object {
        fun newInstance(groupCode: Int) = CollectFragment().apply {
            arguments = Bundle().apply {
                putInt("groupCode", groupCode)
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        groupCode = arguments?.getInt("groupCode") ?: 0

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_6_dimens).toInt()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //1,条目闪动
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        binding.recyclerLayout.init(
            FallsItemDecoration(2, padding, padding, padding, padding),
            mAdapter,
            layoutManager,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getGroupVideos(groupCode, pageIndex * pageCount, pageCount)
                }
            })

        binding.swipLayout.run {
            //setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_falls_short))
            setBackgroundResource(R.drawable.shape_video_short)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                pageIndex = 0
                mViewModel.getGroupVideos(groupCode, 0, pageCount)
            }
        }

        //2,下拉一段距离后回到顶部，发现两列之间的距离变大了，而且一直刷新后位置错乱也解决了
        binding.recyclerLayout.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun createObserver() {

        lifecycleScope.launch {
            mViewModel.groupsVideosFlow.collect {
                Log.e("1meaadsan","size=${it.size}")
                if (pageIndex == 0) {//刷新
                    if (it.isNotEmpty()) {
                        mAdapter.refreshAdapter(it)
                        binding.recyclerLayout.isRefreshing(false)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        pageIndex++
                    } else {
                        mAdapter.clear()
                    }
                } else {
                    if (it.isNotEmpty()) {
                        mAdapter.loadMore(it)
                        binding.recyclerLayout.visibility = View.VISIBLE
                        pageIndex++
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty(), it.size >= pageCount)
                binding.swipLayout.visibility = View.VISIBLE
                binding.swipLayout.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getGroupVideos(groupCode, pageIndex * pageCount, pageCount)
        binding.swipLayout.isRefreshing = true
    }

    override fun updataVideoData(videoData: VideoData) {
        //mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun updatePetVideo(video: PetVideo) {
        //mViewModel.updatePetVideo(video)
    }
}