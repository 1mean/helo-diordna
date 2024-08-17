package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.eyes.EyepetozerData
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.manager.httpManager
import kotlinx.coroutines.launch

/**
 * @description: EyepetozerViewModel
 * @author: dongyiming
 * @date: 2/22/22 11:21 下午
 * @version: v1.0
 */
public class EyepetozerViewModel : BaseViewModel() {

    private var startIndex = 0
    private var num = 20

    private var tabNum = 0
    private var tabPage = 0
    private var date = 0L

    val eyepetozerWrapper: MutableLiveData<UIDataWrapper<EyepetozerItem>> by lazy { MutableLiveData() }
    val tabSelects: MutableLiveData<UIDataWrapper<EyepetozerItem>> by lazy { MutableLiveData() }
    val recoResult: MutableLiveData<MutableList<EyepetozerItem>> by lazy { MutableLiveData() }

    /**
     * 初始化界面数据
     *
     * @param:
     * @return:
     * @version: v1.0
     */
    fun initData(isRefresh: Boolean) {


        Log.e("eyeFragment", "initData")
        if (isRefresh) {
            startIndex = 0
        }
        request({ httpManager.getHotList(startIndex, num) },
            {
                startIndex += num
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = it.size > 0,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                eyepetozerWrapper.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<EyepetozerItem>()
                )
                eyepetozerWrapper.value = dataList
            })
    }

    fun tabSelected(isRefresh: Boolean) {

        viewModelScope.launch {
            runCatching {
                val data: EyepetozerData
                if (isRefresh) {
                    data = httpManager.getTabSelected(true)
                } else {
                    data = httpManager.getTabSelected(false, date, tabNum, tabPage)
                }
                Log.e("EyepetozerViewModel", "list: $data")
                data
            }.onSuccess {
                it.nextPageUrl?.let { url ->
                    date = url.split("date=", "&num")[1].toLong()
                    tabNum = url.split("num=", "&page")[1].toInt()
                    tabPage = url.split("page=")[1].toInt()
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.itemList.isEmpty(),
                    hasMore = it.nextPageUrl != null,
                    isFirstEmpty = isRefresh && it.itemList.isEmpty(),
                    listData = it.itemList
                )
                tabSelects.value = dataList
            }.onFailure {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.toString(),
                    isRefresh = isRefresh,
                    listData = mutableListOf<EyepetozerItem>()
                )
                tabSelects.value = dataList
            }
        }
    }

    fun getRecommend(videoId: Int) {
        viewModelScope.launch {
            recoResult.value = httpManager.getRecommendVideos(videoId)
        }
    }
}