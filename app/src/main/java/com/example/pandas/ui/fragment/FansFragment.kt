package com.example.pandas.ui.fragment
import android.os.Bundle
import android.view.View
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.databinding.LayoutSwipRefreshBinding

/**
 * @description: FansFragment
 * @author: dongyiming
 * @date: 5/10/22 8:56 下午
 * @version: v1.0
 */
public class FansFragment : BaseFragment<BaseViewModel, LayoutSwipRefreshBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}