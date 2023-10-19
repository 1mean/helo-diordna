package com.example.pandas.app

import AppInstance
import AppViewModel
import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.viewmodel.EventViewModel
import com.example.pandas.data.sql.AppData
import com.example.pandas.data.sql.MusicVideoData
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.um.UmInitConfig
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.SPUtils
import com.umeng.commonsdk.UMConfigure


//Application全局共享的ViewModel，里面存放了一些账户信息，基本配置信息等
val appViewModel: AppViewModel by lazy { DiorApplication.appViewModelInstance }

//Application全局的ViewModel，用于发送全局通知操作
val eventViewModel: EventViewModel by lazy { DiorApplication.eventViewModelInstance }

class DiorApplication : Application(), ViewModelStoreOwner {

    private lateinit var mAppViewModelStore: ViewModelStore
    private var mFactory: ViewModelProvider.Factory? = null

    companion object {
        lateinit var instance: DiorApplication
        lateinit var eventViewModelInstance: EventViewModel
        lateinit var appViewModelInstance: AppViewModel
    }

    override fun onCreate() {
        super.onCreate()

        mAppViewModelStore = ViewModelStore()

        //获取全局可用
        instance = this
        eventViewModelInstance = getAppViewModelProvider()[EventViewModel::class.java]
        appViewModelInstance = getAppViewModelProvider()[AppViewModel::class.java]

        CrashHandler.init(this)

        //友盟初始化
        UMConfigure.preInit(applicationContext, AppInfos.appKey, AppInfos.channel)
        val initConfig = UmInitConfig()
        initConfig.UMinit(applicationContext)

        //判断当前设置是黑夜模式时，采用黑夜模式
        val nightMode = DarkModeUtils.getNightModel(this)
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            DarkModeUtils.applyNightMode(this)
            AppInstance.isNightMode = true
        }
        //initdata()
    }

    /**
     * 获取一个全局的ViewModel
     */
    private fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            //在MyApplication中，使用了ViewModelProvider.AndroidViewModelFactory这个工厂来创建ViewModel实例
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory as ViewModelProvider.Factory
    }

    private var startIndex = 0
    private val page = 10
    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()


//            val codes = arrayOf(708,1050)
//            for (code in codes) {
//                val video = petDao.queryVideoByCode1(code)
//                video.star = false
//                petDao.update(video)
//            }

//            val codes = arrayOf(77, 1946, 2815, 2000, 1809, 1810,1799)
//            val codes2 = arrayOf(1808,1127)
//            for (code in codes) {
//                val video = petDao.queryVideoByCode1(code)
//                video.videoType = 0
//                petDao.update(video)
//            }
//            for (code in codes2) {
//                val video = petDao.queryVideoByCode1(code)
//                video.videoType = 1
//                petDao.update(video)
//            }


//            val musicArray = mutableListOf<Int>()
//            val musics = petDao.queryAllTypeVideos(VideoType.ART.ordinal)
//            musics.forEachIndexed { index, petVideo ->
//                musicArray.add(petVideo.code)
//            }
//
//            Log.e("1mean","musicArray:$musicArray")


//            val videos = petDao.queryVerticalVideos()
//            videos.forEach {
//                if (it.width == 0) {
//                    Log.e("2mean","videos: $videos")
//                }
//            }


//            val list = DouyinData.getAll()
//            petDao.insertAll(list)
//            val users = UserData3.getAll()
//            petDao.insertUsers(users)

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
//            val key = SPUtils.getString(this, AppInfos.LOCAL_DATA_KEY)
//            if (key.isEmpty()) {
//                SPUtils.putString(this, AppInfos.LOCAL_DATA_KEY, "local")
//                val list = AppData.getPetVideoData()
//                petDao.insertAll(list)
//                val list1 = AppData.getMusicData()
//                petDao.insertMusics(list1)
//                val list2 = AppData.getUser()
//                petDao.insertUsers(list2)
//                val list3 = AppData.getComment()
//                petDao.insertComment(list3)
//                val list4 = AppData.getShortComment()
//                petDao.insertComment(list4)
//            }
        }.start()
    }

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }
}