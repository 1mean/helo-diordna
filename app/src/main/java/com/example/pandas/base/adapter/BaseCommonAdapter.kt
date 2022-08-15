package com.example.pandas.base.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: base common adapter
 * @author: dongyiming
 * @date: 1/22/22 12:07 下午
 * @version: v1.0
 */
public abstract class BaseCommonAdapter<T>(private val data: MutableList<T>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    /**
     * 刷新界面
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(list: MutableList<T>) {

        if (list.isNotEmpty() && list != data) {
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 添加更多数据
     */
    fun loadMore(list: MutableList<T>) {
        if (list.isNotEmpty()) {
            val size = data.size
            data.addAll(list)
            notifyItemRangeInserted(size, list.size)
        }
    }

    /**
     * 清空所有数据
     */
    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        if (data.isNotEmpty()) {
            data.clear()
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            getLayoutId(), parent,
            false
        )
        return BaseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        convert(holder, data[position], position)
    }

    override fun getItemCount() = data.size

    abstract fun getLayoutId(): Int
    abstract fun convert(holder: BaseViewHolder, data: T, position: Int)
}