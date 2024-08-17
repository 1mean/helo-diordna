package com.example.pandas.data.sql

import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.entity.PetVideo

object ArtData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        val art1 = PetVideo()
        art1.type = VideoType.ART.ordinal
        art1.fileName = "art_1"
        art1.code = 1978
        art1.duration = 77
        art1.star = true
        art1.title = "俄罗斯“祖国母亲在召唤”雕塑！雕塑底下是二战中战死的无数战士，顶上是怒吼着的祖国母亲，一手执剑，一手指向德国柏林的方向"
        art1.releaseTime = 1645744795
        art1.originalUrl = "https://www.bilibili.com/video/BV1634y1r7kw"
        art1.tags = "艺术,MV"
        art1.authorId = 1398755083
        art1.cover = "https://i1.hdslb.com/bfs/archive/41188b9d86cae20c3978c630f2105d035e79a9fd.jpg"
        art1.hot = false
        art1.vertical = false
        list.add(art1)

        val art2 = PetVideo()
        art2.type = VideoType.ART.ordinal
        art2.fileName = "art_2"
        art2.code = 1979
        art2.duration = 100
        art2.star = true
        art2.title =
            "2018_伏尔加格勒_祖国母亲在召唤_灯光秀_精彩剪辑  [2018_Volgograd_Motherland is calling_Light Show]"
        art2.releaseTime = 1585465945
        art2.originalUrl = "https://www.bilibili.com/video/BV1YK4y1C77o"
        art2.tags = "艺术,MV"
        art2.authorId = 98093909
        art2.cover = "https://i0.hdslb.com/bfs/archive/2355775e413d4b67c34b14f9d61539880df62ecc.jpg"
        art2.hot = false
        art2.vertical = false
        list.add(art2)

        val art3 = PetVideo()
        art3.type = VideoType.ART.ordinal
        art3.fileName = "art_3"
        art3.code = 1980
        art3.duration = 20
        art3.star = true
        art3.title = "勒热夫战役纪念雕塑，牺牲的战士乘鹤归来"
        art3.releaseTime = 1639225486
        art3.originalUrl = "https://www.bilibili.com/video/BV18r4y1D7k2"
        art3.tags = "艺术,MV"
        art3.authorId = 36814636
        art3.cover = "https://i1.hdslb.com/bfs/archive/0121ff379cb408a3617a0137d12278151530f02b.jpg"
        art3.hot = false
        art3.vertical = true
        list.add(art3)

        val art4 = PetVideo()
        art4.type = VideoType.ART.ordinal
        art4.fileName = "art_4"
        art4.code = 1981
        art4.duration = 303
        art4.star = true
        art4.title = "勒热夫战役苏军士兵纪念碑"
        art4.releaseTime = 1593861717
        art4.originalUrl = "https://www.bilibili.com/video/BV1tp4y1U72x"
        art4.tags = "艺术,MV"
        art4.authorId = 92694869
        art4.cover = "https://i0.hdslb.com/bfs/archive/cd2661ecb62a563fa5cd2bb1ab837192516d858d.jpg"
        art4.hot = false
        art4.vertical = false
        list.add(art4)

        val art5 = PetVideo()
        art5.type = VideoType.ART.ordinal
        art5.fileName = "art_5"
        art5.code = 3690
        art5.duration = 21
        art5.star = true
        art5.vertical = false
        art5.title = "世界第一大佛，云海仙境"
        art5.releaseTime = 1598584676
        art5.originalUrl = "https://www.bilibili.com/video/BV1sh411R7sq"
        art5.tags = "艺术,MV"
        art5.authorId = 668136570
        art5.cover = "https://i1.hdslb.com/bfs/archive/6de04f4a20d2f1757534695814981f1007a9ee87.jpg"
        list.add(art5)

        val art6 = PetVideo()
        art6.type = VideoType.ART.ordinal
        art6.fileName = "art_6"
        art6.code = 3691
        art6.duration = 160
        art6.star = true
        art6.vertical = false
        art6.title = "“她右手持以利剑，左手指向柏林”【雕塑鉴赏01】"
        art6.releaseTime = 1650101741
        art6.originalUrl = "https://www.bilibili.com/video/BV14S4y1Y7Pa"
        art6.tags = "艺术,MV"
        art6.authorId = 2078322
        art6.cover = "https://i1.hdslb.com/bfs/archive/b7dcf7f811083f0d7d26edf084e932f79a95cb45.jpg"
        list.add(art6)

        val art7 = PetVideo()
        art7.type = VideoType.ART.ordinal
        art7.fileName = "art_7"
        art7.code = 3692
        art7.duration = 114
        art7.star = true
        art7.vertical = false
        art7.title = "你可以永远相信毛子的审美"
        art7.releaseTime = 1647160162
        art7.originalUrl = "https://www.bilibili.com/video/BV17i4y1C7nA"
        art7.tags = "艺术,MV"
        art7.authorId = 254498901
        art7.cover = "https://i1.hdslb.com/bfs/archive/ce60b59055dc906191b64fda39bdbdaf22f3b6fb.jpg"
        list.add(art7)


        return list
    }
}