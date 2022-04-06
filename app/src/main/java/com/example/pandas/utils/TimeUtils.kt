package com.example.pandas.utils

import android.annotation.SuppressLint
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
    fun getCurrentDate(): String {
        val currentTime = System.currentTimeMillis()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return formatter.format(Date(currentTime))
    }

}