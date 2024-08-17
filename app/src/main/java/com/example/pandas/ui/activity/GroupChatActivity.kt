package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivityGroupChatBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 联系我们
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class GroupChatActivity : BaseActivity<MainViewModel, ActivityGroupChatBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            val type = appViewModel.appColorType.value ?: 0
            val spanColor: Int
            if (type == 0) {
                spanColor = viewColors[APP_COLOR_STATUS]
                binding.clayoutSettingTop.setBackgroundResource(R.color.color_bg_home)
                binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                binding.txtSettingTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
                StatusBarUtils.setStatusBarMode(this, true, viewColors[type])
            } else {
                spanColor = viewColors[type]
                binding.clayoutSettingTop.setBackgroundResource(viewColors[type])
                binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                binding.txtSettingTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
                StatusBarUtils.setStatusBarMode(this, false, viewColors[type])
            }
        }

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }
    }

    override fun createObserver() {
    }

}