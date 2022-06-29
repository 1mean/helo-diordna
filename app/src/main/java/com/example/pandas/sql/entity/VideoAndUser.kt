package com.example.pandas.sql.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * video and user
 * @author: dongyiming
 * @date: 6/27/22 3:21 下午
 * @version: v1.0
 */
data class VideoAndUser(

    @Embedded val video: PetVideo,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "userCode"
    )
    val user: User
)
