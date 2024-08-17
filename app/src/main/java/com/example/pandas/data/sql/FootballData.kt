package com.example.pandas.data.sql

import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.entity.PetVideo

object FootballData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        val football1 = PetVideo()
        football1.type = VideoType.FOOTBALL.ordinal
        football1.fileName = "football_1"
        football1.code = 1998
        football1.duration = 693
        football1.star = true
        football1.title = "快乐足球四天王，究竟谁才是最强？"
        football1.releaseTime = 1599224189
        football1.originalUrl = "https://www.bilibili.com/video/BV14A411n7LR"
        football1.tags = "足球"
        football1.authorId = 105502937
        football1.cover =
            "https://i2.hdslb.com/bfs/archive/c0378004cc1e77c34d348121adaec452cf6f1a08.jpg"
        football1.hot = false
        football1.vertical = false
        list.add(football1)

        val football2 = PetVideo()
        football2.type = VideoType.FOOTBALL.ordinal
        football2.fileName = "football_2"
        football2.code = 1999
        football2.duration = 246
        football2.star = true
        football2.title = "“欧洲黑店”是什么梗？靠卖球员，5年挣出1支阿森纳，不比修球场划算？"
        football2.releaseTime = 1642077251
        football2.originalUrl = "https://www.bilibili.com/video/BV1kq4y1A7b8"
        football2.tags = "足球"
        football2.authorId = 2105092609
        football2.cover =
            "https://i2.hdslb.com/bfs/archive/492967cceecbbaa6765580d259ddcc7289c6611d.jpg"
        football2.hot = false
        football2.vertical = false
        list.add(football2)

        val football3 = PetVideo()
        football3.type = VideoType.FOOTBALL.ordinal
        football3.fileName = "football_3"
        football3.code = 2000
        football3.duration = 234
        football3.star = true
        football3.videoType = 0
        football3.title = "“荷兰三棍客”是什么梗？每天生活小目标：吃饭睡觉，打亨特拉尔"
        football3.releaseTime = 1642336092
        football3.originalUrl = "https://www.bilibili.com/video/BV1kr4y1Y7QE"
        football3.tags = "足球"
        football3.authorId = 2105092609
        football3.cover =
            "https://i0.hdslb.com/bfs/archive/1a9049472ac2c5ce7bbe2f5f397ab5ffc7991121.jpg"
        football3.hot = false
        football3.vertical = false
        list.add(football3)

        val football4 = PetVideo()
        football4.type = VideoType.FOOTBALL.ordinal
        football4.fileName = "football_4"
        football4.code = 2001
        football4.duration = 186
        football4.star = true
        football4.title = "“金色侦察机”是什么梗？速度快，跑位妖，覆盖广，就是没有攻击能力"
        football4.releaseTime = 1639653323
        football4.originalUrl = "https://www.bilibili.com/video/BV1sa411k7Ci"
        football4.tags = "足球"
        football4.authorId = 2105092609
        football4.cover =
            "https://i1.hdslb.com/bfs/archive/9c28178633985b8e634363713e39680d6ae71c76.jpg"
        football4.hot = false
        football4.vertical = false
        list.add(football4)

        val football5 = PetVideo()
        football5.type = VideoType.FOOTBALL.ordinal
        football5.fileName = "football_5"
        football5.code = 2002
        football5.duration = 191
        football5.star = true
        football5.videoType = 0
        football5.title = "“双逆足球员”是什么梗？快如马，奈何傻，逆足前锋莫拉塔"
        football5.releaseTime = 1638011202
        football5.originalUrl = "https://www.bilibili.com/video/BV15Y411s7G9"
        football5.tags = "足球"
        football5.authorId = 2105092609
        football5.cover =
            "https://i1.hdslb.com/bfs/archive/9b108d1dd3393f8e25a885f9c6bb78fa797dac06.jpg"
        football5.hot = false
        football5.vertical = false
        list.add(football5)

        val football6 = PetVideo()
        football6.type = VideoType.FOOTBALL.ordinal
        football6.fileName = "football_6"
        football6.code = 2003
        football6.duration = 443
        football6.star = true
        football6.title = "【回顾】足坛最快的男人！9分钟5球安联球场上演“莱万时刻”！"
        football6.releaseTime = 1639207633
        football6.originalUrl = "https://www.bilibili.com/video/BV1P3411t7Gu"
        football6.tags = "足球"
        football6.authorId = 32154760
        football6.cover =
            "https://i1.hdslb.com/bfs/archive/bc002009edb67c3d7eccd8eff33f3c67b5ee1fd6.jpg"
        football6.hot = false
        football6.vertical = false
        list.add(football6)

        val football7 = PetVideo()
        football7.type = VideoType.FOOTBALL.ordinal
        football7.fileName = "football_7"
        football7.code = 2004
        football7.duration = 426
        football7.star = true
        football7.title = "【回顾】让二追三！C罗帽子戏法系列之逆转狼堡！15/16赛季欧冠皇马3-0沃尔夫斯堡"
        football7.releaseTime = 1640352625
        football7.originalUrl = "https://www.bilibili.com/video/BV1pF411B7wE"
        football7.tags = "足球"
        football7.authorId = 32154760
        football7.cover =
            "https://i0.hdslb.com/bfs/archive/fbd4197e94a4e9bbd3ea0e52199462d61468c9e7.jpg"
        football7.hot = false
        football7.vertical = false
        list.add(football7)

        val football8 = PetVideo()
        football8.type = VideoType.FOOTBALL.ordinal
        football8.fileName = "football_8"
        football8.code = 2005
        football8.duration = 479
        football8.star = true
        football8.videoType = 0
        football8.title = "【回顾】还记得那年飞翔的荷兰人吗？14年世界杯荷兰三棍客齐发威 荷兰5-1大胜西班牙"
        football8.releaseTime = 1644933504
        football8.originalUrl = "https://www.bilibili.com/video/BV1QL4y137Gx"
        football8.tags = "足球"
        football8.authorId = 32154760
        football8.cover =
            "https://i1.hdslb.com/bfs/archive/b4fdf87c57f0b1c4e6499910d2db6befe449ded9.jpg"
        football8.hot = false
        football8.vertical = false
        list.add(football8)

        val football9 = PetVideo()
        football9.type = VideoType.FOOTBALL.ordinal
        football9.fileName = "football_9"
        football9.code = 2006
        football9.duration = 522
        football9.star = true
        football9.title = "【回顾】16黄4红！世界杯史上最混乱的一夜究竟发生了什么？06年世界杯1/8决赛葡萄牙1-0荷兰"
        football9.releaseTime = 1633095346
        football9.originalUrl = "https://www.bilibili.com/video/BV16f4y1F7Gp"
        football9.tags = "足球"
        football9.authorId = 32154760
        football9.cover =
            "https://i0.hdslb.com/bfs/archive/ffce3769052a1df277833d2afdacb6d512369ff7.png"
        football9.hot = false
        football9.vertical = false
        list.add(football9)

        val football10 = PetVideo()
        football10.type = VideoType.FOOTBALL.ordinal
        football10.fileName = "football_10"
        football10.code = 2007
        football10.duration = 987
        football10.star = true
        football10.title = "天下足球——十大杀手之十大兵器。。。"
        football10.releaseTime = 1641821474
        football10.originalUrl = "https://www.bilibili.com/video/BV1s44y157zk"
        football10.tags = "足球"
        football10.authorId = 414612336
        football10.cover =
            "https://i0.hdslb.com/bfs/archive/42e6e88c23041bee6981944786b2c91d40a2f6a3.jpg"
        football10.hot = false
        football10.vertical = false
        list.add(football10)

        val football11 = PetVideo()
        football11.type = VideoType.FOOTBALL.ordinal
        football11.fileName = "football_11"
        football11.code = 2008
        football11.duration = 58
        football11.star = true
        football11.title = "卡卡凌空斩攻破尤文球门，力与美的完美结合！"
        football11.releaseTime = 1645678805
        football11.originalUrl = "https://www.bilibili.com/video/BV1tm4y1R7jq"
        football11.tags = "足球"
        football11.authorId = 13621
        football11.cover =
            "https://i0.hdslb.com/bfs/archive/1549a9b9f043f107bfe1dfc6d83ad0c0933d5dad.jpg"
        football11.hot = false
        football11.vertical = false
        list.add(football11)

        val football12 = PetVideo()
        football12.type = VideoType.FOOTBALL.ordinal
        football12.fileName = "football_12"
        football12.code = 2009
        football12.duration = 1796
        football12.star = true
        football12.title = "【天下足球】十大经典球星绰号"
        football12.releaseTime = 1607171547
        football12.originalUrl = "https://www.bilibili.com/video/BV1ep4y1z7kH"
        football12.tags = "足球"
        football12.authorId = 438232879
        football12.cover =
            "https://i2.hdslb.com/bfs/archive/f6ba5538aea1c9d1be021aad0187d8566a264497.jpg"
        football12.hot = false
        football12.vertical = false
        list.add(football12)

        val football13 = PetVideo()
        football13.type = VideoType.FOOTBALL.ordinal
        football13.fileName = "football_13"
        football13.code = 2010
        football13.duration = 711
        football13.star = true
        football13.title = "《天下足球·隐退》传奇功成，不舍离别  央视最好文案"
        football13.releaseTime = 1558980587
        football13.originalUrl = "https://www.bilibili.com/video/BV1K4411W7Nt"
        football13.tags = "足球"
        football13.authorId = 392913805
        football13.cover =
            "https://i1.hdslb.com/bfs/archive/d3b87508cd855c5a7f4defc43b2c487a11d0fba5.jpg"
        football13.hot = false
        football13.vertical = false
        list.add(football13)

