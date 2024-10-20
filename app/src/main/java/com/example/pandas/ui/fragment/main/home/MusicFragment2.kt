package com.example.pandas.ui.fragment.main.home

import MusicFragment2Adapter
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.bean.MusicBean
import com.example.pandas.biz.viewmodel.HomePageViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.PandasAdapter
import com.example.pandas.ui.adapter.decoration.MusicFragmentItemDecoration
import com.example.pandas.ui.adapter.decoration.PandaItemDecoration
import com.example.pandas.ui.ext.addItemAnimation
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: 新的MusicFragment界面
 * @author: dongyiming
 * @date: 7/14/23 2:34 PM
 * @version: v1.0
 */
public class MusicFragment2 : BaseFragment<HomePageViewModel, LayoutSwipRefreshBinding>() {

    private val musicAdapter: MusicFragment2Adapter by lazy { MusicFragment2Adapter(MusicBean()) }

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop = resources.getDimension(R.dimen.common_lh_10_dimens)
        binding.recyclerLayout.init(
            MusicFragmentItemDecoration(paddingTop.toInt()),
            musicAdapter,
            LinearLayoutManager(mActivity, VERTICAL, false),
            null
        )

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_panda_fragment)
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getMusic()
            }
        }

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }

    }

    override fun refresh() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getMusic()
        binding.recyclerLayout.smoothScrollToPosition(0)
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            binding.swipLayout.setColorSchemeResources(AppInfos.viewColors[it])
        }

        mViewModel.musicData2.observe(viewLifecycleOwner) {

            if (it.isSuccess) {//成功
                binding.recyclerLayout.visibility = View.VISIBLE
                musicAdapter.refresh(it.musicBean)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {

        binding.swipLayout.isRefreshing = true
        mViewModel.getMusic()
    }

}