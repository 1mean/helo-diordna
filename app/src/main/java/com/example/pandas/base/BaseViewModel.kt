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
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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
        Log.e("1mean", "id:$id, list:$list")
        if (list.isEmpty()) {
            return false
        } else {
            return list.contains(id.toString())
        }
    }

}