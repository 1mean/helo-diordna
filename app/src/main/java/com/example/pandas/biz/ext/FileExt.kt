package com.example.pandas.biz.ext;

import FileUtils
import android.content.Context
import android.util.Log
import java.io.File

/**
 * 从本地获取视频目录
 */
fun getUrl(context: Context, fileName: String): File {

    // localFile: /storage/emulated/0/Android/data/com.example.hello_diordna/files
    val localFile = FileUtils.getExternalFileDirectory(context, "")
    Log.e("1mean", "fileName: $fileName")
    val builder = StringBuilder("/videos")
    var finalPath = ""
    when {
        fileName.startsWith("bird") ->
            finalPath =
                builder.append(File.separator).append("bird").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("beauty") ->
            finalPath =
                builder.append(File.separator).append("beauty").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("bird") ->
            finalPath =
                builder.append(File.separator).append("bird").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("pet_fox") ->
            finalPath =
                builder.append(File.separator).append("fox").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("pet_monkey") ->
            finalPath =
                builder.append(File.separator).append("monkey").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("video_banner") ->
            finalPath =
                builder.append(File.separator).append("all").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("panda_group") ->
            finalPath =
                builder.append(File.separator).append("group").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("landscape") ->
            finalPath =
                builder.append(File.separator).append("landscape").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("panda_mom") ->
            finalPath =
                builder.append(File.separator).append("mom").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("panda_baby") ->
            finalPath =
                builder.append(File.separator).append("baby").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("music") ->
            finalPath =
                builder.append(File.separator).append("music").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("panda_all") ->
            finalPath =
                builder.append(File.separator).append("all").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("panda_knowledge") ->
            finalPath =
                builder.append(File.separator).append("knowledge").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("penguin") ->
            finalPath =
                builder.append(File.separator).append("penguin").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("red_panda") ->
            finalPath =
                builder.append(File.separator).append("red_panda").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("pet_bear") ->
            finalPath =
                builder.append(File.separator).append("bear").append(File.separator)
                    .append(fileName).append(".mp4").toString()
        fileName.startsWith("single") ->
            finalPath =
                builder.append(File.separator).append("single").append(File.separator)
                    .append(fileName).append(".mp4").toString()
    }
    return File(localFile, finalPath)
}