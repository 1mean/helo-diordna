package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @description: 获取宠物信息
 * @author: dongyiming
 * @date: 1/26/22 12:00 上午
 * @version: v1.0
 */
public class CutePetViewModel : BaseViewModel() {

    private val _bannerWrapper: MutableSharedFlow<UIDataWrapper<PetVideo>> by lazy { MutableSharedFlow() }
    val bannerWrapper = _bannerWrapper.asSharedFlow()

    val pageDataWrapper: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    //分页起始位置
    var startIndex = 0

    fun getBannerData(isRefresh: Boolean) {
        viewModelScope.launch {
            videoRepository.getCutePetBannerData().collect {
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                _bannerWrapper.emit(dataList)
            }
        }
    }

    private var hasMore = false
    fun getDataByPage(isRefresh: Boolean, type: Int) {

        if (isRefresh) {
            startIndex = 0
        }

        request({ videoRepository.getCutePetByType(type, startIndex, 21) },
            {

                hasMore = if (it.isNotEmpty() && it.size > 20) {
                    it.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += 20
                pageDataWrapper.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetVideo>()
                )
                pageDataWrapper.value = dataList
            })
    }

    fun addOrUpdateVideoData(videoData: VideoData) {
        viewModelScope.launch {
            videoRepository.addOrUpdateVideoData(videoData)
        }
    }
}