package com.example.pandas.biz.interaction

import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.VideoComment
import com.example.pandas.bean.UIDataWrapper


/**
 * @description: 处理评论相关的接口
 * @author: dongyiming
 * @date: 12/5/22 3:18 PM
 * @version: v1.0
 */
public interface ICommentCallback {

    fun getPageComments(data: UIDataWrapper<CommentAndUser>)

    fun getPageReply(position: Int, list: MutableList<CommentAndUser>)

    fun sendCommentResult(videoComment: VideoComment)
}