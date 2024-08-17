package com.android.android_sqlite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * 评论
 *   - 一级弹幕:视频弹幕
 *   - 二级弹幕:回复一级弹幕的弹幕
 *   - 三级弹幕:回复二级弹幕
 */
@Entity(tableName = "comment")
data class VideoComment(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//评论id，同一个video的评论自增长。
    @ColumnInfo
    var commentId: Int = 0,//不用此字段
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
    var upLike: Boolean = false,//up是否点赞了
    @ColumnInfo
    var top: Boolean = false,//消息是否被up主置顶了

    @ColumnInfo
    var replyCounts: Int = 0,
    @ColumnInfo
    var commentType: Int = 0, //弹幕类型，有图片

    //界面标识，是否喜欢
    @ColumnInfo
    var like: Boolean = false,
    @ColumnInfo
    var unLike: Boolean = false,

    /**
     *  state
     *    - 0:默认常规评论.没有回复
     *    - 1：默认有作者回复的单一评论
     *    - 2：默认有评论的常规评论，未点开
     *    - 3：有评论，但未展开，只是我回复的几条评论
     *    - 4：有评论，也展开了
     */
    @ColumnInfo
    var state: Int = 0,

    @Ignore
    var user: User? = null,
    @Ignore
    var replyComments: MutableList<CommentAndUser> = mutableListOf(),

    @Ignore
    var newReplyCounts: Int = 0,//中间新增加的评论数

)
