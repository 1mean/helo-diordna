package com.example.pandas.biz.http.invoker

import com.example.pandas.bean.LoginResponse
import com.example.pandas.biz.http.RetrofitBuilder
import com.example.pandas.biz.http.service.OpenHttpService
import com.example.pandas.biz.http.wanAndroidService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * @description: WanAndroid
 * @author: dongyiming
 * @date: 8/15/24 2:55 PM
 * @version: v1.0
 */
val wanAndroidInvoke: WanAndroidInvoker by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { WanAndroidInvoker() }

public class WanAndroidInvoker {

    fun loginWanAndroid(userName: String, password: String) = flow<LoginResponse> {
        val response = wanAndroidService.loginWanAndroid(userName, password)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun registerWanAndroid(userName: String, password: String, repassowrd: String) = flow {
        val response = wanAndroidService.registerWanAndroid(userName, password, repassowrd)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun logOutWanAndroid() = flow {
        val response = wanAndroidService.logout()
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

}