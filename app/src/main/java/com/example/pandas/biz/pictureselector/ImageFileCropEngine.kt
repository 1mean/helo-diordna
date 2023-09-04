package com.example.pandas.biz.pictureselector

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.engine.CropFileEngine
import com.luck.picture.lib.style.PictureSelectorStyle
import com.luck.picture.lib.style.SelectMainStyle
import com.luck.picture.lib.style.TitleBarStyle
import com.luck.picture.lib.utils.StyleUtils
import com.yalantis.ucrop.UCrop
import com.yalantis.ucrop.UCropImageEngine
import java.io.File

/**
 * @description: 图片裁剪
 * @author: dongyiming
 * @date: 9/1/23 2:04 PM
 * @version: v1.0
 */
public class ImageFileCropEngine(
    private val mContext: Context,
    private val selectorStyle: PictureSelectorStyle?
) : CropFileEngine {

    private var aspect_ratio_x: Int = -1
    private var aspect_ratio_y: Int = -1

    override fun onStartCrop(
        fragment: Fragment,
        srcUri: Uri,
        destinationUri: Uri,
        dataSource: ArrayList<String>,
        requestCode: Int
    ) {
        val options: UCrop.Options = buildOptions()
        val uCrop = UCrop.of(srcUri, destinationUri, dataSource)
        uCrop.withOptions(options)
        uCrop.setImageEngine(object : UCropImageEngine {
            override fun loadImage(context: Context, url: String, imageView: ImageView) {
                if (!ImageLoaderUtils.assertValidRequest(context)) {
                    return
                }
                Glide.with(context).load(url).override(180, 180).into(imageView)
            }

            override fun loadImage(
                context: Context,
                url: Uri,
                maxWidth: Int,
                maxHeight: Int,
                call: UCropImageEngine.OnCallbackListener<Bitmap>?
            ) {
                Glide.with(context).asBitmap().load(url).override(maxWidth, maxHeight)
                    .into(object : CustomTarget<Bitmap?>() {

                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap?>?
                        ) {
                            call?.onCall(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                            call?.onCall(null)
                        }
                    })
            }
        })
        uCrop.start(fragment.requireActivity(), fragment, requestCode)
    }

    /**
     * 配制UCrop，可根据需求自我扩展
     *
     * @return
     */
    private fun buildOptions(): UCrop.Options {
        val options = UCrop.Options()
        options.setHideBottomControls(true)//是否显示裁剪菜单栏
        options.setFreeStyleCropEnabled(true)//裁剪框or图片拖动
        options.setShowCropFrame(true)//是否显示裁剪边框
        options.setShowCropGrid(true)//是否显示裁剪框网格
        options.setCircleDimmedLayer(false)//圆形头像裁剪模式
        options.withAspectRatio(
            aspect_ratio_x.toFloat(),
            aspect_ratio_y.toFloat()
        )//比例，默认和1:1/3:4/3:2/16:9
        options.setCropOutputPathDir(getSandboxPath())
        options.isCropDragSmoothToCenter(false)
        options.setSkipCropMimeType(
            PictureMimeType.ofGIF(),
            PictureMimeType.ofWEBP()
        )//跳过裁剪的类型，gif和webp
        options.isForbidCropGifWebp(false)//不支持剪辑gif和webp
        options.isForbidSkipMultipleCrop(true)
        options.setMaxScaleMultiplier(100f)
        if (selectorStyle != null && selectorStyle.selectMainStyle.statusBarColor != 0) {
            val mainStyle: SelectMainStyle = selectorStyle.selectMainStyle
            val isDarkStatusBarBlack = mainStyle.isDarkStatusBarBlack
            val statusBarColor = mainStyle.statusBarColor
            options.isDarkStatusBarBlack(isDarkStatusBarBlack)
            if (StyleUtils.checkStyleValidity(statusBarColor)) {
                options.setStatusBarColor(statusBarColor)
                options.setToolbarColor(statusBarColor)
            } else {
                options.setStatusBarColor(ContextCompat.getColor(mContext, R.color.ps_color_grey))
                options.setToolbarColor(ContextCompat.getColor(mContext, R.color.ps_color_grey))
            }
            val titleBarStyle: TitleBarStyle = selectorStyle.getTitleBarStyle()
            if (StyleUtils.checkStyleValidity(titleBarStyle.titleTextColor)) {
                options.setToolbarWidgetColor(titleBarStyle.titleTextColor)
            } else {
                options.setToolbarWidgetColor(
                    ContextCompat.getColor(mContext, R.color.ps_color_white)
                )
            }
        } else {
            options.setStatusBarColor(ContextCompat.getColor(mContext, R.color.ps_color_grey))
            options.setToolbarColor(ContextCompat.getColor(mContext, R.color.ps_color_grey))
            options.setToolbarWidgetColor(
                ContextCompat.getColor(mContext, R.color.ps_color_white)
            )
        }
        return options
    }

    /**
     * 创建自定义输出目录
     *
     * @return
     */
    private fun getSandboxPath(): String {
        val externalFilesDir = mContext.getExternalFilesDir("")
        val customFile = File(externalFilesDir?.absolutePath, "Sandbox")
        if (!customFile.exists()) {
            customFile.mkdirs()
        }
        return customFile.absolutePath + File.separator
    }
}