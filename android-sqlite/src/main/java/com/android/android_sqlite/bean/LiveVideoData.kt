package com.android.android_sqlite.bean

import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.User

data class LiveVideoData(
    var visitors: MutableList<User> = mutableListOf(),
    var follows: MutableList<PetVideo> = mutableListOf(),
    var lives: MutableList<PetVideo> = mutableListOf()
)
