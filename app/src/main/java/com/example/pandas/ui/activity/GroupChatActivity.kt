package com.example.pandas.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivityGroupChatBinding

/**
 * @description: 联系我们
 * @author: dongyiming
 * @date: 10/8/23 9:43 PM
 * @version: v1.0
 */
public class GroupChatActivity : BaseActivity<MainViewModel, ActivityGroupChatBinding>() {

    private val mHandler = Handler(Looper.getMainLooper())

    override fun initView(savedInstanceState: Bundle?) {

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }
    }

    override fun createObserver() {
    }

}