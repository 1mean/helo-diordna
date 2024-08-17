package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogBottomLiveBinding
import com.example.pandas.databinding.DialogFaceUploadBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class FaceAddSheetDialog(
    context: Context,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context) {

    private var _binding: DialogFaceUploadBinding? = null
    val binding: DialogFaceUploadBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogFaceUploadBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        binding.txtLiveBottomCancel.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.color_txt_cancel_dialog_selfinfo
            )
        )
        binding.txtLiveBottomCancel.setOnClickListener {
            dismiss()
        }
        binding.llayoutDialogFaceCamera.setOnClickListener {
            listener.onItemClick(1)
            dismiss()
        }
        binding.llayoutDialogFacePic.setOnClickListener {
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