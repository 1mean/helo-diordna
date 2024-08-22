package com.example.pandas.biz.viewmodel

import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @description: RankViewModel
 * @author: dongyiming
 * @date: 12/11/22 6:19 PM
 * @version: v1.0
 */
public class RankViewModel : BaseViewModel() {

    private var startIndex = 0
    private val pageCount = 21

    private val _ranks: MutableSharedFlow<UIDataWrapper<VideoAndUser>> by lazy { MutableSharedFlow() }
    val ranks = _ranks.asSharedFlow()

    fun getRanks(isRefresh: Boolean) {
        viewModelScope.launch {
            if (isRefresh) startIndex = 0
            videoRepository.getPageRanks(startIndex, pageCount).collect {
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
                _ranks.emit(dataList)
            }
        }
    }
}