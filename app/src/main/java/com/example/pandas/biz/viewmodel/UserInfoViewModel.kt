package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.PetManagerCoroutine
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoAndData
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.ext.loge
import com.android.base.exception.ExceptionHandle
import com.android.base.vm.SingleLiveData
import kotlinx.coroutines.launch

/**
 * @description: UserInfoViewModel
 * @author: dongyiming
 * @date: 4/21/22 5:36 下午
 * @version: v1.0
 */
public class UserInfoViewModel : BaseViewModel() {

    var startIndex = 0//分页起始
    var hasMore = true//是否有更多
    val user: SingleLiveData<User> by lazy { SingleLiveData() }

    val userVideos: MutableLiveData<UIDataWrapper<VideoAndData>> by lazy { MutableLiveData() }

    fun getUserVideos(code: Int, isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getUserVideos(code, startIndex, 11)
            }.onSuccess {

                hasMore = if (it.size > 10) {
                    it.removeLast()
                    true
                } else {
                    false
                }

                val dataList = UIDataWrapper<VideoAndData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += 10
                userVideos.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<VideoAndData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf()
                )
                userVideos.value = dataList
            }
        }
    }

    fun updateAttention(userCode: Int) {
        viewModelScope.launch {
            PetManagerCoroutine.updateAttention(userCode)
        }
    }

    fun getUserByCode(userCode: Int) {
        viewModelScope.launch {
            user.value = PetManagerCoroutine.getUser(userCode)
        }
    }
}