package com.example.pandas.data

import com.example.pandas.bean.pet.PetType
import com.example.pandas.sql.entity.PetVideo

object LandScapeData {

    private var list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        val landscape25 = PetVideo()
        landscape25.type = PetType.LANDSCAPE.ordinal
        landscape25.fileName = "landscape_25"
        landscape25.code = 471
        landscape25.duration = 235
        landscape25.isStar = true
        landscape25.title = "我于人间，赏山河，踏风雪"
        landscape25.releaseTime = "2021-12-28 23:35:01"
        landscape25.originalUrl = "https://www.bilibili.com/video/BV1j3411v7pc"
        landscape25.tags = "山水,风景"
        landscape25.authorName = "被生活治愈的小人物"
        landscape25.cover =
            "https://i1.hdslb.com/bfs/archive/022e4b497e5834502daf5f3d117ffefe3345b680.jpg"
        landscape25.videoType = 1
        list.add(landscape25)

        val landscape22 = PetVideo()
        landscape22.type = PetType.LANDSCAPE.ordinal
        landscape22.fileName = "landscape_22"
        landscape22.code = 474
        landscape22.duration = 64
        landscape22.isStar = true
        landscape22.title = "紫禁城的大寒瑞雪 和故宫一起冰雪过大年！"
        landscape22.releaseTime = "2022-01-20 14:57:09"
        landscape22.originalUrl = "https://www.bilibili.com/video/BV1yL4y14718"
        landscape22.tags = "山水,风景"
        landscape22.authorName = "故宫博物院"
        landscape22.cover =
            "https://i0.hdslb.com/bfs/archive/12f804f213b250289c5954a71fefa0596ff88725.jpg"
        landscape22.videoType = 1
        list.add(landscape22)

        val landscape42 = PetVideo()
        landscape42.type = PetType.LANDSCAPE.ordinal
        landscape42.fileName = "landscape_42"
        landscape42.code = 475
        landscape42.duration = 88
        landscape42.isStar = true
        landscape42.title = "“檐上三寸雪   人间惊鸿客”"
        landscape42.releaseTime = "2022-01-05 18:07:29"
        landscape42.originalUrl = "https://www.bilibili.com/video/BV1P34y167B9"
        landscape42.tags = "山水,风景"
        landscape42.authorName = "唐唐和唐"
        landscape42.cover =
            "https://i1.hdslb.com/bfs/archive/25986a6f2f742fa145be75df46469af4d547f30d.jpg"
        landscape42.videoType = 1
        list.add(landscape42)

        val landscape26 = PetVideo()
        landscape26.type = PetType.LANDSCAPE.ordinal
        landscape26.fileName = "landscape_26"
        landscape26.code = 491
        landscape26.duration = 237
        landscape26.isStar = true
        landscape26.title = "“忽有故人心上过，回首山河已入冬。两处相思同淋雪，此生也算共白头。”"
        landscape26.releaseTime = "2020-11-25 14:26:45"
        landscape26.originalUrl = "https://www.bilibili.com/video/BV13K41137oz"
        landscape26.tags = "山水,风景"
        landscape26.authorName = "知三冬"
        landscape26.cover =
            "https://i2.hdslb.com/bfs/archive/78d0190e621962220f3e9f54be250f7b4f21e82b.jpg"
        landscape26.videoType = 1
        list.add(landscape26)

        val landscape1 = PetVideo()
        landscape1.type = PetType.LANDSCAPE.ordinal
        landscape1.fileName = "landscape_1"
        landscape1.code = 450
        landscape1.duration = 31
        landscape1.isStar = true
        landscape1.title = "灵隐寺雪景｜夜深知雪重，时闻折竹声"
        landscape1.releaseTime = "2022-01-30 21:14:40"
        landscape1.originalUrl = "https://www.bilibili.com/video/BV12b4y1E7zT"
        landscape1.tags = "山水,风景"
        landscape1.authorName = "摄影的小和尚"
        landscape1.cover =
            "https://i2.hdslb.com/bfs/archive/630e71f34f6ed6adbbd7cb7bbbd37bcf15eb8869.jpg"
        landscape1.videoType = 0
        list.add(landscape1)


