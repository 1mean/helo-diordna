package com.example.pandas.ui.fragment.main.mine

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentChildSettingBinding
import com.example.pandas.ui.activity.*
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.startToActivity
import com.example.pandas.ui.view.dialog.TimingBottomSheetDialog

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
//            startActivity(Intent(activity, LocalCacheActivity::class.java))
            mViewModel.IntUpdate()
        }
        binding.clayoutHistory.setOnClickListener {
            startAnyActivity(mActivity, HistoryActivity::class.java)
        }
        binding.clayoutSetting.setOnClickListener {
            startToActivity(mActivity, SettingActivity::class.java)
        }
        binding.clayoutMineExp.setOnClickListener {
            showToast("个人积分")
        }
        binding.clayoutSettingTiming.setOnClickListener {

            val dialog = TimingBottomSheetDialog(mActivity, object : ItemClickListener<Int> {
                override fun onItemClick(t: Int) {

                }
            })
            dialog.onShow()
        }
        binding.clayoutSelf.setOnClickListener {
            startAnyActivity(mActivity, SelfInfoActivity::class.java)
        }
        binding.cvError.setOnClickListener {
            startAnyActivity(mActivity, ErrorActivity::class.java)
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
            startAnyActivity(mActivity, SelfInfoActivity::class.java)
        }

        binding.clayoutLater.setOnClickListener {
            startAnyActivity(mActivity, LaterActivity::class.java)
        }

        binding.clayoutCollect.setOnClickListener {
            startAnyActivity(mActivity, CollectActivity::class.java)
        }
        binding.clayoutSettingLove.setOnClickListener {
            startAnyActivity(mActivity, LoveActivity::class.java)
        }
    }

    override fun createObserver() {

        mViewModel.follows.observe(viewLifecycleOwner) {
            binding.txtMineFollow.text = it.toString()
        }
    }

    override fun firstOnResume() {
        mViewModel.getCurrentFollows(mActivity)
    }

}