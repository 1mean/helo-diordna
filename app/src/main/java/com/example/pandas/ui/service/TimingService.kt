package com.example.pandas.ui.service

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.example.pandas.ui.ext.toast
import java.util.*

/**
 * @description: TimingService
 * @author: dongyiming
 * @date: 10/30/22 6:28 下午
 * @version: v1.0
 */
public class TimingService : Service() {

    private val ALARM_EVENT = "com.example.pandas.ui.broadcast.TimingBroadCast"

    private var duration: Int = 0
    private var alarmManager: AlarmManager? = null
    private var pIntent: PendingIntent? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onCreate() {
        super.onCreate()

        if (alarmManager == null) {//使用系统闹钟，避免手机休眠导致任务无法完成(如Timer)
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        }

        if (pIntent == null) {//创建一个用于广播的延迟意图
            val broadIntent = Intent(ALARM_EVENT)
            pIntent =
                PendingIntent.getBroadcast(applicationContext, 0, broadIntent, FLAG_UPDATE_CURRENT)
        }
    }

    //每次通过startService()方法启动Service时都会被回调
    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        duration = intent?.getIntExtra("time", 0)!!
        Log.e("TimingService", "服务启动成功，时间为= $duration")

        if (duration == 0) {
            alarmManager?.let {
                pIntent?.let { intent ->
                    it.cancel(intent)
                    Toast.makeText(this, "取消任务成功", Toast.LENGTH_SHORT).show()
                }
            }
            return START_REDELIVER_INTENT
        }
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        // 给当前时间加上若干秒
        calendar.add(Calendar.MINUTE, duration)
        // 开始设定闹钟，延迟若干秒后，携带延迟意图发送闹钟广播
        alarmManager!!.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pIntent)

        return START_REDELIVER_INTENT
    }


}