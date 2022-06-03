package com.example.pandas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.example.pandas.R
import com.example.pandas.utils.ScreenUtil

/**
 * @description: 只适用于本项目评论文字的TextView
 *
 *
 *
 * @author: dongyiming
 * @date: 6/2/22 11:05 下午
 * @version: v1.0
 */
public class ExtendTextView : View {

    var normalTextColor: Int = Color.BLACK
    var clickableTextColor: Int = Color.BLACK
    var normalTextSize: Float = 0f
    var clickableTextSize: Float = 0f

    var normalContent: CharSequence = ""
    var clickableContent: CharSequence = ""

    val mPaint: TextPaint
    val screenWidth: Int

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        attrs?.let {
            val ta = context.obtainStyledAttributes(it, R.styleable.ExtendTextView)
            normalTextColor = ta.getColor(R.styleable.ExtendTextView_normal_textColor, Color.BLACK)
            clickableTextColor =
                ta.getColor(R.styleable.ExtendTextView_clickable_textColor, Color.BLACK)
            normalTextSize = ta.getDimension(R.styleable.ExtendTextView_normal_textSize, 0f)
            clickableTextSize = ta.getDimension(R.styleable.ExtendTextView_clickable_textSize, 0f)
            clickableContent = ta.getString(R.styleable.ExtendTextView_clickable_content).toString()
            ta.recycle()
        }

        screenWidth = ScreenUtil.getScreenWidth(context)
        mPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.textSize = normalTextSize
        mPaint.color = normalTextColor
    }

    /**
     * 目前四种状态
     * - 1，普通
     * - 2，名 up：---
     * - 3，回复 @名：---
     * - 4，名 回复 名：---
     */
    fun setContent(normalContent: String, clickableContent: String, state: Int) {
        this.normalContent = normalContent
        this.clickableContent = clickableContent

        val length = normalContent.length
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val w_mode = MeasureSpec.getMode(widthMeasureSpec)
        val h_mode = MeasureSpec.getMode(heightMeasureSpec)
        val w_size = MeasureSpec.getSize(widthMeasureSpec)
        val h_size = MeasureSpec.getSize(heightMeasureSpec)
        var measureWidth: Int = 0
        var measureHeight: Int = 0

        //获取测量值
        when (w_mode) {
            MeasureSpec.EXACTLY -> {
                measureWidth = w_size
            }
            MeasureSpec.AT_MOST -> {
            }
            MeasureSpec.UNSPECIFIED -> {
            }
        }
        when (h_mode) {
            MeasureSpec.EXACTLY -> {
                measureHeight = h_size
            }
            MeasureSpec.AT_MOST -> {
            }
            MeasureSpec.UNSPECIFIED -> {
            }
        }
        setMeasuredDimension(measureWidth, measureHeight)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (normalContent.isEmpty() || clickableContent.isEmpty()) {
            return
        }
        val mText = normalContent.toString() + clickableContent.toString()
        canvas?.let {

            //实现换行
            val layout = StaticLayout.Builder.obtain(
                mText,
                0,
                mText.length,
                mPaint,
                screenWidth
            ).build()
            layout.draw(it)
//            it.drawText()
        }
    }


}
