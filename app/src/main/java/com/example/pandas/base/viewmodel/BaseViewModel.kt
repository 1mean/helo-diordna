package com.example.pandas.base.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.AppException
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.concurrent.Flow

/**
 * @description: BaseViewModel
 * @author: dongyiming
 * @date: 1/19/22 1:16 下午
 * @version: v1.0
 */
open class BaseViewModel : ViewModel() {

    private var int_flag = 0
    val intFlag: MutableLiveData<Int> by lazy { MutableLiveData() }
    val commentResult: MutableLiveData<VideoComment> by lazy { MutableLiveData() }
    val updateUserResult: SingleLiveData<User> by lazy { SingleLiveData() }
    val user: SingleLiveData<User> by lazy { SingleLiveData() }

    fun IntUpdate() {
        int_flag++
        intFlag.value = int_flag
    }

    fun <T> request(
        block: suspend () -> MutableList<T>,
        success: (MutableList<T>) -> Unit,
        error: (AppException) -> Unit = {}
    ): Job {
        return viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                success(it)
            }.onFailure {
                it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }

    fun <T> requests(
        block: suspend () -> T,
        success: (T) -> Unit,
        error: (AppException) -> Unit = {}
    ): Job {
        return viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                success(it)
            }.onFailure {
                it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }

    fun isAttention(context: Context, id: Int): Boolean {

        val list = SPUtils.getList<String>(context, AppInfos.ATTENTION_KEY)
        if (list.isEmpty()) {
            return false
        } else {
            return list.contains(id.toString())
        }
    }

    fun follow(context: Context, userCode: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                SPUtils.saveList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
            }
        }
    }

    fun unFollow(context: Context, userCode: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                SPUtils.removeFromList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
            }
        }
    }

    fun updateAttention(userCode: Int) {
        viewModelScope.launch {
            PetManagerCoroutine.updateAttention(userCode)
        }
    }

    fun addOrUpdateVideoData(videoData: VideoData) {
        viewModelScope.launch {
            PetManagerCoroutine.addOrUpdateVideoData(videoData)
        }
    }

    fun updatePetVideo(video: PetVideo) {
        viewModelScope.launch {
            PetManagerCoroutine.updatePetVideo(video)
        }
    }

    fun addLaterPlayer(videoCode: Int) {
        viewModelScope.launch {
            PetManagerCoroutine.addLater(videoCode)
        }
    }

    fun sendComment(comment: VideoComment) {
        viewModelScope.launch {
            commentResult.value = PetManagerCoroutine.sendComment(comment)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            updateUserResult.value = PetManagerCoroutine.updateUser(user)
        }
    }

    fun reName(userName: String, userCode: Int) {
        viewModelScope.launch {
            PetManagerCoroutine.reName(userName, userCode)
        }
    }

    fun reSex(sex: Int, userCode: Int) {
        viewModelScope.launch {
            PetManagerCoroutine.reSex(sex, userCode)
        }
    }

    fun getUserByCode(userCode: Int) {
        viewModelScope.launch {
            user.value = PetManagerCoroutine.getUser(userCode)
        }
    }
}