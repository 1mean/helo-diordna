package com.example.pandas.ui.activity

import CacheItemFragment
import CacheListFragment
import StatusBarUtils
import android.os.Bundle
import android.view.View
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.ActivityCacheBinding

/**
 * @description: LocalCacheActivity
 * @author: dongyiming
 * @date: 3/8/22 1:38 下午
 * @version: v1.0
 */
public class LocalCacheActivity : BaseActivity<LocalCacheViewModel, ActivityCacheBinding>(),
    View.OnClickListener {

    private val mFragment1 by lazy { CacheListFragment() }
    private val mFragment2 by lazy { CacheItemFragment() }

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtils.setStatusBarMode(this, true, R.color.white)
        binding.tbarCache.setNavigationOnClickListener {
            finish()
        }

        val transient = supportFragmentManager.beginTransaction()
        transient.add(R.id.flayout_cache_content, mFragment1)
        transient.add(R.id.flayout_cache_content, mFragment2)
        transient.hide(mFragment2).show(mFragment1).commit()
    }

    override fun createObserver() {

        mViewModel.selectFileName.observe(this) {
            supportFragmentManager.beginTransaction().hide(mFragment1).show(mFragment2).commit()
        }
    }

    override fun onClick(v: View?) {
    }

}