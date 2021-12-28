package com.example.pandas.bean.eyes

/**
 * 视频发布者信息
 * @author: dongyiming
 * @date: 2021/12/22 6:19 下午
 * @version: v1.0
 */
data class EyepetozerUser(

    var userCode: Int = 0,//用户id  当界面粉丝数用吧
    var userName: String? = null,//用户名
    var userIcon: String? = null,//用户头像url
    var userDes: String? = null,//描述
    var latestReleaseTime: Long = 0,//最后一次发布时间
    var videoNum: Int = 0//视频数
)
