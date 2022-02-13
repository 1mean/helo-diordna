package com.example.pandas.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * @description: 释放焦点给内部嵌套控件
 * @author: dongyiming
 * @date: 1/27/22 2:12 下午
 * @version: v1.0
 */
public class MySwipeRefreshLayout : SwipeRefreshLayout {

    private var startX = 0f
    private var startY = 0f
    private var lastX = 0f
    private var lastY = 0f

    private val mTouchSlop = 300

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.rawX
                startY = event.rawY
                lastX = event.rawX
                lastY = event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                lastX = event.rawX
                lastY = event.rawY
                val distanceX: Float = Math.abs(lastX - startX)
                val distanceY: Float = Math.abs(lastY - startY)
                if (Math.abs(distanceX) > Math.abs(distanceY)) {
                    return false
                } else if (Math.abs(distanceY) < mTouchSlop) {
                    return false
                }
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return super.onInterceptTouchEvent(event)
    }
}