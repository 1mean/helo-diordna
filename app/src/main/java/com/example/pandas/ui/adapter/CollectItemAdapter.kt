package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.android.android_sqlite.entity.Group
import com.android.base.interaction.AdapterListener
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadImage

/**
 * @description: CollectItemAdapter
 * @author: dongyiming
 * @date: 8/28/24 11:26 AM
 * @version: v1.0
 */
public class CollectItemAdapter(
    list: MutableList<Group> = mutableListOf(),
    private val listener: AdapterListener<Group>
) :
    BaseCommonAdapter<Group>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_item_collect

    override fun convert(holder: BaseViewHolder, data: Group, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_item_collect)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_title_collect)
        val desc = holder.getWidget<AppCompatTextView>(R.id.txt_desc_collect)

        loadImage(context, data.groupCover, cover)
        title.text = data.groupName
        val str = if (data.open) {
            " • 公开"
        } else {
            " • 私密"
        }
        val counts = data.videoCounts
        desc.text = "$counts 个内容 $str"

        holder.itemView.setOnClickListener {
            listener.itemClick(position, data)
        }

    }

}