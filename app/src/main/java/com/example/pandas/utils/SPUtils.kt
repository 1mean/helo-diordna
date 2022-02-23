package com.example.pandas.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * @author: dongyiming
 * @date: 2/21/22 10:45 下午
 * @version: v1.0
 */
object SPUtils {

    private val SP_NAME = "Pandas"
    private var sp: SharedPreferences? = null

    private fun getInstanse(context: Context): SharedPreferences {

        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, MODE_PRIVATE)
        }
        return sp!!
    }

    fun getString(context: Context, key: String): String {

        return getInstanse(context).getString(key, "").toString()
    }

    @SuppressLint("CommitPrefEdits")
    fun putString(context: Context, key: String, value: String) {

        val editor = getInstanse(context).edit()
        editor.putString(key, value).apply()
    }

    /**
     * 存储历史记录数据
     */
    @SuppressLint("CommitPrefEdits")
    fun putSearchList(context: Context, key: String, value: String) {

        val str = getInstanse(context).getString(key, "").toString()
        val editor = getInstanse(context).edit()
        if (str.isEmpty()) {
            editor.putString(key, value).apply()
        } else {
            val list = str.split(",")
            val isIn = list.contains(value)
            if (isIn) {//历史记录中已经包含该一条记录，删除已存，加入到最新
                if (list.size == 1) {//只有这一条数据
                    return
                }
                //删除重复的数据
                val builder = StringBuilder()
                list.filterNot {
                    it == value
                }.forEach {
                    builder.append(it).append(",")
                }
                val newStr = builder.append(value).toString()
                editor.putString(key, newStr).apply()
            } else {//不包含，直接加入
                val builder = StringBuilder(str)
                val newStr = builder.append(",").append(value).toString()
                editor.putString(key, newStr).apply()
            }
        }
    }

    @SuppressLint("CommitPrefEdits")
    fun clearKey(context: Context, key: String) {
        getInstanse(context).edit().putString(key, "").apply()
    }
}