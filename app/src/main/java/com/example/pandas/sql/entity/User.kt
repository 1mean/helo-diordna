package com.example.pandas.sql.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var userCode: Int = 0,//code
    @ColumnInfo
    var userName: String? = null,//userName
    @ColumnInfo
    var sex: Int = 0,//男0女1
    @ColumnInfo
    var level: Int = 0,
    @ColumnInfo
    var isVip: Int = 0,//1为会员
    @ColumnInfo
    var headUrl: String? = null,//头像
    @ColumnInfo
    var topUrl: String? = null,//顶部头像
    @ColumnInfo
    var region: String? = null,//地区
    @ColumnInfo
    var videoCounts: Int = 0,//作品个数
    @ColumnInfo
    var signature: String? = null,//个性签名
    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null//预留string字段
)
