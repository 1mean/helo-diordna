package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivityMusicSettingConfigBinding
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils
import com.github.iielse.switchbutton.SwitchView

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class MusicConfigActivity :
    BaseActivity<BaseViewModel, ActivityMusicSettingConfigBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_activity_setting)

        val type = SPUtils.getInt(this, AppInfos.MUSIC_STYLE_KEY)

        binding.switchMusic.isOpened = type != 0
        binding.switchMusic.setOnClickListener {
            val isOpen = binding.switchMusic.isOpened
            val value = if (isOpen) {
                1
            } else {
                0
            }
            SPUtils.putInt(this, AppInfos.MUSIC_STYLE_KEY, value)
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