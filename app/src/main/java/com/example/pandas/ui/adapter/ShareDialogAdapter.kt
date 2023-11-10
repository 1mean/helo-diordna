package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.ShareItem
import com.example.pandas.biz.interaction.ItemClickListener

/**
 * @description: ShareDialogAdapter
 * @author: dongyiming
 * @date: 8/4/22 5:04 下午
 * @version: v1.0
 */
public class ShareDialogAdapter(
    list: MutableList<ShareItem> = mutableListOf(),
    private val onItemClick: (t: String) -> Unit
) :
    BaseCommonAdapter<ShareItem>(list) {

    override fun getLayoutId(): Int = R.layout.layout_share_item

    override fun convert(holder: BaseViewHolder, data: ShareItem, position: Int) {

        val image = holder.getWidget<AppCompatImageView>(R.id.img_share_item)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_share_item)

        image.setImageResource(data.imgRes)
        name.text = data.name

        if (data.name == "动态") {
            image.setBackgroundResource(R.drawable.shape_bg_share)
        } else {
            image.background = null
        }

        holder.itemView.setOnClickListener {
            onItemClick(data.name)
        }
    }

}