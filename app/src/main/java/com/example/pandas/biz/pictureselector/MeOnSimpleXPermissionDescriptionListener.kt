package com.example.pandas.biz.pictureselector

import android.Manifest
import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.luck.lib.camerax.listener.OnSimpleXPermissionDescriptionListener
import com.luck.picture.lib.permissions.PermissionConfig
import com.luck.picture.lib.utils.DensityUtil
import com.luck.picture.lib.widget.MediumBoldTextView

/**
 * @description: SimpleCameraX添加权限说明
 * @author: dongyiming
 * @date: 9/1/23 7:00 PM
 * @version: v1.0
 */
public class MeOnSimpleXPermissionDescriptionListener : OnSimpleXPermissionDescriptionListener {

    override fun onPermissionDescription(
        context: Context,
        viewGroup: ViewGroup,
        permission: String
    ) {
        addPermissionDescription(true, viewGroup, arrayOf(permission))
    }

    override fun onDismiss(viewGroup: ViewGroup) {

        removePermissionDescription(viewGroup)
    }

    /**
     * 添加权限说明
     *
     * @param viewGroup
     * @param permissionArray
     */
    private fun addPermissionDescription(
        isHasSimpleXCamera: Boolean,
        viewGroup: ViewGroup,
        permissionArray: Array<String>
    ) {
        val dp10 = DensityUtil.dip2px(viewGroup.context, 10f)
        val dp15 = DensityUtil.dip2px(viewGroup.context, 15f)
        val view = MediumBoldTextView(viewGroup.context)
        view.tag = "TAG_EXPLAIN_VIEW"
        view.textSize = 14f
        view.setTextColor(Color.parseColor("#333333"))
        view.setPadding(dp10, dp15, dp10, dp15)
        val title: String
        val explain: String
        if (TextUtils.equals(permissionArray[0], PermissionConfig.CAMERA[0])) {
            title = "相机权限使用说明"
            explain = "相机权限使用说明\n用户app用于拍照/录视频"
        } else if (TextUtils.equals(permissionArray[0], Manifest.permission.RECORD_AUDIO)) {
            if (isHasSimpleXCamera) {
                title = "麦克风权限使用说明"
                explain = "麦克风权限使用说明\n用户app用于录视频时采集声音"
            } else {
                title = "录音权限使用说明"
                explain = "录音权限使用说明\n用户app用于采集声音"
            }
        } else {
            title = "存储权限使用说明"
            explain = "存储权限使用说明\n用户app写入/下载/保存/读取/修改/删除图片、视频、文件等信息"
        }
        val startIndex = 0
        val endOf = startIndex + title.length
        val builder = SpannableStringBuilder(explain)
        builder.setSpan(
            AbsoluteSizeSpan(DensityUtil.dip2px(viewGroup.context, 16f)),
            startIndex,
            endOf,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(
            ForegroundColorSpan(-0xcccccd),
            startIndex,
            endOf,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        view.text = builder
        view.background =
            ContextCompat.getDrawable(viewGroup.context, R.drawable.ps_demo_permission_desc_bg)
        if (isHasSimpleXCamera) {
            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.topMargin = DensityUtil.getStatusBarHeight(viewGroup.context)
            layoutParams.leftMargin = dp10
            layoutParams.rightMargin = dp10
            viewGroup.addView(view, layoutParams)
        } else {
            val layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.topToBottom = R.id.title_bar
            layoutParams.leftToLeft = ConstraintSet.PARENT_ID
            layoutParams.leftMargin = dp10
            layoutParams.rightMargin = dp10
            viewGroup.addView(view, layoutParams)
        }
    }

    /**
     * 移除权限说明
     *
     * @param viewGroup
     */
    private fun removePermissionDescription(viewGroup: ViewGroup) {
        val tagExplainView = viewGroup.findViewWithTag<View>("TAG_EXPLAIN_VIEW")
        viewGroup.removeView(tagExplainView)
    }
}