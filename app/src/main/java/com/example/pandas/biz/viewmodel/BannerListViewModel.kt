package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.BannerListBean
import com.example.pandas.bean.LandscapeData
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser
import kotlinx.coroutines.launch

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