package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.utils.TimeUtils

/**
 * @description: LaterAdapter
 * @author: dongyiming
 * @date: 8/13/22 11:25 上午
 * @version: v1.0
 */
public class LaterAdapter(
    private val list: MutableList<PetVideo> = mutableListOf(),
    private val listener: LaterListener
) :
    BaseCommonAdapter<PetVideo>(list) {

    private var isShow: Boolean = false
    private var isSelectAll: Boolean = false

    private var selectMaps: MutableMap<Int, PetVideo> = mutableMapOf()

    interface LaterListener {
        fun onLongClick()

        fun cancelAllSelected()
    }

    fun getSelectList(): MutableList<PetVideo> {
        if (selectMaps.isNotEmpty()) {
            return selectMaps.values.toMutableList()
        }
        return mutableListOf()
    }


    fun delete() {
        if (isSelectAll) {
            list.clear()
            selectMaps.clear()
        } else {
            //解决ConcurrentModificationException异常，调用list.remove()方法导致modCount和expectedModCount的值不一致。
            // 注意，像使用for-each进行迭代实际上也会出现这种问题
            val iterator = list.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (next.booleanFlag) {
                    iterator.remove()
                }
            }
            selectMaps.clear()
        }
        notifyAdapter()
    }

    fun onLoadMore(newList: MutableList<PetVideo>) {

        if (newList.isNotEmpty()) {
            val size = list.size
            if (isSelectAll) {
                newList.forEachIndexed { index, petVideo ->
                    petVideo.booleanFlag = true
                    selectMaps.put(size + index, petVideo)
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
                        list[it].booleanFlag = false
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
            list.forEachIndexed { _, petVideo ->
                petVideo.booleanFlag = false
            }
        } else {
            list.forEachIndexed { index, petVideo ->
                petVideo.booleanFlag = true
                selectMaps[index] = petVideo
            }
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun getLayoutId(): Int = R.layout.adapter_later

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {
        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_later_cover)
        val select = holder.getWidget<AppCompatImageView>(R.id.ibn_later_item_select)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_later_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_later_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_later_name)
        val playCounts = holder.getWidget<AppCompatTextView>(R.id.txt_later_counts)
        val comments = holder.getWidget<AppCompatTextView>(R.id.txt_later_comment)
        val loadMoreLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_later_more)

        if (isShow) {
            select.visibility = View.VISIBLE
        } else {
            select.visibility = View.GONE
        }

        if (data.booleanFlag) {
            select.setImageResource(R.mipmap.img_history_selected)
        } else {
            select.setImageResource(R.mipmap.img_history_unselect)
        }

        data.cover?.let {
            loadCenterRoundedCornerImage(context, 15, it, cover)
        }

        duration.text = TimeUtils.getDuration(data.duration.toLong())
        title.text = data.title

        data.user?.let {
            name.text = it.userName
        }

        holder.itemView.setOnLongClickListener {
            if (!isShow) {
                data.booleanFlag = true
                selectMaps.put(position, data)
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
                if (data.booleanFlag) {
                    if (selectMaps.containsKey(position)) {
                        selectMaps.remove(position)
                    }
                    select.setImageResource(R.mipmap.img_history_unselect)
                } else {
                    selectMaps.put(position, data)
                    select.setImageResource(R.mipmap.img_history_selected)
                }
                data.booleanFlag = !data.booleanFlag
            } else {
                startVideoPlayingActivity(context, data)
            }
        }

//        loadMoreLayout.setOnClickListener {
//            if (dialog == null) {
//                dialog = MoreBottomSheetDialog(context, object : ItemClickListener<String> {
//                    override fun onItemClick(t: String) {
//                    }
//                })
//            }
//            dialog!!.onShow()
//        }

        data.videoData?.let {

            playCounts.text = it.plays.toString()

            if (it.comments == 0) {
                comments.text = " - "
            } else {
                comments.text = it.comments.toString()
            }

        }
    }

}