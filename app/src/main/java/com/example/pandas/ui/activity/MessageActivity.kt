package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.MessageViewModel
import com.example.pandas.databinding.ActivityMessageBinding
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 消息界面
 * @author: dongyiming
 * @date: 3/24/22 12:51 上午
 * @version: v1.0
 */
public class MessageActivity : BaseActivity<MessageViewModel, ActivityMessageBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        appViewModel.appColorType.value?.let {
            binding.clayoutPlayTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.ibnPlayBack.setImageResource(R.mipmap.img_topview_back)
                binding.txtPlayTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnPlayBack.setImageResource(R.mipmap.img_topview_back_white)
                binding.txtPlayTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
        }

        binding.clayoutMessageRelation.setOnClickListener {
            startAnyActivity(this, FollowAndFansActivity::class.java)
        }
    }

    override fun createObserver() {
    }

}