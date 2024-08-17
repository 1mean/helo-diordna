package com.android.android_sqlite.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * comment and user
 */
data class CommentAndUser(

    @Embedded val comment: VideoComment,
    @Relation(
        parentColumn = "fromUserCode",
        entityColumn = "userCode"
    )
    val user: User
)
