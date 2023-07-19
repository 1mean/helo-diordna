package com.example.pandas.ui.fragment.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.FragmentMusicBinding
import com.example.pandas.ui.activity.MoreDataListActivity
import com.example.pandas.ui.activity.OneVerticalList2Activity
import com.example.pandas.ui.adapter.MusicTopAdapter
import com.example.pandas.ui.adapter.MusicVPAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.fragment.main.home.music.MusicChildFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: 首页-音乐
 * 页面存在的问题(已知)
 * 1，冲突问题
 * - viewpager2和viewpager2的冲突，目前用NestedScrollableHost包裹解决
 *    - 修改NestedScrollableHost，在上下滑动时，不拦截，释放给内部，解决内部vp的列表滑动到底后切换到外部vp2的页面
 *    - 但是目前滑动到底部继续滑动，还是会切换到内部vp2的其他页面，在列表内解决冲突会导致内部vp2无法滑动
 * - SwipeRefreshLayout和Tablayout的冲突，滑动起来十分卡顿，而且左右滑动容易触发下拉刷新
 *    - 自定义SwipeRefreshLayout水平滑动时自己消费
 *    - 同时也解决了SwipeRefreshLayout里面有viewpager2时，左右滑动容易触发下拉刷新的小问题
 * - viewpager2里RecyclerView滑动到底部继续滑动会导致翻页
 * - AppbarLayout和SwipeRefreshLayout的滑动冲突导致卡顿和下拉刷新错误，监听AppbarLayout偏移为0时才允许下拉
 * 2，未解决问题(已知)
 * - MusicFragment里无法完成HomeFragment顶部折叠的操作，上下滑动会被内部折叠消耗
 * - 内部vp2的RecyclerView与SwipeRefreshLayout的冲突(已解决)
 *    - 当vp2其中一个页面上滑到中间，然后切换到vp2的其他页面，往下滑动到AppbarLayout的偏移为0，此时再切回之前页面
 *    - 当往下拖动最初的页面时，无法拖动，且触发了下拉刷新
 *
 * @author: dongyiming
 * @date: 6/28/22 12:13 上午
 * @version: v1.0
 */
public class MusicFragment : BaseFragment<HomePageViewModel, FragmentMusicBinding>() {

    private val mTitles = arrayOf(
        "全部", "流行", "国风", "民谣", "动漫", "爵士", "摇滚", "校园"
    )

    private var verticalOffset: Int = 0//AppBarLayout的滑动偏移

    private var isEnable = true

    private val topAdapter by lazy { MusicTopAdapter(mutableListOf()) }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Music.run {
            adapter = MusicVPAdapter(childFragmentManager, lifecycle, mTitles)
            offscreenPageLimit = mTitles.size
            currentItem = 0
        }

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_5_dimens).toInt()

        binding.recyclerHomeMusicTop.run {
            addItemDecoration(CommonItemDecoration(false, 2, 0, padding, 0))
//            addItemDecoration(MusicTopDecoration())
            layoutManager = GridLayoutManager(mActivity, 2)
            adapter = topAdapter
        }

        binding.swipMusic.run {
            setColorSchemeResources(R.color.color_tab_indicator)
            setOnRefreshListener {
                mViewModel.getMusicTopData()
            }
        }

        //binding.tabMusic.setTitles(mTitles)
        TabLayoutMediator(
            binding.tabMusic, binding.vp2Music, true
        ) { tab, position ->
            tab.text = mTitles[position]
        }.attach()


        //解决AppBarLayout和SwipeRefreshLayout的滑动冲突问题,同时也解决了SwipeRefreshLayout和Recyclerview的滑动冲突问题
        binding.barHomeMusic.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->

            //像上滑动时，verticalOffset为负值，完全展示时为0
            //判断偏移为0，且子vp2的所有item的top距离为0，才允许下拉刷新
            this.verticalOffset = verticalOffset
            if (verticalOffset < 0) {
                binding.swipMusic.isEnabled = false

            } else if (verticalOffset == 0) {//当滑动到偏移为0时处理，再往下拉不会触发监听
                val fragments = childFragmentManager.fragments
                val currentItem = binding.vp2Music.currentItem
                if (fragments.isNotEmpty() && fragments.size > currentItem) {
                    fragments[currentItem]?.let {
                        if (it is MusicChildFragment) {
                            val topValue = (it as MusicChildFragment).getChildTop()
                            if (topValue == 0) {
                                binding.swipMusic.isEnabled = true
                            }
                        }
                    }
                }
            }
        })

        binding.clayoutMusicNotice.setOnClickListener {
            val intent =
                Intent(mActivity, OneVerticalList2Activity::class.java)
                    .putExtra("title", "音乐视频")
                    .putExtra("type", VideoType.MUSIC.ordinal)
            mActivity.startActivity(intent)
        }

        appViewModel.appColorType.value?.let {
            binding.swipMusic.setColorSchemeResources(AppInfos.viewColors[it])
        }
    }

    fun getBarVerticalOffset(): Int = verticalOffset

    fun setSwipeRefreshEnable(isEnable: Boolean) {
        binding.swipMusic.isEnabled = isEnable
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            binding.swipMusic.setColorSchemeResources(AppInfos.viewColors[it])
        }

        mViewModel.musicData.observe(viewLifecycleOwner) {

            topAdapter.refreshAdapter(it)
            binding.clayoutMusic.visibility = View.VISIBLE
            binding.swipMusic.isRefreshing = false
        }

    }

    override fun firstOnResume() {
        binding.swipMusic.isRefreshing = true
        mViewModel.getMusicTopData()
    }

    override fun refresh() {
        super.refresh()
        binding.swipMusic.isRefreshing = true
        mViewModel.getMusicTopData()
    }
}