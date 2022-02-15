package com.example.pandas

import android.app.Application
import android.util.Log
import com.example.pandas.bean.pet.PetType
import com.example.pandas.data.AppData
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.PetVideo


class DiorApplication : Application() {

    companion object {

        private lateinit var _instance: Application
        fun instance() = _instance
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
        //initdata()
    }

    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()
            val video = petDao.queryByCode(431)
            petDao.delete(video)
//            val list1 = AppData.getMusicData()
//            val list2 = AppData.getPetVideoData()
//            petDao.insertMusics(list1)
          //  Log.e("1mean", "count: " + petDao.getAllSize())
        }.start()
    }
}