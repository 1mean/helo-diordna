package com.example.pandas.app

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.um.UmInitConfig
import com.example.pandas.utils.DarkModeUtils
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

        //判断当前设置是黑夜模式时，采用黑夜模式
        val nightMode = DarkModeUtils.getNightModel(this)
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            DarkModeUtils.applyNightMode(this)
        }

        //initdata()
    }

    private var startIndex = 0
    private val page = 10
    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()


            //petDao.insert(panda151)
            //petDao.delete(code)


            //判断是否有没有存在的user对象
            for (i in 0..1000) {
                //Log.e("2mean", "startIndex:$startIndex , page:$page")
                val list = petDao.queryVideosByPage(startIndex, page)
                if (list.isEmpty()) {
                    break
                }
                list.forEach {
                    val user = petDao.queryVerticalUser(it.authorId)
                    if (user == null) {
                        Log.e("2mean", "user is null by userCode=${it}")
                    }
                }
                startIndex += 10
            }


//            val list = ShortCommentData.getList()
//            petDao.insertComment(list)


            /* add data */
//            val list = AppData.getPetVideoData()
//            petDao.insertAll(list)
//            val list1 = AppData.getMusicData()
//            petDao.insertMusics(list1)
//            val list2 = AppData.getUser()
//            petDao.insertUsers(list2)
//            val list3 = AppData.getComment()
//            petDao.insertComment(list3)
//            val list4 = AppData.getShortComment()
//            petDao.insertComment(list4)

        }.start()
    }
}