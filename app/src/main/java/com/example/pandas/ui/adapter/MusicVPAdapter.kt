package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.ui.fragment.main.home.music.MusicChildFragment

/**
 * @description: RoomContentAdapter
 * @author: dongyiming
 * @date: 2021/12/11 2:47 下午
 * @version: v1.0
 */
public class MusicVPAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabs: Array<String>,
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val pageIds = tabs.map { it.hashCode().toLong() }

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment =
        MusicChildFragment.newInstance(getType(position))

    override fun getItemId(position: Int): Long = pageIds[position]

    override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)

    private fun getType(position: Int): Int = position

//    private fun getType(position: Int): Int {
//
//        var type = 0
//        type = when (position) {
//            0 -> VideoType.CAT.ordinal
//            1 -> VideoType.BIRD.ordinal
//            2 -> VideoType.FOX.ordinal
//            3 -> VideoType.RED_PANDA.ordinal
//            4 -> VideoType.PENGUIN.ordinal
//            5 -> VideoType.GOLDEN_MONKEY.ordinal
//            6 -> VideoType.BEAR.ordinal
//            else -> VideoType.BEAR.ordinal
//        }
//        return type
//    }
}