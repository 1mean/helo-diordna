package com.example.pandas.utils

import java.math.RoundingMode
import java.text.DecimalFormat

object NumUtils {

    private val th = 1 * 10 * 1000

    fun getShortNum(input: Int): String {

        if (input >= th) {
            val num = (input.toDouble() / th)
            val outPut = getNoMoreThanTwoDigits(num)
            return StringBuffer(outPut).append("万").toString()
        } else {
            return input.toString()
        }
    }

    /**
     * 对入参保留最多一位小数(舍弃末尾的0)，如:
     * 3.345->3.3
     * 3.40->3.4
     * 3.0->3
     */
    fun getNoMoreThanTwoDigits(number: Double): String {
        val format = DecimalFormat("0.#")
        //未保留小数的舍弃规则，RoundingMode.FLOOR表示直接舍弃。
        format.roundingMode = RoundingMode.FLOOR
        return format.format(number)
    }
}