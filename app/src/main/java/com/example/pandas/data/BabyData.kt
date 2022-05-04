package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object BabyData {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getPandaData()
        return list
    }

    private fun getPandaData(): MutableList<PetVideo> {
        val baby1 = PetVideo()
        baby1.type = VideoType.BABY.ordinal
        baby1.fileName = "baby_1"
        baby1.code = 1882
        baby1.duration = 60
        baby1.isStar = false
        baby1.title = "怎么不能呢 男童打疫苗与医生神对话"
        baby1.releaseTime = "2021-10-21 12:24:37"
        baby1.originalUrl = "https://www.bilibili.com/video/BV1tb4y1h7PB"
        baby1.tags = "人类宝宝"
        baby1.authorId = 2106730041
        baby1.cover =
            "https://i0.hdslb.com/bfs/archive/e4951e74e209fc52bf84964ccf3e0d0b69565a38.jpg"
        list.add(baby1)

        val baby2 = PetVideo()
        baby2.type = VideoType.BABY.ordinal
        baby2.fileName = "baby_2"
        baby2.code = 1883
        baby2.duration = 17
        baby2.isStar = false
        baby2.title = "付出了真情却收获了伤害"
        baby2.releaseTime = "2021-11-20 11:00:09"
        baby2.originalUrl = "https://www.bilibili.com/video/BV1uP4y1L7Vn"
        baby2.tags = "人类宝宝"
        baby2.authorId = 3107068
        baby2.cover =
            "https://i1.hdslb.com/bfs/archive/a0e8bf700deed595d381db6ab2b6d54b0471d41c.jpg"
        list.add(baby2)

        val baby3 = PetVideo()
        baby3.type = VideoType.BABY.ordinal
        baby3.fileName = "baby_3"
        baby3.code = 1884
        baby3.duration = 31
        baby3.isStar = true
        baby3.title = "萌娃为了吃奶狂飙演技“卖惨”，一个动作让网友直呼：嘴巴太有戏"
        baby3.releaseTime = "2022-03-08 11:46:44"
        baby3.originalUrl = "https://www.bilibili.com/video/BV1RL411N7zY"
        baby3.tags = "人类宝宝"
        baby3.authorId = 1984573756
        baby3.cover =
            "https://i0.hdslb.com/bfs/archive/bf0f8f7c8146f606112a623cf59643b5983b6a3c.jpg"
        list.add(baby3)

        val baby4 = PetVideo()
        baby4.type = VideoType.BABY.ordinal
        baby4.fileName = "baby_4"
        baby4.code = 1885
        baby4.duration = 148
        baby4.isStar = false
        baby4.title = "有趣的婴儿和兄弟姐妹"
        baby4.releaseTime = "2022-03-09 11:36:10"
        baby4.originalUrl = "https://www.bilibili.com/video/BV1JS4y1S7Wa"
        baby4.tags = "人类宝宝"
        baby4.authorId = 312245686
        baby4.cover =
            "https://i2.hdslb.com/bfs/archive/c69bcd5a776f331a32255cd11f97b3e993351ebf.jpg"
        list.add(baby4)

        val baby5 = PetVideo()
        baby5.type = VideoType.BABY.ordinal
        baby5.fileName = "baby_5"
        baby5.code = 1886
        baby5.duration = 65
        baby5.isStar = false
        baby5.title = "国外父亲费尽心机教萌娃喊爸爸，下秒人生第一句却乐翻妈咪"
        baby5.releaseTime = "2022-03-07 20:08:20"
        baby5.originalUrl = "https://www.bilibili.com/video/BV13S4y137J9"
        baby5.tags = "人类宝宝"
        baby5.authorId = 27120931
        baby5.cover =
            "https://i2.hdslb.com/bfs/archive/549c2ef23f27b6f1d05409f1b8287d8dd64123f6.jpg"
        list.add(baby5)

        val baby6 = PetVideo()
        baby6.type = VideoType.BABY.ordinal
        baby6.fileName = "baby_6"
        baby6.code = 1887
        baby6.duration = 393
        baby6.isStar = false
        baby6.title = "双胞胎婴儿为一切而战#2"
        baby6.releaseTime = "2022-02-18 13:45:02"
        baby6.originalUrl = "https://www.bilibili.com/video/BV1wr4y1r7Lq"
        baby6.tags = "人类宝宝"
        baby6.authorId = 312245686
        baby6.cover =
            "https://i1.hdslb.com/bfs/archive/12a2ee4b6664046ac3fbea3249997e8e1bd7d331.jpg"
        list.add(baby6)

        val baby7 = PetVideo()
        baby7.type = VideoType.BABY.ordinal
        baby7.fileName = "baby_7"
        baby7.code = 1888
        baby7.duration = 170
        baby7.isStar = false
        baby7.title = "猫咪一来就很黏女儿......"
        baby7.releaseTime = "2022-02-26 21:15:24"
        baby7.originalUrl = "https://www.bilibili.com/video/BV1dR4y1V7nH"
        baby7.tags = "人类宝宝"
        baby7.authorId = 549090612
        baby7.cover =
            "https://i0.hdslb.com/bfs/archive/27b68b6fb2cfe6996dabbab047de06c594393aae.jpg"
        list.add(baby7)

        val baby8 = PetVideo()
        baby8.type = VideoType.BABY.ordinal
        baby8.fileName = "baby_8"
        baby8.code = 1889
        baby8.duration = 166
        baby8.isStar = false
        baby8.title = "她做了我一直很想做的事情！"
        baby8.releaseTime = "2019-12-03 23:28:10"
        baby8.originalUrl = "https://www.bilibili.com/video/BV19J411q7Bv"
        baby8.tags = "人类宝宝"
        baby8.authorId = 179512321
        baby8.cover =
            "https://i1.hdslb.com/bfs/archive/51466d3cce4e53d55cb002bc702403a4c0137c63.jpg"
        list.add(baby8)

        val baby9 = PetVideo()
        baby9.type = VideoType.BABY.ordinal
        baby9.fileName = "baby_9"
        baby9.code = 1890
        baby9.duration = 133
        baby9.isStar = false
        baby9.title = "人类幼崽迷惑行为2"
        baby9.releaseTime = "2021-07-09 18:20:14"
        baby9.originalUrl = "https://www.bilibili.com/video/BV1qB4y1T7nZ"
        baby9.tags = "人类宝宝"
        baby9.authorId = 668149765
        baby9.cover =
            "https://i2.hdslb.com/bfs/archive/449223597111bd91f0a16ffdc98a168abebc83d5.jpg"
        list.add(baby9)

        val baby10 = PetVideo()
        baby10.type = VideoType.BABY.ordinal
        baby10.fileName = "baby_10"
        baby10.code = 1891
        baby10.duration = 51
        baby10.isStar = false
        baby10.title = "一时之间不知道哪一针更痛"
        baby10.releaseTime = "2021-08-05 17:00:12"
        baby10.originalUrl = "https://www.bilibili.com/video/BV1bq4y1p7Zh"
        baby10.tags = "人类宝宝"
        baby10.authorId = 3107068
        baby10.cover =
            "https://i1.hdslb.com/bfs/archive/eec0568e43c6b0f6b9df30b281ce06f555734446.jpg"
        list.add(baby10)

        val baby11 = PetVideo()
        baby11.type = VideoType.BABY.ordinal
        baby11.fileName = "baby_11"
        baby11.code = 1892
        baby11.duration = 163
        baby11.isStar = false
        baby11.title = "“打针！是人类幼崽躲不过的劫”"
        baby11.releaseTime = "2021-10-21 19:31:52"
        baby11.originalUrl = "https://www.bilibili.com/video/BV1jh411n7Kr"
        baby11.tags = "人类宝宝"
        baby11.authorId = 30738231
        baby11.cover =
            "https://i0.hdslb.com/bfs/archive/5bcb3cf7aec0e580053ccccd58636742e7e90ac1.jpg"
        list.add(baby11)

        val baby12 = PetVideo()
        baby12.type = VideoType.BABY.ordinal
        baby12.fileName = "baby_12"
        baby12.code = 1893
        baby12.duration = 211
        baby12.isStar = false
        baby12.title = "“这不叫打针，叫注入可爱”"
        baby12.releaseTime = "2021-11-09 19:15:01"
        baby12.originalUrl = "https://www.bilibili.com/video/BV1Cb4y187cd"
        baby12.tags = "人类宝宝"
        baby12.authorId = 668149765
        baby12.cover =
            "https://i0.hdslb.com/bfs/archive/dcf0f47d02004753c537c4df70132ac8ae3cdd02.jpg"
        list.add(baby12)

        val baby13 = PetVideo()
        baby13.type = VideoType.BABY.ordinal
        baby13.fileName = "baby_13"
        baby13.code = 1894
        baby13.duration = 129
        baby13.isStar = false
        baby13.title = "没有感情，全是技巧"
        baby13.releaseTime = "2022-02-14 19:15:10"
        baby13.originalUrl = "https://www.bilibili.com/video/BV1E34y1C7Ny"
        baby13.tags = "人类宝宝"
        baby13.authorId = 668149765
        baby13.cover =
            "https://i0.hdslb.com/bfs/archive/7227144b16a78b670737083bb53595c012bad41a.jpg"
        list.add(baby13)

        val baby14 = PetVideo()
        baby14.type = VideoType.BABY.ordinal
        baby14.fileName = "baby_14"
        baby14.code = 1895
        baby14.duration = 165
        baby14.isStar = false
        baby14.title = "当你以为娃睡着了，可以悄咪咪玩手机的时候……"
        baby14.releaseTime = "2022-02-26 19:15:08"
        baby14.originalUrl = "https://www.bilibili.com/video/BV11S4y1F7m6"
        baby14.tags = "人类宝宝"
        baby14.authorId = 668149765
        baby14.cover =
            "https://i1.hdslb.com/bfs/archive/41dc763ce36d5ef87d38c665889d04470a064638.jpg"
        list.add(baby14)

        val baby15 = PetVideo()
        baby15.type = VideoType.BABY.ordinal
        baby15.fileName = "baby_15"
        baby15.code = 1896
        baby15.duration = 149
        baby15.isStar = false
        baby15.title = "谁会拒绝一个会给你看花生的小可爱啊"
        baby15.releaseTime = "2022-02-22 18:43:39"
        baby15.originalUrl = "https://www.bilibili.com/video/BV1hL4y1G74X"
        baby15.tags = "人类宝宝"
        baby15.authorId = 668149765
        baby15.cover =
            "https://i2.hdslb.com/bfs/archive/dad679558ad695a822893bead27153682d1550ab.jpg"
        list.add(baby15)

        val baby16 = PetVideo()
        baby16.type = VideoType.BABY.ordinal
        baby16.fileName = "baby_16"
        baby16.code = 1897
        baby16.duration = 61
        baby16.isStar = true
        baby16.title = "【米莉】:我的宝宝和哈士奇从小就是最好的朋友，这个我能看一整天~"
        baby16.releaseTime = "2019-11-21 21:00:04"
        baby16.originalUrl = "https://www.bilibili.com/video/BV1pJ41127Hw"
        baby16.tags = "人类宝宝"
        baby16.authorId = 43296249
        baby16.cover =
            "https://i2.hdslb.com/bfs/archive/e01f536906869405d6116d1e062e079055bc5a2c.jpg"
        list.add(baby16)

        val baby17 = PetVideo()
        baby17.type = VideoType.BABY.ordinal
        baby17.fileName = "baby_17"
        baby17.code = 1898
        baby17.duration = 76
        baby17.isStar = false
        baby17.title = "最重要开心就好，忘记烦恼！"
        baby17.releaseTime = "2021-05-04 16:47:33"
        baby17.originalUrl = "https://www.bilibili.com/video/BV1dy4y1s7q5"
        baby17.tags = "人类宝宝"
        baby17.authorId = 30738231
        baby17.cover =
            "https://i1.hdslb.com/bfs/archive/a552a0279401566c884b251d32ea21aae8315797.jpg"
        list.add(baby17)

        val baby18 = PetVideo()
        baby18.type = VideoType.BABY.ordinal
        baby18.fileName = "baby_18"
        baby18.code = 1899
        baby18.duration = 130
        baby18.isStar = false
        baby18.title = "乖乖洗头的小朋友也太可爱了！Awsl～"
        baby18.releaseTime = "2021-04-13 17:37:49"
        baby18.originalUrl = "https://www.bilibili.com/video/BV1n5411c7Au"
        baby18.tags = "人类宝宝"
        baby18.authorId = 30738231
        baby18.cover =
            "https://i2.hdslb.com/bfs/archive/0324634a78fd9a3cc0b9544ef47cd72a798c625b.jpg"
        list.add(baby18)

        val baby19 = PetVideo()
        baby19.type = VideoType.BABY.ordinal
        baby19.fileName = "baby_19"
        baby19.code = 1900
        baby19.duration = 74
        baby19.isStar = false
        baby19.title = "胖乎乎的萌宝宝做facial是什么感觉，好像很享受呢"
        baby19.releaseTime = "2018-07-10 23:25:48"
        baby19.originalUrl = "https://www.bilibili.com/video/BV11s411p77Y"
        baby19.tags = "人类宝宝"
        baby19.authorId = 346324250
        baby19.cover =
            "https://i2.hdslb.com/bfs/archive/f525c4018ee0ba1c9078c789d40e77ab4b2a4880.jpg"
        list.add(baby19)

        val baby20 = PetVideo()
        baby20.type = VideoType.BABY.ordinal
        baby20.fileName = "baby_20"
        baby20.code = 1901
        baby20.duration = 46
        baby20.isStar = false
        baby20.title = "宝爸给宝宝按摩 萌化了"
        baby20.releaseTime = "2019-12-27 13:50:59"
        baby20.originalUrl = "https://www.bilibili.com/video/BV1zJ411Y7Wv"
        baby20.tags = "人类宝宝"
        baby20.authorId = 404842697
        baby20.cover =
            "https://i0.hdslb.com/bfs/archive/fc74642fca01b256c0590258809bb7c7e7f53638.jpg"
        list.add(baby20)

        val baby21 = PetVideo()
        baby21.type = VideoType.BABY.ordinal
        baby21.fileName = "baby_21"
        baby21.code = 1902
        baby21.duration = 333
        baby21.isStar = false
        baby21.title = "有趣的婴儿和动物"
        baby21.releaseTime = "2022-03-07 03:51:28"
        baby21.originalUrl = "https://www.bilibili.com/video/BV1zb4y1W7Ad"
        baby21.tags = "人类宝宝"
        baby21.authorId = 312245686
        baby21.cover =
            "https://i1.hdslb.com/bfs/archive/e0ca3994b2cbbf8036a2c514f0d5df4ece8cdc63.jpg"
        list.add(baby21)

        val baby22 = PetVideo()
        baby22.type = VideoType.BABY.ordinal
        baby22.fileName = "baby_22"
        baby22.code = 1903
        baby22.duration = 20
        baby22.isStar = false
        baby22.title = "小宝宝在睡梦中叫“妈妈”，听到这个小奶音心都化了~"
        baby22.releaseTime = "2021-07-01 00:32:01"
        baby22.originalUrl = "https://www.bilibili.com/video/BV1wV411W7xH"
        baby22.tags = "人类宝宝"
        baby22.authorId = 412719797
        baby22.cover =
            "https://i1.hdslb.com/bfs/archive/7fcb1e5bd9e645dbff796989cb7c515d33d2842d.jpg"
        list.add(baby22)

        val baby23 = PetVideo()
        baby23.type = VideoType.BABY.ordinal
        baby23.fileName = "baby_23"
        baby23.code = 1904
        baby23.duration = 67
        baby23.isStar = false
        baby23.title = "当爸爸带孩子的时候"
        baby23.releaseTime = "2019-05-06 00:24:00"
        baby23.originalUrl = "https://www.bilibili.com/video/BV1U4411i7NB"
        baby23.tags = "人类宝宝"
        baby23.authorId = 329057504
        baby23.cover =
            "https://i2.hdslb.com/bfs/archive/b3c1b1c40b826f8b49e12dbfa3e380054698b0cb.jpg"
        list.add(baby23)

        val baby24 = PetVideo()
        baby24.type = VideoType.BABY.ordinal
        baby24.fileName = "baby_24"
        baby24.code = 1905
        baby24.duration = 54
        baby24.isStar = false
        baby24.title = "请接受一岁三个月人类幼崽的中英文表白"
        baby24.releaseTime = "2021-10-12 11:02:40"
        baby24.originalUrl = "https://www.bilibili.com/video/BV1AR4y1J7PR"
        baby24.tags = "人类宝宝"
        baby24.authorId = 57289248
        baby24.cover =
            "https://i1.hdslb.com/bfs/archive/85e03f24410110453e66d38c3c65cb5a3b00e759.jpg"
        list.add(baby24)

        val baby25 = PetVideo()
        baby25.type = VideoType.BABY.ordinal
        baby25.fileName = "baby_25"
        baby25.code = 1906
        baby25.duration = 9
        baby25.isStar = true
        baby25.title = "原来俄罗斯的弹舌从小就会"
        baby25.releaseTime = "2020-02-11 20:59:53"
        baby25.originalUrl = "https://www.bilibili.com/video/BV1X741157we"
        baby25.tags = "人类宝宝"
        baby25.authorId = 28128780
        baby25.cover =
            "https://i1.hdslb.com/bfs/archive/3ff9843ac7c088c541d56b7f1fb642486651b7da.jpg"
        list.add(baby25)

        val baby26 = PetVideo()
        baby26.type = VideoType.BABY.ordinal
        baby26.fileName = "baby_26"
        baby26.code = 1907
        baby26.duration = 54
        baby26.isStar = false
        baby26.title = "小女孩用婴语和爸妈吵架_(1)"
        baby26.releaseTime = "2020-04-28 15:50:04"
        baby26.originalUrl = "https://www.bilibili.com/video/BV14K411578r"
        baby26.tags = "人类宝宝"
        baby26.authorId = 62974251
        baby26.cover =
            "https://i0.hdslb.com/bfs/archive/511d02fbc6b43cc9d14e5b4f1050e2a1929a1c8c.jpg"
        list.add(baby26)

        val baby27 = PetVideo()
        baby27.type = VideoType.BABY.ordinal
        baby27.fileName = "baby_27"
        baby27.code = 1908
        baby27.duration = 112
        baby27.isStar = false
        baby27.title = "德国小女孩生爸爸的气 吵架气势汹汹 【中德字幕】"
        baby27.releaseTime = "2022-02-12 12:39:19"
        baby27.originalUrl = "https://www.bilibili.com/video/BV17T4y1X79w"
        baby27.tags = "人类宝宝"
        baby27.authorId = 17597722
        baby27.cover =
            "https://i0.hdslb.com/bfs/archive/3d148e76b6df630d932c681c50b0eb2438ba62c4.jpg"
        list.add(baby27)

        val baby28 = PetVideo()
        baby28.type = VideoType.BABY.ordinal
        baby28.fileName = "baby_28"
        baby28.code = 1909
        baby28.duration = 59
        baby28.isStar = false
        baby28.title = "国外老爸是怎样让自己女儿尴尬的，哈哈哈"
        baby28.releaseTime = "2021-03-19 18:46:17"
        baby28.originalUrl = "https://www.bilibili.com/video/BV1tv411a7go"
        baby28.tags = "人类宝宝"
        baby28.authorId = 382189062
        baby28.cover =
            "https://i1.hdslb.com/bfs/archive/cf21853e98dfcd06ba90ec37b7ef3b39a734095c.jpg"
        list.add(baby28)

        val baby29 = PetVideo()
        baby29.type = VideoType.BABY.ordinal
        baby29.fileName = "baby_29"
        baby29.code = 1910
        baby29.duration = 82
        baby29.isStar = false
        baby29.title = "“人类幼崽的可爱是会传染的”"
        baby29.releaseTime = "2022-01-19 21:42:18"
        baby29.originalUrl = "https://www.bilibili.com/video/BV1fR4y1M7gH"
        baby29.tags = "人类宝宝"
        baby29.authorId = 30738231
        baby29.cover =
            "https://i1.hdslb.com/bfs/archive/1ff39e97b4b1874751adabf779b84f161be79a55.jpg"
        list.add(baby29)

        val baby30 = PetVideo()
        baby30.type = VideoType.BABY.ordinal
        baby30.fileName = "baby_30"
        baby30.code = 1911
        baby30.duration = 138
        baby30.isStar = false
        baby30.title = "“又有什么比人类幼崽更可爱的呢”"
        baby30.releaseTime = "2022-02-03 22:47:36"
        baby30.originalUrl = "https://www.bilibili.com/video/BV1zF411J7xB"
        baby30.tags = "人类宝宝"
        baby30.authorId = 30738231
        baby30.cover =
            "https://i2.hdslb.com/bfs/archive/28beae44044f843dc5b3ac86bf672cb2d1b3fef4.jpg"
        list.add(baby30)

        val baby31 = PetVideo()
        baby31.type = VideoType.BABY.ordinal
        baby31.fileName = "baby_31"
        baby31.code = 1912
        baby31.duration = 150
        baby31.isStar = false
        baby31.title = "“人类幼崽可爱指南”"
        baby31.releaseTime = "2022-02-06 22:08:00"
        baby31.originalUrl = "https://www.bilibili.com/video/BV1Si4y1Z7nG"
        baby31.tags = "人类宝宝"
        baby31.authorId = 30738231
        baby31.cover =
            "https://i1.hdslb.com/bfs/archive/1e75db27be67008b08a7f0fea3f7e2fdacb5f3c4.jpg"
        list.add(baby31)

        val baby32 = PetVideo()
        baby32.type = VideoType.BABY.ordinal
        baby32.fileName = "baby_32"
        baby32.code = 1913
        baby32.duration = 154
        baby32.isStar = false
        baby32.title = "奶爸一坐下宝宝就哭，要怎么解决这个难题呢？"
        baby32.releaseTime = "2021-01-17 13:31:11"
        baby32.originalUrl = "https://www.bilibili.com/video/BV1rA411H7zi"
        baby32.tags = "人类宝宝"
        baby32.authorId = 412719797
        baby32.cover =
            "https://i1.hdslb.com/bfs/archive/408e451b135db0fe5bd744a4be4a50c9746cb2d2.jpg"
        list.add(baby32)

        val baby33 = PetVideo()
        baby33.type = VideoType.BABY.ordinal
        baby33.fileName = "baby_33"
        baby33.code = 1914
        baby33.duration = 22
        baby33.isStar = false
        baby33.title = "一岁宝宝听到叔叔BBOX后的反应~~超萌"
        baby33.releaseTime = "2014-07-24 17:50:45"
        baby33.originalUrl = "https://www.bilibili.com/video/BV1hx411N7ri"
        baby33.tags = "人类宝宝"
        baby33.authorId = 2278338
        baby33.cover =
            "https://i0.hdslb.com/bfs/archive/07ea057bb9bc0cd764d43cd8787bbce85963cf72.jpg"
        list.add(baby33)

        val baby34 = PetVideo()
        baby34.type = VideoType.BABY.ordinal
        baby34.fileName = "baby_34"
        baby34.code = 1915
        baby34.duration = 27
        baby34.isStar = false
        baby34.title = "外國小男孩體檢 每天两遍身心舒适"
        baby34.releaseTime = "2020-04-10 20:38:40"
        baby34.originalUrl = "https://www.bilibili.com/video/BV1H5411t7KE"
        baby34.tags = "人类宝宝"
        baby34.authorId = 103384117
        baby34.cover =
            "https://i0.hdslb.com/bfs/archive/7b11ddfa67727779904e3feb473515d4b57ebbf8.jpg"
        list.add(baby34)

        return list
    }
}