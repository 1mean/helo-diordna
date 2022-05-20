package com.example.pandas.biz.interaction

import com.example.pandas.bean.eyes.Eyepetozer
import com.example.pandas.bean.eyes.EyepetozerItem
import io.reactivex.rxjava3.observers.ResourceObserver

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/21 4:43 下午
 * @version: v1.0
 */
interface IEyepetozerHttpInvoker {

    val BASE_URL: String
        get() = "http://baobab.kaiyanapp.com/api/v4/"

    fun tabsSelected(subscriber: ResourceObserver<Eyepetozer>)

    fun discoveryHot(subscriber: ResourceObserver<MutableList<EyepetozerItem>>)

    fun discoveryHot(
        startIndx: Int,
        count: Int,
        subscriber: ResourceObserver<MutableList<EyepetozerItem>>
    )

    fun getRecommendVideos(
        videoId: Int,
        subscriber: ResourceObserver<MutableList<EyepetozerItem>>
    )
}