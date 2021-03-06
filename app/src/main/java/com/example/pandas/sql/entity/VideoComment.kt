package com.example.pandas.sql.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * 评论
 *   - 一级弹幕:视频弹幕
 *   - 二级弹幕:回复一级弹幕的弹幕
 *   - 三级弹幕:回复二级弹幕
 *
 */
@Entity(tableName = "comment")
data class VideoComment(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var commentId: Int = 0,//评论id，同一个video的评论自增长。
    @ColumnInfo
    var videoCode: Int = 0,
    @ColumnInfo
    var topCommentId: Int = 0,//如果不是一级弹幕，属于谁的下级弹幕

    //弹幕的发送者和接受者
    @ColumnInfo
    var fromUserCode: Int = 0,
    @ColumnInfo
    var fromUserName: String = "",
    @ColumnInfo
    var toUserCode: Int = 0,
    @ColumnInfo
    var toUserName: String = "",

    @ColumnInfo
    var type: Int = 0,//弹幕类型，1是一级弹幕，2是二级弹幕，3是三级弹幕
    @ColumnInfo
    var commitTime: Long = 0L,//发送时间
    @ColumnInfo
    var content: String = "",
    @ColumnInfo
    var likeNum: Int = 0,
    @ColumnInfo
    var isUpLike: Boolean = false,//up是否点赞了
    @ColumnInfo
    var isTop: Boolean = false,//消息是否被up主置顶了

    //界面标识，是否喜欢
    @Ignore
    var isLike: Boolean = false,
    @Ignore
    var isUnLike: Boolean = false,
    @Ignore
    var user: User? = null,
    @Ignore
    var replyComments: MutableList<CommentAndUser> = mutableListOf()
)
