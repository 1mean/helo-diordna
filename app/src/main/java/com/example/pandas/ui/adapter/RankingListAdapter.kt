package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: VideoListAdapter
 * @author: dongyiming
 * @date: 3/2/22 12:50 上午
 * @version: v1.0
 */
public class RankingListAdapter(list: MutableList<VideoAndUser>) :
    BaseCommonAdapter<VideoAndUser>(list) {

    private val max = 1 * 1000 * 1000 * 2
    private val th = 1 * 1000 * 1000

    override fun getLayoutId(): Int = R.layout.adapter_ranking

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val cover = holder.getWidget<AppCompatImageView>(R.id.img_ranking_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_ranking_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_ranking_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_ranking_author)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_ranking_video)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_ranking_time)
        val rankingText = holder.getWidget<AppCompatTextView>(R.id.txt_ranking)
        val rankingLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_ranking)

        val video = data.video
        val user = data.user

        when (position) {
            0 -> rankingLayout.setBackgroundResource(R.drawable.shape_ranking_1)
            1 -> rankingLayout.setBackgroundResource(R.drawable.shape_ranking_2)
            2 -> rankingLayout.setBackgroundResource(R.drawable.shape_ranking_3)
            else -> rankingLayout.setBackgroundResource(R.drawable.shape_ranking_other)
        }

        rankingText.text = (position + 1).toString()

        video.cover?.let {
            loadCenterRoundedCornerImage(holder.itemView.context, 20, it, cover)
        }
        duration.text = TimeUtils.getDuration(video.duration.toLong())
        title.text = video.title
        name.text = user.userName

        val rCounts = (1..max).random()
        val rCountsString = NumUtils.getShortNum(rCounts)
        counts.text = rCountsString

        val parseTime = TimeUtils.descriptiveData(video.releaseTime)
        time.text = StringBuilder("- ").append(parseTime).toString()

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(holder.itemView.context, video)
        }
    }

}