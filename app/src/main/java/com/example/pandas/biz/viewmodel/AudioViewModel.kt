package com.example.pandas.biz.viewmodel

import PetManagerCoroutine
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.sql.entity.MusicVo
import com.google.android.exoplayer2.util.Util
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import java.util.*

/**
 * @description: AudioViewModel
 * @author: dongyiming
 * @date: 3/1/22 6:56 下午
 * @version: v1.0
 */
public class AudioViewModel : BaseViewModel() {

    val musicResult: MutableLiveData<MusicVo> by lazy { MutableLiveData() }

    fun getMusicInfo(fileName: String) {
        viewModelScope.launch {
            musicResult.value = PetManagerCoroutine.getMusic(fileName)
        }
    }
}