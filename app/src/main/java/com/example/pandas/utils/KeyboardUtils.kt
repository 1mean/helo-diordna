package com.example.pandas.utils

import android.app.Activity
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.util.*


object KeyboardUtils {
    /**
     * 自动弹软键盘
     *
     * @param context
     * @param et
     */
    fun showSoftInput(context: Context, et: EditText) {

        Timer().schedule(object : TimerTask() {
            override fun run() {
                (context as Activity).runOnUiThread {
                    et.isFocusable = true
                    et.isFocusableInTouchMode = true
                    //请求获得焦点
                    et.requestFocus()
                    //调用系统输入法
                    val inputManager = et
                        .context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.showSoftInput(et, 0)
                }
            }
        }, 200)
    }

    /**
     * 自动关闭软键盘
     * @param activity
     */
    fun closeKeybord(activity: Activity) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(activity.window.decorView.windowToken, 0)
    }

    /**
     * 打开关闭相互切换
     * @param activity
     */
    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive) {
            activity.currentFocus?.let {
                imm.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
    }

    /**
     * 点击EditText以外的区域，关闭软键盘
     */
    fun isShouldHideKeyboard(v: View?, event: MotionEvent): Boolean {

        v?.let { view ->
            if (view is EditText) {
                val l = intArrayOf(0, 0)
                view.getLocationInWindow(l)
                val left = l[0]
                val top = l[1]
                val bottom = top + view.getHeight()
                val right = left + view.getWidth()
                // 点击EditText的事件，忽略它
                return !(event.x > left && event.x < right
                        && event.y > top && event.y < bottom)
            }
        }
        //如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false
    }
}