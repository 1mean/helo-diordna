package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.MusicVo
import com.android.android_sqlite.manager.musicRepository
import com.android.base.vm.BaseViewModel
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
            musicResult.value = musicRepository.getMusic(fileName)
        }
    }

    fun getMenu() {
        viewModelScope.launch {
            musicsResult.value = musicRepository.getAllMusic()
        }
    }
}