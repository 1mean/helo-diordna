package com.example.pandas.bean.pet

data class PetVideo(

    var videoUrl: String? = null,//视频路径
    var fileName: String? = null,//本地文件名，需要拼接
    var filePath: String? = null,//视频原始转载地址，标注一下
    /**
     * 视频特征：用于搜索
     *    1，天气：冬天，下雪
     *    2，宠物是宝贝
     *
     * @version: v1.0
     */
    var tag: String? = null,
    var isBabyCute: Boolean,//是否是宠物宝宝


)
