package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.bean.HistoryItem
import com.android.android_sqlite.entity.Group
import com.android.android_sqlite.entity.History
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.manager.groupRepository
import com.android.android_sqlite.manager.historyRepository
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * @description: CollectViewModeL
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class CollectViewModeL : BaseViewModel() {

    private val _groupsFlow: MutableSharedFlow<MutableList<Group>> by lazy { MutableSharedFlow() }
    val groupFlow = _groupsFlow.asSharedFlow()
    private val _groupsVideosFlow: MutableSharedFlow<MutableList<PetVideo>> by lazy { MutableSharedFlow() }
    val groupsVideosFlow = _groupsVideosFlow.asSharedFlow()

    fun getCollectGroups() {
        viewModelScope.launch {
            groupRepository.getGroups().collect {
                _groupsFlow.emit(it)
            }
        }
    }

    fun getGroupVideos(groupCode: Int, startIndex: Int, pageCounts: Int) {
        viewModelScope.launch {
            flow {
                val list = groupRepository.getPageGroupItems(groupCode, startIndex, pageCounts)
                emit(list)
            }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO).collect {
                _groupsVideosFlow.emit(it)
            }
        }
    }

}