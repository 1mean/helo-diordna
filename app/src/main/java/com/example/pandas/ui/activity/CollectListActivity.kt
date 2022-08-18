package com.example.pandas.ui.activity
import android.os.Bundle
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityCollectListBinding

/**
 * @description: CollectListActivity
 * @author: dongyiming
 * @date: 8/19/22 1:17 上午
 * @version: v1.0
 */
public class CollectListActivity: BaseActivity<HistoryViewModeL, ActivityCollectListBinding>() {


    override fun initView(savedInstanceState: Bundle?) {

        val groupCode = intent.getIntExtra("groupCode",-1)
        val cover = intent.getStringExtra("cover")

        if (cover == null) {

        }


    }

    override fun createObserver() {

    }

}