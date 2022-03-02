package com.example.pandas.biz.viewmodel

import PetManagerCoroutine
import UIDataWrapper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.MusicVo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 3/1/22 11:23 下午
 * @version: v1.0
 */
public class MoreDataViewModel : BaseViewModel() {

    var currentType = -1
    private var videoStartIndex = 0
    private var musicStartIndex = 0

    val moreDataResult: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }
    val musicResult: MutableLiveData<UIDataWrapper<MusicVo>> by lazy { MutableLiveData() }

    fun getListResult() {

        request({ PetManagerCoroutine.getPageByType(currentType, videoStartIndex, 20) },
            {
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = videoStartIndex == 0,
                    hasMore = it.size == 20,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                videoStartIndex += 20
                moreDataResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = videoStartIndex == 0,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetViewData>()
                )
                moreDataResult.value = dataList
            })
    }

    fun getPageMusic() {

        request({ PetManagerCoroutine.getPageMusic(musicStartIndex, 20) },
            {
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = musicStartIndex == 0,
                    hasMore = it.size == 20,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                musicStartIndex += 20
                musicResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = musicStartIndex == 0,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<MusicVo>()
                )
                musicResult.value = dataList
            })
    }

}