package com.example.pandas.biz.manager

import android.content.Context
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.ICommentCallback
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
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
            val list = PetManagerCoroutine.getPageComments(
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
            val list = PetManagerCoroutine.getPageReplyComments(
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
            val videoComment = PetManagerCoroutine.sendComment(comment)
            listener.sendCommentResult(videoComment)
        }
    }
}