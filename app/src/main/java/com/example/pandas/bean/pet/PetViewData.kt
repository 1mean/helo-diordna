package com.example.pandas.bean.pet

import androidx.room.Ignore
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoData

data class PetViewData(

    var code: Int = 0,
    var title: String = "",
    var duration: Int = 0,
    var cover: String = "",
    var authorId: Int = 0,
    @Ignore
    var videoType: Int = 0,
    var releaseTime: String? = "",//需要时设置，petDao里可以不用设置，编译不会报错
    var fileName: String? = "",
    @Ignore
    var user: User? = null,
    @Ignore
    var videoData: VideoData? = null
)
