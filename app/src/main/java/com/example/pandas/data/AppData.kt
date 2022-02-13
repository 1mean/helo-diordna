package com.example.pandas.data

import MultiVideoData
import PetGroupPandaData
import PetSinglePandaData
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo

object AppData {

    fun getPetVideoData(): MutableList<PetVideo> {

        return mutableListOf<PetVideo>().apply {

            addAll(MultiVideoData.getAll())
            addAll(PetBabyPandaData.getPetBabyPanda())
            addAll(PetBirdData.getPetBirdData())
            addAll(PetGroupPandaData.getPetGroupPandaData())
            addAll(PetMomPandaData.getPetMomPandaData())
            addAll(MusicVideoData.getMusicVideoData())
            addAll(PetSinglePandaData.getAll())
            addAll(BeautyData.getBeauty())
        }
    }

    fun getMusicData(): MutableList<MusicVo> {

        return MusicData.getMusic()
    }
}