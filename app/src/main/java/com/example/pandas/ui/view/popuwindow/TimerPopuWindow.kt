package com.example.pandas.ui.view.popuwindow

import android.app.Activity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import com.android.base.utils.ScreenUtil
import com.example.pandas.R


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

        this.isFocusable = true

        val view = activity.layoutInflater.inflate(R.layout.window_timer, null)
        contentView = view

        setOnDismissListener {
            activity.window.run {
//                val lp = attributes
//                lp.alpha = 1.0f
////                clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
////                attributes = lp
//                attributes.alpha = 1.0f
//                //addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//                clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                setBgAlpha(1.0f)
            }
        }
    }

    fun setBackDark(): TimerPopuWindow {
        //设置背景变暗
//        activity.window.run {
//            attributes.alpha = 0.5f //代表透明程度，范围为0 - 1.0f
//            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//        }
        setBgAlpha(0.5f)
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

    /**
     * 设置背景透明度
     *
     * @param bgAlpha 透明度值
     */
    fun setBgAlpha(bgAlpha: Float) {
        val attributes = this.activity.window.attributes
        attributes.alpha = bgAlpha
        //alpha在0.0f和1.0f之间，1.0f完全不暗，0.0f全暗
        if (bgAlpha == 1.0f) {
            this.activity.window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        } else {
            this.activity.window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        this.activity.window.attributes = attributes
    }
}