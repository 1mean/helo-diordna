package com.example.pandas.biz.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/21 5:14 下午
 * @version: v1.0
 */
public class RetrofitBuilder private constructor() {

    private var eyesRetrofit: Retrofit? = null
    private var httpclentBuilder: OkHttpClient.Builder? = null
    private val DEFAULT_TIMEOUT = 5L


    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = RetrofitBuilder()
    }

    fun getEyeRetrofit(BASE_URL: String): Retrofit? {

        if (eyesRetrofit == null) {
            if (httpclentBuilder == null) {
                httpclentBuilder = OkHttpClient.Builder()
                httpclentBuilder!!.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                httpclentBuilder!!.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                //解析出现了乱码
                httpclentBuilder!!.addInterceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "text/html; charset=gb2312")
                        .addHeader("Content-Type", "text/html; charset=UTF-8")
                        .addHeader("Accept-Encoding", "*")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Accept", "*/*")
                        .addHeader("Access-Control-Allow-Origin", "*")
                        .addHeader("Access-Control-Allow-Headers", "X-Requested-With")
                        .addHeader("Vary", "Accept-Encoding")
                        //.addHeader("Cookie", "add cookies here")
                        .build()
                    chain.proceed(request)
                }
            }
            eyesRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .client(httpclentBuilder!!.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }
        return eyesRetrofit
    }


    //委托的双重单例模式
//    companion object {
//        val instance: com.example.pandas.biz.http.RetrofitBuilder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            com.example.pandas.biz.http.RetrofitBuilder()
//        }
//    }
}