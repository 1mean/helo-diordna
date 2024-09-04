package com.android.base.utils

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.util.Log

/**
 * <TextView设置不同颜色>
 *
 * @author: dongyiming
 * @date: 7/20/22 10:45 下午
 * @version: v1.0
 */
object StringColorUtil {

    private val spBuilder: SpannableStringBuilder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { SpannableStringBuilder() }

    /**
     * <单个关键字>
     *     设置在wholeStr中第一次出现的keyStr的颜色
     *     - wholeStr  全部文字
     *     - keyStr  关键字
     *     - keyStrColor 关键字的颜色
     *
     *      BUG:多个界面使用这个方法时，切到新的viewpager界面后，出现全部都是上一个界面的最后一个SpannableStringBuilder的内容
     *
     * @author: dongyiming
     * @date: 7/20/22 10:13 下午
     * @version: v1.0
     */
    fun fillColor(wholeStr: String, keyStr: String, keyStrColor: Int): SpannableStringBuilder {

        if (!TextUtils.isEmpty(wholeStr)
            && !TextUtils.isEmpty(keyStr)
            && wholeStr.contains(keyStr)
        ) {
            Log.e("SearchListFragment", "wholeStr: $wholeStr")
            val start = wholeStr.indexOf(keyStr)
            val end = start + keyStr.length

            val foregroundColorSpan = ForegroundColorSpan(keyStrColor)
            spBuilder.run {
                clear()
                clearSpans()
                append(wholeStr)
                setSpan(foregroundColorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
        }
        return spBuilder
    }

    fun fillColor2(
        sb: SpannableStringBuilder,
        wholeStr: String,
        keyStr: String,
        keyStrColor: Int
    ): String {
        if (!TextUtils.isEmpty(wholeStr)
            && !TextUtils.isEmpty(keyStr)
            && wholeStr.contains(keyStr)
        ) {
            Log.e("SearchListFragment", "wholeStr: $wholeStr")
            val start = wholeStr.indexOf(keyStr)
            val end = start + keyStr.length
            val foregroundColorSpan = ForegroundColorSpan(keyStrColor)
            sb.run {
                clear()
                clearSpans()
                append(wholeStr)
                setSpan(foregroundColorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
        }
        return sb.toString()
    }

    /**
     * <多个关键字>
     *     设置在wholeStr中第一次出现的keyStr的颜色
     *     - wholeStr  全部文字
     *     - keyStrMap key:关键字Value:颜色
     * @author: dongyiming
     * @date: 7/20/22 10:13 下午
     * @version: v1.0
     */
    fun fillColorByStr(wholeStr: String, keyStrMap: HashMap<*, *>): SpannableStringBuilder {
        if (!TextUtils.isEmpty(wholeStr)) {
            spBuilder.append(wholeStr)
            val keySet: Set<*> = keyStrMap.keys //将Map中所有的键存入到set集合中
            for (keyStr in keySet) {
                if (!TextUtils.isEmpty(keyStr as String) && wholeStr.contains(keyStr)) {

                    val charaStyle: CharacterStyle =
                        ForegroundColorSpan((keyStrMap[keyStr] as Int?)!!)
                    val start = wholeStr.indexOf(keyStr.toString())
                    val end = start + keyStr.toString().length
                    spBuilder.setSpan(charaStyle, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }
        return spBuilder
    }

    /**
     * <多个关键字>
     *     设置指定位置的keyStr的颜色
     *     - wholeStr  全部文字
     *     - keyStringInfos 关键字的一些信息(起始位置，结束位置，颜色值)
     * @author: dongyiming
     * @date: 7/20/22 10:13 下午
     * @version: v1.0
     */
    fun fillColorByIndex(wholeStr: String, keyStringInfos: List<*>): SpannableStringBuilder {
        if (!TextUtils.isEmpty(wholeStr)) {
            spBuilder.append(wholeStr)
            for (keyStringInfo in keyStringInfos) {
                val start = (keyStringInfo as KeyStringInfo).start
                val end = keyStringInfo.end
                if (start >= 0 && end < wholeStr.length && start <= end) {
                    val charaStyle: CharacterStyle = ForegroundColorSpan(
                        keyStringInfo.color
                    )
                    spBuilder.setSpan(charaStyle, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }
        return spBuilder
    }


    data class KeyStringInfo(//起始位置，结束位置，颜色值
        var start: Int, var end: Int, var color: Int
    )
}