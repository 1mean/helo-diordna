package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.PetManagerCoroutine
import com.android.android_sqlite.entity.MusicVo
import com.android.android_sqlite.entity.VideoAndUser
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
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

    val itemListResult: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }
    val musicResult: MutableLiveData<UIDataWrapper<MusicVo>> by lazy { MutableLiveData() }
    val musicCount: MutableLiveData<Int> by lazy { MutableLiveData() }

    fun getMusicCounts() {

        viewModelScope.launch {

            musicCount.value = PetManagerCoroutine.getMusicCounts()
        }
    }

    var hasMoreData: Boolean = false
    fun getListResult(isRefresh: Boolean) {

        if (isRefresh) {
            videoStartIndex = 0
        }
        request({ PetManagerCoroutine.getVideosByVideoType(currentType, videoStartIndex, 21) },
            {

                hasMoreData = it.size >= 21
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

    fun getPageMusic() {

        request({ PetManagerCoroutine.getPageMusic(0, musicStartIndex, 21) },
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