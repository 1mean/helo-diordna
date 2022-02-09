package com.example.pandas

import android.app.Application
import android.content.Context
import com.example.pandas.data.*
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
            val list1 = AppData.getMusicData()
            val list2 = AppData.getPetVideoData()
            petDao.insertAll(list2)
            petDao.insertMusics(list1)
        }.start()
    }
}