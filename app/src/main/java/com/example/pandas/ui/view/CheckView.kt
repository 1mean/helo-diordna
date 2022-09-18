package com.example.pandas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.utils.ScreenUtil

/**
 * @description: CheckView
 * @author: dongyiming
 * @date: 9/11/22 4:24 下午
 * @version: v1.0
 */
public class CheckView : View {

    private var paint: Paint? = null
    private var _path: Path? = null
    private val path get() = _path!!

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        _path = Path()
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint?.run {
            strokeWidth = ScreenUtil.dip2px(2f)
            style = Paint.Style.STROKE
            color = ContextCompat.getColor(context, R.color.color_txt_item_name)
        }
    }

    fun setColor(color: Int) {
        paint!!.color = color
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // first part
        path.moveTo((measuredWidth / 4).toFloat(), (measuredHeight / 2).toFloat())
        path.lineTo((measuredWidth / 2).toFloat(), (measuredHeight * 3 / 4).toFloat())
        // second part
        // second part
        path.lineTo(measuredWidth.toFloat(), (measuredHeight / 4).toFloat())
        canvas!!.drawPath(path, paint!!)
    }
}