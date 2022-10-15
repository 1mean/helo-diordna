package com.example.pandas.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

import android.view.WindowManager
import androidx.core.view.WindowCompat


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/14 10:31 下午
 * @version: v1.0
 */
object ScreenUtil {

    fun dip2px(dpValue: Float): Float {
        return (dpValue * Resources.getSystem().displayMetrics.density + 0.5f)
    }

    fun px2dp(context: Context, pxValue: Float): Int {

        val scale = context.resources.displayMetrics.density

        return (pxValue / scale + 0.5f).toInt()

    }


    //获取屏幕宽度的方法
    fun getScreenWidth(context: Context): Int {
        val wm = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    /**
     * 屏幕相关的写法，可以借鉴于其他功能 for activity
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 3/30/22 6:36 下午
     * @version: v1.0
     */
    fun hideSystemUI(context: Activity) {
        val window = context.window

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            // Tell the window that we want to handle/fit any system windows
            WindowCompat.setDecorFitsSystemWindows(window, false)

            val controller = window.insetsController

            // Hide the keyboard (IME)
            controller?.hide(WindowInsets.Type.ime())

            // Sticky Immersive is now ...
            controller?.systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

            // When we want to hide the system bars
            controller?.hide(WindowInsets.Type.systemBars())

            /*val flag = WindowInsets.Type.statusBars()
            WindowInsets.Type.navigationBars()
            WindowInsets.Type.captionBar()
            window?.insetsController?.hide(flag)*/
        } else {
            //noinspection
            @Suppress("DEPRECATION")
            // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
    }

    /**
     * 当前view是否至少一半在可视屏幕
     */
    fun isOverHalfViewVisiable(itemView: View): Boolean {

        val rect = Rect()
        itemView.getGlobalVisibleRect(rect)
        val visibleHeight = rect.height()//可见的高度
        val totalHeight = itemView.layoutParams.height//总高度
        Log.e("LiveVIdeosss","visibleHeight: $visibleHeight, totalHeight:$totalHeight")
        return visibleHeight >= (totalHeight / 2)
    }

    /**
     * 当前view是否至少一半在可视屏幕
     */
    fun getLocationHeight(itemView: View): Int {

        val ints = IntArray(2)
        itemView.getLocationInWindow(ints)
        val height = ints[1]
        return height
    }
}