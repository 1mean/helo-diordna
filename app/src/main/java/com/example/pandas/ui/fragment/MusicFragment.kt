package com.example.pandas.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.FragmentMusicBinding
import com.example.pandas.ui.adapter.MusicTopAdapter
import com.example.pandas.ui.adapter.MusicVPAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.ext.setRefreshColor
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: 首页-音乐
 * @author: dongyiming
 * @date: 6/28/22 12:13 上午
 * @version: v1.0
 */
public class MusicFragment : BaseFragment<HomePageViewModel, FragmentMusicBinding>() {

    private val mTitles = arrayOf(
        "推荐", "全部", "流行", "纯音乐", "爵士", "动漫", "国风", "动漫", "国风"
    )

    private val topAdapter by lazy { MusicTopAdapter(mutableListOf()) }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        Log.e("1mean", "${mTitles.size}")
        binding.vp2Music.run {
            adapter = MusicVPAdapter(childFragmentManager, lifecycle, mTitles)
            offscreenPageLimit = mTitles.size
            currentItem = 0
        }

        val padding = mActivity.resources.getDimension(R.dimen.common_lh_10_dimens).toInt()

        binding.recyclerHomeMusicTop.run {
            addItemDecoration(CommonItemDecoration(false, 2, 0, padding, 0))
            layoutManager = GridLayoutManager(mActivity, 2)
            adapter = topAdapter
        }

        binding.swipMusic.run {
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getMusicTopData()
            }
        }

        binding.tabMusic.setTitles(mTitles)

        //解决AppBarLayout和SwipeRefreshLayout的滑动冲突问题,同时也解决了SwipeRefreshLayout和Recyclerview的滑动冲突问题
        binding.barHomeMusic.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            //像上滑动时，verticalOffset为负值，完全展示时为0
            binding.swipMusic.isEnabled = verticalOffset >= 0
        })
    }

    override fun createObserver() {
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

}