package com.example.pandas.biz.http.invoker

import com.example.pandas.bean.eyes.Eyepetozer
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.http.RetrofitBuilder
import com.example.pandas.biz.http.service.EyepetozerService
import com.example.pandas.biz.interaction.IEyepetozerHttpInvoker
import com.example.pandas.biz.manager.EyepetozerFunction
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.ResourceObserver
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @description: 开眼视频网络请求
 * @author: dongyiming
 * @date: 2021/12/21 4:41 下午
 * @version: v1.0
 */
public class EyepetozerHttpInvoker : IEyepetozerHttpInvoker {

    private var eyepetozerService: EyepetozerService? = null

    init {
        val retrofit = RetrofitBuilder.instance.getRxRetrofit(BASE_URL)
        eyepetozerService = retrofit?.create(EyepetozerService::class.java)
    }

    override fun tabsSelected(subscriber: ResourceObserver<Eyepetozer>) {
        eyepetozerService?.discoveryHot()?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

    override fun discoveryHot(subscriber: ResourceObserver<MutableList<EyepetozerItem>>) {

        eyepetozerService?.discoveryHot()?.map(EyepetozerFunction())?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

    override fun discoveryHot(
        startIndx: Int,
        count: Int,
        subscriber: ResourceObserver<MutableList<EyepetozerItem>>
    ) {
        eyepetozerService?.discoveryHot(startIndx, count)?.map(EyepetozerFunction())
            ?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

    override fun getRecommendVideos(
        videoId: Int,
        subscriber: ResourceObserver<MutableList<EyepetozerItem>>
    ) {
        eyepetozerService?.getRecommendVideo(videoId)?.map(EyepetozerFunction())
            ?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

}