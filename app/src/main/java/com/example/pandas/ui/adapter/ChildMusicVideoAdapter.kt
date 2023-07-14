package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.utils.TimeUtils

/**
 * @description: ChildMusicVideoAdapter
 * @author: dongyiming
 * @date: 2/17/22 5:39 下午
 * @version: v1.0
 */
public class ChildMusicVideoAdapter(
    private val list: MutableList<VideoAndUser> = mutableListOf()
) :
    BaseCommonAdapter<VideoAndUser>(list) {

    override fun getLayoutId(): Int = R.layout.child_adapter_item3_music

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_music_item_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_music_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_music_item3_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_music_item3_name)

        val video = data.video
        val user = data.user

        name.text = user.userName
        title.text = video.title
        duration.text = TimeUtils.getDuration(video.duration.toLong())
        video.cover?.let {
            loadCenterImage(context, it, cover)
        }

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, video)
        }
    }
}