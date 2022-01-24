package com.example.pandas.ui.ext;

import BaseEmptyViewHolder
import ILoadMoreListener
import PandaDecoration
import RecommendDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.ui.view.refresh.RefreshRecyclerView


/**
 * 绑定上拉加载RecyclerView
 */
fun RefreshRecyclerView.initReco(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: ILoadMoreListener
    ):RefreshRecyclerView{
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter,listener)
    addItemDecoration(RecommendDecoration(context))
    return this
}

fun RefreshRecyclerView.initPanda(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: ILoadMoreListener
):RefreshRecyclerView{
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter,listener)
    addItemDecoration(PandaDecoration(context))
    return this
}