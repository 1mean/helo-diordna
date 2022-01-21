package com.example.pandas.ui.activity

import HomeAdapter
import android.Manifest
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.RadioGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.pandas.R
import com.example.pandas.databinding.ActivityHomeBinding


/**
 * @description: home-activity，项目总界面
 * @author: dongyiming
 * @date: 11/17/21 1:25 PM
 * @version: v1.0
 */
public class HomeActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityHomeBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rgHome.setOnCheckedChangeListener(this)
        binding.rgHome.check(R.id.rb_name1)

        val mAdapter = HomeAdapter(this)
        binding.vpHome.adapter = mAdapter
        binding.vpHome.setCurrentItem(0, false)
        binding.vpHome.isUserInputEnabled = false //禁止滑动

        requestPermissions.launch(permissions)
        //状态栏沉浸
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            window.decorView.systemUiVisibility =
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.rb_name1 -> binding.vpHome.setCurrentItem(0, false)
            R.id.rb_name2 -> binding.vpHome.setCurrentItem(1, false)
            R.id.rb_name3 -> binding.vpHome.setCurrentItem(2, false)
            R.id.rb_name4 -> binding.vpHome.setCurrentItem(3, false)
        }
    }
}