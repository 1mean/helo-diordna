package com.example.pandas.app

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

/**
 * @description: 全局的Coroutine异常，都能获取到，帮助你定位问题，这里只获取异常，无法处理异常
 * @author: dongyiming
 * @date: 7/29/23 12:36 AM
 * @version: v1.0
 */
public class GlobalCoroutineExceptionHandler : CoroutineExceptionHandler {

    override val key: CoroutineContext.Key<*>
        get() = CoroutineExceptionHandler

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        Log.d(AppInfos.LOG_APP, "UnCaught CoroutineException: $exception")
    }
}