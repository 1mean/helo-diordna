package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @description: PandaViewModel
 * @author: dongyiming
 * @date: 3/27/22 11:47 下午
 * @version: v1.0
 */
public class PandaViewModel : BaseViewModel() {

    private val _pandaResult: MutableSharedFlow<UIDataWrapper<VideoAndUser>> by lazy { MutableSharedFlow() }
    val pandaResult = _pandaResult.asSharedFlow()
    val banner: MutableLiveData<MutableList<PetVideo>> by lazy { MutableLiveData() }

    private var startIndex = 0
    private var hasMore = false

    fun getPandas(isRefresh: Boolean, key: String, period: Int) {
        viewModelScope.launch {
            if (isRefresh) startIndex = 0
            videoRepository.searchPeriod(key, period, startIndex, 21).collect {
                hasMore = if (it.isNotEmpty() && it.size > 20) {
                    it.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += 20
                _pandaResult.emit(dataList)
            }
        }
    }

    fun getPandas(isRefresh: Boolean, title: String) {

    }
}