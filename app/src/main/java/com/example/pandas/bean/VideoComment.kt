package com.example.pandas.bean

import com.example.pandas.sql.entity.User

/**
 * 评论
 *   - 一级弹幕:视频弹幕
 *   - 二级弹幕:回复一级弹幕的弹幕
 *   - 三级弹幕:回复二级弹幕
 *
 */
data class VideoComment(

    var id: Int = -1,
    var commentId: Int = -1,//评论id，同一个video的评论自增长。
    var videoCode: Int = -1,

    var topCommentId: Int = -1,//如果不是一级弹幕，属于谁的下级弹幕

    //弹幕的发送者和接受者
    var fromUserCode: Int = -1,
    var fromUserName: String = "",
    var toUserCode: Int = -1,
    var toUserName: String = "",

    var type: Int = 0,//弹幕类型，1是一级弹幕，2是二级弹幕，3是三级弹幕
    var commitTime: Long = 0L,//发送时间
    var content: String = "",
    var likeNum: Int = 0,
    var isUpLike: Boolean = false,//up是否点赞了
    var isTop: Boolean = false,//消息是否被up主置顶了

    //界面标识，是否喜欢
    var isLike: Boolean = false,
    var isUnLike: Boolean = false,

    var user: User? = null,
    var replyComments: MutableList<VideoComment> = mutableListOf()
)
