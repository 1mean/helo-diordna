package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetCatData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {

        val cat1 = PetVideo()
        cat1.type = VideoType.CAT.ordinal
        cat1.fileName = "cat_1"
        cat1.code = 1682
        cat1.duration = 121
        cat1.isStar = true
        cat1.title = "奶猫第一次见到爸爸：让你闻"
        cat1.releaseTime = "2021-06-12 14:00:13"
        cat1.originalUrl = "https://www.bilibili.com/video/BV1G5411u7JX"
        cat1.tags = "猫,萌宠,动物圈"
        cat1.authorName = "伊琳娜的喵星球"
        cat1.cover = "https://i1.hdslb.com/bfs/archive/69ec844c853ca57ad69408896ae70ce3ac634ded.jpg"
        list.add(cat1)

        val cat2 = PetVideo()
        cat2.type = VideoType.CAT.ordinal
        cat2.fileName = "cat_2"
        cat2.code = 1683
        cat2.duration = 238
        cat2.isStar = true
        cat2.title = "猫爷爷带娃，隔辈就是亲！"
        cat2.releaseTime = "2021-07-05 17:36:47"
        cat2.originalUrl = "https://www.bilibili.com/video/BV1X64y197zk"
        cat2.tags = "猫,萌宠,动物圈"
        cat2.authorName = "伊琳娜的喵星球"
        cat2.cover = "https://i1.hdslb.com/bfs/archive/c5b524ac5db4344bef626b526132f64f2661d5ae.jpg"
        list.add(cat2)

        val cat3 = PetVideo()
        cat3.type = VideoType.CAT.ordinal
        cat3.fileName = "cat_3"
        cat3.code = 1684
        cat3.duration = 132
        cat3.isStar = true
        cat3.title = "吸 猫 大 师"
        cat3.releaseTime = "2022-03-09 17:46:15"
        cat3.originalUrl = "https://www.bilibili.com/video/BV1gT4y1D7ju"
        cat3.tags = "猫,萌宠,动物圈"
        cat3.authorName = "伊琳娜的喵星球"
        cat3.cover = "https://i1.hdslb.com/bfs/archive/b872ee88fde9ee5325b17cb3829a6b5f6a8947c3.jpg"
        list.add(cat3)

        val cat4 = PetVideo()
        cat4.type = VideoType.CAT.ordinal
        cat4.fileName = "cat_4"
        cat4.code = 1685
        cat4.duration = 278
        cat4.isStar = true
        cat4.title = "奶猫：来自我姐沉重的爱"
        cat4.releaseTime = "2022-03-08 17:16:34"
        cat4.originalUrl = "https://www.bilibili.com/video/BV1E44y1M7rY"
        cat4.tags = "猫,萌宠,动物圈"
        cat4.authorName = "伊琳娜的喵星球"
        cat4.cover = "https://i2.hdslb.com/bfs/archive/44138470369b35549d277b266d8f31e49466b9d3.jpg"
        list.add(cat4)

        val cat5 = PetVideo()
        cat5.type = VideoType.CAT.ordinal
        cat5.fileName = "cat_5"
        cat5.code = 1686
        cat5.duration = 192
        cat5.isStar = true
        cat5.title = "打妈妈！这奶猫谁想要啊？"
        cat5.releaseTime = "2020-08-29 12:00:43"
        cat5.originalUrl = "https://www.bilibili.com/video/BV1xD4y1m73A"
        cat5.tags = "猫,萌宠,动物圈"
        cat5.authorName = "伊琳娜的喵星球"
        cat5.cover = "https://i2.hdslb.com/bfs/archive/261a1066480f6cd258bc257bf421f0f701412458.jpg"
        list.add(cat5)

        val cat6 = PetVideo()
        cat6.type = VideoType.CAT.ordinal
        cat6.fileName = "cat_6"
        cat6.code = 1687
        cat6.duration = 131
        cat6.isStar = true
        cat6.title = "Coco化身猫保姆：这届孩子太难带"
        cat6.releaseTime = "2020-09-19 16:47:18"
        cat6.originalUrl = "https://www.bilibili.com/video/BV1da4y1j7bk"
        cat6.tags = "猫,萌宠,动物圈"
        cat6.authorName = "伊琳娜的喵星球"
        cat6.cover = "https://i1.hdslb.com/bfs/archive/00f749950a7c05371c6307d02725f888ac70180d.jpg"
        list.add(cat6)

        val cat7 = PetVideo()
        cat7.type = VideoType.CAT.ordinal
        cat7.fileName = "cat_7"
        cat7.code = 1688
        cat7.duration = 51
        cat7.isStar = true
        cat7.title = "银渐层Coco：妈，他真是我爸？"
        cat7.releaseTime = "2020-07-09 18:07:13"
        cat7.originalUrl = "https://www.bilibili.com/video/BV1fv411B7ug"
        cat7.tags = "猫,萌宠,动物圈"
        cat7.authorName = "伊琳娜的喵星球"
        cat7.cover = "https://i0.hdslb.com/bfs/archive/65b378b7ec16b7b871c011f3effe496db16a9a9a.jpg"
        list.add(cat7)

        val cat8 = PetVideo()
        cat8.type = VideoType.CAT.ordinal
        cat8.fileName = "cat_8"
        cat8.code = 1689
        cat8.duration = 118
        cat8.isStar = true
        cat8.title = "Coco：早知这么怂，何必当初呢？"
        cat8.releaseTime = "2020-09-05 17:05:52"
        cat8.originalUrl = "https://www.bilibili.com/video/BV1iK4y1e7TU"
        cat8.tags = "猫,萌宠,动物圈"
        cat8.authorName = "伊琳娜的喵星球"
        cat8.cover = "https://i0.hdslb.com/bfs/archive/f3576be89c255e90f12a57df7fe02da808b1c03b.jpg"
        list.add(cat8)

        val cat9 = PetVideo()
        cat9.type = VideoType.CAT.ordinal
        cat9.fileName = "cat_9"
        cat9.code = 1690
        cat9.duration = 97
        cat9.isStar = true
        cat9.title = "有的猫不止脸好看，jiojio更好看"
        cat9.releaseTime = "2021-02-16 19:05:10"
        cat9.originalUrl = "https://www.bilibili.com/video/BV1Lb4y1R74E"
        cat9.tags = "猫,萌宠,动物圈"
        cat9.authorName = "伊琳娜的喵星球"
        cat9.cover = "https://i1.hdslb.com/bfs/archive/65d43f51dfdfe1aee1b228890011c9a5fd997c4e.jpg"
        list.add(cat9)

        val cat10 = PetVideo()
        cat10.type = VideoType.CAT.ordinal
        cat10.fileName = "cat_10"
        cat10.code = 1691
        cat10.duration = 71
        cat10.isStar = true
        cat10.title = "只有把小奶猫搂在怀里，猫妈才能放心睡觉"
        cat10.releaseTime = "2020-06-10 16:48:01"
        cat10.originalUrl = "https://www.bilibili.com/video/BV1wk4y1z7ZT"
        cat10.tags = "猫,萌宠,动物圈"
        cat10.authorName = "伊琳娜的喵星球"
        cat10.cover =
            "https://i2.hdslb.com/bfs/archive/c7432ac15310d783896c939ad5977e1c2f48279b.jpg"
        list.add(cat10)

        val cat11 = PetVideo()
        cat11.type = VideoType.CAT.ordinal
        cat11.fileName = "cat_11"
        cat11.code = 1692
        cat11.duration = 63
        cat11.isStar = true
        cat11.title = "这就是独苗奶猫的优势，猫妈整天搂着"
        cat11.releaseTime = "2020-06-02 18:39:26"
        cat11.originalUrl = "https://www.bilibili.com/video/BV1uk4y1z71N"
        cat11.tags = "猫,萌宠,动物圈"
        cat11.authorName = "伊琳娜的喵星球"
        cat11.cover =
            "https://i0.hdslb.com/bfs/archive/109c2f154a016274d3bb2a7866b412fe6178fdd0.jpg"
        list.add(cat11)

        val cat12 = PetVideo()
        cat12.type = VideoType.CAT.ordinal
        cat12.fileName = "cat_12"
        cat12.code = 1693
        cat12.duration = 95
        cat12.isStar = true
        cat12.title = "奶猫：走开，别碰我！"
        cat12.releaseTime = "2021-01-22 18:15:00"
        cat12.originalUrl = "https://www.bilibili.com/video/BV1or4y1N7qL"
        cat12.tags = "猫,萌宠,动物圈"
        cat12.authorName = "伊琳娜的喵星球"
        cat12.cover =
            "https://i1.hdslb.com/bfs/archive/dd609d85283bb6336e77f04f562688b8c4297b07.jpg"
        list.add(cat12)

        val cat13 = PetVideo()
        cat13.type = VideoType.CAT.ordinal
        cat13.fileName = "cat_13"
        cat13.code = 1694
        cat13.duration = 89
        cat13.isStar = true
        cat13.title = "猫爸第一次见到女儿：不对，毛色怎么深了？"
        cat13.releaseTime = "2021-04-21 18:30:05"
        cat13.originalUrl = "https://www.bilibili.com/video/BV18Q4y1Z7Jt"
        cat13.tags = "猫,萌宠,动物圈"
        cat13.authorName = "伊琳娜的喵星球"
        cat13.cover =
            "https://i0.hdslb.com/bfs/archive/f50d99faffb34798d2220f05721fdbfdd2911cc2.jpg"
        list.add(cat13)

        val cat14 = PetVideo()
        cat14.type = VideoType.CAT.ordinal
        cat14.fileName = "cat_14"
        cat14.code = 1695
        cat14.duration = 126
        cat14.isStar = true
        cat14.title = "父 慈 子 孝 ！"
        cat14.releaseTime = "2020-11-19 17:07:49"
        cat14.originalUrl = "https://www.bilibili.com/video/BV1rV411a7Hg"
        cat14.tags = "猫,萌宠,动物圈"
        cat14.authorName = "伊琳娜的喵星球"
        cat14.cover =
            "https://i2.hdslb.com/bfs/archive/58b7d919e58fa3dbcfb11063f58ec65c5ff17a2c.jpg"
        list.add(cat14)

        val cat15 = PetVideo()
        cat15.type = VideoType.CAT.ordinal
        cat15.fileName = "cat_15"
        cat15.code = 1696
        cat15.duration = 136
        cat15.isStar = true
        cat15.title = "奶猫第一次见到爸爸：你别过来啦"
        cat15.releaseTime = "2020-12-25 16:44:35"
        cat15.originalUrl = "https://www.bilibili.com/video/BV1Ff4y1v7V4"
        cat15.tags = "猫,萌宠,动物圈"
        cat15.authorName = "伊琳娜的喵星球"
        cat15.cover =
            "https://i1.hdslb.com/bfs/archive/6988e7c20c653edc99ce4b86fccf80476640f78d.jpg"
        list.add(cat15)

        val cat16 = PetVideo()
        cat16.type = VideoType.CAT.ordinal
        cat16.fileName = "cat_16"
        cat16.code = 1697
        cat16.duration = 158
        cat16.isStar = true
        cat16.title = "奶猫：能不能离我远点"
        cat16.releaseTime = "2021-05-03 12:15:08"
        cat16.originalUrl = "https://www.bilibili.com/video/BV11v411L7gH"
        cat16.tags = "猫,萌宠,动物圈"
        cat16.authorName = "伊琳娜的喵星球"
        cat16.cover =
            "https://i1.hdslb.com/bfs/archive/54c8c7bed128dcf5d97ce3b423209b66cc25c061.jpg"
        list.add(cat16)

        val cat17 = PetVideo()
        cat17.type = VideoType.CAT.ordinal
        cat17.fileName = "cat_17"
        cat17.code = 1698
        cat17.duration = 107
        cat17.isStar = true
        cat17.title = "刚睁开眼的奶猫会如何拒绝主人？"
        cat17.releaseTime = "2021-05-25 17:53:08"
        cat17.originalUrl = "https://www.bilibili.com/video/BV1d54y1V7Sp"
        cat17.tags = "猫,萌宠,动物圈"
        cat17.authorName = "伊琳娜的喵星球"
        cat17.cover =
            "https://i0.hdslb.com/bfs/archive/c650cefa50992cf8e533f9d42e3f62be580c8029.jpg"
        list.add(cat17)

        val cat18 = PetVideo()
        cat18.type = VideoType.CAT.ordinal
        cat18.fileName = "cat_18"
        cat18.code = 1699
        cat18.duration = 75
        cat18.isStar = true
        cat18.title = "猫在屋檐下，不得不梳头"
        cat18.releaseTime = "2021-02-12 11:20:06"
        cat18.originalUrl = "https://www.bilibili.com/video/BV1WU4y1x7KS"
        cat18.tags = "猫,萌宠,动物圈"
        cat18.authorName = "伊琳娜的喵星球"
        cat18.cover =
            "https://i0.hdslb.com/bfs/archive/50314d10b8dc61b69293b0d74af1300da4c8cb93.jpg"
        list.add(cat18)

        val cat19 = PetVideo()
        cat19.type = VideoType.CAT.ordinal
        cat19.fileName = "cat_19"
        cat19.code = 1700
        cat19.duration = 84
        cat19.isStar = true
        cat19.title = "你们知道吗？刚出生的小猫咪不会拉粑粑，粑粑都是猫妈妈吃的，可是家里还有一个三个月的小公猫过来抢屎吃 是什么操作"
        cat19.releaseTime = "2020-03-14 22:03:10"
        cat19.originalUrl = "https://www.bilibili.com/video/BV1fE411G7es"
        cat19.tags = "猫,萌宠,动物圈"
        cat19.authorName = "养猫的沐子"
        cat19.cover =
            "https://i0.hdslb.com/bfs/archive/a322480eb9f8f3aa06c37bc59fd379107e2a38cd.jpg"
        list.add(cat19)

        val cat20 = PetVideo()
        cat20.type = VideoType.CAT.ordinal
        cat20.fileName = "cat_20"
        cat20.code = 1701
        cat20.duration = 131
        cat20.isStar = true
        cat20.title = "姐妹们，年度无语事件来了，所以小猫咪是想当妈？还是想当女儿"
        cat20.releaseTime = "2021-05-24 21:23:39"
        cat20.originalUrl = "https://www.bilibili.com/video/BV1Bg4113713"
        cat20.tags = "猫,萌宠,动物圈"
        cat20.authorName = "养猫的沐子"
        cat20.cover =
            "https://i0.hdslb.com/bfs/archive/43eba9c816258e3093881ad5f33b681efccf2ffa.jpg"
        list.add(cat20)

        val cat21 = PetVideo()
        cat21.type = VideoType.CAT.ordinal
        cat21.fileName = "cat_21"
        cat21.code = 1702
        cat21.duration = 79
        cat21.isStar = true
        cat21.title = "试图用手手萌死对方，奶猫打仗太狠了！"
        cat21.releaseTime = "2020-08-08 12:00:53"
        cat21.originalUrl = "https://www.bilibili.com/video/BV11h411d7Km"
        cat21.tags = "猫,萌宠,动物圈"
        cat21.authorName = "伊琳娜的喵星球"
        cat21.cover =
            "https://i2.hdslb.com/bfs/archive/3473fa62676bb5315bba228902bf527b733723e9.jpg"
        list.add(cat21)

        val cat22 = PetVideo()
        cat22.type = VideoType.CAT.ordinal
        cat22.fileName = "cat_22"
        cat22.code = 1703
        cat22.duration = 56
        cat22.isStar = true
        cat22.title = "进击的小奶猫！！！可爱到爆炸！！！"
        cat22.releaseTime = "2019-08-03 18:00:01"
        cat22.originalUrl = "https://www.bilibili.com/video/BV1bt411u7tU"
        cat22.tags = "猫,萌宠,动物圈"
        cat22.authorName = "偶是偶啦"
        cat22.cover =
            "https://i2.hdslb.com/bfs/archive/4f38dc4b342686d2ec11c524c8be368b5c573004.jpg"
        list.add(cat22)

        val cat23 = PetVideo()
        cat23.type = VideoType.CAT.ordinal
        cat23.fileName = "cat_23"
        cat23.code = 1704
        cat23.duration = 72
        cat23.isStar = true
        cat23.title = "奶量十足，猛男必看"
        cat23.releaseTime = "2021-01-29 13:00:00"
        cat23.originalUrl = "https://www.bilibili.com/video/BV12z4y1m7J1"
        cat23.tags = "猫,萌宠,动物圈"
        cat23.authorName = "喵咪狗汪"
        cat23.cover =
            "https://i1.hdslb.com/bfs/archive/2dcd894f0652e4b469203817d647053f0bfec9e1.jpg"
        list.add(cat23)

        val cat24 = PetVideo()
        cat24.type = VideoType.CAT.ordinal
        cat24.fileName = "cat_24"
        cat24.code = 1705
        cat24.duration = 104
        cat24.isStar = true
        cat24.title = "奶量爆棚！"
        cat24.releaseTime = "2021-01-17 10:04:40"
        cat24.originalUrl = "https://www.bilibili.com/video/BV1UU4y1x7qD"
        cat24.tags = "猫,萌宠,动物圈"
        cat24.authorName = "橘乃sama"
        cat24.cover =
            "https://i2.hdslb.com/bfs/archive/4bdbb5312e7a6dc94fa15391631abcdfcb989bca.jpg"
        list.add(cat24)

        val cat25 = PetVideo()
        cat25.type = VideoType.CAT.ordinal
        cat25.fileName = "cat_25"
        cat25.code = 1706
        cat25.duration = 168
        cat25.isStar = true
        cat25.title = "小奶猫非正常走姿大赏"
        cat25.releaseTime = "2021-12-13 16:14:57"
        cat25.originalUrl = "https://www.bilibili.com/video/BV1iU4y1K7C7"
        cat25.tags = "猫,萌宠,动物圈"
        cat25.authorName = "七叶的喵"
        cat25.cover =
            "https://i2.hdslb.com/bfs/archive/1dc2a0687baa04b4979c4014ed181bffeaccb8d6.jpg"
        list.add(cat25)

        val cat26 = PetVideo()
        cat26.type = VideoType.CAT.ordinal
        cat26.fileName = "cat_26"
        cat26.code = 1707
        cat26.duration = 71
        cat26.isStar = true
        cat26.title = "小猫Coco和她的四个弟弟，妈妈都看不下去了"
        cat26.releaseTime = "2020-07-21 17:23:45"
        cat26.originalUrl = "https://www.bilibili.com/video/BV1ZD4y1m73C"
        cat26.tags = "猫,萌宠,动物圈"
        cat26.authorName = "伊琳娜的喵星球"
        cat26.cover =
            "https://i0.hdslb.com/bfs/archive/887c05ea6301dc54acdf34ec4f8e9fe99cf7b66c.jpg"
        list.add(cat26)

        val cat27 = PetVideo()
        cat27.type = VideoType.CAT.ordinal
        cat27.fileName = "cat_27"
        cat27.code = 1708
        cat27.duration = 186
        cat27.isStar = true
        cat27.title = "奶猫打架太狠了，猫妈来劝都没用"
        cat27.releaseTime = "2020-10-30 16:53:24"
        cat27.originalUrl = "https://www.bilibili.com/video/BV13y4y1r7Rn"
        cat27.tags = "猫,萌宠,动物圈"
        cat27.authorName = "伊琳娜的喵星球"
        cat27.cover =
            "https://i1.hdslb.com/bfs/archive/86d44545e67a6677bd8a0708e6e14007d99b3695.jpg"
        list.add(cat27)

        val cat28 = PetVideo()
        cat28.type = VideoType.CAT.ordinal
        cat28.fileName = "cat_28"
        cat28.code = 1709
        cat28.duration = 143
        cat28.isStar = true
        cat28.title = "奶猫打架输了，委屈巴巴"
        cat28.releaseTime = "2021-01-21 18:04:14"
        cat28.originalUrl = "https://www.bilibili.com/video/BV1A54y1x7Pe"
        cat28.tags = "猫,萌宠,动物圈"
        cat28.authorName = "伊琳娜的喵星球"
        cat28.cover =
            "https://i2.hdslb.com/bfs/archive/2dffaffd158fa0f8b47a72687d10ba54c0143f4b.jpg"
        list.add(cat28)

        val cat29 = PetVideo()
        cat29.type = VideoType.CAT.ordinal
        cat29.fileName = "cat_29"
        cat29.code = 1710
        cat29.duration = 211
        cat29.isStar = true
        cat29.title = "奶猫版猫爪在上！这是原则"
        cat29.releaseTime = "2021-02-17 11:20:20"
        cat29.originalUrl = "https://www.bilibili.com/video/BV1XK4y1Q7jj"
        cat29.tags = "猫,萌宠,动物圈"
        cat29.authorName = "伊琳娜的喵星球"
        cat29.cover =
            "https://i0.hdslb.com/bfs/archive/40c53bb501e3a8e4f42fe277b88636fc118f7785.jpg"
        list.add(cat29)

        val cat30 = PetVideo()
        cat30.type = VideoType.CAT.ordinal
        cat30.fileName = "cat_30"
        cat30.code = 1711
        cat30.duration = 41
        cat30.isStar = true
        cat30.title = "三只小猫搂着搂着睡着了"
        cat30.releaseTime = "2021-02-15 14:15:15"
        cat30.originalUrl = "https://www.bilibili.com/video/BV19i4y1K7vU"
        cat30.tags = "猫,萌宠,动物圈"
        cat30.authorName = "伊琳娜的喵星球"
        cat30.cover =
            "https://i0.hdslb.com/bfs/archive/cbdfa7e5fe1105814cbd735dda137b76e7dfc8a2.jpg"
        list.add(cat30)

        val cat31 = PetVideo()
        cat31.type = VideoType.CAT.ordinal
        cat31.fileName = "cat_31"
        cat31.code = 1712
        cat31.duration = 174
        cat31.isStar = true
        cat31.title = "猫咪幼崽可以有多萌？"
        cat31.releaseTime = "2021-07-13 13:49:45"
        cat31.originalUrl = "https://www.bilibili.com/video/BV1Uo4y1X7Wg"
        cat31.tags = "猫,萌宠,动物圈"
        cat31.authorName = "伊琳娜的喵星球"
        cat31.cover =
            "https://i0.hdslb.com/bfs/archive/211b60100e8931b9f45a2f77ddc6ef78a11d311d.jpg"
        list.add(cat31)

        val cat32 = PetVideo()
        cat32.type = VideoType.CAT.ordinal
        cat32.fileName = "cat_32"
        cat32.code = 1713
        cat32.duration = 151
        cat32.isStar = true
        cat32.title = "小奶猫嘬奶瓶的声音也太好听了"
        cat32.releaseTime = "2021-05-15 16:27:41"
        cat32.originalUrl = "https://www.bilibili.com/video/BV1SA411G7vt"
        cat32.tags = "猫,萌宠,动物圈"
        cat32.authorName = "伊琳娜的喵星球"
        cat32.cover =
            "https://i2.hdslb.com/bfs/archive/f3c51ba2910fcdd66d0d79f2f0d3cc4655c45ada.jpg"
        list.add(cat32)

        val cat33 = PetVideo()
        cat33.type = VideoType.CAT.ordinal
        cat33.fileName = "cat_33"
        cat33.code = 1714
        cat33.duration = 233
        cat33.isStar = true
        cat33.title = "猫猫虫营业就犯困，像极了上课的你"
        cat33.releaseTime = "2021-07-21 18:49:21"
        cat33.originalUrl = "https://www.bilibili.com/video/BV1dh411B78b"
        cat33.tags = "猫,萌宠,动物圈"
        cat33.authorName = "七叶的喵"
        cat33.cover =
            "https://i2.hdslb.com/bfs/archive/bca138101e0afdecc502d304ef601b430a433860.jpg"
        list.add(cat33)

        val cat34 = PetVideo()
        cat34.type = VideoType.CAT.ordinal
        cat34.fileName = "cat_34"
        cat34.code = 1715
        cat34.duration = 121
        cat34.isStar = true
        cat34.title = "山海经曰：有萌兽。腿短，形似猫，有兔耳，身如白雪。"
        cat34.releaseTime = "2021-08-25 00:05:32"
        cat34.originalUrl = "https://www.bilibili.com/video/BV1WQ4y1176K"
        cat34.tags = "猫,萌宠,动物圈"
        cat34.authorName = "七叶的喵"
        cat34.cover =
            "https://i0.hdslb.com/bfs/archive/0c174e87b43a0356094baeb84d04fc49181de0cf.jpg"
        list.add(cat34)

        val cat35 = PetVideo()
        cat35.type = VideoType.CAT.ordinal
        cat35.fileName = "cat_35"
        cat35.code = 1716
        cat35.duration = 210
        cat35.isStar = true
        cat35.title = "像这样的小奶猫，我能吸十个！"
        cat35.releaseTime = "2021-07-12 18:00:06"
        cat35.originalUrl = "https://www.bilibili.com/video/BV1sv411n72o"
        cat35.tags = "猫,萌宠,动物圈"
        cat35.authorName = "七叶的喵"
        cat35.cover =
            "https://i0.hdslb.com/bfs/archive/8f4e33d8e18d27f801b435eee9ea57ced0066f40.jpg"
        list.add(cat35)

        val cat36 = PetVideo()
        cat36.type = VideoType.CAT.ordinal
        cat36.fileName = "cat_36"
        cat36.code = 1717
        cat36.duration = 157
        cat36.isStar = true
        cat36.title = "我只是一条猫猫虫，木有脖子也木有jio~"
        cat36.releaseTime = "2021-07-19 17:55:52"
        cat36.originalUrl = "https://www.bilibili.com/video/BV1dh411B7kb"
        cat36.tags = "猫,萌宠,动物圈"
        cat36.authorName = "七叶的喵"
        cat36.cover =
            "https://i1.hdslb.com/bfs/archive/19dd3cc2df00b14731f02240bc532f480b284e26.jpg"
        list.add(cat36)

        val cat37 = PetVideo()
        cat37.type = VideoType.CAT.ordinal
        cat37.fileName = "cat_37"
        cat37.code = 1718
        cat37.duration = 155
        cat37.isStar = true
        cat37.title = "一窝英短猫100天的变化史"
        cat37.releaseTime = "2021-12-15 17:28:43"
        cat37.originalUrl = "https://www.bilibili.com/video/BV1FR4y1x7pq"
        cat37.tags = "猫,萌宠,动物圈"
        cat37.authorName = "七叶的喵"
        cat37.cover =
            "https://i2.hdslb.com/bfs/archive/5c7d2b98ed11f92ff700c1bd15af7f6d11fefcad.jpg"
        list.add(cat37)

        val cat38 = PetVideo()
        cat38.type = VideoType.CAT.ordinal
        cat38.fileName = "cat_38"
        cat38.code = 1719
        cat38.duration = 173
        cat38.isStar = true
        cat38.title = "小奶猫第一次学走路，我人没了！【奶猫第16天】"
        cat38.releaseTime = "2022-03-05 11:00:07"
        cat38.originalUrl = "https://www.bilibili.com/video/BV1Da411h7j7"
        cat38.tags = "猫,萌宠,动物圈"
        cat38.authorName = "七叶的喵"
        cat38.cover =
            "https://i2.hdslb.com/bfs/archive/fb6e262d737147484b3516969d35f0e823f41ce6.jpg"
        list.add(cat38)

        val cat39 = PetVideo()
        cat39.type = VideoType.CAT.ordinal
        cat39.fileName = "cat_39"
        cat39.code = 1720
        cat39.duration = 73
        cat39.isStar = true
        cat39.title = "见证小猫仔的成长！"
        cat39.releaseTime = "2022-03-06 03:00:34"
        cat39.originalUrl = "https://www.bilibili.com/video/BV19i4y1k7UJ"
        cat39.tags = "猫,萌宠,动物圈"
        cat39.authorName = "柠檬游水"
        cat39.cover =
            "https://i1.hdslb.com/bfs/archive/110272e84da239b5deae4aa300f2169b4abf46b4.jpg"
        list.add(cat39)

        val cat40 = PetVideo()
        cat40.type = VideoType.CAT.ordinal
        cat40.fileName = "cat_40"
        cat40.code = 1721
        cat40.duration = 151
        cat40.isStar = true
        cat40.title = "只能说是痴汉行为，抓手上开干！奶奶的小奶猫就是极致的香！！"
        cat40.releaseTime = "2022-03-07 19:01:55"
        cat40.originalUrl = "https://www.bilibili.com/video/BV1MT4y1D7jd"
        cat40.tags = "猫,萌宠,动物圈"
        cat40.authorName = "柠檬游水"
        cat40.cover =
            "https://i1.hdslb.com/bfs/archive/c2783fbf52e331c86203d780bf4adeaa708f5aab.jpg"
        list.add(cat40)

        val cat41 = PetVideo()
        cat41.type = VideoType.CAT.ordinal
        cat41.fileName = "cat_41"
        cat41.code = 1722
        cat41.duration = 80
        cat41.isStar = true
        cat41.title = "被狠狠虐住了"
        cat41.releaseTime = "2022-02-09 18:52:16"
        cat41.originalUrl = "https://www.bilibili.com/video/BV1bP4y1P7u9"
        cat41.tags = "猫,萌宠,动物圈"
        cat41.authorName = "Fishooey"
        cat41.cover =
            "https://i1.hdslb.com/bfs/archive/eb4277b9898710ec350979d4a7c02c4fdcd1cc87.jpg"
        list.add(cat41)

        val cat42 = PetVideo()
        cat42.type = VideoType.CAT.ordinal
        cat42.fileName = "cat_42"
        cat42.code = 1723
        cat42.duration = 297
        cat42.isStar = true
        cat42.title = "姥姥带娃日记"
        cat42.releaseTime = "2022-02-16 14:47:41"
        cat42.originalUrl = "https://www.bilibili.com/video/BV1ym4y1d7CS"
        cat42.tags = "猫,萌宠,动物圈"
        cat42.authorName = "Yuumi的小可爱们"
        cat42.cover =
            "https://i1.hdslb.com/bfs/archive/e152a3677055095c361f09a3a70b03cb4cbf0e5a.jpg"
        list.add(cat42)

        val cat43 = PetVideo()
        cat43.type = VideoType.CAT.ordinal
        cat43.fileName = "cat_43"
        cat43.code = 1724
        cat43.duration = 175
        cat43.isStar = true
        cat43.title = "这样的小猫咪，你一口气能吸几个？"
        cat43.releaseTime = "2021-08-16 19:37:43"
        cat43.originalUrl = "https://www.bilibili.com/video/BV1sb4y1S79h"
        cat43.tags = "猫,萌宠,动物圈"
        cat43.authorName = "伊琳娜的喵星球"
        cat43.cover =
            "https://i1.hdslb.com/bfs/archive/861ff2eb2ebf566a11ea04b037b0678918d4353e.jpg"
        list.add(cat43)

        val cat44 = PetVideo()
        cat44.type = VideoType.CAT.ordinal
        cat44.fileName = "cat_44"
        cat44.code = 1725
        cat44.duration = 31
        cat44.isStar = true
        cat44.title = "猫咪夫妻之间的加密通话"
        cat44.releaseTime = "2021-09-02 15:28:23"
        cat44.originalUrl = "https://www.bilibili.com/video/BV1Hf4y1A7e9"
        cat44.tags = "猫,萌宠,动物圈"
        cat44.authorName = "伊琳娜的喵星球"
        cat44.cover =
            "https://i2.hdslb.com/bfs/archive/04f57b51cc1161c7820e6ef0938613752e72cd14.jpg"
        list.add(cat44)

        val cat45 = PetVideo()
        cat45.type = VideoType.CAT.ordinal
        cat45.fileName = "cat_45"
        cat45.code = 1726
        cat45.duration = 145
        cat45.isStar = true
        cat45.title = "一 球 不 容 二 猫 ！"
        cat45.releaseTime = "2021-08-27 16:33:18"
        cat45.originalUrl = "https://www.bilibili.com/video/BV1Ug411G7J3"
        cat45.tags = "猫,萌宠,动物圈"
        cat45.authorName = "伊琳娜的喵星球"
        cat45.cover =
            "https://i2.hdslb.com/bfs/archive/44e8fcf4663f85fb5258007f6695d09a31e6e073.jpg"
        list.add(cat45)

        val cat46 = PetVideo()
        cat46.type = VideoType.CAT.ordinal
        cat46.fileName = "cat_46"
        cat46.code = 1727
        cat46.duration = 153
        cat46.isStar = true
        cat46.title = "猫爸：再抢我就打你"
        cat46.releaseTime = "2021-09-03 18:31:51"
        cat46.originalUrl = "https://www.bilibili.com/video/BV14M4y1G7ug"
        cat46.tags = "猫,萌宠,动物圈"
        cat46.authorName = "伊琳娜的喵星球"
        cat46.cover =
            "https://i0.hdslb.com/bfs/archive/89335f4d7f6165ca835d540e6e40db163a7b84c6.jpg"
        list.add(cat46)

        val cat47 = PetVideo()
        cat47.type = VideoType.CAT.ordinal
        cat47.fileName = "cat_47"
        cat47.code = 1728
        cat47.duration = 37
        cat47.isStar = true
        cat47.title = "这该死的甜美，谁能受得了"
        cat47.releaseTime = "2021-09-06 18:31:28"
        cat47.originalUrl = "https://www.bilibili.com/video/BV1v44y187Yu"
        cat47.tags = "猫,萌宠,动物圈"
        cat47.authorName = "伊琳娜的喵星球"
        cat47.cover =
            "https://i0.hdslb.com/bfs/archive/e5c7aab684cfcdfd008cf3e4e6e97fbf73e042aa.jpg"
        list.add(cat47)

        val cat48 = PetVideo()
        cat48.type = VideoType.CAT.ordinal
        cat48.fileName = "cat_48"
        cat48.code = 1729
        cat48.duration = 175
        cat48.isStar = true
        cat48.title = "一 模 一 样 ！"
        cat48.releaseTime = "2021-09-20 12:15:01"
        cat48.originalUrl = "https://www.bilibili.com/video/BV11L411x7dp"
        cat48.tags = "猫,萌宠,动物圈"
        cat48.authorName = "伊琳娜的喵星球"
        cat48.cover =
            "https://i0.hdslb.com/bfs/archive/fec45046871c7d9c3f7b8a501ac9747683064ff6.jpg"
        list.add(cat48)

        val cat49 = PetVideo()
        cat49.type = VideoType.CAT.ordinal
        cat49.fileName = "cat_49"
        cat49.code = 1730
        cat49.duration = 211
        cat49.isStar = true
        cat49.title = "奶猫哼哼唧唧找妈妈，超可爱"
        cat49.releaseTime = "2021-10-01 11:30:09"
        cat49.originalUrl = "https://www.bilibili.com/video/BV1E44y1t77m"
        cat49.tags = "猫,萌宠,动物圈"
        cat49.authorName = "伊琳娜的喵星球"
        cat49.cover =
            "https://i1.hdslb.com/bfs/archive/e505a30550db8a07fa892ddaf020b4481cea61c5.jpg"
        list.add(cat49)

        val cat50 = PetVideo()
        cat50.type = VideoType.CAT.ordinal
        cat50.fileName = "cat_50"
        cat50.code = 1731
        cat50.duration = 174
        cat50.isStar = true
        cat50.title = "来自猫妈劈头盖脸的爱"
        cat50.releaseTime = "2021-10-04 11:30:10"
        cat50.originalUrl = "https://www.bilibili.com/video/BV16q4y1o712"
        cat50.tags = "猫,萌宠,动物圈"
        cat50.authorName = "伊琳娜的喵星球"
        cat50.cover =
            "https://i1.hdslb.com/bfs/archive/1bd12226898df3acea531a3df6bb3886f19877ea.jpg"
        list.add(cat50)

        val cat51 = PetVideo()
        cat51.type = VideoType.CAT.ordinal
        cat51.fileName = "cat_51"
        cat51.code = 1732
        cat51.duration = 67
        cat51.isStar = true
        cat51.title = "一根逗猫棒能叫来多少只猫"
        cat51.releaseTime = "2021-10-27 18:17:04"
        cat51.originalUrl = "https://www.bilibili.com/video/BV1PR4y1n7rB"
        cat51.tags = "猫,萌宠,动物圈"
        cat51.authorName = "伊琳娜的喵星球"
        cat51.cover =
            "https://i0.hdslb.com/bfs/archive/8a8dbd2618f19820447fde3cc058f3aa67e8eaec.jpg"
        list.add(cat51)

        val cat52 = PetVideo()
        cat52.type = VideoType.CAT.ordinal
        cat52.fileName = "cat_52"
        cat52.code = 1733
        cat52.duration = 226
        cat52.isStar = true
        cat52.title = "奶猫：你再不起来我就扁了"
        cat52.releaseTime = "2022-01-12 11:27:35"
        cat52.originalUrl = "https://www.bilibili.com/video/BV1XS4y1T79b"
        cat52.tags = "猫,萌宠,动物圈"
        cat52.authorName = "伊琳娜的喵星球"
        cat52.cover =
            "https://i2.hdslb.com/bfs/archive/4e7e041388c3f1d70cc238f36b2397114c0ce887.jpg"
        list.add(cat52)

        val cat53 = PetVideo()
        cat53.type = VideoType.CAT.ordinal
        cat53.fileName = "cat_53"
        cat53.code = 1734
        cat53.duration = 255
        cat53.isStar = true
        cat53.title = "小奶猫委屈哭了"
        cat53.releaseTime = "2022-01-13 16:54:19"
        cat53.originalUrl = "https://www.bilibili.com/video/BV1tq4y1A7Tr"
        cat53.tags = "猫,萌宠,动物圈"
        cat53.authorName = "伊琳娜的喵星球"
        cat53.cover =
            "https://i2.hdslb.com/bfs/archive/ffc2e294e6e7d1b3fa55dfc7d0d232f5e1aa2e64.jpg"
        list.add(cat53)

        val cat54 = PetVideo()
        cat54.type = VideoType.CAT.ordinal
        cat54.fileName = "cat_54"
        cat54.code = 1735
        cat54.duration = 187
        cat54.isStar = true
        cat54.title = "小奶猫给小鸡当妈妈，搂着搂着睡着了"
        cat54.releaseTime = "2020-08-01 11:48:27"
        cat54.originalUrl = "https://www.bilibili.com/video/BV1zp4y1q7m6"
        cat54.tags = "猫,萌宠,动物圈"
        cat54.authorName = "伊琳娜的喵星球"
        cat54.cover =
            "https://i1.hdslb.com/bfs/archive/7f47ea27a6b9868af4e64575fd09592014b1df1b.jpg"
        list.add(cat54)

        val cat55 = PetVideo()
        cat55.type = VideoType.CAT.ordinal
        cat55.fileName = "cat_55"
        cat55.code = 1736
        cat55.duration = 221
        cat55.isStar = true
        cat55.title = "小奶猫第一次见到这么小的兔子，吓哭了！"
        cat55.releaseTime = "2020-08-19 12:00:16"
        cat55.originalUrl = "https://www.bilibili.com/video/BV1nz4y1f7i2"
        cat55.tags = "猫,萌宠,动物圈"
        cat55.authorName = "伊琳娜的喵星球"
        cat55.cover =
            "https://i0.hdslb.com/bfs/archive/630b7088077f7705cba15eaa6c07fa07de765583.jpg"
        list.add(cat55)

        val cat56 = PetVideo()
        cat56.type = VideoType.CAT.ordinal
        cat56.fileName = "cat_56"
        cat56.code = 1737
        cat56.duration = 231
        cat56.isStar = true
        cat56.title = "奶猫第一次见到兔子：兄弟你耳朵怎么了？"
        cat56.releaseTime = "2020-08-10 17:35:36"
        cat56.originalUrl = "https://www.bilibili.com/video/BV1qT4y157Dc"
        cat56.tags = "猫,萌宠,动物圈"
        cat56.authorName = "伊琳娜的喵星球"
        cat56.cover =
            "https://i1.hdslb.com/bfs/archive/23a9e6a67384dfb0c2f9a716931157ad30aa9d91.jpg"
        list.add(cat56)

        val cat57 = PetVideo()
        cat57.type = VideoType.CAT.ordinal
        cat57.fileName = "cat_57"
        cat57.code = 1738
        cat57.duration = 77
        cat57.isStar = true
        cat57.title = "“兔狲小的时候真的好萌，好想抱起来一顿rua”"
        cat57.releaseTime = "2022-03-05 17:37:32"
        cat57.originalUrl = "https://www.bilibili.com/video/BV1ab4y1W7h6"
        cat57.tags = "猫,萌宠,动物圈"
        cat57.authorName = "兔狲那些事儿"
        cat57.cover =
            "https://i0.hdslb.com/bfs/archive/216dc8c559cb58f07ba098a7a41b15946df5eee6.jpg"
        list.add(cat57)

        val cat58 = PetVideo()
        cat58.type = VideoType.CAT.ordinal
        cat58.fileName = "cat_58"
        cat58.code = 1739
        cat58.duration = 185
        cat58.isStar = true
        cat58.title = "奶猫：妈，它咬我！"
        cat58.releaseTime = "2021-06-16 16:32:40"
        cat58.originalUrl = "https://www.bilibili.com/video/BV1Uo4y1y7PF"
        cat58.tags = "猫,萌宠,动物圈"
        cat58.authorName = "伊琳娜的喵星球"
        cat58.cover =
            "https://i0.hdslb.com/bfs/archive/7237cbcd46b5a7ffa9ddd761006407a76f781a27.jpg"
        list.add(cat58)

        val cat59 = PetVideo()
        cat59.type = VideoType.CAT.ordinal
        cat59.fileName = "cat_59"
        cat59.code = 1740
        cat59.duration = 106
        cat59.isStar = true
        cat59.title = "啥是奶猫啊？让我尝尝"
        cat59.releaseTime = "2021-01-20 12:00:01"
        cat59.originalUrl = "https://www.bilibili.com/video/BV1kz4y167hd"
        cat59.tags = "猫,萌宠,动物圈"
        cat59.authorName = "伊琳娜的喵星球"
        cat59.cover =
            "https://i2.hdslb.com/bfs/archive/d47d7c5c684113a9714be2cf308eb4b80c4d4599.jpg"
        list.add(cat59)

        val cat60 = PetVideo()
        cat60.type = VideoType.CAT.ordinal
        cat60.fileName = "cat_60"
        cat60.code = 1741
        cat60.duration = 104
        cat60.isStar = true
        cat60.title = "没 猫 咪 比 我 更 懂 摇 尾 巴 ！"
        cat60.releaseTime = "2020-08-04 11:36:42"
        cat60.originalUrl = "https://www.bilibili.com/video/BV1bA411Y7ED"
        cat60.tags = "猫,萌宠,动物圈"
        cat60.authorName = "伊琳娜的喵星球"
        cat60.cover =
            "https://i1.hdslb.com/bfs/archive/6108869b9e43b0a99d5d1f97d20b8fedfd29bd48.jpg"
        list.add(cat60)

        val cat61 = PetVideo()
        cat61.type = VideoType.CAT.ordinal
        cat61.fileName = "cat_61"
        cat61.code = 1742
        cat61.duration = 112
        cat61.isStar = true
        cat61.title = "小奶猫会像小狗一样摇尾巴"
        cat61.releaseTime = "2021-02-15 19:05:13"
        cat61.originalUrl = "https://www.bilibili.com/video/BV19p4y1p7ZL"
        cat61.tags = "猫,萌宠,动物圈"
        cat61.authorName = "伊琳娜的喵星球"
        cat61.cover =
            "https://i2.hdslb.com/bfs/archive/2b87e721b0b53e0a0f56ef3c90b34a632caafea3.jpg"
        list.add(cat61)

        val cat62 = PetVideo()
        cat62.type = VideoType.CAT.ordinal
        cat62.fileName = "cat_62"
        cat62.code = 1743
        cat62.duration = 223
        cat62.isStar = true
        cat62.title = "奶猫第一次开荤，场面失控了"
        cat62.releaseTime = "2020-08-12 12:00:36"
        cat62.originalUrl = "https://www.bilibili.com/video/BV1aZ4y1M7BL"
        cat62.tags = "猫,萌宠,动物圈"
        cat62.authorName = "伊琳娜的喵星球"
        cat62.cover =
            "https://i2.hdslb.com/bfs/archive/0402fa5f9d8825f2e348a523e55599a262924935.jpg"
        list.add(cat62)

        val cat63 = PetVideo()
        cat63.type = VideoType.CAT.ordinal
        cat63.fileName = "cat_63"
        cat63.code = 1744
        cat63.duration = 211
        cat63.isStar = true
        cat63.title = "猫妈：萌吧？我生的！"
        cat63.releaseTime = "2020-08-23 12:00:49"
        cat63.originalUrl = "https://www.bilibili.com/video/BV1gt4y1Q7mb"
        cat63.tags = "猫,萌宠,动物圈"
        cat63.authorName = "伊琳娜的喵星球"
        cat63.cover =
            "https://i2.hdslb.com/bfs/archive/250a48f40a88654fcdd5e41af13dd0a25a5a83c4.jpg"
        list.add(cat63)

        val cat64 = PetVideo()
        cat64.type = VideoType.CAT.ordinal
        cat64.fileName = "cat_64"
        cat64.code = 1745
        cat64.duration = 111
        cat64.isStar = true
        cat64.title = "当着猫妈的面，抱起小奶猫会发生什么"
        cat64.releaseTime = "2022-02-06 14:00:04"
        cat64.originalUrl = "https://www.bilibili.com/video/BV1W3411h7G8"
        cat64.tags = "猫,萌宠,动物圈"
        cat64.authorName = "伊琳娜的喵星球"
        cat64.cover =
            "https://i0.hdslb.com/bfs/archive/d614f2f90211fa143c2d13ea8ef7e422a606c5cb.jpg"
        list.add(cat64)

        val cat65 = PetVideo()
        cat65.type = VideoType.CAT.ordinal
        cat65.fileName = "cat_65"
        cat65.code = 1746
        cat65.duration = 39
        cat65.isStar = true
        cat65.title = "原来猫咪也喜欢吸猫"
        cat65.releaseTime = "2022-02-24 20:58:00"
        cat65.originalUrl = "https://www.bilibili.com/video/BV1f3411L7ty"
        cat65.tags = "猫,萌宠,动物圈"
        cat65.authorName = "瓜瓜皮和小小妹"
        cat65.cover =
            "https://i2.hdslb.com/bfs/archive/16043c746a9750d5a960bde370bf6e324e481152.jpg"
        list.add(cat65)

        val cat66 = PetVideo()
        cat66.type = VideoType.CAT.ordinal
        cat66.fileName = "cat_66"
        cat66.code = 1747
        cat66.duration = 122
        cat66.isStar = true
        cat66.title = "请大家不要嘲笑没见过世面的小猫咪"
        cat66.releaseTime = "2022-03-03 20:00:06"
        cat66.originalUrl = "https://www.bilibili.com/video/BV1v44y1T7ym"
        cat66.tags = "猫,萌宠,动物圈"
        cat66.authorName = "瓜瓜皮和小小妹"
        cat66.cover =
            "https://i1.hdslb.com/bfs/archive/f0ef2b8c9ec4704c43123ec34a4d3969d1b84c57.jpg"
        list.add(cat66)

        val cat67 = PetVideo()
        cat67.type = VideoType.CAT.ordinal
        cat67.fileName = "cat_67"
        cat67.code = 1748
        cat67.duration = 80
        cat67.isStar = true
        cat67.title = "只能宠着咯，谁让她是我妹呢"
        cat67.releaseTime = "2022-02-16 11:00:17"
        cat67.originalUrl = "https://www.bilibili.com/video/BV1Bm4y1d75A"
        cat67.tags = "猫,萌宠,动物圈"
        cat67.authorName = "瓜瓜皮和小小妹"
        cat67.cover =
            "https://i2.hdslb.com/bfs/archive/adac0c2782aaa0146081dc3d31d759271c9c19e8.jpg"
        list.add(cat67)

        val cat68 = PetVideo()
        cat68.type = VideoType.CAT.ordinal
        cat68.fileName = "cat_68"
        cat68.code = 1749
        cat68.duration = 224
        cat68.isStar = true
        cat68.title = "小喵喵生气气22.02.22"
        cat68.releaseTime = "2022-02-23 01:02:29"
        cat68.originalUrl = "https://www.bilibili.com/video/BV1hS4y1k79V"
        cat68.tags = "猫,萌宠,动物圈"
        cat68.authorName = "蕊儿绝版"
        cat68.cover =
            "https://i0.hdslb.com/bfs/archive/9a7b4a402264acb9aacc531efc421bd9d7d60eec.jpg"
        list.add(cat68)

        val cat69 = PetVideo()
        cat69.type = VideoType.CAT.ordinal
        cat69.fileName = "cat_69"
        cat69.code = 1750
        cat69.duration = 78
        cat69.isStar = true
        cat69.title = "猫妈妈辛苦了，一下子生了8只小奶猫，开始撸猫行动！"
        cat69.releaseTime = "2022-01-28 13:15:34"
        cat69.originalUrl = "https://www.bilibili.com/video/BV1sq4y1F7Cz"
        cat69.tags = "猫,萌宠,动物圈"
        cat69.authorName = "逗不豆儿"
        cat69.cover =
            "https://i2.hdslb.com/bfs/archive/2145c870b07519cda5c7b00b999bfbf74692c2ef.jpg"
        list.add(cat69)

        val cat70 = PetVideo()
        cat70.type = VideoType.CAT.ordinal
        cat70.fileName = "cat_70"
        cat70.code = 1751
        cat70.duration = 156
        cat70.isStar = true
        cat70.title = "奶猫：再来我真的不客气了"
        cat70.releaseTime = "2022-02-02 14:00:00"
        cat70.originalUrl = "https://www.bilibili.com/video/BV1qu41117Kv"
        cat70.tags = "猫,萌宠,动物圈"
        cat70.authorName = "伊琳娜的喵星球"
        cat70.cover =
            "https://i1.hdslb.com/bfs/archive/fc6b6cf4285719d13a2ef24746ece7f228322a22.jpg"
        list.add(cat70)

        val cat71 = PetVideo()
        cat71.type = VideoType.CAT.ordinal
        cat71.fileName = "cat_71"
        cat71.code = 1752
        cat71.duration = 157
        cat71.isStar = true
        cat71.title = "奶猫第一次见到爸爸：你闻，我是亲生的！"
        cat71.releaseTime = "2021-02-02 16:19:33"
        cat71.originalUrl = "https://www.bilibili.com/video/BV1HN411o7q7"
        cat71.tags = "猫,萌宠,动物圈"
        cat71.authorName = "伊琳娜的喵星球"
        cat71.cover =
            "https://i2.hdslb.com/bfs/archive/bbd305e227286d6da4e68f4518a101b4359949c0.jpg"
        list.add(cat71)

        val cat72 = PetVideo()
        cat72.type = VideoType.CAT.ordinal
        cat72.fileName = "cat_72"
        cat72.code = 1753
        cat72.duration = 119
        cat72.isStar = true
        cat72.title = "奶猫：快 给 我"
        cat72.releaseTime = "2022-02-16 18:10:42"
        cat72.originalUrl = "https://www.bilibili.com/video/BV1e5411o7Gn"
        cat72.tags = "猫,萌宠,动物圈"
        cat72.authorName = "伊琳娜的喵星球"
        cat72.cover =
            "https://i0.hdslb.com/bfs/archive/631807131d51d5520cfbce3e4572d46dce530182.jpg"
        list.add(cat72)

        val cat73 = PetVideo()
        cat73.type = VideoType.CAT.ordinal
        cat73.fileName = "cat_73"
        cat73.code = 1754
        cat73.duration = 143
        cat73.isStar = true
        cat73.title = "猫爸：爱就是想动手的时候忍住了..."
        cat73.releaseTime = "2022-02-18 17:47:56"
        cat73.originalUrl = "https://www.bilibili.com/video/BV1j44y1n7Rh"
        cat73.tags = "猫,萌宠,动物圈"
        cat73.authorName = "伊琳娜的喵星球"
        cat73.cover =
            "https://i0.hdslb.com/bfs/archive/fafbe21e1c148483226d41f1cbda0cb2996438a7.jpg"
        list.add(cat73)

        val cat74 = PetVideo()
        cat74.type = VideoType.CAT.ordinal
        cat74.fileName = "cat_74"
        cat74.code = 1755
        cat74.duration = 99
        cat74.isStar = true
        cat74.title = "小奶猫找不到妈妈，急哭了"
        cat74.releaseTime = "2021-01-16 20:18:16"
        cat74.originalUrl = "https://www.bilibili.com/video/BV1L5411H7DV"
        cat74.tags = "猫,萌宠,动物圈"
        cat74.authorName = "伊琳娜的喵星球"
        cat74.cover =
            "https://i2.hdslb.com/bfs/archive/b06d24ad53ca250f7ae6be8b28ec17adf11e10ca.jpg"
        list.add(cat74)

        val cat75 = PetVideo()
        cat75.type = VideoType.CAT.ordinal
        cat75.fileName = "cat_75"
        cat75.code = 1756
        cat75.duration = 111
        cat75.isStar = true
        cat75.title = "小小奶猫把奶猫当成了妈妈"
        cat75.releaseTime = "2021-05-27 18:56:07"
        cat75.originalUrl = "https://www.bilibili.com/video/BV1VK4y1V7qJ"
        cat75.tags = "猫,萌宠,动物圈"
        cat75.authorName = "伊琳娜的喵星球"
        cat75.cover =
            "https://i2.hdslb.com/bfs/archive/f2923f99406f4e7c7b7934fa8999ad848e523155.jpg"
        list.add(cat75)

        val cat76 = PetVideo()
        cat76.type = VideoType.CAT.ordinal
        cat76.fileName = "cat_76"
        cat76.code = 1757
        cat76.duration = 146
        cat76.isStar = true
        cat76.title = "当没满月的小奶猫跟我玩《石头剪刀布》"
        cat76.releaseTime = "2022-02-01 14:00:08"
        cat76.originalUrl = "https://www.bilibili.com/video/BV1yF411n7N7"
        cat76.tags = "猫,萌宠,动物圈"
        cat76.authorName = "伊琳娜的喵星球"
        cat76.cover =
            "https://i1.hdslb.com/bfs/archive/1e9d22677bcd3db0edd205e43bfde48947e4c523.jpg"
        list.add(cat76)

        val cat77 = PetVideo()
        cat77.type = VideoType.CAT.ordinal
        cat77.fileName = "cat_77"
        cat77.code = 1758
        cat77.duration = 120
        cat77.isStar = true
        cat77.title = "这只奶猫好像知道自己很可爱"
        cat77.releaseTime = "2022-02-09 17:24:05"
        cat77.originalUrl = "https://www.bilibili.com/video/BV1ER4y177EY"
        cat77.tags = "猫,萌宠,动物圈"
        cat77.authorName = "伊琳娜的喵星球"
        cat77.cover =
            "https://i2.hdslb.com/bfs/archive/99490a36714f524e775978033e2607c1ae8e9928.jpg"
        list.add(cat77)

        val cat78 = PetVideo()
        cat78.type = VideoType.CAT.ordinal
        cat78.fileName = "cat_78"
        cat78.code = 1759
        cat78.duration = 138
        cat78.isStar = true
        cat78.title = "亲子鉴定！小奶猫第一次见到爸爸"
        cat78.releaseTime = "2022-02-07 16:22:26"
        cat78.originalUrl = "https://www.bilibili.com/video/BV1z44y1W7Vn"
        cat78.tags = "猫,萌宠,动物圈"
        cat78.authorName = "伊琳娜的喵星球"
        cat78.cover =
            "https://i1.hdslb.com/bfs/archive/bc27282cd6489e520b4618c4fbc8ac21687a5ac2.jpg"
        list.add(cat78)

        val cat79 = PetVideo()
        cat79.type = VideoType.CAT.ordinal
        cat79.fileName = "cat_79"
        cat79.code = 1760
        cat79.duration = 113
        cat79.isStar = true
        cat79.title = "小奶猫委屈哭了"
        cat79.releaseTime = "2021-04-02 12:12:18"
        cat79.originalUrl = "https://www.bilibili.com/video/BV1nX4y1g77v"
        cat79.tags = "猫,萌宠,动物圈"
        cat79.authorName = "喵咪狗汪"
        cat79.cover =
            "https://i1.hdslb.com/bfs/archive/387290b7500ea39cfc0ba7c32f561fe1ad44f828.jpg"
        list.add(cat79)

        val cat80 = PetVideo()
        cat80.type = VideoType.CAT.ordinal
        cat80.fileName = "cat_80"
        cat80.code = 1761
        cat80.duration = 10
        cat80.isStar = true
        cat80.title = "小奶猫抢奶抢不过别人，还哭了"
        cat80.releaseTime = "2021-01-21 16:14:06"
        cat80.originalUrl = "https://www.bilibili.com/video/BV12U4y1474z"
        cat80.tags = "猫,萌宠,动物圈"
        cat80.authorName = "小白的铲屎官大人"
        cat80.cover =
            "https://i0.hdslb.com/bfs/archive/fc376acbfb03b668a777c738d4fb4ad6e516ebab.jpg"
        list.add(cat80)

        val cat81 = PetVideo()
        cat81.type = VideoType.CAT.ordinal
        cat81.fileName = "cat_81"
        cat81.code = 1762
        cat81.duration = 198
        cat81.isStar = true
        cat81.title = "猫爸发现孩子和自己颜色不同时"
        cat81.releaseTime = "2020-01-17 18:04:32"
        cat81.originalUrl = "https://www.bilibili.com/video/BV1vJ411E7XP"
        cat81.tags = "猫,萌宠,动物圈"
        cat81.authorName = "なえなの"
        cat81.cover =
            "https://i2.hdslb.com/bfs/archive/d94ee209ef1702df8fd885d27bf20bfd9b55d66f.jpg"
        list.add(cat81)

        val cat82 = PetVideo()
        cat82.type = VideoType.CAT.ordinal
        cat82.fileName = "cat_82"
        cat82.code = 1763
        cat82.duration = 179
        cat82.isStar = true
        cat82.title = "果然隔辈亲！小奶猫第一次见到爷爷"
        cat82.releaseTime = "2021-06-26 11:12:16"
        cat82.originalUrl = "https://www.bilibili.com/video/BV1oh41187gD"
        cat82.tags = "猫,萌宠,动物圈"
        cat82.authorName = "伊琳娜的喵星球"
        cat82.cover =
            "https://i1.hdslb.com/bfs/archive/96981c3f33b71292a0f46c291567e282f517c0a2.jpg"
        list.add(cat82)

        val cat83 = PetVideo()
        cat83.type = VideoType.CAT.ordinal
        cat83.fileName = "cat_83"
        cat83.code = 1764
        cat83.duration = 119
        cat83.isStar = true
        cat83.title = "一模一样！奶猫：你就是我爸？"
        cat83.releaseTime = "2022-02-15 15:55:40"
        cat83.originalUrl = "https://www.bilibili.com/video/BV1Lu411R7mq"
        cat83.tags = "猫,萌宠,动物圈"
        cat83.authorName = "伊琳娜的喵星球"
        cat83.cover =
            "https://i2.hdslb.com/bfs/archive/f8fe294c74933d1b65ca4b79dec0968016383073.jpg"
        list.add(cat83)

        val cat84 = PetVideo()
        cat84.type = VideoType.CAT.ordinal
        cat84.fileName = "cat_84"
        cat84.code = 1765
        cat84.duration = 165
        cat84.isStar = true
        cat84.title = "快看哪家动物园的兔狲跑出来了，趁他不注意拿麻袋套走。"
        cat84.releaseTime = "2021-12-17 15:25:37"
        cat84.originalUrl = "https://www.bilibili.com/video/BV1zS4y1Q732"
        cat84.tags = "猫,萌宠,动物圈"
        cat84.authorName = "爱遛弯的小八"
        cat84.cover =
            "https://i1.hdslb.com/bfs/archive/dfaa9217b10302a9010fc1d8a4d2aaf3a20907c9.jpg"
        list.add(cat84)

        val cat85 = PetVideo()
        cat85.type = VideoType.CAT.ordinal
        cat85.fileName = "cat_85"
        cat85.code = 1766
        cat85.duration = 66
        cat85.isStar = true
        cat85.title = "实话实说，我看上这条小尾巴了"
        cat85.releaseTime = "2021-12-15 19:38:46"
        cat85.originalUrl = "https://www.bilibili.com/video/BV1wS4y1Q7jr"
        cat85.tags = "猫,萌宠,动物圈"
        cat85.authorName = "一只大MiuMiu"
        cat85.cover =
            "https://i1.hdslb.com/bfs/archive/1f29843d1e91d09fa164d70184f89c7619ba22c3.jpg"
        list.add(cat85)

        val cat86 = PetVideo()
        cat86.type = VideoType.CAT.ordinal
        cat86.fileName = "cat_86"
        cat86.code = 1767
        cat86.duration = 171
        cat86.isStar = true
        cat86.title = "我就摸一下！当小鸡掉进了奶猫群"
        cat86.releaseTime = "2020-07-31 11:21:19"
        cat86.originalUrl = "https://www.bilibili.com/video/BV1Ca4y1E7sN"
        cat86.tags = "猫,萌宠,动物圈"
        cat86.authorName = "伊琳娜的喵星球"
        cat86.cover =
            "https://i1.hdslb.com/bfs/archive/03c32dc4b389d83ff457e87e759b7788d3258947.jpg"
        list.add(cat86)

        val cat87 = PetVideo()
        cat87.type = VideoType.CAT.ordinal
        cat87.fileName = "cat_87"
        cat87.code = 1768
        cat87.duration = 76
        cat87.isStar = true
        cat87.title = "这是一个奶气十足的视频请尽情食用"
        cat87.releaseTime = "2022-02-10 19:30:32"
        cat87.originalUrl = "https://www.bilibili.com/video/BV1sS4y1C7a4"
        cat87.tags = "猫,萌宠,动物圈"
        cat87.authorName = "谢吉文"
        cat87.cover =
            "https://i1.hdslb.com/bfs/archive/71fc44b81fd13efb2732e8974fece1359ca4d55a.jpg"
        list.add(cat87)


        return list
    }
}