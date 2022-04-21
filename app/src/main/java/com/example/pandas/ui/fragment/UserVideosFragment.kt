package com.example.pandas.ui.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding

/**
 * @description: 用户个人中心视频界面
 * @author: dongyiming
 * @date: 4/22/22 1:00 上午
 * @version: v1.0
 */
public class UserVideosFragment : BaseFragment<UserInfoViewModel, LayoutSwipRefreshBinding>() {

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