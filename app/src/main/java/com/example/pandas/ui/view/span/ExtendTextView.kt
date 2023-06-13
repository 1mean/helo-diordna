package com.example.pandas.ui.view.span

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.example.pandas.R
import com.example.pandas.utils.ScreenUtil
import java.util.*
import kotlin.math.ceil

/**
 * @description: 只适用于本项目评论文字的TextView
 *   --TODO:不用自定义就能解决，先不用
 * @author: dongyiming
 * @date: 6/2/22 11:05 下午
 * @version: v1.0
 */
public class ExtendTextView : View {

    var normalTextColor: Int = Color.BLACK
    var clickableTextColor: Int = Color.BLACK
    var normalTextSize: Float = 0f
    var clickableTextSize: Float = 0f
    var marginLeft: Float = 0f
    var marginRight: Float = 0f
    var marginTop: Float = 0f
    var marginBottom: Float = 0f
    var columnPadding: Float = 0f //行间距

    var contentText: CharSequence = ""
    var userFromText: CharSequence = ""
    var userToText: CharSequence = ""
    var mText: CharSequence = ""

    //设定属性
    private var totalHeight: Int = 0
    private var maxWidth: Int = 0
    private val maxLines = Integer.MAX_VALUE //最大行数


    //默认值,由于右侧文字会漏出一部分
    private val finalPaddingRight = 30f


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

            columnPadding = ta.getDimension(R.styleable.ExtendTextView_column_padding, 0f)
            marginLeft = ta.getDimension(R.styleable.ExtendTextView_margin_left, 0f)
            marginRight = ta.getDimension(R.styleable.ExtendTextView_margin_right, 0f)
            marginTop = ta.getDimension(R.styleable.ExtendTextView_margin_top, 0f)
            marginBottom = ta.getDimension(R.styleable.ExtendTextView_margin_bottom, 0f)

