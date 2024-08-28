package com.example.pandas.bean

/**
 * 搜索热词
 * @author: dongyiming
 * @date: 8/23/24 4:33 PM
 * @version: v1.0
 */
data class HotKeyResponse(
    var errorCode: Int = 0,
    var errorMsg: String = "",
    var data: List<HotKey>
) {
    data class HotKey(
        var id: Int = 0,
        var link: String = "",
        var name: String = "",
        var order: Int = 0,
        var visible: Int = 0,
    )
}
