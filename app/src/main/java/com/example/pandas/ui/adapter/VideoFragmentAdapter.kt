package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.ui.fragment.VideoCommentFragment
import com.example.pandas.ui.fragment.VideoInfosFragment

/**
 * @description: VideoFragmentAdapter
 * @author: dongyiming
 * @date: 12/29/21 11:18 下午
 * @version: v1.0
 */
public class VideoFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return if (position == 0) {
            VideoInfosFragment()
        } else {
            VideoCommentFragment()
        }
    }
}