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
    public fun tabsSelected(): Observable<Eyepetozer>


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

    //热门搜索词
    //http://baobab.kaiyanapp.com/api/v3/queries/hot

}