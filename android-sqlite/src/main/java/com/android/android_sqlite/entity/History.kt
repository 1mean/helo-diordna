package com.android.android_sqlite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * @description: 历史记录
 * @author: dongyiming
 * @date: 3/10/22 10:08 下午
 * @version: v1.0
 */
@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var code: Int = 0,//视频ID
    @ColumnInfo
    var lastTime: Long = 0,//退出播放的时间
    @ColumnInfo
    var playPosition: String? = null,//播放进度
    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段
)
