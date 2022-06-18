package com.example.pandas.utils

import android.Manifest.permission.VIBRATE
import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.os.Vibrator
import android.os.VibratorManager
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission


/**
 * 震动工具类
 * @author: dongyiming
 * @date: 6/17/22 1:22 下午
 * @version: v1.0
 */
object VibrateUtils {

    private var vibrator: Vibrator? = null

    private fun getInstance(context: Context): Vibrator {

        if (vibrator == null) {
            vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager =
                    context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(VIBRATOR_SERVICE) as Vibrator
            }
        }
        return vibrator!!
    }

    /**
     * 只震动一次
     */
    @RequiresPermission(VIBRATE)
    fun vibrate(context: Context, milliseconds: Long) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val effect = VibrationEffect.createOneShot(milliseconds, DEFAULT_AMPLITUDE)
            getInstance(context).vibrate(effect)
        } else {
            @Suppress("DEPRECATION")
            getInstance(context).vibrate(milliseconds)
        }
    }

    @RequiresPermission(VIBRATE)
    fun cancel() {
        vibrator?.cancel()
    }
}