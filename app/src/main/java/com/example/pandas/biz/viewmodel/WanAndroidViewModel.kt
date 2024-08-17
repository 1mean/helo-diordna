package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.base.vm.BaseViewModel
import com.example.pandas.app.AppInfos
import com.example.pandas.app.AppInfos.LOGIN_KEY
import com.example.pandas.app.AppInfos.PASSWORD_KEY
import com.example.pandas.app.AppInfos.USERNAME_KEY
import com.example.pandas.bean.LoginResponse
import com.example.pandas.biz.http.invoker.wanAndroidInvoke
import com.example.pandas.utils.Preference
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @description: wan android
 * @author: dongyiming
 * @date: 8/15/24 3:26 PM
 * @version: v1.0
 */
public class WanAndroidViewModel : BaseViewModel() {

    private val _login: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val login = _login.asSharedFlow()
    private val _register: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val register = _register.asSharedFlow()
    private val _logout: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val logout = _logout.asSharedFlow()


    fun login(userName: String, password: String) {
        viewModelScope.launch {
            wanAndroidInvoke.loginWanAndroid(userName, password).collect {
                if (it.errorCode == 0) {
                    var name: String by Preference(USERNAME_KEY, userName)
                    name = userName
                    var secret: String by Preference(PASSWORD_KEY, password)
                    secret = password
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = true
                } else {
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = false
                }
                _login.emit(it)
            }
        }
    }

    fun register(userName: String, password: String, repassowrd: String) {
        viewModelScope.launch {
            wanAndroidInvoke.registerWanAndroid(userName, password, repassowrd).collect {
                if (it.errorCode == 0) {
                    var name: String by Preference(USERNAME_KEY, userName)
                    name = userName
                    var secret: String by Preference(PASSWORD_KEY, password)
                    secret = password
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = true
                } else {
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = false
                }
                _register.emit(it)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            wanAndroidInvoke.logOutWanAndroid().collect {
                Log.e("1mean", "logout thread:${Thread.currentThread().name}")
                _logout.emit(it)
            }
        }
    }
}