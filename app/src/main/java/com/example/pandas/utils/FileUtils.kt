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

    /**
     * 判断文件是否存在，不存在则判断是否创建成功
     *
     * @param file 文件
     * @return `true`: 存在或创建成功<br></br>`false`: 不存在或创建失败
     */
    fun createOrExistsFile(file: File?): Boolean {
        if (file == null) return false
        // 如果存在，是文件则返回true，是目录则返回false
        if (file.exists()) return file.isFile
        return if (!createOrExistsDir(file.parentFile)) false else try {
            file.createNewFile()
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     *
     * @param file 文件
     * @return `true`: 存在或创建成功<br></br>`false`: 不存在或创建失败
     */
    fun createOrExistsDir(file: File?): Boolean {
        // 如果存在，是目录则返回true，是文件则返回false，不存在则返回是否创建成功
        return file != null && if (file.exists()) file.isDirectory else file.mkdirs()
    }

    fun deleteFile(filePath: String) {
        val file = File(filePath)
        if (file.exists()) {
            file.delete()
        }
    }
}