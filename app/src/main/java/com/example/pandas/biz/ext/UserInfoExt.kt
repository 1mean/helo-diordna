package com.example.pandas.biz.ext;

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.pandas.app.AppInfos
import com.example.pandas.utils.FileUtils
import kotlinx.coroutines.*
import java.io.File


suspend fun getUserHeader(context: Context): Bitmap? {
    return withContext(Dispatchers.IO) {
        val faceDir = FileUtils.getExternalFilePath(context, "face")
        val faceFile = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg")
        if (!faceFile.exists()) {
            return@withContext null
        }
        BitmapFactory.decodeFile(faceFile.absolutePath)
    }
}