package com.example.pandas.ui.fragment

import android.content.Intent
import android.os.Bundle
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineBinding
import com.example.pandas.ui.activity.ErrorActivity
import com.example.pandas.ui.activity.HistoryActivity
import com.example.pandas.ui.activity.LocalCacheActivity
import com.example.pandas.ui.activity.SelfInfoActivity

/**
 * @description: SelfFragment
 * @author: dongyiming
 * @date: 2021/11/25 3:57 下午
 * @version: v1.0
 */
public class SelfFragment : BaseLazyFragment<SelfViewModel, FragmentMineBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        binding.clayoutDownload.setOnClickListener {
            startActivity(Intent(activity, LocalCacheActivity::class.java))
        }
        binding.clayoutHistory.setOnClickListener {
            startActivity(Intent(activity, HistoryActivity::class.java))
        }
        binding.clayoutSetting.setOnClickListener {
            showToast("设置")
        }
        binding.clayoutOtherSetting.setOnClickListener {
            showToast("个性设置")
        }
        binding.clayoutMoreSetting.setOnClickListener {
            showToast("更多服务")
        }
        binding.clayoutSelf.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, SelfInfoActivity::class.java))
        }
        binding.cvError.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, ErrorActivity::class.java))
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}