package com.example.pandas.ui.activity

import OneVerticalAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.OneVerticalViewModel
import com.example.pandas.databinding.ActivityOneVerticalListBinding
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 只有一行一列的activity   目前使用于"热门-每周必看"
 * @author: dongyiming
 * @date: 7/16/23 6:41 PM
 * @version: v1.0
 */
public class OneVerticalListActivity :
    BaseActivity<OneVerticalViewModel, ActivityOneVerticalListBinding>() {

    private var title: String = ""
    private val mAdapter: OneVerticalAdapter by lazy { OneVerticalAdapter(mutableListOf(), title) }

    override fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    override fun initView(savedInstanceState: Bundle?) {

        title = intent.getStringExtra("title").toString()
        binding.txtOneTopTitle.text = title

        binding.txtOneHugeTitle.text = StringBuilder("ipanda").append(title).toString()

        if (title == "每周必看") {
            binding.root.setBackgroundResource(R.color.color_bg_purple)
            binding.llayoutTopOneVertical.setBackgroundResource(R.color.color_bg_purple)
        } else {
            binding.root.setBackgroundResource(R.color.color_bg_yellow)
            binding.llayoutTopOneVertical.setBackgroundResource(R.color.color_bg_yellow)
        }
        binding.txtTopDesc.text = "$title 已暂停更新！！"

        binding.rvOne.init(
            null,
            mAdapter,
            LinearLayoutManager(this),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getBest(false)
                }
            })

        binding.clayoutOneSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }

        binding.ibnOneBack.setOnClickListener {
            finish()
        }
    }

    override fun createObserver() {

        mViewModel.bestList.observe(this) {

            if (it.isSuccess) {

                binding.rvOne.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.rvOne.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.rvOne.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getBest(true)
    }

}