        val landscape2 = PetVideo()
        landscape2.type = PetType.LANDSCAPE.ordinal
        landscape2.fileName = "landscape_2"
        landscape2.code = 451
        landscape2.duration = 61
        landscape2.isStar = true
        landscape2.title = "【临安·雪】绝美杭州西湖雪景  红衣和雪景最配呀~"
        landscape2.releaseTime = "2019-01-06 01:13:32"
        landscape2.originalUrl = "https://www.bilibili.com/video/BV1At411478b"
        landscape2.tags = "山水,风景"
        landscape2.authorName = "知竹zZ"
        landscape2.cover =
            "https://i0.hdslb.com/bfs/archive/1f85742bbef5669d29849f9af1021f3d306ab83c.jpg"
        landscape2.videoType = 0
        list.add(landscape2)


        val landscape3 = PetVideo()
        landscape3.type = PetType.LANDSCAPE.ordinal
        landscape3.fileName = "landscape_3"
        landscape3.code = 452
        landscape3.duration = 26
        landscape3.isStar = true
        landscape3.title = "航拍雪中的西湖，你可以永远相信杭州的雪景"
        landscape3.releaseTime = "2022-01-30 01:10:43"
        landscape3.originalUrl = "https://www.bilibili.com/video/BV1hq4y1w773"
        landscape3.tags = "山水,风景"
        landscape3.authorName = "张力视觉"
        landscape3.cover =
            "https://i0.hdslb.com/bfs/archive/c8ff8422ee044b208d7722eb5b65898689f8d317.jpg"
        landscape3.videoType = 0
        list.add(landscape3)


        val landscape4 = PetVideo()
        landscape4.type = PetType.LANDSCAPE.ordinal
        landscape4.fileName = "landscape_4"
        landscape4.code = 453
        landscape4.duration = 268
        landscape4.isStar = true
        landscape4.title = "【忆江南】这群老戏骨 把“富春山居图”演活了"
        landscape4.releaseTime = "2022-02-01 14:14:54"
        landscape4.originalUrl = "https://www.bilibili.com/video/BV1RR4y1T7A9"
        landscape4.tags = "山水,风景"
        landscape4.authorName = "央视新闻"
        landscape4.cover =
            "https://i1.hdslb.com/bfs/archive/33a8d3faa30a5c2cc50e01d2b02e12a8842dad0d.jpg"
        landscape4.videoType = 0
        list.add(landscape4)


        val landscape5 = PetVideo()
        landscape5.type = PetType.LANDSCAPE.ordinal
        landscape5.fileName = "landscape_5"
        landscape5.code = 454
        landscape5.duration = 65
        landscape5.isStar = true
        landscape5.title = "2022央视春晚最美节目《只此青绿》沙画版复刻来了！"
        landscape5.releaseTime = "2022-02-02 12:20:59"
        landscape5.originalUrl = "https://www.bilibili.com/video/BV1N3411E7fS"
        landscape5.tags = "山水,风景"
        landscape5.authorName = "央视网"
        landscape5.cover =
            "https://i0.hdslb.com/bfs/archive/aa4911d1ba8c25c5650aeb83d163ea7ec616d73f.jpg"
        landscape5.videoType = 0
        list.add(landscape5)


        val landscape6 = PetVideo()
        landscape6.type = PetType.LANDSCAPE.ordinal
        landscape6.fileName = "landscape_6"
        landscape6.code = 455
        landscape6.duration = 17
        landscape6.isStar = true
        landscape6.title = "滕王阁"
        landscape6.releaseTime = "2021-07-02 18:35:17"
        landscape6.originalUrl = "https://www.bilibili.com/video/BV1sf4y1b7Mb"
        landscape6.tags = "山水,风景"
        landscape6.authorName = "涂文斌"
        landscape6.cover =
            "https://i0.hdslb.com/bfs/archive/842f3c7133fa8c227e6dc1ea5227d16ed5ed2de5.jpg"
        landscape6.videoType = 0
        list.add(landscape6)


