package com.example.pandas.app

import android.app.Application
import com.example.pandas.data.*
import com.example.pandas.sql.database.AppDataBase


class DiorApplication : Application() {

    companion object {

        private lateinit var _instance: Application
        fun instance() = _instance
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
        //
       //initdata()
    }

    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()

            val list1 = FootballData.getAll()
            petDao.insertAll(list1)
//
//            val list2 = AppData.getMusicData()
//            petDao.insertMusics(list2)

//            for (id in 1845..1888){
//                val video = petDao.queryById(id)
//                petDao.delete(video)
//            }

        }.start()
    }
}