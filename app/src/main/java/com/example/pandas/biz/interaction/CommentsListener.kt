package com.example.pandas.biz.interaction
/**
 * @description: TODO
 * @author: dongyiming
 * @date: 6/9/22 12:47 下午
 * @version: v1.0
 */
interface CommentsListener {

    fun showCommentsFragment(commentId: Int)

    fun closeCommentFragment()
}