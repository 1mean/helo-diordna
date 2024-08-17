package com.example.pandas.ui.view.dialog

import AppInstance
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogBottomLiveBinding
import com.example.pandas.databinding.DialogFaceUploadBinding
import com.example.pandas.databinding.DialogSexBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class SexSelectDialog(
    context: Context,
    private val sexType: Int,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context) {

    private var _binding: DialogSexBinding? = null
    val binding: DialogSexBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogSexBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        Log.e("1mean","sexType=$sexType")
        when (sexType) {
            0 -> {
                binding.checkFemale.visibility = View.GONE
                binding.checkMale.visibility = View.VISIBLE
                binding.checkSecret.visibility = View.GONE
            }
            1 -> {
                binding.checkFemale.visibility = View.VISIBLE
                binding.checkMale.visibility = View.GONE
                binding.checkSecret.visibility = View.GONE
            }
            2 -> {
                binding.checkFemale.visibility = View.GONE
                binding.checkMale.visibility = View.GONE
                binding.checkSecret.visibility = View.VISIBLE
            }
        }

        binding.checkMale.setColor(
            ContextCompat.getColor(
                context,
                R.color.color_txt_item_dialog_selfinfo
            )
        )
        binding.checkFemale.setColor(
            ContextCompat.getColor(
                context,
                R.color.color_txt_item_dialog_selfinfo
            )
        )
        binding.checkSecret.setColor(
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
        binding.clayoutFemale.setOnClickListener {
            listener.onItemClick(1)
            dismiss()
        }
        binding.clayoutMale.setOnClickListener {
            listener.onItemClick(0)
            dismiss()
        }
        binding.clayoutSexSecret.setOnClickListener {
            listener.onItemClick(2)
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}