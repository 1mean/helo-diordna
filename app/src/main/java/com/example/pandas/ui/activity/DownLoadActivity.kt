package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.interaction.OnSureListener
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityCollectBinding
import com.example.pandas.databinding.ActivityDownloadBinding
import com.example.pandas.ui.adapter.CacheListAdapter
import com.example.pandas.ui.adapter.CollectAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.launcherActivity
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.dialog.DeletePopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 我的下载
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class DownLoadActivity : BaseActivity<SelfViewModel, ActivityDownloadBinding>() {

    private val mAdapter: CacheListAdapter by lazy { CacheListAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.rvDownloadList.apply {
            layoutManager = LinearLayoutManager(this@DownLoadActivity)
            adapter = mAdapter
        }

        appViewModel.appColorType.value?.let {
            binding.clayoutDownloadTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.ibnHistoryBack.setImageResource(R.mipmap.img_top_leave)
                binding.txtHistoryTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnHistoryBack.setImageResource(R.mipmap.img_top_leave_white)
                binding.txtHistoryTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
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