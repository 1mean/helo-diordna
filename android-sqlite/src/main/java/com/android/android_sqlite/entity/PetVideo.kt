package com.android.android_sqlite.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * video的基本信息
 * @author: dongyiming
 * @date: 11/6/21 9:28 下午
 * @version: v1.0
 */
@Parcelize
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
    var releaseTime: Long = 0,//视频的发布时间
    @ColumnInfo
    var duration: Int = 0,//视频时长
    @ColumnInfo
    var cover: String? = null,//封面路径
    @ColumnInfo
    var type: Int = 0,//视频的内容的类型 对应 ${VideoType}
    @ColumnInfo
    var authorId: Int = 0,//发布者唯一id
    @ColumnInfo
    var period: Int = 0,//对应PetType
    @ColumnInfo
    var star: Boolean = false,//视频分类（普通+精彩），不归属到counts表
    @ColumnInfo
    var hot: Boolean = false,//热门视频
    //视频展示类型 0为普通视频，1为轮播图视频，2为横屏视频  3为cutepet页面轮播图
    @ColumnInfo
    var videoType: Int = 0,
    @ColumnInfo
    var vertical: Boolean = false, //是否是竖屏视屏
    @ColumnInfo
    var width: Int = 0, //宽
    @ColumnInfo
    var height: Int = 0, //长

    @ColumnInfo
    var reservedInt: Int = 0,//预留int字段
    @ColumnInfo
    var reservedString: String? = null,//预留string字段

    @Ignore
    var user: User? = null,
    @Ignore
    var videoData: VideoData? = null,


    @Ignore
    var booleanFlag: Boolean = false,//布尔型标记位，用于帮助解决数据状态的标识
    @Ignore
    var stateFlag: Int = 0,//Int类型标记，基本用于状态类的Int值
) : Parcelable
