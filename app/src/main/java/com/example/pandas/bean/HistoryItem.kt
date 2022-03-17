package com.example.pandas.bean

import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.History

/**
 * 历史记录
 */
data class HistoryItem(
    val history: History? = null,
    val video: PetViewData? = null
)
