package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.ui.fragment.main.pet.PetChildFragment

/**
 * @description: RoomContentAdapter
 * @author: dongyiming
 * @date: 2021/12/11 2:47 下午
 * @version: v1.0
 */
public class RoomContentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabs: MutableList<String>,
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val pageIds = tabs.map { it.hashCode().toLong() }

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment =
        PetChildFragment.newInstance(getType(position))

    override fun getItemId(position: Int): Long = pageIds[position]

    override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)

    private fun getType(position: Int): Int {

        var type = 0
        when (position) {
            0 -> type = VideoType.CAT.ordinal
            1 -> type = VideoType.BIRD.ordinal
            2 -> type = VideoType.FOX.ordinal
            3 -> type = VideoType.RED_PANDA.ordinal
            4 -> type = VideoType.PENGUIN.ordinal
            5 -> type = VideoType.GOLDEN_MONKEY.ordinal
            6 -> type = VideoType.BEAR.ordinal
        }
        return type
    }
}