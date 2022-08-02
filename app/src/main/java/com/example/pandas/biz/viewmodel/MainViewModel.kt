package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.User
import kotlinx.coroutines.launch

/**
 * @description: MainActivity
 * @author: dongyiming
 * @date: 3/24/22 12:20 上午
 * @version: v1.0
 */
public class MainViewModel : BaseViewModel() {

    val HeadUiState: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val userInfo: MutableLiveData<User> by lazy { MutableLiveData() }

    fun updateHeadState() {
        HeadUiState.value = true
    }

    fun getUserInfo(){
        viewModelScope.launch {
            userInfo.value = PetManagerCoroutine.getUser(AppInfos.AUTHOR_ID)
        }
    }
}