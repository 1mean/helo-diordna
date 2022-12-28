package com.example.pandas.ui.view.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.databinding.DialogBottomTimingBinding
import com.example.pandas.ui.service.TimingService
import com.example.pandas.utils.ScreenUtil
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: TimingBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class TimingBottomSheetDialog(
    context: Context,
    private val listener: Any
) :
    BottomSheetDialog(context, R.style.CustomBottomSheetDialog) {

    private var selectPos: Int = 0
    private var _binding: DialogBottomTimingBinding? = null
    val binding: DialogBottomTimingBinding get() = _binding!!

    private val list = mutableListOf(0, 10, 20, 30, 45, 60)
    private val mAdapter: MyAdapter by lazy { MyAdapter(list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogBottomTimingBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        //TODO:[bug] 在style里一顿操作设置了dialog的圆角后，导致dialog距离底部有间隙，这里必须设置具体高度
        window?.attributes?.let {
            it.gravity = Gravity.BOTTOM
            it.width = ViewGroup.LayoutParams.MATCH_PARENT
            it.height = ScreenUtil.dip2px(700f).toInt()
        }
        initWidget()
    }


    private fun initWidget() {
        binding.rvBottomTiming.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }

    inner class MyAdapter(list: MutableList<Int>) : BaseCommonAdapter<Int>(list) {
        override fun getLayoutId(): Int = R.layout.adapter_timing_list

        @SuppressLint("NotifyDataSetChanged")
        override fun convert(holder: BaseViewHolder, data: Int, position: Int) {

            val context = holder.itemView.context
            val left = holder.getWidget<AppCompatTextView>(R.id.txt_name_dialog_timing)
            val right = holder.getWidget<AppCompatImageView>(R.id.img_timing_selected)

            when (data) {
                0 -> {
                    left.text = "关闭"
                }
                60 -> {
                    left.text = "1小时"
                }
                else -> {
                    left.text = StringBuilder("$data").append("分钟").toString()
                }
            }
            if (position == selectPos) {
                right.visibility = View.VISIBLE
                left.setTextColor(ContextCompat.getColor(context, R.color.color_name_txt))
            } else {
                right.visibility = View.GONE
                left.setTextColor(ContextCompat.getColor(context, R.color.black))
            }
            holder.itemView.setOnClickListener {

                val intent = Intent(context, TimingService::class.java).apply {
                    putExtra("time", data)
                }
                context.startService(intent)
                selectPos = position
                notifyDataSetChanged()
            }
        }
    }
}