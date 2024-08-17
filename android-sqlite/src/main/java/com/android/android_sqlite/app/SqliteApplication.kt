package com.android.android_sqlite.app

import android.util.Log
import com.android.base.ModuleApplication

/**
 * @description: SqliteApplication
 * @author: dongyiming
 * @date: 8/1/24 9:14 PM
 * @version: v1.0
 */
public class SqliteApplication: ModuleApplication() {

    companion object {
        lateinit var instance: SqliteApplication
    }

    override fun onCreate() {
        super.onCreate()

        Log.e("1mean","ModuleApplication onCreate")
        instance = this

    }


}