package com.example.pandas.ui.activity

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.LoginInfo
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivitySplashBinding
import com.example.pandas.ui.ext.addAlphaAnimation
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.*

/**
 * @description: 启动界面
 * @author: dongyiming
 * @date: 6/19/23 8:09 PM
 * @version: v1.0
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity : BaseActivity<BaseViewModel, ActivitySplashBinding>() {

    override fun initStatusView() {

        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
        binding.imgSplash.post {
            addAlphaAnimation(binding.imgSplash, 1500, object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                        R.anim.animate_activity_in,
                        R.anim.animate_activity_out
                    )
                    finish()
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }

            })
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        val status = SPUtils.getInt(this, AppInfos.BG_STATUS_KEY)
        if (status != 0) {
            appViewModel.appColorType.value = status
        }

        val type = SPUtils.getInt(this, AppInfos.RECO_STATUS_KEY)
        if (type != 0) {
            appViewModel.recommendType.value = type
        }

        val loginStatus = SPUtils.getInt(this, AppInfos.LOGIN_KEY)
        LoginInfo.instance.setLoginStatus(loginStatus)
    }

    override fun createObserver() {
    }
}