package com.example.pandas.bean

import com.google.android.exoplayer2.MediaItem

/**
 * 需要存储的资源信息
 * - videoCode：视频Id
 * - playUrl：网络url/本地url
 * - playPos：播放进度
 */
data class MediaInfo(
    var videoCode: Int = 0,
    var playUrl: String = "",
    var playPos: Long = 0
)
