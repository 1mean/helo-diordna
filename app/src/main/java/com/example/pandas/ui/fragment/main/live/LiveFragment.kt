package com.example.pandas.ui.fragment.main.live

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentLivingBinding
import com.example.pandas.ui.fragment.main.eyepetozer.EyepetozerFragment
import com.example.pandas.ui.view.TabEntity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener

/**
 * @description: 动态
 * @author: dongyiming
 * @date: 10/10/22 10:17 上午
 * @version: v1.0
 */
public class LiveFragment : BaseFragment<MainFragmentViewModel, FragmentLivingBinding>() {

    private val tabTitles = arrayListOf("综合", "视频")

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Living.run {
            //Bug:这里如果使用FragmentStateAdapter(mActivity)，app在首页时就会触发其onResume()
            adapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
                override fun getItemCount(): Int = 2

                override fun createFragment(position: Int): Fragment {
                    if (position == 0) {
                        return LiveVideoFragment()
                    } else {
                        return EyepetozerFragment()
                    }
                }
            }
            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tabLiving.currentTab = position
                }
            })
        }

        val mTabEntities = ArrayList<CustomTabEntity>()
        for (i in tabTitles.indices) {
            mTabEntities.add(TabEntity(tabTitles[i]))
        }
        binding.tabLiving.run {
            setTabData(mTabEntities)
            currentTab = 0
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    binding.vp2Living.setCurrentItem(position, false)
                }

                override fun onTabReselect(position: Int) {
                }
            })
        }

        appViewModel.appColorType.value?.let {
            updateTop(it)
        }
    }

    override fun createObserver() {
        appViewModel.appColorType.observe(this) {
            updateTop(it)
        }
        mViewModel.refreshPosition.observe(viewLifecycleOwner) { position ->
            Log.e("doubleCilik", "LiveFragment: $position")
            if (position == 1) {
                val currentItem = binding.vp2Living.currentItem
                val fragments = childFragmentManager.fragments
                fragments.forEach {
                    when (currentItem) {
                        0 -> {
                            if (it is LiveVideoFragment) {
                                (it as LiveVideoFragment).refresh()
                            }
                        }
                        1 -> {
                            if (it is EyepetozerFragment) {
                                (it as EyepetozerFragment).refresh()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun firstOnResume() {
    }

    private fun updateTop(status: Int) {
        if (status == 0) {
            binding.clayoutOtherTop.setBackgroundResource(AppInfos.bgColors[status])
            binding.ibnPublish.setImageResource(R.mipmap.img_live_publish_gray)

            binding.tabLiving.textSelectColor =
                ContextCompat.getColor(mActivity, R.color.color_bg_grey)
            binding.tabLiving.textUnselectColor =
                ContextCompat.getColor(mActivity, R.color.color_text_eye_unselect)
            binding.tabLiving.indicatorColor =
                ContextCompat.getColor(mActivity, R.color.color_bg_grey)
        } else {

            binding.clayoutOtherTop.setBackgroundResource(AppInfos.bgColors[status])
            binding.ibnPublish.setImageResource(R.mipmap.img_live_publish_white)

            binding.tabLiving.textSelectColor = ContextCompat.getColor(mActivity, R.color.white)
            binding.tabLiving.textUnselectColor =
                ContextCompat.getColor(mActivity, R.color.snow)
            binding.tabLiving.indicatorColor = ContextCompat.getColor(mActivity, R.color.white)
        }
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}