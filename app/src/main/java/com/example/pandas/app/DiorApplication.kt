package com.example.pandas.app

import android.app.Application
import com.example.pandas.BuildConfig
import com.example.pandas.data.AppData
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.utils.SPUtils
import leakcanary.LeakCanary


class DiorApplication : Application() {

    companion object {

        private lateinit var _instance: Application
        fun instance() = _instance
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
        CrashHandler.init(this)

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
//            val list3 = AppData.getComment()
//            petDao.insertAll(list)
//            petDao.insertMusics(list1)
//            petDao.insertUsers(list2)
//            petDao.insertComment(list3)


        }.start()
    }
}