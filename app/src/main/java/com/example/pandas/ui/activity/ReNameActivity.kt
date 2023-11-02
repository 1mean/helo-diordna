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
import com.example.pandas.ui.ext.*
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class ReNameActivity : BaseActivity<SelfViewModel, ActivityRenameBinding>() {

    private var oldName: String? = null
    private var userCode: Int? = null

    override fun initView(savedInstanceState: Bundle?) {

        oldName = intent.getStringExtra("name")
        userCode = intent.getIntExtra("userCode", -1)
        oldName?.let {
            setEditText(binding.editUpdateName, it)
        }

        binding.txtRenameDesc.text = "- 修改昵称需要消耗6个积分,修改前能确保积分足够\n" +
                "- 禁止输入色情、广告、虚假信息等\n" +
                "- 每天可最多修改10次昵称\n" +
                "- 昵称限7个字符。1中文占1字符，2英文、数字占1个字符"

        binding.editUpdateName.requestFocus()
        binding.editUpdateName.post {
            KeyboardUtils.showSoftInput()
        }

        binding.btnNameSure.setOnClickListener {
            binding.editUpdateName.post {
                KeyboardUtils.hideSoftInput(this)
            }
            val newName = binding.editUpdateName.text.toString()
            if (oldName == newName) {
                finish()
            } else {
                if (newName.isNotEmpty()) {
                    if (newName.length > 7) {
                        toastTopShow(this, "昵称超过最大长度")
                        return@setOnClickListener
                    }
                    showLoading()
                    mViewModel.reName(newName, userCode!!)
                    binding.editUpdateName.postDelayed({
                        loadingPopup?.dismiss()
                        appViewModel.nameUpdate.value = newName
                        val intent = Intent()
                        intent.putExtra("newName", newName)
                        setResult(RESULT_OK, intent)
                        finish()
                    }, 500)
                } else {
                    toastTopShow(this, "昵称不能为空")
                }
            }
        }
    }

    override fun createObserver() {

        mViewModel.updateUserResult.observe(this) {

            binding.editUpdateName.postDelayed({
                mViewModel.userInfo.value = it
                loadingPopup?.dismiss()
                appViewModel.nameUpdate.value = it.userName
                finish()
            }, 500)
        }
    }

    override fun onResume() {
        super.onResume()
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