package com.example.pandas.ui.ext;

import BaseEmptyViewHolder
import PandaDecoration
import RecommendDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView


/**
 * 绑定上拉加载RecyclerView
 */
fun LoadMoreRecyclerView.initReco(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: LoadMoreRecyclerView.ILoadMoreListener
): LoadMoreRecyclerView {
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter, listener)
    addItemDecoration(RecommendDecoration(context))
    return this
}

fun LoadMoreRecyclerView.initPanda(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: LoadMoreRecyclerView.ILoadMoreListener
): LoadMoreRecyclerView {
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter, listener)
    addItemDecoration(PandaDecoration(context))
    return this
}