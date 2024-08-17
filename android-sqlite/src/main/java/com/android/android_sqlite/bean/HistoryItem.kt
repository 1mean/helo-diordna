package com.android.android_sqlite.bean

import com.android.android_sqlite.entity.History
import com.android.android_sqlite.entity.PetVideo

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
