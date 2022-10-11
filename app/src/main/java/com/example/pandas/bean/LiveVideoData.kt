package com.example.pandas.bean

import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User

data class LiveVideoData(
    var visitors: MutableList<User> = mutableListOf(),
    var follows: MutableList<PetVideo> = mutableListOf(),
    var lives: MutableList<PetVideo> = mutableListOf()
)