//        val football14 = PetVideo()
//        football14.type = VideoType.FOOTBALL.ordinal
//        football14.fileName = "football_14"
//        football14.code = 2011
//        football14.duration = 1603
//        football14.star = true
//        football14.title = "天下足球 男人四十致敬76黄金一代"
//        football14.releaseTime = 1608627272
//        football14.originalUrl = "https://www.bilibili.com/video/BV1JK411G7HB"
//        football14.tags = "足球"
//        football14.authorId = 491334548
//        football14.cover =
//            "https://i1.hdslb.com/bfs/archive/5182cde0ef583a27fd807c523713f160c02b53a1.jpg"
//        football14.hot = false
//        football14.vertical = false
//        list.add(football14)

//        val football15 = PetVideo()
//        football15.type = VideoType.FOOTBALL.ordinal
//        football15.fileName = "football_15"
//        football15.code = 2012
//        football15.duration = 1371
//        football15.star = true
//        football15.title = "【天下足球】C罗：红色记忆"
//        football15.releaseTime = 1624892091
//        football15.originalUrl = "https://www.bilibili.com/video/BV1vB4y1K7mh"
//        football15.tags = "足球"
//        football15.authorId = 490749435
//        football15.cover =
//            "https://i1.hdslb.com/bfs/archive/dd2bb633476dfac3c64f5b69d52e42079568e0c2.jpg"
//        football15.hot = false
//        football15.vertical = false
//        list.add(football15)

        val football16 = PetVideo()
        football16.type = VideoType.FOOTBALL.ordinal
        football16.fileName = "football_16"
        football16.code = 2013
        football16.duration = 903
        football16.star = true
        football16.title = "二十年二十人（因扎吉、曼奇尼）"
        football16.releaseTime = 1531105736
        football16.originalUrl = "https://www.bilibili.com/video/BV1cs411W7ke"
        football16.tags = "足球"
        football16.authorId = 33907247
        football16.cover =
            "https://i1.hdslb.com/bfs/archive/b400a4a6c2906f074f6c2905a1a821c456b72e7b.jpg"
        football16.hot = false
        football16.vertical = false
        list.add(football16)

        val football17 = PetVideo()
        football17.type = VideoType.FOOTBALL.ordinal
        football17.fileName = "football_17"
        football17.code = 2014
        football17.duration = 820
        football17.star = true
        football17.title = "罗纳尔多、舍甫琴科（二十年二十人）"
        football17.releaseTime = 1530269498
        football17.originalUrl = "https://www.bilibili.com/video/BV13s411576a"
        football17.tags = "足球"
        football17.authorId = 33907247
        football17.cover =
            "https://i0.hdslb.com/bfs/archive/1e4a4b6e866f42ebec989d8254c8c4c5a8f6c1f1.jpg"
        football17.hot = false
        football17.vertical = false
        list.add(football17)

        val football18 = PetVideo()
        football18.type = VideoType.FOOTBALL.ordinal
        football18.fileName = "football_18"
        football18.code = 2015
        football18.duration = 25
        football18.star = true
        football18.title = "“英超史上最珍贵的合影”"
        football18.releaseTime = 1636118882
        football18.originalUrl = "https://www.bilibili.com/video/BV1fu411o7Tp"
        football18.tags = "足球"
        football18.authorId = 1117193657
        football18.cover =
            "https://i2.hdslb.com/bfs/archive/7325440b04e1ae7cc84d35900fbb06325d1e0745.jpg"
        football18.hot = false
        football18.vertical = false
        list.add(football18)

        val football19 = PetVideo()
        football19.type = VideoType.FOOTBALL.ordinal
        football19.fileName = "football_19"
        football19.code = 2016
        football19.duration = 26
        football19.star = true
        football19.title = "温格被罚上曼联看台的那一刻"
        football19.releaseTime = 1625144405
        football19.originalUrl = "https://www.bilibili.com/video/BV1dL411p7rD"
        football19.tags = "足球"
        football19.authorId = 22849238
        football19.cover =
            "https://i2.hdslb.com/bfs/archive/42c29ed38adbda282606840a7264b8128bab4e31.jpg"
        football19.hot = false
        football19.vertical = false
        list.add(football19)

        val football20 = PetVideo()
        football20.type = VideoType.FOOTBALL.ordinal
        football20.fileName = "football_20"
        football20.code = 2017
        football20.duration = 771
        football20.star = true
        football20.title = "马尔蒂尼、内德维德（二十年二十人）"
        football20.releaseTime = 1530274725
        football20.originalUrl = "https://www.bilibili.com/video/BV1Gs411573F"
        football20.tags = "足球"
        football20.authorId = 33907247
        football20.cover =
            "https://i1.hdslb.com/bfs/archive/300276ce78406e3236f020e33891e242ff0570a9.jpg"
        football20.hot = false
        football20.vertical = false
        list.add(football20)

        val football21 = PetVideo()
        football21.type = VideoType.FOOTBALL.ordinal
        football21.fileName = "football_21"
        football21.code = 2018
        football21.duration = 713
        football21.star = true
        football21.title = "2004年捷克3-2荷兰，疯狂进攻创造经典，连追3球逆转荷兰"
        football21.releaseTime = 1645203318
        football21.originalUrl = "https://www.bilibili.com/video/BV1aR4y1V7Ni"
        football21.tags = "足球"
        football21.authorId = 524346444
        football21.cover =
            "https://i0.hdslb.com/bfs/archive/06efa22aa56b4e33c4bbc1462b6448f2cfcf89ef.jpg"
        football21.hot = false
        football21.vertical = false
        list.add(football21)

