package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object BeautyData {

    private val list = mutableListOf<PetVideo>()

    fun getBeauty(): MutableList<PetVideo> {

        val beauty1 = PetVideo()
        beauty1.type = VideoType.BEAUTY.ordinal
        beauty1.fileName = "beauty1"
        beauty1.code = 1384
        beauty1.duration = 22
        beauty1.isStar = true
        beauty1.title = "惊鸿一瞥的貂蝉"
        beauty1.releaseTime = "2020-12-02 14:51:58"
        beauty1.originalUrl = "https://www.bilibili.com/video/BV1hZ4y1G7fL"
        beauty1.tags = "美女"
        beauty1.authorName = "院落溶溶月-"
        beauty1.cover =
            "https://i1.hdslb.com/bfs/archive/9b90018d3acfe1a1c6a66e42fd658eb45dd8df03.jpg"
        list.add(beauty1)

        val beauty2 = PetVideo()
        beauty2.type = VideoType.BEAUTY.ordinal
        beauty2.fileName = "beauty2"
        beauty2.code = 1385
        beauty2.duration = 224
        beauty2.isStar = true
        beauty2.title = "【刘亦菲1080p超清美貌】镜头怼得越近老娘越美"
        beauty2.releaseTime = "2020-01-15 18:08:52"
        beauty2.originalUrl = "https://www.bilibili.com/video/BV11J411J7tr"
        beauty2.tags = "美女"
        beauty2.authorName = "宝姐姐酷酷的"
        beauty2.cover =
            "https://i1.hdslb.com/bfs/archive/ba12739b8df0059596f414e8103c1a57d30b576b.jpg"
        list.add(beauty2)

        val beauty3 = PetVideo()
        beauty3.type = VideoType.BEAUTY.ordinal
        beauty3.fileName = "beauty3"
        beauty3.code = 1386
        beauty3.duration = 133
        beauty3.isStar = true
        beauty3.title = "这才是言情女主的正确打开方式！【刘亦菲】"
        beauty3.releaseTime = "2020-11-22 20:55:23"
        beauty3.originalUrl = "https://www.bilibili.com/video/BV1VV411a7CK"
        beauty3.tags = "美女"
        beauty3.authorName = "Deponial"
        beauty3.cover =
            "https://i0.hdslb.com/bfs/archive/af69e10ccc01d2850a47d1cb0e01845d44a28fe7.jpg"
        list.add(beauty3)

        val beauty4 = PetVideo()
        beauty4.type = VideoType.BEAUTY.ordinal
        beauty4.fileName = "beauty4"
        beauty4.code = 1387
        beauty4.duration = 44
        beauty4.isStar = true
        beauty4.title = "小说女主婚礼被虐现场"
        beauty4.releaseTime = "2022-02-08 22:03:48"
        beauty4.originalUrl = "https://www.bilibili.com/video/BV16r4y1h78V"
        beauty4.tags = "美女"
        beauty4.authorName = "刘亦菲赵盼儿"
        beauty4.cover =
            "https://i2.hdslb.com/bfs/archive/153db771d26904fc142a14daf5747039a16e81cc.jpg"
        list.add(beauty4)


        return list
    }
}