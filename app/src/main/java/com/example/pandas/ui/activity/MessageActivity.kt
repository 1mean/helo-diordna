package com.example.pandas.ui.activity
import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MessageViewModel
import com.example.pandas.databinding.ActivityMessageBinding
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 消息界面
 * @author: dongyiming
 * @date: 3/24/22 12:51 上午
 * @version: v1.0
 */
public class MessageActivity : BaseActivity<MessageViewModel,ActivityMessageBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }

}