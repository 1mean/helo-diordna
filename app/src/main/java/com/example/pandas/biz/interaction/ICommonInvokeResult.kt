package com.example.pandas.biz.interaction

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/21 7:34 下午
 * @version: v1.0
 */
interface ICommonInvokeResult<T, E> {

    fun onResult(t: T)

    fun onFailure(e: E)

    fun onCompleted()
}