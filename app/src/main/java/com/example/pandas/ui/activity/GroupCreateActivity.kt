package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityCreateGroupBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.addHorizontalAnimation
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: GroupCreateActivity
 * @author: dongyiming
 * @date: 8/17/22 3:57 下午
 * @version: v1.0
 */
public class GroupCreateActivity : BaseActivity<HistoryViewModeL, ActivityCreateGroupBinding>() {

    private var loadingPopup: LoadingPopupView? = null

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutCreatorTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnCreatorBack.setImageResource(R.mipmap.img_topview_back)
                    binding.txtCreatorTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.txtCreatorFinish.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_manager
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnCreatorBack.setImageResource(R.mipmap.img_topview_back_white)
                    binding.txtCreatorTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    binding.txtCreatorFinish.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.txtCreatorFinish.setOnClickListener {

            val name = binding.editCreateName.text
            val desc = binding.editCreateIntroduce.text
            val isOpen = binding.switchGroupCreator.isChecked
            if (name.isNullOrEmpty()) {
                addHorizontalAnimation(binding.txtCreatorName)
                return@setOnClickListener
            } else {
                if (loadingPopup == null) {
                    loadingPopup = XPopup.Builder(this).dismissOnBackPressed(true)
                        .isLightNavigationBar(true)
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
                mViewModel.createAGroup(name.toString(), desc.toString(), isOpen)
            }
        }
    }

    override fun createObserver() {

        mViewModel.createResult.observe(this) {
            loadingPopup!!.dismiss()
            if (it) {
                setResult(RESULT_OK)
                finish()
            }
        }
    }

}