package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity

/**
 * @description: SleepVideoItemAdapter
 * @author: dongyiming
 * @date: 2/3/22 10:05 下午
 * @version: v1.0
 */
class SleepVideoItemAdapter(list: MutableList<PetViewData>) :
    BaseCommonAdapter<PetViewData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_sleep_video_item

    override fun convert(holder: BaseViewHolder, data: PetViewData, position: Int) {
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_sleep_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_sleep_title)
        val context = holder.itemView.context

        loadRoundedCornerImage(context, 20, data.cover, cover)
        title.text = data.title

        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code, false)
        }
    }
}