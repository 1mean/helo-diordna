package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.android.android_sqlite.entity.PetVideo
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: SleepVideoItemAdapter
 * @author: dongyiming
 * @date: 2/3/22 10:05 下午
 * @version: v1.0
 */
class SleepVideoItemAdapter(list: MutableList<PetVideo>) :
    BaseCommonAdapter<PetVideo>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_sleep_video_item

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_sleep_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_sleep_title)
        val context = holder.itemView.context

        data.cover?.let {
            //loadRoundedCornerImage(context, 20, it, cover)
            loadCenterImage(context, it, cover)
        }
        title.text = data.title

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, data)
        }
    }
}