        val landscape7 = PetVideo()
        landscape7.type = PetType.LANDSCAPE.ordinal
        landscape7.fileName = "landscape_7"
        landscape7.code = 456
        landscape7.duration = 12
        landscape7.isStar = true
        landscape7.title = "夜晚滕王阁"
        landscape7.releaseTime = "2021-07-04 18:25:00"
        landscape7.originalUrl = "https://www.bilibili.com/video/BV1NV411W73S"
        landscape7.tags = "山水,风景"
        landscape7.authorName = "涂文斌"
        landscape7.cover =
            "https://i1.hdslb.com/bfs/archive/d0b638263e535b7cc699777155da59b505bc0f1f.jpg"
        landscape7.videoType = 0
        list.add(landscape7)


        val landscape8 = PetVideo()
        landscape8.type = PetType.LANDSCAPE.ordinal
        landscape8.fileName = "landscape_8"
        landscape8.code = 457
        landscape8.duration = 89
        landscape8.isStar = true
        landscape8.title = "2022年看见的第一座雪山竟然在苏州？姑苏夜雪，穹窿山一夜白头"
        landscape8.releaseTime = "2022-01-29 19:54:23"
        landscape8.originalUrl = "https://www.bilibili.com/video/BV1UL411F7wo"
        landscape8.tags = "山水,风景"
        landscape8.authorName = "偶尔拍照的johnson"
        landscape8.cover =
            "https://i1.hdslb.com/bfs/archive/082cfced59becd42508e599e24647387f89976bc.jpg"
        landscape8.videoType = 0
        list.add(landscape8)


        val landscape9 = PetVideo()
        landscape9.type = PetType.LANDSCAPE.ordinal
        landscape9.fileName = "landscape_9"
        landscape9.code = 458
        landscape9.duration = 97
        landscape9.isStar = true
        landscape9.title = "最美的雪是一起看过的雪，快看乌镇下雪了，雪花纷纷飘落的时候，恰逢思念最浓"
        landscape9.releaseTime = "2022-01-29 12:57:39"
        landscape9.originalUrl = "https://www.bilibili.com/video/BV11a41117iv"
        landscape9.tags = "山水,风景"
        landscape9.authorName = "乌镇旅游景区"
        landscape9.cover =
            "https://i1.hdslb.com/bfs/archive/09f05026b225c7aa99a9ea44ea1f2ec812435307.jpg"
        landscape9.videoType = 0
        list.add(landscape9)


        val landscape10 = PetVideo()
        landscape10.type = PetType.LANDSCAPE.ordinal
        landscape10.fileName = "landscape_10"
        landscape10.code = 459
        landscape10.duration = 102
        landscape10.isStar = true
        landscape10.title = "九寨沟 诺日朗瀑布"
        landscape10.releaseTime = "2022-01-09 14:47:03"
        landscape10.originalUrl = "https://www.bilibili.com/video/BV1NL411c71K"
        landscape10.tags = "山水,风景"
        landscape10.authorName = "多吉施甸"
        landscape10.cover =
            "https://i1.hdslb.com/bfs/archive/f98e80c061b08e927fdee66e3da453ca6895267d.jpg"
        landscape10.videoType = 0
        list.add(landscape10)


        val landscape11 = PetVideo()
        landscape11.type = PetType.LANDSCAPE.ordinal
        landscape11.fileName = "landscape_11"
        landscape11.code = 460
        landscape11.duration = 364
        landscape11.isStar = true
        landscape11.title = "【4K】襄阳视界：拍摄历时四年，6分钟带你看尽千年古城襄阳"
        landscape11.releaseTime = "2021-12-09 21:09:04"
        landscape11.originalUrl = "https://www.bilibili.com/video/BV1CP4y137zb"
        landscape11.tags = "山水,风景"
        landscape11.authorName = "8KRAW"
        landscape11.cover =
            "https://i1.hdslb.com/bfs/archive/d92ad610376c724a6932b1cc04d2c649de1b0a4e.jpg"
        landscape11.videoType = 0
        list.add(landscape11)


        val landscape12 = PetVideo()
        landscape12.type = PetType.LANDSCAPE.ordinal
        landscape12.fileName = "landscape_12"
        landscape12.code = 461
        landscape12.duration = 235
        landscape12.isStar = true
        landscape12.title = "你好，我是湖北"
        landscape12.releaseTime = "2021-04-12 11:45:05"
        landscape12.originalUrl = "https://www.bilibili.com/video/BV1oK411w7si"
        landscape12.tags = "山水,风景"
        landscape12.authorName = "8KRAW"
        landscape12.cover =
            "https://i0.hdslb.com/bfs/archive/25ea548501010818a4a519fc97bf9a150f2b9d57.jpg"
        landscape12.videoType = 0
        list.add(landscape12)


