package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PeriodType

/**
 * @description: PandaViewModel
 * @author: dongyiming
 * @date: 3/27/22 11:47 下午
 * @version: v1.0
 */
public class PandaViewModel : BaseViewModel() {

    val pandaResult: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

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
                listData = mutableListOf<PetViewData>()
            )
            pandaResult.value = dataList
        })
    }

    fun getPandas(isRefresh: Boolean, title: String) {

        val period = getVideoType(title)
        if (isRefresh) {
            startIndex = 0
        }

        request({
            PetManagerCoroutine.searchByPeriod(period, startIndex, 21)
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
                listData = mutableListOf<PetViewData>()
            )
            pandaResult.value = dataList
        })
    }

    private fun getVideoType(title: String): Int = when (title) {
        "熊猫宝宝" -> PeriodType.BABY.ordinal
        "带崽熊猫" -> PeriodType.MOM.ordinal
        "幼年班" -> PeriodType.GROUP.ordinal
        "成长记录" -> PeriodType.ALL.ordinal
        else -> PeriodType.KNOWLEDGE.ordinal
    }
}