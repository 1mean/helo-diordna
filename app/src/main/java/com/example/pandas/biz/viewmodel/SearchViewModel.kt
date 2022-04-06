package com.example.pandas.biz.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.SearchInfo
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.utils.SPUtils

/**
 * @description: search
 * @author: dongyiming
 * @date: 2/17/22 4:23 下午
 * @version: v1.0
 */
public class SearchViewModel : BaseViewModel() {

    private var startIndex = 0
    val hotSearchList: MutableLiveData<MutableList<String>> by lazy { MutableLiveData() }
    val resultList: MutableLiveData<UIDataWrapper<SearchInfo>> by lazy { MutableLiveData() }
    val searchResult: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    fun search(words: String) {

        request({ PetManagerCoroutine.search(words) },
            {
                val dataList = UIDataWrapper<SearchInfo>(
                    isSuccess = true,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                resultList.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<SearchInfo>()
                )
                resultList.value = dataList
            })
    }

    /**
     * 获取历史搜索记录，用sp存储在本地，返回一个逆序的list
     */
    fun getSrachHistory(context: Context): List<String> {

        val history = SPUtils.getString(context, AppInfos.SEARCH_KEY)
        if (history.isEmpty()) {
            return arrayListOf()
        } else {
            return history.split(",").reversed()
        }
    }

    /**
     * 存入记录到本地
     */
    fun saveSearchHistory(context: Context, value: String) {

        SPUtils.putSearchList(context, AppInfos.SEARCH_KEY, value)
    }

    fun clearHistory(context: Context) {

        SPUtils.clearKey(context,AppInfos.SEARCH_KEY)
    }

    fun searchRefresh(isRefresh: Boolean, words: String) {

        request({ PetManagerCoroutine.searchByPage(words, startIndex) },
            {
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = it.size == 10,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                searchResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = isRefresh,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetViewData>()
                )
                searchResult.value = dataList
            })
        startIndex += 10
    }

    fun getHotSearch() {

        val list = mutableListOf(
            "大熊猫 和花",
            "大熊猫宝宝",
            "传说中的凤凰",
            "月亮产房四宝",
            "仙剑奇侠传",
            "大熊猫成长记",
            "刘亦菲",
            "梅兰肉肉",
            "中国之美",
            "小熊猫"
        )
        hotSearchList.value = list
    }

}