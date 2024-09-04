package com.example.pandas.ui.fragment.search

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.android.android_sqlite.entity.VideoAndUser
import com.android.base.utils.NumUtils
import com.android.base.utils.StringColorUtil
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: SearchResultAdapter
 * @author: dongyiming
 * @date: 7/19/22 11:48 下午
 * @version: v1.0
 */
public class SearchResultAdapter(
    private var keyWord: String,
    private val list: MutableList<VideoAndUser> = mutableListOf()
) :
    BaseCommonAdapter<VideoAndUser>(list) {

    private val max = 1 * 1000 * 1000 * 2
    private val th = 1 * 1000 * 1000

    /**
     * 刷新界面
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(keyWord: String, data: MutableList<VideoAndUser>) {

        this.keyWord = keyWord
        if (data.isNotEmpty() && data != list) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun getLayoutId(): Int = R.layout.adapter_hot_fragment

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_hot_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_hot_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_hot_title)
        val author = holder.getWidget<AppCompatTextView>(R.id.txt_hot_author)
        val playCounts = holder.getWidget<AppCompatTextView>(R.id.txt_hot_video_counts)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_hot_time)
        val color = ContextCompat.getColor(context, R.color.color_search_text_like)
        val user = data.user
        val video = data.video

        video.cover?.let {
            loadCenterImage(context, it, cover)
        }
        duration.text = TimeUtils.getDuration(video.duration.toLong())
        video.title?.let {
            val name = StringColorUtil.fillColor(it, keyWord, color)
            title.text = StringColorUtil.fillColor(it, keyWord, color)
        }

        val rCounts = (1..max).random()
        val rCountsString = NumUtils.getShortNum(rCounts)
        playCounts.text = rCountsString

        author.text = user.userName

        val parseTime = TimeUtils.getMdTime(video.releaseTime)
        time.text = StringBuilder("- ").append(parseTime).toString()

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, video)
        }
    }

}