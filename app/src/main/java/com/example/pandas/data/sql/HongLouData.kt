package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object HongLouData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {

        val honglou1 = PetVideo()
        honglou1.type = VideoType.HONGLOU.ordinal
        honglou1.fileName = "honglou_1"
        honglou1.code = 1796
        honglou1.duration = 733
        honglou1.star = true
        honglou1.title = "元妃省亲，细思极恐的元宵之夜"
        honglou1.releaseTime = 1614345501
        honglou1.originalUrl = "https://www.bilibili.com/video/BV18K4y1J7VU"
        honglou1.tags = "红楼"
        honglou1.authorId = 472633781
        honglou1.cover = "https://i0.hdslb.com/bfs/archive/095576589304242a2c522dc7f009643505be4b51.jpg"
        honglou1.hot = false
        honglou1.vertical = false
        list.add(honglou1)

        val honglou2 = PetVideo()
        honglou2.type = VideoType.HONGLOU.ordinal
        honglou2.fileName = "honglou_2"
        honglou2.code = 1797
        honglou2.duration = 965
        honglou2.star = true
        honglou2.title = "事事诡异！处处不祥！从中秋看贾府兴衰伏笔"
        honglou2.releaseTime = 1632049674
        honglou2.originalUrl = "https://www.bilibili.com/video/BV12R4y1H7c6"
        honglou2.tags = "红楼"
        honglou2.authorId = 472633781
        honglou2.cover = "https://i2.hdslb.com/bfs/archive/53105c988a3844010fb6abf65c4f984944c0393e.jpg"
        honglou2.hot = false
        honglou2.vertical = false
        list.add(honglou2)

        val honglou3 = PetVideo()
        honglou3.type = VideoType.HONGLOU.ordinal
        honglou3.fileName = "honglou_3"
        honglou3.code = 1798
        honglou3.duration = 1402
        honglou3.star = true
        honglou3.title = "关于宝黛同看“邪书”这件事，谁赞成，谁反对"
        honglou3.releaseTime = 1637904313
        honglou3.originalUrl = "https://www.bilibili.com/video/BV1Sf4y1K7kT"
        honglou3.tags = "红楼"
        honglou3.authorId = 472633781
        honglou3.cover = "https://i2.hdslb.com/bfs/archive/3e9dad3565e33462abdd7ab227120be007771bd5.jpg"
        honglou3.hot = false
        honglou3.vertical = false
        list.add(honglou3)

        val honglou4 = PetVideo()
        honglou4.type = VideoType.HONGLOU.ordinal
        honglou4.fileName = "honglou_4"
        honglou4.code = 1799
        honglou4.duration = 1208
        honglou4.star = true
        honglou4.videoType = 0
        honglou4.title = "如果谐音梗扣钱，那曹雪芹岂不是要“贷款写作”？"
        honglou4.releaseTime = 1639902967
        honglou4.originalUrl = "https://www.bilibili.com/video/BV1xa411k7EA"
        honglou4.tags = "红楼"
        honglou4.authorId = 472633781
        honglou4.cover = "https://i1.hdslb.com/bfs/archive/b8e17de5829f4e80be94ffed86f7d46909aabdcf.jpg"
        honglou4.hot = false
        honglou4.vertical = false
        list.add(honglou4)

        val honglou5 = PetVideo()
        honglou5.type = VideoType.HONGLOU.ordinal
        honglou5.fileName = "honglou_5"
        honglou5.code = 1800
        honglou5.duration = 805
        honglou5.star = true
        honglou5.title = "《红楼梦》惜春没存在感？如何从惜春故事见证贾府盛衰"
        honglou5.releaseTime = 1635591341
        honglou5.originalUrl = "https://www.bilibili.com/video/BV19Q4y1q7AR"
        honglou5.tags = "红楼"
        honglou5.authorId = 472633781
        honglou5.cover = "https://i1.hdslb.com/bfs/archive/ac1f11247da909eb671dc7b1b1f217235500a6f4.jpg"
        honglou5.hot = false
        honglou5.vertical = false
        list.add(honglou5)

        val honglou6 = PetVideo()
        honglou6.type = VideoType.HONGLOU.ordinal
        honglou6.fileName = "honglou_6"
        honglou6.code = 1801
        honglou6.duration = 893
        honglou6.star = true
        honglou6.title = "《红楼梦》平儿：作为王熙凤心腹，却被众人认可？如何在夹缝中求存，保持善良？"
        honglou6.releaseTime = 1634637607
        honglou6.originalUrl = "https://www.bilibili.com/video/BV1JF411e79F"
        honglou6.tags = "红楼"
        honglou6.authorId = 472633781
        honglou6.cover = "https://i2.hdslb.com/bfs/archive/f345872b1ce7229cb1eff627363cf31e7c70c4cf.jpg"
        honglou6.hot = false
        honglou6.vertical = false
        list.add(honglou6)

        val honglou7 = PetVideo()
        honglou7.type = VideoType.HONGLOU.ordinal
        honglou7.fileName = "honglou_7"
        honglou7.code = 1802
        honglou7.duration = 1037
        honglou7.star = true
        honglou7.title = "芳官的头为什么这么铁？她的人设竟是宝玉的影子？"
        honglou7.releaseTime = 1635318326
        honglou7.originalUrl = "https://www.bilibili.com/video/BV1jb4y1a7xr"
        honglou7.tags = "红楼"
        honglou7.authorId = 472633781
        honglou7.cover = "https://i2.hdslb.com/bfs/archive/1340d5cf2aea38593b3962a0bbbf32bcca81543f.jpg"
        honglou7.hot = false
        honglou7.vertical = false
        list.add(honglou7)

        val honglou8 = PetVideo()
        honglou8.type = VideoType.HONGLOU.ordinal
        honglou8.fileName = "honglou_8"
        honglou8.code = 1803
        honglou8.duration = 1324
        honglou8.star = true
        honglou8.title = "贾府的小“戏子”们，为什么“不好惹”？"
        honglou8.releaseTime = 1618390953
        honglou8.originalUrl = "https://www.bilibili.com/video/BV1NA411L7LL"
        honglou8.tags = "红楼"
        honglou8.authorId = 472633781
        honglou8.cover = "https://i0.hdslb.com/bfs/archive/69afa7710ed85d0385a441c3c56b5728b5c7c53e.jpg"
        honglou8.hot = false
        honglou8.vertical = false
        list.add(honglou8)

        val honglou9 = PetVideo()
        honglou9.type = VideoType.HONGLOU.ordinal
        honglou9.fileName = "honglou_9"
        honglou9.code = 1804
        honglou9.duration = 1170
        honglou9.star = true
        honglou9.title = "钗黛为何共用一首判词，它蕴藏了怎样的深意？"
        honglou9.releaseTime = 1616494204
        honglou9.originalUrl = "https://www.bilibili.com/video/BV1pX4y1G7g8"
        honglou9.tags = "红楼"
        honglou9.authorId = 472633781
        honglou9.cover = "https://i0.hdslb.com/bfs/archive/ffdea2840a13b7995f7a2c5612011e97b3c302e7.jpg"
        honglou9.hot = false
        honglou9.vertical = false
        list.add(honglou9)

        val honglou10 = PetVideo()
        honglou10.type = VideoType.HONGLOU.ordinal
        honglou10.fileName = "honglou_10"
        honglou10.code = 1805
        honglou10.duration = 1225
        honglou10.star = true
        honglou10.title = "薛宝钗家到底多有钱，为什么能成为贾家的“哆啦A梦”，薛家的财富密码是什么？"
        honglou10.releaseTime = 1609678482
        honglou10.originalUrl = "https://www.bilibili.com/video/BV12T4y1T7Yu"
        honglou10.tags = "红楼"
        honglou10.authorId = 472633781
        honglou10.cover = "https://i0.hdslb.com/bfs/archive/cc574f94417ca21a29a4af378c06685e7f4b398e.jpg"
        honglou10.hot = false
        honglou10.vertical = false
        list.add(honglou10)

        val honglou11 = PetVideo()
        honglou11.type = VideoType.HONGLOU.ordinal
        honglou11.fileName = "honglou_11"
        honglou11.code = 1806
        honglou11.duration = 712
        honglou11.star = true
        honglou11.title = "幽默大师林黛玉，是俏皮还是刻薄？（上）【蔡丹君】"
        honglou11.releaseTime = 1603373872
        honglou11.originalUrl = "https://www.bilibili.com/video/BV1oK4y177op"
        honglou11.tags = "红楼"
        honglou11.authorId = 472633781
        honglou11.cover = "https://i1.hdslb.com/bfs/archive/640dcca465f3560d540dcb28156ff90d7c5d95a4.jpg"
        honglou11.hot = false
        honglou11.vertical = false
        list.add(honglou11)

        val honglou12 = PetVideo()
        honglou12.type = VideoType.HONGLOU.ordinal
        honglou12.fileName = "honglou_12"
        honglou12.code = 1807
        honglou12.duration = 761
        honglou12.star = true
        honglou12.title = "黛玉叫刘姥姥“母蝗虫”，是刻薄还是雅谑？（下)【蔡丹君】"
        honglou12.releaseTime = 1603458024
        honglou12.originalUrl = "https://www.bilibili.com/video/BV11a411A7yN"
        honglou12.tags = "红楼"
        honglou12.authorId = 472633781
        honglou12.cover = "https://i1.hdslb.com/bfs/archive/12aaad6d2ce093346a870ecd5caa9edaedaea5d4.jpg"
        honglou12.hot = false
        honglou12.vertical = false
        list.add(honglou12)

        val honglou13 = PetVideo()
        honglou13.type = VideoType.HONGLOU.ordinal
        honglou13.fileName = "honglou_13"
        honglou13.code = 1808
        honglou13.duration = 410
        honglou13.star = true
        honglou13.title = "林黛玉的家产去哪了？-红楼梦系列2"
        honglou13.releaseTime = 1598788833
        honglou13.originalUrl = "https://www.bilibili.com/video/BV1Uf4y1Q7ou"
        honglou13.tags = "红楼"
        honglou13.authorId = 472633781
        honglou13.cover = "https://i2.hdslb.com/bfs/archive/e1dcd399fcce7eaf23ec7efa6067844187d7ea1a.jpg"
        honglou13.hot = false
        honglou13.vertical = false
        list.add(honglou13)

        val honglou14 = PetVideo()
        honglou14.type = VideoType.HONGLOU.ordinal
        honglou14.fileName = "honglou_14"
        honglou14.code = 1809
        honglou14.duration = 210
        honglou14.star = true
        honglou14.videoType = 0
        honglou14.title = "宝钗参加选秀是想当贵妃？NONONO，清代选秀制度了解一下-红楼梦系列3"
        honglou14.releaseTime = 1599130845
        honglou14.originalUrl = "https://www.bilibili.com/video/BV1pf4y1X7bc"
        honglou14.tags = "红楼"
        honglou14.authorId = 472633781
        honglou14.cover = "https://i2.hdslb.com/bfs/archive/5c22b70e045f1ac074ce61d38ccecbd172bb4478.jpg"
        honglou14.hot = false
        honglou14.vertical = false
        list.add(honglou14)

        val honglou15 = PetVideo()
        honglou15.type = VideoType.HONGLOU.ordinal
        honglou15.fileName = "honglou_15"
        honglou15.code = 1810
        honglou15.duration = 393
        honglou15.star = true
        honglou15.videoType = 0
        honglou15.title = "贾府的“月钱”制度是怎么样的？谁的工资最高？-红楼梦系列1"
        honglou15.releaseTime = 1598144523
        honglou15.originalUrl = "https://www.bilibili.com/video/BV1Di4y1g7Ro"
        honglou15.tags = "红楼"
        honglou15.authorId = 472633781
        honglou15.cover = "https://i2.hdslb.com/bfs/archive/c8ea7d13e928271087210f98a072093ee513dfec.jpg"
        honglou15.hot = false
        honglou15.vertical = false
        list.add(honglou15)

        val honglou16 = PetVideo()
        honglou16.type = VideoType.HONGLOU.ordinal
        honglou16.fileName = "honglou_16"
        honglou16.code = 1811
        honglou16.duration = 444
        honglou16.star = true
        honglou16.title = "王熙凤放高利贷一年能赚多少？利钱都去哪了【蔡丹君】"
        honglou16.releaseTime = 1601807433
        honglou16.originalUrl = "https://www.bilibili.com/video/BV1WA41177kr"
        honglou16.tags = "红楼"
        honglou16.authorId = 472633781
        honglou16.cover = "https://i2.hdslb.com/bfs/archive/da248371a8ae8bd4a845f41481b271c21dc366bd.jpg"
        honglou16.hot = false
        honglou16.vertical = false
        list.add(honglou16)

        val honglou17 = PetVideo()
        honglou17.type = VideoType.HONGLOU.ordinal
        honglou17.fileName = "honglou_17"
        honglou17.code = 1812
        honglou17.duration = 820
        honglou17.star = true
        honglou17.title = "古代银子怎么用，一两银子值多少钱？贾琏说再发三二百万的财，啥概念？【蔡丹君】"
        honglou17.releaseTime = 1605092172
        honglou17.originalUrl = "https://www.bilibili.com/video/BV1wy4y1z7FZ"
        honglou17.tags = "红楼"
        honglou17.authorId = 472633781
        honglou17.cover = "https://i2.hdslb.com/bfs/archive/3dbf24f0d176084f5c86769f08edefb4ba49fdba.jpg"
        honglou17.hot = false
        honglou17.vertical = false
        list.add(honglou17)

        val honglou18 = PetVideo()
        honglou18.type = VideoType.HONGLOU.ordinal
        honglou18.fileName = "honglou_18"
        honglou18.code = 1813
        honglou18.duration = 1171
        honglou18.star = true
        honglou18.title = "真穷还是装的？从《红楼梦》乌进孝进贡名单看贾府经济状况【蔡丹君】"
        honglou18.releaseTime = 1601391510
        honglou18.originalUrl = "https://www.bilibili.com/video/BV1Ek4y1C7j9"
        honglou18.tags = "红楼"
        honglou18.authorId = 472633781
        honglou18.cover = "https://i2.hdslb.com/bfs/archive/52503dcb9ea70bea3dc2f8b1d3733cb8052e3114.jpg"
        honglou18.hot = false
        honglou18.vertical = false
        list.add(honglou18)

        val honglou19 = PetVideo()
        honglou19.type = VideoType.HONGLOU.ordinal
        honglou19.fileName = "honglou_19"
        honglou19.code = 1814
        honglou19.duration = 751
        honglou19.star = true
        honglou19.title = "《红楼梦》“螃蟹宴”隐藏了贾府哪些经济问题？一个鸡蛋十文钱贵不贵？一顿饭够刘姥姥吃一年，这账算对了吗？"
        honglou19.releaseTime = 1600256184
        honglou19.originalUrl = "https://www.bilibili.com/video/BV1tT4y1A7RJ"
        honglou19.tags = "红楼"
        honglou19.authorId = 472633781
        honglou19.cover = "https://i1.hdslb.com/bfs/archive/7fe4a1f422a5efca6f04e513b50700127cb8a85d.jpg"
        honglou19.hot = false
        honglou19.vertical = false
        list.add(honglou19)

        val honglou20 = PetVideo()
        honglou20.type = VideoType.HONGLOU.ordinal
        honglou20.fileName = "honglou_20"
        honglou20.code = 1815
        honglou20.duration = 1234
        honglou20.star = true
        honglou20.title = "《葬花吟》是首诗谶？它吸收了哪些前代诗歌艺术？林黛玉的人设中为何有隐士形象？"
        honglou20.releaseTime = 1611408599
        honglou20.originalUrl = "https://www.bilibili.com/video/BV1Ky4y117oG"
        honglou20.tags = "红楼"
        honglou20.authorId = 472633781
        honglou20.cover = "https://i2.hdslb.com/bfs/archive/cec7080ba7318f065d36cf788b5aca22b36c13b6.jpg"
        honglou20.hot = false
        honglou20.vertical = false
        list.add(honglou20)

        val honglou21 = PetVideo()
        honglou21.type = VideoType.HONGLOU.ordinal
        honglou21.fileName = "honglou_21"
        honglou21.code = 1816
        honglou21.duration = 438
        honglou21.star = true
        honglou21.title = "看到宝玉喝的饮料，手里的奶茶突然不香了"
        honglou21.releaseTime = 1604226799
        honglou21.originalUrl = "https://www.bilibili.com/video/BV1BT4y1F7i6"
        honglou21.tags = "红楼"
        honglou21.authorId = 472633781
        honglou21.cover = "https://i2.hdslb.com/bfs/archive/8268a49bd2176e4198fed13177eb5380e52c7c88.jpg"
        honglou21.hot = false
        honglou21.vertical = false
        list.add(honglou21)

        val honglou22 = PetVideo()
        honglou22.type = VideoType.HONGLOU.ordinal
        honglou22.fileName = "honglou_22"
        honglou22.code = 1817
        honglou22.duration = 860
        honglou22.star = true
        honglou22.title = "《红楼梦》里的江南美食，富人的世界你看得懂吗"
        honglou22.releaseTime = 1603960665
        honglou22.originalUrl = "https://www.bilibili.com/video/BV1KT4y1F7L3"
        honglou22.tags = "红楼"
        honglou22.authorId = 472633781
        honglou22.cover = "https://i2.hdslb.com/bfs/archive/3521e9ed1d2841ce1b3b983f30f31660fd28491f.jpg"
        honglou22.hot = false
        honglou22.vertical = false
        list.add(honglou22)

        val honglou23 = PetVideo()
        honglou23.type = VideoType.HONGLOU.ordinal
        honglou23.fileName = "honglou_23"
        honglou23.code = 1818
        honglou23.duration = 1115
        honglou23.star = true
        honglou23.title = "《红楼梦》的背景是北京还是南京？大观园原型在哪儿"
        honglou23.releaseTime = 1602406703
        honglou23.originalUrl = "https://www.bilibili.com/video/BV1VT4y1w7Cd"
        honglou23.tags = "红楼"
        honglou23.authorId = 472633781
        honglou23.cover = "https://i1.hdslb.com/bfs/archive/678a5a3bfe39ba3f202338fe60c9a04318fab7f4.jpg"
        honglou23.hot = false
        honglou23.vertical = false
        list.add(honglou23)

        val honglou24 = PetVideo()
        honglou24.type = VideoType.HONGLOU.ordinal
        honglou24.fileName = "honglou_24"
        honglou24.code = 1819
        honglou24.duration = 1101
        honglou24.star = true
        honglou24.title = "元妃参加了怎样的政治斗争，最后是怎么死的？元春的判词和曲子里藏着什么信息？"
        honglou24.releaseTime = 1646822100
        honglou24.originalUrl = "https://www.bilibili.com/video/BV1SZ4y1r7o8"
        honglou24.tags = "红楼"
        honglou24.authorId = 472633781
        honglou24.cover = "https://i1.hdslb.com/bfs/archive/51e9b32380d22cd707c3f1bd514ffb5496fbc259.jpg"
        honglou24.hot = false
        honglou24.vertical = false
        list.add(honglou24)
        
        return list
    }
}