package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.CommentAndUser
import com.example.pandas.bean.ReplyInfo
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.VideoInfo
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
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
    val createComment: MutableLiveData<CommentAndUser> by lazy { MutableLiveData() }
    val createReply: MutableLiveData<CommentAndUser> by lazy { MutableLiveData() }
    val comments: MutableLiveData<UIDataWrapper<CommentAndUser>> by lazy { MutableLiveData() }
    val commentReply: MutableLiveData<UIDataWrapper<CommentAndUser>> by lazy { MutableLiveData() }

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

    var hasCommentsMore = false
    var startCommentsIndex = 0
    fun getComments(isRefresh: Boolean) {

        if (isRefresh) {
            startCommentsIndex = 0
        }
        request({
            PetManagerCoroutine.getVideoCommentByPage(
                videoInfo.value!!.code,
                startCommentsIndex,
                21
            )
        }, {
            if (it.isNotEmpty() && it.size > 20) {
                hasCommentsMore = true
                it.removeLast()
            } else {
                hasCommentsMore = false
            }
            val dataList = UIDataWrapper(
                isSuccess = true,
                isRefresh = isRefresh,
                isEmpty = it.isEmpty(),
                hasMore = hasCommentsMore,
                isFirstEmpty = isRefresh && it.isEmpty(),
                listData = it
            )
            startCommentsIndex += 20
            comments.value = dataList
        }, {
            val dataList = UIDataWrapper(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = mutableListOf<CommentAndUser>()
            )
            comments.value = dataList
        })
    }

    var hasMore = false
    var startIndex = 0
    fun getCommentReply(isRefresh: Boolean, commentId: Int) {

        if (isRefresh) {
            startIndex = 0
        }
        request({
            PetManagerCoroutine.getCommentReplyByPage(
                videoInfo.value!!.code,
                commentId,
                startIndex,
                21
            )
        }, {
            if (it.isNotEmpty() && it.size > 20) {
                hasMore = true
                it.removeLast()
            } else {
                hasMore = false
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
            commentReply.value = dataList
        }, {
            val dataList = UIDataWrapper(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = mutableListOf<CommentAndUser>()
            )
            commentReply.value = dataList
        })
    }


    /**
     * 生成一条弹幕
     */
    fun saveComment(replyInfo: ReplyInfo?, content: String) {

        viewModelScope.launch {
            videoInfo.value?.let {
                createComment.value = PetManagerCoroutine.saveComment(replyInfo, content, it.code)
            }
        }
    }

    fun saveReply(replyInfo: ReplyInfo, content: String) {
        viewModelScope.launch {
            createReply.value = PetManagerCoroutine.saveReply(replyInfo, content)
        }
    }
}