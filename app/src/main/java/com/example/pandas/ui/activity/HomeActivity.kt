package com.example.pandas.ui.activity

import HomeAdapter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
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