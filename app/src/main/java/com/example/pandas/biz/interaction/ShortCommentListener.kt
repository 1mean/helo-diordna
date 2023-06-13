package com.example.pandas.biz.interaction

import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.VideoComment

/**
 * @description: ShortCommentAdapter 短视频
 * @author: dongyiming
 * @date: 6/13/23 3:21 PM
 * @version: v1.0
 */
interface ShortCommentListener {

    fun loadMore(
        topCommentPosition: Int,
        startIndex: Int,
        pageCount: Int,
        videoCode: Int,
        commentId: Int
    )

    fun reply(commentUser: CommentAndUser, position: Int)

    fun updateComment(comment: VideoComment)
}