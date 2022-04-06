package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.ui.fragment.DownLoadFragment

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/18 11:41 下午
 * @version: v1.0
 */
public class SelfFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        var mFragment: Fragment? = null
        when (position) {
            0 -> mFragment = DownLoadFragment()
            else -> mFragment = Fragment()
        }
        return mFragment
    }

}