package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.interaction.OnSureListener
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityCollectBinding
import com.example.pandas.ui.adapter.CollectAdapter
import com.example.pandas.ui.adapter.decoration.LandScapeItemDecoration
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.dialog.DeletePopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 稍后再看
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class CollectActivity : BaseActivity<HistoryViewModeL, ActivityCollectBinding>(),
    CollectAdapter.CollectListener {

    private val mAdapter: CollectAdapter by lazy { CollectAdapter(listener = this) }

    private var loadingPopup: LoadingPopupView? = null

    private var position: Int = 0

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            Log.e("1mean", "result: $result")
            if (result.resultCode == RESULT_OK) {
                binding.refreshCollect.isRefreshing = true
                mViewModel.getCollects()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.white)

        val padding = resources.getDimension(R.dimen.common_lh_6_dimens).toInt()
        binding.rvCollect.run {
            adapter = mAdapter
            addItemDecoration(LandScapeItemDecoration(padding))
            layoutManager = LinearLayoutManager(this@CollectActivity)
        }

        binding.refreshCollect.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.refreshCollect.isRefreshing = true
                mViewModel.getCollects()
            }
        }
        binding.ibnCollectBack.setOnClickListener {
            finish()
        }
        binding.btnCollectAdd.setOnClickListener {

            val intent = Intent(this, GroupCreateActivity::class.java)
            requestLauncher.launch(intent)
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        binding.refreshCollect.isRefreshing = true
        mViewModel.getCollects()
    }

    override fun createObserver() {

        mViewModel.collectResult.observe(this) {

            if (it.isSuccess) {
                mAdapter.refreshAdapter(it.listData)
            }
            binding.refreshCollect.isRefreshing = false
        }

        mViewModel.removeResult.observe(this) {

            if (it) {
                loadingPopup?.dismiss()
                mAdapter.deleteItem()
            }
        }
    }

    override fun deleteGroup(groupCode: Int) {

        val popWindow = DeletePopuWindow(this, object : OnSureListener {
            override fun onSure() {
                super.onCancel()
                if (loadingPopup == null) {
                    loadingPopup = XPopup.Builder(this@CollectActivity).dismissOnBackPressed(true)
                        .isLightNavigationBar(true)
                        .isViewMode(false)
                        .asLoading(null, R.layout.layout_waiting)
                    loadingPopup!!.show()
                } else {
                    loadingPopup!!.show()
                }
                mViewModel.removeGroup(groupCode)
            }
        })
        popWindow.setTitle("确定要删除吗？").setBackDark().onShow(binding.rvCollect)
    }
}