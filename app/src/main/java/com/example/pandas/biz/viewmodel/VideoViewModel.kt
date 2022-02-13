package com.example.pandas.biz.viewmodel

import PetManagerCoroutine
import android.content.Context
import android.os.Environment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.sql.entity.PetVideo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/11/22 4:38 下午
 * @version: v1.0
 */
public class VideoViewModel : BaseViewModel() {

    val videoInfo: MutableLiveData<PetVideo> by lazy { MutableLiveData() }

    fun getVideoInfo(code: Int) {

        viewModelScope.launch {
            PetManagerCoroutine.getVideoByCode(code).collect {
                videoInfo.value = it
            }
        }
    }

    /**
     * 从本地获取视频目录
     */
    fun getUrl(context: Context, fileName: String): File {

        val localFile = FileUtils.getExternalFileDirectory(context, Environment.DIRECTORY_MOVIES)
        val builder = StringBuilder()
        var finalPath = ""
        when {
            fileName.startsWith("bird") ->
                finalPath =
                    builder.append(File.separator).append("bird").append(fileName).toString()
            fileName.startsWith("pet_fox") ->
                finalPath =
                    builder.append(File.separator).append("fox").append(fileName).toString()
            fileName.startsWith("pet_monkey") ->
                finalPath =
                    builder.append(File.separator).append("monkey").append(fileName).toString()
            fileName.startsWith("video_banner") ->
                finalPath =
                    builder.append(File.separator).append("all").append(fileName).toString()
            fileName.startsWith("panda_group") ->
                finalPath =
                    builder.append(File.separator).append("group").append(fileName).toString()
            fileName.startsWith("landscape") ->
                finalPath =
                    builder.append(File.separator).append("landscape").append(fileName).toString()
            fileName.startsWith("panda_mom") ->
                finalPath =
                    builder.append(File.separator).append("mom").append(fileName).toString()
            fileName.startsWith("panda_baby") ->
                finalPath =
                    builder.append(File.separator).append("baby").append(fileName).toString()
            fileName.startsWith("music") ->
                finalPath =
                    builder.append(File.separator).append("music").append(fileName).toString()
            fileName.startsWith("panda_all") ->
                finalPath =
                    builder.append(File.separator).append("all").append(fileName).toString()
            fileName.startsWith("panda_knowledge") ->
                finalPath =
                    builder.append(File.separator).append("knowledge").append(fileName).toString()
            fileName.startsWith("penguin") ->
                finalPath =
                    builder.append(File.separator).append("penguin").append(fileName).toString()
            fileName.startsWith("red_panda") ->
                finalPath =
                    builder.append(File.separator).append("red_panda").append(fileName).toString()
            fileName.startsWith("pet_bear") ->
                finalPath =
                    builder.append(File.separator).append("bear").append(fileName).toString()
            fileName.startsWith("single") ->
                finalPath =
                    builder.append(File.separator).append("single").append(fileName).toString()
        }
        return File(localFile, finalPath)
    }
}