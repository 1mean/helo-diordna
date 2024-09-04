package com.example.pandas.app

import AppInstance
import AppViewModel
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.android.android_sqlite.app.SqliteApplication
import com.android.android_sqlite.entity.GroupVideoItem
import com.android.android_sqlite.manager.groupRepository
import com.android.android_sqlite.manager.searchHistoryRepository
import com.android.android_sqlite.manager.userRepository
import com.android.base.ModuleApplication
import com.android.base.app.CrashHandler
import com.example.pandas.biz.viewmodel.EventViewModel
import com.example.pandas.um.UmInitConfig
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.Preference
import com.umeng.commonsdk.UMConfigure
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.reflect.Method


//Application全局共享的ViewModel，里面存放了一些账户信息，基本配置信息等
val appViewModel: AppViewModel by lazy { DiorApplication.appViewModelInstance }

//Application全局的ViewModel，用于发送全局通知操作
val eventViewModel: EventViewModel by lazy { DiorApplication.eventViewModelInstance }

class DiorApplication : Application(), ViewModelStoreOwner {

    private lateinit var mAppViewModelStore: ViewModelStore
    private var moduleApplication: ModuleApplication? = null
    private var sqliteModuleApplication: SqliteApplication? = null
    private var mFactory: ViewModelProvider.Factory? = null

    companion object {
        lateinit var instance: DiorApplication
        lateinit var eventViewModelInstance: EventViewModel
        lateinit var appViewModelInstance: AppViewModel
    }

    /**
     * 目的：模块共有的初始化，放入主工程Application 中,模块自身的特殊功能初始化，放在自己的 Application
     * 问题：多Module项目开发的时候，app module和library module都有不同的自定义Application,无法共存
     *      - 首先，自定义Application需要声明在AndroidManifest.xml中。每个Module都有该清单文件，但是最终的APK文件只能包含一个。
     *      - 因此，在构建应用时，Gradle构建会将所有清单文件合并到一个封装到 APK 的清单文件中。
     *      - 合并的优先级是:App Module > Library Module
     * 最终结果：APP打开的时候，只会初始化主工程的application（打开主工程AndroidManifest，点击Merged Manifest
     * ，就可以看到，其他的Module的application都被覆盖了，只剩下主工程application）
     * 解决方案：
     *      - 在初始化主工程application的时候，对其他module的application进行初始化
     *      - 使用Hilt/Dagger这种依赖注入的方案
     */
    override fun onCreate() {
        super.onCreate()

        mAppViewModelStore = ViewModelStore()

        //获取全局可用
        instance = this
        eventViewModelInstance = getAppViewModelProvider()[EventViewModel::class.java]
        appViewModelInstance = getAppViewModelProvider()[AppViewModel::class.java]

        CrashHandler.init(this)

        Preference.setContext(this)

        //同步Module的Application的onCreate,用于执行module的一些自定义初始化操作
        moduleApplication?.onCreate()
        sqliteModuleApplication?.onCreate()

        //友盟初始化
        UMConfigure.preInit(applicationContext, AppInfos.appKey, AppInfos.channel)
        val initConfig = UmInitConfig()
        initConfig.UMinit(applicationContext)

        //判断当前设置是黑夜模式时，采用黑夜模式
        val nightMode = DarkModeUtils.getNightModel(this)
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            DarkModeUtils.applyNightMode(this)
            AppInstance.instance.isNightMode = true
        }
        initdata()
    }

    /**
     * 实际上就是主工程的Application和module的Application共用一个base
     *  - 不用在Module的AndroidManifest中注册
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        moduleApplication = getModuleApplicationInstance(this)
        sqliteModuleApplication = getSqliteApplicationInstance(this)
        try {
            //通过反射调用moduleApplication的attach方法
            val method: Method? =
                Application::class.java.getDeclaredMethod("attach", Context::class.java)
            method?.let {
                it.isAccessible = true
                it.invoke(moduleApplication, baseContext)
                it.invoke(sqliteModuleApplication, baseContext)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    //映射获取ModuleApplication
    private fun getModuleApplicationInstance(paramContext: Context): ModuleApplication? {
        try {
            if (moduleApplication == null) {
                val classLoader = paramContext.classLoader
                if (classLoader != null) {
                    val mClass = classLoader.loadClass(ModuleApplication::class.java.name)
                    if (mClass != null)
                        moduleApplication = mClass.newInstance() as ModuleApplication
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return moduleApplication
    }

    //映射获取ModuleApplication
    private fun getSqliteApplicationInstance(paramContext: Context): SqliteApplication? {
        try {
            if (sqliteModuleApplication == null) {
                val classLoader = paramContext.classLoader
                if (classLoader != null) {
                    val mClass = classLoader.loadClass(SqliteApplication::class.java.name)
                    if (mClass != null)
                        sqliteModuleApplication = mClass.newInstance() as SqliteApplication
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sqliteModuleApplication
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

        GlobalScope.launch {
            //searchHistoryRepository.deleteHistoryById(69)
        }

        Thread {

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