package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivityAuthenticationBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.main.mine.AuthenUpdateFragment
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 认证
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class AuthenticationActivity : BaseActivity<MainViewModel, ActivityAuthenticationBinding>() {

    private val tag: String = "auth_fragment"

    override fun initView(savedInstanceState: Bundle?) {

        val transaction = supportFragmentManager.beginTransaction()
        val tagFragment = supportFragmentManager.findFragmentByTag(tag)
        if (tagFragment == null) {
            transaction.run {
                setReorderingAllowed(true)
                add(R.id.flayout_authen, AuthenUpdateFragment(), tag)
                addToBackStack(null)
                commit()
            }
        }

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.clayoutSettingTop.setBackgroundResource(R.color.color_bg_home)
                binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                binding.txtSettingTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.clayoutSettingTop.setBackgroundResource(viewColors[it])
                binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
                binding.txtSettingTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
                StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
            }
        }
    }

    override fun createObserver() {
    }

}