package com.example.pandas.ui.fragment.main.pet

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.CutePetViewModel
import com.example.pandas.databinding.FragmentRoomBinding
import com.example.pandas.ui.adapter.PetBannerAdapter
import com.example.pandas.ui.adapter.RoomContentAdapter
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.viewpager.Indicator
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch


/**
 * @description: homefragment-cutepet
 * @author: dongyiming
 * @date: 2021/11/27 8:10 上午
 * @version: v1.0
 */
public class CutePetFragment : BaseFragment<CutePetViewModel, FragmentRoomBinding>() {

    private var indicator: Indicator? = null
    private val bannerAdapter: PetBannerAdapter by lazy { PetBannerAdapter(mutableListOf()) }

    private val tabNames by lazy {
        arrayListOf(
            resources.getString(R.string.string_room_tab_item0),
            resources.getString(R.string.string_room_tab_item1),
            resources.getString(R.string.string_room_tab_item2),
            resources.getString(R.string.string_room_tab_item3),
            resources.getString(R.string.string_room_tab_item4),
            resources.getString(R.string.string_room_tab_item5),
            resources.getString(R.string.string_room_tab_item6),
            resources.getString(R.string.string_room_tab_item7),
            resources.getString(R.string.string_room_tab_item8),
            resources.getString(R.string.string_room_tab_item9),
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.refreshPet.apply {
            setProgressViewEndTarget(true, 300)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getBannerData(true)
            }
        }

        indicator = Indicator(mActivity)//初始化轮播图指示器

        //解决AppBarLayout和SwipeRefreshLayout的滑动冲突问题,同时也解决了SwipeRefreshLayout和Recyclerview的滑动冲突问题
        binding.abl.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            //像上滑动时，verticalOffset为负值，完全展示时为0
            binding.refreshPet.isEnabled = verticalOffset >= 0
        })

//        如果共享viewmodel，注意在page页面未显示前，observer会接收到model里数据刷新了的通知，
//         会在onResume时先显示前一个页面的相同的view，然后才获取数据显示自己的真实view
//        tabNames.forEach {
//            fragments.add(PetChildFragment.newInstance(mViewModel.getType(it)))
//        }
        //初始化ViewPager相关
        binding.vpPet.apply {
            adapter = RoomContentAdapter(childFragmentManager, lifecycle, tabNames)
            offscreenPageLimit = tabNames.size
            currentItem = 0
            //java.lang.IllegalStateException: Fragment no longer exists for key f#23578416: unique id 9c69bbb3-2f68-4da6-92d8-fadf6ff059fd
            isSaveEnabled = false
        }

        //binding.tlayoutPet.addOnTabSelectedListener(listener)

        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
//        TabLayoutMediator(
//            binding.tlayoutPet, binding.vpPet, true
//        ) { tab, position ->
//            tab.text = tabNames[position]
//        }.attach()

        binding.tlayoutPet.setViewPager(binding.vpPet, tabNames)

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.refreshPet.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.refreshPet.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.bannerWrapper.collect {
                if (it.isSuccess) {
                    val bannerList = it.listData
                    if (bannerList.isNotEmpty()) {

                        indicator!!.initIndicator(
                            bannerList.size,
                            ContextCompat.getColor(mActivity, R.color.white)
                        )
                        bannerAdapter.refreshData(bannerList)
                        binding.bannerPet.setAdapter(bannerAdapter).setIndicator(indicator!!, true)
                            .setAutoPlayed(true)
                    }
                }

                if (it.isRefresh) {
                    //初始化ViewPager相关
                    binding.vpPet.apply {
                        adapter = RoomContentAdapter(childFragmentManager, lifecycle, tabNames)
                        offscreenPageLimit = tabNames.size
                    }
                    binding.refreshPet.isRefreshing = false
                }

                binding.clayoutShow.visibility = View.VISIBLE
                binding.refreshPet.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        binding.refreshPet.isRefreshing = true
        mViewModel.getBannerData(false)
    }

    private val listener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            //使用setCurrentItem(tab.position, false)会出现滑动tab错乱
            binding.vpPet.currentItem = tab.position
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
        }

        override fun onTabReselected(tab: TabLayout.Tab) {
        }
    }

}