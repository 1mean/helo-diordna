package com.android.android_sqlite.bean

import com.android.android_sqlite.entity.PetVideo

data class VideoInfo(
    val videoInfo: PetVideo,
    val recoVideos: MutableList<PetVideo>
)
