package com.example.pandas.ui.view.span

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

/**
 * @description: MySpanTextView
 * @author: dongyiming
 * @date: 6/7/22 6:32 下午
 * @version: v1.0
 */
public class MySpanTextView : AppCompatTextView {

    var mLinkHitFlag: Boolean = false

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return mLinkHitFlag
    }
}