        val landscape13 = PetVideo()
        landscape13.type = PetType.LANDSCAPE.ordinal
        landscape13.fileName = "landscape_13"
        landscape13.code = 462
        landscape13.duration = 143
        landscape13.isStar = true
        landscape13.title = "谁说大海只能是蓝色，这里是大连庄河红海滩"
        landscape13.releaseTime = "2021-11-18 19:37:29"
        landscape13.originalUrl = "https://www.bilibili.com/video/BV1gr4y1k7Fo"
        landscape13.tags = "山水,风景"
        landscape13.authorName = "8KRAW"
        landscape13.cover =
            "https://i2.hdslb.com/bfs/archive/43d3cdd482bb19e08c4c398bb4cf210239df9dc0.jpg"
        landscape13.videoType = 0
        list.add(landscape13)


        val landscape14 = PetVideo()
        landscape14.type = PetType.LANDSCAPE.ordinal
        landscape14.fileName = "landscape_14"
        landscape14.code = 463
        landscape14.duration = 200
        landscape14.isStar = true
        landscape14.title = "【4K】世界最大的红海滩，在中国"
        landscape14.releaseTime = "2020-10-14 20:35:07"
        landscape14.originalUrl = "https://www.bilibili.com/video/BV1zK4y1h72N"
        landscape14.tags = "山水,风景"
        landscape14.authorName = "8KRAW"
        landscape14.cover =
            "https://i1.hdslb.com/bfs/archive/a0ee37786891c7f4274372b1d8d2dafcbd04303c.jpg"
        landscape14.videoType = 0
        list.add(landscape14)


        val landscape15 = PetVideo()
        landscape15.type = PetType.LANDSCAPE.ordinal
        landscape15.fileName = "landscape_15"
        landscape15.code = 464
        landscape15.duration = 217
        landscape15.isStar = true
        landscape15.title = "禾 木 村 雪 夜【4K•航拍】"
        landscape15.releaseTime = "2021-10-08 14:39:27"
        landscape15.originalUrl = "https://www.bilibili.com/video/BV1hq4y1V76W"
        landscape15.tags = "山水,风景"
        landscape15.authorName = "LukeLiz"
        landscape15.cover =
            "https://i1.hdslb.com/bfs/archive/4f9190e57d0a42af72ef4069895b83b4baa708be.jpg"
        landscape15.videoType = 0
        list.add(landscape15)


        val landscape16 = PetVideo()
        landscape16.type = PetType.LANDSCAPE.ordinal
        landscape16.fileName = "landscape_16"
        landscape16.code = 465
        landscape16.duration = 259
        landscape16.isStar = true
        landscape16.title = "垂枝梅丨美的不可思议"
        landscape16.releaseTime = "2021-03-31 19:00:12"
        landscape16.originalUrl = "https://www.bilibili.com/video/BV1T64y1Q7dd"
        landscape16.tags = "山水,风景"
        landscape16.authorName = "棠圃"
        landscape16.cover =
            "https://i1.hdslb.com/bfs/archive/8e6beb07291e184815de314a5105535f1a3740cd.jpg"
        landscape16.videoType = 0
        list.add(landscape16)


        val landscape17 = PetVideo()
        landscape17.type = PetType.LANDSCAPE.ordinal
        landscape17.fileName = "landscape_17"
        landscape17.code = 466
        landscape17.duration = 221
        landscape17.isStar = true
        landscape17.title = "新疆2021之旅：领略一场冰与火之舞"
        landscape17.releaseTime = "2022-01-05 17:30:11"
        landscape17.originalUrl = "https://www.bilibili.com/video/BV1zu411U7Rn"
        landscape17.tags = "山水,风景"
        landscape17.authorName = "8KRAW"
        landscape17.cover =
            "https://i2.hdslb.com/bfs/archive/82efe75222378076fc327b10fe782190931efdd6.jpg"
        landscape17.videoType = 0
        list.add(landscape17)


