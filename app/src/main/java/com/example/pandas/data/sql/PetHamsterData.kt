package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object PetHamsterData {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getHamsterData()
        return list
    }

    private fun getHamsterData(): MutableList<PetVideo> {

        val hamster1 = PetVideo()
        hamster1.type = VideoType.HAMSTER.ordinal
        hamster1.fileName = "hamster_1"
        hamster1.code = 3622
        hamster1.duration = 20
        hamster1.star = true
        hamster1.vertical = false
        hamster1.title = "仓鼠洗澡"
        hamster1.releaseTime = 1650861409
        hamster1.originalUrl = "https://www.bilibili.com/video/BV1va411Y77w"
        hamster1.tags = "仓鼠"
        hamster1.authorId = 404136674
        hamster1.cover =
            "https://i2.hdslb.com/bfs/archive/a8d3c2a940d19308df4fad3fa10e54c6911f65e8.jpg"
        list.add(hamster1)

        val hamster2 = PetVideo()
        hamster2.type = VideoType.HAMSTER.ordinal
        hamster2.fileName = "hamster_2"
        hamster2.code = 3623
        hamster2.duration = 15
        hamster2.star = true
        hamster2.vertical = true
        hamster2.title = "李元芳！！ 这颜值像不像化了妆！  我们是花枝鼠小朋友！"
        hamster2.releaseTime = 1652451860
        hamster2.originalUrl = "https://www.bilibili.com/video/BV1YY4y1z7KQ"
        hamster2.tags = "仓鼠"
        hamster2.authorId = 1517279762
        hamster2.cover =
            "https://i0.hdslb.com/bfs/archive/bb095b0dd00d0102ef1b5afc7453c66fcc44f594.jpg"
        list.add(hamster2)

        val hamster3 = PetVideo()
        hamster3.type = VideoType.HAMSTER.ordinal
        hamster3.fileName = "hamster_3"
        hamster3.code = 3624
        hamster3.duration = 31
        hamster3.star = true
        hamster3.vertical = true
        hamster3.title = "爱你～～"
        hamster3.releaseTime = 1656472741
        hamster3.originalUrl = "https://www.bilibili.com/video/BV1eW4y1z7UC"
        hamster3.tags = "仓鼠"
        hamster3.authorId = 1517279762
        hamster3.cover =
            "https://i2.hdslb.com/bfs/archive/1d492654f3a00029d6f0e6108583f8d5b95fd83b.jpg"
        list.add(hamster3)

        val hamster4 = PetVideo()
        hamster4.type = VideoType.HAMSTER.ordinal
        hamster4.fileName = "hamster_4"
        hamster4.code = 3625
        hamster4.duration = 21
        hamster4.star = true
        hamster4.vertical = false
        hamster4.title = "谁家的小老鼠这么可爱呀？"
        hamster4.releaseTime = 1661653258
        hamster4.originalUrl = "https://www.bilibili.com/video/BV1Za41197zt"
        hamster4.tags = "仓鼠"
        hamster4.authorId = 394839021
        hamster4.cover =
            "https://i1.hdslb.com/bfs/archive/bacb1b4b4eb5dbec47d6e24829a99497a360f410.jpg"
        list.add(hamster4)

        val hamster5 = PetVideo()
        hamster5.type = VideoType.HAMSTER.ordinal
        hamster5.fileName = "hamster_5"
        hamster5.code = 3626
        hamster5.duration = 120
        hamster5.star = true
        hamster5.vertical = true
        hamster5.title = "成功，源自不断的训练！！！"
        hamster5.releaseTime = 1661727600
        hamster5.originalUrl = "https://www.bilibili.com/video/BV1ZP4y1Z76W"
        hamster5.tags = "仓鼠"
        hamster5.authorId = 99262037
        hamster5.cover =
            "https://i1.hdslb.com/bfs/archive/80904ee97764f7b364e1aa00efe19f9c5754de04.jpg"
        list.add(hamster5)

        val hamster6 = PetVideo()
        hamster6.type = VideoType.HAMSTER.ordinal
        hamster6.fileName = "hamster_6"
        hamster6.code = 3627
        hamster6.duration = 66
        hamster6.star = true
        hamster6.vertical = false
        hamster6.title = "我也不想心动啊，可是它对我笑诶"
        hamster6.releaseTime = 1645868019
        hamster6.originalUrl = "https://www.bilibili.com/video/BV12Z4y1k7rR"
        hamster6.tags = "仓鼠"
        hamster6.authorId = 66008990
        hamster6.cover =
            "https://i0.hdslb.com/bfs/archive/959283c4dbe7691f0dfc454206e90d1c0fd3a3df.jpg"
        list.add(hamster6)

        val hamster7 = PetVideo()
        hamster7.type = VideoType.HAMSTER.ordinal
        hamster7.fileName = "hamster_7"
        hamster7.code = 3628
        hamster7.duration = 101
        hamster7.star = true
        hamster7.vertical = false
        hamster7.title = "放假七天烦死了，赶紧上班去吧你"
        hamster7.releaseTime = 1633473038
        hamster7.originalUrl = "https://www.bilibili.com/video/BV13v411g7N2"
        hamster7.tags = "仓鼠"
        hamster7.authorId = 66008990
        hamster7.cover =
            "https://i1.hdslb.com/bfs/archive/ef663e164065f27a1d5e1fcc29fe109e74424d74.jpg"
        list.add(hamster7)

        val hamster8 = PetVideo()
        hamster8.type = VideoType.HAMSTER.ordinal
        hamster8.fileName = "hamster_8"
        hamster8.code = 3629
        hamster8.duration = 52
        hamster8.star = true
        hamster8.vertical = false
        hamster8.title = "乖巧.jpg"
        hamster8.releaseTime = 1638328165
        hamster8.originalUrl = "https://www.bilibili.com/video/BV1yM4y1w7kp"
        hamster8.tags = "仓鼠"
        hamster8.authorId = 66008990
        hamster8.cover =
            "https://i0.hdslb.com/bfs/archive/100d55668b8e5d069ee3adb8616855a6a5739cb6.jpg"
        list.add(hamster8)

        val hamster9 = PetVideo()
        hamster9.type = VideoType.HAMSTER.ordinal
        hamster9.fileName = "hamster_9"
        hamster9.code = 3630
        hamster9.duration = 16
        hamster9.star = true
        hamster9.vertical = false
        hamster9.title = "熊突猛进给你个亲亲"
        hamster9.releaseTime = 1648373156
        hamster9.originalUrl = "https://www.bilibili.com/video/BV1NL4y1E7N7"
        hamster9.tags = "仓鼠"
        hamster9.authorId = 66008990
        hamster9.cover =
            "https://i2.hdslb.com/bfs/archive/77d4957a9c373e4844db6fcf4bfc58a3a2931026.jpg"
        list.add(hamster9)

        val hamster10 = PetVideo()
        hamster10.type = VideoType.HAMSTER.ordinal
        hamster10.fileName = "hamster_10"
        hamster10.code = 3631
        hamster10.duration = 132
        hamster10.star = true
        hamster10.vertical = false
        hamster10.title = "Untitled"
        hamster10.releaseTime = 1649924923
        hamster10.originalUrl = "https://www.bilibili.com/video/BV12S4y1Y7pZ"
        hamster10.tags = "仓鼠"
        hamster10.authorId = 66008990
        hamster10.cover =
            "https://i1.hdslb.com/bfs/archive/8d72ecd2a5366a198f6a72ad18e1381c29b88ead.jpg"
        list.add(hamster10)

        val hamster11 = PetVideo()
        hamster11.type = VideoType.HAMSTER.ordinal
        hamster11.fileName = "hamster_11"
        hamster11.code = 3632
        hamster11.duration = 51
        hamster11.star = true
        hamster11.vertical = false
        hamster11.title = "就算你变成小仓猪也没有关系"
        hamster11.releaseTime = 1661489383
        hamster11.originalUrl = "https://www.bilibili.com/video/BV1rV4y1W7yS"
        hamster11.tags = "仓鼠"
        hamster11.authorId = 66008990
        hamster11.cover =
            "https://i0.hdslb.com/bfs/archive/cdea960e67736ac6d1c4f37f17af082d7bd9eba8.jpg"
        list.add(hamster11)

        val hamster12 = PetVideo()
        hamster12.type = VideoType.HAMSTER.ordinal
        hamster12.fileName = "hamster_12"
        hamster12.code = 3633
        hamster12.duration = 108
        hamster12.star = true
        hamster12.vertical = false
        hamster12.title = "么么么一口一个小仓许！"
        hamster12.releaseTime = 1662634540
        hamster12.originalUrl = "https://www.bilibili.com/video/BV13G4y1r7cZ"
        hamster12.tags = "仓鼠"
        hamster12.authorId = 66008990
        hamster12.cover =
            "https://i1.hdslb.com/bfs/archive/bc758278aaf980c2bbff51e55de1677df5ede336.jpg"
        list.add(hamster12)

        val hamster13 = PetVideo()
        hamster13.type = VideoType.HAMSTER.ordinal
        hamster13.fileName = "hamster_13"
        hamster13.code = 3634
        hamster13.duration = 14
        hamster13.star = true
        hamster13.vertical = false
        hamster13.title = "你是在打嗝吗？"
        hamster13.releaseTime = 1662461981
        hamster13.originalUrl = "https://www.bilibili.com/video/BV15K411f7LR"
        hamster13.tags = "仓鼠"
        hamster13.authorId = 66008990
        hamster13.cover =
            "https://i0.hdslb.com/bfs/archive/77bced3a2bff590d38ea064cabf74cb9f23274a8.jpg"
        list.add(hamster13)

        val hamster14 = PetVideo()
        hamster14.type = VideoType.HAMSTER.ordinal
        hamster14.fileName = "hamster_14"
        hamster14.code = 3635
        hamster14.duration = 84
        hamster14.star = true
        hamster14.vertical = false
        hamster14.title = "香香脆脆的滋味︱仓鼠︱金丝熊"
        hamster14.releaseTime = 1610850489
        hamster14.originalUrl = "https://www.bilibili.com/video/BV1Ey4y1m7UA"
        hamster14.tags = "仓鼠"
        hamster14.authorId = 29485584
        hamster14.cover =
            "https://i1.hdslb.com/bfs/archive/d440e62438ec89ca82a906d061c157a780d2e99f.jpg"
        list.add(hamster14)

        val hamster15 = PetVideo()
        hamster15.type = VideoType.HAMSTER.ordinal
        hamster15.fileName = "hamster_15"
        hamster15.code = 3636
        hamster15.duration = 97
        hamster15.star = true
        hamster15.vertical = true
        hamster15.title = "鼠鼠们有大西瓜吃喽！嘿嘿吃瓜皮"
        hamster15.releaseTime = 1660621243
        hamster15.originalUrl = "https://www.bilibili.com/video/BV1yV4y1s7zd"
        hamster15.tags = "仓鼠"
        hamster15.authorId = 38561366
        hamster15.cover =
            "https://i0.hdslb.com/bfs/archive/fc04767bf8184eb005ab8fb04741a337512c09f7.jpg"
        list.add(hamster15)

        val hamster16 = PetVideo()
        hamster16.type = VideoType.HAMSTER.ordinal
        hamster16.fileName = "hamster_16"
        hamster16.code = 3637
        hamster16.duration = 88
        hamster16.star = true
        hamster16.vertical = true
        hamster16.title = "小饼干成功生下小宝宝！呦吼数数这是多少只啊！"
        hamster16.releaseTime = 1661165701
        hamster16.originalUrl = "https://www.bilibili.com/video/BV1BY4y1F7aj"
        hamster16.tags = "仓鼠"
        hamster16.authorId = 38561366
        hamster16.cover =
            "https://i2.hdslb.com/bfs/archive/8ad087d5fab4e814f16abf0ef38b4891bcb4d966.jpg"
        list.add(hamster16)

        val hamster17 = PetVideo()
        hamster17.type = VideoType.HAMSTER.ordinal
        hamster17.fileName = "hamster_17"
        hamster17.code = 3638
        hamster17.duration = 101
        hamster17.star = true
        hamster17.vertical = false
        hamster17.title = "【你们帮我看看饼干像不像有宝宝呀！！】"
        hamster17.releaseTime = 1661136152
        hamster17.originalUrl = "https://www.bilibili.com/video/BV1hY4y1F7Gn"
        hamster17.tags = "仓鼠"
        hamster17.authorId = 38561366
        hamster17.cover =
            "https://i1.hdslb.com/bfs/archive/2adf6165c8cad4b651e80e650756610929324076.jpg"
        list.add(hamster17)

        val hamster18 = PetVideo()
        hamster18.type = VideoType.HAMSTER.ordinal
        hamster18.fileName = "hamster_18"
        hamster18.code = 3639
        hamster18.duration = 103
        hamster18.star = true
        hamster18.vertical = true
        hamster18.title = "家里来了一个小客人"
        hamster18.releaseTime = 1659603166
        hamster18.originalUrl = "https://www.bilibili.com/video/BV1Dt4y137NL"
        hamster18.tags = "仓鼠"
        hamster18.authorId = 38561366
        hamster18.cover =
            "https://i1.hdslb.com/bfs/archive/d3ccb4a4806fc9258872a2af573d1f0b4eafe038.jpg"
        list.add(hamster18)

        val hamster19 = PetVideo()
        hamster19.type = VideoType.HAMSTER.ordinal
        hamster19.fileName = "hamster_19"
        hamster19.code = 3640
        hamster19.duration = 81
        hamster19.star = true
        hamster19.vertical = true
        hamster19.title = "新成员到家啦！给它们起个一对的名字呗～"
        hamster19.releaseTime = 1659329780
        hamster19.originalUrl = "https://www.bilibili.com/video/BV1PB4y1r7En"
        hamster19.tags = "仓鼠"
        hamster19.authorId = 38561366
        hamster19.cover =
            "https://i1.hdslb.com/bfs/archive/9d44fe503d4619a64a59edbee6cace5244000c3c.jpg"
        list.add(hamster19)

        val hamster20 = PetVideo()
        hamster20.type = VideoType.HAMSTER.ordinal
        hamster20.fileName = "hamster_20"
        hamster20.code = 3641
        hamster20.duration = 173
        hamster20.star = true
        hamster20.vertical = false
        hamster20.title = "【今天给小豆丁布置笼子！对它来说是个别墅吧！】"
        hamster20.releaseTime = 1661481990
        hamster20.originalUrl = "https://www.bilibili.com/video/BV1cP411L7t7"
        hamster20.tags = "仓鼠"
        hamster20.authorId = 38561366
        hamster20.cover =
            "https://i2.hdslb.com/bfs/archive/82ba1a518e6c01a4c51ef241cad4d92cc008c228.jpg"
        list.add(hamster20)

        val hamster21 = PetVideo()
        hamster21.type = VideoType.HAMSTER.ordinal
        hamster21.fileName = "hamster_21"
        hamster21.code = 3642
        hamster21.duration = 18
        hamster21.star = true
        hamster21.vertical = false
        hamster21.title = "熊熊：我可以，我能行"
        hamster21.releaseTime = 1568168374
        hamster21.originalUrl = "https://www.bilibili.com/video/BV14J411K7mp"
        hamster21.tags = "仓鼠"
        hamster21.authorId = 165511
        hamster21.cover =
            "https://i0.hdslb.com/bfs/archive/4b96ccf27bdb556f652f15292928a2eb3c26e494.jpg"
        list.add(hamster21)

        val hamster22 = PetVideo()
        hamster22.type = VideoType.HAMSTER.ordinal
        hamster22.fileName = "hamster_22"
        hamster22.code = 3643
        hamster22.duration = 60
        hamster22.star = true
        hamster22.vertical = true
        hamster22.title = "【蛋包饭】莫挨老子！小仓鼠怒吼（？）最后惨遭绑架双jio离地"
        hamster22.releaseTime = 1563023158
        hamster22.originalUrl = "https://www.bilibili.com/video/BV18x41197mt"
        hamster22.tags = "仓鼠"
        hamster22.authorId = 423803582
        hamster22.cover =
            "https://i2.hdslb.com/bfs/archive/2bbf14dda67f4b0f4e1d0f489963839297dcc7af.jpg"
        list.add(hamster22)

        val hamster23 = PetVideo()
        hamster23.type = VideoType.HAMSTER.ordinal
        hamster23.fileName = "hamster_23"
        hamster23.code = 3644
        hamster23.duration = 21
        hamster23.star = true
        hamster23.vertical = false
        hamster23.title = "鼠鼠：麻麻我想要5颗花生米～"
        hamster23.releaseTime = 1651932306
        hamster23.originalUrl = "https://www.bilibili.com/video/BV1Q3411P758"
        hamster23.tags = "仓鼠"
        hamster23.authorId = 650907138
        hamster23.cover =
            "https://i1.hdslb.com/bfs/archive/9c4424fcc1713352f22b9497730eb89600ea9a52.jpg"
        list.add(hamster23)

        val hamster24 = PetVideo()
        hamster24.type = VideoType.HAMSTER.ordinal
        hamster24.fileName = "hamster_24"
        hamster24.code = 3645
        hamster24.duration = 27
        hamster24.star = true
        hamster24.vertical = false
        hamster24.title = "鼠鼠我啊 可是细嚼慢咽呢"
        hamster24.releaseTime = 1660311756
        hamster24.originalUrl = "https://www.bilibili.com/video/BV1qB4y157mB"
        hamster24.tags = "仓鼠"
        hamster24.authorId = 46025965
        hamster24.cover =
            "https://i0.hdslb.com/bfs/archive/9463fbf68398621ef2c0e668125952539cbd337a.jpg"
        list.add(hamster24)


        return list
    }
}