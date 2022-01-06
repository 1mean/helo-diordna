package com.example.pandas.bean.pet

data class PetVideo(

    var code: Int = 0,//视频ID，用id和本地路径拼接，找到视频本地url
    var fileName: String? = null,//file name
    var title: String? = null,//视频名字
    var description: String? = null,//视频描述
    var url: String? = null,//视频网络路径
    var originalUrl: String? = null,//视频原始转载地址，标注一下
    var tags: String? = null,//标签，用于分类
    var releaseTime: String? = null,//视频的发布时间
    var duration: Int = 0,//视频时长
    var cover: String? = null,//封面路径
    var type: Int = 0,//数据类型
    var authorName: String? = null//发布者信息

)
