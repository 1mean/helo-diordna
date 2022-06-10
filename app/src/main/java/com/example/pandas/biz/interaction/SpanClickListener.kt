package com.example.pandas.biz.interaction

/**
 * @description: TextView文字点击
 * @author: dongyiming
 * @date: 6/7/22 11:22 下午
 * @version: v1.0
 */
public interface SpanClickListener<T> {

    fun spanClick(t: T)
}