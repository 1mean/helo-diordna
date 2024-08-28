package com.android.android_sqlite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "group_item")
data class GroupVideoItem(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var groupCode:Int = 0,//所属群组id
    @ColumnInfo
    var videoCode:Int = 0,//当前视频id

    //TODO:添加时间和更新时间
    @Ignore
    var createTime:Long = 0,
    @Ignore
    var updateTime:Long = 0,

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段
)
