package com.example.pandas

import android.app.Application
import android.content.Context
import com.example.pandas.data.AppData
import com.example.pandas.data.CutePetBannerData
import com.example.pandas.data.FoxData
import com.example.pandas.data.LoveData
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.MusicVo
import kotlin.properties.Delegates


class DiorApplication : Application() {

    companion object{

        private lateinit var _instance:Application
        fun instance() = _instance
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
        //initdata()
    }

    private fun initdata() {

        Thread{
            val petDao = AppDataBase.getInstance().petVideoDao()
            //val list = petDao.queryVideoType(3)
            val list1 = AppData.getAll()
            val list = LoveData.getMusic()
            petDao.insertAll(list1)
            petDao.insertMusics(list)
        }.start()
    }
}