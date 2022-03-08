package com.example.pandas.data

import MultiVideoData
import PetGroupPandaData
import PetSinglePandaData
import android.util.Log
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo

object AppData {

    fun getPetVideoData(): MutableList<PetVideo> {

        //删除的code:429,431
        return mutableListOf<PetVideo>().apply {

            val list1 = MultiVideoData.getAll()
            Log.e("1mean", "size1: ${list1.size}")
            val list2 = PetBabyPandaData.getPetBabyPanda()
            Log.e("1mean", "size2: ${list2.size}")
            val list3 = PetBirdData.getPetBirdData()
            Log.e("1mean", "size3: ${list3.size}")
            val list4 = PetGroupPandaData.getPetGroupPandaData()
            Log.e("1mean", "size4: ${list4.size}")
            val list5 = PetMomPandaData.getAll()
            Log.e("1mean", "size5: ${list5.size}")
            val list6 = MusicVideoData.getMusicVideoData()
            Log.e("1mean", "size6: ${list6.size}")
            val list7 = PetSinglePandaData.getAll()
            Log.e("1mean", "size7: ${list7.size}")
            val list8 = BeautyData.getBeauty()
            Log.e("1mean", "size8: ${list8.size}")
            val list9 = PetMonPandaData2.getAll()
            Log.e("1mean", "size9: ${list9.size}")

            Log.e("1mean","sum: " + (list1.size+list2.size+list3.size+list4.size+list5.size+list6.size+list7.size+list8.size))
            addAll(list1)
            addAll(list2)
            addAll(list3)
            addAll(list4)
            addAll(list5)
            addAll(list6)
            addAll(list7)
            addAll(list8)
            addAll(list9)
        }
    }

    fun getMusicData(): MutableList<MusicVo> {

        return MusicData.getMusic()
    }
}