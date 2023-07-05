package com.example.pandas.ui.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * @description: 嵌套滑动冲突 banner与viewpager2
 * @author: dongyiming
 * @date: 6/29/22 11:12 下午
 * @version: v1.0
 */
public class BannerNestedScrollableHost : FrameLayout {

    private var parentViewPager: ViewPager2? = null
    private var touchSlop: Int = 0
    private var initialX: Float = 0f
    private var initialY: Float = 0f

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {

        touchSlop = ViewConfiguration.get(context).scaledTouchSlop
        viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                var v = parent
                while (v != null && v !is ViewPager2) {
                    v = v.parent
                }
                parentViewPager = v as ViewPager2

                viewTreeObserver.removeOnPreDrawListener(this)
                return false
            }
        })
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        handleInterceptTouchEvent(ev!!)
        return super.onInterceptTouchEvent(ev)
    }


    private fun canChildScroll(orientation: Int, delta: Float): Boolean {
        val direction = (-delta).toInt()
        val child = getChildAt(0)
        return when (orientation) {
            0 -> {
                child.canScrollHorizontally(direction)
            }
            1 -> {
                child.canScrollVertically(direction)
            }
            else -> {
                throw  IllegalArgumentException()
            }
        }
    }

    private fun handleInterceptTouchEvent(e: MotionEvent) {
        if (parentViewPager == null) return
        val orientation = parentViewPager!!.orientation

        // Early return if child can't scroll in same direction as parent
        if (!canChildScroll(orientation, -1f) && !canChildScroll(orientation, 1f)) {
            return
        }

        if (e.action == MotionEvent.ACTION_DOWN) {

            Log.e("1mean","host down 111")
            initialX = e.x
            initialY = e.y
            parent.requestDisallowInterceptTouchEvent(true)
        } else if (e.action == MotionEvent.ACTION_MOVE) {
            Log.e("1mean","host move 222")
            val dx = e.x - initialX
            val dy = e.y - initialY
            val isVpHorizontal = orientation == ViewPager2.ORIENTATION_HORIZONTAL

            // assuming ViewPager2 touch-slop is 2x touch-slop of child
            val scaledDx = if (isVpHorizontal) {
                abs(dx) * .5f
            } else {
                abs(dx) * 1f
            }
            val scaledDy = if (isVpHorizontal) {
                abs(dy) * 1f
            } else {
                abs(dy) * .5f
            }
            if (scaledDx > touchSlop || scaledDy > touchSlop) {

                if (isVpHorizontal == (scaledDy > scaledDx)) {//横屏viewpager，上下滑动，不拦截
                    parent.requestDisallowInterceptTouchEvent(false)
                } else {
                    // Gesture is parallel, query child if movement in that direction is possible
                    val canChildScroll = if (isVpHorizontal) {
                        canChildScroll(orientation, dx)
                    } else {
                        canChildScroll(orientation, dy)
                    }
                    //bug解决：水平方向的快速滑动，偶尔还是会canChildScroll触发一次false。导致滑动到其他页面，这里强制写死
                    if (canChildScroll) {
                        // Child can scroll, disallow all parents to intercept
                        parent.requestDisallowInterceptTouchEvent(true)
                    } else {
                        // Child cannot scroll, allow all parents to intercept
//                        parent.requestDisallowInterceptTouchEvent(false)
                        parent.requestDisallowInterceptTouchEvent(true)
                    }
                }
            }
        }
    }
}