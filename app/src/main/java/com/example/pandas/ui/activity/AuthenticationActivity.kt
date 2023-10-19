package com.example.pandas.ui.activity

import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivityAuthenticationBinding
import com.example.pandas.ui.fragment.main.mine.AuthenUpdateFragment

/**
 * @description: 认证
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class AuthenticationActivity : BaseActivity<MainViewModel, ActivityAuthenticationBinding>() {

    private val tag: String = "auth_fragment"

    override fun initView(savedInstanceState: Bundle?) {

        val transaction = supportFragmentManager.beginTransaction()
        val tagFragment = supportFragmentManager.findFragmentByTag(tag)
        if (tagFragment == null) {
            transaction.run {
                setReorderingAllowed(true)
                add(R.id.flayout_authen, AuthenUpdateFragment(), tag)
                addToBackStack(null)
                commit()
            }
        }

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }

    }

    override fun createObserver() {
    }

}