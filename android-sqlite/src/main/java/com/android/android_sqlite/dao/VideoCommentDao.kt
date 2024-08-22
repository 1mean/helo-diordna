package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoComment
import com.android.android_sqlite.entity.VideoData
import kotlinx.coroutines.flow.Flow

/**
 * @description: UserDao
 * @author: dongyiming
 * @date: 7/29/24 11:27 AM
 * @version: v1.0
 */
@Dao
public interface VideoCommentDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(comments: MutableList<VideoComment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(comment: VideoComment): Long

    /*delete***************************************************************/
    @Delete
    suspend fun delete(list: MutableList<VideoComment>)

    @Delete
    suspend fun delete(comment: VideoComment)

    /*update***************************************************************/
    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(videoComment: VideoComment)

    /*query****************************************************************/
    @Query("delete from comment where videoCode=(:videoCode) and commentId=(:commentId)")
    suspend fun deleteComment(videoCode: Int, commentId: Int)

    @Query("select * from comment where commentId=(:commentId) and videoCode=(:videoCode)")
    fun queryCommentById(videoCode: Int, commentId: Int): Flow<VideoComment>

    @Query("select * from comment where id=(:commentId)")
    suspend fun queryCommentById(commentId: Int): VideoComment

    @Query("select * from comment where videoCode=(:videoCode)")
    fun queryCommentByVideoCode(videoCode: Int): Flow<MutableList<VideoComment>>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and type=(:type) order by commitTime desc limit (:startIndex),(:page)")
    suspend fun queryPageCommentsByType(
        videoCode: Int,
        startIndex: Int,
        page: Int,
        type: Int
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode) and type != 1 order by commitTime asc limit (:startIndex),(:page)")
    suspend fun queryReplyComments(
        videoCode: Int,
        topCommentCode: Int,
        startIndex: Int,
        page: Int
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and type=(:type) order by likeNum desc limit (:startIndex),(:page)")
    suspend fun queryCommentsByHot(
        videoCode: Int,
        startIndex: Int,
        page: Int,
        type: Int
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode) order by commitTime asc")
    suspend fun queryVideoChildComment(
        videoCode: Int,
        topCommentCode: Int,
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and commentId=(:commentId)")
    suspend fun queryCommentUserByCommentId(
        videoCode: Int,
        commentId: Int
    ): CommentAndUser

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:commentId) order by commitTime desc limit (:startIndex),(:page)")
    suspend fun queryReplyByPage(
        videoCode: Int,
        commentId: Int,
        startIndex: Int,
        page: Int
    ): MutableList<CommentAndUser>

    @Query("select count(*) from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode) and type != 1")
    suspend fun queryCommentReplyCounts(videoCode: Int, topCommentCode: Int): Int

    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode)")
    suspend fun queryCommentReply(
        videoCode: Int,
        topCommentCode: Int
    ): MutableList<VideoComment>

    @Query("select * from video_data where videoCode=(:code)")
    suspend fun queryVideoDataByCode(code: Int): VideoData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(videoData: VideoData)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(data: VideoData)

    /**
     * 查询最大的commentId,当视频没有任何评论时，如果直接返回Int类型会报错，转换成String返回，哪怕是null
     */
    @Query("select max(commentId) from comment where videoCode=(:videoCode)")
    suspend fun queryMaxCommentId(videoCode: Int): String?

    @Query("select * from user where userCode=(:userCode)")
    suspend fun queryUserByCode(userCode: Int): User
}