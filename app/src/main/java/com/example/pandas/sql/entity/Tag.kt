package com.example.pandas.sql.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tag(

    //切记不能用类似 isXxx 的字段，会造成无法自动生成字段的set方法

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var videoCode: Int = 0,//groupId
    @ColumnInfo
    var hehua: Boolean = false,//和花
    @ColumnInfo
    var heye: Boolean = false,//和叶
    @ColumnInfo
    var yuanrun: Boolean = false,//和花
    @ColumnInfo
    var aijiu: Boolean = false,//和花

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段

) : Parcelable
