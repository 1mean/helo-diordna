package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import kotlinx.coroutines.launch

/**
 * @description: VerticalVideoViewModel
 * @author: dongyiming
 * @date: 9/20/22 5:19 下午
 * @version: v1.0
 */
public class VerticalVideoViewModel : BaseViewModel() {

    var startIndex = 0//分页起始
    var hasMore = true//是否有更多

    val verticalVideos: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    fun getVerticalVideos(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = (0..20).random()
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getVerticalVideos(startIndex, 11)
            }.onSuccess {

                hasMore = if (it.size > 10) {
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
                startIndex += 10
                verticalVideos.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PetVideo>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf()
                )
                verticalVideos.value = dataList
            }
        }
    }

    fun addOrUpdateVideoData(videoData: VideoData) {
        viewModelScope.launch {
            PetManagerCoroutine.addOrUpdateVideoData(videoData)
        }
    }

    fun updateCollect(isAdd: Boolean, videoCode: Int) {
        viewModelScope.launch {
            if (isAdd) {
                PetManagerCoroutine.addCollection("默认收藏夹", videoCode)
            } else {
                PetManagerCoroutine.deleteCollection("默认收藏夹", videoCode)
            }
        }
    }
}