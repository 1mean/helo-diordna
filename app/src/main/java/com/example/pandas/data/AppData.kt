package com.example.pandas.data

import PandaBabyData
import PandaGroupData
import PandaMomData
import PandaSingleData
import PetBanner
import com.example.pandas.sql.entity.PetVideo

object AppData {

    fun getAll(): MutableList<PetVideo> {

        var list = mutableListOf<PetVideo>()
        list.addAll(PandaBabyData.getBabyHeHua())
        list.addAll(PandaGroupData.getData())
        list.addAll(PandaMomData.getAll())
        list.addAll(PandaSingleData.getData())
        list.addAll(PetBanner.getAllBanner())
        list.addAll(PetHorData.getAll())
        return list
    }

}