package com.example.pandas.ui.view.dialog

import android.app.Activity
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
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.ui.ext.toastTopShow
import com.google.android.exoplayer2.Player
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class VideoMoreFuncDialog(
    private val mContext: Context,
    private val repeatMode: Int,
    private val listener: MoreFunctionListener
) :
    BottomSheetDialog(mContext, R.style.CustomBottomSheetDialog) {

    private var _binding: DialogVideoMoreFuncBinding? = null
    val binding: DialogVideoMoreFuncBinding get() = _binding!!

    //("2.0", "1.5", "1.25", "1.0", "0.75", "0.5")
    private val speedList = arrayOf("0.75", "1.0", "1.25", "1.5", "2.0")
    private val speedItems: MutableList<SpeedItem>
        get() = mutableListOf<SpeedItem>().apply {
            speedList.forEach { speedStr ->
                if (speedStr.equals("1.0")) {
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

        if (repeatMode == Player.REPEAT_MODE_OFF) {
            binding.switchPlay.isOpened = true
        } else {
            binding.switchPlay.isOpened = false
        }
        initWidget()
    }

    private fun initWidget() {

        val paddingRight = context.resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
        binding.rvSpeed.run {
            addItemDecoration(SpeedItemDecoration(paddingRight))
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = SpeedAdapter(speedItems) { speed ->
                listener.updateSpeed(speed)
                dismiss()
            }
        }

        binding.clayoutItemRecommend.setOnClickListener {

        }

        binding.clayoutTopItemDownload.setOnClickListener {
            toastTopShow(mContext as Activity, "下载功能未开放")
            dismiss()
        }

        binding.clayoutTopItemLike.setOnClickListener { //助力视频
            toastTopShow(mContext as Activity, "助力成功")
            dismiss()
        }

        binding.clayoutTopItemUnlike.setOnClickListener {
            listener.unLike()
            dismiss()
        }

        binding.clayoutPlayType.setOnClickListener {
            val isOpen = binding.switchPlay.isOpened
            listener.autoPlay(!isOpen)
            if (isOpen) {
                binding.switchPlay.isOpened = false
            } else {
                binding.switchPlay.isOpened = true
            }
            dismiss()
        }

        val isOpen = binding.switchPlay.isOpened
        binding.switchPlay.setOnClickListener {
            listener.autoPlay(!isOpen)
            dismiss()
        }

        binding.clayoutTopItemLater.setOnClickListener {
            listener.addLaterPlay()
            dismiss()
        }

        binding.clayoutScreenClean.setOnClickListener {
            listener.screenClear()
            dismiss()
        }
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }

    private inner class SpeedAdapter(
        private val list: MutableList<SpeedItem>,
        private val itemClick: (speed: Float) -> Unit
    ) :
        BaseCommonAdapter<SpeedItem>(list) {

        private var lastSelected: Int = 1

        override fun getLayoutId(): Int = R.layout.adapter_item_speed

        override fun convert(holder: BaseViewHolder, data: SpeedItem, position: Int) {
            val name = holder.getWidget<AppCompatTextView>(R.id.txt_item_speed)

            name.text = data.speed + "x"

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
                itemClick.invoke(list[position].speed.toFloat())
                notifyDataSetChanged()
            }
        }
    }

    private data class SpeedItem(var speed: String, var isSelected: Boolean)

    interface MoreFunctionListener {
        fun updateSpeed(speed: Float)
        fun unLike()
        fun autoPlay(isAuto: Boolean)
        fun addLaterPlay()
        fun screenClear()
    }
}