package com.example.pandas.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.manager.KeyboardManager
import com.example.pandas.databinding.FragmentFaceBinding

/**
 * @description: 人脸识别界面
 * @author: dongyiming
 * @date: 6/14/22 6:52 下午
 * @version: v1.0
 */
public class FaceFragment : BaseFragment<BaseViewModel, FragmentFaceBinding>() {

    private var isShow: Boolean = false
    private val km: KeyboardManager by lazy { KeyboardManager(mActivity) }

    override fun initView(savedInstanceState: Bundle?) {


        binding.editFace.run {
            requestFocus()
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
            setOnClickListener {
                binding.editFace.isFocusable = true
            }

        }

        km.setOnSoftKeyBoardChangeListener(object : KeyboardManager.OnSoftKeyBoardChangeListener {
            override fun keyBoardShow(height: Int) {
                isShow = true
            }

            override fun keyBoardHide(height: Int) {
                isShow = false
            }
        })

        binding.btnFaceDelete.setOnClickListener {
            val content = binding.editFace.text.toString().trim()
            if (content.isNotEmpty()) {
                binding.editFace.setText("")
                binding.editFace.clearFocus()
            }
            if (isShow) {
                km.hideKeyBoard(mActivity,binding.editFace)
            }
        }

        binding.btnFaceGetinfo.setOnClickListener {

            if (!Python.isStarted()) {
                Python.start(AndroidPlatform(mActivity))
            }
            val py = Python.getInstance()
            val module = py.getModule("test1")
            val list = module.callAttr("parse")
            Log.e("1mean", "python解析： $list")
            val url = list.toString().replace("http", "https")
            loadImage(mActivity,url,binding.imgFaceVideoCover)
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}