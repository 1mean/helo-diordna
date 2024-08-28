package com.example.pandas.biz.http

import android.util.Log
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.http.service.EyepetozerService
import com.example.pandas.biz.http.service.OpenHttpService
import com.example.pandas.utils.Preference
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @description: RetrofitBuilder
 * @author: dongyiming
 * @date: 2021/12/21 5:14 下午
 * @version: v1.0
 */
val httpService: EyepetozerService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitBuilder.instance.getFlowRetrofit(EyepetozerService.BASE_URL)
        .create(EyepetozerService::class.java)
}

val wanAndroidService: OpenHttpService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitBuilder.instance.getService(
        RetrofitBuilder.instance.REQUEST_BASE_URL,
        OpenHttpService::class.java
    )
}

public class RetrofitBuilder private constructor() {

    private val CONNECT_TIMEOUT = 30L
    private val READ_TIMEOUT = 10L
    private val SAVE_USER_LOGIN_KEY = "user/login"
    private val SAVE_USER_REGISTER_KEY = "user/register"
    private val SET_COOKIE_KEY = "set-cookie"
    private val COOKIE_NAME = "Cookie"
    private val CONTENT_PRE = "OkHttp: "
    val REQUEST_BASE_URL = "https://www.wanandroid.com"

    private var eyesRetrofit: Retrofit? = null
    private var httpclentBuilder: OkHttpClient.Builder? = null
    private val DEFAULT_TIMEOUT = 5L

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = RetrofitBuilder()
    }

    fun getRxRetrofit(BASE_URL: String): Retrofit? {

        if (eyesRetrofit == null) {
            val client = getHttpBuilder().build()
            eyesRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }
        return eyesRetrofit
    }

    fun getFlowRetrofit(BASE_URL: String): Retrofit {

        if (eyesRetrofit == null) {
            val client = getHttpBuilder().build()
            eyesRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return eyesRetrofit!!
    }

    fun create(url: String): Retrofit {
        // okHttpClientBuilder
        val okHttpClientBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            // get response cookie
            addInterceptor {
                val request = it.request()
                val response = it.proceed(request)
                Log.e("1mean","response:$response")
                val requestUrl = request.url.toString()
                val domain = request.url.host
                // set-cookie maybe has multi, login to save cookie
                if ((requestUrl.contains(SAVE_USER_LOGIN_KEY) || requestUrl.contains(
                        SAVE_USER_REGISTER_KEY
                    )) && response.headers(SET_COOKIE_KEY).isNotEmpty()
                ) {
                    val cookies = response.headers(SET_COOKIE_KEY)
                    Log.e("222222","cookies:$cookies")
                    val cookie = encodeCookie(cookies)
                    Log.e("222222","cookie:$cookie")
                    saveCookie(requestUrl, domain, cookie)
                }
                response
            }
            // set request cookie
            addInterceptor {
                val request = it.request()
                val builder = request.newBuilder()
                val domain = request.url.host
                // get domain cookie
                if (domain.isNotEmpty()) {
                    val spDomain: String by Preference(domain, "")
                    Log.e("1mean","spDomain:$spDomain")
                    val cookie: String = spDomain.ifEmpty { "" }
                    Log.e("1mean","cookie:$cookie")
                    if (cookie.isNotEmpty()) {
                        builder.addHeader(COOKIE_NAME, cookie)
                    }
                }
                it.proceed(builder.build())
            }
            // add log print
            if (AppInfos.IS_DEBUG) {//是否是debug
                // loggingInterceptor
                addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                    Log.e(AppInfos.DEBUG_LOG_TAG, CONTENT_PRE + it)
                }).apply {
                    level = HttpLoggingInterceptor.Level.BODY// log level
                })
            }
        }

        return RetrofitBuild(
            url = url,
            client = okHttpClientBuilder.build(),
            gsonFactory = GsonConverterFactory.create()
            //coroutineCallAdapterFactory = CoroutineCallAdapterFactory()
        ).retrofit
    }

    /**
     * get ServiceApi
     */
    fun <T> getService(url: String, service: Class<T>): T = create(url).create(service)

    private fun getHttpBuilder(): OkHttpClient.Builder {

        if (httpclentBuilder == null) {
            httpclentBuilder = OkHttpClient.Builder()
            httpclentBuilder!!.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            //solve SocketTimeoutException: timeout
            httpclentBuilder!!.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
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
        return httpclentBuilder!!
    }

    /**
     * save cookie to SharePreferences
     */
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    private fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        var spUrl: String by Preference(url, cookies)
        Log.e("222222","spUrl1:$spUrl")
        @Suppress("UNUSED_VALUE")
        spUrl = cookies
        Log.e("222222","spUrl2:$spUrl")
        domain ?: return
        var spDomain: String by Preference(domain, cookies)
        Log.e("222222","spDomain1:$spDomain")
        @Suppress("UNUSED_VALUE")
        spDomain = cookies
        Log.e("222222","spDomain2:$spDomain")
    }

    /**
     * save cookie string
     */
    private fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies
            .map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            .forEach {
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }

        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }

        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }

        return sb.toString()
    }

    //委托的双重单例模式
//    companion object {
//        val instance: com.example.pandas.biz.http.RetrofitBuilder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            com.example.pandas.biz.http.RetrofitBuilder()
//        }
//    }
}

class RetrofitBuild(
    url: String, client: OkHttpClient,
    gsonFactory: GsonConverterFactory
    //coroutineCallAdapterFactory: CoroutineCallAdapterFactory
) {
    val retrofit: Retrofit = Retrofit.Builder().apply {
        baseUrl(url)
        client(client)
        addConverterFactory(gsonFactory)
        //addCallAdapterFactory(coroutineCallAdapterFactory)
    }.build()
}