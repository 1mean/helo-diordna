package com.android.base

import android.app.Application
import android.util.Log

/**
 * @description: 子模块公共的application
 * @author: dongyiming
 * @date: 8/1/24 9:36 PM
 * @version: v1.0
 */
public open class ModuleApplication:Application() {

    companion object {
        lateinit var instance: ModuleApplication
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("1mean","ModuleApplication onCreate")

        instance = this
    }
}