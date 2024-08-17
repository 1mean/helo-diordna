package com.android.android_sqlite.bean

import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoAndUser

data class BannerListBean(
    val bannerList: MutableList<PetVideo> = mutableListOf(),
    val itemList: MutableList<VideoAndUser> = mutableListOf()
)
