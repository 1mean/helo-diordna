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

            //landscape73.code = 3801
            //landscape78.code = 3806
            //landscape81.code = 3809
            //landscape81.code = 3797
            //landscape81.code = 3795
            //landscape81.code = 3796
            //landscape81.code = 3794
            //landscape81.code = 3798

            //landscape65.code = 3793
            //landscape64.code = 3792
            //landscape62.code = 3790
            //landscape61.code = 3789
            //landscape59.code = 3787
            //landscape58.code = 3786
            //landscape60.code = 3788
            //landscape74.code = 3802


            //清理掉封面加载失败的视频
//            val list = arrayOf(3802)
//            for (i in list) {
//                val video = petDao.queryVideoByCode1(i)
//                petDao.delete(video)
//
//                val videodata = petDao.queryVideoDataByCode2(i)
//                petDao.deleteVideoData(videodata)
//            }


            //判断是否有没有存在的user对象
//            for (i in 0..1000) {
//                //Log.e("2mean", "startIndex:$startIndex , page:$page")
//                val list = petDao.queryVideosByPage(startIndex, page)
//                if (list.isEmpty()) {
//                    break
//                }
//                list.forEach {
//                    val user = petDao.queryVerticalUser(it.authorId)
//                    if (user == null) {
//                        Log.e("2mean", "user is null by userCode=${it}")
//                    }
//                }
//                startIndex += 10
//            }


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