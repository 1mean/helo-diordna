package com.example.pandas.bean

import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser

data class BannerListBean(
    val bannerList: MutableList<PetVideo> = mutableListOf(),
    val itemList: MutableList<VideoAndUser> = mutableListOf()
)
