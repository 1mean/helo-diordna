package com.example.pandas.app

import android.app.Application
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.data.sql.AppData
import com.example.pandas.data.sql.DataCopy
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.um.UmInitConfig
import com.umeng.commonsdk.UMConfigure


class DiorApplication : Application() {

    companion object {

        private lateinit var _instance: Application
        fun instance() = _instance
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
        CrashHandler.init(this)

        //友盟初始化
        UMConfigure.preInit(applicationContext, AppInfos.appKey, AppInfos.channel)

        val initConfig = UmInitConfig()
        initConfig.UMinit(applicationContext)

        //initdata()
    }

    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()

            /* add data */
            val list = AppData.getPetVideoData()
            petDao.insertAll(list)
            val list1 = AppData.getMusicData()
            petDao.insertMusics(list1)
            val list2 = AppData.getUser()
            petDao.insertUsers(list2)
            val list3 = AppData.getComment()
            petDao.insertComment(list3)
        }.start()
    }
}