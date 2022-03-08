package com.example.pandas.biz.viewmodel

import FileUtils
import PetManagerCoroutine
import UIDataWrapper
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData
import java.io.File

/**
 * @description: LocalCacheViewModel
 * @author: dongyiming
 * @date: 3/8/22 1:39 下午
 * @version: v1.0
 */
public class LocalCacheViewModel : BaseViewModel() {

    private var times = 0

    val selectFileName: MutableLiveData<String> by lazy { MutableLiveData() }
    val cacheList: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    fun setSelectFileName(newFileName: String) {
        selectFileName.value = newFileName
    }

    /**
     * 获取本地videos文件夹里的目录
     */
    fun getCacheList(context: Context): MutableList<PetViewData> {

        val list = mutableListOf<PetViewData>()
        val localFile = FileUtils.getExternalFileDirectory(context, "")
        localFile?.list()?.forEach {
            if (it.equals("videos")) {
                val videoFile = File(localFile, it)
                if (videoFile.isDirectory) {
                    val fileList = videoFile.listFiles()
                    fileList?.forEach { file ->
                        if (file.isDirectory) {//过滤隐藏文件
                            val video = PetViewData()
                            video.title = file.name
                            val url = AppInfos.fileUrl.getValue(file.name)
                            video.cover = url
                            list.add(video)
                        }
                    }
                }
            }
        }
        return list
    }


    fun getItemList(isFirst: Boolean, context: Context) {

        if (isFirst) {
            times = 0
        }

        request({
            val localFile = FileUtils.getExternalFileDirectory(context, "")
            val list = mutableListOf<PetViewData>()
            if (localFile != null) {
                val itemFile =
                    File(
                        localFile,
                        File.separator.plus("videos").plus(File.separator)
                            .plus(selectFileName.value)
                    )
                if (itemFile.isDirectory) {
                    val videoList = itemFile.listFiles()
                    if (videoList != null && videoList.isNotEmpty()) {

                        val videoMutableList =
                            videoList.toMutableList().subList(times * 20, (times + 1) * 20)
                        //每次取21条数据
                        videoMutableList.removeLast()
                        videoMutableList.forEach { file ->
                            val fileName = file.name.split(".")[0]
                            val data = PetManagerCoroutine.getVideoByFileName(fileName)
                            list.add(data)
                        }
                    }
                }
            }
            list
        },
            {
                //请求数据成功
                times += 1
                val hasMore = it.size > 20
                it.removeLast()
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isFirst,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    listData = it
                )
                cacheList.value = dataList
            },
            {
                //请求数据失败
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = isFirst,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetViewData>()
                )
                cacheList.value = dataList
            })
    }
}