package com.example.pandas.biz.http.invoker

import EyepetozerFunction
import com.example.pandas.bean.eyes.Eyepetozer
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.http.RetrofitBuilder
import com.example.pandas.biz.http.service.EyepetozerService
import com.example.pandas.biz.interaction.IEyepetozerHttpInvoker
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.ResourceObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

/**
 * @description: 开眼视频网络请求
 * @author: dongyiming
 * @date: 2021/12/21 4:41 下午
 * @version: v1.0
 */
public class EyepetozerHttpInvoker : IEyepetozerHttpInvoker {

    private var eyepetozerService: EyepetozerService? = null

    init {
        val retrofit = RetrofitBuilder.instance.getEyeRetrofit(BASE_URL)
        eyepetozerService = retrofit?.create(EyepetozerService::class.java)
    }

    override fun tabsSelected(subscriber: ResourceObserver<Eyepetozer>) {
        eyepetozerService?.tabsSelected()?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

    override fun discoveryHot(subscriber: ResourceObserver<MutableList<EyepetozerBean>>) {

        eyepetozerService?.discoveryHot()?.map(EyepetozerFunction())?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

    override fun discoveryHot(
        startIndx: Int,
        count: Int,
        subscriber: ResourceObserver<MutableList<EyepetozerBean>>
    ) {
        eyepetozerService?.discoveryHot(startIndx,count)?.map(EyepetozerFunction())?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

    override fun getRecommendVideos(
        videoId: Int,
        subscriber: ResourceObserver<MutableList<EyepetozerBean>>
    ) {
        eyepetozerService?.getRecommendVideo(videoId)?.map(EyepetozerFunction())?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

}