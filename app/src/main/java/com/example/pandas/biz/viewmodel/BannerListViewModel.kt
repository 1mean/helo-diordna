package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.android_sqlite.PetManagerCoroutine
import com.android.android_sqlite.bean.BannerListBean
import com.android.android_sqlite.entity.VideoAndUser
import com.example.pandas.app.AppInfos
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper

/**
 * @description: PandaViewModel
 * @author: dongyiming
 * @date: 3/27/22 11:47 下午
 * @version: v1.0
 */
public class BannerListViewModel : BaseViewModel() {

    val bannerList: MutableLiveData<UIDataWrapper<BannerListBean>> by lazy { MutableLiveData() }
    val bestList: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }

    private var pages = 10
    private var videoCodes: MutableList<Int> = mutableListOf()

    fun getBest(isRefresh: Boolean) {

        if (isRefresh) {
            pages = 25
            videoCodes.clear()
            videoCodes.addAll(AppInfos.bestPandaVideoCodes + AppInfos.bestBeautyVideoCodes + AppInfos.bestAnimalVideoCodes)
        } else {
            pages = 20
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

        Log.e("1mean","selects size: ${selects.size}")
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
}