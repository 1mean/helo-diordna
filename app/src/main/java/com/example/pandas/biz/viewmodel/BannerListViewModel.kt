package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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

    private var startIndex = 0
    private var counts = 0
    private var hasMore = false

    fun getBannerList(isRefresh: Boolean) {
        if (isRefresh) {
            startIndex = 0
            counts = 26
        } else {
            counts = 21
        }
        viewModelScope.launch {
            runCatching {
                PetManagerCoroutine.getCMBannerList(startIndex, counts)
            }.onSuccess {
                val itemList = it.itemList
                Log.e("1mean","itemList: ${itemList.size}")
                hasMore = if (itemList.isNotEmpty() && itemList.size > 20) {
                    itemList.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper<BannerListBean>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.bannerList.isEmpty(),
                    bannerList = it
                )
                startIndex += counts
                bannerList.value = dataList
            }.onFailure {
                val dataList = UIDataWrapper<BannerListBean>(
                    isSuccess = false,
                    errMessage = it.message.toString(),
                    isRefresh = isRefresh,
                    bannerList = BannerListBean()
                )
                bannerList.value = dataList
            }
        }
    }
}