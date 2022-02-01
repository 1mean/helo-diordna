package com.example.pandas.sql.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pet_video")
data class PetVideo(

    @PrimaryKey(autoGenerate = false) //修改表中的code名为id，会报错
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
    var authorName: String? = null,//发布者信息
    @ColumnInfo
    var period: Int = 0,//对应PetType
    @ColumnInfo
    var isStar: Boolean = false,//明星熊猫
    @ColumnInfo
    var videoType: Int = 0,//视频展示类型 0为普通视频，1为轮播图视频，2为横屏视频  3为cutepet页面轮播图

)
