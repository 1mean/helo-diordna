package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.RankViewModel
import com.example.pandas.databinding.ActivityRankingBinding
import com.example.pandas.ui.adapter.VideoListAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 播放榜单
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class RankingActivity : BaseActivity<RankViewModel, ActivityRankingBinding>() {

    private val mAdapter: VideoListAdapter by lazy { VideoListAdapter(mutableListOf()) }

    private var loadingPopup: LoadingPopupView? = null

    override fun initView(savedInstanceState: Bundle?) {

        val title = intent.getStringExtra("title")
        binding.txtPlayTitle.text = title

        binding.recyclerLayoutRank.init(
            null, mAdapter, LinearLayoutManager(this),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getRanks(false)
                }
            })

        binding.swipLayoutRank.run {
            isRefreshing = true
            setRefreshColor()
            setOnRefreshListener {
                binding.swipLayoutRank.isRefreshing = true
                mViewModel.getRanks(true)
            }
        }

        appViewModel.appColorType.value?.let {
            binding.clayoutPlayTop.setBackgroundResource(AppInfos.bgColors[it])
            binding.ibnPlayBack.setImageResource(R.mipmap.img_topview_back_white)
            binding.txtPlayTitle.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
            binding.btnRankingSearch.setImageResource(R.mipmap.img_topview_search_white)
            StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
        }

        binding.btnRankingSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getRanks(true)
    }

    override fun createObserver() {

        mViewModel.ranks.observe(this) {

            if (it.isSuccess) {

                binding.recyclerLayoutRank.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayoutRank.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerLayoutRank.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayoutRank.visibility = View.VISIBLE
            binding.swipLayoutRank.isRefreshing = false
        }
    }
}