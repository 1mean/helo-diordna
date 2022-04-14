package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.User
import kotlinx.coroutines.launch

/**
 * @description: SelfViewModel
 * @author: dongyiming
 * @date: 2/28/22 6:22 下午
 * @version: v1.0
 */
public class SelfViewModel : BaseViewModel() {

    val userInfo: MutableLiveData<User> by lazy { MutableLiveData() }

    fun getUserInfo() {
        viewModelScope.launch {
            userInfo.value = PetManagerCoroutine.getUser(1074309089)
        }
    }
}