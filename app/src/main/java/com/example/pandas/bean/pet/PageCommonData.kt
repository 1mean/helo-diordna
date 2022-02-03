package com.example.pandas.bean.pet

import com.example.pandas.sql.entity.MusicVo

data class PageCommonData(

    val size: Int = 6,
    var topUrl: String = "",
    var imgUrls: MutableList<String> = mutableListOf(),
    var horizontalVideos: MutableList<PetViewData> = mutableListOf(),
    var songs: MutableList<MusicVo> = mutableListOf(),
    var sleepModel: SleepModel = SleepModel(),
    var talkAudios: MutableList<MusicVo> = mutableListOf()
)

data class SleepModel(
    var videos: MutableList<PetViewData> = mutableListOf(),
    var audios: MutableList<MusicVo> = mutableListOf()
)