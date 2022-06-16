package com.example.pandas.biz.manager

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


/**
 * @description: 软键盘
 * @author: dongyiming
 * @date: 5/31/22 1:16 上午
 * @version: v1.0
 */
class KeyboardManager(private val activity: Activity) {

    //    private var rootView: View? = null //activity的根视图
    private var rootViewVisibleHeight: Int = 0//纪录根视图的显示高度
    private var onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener? = null

    private var km: InputMethodManager? = null

    private val listener = object : ViewTreeObserver.OnGlobalLayoutListener {

        override fun onGlobalLayout() {
            //获取当前根视图在屏幕上显示的大小
            val rect = Rect()
            activity.window.decorView.getWindowVisibleDisplayFrame(rect)
            //当前activity根视图的高度
            val visibleHeight = rect.height()
            if (rootViewVisibleHeight == 0) {
                rootViewVisibleHeight = visibleHeight
                return
            }

            //根视图显示高度没有变化，可以看作软键盘显示／隐藏状态没有改变
            if (rootViewVisibleHeight == visibleHeight) {
                return
            }

            //根视图显示高度变小超过200，可以看作软键盘显示了
            if (rootViewVisibleHeight - visibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null) {
                    onSoftKeyBoardChangeListener!!.keyBoardShow(rootViewVisibleHeight - visibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return
            }

            //根视图显示高度变大超过200，可以看作软键盘隐藏了
            if (visibleHeight - rootViewVisibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null) {
                    onSoftKeyBoardChangeListener!!.keyBoardHide(visibleHeight - rootViewVisibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return
            }
        }
    }

    init {
        //监听视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变
        activity.window.decorView.viewTreeObserver.addOnGlobalLayoutListener(listener)
    }

    fun setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener
    }

    interface OnSoftKeyBoardChangeListener {
        fun keyBoardShow(height: Int)

        fun keyBoardHide(height: Int)
    }

    /**
     * 显示软键盘
     */
    fun showKeyBoard(activity: Activity, view: View) {

        if (km == null) {
            km = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        }
        km?.showSoftInput(view, 0)
    }

    /**
     * 隐藏软键盘
     */
    fun hideKeyBoard(activity: Activity, view: View) {
        if (km == null) {
            km = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        }
        km?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * 隐藏软键盘
     */
    fun hideKeyBoard(activity: Activity) {
        if (km == null) {
            km = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        }
        if (km!!.isAcceptingText) {
            km!!.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun setupUI(activity: Activity, view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { v, _ ->
                hideKeyBoard(activity)
                false
            }
        }

        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setupUI(activity, innerView)
            }
        }
    }

    fun ondestory() {
        activity.window.decorView.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        km = null
    }

}