package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadPandaBackGround
import com.example.pandas.biz.interaction.PagerChangedListener
import com.example.pandas.biz.viewmodel.OneVerticalViewModel
import com.example.pandas.databinding.ActivityTwoVerticalBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.ui.adapter.CommonBannerAdapter
import com.example.pandas.ui.adapter.TwoVerticalAdapter
import com.example.pandas.ui.adapter.decoration.CommonBannerItemDecoration
import com.example.pandas.ui.ext.PandaInfo
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
public class TwoVerticalActivity :
    BaseActivity<OneVerticalViewModel, ActivityTwoVerticalBinding>() {

    private val mAdapter: TwoVerticalAdapter by lazy { TwoVerticalAdapter(mutableListOf()) }

    private var title: String = ""
    private var isShowMore: Boolean = false

    override fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    override fun initView(savedInstanceState: Bundle?) {

        title = intent.getStringExtra("title").toString()
        runOnUiThread {
            binding.txtCmBannerTitle.text = title
            binding.txtBannerListTitle.text = title
            loadCenterImage(this, PandaInfo.getHeader(title), binding.imgBannerListHeader)
            binding.txtPandaId.text = PandaInfo.getPandaCode(title).toString().plus(" [ 谱系号 ]")
            binding.txtPandaDesc.text = PandaInfo.getPandaDesc(title)
        }

        binding.txtPandaMore.setOnClickListener {
            with(binding.txtPandaDesc) {
                if (isShowMore) {
                    maxLines = 1
                    minLines = 1
                    binding.txtPandaMore.text = "展开"
                } else {
                    maxLines = Int.MAX_VALUE
                    minLines = 1
                    binding.txtPandaMore.text = "收起"
                }
            }
            isShowMore = !isShowMore
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

        binding.rvBannerList.init(
            CommonBannerItemDecoration(this),
            mAdapter,
            GridLayoutManager(this, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPandas(false, title)
                }
            })

        binding.btnCmBannerLeft.setOnClickListener {
            finish()
        }

        binding.clayoutBannerTopSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }
    }

    override fun createObserver() {

        mViewModel.pandaResult.observe(this) {

            if (it.isSuccess) {
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
                                                this@TwoVerticalActivity,
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
        mViewModel.getPandas(true, title)
    }
}