package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object ArtData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        val art1 = PetVideo()
        art1.type = VideoType.ART.ordinal
        art1.fileName = "art_1"
        art1.code = 1978
        art1.duration = 77
        art1.isStar = true
        art1.title = "俄罗斯“祖国母亲在召唤”雕塑！雕塑底下是二战中战死的无数战士，顶上是怒吼着的祖国母亲，一手执剑，一手指向德国柏林的方向"
        art1.releaseTime = "2022-02-25 07:19:55"
        art1.originalUrl = "https://www.bilibili.com/video/BV1634y1r7kw"
        art1.tags = "艺术,MV"
        art1.authorName = "徐老憨"
        art1.cover = "https://i1.hdslb.com/bfs/archive/41188b9d86cae20c3978c630f2105d035e79a9fd.jpg"
        list.add(art1)

        val art2 = PetVideo()
        art2.type = VideoType.ART.ordinal
        art2.fileName = "art_2"
        art2.code = 1979
        art2.duration = 100
        art2.isStar = true
        art2.title =
            "2018_伏尔加格勒_祖国母亲在召唤_灯光秀_精彩剪辑  [2018_Volgograd_Motherland is calling_Light Show]"
        art2.releaseTime = "2020-03-29 15:12:25"
        art2.originalUrl = "https://www.bilibili.com/video/BV1YK4y1C77o"
        art2.tags = "艺术,MV"
        art2.authorName = "漫天落樱芳华"
        art2.cover = "https://i0.hdslb.com/bfs/archive/2355775e413d4b67c34b14f9d61539880df62ecc.jpg"
        list.add(art2)

        val art3 = PetVideo()
        art3.type = VideoType.ART.ordinal
        art3.fileName = "art_3"
        art3.code = 1980
        art3.duration = 20
        art3.isStar = true
        art3.title = "勒热夫战役纪念雕塑，牺牲的战士乘鹤归来"
        art3.releaseTime = "2021-12-11 20:24:46"
        art3.originalUrl = "https://www.bilibili.com/video/BV18r4y1D7k2"
        art3.tags = "艺术,MV"
        art3.authorName = "KAuthor"
        art3.cover = "https://i1.hdslb.com/bfs/archive/0121ff379cb408a3617a0137d12278151530f02b.jpg"
        list.add(art3)

        val art4 = PetVideo()
        art4.type = VideoType.ART.ordinal
        art4.fileName = "art_4"
        art4.code = 1981
        art4.duration = 303
        art4.isStar = true
        art4.title = "勒热夫战役苏军士兵纪念碑"
        art4.releaseTime = "2020-07-04 19:21:57"
        art4.originalUrl = "https://www.bilibili.com/video/BV1tp4y1U72x"
        art4.tags = "艺术,MV"
        art4.authorName = "爱吃西瓜的跳跳虎"
        art4.cover = "https://i0.hdslb.com/bfs/archive/cd2661ecb62a563fa5cd2bb1ab837192516d858d.jpg"
        list.add(art4)




        return list
    }
}