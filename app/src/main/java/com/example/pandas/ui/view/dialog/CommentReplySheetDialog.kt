package com.example.pandas.ui.view.dialog

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.pandas.databinding.DialogVerticalInputBinding
import com.example.pandas.utils.SoftInputUtils
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class CommentReplySheetDialog(
    private val mContext: Context,
    private val listener: ShortPopuListener
) :
    BottomSheetDialog(mContext) {

    private var _binding: DialogVerticalInputBinding? = null
    val binding: DialogVerticalInputBinding get() = _binding!!

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        _binding = DialogVerticalInputBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        //(mContext as Activity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
//        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)


        binding.editVerticalInput.setOnClickListener {
            SoftInputUtils.showSoftInput(mContext,binding.editVerticalInput)
        }
        initWidget()
    }

    private fun initWidget() {


    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }

    interface ShortPopuListener {

        fun openEmoji(view: View)

        fun sendComment(comment: String)

        fun dissmiss(comment: String)
    }
}