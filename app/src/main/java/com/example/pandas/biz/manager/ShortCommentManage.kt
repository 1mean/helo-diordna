package com.example.pandas.biz.manager

import android.content.Context
import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoComment
import com.android.android_sqlite.manager.commentRepository
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.ICommentCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @description: ShortCommentManage
 * @author: dongyiming
 * @date: 6/7/23 9:34 PM
 * @version: v1.0
 */
public class ShortCommentManage(val context: Context, val commentScope: CoroutineScope) {

    /**
     * <获取一级评论>
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 6/7/23 9:36 PM
     * @version: v1.0
     */
    fun getPageComment(
        videoCode: Int,
        startIndex: Int,
        pageCount: Int,
        listener: ICommentCallback
    ) {
        commentScope.launch {
            val list = commentRepository.getPageComments(
                true,
                videoCode,
                startIndex,
                pageCount
            )
            val hasMore = list.size > 20
            if (hasMore) {
                list.removeLast()
            }
            val dataList = UIDataWrapper<CommentAndUser>(
                isSuccess = true,
                isEmpty = list.isEmpty(),
                hasMore = hasMore,
                listData = list
            )
            listener.getPageComments(dataList)
        }
    }

    fun buildCommentUser(videoCode: Int, content: String): CommentAndUser {

        val comment = VideoComment(
            videoCode = videoCode,
            fromUserCode = AppInfos.AUTHOR_ID,
            fromUserName = AppInfos.AUTHOR_NAME,
            type = 1,
            commitTime = System.currentTimeMillis(),
            content = content,
        )
        val user = User(
            userCode = AppInfos.AUTHOR_ID,
            userName = AppInfos.AUTHOR_NAME,
            headUrl = AppInfos.HEAD_URL,
            ipAddress = "湖北"
        )
        return CommentAndUser(comment, user)
    }

    fun buildCommentUser(commentAndUser: CommentAndUser, content: String): CommentAndUser {

        commentAndUser.comment.run {
            this.content = content
            commitTime = System.currentTimeMillis()
        }
        return commentAndUser
    }

    fun getPageReply(
        topCommentPosition: Int,
        startIndex: Int,
        pageCount: Int,
        videoCode: Int,
        commentId: Int,
        listener: ICommentCallback
    ) {

        commentScope.launch {
            val list = commentRepository.getPageReplyComments(
                startIndex,
                pageCount,
                videoCode,
                commentId,
            )
            listener.getPageReply(topCommentPosition, list)
        }
    }

    fun sendComment(comment: VideoComment, listener: ICommentCallback) {
        commentScope.launch {
            val videoComment = commentRepository.sendComment(comment)
            listener.sendCommentResult(videoComment)
        }
    }

    fun updateComment(videoComment: VideoComment) {
        commentScope.launch {
            commentRepository.updateVideoComment(videoComment)
        }
    }
}