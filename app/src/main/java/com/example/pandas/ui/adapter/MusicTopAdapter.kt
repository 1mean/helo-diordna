package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import com.android.android_sqlite.entity.VideoAndUser
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: MusicTopAdapter
 * @author: dongyiming
 * @date: 6/28/22 6:09 下午
 * @version: v1.0
 */
public class MusicTopAdapter(list: MutableList<VideoAndUser>) :
    BaseCommonAdapter<VideoAndUser>(list) {

    override fun getLayoutId(): Int = R.layout.item_music_top

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_music_top_cover)

        val video = data.video

        video.cover?.let {
//            loadCenterImage(context, it, cover)
            loadCenterRoundedCornerImage(context, 20, it, cover)
        }

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, video)
        }
    }
}