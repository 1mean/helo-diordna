package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityFollowBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.main.mine.FansFragment
import com.example.pandas.ui.fragment.main.mine.FollowFragment
import com.example.pandas.utils.DarkModeUtils
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

        val index = intent.getIntExtra("FollowsOrFans", 0)

        binding.ibnTopFinish.setOnClickListener { finish() }
        binding.txtTopName.text = resources.getString(R.string.str_mine_friends)

        binding.vp2Follow.run {
            offscreenPageLimit = tabTitles.size
            isSaveEnabled = false
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

        binding.vp2Follow.currentItem = index

        appViewModel.appColorType.value?.let {
            binding.layoutFollowTop.setBackgroundResource(viewColors[it])
            if (it == 0) {
                binding.ibnTopFinish.setImageResource(R.mipmap.img_topview_back)
                binding.txtTopName.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_txt_panda_top
                    )
                )
                binding.tabFollow.setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        this,
                        viewColors[APP_COLOR_STATUS]
                    )
                )
            } else {
                binding.ibnTopFinish.setImageResource(R.mipmap.img_topview_back_white)
                binding.txtTopName.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                binding.tabFollow.setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        this,
                        viewColors[it]
                    )
                )
            }
        }
    }

    override fun createObserver() {

    }

}