package com.example.pandas.ui.fragment.main.face

import android.os.Bundle
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.FragmentFaceBinding
import com.example.pandas.ui.activity.Face2Activity
import com.example.pandas.ui.activity.FaceLoginActivity
import com.example.pandas.ui.ext.startAnyActivity

/**
 * @description: 人脸识别界面
 * @author: dongyiming
 * @date: 6/14/22 6:52 下午
 * @version: v1.0
 */
public class FaceFragment : BaseFragment<BaseViewModel, FragmentFaceBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        binding.btnFaceDetection.setOnClickListener {
            it.postDelayed({
                startAnyActivity(mActivity, Face2Activity::class.java)
            }, 300)
        }
        binding.btnFaceLogin.setOnClickListener {
            it.postDelayed({
                startAnyActivity(mActivity, FaceLoginActivity::class.java)
            }, 300)
        }
    }

    override fun createObserver() {


    }

    override fun firstOnResume() {

    }
}