package com.example.pandas.ui.ext;

import android.content.pm.ActivityInfo
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.core.view.WindowCompat
import com.example.pandas.ui.activity.VideoPlayingActivity

fun VideoPlayingActivity.fullScreen() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

        //Tell the window that we want to handle/fit any system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = window.insetsController
        controller?.hide(WindowInsets.Type.statusBars())
    } else {
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    val params = binding.playView.layoutParams
    params.width = ViewGroup.LayoutParams.MATCH_PARENT
    params.height = ViewGroup.LayoutParams.MATCH_PARENT
    binding.playView.layoutParams = params
}

fun VideoPlayingActivity.closeFullScreen(){
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    val params = binding.playView.layoutParams
    params.width = ViewGroup.LayoutParams.MATCH_PARENT
    params.height = (200 * applicationContext.resources.displayMetrics.density).toInt()
    binding.playView.layoutParams = params
}