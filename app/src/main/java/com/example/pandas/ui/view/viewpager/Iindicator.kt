package com.example.pandas.ui.view.viewpager
import android.view.View
import android.widget.RelativeLayout

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2022/1/10 5:05 下午
 * @version: v1.0
 */
interface Iindicator {

    fun getView(): View

    fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)

    fun initIndicator(count: Int, color: Int)

    fun getParams(): RelativeLayout.LayoutParams
}