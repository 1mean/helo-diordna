package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.bean.ShareItem
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogDeleteBinding
import com.example.pandas.databinding.DialogShareBinding
import com.example.pandas.ui.adapter.ShareDialogAdapter
import com.example.pandas.ui.adapter.decoration.ShareItemDecoration
import com.example.pandas.ui.ext.setAnimation
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class DeleteBottomSheetDialog(
    context: Context,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context) {

    private var _binding: DialogDeleteBinding? = null
    val binding: DialogDeleteBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogDeleteBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        binding.btnDeleteClose.setOnClickListener {
            dismiss()
        }

        binding.clayoutDialogDeleteTop.setOnClickListener {
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