package com.example.pandas.ui.fragment.user

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.FragmentDailyBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding

/**
 * @description: UserDailyFragment
 * @author: dongyiming
 * @date: 4/24/22 5:13 下午
 * @version: v1.0
 */
public class UserDailyFragment : BaseFragment<UserInfoViewModel, FragmentDailyBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}