package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetBabyPandaData2 {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {
        val panda383 = PetVideo()
        panda383.type = VideoType.PANDA.ordinal
        panda383.fileName = "panda_baby_panda383"
        panda383.code = 1575
        panda383.duration = 107
        panda383.period = PeriodType.BABY.ordinal
        panda383.isStar = false
        panda383.title = "可爱的熊猫用“滚”，来吸引保姆的注意(爽爽！)"
        panda383.releaseTime = "2020-11-26 18:20:28"
        panda383.originalUrl = "https://www.bilibili.com/video/BV1Qi4y1V7sU"
        panda383.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda383.authorId = 43296249
        panda383.cover =
            "https://i2.hdslb.com/bfs/archive/8324321680c68b9f51d46f9a63b6591e5ec7ddb1.png"
        list.add(panda383)

        val panda384 = PetVideo()
        panda384.type = VideoType.PANDA.ordinal
        panda384.fileName = "panda_baby_panda384"
        panda384.code = 1576
        panda384.duration = 94
        panda384.period = PeriodType.BABY.ordinal
        panda384.isStar = true
        panda384.title = "大熊猫福多多VS.雅颂打架第二回合，猜猜谁赢了？"
        panda384.releaseTime = "2022-03-02 23:02:51"
        panda384.originalUrl = "https://www.bilibili.com/video/BV1cF411b7br"
        panda384.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda384.authorId = 319900681
        panda384.cover =
            "https://i0.hdslb.com/bfs/archive/23173dcc39e848ef3db70be4ea01684f3930179a.jpg"
        list.add(panda384)

        val panda385 = PetVideo()
        panda385.type = VideoType.PANDA.ordinal
        panda385.fileName = "panda_baby_panda385"
        panda385.code = 1577
        panda385.duration = 209
        panda385.period = PeriodType.BABY.ordinal
        panda385.isStar = true
        panda385.title = "整理所有“大熊猫和花”的超可爱模样，收藏版"
        panda385.releaseTime = "2022-03-06 18:05:02"
        panda385.originalUrl = "https://www.bilibili.com/video/BV1yZ4y167nq"
        panda385.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda385.authorId = 21330840
        panda385.cover =
            "https://i1.hdslb.com/bfs/archive/e58750e65d6d5db007946e850b7be4c230d02270.jpg"
        list.add(panda385)

        val panda386 = PetVideo()
        panda386.type = VideoType.PANDA.ordinal
        panda386.fileName = "panda_baby_panda386"
        panda386.code = 1578
        panda386.duration = 9
        panda386.period = PeriodType.BABY.ordinal
        panda386.isStar = false
        panda386.title = "山竹：谁？谁在说我坏话？"
        panda386.releaseTime = "2022-02-27 01:44:32"
        panda386.originalUrl = "https://www.bilibili.com/video/BV1pF411t74Q"
        panda386.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda386.authorId = 2037312510
        panda386.cover =
            "https://i1.hdslb.com/bfs/archive/cb64b1294ace922b9627a1dd7685895f0bd2435a.jpg"
        list.add(panda386)

        val panda387 = PetVideo()
        panda387.type = VideoType.PANDA.ordinal
        panda387.fileName = "panda_baby_panda387"
        panda387.code = 1579
        panda387.duration = 16
        panda387.period = PeriodType.BABY.ordinal
        panda387.isStar = false
        panda387.title = "从小开始挖煤，奶妈看了都无语"
        panda387.releaseTime = "2022-03-04 12:37:39"
        panda387.originalUrl = "https://www.bilibili.com/video/BV1W34y1k7zR"
        panda387.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda387.authorId = 1025949925
        panda387.cover =
            "https://i0.hdslb.com/bfs/archive/a702c6ceaeea022e520fa95920bbaee187eb3662.jpg"
        list.add(panda387)

        val panda388 = PetVideo()
        panda388.type = VideoType.PANDA.ordinal
        panda388.fileName = "panda_baby_panda388"
        panda388.code = 1580
        panda388.duration = 69
        panda388.period = PeriodType.BABY.ordinal
        panda388.isStar = false
        panda388.title = "【大熊猫福多多】盯了半天研究，福多多这睡姿，这平衡性真好！"
        panda388.releaseTime = "2022-03-06 00:52:22"
        panda388.originalUrl = "https://www.bilibili.com/video/BV1Hu411Q7yu"
        panda388.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda388.authorId = 627116323
        panda388.cover =
            "https://i0.hdslb.com/bfs/archive/f2103d621c2cb8cfa894bebbe022593e6a008395.jpg"
        list.add(panda388)

        val panda389 = PetVideo()
        panda389.type = VideoType.PANDA.ordinal
        panda389.fileName = "panda_baby_panda389"
        panda389.code = 1581
        panda389.duration = 65
        panda389.period = PeriodType.BABY.ordinal
        panda389.isStar = false
        panda389.title = "惊蛰至，熊宝陪你不负春光"
        panda389.releaseTime = "2022-03-05 17:35:18"
        panda389.originalUrl = "https://www.bilibili.com/video/BV1r44y1M7w1"
        panda389.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda389.authorId = 1998535
        panda389.cover =
            "https://i1.hdslb.com/bfs/archive/d4e295b426066d59df4a1fbdb43263edbc7e6fec.jpg"
        list.add(panda389)

        val panda390 = PetVideo()
        panda390.type = VideoType.PANDA.ordinal
        panda390.fileName = "panda_baby_panda390"
        panda390.code = 1582
        panda390.duration = 31
        panda390.period = PeriodType.BABY.ordinal
        panda390.isStar = true
        panda390.title = "和花的颜值真是高"
        panda390.releaseTime = "2022-03-03 19:20:09"
        panda390.originalUrl = "https://www.bilibili.com/video/BV1RP4y1F7cN"
        panda390.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda390.authorId = 479589264
        panda390.cover =
            "https://i0.hdslb.com/bfs/archive/81de4b37d8aa05f73b5843e12fa3d893b43b21dd.jpg"
        list.add(panda390)

        val panda391 = PetVideo()
        panda391.type = VideoType.PANDA.ordinal
        panda391.fileName = "panda_baby_panda391"
        panda391.code = 1583
        panda391.duration = 62
        panda391.period = PeriodType.BABY.ordinal
        panda391.isStar = false
        panda391.title = "梅兰啃树叶玩，小方爬树来抢镜，没想到后面小石灰更抢镜"
        panda391.releaseTime = "2016-12-19 20:49:41"
        panda391.originalUrl = "https://www.bilibili.com/video/BV1Gs411a7fH"
        panda391.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda391.authorId = 4038416
        panda391.cover =
            "https://i2.hdslb.com/bfs/archive/d0c9ab1e504335017381f7f1d36c165a157d90b9.jpg"
        list.add(panda391)

        val panda392 = PetVideo()
        panda392.type = VideoType.PANDA.ordinal
        panda392.fileName = "panda_baby_panda392"
        panda392.code = 1584
        panda392.duration = 36
        panda392.period = PeriodType.BABY.ordinal
        panda392.isStar = true
        panda392.title = "自娱自乐的小和花"
        panda392.releaseTime = "2022-03-03 19:31:46"
        panda392.originalUrl = "https://www.bilibili.com/video/BV1SZ4y167Wi"
        panda392.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda392.authorId = 1307515
        panda392.cover =
            "https://i1.hdslb.com/bfs/archive/0fe59e9a1faa17b04af3a26d845b2d8bc557cb71.jpg"
        list.add(panda392)

        val panda393 = PetVideo()
        panda393.type = VideoType.PANDA.ordinal
        panda393.fileName = "panda_baby_panda393"
        panda393.code = 1585
        panda393.duration = 84
        panda393.period = PeriodType.BABY.ordinal
        panda393.isStar = true
        panda393.title = "【大熊猫兜兜】行动速度较慢，容易被打包带走"
        panda393.releaseTime = "2021-03-06 21:35:16"
        panda393.originalUrl = "https://www.bilibili.com/video/BV1Gr4y1P76G"
        panda393.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda393.authorId = 209554532
        panda393.cover =
            "https://i1.hdslb.com/bfs/archive/1917c4bf9682dfe6f779881d857d213eee6a2ce4.jpg"
        list.add(panda393)

        val panda394 = PetVideo()
        panda394.type = VideoType.PANDA.ordinal
        panda394.fileName = "panda_baby_panda394"
        panda394.code = 1586
        panda394.duration = 66
        panda394.period = PeriodType.BABY.ordinal
        panda394.isStar = false
        panda394.title = "【麒麟甜可】奶爸们接俩兄妹回家"
        panda394.releaseTime = "2020-10-08 21:27:02"
        panda394.originalUrl = "https://www.bilibili.com/video/BV1uy4y1C7bH"
        panda394.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda394.authorId = 19715714
        panda394.cover =
            "https://i2.hdslb.com/bfs/archive/47e1b080f76bd7d02b7a578f47f43f35984be7cb.jpg"
        list.add(panda394)

        val panda395 = PetVideo()
        panda395.type = VideoType.PANDA.ordinal
        panda395.fileName = "panda_baby_panda395"
        panda395.code = 1587
        panda395.duration = 65
        panda395.period = PeriodType.BABY.ordinal
        panda395.isStar = false
        panda395.title = "【重庆动物园】星猪儿辰猪儿喝瓶瓶奶，星猪儿还想抢辰猪儿的"
        panda395.releaseTime = "2022-02-27 17:23:37"
        panda395.originalUrl = "https://www.bilibili.com/video/BV1X44y1n7zD"
        panda395.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda395.authorId = 66688464
        panda395.cover =
            "https://i1.hdslb.com/bfs/archive/0760aaa445f077965ec8d716ade148cda6f617fe.jpg"
        list.add(panda395)

        val panda396 = PetVideo()
        panda396.type = VideoType.PANDA.ordinal
        panda396.fileName = "panda_baby_panda396"
        panda396.code = 1588
        panda396.duration = 193
        panda396.period = PeriodType.BABY.ordinal
        panda396.isStar = true
        panda396.title = "点开这个视频，你将看到这个世界上最可爱的动物！"
        panda396.releaseTime = "2022-03-02 20:52:18"
        panda396.originalUrl = "https://www.bilibili.com/video/BV1f3411V7LY"
        panda396.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda396.authorId = 37053244
        panda396.cover =
            "https://i0.hdslb.com/bfs/archive/bffc4d736d0340ea7d4850d93753953a9da51cfb.jpg"
        list.add(panda396)

        val panda397 = PetVideo()
        panda397.type = VideoType.PANDA.ordinal
        panda397.fileName = "panda_baby_panda397"
        panda397.code = 1589
        panda397.duration = 73
        panda397.period = PeriodType.BABY.ordinal
        panda397.isStar = false
        panda397.title = "【大熊猫福多多雅颂】福多多：要不是血脉封印压制，我一个打八个。雅颂：我不信，我要上武器！"
        panda397.releaseTime = "2022-03-02 20:53:21"
        panda397.originalUrl = "https://www.bilibili.com/video/BV1UP4y1c7gU"
        panda397.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda397.authorId = 627116323
        panda397.cover =
            "https://i2.hdslb.com/bfs/archive/1887d17a7628c64e90710e010e8512bd9eecb71b.jpg"
        list.add(panda397)

        val panda398 = PetVideo()
        panda398.type = VideoType.PANDA.ordinal
        panda398.fileName = "panda_baby_panda398"
        panda398.code = 1590
        panda398.duration = 107
        panda398.period = PeriodType.BABY.ordinal
        panda398.isStar = false
        panda398.title = "福多多和雅颂在月亮幼儿园的生活"
        panda398.releaseTime = "2022-03-02 19:24:38"
        panda398.originalUrl = "https://www.bilibili.com/video/BV1p341157eV"
        panda398.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda398.authorId = 4120384
        panda398.cover =
            "https://i2.hdslb.com/bfs/archive/a2d4da8840be81dc8b3a0177ffe9008dded193fd.jpg"
        list.add(panda398)

        val panda399 = PetVideo()
        panda399.type = VideoType.PANDA.ordinal
        panda399.fileName = "panda_baby_panda399"
        panda399.code = 1591
        panda399.duration = 60
        panda399.period = PeriodType.BABY.ordinal
        panda399.isStar = true
        panda399.title = "大熊猫茅茅：这又是一个神烦的室友~由水秀麻麻出品"
        panda399.releaseTime = "2022-02-16 23:00:17"
        panda399.originalUrl = "https://www.bilibili.com/video/BV12T4y1X741"
        panda399.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda399.authorId = 98871951
        panda399.cover =
            "https://i2.hdslb.com/bfs/archive/5deed2934255439fabfb31e327fc4ab4a4de4ba9.jpg"
        list.add(panda399)

        val panda400 = PetVideo()
        panda400.type = VideoType.PANDA.ordinal
        panda400.fileName = "panda_baby_panda400"
        panda400.code = 1592
        panda400.duration = 73
        panda400.period = PeriodType.BABY.ordinal
        panda400.isStar = false
        panda400.title = "只因拒绝了一个请求，被熊猫追了五里地！！！"
        panda400.releaseTime = "2022-03-01 13:12:44"
        panda400.originalUrl = "https://www.bilibili.com/video/BV1vu411D7n3"
        panda400.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda400.authorId = 12444306
        panda400.cover =
            "https://i2.hdslb.com/bfs/archive/f362d86bfd77b2d9a18c8b7202c441b997950870.jpg"
        list.add(panda400)

        val panda401 = PetVideo()
        panda401.type = VideoType.PANDA.ordinal
        panda401.fileName = "panda_baby_panda401"
        panda401.code = 1593
        panda401.duration = 163
        panda401.period = PeriodType.BABY.ordinal
        panda401.isStar = false
        panda401.title = "20210912 在月亮内场乖乖的花宝宝 还宠粉 哈哈"
        panda401.releaseTime = "2021-09-22 03:24:22"
        panda401.originalUrl = "https://www.bilibili.com/video/BV1Uh411n7FG"
        panda401.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda401.authorId = 264648535
        panda401.cover =
            "https://i1.hdslb.com/bfs/archive/1f562ef948f63649e7c58fc0d29b4d41b3cb2f51.jpg"
        list.add(panda401)

        val panda402 = PetVideo()
        panda402.type = VideoType.PANDA.ordinal
        panda402.fileName = "panda_baby_panda402"
        panda402.code = 1594
        panda402.duration = 1151
        panda402.period = PeriodType.BABY.ordinal
        panda402.isStar = true
        panda402.title = "2021年9月，14个月大的 花花在月亮产房玻璃房独自一熊营业，手机拍了20分钟都不想停下来，太可爱啦小花宝宝～ 能看完的留言 哈哈"
        panda402.releaseTime = "2022-03-01 03:18:25"
        panda402.originalUrl = "https://www.bilibili.com/video/BV1EL4y137yG"
        panda402.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda402.authorId = 264648535
        panda402.cover =
            "https://i2.hdslb.com/bfs/archive/e26beb48394b29d74a130435cc2893ee8cc38f16.jpg"
        list.add(panda402)

        val panda403 = PetVideo()
        panda403.type = VideoType.PANDA.ordinal
        panda403.fileName = "panda_baby_panda403"
        panda403.code = 1595
        panda403.duration = 98
        panda403.period = PeriodType.BABY.ordinal
        panda403.isStar = false
        panda403.title = "【大熊猫金玉】傻鱼儿泡澡澡，舒服到眯眼！"
        panda403.releaseTime = "2022-03-01 00:56:34"
        panda403.originalUrl = "https://www.bilibili.com/video/BV1VZ4y1C7sf"
        panda403.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda403.authorId = 29006209
        panda403.cover =
            "https://i1.hdslb.com/bfs/archive/950c2fc88149479567cb9fbc0ee5409996111442.jpg"
        list.add(panda403)

        val panda404 = PetVideo()
        panda404.type = VideoType.PANDA.ordinal
        panda404.fileName = "panda_baby_panda404"
        panda404.code = 1596
        panda404.duration = 76
        panda404.period = PeriodType.BABY.ordinal
        panda404.isStar = false
        panda404.title = "绩笑小灰灰时期，睡觉也不忘卖萌圈粉"
        panda404.releaseTime = "2021-03-14 09:37:45"
        panda404.originalUrl = "https://www.bilibili.com/video/BV1Ri4y1N7DM"
        panda404.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda404.authorId = 19715714
        panda404.cover =
            "https://i0.hdslb.com/bfs/archive/6eaa2d7ce5ef4c06043a84429b75fbb0ad3bdc3a.jpg"
        list.add(panda404)

        val panda405 = PetVideo()
        panda405.type = VideoType.PANDA.ordinal
        panda405.fileName = "panda_baby_panda405"
        panda405.code = 1597
        panda405.duration = 103
        panda405.period = PeriodType.BABY.ordinal
        panda405.isStar = false
        panda405.title = "【大熊猫爱莲】幼儿园最小的宝宝！不到半岁"
        panda405.releaseTime = "2020-04-14 11:10:12"
        panda405.originalUrl = "https://www.bilibili.com/video/BV1h54y197yS"
        panda405.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda405.authorId = 4120384
        panda405.cover =
            "https://i1.hdslb.com/bfs/archive/53a5023788c56de3baee333960eae480f96fbe62.jpg"
        list.add(panda405)

        val panda406 = PetVideo()
        panda406.type = VideoType.PANDA.ordinal
        panda406.fileName = "panda_baby_panda406"
        panda406.code = 1598
        panda406.duration = 73
        panda406.period = PeriodType.BABY.ordinal
        panda406.isStar = false
        panda406.title = "林安安：静静的看你们表演"
        panda406.releaseTime = "2020-09-17 17:11:35"
        panda406.originalUrl = "https://www.bilibili.com/video/BV1Mi4y1u7Mr"
        panda406.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda406.authorId = 19715714
        panda406.cover =
            "https://i0.hdslb.com/bfs/archive/32dc3e8266241822f874a3335c8951717bc823a2.jpg"
        list.add(panda406)

        val panda407 = PetVideo()
        panda407.type = VideoType.PANDA.ordinal
        panda407.fileName = "panda_baby_panda407"
        panda407.code = 1599
        panda407.duration = 59
        panda407.period = PeriodType.BABY.ordinal
        panda407.isStar = false
        panda407.title = "【大熊猫福多多】【大熊猫雅颂】福多多与小伙伴在一起的第一天～打打闹闹中我们就长大啦～😊😊😊"
        panda407.releaseTime = "2022-02-26 15:49:30"
        panda407.originalUrl = "https://www.bilibili.com/video/BV1TY411G7ij"
        panda407.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda407.authorId = 1098561796
        panda407.cover =
            "https://i0.hdslb.com/bfs/archive/6a8ad8651d68d8f3eaa4bfc961d2e485bb57c45a.jpg"
        list.add(panda407)

        val panda408 = PetVideo()
        panda408.type = VideoType.PANDA.ordinal
        panda408.fileName = "panda_baby_panda408"
        panda408.code = 1600
        panda408.duration = 55
        panda408.period = PeriodType.BABY.ordinal
        panda408.isStar = false
        panda408.title = "不熟悉发箍奶爸的福多多奶凶奶凶的！看到这样的多多，我们都放心了！【熊猫宝宝福多多】"
        panda408.releaseTime = "2022-02-28 12:52:21"
        panda408.originalUrl = "https://www.bilibili.com/video/BV1UP4y1c7PL"
        panda408.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda408.authorId = 2137796700
        panda408.cover =
            "https://i2.hdslb.com/bfs/archive/bdffc0e2f7097a113df05e690f76cf476a4bee80.jpg"
        list.add(panda408)

        val panda409 = PetVideo()
        panda409.type = VideoType.PANDA.ordinal
        panda409.fileName = "panda_baby_panda409"
        panda409.code = 1601
        panda409.duration = 63
        panda409.period = PeriodType.BABY.ordinal
        panda409.isStar = true
        panda409.title = "大熊猫福多多：多多和它的第一个好朋友颂居居，社交牛b症福多多"
        panda409.releaseTime = "2022-02-28 22:00:06"
        panda409.originalUrl = "https://www.bilibili.com/video/BV1vL4y1g7n6"
        panda409.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda409.authorId = 98871951
        panda409.cover =
            "https://i0.hdslb.com/bfs/archive/82d94a6ed0ab550de23809a83a018ce0f613881b.jpg"
        list.add(panda409)

        val panda410 = PetVideo()
        panda410.type = VideoType.PANDA.ordinal
        panda410.fileName = "panda_baby_panda410"
        panda410.code = 1602
        panda410.duration = 52
        panda410.period = PeriodType.BABY.ordinal
        panda410.isStar = false
        panda410.title = "【莽星星莽辰辰】莽星星：彩虹屁对我没用的，公共场所勿大声喧哗，保持安静，嘘！"
        panda410.releaseTime = "2022-02-28 18:22:46"
        panda410.originalUrl = "https://www.bilibili.com/video/BV1Q44y1T7A8"
        panda410.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda410.authorId = 180602305
        panda410.cover =
            "https://i1.hdslb.com/bfs/archive/314c3e4a026da16454ff18bf37b915f9ff1fffa4.jpg"
        list.add(panda410)

        val panda411 = PetVideo()
        panda411.type = VideoType.PANDA.ordinal
        panda411.fileName = "panda_baby_panda411"
        panda411.code = 1603
        panda411.duration = 10
        panda411.period = PeriodType.BABY.ordinal
        panda411.isStar = false
        panda411.title = "小样儿，竟敢走在大哥前面！"
        panda411.releaseTime = "2022-02-23 18:39:08"
        panda411.originalUrl = "https://www.bilibili.com/video/BV1XP4y1F7br"
        panda411.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda411.authorId = 2037312510
        panda411.cover =
            "https://i0.hdslb.com/bfs/archive/fb77e6707a0a51e06d08d8ca853d14d8a349c044.jpg"
        list.add(panda411)

        val panda412 = PetVideo()
        panda412.type = VideoType.PANDA.ordinal
        panda412.fileName = "panda_baby_panda412"
        panda412.code = 1604
        panda412.duration = 19
        panda412.period = PeriodType.BABY.ordinal
        panda412.isStar = false
        panda412.title = "秦岭大熊猫官宣了，展厅拍到的七仔小时候"
        panda412.releaseTime = "2018-11-21 00:53:27"
        panda412.originalUrl = "https://www.bilibili.com/video/BV1Mt41127v1"
        panda412.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda412.authorId = 231314384
        panda412.cover =
            "https://i2.hdslb.com/bfs/archive/55b48b16a34405beebe764325a1a23371f3d5f58.jpg"
        list.add(panda412)

        val panda413 = PetVideo()
        panda413.type = VideoType.PANDA.ordinal
        panda413.fileName = "panda_baby_panda413"
        panda413.code = 1605
        panda413.duration = 63
        panda413.period = PeriodType.BABY.ordinal
        panda413.isStar = true
        panda413.title = "【大熊猫金宵】草丛里长出了一朵黑白团子！"
        panda413.releaseTime = "2021-12-07 12:11:02"
        panda413.originalUrl = "https://www.bilibili.com/video/BV16g411P7EH"
        panda413.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda413.authorId = 5125945
        panda413.cover =
            "https://i1.hdslb.com/bfs/archive/1337153368fc89e5c92cbc39e870851dea715b9c.jpg"
        list.add(panda413)

        val panda414 = PetVideo()
        panda414.type = VideoType.PANDA.ordinal
        panda414.fileName = "panda_baby_panda414"
        panda414.code = 1606
        panda414.duration = 40
        panda414.period = PeriodType.BABY.ordinal
        panda414.isStar = false
        panda414.title = "【大熊猫金宵】这么可爱的小团子去哪里领"
        panda414.releaseTime = "2021-11-27 22:47:41"
        panda414.originalUrl = "https://www.bilibili.com/video/BV1NU4y1T7sQ"
        panda414.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda414.authorId = 32436782
        panda414.cover =
            "https://i1.hdslb.com/bfs/archive/e232ba4f94ed3cc285705ed4f1856c4262d3bf04.jpg"
        list.add(panda414)

        val panda415 = PetVideo()
        panda415.type = VideoType.PANDA.ordinal
        panda415.fileName = "panda_baby_panda415"
        panda415.code = 1607
        panda415.duration = 142
        panda415.period = PeriodType.BABY.ordinal
        panda415.isStar = true
        panda415.title = "【大熊猫艾玖】看看我的小jiojio，肉嘟嘟的，是不是很可爱~"
        panda415.releaseTime = "2021-07-11 15:06:10"
        panda415.originalUrl = "https://www.bilibili.com/video/BV1HX4y1w7Dv"
        panda415.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda415.authorId = 34677299
        panda415.cover =
            "https://i2.hdslb.com/bfs/archive/53a2fe9a1bcecf88c4c35c3cf6930838a9177d9a.jpg"
        list.add(panda415)

        val panda416 = PetVideo()
        panda416.type = VideoType.PANDA.ordinal
        panda416.fileName = "panda_baby_panda416"
        panda416.code = 1608
        panda416.duration = 162
        panda416.period = PeriodType.BABY.ordinal
        panda416.isStar = false
        panda416.title = "【大熊猫艾玖】这娃眼神滴溜溜的，活泼好动，有当谐星的潜质"
        panda416.releaseTime = "2020-11-30 20:11:27"
        panda416.originalUrl = "https://www.bilibili.com/video/BV1Cv411t7ib"
        panda416.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda416.authorId = 34677299
        panda416.cover =
            "https://i2.hdslb.com/bfs/archive/6390c08d14fadd5a7964acab06eb1977707fbdb2.jpg"
        list.add(panda416)

        val panda417 = PetVideo()
        panda417.type = VideoType.PANDA.ordinal
        panda417.fileName = "panda_baby_panda417"
        panda417.code = 1609
        panda417.duration = 117
        panda417.period = PeriodType.BABY.ordinal
        panda417.isStar = false
        panda417.title = "【大熊猫莽仔幼崽】莽小：让你跟我抢奶爸！"
        panda417.releaseTime = "2021-10-26 21:20:58"
        panda417.originalUrl = "https://www.bilibili.com/video/BV1eP4y1L71G"
        panda417.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda417.authorId = 180602305
        panda417.cover =
            "https://i0.hdslb.com/bfs/archive/a8673f4fdaa9b995e4e44c766a3f80fdbad3d901.jpg"
        list.add(panda417)

        val panda418 = PetVideo()
        panda418.type = VideoType.PANDA.ordinal
        panda418.fileName = "panda_baby_panda418"
        panda418.code = 1610
        panda418.duration = 40
        panda418.period = PeriodType.BABY.ordinal
        panda418.isStar = true
        panda418.title = "熊猫从小就得学习如何优雅的次竹叽"
        panda418.releaseTime = "2018-07-08 21:00:53"
        panda418.originalUrl = "https://www.bilibili.com/video/BV1ns411p7LU"
        panda418.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda418.authorId = 12444306
        panda418.cover =
            "https://i1.hdslb.com/bfs/archive/d62a24f7743bc021b364437e40511ebb4bfb6301.jpg"
        list.add(panda418)

        val panda419 = PetVideo()
        panda419.type = VideoType.PANDA.ordinal
        panda419.fileName = "panda_baby_panda419"
        panda419.code = 1611
        panda419.duration = 37
        panda419.period = PeriodType.BABY.ordinal
        panda419.isStar = false
        panda419.title = "把可爱打在公屏上，我就是最可爱的那一只！"
        panda419.releaseTime = "2020-05-01 13:10:57"
        panda419.originalUrl = "https://www.bilibili.com/video/BV1Z54y197Q8"
        panda419.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda419.authorId = 12444306
        panda419.cover =
            "https://i2.hdslb.com/bfs/archive/cf03079d5c1efd14c5b34883af6a201fcc33a6b1.jpg"
        list.add(panda419)

        val panda420 = PetVideo()
        panda420.type = VideoType.PANDA.ordinal
        panda420.fileName = "panda_baby_panda420"
        panda420.code = 1612
        panda420.duration = 49
        panda420.period = PeriodType.BABY.ordinal
        panda420.isStar = true
        panda420.title = "被大熊猫追是一种怎样的体验"
        panda420.releaseTime = "2018-11-21 21:00:31"
        panda420.originalUrl = "https://www.bilibili.com/video/BV1Pt411274t"
        panda420.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda420.authorId = 12444306
        panda420.cover =
            "https://i2.hdslb.com/bfs/archive/5e3152f86a0ddd9eb0aff0578ae07d7503e5b652.jpg"
        list.add(panda420)

        val panda421 = PetVideo()
        panda421.type = VideoType.PANDA.ordinal
        panda421.fileName = "panda_baby_panda421"
        panda421.code = 1613
        panda421.duration = 44
        panda421.period = PeriodType.BABY.ordinal
        panda421.isStar = false
        panda421.title = "芝麻：我哥疯了！"
        panda421.releaseTime = "2017-12-10 21:10:12"
        panda421.originalUrl = "https://www.bilibili.com/video/BV1hW411Y7dh"
        panda421.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda421.authorId = 12444306
        panda421.cover =
            "https://i0.hdslb.com/bfs/archive/caff4bb38c006c66d6bdd4c978a848a4ca90b77b.jpg"
        list.add(panda421)

        val panda422 = PetVideo()
        panda422.type = VideoType.PANDA.ordinal
        panda422.fileName = "panda_baby_panda422"
        panda422.code = 1614
        panda422.duration = 14
        panda422.period = PeriodType.BABY.ordinal
        panda422.isStar = false
        panda422.title = "星辉没想到你是这样的熊！小小年纪就这么会开火车！"
        panda422.releaseTime = "2016-10-28 18:53:22"
        panda422.originalUrl = "https://www.bilibili.com/video/BV1ks411s7yK"
        panda422.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda422.authorId = 12444306
        panda422.cover =
            "https://i0.hdslb.com/bfs/archive/c87d1694e3298697a0f75ad22b2f6e3484c692d6.png"
        list.add(panda422)

        val panda423 = PetVideo()
        panda423.type = VideoType.PANDA.ordinal
        panda423.fileName = "panda_baby_panda423"
        panda423.code = 1615
        panda423.duration = 169
        panda423.period = PeriodType.BABY.ordinal
        panda423.isStar = false
        panda423.title = "睡觉前最适合看的视频"
        panda423.releaseTime = "2016-10-17 18:00:15"
        panda423.originalUrl = "https://www.bilibili.com/video/BV18s41147Lf"
        panda423.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda423.authorId = 12444306
        panda423.cover =
            "https://i2.hdslb.com/bfs/archive/bf761fbf882e1e2387170e045edaa154757ea73f.jpg"
        list.add(panda423)

        val panda424 = PetVideo()
        panda424.type = VideoType.PANDA.ordinal
        panda424.fileName = "panda_baby_panda424"
        panda424.code = 1616
        panda424.duration = 77
        panda424.period = PeriodType.BABY.ordinal
        panda424.isStar = false
        panda424.title = "熊猫为什么要被叫做滚滚呢？"
        panda424.releaseTime = "2018-10-02 20:00:08"
        panda424.originalUrl = "https://www.bilibili.com/video/BV15W411S7JN"
        panda424.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda424.authorId = 12444306
        panda424.cover =
            "https://i0.hdslb.com/bfs/archive/216a5a1c9b8516f293780c1cb525c3ab9606c52d.jpg"
        list.add(panda424)

        val panda425 = PetVideo()
        panda425.type = VideoType.PANDA.ordinal
        panda425.fileName = "panda_baby_panda425"
        panda425.code = 1617
        panda425.duration = 22
        panda425.period = PeriodType.BABY.ordinal
        panda425.isStar = true
        panda425.title = "这是一只自带慢放技能的国宝～"
        panda425.releaseTime = "2019-06-16 13:30:16"
        panda425.originalUrl = "https://www.bilibili.com/video/BV1W4411V7pR"
        panda425.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda425.authorId = 12444306
        panda425.cover =
            "https://i2.hdslb.com/bfs/archive/c77ee14306d708ee4a232b3cd5c91eaceac06685.jpg"
        list.add(panda425)

        val panda426 = PetVideo()
        panda426.type = VideoType.PANDA.ordinal
        panda426.fileName = "panda_baby_panda426"
        panda426.code = 1618
        panda426.duration = 52
        panda426.period = PeriodType.BABY.ordinal
        panda426.isStar = false
        panda426.title = "哎哟 我的肉肉哎～"
        panda426.releaseTime = "2016-12-14 17:24:45"
        panda426.originalUrl = "https://www.bilibili.com/video/BV1Es411e75n"
        panda426.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda426.authorId = 12444306
        panda426.cover =
            "https://i0.hdslb.com/bfs/archive/7ea1528c6e2139e4fe87b0bdb97276e99fb00461.jpg"
        list.add(panda426)

        val panda427 = PetVideo()
        panda427.type = VideoType.PANDA.ordinal
        panda427.fileName = "panda_baby_panda427"
        panda427.code = 1619
        panda427.duration = 79
        panda427.period = PeriodType.BABY.ordinal
        panda427.isStar = true
        panda427.title = "熊猫：有男朋友吗？亲一个呗！"
        panda427.releaseTime = "2019-07-19 11:10:25"
        panda427.originalUrl = "https://www.bilibili.com/video/BV1ht411g7jQ"
        panda427.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda427.authorId = 37053244
        panda427.cover =
            "https://i1.hdslb.com/bfs/archive/d09e2896d7531d9cd2c19b245008b3247edc3d6f.jpg"
        list.add(panda427)

        val panda428 = PetVideo()
        panda428.type = VideoType.PANDA.ordinal
        panda428.fileName = "panda_baby_panda428"
        panda428.code = 1620
        panda428.duration = 105
        panda428.period = PeriodType.BABY.ordinal
        panda428.isStar = false
        panda428.title = "【小馨】熊团子睡不着，需要奶妈哄一哄才可以！"
        panda428.releaseTime = "2019-08-27 18:00:02"
        panda428.originalUrl = "https://www.bilibili.com/video/BV1h4411B7N2"
        panda428.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda428.authorId = 12444306
        panda428.cover =
            "https://i0.hdslb.com/bfs/archive/d2478efb54f9c62a27c98381d6fe53e41458151e.jpg"
        list.add(panda428)

        val panda429 = PetVideo()
        panda429.type = VideoType.PANDA.ordinal
        panda429.fileName = "panda_baby_panda429"
        panda429.code = 1621
        panda429.duration = 44
        panda429.period = PeriodType.BABY.ordinal
        panda429.isStar = false
        panda429.title = "妈妈不让我跟掉色的熊猫玩儿！"
        panda429.releaseTime = "2019-07-18 17:05:03"
        panda429.originalUrl = "https://www.bilibili.com/video/BV1ft411g7ug"
        panda429.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda429.authorId = 12444306
        panda429.cover =
            "https://i2.hdslb.com/bfs/archive/570494e293ab8de65cbf5b846a62f8e229c88482.jpg"
        list.add(panda429)

        val panda430 = PetVideo()
        panda430.type = VideoType.PANDA.ordinal
        panda430.fileName = "panda_baby_panda430"
        panda430.code = 1622
        panda430.duration = 304
        panda430.period = PeriodType.BABY.ordinal
        panda430.isStar = false
        panda430.title = "三国宝光天化日之下么么哒，污到简直没眼看！"
        panda430.releaseTime = "2016-05-31 17:46:48"
        panda430.originalUrl = "https://www.bilibili.com/video/BV12s411i7Es"
        panda430.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda430.authorId = 12444306
        panda430.cover =
            "https://i0.hdslb.com/bfs/archive/2ee30224e1fad3f12beeba4a9e15b1ddf172b05b.jpg"
        list.add(panda430)

        val panda431 = PetVideo()
        panda431.type = VideoType.PANDA.ordinal
        panda431.fileName = "panda_baby_panda431"
        panda431.code = 1623
        panda431.duration = 33
        panda431.period = PeriodType.BABY.ordinal
        panda431.isStar = false
        panda431.title = "孩子睡觉老是哼哼唧唧的"
        panda431.releaseTime = "2020-01-04 15:00:17"
        panda431.originalUrl = "https://www.bilibili.com/video/BV15J41177b1"
        panda431.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda431.authorId = 12444306
        panda431.cover =
            "https://i0.hdslb.com/bfs/archive/9ea05bf0e11b1032e951a46f54e78f83fd58a82d.jpg"
        list.add(panda431)

        val panda432 = PetVideo()
        panda432.type = VideoType.PANDA.ordinal
        panda432.fileName = "panda_baby_panda432"
        panda432.code = 1624
        panda432.duration = 96
        panda432.period = PeriodType.BABY.ordinal
        panda432.isStar = false
        panda432.title = "这不就是上班的我吗？？！"
        panda432.releaseTime = "2020-11-04 17:30:52"
        panda432.originalUrl = "https://www.bilibili.com/video/BV11a4y1s7GU"
        panda432.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda432.authorId = 12444306
        panda432.cover =
            "https://i2.hdslb.com/bfs/archive/ad3c8c0dcd493f97a91a06af5a4d72334089c964.jpg"
        list.add(panda432)

        val panda433 = PetVideo()
        panda433.type = VideoType.PANDA.ordinal
        panda433.fileName = "panda_baby_panda433"
        panda433.code = 1625
        panda433.duration = 180
        panda433.period = PeriodType.BABY.ordinal
        panda433.isStar = false
        panda433.title = "棍棍奶什么的都弱爆了！原来这才是真正的收猫神器！"
        panda433.releaseTime = "2016-05-23 12:12:08"
        panda433.originalUrl = "https://www.bilibili.com/video/BV13s411i77n"
        panda433.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda433.authorId = 12444306
        panda433.cover =
            "https://i0.hdslb.com/bfs/archive/865adb8a54943978bc707211b53c480b2c38e814.png"
        list.add(panda433)

        val panda434 = PetVideo()
        panda434.type = VideoType.PANDA.ordinal
        panda434.fileName = "panda_baby_panda434"
        panda434.code = 1626
        panda434.duration = 51
        panda434.period = PeriodType.BABY.ordinal
        panda434.isStar = false
        panda434.title = "失眠必看，看着看着就想睡了～"
        panda434.releaseTime = "2017-05-23 22:19:04"
        panda434.originalUrl = "https://www.bilibili.com/video/BV1Jx411Y7Nn"
        panda434.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda434.authorId = 12444306
        panda434.cover =
            "https://i1.hdslb.com/bfs/archive/01abcfcb0934dd656c323af84541cbc2c1ec6ad5.jpg"
        list.add(panda434)

        val panda435 = PetVideo()
        panda435.type = VideoType.PANDA.ordinal
        panda435.fileName = "panda_baby_panda435"
        panda435.code = 1627
        panda435.duration = 125
        panda435.period = PeriodType.BABY.ordinal
        panda435.isStar = false
        panda435.title = "小熊友的演技未免也太过了吧?!"
        panda435.releaseTime = "2019-10-06 21:00:58"
        panda435.originalUrl = "https://www.bilibili.com/video/BV1QJ411T74m"
        panda435.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda435.authorId = 12444306
        panda435.cover =
            "https://i1.hdslb.com/bfs/archive/31fd018537365cb38db03c7b19cca39813a8d24c.jpg"
        list.add(panda435)

        val panda436 = PetVideo()
        panda436.type = VideoType.PANDA.ordinal
        panda436.fileName = "panda_baby_panda436"
        panda436.code = 1628
        panda436.duration = 15
        panda436.period = PeriodType.BABY.ordinal
        panda436.isStar = false
        panda436.title = "没什么，就是个熊掌而已"
        panda436.releaseTime = "2016-10-15 17:00:14"
        panda436.originalUrl = "https://www.bilibili.com/video/BV1Es41147y9"
        panda436.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda436.authorId = 12444306
        panda436.cover =
            "https://i0.hdslb.com/bfs/archive/d83aa2c1ce1f454833b6f8f653c609a17260fe6a.jpg"
        list.add(panda436)

        val panda437 = PetVideo()
        panda437.type = VideoType.PANDA.ordinal
        panda437.fileName = "panda_baby_panda437"
        panda437.code = 1629
        panda437.duration = 96
        panda437.period = PeriodType.BABY.ordinal
        panda437.isStar = false
        panda437.title = "快说，我是不是你的小可爱！"
        panda437.releaseTime = "2018-12-25 20:00:14"
        panda437.originalUrl = "https://www.bilibili.com/video/BV1gt411C7uA"
        panda437.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda437.authorId = 12444306
        panda437.cover =
            "https://i2.hdslb.com/bfs/archive/d252d9a23058380fb04c76ce5762cbf72b37b525.jpg"
        list.add(panda437)

        val panda438 = PetVideo()
        panda438.type = VideoType.PANDA.ordinal
        panda438.fileName = "panda_baby_panda438"
        panda438.code = 1630
        panda438.duration = 47
        panda438.period = PeriodType.BABY.ordinal
        panda438.isStar = false
        panda438.title = "奶妈和团子的日常对话，乖宝宝都能听懂～"
        panda438.releaseTime = "2016-12-29 15:24:48"
        panda438.originalUrl = "https://www.bilibili.com/video/BV1os411a7so"
        panda438.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda438.authorId = 12444306
        panda438.cover =
            "https://i0.hdslb.com/bfs/archive/eab524f8477393ebd9aee8e09fc76daacedd8c0c.jpg"
        list.add(panda438)

        val panda439 = PetVideo()
        panda439.type = VideoType.PANDA.ordinal
        panda439.fileName = "panda_baby_panda439"
        panda439.code = 1631
        panda439.duration = 234
        panda439.period = PeriodType.BABY.ordinal
        panda439.isStar = false
        panda439.title = "奶妈，我要你抱着我喝瓶瓶奶！"
        panda439.releaseTime = "2019-07-11 20:00:38"
        panda439.originalUrl = "https://www.bilibili.com/video/BV1zx411f78h"
        panda439.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda439.authorId = 12444306
        panda439.cover =
            "https://i1.hdslb.com/bfs/archive/5a3404c122f52bf7a2b18e92b37784c9b7cf1fb6.jpg"
        list.add(panda439)

        val panda440 = PetVideo()
        panda440.type = VideoType.PANDA.ordinal
        panda440.fileName = "panda_baby_panda440"
        panda440.code = 1632
        panda440.duration = 82
        panda440.period = PeriodType.BABY.ordinal
        panda440.isStar = false
        panda440.title = "雅猪猪称体重，全程一脸懵：奶妈你居然说熊家肉多！明明就是称的锅！"
        panda440.releaseTime = "2016-11-02 11:10:54"
        panda440.originalUrl = "https://www.bilibili.com/video/BV1ws411x7Ds"
        panda440.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda440.authorId = 12444306
        panda440.cover =
            "https://i2.hdslb.com/bfs/archive/c12c0e09171e7d7d28263eef93d33435273bc4b1.jpg"
        list.add(panda440)

        val panda441 = PetVideo()
        panda441.type = VideoType.PANDA.ordinal
        panda441.fileName = "panda_baby_panda441"
        panda441.code = 1633
        panda441.duration = 134
        panda441.period = PeriodType.BABY.ordinal
        panda441.isStar = false
        panda441.title = "请问你们还收给国宝搓澡的吗？"
        panda441.releaseTime = "2019-06-16 20:00:20"
        panda441.originalUrl = "https://www.bilibili.com/video/BV1W4411V78u"
        panda441.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda441.authorId = 12444306
        panda441.cover =
            "https://i1.hdslb.com/bfs/archive/47aac9688da837be1f5f11d7caa349bd5bcde748.jpg"
        list.add(panda441)

        val panda442 = PetVideo()
        panda442.type = VideoType.PANDA.ordinal
        panda442.fileName = "panda_baby_panda442"
        panda442.code = 1634
        panda442.duration = 44
        panda442.period = PeriodType.BABY.ordinal
        panda442.isStar = true
        panda442.title = "胖娃儿跟奶爸对答如流！么么儿，说好的建国之后不准成精呢？"
        panda442.releaseTime = "2016-09-10 16:35:21"
        panda442.originalUrl = "https://www.bilibili.com/video/BV1Ns411r7Rf"
        panda442.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda442.authorId = 12444306
        panda442.cover =
            "https://i0.hdslb.com/bfs/archive/4b926ec801aa05c47a1ea7856d04a95078263251.jpg"
        list.add(panda442)

        val panda443 = PetVideo()
        panda443.type = VideoType.PANDA.ordinal
        panda443.fileName = "panda_baby_panda443"
        panda443.code = 1635
        panda443.duration = 83
        panda443.period = PeriodType.BABY.ordinal
        panda443.isStar = true
        panda443.title = "【绩笑】本国宝最讨厌别人批评我！ 谁给翻译一下，憨憨在说啥呢？"
        panda443.releaseTime = "2020-07-06 12:37:23"
        panda443.originalUrl = "https://www.bilibili.com/video/BV1uf4y1R7Lr"
        panda443.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda443.authorId = 12444306
        panda443.cover =
            "https://i2.hdslb.com/bfs/archive/4bd0c0fe35ec632770eb449ce03214cfa8693b83.jpg"
        list.add(panda443)

        val panda444 = PetVideo()
        panda444.type = VideoType.PANDA.ordinal
        panda444.fileName = "panda_baby_panda444"
        panda444.code = 1636
        panda444.duration = 54
        panda444.period = PeriodType.BABY.ordinal
        panda444.isStar = false
        panda444.title = "【绩笑】奶妈，你说我怎么跑到木床外面了呢？这是为什么呢？"
        panda444.releaseTime = "2019-12-10 11:18:40"
        panda444.originalUrl = "https://www.bilibili.com/video/BV14J411y7h6"
        panda444.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda444.authorId = 12444306
        panda444.cover =
            "https://i1.hdslb.com/bfs/archive/07e5297bf0c6c0b2ced5a02cec033c69067191cd.jpg"
        list.add(panda444)

        val panda445 = PetVideo()
        panda445.type = VideoType.PANDA.ordinal
        panda445.fileName = "panda_baby_panda445"
        panda445.code = 1637
        panda445.duration = 114
        panda445.period = PeriodType.BABY.ordinal
        panda445.isStar = true
        panda445.title = "血槽已空！熊猫宝宝举着jiojio喝瓶瓶奶也太萌了吧！"
        panda445.releaseTime = "2020-08-10 15:45:50"
        panda445.originalUrl = "https://www.bilibili.com/video/BV1Mi4y1g7Dz"
        panda445.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda445.authorId = 12444306
        panda445.cover =
            "https://i1.hdslb.com/bfs/archive/48d98f639224f76e9e985f25aaa00e6c75d7fb78.jpg"
        list.add(panda445)

        val panda446 = PetVideo()
        panda446.type = VideoType.PANDA.ordinal
        panda446.fileName = "panda_baby_panda446"
        panda446.code = 1638
        panda446.duration = 259
        panda446.period = PeriodType.BABY.ordinal
        panda446.isStar = false
        panda446.title = "幼儿园放学回家，抱错就尴尬了"
        panda446.releaseTime = "2019-03-26 21:00:47"
        panda446.originalUrl = "https://www.bilibili.com/video/BV1Ab411t75U"
        panda446.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda446.authorId = 12444306
        panda446.cover =
            "https://i2.hdslb.com/bfs/archive/d93afc06d892a8deca0fa6fc15cf9426a75afc67.jpg"
        list.add(panda446)

        val panda447 = PetVideo()
        panda447.type = VideoType.PANDA.ordinal
        panda447.fileName = "panda_baby_panda447"
        panda447.code = 1639
        panda447.duration = 122
        panda447.period = PeriodType.BABY.ordinal
        panda447.isStar = false
        panda447.title = "对不起，对不起，乖乖！饲养员也慌了，连忙道歉"
        panda447.releaseTime = "2019-05-19 15:05:23"
        panda447.originalUrl = "https://www.bilibili.com/video/BV1s4411a7er"
        panda447.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda447.authorId = 12444306
        panda447.cover =
            "https://i1.hdslb.com/bfs/archive/aa59eabb3ffe50d2eca2a33761db0f08b22b3e72.jpg"
        list.add(panda447)

        val panda448 = PetVideo()
        panda448.type = VideoType.PANDA.ordinal
        panda448.fileName = "panda_baby_panda448"
        panda448.code = 1640
        panda448.duration = 68
        panda448.period = PeriodType.BABY.ordinal
        panda448.isStar = false
        panda448.title = "【大熊猫萌玉】小仙女啊，坐着吃竹笋乖惨了，要被萌化了*^_^*"
        panda448.releaseTime = "2019-06-04 00:29:17"
        panda448.originalUrl = "https://www.bilibili.com/video/BV1V4411H7VZ"
        panda448.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda448.authorId = 34677299
        panda448.cover =
            "https://i2.hdslb.com/bfs/archive/3b918a3c1ac2ac717d6c41ef63e3f89cea091534.jpg"
        list.add(panda448)

        val panda449 = PetVideo()
        panda449.type = VideoType.PANDA.ordinal
        panda449.fileName = "panda_baby_panda449"
        panda449.code = 1641
        panda449.duration = 170
        panda449.period = PeriodType.BABY.ordinal
        panda449.isStar = true
        panda449.title = "【大熊猫萌玉】我们五五小阔爱，在树上颤颤巍巍的和树枝杠上了（20181209）"
        panda449.releaseTime = "2019-02-27 15:37:00"
        panda449.originalUrl = "https://www.bilibili.com/video/BV1Bb411t7vH"
        panda449.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda449.authorId = 34677299
        panda449.cover =
            "https://i0.hdslb.com/bfs/archive/d7aefbd33e17b1adbc5b46188dd75892d20b5589.jpg"
        list.add(panda449)

        val panda450 = PetVideo()
        panda450.type = VideoType.PANDA.ordinal
        panda450.fileName = "panda_baby_panda450"
        panda450.code = 1642
        panda450.duration = 138
        panda450.period = PeriodType.BABY.ordinal
        panda450.isStar = false
        panda450.title = "【大熊猫萌玉】“剔牙”小仙女，涉嫌恶意卖萌，再这样报警了←_←"
        panda450.releaseTime = "2019-06-12 21:27:57"
        panda450.originalUrl = "https://www.bilibili.com/video/BV1V4411P7Vf"
        panda450.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda450.authorId = 34677299
        panda450.cover =
            "https://i1.hdslb.com/bfs/archive/40fa39852ac8a5881160fb5f04dd93e529942da3.jpg"
        list.add(panda450)

        val panda451 = PetVideo()
        panda451.type = VideoType.PANDA.ordinal
        panda451.fileName = "panda_baby_panda451"
        panda451.code = 1643
        panda451.duration = 131
        panda451.period = PeriodType.BABY.ordinal
        panda451.isStar = true
        panda451.title = "【大熊猫萌宝&萌玉】小四:妹妹你先啃着，姐姐我先下班了←_←"
        panda451.releaseTime = "2019-02-25 19:59:39"
        panda451.originalUrl = "https://www.bilibili.com/video/BV1pb411876g"
        panda451.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda451.authorId = 34677299
        panda451.cover =
            "https://i0.hdslb.com/bfs/archive/af4193333a5c32eab4067d24984ae0fd50495786.jpg"
        list.add(panda451)

        val panda452 = PetVideo()
        panda452.type = VideoType.PANDA.ordinal
        panda452.fileName = "panda_baby_panda452"
        panda452.code = 1644
        panda452.duration = 66
        panda452.period = PeriodType.BABY.ordinal
        panda452.isStar = false
        panda452.title = "你走开……我妈不让我和傻子玩……"
        panda452.releaseTime = "2019-06-22 20:00:25"
        panda452.originalUrl = "https://www.bilibili.com/video/BV1b4411u7XM"
        panda452.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda452.authorId = 12444306
        panda452.cover =
            "https://i1.hdslb.com/bfs/archive/dbe8f8d5322ff2e65fdaccb73209714ddf1da3dd.jpg"
        list.add(panda452)

        val panda453 = PetVideo()
        panda453.type = VideoType.PANDA.ordinal
        panda453.fileName = "panda_baby_panda453"
        panda453.code = 1645
        panda453.duration = 55
        panda453.period = PeriodType.BABY.ordinal
        panda453.isStar = true
        panda453.title = "莫名其妙的怂"
        panda453.releaseTime = "2017-12-24 20:40:10"
        panda453.originalUrl = "https://www.bilibili.com/video/BV1zW41187kw"
        panda453.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda453.authorId = 12444306
        panda453.cover =
            "https://i1.hdslb.com/bfs/archive/19df8a6e122f1d55c72cfdadf7168d88bb5e7fea.jpg"
        list.add(panda453)

        val panda454 = PetVideo()
        panda454.type = VideoType.PANDA.ordinal
        panda454.fileName = "panda_baby_panda454"
        panda454.code = 1646
        panda454.duration = 190
        panda454.period = PeriodType.BABY.ordinal
        panda454.isStar = false
        panda454.title = "【大熊猫萌萌&萌玉】阿妈，他们说我脸大~"
        panda454.releaseTime = "2019-09-07 10:44:49"
        panda454.originalUrl = "https://www.bilibili.com/video/BV164411k7Yo"
        panda454.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda454.authorId = 34677299
        panda454.cover =
            "https://i0.hdslb.com/bfs/archive/1431f7116b2d58b94b5ee7d97e3f4be5f5604c4f.jpg"
        list.add(panda454)

        val panda455 = PetVideo()
        panda455.type = VideoType.PANDA.ordinal
        panda455.fileName = "panda_baby_panda455"
        panda455.code = 1647
        panda455.duration = 124
        panda455.period = PeriodType.BABY.ordinal
        panda455.isStar = false
        panda455.title = "今天的盆盆奶的味道怎么不太对啊？"
        panda455.releaseTime = "2018-09-22 14:00:52"
        panda455.originalUrl = "https://www.bilibili.com/video/BV14W411r7QT"
        panda455.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda455.authorId = 19281543
        panda455.cover =
            "https://i2.hdslb.com/bfs/archive/047d8fd2114b19d780d4c9fed5cc17fad9dc281e.jpg"
        list.add(panda455)

        val panda456 = PetVideo()
        panda456.type = VideoType.PANDA.ordinal
        panda456.fileName = "panda_baby_panda456"
        panda456.code = 1648
        panda456.duration = 72
        panda456.period = PeriodType.BABY.ordinal
        panda456.isStar = false
        panda456.title = "“芝师傅”的“打糕揉面”日常"
        panda456.releaseTime = "2020-11-09 17:30:34"
        panda456.originalUrl = "https://www.bilibili.com/video/BV1mZ4y1V7o1"
        panda456.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda456.authorId = 1998535
        panda456.cover =
            "https://i1.hdslb.com/bfs/archive/356bfc6705ddf5b21f2c9cfb7f700fde546e2cf9.jpg"
        list.add(panda456)

        val panda457 = PetVideo()
        panda457.type = VideoType.PANDA.ordinal
        panda457.fileName = "panda_baby_panda457"
        panda457.code = 1649
        panda457.duration = 80
        panda457.period = PeriodType.BABY.ordinal
        panda457.isStar = false
        panda457.title = "今天是为福多多高兴的一天！【熊猫宝宝福多多，雅颂】"
        panda457.releaseTime = "2022-02-26 02:39:19"
        panda457.originalUrl = "https://www.bilibili.com/video/BV1cq4y1b7NN"
        panda457.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda457.authorId = 2137796700
        panda457.cover =
            "https://i1.hdslb.com/bfs/archive/641a9af59389ffc31602e03ddde0955428908512.jpg"
        list.add(panda457)

        val panda458 = PetVideo()
        panda458.type = VideoType.PANDA.ordinal
        panda458.fileName = "panda_baby_panda458"
        panda458.code = 1650
        panda458.duration = 43
        panda458.period = PeriodType.BABY.ordinal
        panda458.isStar = false
        panda458.title = "大熊猫福多多：奶妈给多多妹儿戴了一朵小红花，多多控制不住自己了"
        panda458.releaseTime = "2022-02-24 23:00:11"
        panda458.originalUrl = "https://www.bilibili.com/video/BV14F411t792"
        panda458.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda458.authorId = 98871951
        panda458.cover =
            "https://i2.hdslb.com/bfs/archive/1e7a21689473fd743beb74eec48578ac198357f6.jpg"
        list.add(panda458)

        val panda459 = PetVideo()
        panda459.type = VideoType.PANDA.ordinal
        panda459.fileName = "panda_baby_panda459"
        panda459.code = 1651
        panda459.duration = 50
        panda459.period = PeriodType.BABY.ordinal
        panda459.isStar = false
        panda459.title = "趴趴辉欺负工行大小姐，金宵嗯嗯嗯。。【大熊猫金宵、轮辉】"
        panda459.releaseTime = "2022-02-22 21:23:54"
        panda459.originalUrl = "https://www.bilibili.com/video/BV1a34y1C7Zc"
        panda459.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda459.authorId = 514531996
        panda459.cover =
            "https://i0.hdslb.com/bfs/archive/afa4eabb39bc15713776410555659cb9c08aed32.jpg"
        list.add(panda459)

        val panda460 = PetVideo()
        panda460.type = VideoType.PANDA.ordinal
        panda460.fileName = "panda_baby_panda460"
        panda460.code = 1652
        panda460.duration = 121
        panda460.period = PeriodType.BABY.ordinal
        panda460.isStar = false
        panda460.title = "肉肉，你跨个年经历了什么呀？(⊙ｏ⊙)"
        panda460.releaseTime = "2017-01-07 20:28:02"
        panda460.originalUrl = "https://www.bilibili.com/video/BV1Ds41187Er"
        panda460.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda460.authorId = 4038416
        panda460.cover =
            "https://i2.hdslb.com/bfs/archive/714f781424e274ac0903510f3bad337dae3b5688.jpg"
        list.add(panda460)

        val panda461 = PetVideo()
        panda461.type = VideoType.PANDA.ordinal
        panda461.fileName = "panda_baby_panda461"
        panda461.code = 1653
        panda461.duration = 91
        panda461.period = PeriodType.BABY.ordinal
        panda461.isStar = false
        panda461.title = "都不知道该看人还是看熊猫了"
        panda461.releaseTime = "2019-05-10 23:21:45"
        panda461.originalUrl = "https://www.bilibili.com/video/BV1r4411e7ek"
        panda461.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda461.authorId = 37053244
        panda461.cover =
            "https://i1.hdslb.com/bfs/archive/b8f6fb15990cfabddce29bef8126137c7fc1ea33.jpg"
        list.add(panda461)

        val panda462 = PetVideo()
        panda462.type = VideoType.PANDA.ordinal
        panda462.fileName = "panda_baby_panda462"
        panda462.code = 1654
        panda462.duration = 63
        panda462.period = PeriodType.BABY.ordinal
        panda462.isStar = false
        panda462.title = "奶爸！抱我！"
        panda462.releaseTime = "2016-12-14 17:34:38"
        panda462.originalUrl = "https://www.bilibili.com/video/BV1Es411e7nU"
        panda462.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda462.authorId = 12444306
        panda462.cover =
            "https://i0.hdslb.com/bfs/archive/87267cfed3853027d564add5a8d922308f737294.jpg"
        list.add(panda462)

        val panda463 = PetVideo()
        panda463.type = VideoType.PANDA.ordinal
        panda463.fileName = "panda_baby_panda463"
        panda463.code = 1655
        panda463.duration = 133
        panda463.period = PeriodType.BABY.ordinal
        panda463.isStar = false
        panda463.title = "苹果泡牛奶，高端吃法了解一下吗？"
        panda463.releaseTime = "2019-12-30 15:15:30"
        panda463.originalUrl = "https://www.bilibili.com/video/BV1LJ411Y7V2"
        panda463.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda463.authorId = 12444306
        panda463.cover =
            "https://i0.hdslb.com/bfs/archive/81b1906a6a3abdcf608a515bbcc6dfac449424df.jpg"
        list.add(panda463)

        val panda464 = PetVideo()
        panda464.type = VideoType.PANDA.ordinal
        panda464.fileName = "panda_baby_panda464"
        panda464.code = 1656
        panda464.duration = 84
        panda464.period = PeriodType.BABY.ordinal
        panda464.isStar = false
        panda464.title = "这孩子是走路走到一半睡着了，又起来走？"
        panda464.releaseTime = "2020-02-20 13:50:55"
        panda464.originalUrl = "https://www.bilibili.com/video/BV1n7411j7pe"
        panda464.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda464.authorId = 12444306
        panda464.cover =
            "https://i0.hdslb.com/bfs/archive/7a704d003367e3a1856a13f2bf38899f4fb4e31c.jpg"
        list.add(panda464)

        val panda465 = PetVideo()
        panda465.type = VideoType.PANDA.ordinal
        panda465.fileName = "panda_baby_panda465"
        panda465.code = 1657
        panda465.duration = 69
        panda465.period = PeriodType.BABY.ordinal
        panda465.isStar = false
        panda465.title = "长得胖就可以随便撞熊了么？真是太过分了！！！"
        panda465.releaseTime = "2020-06-17 14:45:59"
        panda465.originalUrl = "https://www.bilibili.com/video/BV1mZ4y1H7DZ"
        panda465.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda465.authorId = 12444306
        panda465.cover =
            "https://i1.hdslb.com/bfs/archive/dacfd83cd0e3b5b6a2ff04350e1ea889c036a85b.jpg"
        list.add(panda465)

        val panda466 = PetVideo()
        panda466.type = VideoType.PANDA.ordinal
        panda466.fileName = "panda_baby_panda466"
        panda466.code = 1658
        panda466.duration = 109
        panda466.period = PeriodType.BABY.ordinal
        panda466.isStar = true
        panda466.title = "生活不易，熊猫宝宝当街“卖艺”"
        panda466.releaseTime = "2020-04-01 12:04:50"
        panda466.originalUrl = "https://www.bilibili.com/video/BV1q541167qB"
        panda466.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda466.authorId = 12444306
        panda466.cover =
            "https://i1.hdslb.com/bfs/archive/ca8408899ebde60a348cebb99f62f83f27ad54dc.jpg"
        list.add(panda466)

        val panda467 = PetVideo()
        panda467.type = VideoType.PANDA.ordinal
        panda467.fileName = "panda_baby_panda467"
        panda467.code = 1659
        panda467.duration = 125
        panda467.period = PeriodType.BABY.ordinal
        panda467.isStar = false
        panda467.title = "熊猫宝宝学走路，屁股一扭一扭哒~"
        panda467.releaseTime = "2020-02-08 18:30:46"
        panda467.originalUrl = "https://www.bilibili.com/video/BV1z741187cn"
        panda467.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda467.authorId = 12444306
        panda467.cover =
            "https://i2.hdslb.com/bfs/archive/0c11ecc32397dc48e6206499434e76194d335214.jpg"
        list.add(panda467)

        val panda468 = PetVideo()
        panda468.type = VideoType.PANDA.ordinal
        panda468.fileName = "panda_baby_panda468"
        panda468.code = 1660
        panda468.duration = 72
        panda468.period = PeriodType.BABY.ordinal
        panda468.isStar = false
        panda468.title = "妈耶，背后有妹妹熊在追我呀"
        panda468.releaseTime = "2018-12-27 21:00:37"
        panda468.originalUrl = "https://www.bilibili.com/video/BV1Pt411r7hB"
        panda468.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda468.authorId = 12444306
        panda468.cover =
            "https://i1.hdslb.com/bfs/archive/7b5d75901b41dce95a666cab1a88ad3612198742.jpg"
        list.add(panda468)

        val panda469 = PetVideo()
        panda469.type = VideoType.PANDA.ordinal
        panda469.fileName = "panda_baby_panda469"
        panda469.code = 1661
        panda469.duration = 51
        panda469.period = PeriodType.BABY.ordinal
        panda469.isStar = false
        panda469.title = "冬天，需要抱团取暖"
        panda469.releaseTime = "2016-12-14 17:14:06"
        panda469.originalUrl = "https://www.bilibili.com/video/BV1Es411e7Lo"
        panda469.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda469.authorId = 12444306
        panda469.cover =
            "https://i0.hdslb.com/bfs/archive/7f6cd966b6671cd148849000764f2cee2d6c8d2f.jpg"
        list.add(panda469)

        val panda470 = PetVideo()
        panda470.type = VideoType.PANDA.ordinal
        panda470.fileName = "panda_baby_panda470"
        panda470.code = 1662
        panda470.duration = 90
        panda470.period = PeriodType.BABY.ordinal
        panda470.isStar = false
        panda470.title = "新物种——胖达兔～从来没见过这么胖的兔几！"
        panda470.releaseTime = "2016-12-26 19:35:58"
        panda470.originalUrl = "https://www.bilibili.com/video/BV11s411a7ra"
        panda470.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda470.authorId = 12444306
        panda470.cover =
            "https://i2.hdslb.com/bfs/archive/3849f19f93fc4964749d966e3e130a2efef99c8f.jpg"
        list.add(panda470)

        val panda471 = PetVideo()
        panda471.type = VideoType.PANDA.ordinal
        panda471.fileName = "panda_baby_panda471"
        panda471.code = 1663
        panda471.duration = 40
        panda471.period = PeriodType.BABY.ordinal
        panda471.isStar = true
        panda471.title = "一想到自己是国宝，就睡得更踏实了~"
        panda471.releaseTime = "2020-09-13 19:33:50"
        panda471.originalUrl = "https://www.bilibili.com/video/BV1Ji4y1u7Ja"
        panda471.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda471.authorId = 62489116
        panda471.cover =
            "https://i1.hdslb.com/bfs/archive/691540e0a5d3d5e5e823cd59e16a16f088020c14.jpg"
        list.add(panda471)

        val panda472 = PetVideo()
        panda472.type = VideoType.PANDA.ordinal
        panda472.fileName = "panda_baby_panda472"
        panda472.code = 1664
        panda472.duration = 92
        panda472.period = PeriodType.BABY.ordinal
        panda472.isStar = false
        panda472.title = "乔乔野外引种产下的俩男孩真是软糯可爱 白白胖胖！"
        panda472.releaseTime = "2020-04-27 11:10:19"
        panda472.originalUrl = "https://www.bilibili.com/video/BV1vK411575m"
        panda472.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda472.authorId = 4120384
        panda472.cover =
            "https://i2.hdslb.com/bfs/archive/c354e5ef69c4af4228c337668eff663b9ea80e83.jpg"
        list.add(panda472)

        val panda473 = PetVideo()
        panda473.type = VideoType.PANDA.ordinal
        panda473.fileName = "panda_baby_panda473"
        panda473.code = 1665
        panda473.duration = 26
        panda473.period = PeriodType.BABY.ordinal
        panda473.isStar = true
        panda473.title = "好可爱好呆萌的国宠！！！"
        panda473.releaseTime = "2021-04-05 02:12:32"
        panda473.originalUrl = "https://www.bilibili.com/video/BV1py4y1b7vi"
        panda473.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda473.authorId = 623627520
        panda473.cover =
            "https://i0.hdslb.com/bfs/archive/84055c8d37bbed25af375a0a97817110bfbfd760.jpg"
        list.add(panda473)

        val panda474 = PetVideo()
        panda474.type = VideoType.PANDA.ordinal
        panda474.fileName = "panda_baby_panda474"
        panda474.code = 1666
        panda474.duration = 98
        panda474.period = PeriodType.BABY.ordinal
        panda474.isStar = true
        panda474.title = "这个睡姿我看入迷了"
        panda474.releaseTime = "2019-07-16 18:22:32"
        panda474.originalUrl = "https://www.bilibili.com/video/BV19t41157QF"
        panda474.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda474.authorId = 37053244
        panda474.cover =
            "https://i2.hdslb.com/bfs/archive/ebeab4c890cb88fd002b8cd09d152666f84b32fa.jpg"
        list.add(panda474)

        val panda475 = PetVideo()
        panda475.type = VideoType.PANDA.ordinal
        panda475.fileName = "panda_baby_panda475"
        panda475.code = 1667
        panda475.duration = 83
        panda475.period = PeriodType.BABY.ordinal
        panda475.isStar = false
        panda475.title = "小多多爬高高。【大熊猫福多多】"
        panda475.releaseTime = "2022-02-20 18:55:04"
        panda475.originalUrl = "https://www.bilibili.com/video/BV1vL4y1G7m1"
        panda475.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda475.authorId = 514531996
        panda475.cover =
            "https://i0.hdslb.com/bfs/archive/33cc75dffd4d5606bb06e5d7c5b01ea650f161be.jpg"
        list.add(panda475)

        val panda476 = PetVideo()
        panda476.type = VideoType.PANDA.ordinal
        panda476.fileName = "panda_baby_panda476"
        panda476.code = 1668
        panda476.duration = 158
        panda476.period = PeriodType.BABY.ordinal
        panda476.isStar = false
        panda476.title = "熊猫宝宝的耳朵是甜的吧？要不路过的熊咋都想来一口……"
        panda476.releaseTime = "2022-02-17 20:00:12"
        panda476.originalUrl = "https://www.bilibili.com/video/BV1VP4y1w7AK"
        panda476.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda476.authorId = 1998535
        panda476.cover =
            "https://i2.hdslb.com/bfs/archive/b05a2f4cb0d314a5055ad9d40a514fd49749a30b.jpg"
        list.add(panda476)

        val panda477 = PetVideo()
        panda477.type = VideoType.PANDA.ordinal
        panda477.fileName = "panda_baby_panda477"
        panda477.code = 1669
        panda477.duration = 29
        panda477.period = PeriodType.BABY.ordinal
        panda477.isStar = false
        panda477.title = "【和花】一年前的婴儿花～录制节目把娃累坏了😘"
        panda477.releaseTime = "2022-02-06 06:30:10"
        panda477.originalUrl = "https://www.bilibili.com/video/BV1mR4y1j7XG"
        panda477.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda477.authorId = 1098561796
        panda477.cover =
            "https://i2.hdslb.com/bfs/archive/30de3a598c9c3501942515aa2fda5e7834a262dd.jpg"
        list.add(panda477)

        val panda478 = PetVideo()
        panda478.type = VideoType.PANDA.ordinal
        panda478.fileName = "panda_baby_panda478"
        panda478.code = 1670
        panda478.duration = 173
        panda478.period = PeriodType.BABY.ordinal
        panda478.isStar = false
        panda478.title = "【大熊猫和叶】这娃打小就机灵"
        panda478.releaseTime = "2021-11-26 12:57:19"
        panda478.originalUrl = "https://www.bilibili.com/video/BV1XU4y1K7Ne"
        panda478.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda478.authorId = 34677299
        panda478.cover =
            "https://i0.hdslb.com/bfs/archive/27c1814489fd566473d39b231f5e8e922196b461.jpg"
        list.add(panda478)

        val panda479 = PetVideo()
        panda479.type = VideoType.PANDA.ordinal
        panda479.fileName = "panda_baby_panda479"
        panda479.code = 1671
        panda479.duration = 89
        panda479.period = PeriodType.BABY.ordinal
        panda479.isStar = false
        panda479.title = "【大熊猫和叶】小和叶：别忘了我也很可爱吖~"
        panda479.releaseTime = "2021-07-17 16:06:28"
        panda479.originalUrl = "https://www.bilibili.com/video/BV1954y1n7EG"
        panda479.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda479.authorId = 34677299
        panda479.cover =
            "https://i1.hdslb.com/bfs/archive/3d3c21753383910dbfba283ba6da18b1f4f1dc8a.jpg"
        list.add(panda479)

        val panda480 = PetVideo()
        panda480.type = VideoType.PANDA.ordinal
        panda480.fileName = "panda_baby_panda480"
        panda480.code = 1672
        panda480.duration = 96
        panda480.period = PeriodType.BABY.ordinal
        panda480.isStar = false
        panda480.title = "没有冰墩墩？来看顶流熊墩墩！"
        panda480.releaseTime = "2022-02-09 18:33:20"
        panda480.originalUrl = "https://www.bilibili.com/video/BV1Mq4y1873S"
        panda480.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda480.authorId = 488055582
        panda480.cover =
            "https://i0.hdslb.com/bfs/archive/3fc2024792c6446e2f34fdf31ea5bae38b4a3f9a.jpg"
        list.add(panda480)

        val panda481 = PetVideo()
        panda481.type = VideoType.PANDA.ordinal
        panda481.fileName = "panda_baby_panda481"
        panda481.code = 1673
        panda481.duration = 184
        panda481.period = PeriodType.BABY.ordinal
        panda481.isStar = false
        panda481.title = "众所周知，元宵节的汤圆是用来吃的，不是用来亲的！"
        panda481.releaseTime = "2022-02-15 19:00:14"
        panda481.originalUrl = "https://www.bilibili.com/video/BV1xb4y147CL"
        panda481.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda481.authorId = 1998535
        panda481.cover =
            "https://i2.hdslb.com/bfs/archive/bd10c5ce12c2929161560932e870dda48bd8b8d5.jpg"
        list.add(panda481)

        val panda482 = PetVideo()
        panda482.type = VideoType.PANDA.ordinal
        panda482.fileName = "panda_baby_panda482"
        panda482.code = 1674
        panda482.duration = 32
        panda482.period = PeriodType.BABY.ordinal
        panda482.isStar = false
        panda482.title = "萌出一脸血，忍不住看了三遍！"
        panda482.releaseTime = "2022-02-14 19:50:05"
        panda482.originalUrl = "https://www.bilibili.com/video/BV1aP4y1w7S3"
        panda482.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda482.authorId = 1247719104
        panda482.cover =
            "https://i2.hdslb.com/bfs/archive/9c3964678ee214dd7c8351e49655e9f759678948.jpg"
        list.add(panda482)

        val panda483 = PetVideo()
        panda483.type = VideoType.PANDA.ordinal
        panda483.fileName = "panda_baby_panda483"
        panda483.code = 1675
        panda483.duration = 119
        panda483.period = PeriodType.BABY.ordinal
        panda483.isStar = false
        panda483.title = "【萌化了！#冰墩墩成都分墩cos元宵和汤圆#】"
        panda483.releaseTime = "2022-02-15 11:30:16"
        panda483.originalUrl = "https://www.bilibili.com/video/BV1QS4y1C7FK"
        panda483.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda483.authorId = 72209046
        panda483.cover =
            "https://i0.hdslb.com/bfs/archive/6603947b8b4a5b9f8643043373d1632e39185c8b.jpg"
        list.add(panda483)

        val panda484 = PetVideo()
        panda484.type = VideoType.PANDA.ordinal
        panda484.fileName = "panda_baby_panda484"
        panda484.code = 1676
        panda484.duration = 152
        panda484.period = PeriodType.BABY.ordinal
        panda484.isStar = false
        panda484.title = "【绩笑】天呐 这是哪只小可爱在这东张西望找妈妈"
        panda484.releaseTime = "2020-10-05 01:02:10"
        panda484.originalUrl = "https://www.bilibili.com/video/BV1DK4y187Kf"
        panda484.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda484.authorId = 39546503
        panda484.cover =
            "https://i0.hdslb.com/bfs/archive/dff1c13196f35c11d627d075d79c5051038015f6.jpg"
        list.add(panda484)

        val panda485 = PetVideo()
        panda485.type = VideoType.PANDA.ordinal
        panda485.fileName = "panda_baby_panda485"
        panda485.code = 1677
        panda485.duration = 213
        panda485.period = PeriodType.BABY.ordinal
        panda485.isStar = false
        panda485.title = "【绩笑成风】（）（）姐妹花震撼来袭，祝愿两姐妹早日复课，继续乘风破浪！"
        panda485.releaseTime = "2020-09-02 23:22:30"
        panda485.originalUrl = "https://www.bilibili.com/video/BV19A411n7nk"
        panda485.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda485.authorId = 39546503
        panda485.cover =
            "https://i0.hdslb.com/bfs/archive/1022ca8ee637c13845efc0d3565bc23de6584145.jpg"
        list.add(panda485)

        val panda486 = PetVideo()
        panda486.type = VideoType.PANDA.ordinal
        panda486.fileName = "panda_baby_panda486"
        panda486.code = 1678
        panda486.duration = 53
        panda486.period = PeriodType.BABY.ordinal
        panda486.isStar = false
        panda486.title = "肉肉的反击"
        panda486.releaseTime = "2020-09-01 08:48:37"
        panda486.originalUrl = "https://www.bilibili.com/video/BV1CV41127Ns"
        panda486.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda486.authorId = 551961363
        panda486.cover =
            "https://i2.hdslb.com/bfs/archive/a6c8c2dc98f455ad0ec3ea073a8b569a03b857ef.jpg"
        list.add(panda486)

        val panda487 = PetVideo()
        panda487.type = VideoType.PANDA.ordinal
        panda487.fileName = "panda_baby_panda487"
        panda487.code = 1679
        panda487.duration = 105
        panda487.period = PeriodType.BABY.ordinal
        panda487.isStar = false
        panda487.title = "奔跑的肉肉"
        panda487.releaseTime = "2020-08-20 09:24:49"
        panda487.originalUrl = "https://www.bilibili.com/video/BV1BZ4y1K7gc"
        panda487.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda487.authorId = 551961363
        panda487.cover =
            "https://i0.hdslb.com/bfs/archive/8912b95b557e6241487acbef3c9be6d38b8e552d.jpg"
        list.add(panda487)

        val panda488 = PetVideo()
        panda488.type = VideoType.PANDA.ordinal
        panda488.fileName = "panda_baby_panda488"
        panda488.code = 1680
        panda488.duration = 52
        panda488.period = PeriodType.BABY.ordinal
        panda488.isStar = false
        panda488.title = "【和花】是不是你们梦中情猫花墩墩？"
        panda488.releaseTime = "2022-02-12 18:50:16"
        panda488.originalUrl = "https://www.bilibili.com/video/BV1hm4y1Z7et"
        panda488.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda488.authorId = 1887387895
        panda488.cover =
            "https://i0.hdslb.com/bfs/archive/45c49592fa334337533a9c90d7a69fe41d607d56.jpg"
        list.add(panda488)

        val panda489 = PetVideo()
        panda489.type = VideoType.PANDA.ordinal
        panda489.fileName = "panda_baby_panda489"
        panda489.code = 1681
        panda489.duration = 93
        panda489.period = PeriodType.BABY.ordinal
        panda489.isStar = false
        panda489.title = "和花一副小大人的样子，太可爱了"
        panda489.releaseTime = "2022-02-11 19:40:16"
        panda489.originalUrl = "https://www.bilibili.com/video/BV1J34y117aX"
        panda489.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda489.authorId = 1942411621
        panda489.cover =
            "https://i2.hdslb.com/bfs/archive/188ac90b6139c579758f7702567973eea9397290.jpg"
        list.add(panda489)

        val panda490 = PetVideo()
        panda490.type = VideoType.PANDA.ordinal
        panda490.fileName = "panda_baby_panda490"
        panda490.code = 1960
        panda490.duration = 185
        panda490.period = PeriodType.BABY.ordinal
        panda490.isStar = false
        panda490.title = "【大熊猫福多多】你成长的每一步，都有爱你的人在守护"
        panda490.releaseTime = "2022-02-19 11:12:03"
        panda490.originalUrl = "https://www.bilibili.com/video/BV1Xu41197Ph"
        panda490.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda490.authorId = 357432921
        panda490.cover =
            "https://i2.hdslb.com/bfs/archive/f839b8b99fd14a0e69e8da4a8c1af7af510ad13d.jpg"
        list.add(panda490)

        val panda491 = PetVideo()
        panda491.type = VideoType.PANDA.ordinal
        panda491.fileName = "panda_baby_panda491"
        panda491.code = 1961
        panda491.duration = 31
        panda491.period = PeriodType.BABY.ordinal
        panda491.isStar = true
        panda491.title = "两脚兽注意！萌兽出现了萌化你【和花】"
        panda491.releaseTime = "2022-02-19 10:00:16"
        panda491.originalUrl = "https://www.bilibili.com/video/BV1Lm4y1d7cu"
        panda491.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda491.authorId = 1887387895
        panda491.cover =
            "https://i2.hdslb.com/bfs/archive/4b06e17d51005b0a50667f50aa95e9f68050c914.jpg"
        list.add(panda491)

        val panda492 = PetVideo()
        panda492.type = VideoType.PANDA.ordinal
        panda492.fileName = "panda_baby_panda492"
        panda492.code = 1962
        panda492.duration = 76
        panda492.period = PeriodType.BABY.ordinal
        panda492.isStar = true
        panda492.title = "【大熊猫福多多】幼崽果然是最可爱的生物，当熊猫幼崽遇到人类幼崽，这神仙组合太让人上头了"
        panda492.releaseTime = "2021-12-19 17:35:48"
        panda492.originalUrl = "https://www.bilibili.com/video/BV1gP4y1H7PM"
        panda492.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda492.authorId = 1808524083
        panda492.cover =
            "https://i2.hdslb.com/bfs/archive/dfc6af1cf076701a7ef25f3131d615a6c72040ac.jpg"
        list.add(panda492)

        val panda493 = PetVideo()
        panda493.type = VideoType.PANDA.ordinal
        panda493.fileName = "panda_baby_panda493"
        panda493.code = 1963
        panda493.duration = 73
        panda493.period = PeriodType.BABY.ordinal
        panda493.isStar = false
        panda493.title = "【大熊猫金宵】懵懵懂懂的妹妹"
        panda493.releaseTime = "2021-11-29 16:51:31"
        panda493.originalUrl = "https://www.bilibili.com/video/BV11P4y1V7dB"
        panda493.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda493.authorId = 5125945
        panda493.cover =
            "https://i0.hdslb.com/bfs/archive/21b4c15dd2cada59f030a4446425784a236228a8.png"
        list.add(panda493)

        val panda494 = PetVideo()
        panda494.type = VideoType.PANDA.ordinal
        panda494.fileName = "panda_baby_panda494"
        panda494.code = 1964
        panda494.duration = 20
        panda494.period = PeriodType.BABY.ordinal
        panda494.isStar = false
        panda494.title = "和花肉都duang起来了"
        panda494.releaseTime = "2022-03-07 19:15:14"
        panda494.originalUrl = "https://www.bilibili.com/video/BV14u411X74H"
        panda494.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda494.authorId = 1942411621
        panda494.cover =
            "https://i1.hdslb.com/bfs/archive/3afbd837040487c1575dae573faa09368bbc54c7.jpg"
        list.add(panda494)

        val panda495 = PetVideo()
        panda495.type = VideoType.PANDA.ordinal
        panda495.fileName = "panda_baby_panda495"
        panda495.code = 1965
        panda495.duration = 36
        panda495.period = PeriodType.BABY.ordinal
        panda495.isStar = false
        panda495.title = "大熊猫福多多：刀疤颂厉害了，把多多打下木架了"
        panda495.releaseTime = "2022-03-08 22:30:03"
        panda495.originalUrl = "https://www.bilibili.com/video/BV13a411b7zx"
        panda495.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda495.authorId = 98871951
        panda495.cover =
            "https://i0.hdslb.com/bfs/archive/4b7a7221d0ceba022a548adbeb32a1d2f8363483.jpg"
        list.add(panda495)

        val panda496 = PetVideo()
        panda496.type = VideoType.PANDA.ordinal
        panda496.fileName = "panda_baby_panda496"
        panda496.code = 1966
        panda496.duration = 31
        panda496.period = PeriodType.BABY.ordinal
        panda496.isStar = false
        panda496.title = "福多多真是一只娇憨的小熊"
        panda496.releaseTime = "2022-03-04 18:40:25"
        panda496.originalUrl = "https://www.bilibili.com/video/BV1aY411G7NC"
        panda496.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda496.authorId = 484657707
        panda496.cover =
            "https://i0.hdslb.com/bfs/archive/6e6546140455b370050b996bacbe1c2a908c258a.jpg"
        list.add(panda496)

        val panda497 = PetVideo()
        panda497.type = VideoType.PANDA.ordinal
        panda497.fileName = "panda_baby_panda497"
        panda497.code = 1967
        panda497.duration = 129
        panda497.period = PeriodType.BABY.ordinal
        panda497.isStar = true
        panda497.title = "么么儿学爬小树"
        panda497.releaseTime = "2017-02-11 15:39:35"
        panda497.originalUrl = "https://www.bilibili.com/video/BV1Ax41127Y2"
        panda497.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda497.authorId = 32407213
        panda497.cover =
            "https://i0.hdslb.com/bfs/archive/03ba10c13317d8cb3bba14e65fe0ad42a9f49778.jpg"
        list.add(panda497)

        val panda498 = PetVideo()
        panda498.type = VideoType.PANDA.ordinal
        panda498.fileName = "panda_baby_panda498"
        panda498.code = 1968
        panda498.duration = 76
        panda498.period = PeriodType.BABY.ordinal
        panda498.isStar = false
        panda498.title = "【大熊猫奇珍】崽崽，你长大了会当王！"
        panda498.releaseTime = "2022-01-11 18:45:04"
        panda498.originalUrl = "https://www.bilibili.com/video/BV14a411q7xD"
        panda498.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda498.authorId = 180602305
        panda498.cover =
            "https://i1.hdslb.com/bfs/archive/fcc3edbf6d56f4b6bc4d9525557e7a76db48c6b9.jpg"
        list.add(panda498)

        val panda499 = PetVideo()
        panda499.type = VideoType.PANDA.ordinal
        panda499.fileName = "panda_baby_panda499"
        panda499.code = 1969
        panda499.duration = 101
        panda499.period = PeriodType.BABY.ordinal
        panda499.isStar = false
        panda499.title = "【奇珍奇宝】lai妈安慰被凑弟弟欺负的姐姐熊！"
        panda499.releaseTime = "2022-01-17 20:20:58"
        panda499.originalUrl = "https://www.bilibili.com/video/BV1WL411c7bC"
        panda499.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda499.authorId = 180602305
        panda499.cover =
            "https://i2.hdslb.com/bfs/archive/3a6e8b9fb159239df21e139079e50518c600abf8.jpg"
        list.add(panda499)

        val panda500 = PetVideo()
        panda500.type = VideoType.PANDA.ordinal
        panda500.fileName = "panda_baby_panda500"
        panda500.code = 1970
        panda500.duration = 22
        panda500.period = PeriodType.BABY.ordinal
        panda500.isStar = false
        panda500.title = "成功摘下奇一，火腿奶爸露出收获的喜悦笑容"
        panda500.releaseTime = "2020-03-10 19:08:42"
        panda500.originalUrl = "https://www.bilibili.com/video/BV14E411T7hu"
        panda500.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda500.authorId = 39546503
        panda500.cover =
            "https://i2.hdslb.com/bfs/archive/e887e660af04e4b6a9dfd9fa13259f0b42e23174.jpg"
        list.add(panda500)

        val panda501 = PetVideo()
        panda501.type = VideoType.PANDA.ordinal
        panda501.fileName = "panda_baby_panda501"
        panda501.code = 1971
        panda501.duration = 17
        panda501.period = PeriodType.BABY.ordinal
        panda501.isStar = true
        panda501.title = "大熊猫奇一:你的小可爱突然出现"
        panda501.releaseTime = "2020-05-28 11:23:17"
        panda501.originalUrl = "https://www.bilibili.com/video/BV1Pp4y1X75x"
        panda501.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda501.authorId = 278306866
        panda501.cover =
            "https://i2.hdslb.com/bfs/archive/c4c52c6125ddd239cfb76fbaf84c953d5118289d.jpg"
        list.add(panda501)

        val panda502 = PetVideo()
        panda502.type = VideoType.PANDA.ordinal
        panda502.fileName = "panda_baby_panda502"
        panda502.code = 1972
        panda502.duration = 31
        panda502.period = PeriodType.BABY.ordinal
        panda502.isStar = true
        panda502.title = "【大熊猫】满场兔子跳的“奇一”宝宝"
        panda502.releaseTime = "2017-01-04 10:15:25"
        panda502.originalUrl = "https://www.bilibili.com/video/BV1ts411Y77d"
        panda502.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
        panda502.authorId = 10027533
        panda502.cover =
            "https://i2.hdslb.com/bfs/archive/4bf143e26b5289c0b5441ffaf207617a1feea0c7.png"
        list.add(panda502)

        return list
    }
}