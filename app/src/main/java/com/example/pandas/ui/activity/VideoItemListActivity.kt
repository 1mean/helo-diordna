package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.PandaViewModel
import com.example.pandas.databinding.ActivityVideoListBinding
import com.example.pandas.ui.adapter.PandaListAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.launch

/**
 * @description: VideoItemListActivity
 * @author: dongyiming
 * @date: 3/28/22 6:26 下午
 * @version: v1.0
 */
public class VideoItemListActivity : BaseActivity<PandaViewModel, ActivityVideoListBinding>() {

    private val mAdapter: PandaListAdapter by lazy { PandaListAdapter(mutableListOf()) }

    private var title: String? = null

    private var isFirstShow: Boolean = true

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)

        val padding = resources.getDimension(R.dimen.dimen_padding_panda_list).toInt()

        title = intent.getStringExtra("title")

        binding.txtPandaName.text = title
        binding.ibnPanda.setOnClickListener { finish() }

        binding.recyclerLayout.init(
            CommonItemDecoration(false, 2, padding, padding),
            mAdapter,
            GridLayoutManager(this@VideoItemListActivity, 2),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    title?.let { mViewModel.getPandas(false, it) }
                }
            })

        binding.swipLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                title?.let { mViewModel.getPandas(true, it) }
            }
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (isFirstShow) {
            isFirstShow = false
            binding.swipLayout.isRefreshing = true
            title?.let { mViewModel.getPandas(true, it) }
        }
    }

    override fun createObserver() {

        lifecycleScope.launch {
            mViewModel.pandaResult.collect {

                if (it.isSuccess) {
                    binding.recyclerLayout.visibility = View.VISIBLE
                    when {
                        it.isFirstEmpty -> {
                            binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                        }
                        it.isRefresh -> {
                            binding.recyclerLayout.isRefreshing(false)
                            mAdapter.refreshAdapter(it.listData)
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
}