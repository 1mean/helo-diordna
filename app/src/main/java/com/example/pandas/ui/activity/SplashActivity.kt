package com.example.pandas.ui.activity

import android.animation.Animator
import android.annotation.SuppressLint
import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivitySplashBinding
import com.example.pandas.ui.ext.addAlphaAnimation
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 启动界面
 * @author: dongyiming
 * @date: 6/19/23 8:09 PM
 * @version: v1.0
 */
public class SplashActivity : BaseActivity<BaseViewModel, ActivitySplashBinding>() {

    override fun initStatusView() {
        super.initStatusView()
        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)

        binding.imgSplash.post {
            addAlphaAnimation(binding.imgSplash, 2000, object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    startAnyActivity(this@SplashActivity, MainActivity::class.java)
                    finish()
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }

            })
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }

}