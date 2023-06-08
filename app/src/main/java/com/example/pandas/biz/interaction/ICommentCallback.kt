package com.example.pandas.biz.interaction

import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.VideoComment


/**
 * @description: 处理评论相关的接口
 * @author: dongyiming
 * @date: 12/5/22 3:18 PM
 * @version: v1.0
 */
public interface ICommentCallback {

    fun getPageComments(data: UIDataWrapper<CommentAndUser>)
}