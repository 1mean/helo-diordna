package com.example.pandas.ui.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewTreeObserver.OnPreDrawListener
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


/**
 * @description: NestedScrollableHost
 * @author: dongyiming
 * @date: 6/4/22 1:02 上午
 * @version: v1.0
 */
public class NestedScrollableHost : FrameLayout {

    private var parentViewPager: ViewPager2? = null
    private var touchSlop = 0
    private var initialX = 0f
    private var initialY = 0f

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
        viewTreeObserver.addOnPreDrawListener(object : OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                var v: View = parent as View
                while (v !is ViewPager2) {
                    v = v.parent as View
                }
                parentViewPager = v
                viewTreeObserver.removeOnPreDrawListener(this)
                return false
            }
        })
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        handleInterceptTouchEvent(ev)
        return super.onInterceptTouchEvent(ev)
    }

    private fun canChildScroll(orientation: Int, delta: Float): Boolean {
        val direction = (-delta).toInt()
        val child = getChildAt(0)
        if (orientation == 0) {
            return child.canScrollHorizontally(direction)
        } else if (orientation == 1) {
            return child.canScrollVertically(direction)
        } else {
            throw IllegalArgumentException()
        }
    }

    private fun handleInterceptTouchEvent(e: MotionEvent) {

        if (parentViewPager == null) return
        val orientation = parentViewPager!!.orientation
        // Early return if child can't scroll in same direction as parent
        if (!canChildScroll(orientation, -1f) && !canChildScroll(orientation, 1f)) {
            return
        }
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            initialX = e.x
            initialY = e.y
            parent.requestDisallowInterceptTouchEvent(true)
        } else if (e.action == MotionEvent.ACTION_MOVE) {
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
                if (isVpHorizontal == (scaledDy > scaledDx)) {
                    // Gesture is perpendicular, allow all parents to intercept
                    parent.requestDisallowInterceptTouchEvent(false)
                } else {
                    // Gesture is parallel, query child if movement in that direction is possible
                    val dxy = if (isVpHorizontal) dx else dy
                    if (canChildScroll(orientation, dxy)) {
                        // Child can scroll, disallow all parents to intercept
                        parent.requestDisallowInterceptTouchEvent(true)
                    } else {
                        // Child cannot scroll, allow all parents to intercept
                        parent.requestDisallowInterceptTouchEvent(false)
                    }
                }
            }
        }
    }
}