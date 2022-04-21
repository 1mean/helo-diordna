package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.ui.fragment.UserVideosFragment

/**
 * @description: UserInfoPageAdapter
 * @author: dongyiming
 * @date: 4/22/22 12:56 上午
 * @version: v1.0
 */
public class UserInfoPageAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            UserVideosFragment()
        } else {
            UserVideosFragment()
        }
    }

}