package com.example.pandas.biz.http.exception

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/20/22 12:56 下午
 * @version: v1.0
 */
public class AppException : Exception {

    var errorMsg: String //错误消息
    var errCode: Int = 0 //错误码
    var errorLog: String? //错误日志
    var throwable: Throwable? = null

    constructor(
        errCode: Int,
        error: String?,
        errorLog: String? = "",
        throwable: Throwable? = null
    ) : super(error) {
        this.errorMsg = error ?: "请求失败，请稍后再试"
        this.errCode = errCode
        this.errorLog = errorLog ?: this.errorMsg
        this.throwable = throwable
    }

    constructor(error:Error, e: Throwable?) {
        errCode = error.getKey()
        errorMsg = error.getValue()
        errorLog = e?.message
        throwable = e
    }
}