            contentText = ta.getString(R.styleable.ExtendTextView_normal_content).toString()
            userFromText = ta.getString(R.styleable.ExtendTextView_user_from).toString()
            userToText = ta.getString(R.styleable.ExtendTextView_user_to).toString()
            ta.recycle()
        }

        screenWidth = ScreenUtil.getScreenWidth(context)
        mPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.textSize = normalTextSize
        mPaint.color = normalTextColor

        maxWidth = ScreenUtil.getScreenWidth(context) - marginLeft.toInt() - marginRight.toInt()
    }

    /**
     * 目前项目里评论文字的四种状态
     * - 0，普通
     * - 1，名 up：---
     *      - 和花UP: 你好吗
     * - 2，回复 @名：---
     *      - 回复 @和花 :这里和花是UP，不需要带UP标识，@和花都变色
     * - 3，名 回复 名：---
     *      - 和花 回复 @和叶 :你好啊
     */
    fun setContent(content: String, from: String, to: String, state: Int, isUp: Boolean) {

        this.contentText = content
        this.userFromText = from
        this.userToText = to

        when (state) {
            0 -> mText = "$contentText"
            1 -> mText = "$userFromText: $contentText"
            2 -> mText = "回复 @$userToText :$contentText"
            3 -> mText = "$userFromText 回复 @$userToText :$contentText"
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val measureWidth = measureWidth(widthMeasureSpec)
        val measureHeight = measureHeight(heightMeasureSpec)

        setMeasuredDimension(measureWidth, measureHeight)
    }

    private fun measureHeight(highMeasureSpec: Int): Int {

        var lineHeight = 0
        var lineWidth = 0
        var lineNum = 1

        val mode = MeasureSpec.getMode(highMeasureSpec)
        val size = MeasureSpec.getSize(highMeasureSpec)

        //初始化高度
        val metrics = mPaint.fontMetrics //字体的各种指标属性
        lineHeight =
            ceil((metrics.descent - metrics.top).toDouble()).toInt() + columnPadding.toInt()

        var index = 0
        if (mText.isNotEmpty()) {
            mText.forEach { _ ->
                val char = mText[index]
                val str = char.toString()
                //接收字节宽度数据，普通45，:和空格是11，单词23，表情两个char分别为46
                val widths = FloatArray(1)
                mPaint.getTextWidths(str, widths)
                if (char == '\n') {
                    lineNum++
                    lineWidth = 0
                } else {
                    lineWidth += ceil(widths[0].toDouble()).toInt()
                    if (lineWidth > maxWidth) {
                        lineNum++
                        lineWidth = ceil(widths[0].toDouble()).toInt()
                    } else {
//                        if (index == mText.length - 1) {
//                            lineNum++
//                        }
                    }
                }
                index++
                if (lineNum > maxLines) {
                    lineNum = if (lineNum < maxLines) lineNum else maxLines
                    return@forEach
                }
            }
            //总高度需要减去一个columnPadding,然后加上marginTop和marginBottom
            totalHeight =
                lineNum * lineHeight - columnPadding.toInt() + marginTop.toInt() + marginBottom.toInt()
        }
        var result = totalHeight
        if (mode == MeasureSpec.AT_MOST) {
            result = size
        } else if (mode == MeasureSpec.EXACTLY) {
            result = totalHeight
        }
        return result
    }

    private fun measureWidth(widthMeasureSpec: Int): Int {

        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)

        var result = maxWidth
        if (specMode == MeasureSpec.AT_MOST) {//wrap
            result = specSize
        } else if (specMode == MeasureSpec.EXACTLY) {//match or 123
            result = maxWidth
        }
        return result
    }

    @SuppressLint("DrawAllocation")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var lineWidth = 0
        var lineHeight = 0
        var lineNum = 1
        var start = 0 //定位，用于截取字符串
        var index = 0

        val mString = Vector<String>()
        val metrics = mPaint.fontMetrics //字体的各种指标属性
        val height = ceil((metrics.descent - metrics.top).toDouble())
        lineHeight = (height + columnPadding).toInt()

        //默认基线在原点，无法显示，为了让文字可以显示出来，不至于被遮盖，特别是第一行，这个值要根据字体大小设置
        val x = 0
        val y = height.toInt()

        if (mText.isNotEmpty()) {
            mText.forEach { _ ->
                val char = mText[index]
                val str = char.toString()
                val widths = FloatArray(1)
                mPaint.getTextWidths(str, widths)
                if (char == '\n') {
                    lineNum++
                    mString.addElement(mText.substring(start, index))
                    lineWidth = 0
                    start = index + 1
                } else {
                    lineWidth += ceil(widths[0].toDouble()).toInt()
                    if (lineWidth > maxWidth) {
                        lineNum++
                        lineWidth = ceil(widths[0].toDouble()).toInt()
                        mString.addElement(mText.substring(start, index))
                        start = index
                    } else {
                        if (index == mText.length - 1) {
                            mString.addElement(mText.substring(start, mText.length))
                        }
                    }
                }
                index++
            }
            totalHeight = lineNum * lineHeight - columnPadding.toInt()
            for (i in 0 until lineNum) {
                //其实设置y的只就是为了迎合这个函数，要是不清楚可以自己百度一下
                if (i == 0) {
                    mPaint.color = clickableTextColor
                } else {
                    mPaint.color = normalTextColor
                }
                canvas!!.drawText(
                    mString.elementAt(i), x.toFloat(),
                    (y + lineHeight * i).toFloat(), mPaint
                )
            }
        }
    }

    /**
     * 目前项目里评论文字的四种状态
     * - 0，普通
     * - 1，名 up：---
     *      - 和花UP: 你好吗
     * - 2，回复 @名：---
     *      - 回复 @和花 :这里和花是UP，不需要带UP标识，@和花都变色
     * - 3，名 回复 名：---
     *      - 和花 回复 @和叶 :你好啊
     */
    private fun drawState(state: Int) {

        var lineWidth = 0
        var lineHeight = 0
        var lineNum = 1
        var start = 0 //定位，用于截取字符串
        var index = 0

        val mString = Vector<String>()
        val metrics = mPaint.fontMetrics //字体的各种指标属性
        val height = ceil((metrics.descent - metrics.top).toDouble())
        lineHeight = (height + columnPadding).toInt()

        //默认基线在原点，无法显示，为了让文字可以显示出来，不至于被遮盖，特别是第一行，这个值要根据字体大小设置
        val x = 0
        val y = height.toInt()


        val toTextLength = userToText.length
        if (state == 1) {
            val fromTextLength = userFromText.length









        }
    }
}
