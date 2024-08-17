package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.android.android_sqlite.entity.VideoAndUser
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: PandaListAdapter
 * @author: dongyiming
 * @date: 3/28/22 2:56 下午
 * @version: v1.0
 */
public class PandaListAdapter(list: MutableList<VideoAndUser>) :
    BaseCommonAdapter<VideoAndUser>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_item_pandas_list

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_pandas_item_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_pandas_item_title)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_panda_item_duration)
        val username = holder.getWidget<AppCompatTextView>(R.id.txt_video_username)

        val video = data.video
        val user = data.user
        video.cover?.let {
            loadCenterImage(context, it, cover)
        }

        username.text = user.userName

        duration.text = TimeUtils.getDuration(video.duration.toLong())

        title.text = video.title

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, video)
        }
    }

}