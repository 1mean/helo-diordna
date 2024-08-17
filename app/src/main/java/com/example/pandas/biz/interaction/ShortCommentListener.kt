package com.example.pandas.biz.interaction

import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.VideoComment

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

    /**
     * 点击评论后，弹出软键盘输入框，开始进行输入和回复
     */
    fun showInputToReply(commentUser: CommentAndUser?, position: Int, showEmotion: Boolean)

    fun updateComment(comment: VideoComment)
}