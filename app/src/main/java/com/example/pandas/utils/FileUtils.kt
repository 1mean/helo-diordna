package com.example.pandas.utils

import android.content.Context
import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

/**
 * @description: 基于分区存储的文件处理
 * @author: dongyiming
 * @date: 2022/1/12 12:48 上午
 * @version: v1.0
 */
object FileUtils {

    /**
     * 外部专属空间是否可用 可读，可写
     * @version: v1.0
     */
    fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    /**
     * 外部专属空间是否可读
     * @version: v1.0
     */
    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }

    /**
     * 获取外部专属空间的特定type的文件夹目录
     * 应用卸载，文件清除
     * @version: v1.0
     * @type:为null时，默认获取file目录
     */
    fun getExternalFileDirectory(context: Context, type: String): File? {

        var appFileDir: File? = null
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            appFileDir = context.getExternalFilesDir(type)
        }
        return appFileDir
    }

    /**
     * 获取外部专属空间的缓存文件目录
     * 应用卸载，文件清除
     * @version: v1.0
     */
    fun getExternalCacheDirectory(context: Context): File? {

        var appCacheDir: File? = null
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            appCacheDir = context.externalCacheDir
        }
        return appCacheDir
    }

    /**
     * 通过视频文件名，获取外部专属空间下的movie目录下的视频文件
     * 应用卸载，文件清除
     * @version: v1.0
     */
    fun getAppSpecificMovieStorageDir(context: Context, name: String): File? {

        val fileDir = getExternalFileDirectory(context, Environment.DIRECTORY_MOVIES)
        if (fileDir != null) {
            return File(fileDir, name)
        }
        return null
    }

    /**
     * 读取文件到指定目录
     * @version: v1.0
     */
    fun copy(source: File?, target: File?) {
        var fileInputStream: FileInputStream? = null
        var fileOutputStream: FileOutputStream? = null
        try {
            fileInputStream = FileInputStream(source)
            fileOutputStream = FileOutputStream(target)
            val buffer = ByteArray(1024)
            while (fileInputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fileInputStream?.close()
                fileOutputStream?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}