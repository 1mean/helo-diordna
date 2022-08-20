package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityCollectListBinding
import com.example.pandas.sql.entity.Group
import com.example.pandas.ui.adapter.CollectListAdapter
import com.example.pandas.ui.ext.initNoFooter
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout

/**
 * @description: CollectListActivity
 * @author: dongyiming
 * @date: 8/19/22 1:17 上午
 * @version: v1.0
 */
public class CollectListActivity : BaseActivity<HistoryViewModeL, ActivityCollectListBinding>(),
    CollectListAdapter.CollectListListener {

    private var groupCode: Int = -1
    private var isLike = false

    private val mAdapter by lazy { CollectListAdapter(listener = this) }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.white)

        val group = intent.getParcelableExtra<Group>("group")
        group?.let {
            groupCode = it.groupCode
            binding.txtGroupTitle.text = it.groupName
            binding.txtCollectListTitle.text = it.groupName
            binding.txtCollectListCounts.text =
                StringBuilder(it.videoCounts.toString()).append("个内容").toString()
            binding.txtCollectListCreator.text =
                StringBuilder("创建者：").append(AppInfos.AUTHOR_NAME).toString()
        }
        loadCenterRoundedCornerImage(this, 15, group?.groupCover, binding.imgCollectListCover)

        val padding = resources.getDimension(R.dimen.item_home_padding).toInt()

        binding.rvCollectList.initNoFooter(
            adapter = mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPageGroupItem(false, groupCode)
                }
            })

        binding.barCollect.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            //像上滑动时，verticalOffset为负值，完全展示时为0
            if (verticalOffset <= -216) {
                binding.txtCollectListTitle.visibility = View.VISIBLE
            } else {
                binding.txtCollectListTitle.visibility = View.GONE
            }
        })

        binding.llayoutCollectListLike.setOnClickListener {

            if (isLike) {
                binding.imgLike.setImageResource(R.mipmap.img_collect_list_like)
            } else {
                binding.imgLike.setImageResource(R.mipmap.img_collect_list_liked)
            }
            isLike = !isLike
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getPageGroupItem(true, groupCode)
    }

    override fun createObserver() {

        mViewModel.groupListResult.observe(this) {

            if (it.isSuccess) {

                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.rvCollectList.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.rvCollectList.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }
}