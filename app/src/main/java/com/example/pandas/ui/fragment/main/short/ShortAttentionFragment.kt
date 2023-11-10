package com.example.pandas.ui.fragment.main.short

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.LoginInfo
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.ShortVideoViewModel
import com.example.pandas.databinding.FragmentListShortVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.activity.LoginActivity
import com.example.pandas.ui.adapter.FallsShortVideoAdapter
import com.example.pandas.ui.adapter.decoration.FallsItemDecoration
import com.example.pandas.ui.ext.*
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

    private var loginStatus: Int = 0
    private var isFirstOnResume = false

    private var mAdapter: FallsShortVideoAdapter? = null

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        loginStatus = LoginInfo.instance.getLoginStatus()
        if (loginStatus == 0) {
            binding.recyclerLayout.visibility = View.GONE
            binding.swipLayout.isEnabled = false
            binding.clayoutAttentionLogin.visibility = View.VISIBLE
        }
        val padding = mActivity.resources.getDimension(R.dimen.common_lh_6_dimens).toInt()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //1,条目闪动
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        mAdapter = FallsShortVideoAdapter(listener = this)
        binding.recyclerLayout.init(
            FallsItemDecoration(2, padding, padding, padding, padding),
            mAdapter!!,
            layoutManager,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    Log.e("1mean", "onLoadMore")
                    mViewModel.getAttentionFallVideos(false)
                }
            })

        binding.swipLayout.run {
            //setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_falls_short))
            setBackgroundResource(R.drawable.shape_video_short)
            setRefreshColor()
            setOnRefreshListener {
                if (loginStatus == 1) {
                    binding.recyclerLayout.isRefreshing(true)
                    mViewModel.getAttentionFallVideos(true)
                }
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
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }

        binding.txtLogin.setOnClickListener {
            startAnyActivity(mActivity, LoginActivity::class.java)
        }
    }

    override fun createObserver() {

        //只要进入app就会初始化该fragment，哪怕没有触发onResume(未进入)，退出登录也会执行下面的方法
        appViewModel.loginStatus.observe(viewLifecycleOwner) {

            if (it == 0) {//退出登录
                loginStatus = 0
                binding.swipLayout.isEnabled = false
                //mAdapter = null
                //binding.recyclerLayout.adapter = null
                mAdapter?.clear()
                binding.recyclerLayout.visibility = View.GONE
                binding.clayoutAttentionLogin.visibility = View.VISIBLE
            } else {
                loginStatus = 1
                if (!isFirstOnResume) {//还未进入该界面过
                    binding.clayoutAttentionLogin.visibility = View.GONE
                    binding.swipLayout.isEnabled = true
                } else {//已经进来过该界面
                    binding.clayoutAttentionLogin.visibility = View.GONE
                    binding.swipLayout.isEnabled = true
                    binding.swipLayout.isRefreshing = true
                    mViewModel.getAttentionFallVideos(true)
                }
            }
        }

        mViewModel.attentionShortVideos.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                binding.recyclerLayout.visibility = View.VISIBLE
                if (mAdapter == null) {
                    mAdapter = FallsShortVideoAdapter(listener = this)
                    binding.recyclerLayout.adapter = mAdapter
                }
                when {
                    it.isRefresh -> {
                        mAdapter!!.refreshAdapter(it.listData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter!!.loadMore(it.listData)
                    }
                }
                Log.e("1mean", "${it.isEmpty},${it.hasMore}")
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun firstOnResume() {
        isFirstOnResume = true
        if (loginStatus == 1) {
            mViewModel.getAttentionFallVideos(true)
            binding.swipLayout.isRefreshing = true
        }
    }

    override fun refresh() {
        super.refresh()
        if (loginStatus == 1) {
            mViewModel.getAttentionFallVideos(true)
            binding.swipLayout.isRefreshing = true
            binding.recyclerLayout.smoothScrollToPosition(0)
        }
    }

    override fun updataVideoData(videoData: VideoData) {
        mViewModel.addOrUpdateVideoData(videoData)
    }

    override fun updatePetVideo(video: PetVideo) {
    }
}