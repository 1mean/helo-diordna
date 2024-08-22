package com.android.base.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.base.exception.AppException
import com.android.base.exception.ExceptionHandle
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * @description: BaseViewModel
 * @author: dongyiming
 * @date: 1/19/22 1:16 下午
 * @version: v1.0
 */
open class BaseViewModel : ViewModel() {

    //val commentResult: MutableLiveData<VideoComment> by lazy { MutableLiveData() }
//    val updateUserResult: SingleLiveData<User> by lazy { SingleLiveData() }
    //val user: SingleLiveData<User> by lazy { SingleLiveData() }

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
                //it.message?.loge()
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
                //it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }
}