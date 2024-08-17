package com.android.android_sqlite.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * groupItem and video
 * @author: dongyiming
 * @date: 6/27/22 3:21 下午
 * @version: v1.0
 */
data class GroupItemAndVideo(

    @Embedded
    val groupItem: GroupVideoItem,
    @Relation(parentColumn = "videoCode", entityColumn = "code")
    val video: PetVideo
)
