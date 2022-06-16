package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @description: HomeActivity的界面适配器
 * @author: dongyiming
 * @date: 2021/11/18 8:32 下午
 * @version: v1.0
 */
public class HomeAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment = FragmentFactory.buildFragment(position)

}