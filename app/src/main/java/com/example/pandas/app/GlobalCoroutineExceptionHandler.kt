package com.example.pandas.app

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

/**
 * @description: GlobalCoroutineExceptionHandler
 * @author: dongyiming
 * @date: 7/29/23 12:36 AM
 * @version: v1.0
 */
public class GlobalCoroutineExceptionHandler : CoroutineExceptionHandler {

    override val key: CoroutineContext.Key<*>
        get() = CoroutineExceptionHandler

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        Log.d("1mean", "UnCaught exception: $exception")
    }
}