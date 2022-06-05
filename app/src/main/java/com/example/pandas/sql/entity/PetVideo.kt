package com.example.pandas.sql.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * video的基本信息
 * @author: dongyiming
 * @date: 11/6/21 9:28 下午
 * @version: v1.0
 */
@Entity(tableName = "pet_video")
data class PetVideo(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var code: Int = 0,//视频ID
    @ColumnInfo
    var fileName: String? = null,//file name
    @ColumnInfo
    var title: String? = null,//视频标题
    @ColumnInfo
    var description: String? = null,//视频描述
    @ColumnInfo
    var url: String? = null,//视频网络路径
    @ColumnInfo
    var originalUrl: String? = null,//视频原始转载地址，标注一下
    @ColumnInfo
    var tags: String? = null,//标签，用于分类
    @ColumnInfo
    var releaseTime: String? = null,//视频的发布时间
    @ColumnInfo
    var duration: Int = 0,//视频时长
    @ColumnInfo
    var cover: String? = null,//封面路径
    @ColumnInfo
    var type: Int = 0,//动物类型
    @ColumnInfo
    var authorId: Int = 0,//发布者唯一id
    @ColumnInfo
    var period: Int = 0,//对应PetType
    @ColumnInfo
    var isStar: Boolean = false,//视频分类（普通+精彩），不归属到counts表
    @ColumnInfo
    var isHot: Boolean = false,//热门视频
    //视频展示类型 0为普通视频，1为轮播图视频，2为横屏视频  3为cutepet页面轮播图
    @ColumnInfo
    var videoType: Int = 0,
    @Ignore
    var user: User? = null,
    @Ignore
    var videoData: VideoData? = null,

    @Ignore
    var isPlaying: Boolean = false,  //是否正在播放中，用于状态标识

    @Ignore
    //是否标记为核心最可爱的视频
    var hasFlag: Boolean = false,
    @Ignore
    //是否是竖屏视屏
    var isVertical: Boolean = false
)
