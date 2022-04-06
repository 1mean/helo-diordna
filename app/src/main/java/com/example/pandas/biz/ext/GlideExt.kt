package com.example.pandas.biz.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Environment
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.utils.FileUtils
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File


/**
 * 加载圆角图片
 * @date: 2/6/22 12:27 上午
 * @version: v1.0
 */
fun loadRoundedCornerImage(context: Context, radius: Int, url: String, view: ImageView) {

    val options = RequestOptions.bitmapTransform(RoundedCorners(radius))
    Glide.with(context).load(url).apply(options).into(view)
}

/**
 * 加载圆形图片
 */
fun loadCircleImage(context: Context, url: String, view: ImageView) {
    val options = RequestOptions.bitmapTransform(CircleCrop())
    Glide.with(context).load(url).apply(options).into(view)
}

fun loadImage(context: Context, url: String, view: ImageView) {
    Glide.with(context).load(url).into(view)
}

fun loadLayoutBackGround(context: Context, url: String, view: View) {

//    Glide.with(mContext)
//        .load(R.drawable.img_menu_top)
//        .bitmapTransform(
//            BlurTransformation(
//                mContext,
//                25,
//                20
//            )
//        )
//        .into(object : SimpleTarget<GlideDrawable?>() {
//            override fun onResourceReady(
//                resource: GlideDrawable,
//                glideAnimation: GlideAnimation<in GlideDrawable?>?
//            ) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    rlayout_header.setBackground(resource.getCurrent())
//                }
//            }
//        })

    /*设置高斯模糊效果,服务器请求的图片失真严重 sampling值越大颜色值会越浓*/
    /*设置背景 glide3.7的为Bitmap,兼容高斯模糊的glide是GlideDrawable,getCurrent()再转换成drawable*/
    Glide.with(context).asBitmap().load(url)
        .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 20)))
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                view.background = BitmapDrawable(context.resources, resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
}

fun clearMemoryCache(context: Context) {
    Glide.get(context).clearMemory()
}

fun clearFileCache(context: Context) {
    Thread {
        Glide.get(context).clearDiskCache()
    }.start()
}

/**
 * 下载项目所有的封面图片到本地，防止远程项目被删除
 * DiskCacheStrategy.DATA： /data/user/0/com.example.hello_diordna/cache/image_manager_disk_cache/74a05aa0349bb3bb72622d1ca50e52882ba535458555fd9ff23993c4b98ef39a.0
 * 存储在专属外部存储空间：/storage/emulated/0/Android/data/com.example.hello_diordna/files/Download/landscape_40.jpg
 * 导出图片 adb pull /storage/emulated/0/Android/data/com.example.hello_diordna/files/Download /Users/dongyiming/Downloads/pandas
 * 导入视频位置 adb push /Users/dongyiming/Desktop/pet/pandas/hehua/videos/ /storage/emulated/0/Android/data/com.example.hello_diordna/files/videos/
 *
 * @date: 2/6/22 4:33 下午
 * @version: v1.0
 */
fun downLoadVideoCovers(
    lifecycleOwner: LifecycleOwner,
    context: Context
) {

    lifecycleOwner.lifecycleScope.launch {

        PetManagerCoroutine.getAllPetCoverUrl().forEach {

            withContext(Dispatchers.IO) {
                val fileName = it.fileName
                Glide.with(context).downloadOnly().load(it.cover)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .listener(object : RequestListener<File> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<File>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }

                        override fun onResourceReady(
                            resource: File?,
                            model: Any?,
                            target: Target<File>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {

                            //存储图片
                            val fileDir =
                                FileUtils.getExternalFileDirectory(
                                    context,
                                    Environment.DIRECTORY_DOWNLOADS
                                )
                            val newFile = File(fileDir, "$fileName.jpg")
                            FileUtils.copy(resource, newFile)
                            return false
                        }

                    }).preload()
            }
        }
    }
}

