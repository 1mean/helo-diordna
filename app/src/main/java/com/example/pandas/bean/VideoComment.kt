package com.example.pandas.bean

import com.example.pandas.sql.entity.User

/**
 * 评论
 */
data class VideoComment(

    var id: Int = -1,
    var videoCode: Int = -1,
    var userCode: Int = -1,
    var type:Int = -1,//弹幕类型，0是对视频的独立弹幕，1是回复别人的弹幕
    var commitTime: Long = 0L,
    var content: String = "",
    var likeNum: Int = 0,
    var commentNum: Int = 0,
    var isLike: Boolean = false,
    var isUnLike: Boolean = false,
    var isUpLike: Boolean = false,
    var associatedComments: List<Int> = arrayListOf(),//相关联的弹幕id
    var isTop: Boolean = false,//是否置顶
    var user: User? = null,
)
