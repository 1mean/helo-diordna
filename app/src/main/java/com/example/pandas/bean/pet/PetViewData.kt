package com.example.pandas.bean.pet

data class PetViewData(

    var code: Int = 0,
    var title: String = "",
    var duration: Int = 0,
    var cover: String = "",
    var authorName: String = "",
    var videoType: Int = 0,
    var releaseTime: String? = "",//需要时设置，petDao里可以不用设置，编译不会报错
    var fileName: String? = ""
)
