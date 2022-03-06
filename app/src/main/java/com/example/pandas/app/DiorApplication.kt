package com.example.pandas.app

import android.app.Application
import com.example.pandas.data.AppData
import com.example.pandas.sql.database.AppDataBase


class DiorApplication : Application() {

    companion object {

        private lateinit var _instance: Application
        fun instance() = _instance
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
//        initdata()
    }

    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()
//            val list = petDao.getAllMusic()
//            petDao.deleteAllMusic(list)
//            val list1 = AppData.getMusicData()
//            petDao.insertMusics(list1)
//            val video = petDao.queryByCode(431)
//            petDao.delete(video)
//            val list1 = AppData.getMusicData()
//            val list2 = AppData.getPetVideoData()
//            petDao.insertMusics(list1)
            //  Log.e("1mean", "count: " + petDao.getAllSize())
        }.start()
    }
}