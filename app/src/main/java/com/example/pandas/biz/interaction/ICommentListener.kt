package com.example.pandas.biz.interaction

import com.android.android_sqlite.entity.VideoComment


/**
 * @description: 处理评论相关的接口
 * @author: dongyiming
 * @date: 12/5/22 3:18 PM
 * @version: v1.0
 */
public interface ICommentListener {

    fun sendComment(comment: VideoComment): Boolean

    fun deleteComment(comment: VideoComment): Boolean
}