package com.example.pandas.biz.ext

import FileUtils
import PetManagerCoroutine
import android.content.Context
import android.os.Environment
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
import com.bumptech.glide.request.target.Target
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

