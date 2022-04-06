package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.ActivityCacheBinding
import com.example.pandas.ui.fragment.CacheItemFragment
import com.example.pandas.ui.fragment.CacheListFragment
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: LocalCacheActivity
 * @author: dongyiming
 * @date: 3/8/22 1:38 下午
 * @version: v1.0
 */
public class LocalCacheActivity : BaseActivity<LocalCacheViewModel, ActivityCacheBinding>() {

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

    override fun onBackPressed() {
        super.onBackPressed()
        Log.e("1mean", "onBackPressed")
    }

    //    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (mFragment2.isVisible) {
//                supportFragmentManager.beginTransaction().hide(mFragment2).show(mFragment1).commit()
//            } else {
//                finish()
//            }
//            return true
//        } else {
//            return super.onKeyDown(keyCode, event);
//        }
//    }
    override fun onkeyBack() {
        if (mFragment2.isVisible) {
            supportFragmentManager.beginTransaction().hide(mFragment2).show(mFragment1).commit()
            return
        } else {
            finish()
        }
    }
}