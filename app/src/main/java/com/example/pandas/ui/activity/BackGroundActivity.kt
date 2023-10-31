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
public class BackGroundActivity : BaseActivity<BaseViewModel, ActivityBgBinding>(),
    BgSelectAdapter.ItemClickListener {



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
        mAdapter.refreshAdapter(bgNames, status)
    }

    override fun itemClick(position: Int) {

        SPUtils.putInt(this, AppInfos.BG_STATUS_KEY, position)
        mAdapter.updateSelect(position)
        Log.e("lidandan3", "colors[position]= ${viewColors[position]}")
        appViewModel.appColorType.value = position
        toastTopShow(this, "已更换的主题将在切换到主页后生效")
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