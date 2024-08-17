package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.android.base.ui.fragment.BaseFragment
import com.android.base.vm.BaseViewModel
import com.example.pandas.databinding.FragmentMineStyleBinding
import com.example.pandas.utils.SPUtils

/**
 * @description: 我的-设置-我的界面样式
 * @author: dongyiming
 * @date: 7/4/23 1:33 PM
 * @version: v1.0
 */
public class MineStyleFragment : BaseFragment<BaseViewModel, FragmentMineStyleBinding>() {

    private val imgResource
        get() = arrayOf(
            R.mipmap.img_mine_selected,
            R.mipmap.img_mine_unselected
        )

    override fun initView(savedInstanceState: Bundle?) {

        val type = SPUtils.getInt(mActivity, AppInfos.MINE_STYLE_KEY)
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
            SPUtils.putInt(mActivity, AppInfos.MINE_STYLE_KEY, 0)
        }

        binding.clayoutType2.setOnClickListener {
            binding.btnMineNormal.setImageResource(imgResource[1])
            binding.btnMineVp.setImageResource(imgResource[0])
            SPUtils.putInt(mActivity, AppInfos.MINE_STYLE_KEY, 1)
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }
}