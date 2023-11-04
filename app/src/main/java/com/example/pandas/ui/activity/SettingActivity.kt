package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.interaction.OnSureListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivitySettingBinding
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.view.popuwindow.StyleSettingPopuWindow
import com.example.pandas.utils.AppUtils
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.launch

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class SettingActivity : BaseActivity<SelfViewModel, ActivitySettingBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_activity_setting)

        binding.clayoutSetLayout.setOnClickListener {

            val popWindow = StyleSettingPopuWindow(this, object : OnSureListener {
                override fun onSure(type: Int) {
                    appViewModel.recommendType.value = type
                    if (type == 0) {
                        binding.txtRecoSetting.text = "经典"
                    } else {
                        binding.txtRecoSetting.text = "满铺"
                    }
                }
            })
            popWindow.setBackDark().onShow(binding.clayoutSetLayout)
        }

        val status = SPUtils.getInt(this, AppInfos.RECO_STATUS_KEY)
        if (status == 1) {
            binding.txtRecoSetting.text = "满铺"
        }

        binding.clayoutSettingStyle.setOnClickListener {

            val intent = Intent(this, SettingConfigActivity::class.java).putExtra("name", "我的界面样式")
            startActivity(intent)
        }

        binding.clayoutMusicSettingStyle.setOnClickListener {
            startAnyActivity(this, MusicConfigActivity::class.java)
        }

        binding.clayoutSettingSelf.setOnClickListener {
            startAnyActivity(this, SelfInfoActivity::class.java)
        }
    }

    override fun createObserver() {

        mViewModel.userInfo.observe(this) {
            binding.txtSettingName.text = it.userName
        }

        appViewModel.nameUpdate.observe(this) {
            binding.txtSettingName.text = it
        }
    }

    override fun onResume() {
        super.onResume()

        mViewModel.getUserInfo()

        lifecycleScope.launch {
            binding.txtSettingCache.text = AppUtils.getAppCache(this@SettingActivity)
        }

        lifecycleScope.launch {
            val bitmap = getUserHeader(this@SettingActivity)
            if (bitmap == null) {
                loadCenterImage(this@SettingActivity, AppInfos.HEAD_URL, binding.imgSettingHeader)
            } else {
                loadCircleBitmap(this@SettingActivity, bitmap, binding.imgSettingHeader)
            }
        }
    }

}