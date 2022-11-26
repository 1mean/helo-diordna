package com.example.pandas.biz.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.getFileCover
import com.example.pandas.app.getUiName
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.CachaListItem
import com.example.pandas.bean.CacheListItemData
import com.example.pandas.biz.ext.getVideoLocalPath
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.User
import com.example.pandas.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * @description: SelfViewModel
 * @author: dongyiming
 * @date: 2/28/22 6:22 下午
 * @version: v1.0
 */
public class SelfViewModel : BaseViewModel() {

    val userInfo: MutableLiveData<User> by lazy { MutableLiveData() }

    private val _follows: MutableLiveData<Int> by lazy { MutableLiveData() }
    val follows: LiveData<Int> = _follows


    val followUser: MutableLiveData<MutableList<User>> by lazy { MutableLiveData() }
    val cacheList: MutableLiveData<MutableList<CacheListItemData>> by lazy { MutableLiveData() }

    fun getUserInfo() {
        viewModelScope.launch {
            userInfo.value = PetManagerCoroutine.getUser(1074309089)
        }
    }

    fun getCurrentFollows(context: Context) {
        viewModelScope.launch {
            _follows.value = PetManagerCoroutine.getAllFollowCounts()
        }
    }

    fun getAllFollowUser() {

        viewModelScope.launch {
            followUser.value = PetManagerCoroutine.getAllFollowUsers()
        }
    }

    /**
     * 获取本地videos文件夹里的目录
     */
    fun getCacheList(context: Context) {

        viewModelScope.launch {
            cacheList.value = withContext(Dispatchers.Default) {
                val list = mutableListOf<CacheListItemData>()
                val localFile = FileUtils.getExternalFileDirectory(context, "")
                localFile?.list()?.forEach {
                    if (it.equals("videos")) {
                        val videoFile = File(localFile, it)
                        if (videoFile.isDirectory) {
                            val fileList = videoFile.listFiles()
                            fileList?.forEach { file ->//一级目录
                                if (file.isDirectory) {//过滤隐藏文件
                                    val cacheItem = CacheListItemData()
                                    val cacheItemList = mutableListOf<CachaListItem>()
                                    cacheItem.title = getUiName(file.name)
                                    val secondFiles = file.listFiles()
                                    secondFiles?.forEach { secondFile ->
                                        if (secondFile.isDirectory) {//过滤隐藏文件
                                            val item = CachaListItem()
                                            secondFile.listFiles()?.let {
                                                item.counts = it.size
                                            }
                                            item.name = getUiName(secondFile.name)
                                            item.url = getFileCover(secondFile.name)
                                            item.localFilePath =
                                                getVideoLocalPath(context, secondFile.name)
                                            cacheItemList.add(item)
                                        }
                                    }
                                    cacheItem.data = cacheItemList
                                    list.add(cacheItem)
                                }
                            }
                        }
                    }
                }
                list
            }
        }
    }
}