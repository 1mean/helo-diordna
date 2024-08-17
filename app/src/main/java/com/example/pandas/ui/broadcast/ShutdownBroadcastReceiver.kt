package com.example.pandas.ui.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.android.base.utils.AppUtils

/**
 * @description: 定时关机
 * @author: dongyiming
 * @date: 11/6/23 1:31 PM
 * @version: v1.0
 */
public class ShutdownBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        try {
            val flag = intent?.extras?.getString("request")
            if (flag.equals("shutdown")) {
                //shutdownSys(context)
                AppUtils.exitApp()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 关机(需要系统权限)
     * @param context
     */
    private fun shutdownSys(context: Context?) {
        val intent = Intent()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            intent.action = "com.android.internal.intent.action.REQUEST_SHUTDOWN"
        } else {
            intent.action = "android.intent.action.ACTION_REQUEST_SHUTDOWN"
        }
        // 其中false换成true,会弹出是否关机的确认窗口
        intent.putExtra("android.intent.extra.KEY_CONFIRM", true)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context?.startActivity(intent)
    }
}