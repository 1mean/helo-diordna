package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: PandaViewModel
 * @author: dongyiming
 * @date: 3/27/22 11:47 下午
 * @version: v1.0
 */
public class PandaViewModel : BaseViewModel() {

    val pandaResult: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    private var startIndex = 0
    private var hasMore = false

    fun getPandas(isRefresh: Boolean, key: String, period: Int) {

        if (isRefresh) {
            startIndex = 0
        }

        request({
            PetManagerCoroutine.searchPeriod(key, period, startIndex, 21)
        }, {

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
            pandaResult.value = dataList
        }, {
            val dataList = UIDataWrapper(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = mutableListOf<PetVideo>()
            )
            pandaResult.value = dataList
        })
    }

    fun getPandas(isRefresh: Boolean, title: String) {

    }
}