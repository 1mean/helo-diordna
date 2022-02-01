package com.example.pandas.bean.pet

import com.example.pandas.sql.entity.MusicVo

data class MyLoveData(

    val size: Int = 4,
    var topUrl: String = "",
    var imgUrls: MutableList<String> = mutableListOf(),
    var horizontalVideos: MutableList<PetViewData> = mutableListOf(),
    var songs: MutableList<MusicVo> = mutableListOf()
)