//        val football22 = PetVideo()
//        football22.type = VideoType.FOOTBALL.ordinal
//        football22.fileName = "football_22"
//        football22.code = 2019
//        football22.duration = 3750
//        football22.star = true
//        football22.title = "天下足球: 魔兽德罗巴退役纪念特辑"
//        football22.releaseTime = 1543306632
//        football22.originalUrl = "https://www.bilibili.com/video/BV19t41197LY"
//        football22.tags = "足球"
//        football22.authorId = 88004317
//        football22.cover =
//            "https://i1.hdslb.com/bfs/archive/f9042e5a46513158b5d5c99ae679b91608920f22.jpg"
//        football22.hot = false
//        football22.vertical = false
//        list.add(football22)

        val football23 = PetVideo()
        football23.type = VideoType.FOOTBALL.ordinal
        football23.fileName = "football_23"
        football23.code = 2020
        football23.duration = 138
        football23.star = true
        football23.videoType = 1
        football23.title = "暴力美学！只有德罗巴才能打进的球"
        football23.releaseTime = 1645182556
        football23.originalUrl = "https://www.bilibili.com/video/BV1BP4y1F7Zg"
        football23.tags = "足球"
        football23.authorId = 1488532268
        football23.cover =
            "https://i1.hdslb.com/bfs/archive/f82927f89677814310f4967b6277b4056ff885d9.jpg"
        football23.hot = false
        football23.vertical = false
        list.add(football23)

        val football24 = PetVideo()
        football24.type = VideoType.FOOTBALL.ordinal
        football24.fileName = "football_24"
        football24.code = 2021
        football24.duration = 238
        football24.star = true
        football24.title = "当年老男孩们球场再次相聚，诠释足球真正魅力，岁月如歌青春不再"
        football24.releaseTime = 1614767662
        football24.originalUrl = "https://www.bilibili.com/video/BV1YV411v71b"
        football24.tags = "足球"
        football24.authorId = 506034970
        football24.cover =
            "https://i2.hdslb.com/bfs/archive/29ae55d5d80b605e70c8c6c984f1bec06c83481c.jpg"
        football24.hot = false
        football24.vertical = false
        list.add(football24)

        val football25 = PetVideo()
        football25.type = VideoType.FOOTBALL.ordinal
        football25.fileName = "football_25"
        football25.code = 2022
        football25.duration = 1809
        football25.star = true
        football25.title = "[天下足球]绝对巨星：优雅杀手—卡卡"
        football25.releaseTime = 1460633737
        football25.originalUrl = "https://www.bilibili.com/video/BV1ms411z769"
        football25.tags = "足球"
        football25.authorId = 3023698
        football25.cover =
            "https://i0.hdslb.com/bfs/archive/34f821d3367bb414794a8e71ddcc1c3fed8771ae.jpg"
        football25.hot = false
        football25.vertical = false
        list.add(football25)

