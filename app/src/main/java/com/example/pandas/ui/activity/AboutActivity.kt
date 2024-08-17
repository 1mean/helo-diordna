package com.example.pandas.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.activity.BaseActivity
import com.android.base.vm.BaseViewModel
import com.example.pandas.databinding.ActivityAboutBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class AboutActivity : BaseActivity<BaseViewModel, ActivityAboutBinding>() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutSettingTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtSettingTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.txtAboutSupport.setTextColor(
                        ContextCompat.getColor(
                            this,
                            viewColors[APP_COLOR_STATUS]
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtSettingTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                    binding.txtAboutSupport.setTextColor(
                        ContextCompat.getColor(
                            this,
                            viewColors[it]
                        )
                    )
                }
            }
        }

        binding.ibnSettingBack.setOnClickListener { finish() }

        binding.txtAboutVersion.post {

            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            val versionName = packageInfo.versionName
            val versionCode = packageInfo.longVersionCode
            binding.txtAboutVersion.text = "当前版本$versionName"
        }

        binding.clayoutAboutCheck.setOnClickListener {
            shortToast(this, "已经是最新版本，无需更新")
        }

        binding.clayoutAboutSource.setOnClickListener {
            startAnyActivity(this, WebActivity::class.java)
        }

        binding.txtAboutSupport.setTextColor(
            ContextCompat.getColor(
                this@AboutActivity,
                R.color.color_txt_mine_name
            )
        )
    }

    override fun createObserver() {
    }

    override fun onResume() {
        super.onResume()
    }
}