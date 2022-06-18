package com.example.pandas.bean

import java.io.File

/**
 * 需要存储的资源信息
 * - videoCode：视频Id
 * - playUrl：播放网络url
 * - file:本地文件
 * - playPos：播放进度
 */
data class MediaInfo(
    var videoCode: Int = 0,
    var playUrl: String = "",
    var file: File,
    var playPos: Long = 0
)
