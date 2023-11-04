package com.example.pandas.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.KeyboardUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityAboutBinding
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.databinding.ActivityRenameBinding
import com.example.pandas.databinding.ActivitySettingBinding
import com.example.pandas.databinding.ActivitySignBinding
import com.example.pandas.ui.ext.*
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 个性签名
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class SignActivity : BaseActivity<SelfViewModel, ActivitySignBinding>() {

    private var oldSign: String? = null
    private var userCode: Int? = null

    override fun initView(savedInstanceState: Bundle?) {

        oldSign = intent.getStringExtra("sign")
        userCode = intent.getIntExtra("userCode", -1)
        oldSign?.let {
            setEditText(binding.editSignName, it)
        }

        binding.txtSignDesc.text = "- 个性签名内容限定50个字符\n" +
                "- 禁止输入色情、广告、虚假信息等"

        binding.editSignName.requestFocus()
        binding.editSignName.post {
            KeyboardUtils.showSoftInput()
        }

        binding.btnSignSure.setOnClickListener {
            binding.editSignName.post {
                KeyboardUtils.hideSoftInput(this)
            }
            val newSign = binding.editSignName.text.toString()
            if (oldSign == newSign) {
                finish()
            } else {
                if (newSign.isNotEmpty()) {
                    if (newSign.length > 50) {
                        toastTopShow(this, "个性签名超过最大长度")
                        return@setOnClickListener
                    }
                    showLoading()
                    mViewModel.reSign(newSign, userCode!!)
                    binding.editSignName.postDelayed({
                        loadingPopup?.dismiss()
                        val intent = Intent()
                        intent.putExtra("newSign", newSign)
                        setResult(RESULT_OK, intent)
                        finish()
                    }, 500)
                } else {
                    toastTopShow(this, "个性签名不能为空")
                }
            }
        }
    }

    override fun createObserver() {
    }

    private var loadingPopup: LoadingPopupView? = null
    private fun showLoading() {
        if (loadingPopup == null) {
            loadingPopup =
                XPopup.Builder(this).dismissOnBackPressed(true)
                    .isLightNavigationBar(true)
                    .dismissOnTouchOutside(true)
                    .isViewMode(false)
                    .asLoading(
                        null,
                        R.layout.layout_waiting,
                        LoadingPopupView.Style.ProgressBar
                    )
            loadingPopup!!.show()
        } else {
            loadingPopup!!.show()
        }
    }
}