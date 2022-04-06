package com.example.pandas.bean
import com.example.pandas.bean.pet.PetViewData

/**
 * @description: landscape page
 * @author: dongyiming
 * @date: 2/4/22 5:33 下午
 * @version: v1.0
 */
public data class LandscapeData(
    val bannerList: MutableList<PetViewData> = mutableListOf(),
    val itemList: MutableList<PetViewData> = mutableListOf()
)