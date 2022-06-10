package com.example.pandas.bean

/**
 * 回复相关，传递数据所需
 */
data class ReplyInfo(

    var commentId: Int = 0, //所属的一级评论的id
    var videoCode: Int = 0, //当前视频的id
    var type: Int = 0, //评论类型
    var replyUserName: String = "", //回复谁的评论
    var replyUserCode: Int = 0
)
