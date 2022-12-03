package com.example.pandas.app

import android.app.Application
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.emoji.bundled.BundledEmojiCompatConfig
import androidx.emoji.text.EmojiCompat
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.data.sql.AppData
import com.example.pandas.data.sql.DataCopy
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.ext.shortToast
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

        initEmoji()
        //initdata()
    }

    private fun initdata() {

        Thread {
            val petDao = AppDataBase.getInstance().petVideoDao()

            /* add data */
//            val list = AppData.getPetVideoData()
//            petDao.insertAll(list)
//            val list1 = AppData.getMusicData()
//            petDao.insertMusics(list1)
//            val list2 = AppData.getUser()
//            petDao.insertUsers(list2)
//            val list3 = AppData.getComment()
//            petDao.insertComment(list3)
        }.start()
    }

    private fun initEmoji() {
        val config: EmojiCompat.Config = BundledEmojiCompatConfig(this)
        config.setReplaceAll(true)
        config.registerInitCallback(object : EmojiCompat.InitCallback() {
            override fun onInitialized() {
                //初始化成功回调
                shortToast(this@DiorApplication,"初始化成功")
            }

            override fun onFailed(@Nullable throwable: Throwable?) {
                //初始化失败回调
                shortToast(this@DiorApplication,"初始化失败")
            }
        })
        EmojiCompat.init(config)
    }
}