package com.android.base.utils

import android.content.Context

/**
 * <BarUtils>
 * @author: dongyiming
 * @date: 7/31/24 1:01 PM
 * @version: v1.0
 */
object BarUtils {

    ///////////////////////////////////////////////////////////////////////////
    // navigation bar
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Return the navigation bar's height.
     *
     * @return the navigation bar's height
     */
    fun getNavBarHeight(context: Context): Int {
        val res = context.applicationContext.resources
        val resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId != 0) {
            res.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }

    /**
     * Return the status bar's height.
     *
     * @return the status bar's height
     */
    fun getStatusBarHeight(context: Context): Int {
        val resources = context.applicationContext.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }
}