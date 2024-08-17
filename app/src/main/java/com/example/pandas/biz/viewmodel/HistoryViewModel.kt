package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.PetManagerCoroutine
import com.android.android_sqlite.bean.HistoryItem
import com.android.android_sqlite.entity.Group
import com.android.android_sqlite.entity.History
import com.android.android_sqlite.entity.PetVideo
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
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
    val loveResult: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }
    val collectResult: MutableLiveData<UIDataWrapper<Group>> by lazy { MutableLiveData() }
    val groupListResult: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }
    val createResult: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val removeResult: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val removeHistoryResult: MutableLiveData<UIDataWrapper<HistoryItem>> by lazy { MutableLiveData() }

    private var startIndex = 0
    private var groupStartIndex = 0
    private var index = 0
    private var loveIndex = 0

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

    fun getPageLove(isRefresh: Boolean) {

        if (isRefresh) {
            loveIndex = 0
        }

        request({ PetManagerCoroutine.getLove(loveIndex, 21) },
            {
                Log.e("1mean", "getLove: $it")
                val hasMore = it.size > 20
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
                loveIndex += 20
                loveResult.value = dataList
            },
            {
                Log.e("1mean", "getLove: $it")
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetVideo>()
                )
                loveResult.value = dataList
            })
    }

    fun getPageGroupItem(isRefresh: Boolean, groupCode: Int) {

        if (isRefresh) {
            groupStartIndex = 0
        }
        request({ PetManagerCoroutine.getPageGroupItems(groupCode, groupStartIndex, 21) },
            {
                val hasMore = it.size > 20
                groupStartIndex += 20
                if (hasMore) {
                    it.removeLast()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    listData = it
                )
                groupListResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetVideo>()
                )
                groupListResult.value = dataList
            })
    }

    fun getCollects() {

        request({ PetManagerCoroutine.getCollects() },
            {
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                collectResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<Group>()
                )
                collectResult.value = dataList
            })
    }

    fun removeHistory(list: MutableList<History>, removeAll: Boolean) {

        request({ PetManagerCoroutine.removeHistory(list, removeAll) },
            {
                var hasmore = false
                if (!removeAll) {
                    if (it.size >= 21) {
                        hasmore = true
                        it.removeLast()
                    }
                    startIndex = it.size
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isEmpty = it.isEmpty(),
                    hasMore = hasmore,
                    listData = it
                )
                removeHistoryResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<HistoryItem>()
                )
                removeHistoryResult.value = dataList
            })
    }

    fun removeLaters(list: MutableList<PetVideo>, removeAll: Boolean) {

        viewModelScope.launch {
            PetManagerCoroutine.removeLaters(list, removeAll)
        }
    }

    fun removeLovers(list: MutableList<PetVideo>, removeAll: Boolean) {

        viewModelScope.launch {
            PetManagerCoroutine.removeLoves(list, removeAll)
        }
    }

    fun createAGroup(groupName: String, groupDesc: String, isOpen: Boolean) {

        viewModelScope.launch {
            createResult.value = PetManagerCoroutine.createGroup(groupName, groupDesc, isOpen)
        }
    }

    fun removeGroup(groupCode: Int) {
        viewModelScope.launch {
            removeResult.value = PetManagerCoroutine.removeGroup(groupCode)
        }
    }
}