package com.example.pandas.biz.viewmodel

import FileUtils
import PetManagerCoroutine
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.PetVideo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/11/22 4:38 下午
 * @version: v1.0
 */
public class VideoViewModel : BaseViewModel() {

    val videoInfo: MutableLiveData<PetVideo> by lazy { MutableLiveData() }
    val isVideoItemClicked: MutableLiveData<Int> by lazy { MutableLiveData() }
    val recommendVideos: MutableLiveData<MutableList<PetViewData>> by lazy { MutableLiveData() }

    fun getVideoInfo(code: Int) {

        viewModelScope.launch {
            PetManagerCoroutine.getVideoByCode(code).collect {
                videoInfo.value = it
            }
        }
    }

    fun setVideoItemClick(code: Int) {
        isVideoItemClicked.value = code
    }

    fun getRecommendVideos() {

        viewModelScope.launch {

            val video = videoInfo.value
            video?.let {
                val list = PetManagerCoroutine.getAiRecommend(it.code, it.type, 40)
                if (list.isNotEmpty()) {
                    recommendVideos.value = list
                }
            }
        }
    }
}