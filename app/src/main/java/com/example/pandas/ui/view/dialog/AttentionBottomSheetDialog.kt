package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class AttentionBottomSheetDialog(
    context: Context,
    private val onItemClick: (t: Int) -> Unit
) :
    BottomSheetDialog(context) {

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
            onItemClick(0)
            dismiss()
        }

        binding.rlayoutGroup.setOnClickListener {
            onItemClick(1)
            dismiss()
        }

        binding.rlayoutCancel.setOnClickListener {
            onItemClick(2)
            dismiss()
        }

        binding.txtCancel.setOnClickListener {
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}