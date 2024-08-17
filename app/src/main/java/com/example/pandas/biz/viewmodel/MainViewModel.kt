package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.PetManagerCoroutine
import com.android.android_sqlite.entity.User
import com.example.pandas.app.AppInfos
import com.android.base.vm.BaseViewModel
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