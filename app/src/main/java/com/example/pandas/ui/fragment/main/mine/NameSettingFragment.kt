package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelStoreOwner
import com.blankj.utilcode.util.KeyboardUtils
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineInfoBinding
import com.example.pandas.ui.ext.toastTopShow
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: SelfInfoActivity-NameSettingFragment
 * @author: dongyiming
 * @date: 7/21/23 12:37 PM
 * @version: v1.0
 */
public class NameSettingFragment : BaseLazyFragment<SelfViewModel, FragmentMineInfoBinding>() {

    private var name: String? = null

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        binding.editUpdateName.requestFocus()
        binding.editUpdateName.post {
            KeyboardUtils.showSoftInput()
        }

        binding.btnDeleteNameInput.setOnClickListener {
            if (binding.editUpdateName.text != null) {
                binding.editUpdateName.text = null
                binding.editUpdateName.hint = "请输入新昵称"
                binding.editUpdateName.requestFocus()
            }
        }

        binding.btnNameSure.setOnClickListener {
            binding.editUpdateName.post {
                KeyboardUtils.hideSoftInput(mActivity)
            }
            val newName = binding.editUpdateName.text.toString()
            if (newName.isNotEmpty()) {
                if (newName.length > 7) {
                    toastTopShow(mActivity, "昵称超过最大长度")
                    return@setOnClickListener
                }
                Log.e("1mean", "11111")
                showLoading()
                val user = mViewModel.userInfo.value
                user?.let { curUser ->
                    curUser.userName = newName
                    mViewModel.updateUser(curUser)
                }
            } else {
                //bug:直接使用fragmentManager或调用activity来进行关闭fragment，都能成功关闭，但是下一次无法继续点击进来
            }
        }
    }

    override fun createObserver() {

        mViewModel.updateUserResult.observe(viewLifecycleOwner) {

            binding.editUpdateName.postDelayed({
                mViewModel.userInfo.value = it
                loadingPopup?.dismiss()
                appViewModel.nameUpdate.value = it.userName
            }, 500)
        }
    }

    override fun firstOnResume() {
    }

    private var loadingPopup: LoadingPopupView? = null
    private fun showLoading() {
        if (loadingPopup == null) {
            loadingPopup =
                XPopup.Builder(mActivity).dismissOnBackPressed(true)
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

    fun hideSoft() {
        val isVisiable = KeyboardUtils.isSoftInputVisible(mActivity)
        if (isVisiable) {
            KeyboardUtils.hideSoftInput(mActivity)
        }
    }
}