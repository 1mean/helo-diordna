package com.example.pandas.base.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * @description: 内部处理分发-只针对LinearLayoutManager，目前是viewpager(recyclerview(recyclerview)),最内层recyclerview内部消耗
 * @author: dongyiming
 * @date: 2/1/22 3:10 下午
 * @version: v1.0
 */
public class DispatchRecyclerView : RecyclerView {

    private var startX = 0f
    private var startY = 0f
    private var lastX = 0f
    private var lastY = 0f
    private var scaledTouchSlop: Int = 0

    constructor(context: Context) : this(context, null) {

        scaledTouchSlop = ViewConfiguration.get(context).scaledTouchSlop shr 1
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

/*    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_DOWN) {
            startX = ev.rawX
            startY = ev.rawY
            lastX = ev.rawX
            lastY = ev.rawY
            //子View的所有父ViewGroup都会跳过onInterceptTouchEvent的回调,放行
            parent.requestDisallowInterceptTouchEvent(true)
        } else if (ev.action == MotionEvent.ACTION_MOVE) {

            lastX = ev.rawX
            lastY = ev.rawY
            val distanceX: Float = abs(lastX - startX)
            val distanceY: Float = abs(lastY - startY)
            val manager = layoutManager as LinearLayoutManager
            val disallowIntercept =
                if (manager.orientation == HORIZONTAL) {
                    distanceX > scaledTouchSlop && distanceX > distanceY
                } else {
                    distanceY > scaledTouchSlop && distanceY > distanceX
                }
            Log.e("1mean", "disallowIntercept: $disallowIntercept")
            parent.requestDisallowInterceptTouchEvent(disallowIntercept)
        }
        return super.dispatchTouchEvent(ev)
    }*/

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {

        val action = ev.action
        if (action == MotionEvent.ACTION_DOWN) {
            startX = ev.rawX
            startY = ev.rawY
            lastX = ev.rawX
            lastY = ev.rawY
        } else if (action == MotionEvent.ACTION_MOVE) {
            lastX = ev.rawX
            lastY = ev.rawY
            val distanceX: Float = Math.abs(lastX - startX)
            val distanceY: Float = Math.abs(lastY - startY)
            val manager = layoutManager as LinearLayoutManager
            val disallowIntercept =
                if (manager.orientation == HORIZONTAL) {
                    distanceX > scaledTouchSlop && distanceX > distanceY
                } else {
                    distanceY > scaledTouchSlop && distanceY > distanceX
                }
            parent.requestDisallowInterceptTouchEvent(disallowIntercept)
        } else if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            return abs(lastX - startX) > scaledTouchSlop || abs(lastY - startY) > scaledTouchSlop
        }
        return super.onInterceptTouchEvent(ev)
    }
}