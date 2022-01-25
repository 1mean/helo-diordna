package com.example.pandas.base.interaction

import android.view.ViewGroup
import com.example.pandas.base.BaseViewHolder

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/16 6:22 下午
 * @version: v1.0
 */
public interface IBaseAdapter {

    fun createViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder

    fun handleViewHolder(holder: BaseViewHolder, position: Int)

}