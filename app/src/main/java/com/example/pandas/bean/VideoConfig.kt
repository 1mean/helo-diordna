package com.example.pandas.bean

data class VideoConfig(
    var videoCode: Int = 0,
    var playUrl: String = "",
    var isPlaying: Boolean = false,
    var currentPosition: Long = 0
)
