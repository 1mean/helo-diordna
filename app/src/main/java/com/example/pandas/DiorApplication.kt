package com.example.pandas

import android.app.Application
import android.content.Context
import com.example.pandas.data.AppData
import com.example.pandas.sql.database.AppDataBase
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
            val list = AppData.getAll()
            petDao.insertAll(list)
        }.start()
    }
}