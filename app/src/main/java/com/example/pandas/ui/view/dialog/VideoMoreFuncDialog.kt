package com.example.pandas.ui.view.dialog

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.android.base.utils.ScreenUtil
import com.example.pandas.R
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogVideoMoreFuncBinding
import com.example.pandas.ui.adapter.decoration.SpeedItemDecoration
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class VideoMoreFuncDialog(
    context: Context,
    private val listener: ItemClickListener<Int>
) :
    BottomSheetDialog(context,R.style.CustomBottomSheetDialog) {

    private var _binding: DialogVideoMoreFuncBinding? = null
    val binding: DialogVideoMoreFuncBinding get() = _binding!!

    //("2.0", "1.5", "1.25", "1.0", "0.75", "0.5")
    private val speedList = arrayOf("0.75x", "1.0x", "1.25x", "1.5x", "2.0x")
    private val speedItems: MutableList<SpeedItem>
        get() = mutableListOf<SpeedItem>().apply {
            speedList.forEach { speedStr ->
                if (speedStr.equals("1.0x")) {
                    add(SpeedItem(speedStr, true))
                } else {
                    add(SpeedItem(speedStr, false))
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogVideoMoreFuncBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        //TODO:[bug] 在style里一顿操作设置了dialog的圆角后，导致dialog距离底部有间隙，这里必须设置具体高度
//        window?.attributes?.let {
//            it.gravity = Gravity.BOTTOM
//            it.width = ViewGroup.LayoutParams.MATCH_PARENT
//            it.height = ScreenUtil.dip2px(700f).toInt()
//        }

        initWidget()
    }

    private fun initWidget() {

        val paddingRight = context.resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
        binding.rvSpeed.run {
            addItemDecoration(SpeedItemDecoration(paddingRight))
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = SpeedAdapter(speedItems)
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }

    private inner class SpeedAdapter(private val list: MutableList<SpeedItem>) :
        BaseCommonAdapter<SpeedItem>(list) {

        private var lastSelected: Int = 1

        override fun getLayoutId(): Int = R.layout.adapter_item_speed

        override fun convert(holder: BaseViewHolder, data: SpeedItem, position: Int) {
            val name = holder.getWidget<AppCompatTextView>(R.id.txt_item_speed)

            name.text = data.speed

            if (data.isSelected) {
                name.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                name.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.color_bg_red
                    )
                )
            } else {
                name.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                name.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.color_video_name_txt
                    )
                )
            }
            holder.itemView.setOnClickListener {
                data.isSelected = true
                list[lastSelected].isSelected = false
                lastSelected = position
                notifyDataSetChanged()
            }
        }

    }

    private data class SpeedItem(var speed: String, var isSelected: Boolean)
}