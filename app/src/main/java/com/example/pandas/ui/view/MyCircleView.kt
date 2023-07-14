package com.example.pandas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.pandas.R

/**
 * @description: MyCircleView
 * @author: dongyiming
 * @date: 7/10/23 11:53 PM
 * @version: v1.0
 */
public class MyCircleView : View {

    private var paint: Paint? = null
    private var radius: Float = 75f
    private var max = 2000f
    private var centerX: Float = 0f
    private var centerY: Float = 0f

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
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint!!.color = ContextCompat.getColor(context, R.color.white)
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = 2f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = width
        val height = height
        canvas?.drawCircle(width.toFloat() / 2, height.toFloat() / 2, radius, paint!!);
    }
}