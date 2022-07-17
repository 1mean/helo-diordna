package com.example.pandas.bean

/**
 * <我的-缓存>列表数据
 * @author: dongyiming
 * @date: 7/14/22 12:55 下午
 * @version: v1.0
 */
data class CacheListItemData(
    var title: String = "",
    var data: MutableList<CachaListItem> = mutableListOf()
)

data class CachaListItem(
    var type: Int = 0,
    var counts: Int = 0,
    var name: String = "未知",
    var desc: String = "",
    var fileName: String = "未知",
    var url: String = "",
    var localFilePath: String = ""
)
