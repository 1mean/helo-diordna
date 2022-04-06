package com.example.pandas.sql

/**
 * @description: 数据库操作类
 * @author: dongyiming
 * @date: 2022/1/11 2:36 下午
 * @version: v1.0
 */
public class SqliteHelper private constructor() {

    companion object {
        @Volatile
        private var instance: SqliteHelper? = null

        @JvmStatic
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: SqliteHelper()
                    .also { instance = it }
            }
    }
}