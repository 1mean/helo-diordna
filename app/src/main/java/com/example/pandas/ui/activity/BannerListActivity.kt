package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadPandaBackGround
import com.example.pandas.biz.interaction.PagerChangedListener
import com.example.pandas.biz.viewmodel.BannerListViewModel
import com.example.pandas.biz.viewmodel.OneVerticalViewModel
import com.example.pandas.databinding.ActivityBannerListBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.ui.adapter.CommonBannerAdapter
import com.example.pandas.ui.adapter.PandaListAdapter
import com.example.pandas.ui.adapter.decoration.CommonBannerItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout

/**
 * @description: BannerListActivity
 * @author: dongyiming
 * @date: 3/27/22 11:46 下午
 * @version: v1.0
 */
public class BannerListActivity : BaseActivity<BannerListViewModel, ActivityBannerListBinding>() {

    private val mAdapter: PandaListAdapter by lazy { PandaListAdapter(mutableListOf()) }

    override fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    override fun initView(savedInstanceState: Bundle?) {

        val title = intent.getStringExtra("title")
        binding.txtCmBannerTitle.text = title
        binding.txtBannerListTitle.text = title

        val status = appViewModel.appColorType.value
        if (status == null) {

        } else {

        }

        binding.barCmBanner.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset < 0 && verticalOffset < -157) {
                binding.tbBannerList.visibility = View.VISIBLE
                binding.txtBannerListTitle.visibility = View.GONE
            } else {
                binding.tbBannerList.visibility = View.GONE
                binding.txtBannerListTitle.visibility = View.VISIBLE
            }
//            if (verticalOffset == 0) {
//                binding.txtCmBannerTitle.visibility = View.GONE
//                binding.btnCmBannerLeft.visibility = View.GONE
//
//            } else if (abs(verticalOffset) >= 0.5 * appBarLayout.totalScrollRange) {
//                binding.tbBannerList.visibility = View.VISIBLE
//                if (!binding.txtCmBannerTitle.isVisible) {
//                    binding.txtCmBannerTitle.visibility = View.VISIBLE
//                    binding.btnCmBannerLeft.visibility = View.VISIBLE
//                    binding.txtCmBannerTitle.text = title
//                }
//            } else {
//                binding.txtCmBannerTitle.visibility = View.GONE
//                binding.btnCmBannerLeft.visibility = View.GONE
//            }
        })

        binding.btnCmBannerLeft.setOnClickListener {
            finish()
        }

        binding.rvBannerList.init(
            CommonBannerItemDecoration(this),
            mAdapter,
            GridLayoutManager(this, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    Log.e("1mean","onLoadMore")
                    mViewModel.getBest(false)
                }
            })

        binding.llayoutBannerBest.setOnClickListener {
            val intent = Intent(
                this@BannerListActivity,
                BannerChildListActivity::class.java
            ).putExtra("title", "最优质")
            startActivity(intent)
        }

        binding.clayoutBannerTopSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }
    }

    override fun createObserver() {

        mViewModel.bestList.observe(this) {
            if (it.isSuccess) {
                Log.e("1mean","hasmore: ${it.hasMore}")
                when {
                    it.isRefresh -> {
                        val bannerList = mutableListOf<PetVideo>()
                        val itemList = mutableListOf<VideoAndUser>()
                        it.listData.forEachIndexed { index, videoAndUser ->
                            if (index < 5) {
                                bannerList.add(videoAndUser.video)
                            } else {
                                itemList.add(videoAndUser)
                            }
                        }
                        if (bannerList.isNotEmpty()) {
                            val adapter = CommonBannerAdapter(bannerList)
                            binding.bannerCmTop.setLifecycleRegistry(lifecycle)
                                .setPagePadding(60, 60, 36)
                                .addPageChangeListener(object : PagerChangedListener {
                                    override fun onChange(position: Int) {
                                        bannerList[position].cover?.let {
                                            loadPandaBackGround(
                                                this@BannerListActivity,
                                                it,
                                                binding.clayoutBannerList
                                            )
                                        }
                                    }
                                }).setAdapter(adapter)
                                .setAutoPlayed(true)
                        }
                        mAdapter.refreshAdapter(itemList)
                        binding.rvBannerList.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.rvBannerList.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getBest(true)
    }
}