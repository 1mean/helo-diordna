package com.example.pandas.biz.interaction

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/17/22 8:37 下午
 * @version: v1.0
 */
public interface OnItemClickListener<T> {

    fun onClick(position: Int, t: T)
}