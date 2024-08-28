package com.example.pandas.bean

/**
 * 获取公众号列表的返回
 * @author: dongyiming
 * @date: 8/23/24 4:33 PM
 * @version: v1.0
 */
data class CoinsResponse(
    var errorCode: Int = 0,
    var errorMsg: String = "",
    var data: Data
) {
    data class Data(
        var curPage: Int = 0,
        var offset: Int = 0,
        var pageCount: Int = 0,
        var size: Int = 0,
        var total: Int = 0,
        var over: Boolean = false,
        var datas: List<CoinInfo>
    ) {
        data class CoinInfo(
            var id: Int = 0,
            var coinCount: Int = 0,
            var date: Long = 0L,
            var desc: String = "",
            var reason: String = "",
            var userName: String = "",
            var type: Int = 0,
            var userId: Int = 0,
        )
    }
}
