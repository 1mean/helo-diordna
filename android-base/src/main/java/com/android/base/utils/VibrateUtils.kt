package com.android.base.utils

import android.Manifest.permission.VIBRATE
import android.content.Context.VIBRATOR_SERVICE
import android.os.Vibrator
import androidx.annotation.RequiresPermission
import com.android.base.ModuleApplication


/**
 * 震动工具类
 * @author: dongyiming
 * @date: 6/17/22 1:22 下午
 * @version: v1.0
 */
object VibrateUtils {

    private var vibrator: Vibrator? = null

    /**
     * Vibrate.
     *
     * Must hold `<uses-permission android:name="android.permission.VIBRATE" />`
     *
     * @param pattern An array of longs of times for which to turn the vibrator on or off.
     * @param repeat  The index into pattern at which to repeat, or -1 if you don't want to repeat.
     */
    @RequiresPermission(VIBRATE)
    fun vibrate(pattern: LongArray?, repeat: Int) {
        val vibrator = getVibrator() ?: return
        vibrator.vibrate(pattern, repeat)
    }

    /**
     * Cancel vibrate.
     *
     * Must hold `<uses-permission android:name="android.permission.VIBRATE" />`
     */
    @RequiresPermission(VIBRATE)
    fun cancel() {
        val vibrator = getVibrator() ?: return
        vibrator.cancel()
    }

    /**
     * Vibrate.
     *
     * Must hold `<uses-permission android:name="android.permission.VIBRATE" />`
     *
     * @param milliseconds The number of milliseconds to vibrate.
     */
    @RequiresPermission(VIBRATE)
    fun vibrate(milliseconds: Long) {
        val vibrator = getVibrator() ?: return
        vibrator.vibrate(milliseconds)
    }

    private fun getVibrator(): Vibrator? {
        if (vibrator == null) {
            vibrator =
                ModuleApplication.instance.applicationContext.getSystemService(VIBRATOR_SERVICE) as Vibrator
        }
        return vibrator
    }
}