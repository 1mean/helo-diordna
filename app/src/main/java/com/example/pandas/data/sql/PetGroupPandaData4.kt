package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetGroupPandaData4 {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {
        getPandaData()
        return list
    }

    private fun getPandaData() {

        val panda746 = PetVideo()
        panda746.type = VideoType.PANDA.ordinal
        panda746.fileName = "panda_group_panda746"
        panda746.code = 2658
        panda746.duration = 187
        panda746.period = PeriodType.GROUP.ordinal
        panda746.star = false
        panda746.vertical = true
        panda746.title = "昨天是和花和叶的生日，也是萌兰么么儿的生日"
        panda746.releaseTime = 1656993357
        panda746.originalUrl = "https://www.bilibili.com/video/BV1VG411W79o"
        panda746.tags = "大熊猫,萌宠,动物圈"
        panda746.authorId = 1025949925
        panda746.cover =
            "https://i2.hdslb.com/bfs/archive/015c1e25ef9e8a395de46a74129c50e5505478d5.jpg"
        list.add(panda746)

        val panda747 = PetVideo()
        panda747.type = VideoType.PANDA.ordinal
        panda747.fileName = "panda_group_panda747"
        panda747.code = 2659
        panda747.duration = 124
        panda747.period = PeriodType.GROUP.ordinal
        panda747.star = false
        panda747.vertical = true
        panda747.title = "你就让人家吃一口嘛【和花】"
        panda747.releaseTime = 1657077917
        panda747.originalUrl = "https://www.bilibili.com/video/BV1Aa41197Kz"
        panda747.tags = "大熊猫,萌宠,动物圈"
        panda747.authorId = 1025949925
        panda747.cover =
            "https://i1.hdslb.com/bfs/archive/9a75bab4cfb3899d74795de6cfaee4c42c729400.jpg"
        list.add(panda747)

        val panda748 = PetVideo()
        panda748.type = VideoType.PANDA.ordinal
        panda748.fileName = "panda_group_panda748"
        panda748.code = 2660
        panda748.duration = 159
        panda748.period = PeriodType.GROUP.ordinal
        panda748.star = false
        panda748.title = "【大熊猫和花&和叶】和花在木架上无聊，和叶爬上来陪姐姐，非常温馨。祝你们2岁生日快乐！一平安快乐成长！（配乐：舒曼《童年情景-梦幻曲》）"
        panda748.releaseTime = 1656860356
        panda748.originalUrl = "https://www.bilibili.com/video/BV1of4y1o7Gx"
        panda748.tags = "大熊猫,萌宠,动物圈"
        panda748.authorId = 542836361
        panda748.cover =
            "https://i2.hdslb.com/bfs/archive/5d556dc85a9d9b1c14b63160216700cd3092c650.jpg"
        list.add(panda748)

        val panda749 = PetVideo()
        panda749.type = VideoType.PANDA.ordinal
        panda749.fileName = "panda_group_panda749"
        panda749.code = 2661
        panda749.duration = 70
        panda749.period = PeriodType.GROUP.ordinal
        panda749.star = false
        panda749.title = "【大熊猫和花和叶】温馨的双胞胎姐弟 生日快乐"
        panda749.releaseTime = 1656932648
        panda749.originalUrl = "https://www.bilibili.com/video/BV1nY4y1E7CM"
        panda749.tags = "大熊猫,萌宠,动物圈"
        panda749.authorId = 327377672
        panda749.cover =
            "https://i0.hdslb.com/bfs/archive/12d919c16d033b0ddb1d1f9428fe7cc1dc754088.jpg"
        list.add(panda749)

        val panda750 = PetVideo()
        panda750.type = VideoType.PANDA.ordinal
        panda750.fileName = "panda_group_panda750"
        panda750.code = 2662
        panda750.duration = 132
        panda750.period = PeriodType.GROUP.ordinal
        panda750.star = false
        panda750.vertical = true
        panda750.title = "谭爷爷沉浸式带大家给和花和叶过生日"
        panda750.releaseTime = 1656919064
        panda750.originalUrl = "https://www.bilibili.com/video/BV1oL4y1w78E"
        panda750.tags = "大熊猫,萌宠,动物圈"
        panda750.authorId = 1025949925
        panda750.cover =
            "https://i0.hdslb.com/bfs/archive/37d3e28bd97d069c2b97c35940bb18d417d4808f.jpg"
        list.add(panda750)

        val panda751 = PetVideo()
        panda751.type = VideoType.PANDA.ordinal
        panda751.fileName = "panda_group_panda751"
        panda751.code = 2663
        panda751.duration = 274
        panda751.period = PeriodType.GROUP.ordinal
        panda751.star = false
        panda751.title = "和花试玩新玩具【大熊猫和花】"
        panda751.releaseTime = 1656920576
        panda751.originalUrl = "https://www.bilibili.com/video/BV1FT411G7oT"
        panda751.tags = "大熊猫,萌宠,动物圈"
        panda751.authorId = 230382720
        panda751.cover =
            "https://i1.hdslb.com/bfs/archive/8f2fa348585ee3f9b54ce79a7a57a7b1302e601e.jpg"
        list.add(panda751)

        val panda752 = PetVideo()
        panda752.type = VideoType.PANDA.ordinal
        panda752.fileName = "panda_group_panda752"
        panda752.code = 2664
        panda752.duration = 11
        panda752.period = PeriodType.GROUP.ordinal
        panda752.star = false
        panda752.title = "【大熊猫和花】救命啊！我又被绑架了！（谭爷爷给和花测体重，和花才38公斤）"
        panda752.releaseTime = 1647003520
        panda752.originalUrl = "https://www.bilibili.com/video/BV15b4y1s7yg"
        panda752.tags = "大熊猫,萌宠,动物圈"
        panda752.authorId = 2041280462
        panda752.cover =
            "https://i1.hdslb.com/bfs/archive/392d2b085b87ff3522205386bc2ac2360ae24e44.jpg"
        list.add(panda752)

        val panda753 = PetVideo()
        panda753.type = VideoType.PANDA.ordinal
        panda753.fileName = "panda_group_panda753"
        panda753.code = 2665
        panda753.duration = 54
        panda753.period = PeriodType.GROUP.ordinal
        panda753.star = false
        panda753.title = "和花和叶，今天就两岁啦！生日快乐！"
        panda753.releaseTime = 1656867169
        panda753.originalUrl = "https://www.bilibili.com/video/BV1tf4y1Z7Lr"
        panda753.tags = "大熊猫,萌宠,动物圈"
        panda753.authorId = 484440897
        panda753.cover =
            "https://i1.hdslb.com/bfs/archive/4a082717612ce85c1698bf664d2c43d0502c4935.jpg"
        list.add(panda753)

        val panda754 = PetVideo()
        panda754.type = VideoType.PANDA.ordinal
        panda754.fileName = "panda_group_panda754"
        panda754.code = 2666
        panda754.duration = 31
        panda754.period = PeriodType.GROUP.ordinal
        panda754.star = false
        panda754.title = "大熊猫和花-奶爸，和花也想吃果果"
        panda754.releaseTime = 1656839817
        panda754.originalUrl = "https://www.bilibili.com/video/BV1bB4y1H7Zr"
        panda754.tags = "大熊猫,萌宠,动物圈"
        panda754.authorId = 1307515
        panda754.cover =
            "https://i0.hdslb.com/bfs/archive/b831168ee52b05f6b1ff7b7b609256a9fade4ddd.jpg"
        list.add(panda754)

        val panda755 = PetVideo()
        panda755.type = VideoType.PANDA.ordinal
        panda755.fileName = "panda_group_panda755"
        panda755.code = 2667
        panda755.duration = 156
        panda755.period = PeriodType.GROUP.ordinal
        panda755.star = false
        panda755.vertical = true
        panda755.title = "和花上树找二狗单挑：迪迪你下去，我自己上"
        panda755.releaseTime = 1656827564
        panda755.originalUrl = "https://www.bilibili.com/video/BV1W34y1p7hE"
        panda755.tags = "大熊猫,萌宠,动物圈"
        panda755.authorId = 34677299
        panda755.cover =
            "https://i2.hdslb.com/bfs/archive/e5378032eb89be54a9177c51d87486b9b055f262.jpg"
        list.add(panda755)

        val panda756 = PetVideo()
        panda756.type = VideoType.PANDA.ordinal
        panda756.fileName = "panda_group_panda756"
        panda756.code = 2668
        panda756.duration = 44
        panda756.period = PeriodType.GROUP.ordinal
        panda756.star = false
        panda756.title = "【四喜丸子】兰虫虫：大家好，我是四喜丸子的C位和颜值担当，下面给大家表演一个“吃西瓜不吐葡萄皮，不吃西瓜倒吐葡萄皮”"
        panda756.releaseTime = 1654943735
        panda756.originalUrl = "https://www.bilibili.com/video/BV1dt4y1H7Fk"
        panda756.tags = "大熊猫,萌宠,动物圈"
        panda756.authorId = 180602305
        panda756.cover =
            "https://i1.hdslb.com/bfs/archive/e2ff56407a79cc01d9f8cbb3ddba477ba0c613fb.jpg"
        list.add(panda756)

        val panda757 = PetVideo()
        panda757.type = VideoType.PANDA.ordinal
        panda757.fileName = "panda_group_panda757"
        panda757.code = 2669
        panda757.duration = 251
        panda757.period = PeriodType.GROUP.ordinal
        panda757.star = false
        panda757.title = "【大熊猫和花】和花的后腿站立训练课，含腿量高"
        panda757.releaseTime = 1648980224
        panda757.originalUrl = "https://www.bilibili.com/video/BV1rY411J7uJ"
        panda757.tags = "大熊猫,萌宠,动物圈"
        panda757.authorId = 230382720
        panda757.cover =
            "https://i0.hdslb.com/bfs/archive/211c5d62e9c9d91f8ea21beebb579a270f845383.jpg"
        list.add(panda757)

        val panda758 = PetVideo()
        panda758.type = VideoType.PANDA.ordinal
        panda758.fileName = "panda_group_panda758"
        panda758.code = 2670
        panda758.duration = 66
        panda758.period = PeriodType.GROUP.ordinal
        panda758.star = false
        panda758.title = "【大熊猫福双】基地分海，聪明机灵的捡漏王"
        panda758.releaseTime = 1656753728
        panda758.originalUrl = "https://www.bilibili.com/video/BV1sB4y1i7PE"
        panda758.tags = "大熊猫,萌宠,动物圈"
        panda758.authorId = 34677299
        panda758.cover =
            "https://i0.hdslb.com/bfs/archive/b3d12d5a82f17cede5d2283e0ab571ccb48dbbd1.jpg"
        list.add(panda758)

        val panda759 = PetVideo()
        panda759.type = VideoType.PANDA.ordinal
        panda759.fileName = "panda_group_panda759"
        panda759.code = 2671
        panda759.duration = 435
        panda759.period = PeriodType.GROUP.ordinal
        panda759.star = false
        panda759.vertical = true
        panda759.title = "熊猫小跟屁虫和花"
        panda759.releaseTime = 1648788669
        panda759.originalUrl = "https://www.bilibili.com/video/BV1o94y1f7gx"
        panda759.tags = "大熊猫,萌宠,动物圈"
        panda759.authorId = 1025949925
        panda759.cover =
            "https://i0.hdslb.com/bfs/archive/87a22109ad0338f991fdf613d3fb11471bf7fbe5.jpg"
        list.add(panda759)

        val panda760 = PetVideo()
        panda760.type = VideoType.PANDA.ordinal
        panda760.fileName = "panda_group_panda760"
        panda760.code = 2672
        panda760.duration = 75
        panda760.period = PeriodType.GROUP.ordinal
        panda760.star = false
        panda760.title = "是哪个小漂亮掰竹子这么厉害，还很听爷爷的话？【大熊猫和花】"
        panda760.releaseTime = 1656683218
        panda760.originalUrl = "https://www.bilibili.com/video/BV1zf4y1o7VF"
        panda760.tags = "大熊猫,萌宠,动物圈"
        panda760.authorId = 514531996
        panda760.cover =
            "https://i0.hdslb.com/bfs/archive/724aaee3d62bb2799c911b623d76925f732a9b41.jpg"
        list.add(panda760)

        val panda761 = PetVideo()
        panda761.type = VideoType.PANDA.ordinal
        panda761.fileName = "panda_group_panda761"
        panda761.code = 2673
        panda761.duration = 63
        panda761.period = PeriodType.GROUP.ordinal
        panda761.star = false
        panda761.title = "可爱暴击，积极营业的和花"
        panda761.releaseTime = 1654523661
        panda761.originalUrl = "https://www.bilibili.com/video/BV1ng41197Ah"
        panda761.tags = "大熊猫,萌宠,动物圈"
        panda761.authorId = 384395600
        panda761.cover =
            "https://i0.hdslb.com/bfs/archive/17a0c78530a680c221cd28c6b697640d53e6c8d8.jpg"
        list.add(panda761)

        val panda762 = PetVideo()
        panda762.type = VideoType.PANDA.ordinal
        panda762.fileName = "panda_group_panda762"
        panda762.code = 2674
        panda762.duration = 73
        panda762.period = PeriodType.GROUP.ordinal
        panda762.star = false
        panda762.title = "《每周集锦》当大熊猫学会了拥抱…"
        panda762.releaseTime = 1509611289
        panda762.originalUrl = "https://www.bilibili.com/video/BV1Hx411E7or"
        panda762.tags = "大熊猫,萌宠,动物圈"
        panda762.authorId = 1998535
        panda762.cover =
            "https://i2.hdslb.com/bfs/archive/be51f3745d719f99ae0bbf8eae8b670aa0aed9e8.jpg"
        list.add(panda762)

        val panda763 = PetVideo()
        panda763.type = VideoType.PANDA.ordinal
        panda763.fileName = "panda_group_panda763"
        panda763.code = 2675
        panda763.duration = 87
        panda763.period = PeriodType.GROUP.ordinal
        panda763.star = false
        panda763.title = "【大熊猫和花】和花 和叶 艾玖（35度的天气和花过来贴贴弟弟，被弟弟嫌弃，艾玖在树上看戏）"
        panda763.releaseTime = 1656475774
        panda763.originalUrl = "https://www.bilibili.com/video/BV1NG411x7iR"
        panda763.tags = "大熊猫,萌宠,动物圈"
        panda763.authorId = 439042524
        panda763.cover =
            "https://i2.hdslb.com/bfs/archive/f103de4c9ea9f6ba6801c5bb0769775027c1aff9.jpg"
        list.add(panda763)

        val panda764 = PetVideo()
        panda764.type = VideoType.PANDA.ordinal
        panda764.fileName = "panda_group_panda764"
        panda764.code = 2676
        panda764.duration = 51
        panda764.period = PeriodType.GROUP.ordinal
        panda764.star = false
        panda764.title = "茱萸：靠着石头吃才巴适"
        panda764.releaseTime = 1656379506
        panda764.originalUrl = "https://www.bilibili.com/video/BV1kT411372v"
        panda764.tags = "大熊猫,萌宠,动物圈"
        panda764.authorId = 442701460
        panda764.cover =
            "https://i0.hdslb.com/bfs/archive/d545e2b853291d3dcf97fa63a9dc74f56f89baa2.jpg"
        list.add(panda764)

        val panda765 = PetVideo()
        panda765.type = VideoType.PANDA.ordinal
        panda765.fileName = "panda_group_panda765"
        panda765.code = 2677
        panda765.duration = 11
        panda765.period = PeriodType.GROUP.ordinal
        panda765.star = false
        panda765.vertical = true
        panda765.title = "谁是和花？我叫果赖呀！"
        panda765.releaseTime = 1656589114
        panda765.originalUrl = "https://www.bilibili.com/video/BV1GF411F7zv"
        panda765.tags = "大熊猫,萌宠,动物圈"
        panda765.authorId = 2037312510
        panda765.cover =
            "https://i1.hdslb.com/bfs/archive/b863367e936192636ac14c037b572382f15372ed.jpg"
        list.add(panda765)

        val panda766 = PetVideo()
        panda766.type = VideoType.PANDA.ordinal
        panda766.fileName = "panda_group_panda766"
        panda766.code = 2678
        panda766.duration = 224
        panda766.period = PeriodType.GROUP.ordinal
        panda766.star = false
        panda766.title = "【大熊猫和花】诸葛花审时度势巧入饭局 ，艾玖惊天破竹抢哭润玥"
        panda766.releaseTime = 1656587701
        panda766.originalUrl = "https://www.bilibili.com/video/BV1kS4y1p7fi"
        panda766.tags = "大熊猫,萌宠,动物圈"
        panda766.authorId = 327377672
        panda766.cover =
            "https://i1.hdslb.com/bfs/archive/6aedc83d5116359b8d73233269a91c7fd12394ae.jpg"
        list.add(panda766)

        val panda767 = PetVideo()
        panda767.type = VideoType.PANDA.ordinal
        panda767.fileName = "panda_group_panda767"
        panda767.code = 2679
        panda767.duration = 222
        panda767.period = PeriodType.GROUP.ordinal
        panda767.star = false
        panda767.title = "这次钓猫不错：金双金喜没抢食成功 都吃到了"
        panda767.releaseTime = 1655034313
        panda767.originalUrl = "https://www.bilibili.com/video/BV1XY4y1G7rE"
        panda767.tags = "大熊猫,萌宠,动物圈"
        panda767.authorId = 442701460
        panda767.cover =
            "https://i0.hdslb.com/bfs/archive/c349493628257691fec35771daa069aa18d981a0.jpg"
        list.add(panda767)

        val panda768 = PetVideo()
        panda768.type = VideoType.PANDA.ordinal
        panda768.fileName = "panda_group_panda768"
        panda768.code = 2680
        panda768.duration = 41
        panda768.period = PeriodType.GROUP.ordinal
        panda768.star = false
        panda768.title = "大熊猫和花-和花已经躲好了，亲妈亲爸们还没找到吗"
        panda768.releaseTime = 1656495155
        panda768.originalUrl = "https://www.bilibili.com/video/BV1hZ4y1e7Ma"
        panda768.tags = "大熊猫,萌宠,动物圈"
        panda768.authorId = 1307515
        panda768.cover =
            "https://i1.hdslb.com/bfs/archive/3958fd4a9358ebc6c69ab0ec42602c7675db88ec.jpg"
        list.add(panda768)

        val panda769 = PetVideo()
        panda769.type = VideoType.PANDA.ordinal
        panda769.fileName = "panda_group_panda769"
        panda769.code = 2681
        panda769.duration = 43
        panda769.period = PeriodType.GROUP.ordinal
        panda769.star = false
        panda769.title = "想拍金喜金双同框吃播 还是妹妹配合"
        panda769.releaseTime = 1656328501
        panda769.originalUrl = "https://www.bilibili.com/video/BV1q3411u7vV"
        panda769.tags = "大熊猫,萌宠,动物圈"
        panda769.authorId = 442701460
        panda769.cover =
            "https://i1.hdslb.com/bfs/archive/29dabed10f9283a839dd3d443def505da0681c79.jpg"
        list.add(panda769)

        val panda770 = PetVideo()
        panda770.type = VideoType.PANDA.ordinal
        panda770.fileName = "panda_group_panda770"
        panda770.code = 2682
        panda770.duration = 70
        panda770.period = PeriodType.GROUP.ordinal
        panda770.star = false
        panda770.title = "【大熊猫和花】真听话，谭爷爷一叫就回去了，就是这四条腿各跑各的，好像都有自己的想法"
        panda770.releaseTime = 1656473270
        panda770.originalUrl = "https://www.bilibili.com/video/BV1zL4y1w73u"
        panda770.tags = "大熊猫,萌宠,动物圈"
        panda770.authorId = 34677299
        panda770.cover =
            "https://i1.hdslb.com/bfs/archive/c3af97f71a0036c647e54dd1bcbdc53051479405.jpg"
        list.add(panda770)

        val panda771 = PetVideo()
        panda771.type = VideoType.PANDA.ordinal
        panda771.fileName = "panda_group_panda771"
        panda771.code = 2683
        panda771.duration = 127
        panda771.period = PeriodType.GROUP.ordinal
        panda771.star = false
        panda771.vertical = true
        panda771.title = "在竞争中成长的和花"
        panda771.releaseTime = 1656474636
        panda771.originalUrl = "https://www.bilibili.com/video/BV1MG411x7YV"
        panda771.tags = "大熊猫,萌宠,动物圈"
        panda771.authorId = 1025949925
        panda771.cover =
            "https://i2.hdslb.com/bfs/archive/c507d53abe47b6119587789b31a0dae64880d54c.jpg"
        list.add(panda771)

        val panda772 = PetVideo()
        panda772.type = VideoType.PANDA.ordinal
        panda772.fileName = "panda_group_panda772"
        panda772.code = 2684
        panda772.duration = 194
        panda772.period = PeriodType.GROUP.ordinal
        panda772.star = false
        panda772.title = "今天爷爷又带苹果来接和花下班喽，和花坐着吃果果，爷爷就一直等着它"
        panda772.releaseTime = 1656482717
        panda772.originalUrl = "https://www.bilibili.com/video/BV17B4y1B7Lm"
        panda772.tags = "大熊猫,萌宠,动物圈"
        panda772.authorId = 98871951
        panda772.cover =
            "https://i0.hdslb.com/bfs/archive/0719f0aa16ffe73afcdcb83f693b5b89796e878f.jpg"
        list.add(panda772)

        val panda773 = PetVideo()
        panda773.type = VideoType.PANDA.ordinal
        panda773.fileName = "panda_group_panda773"
        panda773.code = 2685
        panda773.duration = 107
        panda773.period = PeriodType.GROUP.ordinal
        panda773.star = false
        panda773.title = "为了保住窝头，金叫唤对哥哥使出了小时候的绝技。【大熊猫金双、金喜】"
        panda773.releaseTime = 1656424104
        panda773.originalUrl = "https://www.bilibili.com/video/BV1gY411K7QX"
        panda773.tags = "大熊猫,萌宠,动物圈"
        panda773.authorId = 514531996
        panda773.cover =
            "https://i2.hdslb.com/bfs/archive/fa623d7c605ed88217aa17b5fde1f8682974b7ca.jpg"
        list.add(panda773)

        val panda774 = PetVideo()
        panda774.type = VideoType.PANDA.ordinal
        panda774.fileName = "panda_group_panda774"
        panda774.code = 2686
        panda774.duration = 145
        panda774.period = PeriodType.GROUP.ordinal
        panda774.star = false
        panda774.vertical = true
        panda774.title = "最聪明的熊猫？"
        panda774.releaseTime = 1656386984
        panda774.originalUrl = "https://www.bilibili.com/video/BV1st4y187XV"
        panda774.tags = "大熊猫,萌宠,动物圈"
        panda774.authorId = 1025949925
        panda774.cover =
            "https://i0.hdslb.com/bfs/archive/7486f3915b175d3529582cb388f6fff2339d9f13.jpg"
        list.add(panda774)

        val panda775 = PetVideo()
        panda775.type = VideoType.PANDA.ordinal
        panda775.fileName = "panda_group_panda775"
        panda775.code = 2687
        panda775.duration = 135
        panda775.period = PeriodType.GROUP.ordinal
        panda775.star = false
        panda775.title = "现在是只有谭爷爷收猫，才能看到两分钟的巨星花！听听游客的呼声！【大熊猫和花】"
        panda775.releaseTime = 1656394271
        panda775.originalUrl = "https://www.bilibili.com/video/BV13S4y1n7An"
        panda775.tags = "大熊猫,萌宠,动物圈"
        panda775.authorId = 16468440
        panda775.cover =
            "https://i1.hdslb.com/bfs/archive/9e94395e32509979eafacf32fbf068a4fdb0ce24.jpg"
        list.add(panda775)

        val panda776 = PetVideo()
        panda776.type = VideoType.PANDA.ordinal
        panda776.fileName = "panda_group_panda776"
        panda776.code = 2688
        panda776.duration = 101
        panda776.period = PeriodType.GROUP.ordinal
        panda776.star = false
        panda776.title = "【大熊猫金双】小脸蛋圆溜溜的，很漂亮的小吃货妹妹"
        panda776.releaseTime = 1656332823
        panda776.originalUrl = "https://www.bilibili.com/video/BV1oY411N7j3"
        panda776.tags = "大熊猫,萌宠,动物圈"
        panda776.authorId = 34677299
        panda776.cover =
            "https://i2.hdslb.com/bfs/archive/3f1bec8e409f17597ee9070b8c34eb2fd7f0227c.jpg"
        list.add(panda776)

        val panda777 = PetVideo()
        panda777.type = VideoType.PANDA.ordinal
        panda777.fileName = "panda_group_panda777"
        panda777.code = 2689
        panda777.duration = 76
        panda777.period = PeriodType.GROUP.ordinal
        panda777.star = false
        panda777.title = "和花：听我说谢谢你，我要睡午觉，谁能把活叶带走"
        panda777.releaseTime = 1656338399
        panda777.originalUrl = "https://www.bilibili.com/video/BV1YY411T7ZJ"
        panda777.tags = "大熊猫,萌宠,动物圈"
        panda777.authorId = 98871951
        panda777.cover =
            "https://i1.hdslb.com/bfs/archive/33c93b2220f8fbae58a46422e3e976de5f29172f.jpg"
        list.add(panda777)

        val panda778 = PetVideo()
        panda778.type = VideoType.PANDA.ordinal
        panda778.fileName = "panda_group_panda778"
        panda778.code = 2690
        panda778.duration = 158
        panda778.period = PeriodType.GROUP.ordinal
        panda778.star = false
        panda778.title = "和花边吃苹果，边嘤嘤嘤，独享小苹果，美滋滋【大熊猫和花】"
        panda778.releaseTime = 1656336307
        panda778.originalUrl = "https://www.bilibili.com/video/BV1E94y117Qy"
        panda778.tags = "大熊猫,萌宠,动物圈"
        panda778.authorId = 230382720
        panda778.cover =
            "https://i0.hdslb.com/bfs/archive/eeb8ee7db8c6bfc554e4cf8bc992f07c8c44a488.jpg"
        list.add(panda778)

        val panda779 = PetVideo()
        panda779.type = VideoType.PANDA.ordinal
        panda779.fileName = "panda_group_panda779"
        panda779.code = 2691
        panda779.duration = 76
        panda779.period = PeriodType.GROUP.ordinal
        panda779.star = false
        panda779.title = "嘘，叶师傅正在吸取天地之灵气～！【大熊猫和叶】"
        panda779.releaseTime = 1656323604
        panda779.originalUrl = "https://www.bilibili.com/video/BV1BZ4y1i79Q"
        panda779.tags = "大熊猫,萌宠,动物圈"
        panda779.authorId = 16468440
        panda779.cover =
            "https://i0.hdslb.com/bfs/archive/c9e88e6d2aaf4bda235a60d0c16a3dfb08e256b1.jpg"
        list.add(panda779)

        val panda780 = PetVideo()
        panda780.type = VideoType.PANDA.ordinal
        panda780.fileName = "panda_group_panda780"
        panda780.code = 2692
        panda780.duration = 119
        panda780.period = PeriodType.GROUP.ordinal
        panda780.star = false
        panda780.title = "和花：爷爷，碗洗干净了！谭爷爷：还没有，你看嘛【大熊猫和花】"
        panda780.releaseTime = 1656246444
        panda780.originalUrl = "https://www.bilibili.com/video/BV1TZ4y1e7sv"
        panda780.tags = "大熊猫,萌宠,动物圈"
        panda780.authorId = 230382720
        panda780.cover =
            "https://i0.hdslb.com/bfs/archive/20d8acbeb0d3f63b8170f196b53b55bb80cc9a2e.jpg"
        list.add(panda780)

        val panda781 = PetVideo()
        panda781.type = VideoType.PANDA.ordinal
        panda781.fileName = "panda_group_panda781"
        panda781.code = 2693
        panda781.duration = 67
        panda781.period = PeriodType.GROUP.ordinal
        panda781.star = false
        panda781.title = "福双连续碰瓷想玩，结果金喜一直吃不理，尴尬了走熊"
        panda781.releaseTime = 1656239556
        panda781.originalUrl = "https://www.bilibili.com/video/BV1pT411V7rz"
        panda781.tags = "大熊猫,萌宠,动物圈"
        panda781.authorId = 627116323
        panda781.cover =
            "https://i2.hdslb.com/bfs/archive/e9da419b15192c670d1667d9bac55658a2e551d0.jpg"
        list.add(panda781)

        val panda782 = PetVideo()
        panda782.type = VideoType.PANDA.ordinal
        panda782.fileName = "panda_group_panda782"
        panda782.code = 2694
        panda782.duration = 99
        panda782.period = PeriodType.GROUP.ordinal
        panda782.star = false
        panda782.title = "小叶子，不吃竹子是打不赢“饭扫光”的，你晓得啵?【大熊猫和叶 润玥】"
        panda782.releaseTime = 1656217052
        panda782.originalUrl = "https://www.bilibili.com/video/BV15a411W7fH"
        panda782.tags = "大熊猫,萌宠,动物圈"
        panda782.authorId = 16468440
        panda782.cover =
            "https://i1.hdslb.com/bfs/archive/da12e5561e3f7c364304f39df59f3725f7e5a2fd.jpg"
        list.add(panda782)

        val panda783 = PetVideo()
        panda783.type = VideoType.PANDA.ordinal
        panda783.fileName = "panda_group_panda783"
        panda783.code = 2695
        panda783.duration = 37
        panda783.period = PeriodType.GROUP.ordinal
        panda783.star = false
        panda783.title = "大熊猫和花-你们都别打啦，花主任又要碰瓷啦"
        panda783.releaseTime = 1656233242
        panda783.originalUrl = "https://www.bilibili.com/video/BV1rS4y1H7HR"
        panda783.tags = "大熊猫,萌宠,动物圈"
        panda783.authorId = 1307515
        panda783.cover =
            "https://i1.hdslb.com/bfs/archive/a6ebb08bd32321de829214ad852af2fbf7a80941.jpg"
        list.add(panda783)

        val panda784 = PetVideo()
        panda784.type = VideoType.PANDA.ordinal
        panda784.fileName = "panda_group_panda784"
        panda784.code = 2696
        panda784.duration = 119
        panda784.period = PeriodType.GROUP.ordinal
        panda784.star = false
        panda784.title = "粗线了，传说中的熊猫信号吃播队形！艾灸好温柔，像是在劝润玥把竹子给和和花"
        panda784.releaseTime = 1656142659
        panda784.originalUrl = "https://www.bilibili.com/video/BV1YB4y1p7rC"
        panda784.tags = "大熊猫,萌宠,动物圈"
        panda784.authorId = 230382720
        panda784.cover =
            "https://i1.hdslb.com/bfs/archive/ffe026366764e16b94666f42cee1033d8b689cc0.jpg"
        list.add(panda784)

        val panda785 = PetVideo()
        panda785.type = VideoType.PANDA.ordinal
        panda785.fileName = "panda_group_panda785"
        panda785.code = 2697
        panda785.duration = 102
        panda785.period = PeriodType.GROUP.ordinal
        panda785.star = false
        panda785.title = "当一只帅帅的熊猫er向你走来……【大熊猫和叶】"
        panda785.releaseTime = 1656152794
        panda785.originalUrl = "https://www.bilibili.com/video/BV1Av4y1u7kK"
        panda785.tags = "大熊猫,萌宠,动物圈"
        panda785.authorId = 16468440
        panda785.cover =
            "https://i2.hdslb.com/bfs/archive/2a3c89213d508f1868098a66efe854768a3994fe.jpg"
        list.add(panda785)

        val panda786 = PetVideo()
        panda786.type = VideoType.PANDA.ordinal
        panda786.fileName = "panda_group_panda786"
        panda786.code = 2698
        panda786.duration = 87
        panda786.period = PeriodType.GROUP.ordinal
        panda786.star = false
        panda786.title = "啃脚和叶，顾涌小花！【月亮产房的回忆】"
        panda786.releaseTime = 1656114419
        panda786.originalUrl = "https://www.bilibili.com/video/BV1Wa411W7Fv"
        panda786.tags = "大熊猫,萌宠,动物圈"
        panda786.authorId = 16468440
        panda786.cover =
            "https://i0.hdslb.com/bfs/archive/d08a0fe1293eb4693cd4ccb889b1a8915d846cf8.jpg"
        list.add(panda786)

        val panda787 = PetVideo()
        panda787.type = VideoType.PANDA.ordinal
        panda787.fileName = "panda_group_panda787"
        panda787.code = 2699
        panda787.duration = 121
        panda787.period = PeriodType.GROUP.ordinal
        panda787.star = false
        panda787.title = "【大熊猫和花】“躺平？摆烂？可不能这样，我得去战斗”"
        panda787.releaseTime = 1656059321
        panda787.originalUrl = "https://www.bilibili.com/video/BV1d3411c7UX"
        panda787.tags = "大熊猫,萌宠,动物圈"
        panda787.authorId = 34677299
        panda787.cover =
            "https://i2.hdslb.com/bfs/archive/bde137a415f4987e313f1f5bc96970c953abc515.jpg"
        list.add(panda787)

        val panda788 = PetVideo()
        panda788.type = VideoType.PANDA.ordinal
        panda788.fileName = "panda_group_panda788"
        panda788.code = 2700
        panda788.duration = 89
        panda788.period = PeriodType.GROUP.ordinal
        panda788.star = false
        panda788.title = "【大熊猫和叶】小叶子，你是在摆拍吧，你姐要被挤成夹心饼干了"
        panda788.releaseTime = 1655983041
        panda788.originalUrl = "https://www.bilibili.com/video/BV1wZ4y1i7bb"
        panda788.tags = "大熊猫,萌宠,动物圈"
        panda788.authorId = 34677299
        panda788.cover =
            "https://i1.hdslb.com/bfs/archive/caf09d26527daa5510674e8e3877a43599374a42.jpg"
        list.add(panda788)

        val panda789 = PetVideo()
        panda789.type = VideoType.PANDA.ordinal
        panda789.fileName = "panda_group_panda789"
        panda789.code = 2701
        panda789.duration = 18
        panda789.period = PeriodType.GROUP.ordinal
        panda789.star = false
        panda789.title = "【大熊猫和花】花宝：我只吃一小撮，要测量一下"
        panda789.releaseTime = 1655983200
        panda789.originalUrl = "https://www.bilibili.com/video/BV1oL4y1A7zL"
        panda789.tags = "大熊猫,萌宠,动物圈"
        panda789.authorId = 327377672
        panda789.cover =
            "https://i1.hdslb.com/bfs/archive/9360e85b15cf1f05050fffec4e6af8b5974ce290.jpg"
        list.add(panda789)

        val panda790 = PetVideo()
        panda790.type = VideoType.PANDA.ordinal
        panda790.fileName = "panda_group_panda790"
        panda790.code = 2702
        panda790.duration = 39
        panda790.period = PeriodType.GROUP.ordinal
        panda790.star = false
        panda790.title = "大熊猫和花、润玥-姐妹同框，吃饭更香"
        panda790.releaseTime = 1655986664
        panda790.originalUrl = "https://www.bilibili.com/video/BV1yW4y167DS"
        panda790.tags = "大熊猫,萌宠,动物圈"
        panda790.authorId = 1307515
        panda790.cover =
            "https://i0.hdslb.com/bfs/archive/bd97d99222f91e2f68dffc47bda2c8dbd6118a39.jpg"
        list.add(panda790)

        val panda791 = PetVideo()
        panda791.type = VideoType.PANDA.ordinal
        panda791.fileName = "panda_group_panda791"
        panda791.code = 2703
        panda791.duration = 150
        panda791.period = PeriodType.GROUP.ordinal
        panda791.star = false
        panda791.vertical = true
        panda791.title = "小熊的世界好纯粹"
        panda791.releaseTime = 1655954662
        panda791.originalUrl = "https://www.bilibili.com/video/BV12Y4y1g7Hf"
        panda791.tags = "大熊猫,萌宠,动物圈"
        panda791.authorId = 1025949925
        panda791.cover =
            "https://i2.hdslb.com/bfs/archive/520872ff37a6850e79ecbef2ad6ba1b7e04ff78d.jpg"
        list.add(panda791)

        val panda792 = PetVideo()
        panda792.type = VideoType.PANDA.ordinal
        panda792.fileName = "panda_group_panda792"
        panda792.code = 2704
        panda792.duration = 111
        panda792.period = PeriodType.GROUP.ordinal
        panda792.star = false
        panda792.vertical = true
        panda792.title = "和花的网络有延迟"
        panda792.releaseTime = 1655867701
        panda792.originalUrl = "https://www.bilibili.com/video/BV13B4y1D7Lw"
        panda792.tags = "大熊猫,萌宠,动物圈"
        panda792.authorId = 1025949925
        panda792.cover =
            "https://i0.hdslb.com/bfs/archive/b85219ff4017dac4cd7e3f82b49c5d480a019cb0.jpg"
        list.add(panda792)

        val panda793 = PetVideo()
        panda793.type = VideoType.PANDA.ordinal
        panda793.fileName = "panda_group_panda793"
        panda793.code = 2705
        panda793.duration = 24
        panda793.period = PeriodType.GROUP.ordinal
        panda793.star = false
        panda793.title = "吃一个藏一个"
        panda793.releaseTime = 1655800996
        panda793.originalUrl = "https://www.bilibili.com/video/BV1Ct4y1h7h3"
        panda793.tags = "大熊猫,萌宠,动物圈"
        panda793.authorId = 1435076062
        panda793.cover =
            "https://i1.hdslb.com/bfs/archive/4f397c5d84f6237cca847bc525e1298b94a359ba.jpg"
        list.add(panda793)

        val panda794 = PetVideo()
        panda794.type = VideoType.PANDA.ordinal
        panda794.fileName = "panda_group_panda794"
        panda794.code = 2706
        panda794.duration = 34
        panda794.period = PeriodType.GROUP.ordinal
        panda794.star = false
        panda794.title = "大熊猫和花-她就这样，走进我的……心巴"
        panda794.releaseTime = 1655804840
        panda794.originalUrl = "https://www.bilibili.com/video/BV1GU4y197ru"
        panda794.tags = "大熊猫,萌宠,动物圈"
        panda794.authorId = 1307515
        panda794.cover =
            "https://i2.hdslb.com/bfs/archive/3366a1abfcf33fa2a9afd17b0f93e7bf46ac0d09.jpg"
        list.add(panda794)

        val panda795 = PetVideo()
        panda795.type = VideoType.PANDA.ordinal
        panda795.fileName = "panda_group_panda795"
        panda795.code = 2707
        panda795.duration = 135
        panda795.period = PeriodType.GROUP.ordinal
        panda795.star = false
        panda795.vertical = true
        panda795.title = "会接话的熊猫"
        panda795.releaseTime = 1655781381
        panda795.originalUrl = "https://www.bilibili.com/video/BV1KT411V7G7"
        panda795.tags = "大熊猫,萌宠,动物圈"
        panda795.authorId = 1025949925
        panda795.cover =
            "https://i0.hdslb.com/bfs/archive/d7bd6a07d2568ee0268bc8cf2f6c6f7a4a17b2c8.jpg"
        list.add(panda795)

        val panda796 = PetVideo()
        panda796.type = VideoType.PANDA.ordinal
        panda796.fileName = "panda_group_panda796"
        panda796.code = 2708
        panda796.duration = 83
        panda796.period = PeriodType.GROUP.ordinal
        panda796.star = false
        panda796.title = "和花：二狗，你的不注重细节毁了我好多温柔"
        panda796.releaseTime = 1655782325
        panda796.originalUrl = "https://www.bilibili.com/video/BV1M34y1W7Qi"
        panda796.tags = "大熊猫,萌宠,动物圈"
        panda796.authorId = 34677299
        panda796.cover =
            "https://i1.hdslb.com/bfs/archive/3e29d3bc41d74374e17ac072ea1c91004770a898.jpg"
        list.add(panda796)

        val panda797 = PetVideo()
        panda797.type = VideoType.PANDA.ordinal
        panda797.fileName = "panda_group_panda797"
        panda797.code = 2709
        panda797.duration = 70
        panda797.period = PeriodType.GROUP.ordinal
        panda797.star = false
        panda797.title = "谁能拒绝翻滚卖萌边走边微笑的和花宝贝呢"
        panda797.releaseTime = 1655783117
        panda797.originalUrl = "https://www.bilibili.com/video/BV1sg411X7Aa"
        panda797.tags = "大熊猫,萌宠,动物圈"
        panda797.authorId = 230382720
        panda797.cover =
            "https://i2.hdslb.com/bfs/archive/495949254c469ba1fffe53ffee3bc36121763bbb.jpg"
        list.add(panda797)

        val panda798 = PetVideo()
        panda798.type = VideoType.PANDA.ordinal
        panda798.fileName = "panda_group_panda798"
        panda798.code = 2710
        panda798.duration = 58
        panda798.period = PeriodType.GROUP.ordinal
        panda798.star = false
        panda798.title = "大熊猫和花-小心翼翼过独木桥记"
        panda798.releaseTime = 1655721156
        panda798.originalUrl = "https://www.bilibili.com/video/BV1YB4y1s7Bv"
        panda798.tags = "大熊猫,萌宠,动物圈"
        panda798.authorId = 1307515
        panda798.cover =
            "https://i0.hdslb.com/bfs/archive/0ee5bbc2da44759e8909f843b7dc8e6b8f1386dd.jpg"
        list.add(panda798)

        val panda799 = PetVideo()
        panda799.type = VideoType.PANDA.ordinal
        panda799.fileName = "panda_group_panda799"
        panda799.code = 2711
        panda799.duration = 92
        panda799.period = PeriodType.GROUP.ordinal
        panda799.star = false
        panda799.title = "【大熊猫重阳&茱萸&金双】重阳：你们就压扁我吧！快跟妹妹学学破竹吧，她鼻子大头都会了"
        panda799.releaseTime = 1655722260
        panda799.originalUrl = "https://www.bilibili.com/video/BV1dt4y1h7ce"
        panda799.tags = "大熊猫,萌宠,动物圈"
        panda799.authorId = 34677299
        panda799.cover =
            "https://i2.hdslb.com/bfs/archive/a49cc821ab9921a391b04d8c3cb2682e33418d0b.jpg"
        list.add(panda799)

        val panda800 = PetVideo()
        panda800.type = VideoType.PANDA.ordinal
        panda800.fileName = "panda_group_panda800"
        panda800.code = 2712
        panda800.duration = 75
        panda800.period = PeriodType.GROUP.ordinal
        panda800.star = false
        panda800.title = "谭爷爷钓猫，和花最后来，艾久最大赢家"
        panda800.releaseTime = 1655730566
        panda800.originalUrl = "https://www.bilibili.com/video/BV1hL4y1A7B6"
        panda800.tags = "大熊猫,萌宠,动物圈"
        panda800.authorId = 627116323
        panda800.cover =
            "https://i2.hdslb.com/bfs/archive/8a9fbeec230fd6288be3fab95c71736abe924278.jpg"
        list.add(panda800)

        val panda801 = PetVideo()
        panda801.type = VideoType.PANDA.ordinal
        panda801.fileName = "panda_group_panda801"
        panda801.code = 2713
        panda801.duration = 199
        panda801.period = PeriodType.GROUP.ordinal
        panda801.star = false
        panda801.title = "99手掌轻轻一挥，和花顺势躺下，不知道这种算不算碰瓷【大熊猫和花】"
        panda801.releaseTime = 1655733600
        panda801.originalUrl = "https://www.bilibili.com/video/BV1nT411G71e"
        panda801.tags = "大熊猫,萌宠,动物圈"
        panda801.authorId = 98871951
        panda801.cover =
            "https://i1.hdslb.com/bfs/archive/22d0dceb1ccbfeaeffb511c08bfc1cf1ae638301.jpg"
        list.add(panda801)

        val panda802 = PetVideo()
        panda802.type = VideoType.PANDA.ordinal
        panda802.fileName = "panda_group_panda802"
        panda802.code = 2714
        panda802.duration = 39
        panda802.period = PeriodType.GROUP.ordinal
        panda802.star = false
        panda802.title = "乖巧品尝苹果的fafa被苹果雷达弟弟翻倒【大熊猫和花和叶】22夏"
        panda802.releaseTime = 1653999463
        panda802.originalUrl = "https://www.bilibili.com/video/BV1Za411j7RG"
        panda802.tags = "大熊猫,萌宠,动物圈"
        panda802.authorId = 496664786
        panda802.cover =
            "https://i0.hdslb.com/bfs/archive/c42d0ff6fe010d0f7fd25916bdd99da140efdd41.jpg"
        list.add(panda802)

        val panda803 = PetVideo()
        panda803.type = VideoType.PANDA.ordinal
        panda803.fileName = "panda_group_panda803"
        panda803.code = 2715
        panda803.duration = 121
        panda803.period = PeriodType.GROUP.ordinal
        panda803.star = false
        panda803.title = "小叶子胆子有点大哦，都敢偷袭艾玖了！这回旋飞咬的架势像极了花某~【大熊猫和叶 艾玖】"
        panda803.releaseTime = 1655703953
        panda803.originalUrl = "https://www.bilibili.com/video/BV1CT411G7Vg"
        panda803.tags = "大熊猫,萌宠,动物圈"
        panda803.authorId = 16468440
        panda803.cover =
            "https://i1.hdslb.com/bfs/archive/fd2c018a94fc95c01db2bf379e3527053782cb07.jpg"
        list.add(panda803)

        val panda804 = PetVideo()
        panda804.type = VideoType.PANDA.ordinal
        panda804.fileName = "panda_group_panda804"
        panda804.code = 2716
        panda804.duration = 26
        panda804.period = PeriodType.GROUP.ordinal
        panda804.star = false
        panda804.title = "【大熊猫和花】和花在梯子上玩"
        panda804.releaseTime = 1655637600
        panda804.originalUrl = "https://www.bilibili.com/video/BV1q3411M7Ft"
        panda804.tags = "大熊猫,萌宠,动物圈"
        panda804.authorId = 327377672
        panda804.cover =
            "https://i0.hdslb.com/bfs/archive/75d5b7ff187e2f1b97dec0d87f2c9be0883ea02c.jpg"
        list.add(panda804)

        val panda805 = PetVideo()
        panda805.type = VideoType.PANDA.ordinal
        panda805.fileName = "panda_group_panda805"
        panda805.code = 2717
        panda805.duration = 152
        panda805.period = PeriodType.GROUP.ordinal
        panda805.star = false
        panda805.title = "近花者甜，艾玖来撒娇，好闺蜜就是要贴贴！【大熊猫和花 艾玖】"
        panda805.releaseTime = 1655631060
        panda805.originalUrl = "https://www.bilibili.com/video/BV1WY4y1g7wU"
        panda805.tags = "大熊猫,萌宠,动物圈"
        panda805.authorId = 16468440
        panda805.cover =
            "https://i2.hdslb.com/bfs/archive/98e117084ef3c7f71f0860c87896e79ed77575f5.jpg"
        list.add(panda805)

        val panda806 = PetVideo()
        panda806.type = VideoType.PANDA.ordinal
        panda806.fileName = "panda_group_panda806"
        panda806.code = 2718
        panda806.duration = 166
        panda806.period = PeriodType.GROUP.ordinal
        panda806.star = false
        panda806.vertical = true
        panda806.title = "小熊熊的那些事儿，和花稳坐最佳吃瓜位"
        panda806.releaseTime = 1642908909
        panda806.originalUrl = "https://www.bilibili.com/video/BV1iS4y1o7bE"
        panda806.tags = "大熊猫,萌宠,动物圈"
        panda806.authorId = 1025949925
        panda806.cover =
            "https://i1.hdslb.com/bfs/archive/d9a8d92af9f6ddf0998e4f2c1cdfa03b0d1d7acf.jpg"
        list.add(panda806)

        val panda807 = PetVideo()
        panda807.type = VideoType.PANDA.ordinal
        panda807.fileName = "panda_group_panda807"
        panda807.code = 2719
        panda807.duration = 128
        panda807.period = PeriodType.GROUP.ordinal
        panda807.star = false
        panda807.title = "花公主有自己的节奏，勿CUE栓Q！【大熊猫和花】"
        panda807.releaseTime = 1655574566
        panda807.originalUrl = "https://www.bilibili.com/video/BV1TB4y1s72p"
        panda807.tags = "大熊猫,萌宠,动物圈"
        panda807.authorId = 16468440
        panda807.cover =
            "https://i1.hdslb.com/bfs/archive/abe0f90c835546de84100a45a136efe829394fba.jpg"
        list.add(panda807)

        val panda808 = PetVideo()
        panda808.type = VideoType.PANDA.ordinal
        panda808.fileName = "panda_group_panda808"
        panda808.code = 2720
        panda808.duration = 132
        panda808.period = PeriodType.GROUP.ordinal
        panda808.star = false
        panda808.vertical = true
        panda808.title = "【大熊猫香果&春生&热干面】果果：都欺负我是吧，俩个凑男生，气死了"
        panda808.releaseTime = 1655560496
        panda808.originalUrl = "https://www.bilibili.com/video/BV16T411577Y"
        panda808.tags = "大熊猫,萌宠,动物圈"
        panda808.authorId = 34677299
        panda808.cover =
            "https://i0.hdslb.com/bfs/archive/33a21e2b871a8d7d93bece0774654f40c70730cf.jpg"
        list.add(panda808)

        val panda809 = PetVideo()
        panda809.type = VideoType.PANDA.ordinal
        panda809.fileName = "panda_group_panda809"
        panda809.code = 2721
        panda809.duration = 71
        panda809.period = PeriodType.GROUP.ordinal
        panda809.star = false
        panda809.title = "【大熊猫润玥&和花】和花和二狗，这俩在一起好像就挺好笑"
        panda809.releaseTime = 1655556043
        panda809.originalUrl = "https://www.bilibili.com/video/BV1dg411Q7ne"
        panda809.tags = "大熊猫,萌宠,动物圈"
        panda809.authorId = 34677299
        panda809.cover =
            "https://i2.hdslb.com/bfs/archive/ac0708dda57936b9d5d3b59fef22a23c0a227efa.jpg"
        list.add(panda809)

        val panda810 = PetVideo()
        panda810.type = VideoType.PANDA.ordinal
        panda810.fileName = "panda_group_panda810"
        panda810.code = 2722
        panda810.duration = 61
        panda810.period = PeriodType.GROUP.ordinal
        panda810.star = false
        panda810.title = "〖谭爷爷钓猫记〗小2班的仔仔呢太可爱了吧"
        panda810.releaseTime = 1655541923
        panda810.originalUrl = "https://www.bilibili.com/video/BV1rU4y1X7ae"
        panda810.tags = "大熊猫,萌宠,动物圈"
        panda810.authorId = 690050620
        panda810.cover =
            "https://i0.hdslb.com/bfs/archive/ee2504aceb2b2daea5d158965134e3cad2ee502b.jpg"
        list.add(panda810)

        val panda811 = PetVideo()
        panda811.type = VideoType.PANDA.ordinal
        panda811.fileName = "panda_group_panda811"
        panda811.code = 2723
        panda811.duration = 172
        panda811.period = PeriodType.GROUP.ordinal
        panda811.star = false
        panda811.title = "菜总的贴身花秘书，天天操碎了心！【大熊猫和花 润玥】"
        panda811.releaseTime = 1655464240
        panda811.originalUrl = "https://www.bilibili.com/video/BV1Cg411Q7oB"
        panda811.tags = "大熊猫,萌宠,动物圈"
        panda811.authorId = 16468440
        panda811.cover =
            "https://i0.hdslb.com/bfs/archive/e6e6023d726d63d606f3a2b3c4d187bb6ed7b9a0.jpg"
        list.add(panda811)

        val panda812 = PetVideo()
        panda812.type = VideoType.PANDA.ordinal
        panda812.fileName = "panda_group_panda812"
        panda812.code = 2724
        panda812.duration = 188
        panda812.period = PeriodType.GROUP.ordinal
        panda812.star = false
        panda812.title = "fa姐：二狗，我告诉你下次我还敢挨着你坐！【大熊猫润玥、和花、艾玖、和叶】"
        panda812.releaseTime = 1655465271
        panda812.originalUrl = "https://www.bilibili.com/video/BV1qB4y1S7Ze"
        panda812.tags = "大熊猫,萌宠,动物圈"
        panda812.authorId = 514531996
        panda812.cover =
            "https://i2.hdslb.com/bfs/archive/64ca768e413944ec119fbe4f6cefb1aa1035cc10.jpg"
        list.add(panda812)

        val panda813 = PetVideo()
        panda813.type = VideoType.PANDA.ordinal
        panda813.fileName = "panda_group_panda813"
        panda813.code = 2725
        panda813.duration = 94
        panda813.period = PeriodType.GROUP.ordinal
        panda813.star = false
        panda813.title = "【大熊猫和花&和叶】救命！这俩怎么这么好笑，姐弟俩隔空互怼"
        panda813.releaseTime = 1655437528
        panda813.originalUrl = "https://www.bilibili.com/video/BV1Y94y1276Q"
        panda813.tags = "大熊猫,萌宠,动物圈"
        panda813.authorId = 34677299
        panda813.cover =
            "https://i2.hdslb.com/bfs/archive/93e6e7f959d028a2381833c2f970cb90b1ac34a3.jpg"
        list.add(panda813)

        val panda814 = PetVideo()
        panda814.type = VideoType.PANDA.ordinal
        panda814.fileName = "panda_group_panda814"
        panda814.code = 2726
        panda814.duration = 55
        panda814.period = PeriodType.GROUP.ordinal
        panda814.star = false
        panda814.title = "大熊猫和花-小饭团吃大竹子"
        panda814.releaseTime = 1655462924
        panda814.originalUrl = "https://www.bilibili.com/video/BV1S34y157Wa"
        panda814.tags = "大熊猫,萌宠,动物圈"
        panda814.authorId = 1307515
        panda814.cover =
            "https://i2.hdslb.com/bfs/archive/bddaf4636c92f40c23b1127d503e60150e01839d.jpg"
        list.add(panda814)

        val panda815 = PetVideo()
        panda815.type = VideoType.PANDA.ordinal
        panda815.fileName = "panda_group_panda815"
        panda815.code = 2727
        panda815.duration = 12
        panda815.period = PeriodType.GROUP.ordinal
        panda815.star = false
        panda815.title = "大熊猫和花～假装与花对视"
        panda815.releaseTime = 1655284701
        panda815.originalUrl = "https://www.bilibili.com/video/BV1eW4y1k7UC"
        panda815.tags = "大熊猫,萌宠,动物圈"
        panda815.authorId = 19715714
        panda815.cover =
            "https://i1.hdslb.com/bfs/archive/2606f7b4dfee21c5616d63088787f68627341a7e.jpg"
        list.add(panda815)

        val panda816 = PetVideo()
        panda816.type = VideoType.PANDA.ordinal
        panda816.fileName = "panda_group_panda816"
        panda816.code = 2728
        panda816.duration = 212
        panda816.period = PeriodType.GROUP.ordinal
        panda816.star = false
        panda816.title = "奶妈和熊孩子们都很幸福。~中午太阳养猪场发窝头。【大熊猫蛋烘糕、热干面、春生、香果】"
        panda816.releaseTime = 1655373352
        panda816.originalUrl = "https://www.bilibili.com/video/BV1bB4y1S7wn"
        panda816.tags = "大熊猫,萌宠,动物圈"
        panda816.authorId = 514531996
        panda816.cover =
            "https://i2.hdslb.com/bfs/archive/7c5f37235ce13797eea1ac6f797bdf47728af58e.jpg"
        list.add(panda816)

        val panda817 = PetVideo()
        panda817.type = VideoType.PANDA.ordinal
        panda817.fileName = "panda_group_panda817"
        panda817.code = 2729
        panda817.duration = 105
        panda817.period = PeriodType.GROUP.ordinal
        panda817.star = false
        panda817.vertical = true
        panda817.title = "吃饭不要急，容易被呛到"
        panda817.releaseTime = 1655350591
        panda817.originalUrl = "https://www.bilibili.com/video/BV1rZ4y1q7h1"
        panda817.tags = "大熊猫,萌宠,动物圈"
        panda817.authorId = 1025949925
        panda817.cover =
            "https://i1.hdslb.com/bfs/archive/e2b814a04da502a6e3cbd9df554575894f4c1e36.jpg"
        list.add(panda817)

        val panda818 = PetVideo()
        panda818.type = VideoType.PANDA.ordinal
        panda818.fileName = "panda_group_panda818"
        panda818.code = 2730
        panda818.duration = 68
        panda818.period = PeriodType.GROUP.ordinal
        panda818.star = false
        panda818.title = "你是哪个和花? 我是大熊猫和叶.和花！【大熊猫和叶】"
        panda818.releaseTime = 1655306656
        panda818.originalUrl = "https://www.bilibili.com/video/BV13F411c7TR"
        panda818.tags = "大熊猫,萌宠,动物圈"
        panda818.authorId = 16468440
        panda818.cover =
            "https://i0.hdslb.com/bfs/archive/4c33565c77833e54ee1c69b68d304bf87ef67bb0.jpg"
        list.add(panda818)

        val panda819 = PetVideo()
        panda819.type = VideoType.PANDA.ordinal
        panda819.fileName = "panda_group_panda819"
        panda819.code = 2731
        panda819.duration = 79
        panda819.period = PeriodType.GROUP.ordinal
        panda819.star = false
        panda819.title = "【大熊猫和花】认真的女孩儿最美，说的就是你，成和花"
        panda819.releaseTime = 1655204426
        panda819.originalUrl = "https://www.bilibili.com/video/BV13r4y137qt"
        panda819.tags = "大熊猫,萌宠,动物圈"
        panda819.authorId = 98871951
        panda819.cover =
            "https://i1.hdslb.com/bfs/archive/7f064fda28669b3febffcacb67f444324be48a2b.jpg"
        list.add(panda819)

        val panda820 = PetVideo()
        panda820.type = VideoType.PANDA.ordinal
        panda820.fileName = "panda_group_panda820"
        panda820.code = 2732
        panda820.duration = 73
        panda820.period = PeriodType.GROUP.ordinal
        panda820.star = false
        panda820.title = "【大熊猫和花】摔了两次的和花疯狂生胖气ing（一次掉下架子，一次摔下梯子）"
        panda820.releaseTime = 1650103113
        panda820.originalUrl = "https://www.bilibili.com/video/BV1PB4y1U7L5"
        panda820.tags = "大熊猫,萌宠,动物圈"
        panda820.authorId = 18329821
        panda820.cover =
            "https://i1.hdslb.com/bfs/archive/819d46d605424c11a6284c7ea3fcd0b7c77fb4ba.jpg"
        list.add(panda820)

        val panda821 = PetVideo()
        panda821.type = VideoType.PANDA.ordinal
        panda821.fileName = "panda_group_panda821"
        panda821.code = 2733
        panda821.duration = 205
        panda821.period = PeriodType.GROUP.ordinal
        panda821.star = false
        panda821.title = "艾玖在吃竹子，润玥在吃竹子，和叶在摆拍，还有一只和花虫在 顾 涌 顾 涌 ！"
        panda821.releaseTime = 1655276440
        panda821.originalUrl = "https://www.bilibili.com/video/BV1494y127iW"
        panda821.tags = "大熊猫,萌宠,动物圈"
        panda821.authorId = 16468440
        panda821.cover =
            "https://i1.hdslb.com/bfs/archive/e362324ecd6e1ce205dfc8060211e4b963f08bf4.jpg"
        list.add(panda821)

        val panda822 = PetVideo()
        panda822.type = VideoType.PANDA.ordinal
        panda822.fileName = "panda_group_panda822"
        panda822.code = 2734
        panda822.duration = 77
        panda822.period = PeriodType.GROUP.ordinal
        panda822.star = false
        panda822.title = "【大熊猫和花】真听话，谭爷爷一叫就回去了，和花当然知道自己叫和花啦"
        panda822.releaseTime = 1655265895
        panda822.originalUrl = "https://www.bilibili.com/video/BV123411M7t3"
        panda822.tags = "大熊猫,萌宠,动物圈"
        panda822.authorId = 34677299
        panda822.cover =
            "https://i2.hdslb.com/bfs/archive/f77a3d0e9ab38dedc549752e19df3c3d37fec6d8.jpg"
        list.add(panda822)

        val panda823 = PetVideo()
        panda823.type = VideoType.PANDA.ordinal
        panda823.fileName = "panda_group_panda823"
        panda823.code = 2735
        panda823.duration = 163
        panda823.period = PeriodType.GROUP.ordinal
        panda823.star = false
        panda823.vertical = true
        panda823.title = "和花：我才不稀罕跟你们抢呢，哼！"
        panda823.releaseTime = 1655178086
        panda823.originalUrl = "https://www.bilibili.com/video/BV14g41197SP"
        panda823.tags = "大熊猫,萌宠,动物圈"
        panda823.authorId = 1025949925
        panda823.cover =
            "https://i1.hdslb.com/bfs/archive/fafafc5fe95274bff50b1b29f2cd60d6464910ef.jpg"
        list.add(panda823)

        val panda824 = PetVideo()
        panda824.type = VideoType.PANDA.ordinal
        panda824.fileName = "panda_group_panda824"
        panda824.code = 2736
        panda824.duration = 57
        panda824.period = PeriodType.GROUP.ordinal
        panda824.star = false
        panda824.title = "【大熊猫和花】再不降温我就要融化了  润玥送来及时雨"
        panda824.releaseTime = 1647433159
        panda824.originalUrl = "https://www.bilibili.com/video/BV1CY41137fb"
        panda824.tags = "大熊猫,萌宠,动物圈"
        panda824.authorId = 327377672
        panda824.cover =
            "https://i2.hdslb.com/bfs/archive/c719d7809e757ddeacf24a6324a8a4ee3f4b60d3.jpg"
        list.add(panda824)

        val panda825 = PetVideo()
        panda825.type = VideoType.PANDA.ordinal
        panda825.fileName = "panda_group_panda825"
        panda825.code = 2737
        panda825.duration = 96
        panda825.period = PeriodType.GROUP.ordinal
        panda825.star = false
        panda825.title = "【大熊猫和花】和花已经做的很好了，最后还是被抢了"
        panda825.releaseTime = 1653915774
        panda825.originalUrl = "https://www.bilibili.com/video/BV1yF41157LQ"
        panda825.tags = "大熊猫,萌宠,动物圈"
        panda825.authorId = 327377672
        panda825.cover =
            "https://i2.hdslb.com/bfs/archive/8ee07ab15781aaeb5643de7ec55acec9319343d8.jpg"
        list.add(panda825)

        val panda826 = PetVideo()
        panda826.type = VideoType.PANDA.ordinal
        panda826.fileName = "panda_group_panda826"
        panda826.code = 2738
        panda826.duration = 77
        panda826.period = PeriodType.GROUP.ordinal
        panda826.star = false
        panda826.title = "杂技大师“艾玖”！【大熊猫和叶】"
        panda826.releaseTime = 1655120369
        panda826.originalUrl = "https://www.bilibili.com/video/BV1yA4y1R7pY"
        panda826.tags = "大熊猫,萌宠,动物圈"
        panda826.authorId = 16468440
        panda826.cover =
            "https://i2.hdslb.com/bfs/archive/c7b0091c24fe583e74dfa397477dd17bde29324b.jpg"
        list.add(panda826)

        val panda827 = PetVideo()
        panda827.type = VideoType.PANDA.ordinal
        panda827.fileName = "panda_group_panda827"
        panda827.code = 2739
        panda827.duration = 52
        panda827.period = PeriodType.GROUP.ordinal
        panda827.star = false
        panda827.title = "【大熊猫和花】和花可爱吃笋"
        panda827.releaseTime = 1651492957
        panda827.originalUrl = "https://www.bilibili.com/video/BV1s541127uM"
        panda827.tags = "大熊猫,萌宠,动物圈"
        panda827.authorId = 327377672
        panda827.cover =
            "https://i1.hdslb.com/bfs/archive/44e5bce012686be70cfb69956ded2ed46dc9669c.jpg"
        list.add(panda827)

        val panda828 = PetVideo()
        panda828.type = VideoType.PANDA.ordinal
        panda828.fileName = "panda_group_panda828"
        panda828.code = 2740
        panda828.duration = 24
        panda828.period = PeriodType.GROUP.ordinal
        panda828.star = false
        panda828.vertical = true
        panda828.title = "快 来 帮 花 花 吃 到 苹 果！【大熊猫和花】"
        panda828.releaseTime = 1655096254
        panda828.originalUrl = "https://www.bilibili.com/video/BV1sF411F78c"
        panda828.tags = "大熊猫,萌宠,动物圈"
        panda828.authorId = 16468440
        panda828.cover =
            "https://i0.hdslb.com/bfs/archive/1088819f694b77b3e5811defba84120bb83b832c.jpg"
        list.add(panda828)

        val panda829 = PetVideo()
        panda829.type = VideoType.PANDA.ordinal
        panda829.fileName = "panda_group_panda829"
        panda829.code = 2741
        panda829.duration = 154
        panda829.period = PeriodType.GROUP.ordinal
        panda829.star = false
        panda829.vertical = true
        panda829.title = "国宝今天下干嘛？和花流了一地口水，福双变社牛，真是好玩的一天！"
        panda829.releaseTime = 1655003399
        panda829.originalUrl = "https://www.bilibili.com/video/BV1wt4y1p71f"
        panda829.tags = "大熊猫,萌宠,动物圈"
        panda829.authorId = 1025949925
        panda829.cover =
            "https://i1.hdslb.com/bfs/archive/c4b2a57c0044583700ba26b618b220ea82c21390.jpg"
        list.add(panda829)

        val panda830 = PetVideo()
        panda830.type = VideoType.PANDA.ordinal
        panda830.fileName = "panda_group_panda830"
        panda830.code = 2742
        panda830.duration = 278
        panda830.period = PeriodType.GROUP.ordinal
        panda830.star = false
        panda830.title = "6.11 笑风浪三姐妹生日会。【大熊猫绩笑、成风、成浪】"
        panda830.releaseTime = 1655014861
        panda830.originalUrl = "https://www.bilibili.com/video/BV1bB4y1Q7B4"
        panda830.tags = "大熊猫,萌宠,动物圈"
        panda830.authorId = 514531996
        panda830.cover =
            "https://i0.hdslb.com/bfs/archive/959c81ef7efa678837a5117e669295db39bdaf51.jpg"
        list.add(panda830)

        val panda831 = PetVideo()
        panda831.type = VideoType.PANDA.ordinal
        panda831.fileName = "panda_group_panda831"
        panda831.code = 2743
        panda831.duration = 83
        panda831.period = PeriodType.GROUP.ordinal
        panda831.star = false
        panda831.title = "【大熊猫重阳&茱萸】双胞胎就是要坐一起啊，茱萸妹妹有点胆小，被金喜吓一大跳"
        panda831.releaseTime = 1654939169
        panda831.originalUrl = "https://www.bilibili.com/video/BV1z34y1V7hY"
        panda831.tags = "大熊猫,萌宠,动物圈"
        panda831.authorId = 34677299
        panda831.cover =
            "https://i2.hdslb.com/bfs/archive/959931dc003a87fd5087e0f45be83fa8fe957be0.jpg"
        list.add(panda831)

        val panda832 = PetVideo()
        panda832.type = VideoType.PANDA.ordinal
        panda832.fileName = "panda_group_panda832"
        panda832.code = 2744
        panda832.duration = 68
        panda832.period = PeriodType.GROUP.ordinal
        panda832.star = false
        panda832.vertical = true
        panda832.title = "【大熊猫和花】和花，谭爷爷喊你咯，还在这开见面会呐"
        panda832.releaseTime = 1654946076
        panda832.originalUrl = "https://www.bilibili.com/video/BV1tB4y1Q7wc"
        panda832.tags = "大熊猫,萌宠,动物圈"
        panda832.authorId = 34677299
        panda832.cover =
            "https://i1.hdslb.com/bfs/archive/49f7c41f4223f373de4560e162aaaa31961bd347.jpg"
        list.add(panda832)

        val panda833 = PetVideo()
        panda833.type = VideoType.PANDA.ordinal
        panda833.fileName = "panda_group_panda833"
        panda833.code = 2745
        panda833.duration = 120
        panda833.period = PeriodType.GROUP.ordinal
        panda833.star = false
        panda833.title = "奶爸敲着盆盆来啦，又是摸又是抱，和花还跟到奶爸duangduang地跑！【大熊猫和花】"
        panda833.releaseTime = 1647016968
        panda833.originalUrl = "https://www.bilibili.com/video/BV13S4y1D7v2"
        panda833.tags = "大熊猫,萌宠,动物圈"
        panda833.authorId = 16468440
        panda833.cover =
            "https://i0.hdslb.com/bfs/archive/ddb421cc31b5a32e17865311f551e1464783add2.jpg"
        list.add(panda833)

        val panda834 = PetVideo()
        panda834.type = VideoType.PANDA.ordinal
        panda834.fileName = "panda_group_panda834"
        panda834.code = 2746
        panda834.duration = 321
        panda834.period = PeriodType.GROUP.ordinal
        panda834.star = false
        panda834.title = "【和花和叶】双胞胎姐弟的“腻腻歪歪”"
        panda834.releaseTime = 1654765974
        panda834.originalUrl = "https://www.bilibili.com/video/BV1VS4y1i791"
        panda834.tags = "大熊猫,萌宠,动物圈"
        panda834.authorId = 478823961
        panda834.cover =
            "https://i2.hdslb.com/bfs/archive/5febb8ec26375ba66dbfc52143f0e6d96479ef34.jpg"
        list.add(panda834)

        val panda835 = PetVideo()
        panda835.type = VideoType.PANDA.ordinal
        panda835.fileName = "panda_group_panda835"
        panda835.code = 2747
        panda835.duration = 187
        panda835.period = PeriodType.GROUP.ordinal
        panda835.star = false
        panda835.title = "【1818熊猫眼】本届“最委屈”好市民竟然是它？"
        panda835.releaseTime = 1654861200
        panda835.originalUrl = "https://www.bilibili.com/video/BV1Qg41197sM"
        panda835.tags = "大熊猫,萌宠,动物圈"
        panda835.authorId = 1998535
        panda835.cover =
            "https://i2.hdslb.com/bfs/archive/41b2bdb6a81cd7e47601aee8634a239a944724e1.jpg"
        list.add(panda835)

        val panda836 = PetVideo()
        panda836.type = VideoType.PANDA.ordinal
        panda836.fileName = "panda_group_panda836"
        panda836.code = 2748
        panda836.duration = 104
        panda836.period = PeriodType.GROUP.ordinal
        panda836.star = false
        panda836.title = "【大熊猫和花】抢不抢无所谓，就喜欢挨着二姐。花主任多次展示腿勾竹绝技"
        panda836.releaseTime = 1654862401
        panda836.originalUrl = "https://www.bilibili.com/video/BV1nZ4y1t7yg"
        panda836.tags = "大熊猫,萌宠,动物圈"
        panda836.authorId = 327377672
        panda836.cover =
            "https://i0.hdslb.com/bfs/archive/758d5adb55305d96245b03511292a1301831e0fb.jpg"
        list.add(panda836)

        val panda837 = PetVideo()
        panda837.type = VideoType.PANDA.ordinal
        panda837.fileName = "panda_group_panda837"
        panda837.code = 2749
        panda837.duration = 92
        panda837.period = PeriodType.GROUP.ordinal
        panda837.star = false
        panda837.title = "【大熊猫艾玖润玥和花】新玩具被拆了，和花对两个罪魁祸首敢怒不敢言"
        panda837.releaseTime = 1638617329
        panda837.originalUrl = "https://www.bilibili.com/video/BV1RS4y1X7oq"
        panda837.tags = "大熊猫,萌宠,动物圈"
        panda837.authorId = 5125945
        panda837.cover =
            "https://i1.hdslb.com/bfs/archive/6ca08b5ba2419babc7b10adc573c7abb0f9d711a.jpg"
        list.add(panda837)

        val panda838 = PetVideo()
        panda838.type = VideoType.PANDA.ordinal
        panda838.fileName = "panda_group_panda838"
        panda838.code = 2750
        panda838.duration = 292
        panda838.period = PeriodType.GROUP.ordinal
        panda838.star = false
        panda838.vertical = true
        panda838.title = "【大熊猫】四喜丸子下锅啦！洗干净就上架！欲购从速！"
        panda838.releaseTime = 1594547425
        panda838.originalUrl = "https://www.bilibili.com/video/BV1tK411H7VD"
        panda838.tags = "大熊猫,萌宠,动物圈"
        panda838.authorId = 478187932
        panda838.cover =
            "https://i2.hdslb.com/bfs/archive/723084d2534bd5acf1ec0720e8ee5459a64afec8.jpg"
        list.add(panda838)

        val panda839 = PetVideo()
        panda839.type = VideoType.PANDA.ordinal
        panda839.fileName = "panda_group_panda839"
        panda839.code = 2751
        panda839.duration = 61
        panda839.period = PeriodType.GROUP.ordinal
        panda839.star = false
        panda839.title = "【虫洞四喜丸子】丸子们冲澡降暑啦"
        panda839.releaseTime = 1595728062
        panda839.originalUrl = "https://www.bilibili.com/video/BV1Lv411q7sf"
        panda839.tags = "大熊猫,萌宠,动物圈"
        panda839.authorId = 66688464
        panda839.cover =
            "https://i1.hdslb.com/bfs/archive/0bb53ad43fa8c47d9c6eb0a08ffa6680bca6c4ad.jpg"
        list.add(panda839)

        val panda840 = PetVideo()
        panda840.type = VideoType.PANDA.ordinal
        panda840.fileName = "panda_group_panda840"
        panda840.code = 2752
        panda840.duration = 35
        panda840.period = PeriodType.GROUP.ordinal
        panda840.star = false
        panda840.title = "【大熊猫绩笑】憨皇来干饭了，必须配一个霸气的出场音乐"
        panda840.releaseTime = 1624713035
        panda840.originalUrl = "https://www.bilibili.com/video/BV1Zf4y1t78B"
        panda840.tags = "大熊猫,萌宠,动物圈"
        panda840.authorId = 39546503
        panda840.cover =
            "https://i1.hdslb.com/bfs/archive/842819ac9247be8717b738165f7fb5b9c6b401e9.jpg"
        list.add(panda840)

        val panda841 = PetVideo()
        panda841.type = VideoType.PANDA.ordinal
        panda841.fileName = "panda_group_panda841"
        panda841.code = 2753
        panda841.duration = 146
        panda841.period = PeriodType.GROUP.ordinal
        panda841.star = false
        panda841.title = "看在和花正脸营业的份上，我可以忽略花宝叽的脏PP【大熊猫和花】"
        panda841.releaseTime = 1654830137
        panda841.originalUrl = "https://www.bilibili.com/video/BV1NT41157PC"
        panda841.tags = "大熊猫,萌宠,动物圈"
        panda841.authorId = 230382720
        panda841.cover =
            "https://i0.hdslb.com/bfs/archive/e970b564e1463b05ecfa4e3191d78bfff2dc605c.jpg"
        list.add(panda841)

        val panda842 = PetVideo()
        panda842.type = VideoType.PANDA.ordinal
        panda842.fileName = "panda_group_panda842"
        panda842.code = 2754
        panda842.duration = 145
        panda842.period = PeriodType.GROUP.ordinal
        panda842.star = false
        panda842.title = "幼年1班日常：一个在上头qio欺头，两个在中间使劲儿打，还有一个在下头全力蹭架打滚儿！"
        panda842.releaseTime = 1654823571
        panda842.originalUrl = "https://www.bilibili.com/video/BV1HZ4y1t7LJ"
        panda842.tags = "大熊猫,萌宠,动物圈"
        panda842.authorId = 16468440
        panda842.cover =
            "https://i2.hdslb.com/bfs/archive/d24e535c94e00a249bbc580c304ca0589f06f49d.jpg"
        list.add(panda842)

        val panda843 = PetVideo()
        panda843.type = VideoType.PANDA.ordinal
        panda843.fileName = "panda_group_panda843"
        panda843.code = 2755
        panda843.duration = 64
        panda843.period = PeriodType.GROUP.ordinal
        panda843.star = false
        panda843.title = "【大熊猫和花】吃了我的果果，都必须让我费"
        panda843.releaseTime = 1654783201
        panda843.originalUrl = "https://www.bilibili.com/video/BV1pB4y1Q7QH"
        panda843.tags = "大熊猫,萌宠,动物圈"
        panda843.authorId = 98871951
        panda843.cover =
            "https://i1.hdslb.com/bfs/archive/6cab0bda6904b203984b027e8ea6929953f53a10.jpg"
        list.add(panda843)

        val panda844 = PetVideo()
        panda844.type = VideoType.PANDA.ordinal
        panda844.fileName = "panda_group_panda844"
        panda844.code = 2756
        panda844.duration = 116
        panda844.period = PeriodType.GROUP.ordinal
        panda844.star = false
        panda844.vertical = true
        panda844.title = "钓猫也是一个技术活，跟谭爷爷来学钓猫"
        panda844.releaseTime = 1654744564
        panda844.originalUrl = "https://www.bilibili.com/video/BV1nr4y1V7QN"
        panda844.tags = "大熊猫,萌宠,动物圈"
        panda844.authorId = 1025949925
        panda844.cover =
            "https://i1.hdslb.com/bfs/archive/53b250ce0baf292b6b3f2eb64d7545fc5d21bb21.jpg"
        list.add(panda844)

        val panda845 = PetVideo()
        panda845.type = VideoType.PANDA.ordinal
        panda845.fileName = "panda_group_panda845"
        panda845.code = 2757
        panda845.duration = 73
        panda845.period = PeriodType.GROUP.ordinal
        panda845.star = false
        panda845.title = "大熊猫和花-一次成功的钓猫"
        panda845.releaseTime = 1654771799
        panda845.originalUrl = "https://www.bilibili.com/video/BV1yY411M7HL"
        panda845.tags = "大熊猫,萌宠,动物圈"
        panda845.authorId = 1307515
        panda845.cover =
            "https://i2.hdslb.com/bfs/archive/b148b41a44e6dd029f6ea30b975b90ef51b90650.jpg"
        list.add(panda845)

        val panda846 = PetVideo()
        panda846.type = VideoType.PANDA.ordinal
        panda846.fileName = "panda_group_panda846"
        panda846.code = 2758
        panda846.duration = 18
        panda846.period = PeriodType.GROUP.ordinal
        panda846.star = false
        panda846.title = "福双和金双干架坐断小树 把游客逗笑了"
        panda846.releaseTime = 1652232960
        panda846.originalUrl = "https://www.bilibili.com/video/BV1oB4y1C7PN"
        panda846.tags = "大熊猫,萌宠,动物圈"
        panda846.authorId = 442701460
        panda846.cover =
            "https://i1.hdslb.com/bfs/archive/023f1a28e59509f21234b44ef3a02a022b45c632.jpg"
        list.add(panda846)

        val panda847 = PetVideo()
        panda847.type = VideoType.PANDA.ordinal
        panda847.fileName = "panda_group_panda847"
        panda847.code = 2759
        panda847.duration = 114
        panda847.period = PeriodType.GROUP.ordinal
        panda847.star = false
        panda847.title = "茱萸：超车请注意！撞倒哥哥 这班钓猫笑死人"
        panda847.releaseTime = 1654567465
        panda847.originalUrl = "https://www.bilibili.com/video/BV1eZ4y1t77H"
        panda847.tags = "大熊猫,萌宠,动物圈"
        panda847.authorId = 442701460
        panda847.cover =
            "https://i0.hdslb.com/bfs/archive/58a67771b9e95282e4cab20513e84b4df8601700.jpg"
        list.add(panda847)

        val panda848 = PetVideo()
        panda848.type = VideoType.PANDA.ordinal
        panda848.fileName = "panda_group_panda848"
        panda848.code = 2760
        panda848.duration = 102
        panda848.period = PeriodType.GROUP.ordinal
        panda848.star = false
        panda848.title = "【大熊猫和花】花主任测评：这个垫脚筐筐不太好用，踩着不稳，还是直接爬上去吧"
        panda848.releaseTime = 1643965620
        panda848.originalUrl = "https://www.bilibili.com/video/BV1M5411f7XR"
        panda848.tags = "大熊猫,萌宠,动物圈"
        panda848.authorId = 230382720
        panda848.cover =
            "https://i2.hdslb.com/bfs/archive/48d6e3d2fce0b1b3f76464307f4e665dbcb0a318.jpg"
        list.add(panda848)

        val panda849 = PetVideo()
        panda849.type = VideoType.PANDA.ordinal
        panda849.fileName = "panda_group_panda849"
        panda849.code = 2761
        panda849.duration = 87
        panda849.period = PeriodType.GROUP.ordinal
        panda849.star = false
        panda849.title = "和花又一次重启失败啦～02.09【大熊猫和花】"
        panda849.releaseTime = 1644410616
        panda849.originalUrl = "https://www.bilibili.com/video/BV1Ur4y1h7Rt"
        panda849.tags = "大熊猫,萌宠,动物圈"
        panda849.authorId = 16468440
        panda849.cover =
            "https://i1.hdslb.com/bfs/archive/594401978ddc9c80657896ce96ca57f449502afb.jpg"
        list.add(panda849)

        val panda850 = PetVideo()
        panda850.type = VideoType.PANDA.ordinal
        panda850.fileName = "panda_group_panda850"
        panda850.code = 2762
        panda850.duration = 248
        panda850.period = PeriodType.GROUP.ordinal
        panda850.star = false
        panda850.title = "零食时间，二狗猪突猛进，艾玖熊熊壮壮，和叶帅气饭团熊，和和花躺平吃果果"
        panda850.releaseTime = 1654752192
        panda850.originalUrl = "https://www.bilibili.com/video/BV1SL4y1P7wg"
        panda850.tags = "大熊猫,萌宠,动物圈"
        panda850.authorId = 230382720
        panda850.cover =
            "https://i1.hdslb.com/bfs/archive/9b36a6a930e648fcf50be7d277dbae54a58d7338.jpg"
        list.add(panda850)

        val panda851 = PetVideo()
        panda851.type = VideoType.PANDA.ordinal
        panda851.fileName = "panda_group_panda851"
        panda851.code = 2763
        panda851.duration = 201
        panda851.period = PeriodType.GROUP.ordinal
        panda851.star = false
        panda851.title = "谭爷爷钓猫，和花差点就站起来了，最后苹果被i9抢了两次"
        panda851.releaseTime = 1653483600
        panda851.originalUrl = "https://www.bilibili.com/video/BV1gP4y1F7MU"
        panda851.tags = "大熊猫,萌宠,动物圈"
        panda851.authorId = 98871951
        panda851.cover =
            "https://i0.hdslb.com/bfs/archive/6df9aca46c6bd63132a5956ee66ec32b97531437.jpg"
        list.add(panda851)

        val panda852 = PetVideo()
        panda852.type = VideoType.PANDA.ordinal
        panda852.fileName = "panda_group_panda852"
        panda852.code = 2764
        panda852.duration = 35
        panda852.period = PeriodType.GROUP.ordinal
        panda852.star = false
        panda852.title = "五只小熊排排坐吃笋：金喜福双茱萸金双重阳"
        panda852.releaseTime = 1650249240
        panda852.originalUrl = "https://www.bilibili.com/video/BV1hY411j7uL"
        panda852.tags = "大熊猫,萌宠,动物圈"
        panda852.authorId = 442701460
        panda852.cover =
            "https://i1.hdslb.com/bfs/archive/b04170c10cecad6714eb271bce8235132a030cc3.jpg"
        list.add(panda852)

        val panda853 = PetVideo()
        panda853.type = VideoType.PANDA.ordinal
        panda853.fileName = "panda_group_panda853"
        panda853.code = 2765
        panda853.duration = 70
        panda853.period = PeriodType.GROUP.ordinal
        panda853.star = false
        panda853.title = "悬崖绝壁上滚下来毫发无损"
        panda853.releaseTime = 1654698794
        panda853.originalUrl = "https://www.bilibili.com/video/BV1BY4y1376u"
        panda853.tags = "大熊猫,萌宠,动物圈"
        panda853.authorId = 1435076062
        panda853.cover =
            "https://i2.hdslb.com/bfs/archive/dfecd6d0d10cd20b37c7457cc018cd348feccc76.jpg"
        list.add(panda853)

        val panda854 = PetVideo()
        panda854.type = VideoType.PANDA.ordinal
        panda854.fileName = "panda_group_panda854"
        panda854.code = 2766
        panda854.duration = 154
        panda854.period = PeriodType.GROUP.ordinal
        panda854.star = false
        panda854.title = "小fa仔：冰蛋糕一点都不好玩辣，我更喜欢啃树枝。【大熊猫】"
        panda854.releaseTime = 1654690841
        panda854.originalUrl = "https://www.bilibili.com/video/BV1NY4y1G7zs"
        panda854.tags = "大熊猫,萌宠,动物圈"
        panda854.authorId = 514531996
        panda854.cover =
            "https://i1.hdslb.com/bfs/archive/52c74ec3c001aac793d636caec3d8da7b6a00f04.jpg"
        list.add(panda854)

        val panda855 = PetVideo()
        panda855.type = VideoType.PANDA.ordinal
        panda855.fileName = "panda_group_panda855"
        panda855.code = 2767
        panda855.duration = 350
        panda855.period = PeriodType.GROUP.ordinal
        panda855.star = false
        panda855.title = "大熊猫润玥和艾玖两岁生日，和花挖煤庆祝"
        panda855.releaseTime = 1654679362
        panda855.originalUrl = "https://www.bilibili.com/video/BV1134y1L7iL"
        panda855.tags = "大熊猫,萌宠,动物圈"
        panda855.authorId = 230382720
        panda855.cover =
            "https://i2.hdslb.com/bfs/archive/1303bdf779e830259d1995a120569ec3df9246f3.jpg"
        list.add(panda855)

        val panda856 = PetVideo()
        panda856.type = VideoType.PANDA.ordinal
        panda856.fileName = "panda_group_panda856"
        panda856.code = 2768
        panda856.duration = 106
        panda856.period = PeriodType.GROUP.ordinal
        panda856.star = false
        panda856.title = "谭爷爷，你再不开门，这个大玩偶我就要抱走了！【大熊猫和花】"
        panda856.releaseTime = 1654679880
        panda856.originalUrl = "https://www.bilibili.com/video/BV1p3411g7pQ"
        panda856.tags = "大熊猫,萌宠,动物圈"
        panda856.authorId = 16468440
        panda856.cover =
            "https://i0.hdslb.com/bfs/archive/ee7b8f23af353e6d87e3c2a3054d407eccec14cf.jpg"
        list.add(panda856)

        val panda857 = PetVideo()
        panda857.type = VideoType.PANDA.ordinal
        panda857.fileName = "panda_group_panda857"
        panda857.code = 2769
        panda857.duration = 135
        panda857.period = PeriodType.GROUP.ordinal
        panda857.star = false
        panda857.title = "【大熊猫润玥&和花】谭爷爷为了让和花吃上苹果，声东击西、调虎离山，二狗表示我才不会上当呢"
        panda857.releaseTime = 1654599840
        panda857.originalUrl = "https://www.bilibili.com/video/BV1M94y1U7Hp"
        panda857.tags = "大熊猫,萌宠,动物圈"
        panda857.authorId = 34677299
        panda857.cover =
            "https://i1.hdslb.com/bfs/archive/1f45ad16fda5be81e4b1f759bd8d5e26c0e0431c.jpg"
        list.add(panda857)

        val panda858 = PetVideo()
        panda858.type = VideoType.PANDA.ordinal
        panda858.fileName = "panda_group_panda858"
        panda858.code = 2770
        panda858.duration = 225
        panda858.period = PeriodType.GROUP.ordinal
        panda858.star = false
        panda858.title = "【大熊猫和花】夏日午休，花主任永动机模式，狠狠教育二狗与和叶#大熊猫和花"
        panda858.releaseTime = 1654603200
        panda858.originalUrl = "https://www.bilibili.com/video/BV1qY411M7UF"
        panda858.tags = "大熊猫,萌宠,动物圈"
        panda858.authorId = 327377672
        panda858.cover =
            "https://i0.hdslb.com/bfs/archive/823c7096fae6b52f21b7e35721fcfcd07e270d86.jpg"
        list.add(panda858)

        val panda859 = PetVideo()
        panda859.type = VideoType.PANDA.ordinal
        panda859.fileName = "panda_group_panda859"
        panda859.code = 2771
        panda859.duration = 82
        panda859.period = PeriodType.GROUP.ordinal
        panda859.star = false
        panda859.title = "和叶：天灵灵地灵灵，我也有生日蛋糕行不行？【大熊猫】"
        panda859.releaseTime = 1654608452
        panda859.originalUrl = "https://www.bilibili.com/video/BV1kT411V73X"
        panda859.tags = "大熊猫,萌宠,动物圈"
        panda859.authorId = 514531996
        panda859.cover =
            "https://i0.hdslb.com/bfs/archive/366f46c7b95c77a679bb8b72efe9dd855f46e6c5.jpg"
        list.add(panda859)

        val panda860 = PetVideo()
        panda860.type = VideoType.PANDA.ordinal
        panda860.fileName = "panda_group_panda860"
        panda860.code = 2772
        panda860.duration = 12
        panda860.period = PeriodType.GROUP.ordinal
        panda860.star = false
        panda860.title = "【大熊猫】小时候的伦伦和洋洋（1999）"
        panda860.releaseTime = 1526342284
        panda860.originalUrl = "https://www.bilibili.com/video/BV1Ep411Z76s"
        panda860.tags = "大熊猫,萌宠,动物圈"
        panda860.authorId = 10350277
        panda860.cover =
            "https://i2.hdslb.com/bfs/archive/f113b53ed5f85755cb391e9010fab781a2badd41.jpg"
        list.add(panda860)

        val panda861 = PetVideo()
        panda861.type = VideoType.PANDA.ordinal
        panda861.fileName = "panda_group_panda861"
        panda861.code = 2773
        panda861.duration = 42
        panda861.period = PeriodType.GROUP.ordinal
        panda861.star = false
        panda861.title = "【大熊猫和花】和花靠着润玥吃竹子，画面好温馨"
        panda861.releaseTime = 1654606801
        panda861.originalUrl = "https://www.bilibili.com/video/BV14g411R7mC"
        panda861.tags = "大熊猫,萌宠,动物圈"
        panda861.authorId = 98871951
        panda861.cover =
            "https://i0.hdslb.com/bfs/archive/0ae04c2e6fd57df0e82a60490e7ba9b9455ffae7.jpg"
        list.add(panda861)

        val panda862 = PetVideo()
        panda862.type = VideoType.PANDA.ordinal
        panda862.fileName = "panda_group_panda862"
        panda862.code = 2774
        panda862.duration = 36
        panda862.period = PeriodType.GROUP.ordinal
        panda862.star = false
        panda862.title = "旋风波浪熊猫【大熊猫和花】"
        panda862.releaseTime = 1654505605
        panda862.originalUrl = "https://www.bilibili.com/video/BV1dL4y1K7nD"
        panda862.tags = "大熊猫,萌宠,动物圈"
        panda862.authorId = 230382720
        panda862.cover =
            "https://i0.hdslb.com/bfs/archive/1c6a89a9fae1c1bce04e441852a7f88efaa2e855.jpg"
        list.add(panda862)

        val panda863 = PetVideo()
        panda863.type = VideoType.PANDA.ordinal
        panda863.fileName = "panda_group_panda863"
        panda863.code = 2775
        panda863.duration = 39
        panda863.period = PeriodType.GROUP.ordinal
        panda863.star = false
        panda863.title = "大熊猫和花-这么盯着我是会被麻袋套走的"
        panda863.releaseTime = 1654514271
        panda863.originalUrl = "https://www.bilibili.com/video/BV1HY411M7rb"
        panda863.tags = "大熊猫,萌宠,动物圈"
        panda863.authorId = 1307515
        panda863.cover =
            "https://i2.hdslb.com/bfs/archive/50035a071dacf09149cded6bf7b454507647b8e3.jpg"
        list.add(panda863)

        val panda864 = PetVideo()
        panda864.type = VideoType.PANDA.ordinal
        panda864.fileName = "panda_group_panda864"
        panda864.code = 2776
        panda864.duration = 673
        panda864.period = PeriodType.GROUP.ordinal
        panda864.star = false
        panda864.title = "2022.06.05 <艾玖&润玥2岁生日会记录> 有个主角为什么出场就跑了? 蛋糕为什么去了沟里?【大熊猫艾玖润玥和花和叶】"
        panda864.releaseTime = 1654498285
        panda864.originalUrl = "https://www.bilibili.com/video/BV1AW4y1y77j"
        panda864.tags = "大熊猫,萌宠,动物圈"
        panda864.authorId = 16468440
        panda864.cover =
            "https://i2.hdslb.com/bfs/archive/864603e9341ff018c0bcac5e1a5cb3d560b56fe3.png"
        list.add(panda864)

        val panda865 = PetVideo()
        panda865.type = VideoType.PANDA.ordinal
        panda865.fileName = "panda_group_panda865"
        panda865.code = 2777
        panda865.duration = 37
        panda865.period = PeriodType.GROUP.ordinal
        panda865.star = false
        panda865.vertical = true
        panda865.title = "国宝集体沐浴现场"
        panda865.releaseTime = 1654485000
        panda865.originalUrl = "https://www.bilibili.com/video/BV1FU4y117KN"
        panda865.tags = "大熊猫,萌宠,动物圈"
        panda865.authorId = 1025949925
        panda865.cover =
            "https://i0.hdslb.com/bfs/archive/e4b21186d056a115583944f9463eface9ca3a616.jpg"
        list.add(panda865)

        val panda866 = PetVideo()
        panda866.type = VideoType.PANDA.ordinal
        panda866.fileName = "panda_group_panda866"
        panda866.code = 2778
        panda866.duration = 44
        panda866.period = PeriodType.GROUP.ordinal
        panda866.star = false
        panda866.title = "大熊猫和花-别看我，我敲凶的"
        panda866.releaseTime = 1653164262
        panda866.originalUrl = "https://www.bilibili.com/video/BV19F411L7tL"
        panda866.tags = "大熊猫,萌宠,动物圈"
        panda866.authorId = 1307515
        panda866.cover =
            "https://i2.hdslb.com/bfs/archive/188305beb4d63814d32794eb050834637c2f6109.jpg"
        list.add(panda866)

        val panda867 = PetVideo()
        panda867.type = VideoType.PANDA.ordinal
        panda867.fileName = "panda_group_panda867"
        panda867.code = 2779
        panda867.duration = 83
        panda867.period = PeriodType.GROUP.ordinal
        panda867.star = false
        panda867.title = "芝士芝麻两兄弟吃播"
        panda867.releaseTime = 1595314949
        panda867.originalUrl = "https://www.bilibili.com/video/BV1bC4y1b7Hj"
        panda867.tags = "大熊猫,萌宠,动物圈"
        panda867.authorId = 19715714
        panda867.cover =
            "https://i2.hdslb.com/bfs/archive/39b156265692bb08e4a1a93cc2a0cb8526200b77.jpg"
        list.add(panda867)

        val panda868 = PetVideo()
        panda868.type = VideoType.PANDA.ordinal
        panda868.fileName = "panda_group_panda868"
        panda868.code = 2780
        panda868.duration = 327
        panda868.period = PeriodType.GROUP.ordinal
        panda868.star = false
        panda868.title = "龙凤胎大熊猫姐弟和花和叶一起吃零食"
        panda868.releaseTime = 1654399765
        panda868.originalUrl = "https://www.bilibili.com/video/BV1F34y1L7ns"
        panda868.tags = "大熊猫,萌宠,动物圈"
        panda868.authorId = 230382720
        panda868.cover =
            "https://i0.hdslb.com/bfs/archive/b9f62dd49a43e0563368babb115c44b772edb23e.jpg"
        list.add(panda868)

        val panda869 = PetVideo()
        panda869.type = VideoType.PANDA.ordinal
        panda869.fileName = "panda_group_panda869"
        panda869.code = 2781
        panda869.duration = 58
        panda869.period = PeriodType.GROUP.ordinal
        panda869.star = false
        panda869.title = "禁止在饭桌上挠耳朵挠jiojio，游客会忍不住吹彩虹P。【大熊猫和花】"
        panda869.releaseTime = 1654351461
        panda869.originalUrl = "https://www.bilibili.com/video/BV1MY4y157z2"
        panda869.tags = "大熊猫,萌宠,动物圈"
        panda869.authorId = 514531996
        panda869.cover =
            "https://i0.hdslb.com/bfs/archive/8883649c28cbeac090a66796e8b0a1d6668b6c0e.jpg"
        list.add(panda869)

        val panda870 = PetVideo()
        panda870.type = VideoType.PANDA.ordinal
        panda870.fileName = "panda_group_panda870"
        panda870.code = 2782
        panda870.duration = 13
        panda870.period = PeriodType.GROUP.ordinal
        panda870.star = false
        panda870.title = "大熊猫和花-万绿丛中一朵花"
        panda870.releaseTime = 1630860508
        panda870.originalUrl = "https://www.bilibili.com/video/BV1Fh411s7qE"
        panda870.tags = "大熊猫,萌宠,动物圈"
        panda870.authorId = 1307515
        panda870.cover =
            "https://i0.hdslb.com/bfs/archive/1e132d52a00d02824fd5f483de041a263b9da814.jpg"
        list.add(panda870)

        val panda871 = PetVideo()
        panda871.type = VideoType.PANDA.ordinal
        panda871.fileName = "panda_group_panda871"
        panda871.code = 2783
        panda871.duration = 41
        panda871.period = PeriodType.GROUP.ordinal
        panda871.star = false
        panda871.title = "大熊猫和花-咕涌小熊"
        panda871.releaseTime = 1654352700
        panda871.originalUrl = "https://www.bilibili.com/video/BV16Y4y1V7Ex"
        panda871.tags = "大熊猫,萌宠,动物圈"
        panda871.authorId = 1307515
        panda871.cover =
            "https://i0.hdslb.com/bfs/archive/9a4ae8cc7033bd8dfef120eb7abef99a010762b2.jpg"
        list.add(panda871)

        val panda872 = PetVideo()
        panda872.type = VideoType.PANDA.ordinal
        panda872.fileName = "panda_group_panda872"
        panda872.code = 2784
        panda872.duration = 78
        panda872.period = PeriodType.GROUP.ordinal
        panda872.star = false
        panda872.title = "祝幼年一班大姐大和大姐头2岁生快！开心幸福！！【大熊猫润玥 大熊猫艾玖】"
        panda872.releaseTime = 1654355749
        panda872.originalUrl = "https://www.bilibili.com/video/BV1QY411T7xp"
        panda872.tags = "大熊猫,萌宠,动物圈"
        panda872.authorId = 16468440
        panda872.cover =
            "https://i0.hdslb.com/bfs/archive/414e57ff0b9ab8e119364854377f2d8f74c7553f.jpg"
        list.add(panda872)

        val panda873 = PetVideo()
        panda873.type = VideoType.PANDA.ordinal
        panda873.fileName = "panda_group_panda873"
        panda873.code = 2785
        panda873.duration = 131
        panda873.period = PeriodType.GROUP.ordinal
        panda873.star = false
        panda873.title = "【大熊猫】二班五只开晨会，茱萸妹妹展示新技能，用鼻子破竹"
        panda873.releaseTime = 1654344880
        panda873.originalUrl = "https://www.bilibili.com/video/BV1ZY4y1V7Z7"
        panda873.tags = "大熊猫,萌宠,动物圈"
        panda873.authorId = 34677299
        panda873.cover =
            "https://i1.hdslb.com/bfs/archive/945097c1e6683136afa5293d9d546e16a476b939.jpg"
        list.add(panda873)

        val panda874 = PetVideo()
        panda874.type = VideoType.PANDA.ordinal
        panda874.fileName = "panda_group_panda874"
        panda874.code = 2786
        panda874.duration = 72
        panda874.period = PeriodType.GROUP.ordinal
        panda874.star = false
        panda874.title = "最喜欢和花艾玖同框了 像豚鼠和米老鼠！"
        panda874.releaseTime = 1654337185
        panda874.originalUrl = "https://www.bilibili.com/video/BV1a34y1L7th"
        panda874.tags = "大熊猫,萌宠,动物圈"
        panda874.authorId = 4120384
        panda874.cover =
            "https://i2.hdslb.com/bfs/archive/71be1d6ca3e084788a756e36576706f2bc2842cd.jpg"
        list.add(panda874)

        val panda875 = PetVideo()
        panda875.type = VideoType.PANDA.ordinal
        panda875.fileName = "panda_group_panda875"
        panda875.code = 2787
        panda875.duration = 146
        panda875.period = PeriodType.GROUP.ordinal
        panda875.star = false
        panda875.title = "月亮产房霸王花——嗷 和叶 ！【大熊猫和花 】"
        panda875.releaseTime = 1654333485
        panda875.originalUrl = "https://www.bilibili.com/video/BV1FB4y197ZX"
        panda875.tags = "大熊猫,萌宠,动物圈"
        panda875.authorId = 16468440
        panda875.cover =
            "https://i1.hdslb.com/bfs/archive/e1168d8079691e134d83f076685ecdb70f3cf490.jpg"
        list.add(panda875)

        val panda876 = PetVideo()
        panda876.type = VideoType.PANDA.ordinal
        panda876.fileName = "panda_group_panda876"
        panda876.code = 2788
        panda876.duration = 180
        panda876.period = PeriodType.GROUP.ordinal
        panda876.star = false
        panda876.title = "月亮产房霸王花——嗷润玥！【大熊猫和花 】"
        panda876.releaseTime = 1654313160
        panda876.originalUrl = "https://www.bilibili.com/video/BV1wt4y1W7VD"
        panda876.tags = "大熊猫,萌宠,动物圈"
        panda876.authorId = 16468440
        panda876.cover =
            "https://i2.hdslb.com/bfs/archive/2d78607c6dd99df739dab06d946e7becbd10e8ba.jpg"
        list.add(panda876)

        val panda877 = PetVideo()
        panda877.type = VideoType.PANDA.ordinal
        panda877.fileName = "panda_group_panda877"
        panda877.code = 2789
        panda877.duration = 98
        panda877.period = PeriodType.GROUP.ordinal
        panda877.star = false
        panda877.title = "月亮产房霸王花——嗷艾玖！【大熊猫和花 】"
        panda877.releaseTime = 1654299481
        panda877.originalUrl = "https://www.bilibili.com/video/BV1L94y1m7wq"
        panda877.tags = "大熊猫,萌宠,动物圈"
        panda877.authorId = 16468440
        panda877.cover =
            "https://i2.hdslb.com/bfs/archive/d4e68f6709eb598a4548648b8c6cf670e0f0822e.jpg"
        list.add(panda877)

        val panda878 = PetVideo()
        panda878.type = VideoType.PANDA.ordinal
        panda878.fileName = "panda_group_panda878"
        panda878.code = 2790
        panda878.duration = 48
        panda878.period = PeriodType.GROUP.ordinal
        panda878.star = false
        panda878.title = "【大熊猫和花】超可爱和花"
        panda878.releaseTime = 1654258500
        panda878.originalUrl = "https://www.bilibili.com/video/BV1cZ4y1t7wQ"
        panda878.tags = "大熊猫,萌宠,动物圈"
        panda878.authorId = 327377672
        panda878.cover =
            "https://i0.hdslb.com/bfs/archive/a9c875618ba7bb7d9376190c24df8c8018ee6d87.jpg"
        list.add(panda878)

        val panda879 = PetVideo()
        panda879.type = VideoType.PANDA.ordinal
        panda879.fileName = "panda_group_panda879"
        panda879.code = 2791
        panda879.duration = 33
        panda879.period = PeriodType.GROUP.ordinal
        panda879.star = false
        panda879.title = "大熊猫和花和叶-底层姐弟的battle训练"
        panda879.releaseTime = 1654244760
        panda879.originalUrl = "https://www.bilibili.com/video/BV19Y411T7Uu"
        panda879.tags = "大熊猫,萌宠,动物圈"
        panda879.authorId = 1307515
        panda879.cover =
            "https://i0.hdslb.com/bfs/archive/4beb08c8fcd74930352d4b1348b804bac89ce2d9.jpg"
        list.add(panda879)

        val panda880 = PetVideo()
        panda880.type = VideoType.PANDA.ordinal
        panda880.fileName = "panda_group_panda880"
        panda880.code = 2792
        panda880.duration = 155
        panda880.period = PeriodType.GROUP.ordinal
        panda880.star = false
        panda880.title = "【大熊猫妮娜】吊床上的小仙女娜娜睡觉觉"
        panda880.releaseTime = 1654034936
        panda880.originalUrl = "https://www.bilibili.com/video/BV1PW4y1C71V"
        panda880.tags = "大熊猫,萌宠,动物圈"
        panda880.authorId = 1425086760
        panda880.cover =
            "https://i0.hdslb.com/bfs/archive/9f63d40e05c6bde0194dd5b609aa8f86feb7181b.jpg"
        list.add(panda880)

        val panda881 = PetVideo()
        panda881.type = VideoType.PANDA.ordinal
        panda881.fileName = "panda_group_panda881"
        panda881.code = 2793
        panda881.duration = 219
        panda881.period = PeriodType.GROUP.ordinal
        panda881.star = false
        panda881.vertical = true
        panda881.title = "难姐难弟，干饭熊太难了！（还好晚上有小灶，饿不到）"
        panda881.releaseTime = 1654142243
        panda881.originalUrl = "https://www.bilibili.com/video/BV1TA4y1o7RD"
        panda881.tags = "大熊猫,萌宠,动物圈"
        panda881.authorId = 1025949925
        panda881.cover =
            "https://i2.hdslb.com/bfs/archive/e7222b1b5a688705999ea212518f2022636b311b.jpg"
        list.add(panda881)

        val panda882 = PetVideo()
        panda882.type = VideoType.PANDA.ordinal
        panda882.fileName = "panda_group_panda882"
        panda882.code = 2794
        panda882.duration = 118
        panda882.period = PeriodType.GROUP.ordinal
        panda882.star = false
        panda882.title = "【大熊猫和花】和叶踩和花头，尽显弟王风范。花：这弟弟真让我头大"
        panda882.releaseTime = 1654084800
        panda882.originalUrl = "https://www.bilibili.com/video/BV1mU4y1y76L"
        panda882.tags = "大熊猫,萌宠,动物圈"
        panda882.authorId = 327377672
        panda882.cover =
            "https://i1.hdslb.com/bfs/archive/828e6af9f1cc687c7818736687fe844e9dba5fff.jpg"
        list.add(panda882)

        val panda883 = PetVideo()
        panda883.type = VideoType.PANDA.ordinal
        panda883.fileName = "panda_group_panda883"
        panda883.code = 2795
        panda883.duration = 79
        panda883.period = PeriodType.GROUP.ordinal
        panda883.star = false
        panda883.title = "和花：竹子？我的竹子呢？吃着吃着就飞啦？"
        panda883.releaseTime = 1654143662
        panda883.originalUrl = "https://www.bilibili.com/video/BV1sW4y1C7yH"
        panda883.tags = "大熊猫,萌宠,动物圈"
        panda883.authorId = 34677299
        panda883.cover =
            "https://i1.hdslb.com/bfs/archive/88385ce1c68d0ba0db66204f2b2fc7cd5953dff8.jpg"
        list.add(panda883)

        val panda884 = PetVideo()
        panda884.type = VideoType.PANDA.ordinal
        panda884.fileName = "panda_group_panda884"
        panda884.code = 2796
        panda884.duration = 39
        panda884.period = PeriodType.GROUP.ordinal
        panda884.star = false
        panda884.title = "【大熊猫和花】爷爷别叫我，和花好累要休息了"
        panda884.releaseTime = 1647007306
        panda884.originalUrl = "https://www.bilibili.com/video/BV1dS4y1S7BJ"
        panda884.tags = "大熊猫,萌宠,动物圈"
        panda884.authorId = 18329821
        panda884.cover =
            "https://i1.hdslb.com/bfs/archive/2d10cb6a6ed615fc961e20ee892c7c28fea00f97.jpg"
        list.add(panda884)

        val panda885 = PetVideo()
        panda885.type = VideoType.PANDA.ordinal
        panda885.fileName = "panda_group_panda885"
        panda885.code = 2797
        panda885.duration = 67
        panda885.period = PeriodType.GROUP.ordinal
        panda885.star = false
        panda885.title = "【大熊猫和花】和花，你的游戏时间已到，明天请继续充值果果"
        panda885.releaseTime = 1654084800
        panda885.originalUrl = "https://www.bilibili.com/video/BV1pY4y1V7PX"
        panda885.tags = "大熊猫,萌宠,动物圈"
        panda885.authorId = 98871951
        panda885.cover =
            "https://i2.hdslb.com/bfs/archive/7158e718b9595f4f7f67c84430ee4f815dceb722.jpg"
        list.add(panda885)

        val panda886 = PetVideo()
        panda886.type = VideoType.PANDA.ordinal
        panda886.fileName = "panda_group_panda886"
        panda886.code = 2798
        panda886.duration = 120
        panda886.period = PeriodType.GROUP.ordinal
        panda886.star = false
        panda886.title = "家里有熊猫，锻炼效果堪比健身房"
        panda886.releaseTime = 1594285855
        panda886.originalUrl = "https://www.bilibili.com/video/BV14C4y1h7wM"
        panda886.tags = "大熊猫,萌宠,动物圈"
        panda886.authorId = 12444306
        panda886.cover =
            "https://i1.hdslb.com/bfs/archive/a41c4c56ab7a7787b63421e16c3d32f670826d28.jpg"
        list.add(panda886)

        val panda887 = PetVideo()
        panda887.type = VideoType.PANDA.ordinal
        panda887.fileName = "panda_group_panda887"
        panda887.code = 2799
        panda887.duration = 93
        panda887.period = PeriodType.GROUP.ordinal
        panda887.star = false
        panda887.title = "大熊猫爬树被奶妈吐槽啦！自己有多重心里没点数吗？"
        panda887.releaseTime = 1553759060
        panda887.originalUrl = "https://www.bilibili.com/video/BV1pb411x7AE"
        panda887.tags = "大熊猫,萌宠,动物圈"
        panda887.authorId = 12444306
        panda887.cover =
            "https://i0.hdslb.com/bfs/archive/a7716a2b03f36e8080d23cb6ec6fce8a148c88a1.jpg"
        list.add(panda887)

        val panda888 = PetVideo()
        panda888.type = VideoType.PANDA.ordinal
        panda888.fileName = "panda_group_panda888"
        panda888.code = 2800
        panda888.duration = 128
        panda888.period = PeriodType.GROUP.ordinal
        panda888.star = false
        panda888.title = "祝——和花和叶润玥艾玖四嘟嘟们“六一儿童节”快乐！！"
        panda888.releaseTime = 1654039681
        panda888.originalUrl = "https://www.bilibili.com/video/BV1p34y177f7"
        panda888.tags = "大熊猫,萌宠,动物圈"
        panda888.authorId = 16468440
        panda888.cover =
            "https://i2.hdslb.com/bfs/archive/d6a3d505fd5fbf376bdf87f48750e6ac8f0ce2d3.jpg"
        list.add(panda888)

        val panda889 = PetVideo()
        panda889.type = VideoType.PANDA.ordinal
        panda889.fileName = "panda_group_panda889"
        panda889.code = 2801
        panda889.duration = 113
        panda889.period = PeriodType.GROUP.ordinal
        panda889.star = false
        panda889.title = "当我不开心的时候，总能从我的姐姐那里得到力量！她叫成和花！【大熊猫和花 和叶】"
        panda889.releaseTime = 1653537280
        panda889.originalUrl = "https://www.bilibili.com/video/BV1Ar4y1t7Xq"
        panda889.tags = "大熊猫,萌宠,动物圈"
        panda889.authorId = 16468440
        panda889.cover =
            "https://i2.hdslb.com/bfs/archive/bfc094347047018aa7911b7edc0335ab49df87d1.jpg"
        list.add(panda889)

        val panda890 = PetVideo()
        panda890.type = VideoType.PANDA.ordinal
        panda890.fileName = "panda_group_panda890"
        panda890.code = 2802
        panda890.duration = 88
        panda890.period = PeriodType.GROUP.ordinal
        panda890.star = false
        panda890.title = "润玥在沟里吃竹子，和花来贴贴！润玥一把搂住了和花的脖子?肩膀?总之好有爱哦！【大熊猫和花 润玥】"
        panda890.releaseTime = 1653967680
        panda890.originalUrl = "https://www.bilibili.com/video/BV1eY4y1V7L8"
        panda890.tags = "大熊猫,萌宠,动物圈"
        panda890.authorId = 16468440
        panda890.cover =
            "https://i0.hdslb.com/bfs/archive/2013bf8dc8700ecb964e206158d3e300e7fd6afc.jpg"
        list.add(panda890)

        val panda891 = PetVideo()
        panda891.type = VideoType.PANDA.ordinal
        panda891.fileName = "panda_group_panda891"
        panda891.code = 2803
        panda891.duration = 68
        panda891.period = PeriodType.GROUP.ordinal
        panda891.star = false
        panda891.title = "干饭熊润玥润二狗的大头吃播"
        panda891.releaseTime = 1653750007
        panda891.originalUrl = "https://www.bilibili.com/video/BV1fY411u7BM"
        panda891.tags = "大熊猫,萌宠,动物圈"
        panda891.authorId = 627116323
        panda891.cover =
            "https://i0.hdslb.com/bfs/archive/6c62b8cb9ce4292ae57c58a8a75678fa35b863b9.jpg"
        list.add(panda891)

        val panda892 = PetVideo()
        panda892.type = VideoType.PANDA.ordinal
        panda892.fileName = "panda_group_panda892"
        panda892.code = 2804
        panda892.duration = 158
        panda892.period = PeriodType.GROUP.ordinal
        panda892.star = false
        panda892.title = "【大熊猫和花】眼巴巴的望着两脚兽，太乖了！"
        panda892.releaseTime = 1653900962
        panda892.originalUrl = "https://www.bilibili.com/video/BV1v341137c5"
        panda892.tags = "大熊猫,萌宠,动物圈"
        panda892.authorId = 1268354648
        panda892.cover =
            "https://i2.hdslb.com/bfs/archive/88044daab4f83db5c77a6cc58182113693599716.jpg"
        list.add(panda892)

        val panda893 = PetVideo()
        panda893.type = VideoType.PANDA.ordinal
        panda893.fileName = "panda_group_panda893"
        panda893.code = 2805
        panda893.duration = 103
        panda893.period = PeriodType.GROUP.ordinal
        panda893.star = false
        panda893.title = "下雨天的和和花像开了挂一样【大熊猫和花&润玥】"
        panda893.releaseTime = 1637062488
        panda893.originalUrl = "https://www.bilibili.com/video/BV16v411M7qC"
        panda893.tags = "大熊猫,萌宠,动物圈"
        panda893.authorId = 230382720
        panda893.cover =
            "https://i0.hdslb.com/bfs/archive/0e975515cabf42e1e2f5e3dd604de74d7bc5d6bd.jpg"
        list.add(panda893)

        val panda894 = PetVideo()
        panda894.type = VideoType.PANDA.ordinal
        panda894.fileName = "panda_group_panda894"
        panda894.code = 2806
        panda894.duration = 145
        panda894.period = PeriodType.GROUP.ordinal
        panda894.star = false
        panda894.title = "艾玖在认真吃竹子，和花在……撩架?！翻滚！自娱自乐！【大熊猫和花 艾玖】"
        panda894.releaseTime = 1653795000
        panda894.originalUrl = "https://www.bilibili.com/video/BV1gW4y1C7ow"
        panda894.tags = "大熊猫,萌宠,动物圈"
        panda894.authorId = 16468440
        panda894.cover =
            "https://i2.hdslb.com/bfs/archive/f441bed5a6687e36d21f43a0bce58b18f16ea293.jpg"
        list.add(panda894)

        val panda895 = PetVideo()
        panda895.type = VideoType.PANDA.ordinal
        panda895.fileName = "panda_group_panda895"
        panda895.code = 2807
        panda895.duration = 71
        panda895.period = PeriodType.GROUP.ordinal
        panda895.star = false
        panda895.title = "两个小熊友撩架都这么温柔，好可爱！【大熊猫福双 茱萸】"
        panda895.releaseTime = 1653726600
        panda895.originalUrl = "https://www.bilibili.com/video/BV1eU4y127SJ"
        panda895.tags = "大熊猫,萌宠,动物圈"
        panda895.authorId = 16468440
        panda895.cover =
            "https://i0.hdslb.com/bfs/archive/d2e9f5ab8b5471c0a5f43be4fbf5c512c8bfc5d6.jpg"
        list.add(panda895)

        val panda896 = PetVideo()
        panda896.type = VideoType.PANDA.ordinal
        panda896.fileName = "panda_group_panda896"
        panda896.code = 2808
        panda896.duration = 62
        panda896.period = PeriodType.GROUP.ordinal
        panda896.star = false
        panda896.title = "我发现了，没有金喜和重阳参加的钓猫活动，画风都不一样"
        panda896.releaseTime = 1653570000
        panda896.originalUrl = "https://www.bilibili.com/video/BV1PY4y1L71K"
        panda896.tags = "大熊猫,萌宠,动物圈"
        panda896.authorId = 98871951
        panda896.cover =
            "https://i0.hdslb.com/bfs/archive/4f5a1bf31de93265ec55bd671002b6d61a008c4c.jpg"
        list.add(panda896)

        val panda897 = PetVideo()
        panda897.type = VideoType.PANDA.ordinal
        panda897.fileName = "panda_group_panda897"
        panda897.code = 2809
        panda897.duration = 195
        panda897.period = PeriodType.GROUP.ordinal
        panda897.star = false
        panda897.vertical = true
        panda897.title = "和花的干饭心得：最危险的地方就是最安全的地方"
        panda897.releaseTime = 1653536260
        panda897.originalUrl = "https://www.bilibili.com/video/BV1bg411o7xj"
        panda897.tags = "大熊猫,萌宠,动物圈"
        panda897.authorId = 1025949925
        panda897.cover =
            "https://i0.hdslb.com/bfs/archive/dece55512132edb1fdc8cc94ef5c45df1f52fa07.jpg"
        list.add(panda897)

        val panda898 = PetVideo()
        panda898.type = VideoType.PANDA.ordinal
        panda898.fileName = "panda_group_panda898"
        panda898.code = 2810
        panda898.duration = 152
        panda898.period = PeriodType.GROUP.ordinal
        panda898.star = false
        panda898.title = "吃窝头苹果有多开心？嘤嘤班齐声答：一起嘤嘤一起抢一直开心！【大熊猫】"
        panda898.releaseTime = 1653655017
        panda898.originalUrl = "https://www.bilibili.com/video/BV1MY4y1L7bp"
        panda898.tags = "大熊猫,萌宠,动物圈"
        panda898.authorId = 514531996
        panda898.cover =
            "https://i1.hdslb.com/bfs/archive/e707076eabf1c9b07d15a691ed52a976726e8b3e.jpg"
        list.add(panda898)

        val panda899 = PetVideo()
        panda899.type = VideoType.PANDA.ordinal
        panda899.fileName = "panda_group_panda899"
        panda899.code = 2811
        panda899.duration = 266
        panda899.period = PeriodType.GROUP.ordinal
        panda899.star = false
        panda899.title = "和花来啦！睡撒子睡，哼！挑笋剥笋递笋苹果中转站的公积全部交出来！【大熊猫和花 润玥】"
        panda899.releaseTime = 1653642000
        panda899.originalUrl = "https://www.bilibili.com/video/BV1E54y1o7UN"
        panda899.tags = "大熊猫,萌宠,动物圈"
        panda899.authorId = 16468440
        panda899.cover =
            "https://i1.hdslb.com/bfs/archive/7329da2e03de5766e391faae6c12d7bfffbca488.jpg"
        list.add(panda899)

        val panda900 = PetVideo()
        panda900.type = VideoType.PANDA.ordinal
        panda900.fileName = "panda_group_panda900"
        panda900.code = 2812
        panda900.duration = 317
        panda900.period = PeriodType.GROUP.ordinal
        panda900.star = false
        panda900.title = "【大熊猫和花】三只小熊"
        panda900.releaseTime = 1652056219
        panda900.originalUrl = "https://www.bilibili.com/video/BV1hZ4y1C7ax"
        panda900.tags = "大熊猫,萌宠,动物圈"
        panda900.authorId = 319237435
        panda900.cover =
            "https://i0.hdslb.com/bfs/archive/93765e4e994f5a194acd20ee165e9e2a33620590.jpg"
        list.add(panda900)

        val panda901 = PetVideo()
        panda901.type = VideoType.PANDA.ordinal
        panda901.fileName = "panda_group_panda901"
        panda901.code = 2813
        panda901.duration = 139
        panda901.period = PeriodType.GROUP.ordinal
        panda901.star = false
        panda901.title = "幼年2班5小只，一起吃早饭！姿势各不相同！【大熊猫福双茱萸重阳金喜金双】"
        panda901.releaseTime = 1653521400
        panda901.originalUrl = "https://www.bilibili.com/video/BV1dT4y1q71H"
        panda901.tags = "大熊猫,萌宠,动物圈"
        panda901.authorId = 16468440
        panda901.cover =
            "https://i1.hdslb.com/bfs/archive/992817b43983f341ab04ae7e6d53e3182aa2a408.jpg"
        list.add(panda901)

        val panda902 = PetVideo()
        panda902.type = VideoType.PANDA.ordinal
        panda902.fileName = "panda_group_panda902"
        panda902.code = 2814
        panda902.duration = 71
        panda902.period = PeriodType.GROUP.ordinal
        panda902.star = false
        panda902.title = "努力的一天开始了，和花！！【大熊猫和花】"
        panda902.releaseTime = 1653436810
        panda902.originalUrl = "https://www.bilibili.com/video/BV1bZ4y1b79t"
        panda902.tags = "大熊猫,萌宠,动物圈"
        panda902.authorId = 16468440
        panda902.cover =
            "https://i2.hdslb.com/bfs/archive/ee8746a7361404e8244773390e7b4dab1eeaf3d6.jpg"
        list.add(panda902)

        val panda903 = PetVideo()
        panda903.type = VideoType.PANDA.ordinal
        panda903.fileName = "panda_group_panda903"
        panda903.code = 2815
        panda903.duration = 32
        panda903.period = PeriodType.GROUP.ordinal
        panda903.star = false
        panda903.title = "【大熊猫和花】这个动作太乖了"
        panda903.releaseTime = 1653393600
        panda903.originalUrl = "https://www.bilibili.com/video/BV1Q54y1Z7aJ"
        panda903.tags = "大熊猫,萌宠,动物圈"
        panda903.authorId = 327377672
        panda903.cover =
            "https://i0.hdslb.com/bfs/archive/dbf6b7eaf24de5f9f6b10940b916063f221aa0e2.jpg"
        list.add(panda903)

        val panda904 = PetVideo()
        panda904.type = VideoType.PANDA.ordinal
        panda904.fileName = "panda_group_panda904"
        panda904.code = 2816
        panda904.duration = 199
        panda904.period = PeriodType.GROUP.ordinal
        panda904.star = false
        panda904.title = "难得有润玥不香窝头的时候，也没抢和花的苹果，艾玖的肚肚长好多"
        panda904.releaseTime = 1653383471
        panda904.originalUrl = "https://www.bilibili.com/video/BV1MY4y167Hp"
        panda904.tags = "大熊猫,萌宠,动物圈"
        panda904.authorId = 230382720
        panda904.cover =
            "https://i1.hdslb.com/bfs/archive/ba84d0afc28d4b4c45f1c376c9d67a516935b112.jpg"
        list.add(panda904)

        val panda905 = PetVideo()
        panda905.type = VideoType.PANDA.ordinal
        panda905.fileName = "panda_group_panda905"
        panda905.code = 2817
        panda905.duration = 108
        panda905.period = PeriodType.GROUP.ordinal
        panda905.star = false
        panda905.vertical = true
        panda905.title = "和花终于出气了"
        panda905.releaseTime = 1653362187
        panda905.originalUrl = "https://www.bilibili.com/video/BV1p94y1U7nS"
        panda905.tags = "大熊猫,萌宠,动物圈"
        panda905.authorId = 1025949925
        panda905.cover =
            "https://i2.hdslb.com/bfs/archive/048d96608e7895eb29ef41eca805aa70f84e8849.jpg"
        list.add(panda905)

        val panda906 = PetVideo()
        panda906.type = VideoType.PANDA.ordinal
        panda906.fileName = "panda_group_panda906"
        panda906.code = 2818
        panda906.duration = 118
        panda906.period = PeriodType.GROUP.ordinal
        panda906.star = false
        panda906.title = "二狗子:来，花宝叽，帮我拿着，吃完我再来吃"
        panda906.releaseTime = 1653220853
        panda906.originalUrl = "https://www.bilibili.com/video/BV1YY4y167Th"
        panda906.tags = "大熊猫,萌宠,动物圈"
        panda906.authorId = 335419800
        panda906.cover =
            "https://i0.hdslb.com/bfs/archive/598233a9ca94e875b9f54e143c63516ab8a9f03e.jpg"
        list.add(panda906)

        val panda907 = PetVideo()
        panda907.type = VideoType.PANDA.ordinal
        panda907.fileName = "panda_group_panda907"
        panda907.code = 2819
        panda907.duration = 67
        panda907.period = PeriodType.GROUP.ordinal
        panda907.star = false
        panda907.title = "和花:窝明明是在吃笋，咋就倒地上了"
        panda907.releaseTime = 1653013124
        panda907.originalUrl = "https://www.bilibili.com/video/BV16T4y1z7qi"
        panda907.tags = "大熊猫,萌宠,动物圈"
        panda907.authorId = 1561719766
        panda907.cover =
            "https://i2.hdslb.com/bfs/archive/b53803f230c088d0480816877f29663b6edc1f39.jpg"
        list.add(panda907)

        val panda908 = PetVideo()
        panda908.type = VideoType.PANDA.ordinal
        panda908.fileName = "panda_group_panda908"
        panda908.code = 2820
        panda908.duration = 189
        panda908.period = PeriodType.GROUP.ordinal
        panda908.star = false
        panda908.title = "园丁和花下雨天上班更卖力了【大熊猫和花】"
        panda908.releaseTime = 1653210298
        panda908.originalUrl = "https://www.bilibili.com/video/BV1F34y1J7U9"
        panda908.tags = "大熊猫,萌宠,动物圈"
        panda908.authorId = 230382720
        panda908.cover =
            "https://i0.hdslb.com/bfs/archive/639647bbb8aff64eaf4db4e644e9fbc014760ca5.jpg"
        list.add(panda908)

        val panda909 = PetVideo()
        panda909.type = VideoType.PANDA.ordinal
        panda909.fileName = "panda_group_panda909"
        panda909.code = 2821
        panda909.duration = 542
        panda909.period = PeriodType.GROUP.ordinal
        panda909.star = false
        panda909.title = "我的看猫周记（1）- 记录基地熊猫日常和趣事。(出场顺序按拍摄时间)"
        panda909.releaseTime = 1653139800
        panda909.originalUrl = "https://www.bilibili.com/video/BV1nP4y1F7K3"
        panda909.tags = "大熊猫,萌宠,动物圈"
        panda909.authorId = 514531996
        panda909.cover =
            "https://i0.hdslb.com/bfs/archive/66ec061fd486b0facd173d1f4fd2be18b0c69455.jpg"
        list.add(panda909)

        val panda910 = PetVideo()
        panda910.type = VideoType.PANDA.ordinal
        panda910.fileName = "panda_group_panda910"
        panda910.code = 2822
        panda910.duration = 59
        panda910.period = PeriodType.GROUP.ordinal
        panda910.star = false
        panda910.title = "和花：我弟弟超勇的！不是战五渣"
        panda910.releaseTime = 1653048000
        panda910.originalUrl = "https://www.bilibili.com/video/BV1pT4y1z7Pj"
        panda910.tags = "大熊猫,萌宠,动物圈"
        panda910.authorId = 327377672
        panda910.cover =
            "https://i1.hdslb.com/bfs/archive/fcc22faf38ef1d2067b2f6a50d2f452d4fb60d2b.jpg"
        list.add(panda910)

        val panda911 = PetVideo()
        panda911.type = VideoType.PANDA.ordinal
        panda911.fileName = "panda_group_panda911"
        panda911.code = 2823
        panda911.duration = 132
        panda911.period = PeriodType.GROUP.ordinal
        panda911.star = false
        panda911.title = "爷爷叫和花吃笋，和花一心只想找爷爷。【大熊猫和花】"
        panda911.releaseTime = 1653031801
        panda911.originalUrl = "https://www.bilibili.com/video/BV1KP4y1F738"
        panda911.tags = "大熊猫,萌宠,动物圈"
        panda911.authorId = 514531996
        panda911.cover =
            "https://i0.hdslb.com/bfs/archive/02bddb827b28ca922a4a8978486306fab39e75e7.jpg"
        list.add(panda911)

        val panda912 = PetVideo()
        panda912.type = VideoType.PANDA.ordinal
        panda912.fileName = "panda_group_panda912"
        panda912.code = 2824
        panda912.duration = 65
        panda912.period = PeriodType.GROUP.ordinal
        panda912.star = false
        panda912.title = "福来：小姨？奇一：我在生气，不要管我！福来：好的，你继续！"
        panda912.releaseTime = 1652885161
        panda912.originalUrl = "https://www.bilibili.com/video/BV1w3411P72m"
        panda912.tags = "大熊猫,萌宠,动物圈"
        panda912.authorId = 627116323
        panda912.cover =
            "https://i0.hdslb.com/bfs/archive/e01cc6e865f20e63c4e4f21c992875c00257412a.jpg"
        list.add(panda912)

        val panda913 = PetVideo()
        panda913.type = VideoType.PANDA.ordinal
        panda913.fileName = "panda_group_panda913"
        panda913.code = 2825
        panda913.duration = 716
        panda913.period = PeriodType.GROUP.ordinal
        panda913.star = false
        panda913.title = "谭爷爷出来接和花回去做检查，和花太费爷爷了，爷爷的耐心太好了，千呼万唤外加小果果终于哄回了家！【大熊猫和花 】"
        panda913.releaseTime = 1652933040
        panda913.originalUrl = "https://www.bilibili.com/video/BV1jS4y1874L"
        panda913.tags = "大熊猫,萌宠,动物圈"
        panda913.authorId = 16468440
        panda913.cover =
            "https://i2.hdslb.com/bfs/archive/93fa65812ab9cb53244b6dae232283b582ea0f85.jpg"
        list.add(panda913)

        val panda914 = PetVideo()
        panda914.type = VideoType.PANDA.ordinal
        panda914.fileName = "panda_group_panda914"
        panda914.code = 2826
        panda914.duration = 81
        panda914.period = PeriodType.GROUP.ordinal
        panda914.star = false
        panda914.title = "【大熊猫和花&艾玖】艾玖不小心吓到和花，被霸王花“狠狠”嗷一口"
        panda914.releaseTime = 1652942342
        panda914.originalUrl = "https://www.bilibili.com/video/BV1kg411d7z4"
        panda914.tags = "大熊猫,萌宠,动物圈"
        panda914.authorId = 384395600
        panda914.cover =
            "https://i1.hdslb.com/bfs/archive/f45bce86b11556c018d7228e37cb38606913d396.jpg"
        list.add(panda914)

        val panda915 = PetVideo()
        panda915.type = VideoType.PANDA.ordinal
        panda915.fileName = "panda_group_panda915"
        panda915.code = 2827
        panda915.duration = 38
        panda915.period = PeriodType.GROUP.ordinal
        panda915.star = false
        panda915.title = "【大熊猫和花】和花：来得早不如来得巧"
        panda915.releaseTime = 1652962176
        panda915.originalUrl = "https://www.bilibili.com/video/BV1pr4y147oi"
        panda915.tags = "大熊猫,萌宠,动物圈"
        panda915.authorId = 327377672
        panda915.cover =
            "https://i2.hdslb.com/bfs/archive/4de7e7a637d753ab3bff28760e7471ed2157d616.jpg"
        list.add(panda915)

        val panda916 = PetVideo()
        panda916.type = VideoType.PANDA.ordinal
        panda916.fileName = "panda_group_panda916"
        panda916.code = 2828
        panda916.duration = 177
        panda916.period = PeriodType.GROUP.ordinal
        panda916.star = false
        panda916.title = "幼年二班钓猫，战况激烈得都有熊飙女高音了"
        panda916.releaseTime = 1652965201
        panda916.originalUrl = "https://www.bilibili.com/video/BV19Y4y1z7fM"
        panda916.tags = "大熊猫,萌宠,动物圈"
        panda916.authorId = 98871951
        panda916.cover =
            "https://i1.hdslb.com/bfs/archive/eeeff979a4282af6ee63306f2f2224bb42627048.jpg"
        list.add(panda916)

        val panda917 = PetVideo()
        panda917.type = VideoType.PANDA.ordinal
        panda917.fileName = "panda_group_panda917"
        panda917.code = 2829
        panda917.duration = 325
        panda917.period = PeriodType.GROUP.ordinal
        panda917.star = false
        panda917.title = "和花牌靠枕的使用代价就是睡觉的时候要当和花的抱枕"
        panda917.releaseTime = 1652970666
        panda917.originalUrl = "https://www.bilibili.com/video/BV17Y411w7ms"
        panda917.tags = "大熊猫,萌宠,动物圈"
        panda917.authorId = 230382720
        panda917.cover =
            "https://i1.hdslb.com/bfs/archive/8d66b2ac54e09b50b4080936109fe6aa548dd8cb.jpg"
        list.add(panda917)

        val panda918 = PetVideo()
        panda918.type = VideoType.PANDA.ordinal
        panda918.fileName = "panda_group_panda918"
        panda918.code = 2830
        panda918.duration = 202
        panda918.period = PeriodType.GROUP.ordinal
        panda918.star = false
        panda918.title = "“重阳，窝头好吃哇？”，“嗯，好吃！”~这只小熊成精了吧？【大熊猫】"
        panda918.releaseTime = 1652949352
        panda918.originalUrl = "https://www.bilibili.com/video/BV1Cv4y1N76z"
        panda918.tags = "大熊猫,萌宠,动物圈"
        panda918.authorId = 514531996
        panda918.cover =
            "https://i2.hdslb.com/bfs/archive/8be4c6b1bcbca7b9aa6b75514137da8581431625.jpg"
        list.add(panda918)

        val panda919 = PetVideo()
        panda919.type = VideoType.PANDA.ordinal
        panda919.fileName = "panda_group_panda919"
        panda919.code = 2831
        panda919.duration = 67
        panda919.period = PeriodType.GROUP.ordinal
        panda919.star = false
        panda919.title = "【大熊猫小馨】山头散步"
        panda919.releaseTime = 1634004292
        panda919.originalUrl = "https://www.bilibili.com/video/BV1PL411G7nC"
        panda919.tags = "大熊猫,萌宠,动物圈"
        panda919.authorId = 4824125
        panda919.cover =
            "https://i1.hdslb.com/bfs/archive/75ed472f4bedd68997a6e873cb75c30177704a76.jpg"
        list.add(panda919)

        val panda920 = PetVideo()
        panda920.type = VideoType.PANDA.ordinal
        panda920.fileName = "panda_group_panda920"
        panda920.code = 2832
        panda920.duration = 236
        panda920.period = PeriodType.GROUP.ordinal
        panda920.star = false
        panda920.vertical = true
        panda920.title = "【佛坪熊猫谷】山大王小馨路路视频合集"
        panda920.releaseTime = 1586879883
        panda920.originalUrl = "https://www.bilibili.com/video/BV1eZ4y1x73A"
        panda920.tags = "大熊猫,萌宠,动物圈"
        panda920.authorId = 113647100
        panda920.cover =
            "https://i2.hdslb.com/bfs/archive/7e9c7227ab18897ee8a847b17b03fcf01296a707.jpg"
        list.add(panda920)

        val panda921 = PetVideo()
        panda921.type = VideoType.PANDA.ordinal
        panda921.fileName = "panda_group_panda921"
        panda921.code = 2833
        panda921.duration = 132
        panda921.period = PeriodType.GROUP.ordinal
        panda921.star = false
        panda921.title = "小馨路路：承包了整个山头！我见过的最大外场【佛坪熊猫谷】"
        panda921.releaseTime = 1581300916
        panda921.originalUrl = "https://www.bilibili.com/video/BV1E741147Bi"
        panda921.tags = "大熊猫,萌宠,动物圈"
        panda921.authorId = 4120384
        panda921.cover =
            "https://i1.hdslb.com/bfs/archive/3d3dd37006926d144c74975514a7d966f991a08d.jpg"
        list.add(panda921)

        val panda922 = PetVideo()
        panda922.type = VideoType.PANDA.ordinal
        panda922.fileName = "panda_group_panda922"
        panda922.code = 2834
        panda922.duration = 73
        panda922.period = PeriodType.GROUP.ordinal
        panda922.star = false
        panda922.title = "大熊猫和花-这木架怎么下来着？"
        panda922.releaseTime = 1652922670
        panda922.originalUrl = "https://www.bilibili.com/video/BV1ct4y1473v"
        panda922.tags = "大熊猫,萌宠,动物圈"
        panda922.authorId = 1307515
        panda922.cover =
            "https://i1.hdslb.com/bfs/archive/f95444db792d1d1d193ac5c0b1b3d2ac760b2002.jpg"
        list.add(panda922)

        val panda923 = PetVideo()
        panda923.type = VideoType.PANDA.ordinal
        panda923.fileName = "panda_group_panda923"
        panda923.code = 2835
        panda923.duration = 229
        panda923.period = PeriodType.GROUP.ordinal
        panda923.star = false
        panda923.title = "【大熊猫和叶】20220512 来人呐，给英俊潇洒的和叶小少爷上一壶酒，把上等的好笋都端上来"
        panda923.releaseTime = 1652322348
        panda923.originalUrl = "https://www.bilibili.com/video/BV1PZ4y1a7pp"
        panda923.tags = "大熊猫,萌宠,动物圈"
        panda923.authorId = 478823961
        panda923.cover =
            "https://i2.hdslb.com/bfs/archive/321565df30e1f782a9f89295c720ec6be7c51c89.jpg"
        list.add(panda923)

        val panda924 = PetVideo()
        panda924.type = VideoType.PANDA.ordinal
        panda924.fileName = "panda_group_panda924"
        panda924.code = 2836
        panda924.duration = 90
        panda924.period = PeriodType.GROUP.ordinal
        panda924.star = false
        panda924.title = "【大熊猫和花】和花：感觉左手边有个毛毛虫，右手边有个土匪"
        panda924.releaseTime = 1652449981
        panda924.originalUrl = "https://www.bilibili.com/video/BV1vR4y1c7Fn"
        panda924.tags = "大熊猫,萌宠,动物圈"
        panda924.authorId = 18329821
        panda924.cover =
            "https://i0.hdslb.com/bfs/archive/d372518b9e2dccf828982883f3218431df1b3a20.jpg"
        list.add(panda924)

        val panda925 = PetVideo()
        panda925.type = VideoType.PANDA.ordinal
        panda925.fileName = "panda_group_panda925"
        panda925.code = 2837
        panda925.duration = 61
        panda925.period = PeriodType.GROUP.ordinal
        panda925.star = false
        panda925.title = "大熊猫和花：午休ing"
        panda925.releaseTime = 1652852946
        panda925.originalUrl = "https://www.bilibili.com/video/BV1zv4y1N74W"
        panda925.tags = "大熊猫,萌宠,动物圈"
        panda925.authorId = 19715714
        panda925.cover =
            "https://i0.hdslb.com/bfs/archive/7c9306090a759abcb49a7fda68d04d4df5d613ed.jpg"
        list.add(panda925)

        val panda926 = PetVideo()
        panda926.type = VideoType.PANDA.ordinal
        panda926.fileName = "panda_group_panda926"
        panda926.code = 2838
        panda926.duration = 279
        panda926.period = PeriodType.GROUP.ordinal
        panda926.star = false
        panda926.title = "连续被抢6次后，fa姐欲打包走开，结果还是被二狗拦截。。【大熊猫和花、润玥】"
        panda926.releaseTime = 1652793459
        panda926.originalUrl = "https://www.bilibili.com/video/BV1gB4y197kv"
        panda926.tags = "大熊猫,萌宠,动物圈"
        panda926.authorId = 514531996
        panda926.cover =
            "https://i0.hdslb.com/bfs/archive/3fd4880e6970b4d2918a9037565de67ce12e3617.jpg"
        list.add(panda926)

        val panda927 = PetVideo()
        panda927.type = VideoType.PANDA.ordinal
        panda927.fileName = "panda_group_panda927"
        panda927.code = 2839
        panda927.duration = 94
        panda927.period = PeriodType.GROUP.ordinal
        panda927.star = false
        panda927.title = "【大熊猫】热爱105°小和花"
        panda927.releaseTime = 1646659984
        panda927.originalUrl = "https://www.bilibili.com/video/BV1Wi4y117gy"
        panda927.tags = "大熊猫,萌宠,动物圈"
        panda927.authorId = 327377672
        panda927.cover =
            "https://i0.hdslb.com/bfs/archive/25da09e2b1e2c81162f0a578c3e362b06fe0afb1.jpg"
        list.add(panda927)

        val panda928 = PetVideo()
        panda928.type = VideoType.PANDA.ordinal
        panda928.fileName = "panda_group_panda928"
        panda928.code = 2840
        panda928.duration = 87
        panda928.period = PeriodType.GROUP.ordinal
        panda928.star = false
        panda928.title = "【大熊猫】假如和花来演王家卫电影的女主"
        panda928.releaseTime = 1647000312
        panda928.originalUrl = "https://www.bilibili.com/video/BV1dS4y1S7Sd"
        panda928.tags = "大熊猫,萌宠,动物圈"
        panda928.authorId = 327377672
        panda928.cover =
            "https://i0.hdslb.com/bfs/archive/b9d809e314fbba5c4abc60978ea649d5edf247db.jpg"
        list.add(panda928)

        val panda929 = PetVideo()
        panda929.type = VideoType.PANDA.ordinal
        panda929.fileName = "panda_group_panda929"
        panda929.code = 2841
        panda929.duration = 106
        panda929.period = PeriodType.GROUP.ordinal
        panda929.star = false
        panda929.title = "和花热得趴小水池上降温，但又不去池子里泡澡，什么时候下雨呀，和花喜欢淋浴【大熊猫和花】"
        panda929.releaseTime = 1647347125
        panda929.originalUrl = "https://www.bilibili.com/video/BV14S4y1u7vd"
        panda929.tags = "大熊猫,萌宠,动物圈"
        panda929.authorId = 230382720
        panda929.cover =
            "https://i2.hdslb.com/bfs/archive/2251273316fb662f701654dbd8e414d0116c75da.jpg"
        list.add(panda929)

        val panda930 = PetVideo()
        panda930.type = VideoType.PANDA.ordinal
        panda930.fileName = "panda_group_panda930"
        panda930.code = 2842
        panda930.duration = 200
        panda930.period = PeriodType.GROUP.ordinal
        panda930.star = false
        panda930.title = "【大熊猫】【超清】和花到底有多美？我就不信还能美出一朵花来？！点开！"
        panda930.releaseTime = 1648036821
        panda930.originalUrl = "https://www.bilibili.com/video/BV1eT4y1i7jx"
        panda930.tags = "大熊猫,萌宠,动物圈"
        panda930.authorId = 327377672
        panda930.cover =
            "https://i1.hdslb.com/bfs/archive/979a9576efb17f40ee38aa69e840c8c92d8fde3a.jpg"
        list.add(panda930)

        val panda931 = PetVideo()
        panda931.type = VideoType.PANDA.ordinal
        panda931.fileName = "panda_group_panda931"
        panda931.code = 2843
        panda931.duration = 16
        panda931.period = PeriodType.GROUP.ordinal
        panda931.star = false
        panda931.title = "【大熊猫】和花手势舞跨界黑马    强势打入高校决赛！"
        panda931.releaseTime = 1648422000
        panda931.originalUrl = "https://www.bilibili.com/video/BV1ya411x7FV"
        panda931.tags = "大熊猫,萌宠,动物圈"
        panda931.authorId = 327377672
        panda931.cover =
            "https://i1.hdslb.com/bfs/archive/4c8f6b2e732dd4bdb7a0a2c3ed3ae8131bc754a3.jpg"
        list.add(panda931)

        val panda932 = PetVideo()
        panda932.type = VideoType.PANDA.ordinal
        panda932.fileName = "panda_group_panda932"
        panda932.code = 2844
        panda932.duration = 86
        panda932.period = PeriodType.GROUP.ordinal
        panda932.star = false
        panda932.title = "【大熊猫和花】fafa的奇妙冒险 之钓猫"
        panda932.releaseTime = 1649593316
        panda932.originalUrl = "https://www.bilibili.com/video/BV1UB4y1m7uW"
        panda932.tags = "大熊猫,萌宠,动物圈"
        panda932.authorId = 327377672
        panda932.cover =
            "https://i0.hdslb.com/bfs/archive/919bd1b98a91c88a75732669f2a748bb65e22c8f.jpg"
        list.add(panda932)

        val panda933 = PetVideo()
        panda933.type = VideoType.PANDA.ordinal
        panda933.fileName = "panda_group_panda933"
        panda933.code = 2845
        panda933.duration = 46
        panda933.period = PeriodType.GROUP.ordinal
        panda933.star = false
        panda933.title = "【大熊猫和花】和花在润玥怀中轻松破竹"
        panda933.releaseTime = 1652180700
        panda933.originalUrl = "https://www.bilibili.com/video/BV1vF411j7Q9"
        panda933.tags = "大熊猫,萌宠,动物圈"
        panda933.authorId = 327377672
        panda933.cover =
            "https://i0.hdslb.com/bfs/archive/5048ba705080f06ff3a0264cd740dacd63bf9371.jpg"
        list.add(panda933)

        val panda934 = PetVideo()
        panda934.type = VideoType.PANDA.ordinal
        panda934.fileName = "panda_group_panda934"
        panda934.code = 2846
        panda934.duration = 121
        panda934.period = PeriodType.GROUP.ordinal
        panda934.star = false
        panda934.title = "【大熊猫和花】和花的战斗基因。永不服输"
        panda934.releaseTime = 1652443200
        panda934.originalUrl = "https://www.bilibili.com/video/BV1u54y1Z7kN"
        panda934.tags = "大熊猫,萌宠,动物圈"
        panda934.authorId = 327377672
        panda934.cover =
            "https://i0.hdslb.com/bfs/archive/64fdb0e4c69caa3acc995dc57b5f10ed74089e82.jpg"
        list.add(panda934)

        val panda935 = PetVideo()
        panda935.type = VideoType.PANDA.ordinal
        panda935.fileName = "panda_group_panda935"
        panda935.code = 2847
        panda935.duration = 75
        panda935.period = PeriodType.GROUP.ordinal
        panda935.star = false
        panda935.title = "原来小叶子下木架也是头先下！【大熊猫和叶】"
        panda935.releaseTime = 1651281125
        panda935.originalUrl = "https://www.bilibili.com/video/BV11a411Y75s"
        panda935.tags = "大熊猫,萌宠,动物圈"
        panda935.authorId = 16468440
        panda935.cover =
            "https://i2.hdslb.com/bfs/archive/f5db1e0a0ce6fc2ef9205d0d20218994dc33b36b.jpg"
        list.add(panda935)

        val panda936 = PetVideo()
        panda936.type = VideoType.PANDA.ordinal
        panda936.fileName = "panda_group_panda936"
        panda936.code = 2848
        panda936.duration = 79
        panda936.period = PeriodType.GROUP.ordinal
        panda936.star = false
        panda936.title = "奇一明明是在劝架，结果想起了十多分钟前被福顺抢竹子的一笔账"
        panda936.releaseTime = 1614318173
        panda936.originalUrl = "https://www.bilibili.com/video/BV1Ey4y1774r"
        panda936.tags = "大熊猫,萌宠,动物圈"
        panda936.authorId = 269899367
        panda936.cover =
            "https://i2.hdslb.com/bfs/archive/f2c2cf90fa96a5368007e0258d8d5c33a241d25a.jpg"
        list.add(panda936)

        val panda937 = PetVideo()
        panda937.type = VideoType.PANDA.ordinal
        panda937.fileName = "panda_group_panda937"
        panda937.code = 2849
        panda937.duration = 145
        panda937.period = PeriodType.GROUP.ordinal
        panda937.star = false
        panda937.title = "顺手抢来的竹子更好吃，这个顺手太顺，哈哈哈"
        panda937.releaseTime = 1586359384
        panda937.originalUrl = "https://www.bilibili.com/video/BV1LV411o712"
        panda937.tags = "大熊猫,萌宠,动物圈"
        panda937.authorId = 269899367
        panda937.cover =
            "https://i2.hdslb.com/bfs/archive/772896a11ab1c2247c89ff1ba08728bcd909d71d.jpg"
        list.add(panda937)

        val panda938 = PetVideo()
        panda938.type = VideoType.PANDA.ordinal
        panda938.fileName = "panda_group_panda938"
        panda938.code = 2850
        panda938.duration = 49
        panda938.period = PeriodType.GROUP.ordinal
        panda938.star = false
        panda938.title = "【大熊猫奇一】豆豆顺走兔兔的竹子，兔兔委屈了，打了豆豆好多巴掌"
        panda938.releaseTime = 1616224493
        panda938.originalUrl = "https://www.bilibili.com/video/BV1m5411P7kU"
        panda938.tags = "大熊猫,萌宠,动物圈"
        panda938.authorId = 278306866
        panda938.cover =
            "https://i0.hdslb.com/bfs/archive/72217189360969d4788d48cd3d911b1681e55add.jpg"
        list.add(panda938)

        val panda939 = PetVideo()
        panda939.type = VideoType.PANDA.ordinal
        panda939.fileName = "panda_group_panda939"
        panda939.code = 2851
        panda939.duration = 66
        panda939.period = PeriodType.GROUP.ordinal
        panda939.star = false
        panda939.title = "大熊猫奇一和福来突然互相不理睬对方，难道因为吵架了？"
        panda939.releaseTime = 1634178727
        panda939.originalUrl = "https://www.bilibili.com/video/BV1n34y1S7A1"
        panda939.tags = "大熊猫,萌宠,动物圈"
        panda939.authorId = 627116323
        panda939.cover =
            "https://i2.hdslb.com/bfs/archive/2589fc8643ca075c5974be7212872f7ab1bf6dd0.jpg"
        list.add(panda939)

        val panda940 = PetVideo()
        panda940.type = VideoType.PANDA.ordinal
        panda940.fileName = "panda_group_panda940"
        panda940.code = 2852
        panda940.duration = 69
        panda940.period = PeriodType.GROUP.ordinal
        panda940.star = false
        panda940.title = "奇兔兔，谭爷爷喊你下班回家了"
        panda940.releaseTime = 1612142646
        panda940.originalUrl = "https://www.bilibili.com/video/BV1Yz4y1m7jL"
        panda940.tags = "大熊猫,萌宠,动物圈"
        panda940.authorId = 66688464
        panda940.cover =
            "https://i1.hdslb.com/bfs/archive/adfefdd95107e48bdc522fece48ba223b88e8249.jpg"
        list.add(panda940)

        val panda941 = PetVideo()
        panda941.type = VideoType.PANDA.ordinal
        panda941.fileName = "panda_group_panda941"
        panda941.code = 2853
        panda941.duration = 35
        panda941.period = PeriodType.GROUP.ordinal
        panda941.star = false
        panda941.title = "【大熊猫】奇一，谭爷爷喊你回家咯！"
        panda941.releaseTime = 1603093367
        panda941.originalUrl = "https://www.bilibili.com/video/BV1wa411A7Qa"
        panda941.tags = "大熊猫,萌宠,动物圈"
        panda941.authorId = 278306866
        panda941.cover =
            "https://i2.hdslb.com/bfs/archive/4a4b0eaeecbdb6c6d36b23d2b58037b8909e35d9.jpg"
        list.add(panda941)

        val panda942 = PetVideo()
        panda942.type = VideoType.PANDA.ordinal
        panda942.fileName = "panda_group_panda942"
        panda942.code = 2854
        panda942.duration = 334
        panda942.period = PeriodType.GROUP.ordinal
        panda942.star = false
        panda942.title = "【大熊猫和花】5.16日钓猫，和花今天太不容易了，奶爸都替和花着急了"
        panda942.releaseTime = 1652704194
        panda942.originalUrl = "https://www.bilibili.com/video/BV1GY4y1t7cu"
        panda942.tags = "大熊猫,萌宠,动物圈"
        panda942.authorId = 98871951
        panda942.cover =
            "https://i1.hdslb.com/bfs/archive/427d0b00e286879b6294543fcd92fb77b23005ca.jpg"
        list.add(panda942)

        val panda943 = PetVideo()
        panda943.type = VideoType.PANDA.ordinal
        panda943.fileName = "panda_group_panda943"
        panda943.code = 2855
        panda943.duration = 103
        panda943.period = PeriodType.GROUP.ordinal
        panda943.star = false
        panda943.title = "又是艾玖带崽的一天，这耳朵对比太强烈啦！05.16【大熊猫和花 艾玖】"
        panda943.releaseTime = 1652758579
        panda943.originalUrl = "https://www.bilibili.com/video/BV1WT4y1z7Rb"
        panda943.tags = "大熊猫,萌宠,动物圈"
        panda943.authorId = 16468440
        panda943.cover =
            "https://i0.hdslb.com/bfs/archive/da1fc8ddfe768024530908569cab71d1f52d2998.jpg"
        list.add(panda943)

        val panda944 = PetVideo()
        panda944.type = VideoType.PANDA.ordinal
        panda944.fileName = "panda_group_panda944"
        panda944.code = 2856
        panda944.duration = 97
        panda944.period = PeriodType.GROUP.ordinal
        panda944.star = false
        panda944.title = "看样子这种竹子比较符合我们叶帅的胃口！05.16【大熊猫和花叶】"
        panda944.releaseTime = 1652750544
        panda944.originalUrl = "https://www.bilibili.com/video/BV1h54y1Z7gw"
        panda944.tags = "大熊猫,萌宠,动物圈"
        panda944.authorId = 16468440
        panda944.cover =
            "https://i1.hdslb.com/bfs/archive/dae42b6a05c73d0e7f322ae39dbf25f6606fd010.jpg"
        list.add(panda944)

        val panda945 = PetVideo()
        panda945.type = VideoType.PANDA.ordinal
        panda945.fileName = "panda_group_panda945"
        panda945.code = 2857
        panda945.duration = 29
        panda945.period = PeriodType.GROUP.ordinal
        panda945.star = false
        panda945.title = "把“仙女”叉出去。【大熊猫蛋烘糕、热干面、春生、香果】"
        panda945.releaseTime = 1652700722
        panda945.originalUrl = "https://www.bilibili.com/video/BV1D541197Cy"
        panda945.tags = "大熊猫,萌宠,动物圈"
        panda945.authorId = 514531996
        panda945.cover =
            "https://i0.hdslb.com/bfs/archive/618bf1ad8eb13cd9daabcc8731641180d2659557.jpg"
        list.add(panda945)

        val panda946 = PetVideo()
        panda946.type = VideoType.PANDA.ordinal
        panda946.fileName = "panda_group_panda946"
        panda946.code = 2858
        panda946.duration = 173
        panda946.period = PeriodType.GROUP.ordinal
        panda946.star = false
        panda946.title = "〖大熊猫福双〗〖大熊猫茱萸〗小2班代班奶爸场面一度“失控”哈哈哈 两个小姐妹坐在一起也太可爱了叭"
        panda946.releaseTime = 1652680338
        panda946.originalUrl = "https://www.bilibili.com/video/BV1fZ4y1b7Ne"
        panda946.tags = "大熊猫,萌宠,动物圈"
        panda946.authorId = 690050620
        panda946.cover =
            "https://i2.hdslb.com/bfs/archive/14ab0efabb48d4846bdeb8113d5e4585b03d73e7.jpg"
        list.add(panda946)

        val panda947 = PetVideo()
        panda947.type = VideoType.PANDA.ordinal
        panda947.fileName = "panda_group_panda947"
        panda947.code = 2859
        panda947.duration = 62
        panda947.period = PeriodType.GROUP.ordinal
        panda947.star = false
        panda947.title = "【大熊猫和花】挑选食物这方面，和花是专业的"
        panda947.releaseTime = 1652707800
        panda947.originalUrl = "https://www.bilibili.com/video/BV1vY4y14794"
        panda947.tags = "大熊猫,萌宠,动物圈"
        panda947.authorId = 98871951
        panda947.cover =
            "https://i2.hdslb.com/bfs/archive/050d69fc64429da5bb052cfeca8a3c96cd98dc89.jpg"
        list.add(panda947)

        val panda948 = PetVideo()
        panda948.type = VideoType.PANDA.ordinal
        panda948.fileName = "panda_group_panda948"
        panda948.code = 2860
        panda948.duration = 89
        panda948.period = PeriodType.GROUP.ordinal
        panda948.star = false
        panda948.title = "〖大熊猫润玥〗〖大熊猫和叶〗钓猫最积极的两个仔"
        panda948.releaseTime = 1652679993
        panda948.originalUrl = "https://www.bilibili.com/video/BV1H3411A7yk"
        panda948.tags = "大熊猫,萌宠,动物圈"
        panda948.authorId = 690050620
        panda948.cover =
            "https://i2.hdslb.com/bfs/archive/69a028350478edca46370023561e5889a50eed85.jpg"
        list.add(panda948)

        val panda949 = PetVideo()
        panda949.type = VideoType.PANDA.ordinal
        panda949.fileName = "panda_group_panda949"
        panda949.code = 2861
        panda949.duration = 98
        panda949.period = PeriodType.GROUP.ordinal
        panda949.star = false
        panda949.title = "和花：迪迪压着，二狗还坐着，这熊生有亿点点艰难哦"
        panda949.releaseTime = 1652624571
        panda949.originalUrl = "https://www.bilibili.com/video/BV1HU4y1m7US"
        panda949.tags = "大熊猫,萌宠,动物圈"
        panda949.authorId = 34677299
        panda949.cover =
            "https://i2.hdslb.com/bfs/archive/e1c0d77436eeeb100edcce597ec0ddb8a7316014.jpg"
        list.add(panda949)

        val panda950 = PetVideo()
        panda950.type = VideoType.PANDA.ordinal
        panda950.fileName = "panda_group_panda950"
        panda950.code = 2862
        panda950.duration = 293
        panda950.period = PeriodType.GROUP.ordinal
        panda950.star = false
        panda950.title = "福双 金双 金喜 茱萸 重阳"
        panda950.releaseTime = 1652435042
        panda950.originalUrl = "https://www.bilibili.com/video/BV1dR4y1A7zn"
        panda950.tags = "大熊猫,萌宠,动物圈"
        panda950.authorId = 111531415
        panda950.cover =
            "https://i2.hdslb.com/bfs/archive/d59a2e2a1eed591a1ac86aaf544136fc127ab8d2.jpg"
        list.add(panda950)

        val panda951 = PetVideo()
        panda951.type = VideoType.PANDA.ordinal
        panda951.fileName = "panda_group_panda951"
        panda951.code = 2863
        panda951.duration = 65
        panda951.period = PeriodType.GROUP.ordinal
        panda951.star = false
        panda951.title = "下雨天好喜欢甩水的和花，耳朵要不见了！【大熊猫和花】"
        panda951.releaseTime = 1652570989
        panda951.originalUrl = "https://www.bilibili.com/video/BV1a54119773"
        panda951.tags = "大熊猫,萌宠,动物圈"
        panda951.authorId = 16468440
        panda951.cover =
            "https://i1.hdslb.com/bfs/archive/627570bf98240b3dd636017c09c97a01d0d55bc4.jpg"
        list.add(panda951)

        val panda952 = PetVideo()
        panda952.type = VideoType.PANDA.ordinal
        panda952.fileName = "panda_group_panda952"
        panda952.code = 2864
        panda952.duration = 88
        panda952.period = PeriodType.GROUP.ordinal
        panda952.star = false
        panda952.title = "椰？有灰机！~全套萌迷晕当场亲妈。【大熊猫和花】"
        panda952.releaseTime = 1652189372
        panda952.originalUrl = "https://www.bilibili.com/video/BV1X44y1u7gL"
        panda952.tags = "大熊猫,萌宠,动物圈"
        panda952.authorId = 514531996
        panda952.cover =
            "https://i0.hdslb.com/bfs/archive/329e8344a932b9de02b0815d470448390a4e9c42.jpg"
        list.add(panda952)

        val panda953 = PetVideo()
        panda953.type = VideoType.PANDA.ordinal
        panda953.fileName = "panda_group_panda953"
        panda953.code = 2865
        panda953.duration = 281
        panda953.period = PeriodType.GROUP.ordinal
        panda953.star = false
        panda953.title = "谁还敢说我短？四分钟超长吃播大放送！"
        panda953.releaseTime = 1615519702
        panda953.originalUrl = "https://www.bilibili.com/video/BV1iU4y1p7te"
        panda953.tags = "大熊猫,萌宠,动物圈"
        panda953.authorId = 37053244
        panda953.cover =
            "https://i1.hdslb.com/bfs/archive/56fab61448805dcf37406f2667da5127f9c105b8.jpg"
        list.add(panda953)

        val panda954 = PetVideo()
        panda954.type = VideoType.PANDA.ordinal
        panda954.fileName = "panda_group_panda954"
        panda954.code = 2866
        panda954.duration = 49
        panda954.period = PeriodType.GROUP.ordinal
        panda954.star = false
        panda954.title = "熊生中最幸福的事，莫过于呼哧呼哧吃完竹笋，在笋子皮里一阵瞎翻，结果发现还有没被发现的笋子"
        panda954.releaseTime = 1586589981
        panda954.originalUrl = "https://www.bilibili.com/video/BV12p4y1C7D6"
        panda954.tags = "大熊猫,萌宠,动物圈"
        panda954.authorId = 37053244
        panda954.cover =
            "https://i0.hdslb.com/bfs/archive/b5a6c1f25f15f424341753b8a3d06a76934d0b2b.jpg"
        list.add(panda954)

        val panda955 = PetVideo()
        panda955.type = VideoType.PANDA.ordinal
        panda955.fileName = "panda_group_panda955"
        panda955.code = 2867
        panda955.duration = 287
        panda955.period = PeriodType.GROUP.ordinal
        panda955.star = false
        panda955.title = "执着的和花第三次尝试，丛侧面成功贴到二狗【大熊猫和花、润玥】"
        panda955.releaseTime = 1652590367
        panda955.originalUrl = "https://www.bilibili.com/video/BV1c34y1a7WS"
        panda955.tags = "大熊猫,萌宠,动物圈"
        panda955.authorId = 230382720
        panda955.cover =
            "https://i1.hdslb.com/bfs/archive/4477b699e288ebaa743119184ef0817cca033b46.jpg"
        list.add(panda955)

        val panda956 = PetVideo()
        panda956.type = VideoType.PANDA.ordinal
        panda956.fileName = "panda_group_panda956"
        panda956.code = 2868
        panda956.duration = 52
        panda956.period = PeriodType.GROUP.ordinal
        panda956.star = false
        panda956.title = "一起叠猫猫【大熊猫金玉润九】"
        panda956.releaseTime = 1614148830
        panda956.originalUrl = "https://www.bilibili.com/video/BV1zX4y1G7uN"
        panda956.tags = "大熊猫,萌宠,动物圈"
        panda956.authorId = 19715714
        panda956.cover =
            "https://i2.hdslb.com/bfs/archive/fbeef48524634496eb42f94ea8e7ccd68a44e092.jpg"
        list.add(panda956)

        val panda957 = PetVideo()
        panda957.type = VideoType.PANDA.ordinal
        panda957.fileName = "panda_group_panda957"
        panda957.code = 2869
        panda957.duration = 221
        panda957.period = PeriodType.GROUP.ordinal
        panda957.star = false
        panda957.title = "和花过独木桥找二狗，走得挺稳的，还能在桥上掉头，和花越来越厉害了【大熊猫和花】"
        panda957.releaseTime = 1652532456
        panda957.originalUrl = "https://www.bilibili.com/video/BV14r4y1b7Wk"
        panda957.tags = "大熊猫,萌宠,动物圈"
        panda957.authorId = 230382720
        panda957.cover =
            "https://i1.hdslb.com/bfs/archive/248e9359a86ba44ffd77b94cafea5c7be913f509.jpg"
        list.add(panda957)

        val panda958 = PetVideo()
        panda958.type = VideoType.PANDA.ordinal
        panda958.fileName = "panda_group_panda958"
        panda958.code = 2870
        panda958.duration = 310
        panda958.period = PeriodType.GROUP.ordinal
        panda958.star = false
        panda958.title =
            "和花：弟弟，你冷不冷；我给你盖个熊毯。和花：姐姐，你头痛不痛；我给你头部按摩按摩。怎么都不领和花的好意呢？都不陪和花玩，化戾气为力气的和花下木架都顺畅了非常多！"
        panda958.releaseTime = 1651051800
        panda958.originalUrl = "https://www.bilibili.com/video/BV1QY411P7Uq"
        panda958.tags = "大熊猫,萌宠,动物圈"
        panda958.authorId = 478823961
        panda958.cover =
            "https://i2.hdslb.com/bfs/archive/d4155f94a61c9e948c8cd965f29a0dba193e63e4.jpg"
        list.add(panda958)

        val panda959 = PetVideo()
        panda959.type = VideoType.PANDA.ordinal
        panda959.fileName = "panda_group_panda959"
        panda959.code = 2871
        panda959.duration = 114
        panda959.period = PeriodType.GROUP.ordinal
        panda959.star = false
        panda959.vertical = true
        panda959.title = "谭爷爷有多宠和花"
        panda959.releaseTime = 1652498379
        panda959.originalUrl = "https://www.bilibili.com/video/BV1R34y1h7N2"
        panda959.tags = "大熊猫,萌宠,动物圈"
        panda959.authorId = 1025949925
        panda959.cover =
            "https://i0.hdslb.com/bfs/archive/6850c119bd911a86945286d8bb7d4a2306170c41.jpg"
        list.add(panda959)

        val panda960 = PetVideo()
        panda960.type = VideoType.PANDA.ordinal
        panda960.fileName = "panda_group_panda960"
        panda960.code = 2872
        panda960.duration = 88
        panda960.period = PeriodType.GROUP.ordinal
        panda960.star = false
        panda960.title = "和花好喜欢下雨呀，又撩架又打滚，好开心！【大熊猫和花】"
        panda960.releaseTime = 1652502569
        panda960.originalUrl = "https://www.bilibili.com/video/BV1cZ4y187cq"
        panda960.tags = "大熊猫,萌宠,动物圈"
        panda960.authorId = 16468440
        panda960.cover =
            "https://i2.hdslb.com/bfs/archive/ef7ca79ce8d6fc172bdf8ad18b48ef995f79956e.jpg"
        list.add(panda960)

        val panda961 = PetVideo()
        panda961.type = VideoType.PANDA.ordinal
        panda961.fileName = "panda_group_panda961"
        panda961.code = 2873
        panda961.duration = 575
        panda961.period = PeriodType.GROUP.ordinal
        panda961.star = false
        panda961.title = "05.13  幼年园2班钓猫～原来重阳只吃抹了蜂蜜的窝窝头！【大熊猫福双金喜金双茱萸重阳】"
        panda961.releaseTime = 1652443591
        panda961.originalUrl = "https://www.bilibili.com/video/BV1FR4y1P7N5"
        panda961.tags = "大熊猫,萌宠,动物圈"
        panda961.authorId = 16468440
        panda961.cover =
            "https://i0.hdslb.com/bfs/archive/7bc8e758ac2d57369be75260c2ac13356723cc8b.jpg"
        list.add(panda961)

        val panda962 = PetVideo()
        panda962.type = VideoType.PANDA.ordinal
        panda962.fileName = "panda_group_panda962"
        panda962.code = 2874
        panda962.duration = 65
        panda962.period = PeriodType.GROUP.ordinal
        panda962.star = false
        panda962.title = "【大熊猫和花】和叶惨遭“du手”，雷霆狂花联手猩红之玥"
        panda962.releaseTime = 1652270257
        panda962.originalUrl = "https://www.bilibili.com/video/BV15a411J72s"
        panda962.tags = "大熊猫,萌宠,动物圈"
        panda962.authorId = 327377672
        panda962.cover =
            "https://i1.hdslb.com/bfs/archive/924a8f63af7059c216f45162e46bc2ca5006a9e1.jpg"
        list.add(panda962)

        val panda963 = PetVideo()
        panda963.type = VideoType.PANDA.ordinal
        panda963.fileName = "panda_group_panda963"
        panda963.code = 2875
        panda963.duration = 230
        panda963.period = PeriodType.GROUP.ordinal
        panda963.star = false
        panda963.title = "新丰荣小叶子表示很满意，还坐在宝宝转椅上翘jiojio！05.11【大熊猫和叶】"
        panda963.releaseTime = 1652350746
        panda963.originalUrl = "https://www.bilibili.com/video/BV1oa411J7kf"
        panda963.tags = "大熊猫,萌宠,动物圈"
        panda963.authorId = 16468440
        panda963.cover =
            "https://i1.hdslb.com/bfs/archive/75ccac4d720559089697df13c2c2cb6ab0d5d279.jpg"
        list.add(panda963)

        val panda964 = PetVideo()
        panda964.type = VideoType.PANDA.ordinal
        panda964.fileName = "panda_group_panda964"
        panda964.code = 2876
        panda964.duration = 52
        panda964.period = PeriodType.GROUP.ordinal
        panda964.star = false
        panda964.title = "大熊猫和花 2022.1 幼年园 小乌龟fan不过身，然后打生胖气打滚，可爱爆了～"
        panda964.releaseTime = 1651079119
        panda964.originalUrl = "https://www.bilibili.com/video/BV1DY4y1Y7cf"
        panda964.tags = "大熊猫,萌宠,动物圈"
        panda964.authorId = 264648535
        panda964.cover =
            "https://i2.hdslb.com/bfs/archive/417661a705b4175431a73eedc65bc543b7f16eb1.jpg"
        list.add(panda964)

        val panda965 = PetVideo()
        panda965.type = VideoType.PANDA.ordinal
        panda965.fileName = "panda_group_panda965"
        panda965.code = 2877
        panda965.duration = 53
        panda965.period = PeriodType.GROUP.ordinal
        panda965.star = false
        panda965.title = "【大熊猫和花/和叶】你见过会拳击的熊猫吗？"
        panda965.releaseTime = 1651992996
        panda965.originalUrl = "https://www.bilibili.com/video/BV1gY4y1r79F"
        panda965.tags = "大熊猫,萌宠,动物圈"
        panda965.authorId = 18329821
        panda965.cover =
            "https://i0.hdslb.com/bfs/archive/3f42cfba043c3d2fa3826fa3f11e6e06a2411fb8.jpg"
        list.add(panda965)

        val panda966 = PetVideo()
        panda966.type = VideoType.PANDA.ordinal
        panda966.fileName = "panda_group_panda966"
        panda966.code = 2878
        panda966.duration = 418
        panda966.period = PeriodType.GROUP.ordinal
        panda966.star = false
        panda966.title = "05.11 幼年园2班钓猫~听取嘤嘤声一片！【大熊猫福双金喜金双茱萸重阳】"
        panda966.releaseTime = 1652275865
        panda966.originalUrl = "https://www.bilibili.com/video/BV17R4y1A7Cr"
        panda966.tags = "大熊猫,萌宠,动物圈"
        panda966.authorId = 16468440
        panda966.cover =
            "https://i1.hdslb.com/bfs/archive/ee4709ba6c7e130f50542ede3b8901f53af23891.jpg"
        list.add(panda966)

        val panda967 = PetVideo()
        panda967.type = VideoType.PANDA.ordinal
        panda967.fileName = "panda_group_panda967"
        panda967.code = 2879
        panda967.duration = 163
        panda967.period = PeriodType.GROUP.ordinal
        panda967.star = false
        panda967.vertical = true
        panda967.title = "今天的宝宝们都很乖，只有太阳四子最费了"
        panda967.releaseTime = 1652327449
        panda967.originalUrl = "https://www.bilibili.com/video/BV1WR4y1A7vS"
        panda967.tags = "大熊猫,萌宠,动物圈"
        panda967.authorId = 1025949925
        panda967.cover =
            "https://i2.hdslb.com/bfs/archive/cdf093fa8c2de1f492bd5a2d5244a6be41c0503d.jpg"
        list.add(panda967)

        val panda968 = PetVideo()
        panda968.type = VideoType.PANDA.ordinal
        panda968.fileName = "panda_group_panda968"
        panda968.code = 2880
        panda968.duration = 38
        panda968.period = PeriodType.GROUP.ordinal
        panda968.star = false
        panda968.title = "大熊猫和花-倒下了就没人知道我在吃什么"
        panda968.releaseTime = 1652262495
        panda968.originalUrl = "https://www.bilibili.com/video/BV1654y1f7Y2"
        panda968.tags = "大熊猫,萌宠,动物圈"
        panda968.authorId = 1307515
        panda968.cover =
            "https://i2.hdslb.com/bfs/archive/f2182981a1206e836adabc3f51af2a8529abcc03.jpg"
        list.add(panda968)

        val panda969 = PetVideo()
        panda969.type = VideoType.PANDA.ordinal
        panda969.fileName = "panda_group_panda969"
        panda969.code = 2881
        panda969.duration = 74
        panda969.period = PeriodType.GROUP.ordinal
        panda969.star = false
        panda969.title = "【大熊猫和花】抠痒痒被发现了，好尴尬呀"
        panda969.releaseTime = 1652265838
        panda969.originalUrl = "https://www.bilibili.com/video/BV17Z4y1a7gQ"
        panda969.tags = "大熊猫,萌宠,动物圈"
        panda969.authorId = 384395600
        panda969.cover =
            "https://i2.hdslb.com/bfs/archive/1b1f0438089020f265a0d6f125028384d7d63d9d.jpg"
        list.add(panda969)

        val panda970 = PetVideo()
        panda970.type = VideoType.PANDA.ordinal
        panda970.fileName = "panda_group_panda970"
        panda970.code = 2882
        panda970.duration = 76
        panda970.period = PeriodType.GROUP.ordinal
        panda970.star = false
        panda970.vertical = true
        panda970.title = "香果儿：“听我说，谢谢你…春生和热干面”←_←"
        panda970.releaseTime = 1652178780
        panda970.originalUrl = "https://www.bilibili.com/video/BV1SB4y1C7Gx"
        panda970.tags = "大熊猫,萌宠,动物圈"
        panda970.authorId = 34677299
        panda970.cover =
            "https://i0.hdslb.com/bfs/archive/75dfb7abea32e5832eba05db7462063f34ead4d7.jpg"
        list.add(panda970)

        val panda971 = PetVideo()
        panda971.type = VideoType.PANDA.ordinal
        panda971.fileName = "panda_group_panda971"
        panda971.code = 2883
        panda971.duration = 279
        panda971.period = PeriodType.GROUP.ordinal
        panda971.star = false
        panda971.title = "05.09 和花，检查完身体小苹果都是你的哟，揣好喽慢慢吃！【大熊猫和花】"
        panda971.releaseTime = 1652085796
        panda971.originalUrl = "https://www.bilibili.com/video/BV19Z4y1h792"
        panda971.tags = "大熊猫,萌宠,动物圈"
        panda971.authorId = 16468440
        panda971.cover =
            "https://i0.hdslb.com/bfs/archive/bc2a8d448abc251bc00807bd3a7d8390c4d2d37f.jpg"
        list.add(panda971)

        val panda972 = PetVideo()
        panda972.type = VideoType.PANDA.ordinal
        panda972.fileName = "panda_group_panda972"
        panda972.code = 2884
        panda972.duration = 101
        panda972.period = PeriodType.GROUP.ordinal
        panda972.star = false
        panda972.title = "小声地问一下，浪浪是不是战五渣~绩笑、成风、成浪"
        panda972.releaseTime = 1652187600
        panda972.originalUrl = "https://www.bilibili.com/video/BV1b44y1u71a"
        panda972.tags = "大熊猫,萌宠,动物圈"
        panda972.authorId = 98871951
        panda972.cover =
            "https://i2.hdslb.com/bfs/archive/69c39a099dce4fb7b338c7c0f66568aa7506bb60.jpg"
        list.add(panda972)

        val panda973 = PetVideo()
        panda973.type = VideoType.PANDA.ordinal
        panda973.fileName = "panda_group_panda973"
        panda973.code = 2885
        panda973.duration = 67
        panda973.period = PeriodType.GROUP.ordinal
        panda973.star = false
        panda973.title = "【大熊猫绩笑】亲妈还是黑妈，看拍出来的绩笑笑就知道了"
        panda973.releaseTime = 1635999313
        panda973.originalUrl = "https://www.bilibili.com/video/BV1Eq4y1r7SP"
        panda973.tags = "大熊猫,萌宠,动物圈"
        panda973.authorId = 697876712
        panda973.cover =
            "https://i0.hdslb.com/bfs/archive/19621db713ef0b1e1c50cc3861a586448b94f07a.jpg"
        list.add(panda973)

        val panda974 = PetVideo()
        panda974.type = VideoType.PANDA.ordinal
        panda974.fileName = "panda_group_panda974"
        panda974.code = 2886
        panda974.duration = 67
        panda974.period = PeriodType.GROUP.ordinal
        panda974.star = false
        panda974.title = "和花：跟我的菜菜姐贴贴，菜菜：头太大，并不想"
        panda974.releaseTime = 1652101200
        panda974.originalUrl = "https://www.bilibili.com/video/BV1dB4y1173r"
        panda974.tags = "大熊猫,萌宠,动物圈"
        panda974.authorId = 98871951
        panda974.cover =
            "https://i1.hdslb.com/bfs/archive/45eafc7a15fbbf28b0ddb2c8db85534ed16569c8.jpg"
        list.add(panda974)

        val panda975 = PetVideo()
        panda975.type = VideoType.PANDA.ordinal
        panda975.fileName = "panda_group_panda975"
        panda975.code = 2887
        panda975.duration = 64
        panda975.period = PeriodType.GROUP.ordinal
        panda975.star = false
        panda975.title = "熊 猫 的 夏 天"
        panda975.releaseTime = 1652072037
        panda975.originalUrl = "https://www.bilibili.com/video/BV1ev4y1P7QX"
        panda975.tags = "大熊猫,萌宠,动物圈"
        panda975.authorId = 37053244
        panda975.cover =
            "https://i1.hdslb.com/bfs/archive/859bccc15c8dfb9c70fb8ca9382e195d10b1ebeb.jpg"
        list.add(panda975)

        val panda976 = PetVideo()
        panda976.type = VideoType.PANDA.ordinal
        panda976.fileName = "panda_group_panda976"
        panda976.code = 2888
        panda976.duration = 113
        panda976.period = PeriodType.GROUP.ordinal
        panda976.star = false
        panda976.title = "【大熊猫和花】下班前独自巡场找笋笋的花主任"
        panda976.releaseTime = 1650790626
        panda976.originalUrl = "https://www.bilibili.com/video/BV1pS4y1a78T"
        panda976.tags = "大熊猫,萌宠,动物圈"
        panda976.authorId = 18329821
        panda976.cover =
            "https://i0.hdslb.com/bfs/archive/d42bd9e4434c9662e1015b861af1a7f97e8e6637.jpg"
        list.add(panda976)

        val panda977 = PetVideo()
        panda977.type = VideoType.PANDA.ordinal
        panda977.fileName = "panda_group_panda977"
        panda977.code = 2889
        panda977.duration = 93
        panda977.period = PeriodType.GROUP.ordinal
        panda977.star = false
        panda977.title = "【大熊猫和花/和叶/艾玖】他们打他们的，和花独自一熊卖萌ing"
        panda977.releaseTime = 1649679849
        panda977.originalUrl = "https://www.bilibili.com/video/BV14Y411E7aW"
        panda977.tags = "大熊猫,萌宠,动物圈"
        panda977.authorId = 18329821
        panda977.cover =
            "https://i0.hdslb.com/bfs/archive/c0a624ed06cadc19125f161ef465622146de5d60.jpg"
        list.add(panda977)

        val panda978 = PetVideo()
        panda978.type = VideoType.PANDA.ordinal
        panda978.fileName = "panda_group_panda978"
        panda978.code = 2890
        panda978.duration = 33
        panda978.period = PeriodType.GROUP.ordinal
        panda978.star = false
        panda978.title = "“战神花”堵艾玖，把艾玖打得“抱头求饶”【大熊猫和花、艾玖】"
        panda978.releaseTime = 1651836956
        panda978.originalUrl = "https://www.bilibili.com/video/BV1LS4y1h7bz"
        panda978.tags = "大熊猫,萌宠,动物圈"
        panda978.authorId = 2062416280
        panda978.cover =
            "https://i2.hdslb.com/bfs/archive/a35898126f33049d94524f18666c146839b72728.jpg"
        list.add(panda978)

        val panda979 = PetVideo()
        panda979.type = VideoType.PANDA.ordinal
        panda979.fileName = "panda_group_panda979"
        panda979.code = 2891
        panda979.duration = 61
        panda979.period = PeriodType.GROUP.ordinal
        panda979.star = false
        panda979.title = "考古视频：大熊猫园润抢劫成对和奥莉奥 250"
        panda979.releaseTime = 1634566819
        panda979.originalUrl = "https://www.bilibili.com/video/BV1Rf4y1g7qr"
        panda979.tags = "大熊猫,萌宠,动物圈"
        panda979.authorId = 26698409
        panda979.cover =
            "https://i2.hdslb.com/bfs/archive/533dcb44966079af688b636f505914bf51eb0985.jpg"
        list.add(panda979)

        val panda980 = PetVideo()
        panda980.type = VideoType.PANDA.ordinal
        panda980.fileName = "panda_group_panda980"
        panda980.code = 2892
        panda980.duration = 64
        panda980.period = PeriodType.GROUP.ordinal
        panda980.star = false
        panda980.title = "大熊猫润玥和叶～土匪菜菜抢和叶笋"
        panda980.releaseTime = 1651905554
        panda980.originalUrl = "https://www.bilibili.com/video/BV1NB4y127Cj"
        panda980.tags = "大熊猫,萌宠,动物圈"
        panda980.authorId = 19715714
        panda980.cover =
            "https://i1.hdslb.com/bfs/archive/d9df2819ec8374d4be562d90e06333ab305464c5.jpg"
        list.add(panda980)

        val panda981 = PetVideo()
        panda981.type = VideoType.PANDA.ordinal
        panda981.fileName = "panda_group_panda981"
        panda981.code = 2893
        panda981.duration = 110
        panda981.period = PeriodType.GROUP.ordinal
        panda981.star = false
        panda981.title = "【大熊猫艾玖&和花】玖玖带和花：“这根竹子太硬了，你咬不动，拿来吧”"
        panda981.releaseTime = 1651912947
        panda981.originalUrl = "https://www.bilibili.com/video/BV1SR4y1w7aJ"
        panda981.tags = "大熊猫,萌宠,动物圈"
        panda981.authorId = 34677299
        panda981.cover =
            "https://i2.hdslb.com/bfs/archive/36ca3722762bfa0d2bb6f7ac2d346f522a975ffc.jpg"
        list.add(panda981)

        val panda982 = PetVideo()
        panda982.type = VideoType.PANDA.ordinal
        panda982.fileName = "panda_group_panda982"
        panda982.code = 2894
        panda982.duration = 82
        panda982.period = PeriodType.GROUP.ordinal
        panda982.star = false
        panda982.title = "大熊猫和花-熊生的第一次独木桥尝试"
        panda982.releaseTime = 1651917852
        panda982.originalUrl = "https://www.bilibili.com/video/BV1XY4y1t7FP"
        panda982.tags = "大熊猫,萌宠,动物圈"
        panda982.authorId = 1307515
        panda982.cover =
            "https://i1.hdslb.com/bfs/archive/7f8376178235156abbd7056db877329e073737fb.jpg"
        list.add(panda982)

        val panda983 = PetVideo()
        panda983.type = VideoType.PANDA.ordinal
        panda983.fileName = "panda_group_panda983"
        panda983.code = 2895
        panda983.duration = 101
        panda983.period = PeriodType.GROUP.ordinal
        panda983.star = false
        panda983.title = "早晨不想上班的两姐弟，在一起腻腻歪歪！【大熊猫和花 和叶】"
        panda983.releaseTime = 1651913054
        panda983.originalUrl = "https://www.bilibili.com/video/BV1ca411Y786"
        panda983.tags = "大熊猫,萌宠,动物圈"
        panda983.authorId = 16468440
        panda983.cover =
            "https://i1.hdslb.com/bfs/archive/b1daa515422f2c8de906686453fc8a4f66ea1bf4.jpg"
        list.add(panda983)

        val panda984 = PetVideo()
        panda984.type = VideoType.PANDA.ordinal
        panda984.fileName = "panda_group_panda984"
        panda984.code = 2896
        panda984.duration = 68
        panda984.period = PeriodType.GROUP.ordinal
        panda984.star = false
        panda984.title = "传说中的艾玖，她来了，她来夺笋了"
        panda984.releaseTime = 1651843800
        panda984.originalUrl = "https://www.bilibili.com/video/BV1X3411P7Rq"
        panda984.tags = "大熊猫,萌宠,动物圈"
        panda984.authorId = 98871951
        panda984.cover =
            "https://i2.hdslb.com/bfs/archive/46e6cc9b4dc7f8deba1eab4d5ac72e5a08e7b798.jpg"
        list.add(panda984)

        val panda985 = PetVideo()
        panda985.type = VideoType.PANDA.ordinal
        panda985.fileName = "panda_group_panda985"
        panda985.code = 2897
        panda985.duration = 58
        panda985.period = PeriodType.GROUP.ordinal
        panda985.star = false
        panda985.title = "幼年二班小熊友抢竹子、玩石头。。【大熊猫金喜、茱萸、福双】"
        panda985.releaseTime = 1651839516
        panda985.originalUrl = "https://www.bilibili.com/video/BV1gY411A7ye"
        panda985.tags = "大熊猫,萌宠,动物圈"
        panda985.authorId = 514531996
        panda985.cover =
            "https://i0.hdslb.com/bfs/archive/07d0e1d329d5ee16c951f4bba3b5360af186a6fa.jpg"
        list.add(panda985)

        val panda986 = PetVideo()
        panda986.type = VideoType.PANDA.ordinal
        panda986.fileName = "panda_group_panda986"
        panda986.code = 2898
        panda986.duration = 246
        panda986.period = PeriodType.GROUP.ordinal
        panda986.star = false
        panda986.title = "钓猫姗姗来迟的fa姐：大家都不要抢，我的小饭桌可以共享。【大熊猫和花、润玥、艾玖、和叶】"
        panda986.releaseTime = 1651745818
        panda986.originalUrl = "https://www.bilibili.com/video/BV11U4y1U7SF"
        panda986.tags = "大熊猫,萌宠,动物圈"
        panda986.authorId = 514531996
        panda986.cover =
            "https://i1.hdslb.com/bfs/archive/9c2f47f00f2324024240e67de05ff1d96d8db763.jpg"
        list.add(panda986)

        val panda987 = PetVideo()
        panda987.type = VideoType.PANDA.ordinal
        panda987.fileName = "panda_group_panda987"
        panda987.code = 2899
        panda987.duration = 90
        panda987.period = PeriodType.GROUP.ordinal
        panda987.star = false
        panda987.title = "成和花，你的待机时间太长了，是用的太阳能吗"
        panda987.releaseTime = 1651757400
        panda987.originalUrl = "https://www.bilibili.com/video/BV1gY4y1b7YB"
        panda987.tags = "大熊猫,萌宠,动物圈"
        panda987.authorId = 98871951
        panda987.cover =
            "https://i2.hdslb.com/bfs/archive/3e30e2eb0ad7297e2ee9b85d6cf2179a48025dcf.jpg"
        list.add(panda987)

        val panda988 = PetVideo()
        panda988.type = VideoType.PANDA.ordinal
        panda988.fileName = "panda_group_panda988"
        panda988.code = 2900
        panda988.duration = 54
        panda988.period = PeriodType.GROUP.ordinal
        panda988.star = false
        panda988.title = "(4.16)花主任伸懒腰——萌洗你"
        panda988.releaseTime = 1650160001
        panda988.originalUrl = "https://www.bilibili.com/video/BV1s3411T7GS"
        panda988.tags = "大熊猫,萌宠,动物圈"
        panda988.authorId = 1189717096
        panda988.cover =
            "https://i0.hdslb.com/bfs/archive/ba73e91019b8a2fe4b80bcaf3bce57547fab58e9.jpg"
        list.add(panda988)

        val panda989 = PetVideo()
        panda989.type = VideoType.PANDA.ordinal
        panda989.fileName = "panda_group_panda989"
        panda989.code = 2901
        panda989.duration = 89
        panda989.period = PeriodType.GROUP.ordinal
        panda989.star = false
        panda989.title = "【大熊猫和花】和弟弟排排坐，吃莽莽"
        panda989.releaseTime = 1651152600
        panda989.originalUrl = "https://www.bilibili.com/video/BV1iL4y1V7sQ"
        panda989.tags = "大熊猫,萌宠,动物圈"
        panda989.authorId = 98871951
        panda989.cover =
            "https://i2.hdslb.com/bfs/archive/4c331f0ddcd3de7bd1a84d81046d44ff3790f3f1.jpg"
        list.add(panda989)

        val panda990 = PetVideo()
        panda990.type = VideoType.PANDA.ordinal
        panda990.fileName = "panda_group_panda990"
        panda990.code = 2902
        panda990.duration = 109
        panda990.period = PeriodType.GROUP.ordinal
        panda990.star = false
        panda990.title = "二狗：火花，你咋嗷我喃。和花：一起拍证件照啊。【大熊猫和花、润玥】"
        panda990.releaseTime = 1651311304
        panda990.originalUrl = "https://www.bilibili.com/video/BV1vL4y1c7Hh"
        panda990.tags = "大熊猫,萌宠,动物圈"
        panda990.authorId = 514531996
        panda990.cover =
            "https://i0.hdslb.com/bfs/archive/0206b13f65d6de6acf617e7cfb9e3bec723d1cb1.jpg"
        list.add(panda990)

        val panda991 = PetVideo()
        panda991.type = VideoType.PANDA.ordinal
        panda991.fileName = "panda_group_panda991"
        panda991.code = 2903
        panda991.duration = 41
        panda991.period = PeriodType.GROUP.ordinal
        panda991.star = false
        panda991.title = "大熊猫和花、艾玖-大姐头的温柔一刻"
        panda991.releaseTime = 1651314749
        panda991.originalUrl = "https://www.bilibili.com/video/BV1GF411T7Vq"
        panda991.tags = "大熊猫,萌宠,动物圈"
        panda991.authorId = 1307515
        panda991.cover =
            "https://i1.hdslb.com/bfs/archive/dddf5961f9fb06a2027f851e7cd1e47ee76fe34f.jpg"
        list.add(panda991)

        val panda992 = PetVideo()
        panda992.type = VideoType.PANDA.ordinal
        panda992.fileName = "panda_group_panda992"
        panda992.code = 2904
        panda992.duration = 162
        panda992.period = PeriodType.GROUP.ordinal
        panda992.star = false
        panda992.title = "扯嗝儿、磕牙牙。。≈ 卖萌！！【大熊猫和花】"
        panda992.releaseTime = 1651137390
        panda992.originalUrl = "https://www.bilibili.com/video/BV1pr4y1n76J"
        panda992.tags = "大熊猫,萌宠,动物圈"
        panda992.authorId = 514531996
        panda992.cover =
            "https://i1.hdslb.com/bfs/archive/19dab5fcd879cea6fda29d31c20badda00d2421b.jpg"
        list.add(panda992)

        val panda993 = PetVideo()
        panda993.type = VideoType.PANDA.ordinal
        panda993.fileName = "panda_group_panda993"
        panda993.code = 2905
        panda993.duration = 119
        panda993.period = PeriodType.GROUP.ordinal
        panda993.star = false
        panda993.vertical = true
        panda993.title = "毛茸茸的小玩偶，自己打扫自己的小饭桌【大熊猫和花】"
        panda993.releaseTime = 1650534165
        panda993.originalUrl = "https://www.bilibili.com/video/BV1eY4y1a7Fw"
        panda993.tags = "大熊猫,萌宠,动物圈"
        panda993.authorId = 2062416280
        panda993.cover =
            "https://i1.hdslb.com/bfs/archive/50a78ac728609d30a74600ba1fcce0cc08ef8eb0.jpg"
        list.add(panda993)

        val panda994 = PetVideo()
        panda994.type = VideoType.PANDA.ordinal
        panda994.fileName = "panda_group_panda994"
        panda994.code = 2906
        panda994.duration = 118
        panda994.period = PeriodType.GROUP.ordinal
        panda994.star = false
        panda994.title = "祖孙三代吃播，谁是最霸气的一个？【大熊猫园园、园润、润玥】"
        panda994.releaseTime = 1650806781
        panda994.originalUrl = "https://www.bilibili.com/video/BV11r4y1J7YF"
        panda994.tags = "大熊猫,萌宠,动物圈"
        panda994.authorId = 514531996
        panda994.cover =
            "https://i1.hdslb.com/bfs/archive/b1ea6220151ea52bb26d148d17a5e90f6715f37b.jpg"
        list.add(panda994)

        val panda995 = PetVideo()
        panda995.type = VideoType.PANDA.ordinal
        panda995.fileName = "panda_group_panda995"
        panda995.code = 2907
        panda995.duration = 167
        panda995.period = PeriodType.GROUP.ordinal
        panda995.star = false
        panda995.title = "【大熊猫和花】萌兽和花生胖气"
        panda995.releaseTime = 1651067222
        panda995.originalUrl = "https://www.bilibili.com/video/BV1SY4y1Y7Vx"
        panda995.tags = "大熊猫,萌宠,动物圈"
        panda995.authorId = 384395600
        panda995.cover =
            "https://i1.hdslb.com/bfs/archive/8bed58cd4da8f1d24e9a3b9bf09e1a45f193a7a3.jpg"
        list.add(panda995)

        val panda996 = PetVideo()
        panda996.type = VideoType.PANDA.ordinal
        panda996.fileName = "panda_group_panda996"
        panda996.code = 2908
        panda996.duration = 66
        panda996.period = PeriodType.GROUP.ordinal
        panda996.star = false
        panda996.title = "我们是整个斧头山上班最早的熊熊了，南波湾，就问还有谁【大熊猫和花】"
        panda996.releaseTime = 1649579352
        panda996.originalUrl = "https://www.bilibili.com/video/BV1yT4y1Y7ff"
        panda996.tags = "大熊猫,萌宠,动物圈"
        panda996.authorId = 2062416280
        panda996.cover =
            "https://i2.hdslb.com/bfs/archive/bd59f6c89c31446913f885ecafb4f6ee64f7d98f.jpg"
        list.add(panda996)

        val panda997 = PetVideo()
        panda997.type = VideoType.PANDA.ordinal
        panda997.fileName = "panda_group_panda997"
        panda997.code = 2909
        panda997.duration = 140
        panda997.period = PeriodType.GROUP.ordinal
        panda997.star = false
        panda997.title = "【大熊猫福双&金双】你们俩的账单寄给谁？福禄和淼淼能签收吗"
        panda997.releaseTime = 1650799276
        panda997.originalUrl = "https://www.bilibili.com/video/BV1AF411u7an"
        panda997.tags = "大熊猫,萌宠,动物圈"
        panda997.authorId = 34677299
        panda997.cover =
            "https://i2.hdslb.com/bfs/archive/1c9b7fe4c2f103fef5ffdf385e09f6d18cc43862.jpg"
        list.add(panda997)

        val panda998 = PetVideo()
        panda998.type = VideoType.PANDA.ordinal
        panda998.fileName = "panda_group_panda998"
        panda998.code = 2910
        panda998.duration = 164
        panda998.period = PeriodType.GROUP.ordinal
        panda998.star = false
        panda998.title = "【大熊猫和花 润玥】菜花：好姐妹就是要贴在一起吃！"
        panda998.releaseTime = 1650602520
        panda998.originalUrl = "https://www.bilibili.com/video/BV1s34y1e7QN"
        panda998.tags = "大熊猫,萌宠,动物圈"
        panda998.authorId = 7782934
        panda998.cover =
            "https://i2.hdslb.com/bfs/archive/074c3073f4fc45dec38039ad5dac96e41886cc07.jpg"
        list.add(panda998)

        val panda999 = PetVideo()
        panda999.type = VideoType.PANDA.ordinal
        panda999.fileName = "panda_group_panda999"
        panda999.code = 2911
        panda999.duration = 200
        panda999.period = PeriodType.GROUP.ordinal
        panda999.star = false
        panda999.title = "追赶爷爷声音的超跑花。【大熊猫和花】"
        panda999.releaseTime = 1650634054
        panda999.originalUrl = "https://www.bilibili.com/video/BV1EY4y1Y7xk"
        panda999.tags = "大熊猫,萌宠,动物圈"
        panda999.authorId = 514531996
        panda999.cover =
            "https://i2.hdslb.com/bfs/archive/5e25fc0742b43eb37093a1e86ba9eb889b0c0d68.jpg"
        list.add(panda999)

        val panda1000 = PetVideo()
        panda1000.type = VideoType.PANDA.ordinal
        panda1000.fileName = "panda_group_panda1000"
        panda1000.code = 2912
        panda1000.duration = 26
        panda1000.period = PeriodType.GROUP.ordinal
        panda1000.star = false
        panda1000.title = "【大熊猫和花/和叶/润玥/艾玖】疑似和花“碰瓷”现场？"
        panda1000.releaseTime = 1649996169
        panda1000.originalUrl = "https://www.bilibili.com/video/BV17r4y1H77H"
        panda1000.tags = "大熊猫,萌宠,动物圈"
        panda1000.authorId = 18329821
        panda1000.cover =
            "https://i2.hdslb.com/bfs/archive/9513b3d9f3e5146a70b1b6ede86764a8538a3a7e.jpg"
        list.add(panda1000)

        val panda1001 = PetVideo()
        panda1001.type = VideoType.PANDA.ordinal
        panda1001.fileName = "panda_group_panda1001"
        panda1001.code = 2913
        panda1001.duration = 92
        panda1001.period = PeriodType.GROUP.ordinal
        panda1001.star = false
        panda1001.title = "和花：聪明可爱的我，只要跟着姐姐们跑就很安全哒～"
        panda1001.releaseTime = 1648375649
        panda1001.originalUrl = "https://www.bilibili.com/video/BV1AR4y1F7ub"
        panda1001.tags = "大熊猫,萌宠,动物圈"
        panda1001.authorId = 504946089
        panda1001.cover =
            "https://i1.hdslb.com/bfs/archive/13e84694fadc101829d646ee4907f20d24d726b6.jpg"
        list.add(panda1001)

        val panda1002 = PetVideo()
        panda1002.type = VideoType.PANDA.ordinal
        panda1002.fileName = "panda_group_panda1002"
        panda1002.code = 2914
        panda1002.duration = 245
        panda1002.period = PeriodType.GROUP.ordinal
        panda1002.star = false
        panda1002.vertical = true
        panda1002.title = "花仙子优雅漫步中【和花】"
        panda1002.releaseTime = 1649994341
        panda1002.originalUrl = "https://www.bilibili.com/video/BV1vY411j7J4"
        panda1002.tags = "大熊猫,萌宠,动物圈"
        panda1002.authorId = 1025949925
        panda1002.cover =
            "https://i0.hdslb.com/bfs/archive/c8c412682f0a6446fa5e175adfd335b5e2c5724b.jpg"
        list.add(panda1002)

        val panda1003 = PetVideo()
        panda1003.type = VideoType.PANDA.ordinal
        panda1003.fileName = "panda_group_panda1003"
        panda1003.code = 2915
        panda1003.duration = 160
        panda1003.period = PeriodType.GROUP.ordinal
        panda1003.star = false
        panda1003.vertical = true
        panda1003.title = "大熊猫的智商有多高？【和花】"
        panda1003.releaseTime = 1650423900
        panda1003.originalUrl = "https://www.bilibili.com/video/BV1F44y1G7ob"
        panda1003.tags = "大熊猫,萌宠,动物圈"
        panda1003.authorId = 1025949925
        panda1003.cover =
            "https://i1.hdslb.com/bfs/archive/4e1a8dea0765c47f6ffedc51efd22cb5e83fd99d.jpg"
        list.add(panda1003)

        val panda1004 = PetVideo()
        panda1004.type = VideoType.PANDA.ordinal
        panda1004.fileName = "panda_group_panda1004"
        panda1004.code = 2916
        panda1004.duration = 207
        panda1004.period = PeriodType.GROUP.ordinal
        panda1004.star = false
        panda1004.title = "和花：爷爷，我坐好了！下午爷爷加笋，和花以为要给小苹果，最后只得把笋投到和花旁边【大熊猫和花】"
        panda1004.releaseTime = 1650426905
        panda1004.originalUrl = "https://www.bilibili.com/video/BV1mA4y1Q7eo"
        panda1004.tags = "大熊猫,萌宠,动物圈"
        panda1004.authorId = 230382720
        panda1004.cover =
            "https://i1.hdslb.com/bfs/archive/1ce953e65bbe32c3f4881ad79f1b0d9bffae3a29.jpg"
        list.add(panda1004)

        val panda1005 = PetVideo()
        panda1005.type = VideoType.PANDA.ordinal
        panda1005.fileName = "panda_group_panda1005"
        panda1005.code = 2917
        panda1005.duration = 163
        panda1005.period = PeriodType.GROUP.ordinal
        panda1005.star = false
        panda1005.title = "【大熊猫福双&重阳】青梅竹马，两小无猜"
        panda1005.releaseTime = 1650375903
        panda1005.originalUrl = "https://www.bilibili.com/video/BV1EY4y1a7xn"
        panda1005.tags = "大熊猫,萌宠,动物圈"
        panda1005.authorId = 34677299
        panda1005.cover =
            "https://i0.hdslb.com/bfs/archive/6456212173e3cc537d7e5e8074273af96cb84278.jpg"
        list.add(panda1005)

        val panda1006 = PetVideo()
        panda1006.type = VideoType.PANDA.ordinal
        panda1006.fileName = "panda_group_panda1006"
        panda1006.code = 2918
        panda1006.duration = 118
        panda1006.period = PeriodType.GROUP.ordinal
        panda1006.star = false
        panda1006.title = "这位按摩小弟，手不要停。不要只顾自己吃笋笋。【大熊猫和花、和叶、润玥】"
        panda1006.releaseTime = 1650371134
        panda1006.originalUrl = "https://www.bilibili.com/video/BV1AZ4y1172S"
        panda1006.tags = "大熊猫,萌宠,动物圈"
        panda1006.authorId = 514531996
        panda1006.cover =
            "https://i1.hdslb.com/bfs/archive/71376157c852b819a020ea095dd9f3fbf82c429f.jpg"
        list.add(panda1006)

        val panda1007 = PetVideo()
        panda1007.type = VideoType.PANDA.ordinal
        panda1007.fileName = "panda_group_panda1007"
        panda1007.code = 2919
        panda1007.duration = 99
        panda1007.period = PeriodType.GROUP.ordinal
        panda1007.star = false
        panda1007.title = "专业剥笋大师成和花已就位，小熊友们请排队！【大熊猫和花】"
        panda1007.releaseTime = 1650236640
        panda1007.originalUrl = "https://www.bilibili.com/video/BV1sB4y127PP"
        panda1007.tags = "大熊猫,萌宠,动物圈"
        panda1007.authorId = 16468440
        panda1007.cover =
            "https://i0.hdslb.com/bfs/archive/1e93f4001c0dc4f3c7401a0f8b2847defea8e8e1.jpg"
        list.add(panda1007)

        val panda1008 = PetVideo()
        panda1008.type = VideoType.PANDA.ordinal
        panda1008.fileName = "panda_group_panda1008"
        panda1008.code = 2920
        panda1008.duration = 33
        panda1008.period = PeriodType.GROUP.ordinal
        panda1008.star = false
        panda1008.title = "大熊猫和花和叶-姐弟同心，其力可以rua姐"
        panda1008.releaseTime = 1650191525
        panda1008.originalUrl = "https://www.bilibili.com/video/BV1M44y1G7cf"
        panda1008.tags = "大熊猫,萌宠,动物圈"
        panda1008.authorId = 1307515
        panda1008.cover =
            "https://i0.hdslb.com/bfs/archive/90ea0c125a7cf480d2bab3f723783a5fd7602b3a.jpg"
        list.add(panda1008)

        val panda1009 = PetVideo()
        panda1009.type = VideoType.PANDA.ordinal
        panda1009.fileName = "panda_group_panda1009"
        panda1009.code = 2921
        panda1009.duration = 49
        panda1009.period = PeriodType.GROUP.ordinal
        panda1009.star = false
        panda1009.title = "嗯？中间那个圆不隆冬的是小猪猪吧？【大熊猫和花、和叶、润玥】"
        panda1009.releaseTime = 1650197124
        panda1009.originalUrl = "https://www.bilibili.com/video/BV19Y4y1h7hB"
        panda1009.tags = "大熊猫,萌宠,动物圈"
        panda1009.authorId = 514531996
        panda1009.cover =
            "https://i1.hdslb.com/bfs/archive/8c562a9e1f59c80ac3aa5959446ba6d0e57dadf8.jpg"
        list.add(panda1009)

        val panda1010 = PetVideo()
        panda1010.type = VideoType.PANDA.ordinal
        panda1010.fileName = "panda_group_panda1010"
        panda1010.code = 2922
        panda1010.duration = 138
        panda1010.period = PeriodType.GROUP.ordinal
        panda1010.star = false
        panda1010.title = "看到二狗下架子去吃笋，和花心生一计，欲从二狗背后偷袭【大熊猫和花、润玥】"
        panda1010.releaseTime = 1650197997
        panda1010.originalUrl = "https://www.bilibili.com/video/BV1jZ4y117rr"
        panda1010.tags = "大熊猫,萌宠,动物圈"
        panda1010.authorId = 230382720
        panda1010.cover =
            "https://i2.hdslb.com/bfs/archive/b10092576ea3614ee88ab221346e62594bdc8db3.jpg"
        list.add(panda1010)

        val panda1011 = PetVideo()
        panda1011.type = VideoType.PANDA.ordinal
        panda1011.fileName = "panda_group_panda1011"
        panda1011.code = 2923
        panda1011.duration = 97
        panda1011.period = PeriodType.GROUP.ordinal
        panda1011.star = false
        panda1011.title = "吃得饱饱的艾玖，又登上了大宝座！【大熊猫艾玖】"
        panda1011.releaseTime = 1650181943
        panda1011.originalUrl = "https://www.bilibili.com/video/BV1Z34y1v7kD"
        panda1011.tags = "大熊猫,萌宠,动物圈"
        panda1011.authorId = 16468440
        panda1011.cover =
            "https://i2.hdslb.com/bfs/archive/2867bf9619222a65f1f83c764d1f912389bbc28b.jpg"
        list.add(panda1011)

        val panda1012 = PetVideo()
        panda1012.type = VideoType.PANDA.ordinal
        panda1012.fileName = "panda_group_panda1012"
        panda1012.code = 2924
        panda1012.duration = 230
        panda1012.period = PeriodType.GROUP.ordinal
        panda1012.star = false
        panda1012.title = "女明星不慌不忙的向苹果走来，大家彩虹p快吹起来。~4.16钓猫 【大熊猫和花、和叶、润玥】"
        panda1012.releaseTime = 1650112668
        panda1012.originalUrl = "https://www.bilibili.com/video/BV1AZ4y1m7Cu"
        panda1012.tags = "大熊猫,萌宠,动物圈"
        panda1012.authorId = 514531996
        panda1012.cover =
            "https://i0.hdslb.com/bfs/archive/edbc433a8d4b49fd68bf4a5b00ec0e51e6f88e6c.jpg"
        list.add(panda1012)

        val panda1013 = PetVideo()
        panda1013.type = VideoType.PANDA.ordinal
        panda1013.fileName = "panda_group_panda1013"
        panda1013.code = 2925
        panda1013.duration = 79
        panda1013.period = PeriodType.GROUP.ordinal
        panda1013.star = false
        panda1013.title = "和花不要笋笋，和花要爷爷手里的小苹果，熊家都闻到啦！还要还要！【大熊猫和花】"
        panda1013.releaseTime = 1650113781
        panda1013.originalUrl = "https://www.bilibili.com/video/BV1K94y1o7FX"
        panda1013.tags = "大熊猫,萌宠,动物圈"
        panda1013.authorId = 16468440
        panda1013.cover =
            "https://i1.hdslb.com/bfs/archive/58ac2f6a4709fe79d134e99659a8079453b91727.jpg"
        list.add(panda1013)

        val panda1014 = PetVideo()
        panda1014.type = VideoType.PANDA.ordinal
        panda1014.fileName = "panda_group_panda1014"
        panda1014.code = 2926
        panda1014.duration = 65
        panda1014.period = PeriodType.GROUP.ordinal
        panda1014.star = false
        panda1014.title = "菜总睡梦中还在脚踢大坏蛋呀，花儿小心误伤！【大熊猫和花润玥】"
        panda1014.releaseTime = 1650067573
        panda1014.originalUrl = "https://www.bilibili.com/video/BV1yS4y1Y7cn"
        panda1014.tags = "大熊猫,萌宠,动物圈"
        panda1014.authorId = 16468440
        panda1014.cover =
            "https://i0.hdslb.com/bfs/archive/799b5a1abef8f8f8ebdda9aab7a296db28263487.jpg"
        list.add(panda1014)

        val panda1015 = PetVideo()
        panda1015.type = VideoType.PANDA.ordinal
        panda1015.fileName = "panda_group_panda1015"
        panda1015.code = 2927
        panda1015.duration = 73
        panda1015.period = PeriodType.GROUP.ordinal
        panda1015.star = false
        panda1015.title = "和花～她好像知道自己很可爱"
        panda1015.releaseTime = 1649914235
        panda1015.originalUrl = "https://www.bilibili.com/video/BV1a3411n7Ug"
        panda1015.tags = "大熊猫,萌宠,动物圈"
        panda1015.authorId = 19715714
        panda1015.cover =
            "https://i1.hdslb.com/bfs/archive/87f1fdbe99a1a2f4cb53be7aa1b693cff71a6654.jpg"
        list.add(panda1015)

        val panda1016 = PetVideo()
        panda1016.type = VideoType.PANDA.ordinal
        panda1016.fileName = "panda_group_panda1016"
        panda1016.code = 2928
        panda1016.duration = 227
        panda1016.period = PeriodType.GROUP.ordinal
        panda1016.star = false
        panda1016.title = "04.13窝头苹果时间，和花的坐姿好乖巧【大熊猫和花、和叶、润玥】"
        panda1016.releaseTime = 1649853359
        panda1016.originalUrl = "https://www.bilibili.com/video/BV1ga411v7e4"
        panda1016.tags = "大熊猫,萌宠,动物圈"
        panda1016.authorId = 230382720
        panda1016.cover =
            "https://i2.hdslb.com/bfs/archive/7d832ef33ce2cf5a9bc67c536fe46ddb0434df69.jpg"
        list.add(panda1016)

        val panda1017 = PetVideo()
        panda1017.type = VideoType.PANDA.ordinal
        panda1017.fileName = "panda_group_panda1017"
        panda1017.code = 2929
        panda1017.duration = 46
        panda1017.period = PeriodType.GROUP.ordinal
        panda1017.star = false
        panda1017.title = "大熊猫和花-认真挑选细嚼慢咽，跟聪明小熊学吃竹子"
        panda1017.releaseTime = 1649757099
        panda1017.originalUrl = "https://www.bilibili.com/video/BV1a541127Gd"
        panda1017.tags = "大熊猫,萌宠,动物圈"
        panda1017.authorId = 1307515
        panda1017.cover =
            "https://i1.hdslb.com/bfs/archive/6854ecc30a4f8259ffa4aa789145897cf571c9ca.jpg"
        list.add(panda1017)

        val panda1018 = PetVideo()
        panda1018.type = VideoType.PANDA.ordinal
        panda1018.fileName = "panda_group_panda1018"
        panda1018.code = 2930
        panda1018.duration = 31
        panda1018.period = PeriodType.GROUP.ordinal
        panda1018.star = false
        panda1018.title = "熊熊祟祟的和花想走员工通道，无奈没有钥匙进不去只能乖乖走熊熊通道"
        panda1018.releaseTime = 1649749051
        panda1018.originalUrl = "https://www.bilibili.com/video/BV1DY4y1H7ss"
        panda1018.tags = "大熊猫,萌宠,动物圈"
        panda1018.authorId = 384395600
        panda1018.cover =
            "https://i0.hdslb.com/bfs/archive/34569e6a4f8b91772a2c0b7e2be3e171103c1c52.jpg"
        list.add(panda1018)

        val panda1019 = PetVideo()
        panda1019.type = VideoType.PANDA.ordinal
        panda1019.fileName = "panda_group_panda1019"
        panda1019.code = 2931
        panda1019.duration = 136
        panda1019.period = PeriodType.GROUP.ordinal
        panda1019.star = false
        panda1019.title = "关于太阳九嘟的10个小问题，看谭爷爷来一一回复吧"
        panda1019.releaseTime = 1649673072
        panda1019.originalUrl = "https://www.bilibili.com/video/BV1fq4y1a7ZK"
        panda1019.tags = "大熊猫,萌宠,动物圈"
        panda1019.authorId = 1025949925
        panda1019.cover =
            "https://i2.hdslb.com/bfs/archive/364dd708e3f5ac920c35aed8f86cef4c0f749242.jpg"
        list.add(panda1019)

        val panda1020 = PetVideo()
        panda1020.type = VideoType.PANDA.ordinal
        panda1020.fileName = "panda_group_panda1020"
        panda1020.code = 2932
        panda1020.duration = 58
        panda1020.period = PeriodType.GROUP.ordinal
        panda1020.star = false
        panda1020.vertical = true
        panda1020.title = "吃货的心挡不住"
        panda1020.releaseTime = 1649302806
        panda1020.originalUrl = "https://www.bilibili.com/video/BV1tS4y117sp"
        panda1020.tags = "大熊猫,萌宠,动物圈"
        panda1020.authorId = 1025949925
        panda1020.cover =
            "https://i2.hdslb.com/bfs/archive/5c3ba1218ad9a80539ae144eeb6b084f007fdfd2.jpg"
        list.add(panda1020)

        val panda1021 = PetVideo()
        panda1021.type = VideoType.PANDA.ordinal
        panda1021.fileName = "panda_group_panda1021"
        panda1021.code = 2933
        panda1021.duration = 174
        panda1021.period = PeriodType.GROUP.ordinal
        panda1021.star = false
        panda1021.vertical = true
        panda1021.title = "社恐熊如何走出心理阴影"
        panda1021.releaseTime = 1642995307
        panda1021.originalUrl = "https://www.bilibili.com/video/BV1tS4y1L7MS"
        panda1021.tags = "大熊猫,萌宠,动物圈"
        panda1021.authorId = 1025949925
        panda1021.cover =
            "https://i0.hdslb.com/bfs/archive/a1a815b838ac9b4c31b6d1ade9f6725f6c90aac3.jpg"
        list.add(panda1021)

        val panda1022 = PetVideo()
        panda1022.type = VideoType.PANDA.ordinal
        panda1022.fileName = "panda_group_panda1022"
        panda1022.code = 2934
        panda1022.duration = 227
        panda1022.period = PeriodType.GROUP.ordinal
        panda1022.star = false
        panda1022.title = "【大熊猫】终于逮到二班的宝宝们同框了，爷爷天上下笋笋，咔次咔次咔次"
        panda1022.releaseTime = 1649594783
        panda1022.originalUrl = "https://www.bilibili.com/video/BV1EF411G7LT"
        panda1022.tags = "大熊猫,萌宠,动物圈"
        panda1022.authorId = 34677299
        panda1022.cover =
            "https://i1.hdslb.com/bfs/archive/47c31700ff851dac88645a55d67dcea22356798d.jpg"
        list.add(panda1022)

        val panda1023 = PetVideo()
        panda1023.type = VideoType.PANDA.ordinal
        panda1023.fileName = "panda_group_panda1023"
        panda1023.code = 2935
        panda1023.duration = 81
        panda1023.period = PeriodType.GROUP.ordinal
        panda1023.star = false
        panda1023.title = "和花瓜瓜靠在一起吃笋笋。【大熊猫和花、和叶】"
        panda1023.releaseTime = 1649590296
        panda1023.originalUrl = "https://www.bilibili.com/video/BV1HS4y127Z9"
        panda1023.tags = "大熊猫,萌宠,动物圈"
        panda1023.authorId = 514531996
        panda1023.cover =
            "https://i1.hdslb.com/bfs/archive/064fb20ff0fc76b972e54c77a8c29c18a2bb7a9e.jpg"
        list.add(panda1023)

        val panda1024 = PetVideo()
        panda1024.type = VideoType.PANDA.ordinal
        panda1024.fileName = "panda_group_panda1024"
        panda1024.code = 2936
        panda1024.duration = 132
        panda1024.period = PeriodType.GROUP.ordinal
        panda1024.star = false
        panda1024.title = "【四喜丸子】兰虫虫：锅锅，害怕的是窝呀？为什么你抱的却是妹妹？？？"
        panda1024.releaseTime = 1649330948
        panda1024.originalUrl = "https://www.bilibili.com/video/BV11Y4y1v7Xd"
        panda1024.tags = "大熊猫,萌宠,动物圈"
        panda1024.authorId = 180602305
        panda1024.cover =
            "https://i0.hdslb.com/bfs/archive/600744aacbbc9f46c2c42ad96a70db2f3e0ccec6.jpg"
        list.add(panda1024)

        val panda1025 = PetVideo()
        panda1025.type = VideoType.PANDA.ordinal
        panda1025.fileName = "panda_group_panda1025"
        panda1025.code = 2937
        panda1025.duration = 320
        panda1025.period = PeriodType.GROUP.ordinal
        panda1025.star = false
        panda1025.title = "【大熊猫和花】爷爷喊了好久，六点十几分，和花终于下树了04.06"
        panda1025.releaseTime = 1649333823
        panda1025.originalUrl = "https://www.bilibili.com/video/BV1GY4y1H7a5"
        panda1025.tags = "大熊猫,萌宠,动物圈"
        panda1025.authorId = 230382720
        panda1025.cover =
            "https://i2.hdslb.com/bfs/archive/96d2a53fd8a857cb2b52999db1b040a27dd23cdc.jpg"
        list.add(panda1025)

        val panda1026 = PetVideo()
        panda1026.type = VideoType.PANDA.ordinal
        panda1026.fileName = "panda_group_panda1026"
        panda1026.code = 2938
        panda1026.duration = 75
        panda1026.period = PeriodType.GROUP.ordinal
        panda1026.star = false
        panda1026.title = "有些小熊猫，一个翻身就变成了一张趴趴垫！【大熊猫和花】"
        panda1026.releaseTime = 1649331685
        panda1026.originalUrl = "https://www.bilibili.com/video/BV1ei4y1S7kn"
        panda1026.tags = "大熊猫,萌宠,动物圈"
        panda1026.authorId = 16468440
        panda1026.cover =
            "https://i1.hdslb.com/bfs/archive/af4de73d38cd85296abc7ecd8c2190b13a0a0c63.jpg"
        list.add(panda1026)

        val panda1027 = PetVideo()
        panda1027.type = VideoType.PANDA.ordinal
        panda1027.fileName = "panda_group_panda1027"
        panda1027.code = 2939
        panda1027.duration = 214
        panda1027.period = PeriodType.GROUP.ordinal
        panda1027.star = false
        panda1027.title = "急性子vs慢性子回家~二狗DuangDuangDuang，fafa：爷爷不慌，我吃块苹果宠个粉先。【大熊猫和花、润玥】"
        panda1027.releaseTime = 1649320200
        panda1027.originalUrl = "https://www.bilibili.com/video/BV1g34y1x71o"
        panda1027.tags = "大熊猫,萌宠,动物圈"
        panda1027.authorId = 514531996
        panda1027.cover =
            "https://i0.hdslb.com/bfs/archive/0c0aefe057a73d7d7f7fa7f749f570de80df46a5.jpg"
        list.add(panda1027)

        val panda1028 = PetVideo()
        panda1028.type = VideoType.PANDA.ordinal
        panda1028.fileName = "panda_group_panda1028"
        panda1028.code = 2940
        panda1028.duration = 86
        panda1028.period = PeriodType.GROUP.ordinal
        panda1028.star = false
        panda1028.title = "一花一叶一世界（大熊猫和花和叶）"
        panda1028.releaseTime = 1649205185
        panda1028.originalUrl = "https://www.bilibili.com/video/BV16S4y117ML"
        panda1028.tags = "大熊猫,萌宠,动物圈"
        panda1028.authorId = 2137796700
        panda1028.cover =
            "https://i1.hdslb.com/bfs/archive/1110c5f9e6eabb4c2c3092b35ab6047602732f17.jpg"
        list.add(panda1028)

        val panda1029 = PetVideo()
        panda1029.type = VideoType.PANDA.ordinal
        panda1029.fileName = "panda_group_panda1029"
        panda1029.code = 2941
        panda1029.duration = 67
        panda1029.period = PeriodType.GROUP.ordinal
        panda1029.star = false
        panda1029.title = "【大熊猫和花&润玥】二狗姐姐的贴心小花"
        panda1029.releaseTime = 1649232900
        panda1029.originalUrl = "https://www.bilibili.com/video/BV1s3411J77D"
        panda1029.tags = "大熊猫,萌宠,动物圈"
        panda1029.authorId = 1808524083
        panda1029.cover =
            "https://i1.hdslb.com/bfs/archive/1ff4a31342d58ccd2fea4099a7a858a73abe8649.jpg"
        list.add(panda1029)

        val panda1030 = PetVideo()
        panda1030.type = VideoType.PANDA.ordinal
        panda1030.fileName = "panda_group_panda1030"
        panda1030.code = 2942
        panda1030.duration = 93
        panda1030.period = PeriodType.GROUP.ordinal
        panda1030.star = false
        panda1030.title = "接双休后的和花上班（大熊猫和花）"
        panda1030.releaseTime = 1649117205
        panda1030.originalUrl = "https://www.bilibili.com/video/BV13q4y1a7hU"
        panda1030.tags = "大熊猫,萌宠,动物圈"
        panda1030.authorId = 2137796700
        panda1030.cover =
            "https://i2.hdslb.com/bfs/archive/2fa6c349589910ae24ec5694f8324c5f89a29e9a.jpg"
        list.add(panda1030)

        val panda1031 = PetVideo()
        panda1031.type = VideoType.PANDA.ordinal
        panda1031.fileName = "panda_group_panda1031"
        panda1031.code = 2943
        panda1031.duration = 61
        panda1031.period = PeriodType.GROUP.ordinal
        panda1031.star = false
        panda1031.title = "绝世萌花挠朵朵。【大熊猫和花】"
        panda1031.releaseTime = 1649144531
        panda1031.originalUrl = "https://www.bilibili.com/video/BV1tZ4y1U734"
        panda1031.tags = "大熊猫,萌宠,动物圈"
        panda1031.authorId = 514531996
        panda1031.cover =
            "https://i0.hdslb.com/bfs/archive/83897c6f64415f7fa88fefdf65f2e93415f65ea7.jpg"
        list.add(panda1031)

        val panda1032 = PetVideo()
        panda1032.type = VideoType.PANDA.ordinal
        panda1032.fileName = "panda_group_panda1032"
        panda1032.code = 2944
        panda1032.duration = 70
        panda1032.period = PeriodType.GROUP.ordinal
        panda1032.star = false
        panda1032.title = "树颠颠上有一只玩偶熊猫，还在挪屁屁，这也太可爱了吧！是和花呀！【大熊猫和花】"
        panda1032.releaseTime = 1649131535
        panda1032.originalUrl = "https://www.bilibili.com/video/BV1YL4y1j7ck"
        panda1032.tags = "大熊猫,萌宠,动物圈"
        panda1032.authorId = 16468440
        panda1032.cover =
            "https://i1.hdslb.com/bfs/archive/946f61bd28297da5bb6e3603c262aa8a1491e9ab.jpg"
        list.add(panda1032)

        val panda1033 = PetVideo()
        panda1033.type = VideoType.PANDA.ordinal
        panda1033.fileName = "panda_group_panda1033"
        panda1033.code = 2945
        panda1033.duration = 61
        panda1033.period = PeriodType.GROUP.ordinal
        panda1033.star = false
        panda1033.title = "和花润玥～和花当关，碰瓷失败"
        panda1033.releaseTime = 1648973836
        panda1033.originalUrl = "https://www.bilibili.com/video/BV1yi4y1Q7GM"
        panda1033.tags = "大熊猫,萌宠,动物圈"
        panda1033.authorId = 19715714
        panda1033.cover =
            "https://i2.hdslb.com/bfs/archive/6cfc33834a4b458893a68674cc1ca68e6251ca4c.jpg"
        list.add(panda1033)

        val panda1034 = PetVideo()
        panda1034.type = VideoType.PANDA.ordinal
        panda1034.fileName = "panda_group_panda1034"
        panda1034.code = 2946
        panda1034.duration = 82
        panda1034.period = PeriodType.GROUP.ordinal
        panda1034.star = false
        panda1034.title = "今天坐在这里的是花大爷！【大熊猫和花】"
        panda1034.releaseTime = 1648978080
        panda1034.originalUrl = "https://www.bilibili.com/video/BV1uF41137gs"
        panda1034.tags = "大熊猫,萌宠,动物圈"
        panda1034.authorId = 16468440
        panda1034.cover =
            "https://i2.hdslb.com/bfs/archive/eecd9687020e8e36adce4e8dffa8b5071374c488.jpg"
        list.add(panda1034)

        val panda1035 = PetVideo()
        panda1035.type = VideoType.PANDA.ordinal
        panda1035.fileName = "panda_group_panda1035"
        panda1035.code = 2947
        panda1035.duration = 139
        panda1035.period = PeriodType.GROUP.ordinal
        panda1035.star = false
        panda1035.title = "【大熊猫和花&和叶】“想夺笋，脚拒”"
        panda1035.releaseTime = 1649073926
        panda1035.originalUrl = "https://www.bilibili.com/video/BV1Ki4y1D7XJ"
        panda1035.tags = "大熊猫,萌宠,动物圈"
        panda1035.authorId = 34677299
        panda1035.cover =
            "https://i2.hdslb.com/bfs/archive/ad7d9a067d87ea14efa9e52e47370f7589149482.jpg"
        list.add(panda1035)

        val panda1036 = PetVideo()
        panda1036.type = VideoType.PANDA.ordinal
        panda1036.fileName = "panda_group_panda1036"
        panda1036.code = 2948
        panda1036.duration = 193
        panda1036.period = PeriodType.GROUP.ordinal
        panda1036.star = false
        panda1036.title = "和叶把和花按下水沟，和花气得把自己滚成了小花猫er，起来再战！【大熊猫和花 和叶 润玥】"
        panda1036.releaseTime = 1649027040
        panda1036.originalUrl = "https://www.bilibili.com/video/BV1uF41137EE"
        panda1036.tags = "大熊猫,萌宠,动物圈"
        panda1036.authorId = 16468440
        panda1036.cover =
            "https://i0.hdslb.com/bfs/archive/472c24b5245c7230df84a48eb805fd0b62ac5d93.jpg"
        list.add(panda1036)

        val panda1037 = PetVideo()
        panda1037.type = VideoType.PANDA.ordinal
        panda1037.fileName = "panda_group_panda1037"
        panda1037.code = 2949
        panda1037.duration = 147
        panda1037.period = PeriodType.GROUP.ordinal
        panda1037.star = false
        panda1037.title = "和叶，坐那么远，过来一起吃嘛！【大熊猫和花 和叶 润玥 艾玖】"
        panda1037.releaseTime = 1648962022
        panda1037.originalUrl = "https://www.bilibili.com/video/BV1BP4y1K7nH"
        panda1037.tags = "大熊猫,萌宠,动物圈"
        panda1037.authorId = 16468440
        panda1037.cover =
            "https://i1.hdslb.com/bfs/archive/fd2d879410d5fbfe2cbbd4c1a0ea6fcf44365f24.jpg"
        list.add(panda1037)

        val panda1038 = PetVideo()
        panda1038.type = VideoType.PANDA.ordinal
        panda1038.fileName = "panda_group_panda1038"
        panda1038.code = 2950
        panda1038.duration = 195
        panda1038.period = PeriodType.GROUP.ordinal
        panda1038.star = false
        panda1038.title = "2022.4.2谭爷爷出来接和花回家"
        panda1038.releaseTime = 1648900160
        panda1038.originalUrl = "https://www.bilibili.com/video/BV19r4y1H7Ae"
        panda1038.tags = "大熊猫,萌宠,动物圈"
        panda1038.authorId = 384395600
        panda1038.cover =
            "https://i2.hdslb.com/bfs/archive/13521863ef9dcb5066906a707d74120b8941ff9e.jpg"
        list.add(panda1038)

        val panda1039 = PetVideo()
        panda1039.type = VideoType.PANDA.ordinal
        panda1039.fileName = "panda_group_panda1039"
        panda1039.code = 2951
        panda1039.duration = 94
        panda1039.period = PeriodType.GROUP.ordinal
        panda1039.star = false
        panda1039.title = "春之挂树姐妹花～太美了！【大熊猫和花 润玥】"
        panda1039.releaseTime = 1648891680
        panda1039.originalUrl = "https://www.bilibili.com/video/BV15r4y1s7Cy"
        panda1039.tags = "大熊猫,萌宠,动物圈"
        panda1039.authorId = 16468440
        panda1039.cover =
            "https://i0.hdslb.com/bfs/archive/607f78fd918d6bd46b2c5177805af8965f8e11dd.jpg"
        list.add(panda1039)

        val panda1040 = PetVideo()
        panda1040.type = VideoType.PANDA.ordinal
        panda1040.fileName = "panda_group_panda1040"
        panda1040.code = 2952
        panda1040.duration = 122
        panda1040.period = PeriodType.GROUP.ordinal
        panda1040.star = false
        panda1040.title = "【大熊猫和花&和叶】俩姐弟一起排排坐吃笋笋，好乖"
        panda1040.releaseTime = 1648884349
        panda1040.originalUrl = "https://www.bilibili.com/video/BV1o34y147Nv"
        panda1040.tags = "大熊猫,萌宠,动物圈"
        panda1040.authorId = 34677299
        panda1040.cover =
            "https://i1.hdslb.com/bfs/archive/8e3c444c8d56e3e076af3e38acc2ff46780bf2df.jpg"
        list.add(panda1040)

        val panda1041 = PetVideo()
        panda1041.type = VideoType.PANDA.ordinal
        panda1041.fileName = "panda_group_panda1041"
        panda1041.code = 2953
        panda1041.duration = 69
        panda1041.period = PeriodType.GROUP.ordinal
        panda1041.star = false
        panda1041.title = "晕了，和花挠耳朵也太可爱了吧"
        panda1041.releaseTime = 1648897270
        panda1041.originalUrl = "https://www.bilibili.com/video/BV1eS4y1m727"
        panda1041.tags = "大熊猫,萌宠,动物圈"
        panda1041.authorId = 384395600
        panda1041.cover =
            "https://i1.hdslb.com/bfs/archive/9d41e0c1240edc978c8ccdd46f7acbea5be9bab7.jpg"
        list.add(panda1041)

        val panda1042 = PetVideo()
        panda1042.type = VideoType.PANDA.ordinal
        panda1042.fileName = "panda_group_panda1042"
        panda1042.code = 2954
        panda1042.duration = 280
        panda1042.period = PeriodType.GROUP.ordinal
        panda1042.star = false
        panda1042.title = "04.01 钓猫Part1  慢点，和花的头套按松了！【大熊猫和花 和叶 润玥】"
        panda1042.releaseTime = 1648829500
        panda1042.originalUrl = "https://www.bilibili.com/video/BV1f3411n7XV"
        panda1042.tags = "大熊猫,萌宠,动物圈"
        panda1042.authorId = 16468440
        panda1042.cover =
            "https://i1.hdslb.com/bfs/archive/ab2169362303165d9c77cde14913e5ca4281eee4.jpg"
        list.add(panda1042)

        val panda1043 = PetVideo()
        panda1043.type = VideoType.PANDA.ordinal
        panda1043.fileName = "panda_group_panda1043"
        panda1043.code = 2955
        panda1043.duration = 84
        panda1043.period = PeriodType.GROUP.ordinal
        panda1043.star = false
        panda1043.title = "花宝叽，快停止卖萌！这样是很危险的！！【大熊猫和花】"
        panda1043.releaseTime = 1648729680
        panda1043.originalUrl = "https://www.bilibili.com/video/BV1xu411i7GM"
        panda1043.tags = "大熊猫,萌宠,动物圈"
        panda1043.authorId = 16468440
        panda1043.cover =
            "https://i1.hdslb.com/bfs/archive/58ae3191ae5afe79c0f3f59b7151bfc937e3403b.jpg"
        list.add(panda1043)

        val panda1044 = PetVideo()
        panda1044.type = VideoType.PANDA.ordinal
        panda1044.fileName = "panda_group_panda1044"
        panda1044.code = 2956
        panda1044.duration = 74
        panda1044.period = PeriodType.GROUP.ordinal
        panda1044.star = false
        panda1044.title = "【大熊猫】和花、艾玖、润玥三姐妹一起吃竹子"
        panda1044.releaseTime = 1648645340
        panda1044.originalUrl = "https://www.bilibili.com/video/BV1Fu411i7hJ"
        panda1044.tags = "大熊猫,萌宠,动物圈"
        panda1044.authorId = 327377672
        panda1044.cover =
            "https://i1.hdslb.com/bfs/archive/16c9bf8743451b15bafc7a4176e660dbc51a62be.jpg"
        list.add(panda1044)

        val panda1045 = PetVideo()
        panda1045.type = VideoType.PANDA.ordinal
        panda1045.fileName = "panda_group_panda1045"
        panda1045.code = 2957
        panda1045.duration = 178
        panda1045.period = PeriodType.GROUP.ordinal
        panda1045.star = false
        panda1045.title = "幼年园钓猫，小朋友：“快快快，保护好保护好~”【大熊猫和花、和叶、润玥】"
        panda1045.releaseTime = 1648715812
        panda1045.originalUrl = "https://www.bilibili.com/video/BV1SS4y1N7Bw"
        panda1045.tags = "大熊猫,萌宠,动物圈"
        panda1045.authorId = 514531996
        panda1045.cover =
            "https://i0.hdslb.com/bfs/archive/d00b8bc50ac79462053bb13fdbcf7b0c63337ec3.jpg"
        list.add(panda1045)

        val panda1046 = PetVideo()
        panda1046.type = VideoType.PANDA.ordinal
        panda1046.fileName = "panda_group_panda1046"
        panda1046.code = 2958
        panda1046.duration = 102
        panda1046.period = PeriodType.GROUP.ordinal
        panda1046.star = false
        panda1046.title = "大熊猫和花:我生胖气也是很凶的"
        panda1046.releaseTime = 1648633367
        panda1046.originalUrl = "https://www.bilibili.com/video/BV1ri4y1Q7TX"
        panda1046.tags = "大熊猫,萌宠,动物圈"
        panda1046.authorId = 384395600
        panda1046.cover =
            "https://i0.hdslb.com/bfs/archive/95076d949e39155307591f05b1874fc87bcd0c30.jpg"
        list.add(panda1046)

        val panda1047 = PetVideo()
        panda1047.type = VideoType.PANDA.ordinal
        panda1047.fileName = "panda_group_panda1047"
        panda1047.code = 2959
        panda1047.duration = 36
        panda1047.period = PeriodType.GROUP.ordinal
        panda1047.star = false
        panda1047.title = "大熊猫和花和叶-菜熊互rua"
        panda1047.releaseTime = 1648718352
        panda1047.originalUrl = "https://www.bilibili.com/video/BV1xS4y1m7XL"
        panda1047.tags = "大熊猫,萌宠,动物圈"
        panda1047.authorId = 1307515
        panda1047.cover =
            "https://i2.hdslb.com/bfs/archive/79f9936654a1c05511349af42e17eb29654a4d85.jpg"
        list.add(panda1047)

        val panda1048 = PetVideo()
        panda1048.type = VideoType.PANDA.ordinal
        panda1048.fileName = "panda_group_panda1048"
        panda1048.code = 2960
        panda1048.duration = 321
        panda1048.period = PeriodType.GROUP.ordinal
        panda1048.star = false
        panda1048.vertical = true
        panda1048.title = "熊猫也有外教？这位学生有点淘气"
        panda1048.releaseTime = 1648525582
        panda1048.originalUrl = "https://www.bilibili.com/video/BV1LY411J7zg"
        panda1048.tags = "大熊猫,萌宠,动物圈"
        panda1048.authorId = 1025949925
        panda1048.cover =
            "https://i2.hdslb.com/bfs/archive/2973da2514db4fef080a33e163d7b3671ba9fcd5.jpg"
        list.add(panda1048)

        val panda1049 = PetVideo()
        panda1049.type = VideoType.PANDA.ordinal
        panda1049.fileName = "panda_group_panda1049"
        panda1049.code = 2961
        panda1049.duration = 93
        panda1049.period = PeriodType.GROUP.ordinal
        panda1049.star = false
        panda1049.title = "萌宝萌玉两个逗比姐妹的雪天切磋，萌宝就是个谐星啊、谐星 【大熊猫萌宝】【大熊猫萌玉】20220318"
        panda1049.releaseTime = 1648088685
        panda1049.originalUrl = "https://www.bilibili.com/video/BV1SY4y1i771"
        panda1049.tags = "大熊猫,萌宠,动物圈"
        panda1049.authorId = 1233991446
        panda1049.cover =
            "https://i2.hdslb.com/bfs/archive/495e610a48dd69e3d719e95afc120949b7b5e97d.jpg"
        list.add(panda1049)

        val panda1050 = PetVideo()
        panda1050.type = VideoType.PANDA.ordinal
        panda1050.fileName = "panda_group_panda1050"
        panda1050.code = 2962
        panda1050.duration = 61
        panda1050.period = PeriodType.GROUP.ordinal
        panda1050.star = false
        panda1050.title = "绩笑成风成浪的吃笋时光【大熊猫绩笑成风成浪】"
        panda1050.releaseTime = 1647351425
        panda1050.originalUrl = "https://www.bilibili.com/video/BV1Pq4y1q7Pe"
        panda1050.tags = "大熊猫,萌宠,动物圈"
        panda1050.authorId = 270344612
        panda1050.cover =
            "https://i0.hdslb.com/bfs/archive/30bf5137d8c1d87e218cb6a964479b490672dbc9.jpg"
        list.add(panda1050)

        val panda1051 = PetVideo()
        panda1051.type = VideoType.PANDA.ordinal
        panda1051.fileName = "panda_group_panda1051"
        panda1051.code = 2963
        panda1051.duration = 60
        panda1051.period = PeriodType.GROUP.ordinal
        panda1051.star = false
        panda1051.title = "大熊猫奇一：我是可爱的吃笋主播奇兔兔。"
        panda1051.releaseTime = 1575180865
        panda1051.originalUrl = "https://www.bilibili.com/video/BV1TJ411z7Up"
        panda1051.tags = "大熊猫,萌宠,动物圈"
        panda1051.authorId = 278306866
        panda1051.cover =
            "https://i1.hdslb.com/bfs/archive/235d4baac1f548640a6e24ecb3807ffcfb2aff82.jpg"
        list.add(panda1051)

        val panda1052 = PetVideo()
        panda1052.type = VideoType.PANDA.ordinal
        panda1052.fileName = "panda_group_panda1052"
        panda1052.code = 2964
        panda1052.duration = 61
        panda1052.period = PeriodType.GROUP.ordinal
        panda1052.star = false
        panda1052.title = "大熊猫奇一，不开心，还有点委屈"
        panda1052.releaseTime = 1571098065
        panda1052.originalUrl = "https://www.bilibili.com/video/BV1LE411o7cA"
        panda1052.tags = "大熊猫,萌宠,动物圈"
        panda1052.authorId = 278306866
        panda1052.cover =
            "https://i0.hdslb.com/bfs/archive/11bdbcc2f0143893d9fd1fa067c52db5b1b467c5.jpg"
        list.add(panda1052)

        val panda1053 = PetVideo()
        panda1053.type = VideoType.PANDA.ordinal
        panda1053.fileName = "panda_group_panda1053"
        panda1053.code = 2965
        panda1053.duration = 125
        panda1053.period = PeriodType.GROUP.ordinal
        panda1053.star = false
        panda1053.title = "快来人呀！本和花摔倒了，和叶欺负熊啦！！【大熊猫和花 和叶】"
        panda1053.releaseTime = 1648633393
        panda1053.originalUrl = "https://www.bilibili.com/video/BV1cS4y1m7Ty"
        panda1053.tags = "大熊猫,萌宠,动物圈"
        panda1053.authorId = 16468440
        panda1053.cover =
            "https://i1.hdslb.com/bfs/archive/cc183d7463d35e9f0bb2a01eba69530990a4afe5.jpg"
        list.add(panda1053)

        val panda1054 = PetVideo()
        panda1054.type = VideoType.PANDA.ordinal
        panda1054.fileName = "panda_group_panda1054"
        panda1054.code = 2966
        panda1054.duration = 95
        panda1054.period = PeriodType.GROUP.ordinal
        panda1054.star = false
        panda1054.title = "【大熊猫和花&和叶】“走开，这是我的位置”"
        panda1054.releaseTime = 1648562218
        panda1054.originalUrl = "https://www.bilibili.com/video/BV1yq4y1Y75U"
        panda1054.tags = "大熊猫,萌宠,动物圈"
        panda1054.authorId = 34677299
        panda1054.cover =
            "https://i1.hdslb.com/bfs/archive/116ac18050ad3feeec493908fa2641696bb40556.jpg"
        list.add(panda1054)

        val panda1055 = PetVideo()
        panda1055.type = VideoType.PANDA.ordinal
        panda1055.fileName = "panda_group_panda1055"
        panda1055.code = 2967
        panda1055.duration = 80
        panda1055.period = PeriodType.GROUP.ordinal
        panda1055.star = false
        panda1055.title = "天气热了，熊皮大衣可以脱了！【大熊猫和叶】03.29"
        panda1055.releaseTime = 1648607395
        panda1055.originalUrl = "https://www.bilibili.com/video/BV1V5411S7nc"
        panda1055.tags = "大熊猫,萌宠,动物圈"
        panda1055.authorId = 16468440
        panda1055.cover =
            "https://i0.hdslb.com/bfs/archive/11b8741b7e9a8742bdae985b5d79ae5fd3bb047c.jpg"
        list.add(panda1055)

        val panda1056 = PetVideo()
        panda1056.type = VideoType.PANDA.ordinal
        panda1056.fileName = "panda_group_panda1056"
        panda1056.code = 2968
        panda1056.duration = 93
        panda1056.period = PeriodType.GROUP.ordinal
        panda1056.star = false
        panda1056.title = "【大熊猫润玥和花】长姐如母，照顾妹妹的任务就交给我啦"
        panda1056.releaseTime = 1647577287
        panda1056.originalUrl = "https://www.bilibili.com/video/BV1wL4y1M7Ac"
        panda1056.tags = "大熊猫,萌宠,动物圈"
        panda1056.authorId = 5125945
        panda1056.cover =
            "https://i1.hdslb.com/bfs/archive/989e3023244878136b0b068b56ae342ebbe0191c.jpg"
        list.add(panda1056)

        val panda1057 = PetVideo()
        panda1057.type = VideoType.PANDA.ordinal
        panda1057.fileName = "panda_group_panda1057"
        panda1057.code = 2969
        panda1057.duration = 241
        panda1057.period = PeriodType.GROUP.ordinal
        panda1057.star = false
        panda1057.title = "两个憨憨：和fafa、和瓜瓜沟里互rua。【大熊猫和花、和叶】"
        panda1057.releaseTime = 1648554389
        panda1057.originalUrl = "https://www.bilibili.com/video/BV1SL4y177ky"
        panda1057.tags = "大熊猫,萌宠,动物圈"
        panda1057.authorId = 514531996
        panda1057.cover =
            "https://i1.hdslb.com/bfs/archive/fb0e5e7634c7d19ff9394e4008970954e412ab16.jpg"
        list.add(panda1057)

        val panda1058 = PetVideo()
        panda1058.type = VideoType.PANDA.ordinal
        panda1058.fileName = "panda_group_panda1058"
        panda1058.code = 2970
        panda1058.duration = 85
        panda1058.period = PeriodType.GROUP.ordinal
        panda1058.star = false
        panda1058.title = "【大熊猫和花】迪迪疯狂输出挑衅值，和花在沟里气得直跺脚"
        panda1058.releaseTime = 1648474200
        panda1058.originalUrl = "https://www.bilibili.com/video/BV1A94y1f7Gi"
        panda1058.tags = "大熊猫,萌宠,动物圈"
        panda1058.authorId = 98871951
        panda1058.cover =
            "https://i2.hdslb.com/bfs/archive/4163c4c2bee391bcb02195c0f9c166b080ecc273.jpg"
        list.add(panda1058)

        val panda1059 = PetVideo()
        panda1059.type = VideoType.PANDA.ordinal
        panda1059.fileName = "panda_group_panda1059"
        panda1059.code = 2971
        panda1059.duration = 80
        panda1059.period = PeriodType.GROUP.ordinal
        panda1059.star = false
        panda1059.title = "【大熊猫和花】下班后偷偷捡笋皮的和花"
        panda1059.releaseTime = 1648472686
        panda1059.originalUrl = "https://www.bilibili.com/video/BV1t5411S7UT"
        panda1059.tags = "大熊猫,萌宠,动物圈"
        panda1059.authorId = 18329821
        panda1059.cover =
            "https://i1.hdslb.com/bfs/archive/2e830f5776028021c92e2a585ee1e57f3a72c4b0.jpg"
        list.add(panda1059)

        val panda1060 = PetVideo()
        panda1060.type = VideoType.PANDA.ordinal
        panda1060.fileName = "panda_group_panda1060"
        panda1060.code = 2972
        panda1060.duration = 63
        panda1060.period = PeriodType.GROUP.ordinal
        panda1060.star = false
        panda1060.title = "和花：没想到，我也能把爷爷追回去"
        panda1060.releaseTime = 1648471228
        panda1060.originalUrl = "https://www.bilibili.com/video/BV1dS4y127YK"
        panda1060.tags = "大熊猫,萌宠,动物圈"
        panda1060.authorId = 19715714
        panda1060.cover =
            "https://i2.hdslb.com/bfs/archive/bae04ed9237fafd83d16f4eb0b33539ca5927485.jpg"
        list.add(panda1060)

        val panda1061 = PetVideo()
        panda1061.type = VideoType.PANDA.ordinal
        panda1061.fileName = "panda_group_panda1061"
        panda1061.code = 2973
        panda1061.duration = 85
        panda1061.period = PeriodType.GROUP.ordinal
        panda1061.star = false
        panda1061.title = "早上慵懒的和花，是不是美爆了？【熊猫宝宝和花】"
        panda1061.releaseTime = 1647588012
        panda1061.originalUrl = "https://www.bilibili.com/video/BV1v34y1t77R"
        panda1061.tags = "大熊猫,萌宠,动物圈"
        panda1061.authorId = 2137796700
        panda1061.cover =
            "https://i1.hdslb.com/bfs/archive/09189551b2fded6eaa18888146864c477174f3fb.jpg"
        list.add(panda1061)

        val panda1062 = PetVideo()
        panda1062.type = VideoType.PANDA.ordinal
        panda1062.fileName = "panda_group_panda1062"
        panda1062.code = 2974
        panda1062.duration = 203
        panda1062.period = PeriodType.GROUP.ordinal
        panda1062.star = false
        panda1062.title = "【大熊猫和花】跟着爷爷跑，就会有果果吃哎"
        panda1062.releaseTime = 1648354902
        panda1062.originalUrl = "https://www.bilibili.com/video/BV1FR4y1F7rf"
        panda1062.tags = "大熊猫,萌宠,动物圈"
        panda1062.authorId = 34677299
        panda1062.cover =
            "https://i1.hdslb.com/bfs/archive/c0cc947b116911f738839f90c9856a84d675984f.jpg"
        list.add(panda1062)

        val panda1063 = PetVideo()
        panda1063.type = VideoType.PANDA.ordinal
        panda1063.fileName = "panda_group_panda1063"
        panda1063.code = 2975
        panda1063.duration = 129
        panda1063.period = PeriodType.GROUP.ordinal
        panda1063.star = false
        panda1063.title = "〖大熊猫和叶〗弟弟的性格真好啊 被二狗狗〖大熊猫润玥〗夺笋笋也不生气"
        panda1063.releaseTime = 1648311344
        panda1063.originalUrl = "https://www.bilibili.com/video/BV1ST4y1i7sE"
        panda1063.tags = "大熊猫,萌宠,动物圈"
        panda1063.authorId = 690050620
        panda1063.cover =
            "https://i0.hdslb.com/bfs/archive/94f8f145662b4a613d31ba5448171ae76931517c.jpg"
        list.add(panda1063)

        val panda1064 = PetVideo()
        panda1064.type = VideoType.PANDA.ordinal
        panda1064.fileName = "panda_group_panda1064"
        panda1064.code = 2976
        panda1064.duration = 141
        panda1064.period = PeriodType.GROUP.ordinal
        panda1064.star = false
        panda1064.title = "四喜丸子混战，开始rua作一团，后边庆庆rua喜喜，双双rua重重"
        panda1064.releaseTime = 1648264524
        panda1064.originalUrl = "https://www.bilibili.com/video/BV12L4y1j7SD"
        panda1064.tags = "大熊猫,萌宠,动物圈"
        panda1064.authorId = 66688464
        panda1064.cover =
            "https://i0.hdslb.com/bfs/archive/f22d23be638de134a99eb92756b092f90407d9ab.jpg"
        list.add(panda1064)

        val panda1065 = PetVideo()
        panda1065.type = VideoType.PANDA.ordinal
        panda1065.fileName = "panda_group_panda1065"
        panda1065.code = 2977
        panda1065.duration = 61
        panda1065.period = PeriodType.GROUP.ordinal
        panda1065.star = false
        panda1065.title = "和花：我来躺平了，任rua！"
        panda1065.releaseTime = 1648277297
        panda1065.originalUrl = "https://www.bilibili.com/video/BV1eF411W7kL"
        panda1065.tags = "大熊猫,萌宠,动物圈"
        panda1065.authorId = 19715714
        panda1065.cover =
            "https://i2.hdslb.com/bfs/archive/d49f020c9b81241d03eca90445f6db00be773e8b.jpg"
        list.add(panda1065)

        val panda1066 = PetVideo()
        panda1066.type = VideoType.PANDA.ordinal
        panda1066.fileName = "panda_group_panda1066"
        panda1066.code = 2978
        panda1066.duration = 120
        panda1066.period = PeriodType.GROUP.ordinal
        panda1066.star = false
        panda1066.title = "谭爷爷有意识的训练和花奔跑以增强四肢力量！（大熊猫和花和谭爷爷）"
        panda1066.releaseTime = 1648272969
        panda1066.originalUrl = "https://www.bilibili.com/video/BV1xF411W7SY"
        panda1066.tags = "大熊猫,萌宠,动物圈"
        panda1066.authorId = 2137796700
        panda1066.cover =
            "https://i2.hdslb.com/bfs/archive/8ac740f3d82f95e93ffc0dfbf7cd8da936aa7350.jpg"
        list.add(panda1066)

        val panda1067 = PetVideo()
        panda1067.type = VideoType.PANDA.ordinal
        panda1067.fileName = "panda_group_panda1067"
        panda1067.code = 2979
        panda1067.duration = 181
        panda1067.period = PeriodType.GROUP.ordinal
        panda1067.star = false
        panda1067.title = "和花:这是什么声音？是谭爷爷过来给窝好吃的咩？"
        panda1067.releaseTime = 1648280632
        panda1067.originalUrl = "https://www.bilibili.com/video/BV17F411W7Ay"
        panda1067.tags = "大熊猫,萌宠,动物圈"
        panda1067.authorId = 384395600
        panda1067.cover =
            "https://i2.hdslb.com/bfs/archive/1777065bde4f2275bdd9fe3edac36a9276c02c5a.jpg"
        list.add(panda1067)

        val panda1068 = PetVideo()
        panda1068.type = VideoType.PANDA.ordinal
        panda1068.fileName = "panda_group_panda1068"
        panda1068.code = 2980
        panda1068.duration = 68
        panda1068.period = PeriodType.GROUP.ordinal
        panda1068.star = false
        panda1068.title = "花姐脑门儿滚脏了，耳朵毛也炸了！收拾凑迪迪确实累熊！【大熊猫和花】"
        panda1068.releaseTime = 1648295286
        panda1068.originalUrl = "https://www.bilibili.com/video/BV1M34y147be"
        panda1068.tags = "大熊猫,萌宠,动物圈"
        panda1068.authorId = 16468440
        panda1068.cover =
            "https://i1.hdslb.com/bfs/archive/6eb941ffbb927cf432e876e57f9df563d93f4b05.jpg"
        list.add(panda1068)

        val panda1069 = PetVideo()
        panda1069.type = VideoType.PANDA.ordinal
        panda1069.fileName = "panda_group_panda1069"
        panda1069.code = 2981
        panda1069.duration = 138
        panda1069.period = PeriodType.GROUP.ordinal
        panda1069.star = false
        panda1069.title = "【大熊猫绩笑、成风、成浪】小猫带崽，贴贴窝最爱的小风风"
        panda1069.releaseTime = 1628493601
        panda1069.originalUrl = "https://www.bilibili.com/video/BV18v411K72L"
        panda1069.tags = "大熊猫,萌宠,动物圈"
        panda1069.authorId = 697876712
        panda1069.cover =
            "https://i1.hdslb.com/bfs/archive/061df448d0e3f1456c145ac2559976d5861731d4.jpg"
        list.add(panda1069)

        val panda1070 = PetVideo()
        panda1070.type = VideoType.PANDA.ordinal
        panda1070.fileName = "panda_group_panda1070"
        panda1070.code = 2982
        panda1070.duration = 41
        panda1070.period = PeriodType.GROUP.ordinal
        panda1070.star = false
        panda1070.title = "谭爷爷：和花，果赖！和花：我并不想果赖【大熊猫和花】"
        panda1070.releaseTime = 1646989999
        panda1070.originalUrl = "https://www.bilibili.com/video/BV1Fi4y1C7y4"
        panda1070.tags = "大熊猫,萌宠,动物圈"
        panda1070.authorId = 2062416280
        panda1070.cover =
            "https://i2.hdslb.com/bfs/archive/860c7e7887cd78dba8dec2637e90aedaca488960.jpg"
        list.add(panda1070)

        val panda1071 = PetVideo()
        panda1071.type = VideoType.PANDA.ordinal
        panda1071.fileName = "panda_group_panda1071"
        panda1071.code = 2983
        panda1071.duration = 55
        panda1071.period = PeriodType.GROUP.ordinal
        panda1071.star = false
        panda1071.title = "【大熊猫绩笑、成风、成浪】打妹大不同"
        panda1071.releaseTime = 1648192329
        panda1071.originalUrl = "https://www.bilibili.com/video/BV1SL4y1j7tZ"
        panda1071.tags = "大熊猫,萌宠,动物圈"
        panda1071.authorId = 697876712
        panda1071.cover =
            "https://i0.hdslb.com/bfs/archive/694370a0b3894784624a294ff810303bfad88f34.jpg"
        list.add(panda1071)

        val panda1072 = PetVideo()
        panda1072.type = VideoType.PANDA.ordinal
        panda1072.fileName = "panda_group_panda1072"
        panda1072.code = 2984
        panda1072.duration = 322
        panda1072.period = PeriodType.GROUP.ordinal
        panda1072.star = false
        panda1072.title = "【大熊猫和花】和花“行为训练”，大脑袋要被rua秃了吧"
        panda1072.releaseTime = 1648209922
        panda1072.originalUrl = "https://www.bilibili.com/video/BV1X94y1Z7U4"
        panda1072.tags = "大熊猫,萌宠,动物圈"
        panda1072.authorId = 34677299
        panda1072.cover =
            "https://i1.hdslb.com/bfs/archive/72c9b1146479c1792a19e79767d49d3e8218d6e1.jpg"
        list.add(panda1072)

        val panda1073 = PetVideo()
        panda1073.type = VideoType.PANDA.ordinal
        panda1073.fileName = "panda_group_panda1073"
        panda1073.code = 2985
        panda1073.duration = 47
        panda1073.period = PeriodType.GROUP.ordinal
        panda1073.star = false
        panda1073.vertical = true
        panda1073.title = "【大熊猫和花】挖煤后的和花被嫌弃了！"
        panda1073.releaseTime = 1647006726
        panda1073.originalUrl = "https://www.bilibili.com/video/BV16S4y1S73B"
        panda1073.tags = "大熊猫,萌宠,动物圈"
        panda1073.authorId = 2041280462
        panda1073.cover =
            "https://i0.hdslb.com/bfs/archive/ab1495f639983bf88a347cf65ea6a9dc8d63efff.jpg"
        list.add(panda1073)

        val panda1074 = PetVideo()
        panda1074.type = VideoType.PANDA.ordinal
        panda1074.fileName = "panda_group_panda1074"
        panda1074.code = 2986
        panda1074.duration = 260
        panda1074.period = PeriodType.GROUP.ordinal
        panda1074.star = false
        panda1074.title = "3.22钓猫，能听到“菜花叶”的嗯嗯嗯，和叶出息了，从二狗嘴里抢苹果【大熊猫和花、和叶、润玥】"
        panda1074.releaseTime = 1648210200
        panda1074.originalUrl = "https://www.bilibili.com/video/BV13F411W7Mg"
        panda1074.tags = "大熊猫,萌宠,动物圈"
        panda1074.authorId = 230382720
        panda1074.cover =
            "https://i2.hdslb.com/bfs/archive/408ba17716dc6dffe41feba3c39ba2e899292138.jpg"
        list.add(panda1074)

        val panda1075 = PetVideo()
        panda1075.type = VideoType.PANDA.ordinal
        panda1075.fileName = "panda_group_panda1075"
        panda1075.code = 2987
        panda1075.duration = 54
        panda1075.period = PeriodType.GROUP.ordinal
        panda1075.star = false
        panda1075.vertical = true
        panda1075.title = "太阳三巨头怎么认？看完你学费了吗？"
        panda1075.releaseTime = 1648180196
        panda1075.originalUrl = "https://www.bilibili.com/video/BV1H3411p7tF"
        panda1075.tags = "大熊猫,萌宠,动物圈"
        panda1075.authorId = 1025949925
        panda1075.cover =
            "https://i0.hdslb.com/bfs/archive/c2d19e123a727480365f02087f2df9cc5b6e2397.jpg"
        list.add(panda1075)

        val panda1076 = PetVideo()
        panda1076.type = VideoType.PANDA.ordinal
        panda1076.fileName = "panda_group_panda1076"
        panda1076.code = 2988
        panda1076.duration = 82
        panda1076.period = PeriodType.GROUP.ordinal
        panda1076.star = false
        panda1076.title = "是谁赋予了一条鼻涕灵魂？是春风，是和花。【大熊猫和花】"
        panda1076.releaseTime = 1647952214
        panda1076.originalUrl = "https://www.bilibili.com/video/BV13P4y1T7XD"
        panda1076.tags = "大熊猫,萌宠,动物圈"
        panda1076.authorId = 514531996
        panda1076.cover =
            "https://i0.hdslb.com/bfs/archive/033f14079600884683baf8114a84e05e97da8fbc.jpg"
        list.add(panda1076)

        val panda1077 = PetVideo()
        panda1077.type = VideoType.PANDA.ordinal
        panda1077.fileName = "panda_group_panda1077"
        panda1077.code = 2989
        panda1077.duration = 295
        panda1077.period = PeriodType.GROUP.ordinal
        panda1077.star = false
        panda1077.title = "饲养员谭爷爷视角看和花第一次钓猫，爷爷宠溺的把苹果直接放在和花嘴里。"
        panda1077.releaseTime = 1648175227
        panda1077.originalUrl = "https://www.bilibili.com/video/BV1k3411p7nc"
        panda1077.tags = "大熊猫,萌宠,动物圈"
        panda1077.authorId = 384395600
        panda1077.cover =
            "https://i0.hdslb.com/bfs/archive/c810898b58cfd250d02e0cc9392305fc7fdb3d7a.jpg"
        list.add(panda1077)

        val panda1078 = PetVideo()
        panda1078.type = VideoType.PANDA.ordinal
        panda1078.fileName = "panda_group_panda1078"
        panda1078.code = 2990
        panda1078.duration = 50
        panda1078.period = PeriodType.GROUP.ordinal
        panda1078.star = false
        panda1078.title = "大熊猫和花和叶-排排坐，抢果果"
        panda1078.releaseTime = 1648126231
        panda1078.originalUrl = "https://www.bilibili.com/video/BV1EL4y177vs"
        panda1078.tags = "大熊猫,萌宠,动物圈"
        panda1078.authorId = 1307515
        panda1078.cover =
            "https://i2.hdslb.com/bfs/archive/5ccda1b838ebcaac8fbe31bb3a790e23ed0e7d1f.jpg"
        list.add(panda1078)

        val panda1079 = PetVideo()
        panda1079.type = VideoType.PANDA.ordinal
        panda1079.fileName = "panda_group_panda1079"
        panda1079.code = 2991
        panda1079.duration = 49
        panda1079.period = PeriodType.GROUP.ordinal
        panda1079.star = false
        panda1079.title = "【大熊猫和花】高清大脸花，屏幕都快装不下了"
        panda1079.releaseTime = 1648128600
        panda1079.originalUrl = "https://www.bilibili.com/video/BV1Lq4y1v7bv"
        panda1079.tags = "大熊猫,萌宠,动物圈"
        panda1079.authorId = 98871951
        panda1079.cover =
            "https://i2.hdslb.com/bfs/archive/a375be9893a48dc1314ddbdac3ebd833c310df6b.jpg"
        list.add(panda1079)

        val panda1080 = PetVideo()
        panda1080.type = VideoType.PANDA.ordinal
        panda1080.fileName = "panda_group_panda1080"
        panda1080.code = 2992
        panda1080.duration = 366
        panda1080.period = PeriodType.GROUP.ordinal
        panda1080.star = false
        panda1080.title = "四嘟首次聚在一起钓猫，看得出来每只熊猫都长的不一样吧3.23【大熊猫和花、和叶、艾玖、润玥】"
        panda1080.releaseTime = 1648041348
        panda1080.originalUrl = "https://www.bilibili.com/video/BV1PY4y1q78V"
        panda1080.tags = "大熊猫,萌宠,动物圈"
        panda1080.authorId = 230382720
        panda1080.cover =
            "https://i2.hdslb.com/bfs/archive/d3959a671b44ac7be80152e8247f3ba2f8d3278d.jpg"
        list.add(panda1080)

        val panda1081 = PetVideo()
        panda1081.type = VideoType.PANDA.ordinal
        panda1081.fileName = "panda_group_panda1081"
        panda1081.code = 2993
        panda1081.duration = 92
        panda1081.period = PeriodType.GROUP.ordinal
        panda1081.star = false
        panda1081.title = "别争了，你们都是水沟公主好不好?3.22【大熊猫和花.润玥】"
        panda1081.releaseTime = 1647948319
        panda1081.originalUrl = "https://www.bilibili.com/video/BV1Qb4y1p78r"
        panda1081.tags = "大熊猫,萌宠,动物圈"
        panda1081.authorId = 16468440
        panda1081.cover =
            "https://i1.hdslb.com/bfs/archive/10fc1597eb030e241ce343b2bc2056b2144cd36d.jpg"
        list.add(panda1081)

        val panda1082 = PetVideo()
        panda1082.type = VideoType.PANDA.ordinal
        panda1082.fileName = "panda_group_panda1082"
        panda1082.code = 2994
        panda1082.duration = 67
        panda1082.period = PeriodType.GROUP.ordinal
        panda1082.star = false
        panda1082.title = "【大熊猫和花】看到二狗和叶过来，赶紧转过身躲起来吃，谁也别想抢我的"
        panda1082.releaseTime = 1647958290
        panda1082.originalUrl = "https://www.bilibili.com/video/BV19R4y1F7D6"
        panda1082.tags = "大熊猫,萌宠,动物圈"
        panda1082.authorId = 34677299
        panda1082.cover =
            "https://i2.hdslb.com/bfs/archive/b0fcf658fb2cc2ce9bf2f305697e102b12ed7814.jpg"
        list.add(panda1082)

        val panda1083 = PetVideo()
        panda1083.type = VideoType.PANDA.ordinal
        panda1083.fileName = "panda_group_panda1083"
        panda1083.code = 2995
        panda1083.duration = 253
        panda1083.period = PeriodType.GROUP.ordinal
        panda1083.star = false
        panda1083.title = "爷爷最后钓艾玖，和花循着声音走过来又得了块苹果3.22【大熊猫和花&艾玖】"
        panda1083.releaseTime = 1648006155
        panda1083.originalUrl = "https://www.bilibili.com/video/BV1Yi4y1k7Xf"
        panda1083.tags = "大熊猫,萌宠,动物圈"
        panda1083.authorId = 230382720
        panda1083.cover =
            "https://i0.hdslb.com/bfs/archive/392eed87579a416d5be974e355986512eda77b0d.jpg"
        list.add(panda1083)

        val panda1084 = PetVideo()
        panda1084.type = VideoType.PANDA.ordinal
        panda1084.fileName = "panda_group_panda1084"
        panda1084.code = 2996
        panda1084.duration = 55
        panda1084.period = PeriodType.GROUP.ordinal
        panda1084.star = false
        panda1084.title = "【和花和叶】暖心弟弟知道疼姐姐了"
        panda1084.releaseTime = 1647957664
        panda1084.originalUrl = "https://www.bilibili.com/video/BV1Aq4y1v7rk"
        panda1084.tags = "大熊猫,萌宠,动物圈"
        panda1084.authorId = 385353133
        panda1084.cover =
            "https://i0.hdslb.com/bfs/archive/135a392cd7bf19243edb377cf292121ca2bd95dd.jpg"
        list.add(panda1084)

        val panda1085 = PetVideo()
        panda1085.type = VideoType.PANDA.ordinal
        panda1085.fileName = "panda_group_panda1085"
        panda1085.code = 2997
        panda1085.duration = 120
        panda1085.period = PeriodType.GROUP.ordinal
        panda1085.star = false
        panda1085.title = "【大熊猫和花】和花钓猫~~最终还是逃不掉被抢的命运"
        panda1085.releaseTime = 1647921610
        panda1085.originalUrl = "https://www.bilibili.com/video/BV1D34y1t73z"
        panda1085.tags = "大熊猫,萌宠,动物圈"
        panda1085.authorId = 98871951
        panda1085.cover =
            "https://i0.hdslb.com/bfs/archive/db31fb7c7a6a6a47f3bc39619b006450e3443aa4.jpg"
        list.add(panda1085)

        val panda1086 = PetVideo()
        panda1086.type = VideoType.PANDA.ordinal
        panda1086.fileName = "panda_group_panda1086"
        panda1086.code = 2998
        panda1086.duration = 430
        panda1086.period = PeriodType.GROUP.ordinal
        panda1086.star = false
        panda1086.title = "“菜花叶”的首次钓猫，全程都有看点3.21【大熊猫和花、菜菜、和叶】"
        panda1086.releaseTime = 1647877770
        panda1086.originalUrl = "https://www.bilibili.com/video/BV18L411w7Yb"
        panda1086.tags = "大熊猫,萌宠,动物圈"
        panda1086.authorId = 230382720
        panda1086.cover =
            "https://i0.hdslb.com/bfs/archive/92ebf6d62d257e23afaa3ee1d17df564bafb538d.jpg"
        list.add(panda1086)

        val panda1087 = PetVideo()
        panda1087.type = VideoType.PANDA.ordinal
        panda1087.fileName = "panda_group_panda1087"
        panda1087.code = 2999
        panda1087.duration = 245
        panda1087.period = PeriodType.GROUP.ordinal
        panda1087.star = false
        panda1087.title = "【大熊猫】幼年一班小朋友们，开始熊生第一次钓猫了！"
        panda1087.releaseTime = 1647863285
        panda1087.originalUrl = "https://www.bilibili.com/video/BV1LS4y1U7He"
        panda1087.tags = "大熊猫,萌宠,动物圈"
        panda1087.authorId = 34677299
        panda1087.cover =
            "https://i1.hdslb.com/bfs/archive/3bf86499a7555c00db64d2f6e97905e3c3774333.jpg"
        list.add(panda1087)

        val panda1088 = PetVideo()
        panda1088.type = VideoType.PANDA.ordinal
        panda1088.fileName = "panda_group_panda1088"
        panda1088.code = 3000
        panda1088.duration = 187
        panda1088.period = PeriodType.GROUP.ordinal
        panda1088.star = false
        panda1088.title = "【大熊猫和花】花宝熊生第一次钓猫，和花对钓猫有不同的理解"
        panda1088.releaseTime = 1647859415
        panda1088.originalUrl = "https://www.bilibili.com/video/BV17S4y1g78g"
        panda1088.tags = "大熊猫,萌宠,动物圈"
        panda1088.authorId = 98871951
        panda1088.cover =
            "https://i2.hdslb.com/bfs/archive/3a5a6bb8214485f87ea573ef59296c7d10d33324.jpg"
        list.add(panda1088)

        val panda1089 = PetVideo()
        panda1089.type = VideoType.PANDA.ordinal
        panda1089.fileName = "panda_group_panda1089"
        panda1089.code = 3001
        panda1089.duration = 99
        panda1089.period = PeriodType.GROUP.ordinal
        panda1089.star = false
        panda1089.title = "奶爸就是熊孩子们的丰荣【熊猫宝宝福多多，雅颂】"
        panda1089.releaseTime = 1647753087
        panda1089.originalUrl = "https://www.bilibili.com/video/BV1WR4y1c7NS"
        panda1089.tags = "大熊猫,萌宠,动物圈"
        panda1089.authorId = 2137796700
        panda1089.cover =
            "https://i2.hdslb.com/bfs/archive/8e3a1019821957f3fb70bcd154172a87f6f4d618.jpg"
        list.add(panda1089)

        val panda1090 = PetVideo()
        panda1090.type = VideoType.PANDA.ordinal
        panda1090.fileName = "panda_group_panda1090"
        panda1090.code = 3002
        panda1090.duration = 92
        panda1090.period = PeriodType.GROUP.ordinal
        panda1090.star = false
        panda1090.title = "超级车轮滚滚“大熊猫包包”"
        panda1090.releaseTime = 1647594311
        panda1090.originalUrl = "https://www.bilibili.com/video/BV1Kb4y1p7pi"
        panda1090.tags = "大熊猫,萌宠,动物圈"
        panda1090.authorId = 21330840
        panda1090.cover =
            "https://i0.hdslb.com/bfs/archive/4bb47110eb28f0ba284ab01bcb7267f2cec8a1b4.jpg"
        list.add(panda1090)

        val panda1091 = PetVideo()
        panda1091.type = VideoType.PANDA.ordinal
        panda1091.fileName = "panda_group_panda1091"
        panda1091.code = 3003
        panda1091.duration = 69
        panda1091.period = PeriodType.GROUP.ordinal
        panda1091.star = false
        panda1091.title = "fa总不给正脸，卑微的熊仔队视角。(从幼年二班拍过去的。。)  【大熊猫和花、润玥】"
        panda1091.releaseTime = 1647778811
        panda1091.originalUrl = "https://www.bilibili.com/video/BV1Pq4y1v7jt"
        panda1091.tags = "大熊猫,萌宠,动物圈"
        panda1091.authorId = 514531996
        panda1091.cover =
            "https://i1.hdslb.com/bfs/archive/9726a2949be103ae19ec591557f0a7384640d2af.jpg"
        list.add(panda1091)

        val panda1092 = PetVideo()
        panda1092.type = VideoType.PANDA.ordinal
        panda1092.fileName = "panda_group_panda1092"
        panda1092.code = 3004
        panda1092.duration = 91
        panda1092.period = PeriodType.GROUP.ordinal
        panda1092.star = false
        panda1092.title = "好姐妹就要挤在一起吃"
        panda1092.releaseTime = 1647595128
        panda1092.originalUrl = "https://www.bilibili.com/video/BV1qS4y1u7Ex"
        panda1092.tags = "大熊猫,萌宠,动物圈"
        panda1092.authorId = 273253041
        panda1092.cover =
            "https://i2.hdslb.com/bfs/archive/31928bcb8edc74a4b13237f2254e9a1ea082da51.jpg"
        list.add(panda1092)

        val panda1093 = PetVideo()
        panda1093.type = VideoType.PANDA.ordinal
        panda1093.fileName = "panda_group_panda1093"
        panda1093.code = 3005
        panda1093.duration = 80
        panda1093.period = PeriodType.GROUP.ordinal
        panda1093.star = false
        panda1093.title = "金双金喜&重阳茱萸 吊床争夺战"
        panda1093.releaseTime = 1647745215
        panda1093.originalUrl = "https://www.bilibili.com/video/BV1hY411n7Wq"
        panda1093.tags = "大熊猫,萌宠,动物圈"
        panda1093.authorId = 19715714
        panda1093.cover =
            "https://i1.hdslb.com/bfs/archive/41308fea098e1cda974aa05ec34a1d98acb8f900.jpg"
        list.add(panda1093)

        val panda1094 = PetVideo()
        panda1094.type = VideoType.PANDA.ordinal
        panda1094.fileName = "panda_group_panda1094"
        panda1094.code = 3006
        panda1094.duration = 33
        panda1094.period = PeriodType.GROUP.ordinal
        panda1094.star = false
        panda1094.title = "大熊猫和花和叶-臭弟弟，打包就打包怎么还要踩熊的！"
        panda1094.releaseTime = 1647767927
        panda1094.originalUrl = "https://www.bilibili.com/video/BV1GS4y1g7vR"
        panda1094.tags = "大熊猫,萌宠,动物圈"
        panda1094.authorId = 1307515
        panda1094.cover =
            "https://i2.hdslb.com/bfs/archive/d94aa83fc60c8433012109ddb904c98d0d2d94e4.jpg"
        list.add(panda1094)

        val panda1095 = PetVideo()
        panda1095.type = VideoType.PANDA.ordinal
        panda1095.fileName = "panda_group_panda1095"
        panda1095.code = 3007
        panda1095.duration = 67
        panda1095.period = PeriodType.GROUP.ordinal
        panda1095.star = false
        panda1095.title = "【大熊猫和花，和叶】和花夺笋，稳准，快！"
        panda1095.releaseTime = 1647675729
        panda1095.originalUrl = "https://www.bilibili.com/video/BV1BL411w79m"
        panda1095.tags = "大熊猫,萌宠,动物圈"
        panda1095.authorId = 2137796700
        panda1095.cover =
            "https://i0.hdslb.com/bfs/archive/c84543ec8d0d1d9e3af911b203dfc2a48f53bd9c.jpg"
        list.add(panda1095)

        val panda1096 = PetVideo()
        panda1096.type = VideoType.PANDA.ordinal
        panda1096.fileName = "panda_group_panda1096"
        panda1096.code = 3008
        panda1096.duration = 208
        panda1096.period = PeriodType.GROUP.ordinal
        panda1096.star = false
        panda1096.title = "3.14谭爷爷一阵魔性的“果赖果赖果赖”，四嘟嘟冲上前台扭作一团，滚进沟里！【大熊猫和花&和叶&润玥&艾玖】"
        panda1096.releaseTime = 1647260643
        panda1096.originalUrl = "https://www.bilibili.com/video/BV1bi4y1r76k"
        panda1096.tags = "大熊猫,萌宠,动物圈"
        panda1096.authorId = 16468440
        panda1096.cover =
            "https://i0.hdslb.com/bfs/archive/109a906723eaecf5d09838b5d2c793a9ed210c61.jpg"
        list.add(panda1096)

        val panda1097 = PetVideo()
        panda1097.type = VideoType.PANDA.ordinal
        panda1097.fileName = "panda_group_panda1097"
        panda1097.code = 3009
        panda1097.duration = 50
        panda1097.period = PeriodType.GROUP.ordinal
        panda1097.star = false
        panda1097.title = "她来了，她来了，她迈着优雅的步伐走来了"
        panda1097.releaseTime = 1647570607
        panda1097.originalUrl = "https://www.bilibili.com/video/BV1Zi4y1C771"
        panda1097.tags = "大熊猫,萌宠,动物圈"
        panda1097.authorId = 384395600
        panda1097.cover =
            "https://i2.hdslb.com/bfs/archive/333bb7bf0c1b81c913e505808ea2398142e841c1.jpg"
        list.add(panda1097)

        val panda1098 = PetVideo()
        panda1098.type = VideoType.PANDA.ordinal
        panda1098.fileName = "panda_group_panda1098"
        panda1098.code = 3010
        panda1098.duration = 56
        panda1098.period = PeriodType.GROUP.ordinal
        panda1098.star = false
        panda1098.title = "一定要看到最后！【大熊猫福多多雅颂】"
        panda1098.releaseTime = 1647528605
        panda1098.originalUrl = "https://www.bilibili.com/video/BV1zL4y1T7dX"
        panda1098.tags = "大熊猫,萌宠,动物圈"
        panda1098.authorId = 2137796700
        panda1098.cover =
            "https://i2.hdslb.com/bfs/archive/695de1c28ba85136529d678a1db443ff11128323.jpg"
        list.add(panda1098)

        val panda1099 = PetVideo()
        panda1099.type = VideoType.PANDA.ordinal
        panda1099.fileName = "panda_group_panda1099"
        panda1099.code = 3011
        panda1099.duration = 146
        panda1099.period = PeriodType.GROUP.ordinal
        panda1099.star = false
        panda1099.title = "香果：跟三个哥哥同班 没点真本事可不行（大熊猫热干面 春生 香果）"
        panda1099.releaseTime = 1647572239
        panda1099.originalUrl = "https://www.bilibili.com/video/BV1V3411s764"
        panda1099.tags = "大熊猫,萌宠,动物圈"
        panda1099.authorId = 442701460
        panda1099.cover =
            "https://i1.hdslb.com/bfs/archive/7208161a650eb15bd962e1d7b8f521b971365f4d.jpg"
        list.add(panda1099)

        val panda1100 = PetVideo()
        panda1100.type = VideoType.PANDA.ordinal
        panda1100.fileName = "panda_group_panda1100"
        panda1100.code = 3012
        panda1100.duration = 73
        panda1100.period = PeriodType.GROUP.ordinal
        panda1100.star = true
        panda1100.title = "和花：抱住我的小水池"
        panda1100.releaseTime = 1647586327
        panda1100.originalUrl = "https://www.bilibili.com/video/BV1p34y1t7iC"
        panda1100.tags = "大熊猫,萌宠,动物圈"
        panda1100.authorId = 19715714
        panda1100.cover =
            "https://i0.hdslb.com/bfs/archive/eb324b83102cbf2f96c4e665e9c7378098becd8a.jpg"
        list.add(panda1100)

        val panda1101 = PetVideo()
        panda1101.type = VideoType.PANDA.ordinal
        panda1101.fileName = "panda_group_panda1101"
        panda1101.code = 3013
        panda1101.duration = 252
        panda1101.period = PeriodType.GROUP.ordinal
        panda1101.star = false
        panda1101.title = "第三个月的见异思迁下集——互爆黑料～亲妈版的笑风浪拔牙歌（结尾有彩蛋哟）【大熊猫绩笑】【大熊猫成风】【大熊猫成浪】"
        panda1101.releaseTime = 1627787426
        panda1101.originalUrl = "https://www.bilibili.com/video/BV1W3411r7Fq"
        panda1101.tags = "大熊猫,萌宠,动物圈"
        panda1101.authorId = 270344612
        panda1101.cover =
            "https://i1.hdslb.com/bfs/archive/9bd7ce841563e948be1d0079b62588feb9613f67.jpg"
        list.add(panda1101)

        val panda1102 = PetVideo()
        panda1102.type = VideoType.PANDA.ordinal
        panda1102.fileName = "panda_group_panda1102"
        panda1102.code = 3014
        panda1102.duration = 59
        panda1102.period = PeriodType.GROUP.ordinal
        panda1102.star = false
        panda1102.title = "【大熊猫绩笑、成风】轰轰娇羞小粉红和笑笑绩大爷（特别感谢瑞娜E亲妈的现场报导）"
        panda1102.releaseTime = 1612688362
        panda1102.originalUrl = "https://www.bilibili.com/video/BV1p541177UT"
        panda1102.tags = "大熊猫,萌宠,动物圈"
        panda1102.authorId = 697876712
        panda1102.cover =
            "https://i2.hdslb.com/bfs/archive/7d883a0ed81ec379a4e8fe2f76706bb02fe5e8e6.jpg"
        list.add(panda1102)

        val panda1103 = PetVideo()
        panda1103.type = VideoType.PANDA.ordinal
        panda1103.fileName = "panda_group_panda1103"
        panda1103.code = 3015
        panda1103.duration = 192
        panda1103.period = PeriodType.GROUP.ordinal
        panda1103.star = false
        panda1103.vertical = true
        panda1103.title = "今天5只大熊猫过生日，绩笑营业值满满，和花开心到翻滚"
        panda1103.releaseTime = 1622900330
        panda1103.originalUrl = "https://www.bilibili.com/video/BV1fq4y1j7Yc"
        panda1103.tags = "大熊猫,萌宠,动物圈"
        panda1103.authorId = 1025949925
        panda1103.cover =
            "https://i2.hdslb.com/bfs/archive/08546716866e8578b2199335f57eef20bf3d65c8.jpg"
        list.add(panda1103)

        val panda1104 = PetVideo()
        panda1104.type = VideoType.PANDA.ordinal
        panda1104.fileName = "panda_group_panda1104"
        panda1104.code = 3016
        panda1104.duration = 34
        panda1104.period = PeriodType.GROUP.ordinal
        panda1104.star = true
        panda1104.title = "大熊猫和花-养成良好用餐习惯，饭后清理小桌板"
        panda1104.releaseTime = 1647508684
        panda1104.originalUrl = "https://www.bilibili.com/video/BV153411s7kf"
        panda1104.tags = "大熊猫,萌宠,动物圈"
        panda1104.authorId = 1307515
        panda1104.cover =
            "https://i2.hdslb.com/bfs/archive/d941755c840a04899c830b578af1dc5890906e69.png"
        list.add(panda1104)

        val panda1105 = PetVideo()
        panda1105.type = VideoType.PANDA.ordinal
        panda1105.fileName = "panda_group_panda1105"
        panda1105.code = 3017
        panda1105.duration = 443
        panda1105.period = PeriodType.GROUP.ordinal
        panda1105.star = false
        panda1105.title = "【大熊猫和花 和叶】我们是最甜的和花叶叶哦！"
        panda1105.releaseTime = 1645597263
        panda1105.originalUrl = "https://www.bilibili.com/video/BV1c3411j7G5"
        panda1105.tags = "大熊猫,萌宠,动物圈"
        panda1105.authorId = 7782934
        panda1105.cover =
            "https://i2.hdslb.com/bfs/archive/ad7a62f58eabc33b0201630a8a29657b400c8b7c.jpg"
        list.add(panda1105)

        val panda1106 = PetVideo()
        panda1106.type = VideoType.PANDA.ordinal
        panda1106.fileName = "panda_group_panda1106"
        panda1106.code = 3018
        panda1106.duration = 81
        panda1106.period = PeriodType.GROUP.ordinal
        panda1106.star = true
        panda1106.title = "【大熊猫艾玖&和花】其实和花也抢了艾玖的半根笋，但……就是玩"
        panda1106.releaseTime = 1647431400
        panda1106.originalUrl = "https://www.bilibili.com/video/BV1jP4y1u7Yy"
        panda1106.tags = "大熊猫,萌宠,动物圈"
        panda1106.authorId = 34677299
        panda1106.cover =
            "https://i0.hdslb.com/bfs/archive/d3a8cb61d9ec5723277f93ffae67cf1139c4c210.jpg"
        list.add(panda1106)

        val panda1107 = PetVideo()
        panda1107.type = VideoType.PANDA.ordinal
        panda1107.fileName = "panda_group_panda1107"
        panda1107.code = 3019
        panda1107.duration = 92
        panda1107.period = PeriodType.GROUP.ordinal
        panda1107.star = false
        panda1107.title = "【大熊猫】笋季到了，小朋友们开始吃笋笋啦"
        panda1107.releaseTime = 1647402134
        panda1107.originalUrl = "https://www.bilibili.com/video/BV1434y1t7DW"
        panda1107.tags = "大熊猫,萌宠,动物圈"
        panda1107.authorId = 34677299
        panda1107.cover =
            "https://i2.hdslb.com/bfs/archive/c636b5878e94edcd2b3ff3e9fe87b26fbffea63f.jpg"
        list.add(panda1107)

        val panda1108 = PetVideo()
        panda1108.type = VideoType.PANDA.ordinal
        panda1108.fileName = "panda_group_panda1108"
        panda1108.code = 3020
        panda1108.duration = 221
        panda1108.period = PeriodType.GROUP.ordinal
        panda1108.star = false
        panda1108.title = "20161123下午茶时间的挖煤三宝  奥莉奥破的竹几最好吃"
        panda1108.releaseTime = 1508888582
        panda1108.originalUrl = "https://www.bilibili.com/video/BV1Jx411u7Re"
        panda1108.tags = "大熊猫,萌宠,动物圈"
        panda1108.authorId = 26397817
        panda1108.cover =
            "https://i1.hdslb.com/bfs/archive/b357574b8a4a78debeabcb4f4e9f61e4c64d53d8.jpg"
        list.add(panda1108)

        val panda1109 = PetVideo()
        panda1109.type = VideoType.PANDA.ordinal
        panda1109.fileName = "panda_group_panda1109"
        panda1109.code = 3021
        panda1109.duration = 254
        panda1109.period = PeriodType.GROUP.ordinal
        panda1109.star = false
        panda1109.title = "20161122熊猫谷 奥莉奥淼淼园润吃窝头"
        panda1109.releaseTime = 1508802184
        panda1109.originalUrl = "https://www.bilibili.com/video/BV1Vx411u78H"
        panda1109.tags = "大熊猫,萌宠,动物圈"
        panda1109.authorId = 26397817
        panda1109.cover =
            "https://i0.hdslb.com/bfs/archive/7c0349e93d59f51aa30af2950629f192ac9c4ea8.jpg"
        list.add(panda1109)

        val panda1110 = PetVideo()
        panda1110.type = VideoType.PANDA.ordinal
        panda1110.fileName = "panda_group_panda1110"
        panda1110.code = 3022
        panda1110.duration = 161
        panda1110.period = PeriodType.GROUP.ordinal
        panda1110.star = false
        panda1110.title = "【大熊猫润玥&和花】这朵“霸王花”，二狗是真的宠她叭，这样都不生气"
        panda1110.releaseTime = 1647314739
        panda1110.originalUrl = "https://www.bilibili.com/video/BV1ZF411s7FW"
        panda1110.tags = "大熊猫,萌宠,动物圈"
        panda1110.authorId = 34677299
        panda1110.cover =
            "https://i0.hdslb.com/bfs/archive/4f5997ec4ba0c6f4120cfe73de289acb5cc02c7f.jpg"
        list.add(panda1110)

        val panda1111 = PetVideo()
        panda1111.type = VideoType.PANDA.ordinal
        panda1111.fileName = "panda_group_panda1111"
        panda1111.code = 3760
        panda1111.duration = 116
        panda1111.period = PeriodType.GROUP.ordinal
        panda1111.star = true
        panda1111.vertical = false
        panda1111.title = "富贵小少爷和叶也炫了很久的竹叶，花姐表示很欣慰"
        panda1111.releaseTime = 1666663836
        panda1111.originalUrl = "https://www.bilibili.com/video/BV1ke4y177C6"
        panda1111.tags = "大熊猫,萌宠,动物圈"
        panda1111.authorId = 484440897
        panda1111.cover =
            "https://i0.hdslb.com/bfs/archive/12ae5f8dc9dff6164ff1dfc7c3624f9c45bfb549.jpg"
        list.add(panda1111)

        val panda1112 = PetVideo()
        panda1112.type = VideoType.PANDA.ordinal
        panda1112.fileName = "panda_group_panda1112"
        panda1112.code = 3761
        panda1112.duration = 84
        panda1112.period = PeriodType.GROUP.ordinal
        panda1112.star = true
        panda1112.vertical = false
        panda1112.title = "和花吃窝窝头也太可爱了吧，一边吃还要一边抽空看镜头😍像水獭？🐹？豚鼠？不，她就是最独一无二的和花呀！❤️"
        panda1112.releaseTime = 1666585080
        panda1112.originalUrl = "https://www.bilibili.com/video/BV1Ut4y1u7yd"
        panda1112.tags = "大熊猫,萌宠,动物圈"
        panda1112.authorId = 16468440
        panda1112.cover =
            "https://i1.hdslb.com/bfs/archive/c69f24581f9f10e664ae3a93ab6b1acdb3aac639.jpg"
        list.add(panda1112)

        val panda1113 = PetVideo()
        panda1113.type = VideoType.PANDA.ordinal
        panda1113.fileName = "panda_group_panda1113"
        panda1113.code = 3762
        panda1113.duration = 131
        panda1113.period = PeriodType.GROUP.ordinal
        panda1113.star = true
        panda1113.vertical = false
        panda1113.title = "花叶互相陪伴，和花你的蓬蓬裙都掀起来啦，叶子日常驯服舌头，好有爱"
        panda1113.releaseTime = 1666587600
        panda1113.originalUrl = "https://www.bilibili.com/video/BV1je411G7N3"
        panda1113.tags = "大熊猫,萌宠,动物圈"
        panda1113.authorId = 484440897
        panda1113.cover =
            "https://i2.hdslb.com/bfs/archive/c0641d0dfae203f13b45cadfb0a8fbb8c9df82eb.jpg"
        list.add(panda1113)

        val panda1114 = PetVideo()
        panda1114.type = VideoType.PANDA.ordinal
        panda1114.fileName = "panda_group_panda1114"
        panda1114.code = 3763
        panda1114.duration = 92
        panda1114.period = PeriodType.GROUP.ordinal
        panda1114.star = false
        panda1114.vertical = false
        panda1114.title = "10.21 今天早上和花上班，奶爸拿苹果，奶妈拉小手手，和花还撒娇想抱腿腿。太可爱啦😍这就是谭爷爷所说的“和花你搞不赢”吗？"
        panda1114.releaseTime = 1666352342
        panda1114.originalUrl = "https://www.bilibili.com/video/BV1tm4y1w7Ed"
        panda1114.tags = "大熊猫,萌宠,动物圈"
        panda1114.authorId = 16468440
        panda1114.cover =
            "https://i2.hdslb.com/bfs/archive/9826e3e526cbf1d4f095361f8b23fddc6d197c99.jpg"
        list.add(panda1114)

        val panda1115 = PetVideo()
        panda1115.type = VideoType.PANDA.ordinal
        panda1115.fileName = "panda_group_panda1115"
        panda1115.code = 3764
        panda1115.duration = 90
        panda1115.period = PeriodType.GROUP.ordinal
        panda1115.star = true
        panda1115.vertical = false
        panda1115.title = "“我们约定一辈子都是世界第一好的姐弟”"
        panda1115.releaseTime = 1665183600
        panda1115.originalUrl = "https://www.bilibili.com/video/BV1Ft4y1c7nt"
        panda1115.tags = "大熊猫,萌宠,动物圈"
        panda1115.authorId = 484440897
        panda1115.cover =
            "https://i1.hdslb.com/bfs/archive/c3a4859c2b6b63c70123dc154cab76041b3e8191.jpg"
        list.add(panda1115)

        val panda1116 = PetVideo()
        panda1116.type = VideoType.PANDA.ordinal
        panda1116.fileName = "panda_group_panda1116"
        panda1116.code = 3765
        panda1116.duration = 85
        panda1116.period = PeriodType.GROUP.ordinal
        panda1116.star = true
        panda1116.vertical = false
        panda1116.title = "有一位帅哥，从晨曦中走来，把自己团成了一颗金色的球!【大熊猫和叶】"
        panda1116.releaseTime = 1666566240
        panda1116.originalUrl = "https://www.bilibili.com/video/BV1wV4y1G7Ds"
        panda1116.tags = "大熊猫,萌宠,动物圈"
        panda1116.authorId = 16468440
        panda1116.cover =
            "https://i0.hdslb.com/bfs/archive/1fd30bcb5c2950c919a36a70401eb353ec28b1ac.jpg"
        list.add(panda1116)

        val panda1117 = PetVideo()
        panda1117.type = VideoType.PANDA.ordinal
        panda1117.fileName = "panda_group_panda1117"
        panda1117.code = 3766
        panda1117.duration = 99
        panda1117.period = PeriodType.GROUP.ordinal
        panda1117.star = false
        panda1117.vertical = true
        panda1117.title = "20级小二班钓猫，20220921，熊猫滚滚直播间录屏，大熊猫金双金喜福双茱萸重阳快乐干饭时间"
        panda1117.releaseTime = 1663734633
        panda1117.originalUrl = "https://www.bilibili.com/video/BV1DP411J7US"
        panda1117.tags = "大熊猫,萌宠,动物圈"
        panda1117.authorId = 439042524
        panda1117.cover =
            "https://i1.hdslb.com/bfs/archive/c8fa1bcf289a2db61cf3730034a917940a057d85.jpg"
        list.add(panda1117)

        val panda1118 = PetVideo()
        panda1118.type = VideoType.PANDA.ordinal
        panda1118.fileName = "panda_group_panda1118"
        panda1118.code = 3767
        panda1118.duration = 51
        panda1118.period = PeriodType.GROUP.ordinal
        panda1118.star = false
        panda1118.vertical = false
        panda1118.title = "和花呀，你怂起好像暴躁大熊猫呀哈哈哈，不过你最好看"
        panda1118.releaseTime = 1666350997
        panda1118.originalUrl = "https://www.bilibili.com/video/BV1rG4y1874T"
        panda1118.tags = "大熊猫,萌宠,动物圈"
        panda1118.authorId = 484440897
        panda1118.cover =
            "https://i1.hdslb.com/bfs/archive/82fd96015d4887a0b78fba220ce709ba452d3683.jpg"
        list.add(panda1118)

        val panda1119 = PetVideo()
        panda1119.type = VideoType.PANDA.ordinal
        panda1119.fileName = "panda_group_panda1119"
        panda1119.code = 3768
        panda1119.duration = 87
        panda1119.period = PeriodType.GROUP.ordinal
        panda1119.star = true
        panda1119.vertical = false
        panda1119.title = "和花的大jio板好可爱【大熊猫和花】"
        panda1119.releaseTime = 1663418710
        panda1119.originalUrl = "https://www.bilibili.com/video/BV1cY4y1N754"
        panda1119.tags = "大熊猫,萌宠,动物圈"
        panda1119.authorId = 230382720
        panda1119.cover =
            "https://i2.hdslb.com/bfs/archive/71aa7220b355271c87b60b6a7acba1a27d9f61f4.jpg"
        list.add(panda1119)

        val panda1120 = PetVideo()
        panda1120.type = VideoType.PANDA.ordinal
        panda1120.fileName = "panda_group_panda1120"
        panda1120.code = 3769
        panda1120.duration = 62
        panda1120.period = PeriodType.GROUP.ordinal
        panda1120.star = true
        panda1120.vertical = false
        panda1120.title = "【大熊猫和花】和花的性格真是慢悠悠的，散步都很优雅"
        panda1120.releaseTime = 1666444811
        panda1120.originalUrl = "https://www.bilibili.com/video/BV1m8411e7ZK"
        panda1120.tags = "大熊猫,萌宠,动物圈"
        panda1120.authorId = 608746190
        panda1120.cover =
            "https://i0.hdslb.com/bfs/archive/d352dfe8c5a7a182b38c4057ba700d51a88d91d3.jpg"
        list.add(panda1120)

        val panda1121 = PetVideo()
        panda1121.type = VideoType.PANDA.ordinal
        panda1121.fileName = "panda_group_panda1121"
        panda1121.code = 3770
        panda1121.duration = 346
        panda1121.period = PeriodType.GROUP.ordinal
        panda1121.star = false
        panda1121.vertical = false
        panda1121.title = "【10.23新xuān的钓猫】四只齐聚啦！和花参与感满分，没拿到自己的会嗯嗯叫，还捡到漏耶"
        panda1121.releaseTime = 1666503863
        panda1121.originalUrl = "https://www.bilibili.com/video/BV1pe4y177NR"
        panda1121.tags = "大熊猫,萌宠,动物圈"
        panda1121.authorId = 484440897
        panda1121.cover =
            "https://i0.hdslb.com/bfs/archive/b328bde38489d4a222ad8393ca8631a0cbcf7049.jpg"
        list.add(panda1121)

        val panda1122 = PetVideo()
        panda1122.type = VideoType.PANDA.ordinal
        panda1122.fileName = "panda_group_panda1122"
        panda1122.code = 3771
        panda1122.duration = 21
        panda1122.period = PeriodType.GROUP.ordinal
        panda1122.star = false
        panda1122.vertical = false
        panda1122.title = "和瓜jio拒二狗：退退退~我自己的小饭桌自己清理！【大熊猫和叶、润玥】"
        panda1122.releaseTime = 1666447192
        panda1122.originalUrl = "https://www.bilibili.com/video/BV1Wt4y1u7Xm"
        panda1122.tags = "大熊猫,萌宠,动物圈"
        panda1122.authorId = 514531996
        panda1122.cover =
            "https://i0.hdslb.com/bfs/archive/be055192cc9d85ee9fac8510e7e8cd49707e17f0.jpg"
        list.add(panda1122)

        val panda1123 = PetVideo()
        panda1123.type = VideoType.PANDA.ordinal
        panda1123.fileName = "panda_group_panda1123"
        panda1123.code = 3772
        panda1123.duration = 495
        panda1123.period = PeriodType.GROUP.ordinal
        panda1123.star = true
        panda1123.vertical = false
        panda1123.title = "10.21  奶爸来接和花回家，和花狗叫狮吼凶奶爸，然后开始费奶爸，甚至还想爬个树!"
        panda1123.releaseTime = 1666393440
        panda1123.originalUrl = "https://www.bilibili.com/video/BV1LR4y197mv"
        panda1123.tags = "大熊猫,萌宠,动物圈"
        panda1123.authorId = 16468440
        panda1123.cover =
            "https://i2.hdslb.com/bfs/archive/e310f0e2cd28095a5e483e242248052ab8a20603.jpg"
        list.add(panda1123)

        val panda1124 = PetVideo()
        panda1124.type = VideoType.PANDA.ordinal
        panda1124.fileName = "panda_group_panda1124"
        panda1124.code = 3773
        panda1124.duration = 113
        panda1124.period = PeriodType.GROUP.ordinal
        panda1124.star = false
        panda1124.vertical = false
        panda1124.title = "和花：我今天没有吃果果，憋闻啦，一起吃早饭（和花靠着弟弟好温馨"
        panda1124.releaseTime = 1666399471
        panda1124.originalUrl = "https://www.bilibili.com/video/BV1Wm4y1w79p"
        panda1124.tags = "大熊猫,萌宠,动物圈"
        panda1124.authorId = 484440897
        panda1124.cover =
            "https://i0.hdslb.com/bfs/archive/79ba8d6adc5bdaab852569096b34d47924c140b0.jpg"
        list.add(panda1124)

        val panda1125 = PetVideo()
        panda1125.type = VideoType.PANDA.ordinal
        panda1125.fileName = "panda_group_panda1125"
        panda1125.code = 3774
        panda1125.duration = 164
        panda1125.period = PeriodType.GROUP.ordinal
        panda1125.star = false
        panda1125.vertical = false
        panda1125.title = "那个，这是可以发的吗？和花一边嗷呜一边拉青团，还拉了2次! 很顺畅，很舒服，大家都很满意!😎🎉"
        panda1125.releaseTime = 1666415854
        panda1125.originalUrl = "https://www.bilibili.com/video/BV1ht4y1u7tc"
        panda1125.tags = "大熊猫,萌宠,动物圈"
        panda1125.authorId = 16468440
        panda1125.cover =
            "https://i0.hdslb.com/bfs/archive/0e47225dca629a6ebf609acd7a1170326513f324.jpg"
        list.add(panda1125)

        val panda1126 = PetVideo()
        panda1126.type = VideoType.PANDA.ordinal
        panda1126.fileName = "panda_group_panda1126"
        panda1126.code = 3775
        panda1126.duration = 433
        panda1126.period = PeriodType.GROUP.ordinal
        panda1126.star = false
        panda1126.vertical = false
        panda1126.title = "【10.22钓猫】爷爷回来啦，今天吃得很好呢，和花护食啦（艾玖玖单独喂的）"
        panda1126.releaseTime = 1666422771
        panda1126.originalUrl = "https://www.bilibili.com/video/BV1UW4y177WD"
        panda1126.tags = "大熊猫,萌宠,动物圈"
        panda1126.authorId = 484440897
        panda1126.cover =
            "https://i0.hdslb.com/bfs/archive/90d717cd46f7159a9709dad84e2020d2043eb9a0.jpg"
        list.add(panda1126)

        val panda1127 = PetVideo()
        panda1127.type = VideoType.PANDA.ordinal
        panda1127.fileName = "panda_group_panda1127"
        panda1127.code = 3776
        panda1127.duration = 34
        panda1127.period = PeriodType.GROUP.ordinal
        panda1127.star = false
        panda1127.vertical = false
        panda1127.title = "大熊猫和花和叶-我们是感情超好的姐弟！"
        panda1127.releaseTime = 1666431154
        panda1127.originalUrl = "https://www.bilibili.com/video/BV1wd4y1y7Nq"
        panda1127.tags = "大熊猫,萌宠,动物圈"
        panda1127.authorId = 1307515
        panda1127.cover =
            "https://i1.hdslb.com/bfs/archive/a02ab3d1754ddbe0e5f04b03792ec1511e56fccb.jpg"
        list.add(panda1127)

        val panda1128 = PetVideo()
        panda1128.type = VideoType.PANDA.ordinal
        panda1128.fileName = "panda_group_panda1128"
        panda1128.code = 3777
        panda1128.duration = 80
        panda1128.period = PeriodType.GROUP.ordinal
        panda1128.star = true
        panda1128.vertical = false
        panda1128.title = "两姐弟一起贴着吃饭，和花也紧紧的贴着弟娃💝太可爱了🌸🌿"
        panda1128.releaseTime = 1666437638
        panda1128.originalUrl = "https://www.bilibili.com/video/BV1VR4y1971h"
        panda1128.tags = "大熊猫,萌宠,动物圈"
        panda1128.authorId = 1714028276
        panda1128.cover =
            "https://i1.hdslb.com/bfs/archive/a2b4a3719bfc7ab8307142637c732459bb8eb74f.jpg"
        list.add(panda1128)

        val panda1129 = PetVideo()
        panda1129.type = VideoType.PANDA.ordinal
        panda1129.fileName = "panda_group_panda1129"
        panda1129.code = 3778
        panda1129.duration = 70
        panda1129.period = PeriodType.GROUP.ordinal
        panda1129.star = true
        panda1129.vertical = false
        panda1129.title = "花宝叽的肚肚毛又厚又长，不容易挠透，挠完后和花一脸满足"
        panda1129.releaseTime = 1666425315
        panda1129.originalUrl = "https://www.bilibili.com/video/BV1Jd4y1y7jY"
        panda1129.tags = "大熊猫,萌宠,动物圈"
        panda1129.authorId = 230382720
        panda1129.cover =
            "https://i1.hdslb.com/bfs/archive/417942c7776b12b3fd45390c1abbc04e0810d181.jpg"
        list.add(panda1129)

    }
}