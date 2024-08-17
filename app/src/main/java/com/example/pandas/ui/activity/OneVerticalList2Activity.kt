package com.example.pandas.ui.activity

import OneVertical2Adapter
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.activity.BaseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.OneVerticalViewModel
import com.example.pandas.databinding.ActivityOneVerticalList2Binding
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlin.math.abs

/**
 * @description: 只有一行一列的activity   目前使用于"娱乐-每个item"
 * @author: dongyiming
 * @date: 7/16/23 6:41 PM
 * @version: v1.0
 */
public class OneVerticalList2Activity :
    BaseActivity<OneVerticalViewModel, ActivityOneVerticalList2Binding>() {

    private var title: String = ""
    private var type: Int = -1
    private val mAdapter: OneVertical2Adapter by lazy { OneVertical2Adapter(mutableListOf()) }

    fun initStatusView() {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
    }

    override fun initView(savedInstanceState: Bundle?) {

        initStatusView()
        title = intent.getStringExtra("title").toString()
        type = intent.getIntExtra("type", -1)

        binding.txtOneTopTitle.text = title
        binding.txtOneTopTitle.visibility = View.GONE
        binding.txtTwoHugeTitle.text = StringBuilder("ipanda").append(title).toString()
        binding.rvOne.init(
            null,
            mAdapter,
            LinearLayoutManager(this),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getListResult(false, type)
                }
            })

        binding.clayoutOneSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }

        binding.ibnOneBack.setOnClickListener {
            finish()
        }

        Glide.with(this).asBitmap().load(R.mipmap.img_bg_vertical_one2)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(2, 7)))
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    binding.appbarVertical.background = BitmapDrawable(resources, resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })

        binding.appbarVertical.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                binding.txtOneTopTitle.visibility = View.GONE
            } else if (abs(verticalOffset) >= appBarLayout.totalScrollRange) {
                binding.txtOneTopTitle.visibility = View.VISIBLE
                appViewModel.appColorType.value?.let {
                    if (it == 0) {
                        binding.collVertical.setContentScrimResource(R.color.black)
                    } else {
                        binding.collVertical.setContentScrimResource(viewColors[it])
                    }
                }
            }
        })
    }

    override fun createObserver() {

        mViewModel.itemListResult.observe(this) {

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
        mViewModel.getListResult(true, type)
    }
}