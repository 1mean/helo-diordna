package com.example.pandas.biz.pictureselector

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

object ImageLoaderUtils {

    fun assertValidRequest(context: Context?): Boolean {

        if (context is Activity) {
            val activity = (context as Activity)
            return !(activity.isFinishing || activity.isDestroyed)
        } else if (context is ContextWrapper) {
            val contextWrapper = context as ContextWrapper
            if (contextWrapper.baseContext is Activity) {
                val activity = contextWrapper.baseContext as Activity
                return !(activity.isFinishing || activity.isDestroyed)
            }
        }
        return true
    }
}