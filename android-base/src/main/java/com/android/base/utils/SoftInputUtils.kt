package com.android.base.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.util.*


/**
 * 软键盘，源代码可以查看 [TextView ## onTouchEvent()] 方法
 *
 * * * if (touchIsFinished && (isTextEditable() || textIsSelectable)) {
 * * *       // Show the IME, except when selecting in read-only text.
 * * *      final InputMethodManager imm = getInputMethodManager();
 * * *      viewClicked(imm);
 * * *      if (isTextEditable() && mEditor.mShowSoftInputOnFocus && imm != null) {
 * * *           imm.showSoftInput(this, 0);
 * * *      }
 * * *
 * * *      // The above condition ensures that the mEditor is not null
 * * *      mEditor.onTouchUpEvent(event);
 * * *      handled = true;
 * * * }
 * * * return handled;
 * * *
 * 相关知识点
 * - 软键盘也是dialog，软键盘弹出时，有两个window，分别是Activity和软键盘Dialog
 * - 软键盘的模式：WindowManager.LayoutParams.softInputMode，
 *     - SOFT_INPUT_ADJUST_UNSPECIFIED：不指定调整方式，系统自行决定使用哪种调整方式
 *         - 布局被顶上去
 *     - SOFT_INPUT_ADJUST_RESIZE：调整方式为布局需要重新计算大小适配当前可见区域
 *         - 已废弃。使用 window.setDecorFitsSystemWindows(true) 布局没变化
 *     - SOFT_INPUT_ADJUST_PAN：调整方式为布局需要整体移动
 *         - 布局被顶上去
 *     - SOFT_INPUT_ADJUST_NOTHING：不做任何操作
 *         - 布局没变化 当键盘弹出时，任何View都不需要顶上去，可以设置这个属性
 *     - SOFT_INPUT_STATE_HIDDEN：softInputMode可见状态，当切换至当前window时，在正常情况下隐藏任何软键盘区域
 *     - SOFT_INPUT_STATE_ALWAYS_HIDDEN：softInputMode可见状态，当当前window接收到focus焦点时，始终隐藏任何软键盘区域
 *     - SOFT_INPUT_STATE_VISIBLE：softInputMode可见状态，请在正常情况下(当用户导航到您的窗口时)显示软键盘区域
 *     - SOFT_INPUT_STATE_ALWAYS_VISIBLE：可见状态，当此窗口接收输入焦点时，请始终使软输入区域可见
 *
 * - 软键盘弹出时，会遮挡住部分内容区域，通过可见区域数据 [outRect] 可以得到被遮挡的区域，即偏移量
 *     - 偏移量 = 屏幕长度-可见长度
 *
 * 当app的窗口(即页面)的Focus状态发生变化，如进入一个新页面，这个窗口的focus状态从上一个页面的false变成true时，事件会经过一系列的回调，并通过WindowManagerService对窗口进行相应管理
 *
 *
 *
 *
 * @description: 软键盘工具类和相关知识
 * @author: dongyiming
 * @date: 5/31/22 1:16 上午
 * @version: v1.0
 */
object SoftInputUtils {

    fun getNavigationBarHeight(context: Context): Int {
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

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

    fun showKeyBoard(view: View?) {

        if (view == null) {
            return
        }
        val km = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        km.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    fun showSoftInput(view: View?) {
        if (view == null) {
            return
        }
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            ?: return
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.requestFocus()
//        imm.showSoftInput(view, 0, SoftInputReceiver(view.context))
        imm.showSoftInput(view, 0)
        imm.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
//            InputMethodManager.SHOW_IMPLICIT
        )
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

    fun hideSoftInput(view: View?) {
        if (view == null) {
            return
        }
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive) {
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
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