        val landscape18 = PetVideo()
        landscape18.type = PetType.LANDSCAPE.ordinal
        landscape18.fileName = "landscape_18"
        landscape18.code = 467
        landscape18.duration = 32
        landscape18.isStar = true
        landscape18.title = "江西武功山日落云海延时摄影记录"
        landscape18.releaseTime = "2019-05-30 12:24:51"
        landscape18.originalUrl = "https://www.bilibili.com/video/BV1E4411H7U5"
        landscape18.tags = "山水,风景"
        landscape18.authorName = "麦子_小邬"
        landscape18.cover =
            "https://i1.hdslb.com/bfs/archive/27563dd484db4fe6e196c3ec868798f5cfa1ce09.jpg"
        landscape18.videoType = 0
        list.add(landscape18)


        val landscape19 = PetVideo()
        landscape19.type = PetType.LANDSCAPE.ordinal
        landscape19.fileName = "landscape_19"
        landscape19.code = 468
        landscape19.duration = 15
        landscape19.isStar = true
        landscape19.title = "2022年武功山的第一个壮观云海"
        landscape19.releaseTime = "2022-01-07 16:29:49"
        landscape19.originalUrl = "https://www.bilibili.com/video/BV1vS4y1T7MG"
        landscape19.tags = "山水,风景"
        landscape19.authorName = "一只爰旅行的胖子"
        landscape19.cover =
            "https://i0.hdslb.com/bfs/archive/5fb5effefb004f5a1084e757c502044e62130e8f.jpg"
        landscape19.videoType = 0
        list.add(landscape19)


        val landscape20 = PetVideo()
        landscape20.type = PetType.LANDSCAPE.ordinal
        landscape20.fileName = "landscape_20"
        landscape20.code = 469
        landscape20.duration = 242
        landscape20.isStar = true
        landscape20.title = "上海城市宣传片（我见过最好的）"
        landscape20.releaseTime = "2018-06-02 13:39:51"
        landscape20.originalUrl = "https://www.bilibili.com/video/BV1uW411N729"
        landscape20.tags = "山水,风景"
        landscape20.authorName = "boboli123456"
        landscape20.cover =
            "https://i1.hdslb.com/bfs/archive/9b896cd9cadf2f8fc93421c3750ca629adf9d223.jpg"
        landscape20.videoType = 0
        list.add(landscape20)


        val landscape21 = PetVideo()
        landscape21.type = PetType.LANDSCAPE.ordinal
        landscape21.fileName = "landscape_21"
        landscape21.code = 470
        landscape21.duration = 27
        landscape21.isStar = true
        landscape21.title = "通向蔚蓝的街道～威海-火炬八街"
        landscape21.releaseTime = "2021-06-05 15:00:06"
        landscape21.originalUrl = "https://www.bilibili.com/video/BV1SU4y1V759"
        landscape21.tags = "山水,风景"
        landscape21.authorName = "小林到处跑_Lin"
        landscape21.cover =
            "https://i1.hdslb.com/bfs/archive/07db953b2f7577664293cd71b652f83a6b7f1ba1.jpg"
        landscape21.videoType = 0
        list.add(landscape21)

        val landscape23 = PetVideo()
        landscape23.type = PetType.LANDSCAPE.ordinal
        landscape23.fileName = "landscape_23"
        landscape23.code = 472
        landscape23.duration = 199
        landscape23.isStar = true
        landscape23.title = "“今日只与先生煮酒赏雪，不谈风月”"
        landscape23.releaseTime = "2020-12-31 12:34:09"
        landscape23.originalUrl = "https://www.bilibili.com/video/BV1Tp4y1B7db"
        landscape23.tags = "山水,风景"
        landscape23.authorName = "知三冬"
        landscape23.cover =
            "https://i1.hdslb.com/bfs/archive/be12ec0f89ed9cbbedf86db64b1398f7e31d1656.jpg"
        landscape23.videoType = 0
        list.add(landscape23)


