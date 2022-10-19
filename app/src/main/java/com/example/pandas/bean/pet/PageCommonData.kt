package com.example.pandas.bean.pet

import com.example.pandas.bean.BannerItem
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo

data class PageCommonData(

    var topUrl: String = "",
    var bannerList: MutableList<BannerItem> = mutableListOf(),
    var movieModel: MutableList<PetVideo> = mutableListOf(),
    var songs: MutableList<MusicVo> = mutableListOf(),
    var footBallModel: MutableList<PetVideo> = mutableListOf(),
    var talkAudios: MutableList<MusicVo> = mutableListOf(),
    var videoList: MutableList<PetVideo> = mutableListOf(),
    var artList: MutableList<PetVideo> = mutableListOf(),
    var babyList: MutableList<PetVideo> = mutableListOf(),
    var honglouList: MutableList<PetVideo> = mutableListOf(),
    var beautyList: MutableList<PetVideo> = mutableListOf(),

    )

data class SleepModel(
    var videos: MutableList<PetViewData> = mutableListOf(),
    var audios: MutableList<MusicVo> = mutableListOf()
)