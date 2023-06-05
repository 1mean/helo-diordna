package com.example.pandas.ui.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

/**
 * @description: 处理ViewPager+水平RecyclerView滑动冲突
 * @author: dongyiming
 * @date: 10/17/22 1:59 上午
 * @version: v1.0
 */
public class MyVerticalRecyclerView : RecyclerView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var startX = 0
    private var startY = 0
    private var endX = 0
    private var endY = 0
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = ev.x.toInt()
                startY = ev.y.toInt()
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                endX = ev.x.toInt()
                endY = ev.y.toInt()
                val disX = abs(endX - startX)
                val disY = abs(endY - startY)

                if (disX > disY) {
                    //如果是横向滑动，告知父布局不进行事件拦截，交由子布局消费，　requestDisallowInterceptTouchEvent(true)
                    parent.requestDisallowInterceptTouchEvent(false)
                } else {
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}