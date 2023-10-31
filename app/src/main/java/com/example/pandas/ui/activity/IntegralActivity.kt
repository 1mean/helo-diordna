package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivityIntegralBinding
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 积分
 * @author: dongyiming
 * @date: 5/27/23 5:54 PM
 * @version: v1.0
 */
public class IntegralActivity : BaseActivity<BaseViewModel, ActivityIntegralBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        appViewModel.appColorType.value?.let {
            binding.clayoutLaterTop.setBackgroundResource(viewColors[it])
            if (it == 0) {
                binding.ibnIntegralBack.setImageResource(R.mipmap.img_topview_back)
                binding.txtLaterTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnIntegralBack.setImageResource(R.mipmap.img_topview_back_white)
                binding.txtLaterTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
            }
        }
    }

    override fun createObserver() {
    }

}