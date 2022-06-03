package com.example.pandas.ui.view.recyclerview

import OnItemClickListener
import OnItemLongClickListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * @description: adapter wrapper 只有一个footer
 * @author: dongyiming
 * @date: 4/18/22 11:47 上午
 * @version: v1.0
 */
public class AdapterWrapper(private val mAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_FOOTER = 99999 //footer

    private var onItemClickListener: OnItemClickListener? = null
    private var onItemLongClickListener: OnItemLongClickListener? = null

    private var footer: View? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener
    }

    fun getCurrentItemCount() = mAdapter.itemCount

    private fun isFooter(position: Int): Boolean = position >= getCurrentItemCount()

    private fun isFooter(holder: RecyclerView.ViewHolder): Boolean = holder is FooterViewHolder

    override fun getItemCount(): Int {
        val count = mAdapter.itemCount
        if (count == 0) {
            return 0
        } else if (footer == null) {
            return count
        } else
            return count + 1
    }

    override fun getItemViewType(position: Int): Int {
        if (isFooter(position)) {
            return TYPE_ITEM_FOOTER
        } else {
            return mAdapter.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ITEM_FOOTER) {
            return FooterViewHolder(footer!!)
        } else {
            val holder = mAdapter.onCreateViewHolder(parent, viewType)
            onItemClickListener?.let { listener ->
                holder.itemView.setOnClickListener {
                    listener.onItemClick(it, holder.bindingAdapterPosition)
                }
            }
            onItemLongClickListener?.let { listener ->
                holder.itemView.setOnLongClickListener {
                    listener.onItemLongClick(it, holder.bindingAdapterPosition)
                    true
                }
            }
            return holder
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) != TYPE_ITEM_FOOTER) {
            mAdapter.onBindViewHolder(holder, position)
        }
    }

    private inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView.layoutManager
        if (manager != null && manager is GridLayoutManager) {

            val gm = manager as GridLayoutManager
            gm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {

                    if (isFooter(position)) {
                        return gm.spanCount
                    } else if (getItemViewType(position) == 1 || getItemViewType(position) == 3) {//轮播图和横屏
                        return gm.spanCount
                    }
                    return 1
                }
            }
        }
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (isFooter(holder)) {

            val layoutParams = holder.itemView.layoutParams
            if (layoutParams is StaggeredGridLayoutManager.LayoutParams) {
                val lp = layoutParams as StaggeredGridLayoutManager.LayoutParams
                lp.isFullSpan = true
            }
        } else {
            mAdapter.onViewAttachedToWindow(holder)
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        if (!isFooter(holder)) mAdapter.onViewRecycled(holder)
    }

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        return if (!isFooter(holder)) mAdapter.onFailedToRecycleView(holder) else false
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        if (!isFooter(holder)) mAdapter.onViewDetachedFromWindow(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        mAdapter.onDetachedFromRecyclerView(recyclerView)
    }

    fun addFooter(view: View) {
        this.footer = view
    }
}