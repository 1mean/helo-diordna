package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoAndUser
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.biz.ext.loadPandaBackGround
import com.example.pandas.biz.interaction.PagerChangedListener
import com.example.pandas.biz.viewmodel.BannerListViewModel
import com.example.pandas.databinding.ActivityBannerListBinding
import com.example.pandas.ui.adapter.BannerListAdapter
import com.example.pandas.ui.adapter.CommonBannerAdapter
import com.example.pandas.ui.adapter.decoration.CommonBannerItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
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

    private val mAdapter: BannerListAdapter by lazy { BannerListAdapter(mutableListOf()) }

    fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    override fun initView(savedInstanceState: Bundle?) {

        initStatusView()
        binding.refreshBannerList.apply {
            setProgressViewEndTarget(true, 300)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getBest(true)
            }
        }

        //解决AppBarLayout和SwipeRefreshLayout的滑动冲突问题,同时也解决了SwipeRefreshLayout和Recyclerview的滑动冲突问题
        binding.barCmBanner.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            //像上滑动时，verticalOffset为负值，完全展示时为0
            binding.refreshBannerList.isEnabled = verticalOffset >= 0
        })

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
                    Log.e("1mean", "onLoadMore")
                    mViewModel.getBest(false)
                }
            })

        binding.llayoutBannerBestItem1.setOnClickListener {
            val intent = Intent(
                this@BannerListActivity,
                BannerChildListActivity::class.java
            ).putExtra("title", "新")
            startActivity(intent)
        }
        binding.llayoutBannerBestItem2.setOnClickListener {
            val intent = Intent(
                this@BannerListActivity,
                BannerChildListActivity::class.java
            ).putExtra("title", "年")
            startActivity(intent)
        }
        binding.llayoutBannerBestItem3.setOnClickListener {
            val intent = Intent(
                this@BannerListActivity,
                BannerChildListActivity::class.java
            ).putExtra("title", "快")
            startActivity(intent)
        }
        binding.llayoutBannerBestItem4.setOnClickListener {
            val intent = Intent(
                this@BannerListActivity,
                BannerChildListActivity::class.java
            ).putExtra("title", "乐")
            startActivity(intent)
        }

        binding.clayoutBannerTopSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }

        mViewModel.getBest(true)
    }

    override fun createObserver() {

        mViewModel.bestList.observe(this) {
            if (it.isSuccess) {
                Log.e("1mean", "hasmore: ${it.hasMore}")
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
            binding.refreshBannerList.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
    }
}