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
import com.example.pandas.databinding.ActivityYoungerBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.shape_20_drawables
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

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
            binding.txtYoungerModeOpen.setBackgroundResource(shape_20_drawables[APP_COLOR_STATUS])
        } else {
            spanColor = viewColors[type]
            binding.clayoutSettingTop.setBackgroundResource(viewColors[type])
            binding.ibnSettingBack.setImageResource(R.mipmap.img_setting_top_back_white)
            binding.txtSettingTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
            StatusBarUtils.setStatusBarMode(this, false, viewColors[type])
            binding.txtYoungerModeOpen.setBackgroundResource(shape_20_drawables[type])
        }

        binding.txtActivityYoungerDesc.text = desc

        val builder = SpannableStringBuilder()
        builder.append(desc2)
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, spanColor)),
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