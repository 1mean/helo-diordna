package com.example.pandas.bean

import com.example.pandas.sql.entity.User

/**
 * 评论
 */
data class VideoComment(

    var id: Int = -1,
    var commentId:Int = -1,//评论id，同一个video的评论自增长。
    var videoCode: Int = -1,
    var userCode: Int = -1,//弹幕发送人
    var topCommentId:Int = -1,//如果不是一级弹幕，属于谁的下级弹幕
    var replyUserId:Int = -1,//三级弹幕回复的对象
    var replyUserName:String = "",//三级弹幕回复的对象的名字
    var type:Int = -1,//弹幕类型，0是一级弹幕，1是二级弹幕，2是三级弹幕
    var commitTime: Long = 0L,//发送时间
    var content: String = "",
    var likeNum: Int = 0,
    var commentNum: Int = 0,
    var isUpLike: Boolean = false,//up是否点赞了
    var isTop: Boolean = false,//消息是否被up主置顶了

    //界面标识，是否喜欢
    var isLike: Boolean = false,
    var isUnLike: Boolean = false,

    var user: User? = null,
)
