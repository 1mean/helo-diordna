package com.example.pandas.biz.ext

import android.content.Context
import com.example.pandas.app.getExtFilePath
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.utils.FileUtils
import java.io.File

/**
 * 从本地获取audio具体目录,有两种不同格式的文件
 *
 * 文件存储目录 /storage/emulated/0/Android/data/com.example.hello_diordna/files/music
 * 同 /sdcard/Android/data/com.example.hello_diordna/files/music
 */
fun getMusicUrl(context: Context, fileName: String): String {

    // localFile: /storage/emulated/0/Android/data/com.example.hello_diordna/files
    val localFile = FileUtils.getExternalFileDirectory(context, "")
    val path =
        StringBuilder("/music").append(File.separator).append(fileName).append(".mp3").toString()
    val file = File(localFile, path)
    if (!file.exists()) {
        val path2 = StringBuilder("/music").append(File.separator).append(fileName).append(".flac")
            .toString()
        val file2 = File(localFile, path2)
        if (file2.exists()) {
            return file2.absolutePath
        }
        return ""
    }
    return file.absolutePath
}

/**
 * 通过 [PetVideo.fileName] 来获取app专属空间内的视频文件
 * @param: fileName
 * @return:
 * @author: dongyiming
 * @date: 7/17/22 5:02 下午
 * @version: v1.0
 */
fun getLocalFilePath(context: Context, fileName: String): File {

    val localFile = FileUtils.getExternalFileDirectory(context, "")
    var finalPath = ""
    when {
        fileName.startsWith("pet_bear") ->
            finalPath = appendVideoFile("animal", "bear", fileName)
        fileName.startsWith("bird") ->
            finalPath = appendVideoFile("animal", "bird", fileName)
        fileName.startsWith("cat") ->
            finalPath = appendVideoFile("animal", "cat", fileName)
        fileName.startsWith("pet_fox") ->
            finalPath = appendVideoFile("animal", "fox", fileName)
        fileName.startsWith("pet_monkey") ->
            finalPath = appendVideoFile("animal", "monkey", fileName)
        fileName.startsWith("penguin") ->
            finalPath = appendVideoFile("animal", "penguin", fileName)
        fileName.startsWith("red_panda") ->
            finalPath = appendVideoFile("animal", "red_panda", fileName)
        fileName.startsWith("landscape") ->
            finalPath = appendVideoFile("China", "landscape", fileName)
        fileName.startsWith("honglou") ->
            finalPath = appendVideoFile("culture", "honglou", fileName)
        fileName.startsWith("art") ->
            finalPath = appendVideoFile("entertainment", "art", fileName)
        fileName.startsWith("tv") ->
            finalPath = appendVideoFile("entertainment", "tv", fileName)
        fileName.startsWith("beauty") ->
            finalPath = appendVideoFile("entertainment", "beauty", fileName)
        fileName.startsWith("baby") ->
            finalPath = appendVideoFile("entertainment", "human_baby", fileName)
        fileName.startsWith("music") ->
            finalPath = appendVideoFile("entertainment", "music", fileName)
        fileName.startsWith("football") ->
            finalPath = appendVideoFile("sports", "football", fileName)
        fileName.startsWith("panda_all") ->
            finalPath = appendVideoFile("panda", "all", fileName)
        fileName.startsWith("panda_baby") ->
            finalPath = appendVideoFile("panda", "baby", fileName)
        fileName.startsWith("panda_group") ->
            finalPath = appendVideoFile("panda", "group", fileName)
        fileName.startsWith("panda_knowledge") ->
            finalPath = appendVideoFile("panda", "knowledge", fileName)
        fileName.startsWith("panda_mom") ->
            finalPath = appendVideoFile("panda", "mom", fileName)
        fileName.startsWith("single") ->
            finalPath = appendVideoFile("panda", "single", fileName)
        fileName.startsWith("video_banner") ->
            finalPath = appendVideoFile("panda", "all", fileName)
        fileName.startsWith("rabbit") ->
            finalPath = appendVideoFile("animal", "rabbit", fileName)
        fileName.startsWith("hamster") ->
            finalPath = appendVideoFile("animal", "hamster", fileName)
        fileName.startsWith("tiger") ->
            finalPath = appendVideoFile("animal", "tiger", fileName)
    }
    return File(localFile, finalPath)
}

/**
 * 拼接多级file目录
 *  - /sdcard/Android/data/com.example.hello_diordna/files/videos/animal/bear/pet_bear1.mp4
 * @param: "animal" "bear" "pet_bear1"
 * @return:
 * @version: v1.0
 */
private fun appendVideoFile(vararg fileNames: String): String {

    val builder = StringBuilder("videos").append(File.separator)
    fileNames.forEachIndexed { index, name ->
        builder.append(name)
        if (index == fileNames.size - 1) {
//            builder.append(".mp4")
            builder.append(".flv")
        } else {
            builder.append(File.separator)
        }
    }
    return builder.toString()
}

/**
 * 通过文件名获取文件夹目录
 * @param:
 * @return:
 * @author: dongyiming
 * @date: 7/17/22 6:49 下午
 * @version: v1.0
 */
fun getVideoLocalPath(context: Context, fileName: String): String {
    val path = getExtFilePath(fileName)
    val localFile = FileUtils.getExternalFileDirectory(context, "")
    val finalPath = StringBuilder("videos").append(File.separator).append(path).toString()
    return File(localFile, finalPath).absolutePath
}

