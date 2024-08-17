package com.android.android_sqlite.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * video and user
 * @author: dongyiming
 * @date: 6/27/22 3:21 下午
 * @version: v1.0
 */
data class VideoAndData(

    @Embedded
    val video: PetVideo,
    @Relation(parentColumn = "code", entityColumn = "videoCode")
    val videoData: VideoData?
)