        val landscape24 = PetVideo()
        landscape24.type = PetType.LANDSCAPE.ordinal
        landscape24.fileName = "landscape_24"
        landscape24.code = 473
        landscape24.duration = 92
        landscape24.isStar = true
        landscape24.title = "【闹元宵| 灯会合集】人间不值得 | 欢快版变奏"
        landscape24.releaseTime = "2021-02-23 20:50:05"
        landscape24.originalUrl = "https://www.bilibili.com/video/BV14y4y1J79R"
        landscape24.tags = "山水,风景"
        landscape24.authorName = "hurricanehits"
        landscape24.cover =
            "https://i1.hdslb.com/bfs/archive/23f3922b92c1482b8fc5405499b978582584a46b.jpg"
        landscape24.videoType = 0
        list.add(landscape24)

        val landscape27 = PetVideo()
        landscape27.type = PetType.LANDSCAPE.ordinal
        landscape27.fileName = "landscape_27"
        landscape27.code = 476
        landscape27.duration = 254
        landscape27.isStar = true
        landscape27.title = "“先去你的塞外，再回我的江南”——《浮光》"
        landscape27.releaseTime = "2021-10-09 22:51:24"
        landscape27.originalUrl = "https://www.bilibili.com/video/BV1HP4y187AZ"
        landscape27.tags = "山水,风景"
        landscape27.authorName = "被生活治愈的小人物"
        landscape27.cover =
            "https://i1.hdslb.com/bfs/archive/17568708ccef774f2ec1b904a0d41f6d196801ca.jpg"
        landscape27.videoType = 0
        list.add(landscape27)


        val landscape28 = PetVideo()
        landscape28.type = PetType.LANDSCAPE.ordinal
        landscape28.fileName = "landscape_28"
        landscape28.code = 477
        landscape28.duration = 161
        landscape28.isStar = true
        landscape28.title = "“忽人间已晚，山河已秋”"
        landscape28.releaseTime = "2021-10-02 13:58:40"
        landscape28.originalUrl = "https://www.bilibili.com/video/BV1FP4y187Rg"
        landscape28.tags = "山水,风景"
        landscape28.authorName = "喵喵君想吃肉蟹煲"
        landscape28.cover =
            "https://i2.hdslb.com/bfs/archive/66cb027e130fb6bc8f96e03b52904af479003d10.jpg"
        landscape28.videoType = 0
        list.add(landscape28)


        val landscape29 = PetVideo()
        landscape29.type = PetType.LANDSCAPE.ordinal
        landscape29.fileName = "landscape_29"
        landscape29.code = 478
        landscape29.duration = 48
        landscape29.isStar = true
        landscape29.title = "阳春三月，邂逅伊犁杏花沟"
        landscape29.releaseTime = "2021-03-19 10:35:29"
        landscape29.originalUrl = "https://www.bilibili.com/video/BV1zX4y137XB"
        landscape29.tags = "山水,风景"
        landscape29.authorName = "一起来旅行吧"
        landscape29.cover =
            "https://i0.hdslb.com/bfs/archive/0e92a6c0a92e24b4973a520cd48a70cb9c3c0372.jpg"
        landscape29.videoType = 0
        list.add(landscape29)


        val landscape30 = PetVideo()
        landscape30.type = PetType.LANDSCAPE.ordinal
        landscape30.fileName = "landscape_30"
        landscape30.code = 479
        landscape30.duration = 145
        landscape30.isStar = true
        landscape30.title = "漫步洱海"
        landscape30.releaseTime = "2021-12-09 20:23:15"
        landscape30.originalUrl = "https://www.bilibili.com/video/BV1sb4y1i7SC"
        landscape30.tags = "山水,风景"
        landscape30.authorName = "肯尼_v"
        landscape30.cover =
            "https://i2.hdslb.com/bfs/archive/c1fde1704142c8924b1985c1a4ed33e369e07bd2.jpg"
        landscape30.videoType = 0
        list.add(landscape30)


        val landscape31 = PetVideo()
        landscape31.type = PetType.LANDSCAPE.ordinal
        landscape31.fileName = "landscape_31"
        landscape31.code = 480
        landscape31.duration = 12
        landscape31.isStar = true
        landscape31.title = "大理洱海，人间仙境"
        landscape31.releaseTime = "2019-10-29 10:54:01"
        landscape31.originalUrl = "https://www.bilibili.com/video/BV1vE411h7yR"
        landscape31.tags = "山水,风景"
        landscape31.authorName = "亮亮亮亮亮阿气"
        landscape31.cover =
            "https://i1.hdslb.com/bfs/archive/b9e127e7b488cd44c5bf1c022c6be69bfa7a594a.jpg"
        landscape31.videoType = 0
        list.add(landscape31)


