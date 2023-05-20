package com.example.pandas.biz.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.base.viewmodel.UnPeekLiveData
import com.example.pandas.bean.SearchInfo
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @description: search
 * @author: dongyiming
 * @date: 2/17/22 4:23 下午
 * @version: v1.0
 */
public class SearchViewModel : BaseViewModel() {

    var keyWords: String = ""

    private var startIndex = 0
    private var hotMore = true//是否有更多
    val hotSearchList: MutableLiveData<MutableList<String>> by lazy { MutableLiveData() }
    val resultList: MutableLiveData<UIDataWrapper<SearchInfo>> by lazy { MutableLiveData() }
    val searchResult: UnPeekLiveData<UIDataWrapper<VideoAndUser>> by lazy { UnPeekLiveData() }
    val searchHistory: MutableLiveData<List<String>> by lazy { MutableLiveData() }

    fun search(words: String) {

        request({ PetManagerCoroutine.search(words) },
            {
                val dataList = UIDataWrapper(
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
    fun getSrachHistory(context: Context) {

        viewModelScope.launch {
            searchHistory.value = withContext(Dispatchers.Default) {
                val history = SPUtils.getString(context, AppInfos.SEARCH_KEY)
                if (history.isEmpty()) {
                    arrayListOf()
                } else {
                    history.split(",").reversed()
                }
            }
        }
    }

    /**
     * 存入记录到本地
     */
    fun saveSearchHistory(context: Context) {

        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                SPUtils.putSearchList(context, AppInfos.SEARCH_KEY, keyWords)
            }
        }
    }

    fun clearHistory(context: Context) {

        viewModelScope.launch {
            searchHistory.value = withContext(Dispatchers.Default) {
                SPUtils.clearKey(context, AppInfos.SEARCH_KEY)
                listOf()
            }
        }
    }

    fun searchRefresh(isRefresh: Boolean, words: String) {

        if (isRefresh) {
            startIndex = 0
        }

        request({ PetManagerCoroutine.searchByPage(words, startIndex) },
            {
                Log.e("1mean", "search counts:${it.size}")
                hotMore = if (it.size > 10) {
                    it.removeLast()
                    true
                } else {
                    false
                }

                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    hasMore = it.size == 10,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                startIndex += 10
                searchResult.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    isRefresh = isRefresh,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<VideoAndUser>()
                )
                searchResult.value = dataList
            })
    }

    fun getHotSearch() {

        val list = mutableListOf(
            "大熊猫和花",
            "大熊猫宝宝",
            "凤凰",
            "月亮产房",
            "仙剑奇侠传",
            "舌尖上的斧头山",
            "刘亦菲",
            "大熊猫萌兰",
            "雪",
            "小熊猫"
        )
        hotSearchList.value = list
    }

}