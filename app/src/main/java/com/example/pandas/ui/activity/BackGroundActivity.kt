package com.example.pandas.ui.activity

import BgSelectAdapter
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivityBgBinding
import com.example.pandas.ui.adapter.decoration.BackgroundItemDecoration
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 个性设置
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class BackGroundActivity : BaseActivity<BaseViewModel, ActivityBgBinding>(),
    BgSelectAdapter.ItemClickListener {

    private val names = mutableListOf("简洁白", "少女粉", "主题黑", "高能红", "咸蛋黄", "早苗绿", "宝石蓝", "罗兰紫","天然蓝")
    private val colors = arrayOf(
        R.color.color_bg_white,
        R.color.color_bg_pink,
        R.color.color_bg_black,
        R.color.color_bg_red,
        R.color.color_bg_yellow,
        R.color.color_bg_grey,
        R.color.color_bg_blue,
        R.color.color_bg_purple,
        R.color.color_bg_sky,
    )

    private val mAdapter by lazy { BgSelectAdapter(listener = this) }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop = resources.getDimension(R.dimen.common_lh_15_dimens).toInt()

        binding.ibnSettingBack.setOnClickListener { finish() }

        with(binding.rvBg) {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@BackGroundActivity, 4)
            addItemDecoration(BackgroundItemDecoration(paddingTop))
        }

        appViewModel.appColorType.value?.let {
            update(it)
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
        mAdapter.refreshAdapter(names, status)
    }

    override fun itemClick(position: Int) {

        SPUtils.putInt(this, AppInfos.BG_STATUS_KEY, position)
        mAdapter.updateSelect(position)
        Log.e("lidandan3", "colors[position]= ${colors[position]}")
        appViewModel.appColorType.value = position
        toastTopShow(this, "已更换的主题将在切换到主页后生效")
    }

    private fun update(status: Int) {
        if (status == 0) {
            binding.ibnSettingBack.setImageResource(R.mipmap.img_topview_back)
            binding.txtSettingTitle.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_history_title
                )
            )
            StatusBarUtils.setStatusBarMode(this, true, AppInfos.bgColors[status])
        } else {
            binding.ibnSettingBack.setImageResource(R.mipmap.img_topview_back_white)
            binding.txtSettingTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
            StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[status])
        }
        binding.clayoutSettingTop.setBackgroundResource(AppInfos.bgColors[status])
    }
}