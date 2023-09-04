package com.example.pandas.ui.view

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Interpolator
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/16 4:14 下午
 * @version: v1.0
 */
public class MyBehavior() : CoordinatorLayout.Behavior<View>() {

    private var sinceDirectionChange = 0
    //控件距离coordinatorLayout底部距离
    private val viewY = 0f
    ////动画是否在进行
    private val isAnimate = false

    //不添加构造方法会找不到类
    constructor(context: Context, attrs: AttributeSet) : this() {

    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {

        return super.onDependentViewChanged(parent, child, dependency)
    }

    /**
     * 当CoordinatorLayout 的直接或者非直接子View开始准备嵌套滑动的时候会调用
     * @param:
     * @version: v1.0
     */
    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        //是否是垂直滑动
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
    }

    /**
     * 当嵌套滑动的时候，target尝试滑动或者正在滑动的时候会调用
     * @param:
     * @version: v1.0
     */
    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        //根据滑动的距离显示和隐藏footer view
        if (dyConsumed > 0 && sinceDirectionChange < 0 || dyConsumed < 0 && sinceDirectionChange > 0) {
            child.animate().cancel()
            sinceDirectionChange = 0
        }
        sinceDirectionChange += dyConsumed
        val visibility = child.visibility
        if (sinceDirectionChange > child.height && visibility == View.VISIBLE) {
            hide(child)
        } else {
            if (sinceDirectionChange < 0 && (visibility == View.GONE || visibility == View
                    .INVISIBLE)
            ) {
                show(child);
            }
        }
    }

    private val INTERPOLATOR: Interpolator = FastOutSlowInInterpolator()

    fun hide(view: View) {
        val animator =
            view.animate().translationY(view.height.toFloat()).setInterpolator(INTERPOLATOR)
                .setDuration(200)
        animator.setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.GONE
            }

            override fun onAnimationCancel(animation: Animator) {
                show(view)
            }

            override fun onAnimationRepeat(animation: Animator) {
            }
        })
        animator.start()
    }

    fun show(view: View) {
        val animator =
            view.animate().translationY(0F).setInterpolator(INTERPOLATOR).setDuration(200)
        animator.setListener(object : Animator.AnimatorListener {

            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.VISIBLE
            }

            override fun onAnimationCancel(animation: Animator) {
                hide(view)
            }

            override fun onAnimationRepeat(animation: Animator) {
            }
        })
        animator.start();
    }
}