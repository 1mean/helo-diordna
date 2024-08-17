package com.example.pandas.ui.view.viewpager

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.android.base.utils.ScreenUtil
import com.example.pandas.R

/**
 * @description: 自定义ViewPager的翻页指示器
 * @author: dongyiming
 * @date: 2022/1/10 4:56 下午
 * @version: v1.0
 */
public class Indicator : View, Iindicator {

    private var newPage: Int = 0
    private var pageCount: Int = 0

    private var isMid: Boolean = false

    //距离参数，选中和未选中一样大小
    private val indicatorItemPadding: Int = ScreenUtil.dip2px(4f).toInt() //间隔
    private val indicatorRadius: Int = ScreenUtil.dip2px(2.4f).toInt() //半径

    private var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var selectColor: Int? = null
    private var indiColor: Int = ContextCompat.getColor(context, R.color.color_home_viewpager_bg)

    private var params: RelativeLayout.LayoutParams? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun getView(): View = this

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        newPage = position
        invalidate()//重新执行onDraw()方法
    }

    override fun initIndicator(count: Int, color: Int) {

        pageCount = count
        selectColor = color
        visibility = if (pageCount > 1) {
            VISIBLE
        } else {
            GONE
        }
        requestLayout()//重新测量和布局
    }

    override fun initIndicator(count: Int, color: Int, isMid: Boolean) {

        this.isMid = isMid
        pageCount = count
        selectColor = color
        visibility = if (pageCount > 1) {
            VISIBLE
        } else {
            GONE
        }
        requestLayout()//重新测量和布局
    }

    override fun getParams(): RelativeLayout.LayoutParams {

        if (params == null) {
            params = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params?.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            if (isMid) {
                params?.addRule(RelativeLayout.CENTER_HORIZONTAL)
            } else {
                params?.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                params?.rightMargin = ScreenUtil.dip2px(8f).toInt()
            }
            params?.bottomMargin = ScreenUtil.dip2px(8f).toInt()
        }
        return params!!
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val w_mode = MeasureSpec.getMode(widthMeasureSpec)
        val h_mode = MeasureSpec.getMode(heightMeasureSpec)
        val w_size = MeasureSpec.getSize(widthMeasureSpec)
        val h_size = MeasureSpec.getSize(heightMeasureSpec)
        var measureWidth: Int = 0
        var measureHeight: Int = 0

        //获取测量值
//        when (w_mode) {
//            MeasureSpec.EXACTLY -> {
//                measureWidth = w_size
//            }
//            MeasureSpec.AT_MOST -> {
//            }
//            MeasureSpec.UNSPECIFIED -> {
//                val paddingWidths = (pageCount - 1) * indicatorItemPadding
//                val itemWidths = indicatorRadius * 2 * pageCount
//                measureWidth = paddingLeft + paddingRight + itemWidths + paddingWidths
//            }
//        }
//        when (h_mode) {
//            MeasureSpec.EXACTLY -> {
//                measureHeight = h_size
//            }
//            MeasureSpec.AT_MOST -> {
//            }
//            MeasureSpec.UNSPECIFIED -> {
//                measureHeight = paddingTop + paddingBottom + indicatorRadius * 2
//            }
//        }
        val paddingWidths = (pageCount - 1) * indicatorItemPadding
        val itemWidths = indicatorRadius * 2 * pageCount
        measureWidth = paddingLeft + paddingRight + itemWidths + paddingWidths
        measureHeight = paddingTop + paddingBottom + indicatorRadius * 2
        setMeasuredDimension(measureWidth, measureHeight)
    }

    override fun onDraw(canvas: Canvas) {

        if (pageCount == 0) {
            return
        }
        //画圆
        var cx: Float = paddingLeft + indicatorRadius.toFloat()
        for (i in 0 until pageCount) {
            mPaint.color = if (i == newPage) selectColor!! else indiColor
            canvas.drawCircle(
                cx, indicatorRadius.toFloat() + paddingTop,
                indicatorRadius.toFloat(), mPaint
            )
            cx += (indicatorItemPadding + indicatorRadius * 2)
        }
    }

}