//        val football26 = PetVideo()
//        football26.type = VideoType.FOOTBALL.ordinal
//        football26.fileName = "football_26"
//        football26.code = 2023
//        football26.duration = 971
//        football26.star = true
//        football26.title = "卡卡中文纪录片《上帝之子》Ⅱ，梦碎南非，追风少年再也追不上曾经的自己！"
//        football26.releaseTime = 1602331488
//        football26.originalUrl = "https://www.bilibili.com/video/BV1oA41177NV"
//        football26.tags = "足球"
//        football26.authorId = 643958569
//        football26.cover =
//            "https://i0.hdslb.com/bfs/archive/b8aea5713471db11398ce545aecf4f1c9704cc18.jpg"
//        football26.hot = false
//        football26.vertical = false
//        list.add(football26)
//
//        val football27 = PetVideo()
//        football27.type = VideoType.FOOTBALL.ordinal
//        football27.fileName = "football_27"
//        football27.code = 2024
//        football27.duration = 1065
//        football27.star = true
//        football27.title = "卡卡中文纪录片《上帝之子》Ⅰ，从大伤瘫痪到登顶欧洲，连上帝都被他感动"
//        football27.releaseTime = 1601037737
//        football27.originalUrl = "https://www.bilibili.com/video/BV1dK4y1a7Vr"
//        football27.tags = "足球"
//        football27.authorId = 643958569
//        football27.cover =
//            "https://i1.hdslb.com/bfs/archive/eba5e50279a3573a75a60c7dd4c50e79a2e524e6.jpg"
//        football27.hot = false
//        football27.vertical = false
//        list.add(football27)

        val football28 = PetVideo()
        football28.type = VideoType.FOOTBALL.ordinal
        football28.fileName = "football_28"
        football28.code = 2025
        football28.duration = 903
        football28.star = true
        football28.title = "【天下足球】二十年二十人（因扎吉、曼奇尼）"
        football28.releaseTime = 1537714151
        football28.originalUrl = "https://www.bilibili.com/video/BV1YW411z7BX"
        football28.tags = "足球"
        football28.authorId = 8615665
        football28.cover =
            "https://i0.hdslb.com/bfs/archive/67701a37617bad3ffdd78d3423a406a0b35d559b.jpg"
        football28.hot = false
        football28.vertical = false
        list.add(football28)

        val football29 = PetVideo()
        football29.type = VideoType.FOOTBALL.ordinal
        football29.fileName = "football_29"
        football29.code = 2026
        football29.duration = 793
        football29.star = true
        football29.title = "二十年二十人（维阿、齐达内）"
        football29.releaseTime = 1531105419
        football29.originalUrl = "https://www.bilibili.com/video/BV1cs411W7YX"
        football29.tags = "足球"
        football29.authorId = 33907247
        football29.cover =
            "https://i1.hdslb.com/bfs/archive/2a4714f37a0ca3c92e3e02f5c2a5811f08ff38f4.jpg"
        football29.hot = false
        football29.vertical = false
        list.add(football29)

        val football30 = PetVideo()
        football30.type = VideoType.FOOTBALL.ordinal
        football30.fileName = "football_30"
        football30.code = 2027
        football30.duration = 774
        football30.star = true
        football30.title = "德国三驾马车、维耶里（二十年二十人）"
        football30.releaseTime = 1530262019
        football30.originalUrl = "https://www.bilibili.com/video/BV1Es41157ed"
        football30.tags = "足球"
        football30.authorId = 33907247
        football30.cover =
            "https://i0.hdslb.com/bfs/archive/8f413b12e5855d1f7b4d37ffa02d090079e49c40.jpg"
        football30.hot = false
        football30.vertical = false
        list.add(football30)

        val football31 = PetVideo()
        football31.type = VideoType.FOOTBALL.ordinal
        football31.fileName = "football_31"
        football31.code = 2028
        football31.duration = 904
        football31.star = true
        football31.title = "巴蒂、西格诺里（二十年二十人）"
        football31.releaseTime = 1530262598
        football31.originalUrl = "https://www.bilibili.com/video/BV1Es41157kA"
        football31.tags = "足球"
        football31.authorId = 33907247
        football31.cover =
            "https://i1.hdslb.com/bfs/archive/133d0e1d20ebc04040e553b23fe3ec40eeb16d52.jpg"
        football31.hot = false
        football31.vertical = false
        list.add(football31)

        val football32 = PetVideo()
        football32.type = VideoType.FOOTBALL.ordinal
        football32.fileName = "football_32"
        football32.code = 2029
        football32.duration = 705
        football32.star = true
        football32.title = "二十年二十人（马拉多纳、维亚利）"
        football32.releaseTime = 1530270618
        football32.originalUrl = "https://www.bilibili.com/video/BV13s41157tA"
        football32.tags = "足球"
        football32.authorId = 33907247
        football32.cover =
            "https://i0.hdslb.com/bfs/archive/76ef9e9a0bf3e03f22657091086a15e05baa103b.jpg"
        football32.hot = false
        football32.vertical = false
        list.add(football32)

        val football33 = PetVideo()
        football33.type = VideoType.FOOTBALL.ordinal
        football33.fileName = "football_33"
        football33.code = 2030
        football33.duration = 1205
        football33.star = true
        football33.title = "二十年二十人（皮耶罗、托蒂）"
        football33.releaseTime = 1531102176
        football33.originalUrl = "https://www.bilibili.com/video/BV1ws411W7zk"
        football33.tags = "足球"
        football33.authorId = 33907247
        football33.cover =
            "https://i0.hdslb.com/bfs/archive/7b29b1009c061cf4afbc81209c5af75caf95f165.jpg"
        football33.hot = false
        football33.vertical = false
        list.add(football33)

        val football34 = PetVideo()
        football34.type = VideoType.FOOTBALL.ordinal
        football34.fileName = "football_34"
        football34.code = 2031
        football34.duration = 1114
        football34.star = true
        football34.title = "二十年二十人（萨内蒂、布冯）"
        football34.releaseTime = 1531104501
        football34.originalUrl = "https://www.bilibili.com/video/BV1cs411W79R"
        football34.tags = "足球"
        football34.authorId = 33907247
        football34.cover =
            "https://i1.hdslb.com/bfs/archive/f5b726de63ed43e14aaafb15d3ede25243021e34.jpg"
        football34.hot = false
        football34.vertical = false
        list.add(football34)

        val football35 = PetVideo()
        football35.type = VideoType.FOOTBALL.ordinal
        football35.fileName = "football_35"
        football35.code = 2032
        football35.duration = 820
        football35.star = true
        football35.title = "【天下足球】二十年二十人（罗纳尔多、舍甫琴科）"
        football35.releaseTime = 1537097565
        football35.originalUrl = "https://www.bilibili.com/video/BV1hW411k7LL"
        football35.tags = "足球"
        football35.authorId = 8615665
        football35.cover =
            "https://i2.hdslb.com/bfs/archive/06ba3036b4546136b55c6d4116885fb0d9411b76.jpg"
        football35.hot = false
        football35.vertical = false
        list.add(football35)

        val football36 = PetVideo()
        football36.type = VideoType.FOOTBALL.ordinal
        football36.fileName = "football_36"
        football36.code = 2033
        football36.duration = 863
        football36.star = true
        football36.title = "巴乔、荷兰3剑客（二十年二十人）"
        football36.releaseTime = 1530268599
        football36.originalUrl = "https://www.bilibili.com/video/BV13s41157e3"
        football36.tags = "足球"
        football36.authorId = 33907247
        football36.cover =
            "https://i1.hdslb.com/bfs/archive/805a097a96fe8b1a986472cbc544d2fab70365c6.jpg"
        football36.hot = false
        football36.vertical = false
        list.add(football36)

        val football37 = PetVideo()
        football37.type = VideoType.FOOTBALL.ordinal
        football37.fileName = "football_37"
        football37.code = 2034
        football37.duration = 479
        football37.star = true
        football37.title = "【罗纳尔多45大过门将集锦】能把过门将做成集锦足坛只此一人！"
        football37.releaseTime = 1628793953
        football37.originalUrl = "https://www.bilibili.com/video/BV1qA411w7fs"
        football37.tags = "足球"
        football37.authorId = 508258142
        football37.cover =
            "https://i2.hdslb.com/bfs/archive/ecbd0b1e66186d9ef66fe81c4e1dc1e24c2a2f47.jpg"
        football37.hot = false
        football37.vertical = false
        list.add(football37)

