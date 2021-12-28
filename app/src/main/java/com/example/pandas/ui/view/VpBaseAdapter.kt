package com.example.pandas.ui.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/28 3:57 下午
 * @version: v1.0
 */
public abstract class VpBaseAdapter<T>(datas: List<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), IRecyclerAdapter<T> {

    private var mData: List<T>? = null

    init {
        mData = datas
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return onCreateHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (mData != null) {
            onBindView(holder, mData!!.get(position), position, mData!!.size)
        }
    }

    override fun getItemCount(): Int = mData?.size ?: 0

}