        val landscape32 = PetVideo()
        landscape32.type = PetType.LANDSCAPE.ordinal
        landscape32.fileName = "landscape_32"
        landscape32.code = 481
        landscape32.duration = 312
        landscape32.isStar = true
        landscape32.title = "云顶天宫：老君山最新航拍【4K版】"
        landscape32.releaseTime = "2020-12-02 14:32:10"
        landscape32.originalUrl = "https://www.bilibili.com/video/BV1ca411F7PU"
        landscape32.tags = "山水,风景"
        landscape32.authorName = "WenPhoto_真实"
        landscape32.cover =
            "https://i1.hdslb.com/bfs/archive/0019038199ed421f1f778d5bb2abdea532ed111c.jpg"
        landscape32.videoType = 0
        list.add(landscape32)


        val landscape33 = PetVideo()
        landscape33.type = PetType.LANDSCAPE.ordinal
        landscape33.fileName = "landscape_33"
        landscape33.code = 482
        landscape33.duration = 179
        landscape33.isStar = true
        landscape33.title = "这，真的是人间吗？老君山【4K】摄影"
        landscape33.releaseTime = "2020-12-09 21:43:30"
        landscape33.originalUrl = "https://www.bilibili.com/video/BV1Dv411b7Ee"
        landscape33.tags = "山水,风景"
        landscape33.authorName = "8KRAW"
        landscape33.cover =
            "https://i2.hdslb.com/bfs/archive/f17b8a7b5a2b086b9ca5f01e9edf634ed1750aba.jpg"
        landscape33.videoType = 0
        list.add(landscape33)


        val landscape34 = PetVideo()
        landscape34.type = PetType.LANDSCAPE.ordinal
        landscape34.fileName = "landscape_34"
        landscape34.code = 483
        landscape34.duration = 24
        landscape34.isStar = true
        landscape34.title = "仙气飘飘，美若天宫，老君山风景区"
        landscape34.releaseTime = "2020-10-14 13:43:21"
        landscape34.originalUrl = "https://www.bilibili.com/video/BV1cp4y1k7En"
        landscape34.tags = "山水,风景"
        landscape34.authorName = "z安予"
        landscape34.cover =
            "https://i2.hdslb.com/bfs/archive/8e5f1b64a88b67cb635b9f3bfae26c379da2bd15.jpg"
        landscape34.videoType = 0
        list.add(landscape34)


        val landscape35 = PetVideo()
        landscape35.type = PetType.LANDSCAPE.ordinal
        landscape35.fileName = "landscape_35"
        landscape35.code = 484
        landscape35.duration = 10
        landscape35.isStar = true
        landscape35.title = "这不是特效！下雪后的庐山，简直就是人间仙境！"
        landscape35.releaseTime = "2018-12-09 11:07:45"
        landscape35.originalUrl = "https://www.bilibili.com/video/BV1dt411i7Vv"
        landscape35.tags = "山水,风景"
        landscape35.authorName = "赫莉乌斯"
        landscape35.cover =
            "https://i0.hdslb.com/bfs/archive/84974a77ef7010b28ddbce88e39a49bafd58cf02.jpg"
        landscape35.videoType = 0
        list.add(landscape35)


        val landscape36 = PetVideo()
        landscape36.type = PetType.LANDSCAPE.ordinal
        landscape36.fileName = "landscape_36"
        landscape36.code = 485
        landscape36.duration = 212
        landscape36.isStar = true
        landscape36.title = "“姑苏城外寒山寺”"
        landscape36.releaseTime = "2021-12-10 21:32:18"
        landscape36.originalUrl = "https://www.bilibili.com/video/BV1WF411z7Wc"
        landscape36.tags = "山水,风景"
        landscape36.authorName = "被生活治愈的小人物"
        landscape36.cover =
            "https://i0.hdslb.com/bfs/archive/b91b1e0ea4907b4877f1244b3a8dfabacb83c6bc.jpg"
        landscape36.videoType = 0
        list.add(landscape36)


