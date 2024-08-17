package com.example.pandas.ui.activity

import AppInstance
import BgSelectAdapter
import BgSplashAdapter
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.android.base.vm.BaseViewModel
import com.example.pandas.databinding.ActivityBgBinding
import com.example.pandas.ui.adapter.decoration.BackgroundItemDecoration
import com.example.pandas.ui.adapter.decoration.SplashItemDecoration
import com.example.pandas.ui.ext.bgNames
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 个性设置
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class BackGroundActivity : BaseActivity<BaseViewModel, ActivityBgBinding>() {

    private val mAdapter by lazy { BgSelectAdapter(itemClick = { itemClick(it) }) }
    private val sAdapter by lazy { BgSplashAdapter(itemClick = { itemSplashClick(it) }) }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop = resources.getDimension(R.dimen.common_lh_15_dimens).toInt()
        val paddingLeft = resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        val paddingRight = resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        val paddingMid = resources.getDimension(R.dimen.common_lh_10_dimens).toInt()

        binding.ibnSettingBack.setOnClickListener { finish() }

        with(binding.rvBg) {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@BackGroundActivity, 4)
            addItemDecoration(BackgroundItemDecoration(paddingTop))
        }

        with(binding.rvSplash) {
            adapter = sAdapter
            layoutManager = GridLayoutManager(this@BackGroundActivity, 3)
            addItemDecoration(
                SplashItemDecoration(
                    paddingTop,
                    paddingLeft,
                    paddingRight,
                    paddingMid
                )
            )
        }

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                update(it)
            }
        }
    }

    override fun createObserver() {
        appViewModel.appColorType.observe(this) {
            update(it)
        }
    }

    override fun onResume() {
        super.onResume()
        val status = SPUtils.getInt(this, AppInfos.BG_STATUS_KEY)
        mAdapter.refreshAdapter(bgNames, status)
        val status2 = SPUtils.getInt(this, AppInfos.BG_Splash_KEY)
        sAdapter.refreshAdapter(AppInfos.splashImgs.toMutableList(), status2)
    }

    private fun itemClick(position: Int) {
        SPUtils.putInt(this, AppInfos.BG_STATUS_KEY, position)
        mAdapter.updateSelect(position)
        appViewModel.appColorType.value = position
        toastTopShow(this, "已更换的主题将在切换到主页后生效")
    }

    private fun itemSplashClick(position: Int) {
        SPUtils.putInt(this, AppInfos.BG_Splash_KEY, position)
        sAdapter.updateSelect(position)
        toastTopShow(this, "已更换的主题将在重启时展示")
    }

    private fun update(status: Int) {
        if (status == 0) {
            binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
            binding.txtSettingTitle.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_history_title
                )
            )
            StatusBarUtils.setStatusBarMode(this, true, viewColors[status])
        } else {
            binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
            binding.txtSettingTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
            StatusBarUtils.setStatusBarMode(this, false, viewColors[status])
        }
        binding.clayoutSettingTop.setBackgroundResource(viewColors[status])
    }
}