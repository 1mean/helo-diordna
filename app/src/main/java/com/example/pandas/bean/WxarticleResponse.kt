package com.example.pandas.bean

/**
 * 获取公众号列表的返回
 * @author: dongyiming
 * @date: 8/23/24 4:33 PM
 * @version: v1.0
 */
data class WxarticleResponse(
    var errorCode: Int = 0,
    var errorMsg: String = "",
    var data: List<Wxarticle>
) {
    data class Wxarticle(
        var id: Int = 0,
        var articleList: List<Any>? = null,
        var children: List<Any>? = null,
        var author: String = "",
        var cover: String = "",
        var desc: String = "",
        var lisense: String = "",
        var lisenseLink: String = "",
        var name: String = "",
        var courseId: Int = 0,
        var order: Int = 0,
        var parentChapterId: Int = 0,
        var type: Int = 0,
        var visible: Int = 0,
        var userControlSetTop: Boolean = false,
    )
}
