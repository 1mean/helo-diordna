package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.HistoryItem
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.databinding.AdapterHistoryItemBinding
import com.example.pandas.databinding.AdapterItemTitleHistoryBinding
import com.example.pandas.sql.entity.History
import com.example.pandas.ui.ext.startVideoPlayingActivity
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
) : Adapter<ViewHolder>() {

    private val TYPE_ITEM = 0
    private val TYPE_TITLE = 1

    //今天，昨天，更早
    private var isShow: Boolean = false
    private var isSelectAll: Boolean = false

    private var selectMaps: MutableMap<Int, History> = mutableMapOf()

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


//    fun delete() {
//        if (isSelectAll) {
//            list.clear()
//            selectMaps.clear()
//        } else {
//            //解决ConcurrentModificationException异常，调用list.remove()方法导致modCount和expectedModCount的值不一致。
//            // 注意，像使用for-each进行迭代实际上也会出现这种问题
//            val iterator = list.iterator()
//            while (iterator.hasNext()) {
//                val next = iterator.next()
//                if (next.selected) {
//                    iterator.remove()
//                }
//            }
//            selectMaps.clear()
//        }
//        notifyDataSetChanged()
//    }

    @SuppressLint("NotifyDataSetChanged")
    fun onRefreshAdapter(newList: MutableList<HistoryItem>) {

        if (newList.isNotEmpty() && newList != list) {
            isShow = false
            selectMaps.clear()
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
                    historyItem.history?.let { selectMaps[size + index] = it }
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

        isSelectAll = !selectAll
        if (!isShow) return
        selectMaps.clear()
        if (selectAll) {//全选后，点击取消去选
            list.forEachIndexed { _, historyItem ->
                historyItem.selected = false
            }
        } else {
            list.forEachIndexed { index, historyItem ->
                if (historyItem.type == 0) {
                    historyItem.selected = true
                    selectMaps[index] = historyItem.history!!
                }
            }
        }

        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return if (viewType == TYPE_TITLE) {
            val binding = AdapterItemTitleHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            TitleViewHolder(binding)
        } else {
            val binding = AdapterHistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ItemViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (getItemViewType(position) == TYPE_TITLE) {
            (holder as TitleViewHolder).handle(position)
        } else {
            (holder as ItemViewHolder).handle(position)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].type

    inner class ItemViewHolder(binding: AdapterHistoryItemBinding) : ViewHolder(binding.root) {

        val context = itemView.context
        val cover = binding.imgHistoryCover
        val duration = binding.txtHistoryDuration
        val title = binding.txtHistoryName
        val time = binding.txtHistoryTime
        val name = binding.txtHistoryUp
        val select = binding.ibnHistoryItemSelect

        fun handle(position: Int) {

            val historyItem = list[position]
            val history = historyItem.history
            val video = historyItem.video
            val user = historyItem.video?.user

            user?.let {
                name.text = it.userName
            }

            if (isShow) {
                select.visibility = View.VISIBLE
            } else {
                select.visibility = View.GONE
            }

            if (historyItem.selected) {
                select.setImageResource(R.mipmap.img_history_selected)
            } else {
                select.setImageResource(R.mipmap.img_history_unselect)
            }

            video?.let {
                loadCenterImage(context, it.cover, cover)
//                loadCenterRoundedCornerImage(context, 15, it.cover, cover)
                title.text = it.title

                val videoDuration = TimeUtils.getMMDuration(it.duration.toLong())
                history?.let { his ->
                    his.playPosition?.let { pos ->
                        duration.text =
                            StringBuilder(pos).append(" / ").append(videoDuration).toString()
                    }
                }

                itemView.setOnLongClickListener {
                    if (!isShow) {
                        historyItem.selected = true
                        historyItem.history?.let { it1 -> selectMaps.put(position, it1) }
                        isShow = true
                        listener.onLongClick()
                        notifyAdapter()
                    }
                    true
                }

                itemView.setOnClickListener { _ ->
                    if (isShow) {
                        if (isSelectAll) {
                            isSelectAll = false
                            listener.cancelAllSelected()
                        }
                        if (historyItem.selected) {
                            if (selectMaps.containsKey(position)) {
                                selectMaps.remove(position)
                            }
                            select.setImageResource(R.mipmap.img_history_unselect)
                        } else {
                            historyItem.history?.let { it1 -> selectMaps.put(position, it1) }
                            select.setImageResource(R.mipmap.img_history_selected)
                        }
                        historyItem.selected = !historyItem.selected
                    } else {
                        startVideoPlayingActivity(context, it)
                    }
                }
            }

            history?.let {
                time.text = TimeUtils.getTime(it.lastTime)
            }
        }
    }

    inner class TitleViewHolder(binding: AdapterItemTitleHistoryBinding) :
        ViewHolder(binding.root) {

        val title = binding.txtTitleHistory
        fun handle(position: Int) {
            val titleStr = list[position].title
            title.text = titleStr
        }
    }

}