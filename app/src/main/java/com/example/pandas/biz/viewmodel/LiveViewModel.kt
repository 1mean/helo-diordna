package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.LiveVideoData
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine

/**
 * @description: EyepetozerViewModel
 * @author: dongyiming
 * @date: 2/22/22 11:21 下午
 * @version: v1.0
 */
public class LiveViewModel : BaseViewModel() {

    var startIndex = 0//分页起始
    var hasMore = true//是否有更多
    var pandaHasMore = true//是否有更多

    val liveVideos: MutableLiveData<UIDataWrapper<LiveVideoData>> by lazy { MutableLiveData() }

    fun getLiveVideo(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
        }
        requests({ PetManagerCoroutine.getLiveVides(isRefresh, startIndex, 31) },
            {
                //请求数据成功
                pandaHasMore = if (it.lives.size > 30) {
                    it.lives.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper<LiveVideoData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.lives.isEmpty(),
                    hasMore = pandaHasMore,
                    isFirstEmpty = isRefresh && it.lives.isEmpty(),
                    liveVides = it
                )
                startIndex += 30
                liveVideos.value = dataList
            },
            {
                //请求数据失败
                val dataList = UIDataWrapper<LiveVideoData>(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    liveVides = LiveVideoData()
                )
                liveVideos.value = dataList
            })
    }
}