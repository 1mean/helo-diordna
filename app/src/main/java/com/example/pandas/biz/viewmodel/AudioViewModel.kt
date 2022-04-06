package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.MusicVo
import kotlinx.coroutines.launch

/**
 * @description: AudioViewModel
 * @author: dongyiming
 * @date: 3/1/22 6:56 下午
 * @version: v1.0
 */
public class AudioViewModel : BaseViewModel() {

    val musicResult: MutableLiveData<MusicVo> by lazy { MutableLiveData() }
    val musicsResult: MutableLiveData<MutableList<MusicVo>> by lazy { MutableLiveData() }

    fun getMusicInfo(fileName: String) {
        viewModelScope.launch {
            musicResult.value = PetManagerCoroutine.getMusic(fileName)
        }
    }

    fun getMenu() {
        viewModelScope.launch {
            musicsResult.value = PetManagerCoroutine.getAllMusic()
        }
    }
}