//        val football38 = PetVideo()
//        football38.type = VideoType.FOOTBALL.ordinal
//        football38.fileName = "football_38"
//        football38.code = 2035
//        football38.duration = 677
//        football38.star = true
//        football38.title = "【阿森纳】别找了！这就是行云流水的美丽足球"
//        football38.releaseTime = 1625401240
//        football38.originalUrl = "https://www.bilibili.com/video/BV1rh411h7fU"
//        football38.tags = "足球"
//        football38.authorId = 1488532268
//        football38.cover =
//            "https://i1.hdslb.com/bfs/archive/cb8b1fb93cdb36a513d1a7e7e4a354ad5ae77c42.jpg"
//        football38.hot = false
//        football38.vertical = false
//        list.add(football38)

        val football39 = PetVideo()
        football39.type = VideoType.FOOTBALL.ordinal
        football39.fileName = "football_39"
        football39.code = 2036
        football39.duration = 324
        football39.star = true
        football39.title = "「纯解说1080p60」史上只有阿森纳才能进的10个球"
        football39.releaseTime = 1570012255
        football39.originalUrl = "https://www.bilibili.com/video/BV15E411Q7y7"
        football39.tags = "足球"
        football39.authorId = 280127123
        football39.cover =
            "https://i1.hdslb.com/bfs/archive/b8bd648fd5364510391a0644e18a626f5a5d18f0.jpg"
        football39.hot = false
        football39.vertical = false
        list.add(football39)

