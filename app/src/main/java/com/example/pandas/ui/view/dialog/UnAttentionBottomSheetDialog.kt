package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class UnAttentionBottomSheetDialog(
    private val mContext: Context,
    private val unAttentionClick: () -> Unit
) :
    BottomSheetDialog(mContext) {

    private var _binding: DialogAttentionCancelBinding? = null
    val binding: DialogAttentionCancelBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogAttentionCancelBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {
        binding.rlayoutAdd.setOnClickListener {
            Toast.makeText(context, "加入特别关注", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        binding.rlayoutGroup.setOnClickListener {
            Toast.makeText(context, "加入默认分组", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        binding.txtCancel.setOnClickListener {
            dismiss()
        }

        binding.rlayoutCancel.setOnClickListener { _ ->
            unAttentionClick.invoke()
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}