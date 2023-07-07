package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.BannerViewModel
import com.example.pandas.databinding.ActivityBannerChildBinding
import com.example.pandas.ui.adapter.BannerChildAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration2
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils


/**
 * @description: BannerChildListActivity
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class BannerChildListActivity : BaseActivity<BannerViewModel, ActivityBannerChildBinding>() {


    private val mAdapter: BannerChildAdapter by lazy { BannerChildAdapter(lifecycle) }

    override fun initView(savedInstanceState: Bundle?) {

        val title = intent.getStringExtra("title")
        binding.txtHistoryTitle.text = title

        val padding: Int = resources.getDimension(R.dimen.common_lh_5_dimens).toInt()
        binding.recyclerLayout.init(
            RecommendDecoration2(padding, padding, padding, padding, padding),
            mAdapter,
            GridLayoutManager(this, 2),
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getBest(false)
                }
            })


        binding.ibnHistoryBack.setOnClickListener {
            finish()
        }

        appViewModel.appColorType.value?.let {
            binding.clayoutHistoryTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.ibnHistoryBack.setImageResource(R.mipmap.img_top_leave)
                binding.txtHistoryTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnHistoryBack.setImageResource(R.mipmap.img_top_leave_white)
                binding.txtHistoryTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getBest(true)
    }

    override fun createObserver() {

        mViewModel.bestList.observe(this) {

            if (it.isSuccess) {
                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshData(it.listData)
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
}