//        val football40 = PetVideo()
//        football40.type = VideoType.FOOTBALL.ordinal
//        football40.fileName = "football_40"
//        football40.code = 2037
//        football40.duration = 3367
//        football40.star = true
//        football40.title = "[天下足球]特别企划：温格——枪手风云-CCTV-5"
//        football40.releaseTime = 1526456399
//        football40.originalUrl = "https://www.bilibili.com/video/BV1yp411Z7ph"
//        football40.tags = "足球"
//        football40.authorId = 75058975
//        football40.cover =
//            "https://i1.hdslb.com/bfs/archive/1429e209deef067f1745e8205bb7a3ffad685427.png"
//        football40.hot = false
//        football40.vertical = false
//        list.add(football40)

//        val football41 = PetVideo()
//        football41.type = VideoType.FOOTBALL.ordinal
//        football41.fileName = "football_41"
//        football41.code = 2038
//        football41.duration = 1988
//        football41.star = true
//        football41.title = "【绝对巨星：内斯塔】你是罗马城走出的俊美少年，如水般沉静的优雅卫士"
//        football41.releaseTime = 1616174459
//        football41.originalUrl = "https://www.bilibili.com/video/BV1AX4y1G7EF"
//        football41.tags = "足球"
//        football41.authorId = 36826532
//        football41.cover =
//            "https://i1.hdslb.com/bfs/archive/053e8759015c67c17305ed1c90fb259dccbe4d36.jpg"
//        football41.hot = false
//        football41.vertical = false
//        list.add(football41)

        val football42 = PetVideo()
        football42.type = VideoType.FOOTBALL.ordinal
        football42.fileName = "football_42"
        football42.code = 2039
        football42.duration = 1229
        football42.star = true
        football42.title = "[天下足球]退役纪念特辑——切赫：坚不可摧 720P高清"
        football42.releaseTime = 1612076383
        football42.originalUrl = "https://www.bilibili.com/video/BV1jK4y1p7cp"
        football42.tags = "足球"
        football42.authorId = 356416793
        football42.cover =
            "https://i1.hdslb.com/bfs/archive/45c297a5baf5b24b636aa89c8fcc4c16108a5e75.png"
        football42.hot = false
        football42.vertical = false
        list.add(football42)

