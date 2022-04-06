package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.MusicVo
import kotlinx.coroutines.launch

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
    val musicCount: MutableLiveData<Int> by lazy { MutableLiveData() }

    fun getMusicCounts() {

        viewModelScope.launch {

            musicCount.value = PetManagerCoroutine.getMusicCounts()
        }
    }

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

        request({ PetManagerCoroutine.getPageMusic(musicStartIndex, 21) },
            { list ->
                val hasMore = list.size == 21
                if (list.size == 21) {
                    list.removeLast()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = musicStartIndex == 0,
                    hasMore = hasMore,
                    isEmpty = list.isEmpty(),
                    listData = list
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