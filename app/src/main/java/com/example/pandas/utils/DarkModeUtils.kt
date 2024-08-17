package com.example.pandas.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

/**
 * <暗黑模式工具类>
 * @author: dongyiming
 * @date: 5/21/23 9:31 AM
 * @version: v1.0
 */
object DarkModeUtils {

    private const val KEY_MODE = "white_night_mode_sp"

    /**
     * 在 Application 的 onCreate() 方法中调用
     */
    fun init(application: Application) {
        val nightMode = getNightModel(application)
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    /**
     * 应用夜间模式
     */
    fun applyNightMode(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setNightModel(context, AppCompatDelegate.MODE_NIGHT_YES)
    }

    /**
     * 应用日间模式
     */
    fun applyDayMode(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setNightModel(context, AppCompatDelegate.MODE_NIGHT_NO)
    }

    /**
     * 跟随系统主题时需要动态切换
     */
    fun applySystemMode(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setNightModel(context, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    /**
     * 判断App当前是否处于暗黑模式状态
     */
    fun isDarkMode(context: Context): Boolean {
        val nightMode = getNightModel(context)
        return if (nightMode == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
            val applicationUiMode: Int = context.resources.configuration.uiMode
            val systemMode = applicationUiMode and Configuration.UI_MODE_NIGHT_MASK
            systemMode == Configuration.UI_MODE_NIGHT_YES
        } else {
            nightMode == AppCompatDelegate.MODE_NIGHT_YES
        }
    }

    fun getNightModel(context: Context): Int {
        val sp: SharedPreferences = context.getSharedPreferences(KEY_MODE, Context.MODE_PRIVATE)
        return sp.getInt(KEY_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    private fun setNightModel(context: Context, nightMode: Int) {
        val sp: SharedPreferences = context.getSharedPreferences(KEY_MODE, Context.MODE_PRIVATE)
        sp.edit().putInt(KEY_MODE, nightMode).apply()
    }
}