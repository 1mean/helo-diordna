package com.example.pandas.biz.http.invoker

import com.example.pandas.bean.LoginResponse
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

    fun wxarticles() = flow {
        val response = wanAndroidService.wxarticles()
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun wxPageArticles(userId: Int, pageNo: Int) = flow {
        val response = wanAndroidService.wxPageArticles(userId, pageNo)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun homePageArticles(pageNo: Int) = flow {
        val response = wanAndroidService.homePageArticles(pageNo)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun collectInnerArticle(id: Int) = flow {
        val response = wanAndroidService.collectInnerArticle(id)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun collectOutsideArticle(title: String, author: String, link: String) = flow {
        val response = wanAndroidService.collectOutsideArticle(title, author, link)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun removeCollectedArticle(id: Int, originId: Int) = flow {
        val response = wanAndroidService.removeCollectedArticle(id, originId)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun hotkey() = flow {
        val response = wanAndroidService.hotkey()
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }
    fun pageSearch(page: Int, key: String) = flow {
        val response = wanAndroidService.pageSearch(page, key)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun getCoin() = flow {
        val response = wanAndroidService.getCoin()
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }

    fun getCoinHistory(pageNo: Int) = flow {
        val response = wanAndroidService.getCoinHistory(pageNo)
        emit(response)
    }.flowOn(Dispatchers.IO).catch { e ->
        e.printStackTrace()
    }
}