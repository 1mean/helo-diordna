package com.example.pandas.biz.controller

import android.util.Log
import com.example.pandas.bean.eyes.Eyepetozer
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.http.invoker.EyepetozerHttpInvoker
import com.example.pandas.biz.interaction.ICommonInvokeResult
import io.reactivex.rxjava3.observers.ResourceObserver

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/21 6:34 下午
 * @version: v1.0
 */
public class EyepetozerController {

    private var invoker: EyepetozerHttpInvoker? = null

    init {
        invoker = EyepetozerHttpInvoker()
    }

    /**
     * 获取所有tab数据
     * @param:
     * @version: v1.0
     */
    fun tabsSelected(commonInvokeResult: ICommonInvokeResult<Eyepetozer, String>) {

        val observer = object : ResourceObserver<Eyepetozer>() {
            override fun onNext(eyepetozer: Eyepetozer) {

                val des = eyepetozer.itemList[0].data.description
                Log.e("1mean", "des: $des")
                commonInvokeResult.onResult(eyepetozer)
            }

            override fun onError(e: Throwable) {
                commonInvokeResult.onFailure(e.toString())
            }

            override fun onComplete() {
                commonInvokeResult.onCompleted()
            }
        }
        invoker?.tabsSelected(observer)
    }

    /**
     * 初始化界面数据
     * @param:
     * @return:
     * @version: v1.0
     */
    fun initData(commonInvokeResult: ICommonInvokeResult<MutableList<EyepetozerBean>, String>) {

        val observer = object : ResourceObserver<MutableList<EyepetozerBean>>() {
            override fun onNext(list: MutableList<EyepetozerBean>) {

                commonInvokeResult.onResult(list)
            }

            override fun onError(e: Throwable) {
                commonInvokeResult.onFailure(e.toString())
            }

            override fun onComplete() {
                commonInvokeResult.onCompleted()
            }
        }
        invoker?.discoveryHot(observer)
    }

    /**
     * 加载更多
     * http://baobab.kaiyanapp.com/api/v4/discovery/hot?start=20&num=20
     * http://baobab.kaiyanapp.com/api/v4/discovery/hot?start=40&num=20
     * @param:
     * @return:
     * @version: v1.0
     */
    fun loadMore(
        start: Int,
        num: Int,
        commonInvokeResult: ICommonInvokeResult<MutableList<EyepetozerBean>, String>
    ) {

        val observer = object : ResourceObserver<MutableList<EyepetozerBean>>() {
            override fun onNext(list: MutableList<EyepetozerBean>) {

                commonInvokeResult.onResult(list)
            }

            override fun onError(e: Throwable) {
                commonInvokeResult.onFailure(e.toString())
            }

            override fun onComplete() {
                commonInvokeResult.onCompleted()
            }
        }
        invoker?.discoveryHot(start, num, observer)
    }
}