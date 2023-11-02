package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineInfoBinding
import com.example.pandas.databinding.FragmentSexBinding
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: SexSettingFragment
 * @author: dongyiming
 * @date: 7/22/23 1:22 PM
 * @version: v1.0
 */
public class SexSettingFragment : BaseLazyFragment<SelfViewModel, FragmentSexBinding>() {

    private var sexIndex = 0
    private var curSexIndex = 0

    private val imgResource
        get() = arrayOf(
            R.mipmap.img_mine_selected,
            R.mipmap.img_mine_unselected
        )

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        mViewModel.userInfo.value?.let {
            when (it.sex) {
                0 -> {
                    sexIndex = 0
                    binding.imgMale.setImageResource(imgResource[0])
                }
                1 -> {
                    sexIndex = 1
                    binding.imgSexFemale.setImageResource(imgResource[0])
                }
                -1 -> {
                    sexIndex = -1
                    binding.imgSexSecret.setImageResource(imgResource[0])
                }
            }

        }

        binding.clayoutSexType1.setOnClickListener {
            curSexIndex = 0
            binding.imgMale.setImageResource(imgResource[0])
            binding.imgSexFemale.setImageResource(imgResource[1])
            binding.imgSexSecret.setImageResource(imgResource[1])
        }

        binding.clayoutSexType2.setOnClickListener {
            curSexIndex = 1
            binding.imgMale.setImageResource(imgResource[1])
            binding.imgSexFemale.setImageResource(imgResource[0])
            binding.imgSexSecret.setImageResource(imgResource[1])
        }

        binding.clayoutSexType3.setOnClickListener {
            curSexIndex = -1
            binding.imgMale.setImageResource(imgResource[1])
            binding.imgSexFemale.setImageResource(imgResource[1])
            binding.imgSexSecret.setImageResource(imgResource[0])
        }

        binding.btnSexSure.setOnClickListener {
            if (curSexIndex == sexIndex) {
            } else {
                Log.e("1mean", "11111")
                showLoading()
                val user = mViewModel.userInfo.value
                user?.let { curUser ->
                    Log.e("1mean", "curSexIndex: $curSexIndex")
                    curUser.sex = curSexIndex
                    mViewModel.updateUser(curUser)
                }
            }
        }
    }

    override fun createObserver() {

        mViewModel.updateUserResult.observe(viewLifecycleOwner) {

            binding.llayoutInfoSex.postDelayed({
                mViewModel.userInfo.value = it
                loadingPopup?.dismiss()
                appViewModel.sexUpdate.value = it.sex
            }, 500)
        }
    }

    override fun firstOnResume() {
    }

    private var loadingPopup: LoadingPopupView? = null
    private fun showLoading() {
        if (loadingPopup == null) {
            loadingPopup =
                XPopup.Builder(mActivity).dismissOnBackPressed(true)
                    .isLightNavigationBar(true)
                    .dismissOnTouchOutside(true)
                    .isViewMode(false)
                    .asLoading(
                        null,
                        R.layout.layout_waiting,
                        LoadingPopupView.Style.ProgressBar
                    )
            loadingPopup!!.show()
        } else {
            loadingPopup!!.show()
        }
    }
}