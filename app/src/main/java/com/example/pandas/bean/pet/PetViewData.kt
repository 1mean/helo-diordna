package com.example.pandas.bean.pet

import androidx.room.ColumnInfo

data class PetViewData(

    var code: Int,
    var title: String,
    var duration: Int,
    var cover: String,
    var authorName: String
)
