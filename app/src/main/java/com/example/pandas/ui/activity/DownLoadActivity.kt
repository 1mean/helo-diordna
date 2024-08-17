package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityDownloadBinding
import com.example.pandas.ui.adapter.CacheListAdapter
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 我的下载
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class DownLoadActivity : BaseActivity<SelfViewModel, ActivityDownloadBinding>() {

    private val mAdapter: CacheListAdapter by lazy { CacheListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutDownloadTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtSettingTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtSettingTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.rvDownloadList.apply {
            layoutManager = LinearLayoutManager(this@DownLoadActivity)
            adapter = mAdapter
        }
    }

    override fun createObserver() {
        mViewModel.cacheList.observe(this) {
            mAdapter.refreshAdapter(it)
        }
    }

    override fun firstOnResume() {
        mViewModel.getCacheList(this)
    }
}