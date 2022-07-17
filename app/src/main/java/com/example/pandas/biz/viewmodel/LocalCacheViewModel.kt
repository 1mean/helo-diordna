package com.example.pandas.biz.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.app.fileDesc
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    val localVideos: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }

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
                            val url = fileDesc.getValue(file.name)
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
    fun getLocalVideos(isRefresh: Boolean, localPath: String) {

        require(File(localPath).exists()) {
            "local cache path is not exist"
        }

        request({
            withContext(Dispatchers.Default) {

                if (isRefresh) {
                    times = 0
                    if (mp4List.isNotEmpty()) {
                        mp4List.clear()
                    }
                    mp4List = File(localPath).listFiles()!!.toMutableList()
                }
                val videoList = mutableListOf<VideoAndUser>()
                val pageList =
                    if ((times + 1) * counts >= mp4List.size) {//最后一批数据
                        mp4List.subList(
                            times * counts,
                            mp4List.size
                        )
                    } else {
                        mp4List.subList(
                            times * counts,
                            (times + 1) * counts + 1
                        )
                    }
                //每次取21条数据
                pageList.forEach { file ->
                    Log.e("1mean", "file: ${file.name}")
                    val fileName = file.name.split(".")[0]
                    val data = PetManagerCoroutine.getVideoByFileName(fileName)
                    videoList.add(data)
                }
                videoList
            }
        },
            {
                //请求数据成功
                times += 1
                val hasMore = it.size > counts
                if (hasMore) {
                    it.removeLast()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    listData = it
                )
                localVideos.value = dataList
            },
            {
                //请求数据失败
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = isRefresh,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<VideoAndUser>()
                )
                localVideos.value = dataList
            })
    }
}