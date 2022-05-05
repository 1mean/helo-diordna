package com.example.pandas.ui.activity

import android.Manifest
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import com.example.pandas.R
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.databinding.ActivityMainBinding
import com.example.pandas.utils.StatusBarUtils

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    private var exitTime = 0L

    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {

            val grantedList = it.filterValues { it }.mapNotNull { it.key } //通过的权限
            val isAllGranted = grantedList.size == it.size
            val list = (it - grantedList).map { it.key }//未通过的权限
            //拒绝的权限
            val deniedList =
                list.filter { ActivityCompat.shouldShowRequestPermissionRationale(this, it) }
            val alwaysDeniedList = list - deniedList
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)

        Navigation.findNavController(this, R.id.main_navigation)

        requestPermissions.launch(permissions)

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
