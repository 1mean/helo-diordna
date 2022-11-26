package com.example.pandas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.example.pandas.bean.MatRect

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2022/11/10 14:05
 */
class FaceFrameView : View {

    var paint = Paint()
    private var matRects: List<MatRect>? = null
    private val mtf: Typeface

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        mtf = Typeface.createFromAsset(context.assets, "Lobster2-4.TTF")
        paint.run {
            typeface = mtf
            color = 0x77000000
            isAntiAlias = true
            style = Paint.Style.FILL
        }
    }

    override fun onDraw(canvas: Canvas) {

        matRects?.let { rects ->
            if (rects.isNotEmpty()) {
                matRects?.forEach { matRect ->
                    val rect = matRect.rect
                    val left = rect.x.toFloat()
                    val top = rect.y.toFloat()
                    val right = (rect.x + rect.width).toFloat()
                    val bottom = (rect.y + rect.height).toFloat()
                    canvas.drawRect(left, top, right, bottom, paint)
                }
            }
        }
    }

    /**
     * 更新人脸框坐标，重新绘制
     *
     * @param matRects：
     */
    fun updateView(matRects: List<MatRect>?) {
        this.matRects = matRects
        //重绘和清除界面切换预留的view
        invalidate()
    }
}