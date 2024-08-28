package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.vm.BaseViewModel
import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import com.example.pandas.databinding.ActivityIntegralBinding
import com.example.pandas.ui.adapter.IntegralAdapter
import com.example.pandas.ui.adapter.WanAndroidAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * @description: 积分
 * @author: dongyiming
 * @date: 5/27/23 5:54 PM
 * @version: v1.0
 */
public class IntegralActivity : BaseActivity<WanAndroidViewModel, ActivityIntegralBinding>() {

    private val mAdapter: IntegralAdapter by lazy { IntegralAdapter() }
    private var currentPage = 0

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_activity_setting)
        } else {
            appViewModel.appColorType.value?.let {
                if (it == 0) {
                    binding.clayoutLaterTop.setBackgroundResource(R.color.color_bg_activity_setting)
                    binding.ibnIntegralBack.setImageResource(R.mipmap.img_topview_back)
                    binding.ibtnIntegralRule.setImageResource(R.mipmap.img_intrgral_rule)
                    binding.txtLaterTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_activity_setting)
                } else {
                    binding.clayoutLaterTop.setBackgroundResource(viewColors[it])
                    binding.ibtnIntegralRule.setImageResource(R.mipmap.img_intrgral_rule_white)
                    binding.ibnIntegralBack.setImageResource(R.mipmap.img_topview_back_white)
                    binding.txtLaterTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        val paddingTop = resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
        binding.recyclerLayout.init(
            CommonItemDecoration(paddingTop = paddingTop),
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getCoinHistory(currentPage)
                }
            })

        binding.ibtnIntegralRule.setOnClickListener {
            val intent = Intent(this, WanContentActivity::class.java)
            intent.putExtra("url", "https://www.wanandroid.com/blog/show/2653")
            startActivity(intent)
        }

    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.coinFlow.collect {
                if (it.errorCode == 0) {
                    Log.e("12344mean", "1111111111111111111")
                    binding.txtCoin.text = it.data.coinCount.toString()
                    Log.e("12344mean", "rank=${it.data.rank}")
                    binding.txtCoinRank.visibility = View.VISIBLE
                    binding.txtCoinRank.text = "积分排行：" + it.data.rank.toString()
                } else {
                    binding.txtCoin.text = "0"
                    Log.e("12344mean", "222222222222222222")
                }
                Log.e("12344mean", "333333333333333333333333333")
                binding.txtIntegral.visibility = View.VISIBLE
            }
        }

        lifecycleScope.launch {
            mViewModel.coinHistoryFlow.collect {
                binding.recyclerLayout.visibility = View.VISIBLE
                if (it.errorCode == 0) {
                    binding.progressBar.visibility = View.GONE
                    if (it.data.datas.isNotEmpty()) {
                        if (it.data.curPage == 1) {
                            mAdapter.refreshAdapter(it.data.datas.toMutableList())
                        } else {
                            mAdapter.loadMore(it.data.datas.toMutableList())
                        }
                        binding.recyclerLayout.loadMoreFinished(false, true)
                        currentPage++
                    } else {
                        binding.recyclerLayout.loadMoreFinished(true, false)
                    }
                }
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getCoin()
        mViewModel.getCoinHistory(currentPage)
    }

}