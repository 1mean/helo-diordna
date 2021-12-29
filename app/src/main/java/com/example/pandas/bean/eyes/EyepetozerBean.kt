package com.example.pandas.bean.eyes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 去掉大部分不符合项目的冗余字段，重构成一张新的表
 * @author: dongyiming
 * @date: 2021/12/22 7:04 下午
 * @version: v1.0
 */
@Parcelize
data class EyepetozerBean(

    //squareCardCollection数据不做保存
    //type: horizontalScrollCard/textHeader/video/squareCardCollection
    var type: Int = 0,
    var videoId: Int = 0,//videoId,通过id可以请求到相关评论
    var title: String? = null,//名称
    var coverUrl: String? = null,//封面图片
    var description: String? = null,//视频描述信息
    var userCode: Int = 0,//发布者的id
    var playUrl: String? = null,//默认的视频播放url
    var duration: Int = 0,//video时长，单位秒
    var releaseTime: Long = 0,//video发布的时间
    var videoType: String? = null,//视频类型：NORMAL(标清)/high(高清)
    var normalUrl: String? = null,//标清源url
    var highUrl: String? = null,//高清源url
    var collectionCount: Int = 0,//当作点赞数用吧
    var shareCount: Int = 0,//分享次数
    var replyCount: Int = 0,//回复评论数
    var realCollectionCount: Int = 0,//当作收藏数用吧
    var count: Int = 0,//card数
    var horizontalCardList: MutableList<String>? = null,//HorizontalScrollCard的url

    var user: EyepetozerUser? = null
):Parcelable
