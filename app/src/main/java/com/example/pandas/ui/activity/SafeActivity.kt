package com.example.pandas.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivitySafeBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.shape_20_drawables
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 认证
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class SafeActivity : BaseActivity<MainViewModel, ActivitySafeBinding>() {

    private val desc = "还有其他问题? 联系客服"

    override fun initView(savedInstanceState: Bundle?) {

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
        } else {
            spanColor = viewColors[type]
            binding.clayoutSettingTop.setBackgroundResource(viewColors[type])
            binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
            binding.txtSettingTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
            StatusBarUtils.setStatusBarMode(this, false, viewColors[type])
        }

        val builder = SpannableStringBuilder()
        builder.append(desc)
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, spanColor)),
            8,
            desc.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.txtSafeDesc.text = builder

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }

    }

    override fun createObserver() {
    }

}