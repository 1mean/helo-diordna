package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.android.android_sqlite.bean.SearchInfo
import com.android.base.utils.StringColorUtil
import com.example.pandas.databinding.AdapterPopuSearchBinding
import com.example.pandas.databinding.ItemTopSearchListBinding

/**
 * @description: list
 * @author: dongyiming
 * @date: 2/20/22 6:15 下午
 * @version: v1.0
 */
public class SearchResultAdapter(
    private var keyWord: String = "",
    private val list: MutableList<SearchInfo> = mutableListOf(),
    private val turnToSearchListFragment: () -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(keyWord: String, data: MutableList<SearchInfo>) {//data不会为空

        this.keyWord = keyWord
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        if (list.isNotEmpty()) {
            list.clear()
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val binding = ItemTopSearchListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TopViewHolder(binding)
        } else {
            val binding =
                AdapterPopuSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == 0) {
            (holder as TopViewHolder).handle()
        } else {
            (holder as ItemViewHolder).handle(position)
        }
    }

    override fun getItemCount(): Int {
        return if (list.size == 0) {
            0
        } else {
            list.size + 1
        }
    }

    override fun getItemViewType(position: Int): Int = if (position == 0) {
        0
    } else {
        1
    }

    private inner class ItemViewHolder(binding: AdapterPopuSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.txtSearchResult
        val color = ContextCompat.getColor(itemView.context, R.color.color_search_text_like)

        fun handle(position: Int) {
            val data = list[position - 1]
            name.text = StringColorUtil.fillColor(data.title, keyWord, color)
            itemView.setOnClickListener {
                turnToSearchListFragment()
            }
        }
    }

    private inner class TopViewHolder(binding: ItemTopSearchListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title = binding.txtCacheListTitle
        fun handle() {
            title.text = "本地搜索"
        }
    }
}