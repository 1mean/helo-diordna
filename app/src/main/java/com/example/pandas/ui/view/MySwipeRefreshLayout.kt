package com.example.pandas.ui.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.math.abs

/**
 * @description: 解决滑动冲突
 *     - 1，SwipeRefreshLayout和Tablayout的左右滑动冲突
 *     - 2，SwipeRefreshLayout上下滑动的问题
 * @author: dongyiming
 * @date: 1/27/22 2:12 下午
 * @version: v1.0
 */
public class MySwipeRefreshLayout : SwipeRefreshLayout {

    private var startX = 0f
    private var startY = 0f
    private var lastX = 0f
    private var lastY = 0f

    private val mTouchSlop = 300 //避免很容易就触发了下拉刷新

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
                val distanceX: Float = abs(lastX - startX)
                val distanceY: Float = abs(lastY - startY)
                if (abs(distanceX) > abs(distanceY)) {
                    return false
                } /*else if (abs(distanceY) < mTouchSlop) {
                    return false
                }*/ else{
                    //bug:
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        Log.e("1mean","onInterceptTouchEvent: ${super.onInterceptTouchEvent(event)}")
        return super.onInterceptTouchEvent(event)
    }
}