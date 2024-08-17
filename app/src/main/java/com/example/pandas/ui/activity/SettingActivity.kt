package com.example.pandas.ui.activity

import AppInstance
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.activity.BaseActivity
import com.android.base.utils.AppUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivitySettingBinding
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.dialog.RecoStyleDialog
import com.example.pandas.ui.view.dialog.StyleSelectDialog
import com.example.pandas.utils.DarkModeUtils
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

    private val types
        get() = mapOf(0 to "经典", 1 to "满铺")
    private val recoTypes
        get() = mapOf(0 to "单列", 1 to "双列")

    private var type = 0
    private var recoType = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.clayoutSetLayout.setOnClickListener {
            val dialog =
                StyleSelectDialog(this@SettingActivity, type, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        type = t
                        appViewModel.recommendType.value = t
                        binding.txtRecoSetting.text = types[t]
                        SPUtils.putInt(this@SettingActivity, AppInfos.RECO_STATUS_KEY, t)
                    }
                })
            dialog.show()
        }

        binding.ibnSettingBack.setOnClickListener { finish() }

        binding.clayoutSetHome.setOnClickListener {
            val dialog =
                RecoStyleDialog(this@SettingActivity, recoType, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        recoType = t
                        appViewModel.recoArrangeType.value = t
                        binding.txtRecoArrange.text = recoTypes[t]
                        SPUtils.putInt(this@SettingActivity, AppInfos.RECO_ARRANGE_KEY, t)
                    }
                })
            dialog.show()
        }
        type = SPUtils.getInt(this, AppInfos.RECO_STATUS_KEY)
        binding.txtRecoSetting.text = types[type]
        recoType = SPUtils.getInt(this, AppInfos.RECO_ARRANGE_KEY)
        binding.txtRecoArrange.text = recoTypes[recoType]

        //深色模式的初始化
        binding.switchDark.isOpened = AppInstance.instance.isNightMode
        StatusBarUtils.setStatusBarMode(
            this,
            !AppInstance.instance.isNightMode,//深色模式
            R.color.color_bg_activity_setting
        )

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

        binding.switchDark.setOnClickListener {
            if (AppInstance.instance.isNightMode) {//深色模式
                StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_activity_setting)
                DarkModeUtils.applyDayMode(this)
                AppInstance.instance.isNightMode = false
            } else {
                StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
                DarkModeUtils.applyNightMode(this)
                AppInstance.instance.isNightMode = true
            }
        }

        if (!AppInstance.instance.isNightMode) {
            appViewModel.appColorType.value?.let {
                if (it == 0) {
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.clayoutSettingTop.setBackgroundResource(R.color.color_bg_activity_setting)
                    binding.txtSettingTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_activity_setting)
                } else {
                    binding.clayoutSettingTop.setBackgroundResource(viewColors[it])
                    binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtSettingTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }
    }

    override fun createObserver() {

        mViewModel.userInfo.observe(this) {
            binding.txtSettingName.text = it.userName
            //bug:这里必须添加上颜色的动态设置，否则深色模式下还是显示黑色
            binding.txtSettingName.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.color_txt_setting_item_name
                )
            )
        }

        appViewModel.nameUpdate.observe(this) {
            binding.txtSettingName.text = it
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
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