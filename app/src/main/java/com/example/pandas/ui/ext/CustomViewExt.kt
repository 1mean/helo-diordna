package com.example.pandas.ui.ext;

import BaseEmptyViewHolder
import ILoadMoreListener
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.ui.view.refresh.RefreshRecyclerView


/**
 * 绑定上拉加载RecyclerView
 */
fun RefreshRecyclerView.init(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: ILoadMoreListener
    ):RefreshRecyclerView{
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter,listener)
    return this
}
