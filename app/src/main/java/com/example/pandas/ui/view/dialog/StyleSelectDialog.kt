package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogTypeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class StyleSelectDialog(
    context: Context,
    private val stypeType: Int,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context) {

    private var _binding: DialogTypeBinding? = null
    val binding: DialogTypeBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogTypeBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        when (stypeType) {
            0 -> {
                binding.checkType1.visibility = View.VISIBLE
                binding.checkType2.visibility = View.GONE
            }
            1 -> {
                binding.checkType1.visibility = View.GONE
                binding.checkType2.visibility = View.VISIBLE
            }
        }

        binding.checkType1.setColor(
            ContextCompat.getColor(
                context,
                R.color.color_txt_item_dialog_selfinfo
            )
        )
        binding.checkType2.setColor(
            ContextCompat.getColor(
                context,
                R.color.color_txt_item_dialog_selfinfo
            )
        )

        binding.tvCancel.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.color_txt_cancel_dialog_selfinfo
            )
        )
        binding.tvCancel.setOnClickListener {
            dismiss()
        }
        binding.clayoutType1.setOnClickListener {
            listener.onItemClick(0)
            dismiss()
        }
        binding.clayoutType2.setOnClickListener {
            listener.onItemClick(1)
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}