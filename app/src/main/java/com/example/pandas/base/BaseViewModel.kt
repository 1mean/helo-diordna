package com.example.pandas.base

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.AppException
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @description: BaseViewModel
 * @author: dongyiming
 * @date: 1/19/22 1:16 下午
 * @version: v1.0
 */
open class BaseViewModel : ViewModel() {

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
            withContext(Dispatchers.IO) {
                SPUtils.saveList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
            }
        }
    }

    fun unFollow(context: Context, userCode: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                SPUtils.removeFromList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
            }
        }
    }

    fun addAttention(context: Context, userCode: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            SPUtils.saveList(context, AppInfos.ATTENTION_KEY, userCode.toString())
        }
    }

    fun deleteAttention(context: Context, userCode: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            SPUtils.removeFromList(context, AppInfos.ATTENTION_KEY, userCode.toString())
        }
    }

}