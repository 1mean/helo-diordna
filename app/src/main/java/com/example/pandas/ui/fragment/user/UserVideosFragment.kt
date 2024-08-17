package com.example.pandas.ui.fragment.user

import UserVideosAdapter
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.FragmentUserVideosBinding
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 用户个人中心视频界面
 * @author: dongyiming
 * @date: 4/22/22 1:00 上午
 * @version: v1.0
 */
public class UserVideosFragment : BaseFragment<UserInfoViewModel, FragmentUserVideosBinding>() {

    private var userCode: Int = -1

    private val mAdapter: UserVideosAdapter by lazy { UserVideosAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        userCode = mActivity.intent.getIntExtra("userCode", -1)
        binding.recyclerLayout.setIntercept(false)
        binding.recyclerLayout.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getUserVideos(userCode, false)
                }
            })
    }

    override fun createObserver() {

        mViewModel.userVideos.observe(viewLifecycleOwner) {
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
        }
    }

    override fun firstOnResume() {
        mViewModel.getUserVideos(userCode, true)
    }
}