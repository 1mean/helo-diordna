package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding

/**
 * @description: UserDailyFragment
 * @author: dongyiming
 * @date: 4/24/22 5:13 下午
 * @version: v1.0
 */
public class UserDailyFragment : BaseFragment<UserInfoViewModel, LayoutSwipRefreshBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        binding.swipLayout.isEnabled = false
//        binding.layoutEmpty.llayoutEmpty.setBackgroundResource(R.color.white)
        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}