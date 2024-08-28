package com.android.base.interaction

/**
 * @description: adapter公用的接口
 * @author: dongyiming
 * @date: 8/28/24 5:13 PM
 * @version: v1.0
 */
public interface AdapterListener<T> {

    fun itemClick(position: Int, t: T)

    fun viewClick()
}