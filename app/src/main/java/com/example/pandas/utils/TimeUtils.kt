package com.example.pandas.utils

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/31/21 11:50 上午
 * @version: v1.0
 */
object TimeUtils {


    @SuppressLint("SimpleDateFormat")
    fun getDuration(duration: Long): String {

        val formatter = SimpleDateFormat("m:ss")
        return formatter.format(Date(duration * 1000))
    }

    @SuppressLint("SimpleDateFormat")
    fun getMMDuration(duration: Long): String {

        val formatter = SimpleDateFormat("mm:ss")
        return formatter.format(Date(duration * 1000))
    }

    @SuppressLint("SimpleDateFormat")
    fun getStringDate(time: Long): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return formatter.format(Date(time))
    }

    @SuppressLint("SimpleDateFormat")
    fun getTime(time: Long): String {
        val formatter = SimpleDateFormat("MM-dd HH:mm")
        return formatter.format(Date(time))
    }

    @SuppressLint("SimpleDateFormat")
    fun getYearTime(time: Long): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        return formatter.format(Date(time))
    }

    @SuppressLint("SimpleDateFormat")
    fun getMdTime(time: Long): String {
        val formatter = SimpleDateFormat("MM-dd")
        return formatter.format(Date(time))
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDate(): String {
        val currentTime = System.currentTimeMillis()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return formatter.format(Date(currentTime))
    }

    @SuppressLint("SimpleDateFormat")
    fun formatTime(time: String): Long {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = formatter.parse(time)
        date?.let {
            return it.time / 1000
        }
        return 0
    }

    private fun isCurrentYear(time: Long): Boolean {

        val calendar = Calendar.getInstance()
        calendar.timeZone = TimeZone.getTimeZone("GMT+8:00")
        calendar.timeInMillis = time
        val year1 = calendar.get(Calendar.YEAR)
        calendar.timeInMillis = System.currentTimeMillis()
        val year2 = calendar.get(Calendar.YEAR)
        return year1 == year2
    }

    fun parseTime(startTime: Long): String {

        if (!isCurrentYear(startTime)) {//不是今年
            return getYearTime(startTime)
        } else {
            var timeLong = System.currentTimeMillis() - startTime
            Log.e("asdasdasdasdasdas", "timeLong: $timeLong")
            if (timeLong < 60 * 1000) {
                return "刚刚"
            } else if (timeLong < 60 * 60 * 1000) {
                timeLong = timeLong / 1000 / 60
                return timeLong.toString() + "分钟前"
            } else if (timeLong < 60 * 60 * 24 * 1000) {
                timeLong = timeLong / 60 / 60 / 1000
                return timeLong.toString() + "小时前"
            } else {
                return getMdTime(startTime)
            }
        }
    }
}