package com.example.pandas.ui.view.recyclerview

/**
 * @description: footer的统一规范
 * @author: dongyiming
 * @date: 4/27/22 11:49 下午
 * @version: v1.0
 */
interface SwipLoadMoreView {

    fun onLoading()

    fun onLoadFinished(isEmpty: Boolean, hasMore: Boolean)

    fun onLoadError(errorCode: Int, errorMessage: String)
}