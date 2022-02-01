package com.example.pandas.sql.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music")
data class MusicVo(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,//id
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
    var isLike: Boolean = false//是否喜欢

)
