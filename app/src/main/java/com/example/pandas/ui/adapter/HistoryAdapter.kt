package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.HistoryItem
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.sql.entity.History
import com.example.pandas.utils.TimeUtils

/**
 * @description: HistoryAdapter
 * @author: dongyiming
 * @date: 3/11/22 12:37 上午
 * @version: v1.0
 */
public class HistoryAdapter(
    private var list: MutableList<HistoryItem> = mutableListOf(),
    private val listener: HistoryListener
) :
    BaseCommonAdapter<HistoryItem>(list) {

    private var isShow: Boolean = false
    private var isSelectAll: Boolean = false

    private var selectMaps: MutableMap<Int, History> = mutableMapOf()

    override fun getLayoutId(): Int = R.layout.adapter_history_item

    interface HistoryListener {
        fun onLongClick()

        fun cancelAllSelected()
    }

    fun getSelectList(): MutableList<History> {
        if (selectMaps.isNotEmpty()) {
            return selectMaps.values.toMutableList()
        }
        return mutableListOf()
    }


    fun delete(){
        if (isSelectAll) {
            list.clear()
            selectMaps.clear()
        } else {
            //解决ConcurrentModificationException异常，调用list.remove()方法导致modCount和expectedModCount的值不一致。
            // 注意，像使用for-each进行迭代实际上也会出现这种问题
            val iterator = list.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.selected) {
                    iterator.remove()
                }
            }
            selectMaps.clear()
        }
        notifyAdapter()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onRefreshAdapter(newList: MutableList<HistoryItem>) {

        if (newList.isNotEmpty() && newList != list) {
            list.clear()
            list.addAll(newList)
            notifyDataSetChanged()
        }
    }

    fun onLoadMore(newList: MutableList<HistoryItem>) {

        if (newList.isNotEmpty()) {
            val size = list.size
            if (isSelectAll) {
                newList.forEachIndexed { index, historyItem ->
                    historyItem.selected = true
                    historyItem.history?.let { selectMaps.put(size + index, it) }
                }
            }
            list.addAll(newList)
            notifyItemRangeInserted(size, newList.size)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun manager(isClose: Boolean) {

        if (isClose) {//关闭删除界面
            isSelectAll = false
            if (isShow) {
                if (selectMaps.isNotEmpty()) {
                    selectMaps.keys.forEach {
                        list[it].selected = false
                    }
                }
                isShow = false
                selectMaps.clear()
                notifyDataSetChanged()
            }
        } else {
            isShow = true
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun isSelectAll(selectAll: Boolean) {

        Log.e("HistoryAdapter", "isSelectAll: selectAll")
        isSelectAll = !selectAll
        if (!isShow) return
        selectMaps.clear()
        if (selectAll) {//全选后，点击取消去选
            list.forEachIndexed { _, historyItem ->
                historyItem.selected = false
            }
        } else {
            list.forEachIndexed { index, historyItem ->
                historyItem.selected = true
                selectMaps[index] = historyItem.history!!
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
                    data.selected = true
                    data.history?.let { it1 -> selectMaps.put(position, it1) }
                    isShow = true
                    listener.onLongClick()
                    notifyAdapter()
                }
                true
            }

            holder.itemView.setOnClickListener { _ ->
                if (isShow) {
                    if (isSelectAll) {
                        isSelectAll = false
                        listener.cancelAllSelected()
                    }
                    if (data.selected) {
                        if (selectMaps.containsKey(position)) {
                            selectMaps.remove(position)
                        }
                        select.setImageResource(R.mipmap.img_history_unselect)
                    } else {
                        data.history?.let { it1 -> selectMaps.put(position, it1) }
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