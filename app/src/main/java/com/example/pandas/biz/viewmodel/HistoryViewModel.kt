package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.HistoryItem
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.History
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import kotlinx.coroutines.launch

/**
 * @description: HistoryViewModeL
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class HistoryViewModeL : BaseViewModel() {

    val historyResult: MutableLiveData<UIDataWrapper<HistoryItem>> by lazy { MutableLiveData() }
    val laterResult: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    private var startIndex = 0
    private var index = 0

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

    fun getPageLater(isRefresh: Boolean) {

        if (isRefresh) {
            index = 0
        }

        request({ PetManagerCoroutine.getLater(index, 21) },
            {
                val hasMore = it.size > 20
                index += 20
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
                laterResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetVideo>()
                )
                laterResult.value = dataList
            })
    }

    fun removeHistory(list: MutableList<History>, removeAll: Boolean) {

        viewModelScope.launch {
            PetManagerCoroutine.removeHistory(list, removeAll)
        }
    }

    fun removeLaters(list: MutableList<PetVideo>, removeAll: Boolean) {

        viewModelScope.launch {
            PetManagerCoroutine.removeLaters(list, removeAll)
        }
    }


}