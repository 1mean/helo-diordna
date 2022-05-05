package com.example.pandas.bean.pet

import com.example.pandas.bean.BannerItem
import com.example.pandas.sql.entity.MusicVo

data class PageCommonData(

    var topUrl: String = "",
    var bannerList: MutableList<BannerItem> = mutableListOf(),
    var movieModel: MutableList<PetViewData> = mutableListOf(),
    var songs: MutableList<MusicVo> = mutableListOf(),
    var footBallModel: MutableList<PetViewData> = mutableListOf(),
    var talkAudios: MutableList<MusicVo> = mutableListOf(),
    var videoList: MutableList<PetViewData> = mutableListOf(),
    var artList: MutableList<PetViewData> = mutableListOf(),
    var babyList: MutableList<PetViewData> = mutableListOf(),
    var honglouList: MutableList<PetViewData> = mutableListOf(),
    var beautyList: MutableList<PetViewData> = mutableListOf(),

    )

data class SleepModel(
    var videos: MutableList<PetViewData> = mutableListOf(),
    var audios: MutableList<MusicVo> = mutableListOf()
)