package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pandas.biz.interaction.VideoMoreSelectListener
import com.example.pandas.databinding.DialogVideoMoreBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class VideoMoreBottomSheetDialog(
    context: Context,
    private val listener: VideoMoreSelectListener
) :
    BottomSheetDialog(context) {

    private var _binding: DialogVideoMoreBinding? = null
    val binding: DialogVideoMoreBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogVideoMoreBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        binding.btnShareClose.setOnClickListener {
            dismiss()
        }

        binding.clayoutVideoMoreLater.setOnClickListener {
            listener.addPlayLater()
        }

        binding.clayoutVideoMoreSpeed.setOnClickListener {
            listener.setPlaySpeed()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }
}