package com.android.base.custom_tablayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/**
 * 整个框架的入口，核心
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/6/26.
 */
class MagicIndicator : FrameLayout {

    private var mNavigator: IPagerNavigator? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        mNavigator?.onPageScrolled(position, positionOffset, positionOffsetPixels)
    }

    fun onPageSelected(position: Int) {
        mNavigator?.onPageSelected(position)
    }

    fun onPageScrollStateChanged(state: Int) {
        mNavigator?.onPageScrollStateChanged(state)
    }

    fun setNavigator(navigator: IPagerNavigator) {
        if (this.mNavigator === navigator) {
            return
        }
        if (this.mNavigator != null) {
            navigator.onDetachFromMagicIndicator()
        }
        this.mNavigator = navigator
        removeAllViews()
        if (this.mNavigator is View) {
            val lp = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            addView(this.mNavigator as View?, lp)
            navigator.onAttachToMagicIndicator()//初始化布局、title和指示器
        }
    }
}