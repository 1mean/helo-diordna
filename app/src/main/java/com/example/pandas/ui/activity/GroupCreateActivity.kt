package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.android.android_sqlite.entity.Group
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.CollectViewModeL
import com.example.pandas.databinding.ActivityCreateGroupBinding
import com.example.pandas.ui.ext.addHorizontalAnimation
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.launch

/**
 * @description: GroupCreateActivity
 * @author: dongyiming
 * @date: 8/17/22 3:57 下午
 * @version: v1.0
 */
public class GroupCreateActivity : BaseActivity<CollectViewModeL, ActivityCreateGroupBinding>() {

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

            val name = binding.editCreateName.text.toString()
            val desc = binding.editCreateIntroduce.text.toString()
            val isOpen = binding.switchGroupCreator.isChecked
            if (name.isEmpty()) {
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
                val group = Group(
                    groupName = name,
                    groupDesc = desc,
                    createTime = System.currentTimeMillis(),
                    updateTime = System.currentTimeMillis(),
                    open = isOpen
                )
                mViewModel.createGroup(group)
            }
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.groupsInsertFlow.collect {
                Log.e("1mean","it result = $it")
                loadingPopup?.dismiss()
                if (it >= 1) {
                    setResult(RESULT_OK)
                    finish()
                }
            }
        }
    }

}