        val landscape37 = PetVideo()
        landscape37.type = PetType.LANDSCAPE.ordinal
        landscape37.fileName = "landscape_37"
        landscape37.code = 486
        landscape37.duration = 209
        landscape37.isStar = true
        landscape37.title = "“你是姑苏檐下雨，亦是人间惊鸿客”"
        landscape37.releaseTime = "2021-10-14 13:11:51"
        landscape37.originalUrl = "https://www.bilibili.com/video/BV1Hq4y157Xt"
        landscape37.tags = "山水,风景"
        landscape37.authorName = "张九舟"
        landscape37.cover =
            "https://i2.hdslb.com/bfs/archive/39289415a0cf814525cf92b948ad1e5b8329dcbc.jpg"
        landscape37.videoType = 0
        list.add(landscape37)


        val landscape38 = PetVideo()
        landscape38.type = PetType.LANDSCAPE.ordinal
        landscape38.fileName = "landscape_38"
        landscape38.code = 487
        landscape38.duration = 248
        landscape38.isStar = true
        landscape38.title = "旅行：“见天地，见众生，见自己”"
        landscape38.releaseTime = "2021-08-25 00:37:05"
        landscape38.originalUrl = "https://www.bilibili.com/video/BV1Jf4y1N7Tq"
        landscape38.tags = "山水,风景"
        landscape38.authorName = "知三冬"
        landscape38.cover =
            "https://i1.hdslb.com/bfs/archive/6b7663c1b5ddefa1001d56d5de3e5b7f2615aa85.jpg"
        landscape38.videoType = 0
        list.add(landscape38)


        val landscape39 = PetVideo()
        landscape39.type = PetType.LANDSCAPE.ordinal
        landscape39.fileName = "landscape_39"
        landscape39.code = 488
        landscape39.duration = 227
        landscape39.isStar = true
        landscape39.title = "“一川烟草，满城风絮，梅子黄时雨”"
        landscape39.releaseTime = "2021-04-10 01:28:03"
        landscape39.originalUrl = "https://www.bilibili.com/video/BV1x64y1m7TA"
        landscape39.tags = "山水,风景"
        landscape39.authorName = "知三冬"
        landscape39.cover =
            "https://i1.hdslb.com/bfs/archive/cb30c82effc3fc0ae0c5f6e69a0c228aaba6020f.jpg"
        landscape39.videoType = 0
        list.add(landscape39)

        val landscape40 = PetVideo()
        landscape40.type = PetType.LANDSCAPE.ordinal
        landscape40.fileName = "landscape_40"
        landscape40.code = 489
        landscape40.duration = 236
        landscape40.isStar = true
        landscape40.title = "“小楼一夜听春雨，深巷明朝卖杏花”"
        landscape40.releaseTime = "2021-03-16 20:35:29"
        landscape40.originalUrl = "https://www.bilibili.com/video/BV1CK4y1U7Lc"
        landscape40.tags = "山水,风景"
        landscape40.authorName = "知三冬"
        landscape40.cover =
            "https://i0.hdslb.com/bfs/archive/781091148b8dd9cc1d6ee03359f3a021d81f6f28.jpg"
        landscape40.videoType = 0
        list.add(landscape40)

        val landscape41 = PetVideo()
        landscape41.type = PetType.LANDSCAPE.ordinal
        landscape41.fileName = "landscape_41"
        landscape41.code = 490
        landscape41.duration = 94
        landscape41.isStar = true
        landscape41.title = "梦醒人间看微雨，江山还似旧温柔。"
        landscape41.releaseTime = "2021-09-22 16:11:52"
        landscape41.originalUrl = "https://www.bilibili.com/video/BV1T3411m7EL"
        landscape41.tags = "山水,风景"
        landscape41.authorName = "不问天天天天"
        landscape41.cover =
            "https://i1.hdslb.com/bfs/archive/94d8d885a0fc562d22da3567b2fe9aaca2aaed3d.jpg"
        landscape41.videoType = 0
        list.add(landscape41)

        return list
    }
}