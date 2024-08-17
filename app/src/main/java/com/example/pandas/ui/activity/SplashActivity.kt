package com.example.pandas.ui.activity

import AppInstance
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.AppInfos.LOGIN_KEY
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import com.example.pandas.databinding.ActivitySplashBinding
import com.example.pandas.utils.Preference
import com.example.pandas.utils.SPUtils
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @description: 启动界面
 * @author: dongyiming
 * @date: 6/19/23 8:09 PM
 * @version: v1.0
 */
public class SplashActivity : BaseActivity<WanAndroidViewModel, ActivitySplashBinding>() {

    private var isLogin: Boolean by Preference(LOGIN_KEY, false)

    private val useAndroid12SplashScreen = false//是否使用Android12的SplashScreen
    private var mSplashScreen: SplashScreen? = null
    private var mKeepOnAtomicBool = AtomicBoolean(true)

    override fun preInit() {
        super.preInit()
        if (useAndroid12SplashScreen) {
            mSplashScreen = installSplashScreen()//初始化启动页面，必须在setContentView之前设置
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        //设置共同沉浸式样式
        //Android12之前的启动页面的设置方法
//        initStatusView()
//        val splashKey = SPUtils.getInt(this, AppInfos.BG_Splash_KEY)
//        binding.clayoutSplash.setBackgroundResource(AppInfos.splashImgs[splashKey])

        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init()

        AppInstance.instance.isLoginSuccess = isLogin

        lifecycleScope.launch {
            if (useAndroid12SplashScreen) {//目前没有好的图片和动图，暂时不使用Android12的SplashScreen
                mSplashScreen?.let {
                    //每次UI绘制前，会判断Splash是否有必要继续展示在屏幕上；直到不再满足条件时，隐藏Splash
                    it.setKeepVisibleCondition { mKeepOnAtomicBool.get() }
                    it.setOnExitAnimationListener { splashScreenViewProvider ->
                        startSplashExit(
                            splashScreenViewProvider
                        )
                    }
                }
                withContext(Dispatchers.IO) {
                    delay(2000)// Splash展示2秒钟
                    mKeepOnAtomicBool.compareAndSet(true, false)//Splash 展示完毕
                }
            }

            delay(3000)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_activity_in, R.anim.animate_activity_out)
            finish()
        }

        val status = SPUtils.getInt(this, AppInfos.BG_STATUS_KEY)
        appViewModel.appColorType.value = status

        val type = SPUtils.getInt(this, AppInfos.RECO_STATUS_KEY)
        if (type != 0) {
            appViewModel.recommendType.value = type
        }

        binding.txtSplashClose.setOnClickListener {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_activity_in, R.anim.animate_activity_out)
            finish()
        }
    }

    override fun createObserver() {
    }

    private fun startSplashExit(splashScreenViewProvider: SplashScreenViewProvider) {

        val splashScreenView = splashScreenViewProvider.view//splashScreenView
        val iconView = splashScreenViewProvider.iconView//splashIconView
        //ScreenView alpha动画
        val splashAlphaAnim = ObjectAnimator.ofFloat(splashScreenView, View.ALPHA, 1f, 0f)
        splashAlphaAnim.duration = 500
        splashAlphaAnim.interpolator = FastOutLinearInInterpolator()
        //iconView 向下移动的动画
        val translationY = ObjectAnimator.ofFloat(
            iconView,
            View.TRANSLATION_Y,
            iconView.translationY,
            splashScreenView.height.toFloat()
        )
        translationY.duration = 500
        translationY.interpolator = FastOutLinearInInterpolator()
        // 合并渐变动画 & 下移动画
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(translationY, splashAlphaAnim)
        // 动画结束时调用的方法
        animatorSet.doOnEnd { onAnimEnd(splashScreenViewProvider) }
        // 开启动画
        animatorSet.start()
    }

    /**
     * 当动画结束
     */
    private fun onAnimEnd(splashScreenViewProvider: SplashScreenViewProvider) {
        //移除监听
        splashScreenViewProvider.remove()
        //跳转下个页面
        // 进入主界面
        Log.d("splashActivity", "----startActivity MainActivity----")
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        this@SplashActivity.finish()
        Log.d("splashActivity", "----SplashActivity finish----")
        // Activity 退场动画
        overridePendingTransition(0, R.anim.animate_activity_out)
    }
}