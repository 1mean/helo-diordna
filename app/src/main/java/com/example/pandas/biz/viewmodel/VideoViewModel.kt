package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.VideoComment
import com.example.pandas.bean.VideoInfo
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.data.TempData
import com.example.pandas.sql.entity.History
import com.example.pandas.sql.entity.PetVideo
import com.google.android.exoplayer2.util.Util
import kotlinx.coroutines.launch
import java.util.*

/**
 * @description: VideoViewModel
 * @author: dongyiming
 * @date: 2/11/22 4:38 下午
 * @version: v1.0
 */
public class VideoViewModel : BaseViewModel() {

    val videoInfo: MutableLiveData<PetVideo> by lazy { MutableLiveData() }
    val videos: MutableLiveData<VideoInfo> by lazy { MutableLiveData() }
    val isVideoItemClicked: MutableLiveData<Int> by lazy { MutableLiveData() }
    val createComment: MutableLiveData<VideoComment> by lazy { MutableLiveData() }
    val comments: MutableLiveData<UIDataWrapper<VideoComment>> by lazy { MutableLiveData() }

    fun getVideoInfo(code: Int) {

        viewModelScope.launch {
            runCatching {
                PetManagerCoroutine.getVideoInfo(code, 40)
            }.onSuccess {

                videoInfo.value = it.videoInfo
                videos.value = it

            }.onFailure {
                it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }

    fun setVideoItemClick(code: Int) {
        isVideoItemClicked.value = code
    }


    fun saveHistory(code: Int, currentPosition: Long) {

        Thread {
            val formatBuilder = StringBuilder()
            val formatter = Formatter(formatBuilder, Locale.getDefault())
            val position = Util.getStringForTime(formatBuilder, formatter, currentPosition)
            val history =
                History(
                    code = code,
                    lastTime = System.currentTimeMillis(),
                    playPosition = position
                )
            PetManagerCoroutine.saveHistory(history)
        }.start()
    }

    fun getComments(isRefresh: Boolean) {

        request({
            val list = TempData.getComments(20)
            list.forEach {
                val user = PetManagerCoroutine.getUser(it.userCode)
                it.user = user
            }
            list
        }, {
            val dataList = UIDataWrapper(
                isSuccess = true,
                isRefresh = isRefresh,
                isEmpty = it.isEmpty(),
                hasMore = it.size == 20,
                isFirstEmpty = isRefresh && it.isEmpty(),
                listData = it
            )
            comments.value = dataList
        }, {
            val dataList = UIDataWrapper(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = mutableListOf<VideoComment>()
            )
            comments.value = dataList
        })
    }

    /**
     * 生成一条弹幕
     */
    fun createComment(content: String) {

        viewModelScope.launch {

            val comment = VideoComment()
            comment.commitTime = System.currentTimeMillis()
            comment.userCode = AppInfos.AUTHOR_ID
            comment.type = 0
            comment.content = content
            videoInfo.value?.let {
                comment.videoCode = it.code
                comment.user = PetManagerCoroutine.getUser(AppInfos.AUTHOR_ID)
            }
            createComment.value = comment
        }
    }
}