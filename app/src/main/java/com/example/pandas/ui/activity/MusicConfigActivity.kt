package com.example.pandas.ui.activity

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivityMusicSettingConfigBinding
import com.example.pandas.databinding.ActivitySettingConfigBinding
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.main.mine.MineStyleFragment
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class MusicConfigActivity :
    BaseActivity<BaseViewModel, ActivityMusicSettingConfigBinding>() {

    private val imgResource
        get() = arrayOf(
            R.mipmap.img_mine_selected,
            R.mipmap.img_mine_unselected
        )

    override fun initView(savedInstanceState: Bundle?) {

        appViewModel.appColorType.value?.let {
            binding.clayoutConfigTop.setBackgroundResource(viewColors[it])
            if (it == 0) {
                binding.ibnSettingBack.setImageResource(R.mipmap.img_top_leave)
                binding.txtConfigTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.ibnSettingBack.setImageResource(R.mipmap.img_top_leave_white)
                binding.txtConfigTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
            }
        }

        //如果使用fragment，这里设置就会有重叠的重影，怎么都没办法修改好
//        supportFragmentManager.beginTransaction().add(R.id.fragment_mine_style, MineStyleFragment())
//            .commit()

        val type = SPUtils.getInt(this, AppInfos.MUSIC_STYLE_KEY)
        if (type == 0) {
            binding.btnMineNormal.setImageResource(imgResource[0])
            binding.btnMineVp.setImageResource(imgResource[1])
        } else {
            binding.btnMineNormal.setImageResource(imgResource[1])
            binding.btnMineVp.setImageResource(imgResource[0])
        }

        binding.clayoutType1.setOnClickListener {
            binding.btnMineNormal.setImageResource(imgResource[0])
            binding.btnMineVp.setImageResource(imgResource[1])
            SPUtils.putInt(this, AppInfos.MUSIC_STYLE_KEY, 0)
        }

        binding.clayoutType2.setOnClickListener {
            binding.btnMineNormal.setImageResource(imgResource[1])
            binding.btnMineVp.setImageResource(imgResource[0])
            SPUtils.putInt(this, AppInfos.MUSIC_STYLE_KEY, 1)
        }

        binding.ibnSettingBack.setOnClickListener {
            finish()
        }
    }

    override fun createObserver() {

    }

    override fun onResume() {
        super.onResume()
    }
}