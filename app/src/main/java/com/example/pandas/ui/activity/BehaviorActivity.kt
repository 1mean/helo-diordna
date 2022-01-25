package com.example.pandas.ui.activity

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.BaseViewAdapter
import com.example.pandas.base.BaseViewHolder
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
        binding.recyclerView.adapter = MyAdapter(this, list)
    }

    class MyAdapter(val context: Context, val datas: MutableList<String>) :
        BaseViewAdapter(context, datas) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

            val tv = TextView(context)
            tv.text = "hello $viewType"
            tv.setTextColor(ContextCompat.getColor(context, R.color.black))
            return BaseViewHolder(tv)
        }

        override fun handleViewHolder(holder: BaseViewHolder, position: Int) {

        }


    }
}