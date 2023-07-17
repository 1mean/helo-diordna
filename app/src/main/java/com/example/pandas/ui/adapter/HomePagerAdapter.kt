package com.example.pandas.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.app.AppInfos
import com.example.pandas.ui.fragment.main.home.*
import com.example.pandas.utils.SPUtils

/**
 * @description: fragment factory
 * @author: dongyiming
 * @date: 1/4/22 12:48 下午
 * @version: v1.0
 */
public class HomePagerAdapter(
    private val context: Context,
    private val tabList: List<String>, childFragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(childFragmentManager, lifecycle) {

    private var fragments = HashMap<Int, Fragment>()

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(position: Int): Fragment {

        var mFragment = fragments[position]
        if (mFragment == null) {
            mFragment = when (tabList[position]) {
                "推荐" -> {
                    RecommendFragment()
                }
                "熊猫" -> {
                    PandaFragment()
                }
                "热门" -> {
                    HotFragment()
                }
                "娱乐" -> {
                    EntertainmentFragment()
                }
                "风景" -> {
                    LandscapeFragment()
                }
                "音乐" -> {
                    val type = SPUtils.getInt(context, AppInfos.MUSIC_STYLE_KEY)
                    if (type == 0) {
                        MusicFragment2()
                    } else {
                        MusicFragment()
                    }
                }
                else -> {
                    Fragment()
                }
            }
            fragments[position] = mFragment
        }
        return mFragment
    }
}