package com.example.pandas.bean.pet

import com.example.pandas.sql.entity.MusicVo

data class PageCommonData(

    var topUrl: String = "",
    var imgUrls: MutableList<String> = mutableListOf(),
    var horizontalVideos: MutableList<PetViewData> = mutableListOf(),
    var movieModel: MutableList<PetViewData> = mutableListOf(),
    var songs: MutableList<MusicVo> = mutableListOf(),
    var sleepModel: MutableList<PetViewData> = mutableListOf(),
    var talkAudios: MutableList<MusicVo> = mutableListOf(),
    var videoList: MutableList<PetViewData> = mutableListOf()

)

data class SleepModel(
    var videos: MutableList<PetViewData> = mutableListOf(),
    var audios: MutableList<MusicVo> = mutableListOf()
)