package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.ui.fragment.main.home.panda.PandaChildFragment

/**
 * @description: ActivityPandaAdapter
 * @author: dongyiming
 * @date: 3/28/22 1:01 上午
 * @version: v1.0
 */
public class ActivityPandaAdapter(
    activity: FragmentActivity,
    private val key: String,
    private val tabs: MutableList<String>,
) :
    FragmentStateAdapter(activity) {

    private val pageIds = tabs.map { it.hashCode().toLong() }

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment =
        PandaChildFragment.newInstance(key, getType(position))

    override fun getItemId(position: Int): Long = pageIds[position]

    override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)

    private fun getType(position: Int): Int {

        var type = 0
        when (position) {
            0 -> type = PeriodType.CUTE.ordinal
            1 -> type = PeriodType.BABY.ordinal
            2 -> type = PeriodType.MOM.ordinal
            3 -> type = PeriodType.GROUP.ordinal
            4 -> type = PeriodType.SINGLE.ordinal
        }
        return type
    }

}