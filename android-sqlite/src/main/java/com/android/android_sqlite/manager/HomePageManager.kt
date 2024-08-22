package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.dao.PetVideoDao

/**
 * @description: 处理所有pet相关
 * @author: dongyiming
 * @date: 1/20/22 1:11 上午
 * @version: v1.0
 */
class PetVideoRepository : BaseRepository() {

    private val delayTime = 500L

    private val petDao: PetVideoDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().petVideoDao()
    }
}