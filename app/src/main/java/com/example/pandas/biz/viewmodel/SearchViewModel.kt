package com.example.pandas.biz.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.bean.SearchInfo
import com.android.android_sqlite.entity.SearchHistory
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.manager.searchHistoryRepository
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.android.base.vm.UnPeekLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.HotKeyResponse
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.WxPageArticleResponse
import com.example.pandas.biz.http.invoker.wanAndroidInvoke
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
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

    private val _resultList: MutableSharedFlow<UIDataWrapper<SearchInfo>> by lazy { MutableSharedFlow() }
    val resultList = _resultList.asSharedFlow()
    private val _searchResult: MutableSharedFlow<UIDataWrapper<VideoAndUser>> by lazy { MutableSharedFlow() }
    val searchResult = _searchResult.asSharedFlow()

    val searchHistory: MutableLiveData<List<String>> by lazy { MutableLiveData() }

    private val _hotkey: MutableSharedFlow<HotKeyResponse> by lazy { MutableSharedFlow() }
    val hotkey = _hotkey.asSharedFlow()
    private val _pageSearch: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val pageSearch = _pageSearch.asSharedFlow()
    private val _collectInnerArticle: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val collectInnerArticle = _collectInnerArticle.asSharedFlow()
    private val _removeCollectedArticle: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val removeCollectedArticle = _removeCollectedArticle.asSharedFlow()
    private val _queryAllHistoryFlow: MutableSharedFlow<MutableList<SearchHistory>> by lazy { MutableSharedFlow() }
    val queryAllHistoryFlow = _queryAllHistoryFlow.asSharedFlow()
    private val _deleteAllFlow: MutableSharedFlow<Int> by lazy { MutableSharedFlow() }
    val deleteAllFlow = _deleteAllFlow.asSharedFlow()


    fun search(words: String) {
        viewModelScope.launch {
            videoRepository.search(words).collect {
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                _resultList.emit(dataList)
            }
        }
    }

    fun insertSearchHistory(type: Int, content: String) {
        viewModelScope.launch {
            searchHistoryRepository.insert(
                SearchHistory(
                    createTime = System.currentTimeMillis(),
                    updateTime = System.currentTimeMillis(),
                    reservedString = content,
                    type = type
                )
            )
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

    fun clearAllHistory(type:Int) {
        viewModelScope.launch {
            searchHistoryRepository.deleteAllHistory(type).collect{
                _deleteAllFlow.emit(it)
            }
        }
    }

    fun searchRefresh(isRefresh: Boolean, words: String) {
        viewModelScope.launch {
            if (isRefresh) startIndex = 0
            videoRepository.searchByPage(words, startIndex).collect {
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
                _searchResult.emit(dataList)
            }
        }
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

    fun hotkey() {
        viewModelScope.launch {
            wanAndroidInvoke.hotkey().collect {
                _hotkey.emit(it)
            }
        }
    }

    fun pageSearch(page: Int, key: String) {
        viewModelScope.launch {
            wanAndroidInvoke.pageSearch(page, key).collect {
                _pageSearch.emit(it)
            }
        }
    }

    fun collectInnerArticle(id: Int) {
        viewModelScope.launch {
            wanAndroidInvoke.collectInnerArticle(id).collect {
                _collectInnerArticle.emit(it)
            }
        }
    }

    fun removeCollectedArticle(id: Int, originId: Int) {
        viewModelScope.launch {
            wanAndroidInvoke.removeCollectedArticle(id, originId).collect {
                _removeCollectedArticle.emit(it)
            }
        }
    }

    fun getAllHistory(type: Int) {
        viewModelScope.launch {
            searchHistoryRepository.queryAll(type).collect {
                _queryAllHistoryFlow.emit(it)
            }
        }
    }
}