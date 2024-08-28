package com.android.android_sqlite.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "search_history")
data class SearchHistory(

    //切记不能用类似 isXxx 的字段，会造成无法自动生成字段的set方法
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var createTime: Long = 0,
    @ColumnInfo
    var updateTime: Long = 0,
    @ColumnInfo
    var type: Int = 0,//默认是项目的搜索记录，1：WanAndroid页面的搜索历史

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段

) : Parcelable
