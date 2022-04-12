package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.eyes.EyepetozerBean
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

    val eyepetozerWrapper: MutableLiveData<UIDataWrapper<EyepetozerBean>> by lazy { MutableLiveData() }
    val recoResult: MutableLiveData<MutableList<EyepetozerBean>> by lazy { MutableLiveData() }

    /**
     * 初始化界面数据
     *
     * @param:
     * @return:
     * @version: v1.0
     */
    fun initData(isRefresh: Boolean) {

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
                    hasMore = it.size == 20,
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
                    listData = mutableListOf<EyepetozerBean>()
                )
                eyepetozerWrapper.value = dataList
            })
    }

    fun getRecommend(videoId: Int) {
        viewModelScope.launch {
            recoResult.value = httpManager.getRecommendVideos(videoId)
        }
    }

}