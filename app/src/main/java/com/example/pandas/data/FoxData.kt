package com.example.pandas.data

import com.example.pandas.bean.pet.PetType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object FoxData {

    private var list = mutableListOf<PetVideo>()

    fun getFoxData(): MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = PetType.FOX.ordinal
        panda1.fileName = "pet_fox1"
        panda1.code = 432
        panda1.duration = 73
        panda1.period = PeriodType.SINGLE.ordinal
        panda1.isStar = true
        panda1.title = "有 些 事 ， 真 不 能 怪 纣 王"
        panda1.releaseTime = "2021-05-24 18:07:20"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1Gq4y1j7d5"
        panda1.tags = "狐,萌宠,动物圈"
        panda1.authorName = "力度PowerC"
        panda1.cover =
            "http://i0.hdslb.com/bfs/archive/234ca476f500eaeb386e6ba95d32277a4a7df60b.jpg"
        panda1.videoType = 0
        list.add(panda1)


        val panda2 = PetVideo()
        panda2.type = PetType.FOX.ordinal
        panda2.fileName = "pet_fox2"
        panda2.code = 433
        panda2.duration = 118
        panda2.period = PeriodType.SINGLE.ordinal
        panda2.isStar = true
        panda2.title = "【北极狐】请叫我盛世美颜的雪原精灵"
        panda2.releaseTime = "2019-09-22 20:30:24"
        panda2.originalUrl = "https://www.bilibili.com/video/BV16J411g7ys"
        panda2.tags = "狐,萌宠,动物圈"
        panda2.authorName = "肉山大魔王酱酱菌"
        panda2.cover =
            "http://i2.hdslb.com/bfs/archive/0215a036e2d26af6b9e0f13e92556db4be0ded93.jpg"
        panda2.videoType = 0
        list.add(panda2)


        val panda3 = PetVideo()
        panda3.type = PetType.FOX.ordinal
        panda3.fileName = "pet_fox3"
        panda3.code = 434
        panda3.duration = 29
        panda3.period = PeriodType.SINGLE.ordinal
        panda3.isStar = true
        panda3.title = "雪 中 狐 仙"
        panda3.releaseTime = "2022-01-12 19:13:59"
        panda3.originalUrl = "https://www.bilibili.com/video/BV12q4y1w7Lu"
        panda3.tags = "狐,萌宠,动物圈"
        panda3.authorName = "探纪自然"
        panda3.cover =
            "http://i1.hdslb.com/bfs/archive/ab79a89823f227574f663269a6e86667cb8b7510.jpg"
        panda3.videoType = 0
        list.add(panda3)


        val panda4 = PetVideo()
        panda4.type = PetType.FOX.ordinal
        panda4.fileName = "pet_fox4"
        panda4.code = 435
        panda4.duration = 127
        panda4.period = PeriodType.SINGLE.ordinal
        panda4.isStar = true
        panda4.title = "[混剪][北极狐]北极精灵——独属冰原的极致可爱与美丽"
        panda4.releaseTime = "2020-03-16 01:17:25"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1fE411373z"
        panda4.tags = "狐,萌宠,动物圈"
        panda4.authorName = "GreedEzio"
        panda4.cover =
            "http://i1.hdslb.com/bfs/archive/30b259a24c170e6e27d9eeb315cce28345cec181.jpg"
        panda4.videoType = 0
        list.add(panda4)


        val panda5 = PetVideo()
        panda5.type = PetType.FOX.ordinal
        panda5.fileName = "pet_fox5"
        panda5.code = 436
        panda5.duration = 268
        panda5.period = PeriodType.SINGLE.ordinal
        panda5.isStar = true
        panda5.title = "【4K,60fps】🐺🦊北极雪狐"
        panda5.releaseTime = "2020-07-21 16:01:01"
        panda5.originalUrl = "https://www.bilibili.com/video/BV12h411o7hT"
        panda5.tags = "狐,萌宠,动物圈"
        panda5.authorName = "4K看地球"
        panda5.cover =
            "http://i1.hdslb.com/bfs/archive/1b869e4b839145968304aeafb64042c219058fbf.png"
        panda5.videoType = 0
        list.add(panda5)


        val panda6 = PetVideo()
        panda6.type = PetType.FOX.ordinal
        panda6.fileName = "pet_fox6"
        panda6.code = 437
        panda6.duration = 245
        panda6.period = PeriodType.SINGLE.ordinal
        panda6.isStar = true
        panda6.title = "雪地里的赤狐 毛茸茸的看着真像个小妖精"
        panda6.releaseTime = "2019-07-17 18:13:59"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1bt411g7uE"
        panda6.tags = "狐,萌宠,动物圈"
        panda6.authorName = "远东北亚巨虎"
        panda6.cover =
            "http://i0.hdslb.com/bfs/archive/c917011116fbe1dda527e580532b639514c47899.jpg"
        panda6.videoType = 0
        list.add(panda6)


        val panda7 = PetVideo()
        panda7.type = PetType.FOX.ordinal
        panda7.fileName = "pet_fox7"
        panda7.code = 438
        panda7.duration = 57
        panda7.period = PeriodType.SINGLE.ordinal
        panda7.isStar = true
        panda7.title = "小狐狸撒娇嘤嘤嘤~ 好像是白金狐？"
        panda7.releaseTime = "2021-12-21 16:15:47"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1dS4y1Q7NH"
        panda7.tags = "狐,萌宠,动物圈"
        panda7.authorName = "天天的茶叶"
        panda7.cover =
            "http://i0.hdslb.com/bfs/archive/ec7d418f4165f5175a159285d4f5d5339eb851b7.jpg"
        panda7.videoType = 0
        list.add(panda7)


        val panda8 = PetVideo()
        panda8.type = PetType.FOX.ordinal
        panda8.fileName = "pet_fox8"
        panda8.code = 439
        panda8.duration = 52
        panda8.period = PeriodType.SINGLE.ordinal
        panda8.isStar = true
        panda8.title = "雪中最美，仙狐公主"
        panda8.releaseTime = "2022-01-23 15:58:28"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Sr4y1e7Ak"
        panda8.tags = "狐,萌宠,动物圈"
        panda8.authorName = "探纪自然"
        panda8.cover =
            "http://i0.hdslb.com/bfs/archive/85dcd1eb4c32ea12d64e7a8db4b42a58743151fd.jpg"
        panda8.videoType = 0
        list.add(panda8)


        val panda9 = PetVideo()
        panda9.type = PetType.FOX.ordinal
        panda9.fileName = "pet_fox9"
        panda9.code = 440
        panda9.duration = 4369
        panda9.period = PeriodType.SINGLE.ordinal
        panda9.isStar = true
        panda9.title = "【4K】❄️🐺🦊冬天里的北极狐和狼-放松冥想背景音乐-1小时"
        panda9.releaseTime = "2020-08-08 11:00:46"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1Tv411i7Tx"
        panda9.tags = "狐,萌宠,动物圈"
        panda9.authorName = "4K看地球"
        panda9.cover =
            "http://i1.hdslb.com/bfs/archive/275b34cc904dcb65814cd90c2f7bc98415456183.jpg"
        panda9.videoType = 0
        list.add(panda9)


        val panda10 = PetVideo()
        panda10.type = PetType.FOX.ordinal
        panda10.fileName = "pet_fox10"
        panda10.code = 441
        panda10.duration = 99
        panda10.period = PeriodType.SINGLE.ordinal
        panda10.isStar = true
        panda10.title = "狐狸叫声集锦【三】uuuuuu"
        panda10.releaseTime = "2021-12-30 01:16:12"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1ka411B7Vg"
        panda10.tags = "狐,萌宠,动物圈"
        panda10.authorName = "狐狸社社长乱狐"
        panda10.cover =
            "http://i0.hdslb.com/bfs/archive/cbad79065d7fded5a3d296fe2dfa0eff44a54f1e.jpg"
        panda10.videoType = 0
        list.add(panda10)


        val panda11 = PetVideo()
        panda11.type = PetType.FOX.ordinal
        panda11.fileName = "pet_fox11"
        panda11.code = 442
        panda11.duration = 37
        panda11.period = PeriodType.SINGLE.ordinal
        panda11.isStar = true
        panda11.title = "最 美 狐仙"
        panda11.releaseTime = "2022-01-09 13:35:30"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1844y157gA"
        panda11.tags = "狐,萌宠,动物圈"
        panda11.authorName = "探纪自然"
        panda11.cover =
            "http://i0.hdslb.com/bfs/archive/213435510f2714c4e42323a2ae1111e9e7a27898.jpg"
        panda11.videoType = 0
        list.add(panda11)


        val panda12 = PetVideo()
        panda12.type = PetType.FOX.ordinal
        panda12.fileName = "pet_fox12"
        panda12.code = 443
        panda12.duration = 30
        panda12.period = PeriodType.SINGLE.ordinal
        panda12.isStar = true
        panda12.title = "第一次玩雪的雪狐！"
        panda12.releaseTime = "2021-12-28 18:26:17"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1Ua411678K"
        panda12.tags = "狐,萌宠,动物圈"
        panda12.authorName = "谁家丢了只狐狸"
        panda12.cover =
            "http://i0.hdslb.com/bfs/archive/f211ff7de227f7fcee9aa997cd15bf783f7a9942.jpg"
        panda12.videoType = 0
        list.add(panda12)


        val panda13 = PetVideo()
        panda13.type = PetType.FOX.ordinal
        panda13.fileName = "pet_fox13"
        panda13.code = 444
        panda13.duration = 29
        panda13.period = PeriodType.SINGLE.ordinal
        panda13.isStar = true
        panda13.title = "狐狸村的吵架日常，猜猜最后谁赢了？"
        panda13.releaseTime = "2022-01-04 21:28:06"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1wr4y1v7wm"
        panda13.tags = "狐,萌宠,动物圈"
        panda13.authorName = "天天的茶叶"
        panda13.cover =
            "http://i2.hdslb.com/bfs/archive/ee69b6c14b97fd00c65faeb392eacacb94906cd9.jpg"
        panda13.videoType = 0
        list.add(panda13)


        val panda14 = PetVideo()
        panda14.type = PetType.FOX.ordinal
        panda14.fileName = "pet_fox14"
        panda14.code = 445
        panda14.duration = 22
        panda14.period = PeriodType.SINGLE.ordinal
        panda14.isStar = true
        panda14.title = "你喜欢萝莉还是大魔头？"
        panda14.releaseTime = "2021-11-26 19:04:28"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1vq4y1B79x"
        panda14.tags = "狐,萌宠,动物圈"
        panda14.authorName = "长白山老万"
        panda14.cover =
            "http://i1.hdslb.com/bfs/archive/af90279722702e740d77d1c6b071ae594750d539.jpg"
        panda14.videoType = 0
        list.add(panda14)


        val panda15 = PetVideo()
        panda15.type = PetType.FOX.ordinal
        panda15.fileName = "pet_fox15"
        panda15.code = 446
        panda15.duration = 121
        panda15.period = PeriodType.SINGLE.ordinal
        panda15.isStar = true
        panda15.title = "-20℃密林深处，拍摄到了野生紫貂，太可爱了！"
        panda15.releaseTime = "2021-11-19 18:06:49"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1i3411t7vt"
        panda15.tags = "狐,萌宠,动物圈"
        panda15.authorName = "长白山老万"
        panda15.cover =
            "http://i2.hdslb.com/bfs/archive/3fe6af2b710b04daf5ed2f1b3fdf7c172da8218e.jpg"
        panda15.videoType = 0
        list.add(panda15)


        val panda16 = PetVideo()
        panda16.type = PetType.FOX.ordinal
        panda16.fileName = "pet_fox16"
        panda16.code = 447
        panda16.duration = 110
        panda16.period = PeriodType.SINGLE.ordinal
        panda16.isStar = true
        panda16.title = "北极狐：长成这样的北极狐你见过吗"
        panda16.releaseTime = "2021-12-13 18:00:15"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1oZ4y197cq"
        panda16.tags = "狐,萌宠,动物圈"
        panda16.authorName = "嗑叔磕动物"
        panda16.cover =
            "http://i2.hdslb.com/bfs/archive/773d0f3854e3dc28604649b26e83e1acae6e1e4a.jpg"
        panda16.videoType = 0
        list.add(panda16)


        val panda17 = PetVideo()
        panda17.type = PetType.FOX.ordinal
        panda17.fileName = "pet_fox17"
        panda17.code = 448
        panda17.duration = 116
        panda17.period = PeriodType.SINGLE.ordinal
        panda17.isStar = true
        panda17.title = "动物圈的问号脸 第二季"
        panda17.releaseTime = "2021-12-24 19:00:01"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1oS4y1D7AS"
        panda17.tags = "狐,萌宠,动物圈"
        panda17.authorName = ""
        panda17.cover =
            "http://i0.hdslb.com/bfs/archive/cad2540f119b3298f9fc942ee138afc71e874961.jpg"
        panda17.videoType = 0
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = PetType.FOX.ordinal
        panda18.fileName = "pet_fox18"
        panda18.code = 449
        panda18.duration = 136
        panda18.period = PeriodType.SINGLE.ordinal
        panda18.isStar = true
        panda18.title = "传说中狡猾的狐狸——赤狐，居然会如此安静！"
        panda18.releaseTime = "2021-10-08 19:48:09"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1JQ4y1B7qv"
        panda18.tags = "狐,萌宠,动物圈"
        panda18.authorName = "探纪自然"
        panda18.cover =
            "http://i0.hdslb.com/bfs/archive/4f106ec17ba2902005fd0192ee8ac7cf8c5c408b.jpg"
        panda18.videoType = 0
        list.add(panda18)

        return list
    }
}