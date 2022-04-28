package com.example.pandas.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.example.pandas.R
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.databinding.ActivityMainBinding
import com.example.pandas.utils.StatusBarUtils

class MainActivity : BaseActivity<BaseViewModel,ActivityMainBinding>() {

    private var exitTime = 0L
    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)

        Navigation.findNavController(this, R.id.main_navigation)

//        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                val nav = Navigation.findNavController(this@MainActivity, R.id.main_navigation)
//                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.mainFragment) {
//                    //如果当前界面不是主页，那么直接调用返回即可
//                    nav.navigateUp()
//                } else {
//                    //是主页
//                    if (System.currentTimeMillis() - exitTime > 2000) {
//                        Toast.makeText(this@MainActivity,"再按一次退出程序",Toast.LENGTH_SHORT).show()
//                        exitTime = System.currentTimeMillis()
//                    } else {
//                        finish()
//                    }
//                }
//            }
//        })
    }

    override fun createObserver() {
    }

}
