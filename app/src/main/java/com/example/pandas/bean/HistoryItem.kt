package com.example.pandas.bean

import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.History
import com.example.pandas.sql.entity.User

/**
 * 历史记录
 */
data class HistoryItem(
    val history: History? = null,
    val video: PetViewData? = null,
    val user: User? = null,
    var selected: Boolean = false

)
