package com.example.pandas.data.sql

import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.entity.PetVideo

object PetTigerData {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {

        val tiger1 = PetVideo()
        tiger1.type = VideoType.TIGER.ordinal
        tiger1.fileName = "tiger_1"
        tiger1.code = 3739
        tiger1.duration = 132
        tiger1.star = false
        tiger1.vertical = false
        tiger1.title = "武松打得过这玩意儿？"
        tiger1.releaseTime = 1593226052
        tiger1.originalUrl = "https://www.bilibili.com/video/BV1mT4y1J7iG"
        tiger1.tags = "虎,老虎"
        tiger1.authorId = 496783876
        tiger1.cover =
            "https://i1.hdslb.com/bfs/archive/a915fdd27329fc34b1d7483465891b0a326c7fbf.jpg"
        list.add(tiger1)

        val tiger2 = PetVideo()
        tiger2.type = VideoType.TIGER.ordinal
        tiger2.fileName = "tiger_2"
        tiger2.code = 3740
        tiger2.duration = 41
        tiger2.star = false
        tiger2.vertical = false
        tiger2.title = "母虎将她的可爱幼崽搂入怀中"
        tiger2.releaseTime = 1613133914
        tiger2.originalUrl = "https://www.bilibili.com/video/BV1Mr4y1N7ue"
        tiger2.tags = "虎,老虎"
        tiger2.authorId = 1994843159
        tiger2.cover =
            "https://i1.hdslb.com/bfs/archive/ccad7f29b35dc09d797a526ec6194afd7617d99c.jpg"
        list.add(tiger2)

        val tiger3 = PetVideo()
        tiger3.type = VideoType.TIGER.ordinal
        tiger3.fileName = "tiger_3"
        tiger3.code = 3741
        tiger3.duration = 46
        tiger3.star = false
        tiger3.vertical = false
        tiger3.title = "小老虎很喜欢撩骚家猫，结果被狂抽耳光"
        tiger3.releaseTime = 1612420800
        tiger3.originalUrl = "https://www.bilibili.com/video/BV1vz4y1U7Ni"
        tiger3.tags = "虎,老虎"
        tiger3.authorId = 1994843159
        tiger3.cover =
            "https://i0.hdslb.com/bfs/archive/7fb650b2609bc0cda493bd36a8d752e40c4cf48d.jpg"
        list.add(tiger3)

        val tiger4 = PetVideo()
        tiger4.type = VideoType.TIGER.ordinal
        tiger4.fileName = "tiger_4"
        tiger4.code = 3742
        tiger4.duration = 58
        tiger4.star = false
        tiger4.vertical = false
        tiger4.title = "要妈妈背"
        tiger4.releaseTime = 1640422304
        tiger4.originalUrl = "https://www.bilibili.com/video/BV1j34y1r7Wn"
        tiger4.tags = "虎,老虎"
        tiger4.authorId = 544654213
        tiger4.cover =
            "https://i2.hdslb.com/bfs/archive/2b5d8a6ede69af2156ac73285722c544da4e120b.jpg"
        list.add(tiger4)

        val tiger5 = PetVideo()
        tiger5.type = VideoType.TIGER.ordinal
        tiger5.fileName = "tiger_5"
        tiger5.code = 3743
        tiger5.duration = 131
        tiger5.star = false
        tiger5.vertical = false
        tiger5.title = "毛茸茸的小东西 幼年白虎和东北虎在雪地玩耍"
        tiger5.releaseTime = 1558524565
        tiger5.originalUrl = "https://www.bilibili.com/video/BV11441157PT"
        tiger5.tags = "虎,老虎"
        tiger5.authorId = 28273053
        tiger5.cover =
            "https://i0.hdslb.com/bfs/archive/4b58d5f6a462f534d02fc8d2856fe7e5aece389f.jpg"
        list.add(tiger5)

        val tiger6 = PetVideo()
        tiger6.type = VideoType.TIGER.ordinal
        tiger6.fileName = "tiger_6"
        tiger6.code = 3744
        tiger6.duration = 176
        tiger6.star = false
        tiger6.vertical = false
        tiger6.title = "真抗冻！老虎在天寒地冻的雪地上酣然入梦"
        tiger6.releaseTime = 1605998430
        tiger6.originalUrl = "https://www.bilibili.com/video/BV1Bv411r73q"
        tiger6.tags = "虎,老虎"
        tiger6.authorId = 191319931
        tiger6.cover =
            "https://i1.hdslb.com/bfs/archive/31190ca9114e57b1a3749bffbdec1c7065045a6e.png"
        list.add(tiger6)

        val tiger7 = PetVideo()
        tiger7.type = VideoType.TIGER.ordinal
        tiger7.fileName = "tiger_7"
        tiger7.code = 3745
        tiger7.duration = 60
        tiger7.star = false
        tiger7.vertical = false
        tiger7.title = "神秘长白山下的天籁生灵"
        tiger7.releaseTime = 1644376115
        tiger7.originalUrl = "https://www.bilibili.com/video/BV1434y117qY"
        tiger7.tags = "虎,老虎"
        tiger7.authorId = 1523830423
        tiger7.cover =
            "https://i2.hdslb.com/bfs/archive/79291482dd4598358355dd0bc5d52ca6bdad4047.jpg"
        list.add(tiger7)

        val tiger8 = PetVideo()
        tiger8.type = VideoType.TIGER.ordinal
        tiger8.fileName = "tiger_8"
        tiger8.code = 3746
        tiger8.duration = 38
        tiger8.star = false
        tiger8.vertical = false
        tiger8.title = "麻麻旁边最安全了啦！"
        tiger8.releaseTime = 1621276904
        tiger8.originalUrl = "https://www.bilibili.com/video/BV1q5411u7NF"
        tiger8.tags = "虎,老虎"
        tiger8.authorId = 14451653
        tiger8.cover =
            "https://i1.hdslb.com/bfs/archive/28ed91e07beda2c4e935fdb7496a69c09ba0118c.jpg"
        list.add(tiger8)

