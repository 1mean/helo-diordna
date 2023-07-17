package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser

/**
 * @description: BannerViewModel
 * @author: dongyiming
 * @date: 7/8/23 12:29 AM
 * @version: v1.0
 */
public class OneVerticalViewModel : BaseViewModel() {

    val bestList: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }
    val itemListResult: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }

    private var startIndex = 0
    private var videoStartIndex = 0
    private var pages = 10
    private var videoCodes: MutableList<Int> = mutableListOf()

    fun getBest(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
            videoCodes.clear()
            videoCodes.addAll(AppInfos.bestPandaVideoCodes + AppInfos.bestBeautyVideoCodes + AppInfos.bestAnimalVideoCodes)
        } else {
            pages = 10
        }

        val selects = mutableListOf<Int>()

        for (i in 0 until pages) {
            if (videoCodes.isEmpty()) {
                break
            }
            val selected = videoCodes.random()
            selects.add(selected)
            videoCodes.remove(selected)
        }

        request({
            PetManagerCoroutine.getSelectedVideoUser(selects)
        },
            {
                var hasMore = false
                if (videoCodes.isNotEmpty()) {
                    hasMore = true
                }

                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    listData = it
                )
                bestList.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<VideoAndUser>()
                )
                bestList.value = dataList
            })
    }

    fun getListResult(isRefresh: Boolean, currentType: Int) {

        if (isRefresh) {
            videoStartIndex = 0
        }
        request({ PetManagerCoroutine.getVideosByVideoType(currentType, videoStartIndex, 21) },
            {

                val hasMoreData = it.size >= 21
                if (hasMoreData) {
                    it.removeLast()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = hasMoreData,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                videoStartIndex += 20
                itemListResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = isRefresh,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<VideoAndUser>()
                )
                itemListResult.value = dataList
            })
    }
}