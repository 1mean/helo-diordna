package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import com.android.android_sqlite.bean.BannerItem
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadImage

/**
 * @description: ImageAdapter
 * @author: dongyiming
 * @date: 5/6/22 1:34 上午
 * @version: v1.0
 */
public class ImageAdapter(list: MutableList<BannerItem>) : BaseCommonAdapter<BannerItem>(list) {
    override fun getLayoutId(): Int = R.layout.adapter_image

    override fun convert(holder: BaseViewHolder, data: BannerItem, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cm_cover)
        loadImage(context, data.cover, cover)
        holder.itemView.setOnClickListener {
            //startVideoPlayingActivity(context,data.)
        }
    }

}