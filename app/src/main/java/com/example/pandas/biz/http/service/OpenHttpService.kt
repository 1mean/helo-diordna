package com.example.pandas.biz.http.service

import com.example.pandas.bean.*
import retrofit2.http.*

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

    /**
     * 获取公众号列表
     */
    @GET("/wxarticle/chapters/json")
    suspend fun wxarticles(): WxarticleResponse

    /**
     * 获取公众号列表
     */
    @GET("/wxarticle/list/{id}/{page_no}/json")
    suspend fun wxPageArticles(
        @Path("id") id: Int,
        @Path("page_no") pageNo: Int
    ): WxPageArticleResponse

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */
    @GET("/article/list/{page}/json")
    suspend fun homePageArticles(
        @Path("page") page: Int
    ): WxPageArticleResponse

    /**
     * 收藏站内文章
     * @param id id
     * @return WxPageArticleResponse
     */
    @POST("/lg/collect/{id}/json")
    suspend fun collectInnerArticle(
        @Path("id") id: Int
    ): WxPageArticleResponse

    /**
     * 收藏站外文章
     * @param title title:文章标题
     * @param author author:作者
     * @param link link:文章 url
     */
    @POST("/lg/collect/add/json")
    @FormUrlEncoded
    suspend fun collectOutsideArticle(
        @Field("title") title: String,
        @Field("author") author: String,
        @Field("link") link: String
    ): WxPageArticleResponse

    /**
     * 删除收藏文章
     * @param id id
     * @param originId -1:列表页下发，无则为-1
     * @return WxPageArticleResponse
     */
    @POST("/lg/uncollect_originId/{id}/json")
    @FormUrlEncoded
    suspend fun removeCollectedArticle(
        @Path("id") id: Int,
        @Field("originId") originId: Int = -1
    ): WxPageArticleResponse

    /**
     * 搜索热词
     * https://www.wanandroid.com//hotkey/json
     */
    @GET("/hotkey/json")
    suspend fun hotkey(): HotKeyResponse

    /**
     * 搜索
     * https://www.wanandroid.com/article/query/0/json
     * @param page page:拼接在链接上，从0开始
     * @param k search key:搜索关键词
     */
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    suspend fun pageSearch(
        @Path("page") page: Int,
        @Field("k") k: String
    ): WxPageArticleResponse

    /**
     * 获取个人积分
     * https://www.wanandroid.com/lg/coin/userinfo/json
     * @param page page:拼接在链接上，从0开始
     * @param k search key:搜索关键词
     */
    @GET("/lg/coin/userinfo/json")
    suspend fun getCoin(): CoinResponse

    /**
     * 获取个人积分记录
     * https://www.wanandroid.com//lg/coin/list/1/json
     * @param page page:拼接在链接上，从0开始
     * @param k search key:搜索关键词
     */
    @GET("lg/coin/list/{page}/json")
    suspend fun getCoinHistory(@Path("page") page: Int): CoinsResponse
}