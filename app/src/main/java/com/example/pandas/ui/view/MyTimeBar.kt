package com.example.pandas.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.google.android.exoplayer2.ui.DefaultTimeBar

/**
 * @description: MyTimeBar
 * @author: dongyiming
 * @date: 9/20/24 PM9:11
 * @version: v1.0
 */
public class MyTimeBar: DefaultTimeBar {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        //init()
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        var finalPosition = 0f

        when(event.action){
            MotionEvent.ACTION_DOWN->{
                //finalPosition = this.get
            }
            MotionEvent.ACTION_MOVE->{

            }
            MotionEvent.ACTION_UP->{

            }
        }
        return super.onTouchEvent(event)
    }
}