package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.util.Log
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.FragmentAuthenBinding

/**
 * @description: AuthenFragment
 * @author: dongyiming
 * @date: 10/8/23 11:12 PM
 * @version: v1.0
 */
public class AuthenFragment : BaseFragment<BaseViewModel, FragmentAuthenBinding>() {

    companion object {
        fun newInstance(name: String, card: String): AuthenFragment {
            val args = Bundle().apply {
                putString("name", name)
                putString("card", card)
            }
            val fragment = AuthenFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        val card = arguments?.getString("card")
        val name = arguments?.getString("name")

        val size1 = name!!.length - 1
        val size2 = card!!.length - 2
        val space1 = StringBuilder("")
        val space2 = StringBuilder("")
        for (i in (1..size1)) {
            space1.append("x")
        }
        for (i in (1..size2)) {
            space2.append("x")
        }
        val name1 = name.replaceRange(1, name.length, space1.toString())
        val card1 = card.replaceRange(1, size2, space2.toString())
        Log.e("1mean", "name1:$name1 , card1:$card1,space1:$space1,space2:$space2")
        binding.txtAuthenticationName2.text = name1.toString()
        binding.txtAuthenticationCard2.text = card1.toString()

        binding.txtAuthenUpdate.setOnClickListener {
            mActivity.supportFragmentManager.popBackStack()
        }

    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}