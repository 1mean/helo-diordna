package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.app.getHehuaBanner
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadLayoutBackGround
import com.example.pandas.biz.ext.loadPandaBackGround
import com.example.pandas.biz.interaction.PagerChangedListener
import com.example.pandas.biz.viewmodel.BannerListViewModel
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.ActivityBannerListBinding
import com.example.pandas.databinding.ActivityCmBannerBinding
import com.example.pandas.ui.adapter.ActivityPandaAdapter
import com.example.pandas.ui.adapter.CommonBannerAdapter
import com.example.pandas.ui.adapter.PandaListAdapter
import com.example.pandas.ui.adapter.decoration.CommonBannerItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.initRv
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

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

        val status = appViewModel.appColorType.value
        if (status == null) {

        } else {

        }

        binding.barCmBanner.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.e(
                "2mean",
                "abs(verticalOffset)=$verticalOffset, appBarLayout.totalScrollRange=${appBarLayout.totalScrollRange}"
            )
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
                    Log.e("1mean", "123123")
                    mViewModel.getBannerList(false)
                }
            })

        binding.llayoutBannerBest.setOnClickListener {
            val intent = Intent(
                this@BannerListActivity,
                BannerChildListActivity::class.java
            ).putExtra("title", "最优质")
            startActivity(intent)
        }
    }

    override fun createObserver() {

        mViewModel.bannerList.observe(this) {
            Log.e("1mean", "list: ${it.bannerList.itemList.size}")
            if (it.isSuccess) {
                binding.rvBannerList.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        val banners = it.bannerList.bannerList
                        if (banners.isNotEmpty()) {
                            val adapter = CommonBannerAdapter(banners)
                            binding.bannerCmTop.setLifecycleRegistry(lifecycle)
                                .setPagePadding(60, 60, 36)
                                .addPageChangeListener(object : PagerChangedListener {
                                    override fun onChange(position: Int) {
                                        banners[position].cover?.let {
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
                        binding.rvBannerList.isRefreshing(false)
                        mAdapter.refreshAdapter(it.bannerList.itemList)
                    }
                    else -> {
                        mAdapter.loadMore(it.bannerList.itemList)
                    }
                }
                Log.e("1mean", "isEmpty:${it.isEmpty}, hasMore: ${it.hasMore}")
                binding.rvBannerList.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getBannerList(true)
    }
}