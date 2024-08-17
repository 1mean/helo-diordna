package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.manager.httpManager

/**
 * @description: VerticalVideoModel
 * @author: dongyiming
 * @date: 2/24/22 12:20 上午
 * @version: v1.0
 */
public class VerticalVideoModel : BaseViewModel() {

    val recommendWrapper: MutableLiveData<UIDataWrapper<EyepetozerItem>> by lazy { MutableLiveData() }

    /**
     * 初始化界面数据
     *
     * @param:
     * @return:
     * @version: v1.0
     */
    fun getRecoList(video: EyepetozerItem) {

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
                    listData = mutableListOf<EyepetozerItem>()
                )
                recommendWrapper.value = dataList
            })
    }
}