package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.bean.ReplyInfo
import com.android.android_sqlite.bean.VideoInfo
import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.History
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.android_sqlite.manager.*
import com.android.base.exception.ExceptionHandle
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.ext.loge
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

    var hasCommentsMore = false
    var startCommentsIndex = 0

    val videoData: MutableLiveData<PetVideo> by lazy { MutableLiveData() }
    val videos: MutableLiveData<VideoInfo> by lazy { MutableLiveData() }
    val createComment: MutableLiveData<CommentAndUser> by lazy { MutableLiveData() }
    val createReply: MutableLiveData<CommentAndUser> by lazy { MutableLiveData() }
    val comments: MutableLiveData<UIDataWrapper<CommentAndUser>> by lazy { MutableLiveData() }
    val commentReply: MutableLiveData<UIDataWrapper<CommentAndUser>> by lazy { MutableLiveData() }

    /**
     * 获取播放的视频的信息和推荐视频
     */
    fun getVideoInfoAndRelations(code: Int) {

        viewModelScope.launch {
            runCatching {
                videoRepository.getVideoInfo(code, 40)
            }.onSuccess {
                videos.value = it
            }.onFailure {
                it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }

    fun getVideoData(code: Int) {
        viewModelScope.launch {
            videoData.value = videoRepository.getVideoInfoData(code)
        }
    }

    fun saveHistory(code: Int, currentPosition: Long) {
        viewModelScope.launch {
            val formatBuilder = StringBuilder()
            val formatter = Formatter(formatBuilder, Locale.getDefault())
            val position = Util.getStringForTime(formatBuilder, formatter, currentPosition)
            val history =
                History(
                    code = code,
                    lastTime = System.currentTimeMillis(),
                    playPosition = position
                )
            historyRepository.saveHistory(history)
            videoRepository.addOrUpdateVideoData(code, currentPosition)
        }
    }

    /**
     * 按顺序获取弹幕数据
     *  - isOrderByTime：true,按时间获取数据
     *  - isOrderByTime：false,按热度获取数据
     *
     * @date: 9/15/22 7:00 下午
     * @version: v1.0
     */
    fun getCommentsByOrder(code: Int, isRefresh: Boolean, isOrderByTime: Boolean) {

        if (isRefresh) {
            startCommentsIndex = 0
        }
        request({
            commentRepository.getVideoCommentByPage(
                isOrderByTime,
                code,
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
    fun getCommentReply(isRefresh: Boolean, code: Int, commentId: Int) {

        if (isRefresh) {
            startIndex = 0
        }
        request({
            commentRepository.getCommentReplyByPage(
                code,
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
    fun saveComment(code: Int, replyInfo: ReplyInfo?, content: String) {

        viewModelScope.launch {
            createComment.value = commentRepository.saveComment(replyInfo, content, code)
        }
    }

    fun saveReply(replyInfo: ReplyInfo, content: String) {
        viewModelScope.launch {
            createReply.value = commentRepository.saveReply(replyInfo, content)
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


    fun addLaterPlayer(videoCode: Int) {
        viewModelScope.launch {
            videoRepository.addLater(videoCode)
        }
    }
}