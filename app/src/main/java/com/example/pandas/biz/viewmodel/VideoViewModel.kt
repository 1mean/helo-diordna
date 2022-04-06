package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.History
import com.example.pandas.sql.entity.PetVideo
import com.google.android.exoplayer2.util.Util
import kotlinx.coroutines.launch
import java.util.*

/**
 * @description: VideoViewModel
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
            videoInfo.value = PetManagerCoroutine.getVideoByCode(code)
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

    fun saveHistory(code: Int, currentPosition: Long) {

        Thread {
            val formatBuilder = StringBuilder()
            val formatter = Formatter(formatBuilder, Locale.getDefault())
            val position = Util.getStringForTime(formatBuilder, formatter, currentPosition)
            val history =
                History(
                    code = code,
                    lastTime = System.currentTimeMillis(),
                    playPosition = position
                )
            PetManagerCoroutine.saveHistory(history)
        }.start()

    }
}