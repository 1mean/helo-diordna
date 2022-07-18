package com.example.pandas.ui.adapter

import CacheListItemAdapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.bean.CacheListItemData
import com.example.pandas.databinding.AdapterCacheListBinding
import com.example.pandas.databinding.ItemCacheTitleBinding
import com.example.pandas.ui.adapter.decoration.CacheListItemDecoration
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration

/**
 * @description: 缓存文件夹分类
 * @author: dongyiming
 * @date: 3/8/22 4:55 下午
 * @version: v1.0
 */
public class CacheListAdapter(private val list: MutableList<CacheListItemData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * 刷新界面
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(data: MutableList<CacheListItemData>) {

        if (data.isNotEmpty() && data != list) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            1 -> {
                val binding = AdapterCacheListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return GridViewHolder(binding)
            }
            else -> {
                val binding = ItemCacheTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CacheTitleViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItemViewType(position)) {
            1 -> {
                (holder as GridViewHolder).handle(position)
            }
            else -> {
                (holder as CacheTitleViewHolder).handle(position)
            }
        }
    }

    override fun getItemCount(): Int = list.size * 2

    override fun getItemViewType(position: Int): Int = if (position % 2 == 0) {
        0
    } else {
        1
    }

    private inner class GridViewHolder(binding: AdapterCacheListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val rv = binding.rvCacheItem
        val paddingMid =
            itemView.context.resources.getDimension(R.dimen.common_lh_10_dimens).toInt()
        val paddingBtm =
            itemView.context.resources.getDimension(R.dimen.common_lh_15_dimens).toInt()

        fun handle(position: Int) {
            val data = list[position / 2].data
            rv.run {
//                addItemDecoration(CommonItemDecoration(false, 3, 0, paddingMid, paddingBtm))
                addItemDecoration(CacheListItemDecoration())
                layoutManager = GridLayoutManager(context, 3)
                adapter = CacheListItemAdapter(data)
            }
        }
    }

    private inner class CacheTitleViewHolder(binding: ItemCacheTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val title = binding.txtCacheListTitle
        fun handle(position: Int) {
            val data = list[position / 2].title
            title.text = data
        }
    }
}