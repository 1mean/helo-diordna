package com.example.pandas.bean

/**
 * 获取公众号列表的返回
 * @author: dongyiming
 * @date: 8/23/24 4:33 PM
 * @version: v1.0
 */
data class WxPageArticleResponse(
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
        var datas: List<WxPageArticle>,
    ) {
        data class WxPageArticle(
            var adminAdd: Boolean = false,
            var collect: Boolean = false,
            var canEdit: Boolean = false,
            var fresh: Boolean = false,
            //var isAdminAdd: Boolean = false,//和adminAdd无法共存，是其get方法
            var apkLink: String = "",
            var author: String = "",
            var desc: String = "",
            var descMd: String = "",
            var host: String = "",
            var envelopePic: String = "",
            var link: String = "",
            var niceDate: String = "",
            var niceShareDate: String = "",
            var origin: String = "",
            var prefix: String = "",
            var projectLink: String = "",
            var shareUser: String = "",
            var superChapterName: String = "",
            var title: String = "",
            var chapterName: String = "",
            var audit: Int = 0,
            var chapterId: Int = 0,//408
            var courseId: Int = 0,
            var id: Int = 0,
            var realSuperChapterId: Int = 0,
            var selfVisible: Int = 0,
            var superChapterId: Int = 0,
            var type: Int = 0,
            var userId: Int = 0,
            var visible: Int = 0,
            var zan: Int = 0,
            var publishTime: Long = 0,
            var shareDate: Long = 0,
            var tags: List<tag>,
        ) {
            data class tag(
                var name: String = "",
                var url: String = "",
            )
        }
    }
}
