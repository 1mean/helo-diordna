package com.example.pandas.ui.view

import android.content.Context
import android.util.Log
import com.example.helo_base.magic.commonnavigator.titles.ColorTransitionPagerTitleView

/**
 * @description: ScaleTransitionPagerTitleView
 * @author: dongyiming
 * @date: 10/12/23 1:52 AM
 * @version: v1.0
 */
public class ScaleTransitionPagerTitleView(context: Context?) :
    ColorTransitionPagerTitleView(context) {

    private var mMinScale = 0.8f

    override fun onEnter(index: Int, totalCount: Int, enterPercent: Float, leftToRight: Boolean) {
        super.onEnter(index, totalCount, enterPercent, leftToRight) // 实现颜色渐变
        scaleX = mMinScale + (1.0f - mMinScale) * enterPercent
        scaleY = mMinScale + (1.0f - mMinScale) * enterPercent
        Log.e("1mean","onEnter scaleX:$scaleX, scaleY:$scaleY")
    }

    override fun onLeave(index: Int, totalCount: Int, leavePercent: Float, leftToRight: Boolean) {
        super.onLeave(index, totalCount, leavePercent, leftToRight) // 实现颜色渐变
        scaleX = 1.0f + (mMinScale - 1.0f) * leavePercent
        scaleY = 1.0f + (mMinScale - 1.0f) * leavePercent
        Log.e("1mean","onLeave scaleX:$scaleX, scaleY:$scaleY")
    }

    fun getMinScale(): Float {
        return mMinScale
    }

    fun setMinScale(minScale: Float) {
        mMinScale = minScale
    }
}