package com.example.pandas.base.interaction

import BaseViewHolder
import android.view.ViewGroup

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/16 6:22 下午
 * @version: v1.0
 */
public interface IBaseAdapter {

    fun createViewHolder(parent: ViewGroup, viewType: Int):BaseViewHolder

    fun handleViewHolder(holder: BaseViewHolder, position: Int)

}