package com.example.pandas.ui.adapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.sql.entity.VideoAndUser

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
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_music_top_title)

        val video = data.video

        video.cover?.let {
            loadRoundedCornerImage(context, 20, it, cover)
        }

        title.text = video.title

        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, video.code, false)
        }
    }
}