package com.example.pandas.biz.manager

import android.content.Context
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.ICommentCallback
import com.example.pandas.sql.entity.CommentAndUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @description: ShortCommentManage
 * @author: dongyiming
 * @date: 6/7/23 9:34 PM
 * @version: v1.0
 */
public class ShortCommentManage(val context: Context, val commentScope: CoroutineScope) {

    /**
     * <获取一级评论>
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 6/7/23 9:36 PM
     * @version: v1.0
     */
    fun getPageComment(
        videoCode: Int,
        startIndex: Int,
        pageCount: Int,
        listener: ICommentCallback
    ) {

        commentScope.launch {
            val list = PetManagerCoroutine.getPageComments(
                true,
                videoCode,
                startIndex,
                pageCount
            )
            val hasMore = list.size > 20
            if (hasMore) {
                list.removeLast()
            }
            val dataList = UIDataWrapper<CommentAndUser>(
                isSuccess = true,
                isEmpty = list.isEmpty(),
                hasMore = hasMore,
                listData = list
            )
            listener.getPageComments(dataList)
        }
    }
}