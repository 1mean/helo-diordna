package com.example.pandas.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivitySafeBinding

/**
 * @description: 认证
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class SafeActivity : BaseActivity<MainViewModel, ActivitySafeBinding>() {

    private val desc = "还有其他问题? 联系客服"
    private val mHandler = Handler(Looper.getMainLooper())

    override fun initView(savedInstanceState: Bundle?) {


        val builder = SpannableStringBuilder()
        builder.append(desc)
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_bg_grey)),
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