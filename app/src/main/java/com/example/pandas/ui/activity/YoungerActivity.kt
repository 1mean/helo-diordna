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
import com.example.pandas.databinding.ActivityYoungerBinding
import com.example.pandas.ui.ext.toastTopShow

/**
 * @description: 认证
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class YoungerActivity : BaseActivity<MainViewModel, ActivityYoungerBinding>() {

    private val desc =
        "开启青少年模式后，系统将自动关闭所有视频的下载功能，需要输入密码后才能恢复使用\n\n开启青少年模式，需要先设置独立密码，如忘记密码可联系客服申述重制\n\n青少年模式是响应国家政策，为促进青少年健康成长的一种模式，我们优先针对核心场景进行优化，也将继续致力于优化更多场景"
    private val desc2 = "更多信息可阅读《儿童/青少年使用须知》"
    private val mHandler = Handler(Looper.getMainLooper())

    override fun initView(savedInstanceState: Bundle?) {

        binding.txtActivityYoungerDesc.text = desc

        val builder = SpannableStringBuilder()
        builder.append(desc2)
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_bg_grey)),
            7,
            desc2.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.txtYoungerMore.text = builder

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }

        binding.txtYoungerModeOpen.setOnClickListener {
            toastTopShow(this, "开启成功")
            mHandler.postDelayed({
                finish()
            }, 500)

        }

    }

    override fun createObserver() {
    }

}