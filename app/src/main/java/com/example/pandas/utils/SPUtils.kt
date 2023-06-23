package com.example.pandas.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import com.example.pandas.app.AppInfos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author: dongyiming
 * @date: 2/21/22 10:45 下午
 * @version: v1.0
 */
object SPUtils {

    /**
     * 目录：/data/data/com.example.hello_diordna/shared_prefs/Pandas.xml
     */
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

    fun getInt(context: Context, key: String): Int {
        return getInstanse(context).getInt(key, 0)
    }

    @SuppressLint("CommitPrefEdits")
    fun putString(context: Context, key: String, value: String) {

        val editor = getInstanse(context).edit()
        editor.putString(key, value).apply()
    }

    fun putInt(context: Context, key: String, value: Int) {

        val editor = getInstanse(context).edit()
        editor.putInt(key, value).apply()
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

    /**
     * 获取存储的list集合，存储的json串
     *
     * key:514531996 会变成 5.14531996E8,这里value值使用string包裹起来,避免转换后出现错误
     * 如果按照List<Int>进行gson转换，会变成 5.14531996E8 然后存入xml
     */
    fun <T> getList(context: Context, key: String): MutableList<T> {

        val json = getInstanse(context).getString(key, "").toString()
        return if (json.isEmpty()) {
            mutableListOf<T>()
        } else {
            val type = object : TypeToken<MutableList<T>>() {
            }.type
            Gson().fromJson(json, type)
        }
    }

    /**
     * 获取存储的list集合
     */
    @SuppressLint("CommitPrefEdits")
    fun <T> saveList(context: Context, key: String, value: T) {

        val json = getList<T>(context, key)
        if (!json.contains(value)) {
            json.add(value)
            val gson = Gson().toJson(json)
            getInstanse(context).edit().putString(key, gson).apply()
        }
    }

    /**
     * 删除指定value
     */
    @SuppressLint("CommitPrefEdits")
    fun <T> removeFromList(context: Context, key: String, value: T) {

        val json = getList<T>(context, key)
        if (json.contains(value)) {
            json.remove(value)
            val gson = Gson().toJson(json)
            getInstanse(context).edit().putString(key, gson).apply()
        }
    }

    @SuppressLint("CommitPrefEdits")
    fun clearKey(context: Context, key: String) {
        getInstanse(context).edit().putString(key, "").apply()
    }

    fun isAttention(context: Context, id: Int): Boolean {

        val list = getList<String>(context, AppInfos.ATTENTION_KEY)
        if (list.isEmpty()) {
            return false
        } else {
            return list.contains(id.toString())
        }
    }
}