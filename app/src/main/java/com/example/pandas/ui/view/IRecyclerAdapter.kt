package com.example.pandas.ui.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/28 4:30 下午
 * @version: v1.0
 */
public interface IRecyclerAdapter<T> {

    fun onCreateHolder(parent:ViewGroup,viewType:Int):RecyclerView.ViewHolder

    fun onBindView(holder: RecyclerView.ViewHolder, data: T, position: Int, size: Int)
}