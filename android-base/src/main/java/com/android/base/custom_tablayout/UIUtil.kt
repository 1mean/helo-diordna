package com.android.base.custom_tablayout

import android.content.Context

/**
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/6/26.
 */
object UIUtil {

    fun dip2px(context: Context, dpValue: Double): Int {
        val density = context.resources.displayMetrics.density
        return (dpValue * density + 0.5).toInt()
    }

    fun getScreenWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }
}