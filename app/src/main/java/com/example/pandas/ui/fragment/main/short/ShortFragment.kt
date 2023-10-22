package com.example.pandas.ui.fragment.main.short

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentShortVideoBinding
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.activity.ShortVideoActivity2
import com.example.pandas.ui.view.TabEntity
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.coroutines.launch

/**
 * @description: PetChildFragment
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class ShortFragment() :
    BaseFragment<MainFragmentViewModel, FragmentShortVideoBinding>() {

    private val tabTitles = arrayListOf("关注", "发现", "推荐")

    var isUpdate = true

    private val tabTitleColors
        get() = arrayOf(
            ContextCompat.getColor(mActivity, R.color.color_vertical_played),
            ContextCompat.getColor(mActivity, R.color.color_txt_short_tab_unselected),
            ContextCompat.getColor(mActivity, R.color.color_txt_short_tab_selected),
            ContextCompat.getColor(mActivity, R.color.white)
        )

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Short.run {
            offscreenPageLimit = tabTitles.size
            isSaveEnabled = false
            currentItem = 1
            adapter = object : FragmentStateAdapter(this@ShortFragment) {
                override fun getItemCount(): Int = 3

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> {
                            ShortAttentionFragment()
                        }
                        1 -> {
                            ShortFindingFragment()
                        }
                        else -> {
                            ShortRecommendFragment()
                        }
                    }
                }
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.e("1mean", "onPageSelected: $position")
                    binding.tbShort.currentTab = position
                    updateTabLayout(position)
                }
            })
        }

        val mTabEntities = ArrayList<CustomTabEntity>()
        for (i in tabTitles.indices) {
            mTabEntities.add(TabEntity(tabTitles[i]))
        }
        binding.tbShort.run {
            setTabData(mTabEntities)
            currentTab = 2
            setOnTabSelectListener(object : OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    Log.e("1mean", "onTabSelect: $position")
                    binding.vp2Short.setCurrentItem(position, false)
                    updateTabLayout(position)
                }

                override fun onTabReselect(position: Int) {
                }
            })
        }

//        binding.tbShort.showDot(1)
//        val rtv_2_2: MsgView = binding.tbShort.getMsgView(1)
//        if (rtv_2_2 != null) {
//            UnreadMsgUtils.setSize(rtv_2_2, ScreenUtil.dip2px(7.5f).toInt())
//        }
        binding.vp2Short.currentItem = 2

        appViewModel.appColorType.value?.let {
            updateTop(it)
        }

        binding.clayoutShortSearch.setOnClickListener {
            startActivity(Intent(mActivity, NewSearchActivity::class.java))
        }

//        Glide.with(mActivity).asBitmap().load(R.mipmap.img_tieba_top)
//            .apply(RequestOptions.bitmapTransform(BlurTransformation(20, 5)))//40,7
//            .into(object : CustomTarget<Bitmap>() {
//                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                    Log.e("1mean","resource:$resource")
//                    binding.flayoutShort.background = BitmapDrawable(mActivity.resources, resource)
//                    //binding.flayoutShort.setBackgroundColor(R.color.color_bg_grey)
//                }
//
//                override fun onLoadCleared(placeholder: Drawable?) {
//                }
//            })
    }

    private fun updateTop(status: Int) {
        val selectIndex = binding.tbShort.currentTab
        if (selectIndex == 2) {
            //binding.clayoutShortTab.setBackgroundResource(R.color.color_white_lucency)

            binding.tbShort.indicatorColor = tabTitleColors[3]
            binding.tbShort.textSelectColor = tabTitleColors[3]
            binding.tbShort.textUnselectColor = tabTitleColors[0]
            binding.imgShortSearch.setImageResource(R.mipmap.img_short_search1_white)

        } else {
            if (status == 0) {
                binding.tbShort.indicatorColor = tabTitleColors[2]
                binding.tbShort.textSelectColor = tabTitleColors[2]
                binding.tbShort.textUnselectColor = tabTitleColors[1]
                binding.imgShortSearch.setImageResource(R.mipmap.img_short_search1)
            } else {
                binding.tbShort.indicatorColor = tabTitleColors[3]

                binding.tbShort.textSelectColor = tabTitleColors[3]
                binding.tbShort.textUnselectColor = tabTitleColors[3]
                binding.imgShortSearch.setImageResource(R.mipmap.img_short_search1_white)
            }

            //binding.clayoutShortTab.setBackgroundResource(AppInfos.bgColors[status])
        }
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            updateTop(it)
        }

        mViewModel.refreshPosition.observe(viewLifecycleOwner) {
            if (it == 3) {
                val currentItem = binding.vp2Short.currentItem
                val fragments = childFragmentManager.fragments
                fragments.forEach {
                    when (currentItem) {
                        0 -> {
                            if (it is ShortAttentionFragment) {
                                (it as ShortAttentionFragment).refresh()
                            }
                        }
                        1 -> {
                            if (it is ShortFindingFragment) {
                                (it as ShortFindingFragment).refresh()
                            }
                        }
                    }
                }

            }
        }
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun onPause() {
        super.onPause()
        if (isUpdate) {
            if (binding.tbShort.currentTab == 2) {
                val nightMode = DarkModeUtils.getNightModel(mActivity)
                if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {//夜间模式
                    StatusBarUtils.updataStatus(mActivity, false, true, R.color.color_white_lucency)
                } else {
                    val status = appViewModel.appColorType.value
                    if (status == null || status == 0) {
                        StatusBarUtils.updataStatus(
                            mActivity,
                            true,
                            true,
                            R.color.color_white_lucency
                        )
                    } else {
                        StatusBarUtils.updataStatus(
                            mActivity,
                            false,
                            true,
                            AppInfos.bgColors[status]
                        )
                    }
                }
            }
            mViewModel.updateBottomBackground(0)
        }
    }

    override fun againOnResume() {
        super.againOnResume()
        if (isUpdate) {
            if (binding.tbShort.currentTab == 2) {
                StatusBarUtils.updataStatus(mActivity, false, true, R.color.color_white_lucency)
                mViewModel.updateBottomBackground(1)
            } else {
                //mViewModel.updateBottomBackground(1)
            }
        }
    }

    private var needUpadate = false
    private fun updateTabLayout(position: Int) {
        if (position != 2 && !needUpadate) {
            return
        }
        if (position == 2) {
            needUpadate = true
            StatusBarUtils.updataStatus(
                mActivity,
                false,
                true,
                R.color.color_white_lucency
            )
            binding.tbShort.indicatorColor = tabTitleColors[3]
            binding.tbShort.textSelectColor = tabTitleColors[3]
            binding.tbShort.textUnselectColor = tabTitleColors[0]
            binding.imgShortSearch.setImageResource(R.mipmap.img_short_search1_white)

            mViewModel.updateBottomBackground(1)
            //binding.clayoutShortTab.setBackgroundResource(R.color.color_white_lucency)
        } else {
            needUpadate = false
            val status = appViewModel.appColorType.value
            if (status == null || status == 0) {
                binding.tbShort.textSelectColor = tabTitleColors[2]
                binding.tbShort.textUnselectColor = tabTitleColors[1]

                binding.tbShort.indicatorColor = tabTitleColors[2]

                StatusBarUtils.updataStatus(
                    mActivity,
                    true,
                    true,
                    R.color.color_white_lucency
                )
                binding.imgShortSearch.setImageResource(R.mipmap.img_short_search1)
                //binding.clayoutShortTab.setBackgroundResource(R.color.color_white_lucency)
            } else {
                binding.tbShort.textSelectColor = tabTitleColors[3]
                binding.tbShort.textUnselectColor = tabTitleColors[3]

                binding.tbShort.indicatorColor = tabTitleColors[3]

                StatusBarUtils.updataStatus(
                    mActivity,
                    false,
                    true,
                    AppInfos.bgColors[status]
                )
                binding.imgShortSearch.setImageResource(R.mipmap.img_short_search1_white)
                //binding.clayoutShortTab.setBackgroundResource(AppInfos.bgColors[status])
            }
            mViewModel.updateBottomBackground(0)
        }
    }
}