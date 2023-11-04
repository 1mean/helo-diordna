package com.example.pandas.ui.view.popuwindow

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.FOCUSABLE
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.core.view.marginLeft
import com.example.pandas.R
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils


/**
 * @description: ShortBottoomPopuWindow
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class TimerPopuWindow(
    private val activity: Activity
) : PopupWindow() {

    init {
        val screenWidth = ScreenUtil.getScreenWidth(activity)
        val screenHeight = ScreenUtil.getScreenHeight(activity)
        width = (screenWidth * 0.93).toInt()
        height = (screenHeight * 0.43).toInt()
        Log.e("1mean", "width= $width , height= $height")

        val view = activity.layoutInflater.inflate(R.layout.window_timer, null)
        contentView = view

        setOnDismissListener {
            activity.window.run {
                attributes.alpha = 1.0f
                addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
        }
    }

    fun setBackDark(): TimerPopuWindow {
        //设置背景变暗
        activity.window.run {
            isFocusable = true
            attributes.alpha = 0.5f //代表透明程度，范围为0 - 1.0f
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        return this
    }

    fun onShow(view: View) {

        animationStyle = R.style.style_timer_animation
        isOutsideTouchable = true
//        showAtLocation(view, Gravity.BOTTOM, 0, 100)
        showAtLocation(view, Gravity.BOTTOM, 0, 50)
    }

    //bug:重写dismiss，解决一些问题
    override fun dismiss() {
//        val view = activity.currentFocus
//        if (view is AppCompatEditText) {
//            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//            if (activity.currentFocus != null) {
//                imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0);
//            }
//        }
        super.dismiss()
    }
}