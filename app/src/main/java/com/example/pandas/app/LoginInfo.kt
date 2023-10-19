package com.example.pandas.app

/**
 * <登录信息>
 * @author: dongyiming
 * @date: 9/30/23 7:47 PM
 * @version: v1.0
 */
class LoginInfo private constructor() {

    private var loginStatus = 0

    companion object {
        val instance = LoginHolder.holder
    }

    private object LoginHolder {
        val holder = LoginInfo()
    }

    @Synchronized
    fun getLoginStatus(): Int = loginStatus

    @Synchronized
    fun setLoginStatus(status: Int) {
        this.loginStatus = status
    }
}