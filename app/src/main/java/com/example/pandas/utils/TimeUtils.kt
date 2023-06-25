package com.example.pandas.utils

import android.annotation.SuppressLint
import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * @description: 本项目用到的时间格式转换方法
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
    fun getStringDate2(time: Long): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return formatter.format(Date(time))
    }

    @SuppressLint("SimpleDateFormat")
    fun getStringDate3(time: Long): String {
        val formatter = SimpleDateFormat("yyyy年MM月dd日 HH:mm")
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

    fun parseTime(time: Long): String {
        val startTime = time
        if (!isCurrentYear(time)) {//不是今年
            return getYearTime(startTime)
        } else {
            var timeLong = System.currentTimeMillis() - startTime
            if (timeLong < 60 * 1000) {
                return "刚刚"
            } else if (timeLong < 60 * 60 * 1000) {
                timeLong = timeLong / 1000 / 60
                return timeLong.toString() + "分钟前"
            } else if (timeLong < 60 * 60 * 24 * 1000) {
                timeLong = timeLong / 60 / 60 / 1000
                return timeLong.toString() + "小时前"
            } else {
                return getMdTime(time)
            }
        }
    }

    fun isYesterday(time: Long): Boolean {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = -24 //用小时来判断，不能用day来判断，会出现6月1号前一天是5月30号
        val yesterdayDate: String = dateFormat.format(calendar.time)
        return true
    }

    /**
     * 将传入时间值转换成符合项目要求的描述性时间，总共有以下几种格式的要求
     *  - 刚刚 60秒内
     *  - 30分钟前
     *  - 2小时前
     *  - 昨天 09:21
     *  - 一天前
     *  - 两天前
     *  - 12月24
     *  - 2018年12月17
     *
     * @param: 时间戳：秒/毫秒 已做处理，10位和13位数字
     * @return: 仿抖音描述性时间
     * @author: dongyiming
     * @date: 12/23/22 5:54 PM
     * @version: v1.0
     */
    fun descriptiveData(parseTime: Long): String? {
        val inputTime = if (parseTime.toString().length == 10) {
            parseTime * 1000
        } else {
            parseTime
        }
        val descriptiveText: String?
        var format = ""
        //当前时间
        val currentTime = Calendar.getInstance()
        //要转换的时间
        val time = Calendar.getInstance()
        time.timeInMillis = inputTime
        //年相同
        if (currentTime[Calendar.YEAR] == time[Calendar.YEAR]) {
            //获取一年中的第几天并相减，取差值
            when (currentTime[Calendar.DAY_OF_YEAR] - time[Calendar.DAY_OF_YEAR]) {
                3 -> {
                    descriptiveText = "2天前"
                }
                2 -> {
                    descriptiveText = "1天前"
                }
                1 -> {
                    format = "HH:mm"
                    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
                    val formatDate = simpleDateFormat.format(time.time)
                    descriptiveText = "昨天$formatDate"
                }
                0 -> {
                    var timeDis = System.currentTimeMillis() - inputTime
                    if (timeDis < 60 * 1000) {
                        descriptiveText = "刚刚"
                    } else if (timeDis < 60 * 60 * 1000) {
                        timeDis = timeDis / 1000 / 60
                        descriptiveText = "${timeDis}分钟前"
                    } else {
                        timeDis = timeDis / 60 / 60 / 1000
                        descriptiveText = "${timeDis}小时前"
                    }
                }
                else -> {
                    format = "MM-dd"
                    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
                    descriptiveText = simpleDateFormat.format(time.time)
                }
            }
        } else {
            format = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
            descriptiveText = simpleDateFormat.format(time.time)
        }
        return descriptiveText
    }

}