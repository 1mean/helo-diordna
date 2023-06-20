package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityAboutBinding
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.databinding.ActivitySettingBinding
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class AboutActivity : BaseActivity<BaseViewModel, ActivityAboutBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

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
    }

    override fun createObserver() {
    }

    override fun onResume() {
        super.onResume()
    }

}