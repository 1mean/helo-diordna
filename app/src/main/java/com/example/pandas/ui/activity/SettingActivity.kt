package com.example.pandas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.CacheDiskUtils
import com.blankj.utilcode.util.CacheMemoryUtils
import com.bumptech.glide.util.ByteBufferUtil
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.interaction.OnSureListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.databinding.ActivitySettingBinding
import com.example.pandas.ui.view.dialog.DeletePopuWindow
import com.example.pandas.ui.view.dialog.StyleSettingPopuWindow
import com.example.pandas.utils.AppUtils
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.launch

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class SettingActivity : BaseActivity<BaseViewModel, ActivitySettingBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        appViewModel.appColorType.value?.let {
            binding.clayoutSettingTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                binding.txtSettingTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                binding.txtSettingTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
        }

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
            val intent = Intent(this, MusicConfigActivity::class.java)
            startActivity(intent)
        }
    }

    override fun createObserver() {
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            binding.txtSettingCache.text = AppUtils.getAppCache(this@SettingActivity)
        }
    }

}