//        val football43 = PetVideo()
//        football43.type = VideoType.FOOTBALL.ordinal
//        football43.fileName = "football_43"
//        football43.code = 2040
//        football43.duration = 1770
//        football43.star = true
//        football43.title = "9月8日 天下足球（再见，K神！再见，队长！）"
//        football43.releaseTime = 1410228164
//        football43.originalUrl = "https://www.bilibili.com/video/BV1bx411K7bd"
//        football43.tags = "足球"
//        football43.authorId = 5458690
//        football43.cover =
//            "https://i1.hdslb.com/bfs/archive/661a922ee1d1fa1a4aefe0a8299ace612e81df09.jpg"
//        football43.hot = false
//        football43.vertical = false
//        list.add(football43)

        val football44 = PetVideo()
        football44.type = VideoType.FOOTBALL.ordinal
        football44.fileName = "football_44"
        football44.code = 2041
        football44.duration = 145
        football44.star = true
        football44.videoType = 0
        football44.title = "不同年代阿森纳的地位"
        football44.releaseTime = 1631274611
        football44.originalUrl = "https://www.bilibili.com/video/BV1JA411F7HV"
        football44.tags = "足球"
        football44.authorId = 226243718
        football44.cover =
            "https://i0.hdslb.com/bfs/archive/dcca9c3d247ac0359fda87a5bc1be9ffac71ca88.jpg"
        football44.hot = false
        football44.vertical = false
        list.add(football44)

        val football45 = PetVideo()
        football45.type = VideoType.FOOTBALL.ordinal
        football45.fileName = "football_45"
        football45.code = 2042
        football45.duration = 332
        football45.star = true
        football45.title = "阿森纳是什么梗？天下段子共一石，阿森纳独占八斗"
        football45.releaseTime = 1633956975
        football45.originalUrl = "https://www.bilibili.com/video/BV1wf4y1g7hv"
        football45.tags = "足球"
        football45.authorId = 2105092609
        football45.cover =
            "https://i0.hdslb.com/bfs/archive/ad815a35f7a572e6c04c2824626c7eb9a47df2e9.jpg"
        football45.hot = false
        football45.vertical = false
        list.add(football45)

//        val football46 = PetVideo()
//        football46.type = VideoType.FOOTBALL.ordinal
//        football46.fileName = "football_46"
//        football46.code = 2043
//        football46.duration = 2611
//        football46.star = true
//        football46.title = "世界杯往事之罗纳尔多：你是唯一"
//        football46.releaseTime = 1522511092
//        football46.originalUrl = "https://www.bilibili.com/video/BV1vW411u7iS"
//        football46.tags = "足球"
//        football46.authorId = 11386359
//        football46.cover =
//            "https://i2.hdslb.com/bfs/archive/8710c50c9f2133d862b5f07c69045814eac625f1.png"
//        football46.hot = false
//        football46.vertical = false
//        list.add(football46)

        val football47 = PetVideo()
        football47.type = VideoType.FOOTBALL.ordinal
        football47.fileName = "football_47"
        football47.code = 2044
        football47.duration = 1072
        football47.star = true
        football47.title = "催泪  足球20年 天下之大 足球一家"
        football47.releaseTime = 1605583662
        football47.originalUrl = "https://www.bilibili.com/video/BV1Va4y1x7Mm"
        football47.tags = "足球"
        football47.authorId = 143866924
        football47.cover =
            "https://i1.hdslb.com/bfs/archive/0a49553fd2a0fc05785d1b3ebc57074881b23844.jpg"
        football47.hot = false
        football47.vertical = false
        list.add(football47)

