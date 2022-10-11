package com.example.pandas.bean

import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.RecommendData

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/20/22 12:11 下午
 * @version: v1.0
 */
data class UIDataWrapper<T>(

    //是否请求成功
    val isSuccess: Boolean = false,
    //错误消息 isSuccess为false才会有
    val errMessage: String = "",
    //是否为刷新
    val isRefresh: Boolean = false,
    //是否为空
    val isEmpty: Boolean = false,
    //是否还有更多
    var hasMore: Boolean = false,
    //是第一页且没有数据
    val isFirstEmpty: Boolean = false,
    //列表数据
    val listData: MutableList<T> = mutableListOf(),
    //推荐页数据
    val recoData: RecommendData<T> = RecommendData(),
    //喜欢页数据
    val loveData: PageCommonData = PageCommonData(),
    //山水数据
    val landscapeData: LandscapeData = LandscapeData(),
    val liveVides: LiveVideoData = LiveVideoData(),
)