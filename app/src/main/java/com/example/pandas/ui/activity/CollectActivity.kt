package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.CollectViewModeL
import com.example.pandas.databinding.ActivityCollectBinding
import com.example.pandas.ui.ext.launcherActivity
import com.example.pandas.ui.ext.lightViewColors
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.main.mine.CollectFragment
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.launch

/**
 * @description: 我的收藏
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class CollectActivity : BaseActivity<CollectViewModeL, ActivityCollectBinding>() {

    private val mTitles = arrayListOf<String>()
    private val groupCodes = arrayListOf<Int>()

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {
                //binding.refreshCollect.isRefreshing = true
                mViewModel.getCollectGroups()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutCollectTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnCollectBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtCollectTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.tabWan.indicatorColor = ContextCompat.getColor(this, lightViewColors[7])
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.tabWan.indicatorColor =
                        ContextCompat.getColor(this, lightViewColors[it])
                    binding.ibnCollectBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtCollectTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.ibnCollectBack.setOnClickListener {
            finish()
        }
        binding.btnCollectAdd.setOnClickListener {
            launcherActivity(requestLauncher, this, GroupCreateActivity::class.java)
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getCollectGroups()
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.groupFlow.collect {
                mTitles.clear()
                if (it.isNotEmpty()) {
                    it.forEach { group ->
                        mTitles.add(group.groupName!!)
                        groupCodes.add(group.id)
                    }
                    binding.vp2Collect.apply {
                        adapter = CollectagerAdapter(this@CollectActivity)
                        offscreenPageLimit = mTitles.size
                        currentItem = 0
                        isSaveEnabled = false
                    }
                    binding.tabWan.setViewPager(binding.vp2Collect, mTitles)
                }
            }
        }
    }

    private inner class CollectagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = mTitles.size

        private val pageIds = mTitles.map { it.hashCode().toLong() }

        override fun createFragment(position: Int): Fragment {
            return CollectFragment.newInstance(groupCodes[position])
        }

        override fun getItemId(position: Int): Long = pageIds[position]

        override fun containsItem(itemId: Long): Boolean = pageIds.contains(itemId)
    }
}