//        val football48 = PetVideo()
//        football48.type = VideoType.FOOTBALL.ordinal
//        football48.fileName = "football_48"
//        football48.code = 2045
//        football48.duration = 795
//        football48.star = true
//        football48.title = "20181224《天下足球》· 2018足球回忆：泪水无情，泪水有情"
//        football48.releaseTime = 1545723587
//        football48.originalUrl = "https://www.bilibili.com/video/BV1Pt411C7MW"
//        football48.tags = "足球"
//        football48.authorId = 388698561
//        football48.cover =
//            "https://i2.hdslb.com/bfs/archive/c00ae5b3f8a4fd732ab220f76ff9ff3ca01713b3.jpg"
//        football48.hot = false
//        football48.vertical = false
//        list.add(football48)

        val football49 = PetVideo()
        football49.type = VideoType.FOOTBALL.ordinal
        football49.fileName = "football_49"
        football49.code = 2046
        football49.duration = 602
        football49.star = true
        football49.title = "【传奇谢幕】离开时你已是传奇，希望归来时你仍是少年"
        football49.releaseTime = 1505963025
        football49.originalUrl = "https://www.bilibili.com/video/BV1tx411x7RQ"
        football49.tags = "足球"
        football49.authorId = 56593688
        football49.cover =
            "https://i2.hdslb.com/bfs/archive/af16a0057205961abc2956dbab059b40325530c1.jpg"
        football49.hot = false
        football49.vertical = false
        list.add(football49)

        val football50 = PetVideo()
        football50.type = VideoType.FOOTBALL.ordinal
        football50.fileName = "football_50"
        football50.code = 2047
        football50.duration = 629
        football50.star = true
        football50.title = "《天下足球》走出半生，归来仍是少年"
        football50.releaseTime = 1559163582
        football50.originalUrl = "https://www.bilibili.com/video/BV1W4411H7UE"
        football50.tags = "足球"
        football50.authorId = 392913805
        football50.cover =
            "https://i0.hdslb.com/bfs/archive/66cbf0615c5b61ed36e0442abbbd88a680245951.jpg"
        football50.hot = false
        football50.vertical = false
        list.add(football50)

        val football51 = PetVideo()
        football51.type = VideoType.FOOTBALL.ordinal
        football51.fileName = "football_51"
        football51.code = 2048
        football51.duration = 724
        football51.star = true
        football51.title = "【天下足球/专题】重回故地,情缘难尽：世界足坛回家故事"
        football51.releaseTime = 1479833195
        football51.originalUrl = "https://www.bilibili.com/video/BV1Ds411W7Ue"
        football51.tags = "足球"
        football51.authorId = 19255217
        football51.cover =
            "https://i0.hdslb.com/bfs/archive/27e1f769e7e307e53496e5f8589843237c0f6dc3.jpg"
        football51.hot = false
        football51.vertical = false
        list.add(football51)

        val football52 = PetVideo()
        football52.type = VideoType.FOOTBALL.ordinal
        football52.fileName = "football_52"
        football52.code = 2049
        football52.duration = 1207
        football52.star = true
        football52.title = "[天下足球] 属于亨利的海布里的国王时代（完整版）"
        football52.releaseTime = 1487160778
        football52.originalUrl = "https://www.bilibili.com/video/BV1zx41127Xz"
        football52.tags = "足球"
        football52.authorId = 7731922
        football52.cover =
            "https://i1.hdslb.com/bfs/archive/29fc35ec0fd710fea6aa21f48e6c60bdda8d4754.jpg"
        football52.hot = false
        football52.vertical = false
        list.add(football52)

//        val football53 = PetVideo()
//        football53.type = VideoType.FOOTBALL.ordinal
//        football53.fileName = "football_53"
//        football53.code = 2050
//        football53.duration = 1497
//        football53.star = true
//        football53.title = "“天下足球”好听到爆的神级BGM，不愧是高品质的“音乐栏目”！"
//        football53.releaseTime = 1625662192
//        football53.originalUrl = "https://www.bilibili.com/video/BV1qU4y137N9"
//        football53.tags = "足球"
//        football53.authorId = 78110942
//        football53.cover =
//            "https://i0.hdslb.com/bfs/archive/e34e47d8547200291655796e2a55004f4dd5db3c.jpg"
//        football53.hot = false
//        football53.vertical = false
//        list.add(football53)

        val football54 = PetVideo()
        football54.type = VideoType.FOOTBALL.ordinal
        football54.fileName = "football_54"
        football54.code = 2051
        football54.duration = 205
        football54.star = true
        football54.title = "央视的解说个个都是诗人，一张口就是满分作文！"
        football54.releaseTime = 1628312456
        football54.originalUrl = "https://www.bilibili.com/video/BV18P4y1x79D"
        football54.tags = "足球"
        football54.authorId = 626297715
        football54.cover =
            "https://i1.hdslb.com/bfs/archive/c0a2d6154e7766ddb01255d4f8bb21ffd7bfb2fe.jpg"
        football54.hot = false
        football54.vertical = false
        list.add(football54)


        return list
    }
}