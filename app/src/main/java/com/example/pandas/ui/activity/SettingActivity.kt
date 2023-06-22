package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.databinding.ActivitySettingBinding
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class SettingActivity : BaseActivity<BaseViewModel, ActivitySettingBinding>(){

    override fun initView(savedInstanceState: Bundle?) {

        appViewModel.appColorType.value?.let {
            binding.clayoutSettingTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.ibnSettingBack.setImageResource(R.mipmap.img_topview_back)
                binding.txtSettingTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnSettingBack.setImageResource(R.mipmap.img_topview_back_white)
                binding.txtSettingTitle.setTextColor(
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
    }

}