        val tiger9 = PetVideo()
        tiger9.type = VideoType.TIGER.ordinal
        tiger9.fileName = "tiger_9"
        tiger9.code = 3747
        tiger9.duration = 105
        tiger9.star = false
        tiger9.vertical = false
        tiger9.title = "母女心连心💕喜欢粘着妈妈的小老虎"
        tiger9.releaseTime = 1615292781
        tiger9.originalUrl = "https://www.bilibili.com/video/BV1PK4y1n7aX"
        tiger9.tags = "虎,老虎"
        tiger9.authorId = 19132130
        tiger9.cover =
            "https://i0.hdslb.com/bfs/archive/341821b9e2f477de8b9f186d61fafd89817de88b.jpg"
        list.add(tiger9)

        val tiger10 = PetVideo()
        tiger10.type = VideoType.TIGER.ordinal
        tiger10.fileName = "tiger_10"
        tiger10.code = 3748
        tiger10.duration = 197
        tiger10.star = false
        tiger10.vertical = false
        tiger10.title = "有一个脾气好的哥哥是什么体验"
        tiger10.releaseTime = 1628339518
        tiger10.originalUrl = "https://www.bilibili.com/video/BV1PL411H7sA"
        tiger10.tags = "虎,老虎"
        tiger10.authorId = 19132130
        tiger10.cover =
            "https://i2.hdslb.com/bfs/archive/a4ec94587734ef28e73aeb9b80b18c04b6a321ee.jpg"
        list.add(tiger10)

        val tiger11 = PetVideo()
        tiger11.type = VideoType.TIGER.ordinal
        tiger11.fileName = "tiger_11"
        tiger11.code = 3749
        tiger11.duration = 77
        tiger11.star = false
        tiger11.vertical = false
        tiger11.title = "小母虎和哥哥贴贴，亲密无间的兄妹情~"
        tiger11.releaseTime = 1660372784
        tiger11.originalUrl = "https://www.bilibili.com/video/BV1Pa411Z7VL"
        tiger11.tags = "虎,老虎"
        tiger11.authorId = 1994843159
        tiger11.cover =
            "https://i1.hdslb.com/bfs/archive/da0ec0f4b52e1ca967442d32ead4093bc7eacaea.jpg"
        list.add(tiger11)

        val tiger12 = PetVideo()
        tiger12.type = VideoType.TIGER.ordinal
        tiger12.fileName = "tiger_12"
        tiger12.code = 3750
        tiger12.duration = 39
        tiger12.star = false
        tiger12.vertical = false
        tiger12.title = "小猫咪也是有坏心眼的"
        tiger12.releaseTime = 1656137104
        tiger12.originalUrl = "https://www.bilibili.com/video/BV13B4y1x72G"
        tiger12.tags = "虎,老虎"
        tiger12.authorId = 243161016
        tiger12.cover =
            "https://i2.hdslb.com/bfs/archive/414e4fab025b8f91f9e373b3e526360a5d1d80c4.jpg"
        list.add(tiger12)

        val tiger13 = PetVideo()
        tiger13.type = VideoType.TIGER.ordinal
        tiger13.fileName = "tiger_13"
        tiger13.code = 3751
        tiger13.duration = 39
        tiger13.star = false
        tiger13.vertical = false
        tiger13.title = "【老虎】虎子长大了，虎妈还像往常一样去叼他，发现叼不动Ծ‸Ծ"
        tiger13.releaseTime = 1645633122
        tiger13.originalUrl = "https://www.bilibili.com/video/BV11R4y1V7km"
        tiger13.tags = "虎,老虎"
        tiger13.authorId = 56369656
        tiger13.cover =
            "https://i1.hdslb.com/bfs/archive/ad218cdcadda568533d86de6dec24b47d0cb751a.jpg"
        list.add(tiger13)

        val tiger14 = PetVideo()
        tiger14.type = VideoType.TIGER.ordinal
        tiger14.fileName = "tiger_14"
        tiger14.code = 3752
        tiger14.duration = 210
        tiger14.star = false
        tiger14.vertical = false
        tiger14.title = "“半大小子 气死老子”"
        tiger14.releaseTime = 1645624990
        tiger14.originalUrl = "https://www.bilibili.com/video/BV1dY41137ou"
        tiger14.tags = "虎,老虎"
        tiger14.authorId = 1241780764
        tiger14.cover =
            "https://i2.hdslb.com/bfs/archive/57c2d47fca8015d87e9904d2eae452ce70b8a5c5.jpg"
        list.add(tiger14)

        val tiger15 = PetVideo()
        tiger15.type = VideoType.TIGER.ordinal
        tiger15.fileName = "tiger_15"
        tiger15.code = 3753
        tiger15.duration = 83
        tiger15.star = false
        tiger15.vertical = false
        tiger15.title = "“雄性东北虎宝宝向妈妈和妹妹撒娇”只有一岁就这么壮了……"
        tiger15.releaseTime = 1645330625
        tiger15.originalUrl = "https://www.bilibili.com/video/BV1YT4y1D7Hr"
        tiger15.tags = "虎,老虎"
        tiger15.authorId = 1994843159
        tiger15.cover =
            "https://i0.hdslb.com/bfs/archive/e4569a58bc638c7e388389ca9820d99d37e04d1c.jpg"
        list.add(tiger15)

        return list
    }
}