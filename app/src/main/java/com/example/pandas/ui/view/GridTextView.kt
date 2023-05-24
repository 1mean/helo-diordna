package com.example.pandas.ui.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.utils.ScreenUtil

/**
 * @description: 搜索记录展示,为了方便，只用作添加TextView
 * @author: dongyiming
 * @date: 2/17/22 11:52 下午
 * @version: v1.0
 */
public class GridTextView : ViewGroup {

    private var currentWitdh = 0 //当前行的宽度，比较添加新view后是否大于屏幕宽度
    private var fullScreenWidth = 0

    private var defaultHeight = 0 //TextView高度固定，默认高度为90px
    private var txtColor = 0 //Textview背景色
    private var drawable: Drawable? = null

    private var list: List<String>? = null

    private var margin = 0 //距离最顶部、最底部、最左侧、最右侧的距离
    private var padding = 0 //TextView之间的距离，上下、左右间隔

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        defaultHeight = ScreenUtil.dip2px(30f).toInt()
        padding = ScreenUtil.dip2px(11f).toInt()
        margin = ScreenUtil.dip2px(5f).toInt()
        drawable = ContextCompat.getDrawable(context, R.drawable.shape_search_history)
        txtColor = ContextCompat.getColor(context, R.color.color_txt_item_title_recommend)
        fullScreenWidth = ScreenUtil.getScreenWidth(context) - ScreenUtil.dip2px(14f).toInt()
    }

    private var listener: ItemClickListener<String>? = null
    fun init(list: List<String>, listener: ItemClickListener<String>) {
        this.list = list
        this.listener = listener
        initTextView(list)
        requestLayout()
    }

    private fun initTextView(list: List<String>) {

        removeAllViews()//从其他界面回来刷新数据时，清理之前数据，保证不会显示错乱||清除数据的操作
        if (list.isNotEmpty()) {
            for (item in list) {
                val textView = AppCompatTextView(context).apply {
                    background = drawable
                    maxEms = 7
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    text = item
                    setTextColor(txtColor)
                    textSize = 13f
                    setPadding(43, 18, 43, 0)//设置位置
                }
                val params = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    defaultHeight
                )
                textView.setOnClickListener {
                    listener?.onItemClick(item)
                }
                addView(textView, params)
            }
        }
    }

    /**
     *  onMeasure会执行两次，注意相关变量不要设置为全局，会导致高度出现问题
     *  width = MeasureSpec.EXACTLY  height = MeasureSpec.AT_MOST
     *
     * @date: 2/18/22 11:39 上午
     * @version: v1.0
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var totalHeight = 0
        var row = 1//空的行数，用于计算高度
        list?.let { list ->

            if (list.isNotEmpty()) {

                for (position in list.indices) {

                    val childView = getChildAt(position)
                    if (childView != null) {
                        measureChild(childView, widthMeasureSpec, heightMeasureSpec)//必须先测量
                        val width = childView.measuredWidth
                        if (position == 0) {
                            currentWitdh = width + margin + margin //marginLeft 和 marginRight
                        } else {
                            currentWitdh += (width + padding)
                        }
                        if (currentWitdh > fullScreenWidth) {//宽度超出一屏，移动到下一行，重制参数
                            row += 1
                            currentWitdh = width + margin + margin
                        }
                    }
                }
                totalHeight = row * defaultHeight + (row - 1) * padding + margin + margin
                setMeasuredDimension(fullScreenWidth, totalHeight)
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        list?.let { list ->

            if (list.isNotEmpty()) {
                var left = margin
                var top = margin
                var right = 0
                var bottom = 0
                for (position in list.indices) {
                    val childView = getChildAt(position)
                    if (childView != null) {

                        val childWidth = childView.measuredWidth//getWidth在onLayout执行完，才能获取
                        val childHeight = childView.measuredHeight

                        val totleWidth = right + padding + childWidth + margin
                        if (totleWidth < fullScreenWidth) {//位置为0就肯定在当前行，不用纠结padding的处理
                            left = if (position == 0) {
                                margin
                            } else {
                                right + padding
                            }
                        } else {//跳到下一行
                            left = margin
                            top = bottom + padding
                        }
                        right = left + childWidth
                        bottom = top + childHeight
                        childView.layout(left, top, right, bottom)
                    }
                }
            }
        }
    }
}