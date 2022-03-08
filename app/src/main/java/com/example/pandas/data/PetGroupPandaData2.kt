package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetGroupPandaData2 {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {

        val panda241 = PetVideo()
        panda241.type = VideoType.PANDA.ordinal
        panda241.fileName = "panda_group_panda241"
        panda241.code = 1488
        panda241.duration = 33
        panda241.period = PeriodType.GROUP.ordinal
        panda241.isStar = true
        panda241.title = "一滩和花饼"
        panda241.releaseTime = "2022-02-19 18:43:19"
        panda241.originalUrl = "https://www.bilibili.com/video/BV1vF411E7Jo"
        panda241.tags = "大熊猫,萌宠,动物圈"
        panda241.authorName = "和和和花花"
        panda241.cover =
            "https://i0.hdslb.com/bfs/archive/c0afc1663208b8a1fd7e66f1e382cebafaa26a67.jpg"
        list.add(panda241)

        val panda242 = PetVideo()
        panda242.type = VideoType.PANDA.ordinal
        panda242.fileName = "panda_group_panda242"
        panda242.code = 1489
        panda242.duration = 39
        panda242.period = PeriodType.GROUP.ordinal
        panda242.isStar = false
        panda242.title = "和花:“爷爷对不起，让您尴尬了！”【熊猫宝宝和花，润玥】"
        panda242.releaseTime = "2022-02-26 22:49:40"
        panda242.originalUrl = "https://www.bilibili.com/video/BV1v34y1r7BN"
        panda242.tags = "大熊猫,萌宠,动物圈"
        panda242.authorName = "豆米陪伴大熊猫"
        panda242.cover =
            "https://i1.hdslb.com/bfs/archive/b2a36cafba56abbcd5d1089c5728a087b4ede8a8.png"
        list.add(panda242)

        val panda243 = PetVideo()
        panda243.type = VideoType.PANDA.ordinal
        panda243.fileName = "panda_group_panda243"
        panda243.code = 1490
        panda243.duration = 26
        panda243.period = PeriodType.GROUP.ordinal
        panda243.isStar = false
        panda243.title = "萌兽暴吼~果女王霸气吼退春生哥哥。【大熊猫香果】"
        panda243.releaseTime = "2022-03-06 18:07:10"
        panda243.originalUrl = "https://www.bilibili.com/video/BV1rY411g7im"
        panda243.tags = "大熊猫,萌宠,动物圈"
        panda243.authorName = "隽一一"
        panda243.cover =
            "https://i1.hdslb.com/bfs/archive/05ecd0d0232100184041dbdb510b5d417dcb4cd1.jpg"
        list.add(panda243)

        val panda244 = PetVideo()
        panda244.type = VideoType.PANDA.ordinal
        panda244.fileName = "panda_group_panda244"
        panda244.code = 1491
        panda244.duration = 343
        panda244.period = PeriodType.GROUP.ordinal
        panda244.isStar = true
        panda244.title = "两个可爱调皮鬼茱萸和花花互rua【大熊猫和花&庆茱萸】"
        panda244.releaseTime = "2021-11-21 20:35:38"
        panda244.originalUrl = "https://www.bilibili.com/video/BV1tQ4y1U7sK"
        panda244.tags = "大熊猫,萌宠,动物圈"
        panda244.authorName = "朙雨"
        panda244.cover =
            "https://i1.hdslb.com/bfs/archive/73269b1a0197042dcf5e23d758bfe262924d8a98.jpg"
        list.add(panda244)

        val panda245 = PetVideo()
        panda245.type = VideoType.PANDA.ordinal
        panda245.fileName = "panda_group_panda245"
        panda245.code = 1492
        panda245.duration = 169
        panda245.period = PeriodType.GROUP.ordinal
        panda245.isStar = true
        panda245.title = "【大熊猫和花】花花午休醒了下床散步"
        panda245.releaseTime = "2022-03-06 17:20:10"
        panda245.originalUrl = "https://www.bilibili.com/video/BV1Hu411Q7S8"
        panda245.tags = "大熊猫,萌宠,动物圈"
        panda245.authorName = "朙雨"
        panda245.cover =
            "https://i1.hdslb.com/bfs/archive/384c710036badd271e1372503dc7250d012bd8fa.jpg"
        list.add(panda245)

        val panda246 = PetVideo()
        panda246.type = VideoType.PANDA.ordinal
        panda246.fileName = "panda_group_panda246"
        panda246.code = 1493
        panda246.duration = 13
        panda246.period = PeriodType.GROUP.ordinal
        panda246.isStar = false
        panda246.title = "谁把花花吓出了狗叫？和叶：我！"
        panda246.releaseTime = "2022-03-06 12:20:02"
        panda246.originalUrl = "https://www.bilibili.com/video/BV1Mq4y1i7df"
        panda246.tags = "大熊猫,萌宠,动物圈"
        panda246.authorName = "开饭了大熊猫V"
        panda246.cover =
            "https://i0.hdslb.com/bfs/archive/95e95ef9283c55476a66e189971a3fcbd76431db.jpg"
        list.add(panda246)

        val panda247 = PetVideo()
        panda247.type = VideoType.PANDA.ordinal
        panda247.fileName = "panda_group_panda247"
        panda247.code = 1494
        panda247.duration = 33
        panda247.period = PeriodType.GROUP.ordinal
        panda247.isStar = true
        panda247.title = "【和花】大熊猫背影届的天花板，这背影也太犯规了"
        panda247.releaseTime = "2022-03-05 09:55:11"
        panda247.originalUrl = "https://www.bilibili.com/video/BV1yZ4y167qU"
        panda247.tags = "大熊猫,萌宠,动物圈"
        panda247.authorName = "熊猫幼崽社区"
        panda247.cover =
            "https://i2.hdslb.com/bfs/archive/4dcb5d0c3811bcf8eeb9e7868dbec874f83ee492.jpg"
        list.add(panda247)

        val panda248 = PetVideo()
        panda248.type = VideoType.PANDA.ordinal
        panda248.fileName = "panda_group_panda248"
        panda248.code = 1495
        panda248.duration = 143
        panda248.period = PeriodType.GROUP.ordinal
        panda248.isStar = true
        panda248.title = "和花真是个小戏精，但是二狗姐姐不和你一般见识"
        panda248.releaseTime = "2022-03-06 00:18:18"
        panda248.originalUrl = "https://www.bilibili.com/video/BV1Sb4y1W7Xn"
        panda248.tags = "大熊猫,萌宠,动物圈"
        panda248.authorName = "奇异果家的顺来会fly"
        panda248.cover =
            "https://i2.hdslb.com/bfs/archive/a6206a6bcbaa7246a49874ba6114db2608e18bc2.jpg"
        list.add(panda248)

        val panda249 = PetVideo()
        panda249.type = VideoType.PANDA.ordinal
        panda249.fileName = "panda_group_panda249"
        panda249.code = 1496
        panda249.duration = 80
        panda249.period = PeriodType.GROUP.ordinal
        panda249.isStar = true
        panda249.title = "爷爷不要喊了，花花在开粉丝见面会呢！你看你一喊，熊家还滑了一跤，好没面子哦！【大熊猫和花】"
        panda249.releaseTime = "2022-03-05 11:28:47"
        panda249.originalUrl = "https://www.bilibili.com/video/BV1kr4y1q7nd"
        panda249.tags = "大熊猫,萌宠,动物圈"
        panda249.authorName = "安娜丽丝k"
        panda249.cover =
            "https://i1.hdslb.com/bfs/archive/1d15197f270da9e0ae651f1e0efaa181160bfa29.jpg"
        list.add(panda249)

        val panda250 = PetVideo()
        panda250.type = VideoType.PANDA.ordinal
        panda250.fileName = "panda_group_panda250"
        panda250.code = 1497
        panda250.duration = 117
        panda250.period = PeriodType.GROUP.ordinal
        panda250.isStar = true
        panda250.title = "超级大头的大熊猫，头比饲养员的身子还大，好可爱啊【雪宝】"
        panda250.releaseTime = "2022-03-04 16:19:12"
        panda250.originalUrl = "https://www.bilibili.com/video/BV1JL4y137KV"
        panda250.tags = "大熊猫,萌宠,动物圈"
        panda250.authorName = "睡-不醒--"
        panda250.cover =
            "https://i2.hdslb.com/bfs/archive/d900dd2b6842f7408da3bd474d70d44395d551b3.jpg"
        list.add(panda250)

        val panda251 = PetVideo()
        panda251.type = VideoType.PANDA.ordinal
        panda251.fileName = "panda_group_panda251"
        panda251.code = 1498
        panda251.duration = 63
        panda251.period = PeriodType.GROUP.ordinal
        panda251.isStar = false
        panda251.title = "和花被二狗压成饼干又被弟弟和叶啃脚最后可怜兮兮的跪在小卖部门口"
        panda251.releaseTime = "2022-03-04 22:59:08"
        panda251.originalUrl = "https://www.bilibili.com/video/BV1KL411N7G2"
        panda251.tags = "大熊猫,萌宠,动物圈"
        panda251.authorName = "奇异果家的顺来会fly"
        panda251.cover =
            "https://i0.hdslb.com/bfs/archive/d0ed7a1c066ee0af2c0ff8e24ed1af3372108bcf.jpg"
        list.add(panda251)

        val panda252 = PetVideo()
        panda252.type = VideoType.PANDA.ordinal
        panda252.fileName = "panda_group_panda252"
        panda252.code = 1499
        panda252.duration = 148
        panda252.period = PeriodType.GROUP.ordinal
        panda252.isStar = false
        panda252.title = "绩笑成风再次上木架大战，二楼睡觉的浪花躺着也中枪"
        panda252.releaseTime = "2022-03-03 18:00:13"
        panda252.originalUrl = "https://www.bilibili.com/video/BV1eL411N73s"
        panda252.tags = "大熊猫,萌宠,动物圈"
        panda252.authorName = "雨19005"
        panda252.cover =
            "https://i0.hdslb.com/bfs/archive/78b63768f2ac413972b49177f68b9667c4063633.jpg"
        list.add(panda252)

        val panda253 = PetVideo()
        panda253.type = VideoType.PANDA.ordinal
        panda253.fileName = "panda_group_panda253"
        panda253.code = 1500
        panda253.duration = 108
        panda253.period = PeriodType.GROUP.ordinal
        panda253.isStar = false
        panda253.title = "和叶：菜总，都说了这个盆儿只装得下一只熊，你非不信！【大熊猫和叶.润玥】"
        panda253.releaseTime = "2022-03-04 10:41:41"
        panda253.originalUrl = "https://www.bilibili.com/video/BV1nR4y1G7td"
        panda253.tags = "大熊猫,萌宠,动物圈"
        panda253.authorName = "安娜丽丝k"
        panda253.cover =
            "https://i0.hdslb.com/bfs/archive/72e149cc854b8a81f94cdf24f405cbf498c7c45e.jpg"
        list.add(panda253)

        val panda254 = PetVideo()
        panda254.type = VideoType.PANDA.ordinal
        panda254.fileName = "panda_group_panda254"
        panda254.code = 1501
        panda254.duration = 97
        panda254.period = PeriodType.GROUP.ordinal
        panda254.isStar = false
        panda254.title = "和花  润玥  和叶"
        panda254.releaseTime = "2022-02-23 23:52:50"
        panda254.originalUrl = "https://www.bilibili.com/video/BV1AS4y1c7i5"
        panda254.tags = "大熊猫,萌宠,动物圈"
        panda254.authorName = "多元化之无尽的梦魇"
        panda254.cover =
            "https://i0.hdslb.com/bfs/archive/80048f93e2797908fa8bb6c3990dada86de7caa2.png"
        list.add(panda254)

        val panda255 = PetVideo()
        panda255.type = VideoType.PANDA.ordinal
        panda255.fileName = "panda_group_panda255"
        panda255.code = 1502
        panda255.duration = 143
        panda255.period = PeriodType.GROUP.ordinal
        panda255.isStar = true
        panda255.title = "【大熊猫和花 和叶 润玥】菜菜：妹妹弟弟太爱我了该怎么办？"
        panda255.releaseTime = "2022-02-10 11:07:41"
        panda255.originalUrl = "https://www.bilibili.com/video/BV1rS4y1G7cH"
        panda255.tags = "大熊猫,萌宠,动物圈"
        panda255.authorName = "瑞壑"
        panda255.cover =
            "https://i1.hdslb.com/bfs/archive/80112d206ecef863e19038341597decd08ede57b.jpg"
        list.add(panda255)

        val panda256 = PetVideo()
        panda256.type = VideoType.PANDA.ordinal
        panda256.fileName = "panda_group_panda256"
        panda256.code = 1503
        panda256.duration = 64
        panda256.period = PeriodType.GROUP.ordinal
        panda256.isStar = true
        panda256.title = "[和花]卖力营业的花花"
        panda256.releaseTime = "2022-02-16 00:08:50"
        panda256.originalUrl = "https://www.bilibili.com/video/BV1KL4y1G7tZ"
        panda256.tags = "大熊猫,萌宠,动物圈"
        panda256.authorName = "多元化之无尽的梦魇"
        panda256.cover =
            "https://i2.hdslb.com/bfs/archive/1221744c949db0ad6c8336db074c86d4e547b5d0.jpg"
        list.add(panda256)

        val panda257 = PetVideo()
        panda257.type = VideoType.PANDA.ordinal
        panda257.fileName = "panda_group_panda257"
        panda257.code = 1504
        panda257.duration = 26
        panda257.period = PeriodType.GROUP.ordinal
        panda257.isStar = false
        panda257.title = "熊猫：意外连连，面面遭遇春生的三连击..."
        panda257.releaseTime = "2022-02-04 09:00:08"
        panda257.originalUrl = "https://www.bilibili.com/video/BV1Lq4y1w7W9"
        panda257.tags = "大熊猫,萌宠,动物圈"
        panda257.authorName = "小香妞爱熊猫"
        panda257.cover =
            "https://i0.hdslb.com/bfs/archive/25b45556f0baa2fdff826505065296bc9bc5aedc.jpg"
        list.add(panda257)

        val panda258 = PetVideo()
        panda258.type = VideoType.PANDA.ordinal
        panda258.fileName = "panda_group_panda258"
        panda258.code = 1505
        panda258.duration = 114
        panda258.period = PeriodType.GROUP.ordinal
        panda258.isStar = true
        panda258.title = "滑滑小熊友，请立即停止你的卖萌行为。【大熊猫和花】"
        panda258.releaseTime = "2022-03-03 17:00:18"
        panda258.originalUrl = "https://www.bilibili.com/video/BV1Aq4y147K5"
        panda258.tags = "大熊猫,萌宠,动物圈"
        panda258.authorName = "隽一一"
        panda258.cover =
            "https://i0.hdslb.com/bfs/archive/23ed9cd3b1bfaef0fdbf5009908cdac1701b40db.jpg"
        list.add(panda258)

        val panda259 = PetVideo()
        panda259.type = VideoType.PANDA.ordinal
        panda259.fileName = "panda_group_panda259"
        panda259.code = 1506
        panda259.duration = 43
        panda259.period = PeriodType.GROUP.ordinal
        panda259.isStar = false
        panda259.title = "【大熊猫茱萸】这才是功夫熊猫"
        panda259.releaseTime = "2022-03-03 12:33:42"
        panda259.originalUrl = "https://www.bilibili.com/video/BV17T4y1S77r"
        panda259.tags = "大熊猫,萌宠,动物圈"
        panda259.authorName = "开饭了大熊猫V"
        panda259.cover =
            "https://i0.hdslb.com/bfs/archive/b540c377731ae238929de03251ef3e7d149662df.jpg"
        list.add(panda259)

        val panda260 = PetVideo()
        panda260.type = VideoType.PANDA.ordinal
        panda260.fileName = "panda_group_panda260"
        panda260.code = 1507
        panda260.duration = 130
        panda260.period = PeriodType.GROUP.ordinal
        panda260.isStar = true
        panda260.title = "【大熊猫和花&艾玖】拍糊了也挡不住花花的可爱"
        panda260.releaseTime = "2022-02-23 22:05:09"
        panda260.originalUrl = "https://www.bilibili.com/video/BV1AT4y1Q7P5"
        panda260.tags = "大熊猫,萌宠,动物圈"
        panda260.authorName = "朙雨"
        panda260.cover =
            "https://i0.hdslb.com/bfs/archive/cfcb70d96e806291ae5e29acb578425dca683ebd.jpg"
        list.add(panda260)

        val panda261 = PetVideo()
        panda261.type = VideoType.PANDA.ordinal
        panda261.fileName = "panda_group_panda261"
        panda261.code = 1508
        panda261.duration = 73
        panda261.period = PeriodType.GROUP.ordinal
        panda261.isStar = false
        panda261.title = "【热干面春生】大熊猫的脾气有多好，喜欢的竹子被抢也不会生气"
        panda261.releaseTime = "2022-02-20 13:53:57"
        panda261.originalUrl = "https://www.bilibili.com/video/BV1YR4y1V7vE"
        panda261.tags = "大熊猫,萌宠,动物圈"
        panda261.authorName = "胖哒哒不月半"
        panda261.cover =
            "https://i1.hdslb.com/bfs/archive/f5643aec2478855379b174f656bac34d2fa6948d.jpg"
        list.add(panda261)

        val panda262 = PetVideo()
        panda262.type = VideoType.PANDA.ordinal
        panda262.fileName = "panda_group_panda262"
        panda262.code = 1509
        panda262.duration = 103
        panda262.period = PeriodType.GROUP.ordinal
        panda262.isStar = false
        panda262.title = "【和花润玥】大长腿和小短腿的同款抠痒痒，好像没有什么区别"
        panda262.releaseTime = "2022-02-24 23:02:30"
        panda262.originalUrl = "https://www.bilibili.com/video/BV1o3411L7XL"
        panda262.tags = "大熊猫,萌宠,动物圈"
        panda262.authorName = "胖哒哒不月半"
        panda262.cover =
            "https://i0.hdslb.com/bfs/archive/98f69e39f551c279290dfcc7067c698f30f0b78f.jpg"
        list.add(panda262)

        val panda263 = PetVideo()
        panda263.type = VideoType.PANDA.ordinal
        panda263.fileName = "panda_group_panda263"
        panda263.code = 1510
        panda263.duration = 106
        panda263.period = PeriodType.GROUP.ordinal
        panda263.isStar = false
        panda263.title = "【和花润玥艾玖和叶】面对下班不愿意回家的大熊猫，谭爷爷拿出了诱熊的大苹果"
        panda263.releaseTime = "2022-03-01 20:49:07"
        panda263.originalUrl = "https://www.bilibili.com/video/BV1e3411j79z"
        panda263.tags = "大熊猫,萌宠,动物圈"
        panda263.authorName = "胖哒哒不月半"
        panda263.cover =
            "https://i0.hdslb.com/bfs/archive/10d78ae97da07ee78912df3cd3d96b7e09b28089.jpg"
        list.add(panda263)

        val panda264 = PetVideo()
        panda264.type = VideoType.PANDA.ordinal
        panda264.fileName = "panda_group_panda264"
        panda264.code = 1511
        panda264.duration = 54
        panda264.period = PeriodType.GROUP.ordinal
        panda264.isStar = true
        panda264.title = "和花:千万不要进来看，我怕我的可爱让你忍不住想犯罪"
        panda264.releaseTime = "2022-03-02 18:58:16"
        panda264.originalUrl = "https://www.bilibili.com/video/BV1fY411G7Cq"
        panda264.tags = "大熊猫,萌宠,动物圈"
        panda264.authorName = "胖哒哒不月半"
        panda264.cover =
            "https://i1.hdslb.com/bfs/archive/42ad5218d9b683da09f06eaa889f5c749abbdcde.jpg"
        list.add(panda264)

        val panda265 = PetVideo()
        panda265.type = VideoType.PANDA.ordinal
        panda265.fileName = "panda_group_panda265"
        panda265.code = 1512
        panda265.duration = 22
        panda265.period = PeriodType.GROUP.ordinal
        panda265.isStar = true
        panda265.title = "【大熊猫和花】花宝叽的大正脸哦，太乖喽"
        panda265.releaseTime = "2022-03-02 22:30:19"
        panda265.originalUrl = "https://www.bilibili.com/video/BV1wY411G7Bb"
        panda265.tags = "大熊猫,萌宠,动物圈"
        panda265.authorName = "小香妞爱熊猫"
        panda265.cover =
            "https://i1.hdslb.com/bfs/archive/b81025809d6845f648e6734176ea95f6e1066a79.jpg"
        list.add(panda265)

        val panda266 = PetVideo()
        panda266.type = VideoType.PANDA.ordinal
        panda266.fileName = "panda_group_panda266"
        panda266.code = 1513
        panda266.duration = 91
        panda266.period = PeriodType.GROUP.ordinal
        panda266.isStar = true
        panda266.title = "超萌超可爱超漂亮的春天花花！！【大熊猫和花】"
        panda266.releaseTime = "2022-03-02 08:38:06"
        panda266.originalUrl = "https://www.bilibili.com/video/BV1eT4y1S7J1"
        panda266.tags = "大熊猫,萌宠,动物圈"
        panda266.authorName = "安娜丽丝k"
        panda266.cover =
            "https://i2.hdslb.com/bfs/archive/502b8fbe6e65874bca03841f0c80eac96fce2361.jpg"
        list.add(panda266)

        val panda267 = PetVideo()
        panda267.type = VideoType.PANDA.ordinal
        panda267.fileName = "panda_group_panda267"
        panda267.code = 1514
        panda267.duration = 72
        panda267.period = PeriodType.GROUP.ordinal
        panda267.isStar = true
        panda267.title = "【大熊猫和花】该配合花花的演出，菜菜没有配合好，花花生胖气了"
        panda267.releaseTime = "2022-02-06 09:00:06"
        panda267.originalUrl = "https://www.bilibili.com/video/BV1FY41187yZ"
        panda267.tags = "大熊猫,萌宠,动物圈"
        panda267.authorName = "小香妞爱熊猫"
        panda267.cover =
            "https://i0.hdslb.com/bfs/archive/f76b7f770d3374b574a4d2ab52f84838ef7b1169.jpg"
        list.add(panda267)

        val panda268 = PetVideo()
        panda268.type = VideoType.PANDA.ordinal
        panda268.fileName = "panda_group_panda268"
        panda268.code = 1515
        panda268.duration = 69
        panda268.period = PeriodType.GROUP.ordinal
        panda268.isStar = false
        panda268.title = "和花撩架不成，反被润玥“坐头杀”~【大熊猫和花.和叶.润玥】"
        panda268.releaseTime = "2022-03-01 08:04:02"
        panda268.originalUrl = "https://www.bilibili.com/video/BV1da41187PQ"
        panda268.tags = "大熊猫,萌宠,动物圈"
        panda268.authorName = "安娜丽丝k"
        panda268.cover =
            "https://i1.hdslb.com/bfs/archive/abcbb6ce337ac31d6a52652c3e9d4be55a774cec.jpg"
        list.add(panda268)

        val panda269 = PetVideo()
        panda269.type = VideoType.PANDA.ordinal
        panda269.fileName = "panda_group_panda269"
        panda269.code = 1516
        panda269.duration = 355
        panda269.period = PeriodType.GROUP.ordinal
        panda269.isStar = true
        panda269.title = "【大熊猫和叶 润玥】小叶子也要靠着菜菜姐姐吃！"
        panda269.releaseTime = "2022-02-23 15:40:06"
        panda269.originalUrl = "https://www.bilibili.com/video/BV1eu411X7Qx"
        panda269.tags = "大熊猫,萌宠,动物圈"
        panda269.authorName = "瑞壑"
        panda269.cover =
            "https://i1.hdslb.com/bfs/archive/8389e35d9bcd1601c9d193b159caa645e2c48aab.jpg"
        list.add(panda269)

        val panda270 = PetVideo()
        panda270.type = VideoType.PANDA.ordinal
        panda270.fileName = "panda_group_panda270"
        panda270.code = 1517
        panda270.duration = 23
        panda270.period = PeriodType.GROUP.ordinal
        panda270.isStar = false
        panda270.title = "滚滚花式拜年第六招|双熊无间"
        panda270.releaseTime = "2021-02-09 15:00:16"
        panda270.originalUrl = "https://www.bilibili.com/video/BV19t4y1B75o"
        panda270.tags = "大熊猫,萌宠,动物圈"
        panda270.authorName = "iPanda熊猫频道"
        panda270.cover =
            "https://i0.hdslb.com/bfs/archive/3f9e8ab838368086f7cd19640867a681bff1af17.png"
        list.add(panda270)

        val panda271 = PetVideo()
        panda271.type = VideoType.PANDA.ordinal
        panda271.fileName = "panda_group_panda271"
        panda271.code = 1518
        panda271.duration = 115
        panda271.period = PeriodType.GROUP.ordinal
        panda271.isStar = true
        panda271.title = "【大熊猫和花】花花依偎在菜菜姐怀里，岁月静好，画面很温馨"
        panda271.releaseTime = "2021-10-11 22:00:13"
        panda271.originalUrl = "https://www.bilibili.com/video/BV1y34y1U7H8"
        panda271.tags = "大熊猫,萌宠,动物圈"
        panda271.authorName = "小香妞爱熊猫"
        panda271.cover =
            "https://i0.hdslb.com/bfs/archive/3ddcf709172e640dad08b44461808d4e9787652b.jpg"
        list.add(panda271)

        val panda272 = PetVideo()
        panda272.type = VideoType.PANDA.ordinal
        panda272.fileName = "panda_group_panda272"
        panda272.code = 1519
        panda272.duration = 33
        panda272.period = PeriodType.GROUP.ordinal
        panda272.isStar = true
        panda272.title = "【大熊猫和花】不得不服，花爷泥这是在旱蒸么"
        panda272.releaseTime = "2022-02-27 16:09:21"
        panda272.originalUrl = "https://www.bilibili.com/video/BV1J34y1k7Ta"
        panda272.tags = "大熊猫,萌宠,动物圈"
        panda272.authorName = "小香妞爱熊猫"
        panda272.cover =
            "https://i0.hdslb.com/bfs/archive/d962a9fb675b833d3543287a981c74462fba5c7d.jpg"
        list.add(panda272)

        val panda273 = PetVideo()
        panda273.type = VideoType.PANDA.ordinal
        panda273.fileName = "panda_group_panda273"
        panda273.code = 1520
        panda273.duration = 207
        panda273.period = PeriodType.GROUP.ordinal
        panda273.isStar = false
        panda273.title = "【大熊猫良月】贝贝边看良月眼色边“偷”果果，真的太好笑了！"
        panda273.releaseTime = "2022-02-01 20:41:20"
        panda273.originalUrl = "https://www.bilibili.com/video/BV1HP4y1A7tA"
        panda273.tags = "大熊猫,萌宠,动物圈"
        panda273.authorName = "猴哥某熊铁锤都退役了"
        panda273.cover =
            "https://i0.hdslb.com/bfs/archive/9850e64cdd4b8d8e7ef03557cff05fc9ec8ebaa4.jpg"
        list.add(panda273)

        val panda274 = PetVideo()
        panda274.type = VideoType.PANDA.ordinal
        panda274.fileName = "panda_group_panda274"
        panda274.code = 1521
        panda274.duration = 66
        panda274.period = PeriodType.GROUP.ordinal
        panda274.isStar = false
        panda274.title = "人类幼崽：大熊猫还盖被子呢！【大熊猫和叶】"
        panda274.releaseTime = "2022-02-27 12:38:17"
        panda274.originalUrl = "https://www.bilibili.com/video/BV1vF411t7Yk"
        panda274.tags = "大熊猫,萌宠,动物圈"
        panda274.authorName = "安娜丽丝k"
        panda274.cover =
            "https://i2.hdslb.com/bfs/archive/b89fd298cf6882f7af14b2df4728b83488f77f58.jpg"
        list.add(panda274)

        val panda275 = PetVideo()
        panda275.type = VideoType.PANDA.ordinal
        panda275.fileName = "panda_group_panda275"
        panda275.code = 1522
        panda275.duration = 88
        panda275.period = PeriodType.GROUP.ordinal
        panda275.isStar = false
        panda275.title = "你失忆了，真的没骗你！"
        panda275.releaseTime = "2018-09-06 14:40:01"
        panda275.originalUrl = "https://www.bilibili.com/video/BV1CW411Z7sv"
        panda275.tags = "大熊猫,萌宠,动物圈"
        panda275.authorName = "pandapia熊猫乌托邦"
        panda275.cover =
            "https://i1.hdslb.com/bfs/archive/99d643657a8411e3eb367376048a82fb3ce2ac95.jpg"
        list.add(panda275)

        val panda276 = PetVideo()
        panda276.type = VideoType.PANDA.ordinal
        panda276.fileName = "panda_group_panda276"
        panda276.code = 1523
        panda276.duration = 21
        panda276.period = PeriodType.GROUP.ordinal
        panda276.isStar = true
        panda276.title = "【大美成兰】同是双胞胎为何你这样突出？"
        panda276.releaseTime = "2019-05-08 18:00:08"
        panda276.originalUrl = "https://www.bilibili.com/video/BV1P4411v7ur"
        panda276.tags = "大熊猫,萌宠,动物圈"
        panda276.authorName = "pandapia熊猫乌托邦"
        panda276.cover =
            "https://i2.hdslb.com/bfs/archive/62688a5439b06f9fbc2a158a7dc165569a00baaf.jpg"
        list.add(panda276)

        val panda277 = PetVideo()
        panda277.type = VideoType.PANDA.ordinal
        panda277.fileName = "panda_group_panda277"
        panda277.code = 1524
        panda277.duration = 73
        panda277.period = PeriodType.GROUP.ordinal
        panda277.isStar = false
        panda277.title = "救命啊救命啊，快来救熊啊！"
        panda277.releaseTime = "2019-09-14 13:15:42"
        panda277.originalUrl = "https://www.bilibili.com/video/BV15J411P7aZ"
        panda277.tags = "大熊猫,萌宠,动物圈"
        panda277.authorName = "pandapia熊猫乌托邦"
        panda277.cover =
            "https://i1.hdslb.com/bfs/archive/26f3c82a93c982ccd8795f669ed0be8594e239e4.jpg"
        list.add(panda277)

        val panda278 = PetVideo()
        panda278.type = VideoType.PANDA.ordinal
        panda278.fileName = "panda_group_panda278"
        panda278.code = 1525
        panda278.duration = 75
        panda278.period = PeriodType.GROUP.ordinal
        panda278.isStar = true
        panda278.title = "【奥利奥】战五渣奥胖竹子事件"
        panda278.releaseTime = "2020-07-16 10:03:53"
        panda278.originalUrl = "https://www.bilibili.com/video/BV1Cp4y1S76B"
        panda278.tags = "大熊猫,萌宠,动物圈"
        panda278.authorName = "大熊猫繁育研究基金会"
        panda278.cover =
            "https://i0.hdslb.com/bfs/archive/9c5178a19bab1723c69a0751b3e838b558412477.jpg"
        list.add(panda278)

        val panda279 = PetVideo()
        panda279.type = VideoType.PANDA.ordinal
        panda279.fileName = "panda_group_panda279"
        panda279.code = 1526
        panda279.duration = 71
        panda279.period = PeriodType.GROUP.ordinal
        panda279.isStar = false
        panda279.title = "面哥太暖了，主动去陪断奶中的香果妹妹，妹妹还给哥哥撒娇诉苦"
        panda279.releaseTime = "2021-11-18 09:26:25"
        panda279.originalUrl = "https://www.bilibili.com/video/BV1hT4y1R7CA"
        panda279.tags = "大熊猫,萌宠,动物圈"
        panda279.authorName = "青檬鱼看熊猫儿"
        panda279.cover =
            "https://i2.hdslb.com/bfs/archive/815ce1109994505e07da2a18432bf46dea7574b7.jpg"
        list.add(panda279)

        val panda280 = PetVideo()
        panda280.type = VideoType.PANDA.ordinal
        panda280.fileName = "panda_group_panda280"
        panda280.code = 1527
        panda280.duration = 383
        panda280.period = PeriodType.GROUP.ordinal
        panda280.isStar = true
        panda280.title = "大熊猫萌宝萌玉 亲密的小姐妹（一）"
        panda280.releaseTime = "2020-01-28 20:30:50"
        panda280.originalUrl = "https://www.bilibili.com/video/BV1G7411k7M6"
        panda280.tags = "大熊猫,萌宠,动物圈"
        panda280.authorName = "牙齿不好的老猫"
        panda280.cover =
            "https://i1.hdslb.com/bfs/archive/9f853aad3006cd82a92b9f916d7780f6bc8aabdb.jpg"
        list.add(panda280)

        val panda281 = PetVideo()
        panda281.type = VideoType.PANDA.ordinal
        panda281.fileName = "panda_group_panda281"
        panda281.code = 1528
        panda281.duration = 69
        panda281.period = PeriodType.GROUP.ordinal
        panda281.isStar = true
        panda281.title = "【大熊猫萌宝和萌玉】愉快的早餐。2021.6.21.摄于北京动物园"
        panda281.releaseTime = "2021-06-22 11:19:08"
        panda281.originalUrl = "https://www.bilibili.com/video/BV1dU4y1G7XU"
        panda281.tags = "大熊猫,萌宠,动物圈"
        panda281.authorName = "巴顿洛洛"
        panda281.cover =
            "https://i0.hdslb.com/bfs/archive/02ceab6096623b41a608013a3d49d3b55f73302b.jpg"
        list.add(panda281)

        val panda282 = PetVideo()
        panda282.type = VideoType.PANDA.ordinal
        panda282.fileName = "panda_group_panda282"
        panda282.code = 1529
        panda282.duration = 232
        panda282.period = PeriodType.GROUP.ordinal
        panda282.isStar = false
        panda282.title = "【大熊猫萌宝&萌玉】两个小宝贝今天回北京了，愿以后熊生顺遂~"
        panda282.releaseTime = "2019-09-10 19:55:02"
        panda282.originalUrl = "https://www.bilibili.com/video/BV1JJ411K7LF"
        panda282.tags = "大熊猫,萌宠,动物圈"
        panda282.authorName = "辛辛糖包"
        panda282.cover =
            "https://i0.hdslb.com/bfs/archive/fb92cdaf7d888bc1fef8ddf115cf160c7d2d4bb0.jpg"
        list.add(panda282)

        val panda283 = PetVideo()
        panda283.type = VideoType.PANDA.ordinal
        panda283.fileName = "panda_group_panda283"
        panda283.code = 1530
        panda283.duration = 150
        panda283.period = PeriodType.GROUP.ordinal
        panda283.isStar = true
        panda283.title = "【大熊猫萌玉】合班第一天就把水塞给拔了，怎么那么厉害呢你(●—●)"
        panda283.releaseTime = "2019-09-04 01:30:58"
        panda283.originalUrl = "https://www.bilibili.com/video/BV1g441127jQ"
        panda283.tags = "大熊猫,萌宠,动物圈"
        panda283.authorName = "辛辛糖包"
        panda283.cover =
            "https://i2.hdslb.com/bfs/archive/41e48f27f02727d800564e2aef413b77627279d9.jpg"
        list.add(panda283)

        val panda284 = PetVideo()
        panda284.type = VideoType.PANDA.ordinal
        panda284.fileName = "panda_group_panda284"
        panda284.code = 1531
        panda284.duration = 445
        panda284.period = PeriodType.GROUP.ordinal
        panda284.isStar = false
        panda284.title = "【大熊猫春生香果】暖男春生实锤！你揉面打糕的时候可不是这样的"
        panda284.releaseTime = "2021-03-06 14:22:29"
        panda284.originalUrl = "https://www.bilibili.com/video/BV14f4y1473r"
        panda284.tags = "大熊猫,萌宠,动物圈"
        panda284.authorName = "空调轰轰响"
        panda284.cover =
            "https://i2.hdslb.com/bfs/archive/ba195ba7cc26d481c7c0131031cf210a33770ae9.jpg"
        list.add(panda284)

        val panda285 = PetVideo()
        panda285.type = VideoType.PANDA.ordinal
        panda285.fileName = "panda_group_panda285"
        panda285.code = 1532
        panda285.duration = 86
        panda285.period = PeriodType.GROUP.ordinal
        panda285.isStar = false
        panda285.title = "菜总，请问毁树账单寄给哪个?【大熊猫润玥】"
        panda285.releaseTime = "2022-02-26 10:21:40"
        panda285.originalUrl = "https://www.bilibili.com/video/BV1LL4y1g7xx"
        panda285.tags = "大熊猫,萌宠,动物圈"
        panda285.authorName = "安娜丽丝k"
        panda285.cover =
            "https://i1.hdslb.com/bfs/archive/c96aa7ed360c562b122363ac243f3741ffea9d06.jpg"
        list.add(panda285)

        val panda286 = PetVideo()
        panda286.type = VideoType.PANDA.ordinal
        panda286.fileName = "panda_group_panda286"
        panda286.code = 1533
        panda286.duration = 68
        panda286.period = PeriodType.GROUP.ordinal
        panda286.isStar = false
        panda286.title = "为什么这么长......大熊猫和花的舌头好长啊！"
        panda286.releaseTime = "2022-02-25 18:05:00"
        panda286.originalUrl = "https://www.bilibili.com/video/BV1au411X7HH"
        panda286.tags = "大熊猫,萌宠,动物圈"
        panda286.authorName = "水果小分队的椰子"
        panda286.cover =
            "https://i1.hdslb.com/bfs/archive/aed6e0ed8687f9fef515fc244f095440cea4f842.jpg"
        list.add(panda286)

        val panda287 = PetVideo()
        panda287.type = VideoType.PANDA.ordinal
        panda287.fileName = "panda_group_panda287"
        panda287.code = 1534
        panda287.duration = 207
        panda287.period = PeriodType.GROUP.ordinal
        panda287.isStar = true
        panda287.title = "勇敢和花不怕困难，加油努力爬高高"
        panda287.releaseTime = "2022-02-25 12:35:12"
        panda287.originalUrl = "https://www.bilibili.com/video/BV14m4y1R7tn"
        panda287.tags = "大熊猫,萌宠,动物圈"
        panda287.authorName = "开饭了大熊猫V"
        panda287.cover =
            "https://i2.hdslb.com/bfs/archive/4aff09151e73180e9b51c99025c48cd3c4215300.jpg"
        list.add(panda287)

        val panda288 = PetVideo()
        panda288.type = VideoType.PANDA.ordinal
        panda288.fileName = "panda_group_panda288"
        panda288.code = 1535
        panda288.duration = 141
        panda288.period = PeriodType.GROUP.ordinal
        panda288.isStar = true
        panda288.title = "花花撩架太萌了，一言不合就咬手手，就算打不赢但气势必须拿捏住【大熊猫和花&润玥】"
        panda288.releaseTime = "2022-02-23 21:47:12"
        panda288.originalUrl = "https://www.bilibili.com/video/BV1Bb4y1s7uy"
        panda288.tags = "大熊猫,萌宠,动物圈"
        panda288.authorName = "跑去见花"
        panda288.cover =
            "https://i0.hdslb.com/bfs/archive/7d4644759015464dff681a28eb0a8b4531a77484.jpg"
        list.add(panda288)

        val panda289 = PetVideo()
        panda289.type = VideoType.PANDA.ordinal
        panda289.fileName = "panda_group_panda289"
        panda289.code = 1536
        panda289.duration = 557
        panda289.period = PeriodType.GROUP.ordinal
        panda289.isStar = false
        panda289.title = "20180923幼年2班钓猫（肉肉星繁娇奥星辉）"
        panda289.releaseTime = "2018-10-07 22:26:30"
        panda289.originalUrl = "https://www.bilibili.com/video/BV1RW411y7ff"
        panda289.tags = "大熊猫,萌宠,动物圈"
        panda289.authorName = "咪呜咪呜酱"
        panda289.cover =
            "https://i1.hdslb.com/bfs/archive/aefa0776bb702398e6459322f929bd27013758d5.jpg"
        list.add(panda289)

        val panda290 = PetVideo()
        panda290.type = VideoType.PANDA.ordinal
        panda290.fileName = "panda_group_panda290"
        panda290.code = 1537
        panda290.duration = 263
        panda290.period = PeriodType.GROUP.ordinal
        panda290.isStar = true
        panda290.title = "【幼年二班】肉肉、奇一、星辉、星繁钓猫(20181116)"
        panda290.releaseTime = "2018-11-20 21:19:09"
        panda290.originalUrl = "https://www.bilibili.com/video/BV1dt41117AN"
        panda290.tags = "大熊猫,萌宠,动物圈"
        panda290.authorName = "辛辛糖包"
        panda290.cover =
            "https://i1.hdslb.com/bfs/archive/d20cb88a852de94256bb9f26f74e69e9fa9def98.jpg"
        list.add(panda290)

        val panda291 = PetVideo()
        panda291.type = VideoType.PANDA.ordinal
        panda291.fileName = "panda_group_panda291"
        panda291.code = 1538
        panda291.duration = 482
        panda291.period = PeriodType.GROUP.ordinal
        panda291.isStar = false
        panda291.title = "20181208幼年二班钓猫-肉姐大意失窝头（肉肉奇一星辉星繁）"
        panda291.releaseTime = "2018-12-09 00:29:27"
        panda291.originalUrl = "https://www.bilibili.com/video/BV15t411D7vT"
        panda291.tags = "大熊猫,萌宠,动物圈"
        panda291.authorName = "咪呜咪呜酱"
        panda291.cover =
            "https://i2.hdslb.com/bfs/archive/e69e660a934f8b57676780fedb12011ae37ddd42.jpg"
        list.add(panda291)

        val panda292 = PetVideo()
        panda292.type = VideoType.PANDA.ordinal
        panda292.fileName = "panda_group_panda292"
        panda292.code = 1539
        panda292.duration = 645
        panda292.period = PeriodType.GROUP.ordinal
        panda292.isStar = false
        panda292.title = "20181210幼年2班钓猫，肉姐又被抢，还挨打脸了（肉肉星繁星辉奇一）"
        panda292.releaseTime = "2018-12-14 23:04:42"
        panda292.originalUrl = "https://www.bilibili.com/video/BV17t411i7ij"
        panda292.tags = "大熊猫,萌宠,动物圈"
        panda292.authorName = "咪呜咪呜酱"
        panda292.cover =
            "https://i0.hdslb.com/bfs/archive/46625f9d0b8abe0c102667862a8e531aaf8c8089.jpg"
        list.add(panda292)

        val panda293 = PetVideo()
        panda293.type = VideoType.PANDA.ordinal
        panda293.fileName = "panda_group_panda293"
        panda293.code = 1540
        panda293.duration = 131
        panda293.period = PeriodType.GROUP.ordinal
        panda293.isStar = true
        panda293.title = "【萌三】奶爸你的胯还好吗～"
        panda293.releaseTime = "2016-09-10 16:37:02"
        panda293.originalUrl = "https://www.bilibili.com/video/BV1Ns411r79t"
        panda293.tags = "大熊猫,萌宠,动物圈"
        panda293.authorName = "pandapia熊猫乌托邦"
        panda293.cover =
            "https://i1.hdslb.com/bfs/archive/f587026cc4cbab777f872e4e52935565abd2c097.jpg"
        list.add(panda293)

        val panda294 = PetVideo()
        panda294.type = VideoType.PANDA.ordinal
        panda294.fileName = "panda_group_panda294"
        panda294.code = 1541
        panda294.duration = 41
        panda294.period = PeriodType.GROUP.ordinal
        panda294.isStar = false
        panda294.title = "迎迎球这么大了，也还是个小可爱！"
        panda294.releaseTime = "2019-07-13 18:00:52"
        panda294.originalUrl = "https://www.bilibili.com/video/BV18t411L7Kd"
        panda294.tags = "大熊猫,萌宠,动物圈"
        panda294.authorName = "pandapia熊猫乌托邦"
        panda294.cover =
            "https://i1.hdslb.com/bfs/archive/de6b2899fcf21957e5f03c5f4350ed3b04199560.jpg"
        list.add(panda294)

        val panda295 = PetVideo()
        panda295.type = VideoType.PANDA.ordinal
        panda295.fileName = "panda_group_panda295"
        panda295.code = 1542
        panda295.duration = 23
        panda295.period = PeriodType.GROUP.ordinal
        panda295.isStar = true
        panda295.title = "这是全村唯一一只蹦过迪的熊猫了"
        panda295.releaseTime = "2018-07-29 21:00:11"
        panda295.originalUrl = "https://www.bilibili.com/video/BV18s411N7xG"
        panda295.tags = "大熊猫,萌宠,动物圈"
        panda295.authorName = "pandapia熊猫乌托邦"
        panda295.cover =
            "https://i1.hdslb.com/bfs/archive/f38570382af76610d9cef623bd5f877e5cbe3fa6.jpg"
        list.add(panda295)

        val panda296 = PetVideo()
        panda296.type = VideoType.PANDA.ordinal
        panda296.fileName = "panda_group_panda296"
        panda296.code = 1543
        panda296.duration = 163
        panda296.period = PeriodType.GROUP.ordinal
        panda296.isStar = false
        panda296.title = "熊猫怎么下树？和花的小心思…"
        panda296.releaseTime = "2022-02-22 12:43:32"
        panda296.originalUrl = "https://www.bilibili.com/video/BV1fR4y1L781"
        panda296.tags = "大熊猫,萌宠,动物圈"
        panda296.authorName = "开饭了大熊猫V"
        panda296.cover =
            "https://i1.hdslb.com/bfs/archive/61b8bf13e4cb6cc59031992cceb13c185a08efb6.jpg"
        list.add(panda296)

        val panda297 = PetVideo()
        panda297.type = VideoType.PANDA.ordinal
        panda297.fileName = "panda_group_panda297"
        panda297.code = 1544
        panda297.duration = 93
        panda297.period = PeriodType.GROUP.ordinal
        panda297.isStar = true
        panda297.title = "太惨了！被卡在树上的大熊猫和花......"
        panda297.releaseTime = "2022-02-22 18:05:12"
        panda297.originalUrl = "https://www.bilibili.com/video/BV1vu411X78K"
        panda297.tags = "大熊猫,萌宠,动物圈"
        panda297.authorName = "水果小分队的椰子"
        panda297.cover =
            "https://i1.hdslb.com/bfs/archive/322568a4c95b4002a3e1972e0a31541a5ff30e42.jpg"
        list.add(panda297)

        val panda298 = PetVideo()
        panda298.type = VideoType.PANDA.ordinal
        panda298.fileName = "panda_group_panda298"
        panda298.code = 1545
        panda298.duration = 36
        panda298.period = PeriodType.GROUP.ordinal
        panda298.isStar = false
        panda298.title = "大熊猫和花-漂亮小熊有心事了"
        panda298.releaseTime = "2022-02-22 18:47:35"
        panda298.originalUrl = "https://www.bilibili.com/video/BV1PZ4y1k7z3"
        panda298.tags = "大熊猫,萌宠,动物圈"
        panda298.authorName = "和和和花花"
        panda298.cover =
            "https://i0.hdslb.com/bfs/archive/dfa2726093ce6b6cb1a18897892c416fa7120553.jpg"
        list.add(panda298)

        val panda299 = PetVideo()
        panda299.type = VideoType.PANDA.ordinal
        panda299.fileName = "panda_group_panda299"
        panda299.code = 1546
        panda299.duration = 63
        panda299.period = PeriodType.GROUP.ordinal
        panda299.isStar = true
        panda299.title = "肉肉：为什么国宝还要起床呀！"
        panda299.releaseTime = "2019-02-26 21:00:30"
        panda299.originalUrl = "https://www.bilibili.com/video/BV1Ub41187aQ"
        panda299.tags = "大熊猫,萌宠,动物圈"
        panda299.authorName = "pandapia熊猫乌托邦"
        panda299.cover =
            "https://i2.hdslb.com/bfs/archive/f461c50000cff816365a3def49f2c2f88a8b0e36.jpg"
        list.add(panda299)

        val panda300 = PetVideo()
        panda300.type = VideoType.PANDA.ordinal
        panda300.fileName = "panda_group_panda300"
        panda300.code = 1547
        panda300.duration = 36
        panda300.period = PeriodType.GROUP.ordinal
        panda300.isStar = false
        panda300.title = "【大熊猫】肉肉：我是一只大青蛙，咕咕咕！"
        panda300.releaseTime = "2018-05-19 14:53:38"
        panda300.originalUrl = "https://www.bilibili.com/video/BV1rp411d7ib"
        panda300.tags = "大熊猫,萌宠,动物圈"
        panda300.authorName = "嘉然从小就很猪比"
        panda300.cover =
            "https://i0.hdslb.com/bfs/archive/fb275859d45bd216775c8436e8c6a1010c8234a1.jpg"
        list.add(panda300)

        val panda301 = PetVideo()
        panda301.type = VideoType.PANDA.ordinal
        panda301.fileName = "panda_group_panda301"
        panda301.code = 1548
        panda301.duration = 36
        panda301.period = PeriodType.GROUP.ordinal
        panda301.isStar = false
        panda301.title = "【大熊猫和花】腻歪花"
        panda301.releaseTime = "2022-02-20 15:23:47"
        panda301.originalUrl = "https://www.bilibili.com/video/BV1BS4y1F7hK"
        panda301.tags = "大熊猫,萌宠,动物圈"
        panda301.authorName = "吃花花の喵酱"
        panda301.cover =
            "https://i2.hdslb.com/bfs/archive/d1587eca9521ce16b916b89ea3365cf9359a55ff.png"
        list.add(panda301)

        val panda302 = PetVideo()
        panda302.type = VideoType.PANDA.ordinal
        panda302.fileName = "panda_group_panda302"
        panda302.code = 1549
        panda302.duration = 41
        panda302.period = PeriodType.GROUP.ordinal
        panda302.isStar = false
        panda302.title = "【大熊猫和花】这么近距离的机会，是我就掏出麻袋了"
        panda302.releaseTime = "2022-02-18 17:38:11"
        panda302.originalUrl = "https://www.bilibili.com/video/BV1CS4y1r7bW"
        panda302.tags = "大熊猫,萌宠,动物圈"
        panda302.authorName = "吃花花の喵酱"
        panda302.cover =
            "https://i1.hdslb.com/bfs/archive/e8c0b99ff8198f805ac7d223e3c875e9cb9c1ecd.png"
        list.add(panda302)

        val panda303 = PetVideo()
        panda303.type = VideoType.PANDA.ordinal
        panda303.fileName = "panda_group_panda303"
        panda303.code = 1550
        panda303.duration = 100
        panda303.period = PeriodType.GROUP.ordinal
        panda303.isStar = true
        panda303.title = "【大熊猫和花】花花慢慢走到餐厅，开始啃竹子"
        panda303.releaseTime = "2022-02-19 23:23:54"
        panda303.originalUrl = "https://www.bilibili.com/video/BV1pL411K7MB"
        panda303.tags = "大熊猫,萌宠,动物圈"
        panda303.authorName = "朙雨"
        panda303.cover =
            "https://i0.hdslb.com/bfs/archive/d3d809b18283b7ad7ea59adb4c0ebf6c6cbb1472.jpg"
        list.add(panda303)

        val panda304 = PetVideo()
        panda304.type = VideoType.PANDA.ordinal
        panda304.fileName = "panda_group_panda304"
        panda304.code = 1551
        panda304.duration = 41
        panda304.period = PeriodType.GROUP.ordinal
        panda304.isStar = false
        panda304.title = "和花花用小米牙吃小竹竿（二）"
        panda304.releaseTime = "2022-02-19 14:06:05"
        panda304.originalUrl = "https://www.bilibili.com/video/BV1GL4y1g7VG"
        panda304.tags = "大熊猫,萌宠,动物圈"
        panda304.authorName = "莹宝ts"
        panda304.cover =
            "https://i0.hdslb.com/bfs/archive/438399978bc51dbeac0acf1326e84ac5f8b5aebf.jpg"
        list.add(panda304)

        val panda305 = PetVideo()
        panda305.type = VideoType.PANDA.ordinal
        panda305.fileName = "panda_group_panda305"
        panda305.code = 1552
        panda305.duration = 386
        panda305.period = PeriodType.GROUP.ordinal
        panda305.isStar = false
        panda305.title = "【绩笑成风成浪】当基地树遭遇流氓团伙，嘎嘎脆"
        panda305.releaseTime = "2022-02-02 15:52:52"
        panda305.originalUrl = "https://www.bilibili.com/video/BV1Kr4y1Y7cu"
        panda305.tags = "大熊猫,萌宠,动物圈"
        panda305.authorName = "打酱油的闹闹子"
        panda305.cover =
            "https://i2.hdslb.com/bfs/archive/ac417d80e84db1b7afc4799b51039cb18dc6d5ee.jpg"
        list.add(panda305)

        val panda306 = PetVideo()
        panda306.type = VideoType.PANDA.ordinal
        panda306.fileName = "panda_group_panda306"
        panda306.code = 1553
        panda306.duration = 84
        panda306.period = PeriodType.GROUP.ordinal
        panda306.isStar = false
        panda306.title = "【大熊猫和花】天然呆，自然萌，就是很呆萌啊"
        panda306.releaseTime = "2022-02-13 20:15:47"
        panda306.originalUrl = "https://www.bilibili.com/video/BV1v341177th"
        panda306.tags = "大熊猫,萌宠,动物圈"
        panda306.authorName = "辛辛糖包"
        panda306.cover =
            "https://i2.hdslb.com/bfs/archive/42da0f68aa219383a47f7cdcedc79d802f8a4409.jpg"
        list.add(panda306)

        val panda307 = PetVideo()
        panda307.type = VideoType.PANDA.ordinal
        panda307.fileName = "panda_group_panda307"
        panda307.code = 1554
        panda307.duration = 51
        panda307.period = PeriodType.GROUP.ordinal
        panda307.isStar = true
        panda307.title = "润玥姐姐压和花，花花反击！"
        panda307.releaseTime = "2022-02-18 15:13:10"
        panda307.originalUrl = "https://www.bilibili.com/video/BV1Zi4y117dt"
        panda307.tags = "大熊猫,萌宠,动物圈"
        panda307.authorName = "沈家姑娘最爱和花花"
        panda307.cover =
            "https://i0.hdslb.com/bfs/archive/29e816d11f9e70cf538e1c6a2ed44ce20064eca8.jpg"
        list.add(panda307)

        val panda308 = PetVideo()
        panda308.type = VideoType.PANDA.ordinal
        panda308.fileName = "panda_group_panda308"
        panda308.code = 1555
        panda308.duration = 17
        panda308.period = PeriodType.GROUP.ordinal
        panda308.isStar = true
        panda308.title = "【和花】猛熊的呐喊"
        panda308.releaseTime = "2022-02-17 20:13:24"
        panda308.originalUrl = "https://www.bilibili.com/video/BV1ki4y117He"
        panda308.tags = "大熊猫,萌宠,动物圈"
        panda308.authorName = "育碧小孩"
        panda308.cover =
            "https://i1.hdslb.com/bfs/archive/e562c6855ccf4aaefa4a0dc4dc9c4aac30bbfa5f.jpg"
        list.add(panda308)

        val panda309 = PetVideo()
        panda309.type = VideoType.PANDA.ordinal
        panda309.fileName = "panda_group_panda309"
        panda309.code = 1556
        panda309.duration = 25
        panda309.period = PeriodType.GROUP.ordinal
        panda309.isStar = false
        panda309.title = "【大熊猫奇一】不要贴贴不要贴贴"
        panda309.releaseTime = "2022-02-17 15:35:54"
        panda309.originalUrl = "https://www.bilibili.com/video/BV14341177sT"
        panda309.tags = "大熊猫,萌宠,动物圈"
        panda309.authorName = "丶大熊猫奇一"
        panda309.cover =
            "https://i1.hdslb.com/bfs/archive/a1a59aaebdb39201f898e75c4da3126f73ef91be.jpg"
        list.add(panda309)

        val panda310 = PetVideo()
        panda310.type = VideoType.PANDA.ordinal
        panda310.fileName = "panda_group_panda310"
        panda310.code = 1557
        panda310.duration = 128
        panda310.period = PeriodType.GROUP.ordinal
        panda310.isStar = true
        panda310.title = "大熊猫和花：我躺好了，你想rua吗？"
        panda310.releaseTime = "2022-02-18 18:05:08"
        panda310.originalUrl = "https://www.bilibili.com/video/BV1w5411Z7ro"
        panda310.tags = "大熊猫,萌宠,动物圈"
        panda310.authorName = "水果小分队的椰子"
        panda310.cover =
            "https://i0.hdslb.com/bfs/archive/03df57e76ac8e3a8444f267ec75d8e9a6ece2956.jpg"
        list.add(panda310)

        val panda311 = PetVideo()
        panda311.type = VideoType.PANDA.ordinal
        panda311.fileName = "panda_group_panda311"
        panda311.code = 1558
        panda311.duration = 76
        panda311.period = PeriodType.GROUP.ordinal
        panda311.isStar = true
        panda311.title = "fa姐霸气fa姐威武，fa姐又滚出了屏幕。二狗：。。【大熊猫和花、润玥】"
        panda311.releaseTime = "2022-02-18 21:20:24"
        panda311.originalUrl = "https://www.bilibili.com/video/BV1S34y1C7Fj"
        panda311.tags = "大熊猫,萌宠,动物圈"
        panda311.authorName = "隽一一"
        panda311.cover =
            "https://i2.hdslb.com/bfs/archive/d5279b454dec650503dc060a53663f9e77b4092f.jpg"
        list.add(panda311)

        val panda312 = PetVideo()
        panda312.type = VideoType.PANDA.ordinal
        panda312.fileName = "panda_group_panda312"
        panda312.code = 1559
        panda312.duration = 84
        panda312.period = PeriodType.GROUP.ordinal
        panda312.isStar = false
        panda312.title = "【大熊猫启程&启航】好好吃饭，不要开小差呀"
        panda312.releaseTime = "2021-12-14 20:16:46"
        panda312.originalUrl = "https://www.bilibili.com/video/BV1JL411E76Y"
        panda312.tags = "大熊猫,萌宠,动物圈"
        panda312.authorName = "辛辛糖包"
        panda312.cover =
            "https://i1.hdslb.com/bfs/archive/a2f7d1ce2058fcb144359d8de3c8d251f4adc860.jpg"
        list.add(panda312)

        val panda313 = PetVideo()
        panda313.type = VideoType.PANDA.ordinal
        panda313.fileName = "panda_group_panda313"
        panda313.code = 1560
        panda313.duration = 66
        panda313.period = PeriodType.GROUP.ordinal
        panda313.isStar = false
        panda313.title = "叶总：我的沈王爷羽毛呢？【大熊猫和叶、润玥】"
        panda313.releaseTime = "2022-02-03 21:12:00"
        panda313.originalUrl = "https://www.bilibili.com/video/BV1Hu411d7a5"
        panda313.tags = "大熊猫,萌宠,动物圈"
        panda313.authorName = "隽一一"
        panda313.cover =
            "https://i0.hdslb.com/bfs/archive/7d2951bfcb2083bb929b89558693158c8a360c51.jpg"
        list.add(panda313)

        val panda314 = PetVideo()
        panda314.type = VideoType.PANDA.ordinal
        panda314.fileName = "panda_group_panda314"
        panda314.code = 1561
        panda314.duration = 279
        panda314.period = PeriodType.GROUP.ordinal
        panda314.isStar = true
        panda314.title = "【大熊猫和花 润玥】甜菜花：好姐妹的甜蜜时光"
        panda314.releaseTime = "2022-02-17 14:22:51"
        panda314.originalUrl = "https://www.bilibili.com/video/BV11S4y1C7KF"
        panda314.tags = "大熊猫,萌宠,动物圈"
        panda314.authorName = "瑞壑"
        panda314.cover =
            "https://i0.hdslb.com/bfs/archive/20df016e9aafb76ea08886139c73a7bf2ef5fcde.jpg"
        list.add(panda314)

        val panda315 = PetVideo()
        panda315.type = VideoType.PANDA.ordinal
        panda315.fileName = "panda_group_panda315"
        panda315.code = 1562
        panda315.duration = 71
        panda315.period = PeriodType.GROUP.ordinal
        panda315.isStar = false
        panda315.title = "【绩笑】【成风】【成浪】在一起每顿都是年夜饭"
        panda315.releaseTime = "2022-01-29 12:10:22"
        panda315.originalUrl = "https://www.bilibili.com/video/BV1D3411h7mb"
        panda315.tags = "大熊猫,萌宠,动物圈"
        panda315.authorName = "我觉得还可以诶"
        panda315.cover =
            "https://i0.hdslb.com/bfs/archive/e6f946e99c362556e2de515e0c4a3c9f72360df1.jpg"
        list.add(panda315)

        val panda316 = PetVideo()
        panda316.type = VideoType.PANDA.ordinal
        panda316.fileName = "panda_group_panda316"
        panda316.code = 1563
        panda316.duration = 103
        panda316.period = PeriodType.GROUP.ordinal
        panda316.isStar = true
        panda316.title = "02.15上班，玖菜已经开始吃播，和花花叼着小树枝，迈着从容的步伐来上班"
        panda316.releaseTime = "2022-02-16 14:52:22"
        panda316.originalUrl = "https://www.bilibili.com/video/BV125411o7eg"
        panda316.tags = "大熊猫,萌宠,动物圈"
        panda316.authorName = "朙雨"
        panda316.cover =
            "https://i2.hdslb.com/bfs/archive/6469c24eb264e78aff541e175f4f2ee2938acccb.jpg"
        list.add(panda316)

        val panda317 = PetVideo()
        panda317.type = VideoType.PANDA.ordinal
        panda317.fileName = "panda_group_panda317"
        panda317.code = 1564
        panda317.duration = 105
        panda317.period = PeriodType.GROUP.ordinal
        panda317.isStar = true
        panda317.title = "和花jiojio反复试探还是逃不过摔倒的命运"
        panda317.releaseTime = "2022-02-17 02:13:38"
        panda317.originalUrl = "https://www.bilibili.com/video/BV1u34y1C7Bv"
        panda317.tags = "大熊猫,萌宠,动物圈"
        panda317.authorName = "羽木尹"
        panda317.cover =
            "https://i1.hdslb.com/bfs/archive/e5635b765641b1ceeba5b197b148d9d63b09e50b.jpg"
        list.add(panda317)

        val panda318 = PetVideo()
        panda318.type = VideoType.PANDA.ordinal
        panda318.fileName = "panda_group_panda318"
        panda318.code = 1565
        panda318.duration = 270
        panda318.period = PeriodType.GROUP.ordinal
        panda318.isStar = true
        panda318.title = "【大熊猫和花】睡在泥土里的小仙女起床了"
        panda318.releaseTime = "2022-02-16 13:59:07"
        panda318.originalUrl = "https://www.bilibili.com/video/BV1nY411V7Hk"
        panda318.tags = "大熊猫,萌宠,动物圈"
        panda318.authorName = "瑞壑"
        panda318.cover =
            "https://i0.hdslb.com/bfs/archive/bed66e71bb91cbcb19ca559cf87902d17b8eb8cf.jpg"
        list.add(panda318)

        val panda319 = PetVideo()
        panda319.type = VideoType.PANDA.ordinal
        panda319.fileName = "panda_group_panda319"
        panda319.code = 1566
        panda319.duration = 161
        panda319.period = PeriodType.GROUP.ordinal
        panda319.isStar = true
        panda319.title = "剧情超精彩，请看完。和花： 和叶只因嘀咕了一句fatfat就被打...请各位不要不知好歹哟"
        panda319.releaseTime = "2022-02-12 21:33:46"
        panda319.originalUrl = "https://www.bilibili.com/video/BV1B44y1H7mK"
        panda319.tags = "大熊猫,萌宠,动物圈"
        panda319.authorName = "摄影师动物米"
        panda319.cover =
            "https://i0.hdslb.com/bfs/archive/ec55393bd6fbc61434d35bf66ba80b6656f21bfb.jpg"
        list.add(panda319)

        val panda320 = PetVideo()
        panda320.type = VideoType.PANDA.ordinal
        panda320.fileName = "panda_group_panda320"
        panda320.code = 1567
        panda320.duration = 101
        panda320.period = PeriodType.GROUP.ordinal
        panda320.isStar = false
        panda320.title = "【大熊猫和叶 润玥】黏菜精和叶迪迪"
        panda320.releaseTime = "2022-02-10 11:33:16"
        panda320.originalUrl = "https://www.bilibili.com/video/BV175411o7Zo"
        panda320.tags = "大熊猫,萌宠,动物圈"
        panda320.authorName = "瑞壑"
        panda320.cover =
            "https://i0.hdslb.com/bfs/archive/99d4947d67fdb5cde54ffa60bfd52d12cea00c28.jpg"
        list.add(panda320)

        val panda321 = PetVideo()
        panda321.type = VideoType.PANDA.ordinal
        panda321.fileName = "panda_group_panda321"
        panda321.code = 1568
        panda321.duration = 155
        panda321.period = PeriodType.GROUP.ordinal
        panda321.isStar = false
        panda321.title = "【大熊猫和花 和叶 润玥 艾玖】小树枝快成月亮四墩的主食了"
        panda321.releaseTime = "2022-02-12 22:37:19"
        panda321.originalUrl = "https://www.bilibili.com/video/BV1YY411L7PV"
        panda321.tags = "大熊猫,萌宠,动物圈"
        panda321.authorName = "瑞壑"
        panda321.cover =
            "https://i2.hdslb.com/bfs/archive/1f37ca68c6784d2f9d5070e52cedf74a69b986be.jpg"
        list.add(panda321)

        val panda322 = PetVideo()
        panda322.type = VideoType.PANDA.ordinal
        panda322.fileName = "panda_group_panda322"
        panda322.code = 1569
        panda322.duration = 94
        panda322.period = PeriodType.GROUP.ordinal
        panda322.isStar = true
        panda322.title = "和花真的是最美好最可爱最萌最好看的熊猫了！【大熊猫和花】"
        panda322.releaseTime = "2022-02-15 08:04:02"
        panda322.originalUrl = "https://www.bilibili.com/video/BV1Wb4y147om"
        panda322.tags = "大熊猫,萌宠,动物圈"
        panda322.authorName = "安娜丽丝k"
        panda322.cover =
            "https://i2.hdslb.com/bfs/archive/04a5af25015682855b108c819f86e33eda22c486.jpg"
        list.add(panda322)

        val panda323 = PetVideo()
        panda323.type = VideoType.PANDA.ordinal
        panda323.fileName = "panda_group_panda323"
        panda323.code = 1570
        panda323.duration = 149
        panda323.period = PeriodType.GROUP.ordinal
        panda323.isStar = true
        panda323.title = "【大熊猫和花】花花准备午休了"
        panda323.releaseTime = "2022-02-13 18:12:10"
        panda323.originalUrl = "https://www.bilibili.com/video/BV1cm4y1o7KQ"
        panda323.tags = "大熊猫,萌宠,动物圈"
        panda323.authorName = "朙雨"
        panda323.cover =
            "https://i2.hdslb.com/bfs/archive/ef40b1f90e6e23e4749eab2117b30e9c8c85e745.jpg"
        list.add(panda323)

        val panda324 = PetVideo()
        panda324.type = VideoType.PANDA.ordinal
        panda324.fileName = "panda_group_panda324"
        panda324.code = 1571
        panda324.duration = 126
        panda324.period = PeriodType.GROUP.ordinal
        panda324.isStar = false
        panda324.title = "主任：艾玖，爷爷在喊我们了，你回不回去？【大熊猫和花、润玥、艾玖】"
        panda324.releaseTime = "2022-02-13 21:05:57"
        panda324.originalUrl = "https://www.bilibili.com/video/BV11S4y1C7Y5"
        panda324.tags = "大熊猫,萌宠,动物圈"
        panda324.authorName = "隽一一"
        panda324.cover =
            "https://i2.hdslb.com/bfs/archive/0a54cff49ba92f98ed5b5cf1fc5e7a016ddffe10.jpg"
        list.add(panda324)

        val panda325 = PetVideo()
        panda325.type = VideoType.PANDA.ordinal
        panda325.fileName = "panda_group_panda325"
        panda325.code = 1572
        panda325.duration = 86
        panda325.period = PeriodType.GROUP.ordinal
        panda325.isStar = true
        panda325.title = "【大熊猫和花和叶】 情人节陪姐姐  和叶送礼不当险酿冲突【doge】"
        panda325.releaseTime = "2022-02-14 21:30:23"
        panda325.originalUrl = "https://www.bilibili.com/video/BV14341177NC"
        panda325.tags = "大熊猫,萌宠,动物圈"
        panda325.authorName = "摄影师动物米"
        panda325.cover =
            "https://i0.hdslb.com/bfs/archive/d7149dec6abc8a8846d4681893bfe590a480e09e.jpg"
        list.add(panda325)

        val panda326 = PetVideo()
        panda326.type = VideoType.PANDA.ordinal
        panda326.fileName = "panda_group_panda326"
        panda326.code = 1573
        panda326.duration = 32
        panda326.period = PeriodType.GROUP.ordinal
        panda326.isStar = true
        panda326.title = "冰墩墩改造计划"
        panda326.releaseTime = "2022-02-10 12:12:46"
        panda326.originalUrl = "https://www.bilibili.com/video/BV1Xr4y1h7D1"
        panda326.tags = "大熊猫,萌宠,动物圈"
        panda326.authorName = "zkkkkkkay"
        panda326.cover =
            "https://i2.hdslb.com/bfs/archive/7ee7260c7ea5b7b72e3f4390cdce223ffb342759.jpg"
        list.add(panda326)

        val panda327 = PetVideo()
        panda327.type = VideoType.PANDA.ordinal
        panda327.fileName = "panda_group_panda327"
        panda327.code = 1574
        panda327.duration = 73
        panda327.period = PeriodType.GROUP.ordinal
        panda327.isStar = true
        panda327.title = "【大熊猫和花润玥】好姐妹就是～你抠痒，我马上挨着你一起躺倒同步抠痒"
        panda327.releaseTime = "2022-02-11 22:29:48"
        panda327.originalUrl = "https://www.bilibili.com/video/BV1JY411L7Pz"
        panda327.tags = "大熊猫,萌宠,动物圈"
        panda327.authorName = "青檬鱼看熊猫儿"
        panda327.cover =
            "https://i2.hdslb.com/bfs/archive/0927ed08d3ad190d557537c50babb20952dfd856.jpg"
        list.add(panda327)

        return list
    }
}