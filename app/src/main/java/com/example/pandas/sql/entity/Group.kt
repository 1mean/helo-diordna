package com.example.pandas.sql.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "group_info")
data class Group(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var groupCode: Int = 0,//groupId
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
    var isOpen: Boolean = false,//群组内容是否公开展示
    @ColumnInfo
    var type: Int = 0,//群组类型，目前99为默认群组

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段

) : Parcelable
