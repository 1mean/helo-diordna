package com.example.pandas.ui.adapter

import NullFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.ui.fragment.main.mine.SelfChildCacheFragment
import com.example.pandas.ui.fragment.main.mine.SelfChildSettingFragment

/**
 * @description: SelfViewPagerAdapter
 * @author: dongyiming
 * @date: 2021/12/11 2:47 下午
 * @version: v1.0
 */
public class SelfViewPagerAdapter(
    fragmentActivity: FragmentActivity
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            SelfChildSettingFragment()
        } else if(position == 1) {
            SelfChildCacheFragment()
        } else {
            NullFragment()
        }
    }
}