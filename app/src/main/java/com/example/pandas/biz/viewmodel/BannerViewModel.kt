package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.HistoryItem
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: BannerViewModel
 * @author: dongyiming
 * @date: 7/8/23 12:29 AM
 * @version: v1.0
 */
public class BannerViewModel : BaseViewModel() {

    val bestList: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    private var startIndex = 0
    private var pages = 0
    private var videoCodes: MutableList<Int> = mutableListOf()

    fun getBest(isRefresh: Boolean) {

        if (isRefresh) {
            pages = 13
            startIndex = 0
            videoCodes.clear()
            videoCodes.addAll(AppInfos.bestPandaVideoCodes)
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

        request({ PetManagerCoroutine.getSelectedVideo(selects) },
            {
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = !videoCodes.isEmpty(),
                    listData = it
                )
                bestList.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetVideo>()
                )
                bestList.value = dataList
            })
    }
}