package com.android.base.utils

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * <KeyboardUtils>
 * @author: dongyiming
 * @date: 7/31/24 12:41 PM
 * @version: v1.0
 */
object KeyboardUtils {

    private var sDecorViewDelta = 0

    fun showSoftInput(context: Context) {
        val imm =
            context.applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * Hide the soft input.
     *
     * @param activity The activity.
     */
    fun hideSoftInput(activity: Activity) {
        hideSoftInput(activity.window)
    }

    /**
     * Hide the soft input.
     *
     * @param window The window.
     */
    fun hideSoftInput(window: Window) {
        var view = window.currentFocus
        if (view == null) {
            val decorView = window.decorView
            val focusView = decorView.findViewWithTag<View>("keyboardTagView")
            if (focusView == null) {
                view = EditText(window.context)
                view.setTag("keyboardTagView")
                (decorView as ViewGroup).addView(view, 0, 0)
            } else {
                view = focusView
            }
            view.requestFocus()
        }
        hideSoftInput(view)
    }

    /**
     * Hide the soft input.
     *
     * @param view The view.
     */
    fun hideSoftInput(view: View) {
        val imm =
            view.context.applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * Return whether soft input is visible.
     *
     * @param activity The activity.
     * @return `true`: yes<br></br>`false`: no
     */
    fun isSoftInputVisible(activity: Activity): Boolean {
        return getDecorViewInvisibleHeight(activity.window) > 0
    }

    private fun getDecorViewInvisibleHeight(window: Window): Int {
        val decorView = window.decorView
        val outRect = Rect()
        decorView.getWindowVisibleDisplayFrame(outRect)
        Log.d(
            "KeyboardUtils", "getDecorViewInvisibleHeight: "
                    + (decorView.bottom - outRect.bottom)
        )
        val delta = Math.abs(decorView.bottom - outRect.bottom)
        if (delta <= BarUtils.getNavBarHeight(window.context) + BarUtils.getStatusBarHeight(window.context)) {
            sDecorViewDelta = delta
            return 0
        }
        return delta - sDecorViewDelta
    }
}