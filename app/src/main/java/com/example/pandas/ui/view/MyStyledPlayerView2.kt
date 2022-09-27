package com.example.pandas.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * @description: MyStyledPlayerView
 * @author: dongyiming
 * @date: 7/26/22 12:26 下午
 * @version: v1.0
 */
public class MyStyledPlayerView2 : StyledPlayerView {

    private val gestureDetector: GestureDetectorCompat
    private val gestureListener: DoubleTapGestureListener = DoubleTapGestureListener()

    private var controller: PlayerDoubleTapListener? = null
        get() = gestureListener.controls
        set(value) {
            gestureListener.controls = value
            field = value
        }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        gestureDetector = GestureDetectorCompat(context, gestureListener)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if (gestureDetector.onTouchEvent(ev)) {
            return true
        }
        return super.onTouchEvent(ev)
    }

    fun controller(controller: PlayerDoubleTapListener) = apply { this.controller = controller }

    private class DoubleTapGestureListener() :
        GestureDetector.SimpleOnGestureListener() {

        var controls: PlayerDoubleTapListener? = null

        override fun onDown(e: MotionEvent): Boolean {
            Log.e("PlayerDoubleTapListener","onDown")
            controls?.onDown()
            return super.onDown(e)
        }


        override fun onSingleTapUp(e: MotionEvent): Boolean {//双击时第一次按下也会触发
            Log.e("PlayerDoubleTapListener","onSingleTapUp")
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            Log.e("PlayerDoubleTapListener","onSingleTapConfirmed")
            controls?.onSingleTapConfirmed()
            return super.onSingleTapConfirmed(e)
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            Log.e("PlayerDoubleTapListener","onDoubleTap")
            controls?.onDoubleTap()
            return super.onDoubleTap(e)
        }

        override fun onDoubleTapEvent(e: MotionEvent): Boolean {
            Log.e("PlayerDoubleTapListener","onDoubleTapEvent")
            return super.onDoubleTapEvent(e)
        }

        //右滑时，distanceX < 0
        override fun onScroll(
            e1: MotionEvent?,//The first down motion event that started the scrolling
            e2: MotionEvent?,//The move motion event that triggered the current onScroll
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        companion object {
            private const val TAG = ".DTGListener"
            private var DEBUG = true
        }
    }

}