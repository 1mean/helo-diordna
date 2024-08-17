package com.example.pandas.biz.pictureselector

import android.Manifest
import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.luck.lib.camerax.listener.OnSimpleXPermissionDeniedListener
import com.luck.lib.camerax.permissions.SimpleXPermissionUtil
import com.life.publish.lib_selector.dialog.RemindDialog

/**
 * @description: MeOnSimpleXPermissionDeniedListener
 * @author: dongyiming
 * @date: 9/1/23 6:57 PM
 * @version: v1.0
 */
public class MeOnSimpleXPermissionDeniedListener: OnSimpleXPermissionDeniedListener {

    override fun onDenied(context: Context?, permission: String?, requestCode: Int) {

        val tips: String = if (TextUtils.equals(permission, Manifest.permission.RECORD_AUDIO)) {
            "缺少麦克风权限\n可能会导致录视频无法采集声音"
        } else {
            "缺少相机权限\n可能会导致不能使用摄像头功能"
        }
        val dialog = RemindDialog.buildDialog(context, tips)
        dialog.setButtonText("去设置")
        dialog.setButtonTextColor(-0x828201)
        dialog.setContentTextColor(-0xcccccd)
        dialog.setOnDialogClickListener {
            SimpleXPermissionUtil.goIntentSetting(context as Activity?, requestCode)
            dialog.dismiss()
        }
        dialog.show()
    }

}