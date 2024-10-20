package com.example.pandas.biz

import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.VideoAndUser

/**
 * @description: RankViewModel
 * @author: dongyiming
 * @date: 12/11/22 6:19 PM
 * @version: v1.0
 */
public class RankViewModel : BaseViewModel() {

    private var startIndex = 0
    private val pageCount = 21

    val ranks: MutableLiveData<UIDataWrapper<VideoAndUser>> by lazy { MutableLiveData() }

    fun getRanks(isRefresh: Boolean) {
        if (isRefresh) {
            startIndex = 0
        }
        request({
            PetManagerCoroutine.getPageRanks(startIndex, pageCount)
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
            ranks.value = dataList

        }, {
            val dataList = UIDataWrapper(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = mutableListOf<VideoAndUser>()
            )
            ranks.value = dataList
        })
    }
}