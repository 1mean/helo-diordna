package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.viewmodel.ErrorViewModel
import com.example.pandas.databinding.ActivityErrorBinding
import com.example.pandas.ui.adapter.ErrorAdapter
import com.example.pandas.utils.StatusBarUtils
import com.just.agentweb.AgentWeb

/**
 * @description: ErrorActivity
 * @author: dongyiming
 * @date: 3/24/22 11:34 下午
 * @version: v1.0
 */
public class ErrorActivity : BaseActivity<ErrorViewModel, ActivityErrorBinding>() {

    private val mAdapter: ErrorAdapter by lazy { ErrorAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.white)
        binding.barTitle.setNavigationOnClickListener {
            finish()
        }
        binding.rvError.apply {
            layoutManager = LinearLayoutManager(this@ErrorActivity)
            adapter = mAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getAllLogFile(this)
    }

    override fun createObserver() {

        mViewModel.filesResult.observe(this) {

            if (it.isEmpty()) {
                binding.rvError.visibility = View.GONE
                binding.txtErrorMessage.visibility = View.VISIBLE
            } else {
                mAdapter.refreshAdapter(it)
            }
        }
    }

}