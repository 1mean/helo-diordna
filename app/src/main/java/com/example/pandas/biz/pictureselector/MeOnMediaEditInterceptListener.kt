package com.example.pandas.biz.pictureselector

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnMediaEditInterceptListener
import com.luck.picture.lib.utils.DateUtils
import com.yalantis.ucrop.UCrop
import com.yalantis.ucrop.UCropImageEngine
import java.io.File

/**
 * @description: 自定义编辑
 * @author: dongyiming
 * @date: 9/1/23 7:16 PM
 * @version: v1.0
 */
public class MeOnMediaEditInterceptListener(outputCropPath: String, options: UCrop.Options) :
    OnMediaEditInterceptListener {

    private val outputCropPath: String? = null
    private val options: UCrop.Options? = null

    override fun onStartMediaEdit(
        fragment: Fragment?,
        currentLocalMedia: LocalMedia?,
        requestCode: Int
    ) {
        val currentEditPath = currentLocalMedia!!.availablePath
        val inputUri =
            if (PictureMimeType.isContent(currentEditPath)) Uri.parse(currentEditPath) else Uri.fromFile(
                File(currentEditPath)
            )
        val destinationUri = Uri.fromFile(
            File(outputCropPath, DateUtils.getCreateFileName("CROP_") + ".jpeg")
        )
        val uCrop = UCrop.of<Any>(inputUri, destinationUri)
        options!!.setHideBottomControls(false)
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
                call: UCropImageEngine.OnCallbackListener<Bitmap>
            ) {
                Glide.with(context).asBitmap().load(url).override(maxWidth, maxHeight)
                    .into(object : CustomTarget<Bitmap>() {

                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            call.onCall(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                            call.onCall(null)
                        }
                    })
            }
        })
        uCrop.startEdit(fragment!!.requireActivity(), fragment, requestCode)
    }

}