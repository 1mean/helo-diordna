package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.android.base.vm.BaseViewModel
import com.example.pandas.app.appViewModel
import com.example.pandas.databinding.ActivitySettingConfigBinding
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class SettingConfigActivity : BaseActivity<BaseViewModel, ActivitySettingConfigBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        if (!AppInstance.instance.isNightMode) {
            appViewModel.appColorType.value?.let {
                binding.clayoutConfigTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtConfigTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtConfigTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        } else {
            StatusBarUtils.setStatusBarMode(
                this,
                false,//深色模式
                R.color.color_bg_activity_setting
            )
        }

        val titleName = intent.getStringExtra("name")
        binding.txtConfigTitle.text = titleName

        val type = SPUtils.getInt(this, AppInfos.MINE_STYLE_KEY)
        binding.switchConfig.isOpened = type != 0
        binding.switchConfig.setOnClickListener {
            val isOpen = binding.switchConfig.isOpened
            val value = if (isOpen) {
                1
            } else {
                0
            }
            SPUtils.putInt(this, AppInfos.MINE_STYLE_KEY, value)
            toastTopShow(this, "设置成功，重启应用后才能生效")
        }

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }

    }

    override fun createObserver() {

    }

    override fun onResume() {
        super.onResume()
    }
}