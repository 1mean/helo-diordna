package com.example.pandas.ui.fragment.main.live

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentLivingBinding
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.main.eyepetozer.EyepetozerFragment

/**
 * @description: 动态
 * @author: dongyiming
 * @date: 10/10/22 10:17 上午
 * @version: v1.0
 */
public class LiveFragment : BaseFragment<MainFragmentViewModel, FragmentLivingBinding>() {

    private val tabTitles = arrayListOf("综合", "视频")

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Living.run {
            //Bug:这里如果使用FragmentStateAdapter(mActivity)，app在首页时就会触发其onResume()
            adapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
                override fun getItemCount(): Int = 2

                override fun createFragment(position: Int): Fragment {
                    return if (position == 0) {
                        LiveVideoFragment()
                    } else {
                        EyepetozerFragment()
                    }
                }
            }
            //解决bug：java.lang.IllegalStateException: Fragment no longer exists for key f0: unique id
            isSaveEnabled = false
            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.slideTabSetting.currentTab = position
                }
            })
        }

        binding.slideTabSetting.setViewPager(binding.vp2Living, tabTitles)

        updateTop(appViewModel.appColorType.value)

        binding.clayoutLiveSearch.setOnClickListener {
            startActivity(Intent(mActivity, NewSearchActivity::class.java))
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

    private fun updateTop(status: Int?) {
        if (status == null || status == 0) {
            binding.slideTabSetting.textSelectColor =
                ContextCompat.getColor(mActivity, viewColors[APP_COLOR_STATUS])
            binding.slideTabSetting.textUnselectColor =
                ContextCompat.getColor(mActivity, R.color.color_text_eye_unselect)
            binding.slideTabSetting.indicatorColor =
                ContextCompat.getColor(mActivity, viewColors[APP_COLOR_STATUS])
            binding.clayoutLiveTop.setBackgroundResource(R.color.color_white_lucency)
            binding.root.setBackgroundResource(R.drawable.shape_bg_living)
        } else {

            binding.slideTabSetting.textSelectColor =
                ContextCompat.getColor(mActivity, R.color.white)
            binding.slideTabSetting.textUnselectColor =
                ContextCompat.getColor(mActivity, R.color.white)
            binding.slideTabSetting.indicatorColor =
                ContextCompat.getColor(mActivity, R.color.white)
            binding.clayoutLiveTop.setBackgroundResource(viewColors[status])
        }
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}