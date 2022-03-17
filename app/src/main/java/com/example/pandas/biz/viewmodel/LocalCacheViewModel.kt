package com.example.pandas.biz.viewmodel

import FileUtils
import PetManagerCoroutine
import UIDataWrapper
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

/**
 * @description: LocalCacheViewModel
 * @author: dongyiming
 * @date: 3/8/22 1:39 下午
 * @version: v1.0
 */
public class LocalCacheViewModel : BaseViewModel() {

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

    private var times = 0
    private var counts = 20
    private var mp4List = mutableListOf<File>()
    fun getItemList(isShow: Boolean, context: Context) {

        if (isShow) {
            times = 0
            if (mp4List.isNotEmpty()) {
                mp4List.clear()
            }
        }

        request({
            withContext(Dispatchers.IO) {

                val list = getAllFiles(context)
                Log.e("1madaean","size: ${list.size}")
                val videoList = mutableListOf<PetViewData>()
                val pageList =
                    if ((times + 1) * counts >= list.size) {//最后一批数据
                        list.subList(
                            times * counts,
                            list.size
                        )
                    } else {
                        list.subList(
                            times * counts,
                            (times + 1) * counts + 1
                        )
                    }
                Log.e("111111mean", "list: ${list.size}")
                //每次取21条数据
                pageList.forEach { file ->
                    Log.e("1mean", "file: ${file.name}")
                    val fileName = file.name.split(".")[0]
                    val data = PetManagerCoroutine.getVideoByFileName(fileName)
                    Log.e("filename-data", "fileName: $fileName , ,data:$data")
                    videoList.add(data)
                }
                videoList
            }
        },
            {
                //请求数据成功
                times += 1
                Log.e("111111mean", "lit.size: ${it.size}")
                val hasMore = it.size > counts
                if (hasMore) {
                    it.removeLast()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isShow,
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
                    isRefresh = isShow,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetViewData>()
                )
                cacheList.value = dataList
            })
    }

    /**
     * 获取指定文件夹下的所有mp4文件
     */
    private fun getAllFiles(context: Context): MutableList<File> {

        if (mp4List.isEmpty()) {
            val localFile = FileUtils.getExternalFileDirectory(context, "")
            if (localFile != null) {
                val itemFile = File(localFile, "/videos/".plus(selectFileName.value))
                if (itemFile.isDirectory) {
                    val videoList = itemFile.listFiles()
                    Log.e("1madaean","videoList: ${videoList.size}")
                    if (videoList != null && videoList.isNotEmpty()) {
                        //过滤掉不是mp4的文件,目前已经物理删除
//                        mp4List = videoList.filter { file ->
//                            file.name.endsWith("mp4")
//                        }.toMutableList()
                        mp4List = videoList.toMutableList()
                        Log.e("1madaean","mp4List: ${mp4List.size}")
                    }
                }
            }
        }
        return mp4List
    }
}