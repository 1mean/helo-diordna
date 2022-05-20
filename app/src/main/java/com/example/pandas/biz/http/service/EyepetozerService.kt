package com.example.pandas.biz.http.service

import com.example.pandas.bean.eyes.Eyepetozer
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @description: 从retrofit+rxjava --> retrofit+courtinue
 * @author: dongyiming
 * @date: 2021/12/21 4:23 下午
 * @version: v1.0
 */
interface EyepetozerService {

    companion object {
        val BASE_URL: String
            get() = "http://baobab.kaiyanapp.com/api/v4/"
    }

    /**
     * 获取首页所有数据
     *  url - http://baobab.kaiyanapp.com/api/v4/tabs/selected
     *
     * @return: Eyepetozer
     * @version: v1.0
     */
    @GET("tabs/selected")
    suspend fun tabsSelected(
        @Query("date") date: Long, //时间
        @Query("num") num: Int, //
        @Query("page") page: Int
    ): Eyepetozer

    @GET("tabs/selected")
    suspend fun tabsSelected(): Eyepetozer

    /**
     * 获取热门分类数据
     *  url - http://baobab.kaiyanapp.com/api/v4/discovery/hot
     *
     * @return
     * @version: v1.0
     */
    @GET("discovery/hot")
    fun discoveryHot(): Observable<Eyepetozer>

    @GET("discovery/hot")
    suspend fun getHotList(): Eyepetozer

    @GET("discovery/hot")
    suspend fun getHotList(
        @Query("start") startIndex: Int,
        @Query("num") count: Int
    ): Eyepetozer

    /**
     * 获取分页数据
     * http://baobab.kaiyanapp.com/api/v4/discovery/hot?start=20&num=20
     * @param startIndex
     * @param count
     * @return
     * @version: v1.0
     */
    @GET("discovery/hot")
    fun discoveryHot(
        @Query("start") startIndex: Int,
        @Query("num") count: Int
    ): Observable<Eyepetozer>

    /**
     * 获得当前视频的相关推荐视频
     *      http://baobab.kaiyanapp.com/api/v4/video/related?id=xxx
     *
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 12/30/21 11:40 下午
     * @version: v1.0
     */
    @GET("video/related")
    fun getRecommendVideo(@Query("id") id: Int): Observable<Eyepetozer>

    @GET("video/related")
    suspend fun getRecommend(@Query("id") id: Int): Eyepetozer

    /**
     * <热门评论>
     *
     *     public int videoId = 186856
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 2021/12/22 3:56 下午
     * @version: v1.0
     */
    val REPLY_URL: String
        get() = "http://baobab.kaiyanapp.com/api/v2/replies/video"

    /**
     * 相关推荐
     */
    val NOMINATE_URL: String
        get() = "http://baobab.kaiyanapp.com/api/v4/video/related?id=xxx"

    //作者信息
    //http://baobab.kaiyanapp.com/api/v4/pgcs/detail/tab?id=571

    //获取排行榜的 Info
    //http://baobab.kaiyanapp.com/api/v4/rankList

    ////获取搜索信息
    //http://baobab.kaiyanapp.com/api/v1/search?&num=10&start=10&query=xxx

    //热门搜索关键词
    // http://baobab.kaiyanapp.com/api/v3/queries/hot

    //关注
    // http://baobab.kaiyanapp.com/api/v4/tabs/follow

//    ### 首页
//
//    1.发现更多
//
//    - 请求地址： http://baobab.kaiyanapp.com/api/v7/index/tab/discovery
//
//    2.每日推荐
//
//    - 请求地址： http://baobab.kaiyanapp.com/api/v5/index/tab/allRec
//
//    3.日报精选
//
//    - 请求地址 ： http://baobab.kaiyanapp.com/api/v5/index/tab/feed
//
//
//    ### 社区
//
//    1.推荐
//
//    - 请求地址： http://baobab.kaiyanapp.com/api/v7/community/tab/rec
//
//    2.关注
//
//    - 请求地址： http://baobab.kaiyanapp.com/api/v6/community/tab/follow
//
//
//    ### 通知
//
//    1.主题
//
//    - 请求地址： http://baobab.kaiyanapp.com/api/v7/tag/tabList
//
//    2.通知
//
//    - 请求地址 ：  http://baobab.kaiyanapp.com/api/v3/messages
//
//    3.互动
//
//    - 请求地址 ：  http://baobab.kaiyanapp.com/api/v7/topic/list
//
//    ### 视频详情页
//
//    1.相关推荐
//
//    - 请求地址 ：http://baobab.kaiyanapp.com/api/v4/video/related?id=186856
//
//
//    |参数说明 |说明 |是否必须 |默认值 |
//    |-|-|-|-|
//    |id|当前播放视频的id，从跳转页面视频item中获取|是|无|
//
//
//    2. 评论
//
//    - 请求地址 ：http://baobab.kaiyanapp.com/api/v2/replies/video?videoId=186856
//
//
//    |参数说明 |说明 |是否必须 |默认值 |
//    |-|-|-|-|
//    |videoId|当前播放视频的id，从跳转页面视频item中获取|是|无|
}