package com.example.pandas.ui.fragment.main.mine

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentChildSettingBinding
import com.example.pandas.ui.activity.*
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.startToActivity
import com.example.pandas.ui.view.dialog.TimingBottomSheetDialog
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.util.SmartGlideImageLoader

/**
 * @description: 我的-设置
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class SelfChildSettingFragment : BaseFragment<SelfViewModel, FragmentChildSettingBinding>() {

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        //loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        loadImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)

        binding.viewHeader.setOnClickListener { showHeader() }

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

        binding.clayoutMineExp.setOnClickListener {
            startAnyActivity(mActivity, IntegralActivity::class.java)
        }

        binding.clayoutSettingAbout.setOnClickListener {
            startAnyActivity(mActivity, AboutActivity::class.java)
        }
    }

    override fun createObserver() {

        mViewModel.follows.observe(viewLifecycleOwner) {
            binding.txtMineFollow.text = it.toString()
        }

        appViewModel.appColorType.observe(viewLifecycleOwner) {
        }
    }

    override fun firstOnResume() {
        mViewModel.getCurrentFollows(mActivity)
    }

    private fun showHeader() {
        XPopup.Builder(context)
            .isDestroyOnDismiss(true)
            .asImageViewer(
                binding.imgMineHeader,
                AppInfos.HEAD_URL,
                true,
                Color.parseColor("#f1f1f1"),
                -1,
                0,
                true,
                Color.BLACK,
                SmartGlideImageLoader(R.mipmap.liuyifei)
            ) { popupView, position ->
                Toast.makeText(
                    requireContext(),
                    "点击右下角保存",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .show()
    }
}