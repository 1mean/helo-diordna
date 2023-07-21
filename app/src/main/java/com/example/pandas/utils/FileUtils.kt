package com.example.pandas.utils

import android.annotation.SuppressLint
import android.content.*
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.*
import java.util.*


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

    //打开类型的文件
    fun openFile(context: Context, filePath: String): Intent? {
        val file = File(filePath)
        if (!file.exists()) return null
        /* 取得扩展名 */
        var end = file
            .name
            .substring(
                file.name.lastIndexOf(".") + 1,
                file.name.length
            ).lowercase(Locale.getDefault())
        end = end.trim { it <= ' ' }.lowercase(Locale.getDefault())
        //		System.out.println(end);
        /* 依扩展名的类型决定MimeType */return if (end == "apk") {
            getApkFileIntent(context, filePath)
        } else if (end == "ppt") {
            getPptFileIntent(context, filePath)
        } else if (end == "xls") {
            getExcelFileIntent(context, filePath)
        } else if (end == "doc") {
            getWordFileIntent(context, filePath)
        } else if (end == "pdf") {
            getPdfFileIntent(context, filePath)
        } else if (end == "txt") {
            getTextFileIntent(context, filePath, false)
        } else {
            getAllIntent(context, filePath)
        }
    }

    // Android获取一个用于打开APK文件的intent
    fun getApkFileIntent(context: Context, param: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            val contentUri: Uri = FileProvider.getUriForFile(
                context,
                "com.filepath.intent.MyFileProvider",
                File(param)
            )
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive")
        } else {
            intent.setDataAndType(
                Uri.fromFile(File(param)),
                "application/vnd.android.package-archive"
            )
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        return intent
    }

    // Android获取一个用于打开PPT文件的intent
    fun getPptFileIntent(context: Context, param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //        Uri uri = Uri.fromFile(new File(param));
        val uri: Uri =
            FileProvider.getUriForFile(context, "com.filepath.intent.MyFileProvider", File(param))
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint")
        return intent
    }

    // Android获取一个用于打开Excel文件的intent
    fun getExcelFileIntent(context: Context, param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //        Uri uri = Uri.fromFile(new File(param));
        val uri: Uri =
            FileProvider.getUriForFile(context, "com.filepath.intent.MyFileProvider", File(param))
        intent.setDataAndType(uri, "application/vnd.ms-excel")
        return intent
    }

    // Android获取一个用于打开Word文件的intent
    fun getWordFileIntent(context: Context, param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //        Uri uri = Uri.fromFile(new File(param));
        val uri: Uri =
            FileProvider.getUriForFile(context, "com.filepath.intent.MyFileProvider", File(param))
        intent.setDataAndType(uri, "application/msword")
        return intent
    }

    // Android获取一个用于打开PDF文件的intent
    fun getPdfFileIntent(context: Context, param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //        Uri uri = Uri.fromFile(new File(param));
        val uri: Uri =
            FileProvider.getUriForFile(context, "com.filepath.intent.MyFileProvider", File(param))
        intent.setDataAndType(uri, "application/pdf")
        return intent
    }

    // Android获取一个用于打开文本文件的intent
    fun getTextFileIntent(context: Context, param: String, paramBoolean: Boolean): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (paramBoolean) {
            val uri1 = Uri.parse(param)
            intent.setDataAndType(uri1, "text/plain")
        } else {
//            Uri uri2 = Uri.fromFile(new File(param));
            val uri2: Uri = FileProvider.getUriForFile(
                context,
                //"$packageName",
                "com.example.hello_diordna.fileprovider",
                File(param)
            )
            intent.setDataAndType(uri2, "text/plain")
        }
        return intent
    }

    // Android获取一个用于打开APK文件的intent
    fun getAllIntent(context: Context, param: String): Intent {
        val intent = Intent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.action = Intent.ACTION_VIEW
        //        Uri uri = Uri.fromFile(new File(param));
        val uri: Uri =
            FileProvider.getUriForFile(context, "com.filepath.intent.MyFileProvider", File(param))
        intent.setDataAndType(uri, "*/*")
        return intent
    }

    fun writeFileFromIS(fos: OutputStream, `is`: InputStream): Boolean {
        var os: OutputStream? = null
        return try {
            os = BufferedOutputStream(fos)
            val data = ByteArray(8192)
            var len: Int
            while (`is`.read(data, 0, 8192).also { len = it } != -1) {
                os.write(data, 0, len)
            }
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        } finally {
            try {
                `is`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                os?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}