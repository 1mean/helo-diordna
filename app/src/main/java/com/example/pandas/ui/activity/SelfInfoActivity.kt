package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 个人信息
 * @author: dongyiming
 * @date: 4/13/22 5:38 下午
 * @version: v1.0
 */
public class SelfInfoActivity : BaseActivity<SelfViewModel, ActivityMineInfoBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        binding.ibInfo.setOnClickListener {
            finish()
        }
        mViewModel.getUserInfo()
        binding.clayoutInfoHead.setOnClickListener {

        }
    }

    override fun createObserver() {
        mViewModel.userInfo.observe(this) {

            it?.let { user ->
                user.headUrl?.let {
                    loadCircleImage(this, it, binding.imgMineInfoHeader)
                }
                user.userName?.let {
                    binding.txtMineInfoName.text = it
                }
                when (user.sex) {
                    0 -> binding.txtMineInfoSex.text = "男"
                    1 -> binding.txtMineInfoSex.text = "女"
                    else -> binding.txtMineInfoSex.text = "保密"
                }
                binding.txtMineInfoNum.text = user.userCode.toString()
                user.signature?.let {
                    binding.txtMineInfoSign.text = it
                }
            }
        }
    }

}