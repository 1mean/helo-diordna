package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetMomPandaData2 {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {
        val panda305 = PetVideo()
        panda305.type = VideoType.PANDA.ordinal
        panda305.fileName = "panda_mom_panda305"
        panda305.code = 1391
        panda305.duration = 314
        panda305.period = PeriodType.MOM.ordinal
        panda305.star = true
        panda305.title = "【大熊猫和花&和叶】花花和小叶子玩秋千"
        panda305.releaseTime = "2022-01-16 17:24:43"
        panda305.originalUrl = "https://www.bilibili.com/video/BV1tL4y147s1"
        panda305.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda305.authorId = 230382720
        panda305.cover =
            "https://i0.hdslb.com/bfs/archive/98bb2df99d65be6ee79161ec00c4e72c94b059c4.jpg"
        list.add(panda305)

        val panda306 = PetVideo()
        panda306.type = VideoType.PANDA.ordinal
        panda306.fileName = "panda_mom_panda306"
        panda306.code = 1392
        panda306.duration = 164
        panda306.period = PeriodType.MOM.ordinal
        panda306.star = false
        panda306.title = "【大熊猫和花】天空下着太阳雨，花花找到一个能遮阳避雨的好地方"
        panda306.releaseTime = "2021-09-10 15:08:38"
        panda306.originalUrl = "https://www.bilibili.com/video/BV12q4y1N7uc"
        panda306.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda306.authorId = 230382720
        panda306.cover =
            "https://i1.hdslb.com/bfs/archive/9045539d3b77965c1f09153b46963f31756a56ac.jpg"
        list.add(panda306)

        val panda307 = PetVideo()
        panda307.type = VideoType.PANDA.ordinal
        panda307.fileName = "panda_mom_panda307"
        panda307.code = 1393
        panda307.duration = 117
        panda307.period = PeriodType.MOM.ordinal
        panda307.star = false
        panda307.title = "雅颂有多活泼"
        panda307.releaseTime = "2022-03-06 11:57:46"
        panda307.originalUrl = "https://www.bilibili.com/video/BV1a44y1M7fQ"
        panda307.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda307.authorId = 396450082
        panda307.cover =
            "https://i1.hdslb.com/bfs/archive/f80314ac08e4f1328b387cb48e4e09d0a0986fcb.jpg"
        list.add(panda307)

        val panda308 = PetVideo()
        panda308.type = VideoType.PANDA.ordinal
        panda308.fileName = "panda_mom_panda308"
        panda308.code = 1394
        panda308.duration = 69
        panda308.period = PeriodType.MOM.ordinal
        panda308.star = false
        panda308.title = "宝璐和宝兰的较量"
        panda308.releaseTime = "2022-03-06 00:54:42"
        panda308.originalUrl = "https://www.bilibili.com/video/BV1Pr4y1B7rg"
        panda308.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda308.authorId = 396450082
        panda308.cover =
            "https://i1.hdslb.com/bfs/archive/5cd734d87515d2fc90c16b9ff0532932468cc3ad.jpg"
        list.add(panda308)

        val panda309 = PetVideo()
        panda309.type = VideoType.PANDA.ordinal
        panda309.fileName = "panda_mom_panda309"
        panda309.code = 1395
        panda309.duration = 94
        panda309.period = PeriodType.MOM.ordinal
        panda309.star = true
        panda309.title = "麻麻带仔，莽仔（对着莽小崽）：这是我亲生的，亲生的，我忍！忍不住了，再开打"
        panda309.releaseTime = "2022-03-03 20:33:02"
        panda309.originalUrl = "https://www.bilibili.com/video/BV1yU4y1Z7YG"
        panda309.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda309.authorId = 702068578
        panda309.cover =
            "https://i1.hdslb.com/bfs/archive/f6ab2a8cfc494d8c9ebc34531a36bf4fc129f9d3.jpg"
        list.add(panda309)

        val panda310 = PetVideo()
        panda310.type = VideoType.PANDA.ordinal
        panda310.fileName = "panda_mom_panda310"
        panda310.code = 1396
        panda310.duration = 35
        panda310.period = PeriodType.MOM.ordinal
        panda310.star = true
        panda310.title = "可爱的福多多下架子"
        panda310.releaseTime = "2022-03-04 22:58:03"
        panda310.originalUrl = "https://www.bilibili.com/video/BV1bR4y157ik"
        panda310.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda310.authorId = 396450082
        panda310.cover =
            "https://i0.hdslb.com/bfs/archive/4f9454c43e05acd9e9b7bc434fe77b482ec1cc2c.jpg"
        list.add(panda310)

        val panda311 = PetVideo()
        panda311.type = VideoType.PANDA.ordinal
        panda311.fileName = "panda_mom_panda311"
        panda311.code = 1397
        panda311.duration = 65
        panda311.period = PeriodType.MOM.ordinal
        panda311.star = false
        panda311.title = "福多多好奇干妈的苹果！干妈给了多多温柔！【大熊猫雅莉。福多多，雅颂】"
        panda311.releaseTime = "2022-03-04 16:01:45"
        panda311.originalUrl = "https://www.bilibili.com/video/BV17b4y1x7ws"
        panda311.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda311.authorId = 2137796700
        panda311.cover =
            "https://i0.hdslb.com/bfs/archive/45b34b8ee3e25c2105e7496e8331053b1171f829.jpg"
        list.add(panda311)

        val panda312 = PetVideo()
        panda312.type = VideoType.PANDA.ordinal
        panda312.fileName = "panda_mom_panda312"
        panda312.code = 1398
        panda312.duration = 142
        panda312.period = PeriodType.MOM.ordinal
        panda312.star = false
        panda312.title = "【大熊猫和花】润润干妈最终还是对我下手了"
        panda312.releaseTime = "2021-04-12 21:57:51"
        panda312.originalUrl = "https://www.bilibili.com/video/BV1Py4y147BU"
        panda312.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda312.authorId = 98871951
        panda312.cover =
            "https://i1.hdslb.com/bfs/archive/1470a580086692e556ddee02a4f602d3c09ead2b.jpg"
        list.add(panda312)

        val panda313 = PetVideo()
        panda313.type = VideoType.PANDA.ordinal
        panda313.fileName = "panda_mom_panda313"
        panda313.code = 1399
        panda313.duration = 101
        panda313.period = PeriodType.MOM.ordinal
        panda313.star = false
        panda313.title = "多多第一天跟雅莉干妈出外场。鸭梨不让多多爬石头山、爬树。。【大熊猫福多多、雅莉、雅颂】"
        panda313.releaseTime = "2022-03-04 21:03:49"
        panda313.originalUrl = "https://www.bilibili.com/video/BV183411j7se"
        panda313.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda313.authorId = 514531996
        panda313.cover =
            "https://i0.hdslb.com/bfs/archive/2c117d7e2710881e0bc55d048f8edcd1ea066e98.jpg"
        list.add(panda313)

        val panda314 = PetVideo()
        panda314.type = VideoType.PANDA.ordinal
        panda314.fileName = "panda_mom_panda314"
        panda314.code = 1400
        panda314.duration = 64
        panda314.period = PeriodType.MOM.ordinal
        panda314.star = false
        panda314.title = "【大熊猫和花】和花花之沉浸式舔脚脚咬手手！"
        panda314.releaseTime = "2022-03-03 08:38:19"
        panda314.originalUrl = "https://www.bilibili.com/video/BV1Ta411h7uU"
        panda314.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda314.authorId = 16468440
        panda314.cover =
            "https://i2.hdslb.com/bfs/archive/161078b9f483d06cae5d137401b3f392573358e1.jpg"
        list.add(panda314)

        val panda315 = PetVideo()
        panda315.type = VideoType.PANDA.ordinal
        panda315.fileName = "panda_mom_panda315"
        panda315.code = 1401
        panda315.duration = 48
        panda315.period = PeriodType.MOM.ordinal
        panda315.star = true
        panda315.title = "福多多跟大鸭梨妈妈第一天出外场，有妈妈在，两小只都好开心"
        panda315.releaseTime = "2022-03-03 21:03:29"
        panda315.originalUrl = "https://www.bilibili.com/video/BV1kb4y1x7Nt"
        panda315.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda315.authorId = 98871951
        panda315.cover =
            "https://i1.hdslb.com/bfs/archive/227ce6aaf5f8bd35f6b4661768cc516ca5f74f5f.jpg"
        list.add(panda315)

        val panda316 = PetVideo()
        panda316.type = VideoType.PANDA.ordinal
        panda316.fileName = "panda_mom_panda316"
        panda316.code = 1402
        panda316.duration = 31
        panda316.period = PeriodType.MOM.ordinal
        panda316.star = true
        panda316.title = "【博瓦勒动物园】七个月大的欢黎黎圆嘟嘟"
        panda316.releaseTime = "2022-03-02 19:49:28"
        panda316.originalUrl = "https://www.bilibili.com/video/BV11Y411G7nD"
        panda316.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda316.authorId = 113647100
        panda316.cover =
            "https://i1.hdslb.com/bfs/archive/1ff3046d78790d6da4f0a7267dd98a1a1432cf2d.jpg"
        list.add(panda316)

        val panda317 = PetVideo()
        panda317.type = VideoType.PANDA.ordinal
        panda317.fileName = "panda_mom_panda317"
        panda317.code = 1403
        panda317.duration = 66
        panda317.period = PeriodType.MOM.ordinal
        panda317.star = false
        panda317.title = "【重庆动物园】温馨一家熊，莽仔给星猪儿辰猪儿喂奶"
        panda317.releaseTime = "2022-03-03 12:04:32"
        panda317.originalUrl = "https://www.bilibili.com/video/BV1bu411D7VN"
        panda317.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda317.authorId = 66688464
        panda317.cover =
            "https://i1.hdslb.com/bfs/archive/486f60037b9a4befdf5a79d0dbde7a7ccc7b32e9.jpg"
        list.add(panda317)

        val panda318 = PetVideo()
        panda318.type = VideoType.PANDA.ordinal
        panda318.fileName = "panda_mom_panda318"
        panda318.code = 1404
        panda318.duration = 55
        panda318.period = PeriodType.MOM.ordinal
        panda318.star = false
        panda318.title = "大熊猫汉媛：这是最温馨的画面，汉媛亲吻宝贝女儿甜可，除了感动还是感动"
        panda318.releaseTime = "2020-05-08 12:00:26"
        panda318.originalUrl = "https://www.bilibili.com/video/BV16g4y1z7bb"
        panda318.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda318.authorId = 98871951
        panda318.cover =
            "https://i0.hdslb.com/bfs/archive/657b0e222d5e4da04028d638ddb91e9a60ccc2f9.jpg"
        list.add(panda318)

        val panda319 = PetVideo()
        panda319.type = VideoType.PANDA.ordinal
        panda319.fileName = "panda_mom_panda319"
        panda319.code = 1405
        panda319.duration = 53
        panda319.period = PeriodType.MOM.ordinal
        panda319.star = true
        panda319.title = "媛哥：看看麻麻看什么～呃～麻麻你怎么睡了【大熊猫汉媛麒麟】"
        panda319.releaseTime = "2020-12-01 09:31:17"
        panda319.originalUrl = "https://www.bilibili.com/video/BV1VK4y177Ps"
        panda319.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda319.authorId = 19715714
        panda319.cover =
            "https://i2.hdslb.com/bfs/archive/9a7256ea02818bbb03889519fe93ddde068659e2.jpg"
        list.add(panda319)

        val panda320 = PetVideo()
        panda320.type = VideoType.PANDA.ordinal
        panda320.fileName = "panda_mom_panda320"
        panda320.code = 1406
        panda320.duration = 73
        panda320.period = PeriodType.MOM.ordinal
        panda320.star = false
        panda320.title = "雅颂：麻麻看我玩得溜不溜？ 雅莉：下来吧你～"
        panda320.releaseTime = "2022-03-03 09:30:00"
        panda320.originalUrl = "https://www.bilibili.com/video/BV1pL4y137df"
        panda320.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda320.authorId = 19715714
        panda320.cover =
            "https://i2.hdslb.com/bfs/archive/3c1fc709b7a5c9c4d72f26dca4a2999ccd0f5479.jpg"
        list.add(panda320)

        val panda321 = PetVideo()
        panda321.type = VideoType.PANDA.ordinal
        panda321.fileName = "panda_mom_panda321"
        panda321.code = 1407
        panda321.duration = 206
        panda321.period = PeriodType.MOM.ordinal
        panda321.star = false
        panda321.title = "【奇珍奇宝】好奇上次教孩子吃象草，这次教孩子吃野草"
        panda321.releaseTime = "2022-03-02 20:08:55"
        panda321.originalUrl = "https://www.bilibili.com/video/BV1yU4y1Z7xX"
        panda321.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda321.authorId = 180602305
        panda321.cover =
            "https://i1.hdslb.com/bfs/archive/770e508d89339f55aa3091d590729d2a47902d6d.jpg"
        list.add(panda321)

        val panda322 = PetVideo()
        panda322.type = VideoType.PANDA.ordinal
        panda322.fileName = "panda_mom_panda322"
        panda322.code = 1408
        panda322.duration = 47
        panda322.period = PeriodType.MOM.ordinal
        panda322.star = true
        panda322.title = "和花：您搁这拖地呢？"
        panda322.releaseTime = "2021-07-10 18:15:55"
        panda322.originalUrl = "https://www.bilibili.com/video/BV1Bf4y1L73E"
        panda322.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda322.authorId = 476733832
        panda322.cover =
            "https://i1.hdslb.com/bfs/archive/db786302b2372519ecd452c36e19272d2fa08044.jpg"
        list.add(panda322)

        val panda323 = PetVideo()
        panda323.type = VideoType.PANDA.ordinal
        panda323.fileName = "panda_mom_panda323"
        panda323.code = 1409
        panda323.duration = 70
        panda323.period = PeriodType.MOM.ordinal
        panda323.star = false
        panda323.title = "昭美美：奶妈，请把这两个小魔怪收走，我有点忙不过来。【大熊猫金宵、轮辉、昭美】"
        panda323.releaseTime = "2022-03-02 20:30:37"
        panda323.originalUrl = "https://www.bilibili.com/video/BV14b4y1x7MR"
        panda323.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda323.authorId = 514531996
        panda323.cover =
            "https://i0.hdslb.com/bfs/archive/ef08460c15308d6c211e68f88c61d37cbe4408e2.jpg"
        list.add(panda323)

        val panda324 = PetVideo()
        panda324.type = VideoType.PANDA.ordinal
        panda324.fileName = "panda_mom_panda324"
        panda324.code = 1410
        panda324.duration = 34
        panda324.period = PeriodType.MOM.ordinal
        panda324.star = true
        panda324.title = "水秀麻麻又带崽了，好温馨的一家三口~贵州茅台认养的崽"
        panda324.releaseTime = "2022-01-18 23:00:04"
        panda324.originalUrl = "https://www.bilibili.com/video/BV1wL411c7p2"
        panda324.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda324.authorId = 98871951
        panda324.cover =
            "https://i0.hdslb.com/bfs/archive/8bd0266a635cc266410d474915f7a6d1d1bbe91c.jpg"
        list.add(panda324)

        val panda325 = PetVideo()
        panda325.type = VideoType.PANDA.ordinal
        panda325.fileName = "panda_mom_panda325"
        panda325.code = 1411
        panda325.duration = 79
        panda325.period = PeriodType.MOM.ordinal
        panda325.star = false
        panda325.title = "【重庆动物园】好奇女侠带女儿奇珍"
        panda325.releaseTime = "2022-03-01 12:28:39"
        panda325.originalUrl = "https://www.bilibili.com/video/BV1zS4y1g7ko"
        panda325.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda325.authorId = 66688464
        panda325.cover =
            "https://i0.hdslb.com/bfs/archive/723702063abe4921d2d301c97f0ee095bb68fa1d.jpg"
        list.add(panda325)

        val panda326 = PetVideo()
        panda326.type = VideoType.PANDA.ordinal
        panda326.fileName = "panda_mom_panda326"
        panda326.code = 1412
        panda326.duration = 70
        panda326.period = PeriodType.MOM.ordinal
        panda326.star = false
        panda326.title = "大长腿......大熊猫和花的腿好长啊！"
        panda326.releaseTime = "2022-03-01 18:05:16"
        panda326.originalUrl = "https://www.bilibili.com/video/BV1v44y1T7SF"
        panda326.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda326.authorId = 21330840
        panda326.cover =
            "https://i0.hdslb.com/bfs/archive/f14471e55bfb137355fa831f73ae85386858d2af.jpg"
        list.add(panda326)

        val panda327 = PetVideo()
        panda327.type = VideoType.PANDA.ordinal
        panda327.fileName = "panda_mom_panda327"
        panda327.code = 1413
        panda327.duration = 38
        panda327.period = PeriodType.MOM.ordinal
        panda327.star = false
        panda327.title = "【莽星星莽辰辰】上班早退被逮住了怎么办？"
        panda327.releaseTime = "2022-02-20 15:35:23"
        panda327.originalUrl = "https://www.bilibili.com/video/BV1LS4y1F72Q"
        panda327.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda327.authorId = 66688464
        panda327.cover =
            "https://i2.hdslb.com/bfs/archive/0ea8a5a59195b52ad511db3cda01d756e258ca6f.jpg"
        list.add(panda327)

        val panda328 = PetVideo()
        panda328.type = VideoType.PANDA.ordinal
        panda328.fileName = "panda_mom_panda328"
        panda328.code = 1414
        panda328.duration = 93
        panda328.period = PeriodType.MOM.ordinal
        panda328.star = false
        panda328.title = "苹果面前无母子（宝兰宝新）"
        panda328.releaseTime = "2022-03-01 11:32:16"
        panda328.originalUrl = "https://www.bilibili.com/video/BV1Zu411D7ZJ"
        panda328.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda328.authorId = 19715714
        panda328.cover =
            "https://i2.hdslb.com/bfs/archive/a1896dc8b197cfd56b6b8fa58fe6b2740e9d9ff8.jpg"
        list.add(panda328)

        val panda329 = PetVideo()
        panda329.type = VideoType.PANDA.ordinal
        panda329.fileName = "panda_mom_panda329"
        panda329.code = 1415
        panda329.duration = 14
        panda329.period = PeriodType.MOM.ordinal
        panda329.star = false
        panda329.title = "大熊猫雅颂：“大家来看看，这是我的麻麻”～"
        panda329.releaseTime = "2022-02-28 12:34:57"
        panda329.originalUrl = "https://www.bilibili.com/video/BV1kS4y167xn"
        panda329.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda329.authorId = 1025949925
        panda329.vertical = true
        panda329.cover =
            "https://i2.hdslb.com/bfs/archive/efa303103e26f5450ead8067d756b304bbb2c187.jpg"
        list.add(panda329)

        val panda330 = PetVideo()
        panda330.type = VideoType.PANDA.ordinal
        panda330.fileName = "panda_mom_panda330"
        panda330.code = 1416
        panda330.duration = 65
        panda330.period = PeriodType.MOM.ordinal
        panda330.star = true
        panda330.title = "【莽仔莽星星】莽仔：乖崽，快和妈咪一起拍大头照"
        panda330.releaseTime = "2022-02-23 12:00:57"
        panda330.originalUrl = "https://www.bilibili.com/video/BV1tP4y1c7k5"
        panda330.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda330.authorId = 66688464
        panda330.cover =
            "https://i2.hdslb.com/bfs/archive/566022b4ae6b13d498772ca01e18afafcccf650b.jpg"
        list.add(panda330)

        val panda331 = PetVideo()
        panda331.type = VideoType.PANDA.ordinal
        panda331.fileName = "panda_mom_panda331"
        panda331.code = 1417
        panda331.duration = 129
        panda331.period = PeriodType.MOM.ordinal
        panda331.star = true
        panda331.title = "【大熊猫园润&润玥&和花】菜花园吃播，三个小朋友熊生顺遂，健健康康"
        panda331.releaseTime = "2021-11-15 18:13:15"
        panda331.originalUrl = "https://www.bilibili.com/video/BV1ab4y1t7d5"
        panda331.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda331.authorId = 34677299
        panda331.cover =
            "https://i1.hdslb.com/bfs/archive/e190796f63199a93a466151aa1b8ff5a995479be.jpg"
        list.add(panda331)

        val panda332 = PetVideo()
        panda332.type = VideoType.PANDA.ordinal
        panda332.fileName = "panda_mom_panda332"
        panda332.code = 1418
        panda332.duration = 68
        panda332.period = PeriodType.MOM.ordinal
        panda332.star = false
        panda332.title = "【重庆动物园】莽仔妈咪在吃饭呢，不和你玩"
        panda332.releaseTime = "2022-02-28 12:09:24"
        panda332.originalUrl = "https://www.bilibili.com/video/BV1uL4y137wt"
        panda332.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda332.authorId = 66688464
        panda332.cover =
            "https://i2.hdslb.com/bfs/archive/7ccc3bb9247b14271f61d9ea342c9ae5c2c33e6b.jpg"
        list.add(panda332)

        val panda333 = PetVideo()
        panda333.type = VideoType.PANDA.ordinal
        panda333.fileName = "panda_mom_panda333"
        panda333.code = 1419
        panda333.duration = 107
        panda333.period = PeriodType.MOM.ordinal
        panda333.star = true
        panda333.title = "昭美终于外场带娃了 还是那个负责的好妈妈"
        panda333.releaseTime = "2022-02-26 18:36:37"
        panda333.originalUrl = "https://www.bilibili.com/video/BV17m4y1R7SL"
        panda333.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda333.authorId = 4120384
        panda333.cover =
            "https://i1.hdslb.com/bfs/archive/d1ab924ab952bb7b14112a028b0f380b80c43c65.jpg"
        list.add(panda333)

        val panda334 = PetVideo()
        panda334.type = VideoType.PANDA.ordinal
        panda334.fileName = "panda_mom_panda334"
        panda334.code = 1420
        panda334.duration = 57
        panda334.period = PeriodType.MOM.ordinal
        panda334.star = false
        panda334.title = "艾莉收拾艾玖，和叶旁边卖萌21"
        panda334.releaseTime = "2022-02-23 22:46:16"
        panda334.originalUrl = "https://www.bilibili.com/video/BV1BU4y1Z7Xt"
        panda334.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda334.authorId = 496664786
        panda334.cover =
            "https://i1.hdslb.com/bfs/archive/2df104ef19f07dfb2f9f15d548cb25f99b36ee4e.jpg"
        list.add(panda334)

        val panda335 = PetVideo()
        panda335.type = VideoType.PANDA.ordinal
        panda335.fileName = "panda_mom_panda335"
        panda335.code = 1421
        panda335.duration = 76
        panda335.period = PeriodType.MOM.ordinal
        panda335.star = false
        panda335.title = "昭美：特训开班第一天，让你们看看我的拿手绝活～轮辉：可以换金宵吗？"
        panda335.releaseTime = "2022-02-24 18:38:52"
        panda335.originalUrl = "https://www.bilibili.com/video/BV1LS4y1k7QE"
        panda335.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda335.authorId = 19715714
        panda335.cover =
            "https://i1.hdslb.com/bfs/archive/d83da7d0dfb1d9995ce95bd4c72552f319fa6d2c.jpg"
        list.add(panda335)

        val panda336 = PetVideo()
        panda336.type = VideoType.PANDA.ordinal
        panda336.fileName = "panda_mom_panda336"
        panda336.code = 1422
        panda336.duration = 47
        panda336.period = PeriodType.MOM.ordinal
        panda336.star = false
        panda336.title = "搂着我的宝贝和花女儿睡觉咯~"
        panda336.releaseTime = "2020-04-07 14:02:15"
        panda336.originalUrl = "https://www.bilibili.com/video/BV1gZ4y1x7Qa"
        panda336.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda336.authorId = 12444306
        panda336.cover =
            "https://i2.hdslb.com/bfs/archive/144fffb3848693aec10d23f70fee79c4339975c0.jpg"
        list.add(panda336)

        val panda337 = PetVideo()
        panda337.type = VideoType.PANDA.ordinal
        panda337.fileName = "panda_mom_panda337"
        panda337.code = 1423
        panda337.duration = 226
        panda337.period = PeriodType.MOM.ordinal
        panda337.star = false
        panda337.title = "你以为花花是蓬蓬毛，其实和花是实心胖"
        panda337.releaseTime = "2021-06-03 14:40:00"
        panda337.originalUrl = "https://www.bilibili.com/video/BV1wU4y1j7f8"
        panda337.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda337.authorId = 12444306
        panda337.cover =
            "https://i1.hdslb.com/bfs/archive/21d6a31de58a75dbe8084fffa6e398219edabfba.jpg"
        list.add(panda337)

        val panda338 = PetVideo()
        panda338.type = VideoType.PANDA.ordinal
        panda338.fileName = "panda_mom_panda338"
        panda338.code = 1424
        panda338.duration = 86
        panda338.period = PeriodType.MOM.ordinal
        panda338.star = true
        panda338.title = "【小馨】妈咪，我长胖了就不能在你膝下撒娇了吗？是的，你挡着妈咪了，莫挨我！"
        panda338.releaseTime = "2020-03-19 13:35:19"
        panda338.originalUrl = "https://www.bilibili.com/video/BV1m7411d7R6"
        panda338.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda338.authorId = 12444306
        panda338.cover =
            "https://i2.hdslb.com/bfs/archive/24b4e83c52f182050061277fea1f3bad97264270.jpg"
        list.add(panda338)

        val panda339 = PetVideo()
        panda339.type = VideoType.PANDA.ordinal
        panda339.fileName = "panda_mom_panda339"
        panda339.code = 1425
        panda339.duration = 51
        panda339.period = PeriodType.MOM.ordinal
        panda339.star = false
        panda339.title = "哈哈哈哈哈哈哈游客的现场解说仿佛是出大戏"
        panda339.releaseTime = "2019-06-11 15:30:11"
        panda339.originalUrl = "https://www.bilibili.com/video/BV1f4411N7S8"
        panda339.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda339.authorId = 12444306
        panda339.cover =
            "https://i1.hdslb.com/bfs/archive/bfbf229860022688802e1741b6f90ce5b218f359.jpg"
        list.add(panda339)

        val panda340 = PetVideo()
        panda340.type = VideoType.PANDA.ordinal
        panda340.fileName = "panda_mom_panda340"
        panda340.code = 1426
        panda340.duration = 40
        panda340.period = PeriodType.MOM.ordinal
        panda340.star = true
        panda340.title = "成大面无表情喂奶中"
        panda340.releaseTime = "2018-05-16 20:30:43"
        panda340.originalUrl = "https://www.bilibili.com/video/BV1kp411Z72a"
        panda340.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda340.authorId = 12444306
        panda340.cover =
            "https://i2.hdslb.com/bfs/archive/7468c398be7bc7d4af5c63acf51807724673acda.jpg"
        list.add(panda340)

        val panda341 = PetVideo()
        panda341.type = VideoType.PANDA.ordinal
        panda341.fileName = "panda_mom_panda341"
        panda341.code = 1427
        panda341.duration = 42
        panda341.period = PeriodType.MOM.ordinal
        panda341.star = false
        panda341.title = "成风：这个世界上，怎么会有我介么可爱的熊猫宝宝呢？"
        panda341.releaseTime = "2020-06-13 13:30:04"
        panda341.originalUrl = "https://www.bilibili.com/video/BV1XT4y1E7k3"
        panda341.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda341.authorId = 12444306
        panda341.cover =
            "https://i1.hdslb.com/bfs/archive/ab7feaaa2ec2d206d9c96601d03accb0a3a25535.jpg"
        list.add(panda341)

        val panda342 = PetVideo()
        panda342.type = VideoType.PANDA.ordinal
        panda342.fileName = "panda_mom_panda342"
        panda342.code = 1428
        panda342.duration = 48
        panda342.period = PeriodType.MOM.ordinal
        panda342.star = true
        panda342.title = "【娇奥】会游泳的熊猫？当然。游泳、潜水、打浪花花，啥都会！"
        panda342.releaseTime = "2019-01-20 21:00:29"
        panda342.originalUrl = "https://www.bilibili.com/video/BV1zt411h7UG"
        panda342.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda342.authorId = 12444306
        panda342.cover =
            "https://i1.hdslb.com/bfs/archive/e2f81cd2cbc9903f037ca6f302d32c27325fb4d9.jpg"
        list.add(panda342)

        val panda343 = PetVideo()
        panda343.type = VideoType.PANDA.ordinal
        panda343.fileName = "panda_mom_panda343"
        panda343.code = 1429
        panda343.duration = 55
        panda343.period = PeriodType.MOM.ordinal
        panda343.star = false
        panda343.title = "奶妈，崽崽给你，拿去吧拿去吧～"
        panda343.releaseTime = "2017-11-18 20:20:34"
        panda343.originalUrl = "https://www.bilibili.com/video/BV1Bx411L7My"
        panda343.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda343.authorId = 12444306
        panda343.cover =
            "https://i1.hdslb.com/bfs/archive/f2d4703460c8bbb8b4a8373bb28ee013f5618fe3.jpg"
        list.add(panda343)

        val panda344 = PetVideo()
        panda344.type = VideoType.PANDA.ordinal
        panda344.fileName = "panda_mom_panda344"
        panda344.code = 1430
        panda344.duration = 138
        panda344.period = PeriodType.MOM.ordinal
        panda344.star = false
        panda344.title = "两个崽换一个苹果，我怎么感觉自己亏了？"
        panda344.releaseTime = "2019-07-02 20:30:37"
        panda344.originalUrl = "https://www.bilibili.com/video/BV1Zx411X7R2"
        panda344.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda344.authorId = 12444306
        panda344.cover =
            "https://i0.hdslb.com/bfs/archive/19d376139ec1581de14192e51f59bc0e4ac3d5f2.jpg"
        list.add(panda344)

        val panda345 = PetVideo()
        panda345.type = VideoType.PANDA.ordinal
        panda345.fileName = "panda_mom_panda345"
        panda345.code = 1431
        panda345.duration = 44
        panda345.period = PeriodType.MOM.ordinal
        panda345.star = false
        panda345.title = "【大熊猫香冰/香果】香冰:我可没有这么脏的女儿熊"
        panda345.releaseTime = "2021-12-11 11:55:25"
        panda345.originalUrl = "https://www.bilibili.com/video/BV1D3411s76L"
        panda345.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda345.authorId = 32436782
        panda345.cover =
            "https://i0.hdslb.com/bfs/archive/d3927b3aa272beae2d741aa0220cd46bde1cdcee.jpg"
        list.add(panda345)

        val panda346 = PetVideo()
        panda346.type = VideoType.PANDA.ordinal
        panda346.fileName = "panda_mom_panda346"
        panda346.code = 1432
        panda346.duration = 986
        panda346.period = PeriodType.MOM.ordinal
        panda346.star = true
        panda346.title = "大熊猫萌萌 大熊猫萌宝 大熊猫萌玉 萌萌吃播、女鹅抢镜"
        panda346.releaseTime = "2019-08-22 19:38:27"
        panda346.originalUrl = "https://www.bilibili.com/video/BV11441197AU"
        panda346.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda346.authorId = 20741157
        panda346.cover =
            "https://i2.hdslb.com/bfs/archive/e33c4677c99fe03ccdee0724f7dfba59779ad581.jpg"
        list.add(panda346)

        val panda347 = PetVideo()
        panda347.type = VideoType.PANDA.ordinal
        panda347.fileName = "panda_mom_panda347"
        panda347.code = 1433
        panda347.duration = 219
        panda347.period = PeriodType.MOM.ordinal
        panda347.star = true
        panda347.title = "【大熊猫萌宝&萌玉】俩个小胖墩为了争宝座大打出手，看来是缺妈妈爱了←_←"
        panda347.releaseTime = "2019-07-24 22:46:20"
        panda347.originalUrl = "https://www.bilibili.com/video/BV1ft411L7ZK"
        panda347.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda347.authorId = 34677299
        panda347.cover =
            "https://i2.hdslb.com/bfs/archive/b9cd86b2ebcd3ec1b3f10c0fd24317cb682d987d.jpg"
        list.add(panda347)

        val panda348 = PetVideo()
        panda348.type = VideoType.PANDA.ordinal
        panda348.fileName = "panda_mom_panda348"
        panda348.code = 1434
        panda348.duration = 284
        panda348.period = PeriodType.MOM.ordinal
        panda348.star = true
        panda348.title = "【大熊猫萌萌&萌玉】宝宝，脸脸怎么脏了，阿妈帮你洗洗吧~"
        panda348.releaseTime = "2020-03-22 04:18:31"
        panda348.originalUrl = "https://www.bilibili.com/video/BV1kE411c7CE"
        panda348.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda348.authorId = 34677299
        panda348.cover =
            "https://i1.hdslb.com/bfs/archive/7b1ec2273e136c13926e38c43e1e787aa0551c58.jpg"
        list.add(panda348)

        val panda349 = PetVideo()
        panda349.type = VideoType.PANDA.ordinal
        panda349.fileName = "panda_mom_panda349"
        panda349.code = 1435
        panda349.duration = 113
        panda349.period = PeriodType.MOM.ordinal
        panda349.star = false
        panda349.title = "【大熊猫萌萌&萌玉】女鹅啊，阿妈对你的爱~爱爱爱不完^O^"
        panda349.releaseTime = "2019-01-10 19:46:42"
        panda349.originalUrl = "https://www.bilibili.com/video/BV1xt411p7Bf"
        panda349.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda349.authorId = 34677299
        panda349.cover =
            "https://i0.hdslb.com/bfs/archive/1e59f66e89d5b1f6e92ef43efb8ac3af4b8c7128.jpg"
        list.add(panda349)

        val panda350 = PetVideo()
        panda350.type = VideoType.PANDA.ordinal
        panda350.fileName = "panda_mom_panda350"
        panda350.code = 1436
        panda350.duration = 113
        panda350.period = PeriodType.MOM.ordinal
        panda350.star = true
        panda350.title = "【大熊猫萌萌&萌玉】宝宝，妈妈累了，休息一会再怼你哦*^_^*"
        panda350.releaseTime = "2019-06-01 22:42:11"
        panda350.originalUrl = "https://www.bilibili.com/video/BV1f4411J7H5"
        panda350.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda350.authorId = 34677299
        panda350.cover =
            "https://i1.hdslb.com/bfs/archive/0d705b6e2cad543e089c4c11e7856ab551b75c01.jpg"
        list.add(panda350)

        val panda351 = PetVideo()
        panda351.type = VideoType.PANDA.ordinal
        panda351.fileName = "panda_mom_panda351"
        panda351.code = 1437
        panda351.duration = 201
        panda351.period = PeriodType.MOM.ordinal
        panda351.star = true
        panda351.title = "【大熊猫萌萌&萌宝&萌玉】萌家三胖，俩小一大胖，胖胖都可爱"
        panda351.releaseTime = "2021-08-28 21:12:15"
        panda351.originalUrl = "https://www.bilibili.com/video/BV1AL41187wo"
        panda351.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda351.authorId = 34677299
        panda351.cover =
            "https://i2.hdslb.com/bfs/archive/07ad032a7fd4271481aa6648c98736a33fb57252.jpg"
        list.add(panda351)

        val panda352 = PetVideo()
        panda352.type = VideoType.PANDA.ordinal
        panda352.fileName = "panda_mom_panda352"
        panda352.code = 1438
        panda352.duration = 237
        panda352.period = PeriodType.MOM.ordinal
        panda352.star = true
        panda352.title = "【大熊猫萌萌&萌宝&萌玉】可愁死萌萌了，左右都是小棉袄，该先Rua哪个呢^O^"
        panda352.releaseTime = "2019-01-14 19:51:39"
        panda352.originalUrl = "https://www.bilibili.com/video/BV14t411H7j5"
        panda352.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda352.authorId = 34677299
        panda352.cover =
            "https://i2.hdslb.com/bfs/archive/8897704af0d847a7e9a3e76175970fae4dfbaf87.jpg"
        list.add(panda352)

        val panda353 = PetVideo()
        panda353.type = VideoType.PANDA.ordinal
        panda353.fileName = "panda_mom_panda353"
        panda353.code = 1439
        panda353.duration = 40
        panda353.period = PeriodType.MOM.ordinal
        panda353.star = false
        panda353.title = "听到孩子被夸可爱，熊猫妈妈成兰坐不住了"
        panda353.releaseTime = "2019-04-17 18:47:30"
        panda353.originalUrl = "https://www.bilibili.com/video/BV1nb41157Uw"
        panda353.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda353.authorId = 12444306
        panda353.cover =
            "https://i1.hdslb.com/bfs/archive/3ff6e2643e2f035ca1e235c8f1f811a877a16b22.jpg"
        list.add(panda353)

        val panda354 = PetVideo()
        panda354.type = VideoType.PANDA.ordinal
        panda354.fileName = "panda_mom_panda354"
        panda354.code = 1440
        panda354.duration = 48
        panda354.period = PeriodType.MOM.ordinal
        panda354.star = false
        panda354.title = "熊猫妈妈艾莉叹气，为什么要生娃？"
        panda354.releaseTime = "2019-12-18 13:05:19"
        panda354.originalUrl = "https://www.bilibili.com/video/BV1uJ41167tX"
        panda354.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda354.authorId = 12444306
        panda354.cover =
            "https://i1.hdslb.com/bfs/archive/bf1962c7ead6a0c973fb74abfa536303268b56d8.jpg"
        list.add(panda354)

        val panda355 = PetVideo()
        panda355.type = VideoType.PANDA.ordinal
        panda355.fileName = "panda_mom_panda355"
        panda355.code = 1441
        panda355.duration = 69
        panda355.period = PeriodType.MOM.ordinal
        panda355.star = false
        panda355.title = "【萌萌萌宝】我妈什么时候能长大？"
        panda355.releaseTime = "2020-01-15 18:10:57"
        panda355.originalUrl = "https://www.bilibili.com/video/BV1fJ411E7P8"
        panda355.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda355.authorId = 12444306
        panda355.cover =
            "https://i0.hdslb.com/bfs/archive/c2415422e00461e76c24bc482b1c16dbc4207751.jpg"
        list.add(panda355)

        val panda356 = PetVideo()
        panda356.type = VideoType.PANDA.ordinal
        panda356.fileName = "panda_mom_panda356"
        panda356.code = 1442
        panda356.duration = 135
        panda356.period = PeriodType.MOM.ordinal
        panda356.star = true
        panda356.title = "萌玉：我们仙女都是长在树上的，从不轻易下凡！"
        panda356.releaseTime = "2019-06-20 16:00:54"
        panda356.originalUrl = "https://www.bilibili.com/video/BV1K4411V78i"
        panda356.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda356.authorId = 12444306
        panda356.cover =
            "https://i2.hdslb.com/bfs/archive/a9141e4580ee6068740914da387f175c58a04b95.jpg"
        list.add(panda356)

        val panda357 = PetVideo()
        panda357.type = VideoType.PANDA.ordinal
        panda357.fileName = "panda_mom_panda357"
        panda357.code = 1443
        panda357.duration = 139
        panda357.period = PeriodType.MOM.ordinal
        panda357.star = false
        panda357.title = "【大熊猫萌萌&萌宝&萌玉】我萌萌姐真是个宝藏女孩，可爱到不行*^o^*"
        panda357.releaseTime = "2019-06-21 22:17:51"
        panda357.originalUrl = "https://www.bilibili.com/video/BV1U441137Db"
        panda357.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda357.authorId = 34677299
        panda357.cover =
            "https://i1.hdslb.com/bfs/archive/dcda0b484c72e41ae43a535680e7625fe070d675.jpg"
        list.add(panda357)

        val panda358 = PetVideo()
        panda358.type = VideoType.PANDA.ordinal
        panda358.fileName = "panda_mom_panda358"
        panda358.code = 1444
        panda358.duration = 114
        panda358.period = PeriodType.MOM.ordinal
        panda358.star = false
        panda358.title = "成大妈妈！我的苹果呢？我的窝头呢？？？"
        panda358.releaseTime = "2018-07-05 20:39:17"
        panda358.originalUrl = "https://www.bilibili.com/video/BV1es411V7PE"
        panda358.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda358.authorId = 12444306
        panda358.cover =
            "https://i0.hdslb.com/bfs/archive/0e9fc137549392906aeb85868269bd7757d7de4e.jpg"
        list.add(panda358)

        val panda359 = PetVideo()
        panda359.type = VideoType.PANDA.ordinal
        panda359.fileName = "panda_mom_panda359"
        panda359.code = 1445
        panda359.duration = 113
        panda359.period = PeriodType.MOM.ordinal
        panda359.star = false
        panda359.title = "熊猫麻麻不同的带娃风格"
        panda359.releaseTime = "2021-03-15 15:16:15"
        panda359.originalUrl = "https://www.bilibili.com/video/BV1wK4y1T7o5"
        panda359.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda359.authorId = 37053244
        panda359.cover =
            "https://i1.hdslb.com/bfs/archive/4d964a5709081bd0d97e00f4fae96332ed74e4a1.jpg"
        list.add(panda359)

        val panda360 = PetVideo()
        panda360.type = VideoType.PANDA.ordinal
        panda360.fileName = "panda_mom_panda360"
        panda360.code = 1446
        panda360.duration = 61
        panda360.period = PeriodType.MOM.ordinal
        panda360.star = false
        panda360.title = "熊猫妈妈伟大的母爱，芝芝一拖三喂neinei，不怕辛苦任劳任怨"
        panda360.releaseTime = "2021-05-05 22:30:02"
        panda360.originalUrl = "https://www.bilibili.com/video/BV13U4y1t71f"
        panda360.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda360.authorId = 98871951
        panda360.cover =
            "https://i0.hdslb.com/bfs/archive/a7e684b88657a0c5b0ba1d45efb123651fd19be4.jpg"
        list.add(panda360)

        val panda361 = PetVideo()
        panda361.type = VideoType.PANDA.ordinal
        panda361.fileName = "panda_mom_panda361"
        panda361.code = 1447
        panda361.duration = 118
        panda361.period = PeriodType.MOM.ordinal
        panda361.star = true
        panda361.title = "三个费头子娃娃追着芝芝妈妈要neinei，芝芝表示我太难了"
        panda361.releaseTime = "2021-05-23 23:00:16"
        panda361.originalUrl = "https://www.bilibili.com/video/BV1c54y1L7Uk"
        panda361.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda361.authorId = 98871951
        panda361.cover =
            "https://i1.hdslb.com/bfs/archive/ae72f1939321f05e11b770e2efad83e4c67203c6.jpg"
        list.add(panda361)

        val panda362 = PetVideo()
        panda362.type = VideoType.PANDA.ordinal
        panda362.fileName = "panda_mom_panda362"
        panda362.code = 1448
        panda362.duration = 68
        panda362.period = PeriodType.MOM.ordinal
        panda362.star = true
        panda362.title = "【大熊猫芝芝/热干面/春生】带娃不易，大佬叹气"
        panda362.releaseTime = "2021-01-31 10:34:04"
        panda362.originalUrl = "https://www.bilibili.com/video/BV1Av411e74p"
        panda362.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda362.authorId = 32436782
        panda362.cover =
            "https://i0.hdslb.com/bfs/archive/1c226bd551ad4767f599838c761687ebf3508db3.jpg"
        list.add(panda362)

        val panda363 = PetVideo()
        panda363.type = VideoType.PANDA.ordinal
        panda363.fileName = "panda_mom_panda363"
        panda363.code = 1449
        panda363.duration = 61
        panda363.period = PeriodType.MOM.ordinal
        panda363.star = true
        panda363.title = "带熊孩子好累，“芝芝妈”实在太难啦！"
        panda363.releaseTime = "2020-12-13 13:00:19"
        panda363.originalUrl = "https://www.bilibili.com/video/BV1s54y147Hu"
        panda363.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda363.authorId = 1998535
        panda363.cover =
            "https://i1.hdslb.com/bfs/archive/93bb088602dfe65b0a79cfeefea5fe57e577c284.jpg"
        list.add(panda363)

        val panda364 = PetVideo()
        panda364.type = VideoType.PANDA.ordinal
        panda364.fileName = "panda_mom_panda364"
        panda364.code = 1450
        panda364.duration = 56
        panda364.period = PeriodType.MOM.ordinal
        panda364.star = false
        panda364.title = "【莽辰辰】是哪个小可爱趁妈咪睡觉开始调皮捣蛋"
        panda364.releaseTime = "2022-02-26 15:52:30"
        panda364.originalUrl = "https://www.bilibili.com/video/BV1FZ4y1C77G"
        panda364.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda364.authorId = 66688464
        panda364.vertical = true
        panda364.cover =
            "https://i0.hdslb.com/bfs/archive/0b5ee833ffac04cb811ae75557fd00547ead9d99.jpg"
        list.add(panda364)

        val panda365 = PetVideo()
        panda365.type = VideoType.PANDA.ordinal
        panda365.fileName = "panda_mom_panda365"
        panda365.code = 1451
        panda365.duration = 63
        panda365.period = PeriodType.MOM.ordinal
        panda365.star = false
        panda365.title = "莽仔：星猪儿，快来接受妈咪爱的抱抱"
        panda365.releaseTime = "2022-02-26 12:24:45"
        panda365.originalUrl = "https://www.bilibili.com/video/BV1jL4y1g7cH"
        panda365.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda365.authorId = 66688464
        panda365.cover =
            "https://i2.hdslb.com/bfs/archive/9bb6f6a2852fcbc17639d2ede31f743028123dc9.jpg"
        list.add(panda365)

        val panda366 = PetVideo()
        panda366.type = VideoType.PANDA.ordinal
        panda366.fileName = "panda_mom_panda366"
        panda366.code = 1452
        panda366.duration = 141
        panda366.period = PeriodType.MOM.ordinal
        panda366.star = true
        panda366.title = "福多多去月亮产房的第一天：颂居居和多多吵架，奶妈劝和，真的好好笑"
        panda366.releaseTime = "2022-02-25 22:31:12"
        panda366.originalUrl = "https://www.bilibili.com/video/BV1A34y1k7ps"
        panda366.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda366.authorId = 98871951
        panda366.cover =
            "https://i2.hdslb.com/bfs/archive/516fe92a6c9900db7f466cfbb99b721edf8f65b2.jpg"
        list.add(panda366)

        val panda367 = PetVideo()
        panda367.type = VideoType.PANDA.ordinal
        panda367.fileName = "panda_mom_panda367"
        panda367.code = 1453
        panda367.duration = 73
        panda367.period = PeriodType.MOM.ordinal
        panda367.star = true
        panda367.title = "【奇珍奇宝】下不来的姐姐熊，好奇忙着教育弟弟熊"
        panda367.releaseTime = "2022-02-25 22:45:29"
        panda367.originalUrl = "https://www.bilibili.com/video/BV1ZR4y1V7fs"
        panda367.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda367.authorId = 180602305
        panda367.cover =
            "https://i2.hdslb.com/bfs/archive/062afbed869ccf90986955087db812abb32c788d.jpg"
        list.add(panda367)

        val panda368 = PetVideo()
        panda368.type = VideoType.PANDA.ordinal
        panda368.fileName = "panda_mom_panda368"
        panda368.code = 1454
        panda368.duration = 71
        panda368.period = PeriodType.MOM.ordinal
        panda368.star = false
        panda368.title = "【奇珍奇宝】这妈当的，带着孩子直奔象草，娃娃长大以后，会不会觉得象草才是主食！"
        panda368.releaseTime = "2022-02-04 19:58:14"
        panda368.originalUrl = "https://www.bilibili.com/video/BV1GZ4y1o7tr"
        panda368.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda368.authorId = 180602305
        panda368.cover =
            "https://i0.hdslb.com/bfs/archive/656b2846ad7e36d0788ace09ddb8e2829c603be0.jpg"
        list.add(panda368)

        val panda369 = PetVideo()
        panda369.type = VideoType.PANDA.ordinal
        panda369.fileName = "panda_mom_panda369"
        panda369.code = 1455
        panda369.duration = 109
        panda369.period = PeriodType.MOM.ordinal
        panda369.star = false
        panda369.title = "fa姐：二狗，把你的大屁股挪开，小心我坐你哦。【大熊猫和花、润玥】"
        panda369.releaseTime = "2022-02-25 18:45:41"
        panda369.originalUrl = "https://www.bilibili.com/video/BV1D3411L7uW"
        panda369.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda369.authorId = 514531996
        panda369.cover =
            "https://i0.hdslb.com/bfs/archive/e7d224b067573e5f1ac0d8078b5c059b034877ec.jpg"
        list.add(panda369)

        val panda370 = PetVideo()
        panda370.type = VideoType.PANDA.ordinal
        panda370.fileName = "panda_mom_panda370"
        panda370.code = 1456
        panda370.duration = 71
        panda370.period = PeriodType.MOM.ordinal
        panda370.star = false
        panda370.title = "莽仔妈咪揍星猪儿啦（玩耍）"
        panda370.releaseTime = "2022-02-24 12:12:44"
        panda370.originalUrl = "https://www.bilibili.com/video/BV1yL4y1g7AV"
        panda370.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda370.authorId = 66688464
        panda370.cover =
            "https://i0.hdslb.com/bfs/archive/3506796a5e5ac155dc0981429f0652671ccf570e.jpg"
        list.add(panda370)

        val panda371 = PetVideo()
        panda371.type = VideoType.PANDA.ordinal
        panda371.fileName = "panda_mom_panda371"
        panda371.code = 1457
        panda371.duration = 25
        panda371.period = PeriodType.MOM.ordinal
        panda371.star = false
        panda371.title = "事实证明，熊猫是真的很好吸！熊猫妈妈都吸上瘾了！！！"
        panda371.releaseTime = "2020-03-10 13:00:09"
        panda371.originalUrl = "https://www.bilibili.com/video/BV1gE411T7QA"
        panda371.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda371.authorId = 12444306
        panda371.cover =
            "https://i0.hdslb.com/bfs/archive/1aed675dba7f9627fc5663850a8fa24f29884ff3.jpg"
        list.add(panda371)

        val panda372 = PetVideo()
        panda372.type = VideoType.PANDA.ordinal
        panda372.fileName = "panda_mom_panda372"
        panda372.code = 1458
        panda372.duration = 71
        panda372.period = PeriodType.MOM.ordinal
        panda372.star = true
        panda372.title = "操心型熊猫妈妈——珍珍在两个宝宝之间来回跑，宝宝去哪儿就跟到哪儿"
        panda372.releaseTime = "2022-02-23 18:21:54"
        panda372.originalUrl = "https://www.bilibili.com/video/BV1bL411T7p6"
        panda372.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda372.authorId = 19715714
        panda372.cover =
            "https://i0.hdslb.com/bfs/archive/bf0cdf55639486bb5cb5daf7fe436edb74eff8cd.jpg"
        list.add(panda372)

        val panda373 = PetVideo()
        panda373.type = VideoType.PANDA.ordinal
        panda373.fileName = "panda_mom_panda373"
        panda373.code = 1459
        panda373.duration = 77
        panda373.period = PeriodType.MOM.ordinal
        panda373.star = true
        panda373.title = "〖大熊猫和花〗就要贴贴〖大熊猫润玥〗不要贴贴不要贴贴 贴贴是密接"
        panda373.releaseTime = "2022-02-23 14:06:36"
        panda373.originalUrl = "https://www.bilibili.com/video/BV1N34y1k75D"
        panda373.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda373.authorId = 690050620
        panda373.cover =
            "https://i1.hdslb.com/bfs/archive/26dad52b85185c6a49f34d0e862b5ecc07ce2a03.jpg"
        list.add(panda373)

        val panda374 = PetVideo()
        panda374.type = VideoType.PANDA.ordinal
        panda374.fileName = "panda_mom_panda374"
        panda374.code = 1460
        panda374.duration = 64
        panda374.period = PeriodType.MOM.ordinal
        panda374.star = true
        panda374.title = "【大熊猫和花】下雨天的旋风甩水花"
        panda374.releaseTime = "2021-10-09 20:34:15"
        panda374.originalUrl = "https://www.bilibili.com/video/BV1sg411F7an"
        panda374.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda374.authorId = 230382720
        panda374.cover =
            "https://i2.hdslb.com/bfs/archive/b92cb25edfb6a97e9252ae56962c87f7e40114fd.jpg"
        list.add(panda374)

        val panda375 = PetVideo()
        panda375.type = VideoType.PANDA.ordinal
        panda375.fileName = "panda_mom_panda375"
        panda375.code = 1461
        panda375.duration = 77
        panda375.period = PeriodType.MOM.ordinal
        panda375.star = false
        panda375.title = "【思缘】带娃是件烦心事"
        panda375.releaseTime = "2021-03-24 14:25:12"
        panda375.originalUrl = "https://www.bilibili.com/video/BV1q64y1U7Mq"
        panda375.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda375.authorId = 12444306
        panda375.cover =
            "https://i0.hdslb.com/bfs/archive/5044efc0985d79d290680a4e10364bb540f9e89a.jpg"
        list.add(panda375)

        val panda376 = PetVideo()
        panda376.type = VideoType.PANDA.ordinal
        panda376.fileName = "panda_mom_panda376"
        panda376.code = 1462
        panda376.duration = 218
        panda376.period = PeriodType.MOM.ordinal
        panda376.star = true
        panda376.title = "【大熊猫】梦梦的两个调皮鬼儿子，弟弟最皮了"
        panda376.releaseTime = "2020-03-12 16:06:16"
        panda376.originalUrl = "https://www.bilibili.com/video/BV13E411L7rZ"
        panda376.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda376.authorId = 16791067
        panda376.cover =
            "https://i0.hdslb.com/bfs/archive/7245c6c54f806880099510231a327397ff55a47f.jpg"
        list.add(panda376)

        val panda377 = PetVideo()
        panda377.type = VideoType.PANDA.ordinal
        panda377.fileName = "panda_mom_panda377"
        panda377.code = 1463
        panda377.duration = 59
        panda377.period = PeriodType.MOM.ordinal
        panda377.star = true
        panda377.title =
            "柏林动物园‖梦想和梦圆跟梦梦妈咪的个头一样大了"
        panda377.releaseTime = "2021-08-24 14:54:33"
        panda377.originalUrl = "https://www.bilibili.com/video/BV1FL4y1Y7Wm"
        panda377.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda377.authorId = 35624778
        panda377.cover =
            "https://i0.hdslb.com/bfs/archive/bf2dbb394de49fcc00a36af8582e4582f04be540.jpg"
        list.add(panda377)

        val panda378 = PetVideo()
        panda378.type = VideoType.PANDA.ordinal
        panda378.fileName = "panda_mom_panda378"
        panda378.code = 1464
        panda378.duration = 56
        panda378.period = PeriodType.MOM.ordinal
        panda378.star = false
        panda378.title = "【柏林动物园】梦梦和儿子梦想梦圆"
        panda378.releaseTime = "2020-02-29 23:24:17"
        panda378.originalUrl = "https://www.bilibili.com/video/BV1PE411J7Lh"
        panda378.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda378.authorId = 113647100
        panda378.cover =
            "https://i1.hdslb.com/bfs/archive/4fe17cec4c288a820af75ef0c3af755373e1a608.jpg"
        list.add(panda378)

        val panda379 = PetVideo()
        panda379.type = VideoType.PANDA.ordinal
        panda379.fileName = "panda_mom_panda379"
        panda379.code = 1465
        panda379.duration = 81
        panda379.period = PeriodType.MOM.ordinal
        panda379.star = true
        panda379.title = "【莽仔星星】星猪儿：妈咪妈咪，我要爬妈妈山"
        panda379.releaseTime = "2022-02-21 12:28:49"
        panda379.originalUrl = "https://www.bilibili.com/video/BV1XR4y1L7Ld"
        panda379.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda379.authorId = 66688464
        panda379.cover =
            "https://i0.hdslb.com/bfs/archive/101e7fce820338e852e4176445014f302b92a967.jpg"
        list.add(panda379)

        val panda380 = PetVideo()
        panda380.type = VideoType.PANDA.ordinal
        panda380.fileName = "panda_mom_panda380"
        panda380.code = 1466
        panda380.duration = 55
        panda380.period = PeriodType.MOM.ordinal
        panda380.star = false
        panda380.title = "【莽星星莽辰辰】莽仔麻麻终于支棱起来了！强烈要求把过肩摔麻麻爱，统统都给熊孩子来一套！"
        panda380.releaseTime = "2022-02-03 19:23:38"
        panda380.originalUrl = "https://www.bilibili.com/video/BV1L3411J7je"
        panda380.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda380.authorId = 180602305
        panda380.cover =
            "https://i0.hdslb.com/bfs/archive/974640100853d262c34bc9cb34ad1d0ebcaa7640.jpg"
        list.add(panda380)

        val panda381 = PetVideo()
        panda381.type = VideoType.PANDA.ordinal
        panda381.fileName = "panda_mom_panda381"
        panda381.code = 1467
        panda381.duration = 114
        panda381.period = PeriodType.MOM.ordinal
        panda381.star = false
        panda381.title = "最后一次见奇福也不过数天"
        panda381.releaseTime = "2022-02-16 19:03:11"
        panda381.originalUrl = "https://www.bilibili.com/video/BV1L34y1C7Zy"
        panda381.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda381.authorId = 19715714
        panda381.cover =
            "https://i2.hdslb.com/bfs/archive/d0ed75916b4506c744543e6018de0c78e59d8c6e.jpg"
        list.add(panda381)

        val panda382 = PetVideo()
        panda382.type = VideoType.PANDA.ordinal
        panda382.fileName = "panda_mom_panda382"
        panda382.code = 1468
        panda382.duration = 36
        panda382.period = PeriodType.MOM.ordinal
        panda382.star = true
        panda382.title = "【莽辰辰】辰猪儿屁颠屁颠的跟着饲养员走"
        panda382.releaseTime = "2022-02-19 11:04:27"
        panda382.originalUrl = "https://www.bilibili.com/video/BV1344y1n7iQ"
        panda382.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda382.authorId = 66688464
        panda382.cover =
            "https://i0.hdslb.com/bfs/archive/fcea5730ce69b1733ad66d191201d0d6f0ffc634.jpg"
        list.add(panda382)

        val panda383 = PetVideo()
        panda383.type = VideoType.PANDA.ordinal
        panda383.fileName = "panda_mom_panda383"
        panda383.code = 1469
        panda383.duration = 208
        panda383.period = PeriodType.MOM.ordinal
        panda383.star = true
        panda383.title = "【莽星星莽辰辰】麻麻现在已经懒得劝架了…"
        panda383.releaseTime = "2022-02-02 19:33:06"
        panda383.originalUrl = "https://www.bilibili.com/video/BV1nP4y1A7Aw"
        panda383.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda383.authorId = 180602305
        panda383.cover =
            "https://i1.hdslb.com/bfs/archive/7d7206ebaee39bb168a756bdff1dbf10cbf822e1.jpg"
        list.add(panda383)

        val panda384 = PetVideo()
        panda384.type = VideoType.PANDA.ordinal
        panda384.fileName = "panda_mom_panda384"
        panda384.code = 1470
        panda384.duration = 302
        panda384.period = PeriodType.MOM.ordinal
        panda384.star = false
        panda384.title = "【奇珍奇宝】好奇在外场帮姐姐熊排便，出门也是先找姐姐熊，很好的安抚了她的情绪，姐姐熊今天还蹦蹦跳跳想爬树，表现超棒！"
        panda384.releaseTime = "2022-02-15 20:21:37"
        panda384.originalUrl = "https://www.bilibili.com/video/BV1y341177Fx"
        panda384.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda384.authorId = 180602305
        panda384.cover =
            "https://i0.hdslb.com/bfs/archive/7d1a95e27f952bf63d9b77958550d5e65b787bd4.jpg"
        list.add(panda384)

        val panda385 = PetVideo()
        panda385.type = VideoType.PANDA.ordinal
        panda385.fileName = "panda_mom_panda385"
        panda385.code = 1471
        panda385.duration = 87
        panda385.period = PeriodType.MOM.ordinal
        panda385.star = false
        panda385.title = "【重庆动物园】星星辰辰：走，一起rua妈咪"
        panda385.releaseTime = "2022-02-17 12:10:05"
        panda385.originalUrl = "https://www.bilibili.com/video/BV1jF411E7ny"
        panda385.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda385.authorId = 66688464
        panda385.cover =
            "https://i0.hdslb.com/bfs/archive/6000874af51607bd32ca895e3c77fab0847be64a.jpg"
        list.add(panda385)

        val panda386 = PetVideo()
        panda386.type = VideoType.PANDA.ordinal
        panda386.fileName = "panda_mom_panda386"
        panda386.code = 1472
        panda386.duration = 30
        panda386.period = PeriodType.MOM.ordinal
        panda386.star = false
        panda386.title = "【和花】我框都准备好了！熊猫呢？"
        panda386.releaseTime = "2022-02-16 10:30:05"
        panda386.originalUrl = "https://www.bilibili.com/video/BV1fS4y1G7nB"
        panda386.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda386.authorId = 1887387895
        panda386.cover =
            "https://i1.hdslb.com/bfs/archive/61fd3f26c2a2d0f8e300e86362f6e714a9402617.jpg"
        list.add(panda386)

        val panda387 = PetVideo()
        panda387.type = VideoType.PANDA.ordinal
        panda387.fileName = "panda_mom_panda387"
        panda387.code = 1473
        panda387.duration = 77
        panda387.period = PeriodType.MOM.ordinal
        panda387.star = false
        panda387.title = "帼平平：雪地里最适合滚娃了"
        panda387.releaseTime = "2022-01-31 12:41:53"
        panda387.originalUrl = "https://www.bilibili.com/video/BV16L4y1W7gY"
        panda387.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda387.authorId = 19715714
        panda387.cover =
            "https://i1.hdslb.com/bfs/archive/59e22a54df8a7cc4e7305fda72fe30779a8a1525.jpg"
        list.add(panda387)

        val panda388 = PetVideo()
        panda388.type = VideoType.PANDA.ordinal
        panda388.fileName = "panda_mom_panda388"
        panda388.code = 1474
        panda388.duration = 64
        panda388.period = PeriodType.MOM.ordinal
        panda388.star = true
        panda388.title = "【大熊猫莽仔】吾儿虽叛逆，但可爱！"
        panda388.releaseTime = "2021-11-27 20:55:07"
        panda388.originalUrl = "https://www.bilibili.com/video/BV1NP4y1V7Jr"
        panda388.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda388.authorId = 180602305
        panda388.cover =
            "https://i2.hdslb.com/bfs/archive/13bd6ca7cfb6906f774c4ec272d66ace0d0f0574.jpg"
        list.add(panda388)

        val panda389 = PetVideo()
        panda389.type = VideoType.PANDA.ordinal
        panda389.fileName = "panda_mom_panda389"
        panda389.code = 1475
        panda389.duration = 45
        panda389.period = PeriodType.MOM.ordinal
        panda389.star = false
        panda389.title = "和花：快 说！我 们 俩 谁 更 可 爱？"
        panda389.releaseTime = "2021-09-04 18:22:51"
        panda389.originalUrl = "https://www.bilibili.com/video/BV1gA411w7zm"
        panda389.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda389.authorId = 476733832
        panda389.cover =
            "https://i2.hdslb.com/bfs/archive/fda2d9f6b956b46fcc33266f4724bf5a9d850e55.jpg"
        list.add(panda389)

        val panda390 = PetVideo()
        panda390.type = VideoType.PANDA.ordinal
        panda390.fileName = "panda_mom_panda390"
        panda390.code = 1476
        panda390.duration = 47
        panda390.period = PeriodType.MOM.ordinal
        panda390.star = true
        panda390.title = "【大熊猫和花】太过分了，居然坐熊身上"
        panda390.releaseTime = "2022-02-15 12:05:22"
        panda390.originalUrl = "https://www.bilibili.com/video/BV15R4y1L7Wo"
        panda390.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda390.authorId = 479589264
        panda390.cover =
            "https://i0.hdslb.com/bfs/archive/ff71b07a76326797dc5874d4f6c88bfbb0073d3f.jpg"
        list.add(panda390)

        val panda391 = PetVideo()
        panda391.type = VideoType.PANDA.ordinal
        panda391.fileName = "panda_mom_panda391"
        panda391.code = 1477
        panda391.duration = 40
        panda391.period = PeriodType.MOM.ordinal
        panda391.star = true
        panda391.title = "元宵节到了，和花汤圆了解一下"
        panda391.releaseTime = "2022-02-15 17:33:06"
        panda391.originalUrl = "https://www.bilibili.com/video/BV1nP4y1w7Dk"
        panda391.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda391.authorId = 1307515
        panda391.cover =
            "https://i1.hdslb.com/bfs/archive/27aaecf0f5a4c0b0a07fbbaeb6d153a8c264fa93.jpg"
        list.add(panda391)

        val panda392 = PetVideo()
        panda392.type = VideoType.PANDA.ordinal
        panda392.fileName = "panda_mom_panda392"
        panda392.code = 1478
        panda392.duration = 406
        panda392.period = PeriodType.MOM.ordinal
        panda392.star = false
        panda392.title = "【奇珍奇宝】姐姐熊要回家，好奇不让，一次又一次把孩子叼出来晒太阳！"
        panda392.releaseTime = "2022-02-14 19:32:07"
        panda392.originalUrl = "https://www.bilibili.com/video/BV1BP4y1w7ci"
        panda392.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda392.authorId = 180602305
        panda392.cover =
            "https://i0.hdslb.com/bfs/archive/fabc45da602cebd9e7cddff03e1e1b8d264605d1.jpg"
        list.add(panda392)

        val panda393 = PetVideo()
        panda393.type = VideoType.PANDA.ordinal
        panda393.fileName = "panda_mom_panda393"
        panda393.code = 1479
        panda393.duration = 15
        panda393.period = PeriodType.MOM.ordinal
        panda393.star = true
        panda393.title = "【大熊猫肉肉】这是一只由内到外散发忧郁气质的国宝"
        panda393.releaseTime = "2020-02-21 18:35:37"
        panda393.originalUrl = "https://www.bilibili.com/video/BV127411w7GR"
        panda393.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda393.authorId = 486483424
        panda393.cover =
            "https://i0.hdslb.com/bfs/archive/30d7e710cde5f926b5124f0f3427b185bc9cc0e0.jpg"
        list.add(panda393)

        val panda394 = PetVideo()
        panda394.type = VideoType.PANDA.ordinal
        panda394.fileName = "panda_mom_panda394"
        panda394.code = 1480
        panda394.duration = 157
        panda394.period = PeriodType.MOM.ordinal
        panda394.star = false
        panda394.title = "绩丽：绩笑笑真是烦死个熊了"
        panda394.releaseTime = "2020-10-07 19:46:54"
        panda394.originalUrl = "https://www.bilibili.com/video/BV1oD4y1R7SB"
        panda394.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda394.authorId = 39546503
        panda394.cover =
            "https://i1.hdslb.com/bfs/archive/1d2e2e5fb9011b02d28d452843916b989c2ecf07.jpg"
        list.add(panda394)

        val panda395 = PetVideo()
        panda395.type = VideoType.PANDA.ordinal
        panda395.fileName = "panda_mom_panda395"
        panda395.code = 1481
        panda395.duration = 292
        panda395.period = PeriodType.MOM.ordinal
        panda395.star = true
        panda395.title = "【绩笑】和妈妈排排坐，吃笋笋"
        panda395.releaseTime = "2020-06-17 16:05:58"
        panda395.originalUrl = "https://www.bilibili.com/video/BV1of4y1y7Fk"
        panda395.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda395.authorId = 39546503
        panda395.cover =
            "https://i0.hdslb.com/bfs/archive/14dc4b849fec01646210fc656dff6222e177409a.jpg"
        list.add(panda395)

        val panda396 = PetVideo()
        panda396.type = VideoType.PANDA.ordinal
        panda396.fileName = "panda_mom_panda396"
        panda396.code = 1482
        panda396.duration = 42
        panda396.period = PeriodType.MOM.ordinal
        panda396.star = false
        panda396.title = "【大熊猫绩丽/绩笑】来，妈妈爱！"
        panda396.releaseTime = "2020-07-27 16:14:24"
        panda396.originalUrl = "https://www.bilibili.com/video/BV1qK411J7DS"
        panda396.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda396.authorId = 32436782
        panda396.cover =
            "https://i1.hdslb.com/bfs/archive/ebaac1567f8f47b103857433df7d00d9225d64df.jpg"
        list.add(panda396)

        val panda397 = PetVideo()
        panda397.type = VideoType.PANDA.ordinal
        panda397.fileName = "panda_mom_panda397"
        panda397.code = 1483
        panda397.duration = 40
        panda397.period = PeriodType.MOM.ordinal
        panda397.star = true
        panda397.title = "【绩笑】笑笑与亲妈日常的正确打开方式？"
        panda397.releaseTime = "2020-06-09 23:02:42"
        panda397.originalUrl = "https://www.bilibili.com/video/BV1fi4y1s7bM"
        panda397.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda397.authorId = 498375076
        panda397.cover =
            "https://i2.hdslb.com/bfs/archive/056067c1be1f82c5d69320aca5c8581907af6067.jpg"
        list.add(panda397)

        val panda398 = PetVideo()
        panda398.type = VideoType.PANDA.ordinal
        panda398.fileName = "panda_mom_panda398"
        panda398.code = 1484
        panda398.duration = 52
        panda398.period = PeriodType.MOM.ordinal
        panda398.star = false
        panda398.title = "【绩笑】只因在视频里多看了你一眼，就像春风走进我心里"
        panda398.releaseTime = "2020-10-09 09:34:23"
        panda398.originalUrl = "https://www.bilibili.com/video/BV11k4y1C767"
        panda398.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda398.authorId = 39546503
        panda398.cover =
            "https://i2.hdslb.com/bfs/archive/607c57c58242af6e2efb5c45011c81052dadc292.jpg"
        list.add(panda398)

        val panda399 = PetVideo()
        panda399.type = VideoType.PANDA.ordinal
        panda399.fileName = "panda_mom_panda399"
        panda399.code = 1485
        panda399.duration = 122
        panda399.period = PeriodType.MOM.ordinal
        panda399.star = true
        panda399.title = "萌三生日特别篇"
        panda399.releaseTime = "2020-08-05 14:44:52"
        panda399.originalUrl = "https://www.bilibili.com/video/BV1fK4y1e7Mu"
        panda399.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda399.authorId = 551961363
        panda399.cover =
            "https://i0.hdslb.com/bfs/archive/bb17dfcb55e942690900fc7ea34c970afc017b89.jpg"
        list.add(panda399)

        val panda400 = PetVideo()
        panda400.type = VideoType.PANDA.ordinal
        panda400.fileName = "panda_mom_panda400"
        panda400.code = 1486
        panda400.duration = 118
        panda400.period = PeriodType.MOM.ordinal
        panda400.star = true
        panda400.title = "萌萌妈妈的烦心儿子"
        panda400.releaseTime = "2020-08-13 15:11:35"
        panda400.originalUrl = "https://www.bilibili.com/video/BV1TT4y177Xd"
        panda400.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda400.authorId = 551961363
        panda400.cover =
            "https://i2.hdslb.com/bfs/archive/abffae405d8266fca289d84df2e52749e4cbf722.jpg"
        list.add(panda400)

        val panda401 = PetVideo()
        panda401.type = VideoType.PANDA.ordinal
        panda401.fileName = "panda_mom_panda401"
        panda401.code = 1487
        panda401.duration = 59
        panda401.period = PeriodType.MOM.ordinal
        panda401.star = false
        panda401.title = "【奇珍奇宝】孩子到底做错了什么？好奇的军事化训练从现在就开始了？"
        panda401.releaseTime = "2022-02-13 20:18:57"
        panda401.originalUrl = "https://www.bilibili.com/video/BV1TZ4y1d7Eu"
        panda401.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda401.authorId = 180602305
        panda401.cover =
            "https://i1.hdslb.com/bfs/archive/85834670bea01e439640740047bc19e84a067ff4.jpg"
        list.add(panda401)

        val panda402 = PetVideo()
        panda402.type = VideoType.PANDA.ordinal
        panda402.fileName = "panda_mom_panda402"
        panda402.code = 1860
        panda402.duration = 203
        panda402.period = PeriodType.MOM.ordinal
        panda402.star = false
        panda402.title = "【奇珍奇宝】好奇多次劝架，给妈妈一个面子！"
        panda402.releaseTime = "2022-03-09 19:30:21"
        panda402.originalUrl = "https://www.bilibili.com/video/BV1gR4y1F7rk"
        panda402.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda402.authorId = 180602305
        panda402.cover =
            "https://i0.hdslb.com/bfs/archive/498992422697dd7b68238fb36e5a5796c457a3c4.jpg"
        list.add(panda402)

        val panda403 = PetVideo()
        panda403.type = VideoType.PANDA.ordinal
        panda403.fileName = "panda_mom_panda403"
        panda403.code = 1861
        panda403.duration = 127
        panda403.period = PeriodType.MOM.ordinal
        panda403.star = false
        panda403.title = "【莽辰辰莽星星】两个偷吃妈妈苹果的臭小孩！"
        panda403.releaseTime = "2022-03-12 19:40:45"
        panda403.originalUrl = "https://www.bilibili.com/video/BV1XL4y1u7hS"
        panda403.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda403.authorId = 180602305
        panda403.cover =
            "https://i2.hdslb.com/bfs/archive/9e54c5fb56992d9a47fec7099308b3fee1691ae9.jpg"
        list.add(panda403)

        val panda404 = PetVideo()
        panda404.type = VideoType.PANDA.ordinal
        panda404.fileName = "panda_mom_panda404"
        panda404.code = 1862
        panda404.duration = 70
        panda404.period = PeriodType.MOM.ordinal
        panda404.star = false
        panda404.title = "福多多玩累上树睡觉了，雅颂还想找福多多继续玩！【大熊猫福多多雅颂】"
        panda404.releaseTime = "2022-03-10 23:30:56"
        panda404.originalUrl = "https://www.bilibili.com/video/BV1eP4y1M73A"
        panda404.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda404.authorId = 627116323
        panda404.cover =
            "https://i0.hdslb.com/bfs/archive/9f95180449ee984864f7c98308438e1dc8d6c14a.png"
        list.add(panda404)

        val panda405 = PetVideo()
        panda405.type = VideoType.PANDA.ordinal
        panda405.fileName = "panda_mom_panda405"
        panda405.code = 1863
        panda405.duration = 75
        panda405.period = PeriodType.MOM.ordinal
        panda405.star = false
        panda405.title = "【大熊猫和花】鼓鼓的小奶包"
        panda405.releaseTime = "2022-03-11 23:07:05"
        panda405.originalUrl = "https://www.bilibili.com/video/BV1ES4y137TG"
        panda405.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda405.authorId = 34677299
        panda405.cover =
            "https://i0.hdslb.com/bfs/archive/a252ae7f522cd920a4be610e99f33f1aa7e8d6f5.jpg"
        list.add(panda405)

        val panda406 = PetVideo()
        panda406.type = VideoType.PANDA.ordinal
        panda406.fileName = "panda_mom_panda406"
        panda406.code = 1864
        panda406.duration = 89
        panda406.period = PeriodType.MOM.ordinal
        panda406.star = false
        panda406.title = "【大熊猫和花】考古视频，和园润第一次出外场，花花闹neinei喝"
        panda406.releaseTime = "2022-03-11 22:30:06"
        panda406.originalUrl = "https://www.bilibili.com/video/BV12b4y1x7hP"
        panda406.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda406.authorId = 98871951
        panda406.cover =
            "https://i1.hdslb.com/bfs/archive/4571c57405c9c8514945e4e8f79d9cb9525d1481.jpg"
        list.add(panda406)

        val panda407 = PetVideo()
        panda407.type = VideoType.PANDA.ordinal
        panda407.fileName = "panda_mom_panda407"
        panda407.code = 1865
        panda407.duration = 140
        panda407.period = PeriodType.MOM.ordinal
        panda407.star = false
        panda407.title = "【大熊猫莽仔】这就是生双胞胎的快乐吗？一个啃手，一个啃脚"
        panda407.releaseTime = "2022-03-11 17:12:04"
        panda407.originalUrl = "https://www.bilibili.com/video/BV1tS4y1S7YF"
        panda407.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda407.authorId = 34677299
        panda407.cover =
            "https://i2.hdslb.com/bfs/archive/72bdab11155442aecf46dc66fdd7ce0d4c02cef6.jpg"
        list.add(panda407)

        val panda408 = PetVideo()
        panda408.type = VideoType.PANDA.ordinal
        panda408.fileName = "panda_mom_panda408"
        panda408.code = 1866
        panda408.duration = 34
        panda408.period = PeriodType.MOM.ordinal
        panda408.star = false
        panda408.title = "【莽星星莽辰辰】莽星星标记妈妈"
        panda408.releaseTime = "2022-03-07 18:43:40"
        panda408.originalUrl = "https://www.bilibili.com/video/BV1XT4y1S7tn"
        panda408.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda408.authorId = 180602305
        panda408.cover =
            "https://i0.hdslb.com/bfs/archive/1835f2c508ed859d895437af40bcd12639676a9b.jpg"
        list.add(panda408)

        val panda409 = PetVideo()
        panda409.type = VideoType.PANDA.ordinal
        panda409.fileName = "panda_mom_panda409"
        panda409.code = 1867
        panda409.duration = 71
        panda409.period = PeriodType.MOM.ordinal
        panda409.star = false
        panda409.title = "辰猪儿：妈咪锅锅你们过去rua，我要睡告告呢"
        panda409.releaseTime = "2022-03-10 12:44:32"
        panda409.originalUrl = "https://www.bilibili.com/video/BV15r4y1B7zw"
        panda409.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda409.authorId = 66688464
        panda409.cover =
            "https://i2.hdslb.com/bfs/archive/79de5c1ed8222bdda64555b7d993a70166f42715.jpg"
        list.add(panda409)

        val panda410 = PetVideo()
        panda410.type = VideoType.PANDA.ordinal
        panda410.fileName = "panda_mom_panda410"
        panda410.code = 1868
        panda410.duration = 127
        panda410.period = PeriodType.MOM.ordinal
        panda410.star = false
        panda410.title = "【大熊猫和花.园润】和花，园润吃笋笋（记录那些旧时光～"
        panda410.releaseTime = "2022-03-10 13:11:30"
        panda410.originalUrl = "https://www.bilibili.com/video/BV1iP4y1M7NJ"
        panda410.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda410.authorId = 16468440
        panda410.cover =
            "https://i2.hdslb.com/bfs/archive/2e7e483f357ddcbf4af79b2c4ce55a90e41d4d85.png"
        list.add(panda410)

        val panda411 = PetVideo()
        panda411.type = VideoType.PANDA.ordinal
        panda411.fileName = "panda_mom_panda411"
        panda411.code = 1869
        panda411.duration = 102
        panda411.period = PeriodType.MOM.ordinal
        panda411.star = false
        panda411.title = "【大熊猫】萌兰庆大神烦萌萌"
        panda411.releaseTime = "2018-01-19 17:36:58"
        panda411.originalUrl = "https://www.bilibili.com/video/BV1iW411v7qn"
        panda411.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda411.authorId = 1370008
        panda411.cover =
            "https://i2.hdslb.com/bfs/archive/bd3fc7dbe97e8ac6b4a06f30ac68206240797b82.jpg"
        list.add(panda411)

        val panda412 = PetVideo()
        panda412.type = VideoType.PANDA.ordinal
        panda412.fileName = "panda_mom_panda412"
        panda412.code = 1870
        panda412.duration = 138
        panda412.period = PeriodType.MOM.ordinal
        panda412.star = false
        panda412.title = "妈妈正吃笋，萌三冲过来，结果被夹头，后来还被庆大扁，妈妈不帮也就算了，还来一口"
        panda412.releaseTime = "2016-11-15 22:06:02"
        panda412.originalUrl = "https://www.bilibili.com/video/BV1Es411W7q3"
        panda412.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda412.authorId = 4038416
        panda412.cover =
            "https://i2.hdslb.com/bfs/archive/e756fc8eace5f28f526da4214057f68d33a50201.jpg"
        list.add(panda412)

        val panda413 = PetVideo()
        panda413.type = VideoType.PANDA.ordinal
        panda413.fileName = "panda_mom_panda413"
        panda413.code = 1871
        panda413.duration = 58
        panda413.period = PeriodType.MOM.ordinal
        panda413.star = false
        panda413.title = "大熊猫昭美：这是个操碎了心的妈"
        panda413.releaseTime = "2022-03-07 22:30:01"
        panda413.originalUrl = "https://www.bilibili.com/video/BV1qR4y157S5"
        panda413.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda413.authorId = 98871951
        panda413.cover =
            "https://i0.hdslb.com/bfs/archive/ec4e7786f8af80dd7662f22b59e6ac601653839f.jpg"
        list.add(panda413)

        val panda414 = PetVideo()
        panda414.type = VideoType.PANDA.ordinal
        panda414.fileName = "panda_mom_panda414"
        panda414.code = 1872
        panda414.duration = 117
        panda414.period = PeriodType.MOM.ordinal
        panda414.star = false
        panda414.title = "【大熊猫莽仔】莽小崽喝neinei"
        panda414.releaseTime = "2021-11-24 19:10:45"
        panda414.originalUrl = "https://www.bilibili.com/video/BV1Wr4y1Q7fo"
        panda414.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda414.authorId = 180602305
        panda414.cover =
            "https://i1.hdslb.com/bfs/archive/cafa66543c88428b71e863e529e00e1d3419f4a1.jpg"
        list.add(panda414)

        val panda415 = PetVideo()
        panda415.type = VideoType.PANDA.ordinal
        panda415.fileName = "panda_mom_panda415"
        panda415.code = 1873
        panda415.duration = 64
        panda415.period = PeriodType.MOM.ordinal
        panda415.star = false
        panda415.title = "【重庆动物园】莽仔：儿呀，快过来妈咪啃两口"
        panda415.releaseTime = "2022-03-09 12:27:53"
        panda415.originalUrl = "https://www.bilibili.com/video/BV1La411b741"
        panda415.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda415.authorId = 66688464
        panda415.cover =
            "https://i2.hdslb.com/bfs/archive/d10c315b994e4781724fcae748661caf8e7e4b82.jpg"
        list.add(panda415)

        val panda416 = PetVideo()
        panda416.type = VideoType.PANDA.ordinal
        panda416.fileName = "panda_mom_panda416"
        panda416.code = 1874
        panda416.duration = 72
        panda416.period = PeriodType.MOM.ordinal
        panda416.star = false
        panda416.title = "不要说大鸭梨只认自己亲生的，姨妈很爱多多的。【大熊猫雅莉、福多多、雅颂】"
        panda416.releaseTime = "2022-03-09 20:54:41"
        panda416.originalUrl = "https://www.bilibili.com/video/BV1kL4y1u7co"
        panda416.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda416.authorId = 514531996
        panda416.cover =
            "https://i1.hdslb.com/bfs/archive/45e624aaf207a4c359bb50b544579c491b75b8b6.jpg"
        list.add(panda416)

        val panda417 = PetVideo()
        panda417.type = VideoType.PANDA.ordinal
        panda417.fileName = "panda_mom_panda417"
        panda417.code = 1875
        panda417.duration = 139
        panda417.period = PeriodType.MOM.ordinal
        panda417.star = false
        panda417.title = "莽辰辰：奶爸，莽星星不回去我回去，抱我！"
        panda417.releaseTime = "2022-03-09 22:00:21"
        panda417.originalUrl = "https://www.bilibili.com/video/BV1Ha411b7qe"
        panda417.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda417.authorId = 34677299
        panda417.cover =
            "https://i1.hdslb.com/bfs/archive/35ed40d902ef571996a7a3a048ab9c74027ad474.jpg"
        list.add(panda417)

        val panda418 = PetVideo()
        panda418.type = VideoType.PANDA.ordinal
        panda418.fileName = "panda_mom_panda418"
        panda418.code = 1876
        panda418.duration = 188
        panda418.period = PeriodType.MOM.ordinal
        panda418.star = false
        panda418.title = "【莽星星莽辰辰】今天是钮钴禄·莽仔！"
        panda418.releaseTime = "2022-02-14 20:08:39"
        panda418.originalUrl = "https://www.bilibili.com/video/BV1yY411L7ua"
        panda418.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda418.authorId = 180602305
        panda418.cover =
            "https://i2.hdslb.com/bfs/archive/dcd7fea85d3c6ab2544cffc23fb74a01f1835349.jpg"
        list.add(panda418)

        val panda419 = PetVideo()
        panda419.type = VideoType.PANDA.ordinal
        panda419.fileName = "panda_mom_panda419"
        panda419.code = 1877
        panda419.duration = 205
        panda419.period = PeriodType.MOM.ordinal
        panda419.star = false
        panda419.title = "【莽星星莽辰辰】好奇申请出战！丁丁申请出战！良月申请…（良月你坐下）"
        panda419.releaseTime = "2022-03-08 22:02:36"
        panda419.originalUrl = "https://www.bilibili.com/video/BV1sb4y1W7No"
        panda419.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda419.authorId = 180602305
        panda419.cover =
            "https://i0.hdslb.com/bfs/archive/3e1b385396daf5a2235f6de65b9109eb5411b140.jpg"
        list.add(panda419)

        val panda420 = PetVideo()
        panda420.type = VideoType.PANDA.ordinal
        panda420.fileName = "panda_mom_panda420"
        panda420.code = 1878
        panda420.duration = 182
        panda420.period = PeriodType.MOM.ordinal
        panda420.star = false
        panda420.title = "【奇珍奇宝】两个崽太好笑了，一言不合打起来了，最后还一起打妈妈（好奇：莫影响老娘吃饭！）"
        panda420.releaseTime = "2022-03-07 19:51:02"
        panda420.originalUrl = "https://www.bilibili.com/video/BV1Ar4y1B7Qn"
        panda420.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda420.authorId = 180602305
        panda420.cover =
            "https://i2.hdslb.com/bfs/archive/78bf8cc254aa307e594376fe9c9600eabb629c47.jpg"
        list.add(panda420)

        val panda421 = PetVideo()
        panda421.type = VideoType.PANDA.ordinal
        panda421.fileName = "panda_mom_panda421"
        panda421.code = 1879
        panda421.duration = 64
        panda421.period = PeriodType.MOM.ordinal
        panda421.star = false
        panda421.title = "雅颂：多多救我，我妈吃小孩了。【大熊猫雅颂、雅莉、福多多】"
        panda421.releaseTime = "2022-03-07 21:22:06"
        panda421.originalUrl = "https://www.bilibili.com/video/BV1Qq4y1v7vh"
        panda421.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda421.authorId = 514531996
        panda421.cover =
            "https://i2.hdslb.com/bfs/archive/f7d9d924910f60c62e79e7d7c92ce5dd51d8a966.jpg"
        list.add(panda421)

        val panda422 = PetVideo()
        panda422.type = VideoType.PANDA.ordinal
        panda422.fileName = "panda_mom_panda422"
        panda422.code = 1880
        panda422.duration = 51
        panda422.period = PeriodType.MOM.ordinal
        panda422.star = false
        panda422.title = "【大熊猫昭美-金宵-轮辉】熊猫母子园的温馨时光"
        panda422.releaseTime = "2022-03-06 23:59:43"
        panda422.originalUrl = "https://www.bilibili.com/video/BV14S4y1S7ey"
        panda422.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda422.authorId = 18329821
        panda422.cover =
            "https://i2.hdslb.com/bfs/archive/37bb5505e261a258769b978ad5c49d07a199af19.jpg"
        list.add(panda422)

        val panda423 = PetVideo()
        panda423.type = VideoType.PANDA.ordinal
        panda423.fileName = "panda_mom_panda423"
        panda423.code = 1881
        panda423.duration = 70
        panda423.period = PeriodType.MOM.ordinal
        panda423.star = true
        panda423.title = "温馨治愈系～熊猫妈妈昭美照顾两个宝宝睡觉觉【大熊猫昭美轮辉金宵】"
        panda423.releaseTime = "2022-03-07 00:35:52"
        panda423.originalUrl = "https://www.bilibili.com/video/BV1Mr4y1B7AA"
        panda423.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda423.authorId = 627116323
        panda423.cover =
            "https://i1.hdslb.com/bfs/archive/8363873e426c4bafbfa399b34deeda7f3e18f8a7.jpg"
        list.add(panda423)

        return list
    }
}