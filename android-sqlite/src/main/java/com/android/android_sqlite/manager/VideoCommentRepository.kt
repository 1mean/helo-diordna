package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.bean.ReplyInfo
import com.android.android_sqlite.dao.UserDao
import com.android.android_sqlite.dao.VideoCommentDao
import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoComment
import com.android.android_sqlite.entity.VideoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

/**
 * @description: 处理VideoComment表相关的数据库操作
 * @author: dongyiming
 * @date: 8/18/24 5:21 PM
 * @version: v1.0
 */
val commentRepository: VideoCommentRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { VideoCommentRepository() }

public class VideoCommentRepository : BaseRepository() {

    private val commentDao: VideoCommentDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().videoCommentDao()
    }


    suspend fun insert(comments: MutableList<VideoComment>) {
        withContext(Dispatchers.IO) {
            commentDao.insert(comments)
        }
    }

    suspend fun delete(list: MutableList<VideoComment>) {
        withContext(Dispatchers.IO) {
            commentDao.delete(list)
        }
    }

    suspend fun deleteComment(videoCode: Int, commentId: Int) {
        withContext(Dispatchers.IO) {
            commentDao.deleteComment(videoCode, commentId)
        }
    }

    suspend fun delete(comment: VideoComment) {
        withContext(Dispatchers.IO) {
            commentDao.delete(comment)
        }
    }

    suspend fun update(videoComment: VideoComment) {
        withContext(Dispatchers.IO) {
            commentDao.update(videoComment)
        }
    }

    fun queryCommentById(videoCode: Int, commentId: Int): Flow<VideoComment> =
        flowIn(commentDao.queryCommentById(videoCode, commentId))

    fun queryCommentByVideoCode(videoCode: Int): Flow<MutableList<VideoComment>> =
        flowIn(commentDao.queryCommentByVideoCode(videoCode))

    suspend fun getVideoCommentByPage(
        isOrderByTime: Boolean,
        videoCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.IO) {

            delay(500)
            //先获取一级弹幕
            val list = if (isOrderByTime) {//获取时间顺序的数据
                commentDao.queryPageCommentsByType(videoCode, startIndex, counts, 1)
            } else {
                commentDao.queryCommentsByHot(videoCode, startIndex, counts, 1)
            }

            if (list.isNotEmpty()) {
                list.forEach {
                    val childList =
                        commentDao.queryVideoChildComment(
                            it.comment.videoCode,
                            it.comment.commentId
                        )
                    if (childList.isNotEmpty()) {
                        it.comment.replyComments = childList
                    }
                }
            }
            list
        }
    }

    suspend fun getPageComments(
        isOrderByTime: Boolean,
        videoCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.IO) {
            //先获取一级弹幕
            val list = if (isOrderByTime) {//获取时间顺序的数据
                commentDao.queryPageCommentsByType(videoCode, startIndex, counts, 1)
            } else {
                commentDao.queryCommentsByHot(videoCode, startIndex, counts, 1)
            }
            if (list.isNotEmpty()) {
                list.forEach {
                    val count =
                        commentDao.queryCommentReplyCounts(it.comment.videoCode, it.comment.id)
                    if (count > 0) {
                        it.comment.replyCounts = count
                    } /*else{
                        it.comment.replyCounts = (1..10).random()
                    }*/
                }
            }
            list
        }
    }

    suspend fun getPageReplyComments(
        startIndex: Int,
        pageCounts: Int,
        videoCode: Int,
        topCommentId: Int
    ): MutableList<CommentAndUser> {
        return withContext(Dispatchers.IO) {
            delay(200)
            commentDao.queryReplyComments(videoCode, topCommentId, startIndex, pageCounts)
        }
    }

    /**
     * 获取弹幕的回复信息
     */
    suspend fun getCommentReplyByPage(
        videoCode: Int,
        commentId: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {
        return withContext(Dispatchers.IO) {
            if (startIndex == 0) {
                val comments = mutableListOf<CommentAndUser>()
                val topComment = commentDao.queryCommentUserByCommentId(videoCode, commentId)
                comments.add(0, topComment)
                val list = commentDao.queryReplyByPage(videoCode, commentId, startIndex, counts - 1)
                if (list.isNotEmpty()) {
                    comments.addAll(list)
                }
                comments
            } else {
                commentDao.queryReplyByPage(videoCode, commentId, startIndex, counts)
            }
        }
    }

    /**
     * 发送一条弹幕，同时videodata列表应该+1
     */
    suspend fun sendComment(comment: VideoComment): VideoComment {
        return withContext(Dispatchers.IO) {
            val commentId = commentDao.insert(comment)
            val videoComment = commentDao.queryCommentById(commentId.toInt())
            if (videoComment != null) {//消息个数+1
                val videoData = commentDao.queryVideoDataByCode(comment.videoCode)
                if (videoData == null) {
                    val vd = VideoData(videoCode = comment.videoCode, comments = 1)
                    commentDao.insert(vd)
                } else {
                    videoData.comments += 1
                    commentDao.update(videoData)
                }
            }
            videoComment
        }
    }

    suspend fun updateVideoComment(comment: VideoComment) {
        return withContext(Dispatchers.IO) {
            commentDao.update(comment)
        }
    }

    suspend fun saveComment(
        replyInfo: ReplyInfo?,
        content: String,
        videoCode: Int
    ): CommentAndUser {
        return withContext(Dispatchers.IO) {
            val comment = VideoComment()
            //当没有评论时，获取到的id是null，以String类型返回
            //不使用id是因为可能每一次调整数据库，该数据的id会不同，不能保证唯一性
            var maxCommentId = commentDao.queryMaxCommentId(videoCode)
            if (maxCommentId.isNullOrEmpty()) {
                maxCommentId = "0"
            }
            comment.commentId = maxCommentId.toInt() + 1
            if (replyInfo == null) {
                comment.type = 1
            } else {
                comment.type = replyInfo.type
                comment.fromUserName = "和叶小可怜"//AppInfos.AUTHOR_NAME
                comment.toUserName = replyInfo.replyUserName
                comment.toUserCode = replyInfo.replyUserCode
                comment.topCommentId = replyInfo.commentId
            }
            val user = commentDao.queryUserByCode(1074309089)//Appinfos.AUTHOR_ID
            comment.fromUserCode = 1074309089//Appinfos.AUTHOR_ID
            comment.commitTime = System.currentTimeMillis()
            comment.content = content
            comment.videoCode = videoCode
            commentDao.insert(comment)
            val videodata = commentDao.queryVideoDataByCode(videoCode)
            videodata?.let {
                it.comments += 1
                commentDao.update(it)
            }
            delay(300)
            CommentAndUser(comment, user)
        }
    }

    suspend fun saveReply(
        replyInfo: ReplyInfo,
        content: String
    ): CommentAndUser {
        return withContext(Dispatchers.IO) {
            val comment = VideoComment()
            //当没有评论时，获取到的id是null，以String类型返回
            var maxCommentId = commentDao.queryMaxCommentId(replyInfo.videoCode)
            if (maxCommentId.isNullOrEmpty()) {
                maxCommentId = "0"
            }
            comment.commentId = maxCommentId.toInt() + 1
            comment.type = replyInfo.type
            comment.fromUserName = "和叶小可怜"//AppInfos.AUTHOR_NAME
            comment.toUserName = replyInfo.replyUserName
            comment.toUserCode = replyInfo.replyUserCode
            comment.topCommentId = replyInfo.commentId
            val user = commentDao.queryUserByCode(1074309089)//Appinfos.AUTHOR_ID
            comment.fromUserCode = 1074309089//Appinfos.AUTHOR_ID
            comment.commitTime = System.currentTimeMillis()
            comment.content = content
            comment.videoCode = replyInfo.videoCode
            commentDao.insert(comment)
            delay(300)
            CommentAndUser(comment, user)
        }
    }
}