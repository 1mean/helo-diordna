package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.UIDataWrapper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @description: BannerViewModel
 * @author: dongyiming
 * @date: 7/8/23 12:29 AM
 * @version: v1.0
 */
public class OneVerticalViewModel : BaseViewModel() {

    val bestList: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }

    private val _itemListResult: MutableSharedFlow<UIDataWrapper<VideoAndUser>> by lazy { MutableSharedFlow() }
    val itemListResult = _itemListResult.asSharedFlow()

    private val _pandaResult: MutableSharedFlow<UIDataWrapper<VideoAndUser>> by lazy { MutableSharedFlow() }
    val pandaResult = _pandaResult.asSharedFlow()

    private var counts = 0
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
            videoRepository.getSelectedVideoUser(selects)
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

        viewModelScope.launch {

            if (isRefresh) {
                videoStartIndex = 0
            }

            videoRepository.getVideosByType(currentType, videoStartIndex, 21).collect {
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
                _itemListResult.emit(dataList)
            }
        }
    }

    fun getPandas(isRefresh: Boolean, title: String) {
        viewModelScope.launch {
            if (isRefresh) {
                startIndex = 0
                counts = 26
            } else {
                counts = 21
            }
            videoRepository.getPandas(title, startIndex, counts).collect {
                val hasMore = if (it.isNotEmpty() && it.size >= counts) {
                    it.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += counts
                _pandaResult.emit(dataList)
            }
        }
    }
}