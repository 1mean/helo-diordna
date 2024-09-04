package com.example.pandas.biz.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.bean.SearchInfo
import com.android.android_sqlite.entity.SearchHistory
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.manager.searchHistoryRepository
import com.android.android_sqlite.manager.userRepository
import com.android.android_sqlite.manager.videoRepository
import com.android.base.vm.BaseViewModel
import com.android.base.vm.SingleLiveData
import com.android.base.vm.UnPeekLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.HotKeyResponse
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.WxPageArticleResponse
import com.example.pandas.biz.http.invoker.wanAndroidInvoke
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
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

    val newSearchRefresh1: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    private val _newSearchRefresh: MutableSharedFlow<Boolean> by lazy { MutableSharedFlow() }
    val newSearchRefresh = _newSearchRefresh.asSharedFlow()


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

    //这里不使用MutableSharedFlow，因为无法解决一个bug，每次点击关注后，这个数据就会一直多次回掉给collect，导致界面一直有重复数据
    val likedUsersFlow: SingleLiveData<MutableList<User>> by lazy { SingleLiveData() }
    val likedUsersFlow2: MutableLiveData<MutableList<User>> by lazy { MutableLiveData() }

    private val _likedUsersFlow: MutableSharedFlow<MutableList<User>> by lazy { MutableSharedFlow() }
    val likedUsersFlowww = _likedUsersFlow.asSharedFlow()

    val attentionFlow: SingleLiveData<Int> by lazy { SingleLiveData() }
    val unAttentionFlow: SingleLiveData<Int> by lazy { SingleLiveData() }


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

    fun newSearchRefresh(isRefresh: Boolean) {
        viewModelScope.launch {
            flow<Boolean> {
                emit(isRefresh)
            }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO).collect {
                _newSearchRefresh.emit(it)
            }
        }
//        viewModelScope.launch {
//            newSearchRefresh.value = isRefresh
//        }
    }

    fun clearAllHistory(type: Int) {
        viewModelScope.launch {
            searchHistoryRepository.deleteAllHistory(type).collect {
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

    fun getLikeUser(key: String, startIndex: Int, pageCount: Int) {
        viewModelScope.launch {
            likedUsersFlow.value = userRepository.getLikedUser1(key, startIndex, pageCount)
        }
    }

    fun getLikeUserrrrrr(key: String, startIndex: Int, pageCount: Int) {
        viewModelScope.launch {
            userRepository.getLikedUser(key, startIndex, pageCount).collect {
                Log.e("1mean","getLikedUser size:${it.size}")
                _likedUsersFlow.emit(it)
            }
        }
    }

    fun attention(userCode: Int, position: Int) {
        viewModelScope.launch {
//            flow {
//                emit()
//            }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO).collect {
//                Log.e("1mean", "attention it=$it")
//                if (it >= 1) {
//                    attentionFlow.value = position
//                    //_attentionFlow.emit(position)
//                }
//            }

            attentionFlow.value = userRepository.attention(true, userCode)
        }
    }

    fun removeAttention(userCode: Int, position: Int) {
        viewModelScope.launch {
            userRepository.attention(false, userCode)
            unAttentionFlow.value = position
//            flow {
//                emit(userRepository.attention(false, userCode))
//            }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO).collect {
//                Log.e("1mean", "attention it=$it")
//                if (it >= 1) {
//                    _unAttentionFlow.emit(position)
//                }
//            }
        }
//        viewModelScope.launch {
//            userRepository.attention(false, userCode).collect {
//                Log.e("1mean", "unAttention it=$it")
//                if (it >= 1) {
//                    _unAttentionFlow.emit(position)
//                }
//            }
//        }
    }


}