package com.example.pandas.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * @description: MyStyledPlayerView
 * @author: dongyiming
 * @date: 7/26/22 12:26 下午
 * @version: v1.0
 */
public class MyStyledPlayerView : StyledPlayerView {

    private val gestureDetector: GestureDetectorCompat
    private val gestureListener: DoubleTapGestureListener = DoubleTapGestureListener(rootView)

    /**
     * If this field is set to `true` this view will handle double tapping, otherwise it will
     * handle touches the same way as the original [PlayerView][com.google.android.exoplayer2.ui.PlayerView] does
     */
    var isDoubleTapEnabled = true

    /**
     * Time window a double tap is active, so a followed tap is calling a gesture detector
     * method instead of normal tap (see [PlayerView.onTouchEvent])
     */
    var doubleTapDelay: Long = 700
        get() = gestureListener.doubleTapDelay
        set(value) {
            gestureListener.doubleTapDelay = value
            field = value
        }

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

        //1- 单击和双击的up在 [GestureDetectorCompat] 里已处理, 这里onUp处理拖动后的up
        if (isDoubleTapEnabled) {
            if (!gestureDetector.onTouchEvent(ev) && ev.action == MotionEvent.ACTION_UP) {
                controller?.onUp()
            }
            return true
        }

        //2- 单击和双击的up在 [GestureDetectorCompat] 里已处理
        /*if (isDoubleTapEnabled) {
            gestureDetector.onTouchEvent(ev)
            return true
        }*/

        return super.onTouchEvent(ev)
    }

    /**
     * Sets the [PlayerDoubleTapListener] which handles the gesture callbacks.
     *
     * Primarily used for [YouTubeOverlay][com.github.vkay94.dtpv.youtube.YouTubeOverlay]
     */
    fun controller(controller: PlayerDoubleTapListener) = apply { this.controller = controller }

    /**
     * Gesture Listener for double tapping
     *
     * For more information which methods are called in certain situations look for
     * [GestureDetector.onTouchEvent][android.view.GestureDetector.onTouchEvent],
     * especially for ACTION_DOWN and ACTION_UP
     */
    private class DoubleTapGestureListener(private val rootView: View) :
        GestureDetector.SimpleOnGestureListener() {

        private val mHandler = Handler(Looper.getMainLooper())
        private val mRunnable = Runnable {
            if (DEBUG) Log.d(TAG, "Runnable called")
            isDoubleTapping = false
            controls?.onDoubleTapFinished()
        }

        var controls: PlayerDoubleTapListener? = null
        var isDoubleTapping = false
        var doubleTapDelay: Long = 400

        /**
         * Resets the timeout to keep in double tap mode.
         *
         * Called once in [PlayerDoubleTapListener.onDoubleTapStarted]. Needs to be called
         * from outside if the double tap is customized / overridden to detect ongoing taps
         */
        fun keepInDoubleTapMode() {
            isDoubleTapping = true
            mHandler.removeCallbacks(mRunnable)
            mHandler.postDelayed(mRunnable, doubleTapDelay)
        }

        /**
         * Cancels double tap mode instantly by calling [PlayerDoubleTapListener.onDoubleTapFinished]
         */
        fun cancelInDoubleTapMode() {
            mHandler.removeCallbacks(mRunnable)
            isDoubleTapping = false
            controls?.onDoubleTapFinished()
        }

        override fun onDown(e: MotionEvent): Boolean {
            Log.e("1mmmmmmmm", "onDown isDoubleTapping=$isDoubleTapping")
            // Used to override the other methods
            controls?.onDown()
            if (isDoubleTapping) {
                controls?.onDoubleTapProgressDown(e.x, e.y)
                return true
            }
            return super.onDown(e)
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {//双击时第一次按下也会触发
            Log.e("1mmmmmmmm", "onSingleTapUp isDoubleTapping=$isDoubleTapping")
            controls?.onSingleTapUp()
            if (isDoubleTapping) {
                if (DEBUG) Log.d(TAG, "onSingleTapUp: isDoubleTapping = true")
                controls?.onDoubleTapProgressUp(e.x, e.y)
                return true
            }
            return super.onSingleTapUp(e)
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            // Ignore this event if double tapping is still active
            // Return true needed because this method is also called if you tap e.g. three times
            // in a row, therefore the controller would appear since the original behavior is
            // to hide and show on single tap
            Log.e("1mmmmmmmm", "onSingleTapConfirmed: isDoubleTapping=$isDoubleTapping")
            if (isDoubleTapping) return true
            if (DEBUG) Log.d(TAG, "onSingleTapConfirmed: isDoubleTap = false")
            return rootView.performClick()
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            // First tap (ACTION_DOWN) of both taps
            Log.e("1mmmmmmmm", "onDoubleTap isDoubleTapping:$isDoubleTapping")
            if (!isDoubleTapping) {
                isDoubleTapping = true
                keepInDoubleTapMode()
                controls?.onDoubleTapStarted(e.x, e.y)
            }
            return true
        }

        override fun onDoubleTapEvent(e: MotionEvent): Boolean {

            val isUp = e.actionMasked == MotionEvent.ACTION_UP
            Log.e("1mmmmmmmm", "onDoubleTapEvent： isUp=$isUp, isDoubleTapping=$isDoubleTapping")
            // Second tap (ACTION_UP) of both taps
            if (e.actionMasked == MotionEvent.ACTION_UP && isDoubleTapping) {
                if (DEBUG) Log.d(
                    TAG,
                    "onDoubleTapEvent, ACTION_UP"
                )
                controls?.onDoubleTapProgressUp(e.x, e.y)
                return true
            }
            return super.onDoubleTapEvent(e)
        }

        //右滑时，distanceX < 0
        override fun onScroll(
            e1: MotionEvent?,//The first down motion event that started the scrolling
            e2: MotionEvent?,//The move motion event that triggered the current onScroll
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            //Log.e("1mmmmmmmm","onScroll")
            controls?.onScroll(distanceX, distanceY)
            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        companion object {
            private const val TAG = ".DTGListener"
            private var DEBUG = true
        }
    }

}