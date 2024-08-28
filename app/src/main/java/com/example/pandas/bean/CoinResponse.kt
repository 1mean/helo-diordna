package com.example.pandas.bean

/**
 * 搜索热词
 * @author: dongyiming
 * @date: 8/23/24 4:33 PM
 * @version: v1.0
 */
data class CoinResponse(
    var errorCode: Int = 0,
    var errorMsg: String = "",
    var data: CoinInfo
) {
    data class CoinInfo(
        var coinCount: Int = 0,//总积分
        var rank: Int = 0,//当前排名
        var userId: Int = 0,
        var username: String = "",
    )
}
