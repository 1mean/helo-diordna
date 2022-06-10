package com.example.pandas.bean

import androidx.room.Embedded
import androidx.room.Relation
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment

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
