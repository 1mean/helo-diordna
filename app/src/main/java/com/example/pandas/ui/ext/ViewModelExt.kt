package com.example.pandas.biz.ext

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.pandas.ui.activity.UserInfoActivity
import com.example.pandas.ui.activity.VideoPlayingActivity

/**
 * SwipeRefreshLayout初始化设置
 */
fun SwipeRefreshLayout.init(distance: Int): SwipeRefreshLayout {

    //设置触发下拉刷新的距离
    setDistanceToTriggerSync(distance)
    //设置动画样式下拉的起始点和结束点，scale 是指设置是否需要放大或者缩小动画
    setProgressViewOffset(true, 200, 700)
    //设置动画样式下拉的结束点，scale 是指设置是否需要放大或者缩小动画
    setProgressViewEndTarget(true, 500)
    //设置进度View样式的大小，只有两个值DEFAULT和LARGE，表示默认和较大
    setSize(SwipeRefreshLayout.DEFAULT)
    ////如果自定义了swipeRefreshLayout，可以通过这个回调方法决定是否可以滑动
    setOnChildScrollUpCallback(null)
    return this
}

fun startVideoPlayActivity(context: Context, code: Int) {
    val intent = Intent(context, VideoPlayingActivity::class.java).apply {
        putExtra("code", code)
    }
    context.startActivity(intent)
}

fun startVideoPlayActivity(launcher: ActivityResultLauncher<Intent>, context: Context, code: Int) {
    val intent = Intent(context, VideoPlayingActivity::class.java).apply {
        putExtra("code", code)
    }
    launcher.launch(intent)
}

fun startVideoPlayActivity(context: Context, code: Int, isPlaying: Boolean, playPosition: Long) {
    val intent = Intent(context, VideoPlayingActivity::class.java).apply {
        putExtra("code", code)
        putExtra("isPlaying", isPlaying)
        putExtra("position", playPosition)
    }
    context.startActivity(intent)
}

fun startVideoPlayActivity(
    launcher: ActivityResultLauncher<Intent>,
    context: Context,
    code: Int,
    isPlaying: Boolean,
    playPosition: Long
) {
    val intent = Intent(context, VideoPlayingActivity::class.java).apply {
        putExtra("code", code)
        putExtra("isPlaying", isPlaying)
        putExtra("position", playPosition)
    }
    launcher.launch(intent)
}

fun launchVideoPlayActivity(
    context: Context,
    code: Int,
    isPlaying: Boolean,
    launcher: ActivityResultLauncher<Intent>
) {
    val intent = Intent(context, VideoPlayingActivity::class.java).apply {
        putExtra("code", code)
        putExtra("isPlaying", isPlaying)
    }
    launcher.launch(intent)
}