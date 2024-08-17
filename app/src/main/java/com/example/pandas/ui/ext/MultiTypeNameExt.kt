package com.example.pandas.ui.ext;

import com.android.android_sqlite.bean.PeriodType


fun getHomePandaDesc(period:Int,title:String):String{

    PeriodType.values().forEach {
        if (it.ordinal == period) {
            return it.value
        }
    }
    return ""
}