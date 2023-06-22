package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineBinding
import com.example.pandas.ui.activity.BackGroundActivity
import com.example.pandas.ui.adapter.SelfViewPagerAdapter
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils


/**
 * @description: SelfFragment
 * @author: dongyiming
 * @date: 2021/11/25 3:57 下午
 * @version: v1.0
 */
public class SelfFragment : BaseFragment<SelfViewModel, FragmentMineBinding>() {

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    private val titles = arrayOf("设置", "缓存", "预留")
    private val pagerAdapter: SelfViewPagerAdapter by lazy { SelfViewPagerAdapter(mActivity) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.vp2Self.run {
            adapter = pagerAdapter
            currentItem = 0
        }
        binding.slideTabSetting.setViewPager(binding.vp2Self, titles)


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

    private fun updateTop(status: Int) {
        if (status == 0) {
            binding.layoutMineTop.setBackgroundResource(R.color.color_bg_self)
            binding.slideTabSetting.textSelectColor =
                ContextCompat.getColor(mActivity, R.color.color_tab_selected_self)
            binding.slideTabSetting.textUnselectColor =
                ContextCompat.getColor(mActivity, R.color.color_audio_menu_singer)
            binding.slideTabSetting.indicatorColor =
                ContextCompat.getColor(mActivity, R.color.color_home_tab_text_selected)

            binding.imgUpdateDark.setImageResource(R.mipmap.img_mine_dark_gray)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_gray)
        } else {
            binding.layoutMineTop.setBackgroundResource(AppInfos.bgColors[status])
            binding.slideTabSetting.textSelectColor =
                ContextCompat.getColor(mActivity, R.color.white)
            binding.slideTabSetting.textUnselectColor =
                ContextCompat.getColor(mActivity, R.color.white)
            binding.slideTabSetting.indicatorColor =
                ContextCompat.getColor(mActivity, R.color.white)

            binding.imgUpdateDark.setImageResource(R.mipmap.img_mine_dark_white)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_white)
        }
    }

    override fun createObserver() {

        mViewModel.intFlag.observe(viewLifecycleOwner) {

            binding.slideTabSetting.currentTab = 1
        }

        appViewModel.appColorType.observe(this) {
            updateTop(it)
        }
    }

    override fun firstOnResume() {
    }

    override fun onResume() {
        super.onResume()
    }
}