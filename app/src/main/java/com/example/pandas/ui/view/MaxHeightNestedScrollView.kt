package com.example.pandas.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView
import com.example.pandas.R

/**
 * @description: MaxHeightNestedScrollView
 * @author: dongyiming
 * @date: 5/19/23 4:25 PM
 * @version: v1.0
 */
public class MaxHeightNestedScrollView : NestedScrollView {

    private var maxHeight = -1

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }

    fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {

        val array = context.obtainStyledAttributes(attrs, R.styleable.MaxHeightNestedScrollView)
        maxHeight = array.getDimensionPixelSize(R.styleable.MaxHeightNestedScrollView_maxHeight, 0)
        array.recycle()
    }

    fun getMaxHeight(): Int {
        return maxHeight
    }

    fun setMaxHeight(maxHeight: Int) {
        this.maxHeight = maxHeight
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        if (maxHeight > 0) {
            //不限制大小，但是有最大值限制
            val heightSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST)
            super.onMeasure(widthMeasureSpec, heightSpec)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}