package com.example.pandas.ui.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @description: TimingBroadCast
 * @author: dongyiming
 * @date: 10/30/22 6:33 下午
 * @version: v1.0
 */
public class TimingBroadCast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        intent?.let {
            val content = it.getIntExtra("time", 0)
        }

    }

}