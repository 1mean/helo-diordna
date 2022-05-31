package com.example.pandas.biz.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.User
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @description: SelfViewModel
 * @author: dongyiming
 * @date: 2/28/22 6:22 下午
 * @version: v1.0
 */
public class SelfViewModel : BaseViewModel() {

    val userInfo: MutableLiveData<User> by lazy { MutableLiveData() }

    private val _follows: MutableLiveData<MutableList<String>> by lazy { MutableLiveData() }
    val follows: LiveData<MutableList<String>> = _follows

    val followUser: MutableLiveData<MutableList<User>> by lazy { MutableLiveData() }

    fun getUserInfo() {
        viewModelScope.launch {
            userInfo.value = PetManagerCoroutine.getUser(1074309089)
        }
    }

    fun getCurrentFollows(context: Context) {
        viewModelScope.launch {
            _follows.value = withContext(Dispatchers.IO) {
                SPUtils.getList(context, AppInfos.ATTENTION_KEY)
            }
        }
    }

    fun getAllFollowUser(context: Context) {

        viewModelScope.launch {
            followUser.value = PetManagerCoroutine.getAllFollowUsers(context)
        }
    }
}