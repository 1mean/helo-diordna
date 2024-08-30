package com.android.android_sqlite.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "group_info")
data class Group(

    //切记不能用类似 isXxx 的字段，会造成无法自动生成字段的set方法

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id作为区分群组，0为常规群组收藏，创建的新的群组一次累加
    @ColumnInfo
    var groupCode: Int = 0,
    @ColumnInfo
    var groupName: String? = null,//群组名
    @ColumnInfo
    var videoCounts: Int = 0,//组内视频个数
    @ColumnInfo
    var createTime: Long = 0,//群组创建的时间
    @ColumnInfo
    var updateTime: Long = 0,//群组更新的时间
    @ColumnInfo
    var creatorCode: Int = 0,//群组的创建者的userCode
    @ColumnInfo
    var groupCover: String? = null,//群组封面
    @ColumnInfo
    var groupDesc: String? = null,//群组描述
    @ColumnInfo
    var open: Boolean = false,//群组内容是否公开展示
    @ColumnInfo
    var type: Int = 0,

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段

) : Parcelable
