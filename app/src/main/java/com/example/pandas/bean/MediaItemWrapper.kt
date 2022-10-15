package com.example.pandas.bean

import com.google.android.exoplayer2.MediaItem

data class MediaItemWrapper(

    var playPosition: Long = 0,
    var mediaItem: MediaItem? = null
)
