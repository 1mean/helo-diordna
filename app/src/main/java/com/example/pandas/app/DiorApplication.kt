package com.example.pandas.app

import android.app.Application
import android.util.Log
import com.example.pandas.data.AppData
import com.example.pandas.data.FootballData
import com.example.pandas.data.UserData
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.User


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