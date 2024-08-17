package com.example.pandas.biz.http.service

import com.example.pandas.bean.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @description: OpenHttpService
 * @author: dongyiming
 * @date: 8/15/24 12:52 AM
 * @version: v1.0
 */
interface OpenHttpService {

    /**
     * 登录
     * @param username username
     * @param password password
     * @return Flow<LoginResponse>
     */
    @POST("/user/login")
    @FormUrlEncoded
    suspend fun loginWanAndroid(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginResponse

    /**
     * 注册
     * @param username username
     * @param password password
     * @param repassword repassword
     * @return Flow<LoginResponse>
     */
    @POST("/user/register")
    @FormUrlEncoded
    suspend fun registerWanAndroid(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassowrd: String
    ): LoginResponse

    /**
     * 退出
     *
     * 返回数据：{"data": null,"errorCode": 0,"errorMsg": ""}
     *
     * @return Flow<LoginResponse>
     */
    @GET("/user/logout/json")
    suspend fun logout(): LoginResponse

}