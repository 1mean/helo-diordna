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
import com.example.pandas.databinding.ActivityCollectBinding
import com.example.pandas.ui.adapter.CollectAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.launcherActivity
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.dialog.DeletePopuWindow
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 我的收藏
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

            if (result.resultCode == RESULT_OK) {
                binding.refreshCollect.isRefreshing = true
                mViewModel.getCollects()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop = resources.getDimension(R.dimen.common_lh_6_dimens).toInt()
        binding.rvCollect.run {
            adapter = mAdapter
            addItemDecoration(CommonItemDecoration(paddingTop = paddingTop))
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
            launcherActivity(requestLauncher, this, GroupCreateActivity::class.java)
        }

        appViewModel.appColorType.value?.let {

            binding.refreshCollect.setColorSchemeResources(viewColors[it])
            binding.clayoutCollectTop.setBackgroundResource(viewColors[it])
            if (it == 0) {
                binding.ibnCollectBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                binding.txtCollectTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
                binding.btnCollectAdd.setImageResource(R.mipmap.img_topview_add_black)
            } else {
                binding.ibnCollectBack.setImageResource(R.mipmap.img_setting_top_back_white)
                binding.txtCollectTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
                StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                binding.btnCollectAdd.setImageResource(R.mipmap.img_topview_add_white)
            }
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
                        .asLoading(
                            null,
                            R.layout.layout_waiting,
                            LoadingPopupView.Style.ProgressBar
                        )
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