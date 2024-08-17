package com.android.android_sqlite.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var userCode: Int = 0,//code
    @ColumnInfo
    var userName: String? = null,//userName
    @ColumnInfo
    var sex: Int = 0,//男0女1,-1为保密
    @ColumnInfo
    var level: Int = 0,
    @ColumnInfo
    var vip: Int = 0,//1为会员
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
    var exp: Int = 0,//当前等级的经验值
    @ColumnInfo
    var coin: Int = 0,//硬币
    @ColumnInfo
    var attention: Boolean = false,//是否被关注
    @ColumnInfo
    var ipAddress: String? = null,//用户的ip地址

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段

    @Ignore
    var booleanFlag: Boolean = false

) : Parcelable
