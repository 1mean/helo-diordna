package com.example.pandas.utils

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
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

    fun getExternalFilePath(context: Context, name: String): String {

        val localFile = getExternalFileDirectory(context, "")//File目录
        localFile?.let {
            val facePath =
                StringBuilder(it.absolutePath).append(File.separator).append(name).toString()
            val faceFile = File(facePath)
            if (!faceFile.exists()) {
                faceFile.mkdirs()
            }
            return facePath
        }
        return ""
    }

    /**
     * 根据Uri获取图片的绝对路径
     *
     * @param context 上下文对象
     * @param uri     图片的Uri
     * @return 如果Uri对应的图片存在, 那么返回该图片的绝对路径, 否则返回null
     */
    fun getRealPathFromUri(context: Context, uri: Uri): String? {
        val sdkVersion: Int = Build.VERSION.SDK_INT
        return if (sdkVersion >= 19) { // api >= 19
            getRealPathFromUriAboveApi19(context, uri)
        } else { // api < 19
            getRealPathFromUriBelowAPI19(context, uri)
        }
    }

    /**
     * 适配api19以下(不包括api19),根据uri获取图片的绝对路径
     *
     * @param context 上下文对象
     * @param uri     图片的Uri
     * @return 如果Uri对应的图片存在, 那么返回该图片的绝对路径, 否则返回null
     */
    private fun getRealPathFromUriBelowAPI19(context: Context, uri: Uri): String? {
        return getDataColumn(context, uri, null, null)
    }

    /**
     * 适配api19及以上,根据uri获取图片的绝对路径
     * @param context 上下文对象
     * @param uri     图片的Uri
     * @return 如果Uri对应的图片存在, 那么返回该图片的绝对路径, 否则返回null
     */
    @SuppressLint("NewApi")
    private fun getRealPathFromUriAboveApi19(context: Context?, uri: Uri): String? {
        var filePath: String? = null
        if (DocumentsContract.isDocumentUri(context, uri)) {
            // 如果是document类型的 uri, 则通过document id来进行处理
            val documentId = DocumentsContract.getDocumentId(uri)
            if (isMediaDocument(uri)) { // MediaProvider
                // 使用':'分割
                val id = documentId.split(":").toTypedArray()[1]
                val selection = MediaStore.Images.Media._ID + "=?"
                val selectionArgs = arrayOf(id)
                filePath = getDataColumn(
                    context!!,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    selection,
                    selectionArgs
                )
            } else if (isDownloadsDocument(uri)) { // DownloadsProvider
                val contentUri = ContentUris.withAppendedId(
                    Uri.parse("content://downloads/public_downloads"),
                    java.lang.Long.valueOf(documentId)
                )
                filePath = getDataColumn(context!!, contentUri, null, null)
            }
        } else if ("content".equals(uri.scheme, ignoreCase = true)) {
            // 如果是 content 类型的 Uri
            filePath = getDataColumn(context!!, uri, null, null)
        } else if ("file" == uri.scheme) {
            // 如果是 file 类型的 Uri,直接获取图片对应的路径
            filePath = uri.path
        }
        return filePath
    }

    /**
     * @param uri the Uri to check
     * @return Whether the Uri authority is MediaProvider
     */
    private fun isMediaDocument(uri: Uri): Boolean {
        return "com.android.providers.media.documents" == uri.authority
    }

    /**
     * @param uri the Uri to check
     * @return Whether the Uri authority is DownloadsProvider
     */
    private fun isDownloadsDocument(uri: Uri): Boolean {
        return "com.android.providers.downloads.documents" == uri.authority
    }


    /**
     * 获取数据库表中的 _data 列，即返回Uri对应的文件路径
     * @return
     */
    private fun getDataColumn(
        context: Context,
        uri: Uri,
        selection: String?,
        selectionArgs: Array<String>?
    ): String? {
        var path: String? = null
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        var cursor: Cursor? = null
        try {
            cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, null)
            if (cursor != null && cursor.moveToFirst()) {
                val columnIndex = cursor.getColumnIndexOrThrow(projection[0])
                path = cursor.getString(columnIndex)
            }
        } catch (e: java.lang.Exception) {
            cursor?.close()
        }
        return path
    }


}