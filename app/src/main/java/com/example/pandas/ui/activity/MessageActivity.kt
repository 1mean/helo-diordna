package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.MessageViewModel
import com.example.pandas.databinding.ActivityMessageBinding
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 消息界面
 * @author: dongyiming
 * @date: 3/24/22 12:51 上午
 * @version: v1.0
 */
public class MessageActivity : BaseActivity<MessageViewModel, ActivityMessageBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutPlayTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnPlayBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtPlayTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.imgMessageRelation.setImageResource(R.mipmap.img_message_top_relation)
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnPlayBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtPlayTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    binding.imgMessageRelation.setImageResource(R.mipmap.img_message_top_relation_white)
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.clayoutMessageRelation.setOnClickListener {
            startAnyActivity(this, FollowAndFansActivity::class.java)
        }
    }

    override fun createObserver() {
    }

}