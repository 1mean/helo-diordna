package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityFollowBinding
import com.example.pandas.ui.fragment.FansFragment
import com.example.pandas.ui.fragment.FollowFragment
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: 关注和粉丝页面
 * @author: dongyiming
 * @date: 5/10/22 1:52 下午
 * @version: v1.0
 */
public class FollowAndFansActivity : BaseActivity<SelfViewModel, ActivityFollowBinding>() {

    private val tabTitles = arrayListOf("我的关注", "我的粉丝")

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)

        val index = intent.getIntExtra("FollowsOrFans", -1)
        binding.layoutFollowTop.ibnTopFinish.setOnClickListener { finish() }
        binding.layoutFollowTop.txtTopName.text = resources.getString(R.string.str_mine_friends)

        binding.vp2Follow.run {
            offscreenPageLimit = tabTitles.size
            isSaveEnabled = false
            setCurrentItem(index, false)
            adapter = object : FragmentStateAdapter(this@FollowAndFansActivity) {
                override fun getItemCount(): Int = 2

                override fun createFragment(position: Int): Fragment {
                    if (position == 0) {
                        return FollowFragment()
                    } else {
                        return FansFragment()
                    }
                }
            }
        }
        TabLayoutMediator(
            binding.tabFollow, binding.vp2Follow, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    override fun createObserver() {

    }

}