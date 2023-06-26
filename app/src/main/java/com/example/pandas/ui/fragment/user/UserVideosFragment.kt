package com.example.pandas.ui.fragment.user

import UserVideosAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 用户个人中心视频界面
 * @author: dongyiming
 * @date: 4/22/22 1:00 上午
 * @version: v1.0
 */
public class UserVideosFragment : BaseFragment<UserInfoViewModel, LayoutSwipRefreshBinding>() {

    private var user: User? = null

    private val mAdapter: UserVideosAdapter by lazy { UserVideosAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        user = mActivity.intent.getParcelableExtra("user")
        binding.recyclerLayout.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    user?.let {
                        mViewModel.getUserVideos(it.userCode, false)
                    }
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_video_activity)
            setRefreshColor()
            isRefreshing = true
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                user?.let {
                    mViewModel.getUserVideos(it.userCode, true)
                }
            }
        }

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }
    }

    override fun createObserver() {

        mViewModel.userVideos.observe(viewLifecycleOwner) {
            Log.e("listData1","size: ${it.listData.size}")
            it.listData.forEach {
                Log.e("listData1", "listData1: ${it.videoData}")
            }
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
    }

    override fun firstOnResume() {

        user?.let {
            mViewModel.getUserVideos(it.userCode, true)
        }
    }
}