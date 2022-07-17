package com.example.pandas.ui.activity

import ListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.ActivityListBinding
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration2
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 统一的列表
 * @author: dongyiming
 * @date: 7/16/22 1:22 上午
 * @version: v1.0
 */
public class ListActivity : BaseActivity<LocalCacheViewModel, ActivityListBinding>() {

    private var type: Int = -1
    private var localFilePath: String? = null
    private var title: String? = null

    private val mAdapter by lazy { ListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)

        type = intent.getIntExtra("list_type", -1)
        localFilePath = intent.getStringExtra("localFilePath")
        title = intent.getStringExtra("title")

        val paddingTop = resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        val paddingSides = resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        val paddingMid = resources.getDimension(R.dimen.common_lh_5_dimens).toInt()

        binding.refreshList.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerviewList.isRefreshing(true)
                localFilePath?.let {
                    mViewModel.getLocalVideos(true, it)
                }
            }
        }

        binding.recyclerviewList.init(
            CommonItemDecoration2(
                false,
                2,
                paddingTop,
                paddingSides,
                paddingMid,
                0
            ),
            mAdapter,
            GridLayoutManager(this, 2),
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {

                    localFilePath?.let {
                        mViewModel.getLocalVideos(false, it)
                    }
                }
            }
        )

        binding.viewListTop.ibnTopFinish.setOnClickListener {
            finish()
        }
        binding.viewListTop.ibnTopSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }

    override fun createObserver() {

        mViewModel.localVideos.observe(this) {

            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerviewList.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerviewList.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.refreshList.isRefreshing = false
            binding.llayoutActivityList.visibility = View.VISIBLE
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()

        title?.let {
            binding.viewListTop.txtTopName.text = it
        }
        localFilePath?.let {
            mViewModel.getLocalVideos(true, it)
        }
    }
}