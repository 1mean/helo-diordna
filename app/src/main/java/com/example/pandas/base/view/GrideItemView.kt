package com.example.pandas.base.view
import android.content.Context
import android.util.AttributeSet
import android.view.ViewConfiguration
import android.view.ViewGroup

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/4/22 8:27 下午
 * @version: v1.0
 */
public class GrideItemView:ViewGroup {

    //默认的图片高度:330px
    private val DEFAULT_HEIGHT = 330

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    fun initView(){

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }

}