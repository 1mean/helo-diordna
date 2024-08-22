package com.example.pandas.biz.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.bean.PetViewData
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.manager.videoRepository
import com.android.base.utils.FileUtils
import com.android.base.vm.BaseViewModel
import com.example.pandas.app.fileDesc
import com.example.pandas.bean.UIDataWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
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

    private var startIndex = 0
    private var times = 0
    private var counts = 20
    private var mp4List = mutableListOf<File>()
    val selectFileName: MutableLiveData<String> by lazy { MutableLiveData() }
    val localVideos: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }
    private val _pandaResult: MutableSharedFlow<UIDataWrapper<VideoAndUser>> by lazy { MutableSharedFlow() }
    val pandaResult = _pandaResult.asSharedFlow()

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

    fun getLocalVideos(isRefresh: Boolean, localPath: String) {

        Log.e("1mean", "localPath: $localPath")
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
                    Log.e("2mean", "mp4List size : ${mp4List.size}")
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
                Log.e("2mean", "pageList size : ${pageList.size}")
                //每次取21条数据
                pageList.forEach { file ->
                    Log.e("1mean", "file: ${file.name}")
                    val fileName = file.name.split(".")[0]
                    Log.e("2mean", "fileName:  $fileName")
                    val data = videoRepository.getVideoByFileName(fileName)
                    Log.e("2mean", "data:  $data")
                    if (data != null) {//会存在为null的情况
                        videoList.add(data)
                    }
                }
                videoList
            }
        },
            {
                //请求数据成功
                times += 1
                Log.e("2mean", "it.size=${it.size}, counts:$counts")
                val hasMore = it.size > counts
                if (hasMore) {
                    it.removeLast()
                }
                Log.e("2mean", "hasmore: $hasMore")
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

    fun getPandas(isRefresh: Boolean, title: String) {
        viewModelScope.launch {
            if (isRefresh) startIndex = 0
            videoRepository.getPandas(title, startIndex, 21).collect {
                val hasMore = if (it.isNotEmpty() && it.size > 20) {
                    it.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += 20
                _pandaResult.emit(dataList)
            }
        }
    }
}