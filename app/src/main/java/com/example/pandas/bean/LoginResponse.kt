package com.example.pandas.bean

/**
 * LoginResponse
 * @author: dongyiming
 * @date: 8/15/24 1:05 AM
 * @version: v1.0
 */
data class LoginResponse(
    var errorCode: Int,
    var errorMsg: String?,
    var data: Data
) {
    /**
     * {
     * *"data": {
     * * * *"admin": false,
     * * * *"chapterTops": [],
     * * * *"coinCount": 33,
     * * * *"collectIds": [],
     * * * *"email": "870934420@qq.com",
     * * * *"icon": "",
     * * * *"id": 163381,
     * * * *"nickname": "董一鸣",
     * * * *"password": "",
     * * * *"publicName": "董一鸣",
     * * * *"token": "",
     * * * *"type": 0,
     * * * *"username": "董一鸣"
     * },
     * *"errorCode": 0,
     * *"errorMsg": ""
     *  }
     */
    data class Data(
        var id: Int,
        var username: String,
        var password: String?,//空的
        var icon: String?,
        var type: Int,
        var collectIds: List<Int>?,
        var admin: Boolean,
        var email: String?,
        var nickname: String?,
        var publicName: String?,
    )
}
