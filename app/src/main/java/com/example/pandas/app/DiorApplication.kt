package com.example.pandas.app

import android.app.Application
import android.util.Log
import com.example.pandas.sql.database.AppDataBase


class DiorApplication : Application() {

    companion object {

        private lateinit var _instance: Application
        fun instance() = _instance
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
        CrashHandler.init(this)
        //
        //initdata()

    }

    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()

//            val list = petDao.queryVideoData()
//            petDao.deleteAllVideoData(list)

            /* add data */
//            val list = AppData.getPetVideoData()
//            val list1 = AppData.getMusicData()
//            val list2 = AppData.getUser()
//            petDao.insertAll(list)
//            petDao.insertMusics(list1)
//            petDao.insertUsers(list2)

        }.start()
    }
}