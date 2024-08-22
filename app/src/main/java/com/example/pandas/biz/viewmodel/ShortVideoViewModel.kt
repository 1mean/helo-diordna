package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoComment
import com.android.android_sqlite.entity.VideoData
import com.android.android_sqlite.manager.commentRepository
import com.android.android_sqlite.manager.groupRepository
import com.android.android_sqlite.manager.userRepository
import com.android.android_sqlite.manager.videoRepository
import com.android.base.exception.ExceptionHandle
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.ext.loge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * @description: ShortVideoViewModel
 * @author: dongyiming
 * @date: 9/20/22 5:19 下午
 * @version: v1.0
 */
public class ShortVideoViewModel : BaseViewModel() {

    var startIndex1 = 0//分页起始
    var startIndex = 0//分页起始
    var fallsStartIndex = 0//分页起始
    var attentionStartIndex = 0//分页起始
    var fallsPage = 10
    var attentionPage = 10
    var hasMore = true//是否有更多

    val commentResult: MutableLiveData<VideoComment> by lazy { MutableLiveData() }

    val _verticalVideosFlow: MutableSharedFlow<UIDataWrapper<PetVideo>> by lazy { MutableSharedFlow() }
    val verticalVideosFlow = _verticalVideosFlow.asSharedFlow()

    val _verticalVideosFlow1: MutableSharedFlow<UIDataWrapper<PetVideo>> by lazy { MutableSharedFlow() }
    val verticalVideosFlow1 = _verticalVideosFlow1.asSharedFlow()


    val fallsShortVideos: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }
    val attentionShortVideos: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    fun getVerticalVideos(isRefresh: Boolean, videoCode: Int) {

        viewModelScope.launch {
            if (isRefresh) {
                startIndex1 = 0
            }
            flow {
                val list = videoRepository.getVerticalVideos1(startIndex1, 21, videoCode)
                emit(list)
            }.catch { e -> e.printStackTrace() }.collect {
                hasMore = if (it.size > 20) {
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
                startIndex1 += 10
                _verticalVideosFlow1.emit(dataList)
            }
        }
    }

    fun getVerticalVideos(isRefresh: Boolean) {

        viewModelScope.launch {
            if (isRefresh) {
                startIndex = 0
            }
            flow {
                val list = videoRepository.getVerticalVideos(startIndex, 21)
                emit(list)
            }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO).collect {
                hasMore = if (it.size > 20) {
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
                _verticalVideosFlow.emit(dataList)
            }
        }
    }

    /**
     * 获取瀑布流的短视频
     */
    fun getFallsShortVideos(isRefresh: Boolean) {

        fallsPage = 10
        if (isRefresh) {
//            startIndex = (0..20).random()
            fallsStartIndex = 0
            fallsPage = 20
        }
        viewModelScope.launch {
            runCatching {
                videoRepository.getFallsShortVideos(fallsStartIndex, fallsPage + 1)
            }.onSuccess {

                hasMore = if (it.size > fallsPage) {
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
                fallsStartIndex += fallsPage
                fallsShortVideos.value = dataList
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
                fallsShortVideos.value = dataList
            }
        }
    }

    /**
     * 获取关注的短视频
     */
    fun getAttentionFallVideos(isRefresh: Boolean) {

        attentionPage = 10
        if (isRefresh) {
//            startIndex = (0..20).random()
            attentionStartIndex = 0
            attentionPage = 20
        }
        viewModelScope.launch {
            runCatching {
                videoRepository.getAttentionFallsShortVideos(
                    attentionStartIndex,
                    attentionPage + 1
                )
            }.onSuccess {

                hasMore = if (it.size > attentionPage) {
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
                attentionStartIndex += attentionPage
                attentionShortVideos.value = dataList
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
                attentionShortVideos.value = dataList
            }
        }
    }

    fun updateCollect(isAdd: Boolean, videoCode: Int) {
        viewModelScope.launch {
            if (isAdd) {
                groupRepository.addCollection("默认收藏夹", videoCode)
            } else {
                groupRepository.deleteCollection("默认收藏夹", videoCode)
            }
        }
    }

    fun updateAttention(userCode: Int) {
        viewModelScope.launch {
            userRepository.updateAttention(userCode)
        }
    }

    fun addOrUpdateVideoData(videoData: VideoData) {
        viewModelScope.launch {
            videoRepository.addOrUpdateVideoData(videoData)
        }
    }

    fun updatePetVideo(video: PetVideo) {
        viewModelScope.launch {
            videoRepository.updatePetVideo(video)
        }
    }

    fun sendComment(comment: VideoComment) {
        viewModelScope.launch {
            commentResult.value = commentRepository.sendComment(comment)
        }
    }
}