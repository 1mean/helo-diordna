package com.android.android_sqlite.bean

import com.android.android_sqlite.entity.PetVideo

/**
 * @description: landscape page
 * @author: dongyiming
 * @date: 2/4/22 5:33 下午
 * @version: v1.0
 */
public data class LandscapeData(
    val bannerList: MutableList<PetVideo> = mutableListOf(),
    val itemList: MutableList<PetVideo> = mutableListOf()
)