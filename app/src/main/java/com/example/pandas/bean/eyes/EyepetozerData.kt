package com.example.pandas.bean.eyes

data class EyepetozerData(

    var itemList: MutableList<EyepetozerItem> = mutableListOf(),
    var date: Long = 0L,
    var nextPublishTime: Long = 0L,
    var nextPageUrl: String? = null,
)
