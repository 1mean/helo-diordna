package com.example.pandas.bean

import com.example.pandas.sql.entity.PetVideo

data class VideoInfo(
    val videoInfo: PetVideo,
    val recoVideos: MutableList<PetVideo>
)
