package com.example.pandas.sql.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music")
data class MusicVo(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
    @ColumnInfo
    var fileName: String? = null,//实际存储的文件名
    @ColumnInfo
    var audioName: String? = null,//歌曲名
    @ColumnInfo
    var url: String? = null,//mp3文件网络路径
    @ColumnInfo
    var singerName: String? = null,//歌手名
    @ColumnInfo
    var cover: String? = null,//歌曲封面
    //var duration: String? = null,//歌曲时长
    @ColumnInfo
    var isLike: Boolean = false,//是否喜欢
    @ColumnInfo
    var type: Int = 0,//歌曲类型，0为普通歌曲，1为相声音频
    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null//预留string字段

)
