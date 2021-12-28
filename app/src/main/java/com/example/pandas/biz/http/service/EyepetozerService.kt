package com.example.pandas.biz.http.service

import com.example.pandas.bean.eyes.Eyepetozer
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/21 4:23 下午
 * @version: v1.0
 */
public interface EyepetozerService {

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
        get() = "http://baobab.kaiyanapp.com/api/v4/video/related"

}