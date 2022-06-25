package com.example.pandas.ui.ext;

import com.example.pandas.sql.entity.PeriodType


fun getHomePandaDesc(period:Int,title:String):String{

    PeriodType.values().forEach {
        if (it.ordinal == period) {
            return it.value
        }
    }
    return ""
}