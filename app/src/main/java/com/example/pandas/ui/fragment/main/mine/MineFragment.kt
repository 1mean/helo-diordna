package com.example.pandas.ui.fragment.main.mine

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentSettingBinding
import com.example.pandas.ui.activity.*
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.startToActivity
import com.example.pandas.ui.view.dialog.TimingBottomSheetDialog
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.util.SmartGlideImageLoader

/**
 * @description: 我的-设置
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class MineFragment : BaseFragment<SelfViewModel, FragmentSettingBinding>() {

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        //loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        binding.imgMineHeader.post {
            loadImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        }

        binding.imgMineHeader.setOnClickListener { showHeader() }

        binding.cardMineHistory.setOnClickListener {
            startAnyActivity(mActivity, HistoryActivity::class.java)
        }
        binding.clayoutSetting.setOnClickListener {
            startToActivity(mActivity, SettingActivity::class.java)
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

        binding.cardMineLater.setOnClickListener {
            startAnyActivity(mActivity, LaterActivity::class.java)
        }

        binding.cardMineCollect.setOnClickListener {
            startAnyActivity(mActivity, CollectActivity::class.java)
        }
        binding.clayoutSettingLove.setOnClickListener {
            startAnyActivity(mActivity, LoveActivity::class.java)
        }

        binding.llayoutMineExp.setOnClickListener {
            startAnyActivity(mActivity, IntegralActivity::class.java)
        }

        binding.clayoutSettingAbout.setOnClickListener {
            startAnyActivity(mActivity, AboutActivity::class.java)
        }

        binding.cardMineDownload.setOnClickListener {
            startAnyActivity(mActivity, DownLoadActivity::class.java)
        }

        //1。主题不一致，会导致MainActivity刷新重建，即会主动调用recreate方法
        //2。如果不想要重建，可在activity中设置android:configChanges="uiMode"，使模式的改变对其无效
        //3。在MainActivity的onConfigurationChanged方法里，自己处理界面的改变
        binding.itemModeDark.setOnClickListener {
            val nightMode = DarkModeUtils.getNightModel(mActivity)
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {//夜间模式
                DarkModeUtils.applyDayMode(mActivity)
                StatusBarUtils.updataStatus(mActivity, false, true, R.color.color_white_lucency)
            } else {
                DarkModeUtils.applyNightMode(mActivity)
                StatusBarUtils.updataStatus(mActivity, true, true, R.color.color_white_lucency)
            }
        }

        binding.itemCharacter.setOnClickListener {
            startAnyActivity(mActivity, BackGroundActivity::class.java)
        }

        appViewModel.appColorType.value?.let {
            updateTop(it)
        }
    }

    override fun createObserver() {

        mViewModel.follows.observe(viewLifecycleOwner) {
            binding.txtMineFollow.text = it.toString()
        }

        appViewModel.appColorType.observe(viewLifecycleOwner) {
        }

        appViewModel.appColorType.observe(this) {
            updateTop(it)
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

    private fun updateTop(status: Int) {
        if (status == 0) {
            binding.layoutMineTop.setBackgroundResource(R.color.color_bg_self)
            binding.clayoutTopInfo.setBackgroundResource(R.color.color_bg_self)
            binding.txtMineName.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_mine_name))
            binding.txtCoins.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_tab))
            binding.txtSelfZone.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_tab))
            binding.txtFan.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_tab))
            binding.txtAttention.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_tab))
            binding.txtZone.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_tab))
            binding.txtMineZone.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_fans_self))
            binding.txtMineFollow.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_fans_self))
            binding.txtMineFans.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_fans_self))
            binding.imgZoneTo.setImageResource(R.mipmap.img_setting_top_arror)


            binding.imgUpdateDark.setImageResource(R.mipmap.img_mine_dark_gray)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_gray)
        } else {
            binding.layoutMineTop.setBackgroundResource(AppInfos.bgColors[status])
            binding.clayoutTopInfo.setBackgroundResource(AppInfos.bgColors[status])
            binding.txtMineName.setTextColor(ContextCompat.getColor(mActivity,R.color.white))
            binding.txtCoins.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_top))
            binding.txtSelfZone.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_top))
            binding.txtFan.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_top))
            binding.txtAttention.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_top))
            binding.txtZone.setTextColor(ContextCompat.getColor(mActivity,R.color.color_txt_top))
            binding.txtMineZone.setTextColor(ContextCompat.getColor(mActivity,R.color.white))
            binding.txtMineFollow.setTextColor(ContextCompat.getColor(mActivity,R.color.white))
            binding.txtMineFans.setTextColor(ContextCompat.getColor(mActivity,R.color.white))
            binding.imgZoneTo.setImageResource(R.mipmap.img_setting_top_arror_white)


            binding.imgUpdateDark.setImageResource(R.mipmap.img_mine_dark_white)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_white)
        }
    }
}