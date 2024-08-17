package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.android.android_sqlite.PetManagerCoroutine
import com.android.android_sqlite.entity.CommentAndUser
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper

/**
 * @description: CommentViewModel
 * @author: dongyiming
 * @date: 12/11/22 6:19 PM
 * @version: v1.0
 */
public class CommentViewModel : BaseViewModel() {

    private var startIndex = 0
    private val pageCount = 21

    val pageComments: MutableLiveData<UIDataWrapper<CommentAndUser>> by lazy { MutableLiveData() }
    val replyComments: MutableLiveData<UIDataWrapper<CommentAndUser>> by lazy { MutableLiveData() }

    fun getPageComment(isRefresh: Boolean, videoCode: Int) {
        if (isRefresh) {
            startIndex = 0
        }
        request({
            PetManagerCoroutine.getPageComments(true, videoCode, startIndex, pageCount)
        }, {
            val hasMore = if (it.size > 20) {
                it.removeLast()
                true
            } else {
                false
            }
            val dataList = UIDataWrapper(
                isSuccess = true,
                isRefresh = isRefresh,
                isEmpty = it.isEmpty(),
                hasMore = hasMore,
                isFirstEmpty = isRefresh && it.isEmpty(),
                listData = it
            )
            startIndex += 20
            pageComments.value = dataList

        }, {
            val dataList = UIDataWrapper(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = mutableListOf<CommentAndUser>()
            )
            pageComments.value = dataList
        })
    }
}