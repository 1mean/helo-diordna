package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.utils.TimeUtils

/**
 * @description: PandaListAdapter
 * @author: dongyiming
 * @date: 3/28/22 2:56 下午
 * @version: v1.0
 */
public class PandaListAdapter(list: MutableList<PetVideo>) :
    BaseCommonAdapter<PetVideo>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_item_pandas_list

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_pandas_item_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_pandas_item_title)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_panda_item_duration)

        data.cover?.let {
            loadImage(context, it, cover)
        }

        duration.text = TimeUtils.getDuration(data.duration.toLong())

        title.text = data.title

        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code)
        }
    }

}