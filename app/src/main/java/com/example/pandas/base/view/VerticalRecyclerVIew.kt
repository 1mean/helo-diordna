package com.example.pandas.base.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/2/22 7:05 下午
 * @version: v1.0
 */
public class VerticalRecyclerVIew : RecyclerView {

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

        parent.requestDisallowInterceptTouchEvent(false)
        return super.dispatchTouchEvent(ev)
//        if (ev.action == MotionEvent.ACTION_DOWN) {
//            startX = ev.x
//            startY = ev.y
//            lastX = ev.x
//            lastY = ev.y
//            //子View的所有父ViewGroup都会跳过onInterceptTouchEvent的回调,放行
//            parent.requestDisallowInterceptTouchEvent(true)
//        } else if (ev.action == MotionEvent.ACTION_MOVE) {
//
//            lastX = ev.x
//            lastY = ev.y
//            val distanceX: Float = abs(lastX - startX)
//            val distanceY: Float = abs(lastY - startY)
//            val manager = layoutManager as LinearLayoutManager
//            Log.e("1mean", "disY: " + (lastY - startY) + ",,manager.findFirstVisibleItemPosition() = " + manager.findFirstVisibleItemPosition())
//            if (manager.findFirstVisibleItemPosition() == 0 ) {
//                parent.requestDisallowInterceptTouchEvent(false)
//            } else if (manager.findFirstVisibleItemPosition() == childCount - 1 && (lastY - startY) < 0) {
//                parent.requestDisallowInterceptTouchEvent(false)
//            } else {
//                parent.requestDisallowInterceptTouchEvent(true)
//            }
//            val disallowIntercept =
//                if (manager.orientation == HORIZONTAL) {
//                    distanceX > distanceY
//                } else {
//                    distanceY > scaledTouchSlop && distanceY > distanceX
//                }
//            Log.e("1mean", "disallowIntercept: $disallowIntercept")
//            parent.requestDisallowInterceptTouchEvent(disallowIntercept)
//        }

    }
}