package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogBottomLiveBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class LiveBottomSheetDialog(
    context: Context,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context) {

    private var _binding: DialogBottomLiveBinding? = null
    val binding: DialogBottomLiveBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogBottomLiveBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        binding.txtLiveBottomCancel.setOnClickListener {
            dismiss()
        }
        binding.llayoutLiveBottomLater.setOnClickListener {
            listener.onItemClick(1)
            dismiss()
        }
        binding.llayoutLiveBottomShare.setOnClickListener {
            listener.onItemClick(2)
            dismiss()
        }
        binding.llayoutLiveBottomAttention.setOnClickListener {
            listener.onItemClick(3)
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}