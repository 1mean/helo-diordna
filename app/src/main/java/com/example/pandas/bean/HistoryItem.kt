package com.example.pandas.bean

import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.History
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User

/**
 * 历史记录
 */
data class HistoryItem(
    val history: History? = null,
    val video: PetVideo? = null,
    var selected: Boolean = false,
    var title: String = "",
    var type: Int = 0, //1是title
)
