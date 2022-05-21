package com.example.pandas.ui.fragment

import android.content.Intent
import android.os.Bundle
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineBinding
import com.example.pandas.ui.activity.*

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
        binding.clayoutMineExp.setOnClickListener {
            showToast("个人积分")
        }
        binding.clayoutSettingTiming.setOnClickListener {
            showToast("定时关闭")
        }
        binding.clayoutSelf.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, SelfInfoActivity::class.java))
        }
        binding.cvError.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, ErrorActivity::class.java))
        }
        binding.clayoutMineFollow.setOnClickListener {
            val intent =
                Intent(mActivity, FollowAndFansActivity::class.java).putExtra("FollowsOrFans", 0)
            mActivity.startActivity(intent)
        }
        binding.clayoutMineFans.setOnClickListener {
            val intent =
                Intent(mActivity, FollowAndFansActivity::class.java).putExtra("FollowsOrFans", 1)
            mActivity.startActivity(intent)
        }
    }

    override fun createObserver() {

        mViewModel.follows.observe(viewLifecycleOwner) {
            binding.txtMineFollow.text = it.size.toString()
        }
    }

    override fun firstOnResume() {
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getCurrentFollows(mActivity)
    }
}