package com.example.pandas.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.example.pandas.R

/**
 * @description: RadiusCardView
 * @author: dongyiming
 * @date: 3/19/22 3:30 下午
 * @version: v1.0
 */
public class RadiusCardView : CardView {

    private var leftTopRadiu = 0f
    private var leftBottomRadiu = 0f
    private var rightTopRadiu = 0f
    private var rightBottomRadiu = 0f
    private var bgColor = 0
    private var path: Path? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    @SuppressLint("Recycle")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        radius = 0F
        path = Path()
//        background = ColorDrawable() //设置透明背景
        val array = context.obtainStyledAttributes(attrs, R.styleable.RadiusCardView)
        leftTopRadiu = array.getDimension(R.styleable.RadiusCardView_leftTopRadiu, 0F)
        leftBottomRadiu = array.getDimension(R.styleable.RadiusCardView_leftBottomRadiu, 0F)
        rightTopRadiu = array.getDimension(R.styleable.RadiusCardView_rightTopRadiu, 0F)
        rightBottomRadiu = array.getDimension(R.styleable.RadiusCardView_rightBottomRadiu, 0F)
        bgColor = array.getResourceId(R.styleable.RadiusCardView_bgColor, 0)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {

        val paint = Paint()
        paint.color = bgColor

        val rectF = getRectF()
        val readius = floatArrayOf(
            leftTopRadiu,
            leftTopRadiu,
            rightTopRadiu,
            rightTopRadiu,
            rightBottomRadiu,
            rightBottomRadiu,
            leftBottomRadiu,
            leftBottomRadiu
        )
        path?.addRoundRect(rectF, readius, Path.Direction.CW)
        canvas?.clipPath(path!!)
//        canvas?.clipPath(path, Region.Op.INTERSECT)
        canvas?.drawPath(path!!, paint)
        //super.onDraw(canvas);
    }

    private fun getRectF(): RectF {
        val rect = Rect()
        getDrawingRect(rect)
        return RectF(rect)
    }
}