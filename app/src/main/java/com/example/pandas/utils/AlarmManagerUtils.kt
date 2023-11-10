package com.example.pandas.utils

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.pandas.ui.service.TimingService
import java.util.*

/**
 * @description: AlarmManagerUtils
 * @author: dongyiming
 * @date: 11/6/23 5:41 PM
 * @version: v1.0
 */
public class AlarmManagerUtils(private val context: Context) {


    private val TIME_INTERVAL = 10 * 1000//闹钟执行任务的时间间隔
    private var am: AlarmManager? = null
    private var pendingIntent: PendingIntent? = null
    private var calendar: Calendar? = null

    public fun createGetUpAlarmManager() {
        am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, TimingService::class.java)
        pendingIntent = PendingIntent.getService(context, 0, intent, 0)//每隔10秒启动一次服务
    }

    @SuppressLint("NewApi")
    public fun getUpAlarmManagerStartWork() {

        calendar = Calendar.getInstance()
        calendar!!.set(Calendar.HOUR_OF_DAY, 23)
        calendar!!.set(Calendar.MINUTE, 50)
        calendar!!.set(Calendar.SECOND, 0)

        //版本适配 System.currentTimeMillis()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {// 6.0及以上
            am?.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar!!.timeInMillis, pendingIntent
            )
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {// 4.4及以上
            am?.setExact(
                AlarmManager.RTC_WAKEUP, calendar!!.timeInMillis,
                pendingIntent
            )
        } else {
            am?.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar!!.timeInMillis, TIME_INTERVAL.toLong(), pendingIntent
            )
        }
    }

    @SuppressLint("NewApi")
    public fun getUpAlarmManagerWorkOnOthers() {
        //高版本重复设置闹钟达到低版本中setRepeating相同效果
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {// 6.0及以上
            am?.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + TIME_INTERVAL, pendingIntent
            )
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {// 4.4及以上
            am?.setExact(
                AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                        + TIME_INTERVAL, pendingIntent
            )
        }
    }
}