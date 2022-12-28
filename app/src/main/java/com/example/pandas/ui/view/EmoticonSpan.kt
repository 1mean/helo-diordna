package com.example.pandas.ui.view

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan

/**
 * @description: 实现图形和文字居中的效果，默认只有居于bottom和基线
 * @author: dongyiming
 * @date: 12/6/22 3:19 PM
 * @version: v1.0
 */
public class EmoticonSpan(drawable: Drawable) : ImageSpan(drawable) {

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        val drawable = drawable
        canvas.save()
        var transY: Int = 0
        if (mVerticalAlignment == ALIGN_BASELINE) {
            transY -= paint.fontMetricsInt.descent
        } else if (mVerticalAlignment == ALIGN_BOTTOM) {
            transY = bottom - drawable.bounds.bottom;
        } else {
            val fm = paint.fontMetricsInt
            transY = (y + fm.descent + y + fm.ascent) / 2 - drawable.bounds.bottom / 2
//            transY = (bottom - top - drawable.bounds.bottom) / 2 + top
        }
        canvas.translate(x, transY.toFloat())
        drawable.draw(canvas)
        canvas.restore()
    }

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fontMetricsInt: Paint.FontMetricsInt?
    ): Int {
        val drawable = drawable
        val rect = drawable.bounds
        fontMetricsInt?.let {
            val fmPaint = paint.fontMetricsInt
            val fontHeight = fmPaint.bottom - fmPaint.top
            val drHeight = rect.bottom - rect.top
            val top = drHeight / 2 - fontHeight / 4
            val bottom = drHeight / 2 + fontHeight / 4
            it.ascent = -bottom
            it.top = -bottom
            it.bottom = top
            it.descent = top
        }
        return rect.right
    }
}