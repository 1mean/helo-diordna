package com.example.pandas.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentChildSettingBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.activity.*

/**
 * @description: 我的-设置
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class SelfChildSettingFragment : BaseFragment<SelfViewModel, FragmentChildSettingBinding>() {

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

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
        binding.txtMineName.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, SelfInfoActivity::class.java))
        }
    }

    override fun createObserver() {

        mViewModel.follows.observe(viewLifecycleOwner) {
            binding.txtMineFollow.text = it.size.toString()
        }
    }

    override fun firstOnResume() {
        mViewModel.getCurrentFollows(mActivity)
    }

}