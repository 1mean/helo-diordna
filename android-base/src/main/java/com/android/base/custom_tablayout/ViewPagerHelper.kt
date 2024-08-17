package com.android.base.custom_tablayout

import androidx.viewpager2.widget.ViewPager2

/**
 * 简化和ViewPager绑定
 * Created by hackware on 2016/8/17.
 */
object ViewPagerHelper {
    fun bind(magicIndicator: MagicIndicator, viewPager: ViewPager2) {

        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                magicIndicator.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                magicIndicator.onPageSelected(position)
            }
        })
    }
}