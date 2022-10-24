package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetGroupPandaData3 {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {
        getPandaData()
        return list
    }

    private fun getPandaData() {

        val panda364 = PetVideo()
        panda364.type = VideoType.PANDA.ordinal
        panda364.fileName = "panda_group_panda364"
        panda364.code = 2276
        panda364.duration = 42
        panda364.period = PeriodType.GROUP.ordinal
        panda364.star = false
        panda364.title = "仰视斧头山女王润玥～"
        panda364.releaseTime = 1665711661
        panda364.originalUrl = "https://www.bilibili.com/video/BV1MP411E7rM"
        panda364.tags = "大熊猫,萌宠,动物圈"
        panda364.authorId = 484440897
        panda364.cover =
            "https://i1.hdslb.com/bfs/archive/c3a3a758d880431b3a9988b9fec1043a29e83ed6.jpg"
        list.add(panda364)

        val panda365 = PetVideo()
        panda365.type = VideoType.PANDA.ordinal
        panda365.fileName = "panda_group_panda365"
        panda365.code = 2277
        panda365.duration = 103
        panda365.period = PeriodType.GROUP.ordinal
        panda365.star = false
        panda365.title = "可怜虚弱无助的润玥被和叶推沟里了"
        panda365.releaseTime = 1666224000
        panda365.originalUrl = "https://www.bilibili.com/video/BV1MW4y1n7h5"
        panda365.tags = "大熊猫,萌宠,动物圈"
        panda365.authorId = 484440897
        panda365.cover =
            "https://i2.hdslb.com/bfs/archive/8caabfd9cf14c65070f8733c5fb31b6cbc45f491.jpg"
        list.add(panda365)

        val panda366 = PetVideo()
        panda366.type = VideoType.PANDA.ordinal
        panda366.fileName = "panda_group_panda366"
        panda366.code = 2278
        panda366.duration = 117
        panda366.period = PeriodType.GROUP.ordinal
        panda366.star = false
        panda366.title = "🌿小叶子来贴贴呀，一起睡告告！有人要和我们一起【睡懒觉】吗？😘"
        panda366.releaseTime = 1666134240
        panda366.originalUrl = "https://www.bilibili.com/video/BV1mV4y1V7AK"
        panda366.tags = "大熊猫,萌宠,动物圈"
        panda366.authorId = 16468440
        panda366.cover =
            "https://i0.hdslb.com/bfs/archive/e7e16d664a102fcc611cb9182608a6eb9930ea52.jpg"
        list.add(panda366)

        val panda367 = PetVideo()
        panda367.type = VideoType.PANDA.ordinal
        panda367.fileName = "panda_group_panda367"
        panda367.code = 2279
        panda367.duration = 70
        panda367.period = PeriodType.GROUP.ordinal
        panda367.star = false
        panda367.title = "大熊猫和花和叶-就要和迪迪贴贴！"
        panda367.releaseTime = 1666083788
        panda367.originalUrl = "https://www.bilibili.com/video/BV1114y1L7bD"
        panda367.tags = "大熊猫,萌宠,动物圈"
        panda367.authorId = 1307515
        panda367.cover =
            "https://i2.hdslb.com/bfs/archive/0104a385f0f70701428dd41a9f0ff903594d7a60.jpg"
        list.add(panda367)

        val panda368 = PetVideo()
        panda368.type = VideoType.PANDA.ordinal
        panda368.fileName = "panda_group_panda368"
        panda368.code = 2280
        panda368.duration = 84
        panda368.period = PeriodType.GROUP.ordinal
        panda368.star = false
        panda368.title = "这个两岁的宝宝会七十二变，把自己变成一岁的宝宝了🌺"
        panda368.releaseTime = 1665912421
        panda368.originalUrl = "https://www.bilibili.com/video/BV11G4y1n7JD"
        panda368.tags = "大熊猫,萌宠,动物圈"
        panda368.authorId = 1714028276
        panda368.cover =
            "https://i1.hdslb.com/bfs/archive/4f23bde84e8191e10bdd3b6f6c15ea380f3e0fef.jpg"
        list.add(panda368)

        val panda369 = PetVideo()
        panda369.type = VideoType.PANDA.ordinal
        panda369.fileName = "panda_group_panda369"
        panda369.code = 2281
        panda369.duration = 140
        panda369.period = PeriodType.GROUP.ordinal
        panda369.star = false
        panda369.title = "花花：和叶这块草地我标记了是我的地盘，我同意了你才能玩哈。                             和叶：姐姐你嗦撒子呢"
        panda369.releaseTime = 1665970599
        panda369.originalUrl = "https://www.bilibili.com/video/BV1uV4y157LW"
        panda369.tags = "大熊猫,萌宠,动物圈"
        panda369.authorId = 484440897
        panda369.cover =
            "https://i2.hdslb.com/bfs/archive/92ad0c79c3131a1db75af644e4b9b8151b16c6ec.jpg"
        list.add(panda369)

        val panda370 = PetVideo()
        panda370.type = VideoType.PANDA.ordinal
        panda370.fileName = "panda_group_panda370"
        panda370.code = 2282
        panda370.duration = 190
        panda370.period = PeriodType.GROUP.ordinal
        panda370.star = false
        panda370.title = "花宝叽吃竹子，好可爱哦～"
        panda370.releaseTime = 1665927409
        panda370.originalUrl = "https://www.bilibili.com/video/BV1Rd4y117oE"
        panda370.tags = "大熊猫,萌宠,动物圈"
        panda370.authorId = 230382720
        panda370.cover =
            "https://i2.hdslb.com/bfs/archive/47bd81679f03ce54d5250a648f077d95928ecf75.jpg"
        list.add(panda370)

        val panda371 = PetVideo()
        panda371.type = VideoType.PANDA.ordinal
        panda371.fileName = "panda_group_panda371"
        panda371.code = 2283
        panda371.duration = 121
        panda371.period = PeriodType.GROUP.ordinal
        panda371.star = false
        panda371.title = "这俩喜剧熊在一起就要互怼，和叶你是学你姐蒙脸吗😂"
        panda371.releaseTime = 1665937223
        panda371.originalUrl = "https://www.bilibili.com/video/BV1CV4y1V7e8"
        panda371.tags = "大熊猫,萌宠,动物圈"
        panda371.authorId = 1714028276
        panda371.cover =
            "https://i0.hdslb.com/bfs/archive/f2158307a88fbe5be32ab3fe7c82614c221579e1.jpg"
        list.add(panda371)

        val panda372 = PetVideo()
        panda372.type = VideoType.PANDA.ordinal
        panda372.fileName = "panda_group_panda372"
        panda372.code = 2284
        panda372.duration = 131
        panda372.period = PeriodType.GROUP.ordinal
        panda372.star = false
        panda372.title = "花花的迪拜式新吃法"
        panda372.releaseTime = 1665892062
        panda372.originalUrl = "https://www.bilibili.com/video/BV1c8411s7su"
        panda372.tags = "大熊猫,萌宠,动物圈"
        panda372.authorId = 1025949925
        panda372.cover =
            "https://i2.hdslb.com/bfs/archive/b2f8e9848a92fea04a6d4425812f46874d030f63.jpg"
        list.add(panda372)

        val panda373 = PetVideo()
        panda373.type = VideoType.PANDA.ordinal
        panda373.fileName = "panda_group_panda373"
        panda373.code = 2285
        panda373.duration = 95
        panda373.period = PeriodType.GROUP.ordinal
        panda373.star = false
        panda373.title = "大熊猫花花的起床规律，只要是没睡醒就会一连串哈欠"
        panda373.releaseTime = 1665882042
        panda373.originalUrl = "https://www.bilibili.com/video/BV1DG411j777"
        panda373.tags = "大熊猫,萌宠,动物圈"
        panda373.authorId = 1714028276
        panda373.cover =
            "https://i1.hdslb.com/bfs/archive/9b65bcd20feb18415aeb73b77826c967ccfe0ff7.jpg"
        list.add(panda373)

        val panda374 = PetVideo()
        panda374.type = VideoType.PANDA.ordinal
        panda374.fileName = "panda_group_panda374"
        panda374.code = 2286
        panda374.duration = 79
        panda374.period = PeriodType.GROUP.ordinal
        panda374.star = false
        panda374.title = "两姐弟背靠着一起吃笋，最萌差距"
        panda374.releaseTime = 1665854188
        panda374.originalUrl = "https://www.bilibili.com/video/BV1cG41177ra"
        panda374.tags = "大熊猫,萌宠,动物圈"
        panda374.authorId = 1714028276
        panda374.cover =
            "https://i1.hdslb.com/bfs/archive/5aef45153ff80ff0f998d0de1fdf390e138928bb.jpg"
        list.add(panda374)

        val panda375 = PetVideo()
        panda375.type = VideoType.PANDA.ordinal
        panda375.fileName = "panda_group_panda375"
        panda375.code = 2287
        panda375.duration = 21
        panda375.period = PeriodType.GROUP.ordinal
        panda375.star = false
        panda375.title = "钓猫的时候，把我们润玥急的就差开口说话了！"
        panda375.releaseTime = 1665717815
        panda375.originalUrl = "https://www.bilibili.com/video/BV1gN4y1w7dj"
        panda375.tags = "大熊猫,萌宠,动物圈"
        panda375.authorId = 2009586822
        panda375.cover =
            "https://i0.hdslb.com/bfs/archive/2ea85fd94cb1d3536a338271badf146a469b39c3.jpg"
        list.add(panda375)

        val panda376 = PetVideo()
        panda376.type = VideoType.PANDA.ordinal
        panda376.fileName = "panda_group_panda376"
        panda376.code = 2288
        panda376.duration = 58
        panda376.period = PeriodType.GROUP.ordinal
        panda376.star = false
        panda376.title = "这只大熊猫为什么有喜剧效果  ( 和叶,润玥)"
        panda376.releaseTime = 1665745200
        panda376.originalUrl = "https://www.bilibili.com/video/BV1114y177NS"
        panda376.tags = "大熊猫,萌宠,动物圈"
        panda376.authorId = 327377672
        panda376.cover =
            "https://i0.hdslb.com/bfs/archive/4fb4d9338bbb76a150f8c433ea7b53af471d16d3.jpg"
        list.add(panda376)

        val panda377 = PetVideo()
        panda377.type = VideoType.PANDA.ordinal
        panda377.fileName = "panda_group_panda377"
        panda377.code = 2289
        panda377.duration = 151
        panda377.period = PeriodType.GROUP.ordinal
        panda377.star = false
        panda377.title = "润玥的收费项目"
        panda377.releaseTime = 1665631531
        panda377.originalUrl = "https://www.bilibili.com/video/BV1dm4y1A7Mo"
        panda377.tags = "大熊猫,萌宠,动物圈"
        panda377.authorId = 1025949925
        panda377.cover =
            "https://i1.hdslb.com/bfs/archive/f3c17fbbdf2cb1e3b0e163023931ac0384867028.jpg"
        list.add(panda377)

        val panda378 = PetVideo()
        panda378.type = VideoType.PANDA.ordinal
        panda378.fileName = "panda_group_panda378"
        panda378.code = 2290
        panda378.duration = 12
        panda378.period = PeriodType.GROUP.ordinal
        panda378.star = false
        panda378.title = "有点看不清，上面的是艾玖还是润月？"
        panda378.releaseTime = 1665403604
        panda378.originalUrl = "https://www.bilibili.com/video/BV1FG4y1p78t"
        panda378.tags = "大熊猫,萌宠,动物圈"
        panda378.authorId = 1170961381
        panda378.cover =
            "https://i0.hdslb.com/bfs/archive/c5e7fc2f63476b69f63670689934222fa5fdc901.jpg"
        list.add(panda378)

        val panda379 = PetVideo()
        panda379.type = VideoType.PANDA.ordinal
        panda379.fileName = "panda_group_panda379"
        panda379.code = 2291
        panda379.duration = 77
        panda379.period = PeriodType.GROUP.ordinal
        panda379.star = false
        panda379.title = "熊中哈士奇"
        panda379.releaseTime = 1665371832
        panda379.originalUrl = "https://www.bilibili.com/video/BV1Dd4y1i7JS"
        panda379.tags = "大熊猫,萌宠,动物圈"
        panda379.authorId = 1025949925
        panda379.cover =
            "https://i1.hdslb.com/bfs/archive/b5e32c0b48c56fa19b3f70017eee74a4e916eab1.jpg"
        list.add(panda379)

        val panda380 = PetVideo()
        panda380.type = VideoType.PANDA.ordinal
        panda380.fileName = "panda_group_panda380"
        panda380.code = 2292
        panda380.duration = 15
        panda380.period = PeriodType.GROUP.ordinal
        panda380.star = false
        panda380.title = "原来大熊猫润玥是人类扮演的！"
        panda380.releaseTime = 1665375796
        panda380.originalUrl = "https://www.bilibili.com/video/BV1qd4y1i7Rn"
        panda380.tags = "大熊猫,萌宠,动物圈"
        panda380.authorId = 2037312510
        panda380.cover =
            "https://i2.hdslb.com/bfs/archive/078bfc4b6152e04c2d31fac99a4a5e3ffbfb058e.jpg"
        list.add(panda380)

        val panda381 = PetVideo()
        panda381.type = VideoType.PANDA.ordinal
        panda381.fileName = "panda_group_panda381"
        panda381.code = 2293
        panda381.duration = 11
        panda381.period = PeriodType.GROUP.ordinal
        panda381.star = false
        panda381.title = "🤪emmmmm……【大熊猫和叶】"
        panda381.releaseTime = 1665573952
        panda381.originalUrl = "https://www.bilibili.com/video/BV14W4y1J7ik"
        panda381.tags = "大熊猫,萌宠,动物圈"
        panda381.authorId = 16468440
        panda381.cover =
            "https://i2.hdslb.com/bfs/archive/89467a10bf2a1839c5fb9011c2778da0045a1145.jpg"
        list.add(panda381)

        val panda382 = PetVideo()
        panda382.type = VideoType.PANDA.ordinal
        panda382.fileName = "panda_group_panda382"
        panda382.code = 2294
        panda382.duration = 83
        panda382.period = PeriodType.GROUP.ordinal
        panda382.star = false
        panda382.title = "花花终于报了上次“一卷之仇”!【大熊猫和花 润玥】"
        panda382.releaseTime = 1665533880
        panda382.originalUrl = "https://www.bilibili.com/video/BV1zP41177TM"
        panda382.tags = "大熊猫,萌宠,动物圈"
        panda382.authorId = 16468440
        panda382.cover =
            "https://i0.hdslb.com/bfs/archive/4f3e387027b47ee50becce71ad4e4e85eac8ee12.jpg"
        list.add(panda382)

        val panda383 = PetVideo()
        panda383.type = VideoType.PANDA.ordinal
        panda383.fileName = "panda_group_panda383"
        panda383.code = 2295
        panda383.duration = 118
        panda383.period = PeriodType.GROUP.ordinal
        panda383.star = false
        panda383.title = "比起竹子笋笋小苹果，花花还是更喜欢谭爷爷！【大熊猫和花】"
        panda383.releaseTime = 1651653968
        panda383.originalUrl = "https://www.bilibili.com/video/BV18v4y1K76R"
        panda383.tags = "大熊猫,萌宠,动物圈"
        panda383.authorId = 16468440
        panda383.cover =
            "https://i0.hdslb.com/bfs/archive/0fc7c51f8639c5f290fc8e80f49632e7b7bb9824.jpg"
        list.add(panda383)

        val panda384 = PetVideo()
        panda384.type = VideoType.PANDA.ordinal
        panda384.fileName = "panda_group_panda384"
        panda384.code = 2296
        panda384.duration = 94
        panda384.period = PeriodType.GROUP.ordinal
        panda384.star = false
        panda384.title = "大熊猫韵文韵武姐弟俩每天下班前都要操练一番"
        panda384.releaseTime = 1665378742
        panda384.originalUrl = "https://www.bilibili.com/video/BV1jW4y1H7Q2"
        panda384.tags = "大熊猫,萌宠,动物圈"
        panda384.authorId = 1425086760
        panda384.cover =
            "https://i0.hdslb.com/bfs/archive/46204888405804584b50deb5b04679c3eefa3928.jpg"
        list.add(panda384)

        val panda385 = PetVideo()
        panda385.type = VideoType.PANDA.ordinal
        panda385.fileName = "panda_group_panda385"
        panda385.code = 2297
        panda385.duration = 81
        panda385.period = PeriodType.GROUP.ordinal
        panda385.star = false
        panda385.title = "八卦花花在线要笋"
        panda385.releaseTime = 1665360000
        panda385.originalUrl = "https://www.bilibili.com/video/BV1UN4y1A7K8"
        panda385.tags = "大熊猫,萌宠,动物圈"
        panda385.authorId = 484440897
        panda385.cover =
            "https://i2.hdslb.com/bfs/archive/ca0afef63bca4da76fe9a9111f593d8adc796130.jpg"
        list.add(panda385)

        val panda386 = PetVideo()
        panda386.type = VideoType.PANDA.ordinal
        panda386.fileName = "panda_group_panda386"
        panda386.code = 2298
        panda386.duration = 68
        panda386.period = PeriodType.GROUP.ordinal
        panda386.star = false
        panda386.title = "花花乖巧坐着打理毛发，是爱漂亮的小公仔！【大熊猫和花】"
        panda386.releaseTime = 1654872715
        panda386.originalUrl = "https://www.bilibili.com/video/BV1jZ4y1q7pF"
        panda386.tags = "大熊猫,萌宠,动物圈"
        panda386.authorId = 627116323
        panda386.cover =
            "https://i1.hdslb.com/bfs/archive/d5067a260a4d8ef5d1762fc9d28e136782b968c0.jpg"
        list.add(panda386)

        val panda387 = PetVideo()
        panda387.type = VideoType.PANDA.ordinal
        panda387.fileName = "panda_group_panda387"
        panda387.code = 2299
        panda387.duration = 19
        panda387.period = PeriodType.GROUP.ordinal
        panda387.star = false
        panda387.title = "重阳话唠，边吃饭边和大家唠嗑"
        panda387.releaseTime = 1665048890
        panda387.originalUrl = "https://www.bilibili.com/video/BV1Qe4y1i7mh"
        panda387.tags = "大熊猫,萌宠,动物圈"
        panda387.authorId = 2037312510
        panda387.cover =
            "https://i2.hdslb.com/bfs/archive/edd0e4534085c1c1a50c2ac80d2fb43ea884f105.jpg"
        list.add(panda387)

        val panda388 = PetVideo()
        panda388.type = VideoType.PANDA.ordinal
        panda388.fileName = "panda_group_panda388"
        panda388.code = 2300
        panda388.duration = 157
        panda388.period = PeriodType.GROUP.ordinal
        panda388.star = false
        panda388.title = "这只熊猫有点慢性子"
        panda388.releaseTime = 1665285105
        panda388.originalUrl = "https://www.bilibili.com/video/BV1wK411Q7mt"
        panda388.tags = "大熊猫,萌宠,动物圈"
        panda388.authorId = 1025949925
        panda388.cover =
            "https://i1.hdslb.com/bfs/archive/3cdb47ef3015998cbc8410e26e6620d43ca9c018.jpg"
        list.add(panda388)

        val panda389 = PetVideo()
        panda389.type = VideoType.PANDA.ordinal
        panda389.fileName = "panda_group_panda389"
        panda389.code = 2301
        panda389.duration = 160
        panda389.period = PeriodType.GROUP.ordinal
        panda389.star = false
        panda389.title = "雪宝上树给芊金送竹子，递了好几次芊金都不接，只能自己吃了"
        panda389.releaseTime = 1571058432
        panda389.originalUrl = "https://www.bilibili.com/video/BV1XE411d7fU"
        panda389.tags = "大熊猫,萌宠,动物圈"
        panda389.authorId = 25978644
        panda389.cover =
            "https://i0.hdslb.com/bfs/archive/d4f74b9b387fa3d9dceff7ca886a2740f3a58dee.jpg"
        list.add(panda389)

        val panda390 = PetVideo()
        panda390.type = VideoType.PANDA.ordinal
        panda390.fileName = "panda_group_panda390"
        panda390.code = 2302
        panda390.duration = 61
        panda390.period = PeriodType.GROUP.ordinal
        panda390.star = false
        panda390.title = "【大熊猫雪宝】大头宝和脑婆的幸福生活"
        panda390.releaseTime = 1584860436
        panda390.originalUrl = "https://www.bilibili.com/video/BV15E411w7zQ"
        panda390.tags = "大熊猫,萌宠,动物圈"
        panda390.authorId = 25978644
        panda390.cover =
            "https://i1.hdslb.com/bfs/archive/e1efe307a6614ecf47553a613703d8ea129ebb8b.jpg"
        list.add(panda390)

        val panda391 = PetVideo()
        panda391.type = VideoType.PANDA.ordinal
        panda391.fileName = "panda_group_panda391"
        panda391.code = 2303
        panda391.duration = 83
        panda391.period = PeriodType.GROUP.ordinal
        panda391.star = false
        panda391.title = "【大熊猫和花】花花每吃到一个窝头，谭爷爷就要叹一次气……"
        panda391.releaseTime = 1665143573
        panda391.originalUrl = "https://www.bilibili.com/video/BV1Y24y197nt"
        panda391.tags = "大熊猫,萌宠,动物圈"
        panda391.authorId = 444796647
        panda391.cover =
            "https://i2.hdslb.com/bfs/archive/267eaeecdacf63d796a5381dd08a44567a3f7153.jpg"
        list.add(panda391)

        val panda392 = PetVideo()
        panda392.type = VideoType.PANDA.ordinal
        panda392.fileName = "panda_group_panda392"
        panda392.code = 2304
        panda392.duration = 218
        panda392.period = PeriodType.GROUP.ordinal
        panda392.star = false
        panda392.title = "和花：弟弟，注意表情管理，那么多两脚兽在拍照喔"
        panda392.releaseTime = 1665211548
        panda392.originalUrl = "https://www.bilibili.com/video/BV1je4y1n78X"
        panda392.tags = "大熊猫,萌宠,动物圈"
        panda392.authorId = 230382720
        panda392.cover =
            "https://i1.hdslb.com/bfs/archive/239fffba1f20a7e3918df09ec36d8ffca3502289.jpg"
        list.add(panda392)

        val panda393 = PetVideo()
        panda393.type = VideoType.PANDA.ordinal
        panda393.fileName = "panda_group_panda393"
        panda393.code = 2305
        panda393.duration = 265
        panda393.period = PeriodType.GROUP.ordinal
        panda393.star = false
        panda393.title = "花落番外篇-找花花"
        panda393.releaseTime = 1664456323
        panda393.originalUrl = "https://www.bilibili.com/video/BV12N4y1P7np"
        panda393.tags = "大熊猫,萌宠,动物圈"
        panda393.authorId = 335419800
        panda393.cover =
            "https://i1.hdslb.com/bfs/archive/114ac291ff5c214aedec35601935e9a7cdb1fde2.jpg"
        list.add(panda393)

        val panda394 = PetVideo()
        panda394.type = VideoType.PANDA.ordinal
        panda394.fileName = "panda_group_panda394"
        panda394.code = 2306
        panda394.duration = 62
        panda394.period = PeriodType.GROUP.ordinal
        panda394.star = false
        panda394.title = "花花好久没出现啦，好想好想你！"
        panda394.releaseTime = 1664960700
        panda394.originalUrl = "https://www.bilibili.com/video/BV1uD4y127UN"
        panda394.tags = "大熊猫,萌宠,动物圈"
        panda394.authorId = 21330840
        panda394.cover =
            "https://i2.hdslb.com/bfs/archive/84e98b2b9266f97ec1df71c9a0f68e81e8c8df07.jpg"
        list.add(panda394)

        val panda395 = PetVideo()
        panda395.type = VideoType.PANDA.ordinal
        panda395.fileName = "panda_group_panda395"
        panda395.code = 2307
        panda395.duration = 100
        panda395.period = PeriodType.GROUP.ordinal
        panda395.star = false
        panda395.title = "游客：好胖哦！短胖炸毛滴和花！花花：有本事再说一遍…"
        panda395.releaseTime = 1665146099
        panda395.originalUrl = "https://www.bilibili.com/video/BV1d8411x7bz"
        panda395.tags = "大熊猫,萌宠,动物圈"
        panda395.authorId = 34677299
        panda395.cover =
            "https://i2.hdslb.com/bfs/archive/0d2298cecdad4df9842f006661762887126e65ab.jpg"
        list.add(panda395)

        val panda396 = PetVideo()
        panda396.type = VideoType.PANDA.ordinal
        panda396.fileName = "panda_group_panda396"
        panda396.code = 2308
        panda396.duration = 89
        panda396.period = PeriodType.GROUP.ordinal
        panda396.star = false
        panda396.title = "花花 又又又 卡 牙 啦 !  趴在草丛里躲着抠，抠不出来好难受呀!😂"
        panda396.releaseTime = 1665118680
        panda396.originalUrl = "https://www.bilibili.com/video/BV1Lt4y1c7EC"
        panda396.tags = "大熊猫,萌宠,动物圈"
        panda396.authorId = 16468440
        panda396.cover =
            "https://i2.hdslb.com/bfs/archive/f2459b4bed58606a1d901f571771ec8bd69cd7f8.jpg"
        list.add(panda396)

        val panda397 = PetVideo()
        panda397.type = VideoType.PANDA.ordinal
        panda397.fileName = "panda_group_panda397"
        panda397.code = 2309
        panda397.duration = 163
        panda397.period = PeriodType.GROUP.ordinal
        panda397.star = false
        panda397.title = "我们是亲亲的姐弟：花花要和弟弟贴贴，和叶摸摸姐姐的头，摸摸姐姐的肩，还把下巴枕在花花的头上!💕"
        panda397.releaseTime = 1664974500
        panda397.originalUrl = "https://www.bilibili.com/video/BV1ge4y1n77w"
        panda397.tags = "大熊猫,萌宠,动物圈"
        panda397.authorId = 16468440
        panda397.cover =
            "https://i0.hdslb.com/bfs/archive/989f4e0bcbe91dfddf20878c3a997a40e289481e.jpg"
        list.add(panda397)

        val panda398 = PetVideo()
        panda398.type = VideoType.PANDA.ordinal
        panda398.fileName = "panda_group_panda398"
        panda398.code = 2310
        panda398.duration = 15
        panda398.period = PeriodType.GROUP.ordinal
        panda398.star = false
        panda398.title = "花花跟弟弟的感情有多好"
        panda398.releaseTime = 1665026094
        panda398.originalUrl = "https://www.bilibili.com/video/BV1FP41177sa"
        panda398.tags = "大熊猫,萌宠,动物圈"
        panda398.authorId = 1025949925
        panda398.cover =
            "https://i1.hdslb.com/bfs/archive/2a8870bd9a1d035042f15d9f4989bef7b37a3922.jpg"
        list.add(panda398)

        val panda399 = PetVideo()
        panda399.type = VideoType.PANDA.ordinal
        panda399.fileName = "panda_group_panda399"
        panda399.code = 2311
        panda399.duration = 127
        panda399.period = PeriodType.GROUP.ordinal
        panda399.star = false
        panda399.title = "二狗不愧是二狗，这些迷惑行为没熊干得出来！"
        panda399.releaseTime = 1657951800
        panda399.originalUrl = "https://www.bilibili.com/video/BV1EW4y1S7jU"
        panda399.tags = "大熊猫,萌宠,动物圈"
        panda399.authorId = 12444306
        panda399.cover =
            "https://i0.hdslb.com/bfs/archive/07b7285c179e910cf2f77b4703940648b0f04fd1.jpg"
        list.add(panda399)

        val panda400 = PetVideo()
        panda400.type = VideoType.PANDA.ordinal
        panda400.fileName = "panda_group_panda400"
        panda400.code = 2312
        panda400.duration = 86
        panda400.period = PeriodType.GROUP.ordinal
        panda400.star = false
        panda400.title = "【兰家崽】兰虫虫今天打架打赢了，睡觉都在笑！"
        panda400.releaseTime = 1664943795
        panda400.originalUrl = "https://www.bilibili.com/video/BV1rV4y157Gw"
        panda400.tags = "大熊猫,萌宠,动物圈"
        panda400.authorId = 180602305
        panda400.cover =
            "https://i0.hdslb.com/bfs/archive/91655e22c97cd79c35b3724301388baa3e9d6e56.jpg"
        list.add(panda400)

        val panda401 = PetVideo()
        panda401.type = VideoType.PANDA.ordinal
        panda401.fileName = "panda_group_panda401"
        panda401.code = 2313
        panda401.duration = 152
        panda401.period = PeriodType.GROUP.ordinal
        panda401.star = false
        panda401.title = "会藏食物的熊猫"
        panda401.releaseTime = 1664939947
        panda401.originalUrl = "https://www.bilibili.com/video/BV1Me4y167Qk"
        panda401.tags = "大熊猫,萌宠,动物圈"
        panda401.authorId = 1025949925
        panda401.cover =
            "https://i2.hdslb.com/bfs/archive/2779a2b516f6fbf5a57cc699a0f6e06bc70bad08.jpg"
        list.add(panda401)

        val panda402 = PetVideo()
        panda402.type = VideoType.PANDA.ordinal
        panda402.fileName = "panda_group_panda402"
        panda402.code = 2314
        panda402.duration = 77
        panda402.period = PeriodType.GROUP.ordinal
        panda402.star = false
        panda402.title = "【大熊猫和花和叶】花花闻了闻，确定就是弟弟的大宝座，可厉害了"
        panda402.releaseTime = 1664492400
        panda402.originalUrl = "https://www.bilibili.com/video/BV1ue4y1B7cf"
        panda402.tags = "大熊猫,萌宠,动物圈"
        panda402.authorId = 484440897
        panda402.cover =
            "https://i0.hdslb.com/bfs/archive/5ec54a8fd221ffdbf3d16a260b45dcc42674fccb.jpg"
        list.add(panda402)

        val panda403 = PetVideo()
        panda403.type = VideoType.PANDA.ordinal
        panda403.fileName = "panda_group_panda403"
        panda403.code = 2315
        panda403.duration = 68
        panda403.period = PeriodType.GROUP.ordinal
        panda403.star = false
        panda403.title = "【大熊猫和花】花花挠耳朵好可爱丫，瞧把小朋友乐得哈哈大笑"
        panda403.releaseTime = 1663146000
        panda403.originalUrl = "https://www.bilibili.com/video/BV1KY4y1T7wm"
        panda403.tags = "大熊猫,萌宠,动物圈"
        panda403.authorId = 1383841530
        panda403.cover =
            "https://i0.hdslb.com/bfs/archive/f219e2b0eeb68364909f9bbb90fab12e92f1233f.jpg"
        list.add(panda403)

        val panda404 = PetVideo()
        panda404.type = VideoType.PANDA.ordinal
        panda404.fileName = "panda_group_panda404"
        panda404.code = 2316
        panda404.duration = 8
        panda404.period = PeriodType.GROUP.ordinal
        panda404.star = false
        panda404.title = "胖崽你叫谁？！"
        panda404.releaseTime = 1664689688
        panda404.originalUrl = "https://www.bilibili.com/video/BV1cD4y1y7bP"
        panda404.tags = "大熊猫,萌宠,动物圈"
        panda404.authorId = 1198136200
        panda404.cover =
            "https://i0.hdslb.com/bfs/archive/05154affa3a489c5c4bc284fbe91f2180c5b2469.jpg"
        list.add(panda404)

        val panda405 = PetVideo()
        panda405.type = VideoType.PANDA.ordinal
        panda405.fileName = "panda_group_panda405"
        panda405.code = 2317
        panda405.duration = 18
        panda405.period = PeriodType.GROUP.ordinal
        panda405.star = false
        panda405.title = "和花居然是双眼皮"
        panda405.releaseTime = 1664866523
        panda405.originalUrl = "https://www.bilibili.com/video/BV1Rt4y1F78r"
        panda405.tags = "大熊猫,萌宠,动物圈"
        panda405.authorId = 484657707
        panda405.cover =
            "https://i1.hdslb.com/bfs/archive/2218ee963b2889b779cad686bb2e8f742abb8381.jpg"
        list.add(panda405)

        val panda406 = PetVideo()
        panda406.type = VideoType.PANDA.ordinal
        panda406.fileName = "panda_group_panda406"
        panda406.code = 2318
        panda406.duration = 161
        panda406.period = PeriodType.GROUP.ordinal
        panda406.star = false
        panda406.title = "【20221001】润玥自觉锻炼下肢力量，眼巴巴的守了好久，这不得多奖励几个窝头苹果啊"
        panda406.releaseTime = 1664751600
        panda406.originalUrl = "https://www.bilibili.com/video/BV1LG411n7Xa"
        panda406.tags = "大熊猫,萌宠,动物圈"
        panda406.authorId = 484440897
        panda406.cover =
            "https://i2.hdslb.com/bfs/archive/d1907ba139dd26d049d668bed488b3778dbcd3a4.jpg"
        list.add(panda406)

        val panda407 = PetVideo()
        panda407.type = VideoType.PANDA.ordinal
        panda407.fileName = "panda_group_panda407"
        panda407.code = 2319
        panda407.duration = 11
        panda407.period = PeriodType.GROUP.ordinal
        panda407.star = false
        panda407.title = "花花答应爷爷，小奶音太可爱啦！"
        panda407.releaseTime = 1664796313
        panda407.originalUrl = "https://www.bilibili.com/video/BV1y14y187ur"
        panda407.tags = "大熊猫,萌宠,动物圈"
        panda407.authorId = 2037312510
        panda407.cover =
            "https://i0.hdslb.com/bfs/archive/31bde56eb38375953d57a71b0412becc57270b8b.jpg"
        list.add(panda407)

        val panda408 = PetVideo()
        panda408.type = VideoType.PANDA.ordinal
        panda408.fileName = "panda_group_panda408"
        panda408.code = 2320
        panda408.duration = 105
        panda408.period = PeriodType.GROUP.ordinal
        panda408.star = false
        panda408.title = "【大熊猫和花】花花上一秒还对木头君凶凶，下一秒就和他贴贴，真是个可爱的小公举。"
        panda408.releaseTime = 1664717594
        panda408.originalUrl = "https://www.bilibili.com/video/BV1Ye4y1J7AR"
        panda408.tags = "大熊猫,萌宠,动物圈"
        panda408.authorId = 542836361
        panda408.cover =
            "https://i2.hdslb.com/bfs/archive/dd4184d8931302d73beb14eb4fc925b5d6f16bf0.jpg"
        list.add(panda408)

        val panda409 = PetVideo()
        panda409.type = VideoType.PANDA.ordinal
        panda409.fileName = "panda_group_panda409"
        panda409.code = 2321
        panda409.duration = 124
        panda409.period = PeriodType.GROUP.ordinal
        panda409.star = false
        panda409.title = "和花：亲爱的弟弟，你的舌头会不会抽筋呀？明天我可以帮你吃掉窝头，这样你就不会粘牙了！和叶：那到不必"
        panda409.releaseTime = 1664715590
        panda409.originalUrl = "https://www.bilibili.com/video/BV1fD4y1C7V1"
        panda409.tags = "大熊猫,萌宠,动物圈"
        panda409.authorId = 230382720
        panda409.cover =
            "https://i0.hdslb.com/bfs/archive/09c13b5ee3fe2589f3bcc72c5a7764c279581898.jpg"
        list.add(panda409)

        val panda410 = PetVideo()
        panda410.type = VideoType.PANDA.ordinal
        panda410.fileName = "panda_group_panda410"
        panda410.code = 2322
        panda410.duration = 76
        panda410.period = PeriodType.GROUP.ordinal
        panda410.star = false
        panda410.title = "和叶的杂技表演，下届体育冠军就非他莫属了"
        panda410.releaseTime = 1664617867
        panda410.originalUrl = "https://www.bilibili.com/video/BV1614y1a7XK"
        panda410.tags = "大熊猫,萌宠,动物圈"
        panda410.authorId = 1714028276
        panda410.cover =
            "https://i0.hdslb.com/bfs/archive/19994c727f880378be5c5729629f3900ca744484.jpg"
        list.add(panda410)

        val panda411 = PetVideo()
        panda411.type = VideoType.PANDA.ordinal
        panda411.fileName = "panda_group_panda411"
        panda411.code = 2323
        panda411.duration = 13
        panda411.period = PeriodType.GROUP.ordinal
        panda411.star = false
        panda411.title = "花花：今天又是不想上班的一天！"
        panda411.releaseTime = 1664686149
        panda411.originalUrl = "https://www.bilibili.com/video/BV1mR4y1d74a"
        panda411.tags = "大熊猫,萌宠,动物圈"
        panda411.authorId = 2037312510
        panda411.cover =
            "https://i0.hdslb.com/bfs/archive/d53cc64f9691cd81d1babe9da0a8156bd2745848.jpg"
        list.add(panda411)

        val panda412 = PetVideo()
        panda412.type = VideoType.PANDA.ordinal
        panda412.fileName = "panda_group_panda412"
        panda412.code = 2324
        panda412.duration = 43
        panda412.period = PeriodType.GROUP.ordinal
        panda412.star = false
        panda412.title = "和叶吃窝头叕卡牙了。二狗走熊表示“憨到没眼看”！【大熊猫和叶、润玥】"
        panda412.releaseTime = 1664632654
        panda412.originalUrl = "https://www.bilibili.com/video/BV14e411T7Nk"
        panda412.tags = "大熊猫,萌宠,动物圈"
        panda412.authorId = 514531996
        panda412.cover =
            "https://i2.hdslb.com/bfs/archive/6a16ced502d9f0e6c22c7de665f4e0f627df23d3.jpg"
        list.add(panda412)

        val panda413 = PetVideo()
        panda413.type = VideoType.PANDA.ordinal
        panda413.fileName = "panda_group_panda413"
        panda413.code = 2325
        panda413.duration = 102
        panda413.period = PeriodType.GROUP.ordinal
        panda413.star = false
        panda413.title = "熊猫从树上掉下来的机率有多大"
        panda413.releaseTime = 1664594409
        panda413.originalUrl = "https://www.bilibili.com/video/BV1Le411T7bz"
        panda413.tags = "大熊猫,萌宠,动物圈"
        panda413.authorId = 1025949925
        panda413.cover =
            "https://i2.hdslb.com/bfs/archive/322987313e521704ea3098901c2bb79ba6dc4f98.jpg"
        list.add(panda413)

        val panda414 = PetVideo()
        panda414.type = VideoType.PANDA.ordinal
        panda414.fileName = "panda_group_panda414"
        panda414.code = 2326
        panda414.duration = 114
        panda414.period = PeriodType.GROUP.ordinal
        panda414.star = false
        panda414.title = "爷爷给花花开特训班，花花小短腿站站跪跪自带萌点，苹果没吃完爷爷怎么就走了？"
        panda414.releaseTime = 1648514100
        panda414.originalUrl = "https://www.bilibili.com/video/BV1xY4y1p7no"
        panda414.tags = "大熊猫,萌宠,动物圈"
        panda414.authorId = 19715714
        panda414.cover =
            "https://i0.hdslb.com/bfs/archive/70bd3cc0af42325de14fe009e50a4ee6b96fba91.jpg"
        list.add(panda414)

        val panda415 = PetVideo()
        panda415.type = VideoType.PANDA.ordinal
        panda415.fileName = "panda_group_panda415"
        panda415.code = 2327
        panda415.duration = 77
        panda415.period = PeriodType.GROUP.ordinal
        panda415.star = false
        panda415.title = "看花宝子下木架（大熊猫和花）"
        panda415.releaseTime = 1664540824
        panda415.originalUrl = "https://www.bilibili.com/video/BV1fB4y17781"
        panda415.tags = "大熊猫,萌宠,动物圈"
        panda415.authorId = 2137796700
        panda415.cover =
            "https://i2.hdslb.com/bfs/archive/1bcd2b843b41425652e9282f1ea0131437db3948.jpg"
        list.add(panda415)

        val panda416 = PetVideo()
        panda416.type = VideoType.PANDA.ordinal
        panda416.fileName = "panda_group_panda416"
        panda416.code = 2328
        panda416.duration = 133
        panda416.period = PeriodType.GROUP.ordinal
        panda416.star = false
        panda416.title = "香果的翻滚避暑法"
        panda416.releaseTime = 1664528520
        panda416.originalUrl = "https://www.bilibili.com/video/BV1hd4y167ag"
        panda416.tags = "大熊猫,萌宠,动物圈"
        panda416.authorId = 551961363
        panda416.cover =
            "https://i1.hdslb.com/bfs/archive/3d96656f65a2016a7ca080ca4faa0ef368d0e990.jpg"
        list.add(panda416)

        val panda417 = PetVideo()
        panda417.type = VideoType.PANDA.ordinal
        panda417.fileName = "panda_group_panda417"
        panda417.code = 2329
        panda417.duration = 15
        panda417.period = PeriodType.GROUP.ordinal
        panda417.star = false
        panda417.title = "两姐弟背靠背，要暖啦！"
        panda417.releaseTime = 1664537213
        panda417.originalUrl = "https://www.bilibili.com/video/BV1eG411J72W"
        panda417.tags = "大熊猫,萌宠,动物圈"
        panda417.authorId = 2037312510
        panda417.cover =
            "https://i2.hdslb.com/bfs/archive/b033c87da9d27752431c7487d2554cfee3983a6d.jpg"
        list.add(panda417)

        val panda418 = PetVideo()
        panda418.type = VideoType.PANDA.ordinal
        panda418.fileName = "panda_group_panda418"
        panda418.code = 2330
        panda418.duration = 206
        panda418.period = PeriodType.GROUP.ordinal
        panda418.star = false
        panda418.title = "润玥：来一起抠抠掏掏，一起休息，晚安!【大熊猫润玥】"
        panda418.releaseTime = 1664555177
        panda418.originalUrl = "https://www.bilibili.com/video/BV1ZR4y1R7bZ"
        panda418.tags = "大熊猫,萌宠,动物圈"
        panda418.authorId = 16468440
        panda418.cover =
            "https://i0.hdslb.com/bfs/archive/7f4128dd24764d66be57e5c266a6ba3fdc869840.jpg"
        list.add(panda418)

        val panda419 = PetVideo()
        panda419.type = VideoType.PANDA.ordinal
        panda419.fileName = "panda_group_panda419"
        panda419.code = 2331
        panda419.duration = 85
        panda419.period = PeriodType.GROUP.ordinal
        panda419.star = false
        panda419.title = "花宝叽背靠木桩掏兜兜，左掏掏，右掏掏，撒也没有!😜"
        panda419.releaseTime = 1664548819
        panda419.originalUrl = "https://www.bilibili.com/video/BV12e4y1r7wE"
        panda419.tags = "大熊猫,萌宠,动物圈"
        panda419.authorId = 16468440
        panda419.cover =
            "https://i0.hdslb.com/bfs/archive/153cf390bf73a3f852d521674a661b8978bc2b10.jpg"
        list.add(panda419)

        val panda420 = PetVideo()
        panda420.type = VideoType.PANDA.ordinal
        panda420.fileName = "panda_group_panda420"
        panda420.code = 2332
        panda420.duration = 350
        panda420.period = PeriodType.GROUP.ordinal
        panda420.star = false
        panda420.title = "艾玖玖也来吸花了，花花身上是不是奶香奶香的呀？!【大熊猫和花 艾玖】"
        panda420.releaseTime = 1664517674
        panda420.originalUrl = "https://www.bilibili.com/video/BV138411t76R"
        panda420.tags = "大熊猫,萌宠,动物圈"
        panda420.authorId = 16468440
        panda420.cover =
            "https://i2.hdslb.com/bfs/archive/1e7118298e53ad971db201e543e260602181e269.jpg"
        list.add(panda420)

        val panda421 = PetVideo()
        panda421.type = VideoType.PANDA.ordinal
        panda421.fileName = "panda_group_panda421"
        panda421.code = 2333
        panda421.duration = 124
        panda421.period = PeriodType.GROUP.ordinal
        panda421.star = false
        panda421.title = "花落全过程02-懵花啃木头"
        panda421.releaseTime = 1664447909
        panda421.originalUrl = "https://www.bilibili.com/video/BV1DT411N7aw"
        panda421.tags = "大熊猫,萌宠,动物圈"
        panda421.authorId = 335419800
        panda421.cover =
            "https://i2.hdslb.com/bfs/archive/f1a8a2d24e658dd660eb678ec3370bced865abed.jpg"
        list.add(panda421)

        val panda422 = PetVideo()
        panda422.type = VideoType.PANDA.ordinal
        panda422.fileName = "panda_group_panda422"
        panda422.code = 2334
        panda422.duration = 158
        panda422.period = PeriodType.GROUP.ordinal
        panda422.star = false
        panda422.title = "短腿的胜利，换了好几条线路才爬上去，和花累够呛"
        panda422.releaseTime = 1664335800
        panda422.originalUrl = "https://www.bilibili.com/video/BV1ed4y1M7eG"
        panda422.tags = "大熊猫,萌宠,动物圈"
        panda422.authorId = 14887617
        panda422.cover =
            "https://i2.hdslb.com/bfs/archive/b946df273d879b1c0e8ca4a783e9cb80be5e9d18.jpg"
        list.add(panda422)

        val panda423 = PetVideo()
        panda423.type = VideoType.PANDA.ordinal
        panda423.fileName = "panda_group_panda423"
        panda423.code = 2335
        panda423.duration = 15
        panda423.period = PeriodType.GROUP.ordinal
        panda423.star = false
        panda423.title = "会吃睡着的大熊猫"
        panda423.releaseTime = 1664508326
        panda423.originalUrl = "https://www.bilibili.com/video/BV1dN4y1P7Ch"
        panda423.tags = "大熊猫,萌宠,动物圈"
        panda423.authorId = 1025949925
        panda423.cover =
            "https://i0.hdslb.com/bfs/archive/03ccfef31498e877e00429f2c13ffe8877e2acea.jpg"
        list.add(panda423)

        val panda424 = PetVideo()
        panda424.type = VideoType.PANDA.ordinal
        panda424.fileName = "panda_group_panda424"
        panda424.code = 2336
        panda424.duration = 49
        panda424.period = PeriodType.GROUP.ordinal
        panda424.star = false
        panda424.title = "奶气的二狗，吃得好香【大熊猫润玥】"
        panda424.releaseTime = 1664440462
        panda424.originalUrl = "https://www.bilibili.com/video/BV1Q841147Qz"
        panda424.tags = "大熊猫,萌宠,动物圈"
        panda424.authorId = 230382720
        panda424.cover =
            "https://i1.hdslb.com/bfs/archive/1d3aeed7368f00dba2809d7d7df83b7fb8199bba.jpg"
        list.add(panda424)

        val panda425 = PetVideo()
        panda425.type = VideoType.PANDA.ordinal
        panda425.fileName = "panda_group_panda425"
        panda425.code = 2337
        panda425.duration = 107
        panda425.period = PeriodType.GROUP.ordinal
        panda425.star = false
        panda425.title = "弟弟和姐姐贴贴，真的好有爱，真是个懂事的好孩子🌺"
        panda425.releaseTime = 1664436956
        panda425.originalUrl = "https://www.bilibili.com/video/BV11N4y1P7fs"
        panda425.tags = "大熊猫,萌宠,动物圈"
        panda425.authorId = 1714028276
        panda425.cover =
            "https://i1.hdslb.com/bfs/archive/2bf88c5bec0027bcb92cca8a3f9fea27f0627a23.jpg"
        list.add(panda425)

        val panda426 = PetVideo()
        panda426.type = VideoType.PANDA.ordinal
        panda426.fileName = "panda_group_panda426"
        panda426.code = 2338
        panda426.duration = 68
        panda426.period = PeriodType.GROUP.ordinal
        panda426.star = false
        panda426.title = "【大熊猫绩笑、成风】笑笑被风风偷袭，先是嘤嘤求饶、然后狗叫警告"
        panda426.releaseTime = 1664185346
        panda426.originalUrl = "https://www.bilibili.com/video/BV1sg411e7BL"
        panda426.tags = "大熊猫,萌宠,动物圈"
        panda426.authorId = 697876712
        panda426.cover =
            "https://i0.hdslb.com/bfs/archive/a1b39181ae28b3f6fe4b025bd7ca58ef3d759d08.jpg"
        list.add(panda426)

        val panda427 = PetVideo()
        panda427.type = VideoType.PANDA.ordinal
        panda427.fileName = "panda_group_panda427"
        panda427.code = 2339
        panda427.duration = 145
        panda427.period = PeriodType.GROUP.ordinal
        panda427.star = false
        panda427.title = "谁让你吃得那么香"
        panda427.releaseTime = 1664422424
        panda427.originalUrl = "https://www.bilibili.com/video/BV19B4y177Yy"
        panda427.tags = "大熊猫,萌宠,动物圈"
        panda427.authorId = 1025949925
        panda427.cover =
            "https://i1.hdslb.com/bfs/archive/cd214e3594a5c805e56991a87824e1adeacf0ad3.jpg"
        list.add(panda427)

        val panda428 = PetVideo()
        panda428.type = VideoType.PANDA.ordinal
        panda428.fileName = "panda_group_panda428"
        panda428.code = 2340
        panda428.duration = 107
        panda428.period = PeriodType.GROUP.ordinal
        panda428.star = false
        panda428.title = "周末当然是早起去看四嘟吧唧嘴干饭啦～"
        panda428.releaseTime = 1664319600
        panda428.originalUrl = "https://www.bilibili.com/video/BV1Ue4y1n7Zb"
        panda428.tags = "大熊猫,萌宠,动物圈"
        panda428.authorId = 484440897
        panda428.cover =
            "https://i0.hdslb.com/bfs/archive/5cb36529609b74d7a3aa5dc84555270b2917d9ba.jpg"
        list.add(panda428)

        val panda429 = PetVideo()
        panda429.type = VideoType.PANDA.ordinal
        panda429.fileName = "panda_group_panda429"
        panda429.code = 2341
        panda429.duration = 103
        panda429.period = PeriodType.GROUP.ordinal
        panda429.star = false
        panda429.title = "亲爱的谭爷爷又来加笋笋啦，花花吓得一个翻身，接着一边吃一边笑!笋笋大王和叶弟弟咬了一口就跑了？【大熊猫和花 和叶】"
        panda429.releaseTime = 1664377800
        panda429.originalUrl = "https://www.bilibili.com/video/BV14P411E7bR"
        panda429.tags = "大熊猫,萌宠,动物圈"
        panda429.authorId = 16468440
        panda429.cover =
            "https://i2.hdslb.com/bfs/archive/798e5d6b6095a7e43a47bb67b2967edf22dc38b8.jpg"
        list.add(panda429)

        val panda430 = PetVideo()
        panda430.type = VideoType.PANDA.ordinal
        panda430.fileName = "panda_group_panda430"
        panda430.code = 2342
        panda430.duration = 142
        panda430.period = PeriodType.GROUP.ordinal
        panda430.star = false
        panda430.title = "和花和叶真的是心有灵犀的双胞胎呀 ! 才睡醒的和叶懵懵的，还是能穿越树林，准确找到姐姐，并开始吸花😘"
        panda430.releaseTime = 1664327744
        panda430.originalUrl = "https://www.bilibili.com/video/BV1Hg411m7Fy"
        panda430.tags = "大熊猫,萌宠,动物圈"
        panda430.authorId = 16468440
        panda430.cover =
            "https://i0.hdslb.com/bfs/archive/afda54d89331bc195368827b4adbe3bfe0f4e784.jpg"
        list.add(panda430)

        val panda431 = PetVideo()
        panda431.type = VideoType.PANDA.ordinal
        panda431.fileName = "panda_group_panda431"
        panda431.code = 2343
        panda431.duration = 74
        panda431.period = PeriodType.GROUP.ordinal
        panda431.star = false
        panda431.title = "难得花姐想抢笋笋，我和叶就给你吧! 咦，咋你转头就剥好递给菜总了呢？？"
        panda431.releaseTime = 1664290740
        panda431.originalUrl = "https://www.bilibili.com/video/BV1zD4y1174L"
        panda431.tags = "大熊猫,萌宠,动物圈"
        panda431.authorId = 16468440
        panda431.cover =
            "https://i1.hdslb.com/bfs/archive/52a0126d38134aa71aa9b3382814390abd6ebaf6.jpg"
        list.add(panda431)

        val panda432 = PetVideo()
        panda432.type = VideoType.PANDA.ordinal
        panda432.fileName = "panda_group_panda432"
        panda432.code = 2344
        panda432.duration = 55
        panda432.period = PeriodType.GROUP.ordinal
        panda432.star = false
        panda432.title = "大熊猫和花-吃完笋笋仰卧起坐更容易消化"
        panda432.releaseTime = 1664279277
        panda432.originalUrl = "https://www.bilibili.com/video/BV1me4y1b7gJ"
        panda432.tags = "大熊猫,萌宠,动物圈"
        panda432.authorId = 1307515
        panda432.cover =
            "https://i1.hdslb.com/bfs/archive/c3a629a8b61e33541db6ed86f2d3554b1e4b661e.jpg"
        list.add(panda432)

        val panda433 = PetVideo()
        panda433.type = VideoType.PANDA.ordinal
        panda433.fileName = "panda_group_panda433"
        panda433.code = 2345
        panda433.duration = 252
        panda433.period = PeriodType.GROUP.ordinal
        panda433.star = false
        panda433.title = "钓猫完花花坐着回味果果 弟弟过来帮助花花清理小桌板 被花花咬朵朵 温馨美好的画面（cr:和花我的宝 库存8.31）"
        panda433.releaseTime = 1662901524
        panda433.originalUrl = "https://www.bilibili.com/video/BV1bg411m7hB"
        panda433.tags = "大熊猫,萌宠,动物圈"
        panda433.authorId = 1852236806
        panda433.cover =
            "https://i1.hdslb.com/bfs/archive/565c5c414f6f127a2725f6c2217580d5b69cb8be.jpg"
        list.add(panda433)

        val panda434 = PetVideo()
        panda434.type = VideoType.PANDA.ordinal
        panda434.fileName = "panda_group_panda434"
        panda434.code = 2346
        panda434.duration = 195
        panda434.period = PeriodType.GROUP.ordinal
        panda434.star = false
        panda434.title = "花花开发了守护果果的新方法，活叶你要抠窝嘴巴里的，窝就吐出来藏起，等谭爷爷把你引开，我再找回来慢慢吃!【大熊猫和花 和叶】"
        panda434.releaseTime = 1664169120
        panda434.originalUrl = "https://www.bilibili.com/video/BV1jD4y117oc"
        panda434.tags = "大熊猫,萌宠,动物圈"
        panda434.authorId = 16468440
        panda434.cover =
            "https://i2.hdslb.com/bfs/archive/da648a35635ab0fd2eca16da6b627f1c45566261.jpg"
        list.add(panda434)

        val panda435 = PetVideo()
        panda435.type = VideoType.PANDA.ordinal
        panda435.fileName = "panda_group_panda435"
        panda435.code = 2347
        panda435.duration = 20
        panda435.period = PeriodType.GROUP.ordinal
        panda435.star = false
        panda435.title = "【大熊猫和花】Duang Duang Duang，花花甩起来来了"
        panda435.releaseTime = 1663059576
        panda435.originalUrl = "https://www.bilibili.com/video/BV1rG41137yK"
        panda435.tags = "大熊猫,萌宠,动物圈"
        panda435.authorId = 608746190
        panda435.cover =
            "https://i0.hdslb.com/bfs/archive/76186afb8f303368a6aca2ed85633538aae108a3.jpg"
        list.add(panda435)

        val panda436 = PetVideo()
        panda436.type = VideoType.PANDA.ordinal
        panda436.fileName = "panda_group_panda436"
        panda436.code = 2348
        panda436.duration = 24
        panda436.period = PeriodType.GROUP.ordinal
        panda436.star = false
        panda436.title = "花花的迪拜吃笋法！"
        panda436.releaseTime = 1664119824
        panda436.originalUrl = "https://www.bilibili.com/video/BV13P411n7Nw"
        panda436.tags = "大熊猫,萌宠,动物圈"
        panda436.authorId = 2037312510
        panda436.cover =
            "https://i0.hdslb.com/bfs/archive/a00293b4941c8c762bd8b00365db16943eb8e2fa.jpg"
        list.add(panda436)

        val panda437 = PetVideo()
        panda437.type = VideoType.PANDA.ordinal
        panda437.fileName = "panda_group_panda437"
        panda437.code = 2349
        panda437.duration = 153
        panda437.period = PeriodType.GROUP.ordinal
        panda437.star = false
        panda437.title = "优秀带崽公猫成和叶"
        panda437.releaseTime = 1663974000
        panda437.originalUrl = "https://www.bilibili.com/video/BV1nG4y1s7Ef"
        panda437.tags = "大熊猫,萌宠,动物圈"
        panda437.authorId = 484440897
        panda437.cover =
            "https://i0.hdslb.com/bfs/archive/2944369af29c5be996a7ad1a1a726dfab0997992.jpg"
        list.add(panda437)

        val panda438 = PetVideo()
        panda438.type = VideoType.PANDA.ordinal
        panda438.fileName = "panda_group_panda438"
        panda438.code = 2350
        panda438.duration = 32
        panda438.period = PeriodType.GROUP.ordinal
        panda438.star = false
        panda438.title = "花花需要法律援助"
        panda438.releaseTime = 1662043550
        panda438.originalUrl = "https://www.bilibili.com/video/BV1oP411V7za"
        panda438.tags = "大熊猫,萌宠,动物圈"
        panda438.authorId = 107396535
        panda438.cover =
            "https://i0.hdslb.com/bfs/archive/9e69349441d3babd9231cb0081ed18bca42b40d3.jpg"
        list.add(panda438)

        val panda439 = PetVideo()
        panda439.type = VideoType.PANDA.ordinal
        panda439.fileName = "panda_group_panda439"
        panda439.code = 2351
        panda439.duration = 144
        panda439.period = PeriodType.GROUP.ordinal
        panda439.star = false
        panda439.title = "小可爱花花突然出现，就是要和菜菜贴贴靠靠，找个好姿势一起睡午觉😍【大熊猫和花 润玥】"
        panda439.releaseTime = 1664087518
        panda439.originalUrl = "https://www.bilibili.com/video/BV1M841147xN"
        panda439.tags = "大熊猫,萌宠,动物圈"
        panda439.authorId = 16468440
        panda439.cover =
            "https://i0.hdslb.com/bfs/archive/1adafec0938551da70804649ce079d7edd15aa25.jpg"
        list.add(panda439)

        val panda440 = PetVideo()
        panda440.type = VideoType.PANDA.ordinal
        panda440.fileName = "panda_group_panda440"
        panda440.code = 2352
        panda440.duration = 38
        panda440.period = PeriodType.GROUP.ordinal
        panda440.star = false
        panda440.title = "真·夺笋！委屈巴巴的剥笋机器花"
        panda440.releaseTime = 1663932219
        panda440.originalUrl = "https://www.bilibili.com/video/BV1Ke4y1b7Mr"
        panda440.tags = "大熊猫,萌宠,动物圈"
        panda440.authorId = 1718135719
        panda440.cover =
            "https://i2.hdslb.com/bfs/archive/bfc96b7b0826fb73fdd6b618b9c5af2c7b1ba9c1.jpg"
        list.add(panda440)

        val panda441 = PetVideo()
        panda441.type = VideoType.PANDA.ordinal
        panda441.fileName = "panda_group_panda441"
        panda441.code = 2353
        panda441.duration = 229
        panda441.period = PeriodType.GROUP.ordinal
        panda441.star = false
        panda441.title = "【0924加笋】和叶你再迷惑操作，笋没了，四只熊四个状态，笑死"
        panda441.releaseTime = 1664062706
        panda441.originalUrl = "https://www.bilibili.com/video/BV1mV4y1T7Ds"
        panda441.tags = "大熊猫,萌宠,动物圈"
        panda441.authorId = 484440897
        panda441.cover =
            "https://i2.hdslb.com/bfs/archive/dd55e074668830c4d5952703470d64f4241a8d7f.jpg"
        list.add(panda441)

        val panda442 = PetVideo()
        panda442.type = VideoType.PANDA.ordinal
        panda442.fileName = "panda_group_panda442"
        panda442.code = 2354
        panda442.duration = 95
        panda442.period = PeriodType.GROUP.ordinal
        panda442.star = false
        panda442.title = "花花是个热心肠的小姑娘，保安师傅来捞掉下去的东西，花花也想来帮忙!  谭爷爷好了解花花，说花花不来头！【大熊猫和花】"
        panda442.releaseTime = 1664000846
        panda442.originalUrl = "https://www.bilibili.com/video/BV18e411M76w"
        panda442.tags = "大熊猫,萌宠,动物圈"
        panda442.authorId = 16468440
        panda442.cover =
            "https://i1.hdslb.com/bfs/archive/664c92300eab4742a08f2aa9c4e388bb04aec57d.jpg"
        list.add(panda442)

        val panda443 = PetVideo()
        panda443.type = VideoType.PANDA.ordinal
        panda443.fileName = "panda_group_panda443"
        panda443.code = 2355
        panda443.duration = 45
        panda443.period = PeriodType.GROUP.ordinal
        panda443.star = false
        panda443.title = "[润玥  和花  和叶]秋高气爽，一起贴贴，睡觉觉"
        panda443.releaseTime = 1663939546
        panda443.originalUrl = "https://www.bilibili.com/video/BV1de4y1k7Ru"
        panda443.tags = "大熊猫,萌宠,动物圈"
        panda443.authorId = 399523759
        panda443.cover =
            "https://i2.hdslb.com/bfs/archive/e36ed5abb0e61aee60c812c82516ed6e79100726.jpg"
        list.add(panda443)

        val panda444 = PetVideo()
        panda444.type = VideoType.PANDA.ordinal
        panda444.fileName = "panda_group_panda444"
        panda444.code = 2356
        panda444.duration = 110
        panda444.period = PeriodType.GROUP.ordinal
        panda444.star = false
        panda444.title = "花花手里的笋笋还没吃完，菜菜就走了，笋瞬间就不香了。"
        panda444.releaseTime = 1663983211
        panda444.originalUrl = "https://www.bilibili.com/video/BV1jB4y1J73y"
        panda444.tags = "大熊猫,萌宠,动物圈"
        panda444.authorId = 1714028276
        panda444.cover =
            "https://i0.hdslb.com/bfs/archive/87cab41f9b4a95f351ada7eb31eb3bdf4ce8083f.jpg"
        list.add(panda444)

        val panda445 = PetVideo()
        panda445.type = VideoType.PANDA.ordinal
        panda445.fileName = "panda_group_panda445"
        panda445.code = 2357
        panda445.duration = 81
        panda445.period = PeriodType.GROUP.ordinal
        panda445.star = false
        panda445.title = "胖崽：问天嫑动，我错个车。【大熊猫和花、和叶】"
        panda445.releaseTime = 1663932528
        panda445.originalUrl = "https://www.bilibili.com/video/BV1gW4y1v7G2"
        panda445.tags = "大熊猫,萌宠,动物圈"
        panda445.authorId = 514531996
        panda445.cover =
            "https://i1.hdslb.com/bfs/archive/43bb382e3f4027de07ae60e7aa4d18ffabd7e6af.jpg"
        list.add(panda445)

        val panda446 = PetVideo()
        panda446.type = VideoType.PANDA.ordinal
        panda446.fileName = "panda_group_panda446"
        panda446.code = 2358
        panda446.duration = 493
        panda446.period = PeriodType.GROUP.ordinal
        panda446.star = false
        panda446.title = "8.29 爷爷叫花花回家 菜菜和玖玖兴奋打架 花花坐在木架上吃瓜 发呆 等爷爷来接（cr和花我的宝  基地开放延迟到8.7号，想花花🤧）"
        panda446.releaseTime = 1662394021
        panda446.originalUrl = "https://www.bilibili.com/video/BV1sY4y1M7WM"
        panda446.tags = "大熊猫,萌宠,动物圈"
        panda446.authorId = 1852236806
        panda446.cover =
            "https://i1.hdslb.com/bfs/archive/c45b01f31dba15edcdaa49027de98138d09ea21a.jpg"
        list.add(panda446)

        val panda447 = PetVideo()
        panda447.type = VideoType.PANDA.ordinal
        panda447.fileName = "panda_group_panda447"
        panda447.code = 2359
        panda447.duration = 70
        panda447.period = PeriodType.GROUP.ordinal
        panda447.star = false
        panda447.title = "【大熊猫和花】【大熊猫和叶】姐姐 弟弟一起吃播😉"
        panda447.releaseTime = 1663911035
        panda447.originalUrl = "https://www.bilibili.com/video/BV1FN4y1K7aw"
        panda447.tags = "大熊猫,萌宠,动物圈"
        panda447.authorId = 1098561796
        panda447.cover =
            "https://i2.hdslb.com/bfs/archive/a11332f3ac6808f4ee67db30cf1cd99f9cabb43c.jpg"
        list.add(panda447)

        val panda448 = PetVideo()
        panda448.type = VideoType.PANDA.ordinal
        panda448.fileName = "panda_group_panda448"
        panda448.code = 2360
        panda448.duration = 69
        panda448.period = PeriodType.GROUP.ordinal
        panda448.star = false
        panda448.title = "好姐妹就是要贴贴，看菜菜这得意的表情好搞笑💘"
        panda448.releaseTime = 1663924130
        panda448.originalUrl = "https://www.bilibili.com/video/BV1SD4y1i7kF"
        panda448.tags = "大熊猫,萌宠,动物圈"
        panda448.authorId = 1714028276
        panda448.cover =
            "https://i1.hdslb.com/bfs/archive/8a61355db643f60eda835cac460d9ede49a08b35.jpg"
        list.add(panda448)

        val panda449 = PetVideo()
        panda449.type = VideoType.PANDA.ordinal
        panda449.fileName = "panda_group_panda449"
        panda449.code = 2361
        panda449.duration = 213
        panda449.period = PeriodType.GROUP.ordinal
        panda449.star = false
        panda449.title = "爷爷让花花坐远一点吃苹果，就不容易被抢啦"
        panda449.releaseTime = 1663920941
        panda449.originalUrl = "https://www.bilibili.com/video/BV1V8411b7wn"
        panda449.tags = "大熊猫,萌宠,动物圈"
        panda449.authorId = 230382720
        panda449.cover =
            "https://i1.hdslb.com/bfs/archive/2ee780bcb1420ddf7899404d6d7099c822821647.jpg"
        list.add(panda449)

        val panda450 = PetVideo()
        panda450.type = VideoType.PANDA.ordinal
        panda450.fileName = "panda_group_panda450"
        panda450.code = 2362
        panda450.duration = 71
        panda450.period = PeriodType.GROUP.ordinal
        panda450.star = false
        panda450.title = "和叶喝水的侧影，好像功妈呀!【大熊猫和叶】"
        panda450.releaseTime = 1663910280
        panda450.originalUrl = "https://www.bilibili.com/video/BV1TW4y1v7ZH"
        panda450.tags = "大熊猫,萌宠,动物圈"
        panda450.authorId = 16468440
        panda450.cover =
            "https://i0.hdslb.com/bfs/archive/d10a754aed6b22369ea43952b5f776910633e73e.jpg"
        list.add(panda450)

        val panda451 = PetVideo()
        panda451.type = VideoType.PANDA.ordinal
        panda451.fileName = "panda_group_panda451"
        panda451.code = 2363
        panda451.duration = 143
        panda451.period = PeriodType.GROUP.ordinal
        panda451.star = false
        panda451.title = "沉浸式看熊猫吃播，重阳嘤嘤叫不停"
        panda451.releaseTime = 1663899775
        panda451.originalUrl = "https://www.bilibili.com/video/BV1cd4y1z75N"
        panda451.tags = "大熊猫,萌宠,动物圈"
        panda451.authorId = 1025949925
        panda451.cover =
            "https://i0.hdslb.com/bfs/archive/febaa378ca8883a90eed3df42b9986d9536212b5.jpg"
        list.add(panda451)


        val panda452 = PetVideo()
        panda452.type = VideoType.PANDA.ordinal
        panda452.fileName = "panda_group_panda452"
        panda452.code = 2364
        panda452.duration = 134
        panda452.period = PeriodType.GROUP.ordinal
        panda452.star = false
        panda452.title = "和叶:来个人把润玥姐带走，好烦熊，连个觉都睡不好🥰"
        panda452.releaseTime = 1662277438
        panda452.originalUrl = "https://www.bilibili.com/video/BV1UB4y1G7SB"
        panda452.tags = "大熊猫,萌宠,动物圈"
        panda452.authorId = 1714028276
        panda452.cover =
            "https://i0.hdslb.com/bfs/archive/246b23876ff822034801c98b34635ca4dbe17750.jpg"
        list.add(panda452)

        val panda453 = PetVideo()
        panda453.type = VideoType.PANDA.ordinal
        panda453.fileName = "panda_group_panda453"
        panda453.code = 2365
        panda453.duration = 68
        panda453.period = PeriodType.GROUP.ordinal
        panda453.star = false
        panda453.title = "当年小小的两只"
        panda453.releaseTime = 1663850174
        panda453.originalUrl = "https://www.bilibili.com/video/BV1DD4y1i7MR"
        panda453.tags = "大熊猫,萌宠,动物圈"
        panda453.authorId = 1754373551
        panda453.cover =
            "https://i0.hdslb.com/bfs/archive/ee44c905293587419e19d89c30b54b0472b43566.jpg"
        list.add(panda453)

        val panda454 = PetVideo()
        panda454.type = VideoType.PANDA.ordinal
        panda454.fileName = "panda_group_panda454"
        panda454.code = 2366
        panda454.duration = 138
        panda454.period = PeriodType.GROUP.ordinal
        panda454.star = false
        panda454.title = "0921花花没吃到窝头，等土匪些都睡觉了，谭爷爷给花花补零食，结果小声喊了花花，本花还在迟疑，其他三只火速赶到"
        panda454.releaseTime = 1663804714
        panda454.originalUrl = "https://www.bilibili.com/video/BV1i8411b7Kp"
        panda454.tags = "大熊猫,萌宠,动物圈"
        panda454.authorId = 484440897
        panda454.cover =
            "https://i1.hdslb.com/bfs/archive/3a8968db79d435714c4da9e617e95a4c35269e7b.jpg"
        list.add(panda454)

        val panda455 = PetVideo()
        panda455.type = VideoType.PANDA.ordinal
        panda455.fileName = "panda_group_panda455"
        panda455.code = 2367
        panda455.duration = 291
        panda455.period = PeriodType.GROUP.ordinal
        panda455.star = false
        panda455.title = "09.21 幼年2班钓猫，重阳小朋友，请注意吃饭的时候不要聊天😎"
        panda455.releaseTime = 1663834080
        panda455.originalUrl = "https://www.bilibili.com/video/BV1Pd4y1z7KN"
        panda455.tags = "大熊猫,萌宠,动物圈"
        panda455.authorId = 16468440
        panda455.cover =
            "https://i0.hdslb.com/bfs/archive/f276e3543f3688931dbb167edb06c59192c5e2c1.jpg"
        list.add(panda455)

        val panda456 = PetVideo()
        panda456.type = VideoType.PANDA.ordinal
        panda456.fileName = "panda_group_panda456"
        panda456.code = 2368
        panda456.duration = 89
        panda456.period = PeriodType.GROUP.ordinal
        panda456.star = false
        panda456.title = "才睡醒的润玥懵懵的，用脚挠挠耳朵，再舔舔尾巴，好乖呀!"
        panda456.releaseTime = 1663838528
        panda456.originalUrl = "https://www.bilibili.com/video/BV1UP411J7Tp"
        panda456.tags = "大熊猫,萌宠,动物圈"
        panda456.authorId = 16468440
        panda456.cover =
            "https://i0.hdslb.com/bfs/archive/bd37d940b62408d1c67c6eff723f1bc751e94752.jpg"
        list.add(panda456)

        val panda457 = PetVideo()
        panda457.type = VideoType.PANDA.ordinal
        panda457.fileName = "panda_group_panda457"
        panda457.code = 2369
        panda457.duration = 77
        panda457.period = PeriodType.GROUP.ordinal
        panda457.star = false
        panda457.title = "我成和花真的没有惹你们任何一个小熊友，怎么就成了花卷儿？😂😭"
        panda457.releaseTime = 1663821660
        panda457.originalUrl = "https://www.bilibili.com/video/BV1zd4y1B7RJ"
        panda457.tags = "大熊猫,萌宠,动物圈"
        panda457.authorId = 16468440
        panda457.cover =
            "https://i1.hdslb.com/bfs/archive/40a5a820217981c2d3779661160cd189c14a49d5.jpg"
        list.add(panda457)

        val panda458 = PetVideo()
        panda458.type = VideoType.PANDA.ordinal
        panda458.fileName = "panda_group_panda458"
        panda458.code = 2370
        panda458.duration = 114
        panda458.period = PeriodType.GROUP.ordinal
        panda458.star = false
        panda458.title = "菜菜炫笋笋的名场面又来了，吃的好有食欲🎍专心干饭💘"
        panda458.releaseTime = 1663808291
        panda458.originalUrl = "https://www.bilibili.com/video/BV1iD4y1i7za"
        panda458.tags = "大熊猫,萌宠,动物圈"
        panda458.authorId = 1714028276
        panda458.cover =
            "https://i0.hdslb.com/bfs/archive/ba0c32d23bf49767434ce4ac4d0ca17ccc5e0552.jpg"
        list.add(panda458)

        val panda459 = PetVideo()
        panda459.type = VideoType.PANDA.ordinal
        panda459.fileName = "panda_group_panda459"
        panda459.code = 2371
        panda459.duration = 190
        panda459.period = PeriodType.GROUP.ordinal
        panda459.star = false
        panda459.title = "重阳小阔爱是个超治愈的嘤嘤怪。~9.21小二班钓猫 【大熊猫】"
        panda459.releaseTime = 1663768633
        panda459.originalUrl = "https://www.bilibili.com/video/BV1Ug41127GU"
        panda459.tags = "大熊猫,萌宠,动物圈"
        panda459.authorId = 514531996
        panda459.cover =
            "https://i1.hdslb.com/bfs/archive/ce27c530d5eec20b6202593c572f8f2c694b91d0.jpg"
        list.add(panda459)

        val panda460 = PetVideo()
        panda460.type = VideoType.PANDA.ordinal
        panda460.fileName = "panda_group_panda460"
        panda460.code = 2372
        panda460.duration = 79
        panda460.period = PeriodType.GROUP.ordinal
        panda460.star = false
        panda460.title = "09.21 今天爷爷给的苹果也太好吃了，掉在手臂上的也要全部吃掉!😜【大熊猫和花】"
        panda460.releaseTime = 1663770195
        panda460.originalUrl = "https://www.bilibili.com/video/BV1Fe4y1C75V"
        panda460.tags = "大熊猫,萌宠,动物圈"
        panda460.authorId = 16468440
        panda460.cover =
            "https://i2.hdslb.com/bfs/archive/ae6da3b238f68e444557f135a1daa3590229bcef.jpg"
        list.add(panda460)

        val panda461 = PetVideo()
        panda461.type = VideoType.PANDA.ordinal
        panda461.fileName = "panda_group_panda461"
        panda461.code = 2373
        panda461.duration = 144
        panda461.period = PeriodType.GROUP.ordinal
        panda461.star = false
        panda461.title = "【大熊润玥和叶】9.21 二狗和弟弟的沉浸式吃播"
        panda461.releaseTime = 1663721665
        panda461.originalUrl = "https://www.bilibili.com/video/BV1cB4y1J7Qa"
        panda461.tags = "大熊猫,萌宠,动物圈"
        panda461.authorId = 8299975
        panda461.cover =
            "https://i2.hdslb.com/bfs/archive/cded2a4c3cea2d6c77014fdfb93da7f637a3cd41.jpg"
        list.add(panda461)

        val panda462 = PetVideo()
        panda462.type = VideoType.PANDA.ordinal
        panda462.fileName = "panda_group_panda462"
        panda462.code = 2374
        panda462.duration = 79
        panda462.period = PeriodType.GROUP.ordinal
        panda462.star = false
        panda462.title = "今日也是超努力的花花哦！"
        panda462.releaseTime = 1663674875
        panda462.originalUrl = "https://www.bilibili.com/video/BV1CW4y1v7Nn"
        panda462.tags = "大熊猫,萌宠,动物圈"
        panda462.authorId = 1718135719
        panda462.cover =
            "https://i2.hdslb.com/bfs/archive/13699105c0d242bed67e7944a863bfe0f247fc4c.jpg"
        list.add(panda462)

        val panda463 = PetVideo()
        panda463.type = VideoType.PANDA.ordinal
        panda463.fileName = "panda_group_panda463"
        panda463.code = 2375
        panda463.duration = 52
        panda463.period = PeriodType.GROUP.ordinal
        panda463.star = false
        panda463.title = "花主任日常工作之巡检独木桥"
        panda463.releaseTime = 1663662259
        panda463.originalUrl = "https://www.bilibili.com/video/BV14Y4y1T73h"
        panda463.tags = "大熊猫,萌宠,动物圈"
        panda463.authorId = 1307515
        panda463.cover =
            "https://i0.hdslb.com/bfs/archive/2a28fe6955dcd591f1280076e4bc33c80109a8e5.jpg"
        list.add(panda463)

        val panda464 = PetVideo()
        panda464.type = VideoType.PANDA.ordinal
        panda464.fileName = "panda_group_panda464"
        panda464.code = 2376
        panda464.duration = 23
        panda464.period = PeriodType.GROUP.ordinal
        panda464.star = false
        panda464.title = "一种长在树上的生物"
        panda464.releaseTime = 1663665383
        panda464.originalUrl = "https://www.bilibili.com/video/BV1SB4y1E7Qz"
        panda464.tags = "大熊猫,萌宠,动物圈"
        panda464.authorId = 1025949925
        panda464.cover =
            "https://i0.hdslb.com/bfs/archive/4d581c35aeadc6adf4513cdc2bae327919f16e77.jpg"
        list.add(panda464)

        val panda465 = PetVideo()
        panda465.type = VideoType.PANDA.ordinal
        panda465.fileName = "panda_group_panda465"
        panda465.code = 2377
        panda465.duration = 114
        panda465.period = PeriodType.GROUP.ordinal
        panda465.star = false
        panda465.title = "二班两个钢铁直男把两个女生推下木架，所以爱真的会消失吗？"
        panda465.releaseTime = 1663674401
        panda465.originalUrl = "https://www.bilibili.com/video/BV1jt4y1P7xW"
        panda465.tags = "大熊猫,萌宠,动物圈"
        panda465.authorId = 34677299
        panda465.cover =
            "https://i0.hdslb.com/bfs/archive/cf53723d35b50d2612c53e864d7ce8f9dfbfe624.jpg"
        list.add(panda465)

        val panda466 = PetVideo()
        panda466.type = VideoType.PANDA.ordinal
        panda466.fileName = "panda_group_panda466"
        panda466.code = 2378
        panda466.duration = 86
        panda466.period = PeriodType.GROUP.ordinal
        panda466.star = false
        panda466.title = "9.21的花花和艾玖润玥姐姐们一起恰笋笋，弟弟在一旁恰笋🌸💐"
        panda466.releaseTime = 1663722211
        panda466.originalUrl = "https://www.bilibili.com/video/BV1pG4y1s7n4"
        panda466.tags = "大熊猫,萌宠,动物圈"
        panda466.authorId = 1714028276
        panda466.cover =
            "https://i0.hdslb.com/bfs/archive/b4a81dcc34ce2689f85b55e8be411954be9e169d.jpg"
        list.add(panda466)

        val panda467 = PetVideo()
        panda467.type = VideoType.PANDA.ordinal
        panda467.fileName = "panda_group_panda467"
        panda467.code = 2379
        panda467.duration = 16
        panda467.period = PeriodType.GROUP.ordinal
        panda467.star = false
        panda467.title = "这么可爱的熊猫哪里找"
        panda467.releaseTime = 1663557360
        panda467.originalUrl = "https://www.bilibili.com/video/BV1v24y1d7xE"
        panda467.tags = "大熊猫,萌宠,动物圈"
        panda467.authorId = 1025949925
        panda467.cover =
            "https://i0.hdslb.com/bfs/archive/a281dab1ed1d442a8fe7e714b092ea01f806aa11.jpg"
        list.add(panda467)

        val panda468 = PetVideo()
        panda468.type = VideoType.PANDA.ordinal
        panda468.fileName = "panda_group_panda468"
        panda468.code = 2380
        panda468.duration = 91
        panda468.period = PeriodType.GROUP.ordinal
        panda468.star = false
        panda468.title = "花花，花花，快醒醒 !!  你弟弟，被一只🐝蜜蜂欺负啦!【大熊猫和花】"
        panda468.releaseTime = 1663560480
        panda468.originalUrl = "https://www.bilibili.com/video/BV1VG411G7qd"
        panda468.tags = "大熊猫,萌宠,动物圈"
        panda468.authorId = 16468440
        panda468.cover =
            "https://i2.hdslb.com/bfs/archive/36a3ac006c26e5c5e6e8ddac377d62f515d3ca95.jpg"
        list.add(panda468)

        val panda469 = PetVideo()
        panda469.type = VideoType.PANDA.ordinal
        panda469.fileName = "panda_group_panda469"
        panda469.code = 2381
        panda469.duration = 79
        panda469.period = PeriodType.GROUP.ordinal
        panda469.star = false
        panda469.title = "猜猜花花这么着急忙慌，扑趴跟斗儿的去干嘛？原来是………花花碰瓷式撩架方式从来没有变过!"
        panda469.releaseTime = 1663499862
        panda469.originalUrl = "https://www.bilibili.com/video/BV1ne4y1k7Kx"
        panda469.tags = "大熊猫,萌宠,动物圈"
        panda469.authorId = 16468440
        panda469.cover =
            "https://i0.hdslb.com/bfs/archive/1d4e042283ed48bfebf849a00ad361dba556fe44.jpg"
        list.add(panda469)

        val panda470 = PetVideo()
        panda470.type = VideoType.PANDA.ordinal
        panda470.fileName = "panda_group_panda470"
        panda470.code = 2382
        panda470.duration = 83
        panda470.period = PeriodType.GROUP.ordinal
        panda470.star = false
        panda470.title = "二狗：还是这个靠枕舒服，软fufu，肉嘟嘟"
        panda470.releaseTime = 1663499862
        panda470.originalUrl = "https://www.bilibili.com/video/BV1dT411K7jg"
        panda470.tags = "大熊猫,萌宠,动物圈"
        panda470.authorId = 34677299
        panda470.cover =
            "https://i1.hdslb.com/bfs/archive/93a1429f27dc70f489b5db9cddc597a48e8252c3.jpg"
        list.add(panda470)

        val panda471 = PetVideo()
        panda471.type = VideoType.PANDA.ordinal
        panda471.fileName = "panda_group_panda471"
        panda471.code = 2383
        panda471.duration = 80
        panda471.period = PeriodType.GROUP.ordinal
        panda471.star = false
        panda471.title = "脸脸在膨胀，朵朵在原地踏步，像扎了两个小丸子"
        panda471.releaseTime = 1663504179
        panda471.originalUrl = "https://www.bilibili.com/video/BV1NV4y1u7kV"
        panda471.tags = "大熊猫,萌宠,动物圈"
        panda471.authorId = 34677299
        panda471.cover =
            "https://i0.hdslb.com/bfs/archive/f8aeb738ef029c14115856f8c4eef45d5dc7029b.jpg"
        list.add(panda471)

        val panda472 = PetVideo()
        panda472.type = VideoType.PANDA.ordinal
        panda472.fileName = "panda_group_panda472"
        panda472.code = 2384
        panda472.duration = 51
        panda472.period = PeriodType.GROUP.ordinal
        panda472.star = false
        panda472.title = "花花突然就滚走了【大熊猫和花】"
        panda472.releaseTime = 1663509331
        panda472.originalUrl = "https://www.bilibili.com/video/BV1N14y1Y78j"
        panda472.tags = "大熊猫,萌宠,动物圈"
        panda472.authorId = 230382720
        panda472.cover =
            "https://i1.hdslb.com/bfs/archive/32b8a88758d36794391b2c30e91aedc3a0510e6e.jpg"
        list.add(panda472)

        val panda473 = PetVideo()
        panda473.type = VideoType.PANDA.ordinal
        panda473.fileName = "panda_group_panda473"
        panda473.code = 2385
        panda473.duration = 69
        panda473.period = PeriodType.GROUP.ordinal
        panda473.star = false
        panda473.title = "和花闭着眼吃笋"
        panda473.releaseTime = 1663498800
        panda473.originalUrl = "https://www.bilibili.com/video/BV1TD4y1i7m7"
        panda473.tags = "大熊猫,萌宠,动物圈"
        panda473.authorId = 327377672
        panda473.cover =
            "https://i0.hdslb.com/bfs/archive/90c0f1f2acaa8764c98d15391c7b3b24454ff961.jpg"
        list.add(panda473)

        val panda474 = PetVideo()
        panda474.type = VideoType.PANDA.ordinal
        panda474.fileName = "panda_group_panda474"
        panda474.code = 2386
        panda474.duration = 62
        panda474.period = PeriodType.GROUP.ordinal
        panda474.star = false
        panda474.title = "花花路过，润玥把下巴放在花花背上 ，这画面太有爱啦!【大熊猫和花 润玥】"
        panda474.releaseTime = 1663477054
        panda474.originalUrl = "https://www.bilibili.com/video/BV1dB4y1n7id"
        panda474.tags = "大熊猫,萌宠,动物圈"
        panda474.authorId = 16468440
        panda474.cover =
            "https://i0.hdslb.com/bfs/archive/c20b52d91191ee699b7b4619be0ea4fa2f8e5af0.jpg"
        list.add(panda474)

        val panda475 = PetVideo()
        panda475.type = VideoType.PANDA.ordinal
        panda475.fileName = "panda_group_panda475"
        panda475.code = 2387
        panda475.duration = 66
        panda475.period = PeriodType.GROUP.ordinal
        panda475.star = false
        panda475.title = "【大熊猫和花】花花这毛蓬蓬的小方脸，咋这么招人稀罕呢！"
        panda475.releaseTime = 1663282034
        panda475.originalUrl = "https://www.bilibili.com/video/BV1ZD4y1q7qA"
        panda475.tags = "大熊猫,萌宠,动物圈"
        panda475.authorId = 1383841530
        panda475.cover =
            "https://i2.hdslb.com/bfs/archive/f593f4a66c91971e79a6fad64c58dc7ea03e64df.jpg"
        list.add(panda475)

        val panda476 = PetVideo()
        panda476.type = VideoType.PANDA.ordinal
        panda476.fileName = "panda_group_panda476"
        panda476.code = 2388
        panda476.duration = 67
        panda476.period = PeriodType.GROUP.ordinal
        panda476.star = false
        panda476.title = "露完正脸的小熊🐻开始磕牙了～"
        panda476.releaseTime = 1663396154
        panda476.originalUrl = "https://www.bilibili.com/video/BV12G411u7TK"
        panda476.tags = "大熊猫,萌宠,动物圈"
        panda476.authorId = 1714028276
        panda476.cover =
            "https://i1.hdslb.com/bfs/archive/03b1e19672190238b90fb71adc0354791af524ba.jpg"
        list.add(panda476)

        val panda477 = PetVideo()
        panda477.type = VideoType.PANDA.ordinal
        panda477.fileName = "panda_group_panda477"
        panda477.code = 2389
        panda477.duration = 62
        panda477.period = PeriodType.GROUP.ordinal
        panda477.star = false
        panda477.title = "花花：本仙女想干嘛就干嘛，要你寡（doge"
        panda477.releaseTime = 1663377300
        panda477.originalUrl = "https://www.bilibili.com/video/BV1ot4y1L7Uf"
        panda477.tags = "大熊猫,萌宠,动物圈"
        panda477.authorId = 484440897
        panda477.cover =
            "https://i1.hdslb.com/bfs/archive/ddb3819d91ad029bab624c8a24e88866a5e01622.jpg"
        list.add(panda477)

        val panda478 = PetVideo()
        panda478.type = VideoType.PANDA.ordinal
        panda478.fileName = "panda_group_panda478"
        panda478.code = 2390
        panda478.duration = 12
        panda478.period = PeriodType.GROUP.ordinal
        panda478.star = false
        panda478.title = "是谁说花花很菜的？来给他们凶一个"
        panda478.releaseTime = 1663385408
        panda478.originalUrl = "https://www.bilibili.com/video/BV1Te411M7nF"
        panda478.tags = "大熊猫,萌宠,动物圈"
        panda478.authorId = 1025949925
        panda478.cover =
            "https://i1.hdslb.com/bfs/archive/1d2f235b1dc373c70ece03a9c76d192fc4ab0ec7.jpg"
        list.add(panda478)

        val panda479 = PetVideo()
        panda479.type = VideoType.PANDA.ordinal
        panda479.fileName = "panda_group_panda479"
        panda479.code = 2391
        panda479.duration = 66
        panda479.period = PeriodType.GROUP.ordinal
        panda479.star = false
        panda479.title = "和瓜：二狗，你今天休想推我下木架！【大熊猫和叶、润玥】"
        panda479.releaseTime = 1663330611
        panda479.originalUrl = "https://www.bilibili.com/video/BV1JV4y1M7cP"
        panda479.tags = "大熊猫,萌宠,动物圈"
        panda479.authorId = 514531996
        panda479.cover =
            "https://i2.hdslb.com/bfs/archive/843afa816f35764feb7e6f71187d55c623b763e1.jpg"
        list.add(panda479)

        val panda480 = PetVideo()
        panda480.type = VideoType.PANDA.ordinal
        panda480.fileName = "panda_group_panda480"
        panda480.code = 2392
        panda480.duration = 44
        panda480.period = PeriodType.GROUP.ordinal
        panda480.star = false
        panda480.title = "大熊猫和花-果赖！第一视角钓猫体验！"
        panda480.releaseTime = 1663326245
        panda480.originalUrl = "https://www.bilibili.com/video/BV1PP411H7s6"
        panda480.tags = "大熊猫,萌宠,动物圈"
        panda480.authorId = 1307515
        panda480.cover =
            "https://i0.hdslb.com/bfs/archive/1af5389d2f343e7f88e1f41cc6611b3d6d1eb20a.jpg"
        list.add(panda480)

        val panda481 = PetVideo()
        panda481.type = VideoType.PANDA.ordinal
        panda481.fileName = "panda_group_panda481"
        panda481.code = 2393
        panda481.duration = 66
        panda481.period = PeriodType.GROUP.ordinal
        panda481.star = false
        panda481.title = "花望天营业累了就倒下来睡觉，一秒进入梦乡💘"
        panda481.releaseTime = 1663317550
        panda481.originalUrl = "https://www.bilibili.com/video/BV1fW4y1i7Jh"
        panda481.tags = "大熊猫,萌宠,动物圈"
        panda481.authorId = 1714028276
        panda481.cover =
            "https://i1.hdslb.com/bfs/archive/5834e7b647aed0306094b67f1246922930503ac4.jpg"
        list.add(panda481)

        val panda482 = PetVideo()
        panda482.type = VideoType.PANDA.ordinal
        panda482.fileName = "panda_group_panda482"
        panda482.code = 2394
        panda482.duration = 137
        panda482.period = PeriodType.GROUP.ordinal
        panda482.star = false
        panda482.title = "熊猫奇一要怀疑熊生，专心吃饭没八卦男孩子打架，结果被揉面团"
        panda482.releaseTime = 1663299370
        panda482.originalUrl = "https://www.bilibili.com/video/BV1f14y1a77E"
        panda482.tags = "大熊猫,萌宠,动物圈"
        panda482.authorId = 627116323
        panda482.cover =
            "https://i1.hdslb.com/bfs/archive/154ba0cfb65949a14667307337c33eb64458f9c1.jpg"
        list.add(panda482)

        val panda483 = PetVideo()
        panda483.type = VideoType.PANDA.ordinal
        panda483.fileName = "panda_group_panda483"
        panda483.code = 2395
        panda483.duration = 119
        panda483.period = PeriodType.GROUP.ordinal
        panda483.star = false
        panda483.title = "【大熊猫和花】花花的竹叶囧囧眉好自然"
        panda483.releaseTime = 1655431259
        panda483.originalUrl = "https://www.bilibili.com/video/BV1pa411s7G4"
        panda483.tags = "大熊猫,萌宠,动物圈"
        panda483.authorId = 230382720
        panda483.cover =
            "https://i2.hdslb.com/bfs/archive/7121984a5a81faaa474bcccaf226367a289e32d6.jpg"
        list.add(panda483)

        val panda484 = PetVideo()
        panda484.type = VideoType.PANDA.ordinal
        panda484.fileName = "panda_group_panda484"
        panda484.code = 2396
        panda484.duration = 103
        panda484.period = PeriodType.GROUP.ordinal
        panda484.star = false
        panda484.title = "ergo：妹妹这个太粗了，还是我来吧"
        panda484.releaseTime = 1663139173
        panda484.originalUrl = "https://www.bilibili.com/video/BV1dY4y1K7ST"
        panda484.tags = "大熊猫,萌宠,动物圈"
        panda484.authorId = 1325768509
        panda484.cover =
            "https://i0.hdslb.com/bfs/archive/0d170bb293dc4d4c41958dfb06a79c3d5587ddde.jpg"
        list.add(panda484)

        val panda485 = PetVideo()
        panda485.type = VideoType.PANDA.ordinal
        panda485.fileName = "panda_group_panda485"
        panda485.code = 2397
        panda485.duration = 150
        panda485.period = PeriodType.GROUP.ordinal
        panda485.star = false
        panda485.title = "嘴强王者花花"
        panda485.releaseTime = 1663211881
        panda485.originalUrl = "https://www.bilibili.com/video/BV1dY4y1K7H9"
        panda485.tags = "大熊猫,萌宠,动物圈"
        panda485.authorId = 1025949925
        panda485.cover =
            "https://i2.hdslb.com/bfs/archive/7963ad227397c923e9f945a14213f60f5b1f1a64.jpg"
        list.add(panda485)

        val panda486 = PetVideo()
        panda486.type = VideoType.PANDA.ordinal
        panda486.fileName = "panda_group_panda486"
        panda486.code = 2398
        panda486.duration = 97
        panda486.period = PeriodType.GROUP.ordinal
        panda486.star = false
        panda486.title = "好喜欢看胖崽抱着肚肚的样子，太可爱了。。【大熊猫和花】"
        panda486.releaseTime = 1663161686
        panda486.originalUrl = "https://www.bilibili.com/video/BV1Fe4y187NA"
        panda486.tags = "大熊猫,萌宠,动物圈"
        panda486.authorId = 514531996
        panda486.cover =
            "https://i1.hdslb.com/bfs/archive/a2d880160882830adce77d6a539d86d787e2af66.jpg"
        list.add(panda486)

        val panda487 = PetVideo()
        panda487.type = VideoType.PANDA.ordinal
        panda487.fileName = "panda_group_panda487"
        panda487.code = 2399
        panda487.duration = 90
        panda487.period = PeriodType.GROUP.ordinal
        panda487.star = false
        panda487.title = "艾玖:不带这么玩的，和叶你咬我手干啥子"
        panda487.releaseTime = 1663056464
        panda487.originalUrl = "https://www.bilibili.com/video/BV1va411g7AS"
        panda487.tags = "大熊猫,萌宠,动物圈"
        panda487.authorId = 1714028276
        panda487.cover =
            "https://i2.hdslb.com/bfs/archive/b8a021221516e6cce59ec769d7f24ea79c7a349a.jpg"
        list.add(panda487)

        val panda488 = PetVideo()
        panda488.type = VideoType.PANDA.ordinal
        panda488.fileName = "panda_group_panda488"
        panda488.code = 2400
        panda488.duration = 66
        panda488.period = PeriodType.GROUP.ordinal
        panda488.star = false
        panda488.title = "润玥睡午觉太乖了，半梦半醒之间还在转耳朵!【大熊猫润玥】"
        panda488.releaseTime = 1663049280
        panda488.originalUrl = "https://www.bilibili.com/video/BV1nD4y1q7m8"
        panda488.tags = "大熊猫,萌宠,动物圈"
        panda488.authorId = 16468440
        panda488.cover =
            "https://i0.hdslb.com/bfs/archive/9d68dc1e42a3d0b7149b62ed75d719ce16cbc5b8.jpg"
        list.add(panda488)

        val panda489 = PetVideo()
        panda489.type = VideoType.PANDA.ordinal
        panda489.fileName = "panda_group_panda489"
        panda489.code = 2401
        panda489.duration = 7
        panda489.period = PeriodType.GROUP.ordinal
        panda489.star = false
        panda489.title = "花花：我这不是胖，是可爱到膨胀！"
        panda489.releaseTime = 1662893354
        panda489.originalUrl = "https://www.bilibili.com/video/BV1Je411u7wF"
        panda489.tags = "大熊猫,萌宠,动物圈"
        panda489.authorId = 2037312510
        panda489.cover =
            "https://i2.hdslb.com/bfs/archive/caa0707708adaf6dc7d8034267972dcba2ad23f8.jpg"
        list.add(panda489)

        val panda490 = PetVideo()
        panda490.type = VideoType.PANDA.ordinal
        panda490.fileName = "panda_group_panda490"
        panda490.code = 2402
        panda490.duration = 91
        panda490.period = PeriodType.GROUP.ordinal
        panda490.star = false
        panda490.title = "花花又走过来散发可爱啦(//∇//)"
        panda490.releaseTime = 1663034492
        panda490.originalUrl = "https://www.bilibili.com/video/BV1HP411G7Qw"
        panda490.tags = "大熊猫,萌宠,动物圈"
        panda490.authorId = 16468440
        panda490.cover =
            "https://i2.hdslb.com/bfs/archive/f679b48142816f5261c826ed3351c4f90c4d00eb.jpg"
        list.add(panda490)

        val panda491 = PetVideo()
        panda491.type = VideoType.PANDA.ordinal
        panda491.fileName = "panda_group_panda491"
        panda491.code = 2403
        panda491.duration = 103
        panda491.period = PeriodType.GROUP.ordinal
        panda491.star = false
        panda491.title = "和叶:本来想在上面打打的，失算了就掉下来了😂"
        panda491.releaseTime = 1662098965
        panda491.originalUrl = "https://www.bilibili.com/video/BV1mG4y167sq"
        panda491.tags = "大熊猫,萌宠,动物圈"
        panda491.authorId = 1714028276
        panda491.cover =
            "https://i0.hdslb.com/bfs/archive/641233fd082ab9d7894db277d9bd256d0efd2cbd.jpg"
        list.add(panda491)

        val panda492 = PetVideo()
        panda492.type = VideoType.PANDA.ordinal
        panda492.fileName = "panda_group_panda492"
        panda492.code = 2404
        panda492.duration = 38
        panda492.period = PeriodType.GROUP.ordinal
        panda492.star = false
        panda492.title = "幼年一班四位大佬出街～闲人莫近"
        panda492.releaseTime = 1657371365
        panda492.originalUrl = "https://www.bilibili.com/video/BV1Na411Q7hX"
        panda492.tags = "大熊猫,萌宠,动物圈"
        panda492.authorId = 264648535
        panda492.cover =
            "https://i2.hdslb.com/bfs/archive/92e1678c22b1393c93274859ffe9e43233180a10.jpg"
        list.add(panda492)

        val panda493 = PetVideo()
        panda493.type = VideoType.PANDA.ordinal
        panda493.fileName = "panda_group_panda493"
        panda493.code = 2405
        panda493.duration = 78
        panda493.period = PeriodType.GROUP.ordinal
        panda493.star = false
        panda493.title = "你就这样duangduangduang地萌进了我的心！【大熊猫和花】"
        panda493.releaseTime = 1641436765
        panda493.originalUrl = "https://www.bilibili.com/video/BV1jr4y1U7Wc"
        panda493.tags = "大熊猫,萌宠,动物圈"
        panda493.authorId = 16468440
        panda493.cover =
            "https://i2.hdslb.com/bfs/archive/6a7ec17595fb37ceada4d42a23653312436ccb52.jpg"
        list.add(panda493)

        val panda494 = PetVideo()
        panda494.type = VideoType.PANDA.ordinal
        panda494.fileName = "panda_group_panda494"
        panda494.code = 2406
        panda494.duration = 78
        panda494.period = PeriodType.GROUP.ordinal
        panda494.star = false
        panda494.title = "苏炳花跑出中国速度"
        panda494.releaseTime = 1649172303
        panda494.originalUrl = "https://www.bilibili.com/video/BV1uF411G7GC"
        panda494.tags = "大熊猫,萌宠,动物圈"
        panda494.authorId = 492727424
        panda494.cover =
            "https://i1.hdslb.com/bfs/archive/535dd0c39cf741be2ad5c150280b91f147625fd3.jpg"
        list.add(panda494)

        val panda495 = PetVideo()
        panda495.type = VideoType.PANDA.ordinal
        panda495.fileName = "panda_group_panda495"
        panda495.code = 2407
        panda495.duration = 155
        panda495.period = PeriodType.GROUP.ordinal
        panda495.star = false
        panda495.title = "闹脾气的熊猫"
        panda495.releaseTime = 1662953776
        panda495.originalUrl = "https://www.bilibili.com/video/BV1Re4y1C7CS"
        panda495.tags = "大熊猫,萌宠,动物圈"
        panda495.authorId = 1025949925
        panda495.cover =
            "https://i0.hdslb.com/bfs/archive/fd2815541daa1a2f0e1e02a81571a429005a8ee6.jpg"
        list.add(panda495)

        val panda496 = PetVideo()
        panda496.type = VideoType.PANDA.ordinal
        panda496.fileName = "panda_group_panda496"
        panda496.code = 2408
        panda496.duration = 89
        panda496.period = PeriodType.GROUP.ordinal
        panda496.star = false
        panda496.title = "花花艾玖润玥三姐妹干饭进行时，画风各不相同！不得不说，菜总这功夫是真好!"
        panda496.releaseTime = 1662951348
        panda496.originalUrl = "https://www.bilibili.com/video/BV1JW4y1i71B"
        panda496.tags = "大熊猫,萌宠,动物圈"
        panda496.authorId = 16468440
        panda496.cover =
            "https://i2.hdslb.com/bfs/archive/ea22160e78b07722d1e5e442c6eac742b9f27df7.jpg"
        list.add(panda496)

        val panda497 = PetVideo()
        panda497.type = VideoType.PANDA.ordinal
        panda497.fileName = "panda_group_panda497"
        panda497.code = 2409
        panda497.duration = 119
        panda497.period = PeriodType.GROUP.ordinal
        panda497.star = false
        panda497.title = "胖崽战神附体推弟弟下木架，然后。。。【大熊猫和花、和叶】"
        panda497.releaseTime = 1662904194
        panda497.originalUrl = "https://www.bilibili.com/video/BV1Xg411m7y7"
        panda497.tags = "大熊猫,萌宠,动物圈"
        panda497.authorId = 514531996
        panda497.cover =
            "https://i0.hdslb.com/bfs/archive/534c96a2f85bbb51664db22e088374d622d85ca9.jpg"
        list.add(panda497)

        val panda498 = PetVideo()
        panda498.type = VideoType.PANDA.ordinal
        panda498.fileName = "panda_group_panda498"
        panda498.code = 2410
        panda498.duration = 61
        panda498.period = PeriodType.GROUP.ordinal
        panda498.star = false
        panda498.title = "考古视频：奥莉奥带领弟弟妹妹努力干饭 260"
        panda498.releaseTime = 1637846417
        panda498.originalUrl = "https://www.bilibili.com/video/BV1SF411h7PA"
        panda498.tags = "大熊猫,萌宠,动物圈"
        panda498.authorId = 26698409
        panda498.cover =
            "https://i2.hdslb.com/bfs/archive/85db9899b26448149c4bfddfd64ef8377ee3e375.jpg"
        list.add(panda498)

        val panda499 = PetVideo()
        panda499.type = VideoType.PANDA.ordinal
        panda499.fileName = "panda_group_panda499"
        panda499.code = 2411
        panda499.duration = 91
        panda499.period = PeriodType.GROUP.ordinal
        panda499.star = false
        panda499.title = "考古视频：大熊猫淼淼表演杂技吓坏小伙伴 220908"
        panda499.releaseTime = 1662639600
        panda499.originalUrl = "https://www.bilibili.com/video/BV1Qe4y1d7Pq"
        panda499.tags = "大熊猫,萌宠,动物圈"
        panda499.authorId = 26698409
        panda499.cover =
            "https://i0.hdslb.com/bfs/archive/1ac7caad90cfd1fb0e246afdf336851abae335fb.jpg"
        list.add(panda499)

        val panda500 = PetVideo()
        panda500.type = VideoType.PANDA.ordinal
        panda500.fileName = "panda_group_panda500"
        panda500.code = 2412
        panda500.duration = 77
        panda500.period = PeriodType.GROUP.ordinal
        panda500.star = false
        panda500.title = "艾玖要贴在花花teitei上，花花不让艾玖贴在teitei上，花花一把推开了艾玖玖【大熊猫和花.艾玖】"
        panda500.releaseTime = 1662806283
        panda500.originalUrl = "https://www.bilibili.com/video/BV1We411u7Mg"
        panda500.tags = "大熊猫,萌宠,动物圈"
        panda500.authorId = 16468440
        panda500.cover =
            "https://i2.hdslb.com/bfs/archive/663730a07b3c0b9f1f65621d2596b0f97c5df3d6.jpg"
        list.add(panda500)

        val panda501 = PetVideo()
        panda501.type = VideoType.PANDA.ordinal
        panda501.fileName = "panda_group_panda501"
        panda501.code = 2413
        panda501.duration = 23
        panda501.period = PeriodType.GROUP.ordinal
        panda501.star = false
        panda501.title = "大熊猫玩偷袭有多可爱"
        panda501.releaseTime = 1662693761
        panda501.originalUrl = "https://www.bilibili.com/video/BV12P41137aU"
        panda501.tags = "大熊猫,萌宠,动物圈"
        panda501.authorId = 1025949925
        panda501.cover =
            "https://i2.hdslb.com/bfs/archive/e1387673d88cb4ac3e040dd712bf7a90d231f931.jpg"
        list.add(panda501)

        val panda502 = PetVideo()
        panda502.type = VideoType.PANDA.ordinal
        panda502.fileName = "panda_group_panda502"
        panda502.code = 2414
        panda502.duration = 70
        panda502.period = PeriodType.GROUP.ordinal
        panda502.star = false
        panda502.title = "润玥在木架上板来板去，像极了闹觉的小朋友，终于把自己哄睡着了！【大熊猫润玥】"
        panda502.releaseTime = 1662703680
        panda502.originalUrl = "https://www.bilibili.com/video/BV1Ne411u7M7"
        panda502.tags = "大熊猫,萌宠,动物圈"
        panda502.authorId = 16468440
        panda502.cover =
            "https://i2.hdslb.com/bfs/archive/e3f4a4dd052e9acff0e0d11fde0d4ad333a360dc.jpg"
        list.add(panda502)

        val panda503 = PetVideo()
        panda503.type = VideoType.PANDA.ordinal
        panda503.fileName = "panda_group_panda503"
        panda503.code = 2415
        panda503.duration = 118
        panda503.period = PeriodType.GROUP.ordinal
        panda503.star = false
        panda503.title = "看和叶是怎样一步一步把大宝坐夺回来的"
        panda503.releaseTime = 1662714365
        panda503.originalUrl = "https://www.bilibili.com/video/BV1kY4y1M7xL"
        panda503.tags = "大熊猫,萌宠,动物圈"
        panda503.authorId = 1714028276
        panda503.cover =
            "https://i0.hdslb.com/bfs/archive/84ae42d089415daa1506cb903bdb0d983bf58eb8.jpg"
        list.add(panda503)

        val panda504 = PetVideo()
        panda504.type = VideoType.PANDA.ordinal
        panda504.fileName = "panda_group_panda504"
        panda504.code = 2416
        panda504.duration = 66
        panda504.period = PeriodType.GROUP.ordinal
        panda504.star = false
        panda504.title = "和叶:下班和吃零食我的生物钟非常准，不用爷爷喊的"
        panda504.releaseTime = 1661329440
        panda504.originalUrl = "https://www.bilibili.com/video/BV1rP41157x6"
        panda504.tags = "大熊猫,萌宠,动物圈"
        panda504.authorId = 1714028276
        panda504.cover =
            "https://i1.hdslb.com/bfs/archive/7f40707de6fd8d5960e8833d5e401e3efc284d1b.jpg"
        list.add(panda504)

        val panda505 = PetVideo()
        panda505.type = VideoType.PANDA.ordinal
        panda505.fileName = "panda_group_panda505"
        panda505.code = 2417
        panda505.duration = 82
        panda505.period = PeriodType.GROUP.ordinal
        panda505.star = false
        panda505.title = "喜欢【掏兜兜】的超级可爱大熊猫，还喜欢啃jiojio"
        panda505.releaseTime = 1662606281
        panda505.originalUrl = "https://www.bilibili.com/video/BV1AD4y1q761"
        panda505.tags = "大熊猫,萌宠,动物圈"
        panda505.authorId = 16468440
        panda505.cover =
            "https://i0.hdslb.com/bfs/archive/e19010a56659fb8a8e441ea65493de71e195eead.jpg"
        list.add(panda505)

        val panda506 = PetVideo()
        panda506.type = VideoType.PANDA.ordinal
        panda506.fileName = "panda_group_panda506"
        panda506.code = 2418
        panda506.duration = 215
        panda506.period = PeriodType.GROUP.ordinal
        panda506.star = false
        panda506.title = "花花成功护住了属于她的小果果 吃完还有两个清理小桌板的"
        panda506.releaseTime = 1662607105
        panda506.originalUrl = "https://www.bilibili.com/video/BV1Se4y1h74q"
        panda506.tags = "大熊猫,萌宠,动物圈"
        panda506.authorId = 1714028276
        panda506.cover =
            "https://i1.hdslb.com/bfs/archive/2416e9a0a92a9dfdf5d3dfa37ad65b7c69a4995c.jpg"
        list.add(panda506)

        val panda507 = PetVideo()
        panda507.type = VideoType.PANDA.ordinal
        panda507.fileName = "panda_group_panda507"
        panda507.code = 2419
        panda507.duration = 70
        panda507.period = PeriodType.GROUP.ordinal
        panda507.star = false
        panda507.title = "花花：爷爷叫我回家喝奶berber了，见面会就开到这吧！"
        panda507.releaseTime = 1662611495
        panda507.originalUrl = "https://www.bilibili.com/video/BV14U4y1z73H"
        panda507.tags = "大熊猫,萌宠,动物圈"
        panda507.authorId = 34677299
        panda507.cover =
            "https://i2.hdslb.com/bfs/archive/17bda6b762d922d8d2eba2a338651a5733158622.jpg"
        list.add(panda507)

        val panda508 = PetVideo()
        panda508.type = VideoType.PANDA.ordinal
        panda508.fileName = "panda_group_panda508"
        panda508.code = 2420
        panda508.duration = 21
        panda508.period = PeriodType.GROUP.ordinal
        panda508.star = false
        panda508.title = "静态的花花可漂亮啦～"
        panda508.releaseTime = 1661994172
        panda508.originalUrl = "https://www.bilibili.com/video/BV1Be4y1d7x4"
        panda508.tags = "大熊猫,萌宠,动物圈"
        panda508.authorId = 1198136200
        panda508.cover =
            "https://i1.hdslb.com/bfs/archive/44b847ae5ba3ffbcadd47b60842e89b33769c3a1.jpg"
        list.add(panda508)

        val panda509 = PetVideo()
        panda509.type = VideoType.PANDA.ordinal
        panda509.fileName = "panda_group_panda509"
        panda509.code = 2421
        panda509.duration = 173
        panda509.period = PeriodType.GROUP.ordinal
        panda509.star = false
        panda509.title = "fa仔：我弟真的有点瓜，我要代表妈妈收拾他。【大熊猫和花、和叶、艾玖】"
        panda509.releaseTime = 1662557644
        panda509.originalUrl = "https://www.bilibili.com/video/BV1rP41137MD"
        panda509.tags = "大熊猫,萌宠,动物圈"
        panda509.authorId = 514531996
        panda509.cover =
            "https://i0.hdslb.com/bfs/archive/8add360c1d9be68e1e91e6b50f0364bcb8b642f2.jpg"
        list.add(panda509)

        val panda510 = PetVideo()
        panda510.type = VideoType.PANDA.ordinal
        panda510.fileName = "panda_group_panda510"
        panda510.code = 2422
        panda510.duration = 136
        panda510.period = PeriodType.GROUP.ordinal
        panda510.star = false
        panda510.title = "【大熊猫和花】重量级钓猫，花花力扛所有！"
        panda510.releaseTime = 1662548400
        panda510.originalUrl = "https://www.bilibili.com/video/BV1Ad4y137hs"
        panda510.tags = "大熊猫,萌宠,动物圈"
        panda510.authorId = 327377672
        panda510.cover =
            "https://i0.hdslb.com/bfs/archive/b7e3f51994094fdc81ab8e248f6148b57e734140.jpg"
        list.add(panda510)

        val panda511 = PetVideo()
        panda511.type = VideoType.PANDA.ordinal
        panda511.fileName = "panda_group_panda511"
        panda511.code = 2423
        panda511.duration = 113
        panda511.period = PeriodType.GROUP.ordinal
        panda511.star = false
        panda511.title = "两个大姐在展示她的绝技吗"
        panda511.releaseTime = 1662521675
        panda511.originalUrl = "https://www.bilibili.com/video/BV1Hd4y1X7ao"
        panda511.tags = "大熊猫,萌宠,动物圈"
        panda511.authorId = 1714028276
        panda511.cover =
            "https://i0.hdslb.com/bfs/archive/b50c9f1af89dff6ff463e668e7df0eefdadbcc65.jpg"
        list.add(panda511)

        val panda512 = PetVideo()
        panda512.type = VideoType.PANDA.ordinal
        panda512.fileName = "panda_group_panda512"
        panda512.code = 2424
        panda512.duration = 84
        panda512.period = PeriodType.GROUP.ordinal
        panda512.star = false
        panda512.title = "花儿踩到一块跷跷木板，顺便开起了粉丝见面会，这谁不迷糊呢？！【大熊猫和花】"
        panda512.releaseTime = 1662517543
        panda512.originalUrl = "https://www.bilibili.com/video/BV19t4y177jW"
        panda512.tags = "大熊猫,萌宠,动物圈"
        panda512.authorId = 16468440
        panda512.cover =
            "https://i2.hdslb.com/bfs/archive/bc042be0698cdd1be99d9006dde3dd7ee3364a06.jpg"
        list.add(panda512)

        val panda513 = PetVideo()
        panda513.type = VideoType.PANDA.ordinal
        panda513.fileName = "panda_group_panda513"
        panda513.code = 2425
        panda513.duration = 136
        panda513.period = PeriodType.GROUP.ordinal
        panda513.star = false
        panda513.title = "【大熊猫和花】钓猫"
        panda513.releaseTime = 1662462000
        panda513.originalUrl = "https://www.bilibili.com/video/BV1Ke4y1a7gq"
        panda513.tags = "大熊猫,萌宠,动物圈"
        panda513.authorId = 327377672
        panda513.cover =
            "https://i1.hdslb.com/bfs/archive/9b473a5f9fe5593ba05f209c990a1ab14bd12321.jpg"
        list.add(panda513)

        val panda514 = PetVideo()
        panda514.type = VideoType.PANDA.ordinal
        panda514.fileName = "panda_group_panda514"
        panda514.code = 2426
        panda514.duration = 148
        panda514.period = PeriodType.GROUP.ordinal
        panda514.star = false
        panda514.title = "谭爷爷带着窝窝头来接花花放学啦！花花最后乖乖回家了吗？剧情有反转哦(*°▽°*）♪"
        panda514.releaseTime = 1662451680
        panda514.originalUrl = "https://www.bilibili.com/video/BV14Y4y1M7de"
        panda514.tags = "大熊猫,萌宠,动物圈"
        panda514.authorId = 16468440
        panda514.cover =
            "https://i0.hdslb.com/bfs/archive/45011e0f5decaad525c92137df356393515882b3.jpg"
        list.add(panda514)

        val panda515 = PetVideo()
        panda515.type = VideoType.PANDA.ordinal
        panda515.fileName = "panda_group_panda515"
        panda515.code = 2427
        panda515.duration = 105
        panda515.period = PeriodType.GROUP.ordinal
        panda515.star = false
        panda515.title = "这天下着小雨，国宝们都在干嘛呢"
        panda515.releaseTime = 1662435228
        panda515.originalUrl = "https://www.bilibili.com/video/BV1EB4y137LJ"
        panda515.tags = "大熊猫,萌宠,动物圈"
        panda515.authorId = 1025949925
        panda515.cover =
            "https://i0.hdslb.com/bfs/archive/b5e05bcfd7de61a53ba7cd1c1ed2b38b15a26248.jpg"
        list.add(panda515)

        val panda516 = PetVideo()
        panda516.type = VideoType.PANDA.ordinal
        panda516.fileName = "panda_group_panda516"
        panda516.code = 2428
        panda516.duration = 79
        panda516.period = PeriodType.GROUP.ordinal
        panda516.star = false
        panda516.title = "这什么操作，咋还气鼓气鼓的呢😂"
        panda516.releaseTime = 1660718695
        panda516.originalUrl = "https://www.bilibili.com/video/BV1Md4y1P7Bp"
        panda516.tags = "大熊猫,萌宠,动物圈"
        panda516.authorId = 1714028276
        panda516.cover =
            "https://i0.hdslb.com/bfs/archive/51552792fded865ee04fd3bcd0c8b2d0377276bb.jpg"
        list.add(panda516)

        val panda517 = PetVideo()
        panda517.type = VideoType.PANDA.ordinal
        panda517.fileName = "panda_group_panda517"
        panda517.code = 2429
        panda517.duration = 116
        panda517.period = PeriodType.GROUP.ordinal
        panda517.star = false
        panda517.title = "和叶:下班了，爷爷在叫我，赶快冲啊"
        panda517.releaseTime = 1658225645
        panda517.originalUrl = "https://www.bilibili.com/video/BV1MT411n7WS"
        panda517.tags = "大熊猫,萌宠,动物圈"
        panda517.authorId = 1714028276
        panda517.cover =
            "https://i0.hdslb.com/bfs/archive/ece0a5d0f48aec185028fd76d04768d34ad54c87.jpg"
        list.add(panda517)

        val panda518 = PetVideo()
        panda518.type = VideoType.PANDA.ordinal
        panda518.fileName = "panda_group_panda518"
        panda518.code = 2430
        panda518.duration = 69
        panda518.period = PeriodType.GROUP.ordinal
        panda518.star = false
        panda518.title = "【大熊猫和花】花花，吃饱饱了吗，今天沟里没有果果噢～"
        panda518.releaseTime = 1662418800
        panda518.originalUrl = "https://www.bilibili.com/video/BV18t4y1775g"
        panda518.tags = "大熊猫,萌宠,动物圈"
        panda518.authorId = 484440897
        panda518.cover =
            "https://i2.hdslb.com/bfs/archive/964e25af6291eb0c6fa252c4eb958c3a2a62f35d.jpg"
        list.add(panda518)

        val panda519 = PetVideo()
        panda519.type = VideoType.PANDA.ordinal
        panda519.fileName = "panda_group_panda519"
        panda519.code = 2431
        panda519.duration = 87
        panda519.period = PeriodType.GROUP.ordinal
        panda519.star = false
        panda519.title = "花花的腿腿又长长了，小脚丫一蹬一蹬的，很可爱😘😘😘"
        panda519.releaseTime = 1661754635
        panda519.originalUrl = "https://www.bilibili.com/video/BV17P4y1f7JH"
        panda519.tags = "大熊猫,萌宠,动物圈"
        panda519.authorId = 1714028276
        panda519.cover =
            "https://i2.hdslb.com/bfs/archive/522745ae3ef26ec6fba013306e073f39942c8e2e.jpg"
        list.add(panda519)

        val panda520 = PetVideo()
        panda520.type = VideoType.PANDA.ordinal
        panda520.fileName = "panda_group_panda520"
        panda520.code = 2432
        panda520.duration = 120
        panda520.period = PeriodType.GROUP.ordinal
        panda520.star = false
        panda520.title = "五只嘤嘤怪"
        panda520.releaseTime = 1662350757
        panda520.originalUrl = "https://www.bilibili.com/video/BV1bP411V7yD"
        panda520.tags = "大熊猫,萌宠,动物圈"
        panda520.authorId = 1025949925
        panda520.cover =
            "https://i0.hdslb.com/bfs/archive/d1a50ea9dc879adc5c05da7761e8cf0de4d3a6c4.jpg"
        list.add(panda520)

        val panda521 = PetVideo()
        panda521.type = VideoType.PANDA.ordinal
        panda521.fileName = "panda_group_panda521"
        panda521.code = 2433
        panda521.duration = 98
        panda521.period = PeriodType.GROUP.ordinal
        panda521.star = false
        panda521.title = "花花一边掏兜兜，一边还不忘抬头看看游客"
        panda521.releaseTime = 1662191690
        panda521.originalUrl = "https://www.bilibili.com/video/BV1uK411f7CJ"
        panda521.tags = "大熊猫,萌宠,动物圈"
        panda521.authorId = 1714028276
        panda521.cover =
            "https://i0.hdslb.com/bfs/archive/7532e35c8898a78b7345f2a852f4f095c6db0069.jpg"
        list.add(panda521)

        val panda522 = PetVideo()
        panda522.type = VideoType.PANDA.ordinal
        panda522.fileName = "panda_group_panda522"
        panda522.code = 2434
        panda522.duration = 520
        panda522.period = PeriodType.GROUP.ordinal
        panda522.star = false
        panda522.title = "【大熊猫和花和叶】：又来吃笋了～（库存）"
        panda522.releaseTime = 1662332400
        panda522.originalUrl = "https://www.bilibili.com/video/BV1bD4y1B7EF"
        panda522.tags = "大熊猫,萌宠,动物圈"
        panda522.authorId = 484440897
        panda522.cover =
            "https://i0.hdslb.com/bfs/archive/7d11352cf62a22755669ec93f5e13737bfa73e9e.jpg"
        list.add(panda522)

        val panda523 = PetVideo()
        panda523.type = VideoType.PANDA.ordinal
        panda523.fileName = "panda_group_panda523"
        panda523.code = 2435
        panda523.duration = 33
        panda523.period = PeriodType.GROUP.ordinal
        panda523.star = false
        panda523.title = "【大熊猫】御姐特工和花：要横行霸道一辈子（ 金克丝配音）"
        panda523.releaseTime = 1645875848
        panda523.originalUrl = "https://www.bilibili.com/video/BV1wq4y1b7TG"
        panda523.tags = "大熊猫,萌宠,动物圈"
        panda523.authorId = 327377672
        panda523.cover =
            "https://i0.hdslb.com/bfs/archive/cdfb14b731a55841c379804fb8dbb792d34afd0b.jpg"
        list.add(panda523)

        val panda524 = PetVideo()
        panda524.type = VideoType.PANDA.ordinal
        panda524.fileName = "panda_group_panda524"
        panda524.code = 2436
        panda524.duration = 114
        panda524.period = PeriodType.GROUP.ordinal
        panda524.star = false
        panda524.title = "【大熊猫】和花艾玖"
        panda524.releaseTime = 1662335248
        panda524.originalUrl = "https://www.bilibili.com/video/BV12K411Z7LG"
        panda524.tags = "大熊猫,萌宠,动物圈"
        panda524.authorId = 327377672
        panda524.cover =
            "https://i1.hdslb.com/bfs/archive/fa9465161ad3ec2e078fc85780266b96c81ad171.jpg"
        list.add(panda524)

        val panda525 = PetVideo()
        panda525.type = VideoType.PANDA.ordinal
        panda525.fileName = "panda_group_panda525"
        panda525.code = 2437
        panda525.duration = 109
        panda525.period = PeriodType.GROUP.ordinal
        panda525.star = false
        panda525.title = "艾玖玖要贴贴，菜菜好无奈，和叶：不敢动不敢动！"
        panda525.releaseTime = 1662352268
        panda525.originalUrl = "https://www.bilibili.com/video/BV1CD4y1B7sv"
        panda525.tags = "大熊猫,萌宠,动物圈"
        panda525.authorId = 16468440
        panda525.cover =
            "https://i2.hdslb.com/bfs/archive/a3d7242c63d615ca0113a8ee95849e8a22f01130.jpg"
        list.add(panda525)

        val panda526 = PetVideo()
        panda526.type = VideoType.PANDA.ordinal
        panda526.fileName = "panda_group_panda526"
        panda526.code = 2438
        panda526.duration = 326
        panda526.period = PeriodType.GROUP.ordinal
        panda526.star = false
        panda526.title = "【大熊猫金喜金双福双重阳】二班猪猪熊来了～别问茱萸，问就是在树上～"
        panda526.releaseTime = 1662354000
        panda526.originalUrl = "https://www.bilibili.com/video/BV16d4y1G75r"
        panda526.tags = "大熊猫,萌宠,动物圈"
        panda526.authorId = 484440897
        panda526.cover =
            "https://i2.hdslb.com/bfs/archive/5163e02dd0da0cc9d578c7448c9b4d365b06419e.jpg"
        list.add(panda526)

        val panda527 = PetVideo()
        panda527.type = VideoType.PANDA.ordinal
        panda527.fileName = "panda_group_panda527"
        panda527.code = 2439
        panda527.duration = 51
        panda527.period = PeriodType.GROUP.ordinal
        panda527.star = false
        panda527.title = "福双：突然很嗨 大战金喜金双兄妹"
        panda527.releaseTime = 1662279057
        panda527.originalUrl = "https://www.bilibili.com/video/BV18d4y1R7xB"
        panda527.tags = "大熊猫,萌宠,动物圈"
        panda527.authorId = 442701460
        panda527.cover =
            "https://i2.hdslb.com/bfs/archive/ed037f8ae1d5ac8d23c208d37f777f0a0d011a95.jpg"
        list.add(panda527)

        val panda528 = PetVideo()
        panda528.type = VideoType.PANDA.ordinal
        panda528.fileName = "panda_group_panda528"
        panda528.code = 2440
        panda528.duration = 77
        panda528.period = PeriodType.GROUP.ordinal
        panda528.star = false
        panda528.title = "送你一颗长腿盆栽花花！【大熊猫和花】"
        panda528.releaseTime = 1662294422
        panda528.originalUrl = "https://www.bilibili.com/video/BV1gd4y1R7AJ"
        panda528.tags = "大熊猫,萌宠,动物圈"
        panda528.authorId = 16468440
        panda528.cover =
            "https://i2.hdslb.com/bfs/archive/1f5dd6b833951c35e592a96db34f94ebf596e75e.jpg"
        list.add(panda528)

        val panda529 = PetVideo()
        panda529.type = VideoType.PANDA.ordinal
        panda529.fileName = "panda_group_panda529"
        panda529.code = 2441
        panda529.duration = 78
        panda529.period = PeriodType.GROUP.ordinal
        panda529.star = false
        panda529.title = "【大熊猫和花】和花艾玖坐排排吃竹笋"
        panda529.releaseTime = 1662289200
        panda529.originalUrl = "https://www.bilibili.com/video/BV1EV4y1u7L8"
        panda529.tags = "大熊猫,萌宠,动物圈"
        panda529.authorId = 327377672
        panda529.cover =
            "https://i0.hdslb.com/bfs/archive/0130e2c36ab1db9f4c74310148996b8c58a795fb.jpg"
        list.add(panda529)

        val panda530 = PetVideo()
        panda530.type = VideoType.PANDA.ordinal
        panda530.fileName = "panda_group_panda530"
        panda530.code = 2442
        panda530.duration = 66
        panda530.period = PeriodType.GROUP.ordinal
        panda530.star = false
        panda530.title = "大熊猫打架奇一难得战神时刻 王八拳虎虎生风"
        panda530.releaseTime = 1571402833
        panda530.originalUrl = "https://www.bilibili.com/video/BV19E411r7Bs"
        panda530.tags = "大熊猫,萌宠,动物圈"
        panda530.authorId = 269899367
        panda530.cover =
            "https://i1.hdslb.com/bfs/archive/3585d37cc619a10811f21ba2d967f1d9088d8cb3.jpg"
        list.add(panda530)

        val panda531 = PetVideo()
        panda531.type = VideoType.PANDA.ordinal
        panda531.fileName = "panda_group_panda531"
        panda531.code = 2443
        panda531.duration = 40
        panda531.period = PeriodType.GROUP.ordinal
        panda531.star = false
        panda531.title = "大熊猫和花、润玥-小姐妹的饭后时光"
        panda531.releaseTime = 1662026516
        panda531.originalUrl = "https://www.bilibili.com/video/BV1rW4y1t7Ei"
        panda531.tags = "大熊猫,萌宠,动物圈"
        panda531.authorId = 1307515
        panda531.cover =
            "https://i1.hdslb.com/bfs/archive/71a3aa048129fba9bd7534383e19a9a20c90154f.jpg"
        list.add(panda531)

        val panda532 = PetVideo()
        panda532.type = VideoType.PANDA.ordinal
        panda532.fileName = "panda_group_panda532"
        panda532.code = 2444
        panda532.duration = 420
        panda532.period = PeriodType.GROUP.ordinal
        panda532.star = false
        panda532.title = "【大熊猫和花】自娱自乐：大号毛绒玩具复活了"
        panda532.releaseTime = 1662246000
        panda532.originalUrl = "https://www.bilibili.com/video/BV1Se4y1Y7FE"
        panda532.tags = "大熊猫,萌宠,动物圈"
        panda532.authorId = 484440897
        panda532.cover =
            "https://i2.hdslb.com/bfs/archive/d985c59c9ef960309ec4fc1799545cba2e2c0e17.jpg"
        list.add(panda532)

        val panda533 = PetVideo()
        panda533.type = VideoType.PANDA.ordinal
        panda533.fileName = "panda_group_panda533"
        panda533.code = 2445
        panda533.duration = 90
        panda533.period = PeriodType.GROUP.ordinal
        panda533.star = false
        panda533.title = "花花，虽然你喜欢碰瓷，但还是要注意安全啊【大熊猫和花、艾玖】"
        panda533.releaseTime = 1662182257
        panda533.originalUrl = "https://www.bilibili.com/video/BV1qB4y1g7jz"
        panda533.tags = "大熊猫,萌宠,动物圈"
        panda533.authorId = 230382720
        panda533.cover =
            "https://i1.hdslb.com/bfs/archive/876c08898810006ff966555b7052f9666eb9ad66.jpg"
        list.add(panda533)

        val panda534 = PetVideo()
        panda534.type = VideoType.PANDA.ordinal
        panda534.fileName = "panda_group_panda534"
        panda534.code = 2446
        panda534.duration = 65
        panda534.period = PeriodType.GROUP.ordinal
        panda534.star = false
        panda534.title = "熊孩子开学第一天，秋天第一杯奶茶"
        panda534.releaseTime = 1662041847
        panda534.originalUrl = "https://www.bilibili.com/video/BV1x14y1s7aY"
        panda534.tags = "大熊猫,萌宠,动物圈"
        panda534.authorId = 1809127548
        panda534.cover =
            "https://i2.hdslb.com/bfs/archive/5edf0971753e923c42c6e6fea23cd909d86dc144.jpg"
        list.add(panda534)

        val panda535 = PetVideo()
        panda535.type = VideoType.PANDA.ordinal
        panda535.fileName = "panda_group_panda535"
        panda535.code = 2447
        panda535.duration = 135
        panda535.period = PeriodType.GROUP.ordinal
        panda535.star = false
        panda535.title = "【大熊猫和花】半路偶遇姐姐山～"
        panda535.releaseTime = 1662110657
        panda535.originalUrl = "https://www.bilibili.com/video/BV1dB4y1g7bK"
        panda535.tags = "大熊猫,萌宠,动物圈"
        panda535.authorId = 484440897
        panda535.cover =
            "https://i1.hdslb.com/bfs/archive/8f243eb8b418637da2f5577e61d0ef5b0adefcdb.jpg"
        list.add(panda535)

        val panda536 = PetVideo()
        panda536.type = VideoType.PANDA.ordinal
        panda536.fileName = "panda_group_panda536"
        panda536.code = 2448
        panda536.duration = 108
        panda536.period = PeriodType.GROUP.ordinal
        panda536.star = false
        panda536.title = "爷爷一叫，吨吨吨奔跑的坦克花，和二狗你追我赶"
        panda536.releaseTime = 1662114586
        panda536.originalUrl = "https://www.bilibili.com/video/BV1Md4y1V7Sp"
        panda536.tags = "大熊猫,萌宠,动物圈"
        panda536.authorId = 34677299
        panda536.cover =
            "https://i1.hdslb.com/bfs/archive/67845a1951667e1bfa3242b9ea371924577694bc.jpg"
        list.add(panda536)

        val panda537 = PetVideo()
        panda537.type = VideoType.PANDA.ordinal
        panda537.fileName = "panda_group_panda537"
        panda537.code = 2449
        panda537.duration = 171
        panda537.period = PeriodType.GROUP.ordinal
        panda537.star = false
        panda537.title = "【大熊猫和花艾玖】逛gāigāi的俩小闺蜜～"
        panda537.releaseTime = 1662159600
        panda537.originalUrl = "https://www.bilibili.com/video/BV1YG4y1k72T"
        panda537.tags = "大熊猫,萌宠,动物圈"
        panda537.authorId = 484440897
        panda537.cover =
            "https://i0.hdslb.com/bfs/archive/9c9db9f48ebdac6ee02f323caddfdffc29246c82.jpg"
        list.add(panda537)

        val panda538 = PetVideo()
        panda538.type = VideoType.PANDA.ordinal
        panda538.fileName = "panda_group_panda538"
        panda538.code = 2450
        panda538.duration = 73
        panda538.period = PeriodType.GROUP.ordinal
        panda538.star = false
        panda538.title = "8月31钓猫，花宝乖乖坐着吃窝头"
        panda538.releaseTime = 1662100567
        panda538.originalUrl = "https://www.bilibili.com/video/BV1rY4y1T7DC"
        panda538.tags = "大熊猫,萌宠,动物圈"
        panda538.authorId = 97315338
        panda538.cover =
            "https://i1.hdslb.com/bfs/archive/12de9f50213b0a05200aa41a70cbbb296ac24540.jpg"
        list.add(panda538)

        val panda539 = PetVideo()
        panda539.type = VideoType.PANDA.ordinal
        panda539.fileName = "panda_group_panda539"
        panda539.code = 2451
        panda539.duration = 216
        panda539.period = PeriodType.GROUP.ordinal
        panda539.star = false
        panda539.title = "睡美熊和花花正脸营业，挠痒痒打哈欠，花宝叽太可爱了！！！"
        panda539.releaseTime = 1662093979
        panda539.originalUrl = "https://www.bilibili.com/video/BV1Fd4y1V7mU"
        panda539.tags = "大熊猫,萌宠,动物圈"
        panda539.authorId = 230382720
        panda539.cover =
            "https://i1.hdslb.com/bfs/archive/0b629847f3133f32f8e168449106c8ec85df1b3f.jpg"
        list.add(panda539)

        val panda540 = PetVideo()
        panda540.type = VideoType.PANDA.ordinal
        panda540.fileName = "panda_group_panda540"
        panda540.code = 2452
        panda540.duration = 134
        panda540.period = PeriodType.GROUP.ordinal
        panda540.star = false
        panda540.title = "润玥：下班了花花，快点走"
        panda540.releaseTime = 1662073200
        panda540.originalUrl = "https://www.bilibili.com/video/BV1FY4y1g7LY"
        panda540.tags = "大熊猫,萌宠,动物圈"
        panda540.authorId = 484440897
        panda540.cover =
            "https://i1.hdslb.com/bfs/archive/e058de06dded4485c5a9d51d3dbda2e10652bf54.jpg"
        list.add(panda540)

        val panda541 = PetVideo()
        panda541.type = VideoType.PANDA.ordinal
        panda541.fileName = "panda_group_panda541"
        panda541.code = 2453
        panda541.duration = 71
        panda541.period = PeriodType.GROUP.ordinal
        panda541.star = false
        panda541.title = "花花，你听到小朋友给你加油了吗？又真挚又可爱！【大熊猫和花】"
        panda541.releaseTime = 1662002880
        panda541.originalUrl = "https://www.bilibili.com/video/BV1Ke4y1Y73T"
        panda541.tags = "大熊猫,萌宠,动物圈"
        panda541.authorId = 16468440
        panda541.cover =
            "https://i1.hdslb.com/bfs/archive/0cc06955205504ceed3b2a72c594de2a898d5b96.jpg"
        list.add(panda541)

        val panda542 = PetVideo()
        panda542.type = VideoType.PANDA.ordinal
        panda542.fileName = "panda_group_panda542"
        panda542.code = 2454
        panda542.duration = 103
        panda542.period = PeriodType.GROUP.ordinal
        panda542.star = false
        panda542.title = "【大熊猫】 情感导师重阳带福双从社恐到社牛"
        panda542.releaseTime = 1661943600
        panda542.originalUrl = "https://www.bilibili.com/video/BV1hP4y1f7KT"
        panda542.tags = "大熊猫,萌宠,动物圈"
        panda542.authorId = 327377672
        panda542.cover =
            "https://i0.hdslb.com/bfs/archive/c8e64eddd726d3c955c9d218445c2bc0a2711bb1.jpg"
        list.add(panda542)

        val panda543 = PetVideo()
        panda543.type = VideoType.PANDA.ordinal
        panda543.fileName = "panda_group_panda543"
        panda543.code = 2455
        panda543.duration = 71
        panda543.period = PeriodType.GROUP.ordinal
        panda543.star = false
        panda543.title = "花花的小苹果来了，这也太好吃了吧！【大熊猫和花】"
        panda543.releaseTime = 1661915907
        panda543.originalUrl = "https://www.bilibili.com/video/BV1fP411G7a4"
        panda543.tags = "大熊猫,萌宠,动物圈"
        panda543.authorId = 16468440
        panda543.cover =
            "https://i0.hdslb.com/bfs/archive/f80f7e5ff4951086aa356763023bfd95c6ccb969.jpg"
        list.add(panda543)

        val panda544 = PetVideo()
        panda544.type = VideoType.PANDA.ordinal
        panda544.fileName = "panda_group_panda544"
        panda544.code = 2456
        panda544.duration = 101
        panda544.period = PeriodType.GROUP.ordinal
        panda544.star = false
        panda544.title = "像不像润玥在叫花花一起爬树～（昨天花花下树之后的视频）"
        panda544.releaseTime = 1661900315
        panda544.originalUrl = "https://www.bilibili.com/video/BV1ct4y1J7Sz"
        panda544.tags = "大熊猫,萌宠,动物圈"
        panda544.authorId = 484440897
        panda544.cover =
            "https://i1.hdslb.com/bfs/archive/44a2478d35702bc91d1798ba37626d3bce78d7a3.jpg"
        list.add(panda544)

        val panda545 = PetVideo()
        panda545.type = VideoType.PANDA.ordinal
        panda545.fileName = "panda_group_panda545"
        panda545.code = 2457
        panda545.duration = 71
        panda545.period = PeriodType.GROUP.ordinal
        panda545.star = false
        panda545.title = "草草有点高，差点没发现有一只美能向我走来！【大熊猫和花】"
        panda545.releaseTime = 1661900640
        panda545.originalUrl = "https://www.bilibili.com/video/BV13U4y1r7nR"
        panda545.tags = "大熊猫,萌宠,动物圈"
        panda545.authorId = 16468440
        panda545.cover =
            "https://i0.hdslb.com/bfs/archive/27cc2e173297456c0e6b75c09089875ec237b9f7.jpg"
        list.add(panda545)

        val panda546 = PetVideo()
        panda546.type = VideoType.PANDA.ordinal
        panda546.fileName = "panda_group_panda546"
        panda546.code = 2458
        panda546.duration = 80
        panda546.period = PeriodType.GROUP.ordinal
        panda546.star = false
        panda546.title = "反向遛花视角～花不动我不动，花一动我心乱动～"
        panda546.releaseTime = 1660431600
        panda546.originalUrl = "https://www.bilibili.com/video/BV1GT411A7bo"
        panda546.tags = "大熊猫,萌宠,动物圈"
        panda546.authorId = 484440897
        panda546.cover =
            "https://i0.hdslb.com/bfs/archive/e773b28730132573bf216369aeda3418fbd4277f.jpg"
        list.add(panda546)

        val panda547 = PetVideo()
        panda547.type = VideoType.PANDA.ordinal
        panda547.fileName = "panda_group_panda547"
        panda547.code = 2459
        panda547.duration = 42
        panda547.period = PeriodType.GROUP.ordinal
        panda547.star = false
        panda547.title = "重阳：在吃什么？给我尝一口！福双：来吧，我的胖爪，咬一口！"
        panda547.releaseTime = 1661853245
        panda547.originalUrl = "https://www.bilibili.com/video/BV1Vt4y1J7PD"
        panda547.tags = "大熊猫,萌宠,动物圈"
        panda547.authorId = 34677299
        panda547.cover =
            "https://i2.hdslb.com/bfs/archive/ea12b687b7e24e67d744cea2896cd6f6890af14e.jpg"
        list.add(panda547)

        val panda548 = PetVideo()
        panda548.type = VideoType.PANDA.ordinal
        panda548.fileName = "panda_group_panda548"
        panda548.code = 2460
        panda548.duration = 273
        panda548.period = PeriodType.GROUP.ordinal
        panda548.star = false
        panda548.title = "奔走相告，花花秋季第一场爬树20220830～"
        panda548.releaseTime = 1661827075
        panda548.originalUrl = "https://www.bilibili.com/video/BV1mt4y1E7Pv"
        panda548.tags = "大熊猫,萌宠,动物圈"
        panda548.authorId = 484440897
        panda548.cover =
            "https://i0.hdslb.com/bfs/archive/a3ef0a3bd51c48814e616a11ef2607bfba53afdb.jpg"
        list.add(panda548)

        val panda549 = PetVideo()
        panda549.type = VideoType.PANDA.ordinal
        panda549.fileName = "panda_group_panda549"
        panda549.code = 2461
        panda549.duration = 42
        panda549.period = PeriodType.GROUP.ordinal
        panda549.star = false
        panda549.title = "花花：突然感觉头皮一紧～"
        panda549.releaseTime = 1661814000
        panda549.originalUrl = "https://www.bilibili.com/video/BV17G4y167pL"
        panda549.tags = "大熊猫,萌宠,动物圈"
        panda549.authorId = 484440897
        panda549.cover =
            "https://i1.hdslb.com/bfs/archive/0466e1ec768d9c92389ec0d9b4e9cc3ca3fdb160.jpg"
        list.add(panda549)

        val panda550 = PetVideo()
        panda550.type = VideoType.PANDA.ordinal
        panda550.fileName = "panda_group_panda550"
        panda550.code = 2462
        panda550.duration = 55
        panda550.period = PeriodType.GROUP.ordinal
        panda550.star = false
        panda550.title = "不想回家的茱萸"
        panda550.releaseTime = 1661742903
        panda550.originalUrl = "https://www.bilibili.com/video/BV1DU4y1B7vf"
        panda550.tags = "大熊猫,萌宠,动物圈"
        panda550.authorId = 1025949925
        panda550.cover =
            "https://i2.hdslb.com/bfs/archive/3bb5d145f7460d67b79a7f93b25e41c3d479a8f7.jpg"
        list.add(panda550)

        val panda551 = PetVideo()
        panda551.type = VideoType.PANDA.ordinal
        panda551.fileName = "panda_group_panda551"
        panda551.code = 2463
        panda551.duration = 184
        panda551.period = PeriodType.GROUP.ordinal
        panda551.star = false
        panda551.title = "你们听我解释，这真的是大熊猫！"
        panda551.releaseTime = 1637924409
        panda551.originalUrl = "https://www.bilibili.com/video/BV1eL4y1p7Zq"
        panda551.tags = "大熊猫,萌宠,动物圈"
        panda551.authorId = 1998535
        panda551.cover =
            "https://i0.hdslb.com/bfs/archive/b16de7fc3336aa0b9c5b101f11d4548cfb22baba.jpg"
        list.add(panda551)

        val panda552 = PetVideo()
        panda552.type = VideoType.PANDA.ordinal
        panda552.fileName = "panda_group_panda552"
        panda552.code = 2464
        panda552.duration = 61
        panda552.period = PeriodType.GROUP.ordinal
        panda552.star = false
        panda552.title = "〖大熊猫金喜〗〖大熊猫重阳〗〖大熊猫福双〗小2班三个大宝贝"
        panda552.releaseTime = 1659879187
        panda552.originalUrl = "https://www.bilibili.com/video/BV1mU4y1k7Vd"
        panda552.tags = "大熊猫,萌宠,动物圈"
        panda552.authorId = 690050620
        panda552.cover =
            "https://i1.hdslb.com/bfs/archive/d89bae94865e1403733d7b2fb9f23236a3cdadae.jpg"
        list.add(panda552)

        val panda553 = PetVideo()
        panda553.type = VideoType.PANDA.ordinal
        panda553.fileName = "panda_group_panda553"
        panda553.code = 2465
        panda553.duration = 81
        panda553.period = PeriodType.GROUP.ordinal
        panda553.star = false
        panda553.title = "【谭爷爷的小二班】小二班的五只猪又到开饭时间啦，瞧我们双妹儿的防御性抬脚😄😄😄"
        panda553.releaseTime = 1659937234
        panda553.originalUrl = "https://www.bilibili.com/video/BV1114y1t7N9"
        panda553.tags = "大熊猫,萌宠,动物圈"
        panda553.authorId = 1098561796
        panda553.cover =
            "https://i1.hdslb.com/bfs/archive/6ad42f028946aeb56baeb491cca9c2e05fe18f01.jpg"
        list.add(panda553)

        val panda554 = PetVideo()
        panda554.type = VideoType.PANDA.ordinal
        panda554.fileName = "panda_group_panda554"
        panda554.code = 2466
        panda554.duration = 253
        panda554.period = PeriodType.GROUP.ordinal
        panda554.star = false
        panda554.title = "和花：发生甚么了？艾玖：花花起来嗨～20220827"
        panda554.releaseTime = 1661578713
        panda554.originalUrl = "https://www.bilibili.com/video/BV1BT411w7Pc"
        panda554.tags = "大熊猫,萌宠,动物圈"
        panda554.authorId = 484440897
        panda554.cover =
            "https://i1.hdslb.com/bfs/archive/0697f8a3aa404ae8825602865f07aac6a0ac8e8f.jpg"
        list.add(panda554)

        val panda555 = PetVideo()
        panda555.type = VideoType.PANDA.ordinal
        panda555.fileName = "panda_group_panda555"
        panda555.code = 2467
        panda555.duration = 615
        panda555.period = PeriodType.GROUP.ordinal
        panda555.star = false
        panda555.title = "秋季的第一场钓猫，场面有点小混乱，但聪明花沟里找到了果果哈哈哈～20220828"
        panda555.releaseTime = 1661663986
        panda555.originalUrl = "https://www.bilibili.com/video/BV1WW4y1t7zy"
        panda555.tags = "大熊猫,萌宠,动物圈"
        panda555.authorId = 484440897
        panda555.cover =
            "https://i1.hdslb.com/bfs/archive/cd5649499adce879a2ed2f97b1e0494328730dd9.jpg"
        list.add(panda555)

        val panda556 = PetVideo()
        panda556.type = VideoType.PANDA.ordinal
        panda556.fileName = "panda_group_panda556"
        panda556.code = 2468
        panda556.duration = 159
        panda556.period = PeriodType.GROUP.ordinal
        panda556.star = false
        panda556.title = "8.26艾玖带崽，花花有样学样～"
        panda556.releaseTime = 1661641200
        panda556.originalUrl = "https://www.bilibili.com/video/BV19U4y167ou"
        panda556.tags = "大熊猫,萌宠,动物圈"
        panda556.authorId = 484440897
        panda556.cover =
            "https://i1.hdslb.com/bfs/archive/615707c163893830ebc3ae9be0f3fcefdbe3388e.jpg"
        list.add(panda556)

        val panda557 = PetVideo()
        panda557.type = VideoType.PANDA.ordinal
        panda557.fileName = "panda_group_panda557"
        panda557.code = 2469
        panda557.duration = 130
        panda557.period = PeriodType.GROUP.ordinal
        panda557.star = false
        panda557.title = "花花目标明确，专门挑战不容易爬的树【大熊猫和花】"
        panda557.releaseTime = 1661675273
        panda557.originalUrl = "https://www.bilibili.com/video/BV1xg411D7ci"
        panda557.tags = "大熊猫,萌宠,动物圈"
        panda557.authorId = 230382720
        panda557.cover =
            "https://i1.hdslb.com/bfs/archive/2b885b9519a4ea1cf9f89807e5965d0680939241.jpg"
        list.add(panda557)

        val panda558 = PetVideo()
        panda558.type = VideoType.PANDA.ordinal
        panda558.fileName = "panda_group_panda558"
        panda558.code = 2470
        panda558.duration = 95
        panda558.period = PeriodType.GROUP.ordinal
        panda558.star = false
        panda558.title = "fa仔：做个热情有礼貌的小能能。i99来贴一个！【大熊猫和花】"
        panda558.releaseTime = 1661608705
        panda558.originalUrl = "https://www.bilibili.com/video/BV1JP411L7ng"
        panda558.tags = "大熊猫,萌宠,动物圈"
        panda558.authorId = 514531996
        panda558.cover =
            "https://i2.hdslb.com/bfs/archive/f7152e8978804e3afe2472b0be859071523bf279.jpg"
        list.add(panda558)

        val panda559 = PetVideo()
        panda559.type = VideoType.PANDA.ordinal
        panda559.fileName = "panda_group_panda559"
        panda559.code = 2471
        panda559.duration = 408
        panda559.period = PeriodType.GROUP.ordinal
        panda559.star = false
        panda559.title = "【大熊猫】嘴炮小王子么么儿上线！宝宝可是会说四川话的小熊精哟！"
        panda559.releaseTime = 1519308655
        panda559.originalUrl = "https://www.bilibili.com/video/BV12W41177Xa"
        panda559.tags = "大熊猫,萌宠,动物圈"
        panda559.authorId = 22775716
        panda559.cover =
            "https://i1.hdslb.com/bfs/archive/d5c748a10101a8a1ab3b428df2525786ae16fb8e.jpg"
        list.add(panda559)

        val panda560 = PetVideo()
        panda560.type = VideoType.PANDA.ordinal
        panda560.fileName = "panda_group_panda560"
        panda560.code = 2472
        panda560.duration = 65
        panda560.period = PeriodType.GROUP.ordinal
        panda560.star = false
        panda560.title = "【大熊猫萌兰】【大熊猫萌宝萌玉】三兄妹排排坐吃竹竹"
        panda560.releaseTime = 1660894060
        panda560.originalUrl = "https://www.bilibili.com/video/BV1g14y1t732"
        panda560.tags = "大熊猫,萌宠,动物圈"
        panda560.authorId = 8928592
        panda560.cover =
            "https://i0.hdslb.com/bfs/archive/93a0bfd6cfb415d589c43be7f137a70a2a1058e3.jpg"
        list.add(panda560)

        val panda561 = PetVideo()
        panda561.type = VideoType.PANDA.ordinal
        panda561.fileName = "panda_group_panda561"
        panda561.code = 2473
        panda561.duration = 74
        panda561.period = PeriodType.GROUP.ordinal
        panda561.star = false
        panda561.title = "度过了近20天的高温假期，又开始营业的新鲜花宝叽【大熊猫和花】"
        panda561.releaseTime = 1661523596
        panda561.originalUrl = "https://www.bilibili.com/video/BV1Ta411R7ET"
        panda561.tags = "大熊猫,萌宠,动物圈"
        panda561.authorId = 230382720
        panda561.cover =
            "https://i2.hdslb.com/bfs/archive/0053b24736add37d213ca09b0db8a02a80c7452d.jpg"
        list.add(panda561)

        val panda562 = PetVideo()
        panda562.type = VideoType.PANDA.ordinal
        panda562.fileName = "panda_group_panda562"
        panda562.code = 2474
        panda562.duration = 46
        panda562.period = PeriodType.GROUP.ordinal
        panda562.star = false
        panda562.title = "饲养员：当时我就感觉眼前一黑……"
        panda562.releaseTime = 1661508000
        panda562.originalUrl = "https://www.bilibili.com/video/BV1GB4y1G7JB"
        panda562.tags = "大熊猫,萌宠,动物圈"
        panda562.authorId = 1998535
        panda562.cover =
            "https://i2.hdslb.com/bfs/archive/f89ae7e53bb9f3f098beeeb8993b2a4358988486.jpg"
        list.add(panda562)

        val panda563 = PetVideo()
        panda563.type = VideoType.PANDA.ordinal
        panda563.fileName = "panda_group_panda563"
        panda563.code = 2475
        panda563.duration = 42
        panda563.period = PeriodType.GROUP.ordinal
        panda563.star = false
        panda563.title = "【大熊猫和花】和花的邻居班都是怎样的高精尖熊才"
        panda563.releaseTime = 1661513146
        panda563.originalUrl = "https://www.bilibili.com/video/BV15D4y1675k"
        panda563.tags = "大熊猫,萌宠,动物圈"
        panda563.authorId = 327377672
        panda563.cover =
            "https://i2.hdslb.com/bfs/archive/2237af6c62b506880e79ba97cb5e289e1988c050.jpg"
        list.add(panda563)

        val panda564 = PetVideo()
        panda564.type = VideoType.PANDA.ordinal
        panda564.fileName = "panda_group_panda564"
        panda564.code = 2476
        panda564.duration = 78
        panda564.period = PeriodType.GROUP.ordinal
        panda564.star = false
        panda564.title = "我们花花真的好喜欢下雨呀，开心得直打滚！【大熊猫和花】"
        panda564.releaseTime = 1661491952
        panda564.originalUrl = "https://www.bilibili.com/video/BV16V4y1W7ho"
        panda564.tags = "大熊猫,萌宠,动物圈"
        panda564.authorId = 16468440
        panda564.cover =
            "https://i0.hdslb.com/bfs/archive/bece848a136aa42c431f93fe96ba49a4e2174395.jpg"
        list.add(panda564)

        val panda565 = PetVideo()
        panda565.type = VideoType.PANDA.ordinal
        panda565.fileName = "panda_group_panda565"
        panda565.code = 2477
        panda565.duration = 98
        panda565.period = PeriodType.GROUP.ordinal
        panda565.star = false
        panda565.title = "聪明的花花在草丛里捡到了谭爷爷藏的小苹果，太开心了，要躲起来慢慢吃！【大熊猫和花】"
        panda565.releaseTime = 1661402723
        panda565.originalUrl = "https://www.bilibili.com/video/BV14U4y1k7RA"
        panda565.tags = "大熊猫,萌宠,动物圈"
        panda565.authorId = 16468440
        panda565.cover =
            "https://i2.hdslb.com/bfs/archive/43f98fd11e085e64cf92d21732a28a7a52a3bf7c.jpg"
        list.add(panda565)

        val panda566 = PetVideo()
        panda566.type = VideoType.PANDA.ordinal
        panda566.fileName = "panda_group_panda566"
        panda566.code = 2478
        panda566.duration = 124
        panda566.period = PeriodType.GROUP.ordinal
        panda566.star = false
        panda566.title = "上个视频花花妞脖子的由来，费弟弟累了，哈哈（库存6.4 视频来源和花我的宝直播间录屏）"
        panda566.releaseTime = 1661320142
        panda566.originalUrl = "https://www.bilibili.com/video/BV1c14y1x7tm"
        panda566.tags = "大熊猫,萌宠,动物圈"
        panda566.authorId = 1852236806
        panda566.cover =
            "https://i2.hdslb.com/bfs/archive/308fdc6d6277c39a1d2dac857e8e5029c46f7c4a.jpg"
        list.add(panda566)

        val panda567 = PetVideo()
        panda567.type = VideoType.PANDA.ordinal
        panda567.fileName = "panda_group_panda567"
        panda567.code = 2479
        panda567.duration = 100
        panda567.period = PeriodType.GROUP.ordinal
        panda567.star = false
        panda567.title = "大家都在帮爷爷喊“花花”。。fa仔和弟弟一起往回走。【大熊猫和花、和叶】"
        panda567.releaseTime = 1661349605
        panda567.originalUrl = "https://www.bilibili.com/video/BV1ha41157cL"
        panda567.tags = "大熊猫,萌宠,动物圈"
        panda567.authorId = 514531996
        panda567.cover =
            "https://i2.hdslb.com/bfs/archive/9729cdef7806dda5f504cc7c5224297cf37fd79a.jpg"
        list.add(panda567)

        val panda568 = PetVideo()
        panda568.type = VideoType.PANDA.ordinal
        panda568.fileName = "panda_group_panda568"
        panda568.code = 2480
        panda568.duration = 86
        panda568.period = PeriodType.GROUP.ordinal
        panda568.star = false
        panda568.title = "大河向东流哇！陈园润唱好汉歌哇！挖煤三宝&九菜花园【大熊猫园润】【大熊猫和花】【大熊猫润玥】【大熊猫奥莉奥】"
        panda568.releaseTime = 1661339755
        panda568.originalUrl = "https://www.bilibili.com/video/BV1HW4y187jP"
        panda568.tags = "大熊猫,萌宠,动物圈"
        panda568.authorId = 6696683
        panda568.cover =
            "https://i0.hdslb.com/bfs/archive/8552b500784f9eb63b072d9006693f656709f968.jpg"
        list.add(panda568)

        val panda569 = PetVideo()
        panda569.type = VideoType.PANDA.ordinal
        panda569.fileName = "panda_group_panda569"
        panda569.code = 2481
        panda569.duration = 117
        panda569.period = PeriodType.GROUP.ordinal
        panda569.star = false
        panda569.title = "【四喜丸子】大熊猫也有血脉压制？这个犀利的眼神，把毛皮大衣脱了吧？"
        panda569.releaseTime = 1661336255
        panda569.originalUrl = "https://www.bilibili.com/video/BV12S4y1W7oV"
        panda569.tags = "大熊猫,萌宠,动物圈"
        panda569.authorId = 180602305
        panda569.cover =
            "https://i0.hdslb.com/bfs/archive/d38a64ccca58b6a3d10218367ca7497dc65f0b20.jpg"
        list.add(panda569)

        val panda570 = PetVideo()
        panda570.type = VideoType.PANDA.ordinal
        panda570.fileName = "panda_group_panda570"
        panda570.code = 2482
        panda570.duration = 70
        panda570.period = PeriodType.GROUP.ordinal
        panda570.star = false
        panda570.title = "如果花花躺在自己旁边，大概是这个视角吧，可以想象一下【大熊猫和花】"
        panda570.releaseTime = 1650981494
        panda570.originalUrl = "https://www.bilibili.com/video/BV1Na411e7T9"
        panda570.tags = "大熊猫,萌宠,动物圈"
        panda570.authorId = 230382720
        panda570.cover =
            "https://i0.hdslb.com/bfs/archive/1f0e52bb1ab134668831f7ec74d3a357ce7b5115.jpg"
        list.add(panda570)

        val panda571 = PetVideo()
        panda571.type = VideoType.PANDA.ordinal
        panda571.fileName = "panda_group_panda571"
        panda571.code = 2483
        panda571.duration = 10
        panda571.period = PeriodType.GROUP.ordinal
        panda571.star = false
        panda571.title = "有多少人在等花花暑假结束呢？"
        panda571.releaseTime = 1660965583
        panda571.originalUrl = "https://www.bilibili.com/video/BV1t14y1t74A"
        panda571.tags = "大熊猫,萌宠,动物圈"
        panda571.authorId = 1025949925
        panda571.cover =
            "https://i1.hdslb.com/bfs/archive/efd67e4ae77f02bdf7f97ba9301e7dd54ee63e3a.jpg"
        list.add(panda571)

        val panda572 = PetVideo()
        panda572.type = VideoType.PANDA.ordinal
        panda572.fileName = "panda_group_panda572"
        panda572.code = 2484
        panda572.duration = 135
        panda572.period = PeriodType.GROUP.ordinal
        panda572.star = false
        panda572.title = "花花：敌人未动我先倒，碰瓷我是专业的，擅长各种花式碰瓷，谁能赢过我！"
        panda572.releaseTime = 1661139186
        panda572.originalUrl = "https://www.bilibili.com/video/BV1FY4y1F7KC"
        panda572.tags = "大熊猫,萌宠,动物圈"
        panda572.authorId = 34677299
        panda572.cover =
            "https://i2.hdslb.com/bfs/archive/b997667b267fc5546aa733bc977b81b528815797.jpg"
        list.add(panda572)

        val panda573 = PetVideo()
        panda573.type = VideoType.PANDA.ordinal
        panda573.fileName = "panda_group_panda573"
        panda573.code = 2485
        panda573.duration = 128
        panda573.period = PeriodType.GROUP.ordinal
        panda573.star = false
        panda573.title = "大美成兰姐弟情深，弟弟成兰趴在姐姐肚子上舔手，遗憾没有录上声音"
        panda573.releaseTime = 1578618979
        panda573.originalUrl = "https://www.bilibili.com/video/BV1LJ411V7b8"
        panda573.tags = "大熊猫,萌宠,动物圈"
        panda573.authorId = 53097073
        panda573.cover =
            "https://i0.hdslb.com/bfs/archive/ae72838c27d0a84c0cd2695a1862243774749aed.jpg"
        list.add(panda573)

        val panda574 = PetVideo()
        panda574.type = VideoType.PANDA.ordinal
        panda574.fileName = "panda_group_panda574"
        panda574.code = 2486
        panda574.duration = 380
        panda574.period = PeriodType.GROUP.ordinal
        panda574.star = false
        panda574.title = "咱们双胞胎之大美、成兰：姐姐巨能吃，弟弟特黏人？"
        panda574.releaseTime = 1551960041
        panda574.originalUrl = "https://www.bilibili.com/video/BV16b411q758"
        panda574.tags = "大熊猫,萌宠,动物圈"
        panda574.authorId = 12444306
        panda574.cover =
            "https://i2.hdslb.com/bfs/archive/6ff81328eecb2de67b70310ac67a752f5fc75b10.jpg"
        list.add(panda574)

        val panda575 = PetVideo()
        panda575.type = VideoType.PANDA.ordinal
        panda575.fileName = "panda_group_panda575"
        panda575.code = 2487
        panda575.duration = 43
        panda575.period = PeriodType.GROUP.ordinal
        panda575.star = false
        panda575.title = "是谁在想花花？花花打了个大喷嚏【大熊猫和花】"
        panda575.releaseTime = 1651543063
        panda575.originalUrl = "https://www.bilibili.com/video/BV14S4y187nB"
        panda575.tags = "大熊猫,萌宠,动物圈"
        panda575.authorId = 230382720
        panda575.cover =
            "https://i1.hdslb.com/bfs/archive/be3fe26d334477a2521861782e39f186ba7f9405.jpg"
        list.add(panda575)

        val panda576 = PetVideo()
        panda576.type = VideoType.PANDA.ordinal
        panda576.fileName = "panda_group_panda576"
        panda576.code = 2488
        panda576.duration = 250
        panda576.period = PeriodType.GROUP.ordinal
        panda576.star = false
        panda576.title = "小朋友：躺着吃对肠胃不好。和花：好的窝立马躺着吃"
        panda576.releaseTime = 1661076000
        panda576.originalUrl = "https://www.bilibili.com/video/BV1XB4y1B7no"
        panda576.tags = "大熊猫,萌宠,动物圈"
        panda576.authorId = 484440897
        panda576.cover =
            "https://i0.hdslb.com/bfs/archive/1e025e60b687444bcea6c60945ad6f11273f8d77.jpg"
        list.add(panda576)

        val panda577 = PetVideo()
        panda577.type = VideoType.PANDA.ordinal
        panda577.fileName = "panda_group_panda577"
        panda577.code = 2489
        panda577.duration = 124
        panda577.period = PeriodType.GROUP.ordinal
        panda577.star = false
        panda577.title = "【大熊猫绩笑】女明星熟练掌握以宠粉掩盖青团"
        panda577.releaseTime = 1660836984
        panda577.originalUrl = "https://www.bilibili.com/video/BV1S14y147z7"
        panda577.tags = "大熊猫,萌宠,动物圈"
        panda577.authorId = 697876712
        panda577.cover =
            "https://i2.hdslb.com/bfs/archive/71f14342ab83a6848265fe807d305efc95794c91.jpg"
        list.add(panda577)

        val panda578 = PetVideo()
        panda578.type = VideoType.PANDA.ordinal
        panda578.fileName = "panda_group_panda578"
        panda578.code = 2490
        panda578.duration = 64
        panda578.period = PeriodType.GROUP.ordinal
        panda578.star = false
        panda578.title = "凑迪迪，不可以蹬脸，哼！"
        panda578.releaseTime = 1661000443
        panda578.originalUrl = "https://www.bilibili.com/video/BV1TU4y1k73q"
        panda578.tags = "大熊猫,萌宠,动物圈"
        panda578.authorId = 16468440
        panda578.cover =
            "https://i1.hdslb.com/bfs/archive/f358820aa6d26eefa862074171c88f68dd1adc10.jpg"
        list.add(panda578)

        val panda579 = PetVideo()
        panda579.type = VideoType.PANDA.ordinal
        panda579.fileName = "panda_group_panda579"
        panda579.code = 2491
        panda579.duration = 58
        panda579.period = PeriodType.GROUP.ordinal
        panda579.star = false
        panda579.title = "【大熊猫萌宝萌玉】萌宝玉小雨中菜熊互啄一嘴毛20220809"
        panda579.releaseTime = 1660081363
        panda579.originalUrl = "https://www.bilibili.com/video/BV1VB4y1k7XW"
        panda579.tags = "大熊猫,萌宠,动物圈"
        panda579.authorId = 3232184
        panda579.cover =
            "https://i0.hdslb.com/bfs/archive/1a8d2bc490cf23cc995bc563047474f3c4f68655.jpg"
        list.add(panda579)

        val panda580 = PetVideo()
        panda580.type = VideoType.PANDA.ordinal
        panda580.fileName = "panda_group_panda580"
        panda580.code = 2492
        panda580.duration = 48
        panda580.period = PeriodType.GROUP.ordinal
        panda580.star = false
        panda580.title = "【大熊猫和花】和花爬架子找弟弟-下集"
        panda580.releaseTime = 1660908300
        panda580.originalUrl = "https://www.bilibili.com/video/BV11W4y1b7XY"
        panda580.tags = "大熊猫,萌宠,动物圈"
        panda580.authorId = 327377672
        panda580.cover =
            "https://i1.hdslb.com/bfs/archive/178820f1b1a6ebc3b1aef3b0b6a45350ed8d7202.jpg"
        list.add(panda580)

        val panda581 = PetVideo()
        panda581.type = VideoType.PANDA.ordinal
        panda581.fileName = "panda_group_panda581"
        panda581.code = 2493
        panda581.duration = 112
        panda581.period = PeriodType.GROUP.ordinal
        panda581.star = false
        panda581.title = "【大熊猫和花】和花爬架子找弟弟-上集"
        panda581.releaseTime = 1660906800
        panda581.originalUrl = "https://www.bilibili.com/video/BV1cv4y1F7sj"
        panda581.tags = "大熊猫,萌宠,动物圈"
        panda581.authorId = 327377672
        panda581.cover =
            "https://i1.hdslb.com/bfs/archive/b95ed609300ae50f5f47f7d64aa3612eb26b004f.jpg"
        list.add(panda581)

        val panda582 = PetVideo()
        panda582.type = VideoType.PANDA.ordinal
        panda582.fileName = "panda_group_panda582"
        panda582.code = 2494
        panda582.duration = 289
        panda582.period = PeriodType.GROUP.ordinal
        panda582.star = false
        panda582.title = "【大熊猫萌宝萌玉】姐妹俩的窝头雷达对决20220722"
        panda582.releaseTime = 1658511172
        panda582.originalUrl = "https://www.bilibili.com/video/BV1SF411K7uz"
        panda582.tags = "大熊猫,萌宠,动物圈"
        panda582.authorId = 3232184
        panda582.cover =
            "https://i0.hdslb.com/bfs/archive/04cd1ee270c6c38925bb6c179f645b7b365a5a68.jpg"
        list.add(panda582)

        val panda583 = PetVideo()
        panda583.type = VideoType.PANDA.ordinal
        panda583.fileName = "panda_group_panda583"
        panda583.code = 2495
        panda583.duration = 68
        panda583.period = PeriodType.GROUP.ordinal
        panda583.star = false
        panda583.title = "真羡慕小叶子，有一个主动贴贴靠靠的大头姐姐！【大熊猫和花】【大熊猫和叶】"
        panda583.releaseTime = 1660882079
        panda583.originalUrl = "https://www.bilibili.com/video/BV1Ba4y1f75D"
        panda583.tags = "大熊猫,萌宠,动物圈"
        panda583.authorId = 16468440
        panda583.cover =
            "https://i1.hdslb.com/bfs/archive/7d82b35588d6568166868b2401afab5b6ba53c86.jpg"
        list.add(panda583)

        val panda584 = PetVideo()
        panda584.type = VideoType.PANDA.ordinal
        panda584.fileName = "panda_group_panda584"
        panda584.code = 2496
        panda584.duration = 54
        panda584.period = PeriodType.GROUP.ordinal
        panda584.star = false
        panda584.title = "夏天太热，给大家发个库存降降温。"
        panda584.releaseTime = 1660822560
        panda584.originalUrl = "https://www.bilibili.com/video/BV1eY4y1c7R8"
        panda584.tags = "大熊猫,萌宠,动物圈"
        panda584.authorId = 1754373551
        panda584.cover =
            "https://i2.hdslb.com/bfs/archive/b53fc1f9d2c235a4973dfd3cd557908f2b01d23c.jpg"
        list.add(panda584)

        val panda585 = PetVideo()
        panda585.type = VideoType.PANDA.ordinal
        panda585.fileName = "panda_group_panda585"
        panda585.code = 2497
        panda585.duration = 212
        panda585.period = PeriodType.GROUP.ordinal
        panda585.star = false
        panda585.title = "花花：下树很难吗？不难啊！这样一下那样一下很容易就下来了啊！！！"
        panda585.releaseTime = 1660821053
        panda585.originalUrl = "https://www.bilibili.com/video/BV1mV4y1s7kF"
        panda585.tags = "大熊猫,萌宠,动物圈"
        panda585.authorId = 34677299
        panda585.cover =
            "https://i1.hdslb.com/bfs/archive/975e47e53d92db1e40ebf9f82c32bb6e01709227.jpg"
        list.add(panda585)

        val panda586 = PetVideo()
        panda586.type = VideoType.PANDA.ordinal
        panda586.fileName = "panda_group_panda586"
        panda586.code = 2498
        panda586.duration = 34
        panda586.period = PeriodType.GROUP.ordinal
        panda586.star = false
        panda586.title = "大熊猫和花和叶-姐弟同框，笋笋更香"
        panda586.releaseTime = 1660822331
        panda586.originalUrl = "https://www.bilibili.com/video/BV1gg411r73u"
        panda586.tags = "大熊猫,萌宠,动物圈"
        panda586.authorId = 1307515
        panda586.cover =
            "https://i1.hdslb.com/bfs/archive/164b8c055665eefd7066f421fc59ea92913a5659.jpg"
        list.add(panda586)

        val panda587 = PetVideo()
        panda587.type = VideoType.PANDA.ordinal
        panda587.fileName = "panda_group_panda587"
        panda587.code = 2499
        panda587.duration = 65
        panda587.period = PeriodType.GROUP.ordinal
        panda587.star = false
        panda587.title = "🔥太热了，贴心的花主任开着【洒水车】来帮忙啦！😘"
        panda587.releaseTime = 1660811904
        panda587.originalUrl = "https://www.bilibili.com/video/BV1Qe4y1f7W2"
        panda587.tags = "大熊猫,萌宠,动物圈"
        panda587.authorId = 16468440
        panda587.cover =
            "https://i2.hdslb.com/bfs/archive/c55f7c560ed98064de407dc1be0af61d2dfb3cc4.jpg"
        list.add(panda587)

        val panda588 = PetVideo()
        panda588.type = VideoType.PANDA.ordinal
        panda588.fileName = "panda_group_panda588"
        panda588.code = 2500
        panda588.duration = 97
        panda588.period = PeriodType.GROUP.ordinal
        panda588.star = false
        panda588.title = "生气的香果妹妹"
        panda588.releaseTime = 1660797242
        panda588.originalUrl = "https://www.bilibili.com/video/BV1Ue4y1f7cA"
        panda588.tags = "大熊猫,萌宠,动物圈"
        panda588.authorId = 1025949925
        panda588.cover =
            "https://i2.hdslb.com/bfs/archive/f7dbffbff15c3ea429247d7fb7cde4252f8b199e.jpg"
        list.add(panda588)

        val panda589 = PetVideo()
        panda589.type = VideoType.PANDA.ordinal
        panda589.fileName = "panda_group_panda589"
        panda589.code = 2501
        panda589.duration = 105
        panda589.period = PeriodType.GROUP.ordinal
        panda589.star = false
        panda589.title = "那天被吓到上树的花花，谭爷爷叫了好久！"
        panda589.releaseTime = 1660739360
        panda589.originalUrl = "https://www.bilibili.com/video/BV12B4y1B7xw"
        panda589.tags = "大熊猫,萌宠,动物圈"
        panda589.authorId = 34677299
        panda589.cover =
            "https://i0.hdslb.com/bfs/archive/6163d37b38f79fdc3f357935f572be7b648601cb.jpg"
        list.add(panda589)

        val panda590 = PetVideo()
        panda590.type = VideoType.PANDA.ordinal
        panda590.fileName = "panda_group_panda590"
        panda590.code = 2502
        panda590.duration = 91
        panda590.period = PeriodType.GROUP.ordinal
        panda590.star = false
        panda590.title = "大熊猫吵架 奇一福顺树上互相摇树逗比"
        panda590.releaseTime = 1571319490
        panda590.originalUrl = "https://www.bilibili.com/video/BV1VE411y7Kz"
        panda590.tags = "大熊猫,萌宠,动物圈"
        panda590.authorId = 269899367
        panda590.cover =
            "https://i1.hdslb.com/bfs/archive/133bc87ab3d1246de34fe8ef7f243dadbceebf1d.jpg"
        list.add(panda590)

        val panda591 = PetVideo()
        panda591.type = VideoType.PANDA.ordinal
        panda591.fileName = "panda_group_panda591"
        panda591.code = 2503
        panda591.duration = 33
        panda591.period = PeriodType.GROUP.ordinal
        panda591.star = false
        panda591.title = "肉肉：又说我脸大，哼╰（‵□′）╯"
        panda591.releaseTime = 1520182539
        panda591.originalUrl = "https://www.bilibili.com/video/BV1hW411x7mw"
        panda591.tags = "大熊猫,萌宠,动物圈"
        panda591.authorId = 3848093
        panda591.cover =
            "https://i0.hdslb.com/bfs/archive/b3ecaa8371af13bcd1192356e4f5ba36f3518d87.png"
        list.add(panda591)

        val panda592 = PetVideo()
        panda592.type = VideoType.PANDA.ordinal
        panda592.fileName = "panda_group_panda592"
        panda592.code = 2504
        panda592.duration = 81
        panda592.period = PeriodType.GROUP.ordinal
        panda592.star = false
        panda592.title = "那时候还是小小的两只，吃玩都好可爱"
        panda592.releaseTime = 1660651560
        panda592.originalUrl = "https://www.bilibili.com/video/BV1Yd4y1o7V9"
        panda592.tags = "大熊猫,萌宠,动物圈"
        panda592.authorId = 1754373551
        panda592.cover =
            "https://i2.hdslb.com/bfs/archive/d9b45a4954286fd56ee2455d82e913f09343c1a3.jpg"
        list.add(panda592)

        val panda593 = PetVideo()
        panda593.type = VideoType.PANDA.ordinal
        panda593.fileName = "panda_group_panda593"
        panda593.code = 2505
        panda593.duration = 44
        panda593.period = PeriodType.GROUP.ordinal
        panda593.star = false
        panda593.title = "【大熊猫和花】感受一下阿花盯着你走过来的压迫感！"
        panda593.releaseTime = 1660645877
        panda593.originalUrl = "https://www.bilibili.com/video/BV1kG411t7VN"
        panda593.tags = "大熊猫,萌宠,动物圈"
        panda593.authorId = 327377672
        panda593.cover =
            "https://i0.hdslb.com/bfs/archive/a10eefb5a399527ee6b67cf279e6949417378b3c.jpg"
        list.add(panda593)

        val panda594 = PetVideo()
        panda594.type = VideoType.PANDA.ordinal
        panda594.fileName = "panda_group_panda594"
        panda594.code = 2506
        panda594.duration = 65
        panda594.period = PeriodType.GROUP.ordinal
        panda594.star = false
        panda594.title = "花花你脏了！直击女明星挖煤现场！😎【大熊猫和花】"
        panda594.releaseTime = 1660615742
        panda594.originalUrl = "https://www.bilibili.com/video/BV1ZP411L7qa"
        panda594.tags = "大熊猫,萌宠,动物圈"
        panda594.authorId = 16468440
        panda594.cover =
            "https://i1.hdslb.com/bfs/archive/49de1b2d53d36b70a7b5ec8a0a8c1d98ed38667e.jpg"
        list.add(panda594)

        val panda595 = PetVideo()
        panda595.type = VideoType.PANDA.ordinal
        panda595.fileName = "panda_group_panda595"
        panda595.code = 2507
        panda595.duration = 130
        panda595.period = PeriodType.GROUP.ordinal
        panda595.star = false
        panda595.title = "花花枕着手睡觉觉，像个小孩儿【大熊猫和花】"
        panda595.releaseTime = 1648891577
        panda595.originalUrl = "https://www.bilibili.com/video/BV1pS4y117qX"
        panda595.tags = "大熊猫,萌宠,动物圈"
        panda595.authorId = 230382720
        panda595.cover =
            "https://i2.hdslb.com/bfs/archive/54d83e55717e77596cb31d2f20c48b8651ee61a5.jpg"
        list.add(panda595)

        val panda596 = PetVideo()
        panda596.type = VideoType.PANDA.ordinal
        panda596.fileName = "panda_group_panda596"
        panda596.code = 2508
        panda596.duration = 73
        panda596.period = PeriodType.GROUP.ordinal
        panda596.star = false
        panda596.title = "【四喜丸子】睡觉的地方，一步都不能让，总有熊先支持不住"
        panda596.releaseTime = 1660557281
        panda596.originalUrl = "https://www.bilibili.com/video/BV1aV4y1s7cQ"
        panda596.tags = "大熊猫,萌宠,动物圈"
        panda596.authorId = 180602305
        panda596.cover =
            "https://i0.hdslb.com/bfs/archive/1a861becb23e934d377c73dd8effad8fc49a144e.jpg"
        list.add(panda596)

        val panda597 = PetVideo()
        panda597.type = VideoType.PANDA.ordinal
        panda597.fileName = "panda_group_panda597"
        panda597.code = 2509
        panda597.duration = 88
        panda597.period = PeriodType.GROUP.ordinal
        panda597.star = false
        panda597.title = "花花：这地上长的系什么，好吃的咩？【大熊猫和花】"
        panda597.releaseTime = 1660477385
        panda597.originalUrl = "https://www.bilibili.com/video/BV13a411d7rc"
        panda597.tags = "大熊猫,萌宠,动物圈"
        panda597.authorId = 230382720
        panda597.cover =
            "https://i1.hdslb.com/bfs/archive/064bfc23a39ecf59e9bb2e57cae7755792d959b4.jpg"
        list.add(panda597)

        val panda598 = PetVideo()
        panda598.type = VideoType.PANDA.ordinal
        panda598.fileName = "panda_group_panda598"
        panda598.code = 2510
        panda598.duration = 85
        panda598.period = PeriodType.GROUP.ordinal
        panda598.star = false
        panda598.title = "这只小花猪在面前一坐，就足以萌化人的心！【大熊猫和花】"
        panda598.releaseTime = 1660399073
        panda598.originalUrl = "https://www.bilibili.com/video/BV1Bg411k799"
        panda598.tags = "大熊猫,萌宠,动物圈"
        panda598.authorId = 514531996
        panda598.cover =
            "https://i1.hdslb.com/bfs/archive/9e4aed1d84206da2b46257acde5e4581369508e8.jpg"
        list.add(panda598)

        val panda599 = PetVideo()
        panda599.type = VideoType.PANDA.ordinal
        panda599.fileName = "panda_group_panda599"
        panda599.code = 2511
        panda599.duration = 110
        panda599.period = PeriodType.GROUP.ordinal
        panda599.star = false
        panda599.title = "📢谭爷爷喊花花啦，花花“叶玖菜”迅速抵达，只有“果赖”缓慢登场！🌟"
        panda599.releaseTime = 1660386900
        panda599.originalUrl = "https://www.bilibili.com/video/BV1pG4y1e7Xx"
        panda599.tags = "大熊猫,萌宠,动物圈"
        panda599.authorId = 16468440
        panda599.cover =
            "https://i0.hdslb.com/bfs/archive/24cc87d829ae197be636a50086b87e7bcf7e78b2.jpg"
        list.add(panda599)

        val panda600 = PetVideo()
        panda600.type = VideoType.PANDA.ordinal
        panda600.fileName = "panda_group_panda600"
        panda600.code = 2512
        panda600.duration = 80
        panda600.period = PeriodType.GROUP.ordinal
        panda600.star = false
        panda600.title = "菜总，坐过去一点点嘛，毛大衣挤起好热哦！【大熊猫和花】"
        panda600.releaseTime = 1651189680
        panda600.originalUrl = "https://www.bilibili.com/video/BV1SS4y1a7T9"
        panda600.tags = "大熊猫,萌宠,动物圈"
        panda600.authorId = 16468440
        panda600.cover =
            "https://i2.hdslb.com/bfs/archive/e74522da9b1654c025efae7d4134bf3277d3c3a5.jpg"
        list.add(panda600)

        val panda601 = PetVideo()
        panda601.type = VideoType.PANDA.ordinal
        panda601.fileName = "panda_group_panda601"
        panda601.code = 2513
        panda601.duration = 114
        panda601.period = PeriodType.GROUP.ordinal
        panda601.star = false
        panda601.title = "午饭时间！玖菜在努力干饭，看看花叶姐弟在搞撒子?😎"
        panda601.releaseTime = 1660305028
        panda601.originalUrl = "https://www.bilibili.com/video/BV1cG4y1a7D7"
        panda601.tags = "大熊猫,萌宠,动物圈"
        panda601.authorId = 16468440
        panda601.cover =
            "https://i2.hdslb.com/bfs/archive/fcd4fbbbe4d6cbfb83314b0b85394da9aaaacbb2.jpg"
        list.add(panda601)

        val panda602 = PetVideo()
        panda602.type = VideoType.PANDA.ordinal
        panda602.fileName = "panda_group_panda602"
        panda602.code = 2514
        panda602.duration = 78
        panda602.period = PeriodType.GROUP.ordinal
        panda602.star = false
        panda602.title = "水璨璨草美美 女孩子也会偶尔打闹"
        panda602.releaseTime = 1659406173
        panda602.originalUrl = "https://www.bilibili.com/video/BV1rg411C7eY"
        panda602.tags = "大熊猫,萌宠,动物圈"
        panda602.authorId = 442701460
        panda602.cover =
            "https://i0.hdslb.com/bfs/archive/6507031486d25336418331ac17bbce08f23354b6.jpg"
        list.add(panda602)

        val panda603 = PetVideo()
        panda603.type = VideoType.PANDA.ordinal
        panda603.fileName = "panda_group_panda603"
        panda603.code = 2515
        panda603.duration = 37
        panda603.period = PeriodType.GROUP.ordinal
        panda603.star = false
        panda603.title = "带崽母猫润二狗，婴儿专座和花花"
        panda603.releaseTime = 1642303390
        panda603.originalUrl = "https://www.bilibili.com/video/BV1pR4y1M7Qn"
        panda603.tags = "大熊猫,萌宠,动物圈"
        panda603.authorId = 1307515
        panda603.cover =
            "https://i0.hdslb.com/bfs/archive/509d8838fbb3647aefaa82dee4da15677828cf7b.jpg"
        list.add(panda603)

        val panda604 = PetVideo()
        panda604.type = VideoType.PANDA.ordinal
        panda604.fileName = "panda_group_panda604"
        panda604.code = 2516
        panda604.duration = 116
        panda604.period = PeriodType.GROUP.ordinal
        panda604.star = false
        panda604.title = "今天的新鲜花花，花花睡觉被玖玖姐姐弄醒了"
        panda604.releaseTime = 1658158613
        panda604.originalUrl = "https://www.bilibili.com/video/BV1de4y1X7Va"
        panda604.tags = "大熊猫,萌宠,动物圈"
        panda604.authorId = 1852236806
        panda604.cover =
            "https://i1.hdslb.com/bfs/archive/abbc1e4547c22c41a72f86c275d05e31722c63a1.jpg"
        list.add(panda604)

        val panda605 = PetVideo()
        panda605.type = VideoType.PANDA.ordinal
        panda605.fileName = "panda_group_panda605"
        panda605.code = 2517
        panda605.duration = 39
        panda605.period = PeriodType.GROUP.ordinal
        panda605.star = false
        panda605.title = "叮~你的无敌小可爱叫醒服务已上线！【大熊猫和花、和叶】"
        panda605.releaseTime = 1660224958
        panda605.originalUrl = "https://www.bilibili.com/video/BV1hB4y157Pm"
        panda605.tags = "大熊猫,萌宠,动物圈"
        panda605.authorId = 514531996
        panda605.cover =
            "https://i0.hdslb.com/bfs/archive/dfe947296464b94d8e58a13f83812d39d1339f7b.jpg"
        list.add(panda605)

        val panda606 = PetVideo()
        panda606.type = VideoType.PANDA.ordinal
        panda606.fileName = "panda_group_panda606"
        panda606.code = 2518
        panda606.duration = 85
        panda606.period = PeriodType.GROUP.ordinal
        panda606.star = false
        panda606.title = "艾玖：和瓜你胆子肥了，各人下去缓解一下尴尬。【和叶、润玥】"
        panda606.releaseTime = 1660138193
        panda606.originalUrl = "https://www.bilibili.com/video/BV1AB4y1675n"
        panda606.tags = "大熊猫,萌宠,动物圈"
        panda606.authorId = 514531996
        panda606.cover =
            "https://i0.hdslb.com/bfs/archive/b2bccd06ee2ab1ece854dc3b1fb9d6857addd18b.jpg"
        list.add(panda606)

        val panda607 = PetVideo()
        panda607.type = VideoType.PANDA.ordinal
        panda607.fileName = "panda_group_panda607"
        panda607.code = 2519
        panda607.duration = 85
        panda607.period = PeriodType.GROUP.ordinal
        panda607.star = false
        panda607.title = "真不愧是叶师傅，下雨jio滑半空摔也能轻松应对！👏😎【大熊猫和叶】"
        panda607.releaseTime = 1660187653
        panda607.originalUrl = "https://www.bilibili.com/video/BV1gd4y1P7sr"
        panda607.tags = "大熊猫,萌宠,动物圈"
        panda607.authorId = 16468440
        panda607.cover =
            "https://i2.hdslb.com/bfs/archive/9d24bd44512c0ab5e02803f1d5d7c31fcaaae751.jpg"
        list.add(panda607)

        val panda608 = PetVideo()
        panda608.type = VideoType.PANDA.ordinal
        panda608.fileName = "panda_group_panda608"
        panda608.code = 2520
        panda608.duration = 32
        panda608.period = PeriodType.GROUP.ordinal
        panda608.star = false
        panda608.title = "第一次见熊猫做平板撑"
        panda608.releaseTime = 1629442992
        panda608.originalUrl = "https://www.bilibili.com/video/BV1CL411J7rP"
        panda608.tags = "大熊猫,萌宠,动物圈"
        panda608.authorId = 37053244
        panda608.cover =
            "https://i2.hdslb.com/bfs/archive/a9e43503196c67605efb0f6b870cdaf928a8b47f.jpg"
        list.add(panda608)

        val panda609 = PetVideo()
        panda609.type = VideoType.PANDA.ordinal
        panda609.fileName = "panda_group_panda609"
        panda609.code = 2521
        panda609.duration = 104
        panda609.period = PeriodType.GROUP.ordinal
        panda609.star = false
        panda609.title = "花姐，你弟弟好次啵?😎【大熊猫和花 和叶】"
        panda609.releaseTime = 1660110934
        panda609.originalUrl = "https://www.bilibili.com/video/BV1bS4y1s7fz"
        panda609.tags = "大熊猫,萌宠,动物圈"
        panda609.authorId = 16468440
        panda609.cover =
            "https://i0.hdslb.com/bfs/archive/abd5b483f42013158d9b288923fb1324bbf07542.jpg"
        list.add(panda609)

        val panda610 = PetVideo()
        panda610.type = VideoType.PANDA.ordinal
        panda610.fileName = "panda_group_panda610"
        panda610.code = 2522
        panda610.duration = 74
        panda610.period = PeriodType.GROUP.ordinal
        panda610.star = false
        panda610.title = "自律的叶师傅，练功也是很努力的！💪【大熊猫和叶】"
        panda610.releaseTime = 1660124280
        panda610.originalUrl = "https://www.bilibili.com/video/BV1UG41187yH"
        panda610.tags = "大熊猫,萌宠,动物圈"
        panda610.authorId = 16468440
        panda610.cover =
            "https://i2.hdslb.com/bfs/archive/90d3f1990bb26e9bd37433d9e24c946a8561f201.jpg"
        list.add(panda610)

        val panda611 = PetVideo()
        panda611.type = VideoType.PANDA.ordinal
        panda611.fileName = "panda_group_panda611"
        panda611.code = 2523
        panda611.duration = 72
        panda611.period = PeriodType.GROUP.ordinal
        panda611.star = false
        panda611.title = "【大熊猫绩笑】笑笑泡澡澡啦"
        panda611.releaseTime = 1660048127
        panda611.originalUrl = "https://www.bilibili.com/video/BV19V4y1x7ji"
        panda611.tags = "大熊猫,萌宠,动物圈"
        panda611.authorId = 492727424
        panda611.cover =
            "https://i0.hdslb.com/bfs/archive/2cb23c9155ad3300f2087b31dcaa8aaed71c6500.jpg"
        list.add(panda611)

        val panda612 = PetVideo()
        panda612.type = VideoType.PANDA.ordinal
        panda612.fileName = "panda_group_panda612"
        panda612.code = 2524
        panda612.duration = 181
        panda612.period = PeriodType.GROUP.ordinal
        panda612.star = false
        panda612.title = "萌兰与庆小弟悠闲的幸福生活"
        panda612.releaseTime = 1486905571
        panda612.originalUrl = "https://www.bilibili.com/video/BV1Vx41127zU"
        panda612.tags = "大熊猫,萌宠,动物圈"
        panda612.authorId = 4038416
        panda612.cover =
            "https://i0.hdslb.com/bfs/archive/2b23e62e62eb217e5a831d2745e4bea2e5a6b6ed.png"
        list.add(panda612)

        val panda613 = PetVideo()
        panda613.type = VideoType.PANDA.ordinal
        panda613.fileName = "panda_group_panda613"
        panda613.code = 2525
        panda613.duration = 75
        panda613.period = PeriodType.GROUP.ordinal
        panda613.star = false
        panda613.title = "比利时天堂动物园为大熊猫演奏《生日快乐》四重奏"
        panda613.releaseTime = 1660036173
        panda613.originalUrl = "https://www.bilibili.com/video/BV1Wt4y1G7QC"
        panda613.tags = "大熊猫,萌宠,动物圈"
        panda613.authorId = 1998535
        panda613.cover =
            "https://i2.hdslb.com/bfs/archive/8e379b318f6afb7868b8bffd4cba6c5273d96b73.jpg"
        list.add(panda613)

        val panda614 = PetVideo()
        panda614.type = VideoType.PANDA.ordinal
        panda614.fileName = "panda_group_panda614"
        panda614.code = 2526
        panda614.duration = 71
        panda614.period = PeriodType.GROUP.ordinal
        panda614.star = false
        panda614.title = "✨花花爬上栖架，翻成了小乌龟💗萌化了！"
        panda614.releaseTime = 1660018113
        panda614.originalUrl = "https://www.bilibili.com/video/BV1dV4y1x7Rm"
        panda614.tags = "大熊猫,萌宠,动物圈"
        panda614.authorId = 16468440
        panda614.cover =
            "https://i2.hdslb.com/bfs/archive/26cff331db5a17a0dfb2afa74ab55a02500945cc.jpg"
        list.add(panda614)

        val panda615 = PetVideo()
        panda615.type = VideoType.PANDA.ordinal
        panda615.fileName = "panda_group_panda615"
        panda615.code = 2527
        panda615.duration = 83
        panda615.period = PeriodType.GROUP.ordinal
        panda615.star = false
        panda615.title = "💓花花，你这样看着我们，很容易被偷走的哦！😍"
        panda615.releaseTime = 1659975075
        panda615.originalUrl = "https://www.bilibili.com/video/BV1iB4y1t7Yn"
        panda615.tags = "大熊猫,萌宠,动物圈"
        panda615.authorId = 16468440
        panda615.cover =
            "https://i1.hdslb.com/bfs/archive/2a608d1e89f78b45414bf98405448e5e430e49e3.jpg"
        list.add(panda615)

        val panda616 = PetVideo()
        panda616.type = VideoType.PANDA.ordinal
        panda616.fileName = "panda_group_panda616"
        panda616.code = 2528
        panda616.duration = 144
        panda616.period = PeriodType.GROUP.ordinal
        panda616.star = false
        panda616.title = "聪明又拽的熊猫"
        panda616.releaseTime = 1659928426
        panda616.originalUrl = "https://www.bilibili.com/video/BV16d4y1m7kq"
        panda616.tags = "大熊猫,萌宠,动物圈"
        panda616.authorId = 1025949925
        panda616.cover =
            "https://i2.hdslb.com/bfs/archive/066ac5f1ff396270beb0a55de45b1b7dfa520261.jpg"
        list.add(panda616)

        val panda617 = PetVideo()
        panda617.type = VideoType.PANDA.ordinal
        panda617.fileName = "panda_group_panda617"
        panda617.code = 2529
        panda617.duration = 119
        panda617.period = PeriodType.GROUP.ordinal
        panda617.star = false
        panda617.title = "一朝被熊抱，经典永流传"
        panda617.releaseTime = 1659953160
        panda617.originalUrl = "https://www.bilibili.com/video/BV1sa411K7qD"
        panda617.tags = "大熊猫,萌宠,动物圈"
        panda617.authorId = 37053244
        panda617.cover =
            "https://i0.hdslb.com/bfs/archive/3a37ea97e3f1b3596a9a4e2310cddcc3c1d14c0a.jpg"
        list.add(panda617)

        val panda618 = PetVideo()
        panda618.type = VideoType.PANDA.ordinal
        panda618.fileName = "panda_group_panda618"
        panda618.code = 2530
        panda618.duration = 64
        panda618.period = PeriodType.GROUP.ordinal
        panda618.star = false
        panda618.title = "我能想到最浪漫的事，就是你抱着肚肚我掰着脚我们靠着吃播，你的笋笋也是我的！【大熊猫和花、润玥】"
        panda618.releaseTime = 1659961448
        panda618.originalUrl = "https://www.bilibili.com/video/BV1kS4y147tK"
        panda618.tags = "大熊猫,萌宠,动物圈"
        panda618.authorId = 514531996
        panda618.cover =
            "https://i1.hdslb.com/bfs/archive/31ce42903b0dd4f6ac75ec6f8799f66a50acb087.jpg"
        list.add(panda618)

        val panda619 = PetVideo()
        panda619.type = VideoType.PANDA.ordinal
        panda619.fileName = "panda_group_panda619"
        panda619.code = 2531
        panda619.duration = 109
        panda619.period = PeriodType.GROUP.ordinal
        panda619.star = false
        panda619.title = "每次吃完零食的花花都非常宠粉，各种角度给正脸"
        panda619.releaseTime = 1659864848
        panda619.originalUrl = "https://www.bilibili.com/video/BV1Xr4y157a1"
        panda619.tags = "大熊猫,萌宠,动物圈"
        panda619.authorId = 1714028276
        panda619.cover =
            "https://i0.hdslb.com/bfs/archive/42d665286045b1dc5670d74b1a592e742fb75b44.jpg"
        list.add(panda619)

        val panda620 = PetVideo()
        panda620.type = VideoType.PANDA.ordinal
        panda620.fileName = "panda_group_panda620"
        panda620.code = 2532
        panda620.duration = 108
        panda620.period = PeriodType.GROUP.ordinal
        panda620.star = false
        panda620.title = "花花:不要看我萌萌的，听我咬竹子那个声音两脚兽害怕了没有！"
        panda620.releaseTime = 1655092650
        panda620.originalUrl = "https://www.bilibili.com/video/BV1uY4y1s7Ta"
        panda620.tags = "大熊猫,萌宠,动物圈"
        panda620.authorId = 1714028276
        panda620.cover =
            "https://i2.hdslb.com/bfs/archive/ede995f4de905199b8c3f352b2cf1326838216ac.png"
        list.add(panda620)

        val panda621 = PetVideo()
        panda621.type = VideoType.PANDA.ordinal
        panda621.fileName = "panda_group_panda621"
        panda621.code = 2533
        panda621.duration = 67
        panda621.period = PeriodType.GROUP.ordinal
        panda621.star = false
        panda621.title = "胖崽在打嗝儿"
        panda621.releaseTime = 1655128626
        panda621.originalUrl = "https://www.bilibili.com/video/BV1A94y127r3"
        panda621.tags = "大熊猫,萌宠,动物圈"
        panda621.authorId = 1714028276
        panda621.cover =
            "https://i1.hdslb.com/bfs/archive/82099fbc725cd920c62d438990f419e2968fbc89.png"
        list.add(panda621)

        val panda622 = PetVideo()
        panda622.type = VideoType.PANDA.ordinal
        panda622.fileName = "panda_group_panda622"
        panda622.code = 2534
        panda622.duration = 49
        panda622.period = PeriodType.GROUP.ordinal
        panda622.star = false
        panda622.title = "【大熊猫绩笑】圆头圆脑二头身"
        panda622.releaseTime = 1643707806
        panda622.originalUrl = "https://www.bilibili.com/video/BV1vq4y1F7Dx"
        panda622.tags = "大熊猫,萌宠,动物圈"
        panda622.authorId = 442701460
        panda622.cover =
            "https://i0.hdslb.com/bfs/archive/aee7dc02612ad01809b0ffc147a77be9fd4e4ca2.jpg"
        list.add(panda622)

        val panda623 = PetVideo()
        panda623.type = VideoType.PANDA.ordinal
        panda623.fileName = "panda_group_panda623"
        panda623.code = 2535
        panda623.duration = 161
        panda623.period = PeriodType.GROUP.ordinal
        panda623.star = false
        panda623.title = "土匪肉猪实至名归"
        panda623.releaseTime = 1566037505
        panda623.originalUrl = "https://www.bilibili.com/video/BV1T4411f7Bn"
        panda623.tags = "大熊猫,萌宠,动物圈"
        panda623.authorId = 50634121
        panda623.cover =
            "https://i0.hdslb.com/bfs/archive/3efb9ad54089cf6bbb035c4aa5f172f713b84565.jpg"
        list.add(panda623)

        val panda624 = PetVideo()
        panda624.type = VideoType.PANDA.ordinal
        panda624.fileName = "panda_group_panda624"
        panda624.code = 2536
        panda624.duration = 76
        panda624.period = PeriodType.GROUP.ordinal
        panda624.star = false
        panda624.title = "弟弟这个不安份的小手~~~"
        panda624.releaseTime = 1657774212
        panda624.originalUrl = "https://www.bilibili.com/video/BV1oG411H7bX"
        panda624.tags = "大熊猫,萌宠,动物圈"
        panda624.authorId = 1714028276
        panda624.cover =
            "https://i2.hdslb.com/bfs/archive/783ba6f8bd0f9d15df98892fc8684f5bc2b53e83.jpg"
        list.add(panda624)

        val panda625 = PetVideo()
        panda625.type = VideoType.PANDA.ordinal
        panda625.fileName = "panda_group_panda625"
        panda625.code = 2537
        panda625.duration = 111
        panda625.period = PeriodType.GROUP.ordinal
        panda625.star = false
        panda625.title = "【大熊猫绩笑&成风】不愧是同父异母的“双胞胎”，浪浪：那我走！"
        panda625.releaseTime = 1659876748
        panda625.originalUrl = "https://www.bilibili.com/video/BV1nd4y1m7rT"
        panda625.tags = "大熊猫,萌宠,动物圈"
        panda625.authorId = 34677299
        panda625.cover =
            "https://i1.hdslb.com/bfs/archive/bef5b124b45e6f4132e749a98b3d4df4733e65b1.jpg"
        list.add(panda625)

        val panda626 = PetVideo()
        panda626.type = VideoType.PANDA.ordinal
        panda626.fileName = "panda_group_panda626"
        panda626.code = 2538
        panda626.duration = 83
        panda626.period = PeriodType.GROUP.ordinal
        panda626.star = false
        panda626.title = "【大熊猫莽星星】【大熊猫莽辰辰】永动机的兄弟俩，不是在费妈妈就是在费彼此😄😄😄"
        panda626.releaseTime = 1658700990
        panda626.originalUrl = "https://www.bilibili.com/video/BV1L94y1D7PT"
        panda626.tags = "大熊猫,萌宠,动物圈"
        panda626.authorId = 1098561796
        panda626.cover =
            "https://i1.hdslb.com/bfs/archive/f5c061b3910ba4b1782ce831be569743666b38bd.jpg"
        list.add(panda626)

        val panda627 = PetVideo()
        panda627.type = VideoType.PANDA.ordinal
        panda627.fileName = "panda_group_panda627"
        panda627.code = 2539
        panda627.duration = 75
        panda627.period = PeriodType.GROUP.ordinal
        panda627.star = false
        panda627.title = "💓花花正脸 ~破 竹~吃播，赢来掌声一片👏🎉"
        panda627.releaseTime = 1659841007
        panda627.originalUrl = "https://www.bilibili.com/video/BV1gW4y1a7Ex"
        panda627.tags = "大熊猫,萌宠,动物圈"
        panda627.authorId = 16468440
        panda627.cover =
            "https://i0.hdslb.com/bfs/archive/056cdc2ea159365b3746deafad8bebd6db4c2ce9.jpg"
        list.add(panda627)

        val panda628 = PetVideo()
        panda628.type = VideoType.PANDA.ordinal
        panda628.fileName = "panda_group_panda628"
        panda628.code = 2540
        panda628.duration = 82
        panda628.period = PeriodType.GROUP.ordinal
        panda628.star = false
        panda628.title = "🌨雨中开心撒欢的四嘟嘟💗和叶不要老偷袭你姐呀😆【大熊猫和花和叶润玥艾玖】"
        panda628.releaseTime = 1659786442
        panda628.originalUrl = "https://www.bilibili.com/video/BV1Sd4y12753"
        panda628.tags = "大熊猫,萌宠,动物圈"
        panda628.authorId = 16468440
        panda628.cover =
            "https://i1.hdslb.com/bfs/archive/ff3471cb46ed986cc1f28124cd0320b4ea21b920.jpg"
        list.add(panda628)

        val panda629 = PetVideo()
        panda629.type = VideoType.PANDA.ordinal
        panda629.fileName = "panda_group_panda629"
        panda629.code = 2541
        panda629.duration = 162
        panda629.period = PeriodType.GROUP.ordinal
        panda629.star = false
        panda629.title = "吃饭让人操心的熊猫"
        panda629.releaseTime = 1659757213
        panda629.originalUrl = "https://www.bilibili.com/video/BV1Ra411N7Qn"
        panda629.tags = "大熊猫,萌宠,动物圈"
        panda629.authorId = 1025949925
        panda629.cover =
            "https://i2.hdslb.com/bfs/archive/8c060b9659df6fa94e221c581e26e28121a49cb7.jpg"
        list.add(panda629)

        val panda630 = PetVideo()
        panda630.type = VideoType.PANDA.ordinal
        panda630.fileName = "panda_group_panda630"
        panda630.code = 2542
        panda630.duration = 230
        panda630.period = PeriodType.GROUP.ordinal
        panda630.star = false
        panda630.title = "2分50秒，成良良沉浸式泡澡。~三姐妹终于一起坐澡堂。【大熊猫绩笑、成风、成浪】"
        panda630.releaseTime = 1649555765
        panda630.originalUrl = "https://www.bilibili.com/video/BV1Q44y1V762"
        panda630.tags = "大熊猫,萌宠,动物圈"
        panda630.authorId = 514531996
        panda630.cover =
            "https://i2.hdslb.com/bfs/archive/427c0c661d4cf1893097b911c7a49b03afb43416.jpg"
        list.add(panda630)

        val panda631 = PetVideo()
        panda631.type = VideoType.PANDA.ordinal
        panda631.fileName = "panda_group_panda631"
        panda631.code = 2543
        panda631.duration = 128
        panda631.period = PeriodType.GROUP.ordinal
        panda631.star = false
        panda631.title = "润玥憋屈的一天"
        panda631.releaseTime = 1659608280
        panda631.originalUrl = "https://www.bilibili.com/video/BV1Ga411f7RP"
        panda631.tags = "大熊猫,萌宠,动物圈"
        panda631.authorId = 551961363
        panda631.cover =
            "https://i2.hdslb.com/bfs/archive/4116ad53ac0741febc116f4a0ce1dbfcc4e968d9.jpg"
        list.add(panda631)

        val panda632 = PetVideo()
        panda632.type = VideoType.PANDA.ordinal
        panda632.fileName = "panda_group_panda632"
        panda632.code = 2544
        panda632.duration = 150
        panda632.period = PeriodType.GROUP.ordinal
        panda632.star = false
        panda632.title = "夏天，就是要愉快的趟水泡澡畅饮啦。【大熊猫绩笑、成风、成浪】"
        panda632.releaseTime = 1659706811
        panda632.originalUrl = "https://www.bilibili.com/video/BV15F411P7og"
        panda632.tags = "大熊猫,萌宠,动物圈"
        panda632.authorId = 514531996
        panda632.cover =
            "https://i0.hdslb.com/bfs/archive/185c3816d477226cc758e53db67c9f152462b8a7.jpg"
        list.add(panda632)

        val panda633 = PetVideo()
        panda633.type = VideoType.PANDA.ordinal
        panda633.fileName = "panda_group_panda633"
        panda633.code = 2545
        panda633.duration = 265
        panda633.period = PeriodType.GROUP.ordinal
        panda633.star = false
        panda633.title = "花花:只要二狗姐喜欢，别说笋笋，盆盆奶也可以让给她喝"
        panda633.releaseTime = 1655273850
        panda633.originalUrl = "https://www.bilibili.com/video/BV1JT411G7U9"
        panda633.tags = "大熊猫,萌宠,动物圈"
        panda633.authorId = 1714028276
        panda633.cover =
            "https://i1.hdslb.com/bfs/archive/8955240d915d8bc0d8789d98e03f7a1caeee8615.png"
        list.add(panda633)

        val panda634 = PetVideo()
        panda634.type = VideoType.PANDA.ordinal
        panda634.fileName = "panda_group_panda634"
        panda634.code = 2546
        panda634.duration = 39
        panda634.period = PeriodType.GROUP.ordinal
        panda634.star = false
        panda634.title = "【大熊猫和花】谁能抵挡这美丽可爱大脸的暴击！！！一定是暴击！！！【4.26】"
        panda634.releaseTime = 1650974197
        panda634.originalUrl = "https://www.bilibili.com/video/BV1U541117yV"
        panda634.tags = "大熊猫,萌宠,动物圈"
        panda634.authorId = 97315338
        panda634.cover =
            "https://i0.hdslb.com/bfs/archive/5e63a9e60c0c100eb5baafe1f53b8ba1d603ea4d.jpg"
        list.add(panda634)

        val panda635 = PetVideo()
        panda635.type = VideoType.PANDA.ordinal
        panda635.fileName = "panda_group_panda635"
        panda635.code = 2547
        panda635.duration = 63
        panda635.period = PeriodType.GROUP.ordinal
        panda635.star = false
        panda635.title = "大熊猫和花，豆伴对话，结果我泪目了"
        panda635.releaseTime = 1659621861
        panda635.originalUrl = "https://www.bilibili.com/video/BV1yd4y1T7VN"
        panda635.tags = "大熊猫,萌宠,动物圈"
        panda635.authorId = 1809127548
        panda635.cover =
            "https://i2.hdslb.com/bfs/archive/732ea6719202385823778dd104ca86e7341f4e44.jpg"
        list.add(panda635)

        val panda636 = PetVideo()
        panda636.type = VideoType.PANDA.ordinal
        panda636.fileName = "panda_group_panda636"
        panda636.code = 2548
        panda636.duration = 82
        panda636.period = PeriodType.GROUP.ordinal
        panda636.star = false
        panda636.title = "知足常乐的花花，吃完红果果🍎，舔舔小嘴巴，开心一整天！😘"
        panda636.releaseTime = 1659613056
        panda636.originalUrl = "https://www.bilibili.com/video/BV1DG4y1v7mo"
        panda636.tags = "大熊猫,萌宠,动物圈"
        panda636.authorId = 16468440
        panda636.cover =
            "https://i1.hdslb.com/bfs/archive/39bfbb2b9339024f95ae6847ede717b3010c444e.jpg"
        list.add(panda636)

        val panda637 = PetVideo()
        panda637.type = VideoType.PANDA.ordinal
        panda637.fileName = "panda_group_panda637"
        panda637.code = 2549
        panda637.duration = 93
        panda637.period = PeriodType.GROUP.ordinal
        panda637.star = false
        panda637.title = "花 叶 姐 弟 也太喜剧了，一定要 看 到 最 后 ！！【大熊猫和花 和叶】"
        panda637.releaseTime = 1655767800
        panda637.originalUrl = "https://www.bilibili.com/video/BV1sg411X7Se"
        panda637.tags = "大熊猫,萌宠,动物圈"
        panda637.authorId = 16468440
        panda637.cover =
            "https://i0.hdslb.com/bfs/archive/d2161518103af473aac0c671e41b95c939f62862.jpg"
        list.add(panda637)

        val panda638 = PetVideo()
        panda638.type = VideoType.PANDA.ordinal
        panda638.fileName = "panda_group_panda638"
        panda638.code = 2550
        panda638.duration = 31
        panda638.period = PeriodType.GROUP.ordinal
        panda638.star = false
        panda638.title = "【大熊猫奇一】 爷爷我听到啦～不要急嘛～等我把笋消灭就跟你回家"
        panda638.releaseTime = 1578456108
        panda638.originalUrl = "https://www.bilibili.com/video/BV18J41157t5"
        panda638.tags = "大熊猫,萌宠,动物圈"
        panda638.authorId = 397311515
        panda638.cover =
            "https://i1.hdslb.com/bfs/archive/2547ddcadff4f78707eb673ce570abd63f751d03.jpg"
        list.add(panda638)

        val panda639 = PetVideo()
        panda639.type = VideoType.PANDA.ordinal
        panda639.fileName = "panda_group_panda639"
        panda639.code = 2551
        panda639.duration = 40
        panda639.period = PeriodType.GROUP.ordinal
        panda639.star = false
        panda639.title = "【大熊猫和花】谭爷爷的快乐就是有花花的陪伴"
        panda639.releaseTime = 1659083430
        panda639.originalUrl = "https://www.bilibili.com/video/BV1cN4y1L7vF"
        panda639.tags = "大熊猫,萌宠,动物圈"
        panda639.authorId = 608746190
        panda639.cover =
            "https://i0.hdslb.com/bfs/archive/b776a08b22680e4b0e77a84955f4fa59df7e4913.jpg"
        list.add(panda639)

        val panda640 = PetVideo()
        panda640.type = VideoType.PANDA.ordinal
        panda640.fileName = "panda_group_panda640"
        panda640.code = 2552
        panda640.duration = 17
        panda640.period = PeriodType.GROUP.ordinal
        panda640.star = false
        panda640.title = "还有比这更可爱的熊猫吗【大熊猫和花】"
        panda640.releaseTime = 1656076014
        panda640.originalUrl = "https://www.bilibili.com/video/BV1jT41137z5"
        panda640.tags = "大熊猫,萌宠,动物圈"
        panda640.authorId = 608746190
        panda640.cover =
            "https://i1.hdslb.com/bfs/archive/7af70990d394ab8634e0b168b78fb4388a79d207.jpg"
        list.add(panda640)

        val panda641 = PetVideo()
        panda641.type = VideoType.PANDA.ordinal
        panda641.fileName = "panda_group_panda641"
        panda641.code = 2553
        panda641.duration = 98
        panda641.period = PeriodType.GROUP.ordinal
        panda641.star = false
        panda641.title = "三姐妹一起吃早饭，吃着吃着就只剩花花一只小熊熊了"
        panda641.releaseTime = 1659408643
        panda641.originalUrl = "https://www.bilibili.com/video/BV1VF411A7mD"
        panda641.tags = "大熊猫,萌宠,动物圈"
        panda641.authorId = 1714028276
        panda641.cover =
            "https://i0.hdslb.com/bfs/archive/6a1170a9864563440904bc6705b6b0fef1e08abd.jpg"
        list.add(panda641)

        val panda642 = PetVideo()
        panda642.type = VideoType.PANDA.ordinal
        panda642.fileName = "panda_group_panda642"
        panda642.code = 2554
        panda642.duration = 86
        panda642.period = PeriodType.GROUP.ordinal
        panda642.star = false
        panda642.title = "可可爱爱的熊猫幼儿园"
        panda642.releaseTime = 1659496087
        panda642.originalUrl = "https://www.bilibili.com/video/BV1qa411N7cB"
        panda642.tags = "大熊猫,萌宠,动物圈"
        panda642.authorId = 1025949925
        panda642.cover =
            "https://i1.hdslb.com/bfs/archive/873c77f7ce15e4f68b4a3a0f900e53592a42e3c7.jpg"
        list.add(panda642)

        val panda643 = PetVideo()
        panda643.type = VideoType.PANDA.ordinal
        panda643.fileName = "panda_group_panda643"
        panda643.code = 2555
        panda643.duration = 161
        panda643.period = PeriodType.GROUP.ordinal
        panda643.star = false
        panda643.title = "‼️不得了，“斧头山”猛兽出洞啦，大家快闪开，有多远躲多远！😱【大熊猫和花】"
        panda643.releaseTime = 1659429347
        panda643.originalUrl = "https://www.bilibili.com/video/BV1NB4y187iR"
        panda643.tags = "大熊猫,萌宠,动物圈"
        panda643.authorId = 16468440
        panda643.cover =
            "https://i0.hdslb.com/bfs/archive/8294ea4320d7d698c4b901b69bf2b0636709785d.jpg"
        list.add(panda643)

        val panda644 = PetVideo()
        panda644.type = VideoType.PANDA.ordinal
        panda644.fileName = "panda_group_panda644"
        panda644.code = 2556
        panda644.duration = 175
        panda644.period = PeriodType.GROUP.ordinal
        panda644.star = false
        panda644.title = "花花：我就喜欢和二狗贴贴，我和二狗世界第一好"
        panda644.releaseTime = 1659441508
        panda644.originalUrl = "https://www.bilibili.com/video/BV1Le4y1D7Gx"
        panda644.tags = "大熊猫,萌宠,动物圈"
        panda644.authorId = 34677299
        panda644.cover =
            "https://i1.hdslb.com/bfs/archive/9d8290c5a665db8287ae1aadc9cf1630491bd8ea.jpg"
        list.add(panda644)

        val panda645 = PetVideo()
        panda645.type = VideoType.PANDA.ordinal
        panda645.fileName = "panda_group_panda645"
        panda645.code = 2557
        panda645.duration = 80
        panda645.period = PeriodType.GROUP.ordinal
        panda645.star = false
        panda645.title = "💐来和大姐大大姐头干早饭，开启美好的一天😜【大熊猫润玥 艾玖】"
        panda645.releaseTime = 1659402600
        panda645.originalUrl = "https://www.bilibili.com/video/BV16S4y1x7Fh"
        panda645.tags = "大熊猫,萌宠,动物圈"
        panda645.authorId = 16468440
        panda645.cover =
            "https://i2.hdslb.com/bfs/archive/8f87fb392fa557d7ff804b6c849d3caca68661ad.jpg"
        list.add(panda645)

        val panda646 = PetVideo()
        panda646.type = VideoType.PANDA.ordinal
        panda646.fileName = "panda_group_panda646"
        panda646.code = 2558
        panda646.duration = 41
        panda646.period = PeriodType.GROUP.ordinal
        panda646.star = false
        panda646.title = "韵文韵武：以为小姐弟分开了 结果还没有 要和谐相处哟"
        panda646.releaseTime = 1659059195
        panda646.originalUrl = "https://www.bilibili.com/video/BV1Pd4y1U7Ud"
        panda646.tags = "大熊猫,萌宠,动物圈"
        panda646.authorId = 442701460
        panda646.cover =
            "https://i2.hdslb.com/bfs/archive/9872412e2612cc6a59b4d9e75f50841b904be7c3.jpg"
        list.add(panda646)

        val panda647 = PetVideo()
        panda647.type = VideoType.PANDA.ordinal
        panda647.fileName = "panda_group_panda647"
        panda647.code = 2559
        panda647.duration = 272
        panda647.period = PeriodType.GROUP.ordinal
        panda647.star = false
        panda647.title = "【四喜丸子】壮壮可以永远相信二宝锅锅，以及不要搞事情"
        panda647.releaseTime = 1659349421
        panda647.originalUrl = "https://www.bilibili.com/video/BV1SY4y1P7VW"
        panda647.tags = "大熊猫,萌宠,动物圈"
        panda647.authorId = 180602305
        panda647.cover =
            "https://i0.hdslb.com/bfs/archive/723aeaff5f7d9b913f230a9aab5655da6ffd5a69.jpg"
        list.add(panda647)

        val panda648 = PetVideo()
        panda648.type = VideoType.PANDA.ordinal
        panda648.fileName = "panda_group_panda648"
        panda648.code = 2560
        panda648.duration = 80
        panda648.period = PeriodType.GROUP.ordinal
        panda648.star = false
        panda648.title = "这是一只很特别的大熊猫"
        panda648.releaseTime = 1659326877
        panda648.originalUrl = "https://www.bilibili.com/video/BV1ba411Z7XF"
        panda648.tags = "大熊猫,萌宠,动物圈"
        panda648.authorId = 1025949925
        panda648.cover =
            "https://i0.hdslb.com/bfs/archive/88778db4bab10725373c66d2a2593810377f9c60.jpg"
        list.add(panda648)

        val panda649 = PetVideo()
        panda649.type = VideoType.PANDA.ordinal
        panda649.fileName = "panda_group_panda649"
        panda649.code = 2561
        panda649.duration = 138
        panda649.period = PeriodType.GROUP.ordinal
        panda649.star = false
        panda649.title = "花宝叽练习爬树爬累了，趴在树边休息【大熊猫和花】"
        panda649.releaseTime = 1659241555
        panda649.originalUrl = "https://www.bilibili.com/video/BV12G411h7Kv"
        panda649.tags = "大熊猫,萌宠,动物圈"
        panda649.authorId = 230382720
        panda649.cover =
            "https://i2.hdslb.com/bfs/archive/f83fe4805fa37cd8f2d1bb279350b58818132149.jpg"
        list.add(panda649)

        val panda650 = PetVideo()
        panda650.type = VideoType.PANDA.ordinal
        panda650.fileName = "panda_group_panda650"
        panda650.code = 2562
        panda650.duration = 30
        panda650.period = PeriodType.GROUP.ordinal
        panda650.star = false
        panda650.title = "【大熊猫渝宝】他知道自己有多可爱吗！！！"
        panda650.releaseTime = 1640085156
        panda650.originalUrl = "https://www.bilibili.com/video/BV17u411S7BX"
        panda650.tags = "大熊猫,萌宠,动物圈"
        panda650.authorId = 180602305
        panda650.cover =
            "https://i0.hdslb.com/bfs/archive/c457d67a3cae3b8a7b13952764211bdae7df3eb1.jpg"
        list.add(panda650)

        val panda651 = PetVideo()
        panda651.type = VideoType.PANDA.ordinal
        panda651.fileName = "panda_group_panda651"
        panda651.code = 2563
        panda651.duration = 187
        panda651.period = PeriodType.GROUP.ordinal
        panda651.star = false
        panda651.title = "步步糕生掐架，小情侣现场解说。【大熊猫蛋烘糕、春生】"
        panda651.releaseTime = 1659168008
        panda651.originalUrl = "https://www.bilibili.com/video/BV1HB4y1b7QH"
        panda651.tags = "大熊猫,萌宠,动物圈"
        panda651.authorId = 514531996
        panda651.cover =
            "https://i0.hdslb.com/bfs/archive/b77db03b298318a8eab403056f09974326d87d2b.jpg"
        list.add(panda651)

        val panda652 = PetVideo()
        panda652.type = VideoType.PANDA.ordinal
        panda652.fileName = "panda_group_panda652"
        panda652.code = 2564
        panda652.duration = 129
        panda652.period = PeriodType.GROUP.ordinal
        panda652.star = false
        panda652.title = "哦哟，你们在🌸花主任面前打架还不带主任，这还了得！😤【大熊猫和花润玥艾玖】"
        panda652.releaseTime = 1659174013
        panda652.originalUrl = "https://www.bilibili.com/video/BV1AU4y1v78k"
        panda652.tags = "大熊猫,萌宠,动物圈"
        panda652.authorId = 16468440
        panda652.cover =
            "https://i0.hdslb.com/bfs/archive/2dd24c64b1086aedb6f9c4990aa94060f59f3aba.jpg"
        list.add(panda652)

        val panda653 = PetVideo()
        panda653.type = VideoType.PANDA.ordinal
        panda653.fileName = "panda_group_panda653"
        panda653.code = 2565
        panda653.duration = 72
        panda653.period = PeriodType.GROUP.ordinal
        panda653.star = false
        panda653.title = "【大熊猫艾玖&和花】想咬玖玖的大耳朵，咬不到，生气“滚”走了"
        panda653.releaseTime = 1659100738
        panda653.originalUrl = "https://www.bilibili.com/video/BV1MB4y1b7wZ"
        panda653.tags = "大熊猫,萌宠,动物圈"
        panda653.authorId = 34677299
        panda653.cover =
            "https://i1.hdslb.com/bfs/archive/b4e94dd8871fa8316b672d9770eb53c6bae9eedc.jpg"
        list.add(panda653)

        val panda654 = PetVideo()
        panda654.type = VideoType.PANDA.ordinal
        panda654.fileName = "panda_group_panda654"
        panda654.code = 2566
        panda654.duration = 47
        panda654.period = PeriodType.GROUP.ordinal
        panda654.star = false
        panda654.title = "瓜弟好可爱，像极了村口大树上逃学的小屁孩。【大熊猫和叶】"
        panda654.releaseTime = 1659103338
        panda654.originalUrl = "https://www.bilibili.com/video/BV1m94y1D7ys"
        panda654.tags = "大熊猫,萌宠,动物圈"
        panda654.authorId = 514531996
        panda654.cover =
            "https://i2.hdslb.com/bfs/archive/cfeeaf415fa112f245bdd743e42d13a1c53efe43.jpg"
        list.add(panda654)

        val panda655 = PetVideo()
        panda655.type = VideoType.PANDA.ordinal
        panda655.fileName = "panda_group_panda655"
        panda655.code = 2567
        panda655.duration = 291
        panda655.period = PeriodType.GROUP.ordinal
        panda655.star = false
        panda655.title = "🌿和叶，要不是你🌸花姐自己滚起跑了，你咋可能逃得出她的熊掌心?😎【大熊猫和花和叶】"
        panda655.releaseTime = 1659086280
        panda655.originalUrl = "https://www.bilibili.com/video/BV1GB4y1b7Pj"
        panda655.tags = "大熊猫,萌宠,动物圈"
        panda655.authorId = 16468440
        panda655.cover =
            "https://i1.hdslb.com/bfs/archive/e10df11d4f3933e0b14bc9437979d1eb03ce328b.jpg"
        list.add(panda655)

        val panda656 = PetVideo()
        panda656.type = VideoType.PANDA.ordinal
        panda656.fileName = "panda_group_panda656"
        panda656.code = 2568
        panda656.duration = 47
        panda656.period = PeriodType.GROUP.ordinal
        panda656.star = false
        panda656.title = "大熊猫聚众醉奶，最后几秒钟场面控制不住了……"
        panda656.releaseTime = 1619695811
        panda656.originalUrl = "https://www.bilibili.com/video/BV1vV41177io"
        panda656.tags = "大熊猫,萌宠,动物圈"
        panda656.authorId = 1998535
        panda656.cover =
            "https://i2.hdslb.com/bfs/archive/5bcc735ce2eb9617c25561787987a5c0efed3bb0.jpg"
        list.add(panda656)

        val panda657 = PetVideo()
        panda657.type = VideoType.PANDA.ordinal
        panda657.fileName = "panda_group_panda657"
        panda657.code = 2569
        panda657.duration = 173
        panda657.period = PeriodType.GROUP.ordinal
        panda657.star = false
        panda657.title = "熊猫的饭斗剧《花花传》"
        panda657.releaseTime = 1656818892
        panda657.originalUrl = "https://www.bilibili.com/video/BV1Mf4y1Z76c"
        panda657.tags = "大熊猫,萌宠,动物圈"
        panda657.authorId = 1025949925
        panda657.cover =
            "https://i1.hdslb.com/bfs/archive/f4499a092f993cbaeaf7abeb8a10be31ed9c2d5b.jpg"
        list.add(panda657)

        val panda658 = PetVideo()
        panda658.type = VideoType.PANDA.ordinal
        panda658.fileName = "panda_group_panda658"
        panda658.code = 2570
        panda658.duration = 7
        panda658.period = PeriodType.GROUP.ordinal
        panda658.star = false
        panda658.title = "这是谁的宝宝"
        panda658.releaseTime = 1658288250
        panda658.originalUrl = "https://www.bilibili.com/video/BV1b3411F7VP"
        panda658.tags = "大熊猫,萌宠,动物圈"
        panda658.authorId = 1025949925
        panda658.cover =
            "https://i1.hdslb.com/bfs/archive/470150cac396416eaee2a94b69b2e0c2cc3fb554.jpg"
        list.add(panda658)

        val panda659 = PetVideo()
        panda659.type = VideoType.PANDA.ordinal
        panda659.fileName = "panda_group_panda659"
        panda659.code = 2571
        panda659.duration = 80
        panda659.period = PeriodType.GROUP.ordinal
        panda659.star = false
        panda659.title = "小花花孵🎃南瓜蛋！【大熊猫和花】"
        panda659.releaseTime = 1659066276
        panda659.originalUrl = "https://www.bilibili.com/video/BV1WN4y1L72d"
        panda659.tags = "大熊猫,萌宠,动物圈"
        panda659.authorId = 16468440
        panda659.cover =
            "https://i2.hdslb.com/bfs/archive/dffd5256212fded1999427d007b125a215b20651.jpg"
        list.add(panda659)

        val panda660 = PetVideo()
        panda660.type = VideoType.PANDA.ordinal
        panda660.fileName = "panda_group_panda660"
        panda660.code = 2572
        panda660.duration = 66
        panda660.period = PeriodType.GROUP.ordinal
        panda660.star = false
        panda660.title = "舔手手嗯嗯熊——庆重阳😍"
        panda660.releaseTime = 1658979480
        panda660.originalUrl = "https://www.bilibili.com/video/BV1494y1D7Ew"
        panda660.tags = "大熊猫,萌宠,动物圈"
        panda660.authorId = 16468440
        panda660.cover =
            "https://i2.hdslb.com/bfs/archive/add5043c97448b11d3fb9e309935a36739871d96.jpg"
        list.add(panda660)

        val panda661 = PetVideo()
        panda661.type = VideoType.PANDA.ordinal
        panda661.fileName = "panda_group_panda661"
        panda661.code = 2573
        panda661.duration = 75
        panda661.period = PeriodType.GROUP.ordinal
        panda661.star = false
        panda661.title = "花花放暑假，已经6天没看到霸王花了"
        panda661.releaseTime = 1657690320
        panda661.originalUrl = "https://www.bilibili.com/video/BV1zY4y177HN"
        panda661.tags = "大熊猫,萌宠,动物圈"
        panda661.authorId = 384395600
        panda661.cover =
            "https://i0.hdslb.com/bfs/archive/d33887f93064f74d8ed9c6332fefd307571f488c.jpg"
        list.add(panda661)

        val panda662 = PetVideo()
        panda662.type = VideoType.PANDA.ordinal
        panda662.fileName = "panda_group_panda662"
        panda662.code = 2574
        panda662.duration = 134
        panda662.period = PeriodType.GROUP.ordinal
        panda662.star = false
        panda662.title = "【大熊猫金喜&福双】金喜把葫芦娃推下沟沟，葫芦娃上来就赏了一个大比兜"
        panda662.releaseTime = 1658928562
        panda662.originalUrl = "https://www.bilibili.com/video/BV1cB4y1b7Y2"
        panda662.tags = "大熊猫,萌宠,动物圈"
        panda662.authorId = 34677299
        panda662.cover =
            "https://i0.hdslb.com/bfs/archive/f777d366007430ccd5ab3c0fe98f056b8b9b9527.jpg"
        list.add(panda662)

        val panda663 = PetVideo()
        panda663.type = VideoType.PANDA.ordinal
        panda663.fileName = "panda_group_panda663"
        panda663.code = 2575
        panda663.duration = 294
        panda663.period = PeriodType.GROUP.ordinal
        panda663.star = false
        panda663.title = "【四喜丸子】来看看2年前四喜丸子“洗澡”"
        panda663.releaseTime = 1658914469
        panda663.originalUrl = "https://www.bilibili.com/video/BV1wg41117GG"
        panda663.tags = "大熊猫,萌宠,动物圈"
        panda663.authorId = 180602305
        panda663.cover =
            "https://i0.hdslb.com/bfs/archive/6beacf28b4ded68b9ced1d8b19ff0296b0c5ff9a.jpg"
        list.add(panda663)

        val panda664 = PetVideo()
        panda664.type = VideoType.PANDA.ordinal
        panda664.fileName = "panda_group_panda664"
        panda664.code = 2576
        panda664.duration = 166
        panda664.period = PeriodType.GROUP.ordinal
        panda664.star = false
        panda664.title = "幼年园1班底层姐弟打架，一时分不清到底谁赢了"
        panda664.releaseTime = 1658919142
        panda664.originalUrl = "https://www.bilibili.com/video/BV1ZU4y1e7HS"
        panda664.tags = "大熊猫,萌宠,动物圈"
        panda664.authorId = 384395600
        panda664.cover =
            "https://i1.hdslb.com/bfs/archive/1176fa93ca88bc9c5e1b0cf6b8ad09a45c6badc0.jpg"
        list.add(panda664)

        val panda665 = PetVideo()
        panda665.type = VideoType.PANDA.ordinal
        panda665.fileName = "panda_group_panda665"
        panda665.code = 2577
        panda665.duration = 34
        panda665.period = PeriodType.GROUP.ordinal
        panda665.star = false
        panda665.title = "爷爷喊fa仔回家，松狮花打哈欠引“哇”声一片。【大熊猫和花】"
        panda665.releaseTime = 1658927200
        panda665.originalUrl = "https://www.bilibili.com/video/BV1XS4y147ZQ"
        panda665.tags = "大熊猫,萌宠,动物圈"
        panda665.authorId = 514531996
        panda665.cover =
            "https://i2.hdslb.com/bfs/archive/fbc05ffff26dc59e494a74aad8526d6eff15c07c.jpg"
        list.add(panda665)

        val panda666 = PetVideo()
        panda666.type = VideoType.PANDA.ordinal
        panda666.fileName = "panda_group_panda666"
        panda666.code = 2578
        panda666.duration = 35
        panda666.period = PeriodType.GROUP.ordinal
        panda666.star = false
        panda666.title = "谭爷爷钓猫离沟，成和花欲吃故纵"
        panda666.releaseTime = 1658910716
        panda666.originalUrl = "https://www.bilibili.com/video/BV1v94y1D7Je"
        panda666.tags = "大熊猫,萌宠,动物圈"
        panda666.authorId = 1307515
        panda666.cover =
            "https://i0.hdslb.com/bfs/archive/f1b13fe82e82f407d5f09dedd707f4e1b9b690d1.jpg"
        list.add(panda666)

        val panda667 = PetVideo()
        panda667.type = VideoType.PANDA.ordinal
        panda667.fileName = "panda_group_panda667"
        panda667.code = 2579
        panda667.duration = 131
        panda667.period = PeriodType.GROUP.ordinal
        panda667.star = false
        panda667.title = "爱你duang duang 的模样，黑白毛球在草地上蹦跶【大熊猫和花】"
        panda667.releaseTime = 1658890112
        panda667.originalUrl = "https://www.bilibili.com/video/BV1XF411P7z3"
        panda667.tags = "大熊猫,萌宠,动物圈"
        panda667.authorId = 230382720
        panda667.cover =
            "https://i0.hdslb.com/bfs/archive/b670ede7c82e6dda12870f8a9b8439a22f7711b8.jpg"
        list.add(panda667)

        val panda668 = PetVideo()
        panda668.type = VideoType.PANDA.ordinal
        panda668.fileName = "panda_group_panda668"
        panda668.code = 2580
        panda668.duration = 101
        panda668.period = PeriodType.GROUP.ordinal
        panda668.star = false
        panda668.title = "🌸花花吃窝窝头啦！和弟弟一起吃得好开心，还没有被抢走！😍【大熊猫和花】"
        panda668.releaseTime = 1658827402
        panda668.originalUrl = "https://www.bilibili.com/video/BV1qe4y1Q7dS"
        panda668.tags = "大熊猫,萌宠,动物圈"
        panda668.authorId = 16468440
        panda668.cover =
            "https://i1.hdslb.com/bfs/archive/0852e3d1622267268c60b66c269a30e38e00552d.jpg"
        list.add(panda668)

        val panda669 = PetVideo()
        panda669.type = VideoType.PANDA.ordinal
        panda669.fileName = "panda_group_panda669"
        panda669.code = 2581
        panda669.duration = 184
        panda669.period = PeriodType.GROUP.ordinal
        panda669.star = false
        panda669.title = "论花叶姐弟动作的一致——姐弟俩一起下沟，一起坐着、躺着，最后一起走熊，不愧是亲姐弟呀"
        panda669.releaseTime = 1658743722
        panda669.originalUrl = "https://www.bilibili.com/video/BV11e4y1Q723"
        panda669.tags = "大熊猫,萌宠,动物圈"
        panda669.authorId = 443245052
        panda669.cover =
            "https://i0.hdslb.com/bfs/archive/d4a94278f2e09f6147edac933d07a41536ac4b4e.jpg"
        list.add(panda669)

        val panda670 = PetVideo()
        panda670.type = VideoType.PANDA.ordinal
        panda670.fileName = "panda_group_panda670"
        panda670.code = 2582
        panda670.duration = 7
        panda670.period = PeriodType.GROUP.ordinal
        panda670.star = false
        panda670.title = "有想这个小盆友了吗？"
        panda670.releaseTime = 1658552855
        panda670.originalUrl = "https://www.bilibili.com/video/BV1tB4y1k7G2"
        panda670.tags = "大熊猫,萌宠,动物圈"
        panda670.authorId = 1198136200
        panda670.cover =
            "https://i2.hdslb.com/bfs/archive/7d93b2c96c0824420dc19cc310addbbefaf6489c.jpg"
        list.add(panda670)

        val panda671 = PetVideo()
        panda671.type = VideoType.PANDA.ordinal
        panda671.fileName = "panda_group_panda671"
        panda671.code = 2583
        panda671.duration = 75
        panda671.period = PeriodType.GROUP.ordinal
        panda671.star = false
        panda671.title = "💐这是你的心上熊吗?～她为什么走到了我的心巴上😘"
        panda671.releaseTime = 1658730080
        panda671.originalUrl = "https://www.bilibili.com/video/BV1eY4y1A751"
        panda671.tags = "大熊猫,萌宠,动物圈"
        panda671.authorId = 16468440
        panda671.cover =
            "https://i2.hdslb.com/bfs/archive/7aef9527d12b336c10dae0ea8f1bc4a8cc881090.jpg"
        list.add(panda671)

        val panda672 = PetVideo()
        panda672.type = VideoType.PANDA.ordinal
        panda672.fileName = "panda_group_panda672"
        panda672.code = 2584
        panda672.duration = 92
        panda672.period = PeriodType.GROUP.ordinal
        panda672.star = false
        panda672.title = "大熊猫园润：听雨声看奶润吃播，太治愈了。"
        panda672.releaseTime = 1658668346
        panda672.originalUrl = "https://www.bilibili.com/video/BV1TV4y1E7g9"
        panda672.tags = "大熊猫,萌宠,动物圈"
        panda672.authorId = 514531996
        panda672.cover =
            "https://i1.hdslb.com/bfs/archive/2ce101c1b661c2b67ddf4de32f23c4715d734064.jpg"
        list.add(panda672)

        val panda673 = PetVideo()
        panda673.type = VideoType.PANDA.ordinal
        panda673.fileName = "panda_group_panda673"
        panda673.code = 2585
        panda673.duration = 103
        panda673.period = PeriodType.GROUP.ordinal
        panda673.star = false
        panda673.title = "🌧幼年1班打架，金喜隔岸观火还嗯嗯叫！【大熊猫金喜和花和叶润玥】"
        panda673.releaseTime = 1658631623
        panda673.originalUrl = "https://www.bilibili.com/video/BV1Ka411T7Ur"
        panda673.tags = "大熊猫,萌宠,动物圈"
        panda673.authorId = 16468440
        panda673.cover =
            "https://i2.hdslb.com/bfs/archive/ace1ab5ae504b5c788efa646522123a31a8912ce.jpg"
        list.add(panda673)

        val panda674 = PetVideo()
        panda674.type = VideoType.PANDA.ordinal
        panda674.fileName = "panda_group_panda674"
        panda674.code = 2586
        panda674.duration = 90
        panda674.period = PeriodType.GROUP.ordinal
        panda674.star = false
        panda674.title = "二班钓猫很好玩"
        panda674.releaseTime = 1658632200
        panda674.originalUrl = "https://www.bilibili.com/video/BV1w34y1n76C"
        panda674.tags = "大熊猫,萌宠,动物圈"
        panda674.authorId = 1025949925
        panda674.cover =
            "https://i1.hdslb.com/bfs/archive/e35de108af28234a523a22752a702d572fb97db5.jpg"
        list.add(panda674)

        val panda675 = PetVideo()
        panda675.type = VideoType.PANDA.ordinal
        panda675.fileName = "panda_group_panda675"
        panda675.code = 2587
        panda675.duration = 13
        panda675.period = PeriodType.GROUP.ordinal
        panda675.star = false
        panda675.title = "晚安～玛卡巴卡。fafa小仙女，爱你哟～"
        panda675.releaseTime = 1658413783
        panda675.originalUrl = "https://www.bilibili.com/video/BV1BU4y1i7Dm"
        panda675.tags = "大熊猫,萌宠,动物圈"
        panda675.authorId = 484440897
        panda675.cover =
            "https://i0.hdslb.com/bfs/archive/c41a6cde715279e5286d5674898c423bce0f6b04.jpg"
        list.add(panda675)

        val panda676 = PetVideo()
        panda676.type = VideoType.PANDA.ordinal
        panda676.fileName = "panda_group_panda676"
        panda676.code = 2588
        panda676.duration = 152
        panda676.period = PeriodType.GROUP.ordinal
        panda676.star = false
        panda676.title = "这是什么人间绝世大甜妞，姐姐们都好爱她（doge）～～有没有觉得花花，手手长长了，好激动呀～哈哈哈"
        panda676.releaseTime = 1658532600
        panda676.originalUrl = "https://www.bilibili.com/video/BV1ZG4y1v7ht"
        panda676.tags = "大熊猫,萌宠,动物圈"
        panda676.authorId = 484440897
        panda676.cover =
            "https://i1.hdslb.com/bfs/archive/a349eb061b206d3e131ec5a3973ecc8717982319.jpg"
        list.add(panda676)

        val panda677 = PetVideo()
        panda677.type = VideoType.PANDA.ordinal
        panda677.fileName = "panda_group_panda677"
        panda677.code = 2589
        panda677.duration = 45
        panda677.period = PeriodType.GROUP.ordinal
        panda677.star = false
        panda677.title = "大熊猫和花-吃窝头也要优雅，一口嚼十下"
        panda677.releaseTime = 1658565162
        panda677.originalUrl = "https://www.bilibili.com/video/BV1xr4y177PZ"
        panda677.tags = "大熊猫,萌宠,动物圈"
        panda677.authorId = 1307515
        panda677.cover =
            "https://i1.hdslb.com/bfs/archive/08fc5461d1c6346e5659e172a4cfc2db72440a28.jpg"
        list.add(panda677)

        val panda678 = PetVideo()
        panda678.type = VideoType.PANDA.ordinal
        panda678.fileName = "panda_group_panda678"
        panda678.code = 2590
        panda678.duration = 49
        panda678.period = PeriodType.GROUP.ordinal
        panda678.star = false
        panda678.title = "【四喜丸子】莽壮壮：来啊！战啊！（抠痒掰头）"
        panda678.releaseTime = 1658569243
        panda678.originalUrl = "https://www.bilibili.com/video/BV11F411K7Mi"
        panda678.tags = "大熊猫,萌宠,动物圈"
        panda678.authorId = 180602305
        panda678.cover =
            "https://i0.hdslb.com/bfs/archive/47402fa597307f16c0703b1868347cf35aa1bfee.jpg"
        list.add(panda678)

        val panda679 = PetVideo()
        panda679.type = VideoType.PANDA.ordinal
        panda679.fileName = "panda_group_panda679"
        panda679.code = 2591
        panda679.duration = 112
        panda679.period = PeriodType.GROUP.ordinal
        panda679.star = false
        panda679.title = "好惬意的下雨天～金喜锅锅过来耍撒～～～叶甜甜vs润玥玥，前方注意大头花闪现～艾玖玖表示窝不想出镜～【大熊猫和花和叶润玥艾玖金喜】"
        panda679.releaseTime = 1658553399
        panda679.originalUrl = "https://www.bilibili.com/video/BV1ua411u7dp"
        panda679.tags = "大熊猫,萌宠,动物圈"
        panda679.authorId = 484440897
        panda679.cover =
            "https://i2.hdslb.com/bfs/archive/6f1af74b687e0d3dae703e62defe3e364168b381.jpg"
        list.add(panda679)

        val panda680 = PetVideo()
        panda680.type = VideoType.PANDA.ordinal
        panda680.fileName = "panda_group_panda680"
        panda680.code = 2592
        panda680.duration = 181
        panda680.period = PeriodType.GROUP.ordinal
        panda680.star = false
        panda680.title = "胖胖花趴着睡得好香啊！可硬是被顽皮滴玖玖给造了起来！心宽体胖滴花花啊！"
        panda680.releaseTime = 1658542372
        panda680.originalUrl = "https://www.bilibili.com/video/BV1Fa411u7ZK"
        panda680.tags = "大熊猫,萌宠,动物圈"
        panda680.authorId = 481917765
        panda680.cover =
            "https://i1.hdslb.com/bfs/archive/00d2ee85f60f80c8e1216be2447b1b184583bf7c.jpg"
        list.add(panda680)

        val panda681 = PetVideo()
        panda681.type = VideoType.PANDA.ordinal
        panda681.fileName = "panda_group_panda681"
        panda681.code = 2593
        panda681.duration = 119
        panda681.period = PeriodType.GROUP.ordinal
        panda681.star = false
        panda681.title = "花花下沟沟啦，超聪明哒，是不是想从沟里爬上来找两脚兽玩呀"
        panda681.releaseTime = 1657089185
        panda681.originalUrl = "https://www.bilibili.com/video/BV1Sa411D7Jx"
        panda681.tags = "大熊猫,萌宠,动物圈"
        panda681.authorId = 484440897
        panda681.cover =
            "https://i2.hdslb.com/bfs/archive/76571f9b29c4b29a67c42f8eee3a35911765155e.jpg"
        list.add(panda681)

        val panda682 = PetVideo()
        panda682.type = VideoType.PANDA.ordinal
        panda682.fileName = "panda_group_panda682"
        panda682.code = 2594
        panda682.duration = 199
        panda682.period = PeriodType.GROUP.ordinal
        panda682.star = false
        panda682.title = "我弟弟叫和叶🌿，我爱他，而且你知道吗?他也爱我！（永远爱我）💕【大熊猫和花和叶】"
        panda682.releaseTime = 1658531040
        panda682.originalUrl = "https://www.bilibili.com/video/BV1YU4y1i7h3"
        panda682.tags = "大熊猫,萌宠,动物圈"
        panda682.authorId = 16468440
        panda682.cover =
            "https://i1.hdslb.com/bfs/archive/7ebdeeb4828355f9a9a2bca41402aac3e38e0946.jpg"
        list.add(panda682)

        val panda683 = PetVideo()
        panda683.type = VideoType.PANDA.ordinal
        panda683.fileName = "panda_group_panda683"
        panda683.code = 2595
        panda683.duration = 253
        panda683.period = PeriodType.GROUP.ordinal
        panda683.star = false
        panda683.title = "乖哭了！！大熊猫界的娃娃脸不是吹的【大熊猫和花、和叶】"
        panda683.releaseTime = 1658494592
        panda683.originalUrl = "https://www.bilibili.com/video/BV1nd4y1S7cp"
        panda683.tags = "大熊猫,萌宠,动物圈"
        panda683.authorId = 230382720
        panda683.cover =
            "https://i0.hdslb.com/bfs/archive/f730f5ff3f09559993243996746bda2562300591.jpg"
        list.add(panda683)

        val panda684 = PetVideo()
        panda684.type = VideoType.PANDA.ordinal
        panda684.fileName = "panda_group_panda684"
        panda684.code = 2596
        panda684.duration = 91
        panda684.period = PeriodType.GROUP.ordinal
        panda684.star = false
        panda684.title = "07.22💕今日份最美丽最可爱最绝绝子的🌸花宝叽！【大熊猫和花】"
        panda684.releaseTime = 1658486273
        panda684.originalUrl = "https://www.bilibili.com/video/BV1T94y1X7wZ"
        panda684.tags = "大熊猫,萌宠,动物圈"
        panda684.authorId = 16468440
        panda684.cover =
            "https://i1.hdslb.com/bfs/archive/02c80bcc0e554aa30511d6d3afb8113538a91bd3.jpg"
        list.add(panda684)

        val panda685 = PetVideo()
        panda685.type = VideoType.PANDA.ordinal
        panda685.fileName = "panda_group_panda685"
        panda685.code = 2597
        panda685.duration = 96
        panda685.period = PeriodType.GROUP.ordinal
        panda685.star = false
        panda685.title = "【大熊猫和花】和花安静坐着，却迎来一波开小灶，润玥刚好错过"
        panda685.releaseTime = 1658489100
        panda685.originalUrl = "https://www.bilibili.com/video/BV1oB4y1Y7uK"
        panda685.tags = "大熊猫,萌宠,动物圈"
        panda685.authorId = 327377672
        panda685.cover =
            "https://i2.hdslb.com/bfs/archive/d387dd6ef04e084678b56c8b9bf3f846d05e7b9b.jpg"
        list.add(panda685)

        val panda686 = PetVideo()
        panda686.type = VideoType.PANDA.ordinal
        panda686.fileName = "panda_group_panda686"
        panda686.code = 2598
        panda686.duration = 92
        panda686.period = PeriodType.GROUP.ordinal
        panda686.star = false
        panda686.title = "👸花花公主就是不仅要谭爷爷接回家，还得谭爷爷送出来上学😊💓"
        panda686.releaseTime = 1658444640
        panda686.originalUrl = "https://www.bilibili.com/video/BV1vU4y1i7MU"
        panda686.tags = "大熊猫,萌宠,动物圈"
        panda686.authorId = 16468440
        panda686.cover =
            "https://i1.hdslb.com/bfs/archive/706458ba6ceffe5d0cdb5c3a199f18c203cb24fe.jpg"
        list.add(panda686)

        val panda687 = PetVideo()
        panda687.type = VideoType.PANDA.ordinal
        panda687.fileName = "panda_group_panda687"
        panda687.code = 2599
        panda687.duration = 68
        panda687.period = PeriodType.GROUP.ordinal
        panda687.star = false
        panda687.title = "【大熊猫和花&和叶】爷爷刚喂完苹果，坐在前面浅浅的开个见面会吧"
        panda687.releaseTime = 1658412445
        panda687.originalUrl = "https://www.bilibili.com/video/BV12B4y1Y7xr"
        panda687.tags = "大熊猫,萌宠,动物圈"
        panda687.authorId = 34677299
        panda687.cover =
            "https://i0.hdslb.com/bfs/archive/0d5b62f27417ee2b197fc94029fc0e8c12cc383d.jpg"
        list.add(panda687)

        val panda688 = PetVideo()
        panda688.type = VideoType.PANDA.ordinal
        panda688.fileName = "panda_group_panda688"
        panda688.code = 2600
        panda688.duration = 121
        panda688.period = PeriodType.GROUP.ordinal
        panda688.star = false
        panda688.title = "【大熊猫和花】不愧是荔枝花，它一直在进步"
        panda688.releaseTime = 1658412000
        panda688.originalUrl = "https://www.bilibili.com/video/BV1Me4y197Hc"
        panda688.tags = "大熊猫,萌宠,动物圈"
        panda688.authorId = 98871951
        panda688.cover =
            "https://i0.hdslb.com/bfs/archive/35971bb42a1944c5f65a60e66b6dee3108da1b54.jpg"
        list.add(panda688)

        val panda689 = PetVideo()
        panda689.type = VideoType.PANDA.ordinal
        panda689.fileName = "panda_group_panda689"
        panda689.code = 2601
        panda689.duration = 158
        panda689.period = PeriodType.GROUP.ordinal
        panda689.star = false
        panda689.title = "为了斧头山幼年1班的和谐发展，🌸花主任甘做垫jio熊！😍您辛苦了！💐"
        panda689.releaseTime = 1658383824
        panda689.originalUrl = "https://www.bilibili.com/video/BV1kN4y1j7nq"
        panda689.tags = "大熊猫,萌宠,动物圈"
        panda689.authorId = 16468440
        panda689.cover =
            "https://i0.hdslb.com/bfs/archive/6921d7a862dbfb84e98e5e47ea38a336616d9ad2.jpg"
        list.add(panda689)

        val panda690 = PetVideo()
        panda690.type = VideoType.PANDA.ordinal
        panda690.fileName = "panda_group_panda690"
        panda690.code = 2602
        panda690.duration = 115
        panda690.period = PeriodType.GROUP.ordinal
        panda690.star = false
        panda690.title = "💓我们花花早就爬上过这颗大树了，相信有一天你也可以登顶！加油鸭😘"
        panda690.releaseTime = 1658398665
        panda690.originalUrl = "https://www.bilibili.com/video/BV1534y1n7t9"
        panda690.tags = "大熊猫,萌宠,动物圈"
        panda690.authorId = 16468440
        panda690.cover =
            "https://i1.hdslb.com/bfs/archive/36d703bf45dd20665263c81986eb874351abaf4f.jpg"
        list.add(panda690)

        val panda691 = PetVideo()
        panda691.type = VideoType.PANDA.ordinal
        panda691.fileName = "panda_group_panda691"
        panda691.code = 2603
        panda691.duration = 150
        panda691.period = PeriodType.GROUP.ordinal
        panda691.star = false
        panda691.title = "一只非常执着的熊猫"
        panda691.releaseTime = 1658372828
        panda691.originalUrl = "https://www.bilibili.com/video/BV1EV4y177M3"
        panda691.tags = "大熊猫,萌宠,动物圈"
        panda691.authorId = 1025949925
        panda691.cover =
            "https://i2.hdslb.com/bfs/archive/f65dc66444b71a0e40f6fb65df54baadb7accf87.jpg"
        list.add(panda691)

        val panda692 = PetVideo()
        panda692.type = VideoType.PANDA.ordinal
        panda692.fileName = "panda_group_panda692"
        panda692.code = 2604
        panda692.duration = 277
        panda692.period = PeriodType.GROUP.ordinal
        panda692.star = false
        panda692.title = "07.19 幼年2班钓猫～可爱的嘤嘤怪们，好久不见💓"
        panda692.releaseTime = 1658292723
        panda692.originalUrl = "https://www.bilibili.com/video/BV18d4y1Q7Gz"
        panda692.tags = "大熊猫,萌宠,动物圈"
        panda692.authorId = 16468440
        panda692.cover =
            "https://i0.hdslb.com/bfs/archive/7f018ab2b213c3a82db12ed435247baaba9c044f.jpg"
        list.add(panda692)

        val panda693 = PetVideo()
        panda693.type = VideoType.PANDA.ordinal
        panda693.fileName = "panda_group_panda693"
        panda693.code = 2605
        panda693.duration = 126
        panda693.period = PeriodType.GROUP.ordinal
        panda693.star = false
        panda693.title = "姐弟俩各自的护食能力真是两个极端，花花太礼貌了【大熊猫和花、和叶】"
        panda693.releaseTime = 1658295562
        panda693.originalUrl = "https://www.bilibili.com/video/BV1nB4y187F8"
        panda693.tags = "大熊猫,萌宠,动物圈"
        panda693.authorId = 230382720
        panda693.cover =
            "https://i0.hdslb.com/bfs/archive/40e7a05708e48fbb703e766d5ca2c002861fa27c.jpg"
        list.add(panda693)

        val panda694 = PetVideo()
        panda694.type = VideoType.PANDA.ordinal
        panda694.fileName = "panda_group_panda694"
        panda694.code = 2606
        panda694.duration = 39
        panda694.period = PeriodType.GROUP.ordinal
        panda694.star = false
        panda694.title = "【大熊猫成风】风风吃播，还有两个小孩儿给吹风扇，风风看了一眼他们，三个宝宝真的太有爱啦。"
        panda694.releaseTime = 1656514157
        panda694.originalUrl = "https://www.bilibili.com/video/BV1qW4y1z7iT"
        panda694.tags = "大熊猫,萌宠,动物圈"
        panda694.authorId = 542836361
        panda694.cover =
            "https://i2.hdslb.com/bfs/archive/23756d888600879f6f9fdcfab2e277be2bfab751.jpg"
        list.add(panda694)

        val panda695 = PetVideo()
        panda695.type = VideoType.PANDA.ordinal
        panda695.fileName = "panda_group_panda695"
        panda695.code = 2607
        panda695.duration = 317
        panda695.period = PeriodType.GROUP.ordinal
        panda695.star = false
        panda695.title = "07.19久违的钓猫！🏆幼年一班，🌸花花参与感——ZERO！😂"
        panda695.releaseTime = 1658245982
        panda695.originalUrl = "https://www.bilibili.com/video/BV1yT411J7io"
        panda695.tags = "大熊猫,萌宠,动物圈"
        panda695.authorId = 16468440
        panda695.cover =
            "https://i0.hdslb.com/bfs/archive/fb381f425bdb26fabd8a16d54452232aec5049d1.jpg"
        list.add(panda695)

        val panda696 = PetVideo()
        panda696.type = VideoType.PANDA.ordinal
        panda696.fileName = "panda_group_panda696"
        panda696.code = 2608
        panda696.duration = 64
        panda696.period = PeriodType.GROUP.ordinal
        panda696.star = false
        panda696.title = "【大熊猫和花】爷爷给的小苹果真好吃"
        panda696.releaseTime = 1650880117
        panda696.originalUrl = "https://www.bilibili.com/video/BV1WA4y1X7w3"
        panda696.tags = "大熊猫,萌宠,动物圈"
        panda696.authorId = 384395600
        panda696.cover =
            "https://i0.hdslb.com/bfs/archive/0b98e90024296215d2016c1a859799131de89c45.jpg"
        list.add(panda696)

        val panda697 = PetVideo()
        panda697.type = VideoType.PANDA.ordinal
        panda697.fileName = "panda_group_panda697"
        panda697.code = 2609
        panda697.duration = 73
        panda697.period = PeriodType.GROUP.ordinal
        panda697.star = false
        panda697.title = "第一次看你钓猫，站的好棒啦【大熊猫和花】"
        panda697.releaseTime = 1649160458
        panda697.originalUrl = "https://www.bilibili.com/video/BV1yL4y1j7cc"
        panda697.tags = "大熊猫,萌宠,动物圈"
        panda697.authorId = 2062416280
        panda697.cover =
            "https://i1.hdslb.com/bfs/archive/59457455999367730e11c210aa2fc71484cb5dfa.jpg"
        list.add(panda697)

        val panda698 = PetVideo()
        panda698.type = VideoType.PANDA.ordinal
        panda698.fileName = "panda_group_panda698"
        panda698.code = 2610
        panda698.duration = 68
        panda698.period = PeriodType.GROUP.ordinal
        panda698.star = false
        panda698.title = "【大熊猫和花】卡牙啦，磕牙的声音好大"
        panda698.releaseTime = 1658233920
        panda698.originalUrl = "https://www.bilibili.com/video/BV1Et4y1t7rS"
        panda698.tags = "大熊猫,萌宠,动物圈"
        panda698.authorId = 34677299
        panda698.cover =
            "https://i1.hdslb.com/bfs/archive/8c1a5668e6cb982f064116589aae4a27580f7365.jpg"
        list.add(panda698)

        val panda699 = PetVideo()
        panda699.type = VideoType.PANDA.ordinal
        panda699.fileName = "panda_group_panda699"
        panda699.code = 2611
        panda699.duration = 142
        panda699.period = PeriodType.GROUP.ordinal
        panda699.star = false
        panda699.title = "💪暑假特训10天后【和花VS艾玖】究竟鹿死谁手?😎"
        panda699.releaseTime = 1658185440
        panda699.originalUrl = "https://www.bilibili.com/video/BV1jU4y1i7W6"
        panda699.tags = "大熊猫,萌宠,动物圈"
        panda699.authorId = 16468440
        panda699.cover =
            "https://i0.hdslb.com/bfs/archive/c210ec0ea9fe8855f2c6b3d1949c791a021f0692.jpg"
        list.add(panda699)

        val panda700 = PetVideo()
        panda700.type = VideoType.PANDA.ordinal
        panda700.fileName = "panda_group_panda700"
        panda700.code = 2612
        panda700.duration = 46
        panda700.period = PeriodType.GROUP.ordinal
        panda700.star = false
        panda700.title = "反面教材：花花偷袭i9，火力值为0，属于无效进攻"
        panda700.releaseTime = 1658152800
        panda700.originalUrl = "https://www.bilibili.com/video/BV1jS4y1J7pb"
        panda700.tags = "大熊猫,萌宠,动物圈"
        panda700.authorId = 98871951
        panda700.cover =
            "https://i1.hdslb.com/bfs/archive/0ebe403d4884d4cf79127fbfdd0c06388d172e6d.jpg"
        list.add(panda700)

        val panda701 = PetVideo()
        panda701.type = VideoType.PANDA.ordinal
        panda701.fileName = "panda_group_panda701"
        panda701.code = 2613
        panda701.duration = 50
        panda701.period = PeriodType.GROUP.ordinal
        panda701.star = false
        panda701.title = "【大熊猫萌兰】么么儿晃着朵朵兔几跳跑来吃下午茶，开心极啦"
        panda701.releaseTime = 1506011581
        panda701.originalUrl = "https://www.bilibili.com/video/BV1sx411x7Tp"
        panda701.tags = "大熊猫,萌宠,动物圈"
        panda701.authorId = 16791067
        panda701.cover =
            "https://i0.hdslb.com/bfs/archive/ecdc5018a2146273dc22e5de2df7083e044fbe99.jpg"
        list.add(panda701)

        val panda702 = PetVideo()
        panda702.type = VideoType.PANDA.ordinal
        panda702.fileName = "panda_group_panda702"
        panda702.code = 2614
        panda702.duration = 76
        panda702.period = PeriodType.GROUP.ordinal
        panda702.star = false
        panda702.title = "耿达小猪仔们聚餐 抢笋嗯嗯叫"
        panda702.releaseTime = 1655897280
        panda702.originalUrl = "https://www.bilibili.com/video/BV15B4y1s7Nf"
        panda702.tags = "大熊猫,萌宠,动物圈"
        panda702.authorId = 442701460
        panda702.cover =
            "https://i2.hdslb.com/bfs/archive/55af6ad1a525950823157cd150120b21b562b270.jpg"
        list.add(panda702)

        val panda703 = PetVideo()
        panda703.type = VideoType.PANDA.ordinal
        panda703.fileName = "panda_group_panda703"
        panda703.code = 2615
        panda703.duration = 75
        panda703.period = PeriodType.GROUP.ordinal
        panda703.star = false
        panda703.title = "【大熊猫】重阳小可爱，吃饭非得挤到金双金喜中间，小熊友们吃饭的姿势各不同"
        panda703.releaseTime = 1657944975
        panda703.originalUrl = "https://www.bilibili.com/video/BV1af4y1o7Ue"
        panda703.tags = "大熊猫,萌宠,动物圈"
        panda703.authorId = 34677299
        panda703.cover =
            "https://i2.hdslb.com/bfs/archive/0b75f7dba5b25941c529706ac51e1525025721ca.jpg"
        list.add(panda703)

        val panda704 = PetVideo()
        panda704.type = VideoType.PANDA.ordinal
        panda704.fileName = "panda_group_panda704"
        panda704.code = 2616
        panda704.duration = 133
        panda704.period = PeriodType.GROUP.ordinal
        panda704.star = false
        panda704.title = "【大熊猫和花】钓猫--和花婉拒润玥艾玖和叶"
        panda704.releaseTime = 1657969200
        panda704.originalUrl = "https://www.bilibili.com/video/BV1nB4y1a7mB"
        panda704.tags = "大熊猫,萌宠,动物圈"
        panda704.authorId = 327377672
        panda704.cover =
            "https://i0.hdslb.com/bfs/archive/db83382bbc629411f03572ec962f47ebc36fbdab.jpg"
        list.add(panda704)

        val panda705 = PetVideo()
        panda705.type = VideoType.PANDA.ordinal
        panda705.fileName = "panda_group_panda705"
        panda705.code = 2617
        panda705.duration = 66
        panda705.period = PeriodType.GROUP.ordinal
        panda705.star = false
        panda705.title = "嘘，宝宝猪睡午觉了！这是落入凡间的天使呀！~【大熊猫和花】"
        panda705.releaseTime = 1657947822
        panda705.originalUrl = "https://www.bilibili.com/video/BV1Dr4y1E7KY"
        panda705.tags = "大熊猫,萌宠,动物圈"
        panda705.authorId = 16468440
        panda705.cover =
            "https://i0.hdslb.com/bfs/archive/8de8618f2d67b5674ad056f86523dff9d71c7321.jpg"
        list.add(panda705)

        val panda706 = PetVideo()
        panda706.type = VideoType.PANDA.ordinal
        panda706.fileName = "panda_group_panda706"
        panda706.code = 2618
        panda706.duration = 91
        panda706.period = PeriodType.GROUP.ordinal
        panda706.star = false
        panda706.title = "窝是 女明星——润玥.ERGO.菜菜.饭扫光！【大熊猫润玥】"
        panda706.releaseTime = 1657927680
        panda706.originalUrl = "https://www.bilibili.com/video/BV1dG411H76k"
        panda706.tags = "大熊猫,萌宠,动物圈"
        panda706.authorId = 16468440
        panda706.cover =
            "https://i0.hdslb.com/bfs/archive/712e6a266e2395ae5b6ea85f73f103ec1d19d000.jpg"
        list.add(panda706)

        val panda707 = PetVideo()
        panda707.type = VideoType.PANDA.ordinal
        panda707.fileName = "panda_group_panda707"
        panda707.code = 2619
        panda707.duration = 169
        panda707.period = PeriodType.GROUP.ordinal
        panda707.star = false
        panda707.title = "【大熊猫艾玖&和花】打空气、扑空气，气势拿捏住，花花多少有点搞笑基因在身上"
        panda707.releaseTime = 1657886884
        panda707.originalUrl = "https://www.bilibili.com/video/BV1nN4y1T7Tx"
        panda707.tags = "大熊猫,萌宠,动物圈"
        panda707.authorId = 34677299
        panda707.cover =
            "https://i1.hdslb.com/bfs/archive/0a8ab8fcdb067957a802ef350fcbf9f5bd6dfef9.jpg"
        list.add(panda707)

        val panda708 = PetVideo()
        panda708.type = VideoType.PANDA.ordinal
        panda708.fileName = "panda_group_panda708"
        panda708.code = 2620
        panda708.duration = 388
        panda708.period = PeriodType.GROUP.ordinal
        panda708.star = false
        panda708.title = "最近的一次钓猫！小叶子拼命护住了自己的苹果，优秀！花花又是姗姗来迟。下次钓猫是好久呢?【大熊猫和叶润玥艾玖和花】"
        panda708.releaseTime = 1657858882
        panda708.originalUrl = "https://www.bilibili.com/video/BV1z34y1H7y3"
        panda708.tags = "大熊猫,萌宠,动物圈"
        panda708.authorId = 16468440
        panda708.cover =
            "https://i2.hdslb.com/bfs/archive/d6ea72c10e590b1495a90b93381211cf95029084.jpg"
        list.add(panda708)

        val panda709 = PetVideo()
        panda709.type = VideoType.PANDA.ordinal
        panda709.fileName = "panda_group_panda709"
        panda709.code = 2621
        panda709.duration = 96
        panda709.period = PeriodType.GROUP.ordinal
        panda709.star = false
        panda709.title = "好好一个帅哥，却致力于把自己种成一棵盆栽！【大熊猫和叶】"
        panda709.releaseTime = 1657841880
        panda709.originalUrl = "https://www.bilibili.com/video/BV1Wa411H7tW"
        panda709.tags = "大熊猫,萌宠,动物圈"
        panda709.authorId = 16468440
        panda709.cover =
            "https://i2.hdslb.com/bfs/archive/b9062adad965032d4d5ce6cfdef44d72c6c6fdc2.jpg"
        list.add(panda709)

        val panda710 = PetVideo()
        panda710.type = VideoType.PANDA.ordinal
        panda710.fileName = "panda_group_panda710"
        panda710.code = 2622
        panda710.duration = 109
        panda710.period = PeriodType.GROUP.ordinal
        panda710.star = false
        panda710.title = "【大熊猫和花】和花下木架，太可爱了"
        panda710.releaseTime = 1657800300
        panda710.originalUrl = "https://www.bilibili.com/video/BV1bT411J72A"
        panda710.tags = "大熊猫,萌宠,动物圈"
        panda710.authorId = 327377672
        panda710.cover =
            "https://i2.hdslb.com/bfs/archive/d5f6e0a9e46c6829d189eaeb135ff279e6f439c0.jpg"
        list.add(panda710)

        val panda711 = PetVideo()
        panda711.type = VideoType.PANDA.ordinal
        panda711.fileName = "panda_group_panda711"
        panda711.code = 2623
        panda711.duration = 95
        panda711.period = PeriodType.GROUP.ordinal
        panda711.star = false
        panda711.title = "【大熊猫润玥&艾玖】大姐大之间的战争，二狗和玖玖，谁更厉害点？"
        panda711.releaseTime = 1657717575
        panda711.originalUrl = "https://www.bilibili.com/video/BV1VB4y1v7rw"
        panda711.tags = "大熊猫,萌宠,动物圈"
        panda711.authorId = 34677299
        panda711.cover =
            "https://i2.hdslb.com/bfs/archive/71ef1b76933fff6df94722b78a98d4fdf6257e03.jpg"
        list.add(panda711)

        val panda712 = PetVideo()
        panda712.type = VideoType.PANDA.ordinal
        panda712.fileName = "panda_group_panda712"
        panda712.code = 2624
        panda712.duration = 12
        panda712.period = PeriodType.GROUP.ordinal
        panda712.star = false
        panda712.title = "下熊猫雨了"
        panda712.releaseTime = 1657768609
        panda712.originalUrl = "https://www.bilibili.com/video/BV1nW4y1m75Y"
        panda712.tags = "大熊猫,萌宠,动物圈"
        panda712.authorId = 1025949925
        panda712.cover =
            "https://i0.hdslb.com/bfs/archive/4c323ea9ce91dd2601816aaed6da2bd84d82f7bb.jpg"
        list.add(panda712)

        val panda713 = PetVideo()
        panda713.type = VideoType.PANDA.ordinal
        panda713.fileName = "panda_group_panda713"
        panda713.code = 2625
        panda713.duration = 31
        panda713.period = PeriodType.GROUP.ordinal
        panda713.star = false
        panda713.title = "大熊猫和花-优雅，实在是太优雅了"
        panda713.releaseTime = 1657790321
        panda713.originalUrl = "https://www.bilibili.com/video/BV1xU4y1B7oj"
        panda713.tags = "大熊猫,萌宠,动物圈"
        panda713.authorId = 1307515
        panda713.cover =
            "https://i2.hdslb.com/bfs/archive/14f06c7d758297e394f4ddcd70dd2f0d8d936834.jpg"
        list.add(panda713)

        val panda714 = PetVideo()
        panda714.type = VideoType.PANDA.ordinal
        panda714.fileName = "panda_group_panda714"
        panda714.code = 2626
        panda714.duration = 95
        panda714.period = PeriodType.GROUP.ordinal
        panda714.star = false
        panda714.title = "幼年1班四嘟嘟上班啦啦啦……！~（假装是今天(=_=)）【大熊猫和花和叶润玥艾玖】"
        panda714.releaseTime = 1657755480
        panda714.originalUrl = "https://www.bilibili.com/video/BV1K94y1Q7Bf"
        panda714.tags = "大熊猫,萌宠,动物圈"
        panda714.authorId = 16468440
        panda714.cover =
            "https://i1.hdslb.com/bfs/archive/8f97175ca4a1b83849eceb4e4e1e2309b9cfbabc.jpg"
        list.add(panda714)

        val panda715 = PetVideo()
        panda715.type = VideoType.PANDA.ordinal
        panda715.fileName = "panda_group_panda715"
        panda715.code = 2627
        panda715.duration = 44
        panda715.period = PeriodType.GROUP.ordinal
        panda715.star = false
        panda715.title = "宠姐狂魔成和叶，你很帅很暖~大熊猫和花和叶"
        panda715.releaseTime = 1657634400
        panda715.originalUrl = "https://www.bilibili.com/video/BV1At4y1h7Ti"
        panda715.tags = "大熊猫,萌宠,动物圈"
        panda715.authorId = 98871951
        panda715.cover =
            "https://i0.hdslb.com/bfs/archive/f24e16342ad49a77950d1606df8c08f8176183a9.jpg"
        list.add(panda715)

        val panda716 = PetVideo()
        panda716.type = VideoType.PANDA.ordinal
        panda716.fileName = "panda_group_panda716"
        panda716.code = 2628
        panda716.duration = 125
        panda716.period = PeriodType.GROUP.ordinal
        panda716.star = false
        panda716.title = "【大熊猫和花&和叶】润玥挠花花痒痒，花花弱小无助，和叶弟弟成功救驾！"
        panda716.releaseTime = 1657635324
        panda716.originalUrl = "https://www.bilibili.com/video/BV1iV4y1n7pb"
        panda716.tags = "大熊猫,萌宠,动物圈"
        panda716.authorId = 542836361
        panda716.cover =
            "https://i1.hdslb.com/bfs/archive/acb915272447ce80b98acc44a79488525d79d315.jpg"
        list.add(panda716)

        val panda717 = PetVideo()
        panda717.type = VideoType.PANDA.ordinal
        panda717.fileName = "panda_group_panda717"
        panda717.code = 2629
        panda717.duration = 79
        panda717.period = PeriodType.GROUP.ordinal
        panda717.star = false
        panda717.title = "蛄蛹蛄蛹就把寄几甜翻了。【大熊猫和花】"
        panda717.releaseTime = 1657632555
        panda717.originalUrl = "https://www.bilibili.com/video/BV18T411g723"
        panda717.tags = "大熊猫,萌宠,动物圈"
        panda717.authorId = 514531996
        panda717.cover =
            "https://i2.hdslb.com/bfs/archive/1e80677413889bf16c080b06f23692fc33cfb0d6.jpg"
        list.add(panda717)

        val panda718 = PetVideo()
        panda718.type = VideoType.PANDA.ordinal
        panda718.fileName = "panda_group_panda718"
        panda718.code = 2630
        panda718.duration = 132
        panda718.period = PeriodType.GROUP.ordinal
        panda718.star = false
        panda718.title = "【大熊猫和花】谭爷爷喂药药，花花扒着碗意犹未尽"
        panda718.releaseTime = 1657621080
        panda718.originalUrl = "https://www.bilibili.com/video/BV1tZ4y1Y7NS"
        panda718.tags = "大熊猫,萌宠,动物圈"
        panda718.authorId = 34677299
        panda718.cover =
            "https://i2.hdslb.com/bfs/archive/9c11ab0492a2801bbe8e68efca5407dececf4363.jpg"
        list.add(panda718)

        val panda719 = PetVideo()
        panda719.type = VideoType.PANDA.ordinal
        panda719.fileName = "panda_group_panda719"
        panda719.code = 2631
        panda719.duration = 118
        panda719.period = PeriodType.GROUP.ordinal
        panda719.star = false
        panda719.title = "花叶两岁的蛋糕很美味，花花眼巴巴看着弟弟吃蛋糕，弟弟被蛋糕冰到舌头也不舍得分给姐姐"
        panda719.releaseTime = 1657516326
        panda719.originalUrl = "https://www.bilibili.com/video/BV1TY4y177iV"
        panda719.tags = "大熊猫,萌宠,动物圈"
        panda719.authorId = 384395600
        panda719.cover =
            "https://i1.hdslb.com/bfs/archive/0e8bfd17eb685e05d32e8199fc6b05cb5f85b72d.jpg"
        list.add(panda719)

        val panda720 = PetVideo()
        panda720.type = VideoType.PANDA.ordinal
        panda720.fileName = "panda_group_panda720"
        panda720.code = 2632
        panda720.duration = 101
        panda720.period = PeriodType.GROUP.ordinal
        panda720.star = false
        panda720.title = "宝宝猪睡醒了，懵了一分钟~~咋这么多人呀，快咬点小树枝压压惊~！【大熊猫和花】"
        panda720.releaseTime = 1657603680
        panda720.originalUrl = "https://www.bilibili.com/video/BV1st4y147KC"
        panda720.tags = "大熊猫,萌宠,动物圈"
        panda720.authorId = 16468440
        panda720.cover =
            "https://i1.hdslb.com/bfs/archive/4e5500fbe18a2af476e358b2f6da96182c4274ab.jpg"
        list.add(panda720)

        val panda721 = PetVideo()
        panda721.type = VideoType.PANDA.ordinal
        panda721.fileName = "panda_group_panda721"
        panda721.code = 2633
        panda721.duration = 131
        panda721.period = PeriodType.GROUP.ordinal
        panda721.star = false
        panda721.title = "熊孩子给妈妈做马杀鸡 家美很无奈"
        panda721.releaseTime = 1657538471
        panda721.originalUrl = "https://www.bilibili.com/video/BV1AS4y1J7bT"
        panda721.tags = "大熊猫,萌宠,动物圈"
        panda721.authorId = 442701460
        panda721.cover =
            "https://i1.hdslb.com/bfs/archive/d414ef0a7e7032c4117b19ee0a3484ae80235b16.jpg"
        list.add(panda721)

        val panda722 = PetVideo()
        panda722.type = VideoType.PANDA.ordinal
        panda722.fileName = "panda_group_panda722"
        panda722.code = 2634
        panda722.duration = 56
        panda722.period = PeriodType.GROUP.ordinal
        panda722.star = false
        panda722.title = "和叶先生的美妙时光～"
        panda722.releaseTime = 1657407600
        panda722.originalUrl = "https://www.bilibili.com/video/BV1jg411f7u9"
        panda722.tags = "大熊猫,萌宠,动物圈"
        panda722.authorId = 484440897
        panda722.cover =
            "https://i0.hdslb.com/bfs/archive/e5f4413be799c18a446a99c941f4afe8034ae45b.jpg"
        list.add(panda722)

        val panda723 = PetVideo()
        panda723.type = VideoType.PANDA.ordinal
        panda723.fileName = "panda_group_panda723"
        panda723.code = 2635
        panda723.duration = 101
        panda723.period = PeriodType.GROUP.ordinal
        panda723.star = false
        panda723.title = "【大熊猫和花】润玥小鸟依偎着艾玖 和花加入"
        panda723.releaseTime = 1657539000
        panda723.originalUrl = "https://www.bilibili.com/video/BV1mG411H77F"
        panda723.tags = "大熊猫,萌宠,动物圈"
        panda723.authorId = 327377672
        panda723.cover =
            "https://i0.hdslb.com/bfs/archive/d645bc879c599030fdf8e0aed80d026a43de6efa.jpg"
        list.add(panda723)

        val panda724 = PetVideo()
        panda724.type = VideoType.PANDA.ordinal
        panda724.fileName = "panda_group_panda724"
        panda724.code = 2636
        panda724.duration = 171
        panda724.period = PeriodType.GROUP.ordinal
        panda724.star = false
        panda724.title = "期待幼年一班F4齐聚一堂，努力干饭！【大熊猫和花和叶润玥艾玖】"
        panda724.releaseTime = 1657515321
        panda724.originalUrl = "https://www.bilibili.com/video/BV1qU4y1q799"
        panda724.tags = "大熊猫,萌宠,动物圈"
        panda724.authorId = 16468440
        panda724.cover =
            "https://i1.hdslb.com/bfs/archive/20a9b14a3a82378ed511809925165f1cd9ce4165.jpg"
        list.add(panda724)

        val panda725 = PetVideo()
        panda725.type = VideoType.PANDA.ordinal
        panda725.fileName = "panda_group_panda725"
        panda725.code = 2637
        panda725.duration = 194
        panda725.period = PeriodType.GROUP.ordinal
        panda725.star = false
        panda725.title = "花瘾犯了，那就来看花花的沉浸式吃播吧"
        panda725.releaseTime = 1657446824
        panda725.originalUrl = "https://www.bilibili.com/video/BV1Jr4y1E7Eg"
        panda725.tags = "大熊猫,萌宠,动物圈"
        panda725.authorId = 384395600
        panda725.cover =
            "https://i1.hdslb.com/bfs/archive/0a0073e9358fd936f26f9855cf9758715a6b7319.jpg"
        list.add(panda725)

        val panda726 = PetVideo()
        panda726.type = VideoType.PANDA.ordinal
        panda726.fileName = "panda_group_panda726"
        panda726.code = 2638
        panda726.duration = 75
        panda726.period = PeriodType.GROUP.ordinal
        panda726.star = false
        panda726.title = "〖大熊猫和叶〗〖大熊猫润玥〗弟弟是个帅气的小绅士 菜菜觉得别人手里的是最香的"
        panda726.releaseTime = 1657460106
        panda726.originalUrl = "https://www.bilibili.com/video/BV1iV4y1n7fk"
        panda726.tags = "大熊猫,萌宠,动物圈"
        panda726.authorId = 690050620
        panda726.cover =
            "https://i2.hdslb.com/bfs/archive/88ad8a043050bb7a2bdf4a30736eede231d4cb18.jpg"
        list.add(panda726)

        val panda727 = PetVideo()
        panda727.type = VideoType.PANDA.ordinal
        panda727.fileName = "panda_group_panda727"
        panda727.code = 2639
        panda727.duration = 41
        panda727.period = PeriodType.GROUP.ordinal
        panda727.star = false
        panda727.title = "大熊猫和花和叶-迪迪，听话，蛋糕给姐姐吃一口"
        panda727.releaseTime = 1657443782
        panda727.originalUrl = "https://www.bilibili.com/video/BV1kZ4y1Y7sU"
        panda727.tags = "大熊猫,萌宠,动物圈"
        panda727.authorId = 1307515
        panda727.cover =
            "https://i0.hdslb.com/bfs/archive/e046c75604ce2d921a67d5683143fae5b1c103e1.jpg"
        list.add(panda727)

        val panda728 = PetVideo()
        panda728.type = VideoType.PANDA.ordinal
        panda728.fileName = "panda_group_panda728"
        panda728.code = 2640
        panda728.duration = 103
        panda728.period = PeriodType.GROUP.ordinal
        panda728.star = false
        panda728.title = "熊菜瘾大的霸王花三度碰瓷大姐大艾玖"
        panda728.releaseTime = 1657445300
        panda728.originalUrl = "https://www.bilibili.com/video/BV17t4y147KF"
        panda728.tags = "大熊猫,萌宠,动物圈"
        panda728.authorId = 384395600
        panda728.cover =
            "https://i2.hdslb.com/bfs/archive/e95c32e6a78660e12192289230eecc132e85b34d.jpg"
        list.add(panda728)

        val panda729 = PetVideo()
        panda729.type = VideoType.PANDA.ordinal
        panda729.fileName = "panda_group_panda729"
        panda729.code = 2641
        panda729.duration = 114
        panda729.period = PeriodType.GROUP.ordinal
        panda729.star = false
        panda729.title = "三伏天咯，熊猫学院也放暑假咯～只能靠库存过日子了！润玥你的眼睛在看哪？花叶被抢委屈巴巴，底层熊的姐弟俩"
        panda729.releaseTime = 1657279377
        panda729.originalUrl = "https://www.bilibili.com/video/BV1qB4y1H7eY"
        panda729.tags = "大熊猫,萌宠,动物圈"
        panda729.authorId = 484440897
        panda729.cover =
            "https://i2.hdslb.com/bfs/archive/83fd826e5f9165f0fbf1524a6c2b428556fb20aa.jpg"
        list.add(panda729)

        val panda730 = PetVideo()
        panda730.type = VideoType.PANDA.ordinal
        panda730.fileName = "panda_group_panda730"
        panda730.code = 2642
        panda730.duration = 229
        panda730.period = PeriodType.GROUP.ordinal
        panda730.star = false
        panda730.title = "花花倾情演绎《普通disico》，快来打Call~呀！【大熊猫和花】"
        panda730.releaseTime = 1657407840
        panda730.originalUrl = "https://www.bilibili.com/video/BV1XS4y1n72X"
        panda730.tags = "大熊猫,萌宠,动物圈"
        panda730.authorId = 16468440
        panda730.cover =
            "https://i2.hdslb.com/bfs/archive/64927fa0365cc930a756f686c38edd97db5dc55f.jpg"
        list.add(panda730)

        val panda731 = PetVideo()
        panda731.type = VideoType.PANDA.ordinal
        panda731.fileName = "panda_group_panda731"
        panda731.code = 2643
        panda731.duration = 150
        panda731.period = PeriodType.GROUP.ordinal
        panda731.star = false
        panda731.title = "这可能是目前谭爷爷职业生涯中最难的一次收猫"
        panda731.releaseTime = 1657336926
        panda731.originalUrl = "https://www.bilibili.com/video/BV1jf4y1d7KE"
        panda731.tags = "大熊猫,萌宠,动物圈"
        panda731.authorId = 1025949925
        panda731.cover =
            "https://i0.hdslb.com/bfs/archive/9e1f042106e67a7ef525d6f4e4b22203187d2840.jpg"
        list.add(panda731)

        val panda732 = PetVideo()
        panda732.type = VideoType.PANDA.ordinal
        panda732.fileName = "panda_group_panda732"
        panda732.code = 2644
        panda732.duration = 237
        panda732.period = PeriodType.GROUP.ordinal
        panda732.star = false
        panda732.title = "【莽星星莽辰辰】孩子成精了！会自己拿水管洗澡了！"
        panda732.releaseTime = 1657354073
        panda732.originalUrl = "https://www.bilibili.com/video/BV1Y94y1X7j2"
        panda732.tags = "大熊猫,萌宠,动物圈"
        panda732.authorId = 180602305
        panda732.cover =
            "https://i1.hdslb.com/bfs/archive/cafb68ef8268e1cf05d5721e82439e868e97b363.jpg"
        list.add(panda732)

        val panda733 = PetVideo()
        panda733.type = VideoType.PANDA.ordinal
        panda733.fileName = "panda_group_panda733"
        panda733.code = 2645
        panda733.duration = 159
        panda733.period = PeriodType.GROUP.ordinal
        panda733.star = false
        panda733.title = "看着花花的挖煤成果，审核都沉默了【大熊猫和花】"
        panda733.releaseTime = 1657330022
        panda733.originalUrl = "https://www.bilibili.com/video/BV1FU4y1D7Cy"
        panda733.tags = "大熊猫,萌宠,动物圈"
        panda733.authorId = 230382720
        panda733.cover =
            "https://i2.hdslb.com/bfs/archive/f93b6889e0babdb69b96698ebc0d7983272a82c8.jpg"
        list.add(panda733)

        val panda734 = PetVideo()
        panda734.type = VideoType.PANDA.ordinal
        panda734.fileName = "panda_group_panda734"
        panda734.code = 2646
        panda734.duration = 159
        panda734.period = PeriodType.GROUP.ordinal
        panda734.star = false
        panda734.title = "都来水上乐园玩了，要不咱就把工作服脱了吧！"
        panda734.releaseTime = 1657278000
        panda734.originalUrl = "https://www.bilibili.com/video/BV1Ca411p7Nc"
        panda734.tags = "大熊猫,萌宠,动物圈"
        panda734.authorId = 1998535
        panda734.cover =
            "https://i1.hdslb.com/bfs/archive/7cd49aa3afb24a556d9a2d8e9cec20b7314bdfee.jpg"
        list.add(panda734)

        val panda735 = PetVideo()
        panda735.type = VideoType.PANDA.ordinal
        panda735.fileName = "panda_group_panda735"
        panda735.code = 2647
        panda735.duration = 53
        panda735.period = PeriodType.GROUP.ordinal
        panda735.star = false
        panda735.title = "和瓜：这个冰蛋糕有点上头（那你还抱着不松手？）。。【大熊猫和叶、和花】"
        panda735.releaseTime = 1656943174
        panda735.originalUrl = "https://www.bilibili.com/video/BV1aa411H7A9"
        panda735.tags = "大熊猫,萌宠,动物圈"
        panda735.authorId = 514531996
        panda735.cover =
            "https://i2.hdslb.com/bfs/archive/8775c6a577d52aff6af28465e8e73cd38459a708.jpg"
        list.add(panda735)

        val panda736 = PetVideo()
        panda736.type = VideoType.PANDA.ordinal
        panda736.fileName = "panda_group_panda736"
        panda736.code = 2648
        panda736.duration = 94
        panda736.period = PeriodType.GROUP.ordinal
        panda736.star = false
        panda736.title = "国宝的一天，它们都在干嘛？"
        panda736.releaseTime = 1657249874
        panda736.originalUrl = "https://www.bilibili.com/video/BV1GZ4y1Y7T1"
        panda736.tags = "大熊猫,萌宠,动物圈"
        panda736.authorId = 1025949925
        panda736.cover =
            "https://i0.hdslb.com/bfs/archive/78cf9898943849224ee28ea3328e57b2760a9659.jpg"
        list.add(panda736)

        val panda737 = PetVideo()
        panda737.type = VideoType.PANDA.ordinal
        panda737.fileName = "panda_group_panda737"
        panda737.code = 2649
        panda737.duration = 58
        panda737.period = PeriodType.GROUP.ordinal
        panda737.star = false
        panda737.title = "孩子听懂了。~四川话十级，沟通无障碍。。【大熊猫重阳】"
        panda737.releaseTime = 1655817260
        panda737.originalUrl = "https://www.bilibili.com/video/BV1zS4y1v7wu"
        panda737.tags = "大熊猫,萌宠,动物圈"
        panda737.authorId = 514531996
        panda737.cover =
            "https://i2.hdslb.com/bfs/archive/831625b4a02390c5c709977bd29d2b3bb09e8ca1.jpg"
        list.add(panda737)

        val panda738 = PetVideo()
        panda738.type = VideoType.PANDA.ordinal
        panda738.fileName = "panda_group_panda738"
        panda738.code = 2650
        panda738.duration = 96
        panda738.period = PeriodType.GROUP.ordinal
        panda738.star = false
        panda738.title = "花花找迪迪贴贴睡觉觉，两个小宝贝好治愈"
        panda738.releaseTime = 1657195756
        panda738.originalUrl = "https://www.bilibili.com/video/BV1dY4y1E7eY"
        panda738.tags = "大熊猫,萌宠,动物圈"
        panda738.authorId = 443245052
        panda738.cover =
            "https://i2.hdslb.com/bfs/archive/3d2ea474fc69e60ec1d3f63c3b5d24224a742622.jpg"
        list.add(panda738)

        val panda739 = PetVideo()
        panda739.type = VideoType.PANDA.ordinal
        panda739.fileName = "panda_group_panda739"
        panda739.code = 2651
        panda739.duration = 152
        panda739.period = PeriodType.GROUP.ordinal
        panda739.star = false
        panda739.title = "【大熊猫和花&和叶】给迪迪安排了一套“马杀鸡”，把自己累倒了"
        panda739.releaseTime = 1657254298
        panda739.originalUrl = "https://www.bilibili.com/video/BV17f4y1d7JY"
        panda739.tags = "大熊猫,萌宠,动物圈"
        panda739.authorId = 34677299
        panda739.cover =
            "https://i0.hdslb.com/bfs/archive/beec8c93fbed5def8bc77ff3b5348f71bad7d51f.jpg"
        list.add(panda739)

        val panda740 = PetVideo()
        panda740.type = VideoType.PANDA.ordinal
        panda740.fileName = "panda_group_panda740"
        panda740.code = 2652
        panda740.duration = 103
        panda740.period = PeriodType.GROUP.ordinal
        panda740.star = false
        panda740.title = "最近熊猫生日季，今天是香果宝哥宝妹的生日，香果追奶爸太好玩了"
        panda740.releaseTime = 1657112191
        panda740.originalUrl = "https://www.bilibili.com/video/BV1pB4y1e7FY"
        panda740.tags = "大熊猫,萌宠,动物圈"
        panda740.authorId = 1025949925
        panda740.cover =
            "https://i2.hdslb.com/bfs/archive/dbf6e7320ad413daca9b253d808c4e6f2750340e.jpg"
        list.add(panda740)

        val panda741 = PetVideo()
        panda741.type = VideoType.PANDA.ordinal
        panda741.fileName = "panda_group_panda741"
        panda741.code = 2653
        panda741.duration = 96
        panda741.period = PeriodType.GROUP.ordinal
        panda741.star = false
        panda741.title = "和爷爷玩木头人的花花，太逗了"
        panda741.releaseTime = 1657031262
        panda741.originalUrl = "https://www.bilibili.com/video/BV1TU4y1D7Kb"
        panda741.tags = "大熊猫,萌宠,动物圈"
        panda741.authorId = 12522531
        panda741.cover =
            "https://i0.hdslb.com/bfs/archive/e99ab2846fb059e647ccb8c0bd182ea2962ef6da.jpg"
        list.add(panda741)

        val panda742 = PetVideo()
        panda742.type = VideoType.PANDA.ordinal
        panda742.fileName = "panda_group_panda742"
        panda742.code = 2654
        panda742.duration = 84
        panda742.period = PeriodType.GROUP.ordinal
        panda742.star = false
        panda742.title = "被冰蛋糕被冰到舌头是怎样的体验？"
        panda742.releaseTime = 1657167048
        panda742.originalUrl = "https://www.bilibili.com/video/BV13S4y1H7xz"
        panda742.tags = "大熊猫,萌宠,动物圈"
        panda742.authorId = 384395600
        panda742.cover =
            "https://i2.hdslb.com/bfs/archive/3a29ad10f156e773f6ee7cfbf19ae0de61fb87d5.jpg"
        list.add(panda742)

        val panda743 = PetVideo()
        panda743.type = VideoType.PANDA.ordinal
        panda743.fileName = "panda_group_panda743"
        panda743.code = 2655
        panda743.duration = 357
        panda743.period = PeriodType.GROUP.ordinal
        panda743.star = false
        panda743.title = "谭爷爷来钓猫加餐啦~花叶姐弟独享苹果餐 (｢･ω･)｢嘿 【大熊猫和花 和叶】"
        panda743.releaseTime = 1657176576
        panda743.originalUrl = "https://www.bilibili.com/video/BV1RZ4y1a7Fq"
        panda743.tags = "大熊猫,萌宠,动物圈"
        panda743.authorId = 16468440
        panda743.cover =
            "https://i1.hdslb.com/bfs/archive/02778f9358fd06869faadc479b75a29660b785f2.jpg"
        list.add(panda743)

        val panda744 = PetVideo()
        panda744.type = VideoType.PANDA.ordinal
        panda744.fileName = "panda_group_panda744"
        panda744.code = 2656
        panda744.duration = 45
        panda744.period = PeriodType.GROUP.ordinal
        panda744.star = false
        panda744.title = "【四喜丸子】莽壮壮：你们玩吧！窝脑阔有点痛，先休息一下"
        panda744.releaseTime = 1635330597
        panda744.originalUrl = "https://www.bilibili.com/video/BV1rQ4y1q7Rz"
        panda744.tags = "大熊猫,萌宠,动物圈"
        panda744.authorId = 180602305
        panda744.cover =
            "https://i0.hdslb.com/bfs/archive/bb91fe65416c62e5730c5ddd6cf92462ac039b50.jpg"
        list.add(panda744)

        val panda745 = PetVideo()
        panda745.type = VideoType.PANDA.ordinal
        panda745.fileName = "panda_group_panda745"
        panda745.code = 2657
        panda745.duration = 180
        panda745.period = PeriodType.GROUP.ordinal
        panda745.star = false
        panda745.title = "大玩偶玩小竹篓，血槽已空！这是我能看到吗?【大熊猫和花】"
        panda745.releaseTime = 1657093963
        panda745.originalUrl = "https://www.bilibili.com/video/BV1A34y1W7zg"
        panda745.tags = "大熊猫,萌宠,动物圈"
        panda745.authorId = 16468440
        panda745.cover =
            "https://i1.hdslb.com/bfs/archive/b1caa1514f5e5262f82cbba21c41d5594f20a7a0.jpg"
        list.add(panda745)

    }
}