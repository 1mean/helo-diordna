package com.example.pandas.ui.fragment.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.base.ui.fragment.BaseFragment
import com.android.base.vm.BaseViewModel
import com.example.pandas.databinding.FragmentSearchListResultBinding

/**
 * @description: SearchResultFragment
 * @author: dongyiming
 * @date: 8/25/24 2:27 AM
 * @version: v1.0
 */
public class SearchResultFragment :
    BaseFragment<BaseViewModel, FragmentSearchListResultBinding>() {

    private val mTitles = arrayListOf("全部", "用户")

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Search.apply {
            adapter = SearchPagerAdapter(mActivity)
            offscreenPageLimit = mTitles.size
            currentItem = 0
            isSaveEnabled = false
        }
        binding.tabWan.setViewPager(binding.vp2Search, mTitles)
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    private inner class SearchPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = mTitles.size

        private val pageIds = mTitles.map { it.hashCode().toLong() }

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> SearchListFragment.newInstance()
            else -> {
                SearchUserFragment.newInstance()
            }
        }

        override fun getItemId(position: Int): Long = pageIds[position]

        override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)
    }
}