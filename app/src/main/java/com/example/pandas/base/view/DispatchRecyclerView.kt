package com.example.pandas.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_DOWN) {
            startX = ev.x
            startY = ev.y
            lastX = ev.x
            lastY = ev.y
            //子View的所有父ViewGroup都会跳过onInterceptTouchEvent的回调,放行
            parent.requestDisallowInterceptTouchEvent(true)
        } else if (ev.action == MotionEvent.ACTION_DOWN) {

            lastX = ev.x
            lastY = ev.y
            val distanceX: Float = Math.abs(lastX - startX)
            val distanceY: Float = Math.abs(lastY - startY)
            val manager = layoutManager as LinearLayoutManager
            val disallowIntercept =
                if (manager.orientation == HORIZONTAL) {
                    distanceX > distanceY
                } else {
                    distanceY > scaledTouchSlop && distanceY > distanceX
                }
            parent.requestDisallowInterceptTouchEvent(!disallowIntercept)
        }
        return super.dispatchTouchEvent(ev)
    }
}