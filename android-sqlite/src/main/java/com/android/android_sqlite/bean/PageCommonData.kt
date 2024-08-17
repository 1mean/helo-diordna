package com.android.android_sqlite.bean

import com.android.android_sqlite.entity.MusicVo
import com.android.android_sqlite.entity.PetVideo


data class PageCommonData(

    var topUrl: String = "",
    var bannerList: MutableList<BannerItem> = mutableListOf(),
    var footBallModel: MutableList<PetVideo> = mutableListOf(),
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