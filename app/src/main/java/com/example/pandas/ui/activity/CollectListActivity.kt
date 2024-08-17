package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.android.android_sqlite.entity.Group
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityCollectListBinding
import com.example.pandas.ui.adapter.CollectListAdapter
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.initNoFooter
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: CollectListActivity
 * @author: dongyiming
 * @date: 8/19/22 1:17 上午
 * @version: v1.0
 */
public class CollectListActivity : BaseActivity<HistoryViewModeL, ActivityCollectListBinding>(),
    CollectListAdapter.CollectListListener {

    private var groupCode: Int = -1
    private val mAdapter by lazy { CollectListAdapter(listener = this) }

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutCollectListTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnCollectListBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtCollectListTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.txtCollectListManager.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnCollectListBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtCollectListTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                    binding.txtCollectListManager.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                }
            }
        }

        val group = intent.getParcelableExtra<Group>("group")
        group?.let {
            groupCode = it.groupCode
            Log.e("1mean","groudName: ${it.groupName}")
            binding.txtCollectListTitle.text = it.groupName
        }
        val padding = resources.getDimension(R.dimen.item_home_padding).toInt()

        binding.rvCollectList.initNoFooter(
            adapter = mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPageGroupItem(false, groupCode)
                }
            })
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