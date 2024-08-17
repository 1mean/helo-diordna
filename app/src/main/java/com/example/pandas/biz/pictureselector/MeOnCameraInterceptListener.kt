package com.example.pandas.biz.pictureselector

import android.content.Context
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.luck.lib.camerax.SimpleCameraX
import com.luck.lib.camerax.listener.OnSimpleXPermissionDeniedListener
import com.luck.lib.camerax.listener.OnSimpleXPermissionDescriptionListener
import com.life.publish.lib_selector.interfaces.OnCameraInterceptListener
import java.io.File

/**
 * @description: MeOnCameraInterceptListener
 * @author: dongyiming
 * @date: 9/1/23 6:49 PM
 * @version: v1.0
 */
public class MeOnCameraInterceptListener(
    private val mContext: Context,
    private val addPermission: Boolean,
    private val isUseOwnerPath: Boolean,
) :
    OnCameraInterceptListener {

    override fun openCamera(fragment: Fragment, cameraMode: Int, requestCode: Int) {

        val camera = SimpleCameraX.of()
        camera.isAutoRotation(true)
        camera.setCameraMode(cameraMode)
        camera.setVideoFrameRate(25)
        camera.setVideoBitRate(3 * 1024 * 1024)
        camera.isDisplayRecordChangeTime(true)
        camera.isManualFocusCameraPreview(false)//支持手指点击对焦
        camera.isZoomCameraPreview(false)//支持手指缩放相机
        camera.setOutputPathDir(getSandboxCameraOutputPath())
        camera.setPermissionDeniedListener(getSimpleXPermissionDeniedListener())
        camera.setPermissionDescriptionListener(getSimpleXPermissionDescriptionListener())
        camera.setImageEngine { context, url, imageView ->
            Glide.with(context).load(url).into(imageView)
        }
        camera.start(fragment.requireActivity(), fragment, requestCode)
    }

    /**
     * 创建相机自定义输出目录
     *
     * @return
     */
    private fun getSandboxCameraOutputPath(): String {
        return if (isUseOwnerPath) {
            val externalFilesDir = mContext.getExternalFilesDir("")
            val customFile = File(externalFilesDir?.absolutePath, "Sandbox")
            if (!customFile.exists()) {
                customFile.mkdirs()
            }
            customFile.absolutePath + File.separator
        } else {
            ""
        }
    }

    /**
     * SimpleCameraX权限拒绝后回调
     *
     * @return
     */
    private fun getSimpleXPermissionDeniedListener(): OnSimpleXPermissionDeniedListener? {
        return if (addPermission) MeOnSimpleXPermissionDeniedListener() else null
    }

    /**
     * SimpleCameraX权限说明
     *
     * @return
     */
    private fun getSimpleXPermissionDescriptionListener(): OnSimpleXPermissionDescriptionListener? {
        return if (addPermission) MeOnSimpleXPermissionDescriptionListener() else null
    }
}