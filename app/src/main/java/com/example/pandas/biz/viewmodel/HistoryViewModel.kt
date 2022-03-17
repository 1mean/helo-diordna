package com.example.pandas.biz.viewmodel

import PetManagerCoroutine
import UIDataWrapper
import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.HistoryItem

/**
 * @description: HistoryViewModeL
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class HistoryViewModeL : BaseViewModel() {

    val historyResult: MutableLiveData<UIDataWrapper<HistoryItem>> by lazy { MutableLiveData() }

    private var startIndex = 0

    fun getPageHistory(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
        }

        request({ PetManagerCoroutine.getHistory(startIndex, 21) },
            {
                val hasMore = it.size > 20
                startIndex += 20
                if (hasMore) {
                    it.removeLast()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    listData = it
                )
                historyResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<HistoryItem>()
                )
                historyResult.value = dataList
            })
    }

}