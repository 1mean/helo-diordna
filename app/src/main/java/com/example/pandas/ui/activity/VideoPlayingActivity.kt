package com.example.pandas.ui.activity

import VideoFragmentAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.databinding.ActivityVideoBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/29/21 3:48 下午
 * @version: v1.0
 */
public class VideoPlayingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    private val tabNames = arrayListOf<String>("简介", "评论")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        StatusBarUtils.setStatusBarMode(this,false,R.color.black)

        val eyepetozerBean = getIntent().getParcelableExtra<EyepetozerBean>("EyepetozerBean")

        val viewPager = binding.vpVideo

        viewPager.adapter = VideoFragmentAdapter(this)
        viewPager.offscreenPageLimit = 1

        TabLayoutMediator(
            binding.tabView, viewPager, true
        ) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}