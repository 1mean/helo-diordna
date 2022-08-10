package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.HistoryItem
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.utils.TimeUtils

/**
 * @description: HistoryAdapter
 * @author: dongyiming
 * @date: 3/11/22 12:37 上午
 * @version: v1.0
 */
public class HistoryAdapter(private val list: MutableList<HistoryItem>) :
    BaseCommonAdapter<HistoryItem>(list) {

    var isShow: Boolean = false

    override fun getLayoutId(): Int = R.layout.adapter_history_item

    @SuppressLint("NotifyDataSetChanged")
    private fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun convert(holder: BaseViewHolder, data: HistoryItem, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_history_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_history_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_history_name)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_history_time)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_history_up)
        val select = holder.getWidget<AppCompatImageView>(R.id.ibn_history_item_select)

        val history = data.history
        val videoData = data.video
        val user = data.user

        user?.let {
            name.text = it.userName
        }

        if (isShow) {
            select.visibility = View.VISIBLE
        } else {
            select.visibility = View.GONE
        }

        if (data.selected) {
            select.setImageResource(R.mipmap.img_history_selected)
        } else {
            select.setImageResource(R.mipmap.img_history_unselect)
        }

        videoData?.let {
            loadCenterRoundedCornerImage(context, 15, it.cover, cover)
            title.text = it.title

            val videoDuration = TimeUtils.getMMDuration(it.duration.toLong())
            history?.let { his ->
                his.playPosition?.let { pos ->
                    duration.text =
                        StringBuilder(pos).append(" / ").append(videoDuration).toString()
                }
            }

            holder.itemView.setOnLongClickListener {
                if (!isShow) {
                    notifyAdapter()
                    isShow = true
                }
                true
            }

            holder.itemView.setOnClickListener { _ ->
                if (isShow) {
                    if (data.selected) {
                        select.setImageResource(R.mipmap.img_history_unselect)
                    } else {
                        select.setImageResource(R.mipmap.img_history_selected)
                    }
                    data.selected = !data.selected
                } else {
                    startVideoPlayActivity(context, it.code, false)
                }
            }
        }

        history?.let {
            time.text = TimeUtils.getTime(it.lastTime)
        }
    }

}