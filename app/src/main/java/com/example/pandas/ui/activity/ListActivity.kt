package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.ActivityListBinding
import com.example.pandas.ui.adapter.ListAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration2
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 熊猫-绩笑/肉肉
 * @author: dongyiming
 * @date: 7/16/22 1:22 上午
 * @version: v1.0
 */
public class ListActivity : BaseActivity<LocalCacheViewModel, ActivityListBinding>() {

    /**
     *  type = 1 从PandaFragment进入
     *  type = 2 从本地缓存列表进入
     */
    private var type: Int = -1
    private var localFilePath: String? = null
    private var title: String? = null

    private val mAdapter by lazy { ListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        type = intent.getIntExtra("list_type", -1)
        localFilePath = intent.getStringExtra("localFilePath")
        title = intent.getStringExtra("title")

        val paddingTop = resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        val paddingSides = resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        val paddingMid = resources.getDimension(R.dimen.common_lh_5_dimens).toInt()

        binding.refreshList.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerviewList.isRefreshing(true)
                request(true)
            }
        }

        binding.recyclerviewList.init(
            CommonItemDecoration2(
                false,
                2,
                paddingTop,
                paddingSides,
                paddingMid,
                0
            ),
            mAdapter,
            GridLayoutManager(this, 2),
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    request(false)
                }
            }
        )

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.refreshList.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.refreshList.setColorSchemeResources(viewColors[it])
            }
            StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
            binding.viewListTop.setBackgroundResource(viewColors[it])
            binding.txtPandaTitle.setTextColor(ContextCompat.getColor(this, viewColors[0]))
            binding.ibnPandaBack.setImageResource(R.mipmap.img_setting_top_back_white)
            binding.btnPandaSearch.setImageResource(R.mipmap.img_topview_search_white)
        }

        binding.ibnPandaBack.setOnClickListener {
            finish()
        }

        binding.btnPandaSearch.setOnClickListener {
            startActivity(Intent(this, NewSearchActivity::class.java))
        }
    }

    override fun createObserver() {

        mViewModel.localVideos.observe(this) {

            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerviewList.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerviewList.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.refreshList.isRefreshing = false
            binding.llayoutActivityList.visibility = View.VISIBLE
        }

        mViewModel.pandaResult.observe(this) {

            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerviewList.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerviewList.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.refreshList.isRefreshing = false
            binding.llayoutActivityList.visibility = View.VISIBLE
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()

        title?.let {
            binding.txtPandaTitle.text = it
        }
        request(true)
    }

    private fun request(isRefresh: Boolean) {
        when (type) {
            1 -> {
                title?.let {
                    mViewModel.getPandas(isRefresh, it)
                }
            }
            2 -> {
                localFilePath?.let {
                    mViewModel.getLocalVideos(isRefresh, it)
                }
            }
        }
    }
}