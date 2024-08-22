package com.example.pandas.biz.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.manager.userRepository
import com.android.base.utils.FileUtils
import com.android.base.vm.BaseViewModel
import com.android.base.vm.SingleLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.app.getFileCover
import com.example.pandas.app.getUiName
import com.example.pandas.bean.CachaListItem
import com.example.pandas.bean.CacheListItemData
import com.example.pandas.bean.LoginResponse
import com.example.pandas.biz.ext.getVideoLocalPath
import com.example.pandas.biz.http.invoker.wanAndroidInvoke
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
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

    private var int_flag = 0
    val intFlag: MutableLiveData<Int> by lazy { MutableLiveData() }

    private val _userInfo: MutableSharedFlow<User> by lazy { MutableSharedFlow() }
    val user = _userInfo.asSharedFlow()

    val userInfo: SingleLiveData<User> by lazy { SingleLiveData() }
    val updateUserResult: SingleLiveData<User> by lazy { SingleLiveData() }

    private val _follows: MutableSharedFlow<Int> by lazy { MutableSharedFlow() }
    val follows = _follows.asSharedFlow()
    private val _logout: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val logout = _logout.asSharedFlow()
    private val _followUser: MutableSharedFlow<MutableList<User>> by lazy { MutableSharedFlow() }
    val followUser = _followUser.asSharedFlow()
    val cacheList: MutableLiveData<MutableList<CacheListItemData>> by lazy { MutableLiveData() }

    fun getUser() {
        viewModelScope.launch {
            userRepository.getLoginUser().collect {
                _userInfo.emit(it)
            }
        }
    }

    fun getCurrentFollows() {
        viewModelScope.launch {
            userRepository.getAllFollowCounts().collect {
                _follows.emit(it)
            }
        }
    }

    fun getAllFollowUser() {
        viewModelScope.launch {
            userRepository.getAllFollowUsers().collect {
                _followUser.emit(it)
            }
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
                                        Log.e("1mean", "secondFile: $secondFile")
                                        if (secondFile.isDirectory) {//过滤隐藏文件
                                            val item = CachaListItem()
                                            //TODO:切记删除文件夹里的.DS_Store文件，不然数目总是不对，无法进行加载更多
                                            secondFile.listFiles()?.let {
                                                item.counts = it.size
                                            }
                                            item.name = getUiName(secondFile.name)
                                            item.url = getFileCover(secondFile.name)
                                            item.localFilePath =
                                                getVideoLocalPath(context, secondFile.name)
                                            Log.e("1mean", "item: $item")
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

    fun follow(context: Context, userCode: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                SPUtils.saveList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
            }
        }
    }

    fun updateAttention(userCode: Int) {
        viewModelScope.launch {
            userRepository.updateAttention(userCode)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            updateUserResult.value = userRepository.updateUser(user)
        }
    }

    fun reName(userName: String) {
        viewModelScope.launch {
            //PetManagerCoroutine.reName(userName, userCode)
            userRepository.reName(userName)
        }
    }

    fun reSign(sign: String) {
        viewModelScope.launch {
            userRepository.reSign(sign)
        }
    }

    fun reSex(sex: Int) {
        viewModelScope.launch {
            userRepository.reSex(sex)

        }
    }

    fun IntUpdate() {
        int_flag++
        intFlag.value = int_flag
    }

    fun logout() {
        viewModelScope.launch {
            wanAndroidInvoke.logOutWanAndroid().collect {
                Log.e("1mean", "logout thread:${Thread.currentThread().name}")
                _logout.emit(it)
            }
        }
    }
}