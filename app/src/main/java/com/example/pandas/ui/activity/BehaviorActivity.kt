package com.example.pandas.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.databinding.ActivityBehaviorBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/16 4:32 下午
 * @version: v1.0
 */
public class BehaviorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBehaviorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBehaviorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //状态栏沉浸
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val list = mutableListOf<String>()
        for (i in 0 until 100) {
            list.add("")
        }
    }
}