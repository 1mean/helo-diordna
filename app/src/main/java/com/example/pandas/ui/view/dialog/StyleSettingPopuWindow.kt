package com.example.pandas.ui.view.dialog

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.interaction.OnSureListener
import com.example.pandas.utils.SPUtils

/**
 * @description: 设置-首页布局样式
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class StyleSettingPopuWindow(
    private val activity: Activity,
    private val listener: OnSureListener
) : PopupWindow() {

    private var title: AppCompatTextView? = null

    init {

        val view = activity.layoutInflater.inflate(R.layout.dialog_reco_style_setting, null)
        contentView = view

        val selectedImage1 = view.findViewById<AppCompatImageView>(R.id.img_style1_selected)
        val selectedImage2 = view.findViewById<AppCompatImageView>(R.id.img_style2_selected)
        val style1View = view.findViewById<ConstraintLayout>(R.id.clayout_style1)
        val style2View = view.findViewById<ConstraintLayout>(R.id.clayout_style2)
        val style1Layout = view.findViewById<ConstraintLayout>(R.id.clayout_setting_style1)
        val style2Layout = view.findViewById<ConstraintLayout>(R.id.clayout_setting_style2)

        val sure = view.findViewById<AppCompatButton>(R.id.btn_style_sure)

        width = 855
        height = 1000
        isFocusable = true

        setOnDismissListener {
            activity.window.run {
                attributes.alpha = 1.0f
                addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
        }

        val status = SPUtils.getInt(activity, AppInfos.RECO_STATUS_KEY)
        if (status == 0) {
            style1Layout.setBackgroundResource(R.drawable.shape_style_setting)
            style2Layout.background = null
            selectedImage1.visibility = View.VISIBLE
            selectedImage2.visibility = View.GONE
        } else {
            style2Layout.setBackgroundResource(R.drawable.shape_style_setting)
            style1Layout.background = null
            selectedImage1.visibility = View.GONE
            selectedImage2.visibility = View.VISIBLE
        }

        style1Layout.setOnClickListener {
            style1Layout.setBackgroundResource(R.drawable.shape_style_setting)
            style2Layout.background = null
            selectedImage1.visibility = View.VISIBLE
            selectedImage2.visibility = View.GONE
        }

        style2Layout.setOnClickListener {
            style2Layout.setBackgroundResource(R.drawable.shape_style_setting)
            style1Layout.background = null
            selectedImage1.visibility = View.GONE
            selectedImage2.visibility = View.VISIBLE
        }

        sure.setOnClickListener {
            val type = if (selectedImage1.isVisible) 0 else 1
            if (type == status) {
                return@setOnClickListener
            }
            sure.post {
                SPUtils.putInt(activity, AppInfos.RECO_STATUS_KEY, type)
            }
            listener.onSure(type)
            dismiss()
        }
    }

    fun setTitle(titleStr: String): StyleSettingPopuWindow {
        title?.text = titleStr
        return this
    }

    fun setBackDark(): StyleSettingPopuWindow {
        //设置背景变暗
        activity.window.run {
            attributes.alpha = 0.5f //代表透明程度，范围为0 - 1.0f
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        return this
    }

    fun onShow(parent: View) {
        isOutsideTouchable = true
        showAtLocation(parent, Gravity.CENTER, 0, 0)
    }
}