package com.example.pandas.ui.fragment

import UserVideosAdapter
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
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

    private val mAdapter: UserVideosAdapter by lazy { UserVideosAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getUserVideos(mViewModel.authorId, false)
                }
            })

        binding.swipLayout.run {
            setBackgroundResource(R.color.white)
            setRefreshColor()
            isRefreshing = true
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getUserVideos(mViewModel.authorId, true)
            }
        }

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
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}