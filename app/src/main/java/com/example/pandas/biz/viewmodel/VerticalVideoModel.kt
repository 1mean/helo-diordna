package com.example.pandas.biz.viewmodel

import UIDataWrapper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.eyes.EyepetozerBean
import httpManager

/**
 * @description: VerticalVideoModel
 * @author: dongyiming
 * @date: 2/24/22 12:20 上午
 * @version: v1.0
 */
public class VerticalVideoModel : BaseViewModel() {

    val recommendWrapper: MutableLiveData<UIDataWrapper<EyepetozerBean>> by lazy { MutableLiveData() }

    /**
     * 初始化界面数据
     *
     * @param:
     * @return:
     * @version: v1.0
     */
    fun getRecoList(video: EyepetozerBean) {

        request({ httpManager.getRecommendVideos(video.videoId) },
            { list ->
                Log.e("1mean", "recommend video size: ${list.size}")
                if (list.isNotEmpty()) {
                    list.add(0, video)
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isEmpty = list.isEmpty(),
                    listData = list
                )
                recommendWrapper.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<EyepetozerBean>()
                )
                recommendWrapper.value = dataList
            })
    }
}