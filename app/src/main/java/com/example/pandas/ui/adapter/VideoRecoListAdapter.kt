package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.OnVideoItemClickLIstener
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.view.dialog.MoreBottomSheetDialog
import com.example.pandas.utils.TimeUtils

/**
 * @description: 播放详情页推荐视频列表
 * @author: dongyiming
 * @date: 2/15/22 9:50 下午
 * @version: v1.0
 */
public class VideoRecoListAdapter(
    list: MutableList<PetVideo> = mutableListOf(),
    private val listener: OnVideoItemClickLIstener
) :
    BaseCommonAdapter<PetVideo>(list) {

    private var dialog: MoreBottomSheetDialog? = null

    override fun getLayoutId(): Int = R.layout.item_video_intro

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_video_reco_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_video_reco_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_video_reco_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_video_reco_name)
        val playCounts = holder.getWidget<AppCompatTextView>(R.id.txt_video_info_counts)
        val comments = holder.getWidget<AppCompatTextView>(R.id.txt_video_info_comment)
        val loadMoreLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_video_info_more)

        data.cover?.let {
            loadRoundedCornerImage(context, 15, it, cover)
        }
        duration.text = TimeUtils.getDuration(data.duration.toLong())
        title.text = data.title
        data.user?.let {
            name.text = it.userName
        }
        holder.itemView.setOnClickListener {
            listener.onClick(position, data.code)
        }

        loadMoreLayout.setOnClickListener {
            if (dialog == null) {
                dialog = MoreBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                    }
                })
            }
            dialog!!.onShow()
        }

        val videoData = data.videoData
        if (videoData == null) {
            playCounts.text = "0"
            comments.text = " - "
        } else {
            playCounts.text = videoData.plays.toString()
            val counts = videoData.comments
            if (counts == 0) {
                comments.text = " - "
            } else {
                comments.text = counts.toString()
            }
        }
    }
}