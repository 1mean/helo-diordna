package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogHomeItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class MoreBottomSheetDialog(
    context: Context,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context) {

    private var _binding: DialogHomeItemBinding? = null
    val binding: DialogHomeItemBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogHomeItemBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        initWidget()
    }

    private fun initWidget() {

        binding.rlayoutDialogCancel.isClickable = true
        binding.rlayoutDialogCancel.setOnClickListener {
            dismiss()
        }
        binding.txtHomeDialog1.setOnClickListener {
            dismiss()
        }
        binding.txtHomeDialog2.setOnClickListener {
            dismiss()
        }
        binding.txtHomeDialog3.setOnClickListener {
            dismiss()
        }
        binding.txtHomeDialog4.setOnClickListener {
            dismiss()
        }
        binding.llayoutDialogTop.setOnClickListener {
            listener.onItemClick(0)
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}