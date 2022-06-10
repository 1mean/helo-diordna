package com.example.pandas.sql.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @description: 视频数据
 * @author: dongyiming
 * @date: 5/6/22 9:15 下午
 * @version: v1.0
 */
@Entity(tableName = "video_data")
public data class VideoData(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var videoCode: Int = 0,//视频ID
    @ColumnInfo
    var isLike: Boolean = false,//是否点赞
    @ColumnInfo
    var isHate: Boolean = false,//是否不喜欢
    @ColumnInfo
    var isLove: Boolean = false,//是否喜欢
    @ColumnInfo
    var isCollect: Boolean = false,//是否收藏
    @ColumnInfo
    var isPay: Boolean = false,//是否投币
    @ColumnInfo
    var loves: Int = 0,//喜欢数
    @ColumnInfo
    var likes: Int = 0,//点赞数
    @ColumnInfo
    var shares: Int = 0,//分享数
    @ColumnInfo
    var collects: Int = 0,//收藏数
    @ColumnInfo
    var plays: Int = 0,//播放数
    @ColumnInfo
    var comments: Int = 0,//评论数
    @ColumnInfo
    var playPosition: Long = 0,//视频历史进度  改成Long
    @ColumnInfo
    var coins: Int = 0,//投币数
    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null//预留string字段
)