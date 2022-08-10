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
public class HistoryAdapter(
    private val list: MutableList<HistoryItem> = mutableListOf(),
    private val listener: HistoryListener
) :
    BaseCommonAdapter<HistoryItem>(list) {

    var isShow: Boolean = false
    var isSelectAll:Boolean = false

    var selectPositions: MutableList<Int> = mutableListOf()

    override fun getLayoutId(): Int = R.layout.adapter_history_item

    interface HistoryListener {
        fun onLongClick()
    }

    override fun loadMore(newList: MutableList<HistoryItem>) {
        if (newList.isNotEmpty()) {
            val size = list.size
            if (isSelectAll) {
                newList.forEach {
                    it.selected = true
                    list.add(it)
                }
            } else {
                list.addAll(newList)
            }
            notifyItemRangeInserted(size, list.size)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun manager(isClose: Boolean) {

        if (isClose) {
            if (isShow) {
                if (selectPositions.isNotEmpty()) {
                    selectPositions.forEach {
                        list[it].selected = false
                    }
                }
                isShow = false
                selectPositions.clear()
                notifyDataSetChanged()
            }
        } else {
            isShow = true
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun isSelectAll(selectAll: Boolean) {

        isSelectAll = selectAll
        if (!isShow) return
        selectPositions.clear()
        if (selectAll) {
            list.forEachIndexed { index, historyItem ->
                historyItem.selected = true
                selectPositions.add(index)
            }
        } else {
            list.forEachIndexed { index, historyItem ->
                historyItem.selected = false
            }
        }
        notifyDataSetChanged()
    }

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
                    listener.onLongClick()
                }
                true
            }

            holder.itemView.setOnClickListener { _ ->
                if (isShow) {
                    selectPositions.add(position)
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