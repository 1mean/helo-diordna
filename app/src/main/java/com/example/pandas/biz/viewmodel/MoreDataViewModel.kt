package com.example.pandas.biz.viewmodel

import PetManagerCoroutine
import UIDataWrapper
import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 3/1/22 11:23 下午
 * @version: v1.0
 */
public class MoreDataViewModel : BaseViewModel() {

    var currentType = -1
    private var startIndex = 0

    val moreDataResult: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    fun getListResult() {

        request({ PetManagerCoroutine.getPageByType(currentType, startIndex, 20) },
            {
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = startIndex == 0,
                    hasMore = it.size == 20,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                startIndex += 20
                moreDataResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = startIndex == 0,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetViewData>()
                )
                moreDataResult.value = dataList
            })
    }

}