package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/8/22 7:16 下午
 * @version: v1.0
 */
object MultiVideoData {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getRecoBanner() //4
        getFoxData() //31
        getLandScapeData() //56
        getPandaKnowledge() //39
        getPenguinData() //18
        getbearData() // 42
        getMonkey() //32
        getRedPanda() //87
        return list
    }

    private fun getRecoBanner(): MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = VideoType.PANDA.ordinal
        panda1.fileName = "video_banner1"
        panda1.code = 423
        panda1.duration = 61
        panda1.star = false
        panda1.period = PeriodType.BABY.ordinal
        panda1.title = "毛茸茸的小可爱谁不想拥有一只"
        panda1.releaseTime = 1640602812
        panda1.originalUrl = "https://www.bilibili.com/video/BV1bL4y1E7L8"
        panda1.tags = "熊猫,冰雪"
        panda1.authorId = 565388139
        panda1.videoType = 1
        panda1.cover =
            "https://i1.hdslb.com/bfs/archive/8c551b4ec8aad66ddafc523dbef16b180b85d27d.jpg"
        panda1.hot = false
        panda1.vertical = false
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = VideoType.CHINA.ordinal
        panda2.fileName = "video_banner2"
        panda2.code = 424
        panda2.duration = 59
        panda2.videoType = 1
        panda2.star = false
        panda2.period = PeriodType.BABY.ordinal
        panda2.title = "今天，雪中的橘子洲头"
        panda2.releaseTime = 1640530372
        panda2.originalUrl = "https://www.bilibili.com/video/BV1v3411v7Hi"
        panda2.tags = "中国,湖南,橘子洲头,雪"
        panda2.authorId = 324473490
        panda2.cover =
            "https://i2.hdslb.com/bfs/archive/96ab6c6fc7474a67de916c75397161fcc9297095.jpg"
        panda2.hot = false
        panda2.vertical = false
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = VideoType.PANDA.ordinal
        panda3.fileName = "video_banner3"
        panda3.code = 425
        panda3.duration = 86
        panda3.videoType = 1
        panda3.star = false
        panda3.period = PeriodType.BABY.ordinal
        panda3.title = "冬奥味儿的神仙年画：如果关公会滑雪"
        panda3.releaseTime = 1643103070
        panda3.originalUrl = "https://www.bilibili.com/video/BV1HL411F7J8"
        panda3.tags = "年画画年,最农记忆,冬奥"
        panda3.authorId = 1343321779
        panda3.cover =
            "https://i1.hdslb.com/bfs/archive/7dc1b9731969d1e1b4d492d51efbfe51f3e310ca.jpg"
        panda3.hot = false
        panda3.vertical = false
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = VideoType.BEAUTY.ordinal
        panda4.fileName = "video_banner4"
        panda4.videoType = 1
        panda4.code = 426
        panda4.duration = 62
        panda4.star = false
        panda4.period = PeriodType.BABY.ordinal
        panda4.title = "飞天的四月，无人机视角"
        panda4.releaseTime = 1638335982
        panda4.originalUrl = "https://www.bilibili.com/video/BV1v44y1h7jw"
        panda4.tags = "四月,飞天"
        panda4.authorId = 443447892
        panda4.cover =
            "https://i0.hdslb.com/bfs/archive/21dc90239bd1e237ef080604e7295dc9a59088be.jpg"
        panda4.hot = false
        panda4.vertical = false
        list.add(panda4)

        return list
    }

    private fun getFoxData(): MutableList<PetVideo> {

        val fox1 = PetVideo()
        fox1.type = VideoType.FOX.ordinal
        fox1.fileName = "pet_fox1"
        fox1.code = 432
        fox1.duration = 73
        fox1.star = true
        fox1.title = "有 些 事 ， 真 不 能 怪 纣 王"
        fox1.releaseTime = 1621850840
        fox1.originalUrl = "https://www.bilibili.com/video/BV1Gq4y1j7d5"
        fox1.tags = "狐,萌宠,动物圈"
        fox1.authorId = 24751035
        fox1.cover = "https://i0.hdslb.com/bfs/archive/234ca476f500eaeb386e6ba95d32277a4a7df60b.jpg"
        fox1.vertical = false
        list.add(fox1)

        val fox2 = PetVideo()
        fox2.type = VideoType.FOX.ordinal
        fox2.fileName = "pet_fox2"
        fox2.code = 433
        fox2.duration = 118
        fox2.star = true
        fox2.title = "【北极狐】请叫我盛世美颜的雪原精灵"
        fox2.releaseTime = 1569155424
        fox2.originalUrl = "https://www.bilibili.com/video/BV16J411g7ys"
        fox2.tags = "狐,萌宠,动物圈"
        fox2.authorId = 814507
        fox2.cover = "https://i2.hdslb.com/bfs/archive/0215a036e2d26af6b9e0f13e92556db4be0ded93.jpg"
        fox2.vertical = false
        list.add(fox2)

        val fox5 = PetVideo()
        fox5.type = VideoType.FOX.ordinal
        fox5.fileName = "pet_fox5"
        fox5.code = 436
        fox5.duration = 268
        fox5.star = true
        fox5.title = "【4K,60fps】🐺🦊北极雪狐"
        fox5.releaseTime = 1595318461
        fox5.originalUrl = "https://www.bilibili.com/video/BV12h411o7hT"
        fox5.tags = "狐,萌宠,动物圈"
        fox5.authorId = 68057278
        fox5.cover = "https://i1.hdslb.com/bfs/archive/1b869e4b839145968304aeafb64042c219058fbf.png"
        fox5.vertical = false
        list.add(fox5)

        val fox6 = PetVideo()
        fox6.type = VideoType.FOX.ordinal
        fox6.fileName = "pet_fox6"
        fox6.code = 437
        fox6.duration = 245
        fox6.star = true
        fox6.title = "雪地里的赤狐 毛茸茸的看着真像个小妖精"
        fox6.releaseTime = 1563358439
        fox6.originalUrl = "https://www.bilibili.com/video/BV1bt411g7uE"
        fox6.tags = "狐,萌宠,动物圈"
        fox6.authorId = 28273053
        fox6.cover = "https://i0.hdslb.com/bfs/archive/c917011116fbe1dda527e580532b639514c47899.jpg"
        fox6.vertical = false
        list.add(fox6)

        val fox7 = PetVideo()
        fox7.type = VideoType.FOX.ordinal
        fox7.fileName = "pet_fox7"
        fox7.code = 438
        fox7.duration = 57
        fox7.star = true
        fox7.title = "小狐狸撒娇嘤嘤嘤~ 好像是白金狐？"
        fox7.releaseTime = 1640074547
        fox7.originalUrl = "https://www.bilibili.com/video/BV1dS4y1Q7NH"
        fox7.tags = "狐,萌宠,动物圈"
        fox7.authorId = 24272038
        fox7.cover = "https://i0.hdslb.com/bfs/archive/ec7d418f4165f5175a159285d4f5d5339eb851b7.jpg"
        fox7.vertical = false
        list.add(fox7)

        val fox8 = PetVideo()
        fox8.type = VideoType.FOX.ordinal
        fox8.fileName = "pet_fox8"
        fox8.code = 439
        fox8.duration = 52
        fox8.star = true
        fox8.title = "雪中最美，仙狐公主"
        fox8.releaseTime = 1642924708
        fox8.originalUrl = "https://www.bilibili.com/video/BV1Sr4y1e7Ak"
        fox8.tags = "狐,萌宠,动物圈"
        fox8.authorId = 282239993
        fox8.cover = "https://i0.hdslb.com/bfs/archive/85dcd1eb4c32ea12d64e7a8db4b42a58743151fd.jpg"
        fox8.vertical = true
        list.add(fox8)

        val fox9 = PetVideo()
        fox9.type = VideoType.FOX.ordinal
        fox9.fileName = "pet_fox9"
        fox9.code = 441
        fox9.duration = 99
        fox9.star = true
        fox9.title = "狐狸叫声集锦【三】uuuuuu"
        fox9.releaseTime = 1640798172
        fox9.originalUrl = "https://www.bilibili.com/video/BV1ka411B7Vg"
        fox9.tags = "狐,萌宠,动物圈"
        fox9.authorId = 28426235
        fox9.cover = "https://i0.hdslb.com/bfs/archive/cbad79065d7fded5a3d296fe2dfa0eff44a54f1e.jpg"
        fox9.vertical = false
        list.add(fox9)

        val fox11 = PetVideo()
        fox11.type = VideoType.FOX.ordinal
        fox11.fileName = "pet_fox11"
        fox11.code = 443
        fox11.duration = 30
        fox11.star = true
        fox11.title = "第一次玩雪的雪狐！"
        fox11.releaseTime = 1640687177
        fox11.originalUrl = "https://www.bilibili.com/video/BV1Ua411678K"
        fox11.tags = "狐,萌宠,动物圈"
        fox11.authorId = 55370504
        fox11.cover =
            "https://i0.hdslb.com/bfs/archive/f211ff7de227f7fcee9aa997cd15bf783f7a9942.jpg"
        fox11.vertical = false
        list.add(fox11)

        val fox12 = PetVideo()
        fox12.type = VideoType.FOX.ordinal
        fox12.fileName = "pet_fox12"
        fox12.code = 444
        fox12.duration = 29
        fox12.star = true
        fox12.title = "狐狸村的吵架日常，猜猜最后谁赢了？"
        fox12.releaseTime = 1641302886
        fox12.originalUrl = "https://www.bilibili.com/video/BV1wr4y1v7wm"
        fox12.tags = "狐,萌宠,动物圈"
        fox12.authorId = 24272038
        fox12.cover =
            "https://i2.hdslb.com/bfs/archive/ee69b6c14b97fd00c65faeb392eacacb94906cd9.jpg"
        fox12.vertical = false
        list.add(fox12)

        val fox13 = PetVideo()
        fox13.type = VideoType.FOX.ordinal
        fox13.fileName = "pet_fox13"
        fox13.code = 445
        fox13.duration = 22
        fox13.star = true
        fox13.title = "你喜欢萝莉还是大魔头？"
        fox13.releaseTime = 1637924668
        fox13.originalUrl = "https://www.bilibili.com/video/BV1vq4y1B79x"
        fox13.tags = "狐,萌宠,动物圈"
        fox13.authorId = 1523830423
        fox13.cover =
            "https://i1.hdslb.com/bfs/archive/af90279722702e740d77d1c6b071ae594750d539.jpg"
        fox13.vertical = true
        list.add(fox13)

        val fox14 = PetVideo()
        fox14.type = VideoType.FOX.ordinal
        fox14.fileName = "pet_fox14"
        fox14.code = 446
        fox14.duration = 121
        fox14.star = true
        fox14.title = "-20℃密林深处，拍摄到了野生紫貂，太可爱了！"
        fox14.releaseTime = 1637316409
        fox14.originalUrl = "https://www.bilibili.com/video/BV1i3411t7vt"
        fox14.tags = "狐,萌宠,动物圈"
        fox14.authorId = 1523830423
        fox14.cover =
            "https://i2.hdslb.com/bfs/archive/3fe6af2b710b04daf5ed2f1b3fdf7c172da8218e.jpg"
        fox14.vertical = false
        list.add(fox14)

        val fox15 = PetVideo()
        fox15.type = VideoType.FOX.ordinal
        fox15.fileName = "pet_fox15"
        fox15.code = 447
        fox15.duration = 110
        fox15.star = true
        fox15.title = "北极狐：长成这样的北极狐你见过吗"
        fox15.releaseTime = 1639389615
        fox15.originalUrl = "https://www.bilibili.com/video/BV1oZ4y197cq"
        fox15.tags = "狐,萌宠,动物圈"
        fox15.authorId = 31762728
        fox15.cover =
            "https://i2.hdslb.com/bfs/archive/773d0f3854e3dc28604649b26e83e1acae6e1e4a.jpg"
        fox15.vertical = false
        list.add(fox15)

        val fox16 = PetVideo()
        fox16.type = VideoType.FOX.ordinal
        fox16.fileName = "pet_fox16"
        fox16.code = 448
        fox16.duration = 136
        fox16.star = true
        fox16.title = "传说中狡猾的狐狸——赤狐，居然会如此安静！"
        fox16.releaseTime = 1633693689
        fox16.originalUrl = "https://www.bilibili.com/video/BV1JQ4y1B7qv"
        fox16.tags = "狐,萌宠,动物圈"
        fox16.authorId = 282239993
        fox16.cover =
            "https://i0.hdslb.com/bfs/archive/4f106ec17ba2902005fd0192ee8ac7cf8c5c408b.jpg"
        fox16.vertical = false
        list.add(fox16)

        val fox18 = PetVideo()
        fox18.type = VideoType.FOX.ordinal
        fox18.fileName = "pet_fox18"
        fox18.code = 1064
        fox18.duration = 31
        fox18.star = true
        fox18.title = "大雪中趴窝休息的暖暖狐 ©itseriksen"
        fox18.releaseTime = 1643883777
        fox18.originalUrl = "https://www.bilibili.com/video/BV1d44y1p74N"
        fox18.tags = "狐狸,萌宠,动物圈"
        fox18.authorId = 28426235
        fox18.cover =
            "https://i1.hdslb.com/bfs/archive/f0ca6ad1e049ab3cab66005b3e848527e8d1c4bf.jpg"
        fox18.vertical = true
        list.add(fox18)

        val fox19 = PetVideo()
        fox19.type = VideoType.FOX.ordinal
        fox19.fileName = "pet_fox19"
        fox19.code = 1065
        fox19.duration = 27
        fox19.star = true
        fox19.title = "【赤狐】狐狸躺在地上吵架"
        fox19.releaseTime = 1640924041
        fox19.originalUrl = "https://www.bilibili.com/video/BV1Yr4y1m7hF"
        fox19.tags = "狐狸,萌宠,动物圈"
        fox19.authorId = 24272038
        fox19.cover =
            "https://i1.hdslb.com/bfs/archive/a050797a51e46f34254ad7860746f07a99338fb9.jpg"
        fox19.vertical = false
        list.add(fox19)

        val fox20 = PetVideo()
        fox20.type = VideoType.FOX.ordinal
        fox20.fileName = "pet_fox20"
        fox20.code = 1066
        fox20.duration = 53
        fox20.star = true
        fox20.title = "【赤狐】带个对象回家看饲养员"
        fox20.releaseTime = 1643557169
        fox20.originalUrl = "https://www.bilibili.com/video/BV1oS4y1y7bo"
        fox20.tags = "狐狸,萌宠,动物圈"
        fox20.authorId = 24272038
        fox20.cover =
            "https://i1.hdslb.com/bfs/archive/2d87e6fc2e9b02aace8c7b392b31d0567d1dcfa5.jpg"
        fox20.vertical = false
        list.add(fox20)

        val fox21 = PetVideo()
        fox21.type = VideoType.FOX.ordinal
        fox21.fileName = "pet_fox21"
        fox21.code = 1067
        fox21.duration = 217
        fox21.star = true
        fox21.title = "【狐狸村】茶狐.茶色白金狐小合集"
        fox21.releaseTime = 1641315534
        fox21.originalUrl = "https://www.bilibili.com/video/BV17a411z77N"
        fox21.tags = "狐狸,萌宠,动物圈"
        fox21.authorId = 28426235
        fox21.cover =
            "https://i0.hdslb.com/bfs/archive/d45ea8c0410af997ec4f82200bc65df35b9f63da.jpg"
        fox21.vertical = false
        list.add(fox21)

        val fox23 = PetVideo()
        fox23.type = VideoType.FOX.ordinal
        fox23.fileName = "pet_fox23"
        fox23.code = 1069
        fox23.duration = 58
        fox23.star = true
        fox23.title = "和小盆友van耍的小狐狸"
        fox23.releaseTime = 1580035909
        fox23.originalUrl = "https://www.bilibili.com/video/BV1B7411k7b9"
        fox23.tags = "狐狸,萌宠,动物圈"
        fox23.authorId = 273451160
        fox23.cover =
            "https://i2.hdslb.com/bfs/archive/23247b14bda1eec534bf84a2a48967a4857b556c.jpg"
        fox23.vertical = true
        list.add(fox23)

        val fox24 = PetVideo()
        fox24.type = VideoType.FOX.ordinal
        fox24.fileName = "pet_fox24"
        fox24.code = 1070
        fox24.duration = 208
        fox24.star = true
        fox24.title = "近日的Alisa和阿奇"
        fox24.releaseTime = 1614413341
        fox24.originalUrl = "https://www.bilibili.com/video/BV1CZ4y1A79n"
        fox24.tags = "狐狸,萌宠,动物圈"
        fox24.authorId = 273451160
        fox24.cover =
            "https://i1.hdslb.com/bfs/archive/0ecd5b106b703eb85007cdcee379e07094543648.jpg"
        fox24.vertical = false
        list.add(fox24)

        val fox25 = PetVideo()
        fox25.type = VideoType.FOX.ordinal
        fox25.fileName = "pet_fox25"
        fox25.code = 1071
        fox25.duration = 17
        fox25.star = true
        fox25.title = "【赤狐】总之就是很委屈的狐狸（1）"
        fox25.releaseTime = 1640521683
        fox25.originalUrl = "https://www.bilibili.com/video/BV1hb4y1v7RF"
        fox25.tags = "狐狸,萌宠,动物圈"
        fox25.authorId = 24272038
        fox25.cover =
            "https://i2.hdslb.com/bfs/archive/8ce5c0d27e0a2895bb1a51cb756272c1c91b4a4d.jpg"
        fox25.vertical = false
        list.add(fox25)

        val fox26 = PetVideo()
        fox26.type = VideoType.FOX.ordinal
        fox26.fileName = "pet_fox26"
        fox26.code = 1072
        fox26.duration = 115
        fox26.star = true
        fox26.title = "晚安北极狐zzzZZZ"
        fox26.releaseTime = 1642016378
        fox26.originalUrl = "https://www.bilibili.com/video/BV1Xm4y1D7Vu"
        fox26.tags = "狐狸,萌宠,动物圈"
        fox26.authorId = 28426235
        fox26.cover =
            "https://i1.hdslb.com/bfs/archive/ea1b01b378f551f5f926044e5a3c882b51fd5c39.jpg"
        fox26.vertical = false
        list.add(fox26)

        val fox27 = PetVideo()
        fox27.type = VideoType.FOX.ordinal
        fox27.fileName = "pet_fox27"
        fox27.code = 1073
        fox27.duration = 103
        fox27.star = true
        fox27.title = "【秋日童话】邂逅武汉大学的小狐狸“珞珞”"
        fox27.releaseTime = 1573043455
        fox27.originalUrl = "https://www.bilibili.com/video/BV1VE411i7gR"
        fox27.tags = "狐狸,萌宠,动物圈"
        fox27.authorId = 279037057
        fox27.cover =
            "https://i1.hdslb.com/bfs/archive/00b1971c4444fb8492a4da0ab56e5afbd83375a2.jpg"
        fox27.vertical = false
        list.add(fox27)

        val fox28 = PetVideo()
        fox28.type = VideoType.FOX.ordinal
        fox28.fileName = "pet_fox28"
        fox28.code = 1074
        fox28.duration = 277
        fox28.star = true
        fox28.title = "【狐狸】旭山动物园的北极狐和赤狐"
        fox28.releaseTime = 1643198568
        fox28.originalUrl = "https://www.bilibili.com/video/BV1JZ4y1Z7LU"
        fox28.tags = "狐狸,萌宠,动物圈"
        fox28.authorId = 28426235
        fox28.cover =
            "https://i2.hdslb.com/bfs/archive/414b1548d68095a3ac57fc284b359f755c454283.jpg"
        fox28.vertical = false
        list.add(fox28)

        val fox29 = PetVideo()
        fox29.type = VideoType.FOX.ordinal
        fox29.fileName = "pet_fox29"
        fox29.code = 1075
        fox29.duration = 48
        fox29.star = true
        fox29.title = "小狐狸吵架吵输了"
        fox29.releaseTime = 1637321979
        fox29.originalUrl = "https://www.bilibili.com/video/BV1Ag411N7nq"
        fox29.tags = "狐狸,萌宠,动物圈"
        fox29.authorId = 84519683
        fox29.cover =
            "https://i1.hdslb.com/bfs/archive/d616a4b03d571f8b68769ab1c3c9844ac756b56d.jpg"
        fox29.vertical = false
        list.add(fox29)

        val fox30 = PetVideo()
        fox30.type = VideoType.FOX.ordinal
        fox30.fileName = "pet_fox30"
        fox30.code = 1076
        fox30.duration = 21
        fox30.star = true
        fox30.title = "北狐牧场 呆呆狐和雪"
        fox30.releaseTime = 1638596211
        fox30.originalUrl = "https://www.bilibili.com/video/BV1qg411A7HZ"
        fox30.tags = "狐狸,萌宠,动物圈"
        fox30.authorId = 24272038
        fox30.cover =
            "https://i2.hdslb.com/bfs/archive/5b1931617ffbe0c5e86875b38cc1d79500aa4941.jpg"
        fox30.vertical = false
        list.add(fox30)

        val fox31 = PetVideo()
        fox31.type = VideoType.FOX.ordinal
        fox31.fileName = "pet_fox31"
        fox31.code = 428
        fox31.duration = 73
        fox31.star = true
        fox31.title = "【北极狐】雪中精灵"
        fox31.releaseTime = 1621850840
        fox31.originalUrl = "https://www.bilibili.com/video/BV1Gq4y1j7d5"
        fox31.tags = "萌宠,动物圈,北极狐,狐狸"
        fox31.authorId = 24751035
        fox31.cover =
            "https://i1.hdslb.com/bfs/archive/30b259a24c170e6e27d9eeb315cce28345cec181.jpg"
        fox31.vertical = false
        list.add(fox31)

        return list
    }

    private fun getLandScapeData(): MutableList<PetVideo> {

        val landscape1 = PetVideo()
        landscape1.type = VideoType.LANDSCAPE.ordinal
        landscape1.fileName = "landscape_1"
        landscape1.code = 471
        landscape1.duration = 235
        landscape1.star = true
        landscape1.title = "我于人间，赏山河，踏风雪"
        landscape1.releaseTime = 1640705701
        landscape1.originalUrl = "https://www.bilibili.com/video/BV1j3411v7pc"
        landscape1.tags = "山水,风景"
        landscape1.authorId = 1866448992
        landscape1.cover =
            "https://i1.hdslb.com/bfs/archive/022e4b497e5834502daf5f3d117ffefe3345b680.jpg"
        landscape1.vertical = false
        landscape1.videoType = 1
        list.add(landscape1)

        val landscape2 = PetVideo()
        landscape2.type = VideoType.LANDSCAPE.ordinal
        landscape2.fileName = "landscape_2"
        landscape2.code = 474
        landscape2.duration = 64
        landscape2.star = true
        landscape2.title = "紫禁城的大寒瑞雪 和故宫一起冰雪过大年！"
        landscape2.releaseTime = 1642661829
        landscape2.originalUrl = "https://www.bilibili.com/video/BV1yL4y14718"
        landscape2.tags = "山水,风景"
        landscape2.authorId = 630399926
        landscape2.cover =
            "https://i0.hdslb.com/bfs/archive/12f804f213b250289c5954a71fefa0596ff88725.jpg"
        landscape2.vertical = false
        landscape2.videoType = 1
        list.add(landscape2)

        val landscape3 = PetVideo()
        landscape3.type = VideoType.LANDSCAPE.ordinal
        landscape3.fileName = "landscape_3"
        landscape3.code = 475
        landscape3.duration = 88
        landscape3.star = true
        landscape3.title = "“檐上三寸雪   人间惊鸿客”"
        landscape3.releaseTime = 1641377249
        landscape3.originalUrl = "https://www.bilibili.com/video/BV1P34y167B9"
        landscape3.tags = "山水,风景"
        landscape3.authorId = 479410884
        landscape3.cover =
            "https://i1.hdslb.com/bfs/archive/25986a6f2f742fa145be75df46469af4d547f30d.jpg"
        landscape3.vertical = false
        landscape3.videoType = 1
        list.add(landscape3)

        val landscape4 = PetVideo()
        landscape4.type = VideoType.LANDSCAPE.ordinal
        landscape4.fileName = "landscape_4"
        landscape4.code = 491
        landscape4.duration = 237
        landscape4.star = true
        landscape4.title = "“忽有故人心上过，回首山河已入冬。两处相思同淋雪，此生也算共白头。”"
        landscape4.releaseTime = 1606285605
        landscape4.originalUrl = "https://www.bilibili.com/video/BV13K41137oz"
        landscape4.tags = "山水,风景"
        landscape4.authorId = 82571698
        landscape4.cover =
            "https://i2.hdslb.com/bfs/archive/78d0190e621962220f3e9f54be250f7b4f21e82b.jpg"
        landscape4.vertical = false
        landscape4.videoType = 1
        list.add(landscape4)

        val landscape5 = PetVideo()
        landscape5.type = VideoType.LANDSCAPE.ordinal
        landscape5.fileName = "landscape_5"
        landscape5.code = 450
        landscape5.duration = 31
        landscape5.star = true
        landscape5.title = "灵隐寺雪景｜夜深知雪重，时闻折竹声"
        landscape5.releaseTime = 1643548480
        landscape5.originalUrl = "https://www.bilibili.com/video/BV12b4y1E7zT"
        landscape5.tags = "山水,风景"
        landscape5.authorId = 484071625
        landscape5.cover =
            "https://i2.hdslb.com/bfs/archive/630e71f34f6ed6adbbd7cb7bbbd37bcf15eb8869.jpg"
        landscape5.vertical = false
        landscape5.videoType = 0
        list.add(landscape5)

        val landscape6 = PetVideo()
        landscape6.type = VideoType.LANDSCAPE.ordinal
        landscape6.fileName = "landscape_6"
        landscape6.code = 451
        landscape6.duration = 61
        landscape6.star = true
        landscape6.title = "【临安·雪】绝美杭州西湖雪景  红衣和雪景最配呀~"
        landscape6.releaseTime = 1546708412
        landscape6.originalUrl = "https://www.bilibili.com/video/BV1At411478b"
        landscape6.tags = "山水,风景"
        landscape6.authorId = 30652169
        landscape6.cover =
            "https://i0.hdslb.com/bfs/archive/1f85742bbef5669d29849f9af1021f3d306ab83c.jpg"
        landscape6.vertical = false
        landscape6.videoType = 0
        list.add(landscape6)

        val landscape7 = PetVideo()
        landscape7.type = VideoType.LANDSCAPE.ordinal
        landscape7.fileName = "landscape_7"
        landscape7.code = 452
        landscape7.duration = 26
        landscape7.star = true
        landscape7.title = "航拍雪中的西湖，你可以永远相信杭州的雪景"
        landscape7.releaseTime = 1643476243
        landscape7.originalUrl = "https://www.bilibili.com/video/BV1hq4y1w773"
        landscape7.tags = "山水,风景"
        landscape7.authorId = 16748982
        landscape7.cover =
            "https://i0.hdslb.com/bfs/archive/c8ff8422ee044b208d7722eb5b65898689f8d317.jpg"
        landscape7.vertical = false
        landscape7.videoType = 0
        list.add(landscape7)

        val landscape8 = PetVideo()
        landscape8.type = VideoType.LANDSCAPE.ordinal
        landscape8.fileName = "landscape_8"
        landscape8.code = 453
        landscape8.duration = 268
        landscape8.star = true
        landscape8.title = "【忆江南】这群老戏骨 把“富春山居图”演活了"
        landscape8.releaseTime = 1643696094
        landscape8.originalUrl = "https://www.bilibili.com/video/BV1RR4y1T7A9"
        landscape8.tags = "山水,风景"
        landscape8.authorId = 456664753
        landscape8.cover =
            "https://i1.hdslb.com/bfs/archive/33a8d3faa30a5c2cc50e01d2b02e12a8842dad0d.jpg"
        landscape8.vertical = false
        landscape8.videoType = 0
        list.add(landscape8)

        val landscape9 = PetVideo()
        landscape9.type = VideoType.LANDSCAPE.ordinal
        landscape9.fileName = "landscape_9"
        landscape9.code = 454
        landscape9.duration = 65
        landscape9.star = true
        landscape9.title = "2022央视春晚最美节目《只此青绿》沙画版复刻来了！"
        landscape9.releaseTime = 1643775659
        landscape9.originalUrl = "https://www.bilibili.com/video/BV1N3411E7fS"
        landscape9.tags = "山水,风景"
        landscape9.authorId = 222103174
        landscape9.cover =
            "https://i0.hdslb.com/bfs/archive/aa4911d1ba8c25c5650aeb83d163ea7ec616d73f.jpg"
        landscape9.vertical = false
        landscape9.videoType = 0
        list.add(landscape9)

        val landscape10 = PetVideo()
        landscape10.type = VideoType.LANDSCAPE.ordinal
        landscape10.fileName = "landscape_10"
        landscape10.code = 455
        landscape10.duration = 17
        landscape10.star = true
        landscape10.title = "滕王阁"
        landscape10.releaseTime = 1625222117
        landscape10.originalUrl = "https://www.bilibili.com/video/BV1sf4y1b7Mb"
        landscape10.tags = "山水,风景"
        landscape10.authorId = 2099739299
        landscape10.cover =
            "https://i0.hdslb.com/bfs/archive/842f3c7133fa8c227e6dc1ea5227d16ed5ed2de5.jpg"
        landscape10.vertical = false
        landscape10.videoType = 0
        list.add(landscape10)

        val landscape11 = PetVideo()
        landscape11.type = VideoType.LANDSCAPE.ordinal
        landscape11.fileName = "landscape_11"
        landscape11.code = 456
        landscape11.duration = 12
        landscape11.star = true
        landscape11.title = "夜晚滕王阁"
        landscape11.releaseTime = 1625394300
        landscape11.originalUrl = "https://www.bilibili.com/video/BV1NV411W73S"
        landscape11.tags = "山水,风景"
        landscape11.authorId = 2099739299
        landscape11.cover =
            "https://i1.hdslb.com/bfs/archive/d0b638263e535b7cc699777155da59b505bc0f1f.jpg"
        landscape11.vertical = false
        landscape11.videoType = 0
        list.add(landscape11)

        val landscape12 = PetVideo()
        landscape12.type = VideoType.LANDSCAPE.ordinal
        landscape12.fileName = "landscape_12"
        landscape12.code = 457
        landscape12.duration = 89
        landscape12.star = true
        landscape12.title = "2022年看见的第一座雪山竟然在苏州？姑苏夜雪，穹窿山一夜白头"
        landscape12.releaseTime = 1643457263
        landscape12.originalUrl = "https://www.bilibili.com/video/BV1UL411F7wo"
        landscape12.tags = "山水,风景"
        landscape12.authorId = 4875902
        landscape12.cover =
            "https://i1.hdslb.com/bfs/archive/082cfced59becd42508e599e24647387f89976bc.jpg"
        landscape12.vertical = false
        landscape12.videoType = 0
        list.add(landscape12)

        val landscape13 = PetVideo()
        landscape13.type = VideoType.LANDSCAPE.ordinal
        landscape13.fileName = "landscape_13"
        landscape13.code = 458
        landscape13.duration = 97
        landscape13.star = true
        landscape13.title = "最美的雪是一起看过的雪，快看乌镇下雪了，雪花纷纷飘落的时候，恰逢思念最浓"
        landscape13.releaseTime = 1643432259
        landscape13.originalUrl = "https://www.bilibili.com/video/BV11a41117iv"
        landscape13.tags = "山水,风景"
        landscape13.authorId = 335680001
        landscape13.cover =
            "https://i1.hdslb.com/bfs/archive/09f05026b225c7aa99a9ea44ea1f2ec812435307.jpg"
        landscape13.vertical = false
        landscape13.videoType = 0
        list.add(landscape13)

        val landscape14 = PetVideo()
        landscape14.type = VideoType.LANDSCAPE.ordinal
        landscape14.fileName = "landscape_14"
        landscape14.code = 459
        landscape14.duration = 102
        landscape14.star = true
        landscape14.title = "九寨沟 诺日朗瀑布"
        landscape14.releaseTime = 1641710823
        landscape14.originalUrl = "https://www.bilibili.com/video/BV1NL411c71K"
        landscape14.tags = "山水,风景"
        landscape14.authorId = 1541346990
        landscape14.cover =
            "https://i1.hdslb.com/bfs/archive/f98e80c061b08e927fdee66e3da453ca6895267d.jpg"
        landscape14.vertical = false
        landscape14.videoType = 0
        list.add(landscape14)

        val landscape15 = PetVideo()
        landscape15.type = VideoType.LANDSCAPE.ordinal
        landscape15.fileName = "landscape_15"
        landscape15.code = 460
        landscape15.duration = 364
        landscape15.star = true
        landscape15.title = "【4K】襄阳视界：拍摄历时四年，6分钟带你看尽千年古城襄阳"
        landscape15.releaseTime = 1639055344
        landscape15.originalUrl = "https://www.bilibili.com/video/BV1CP4y137zb"
        landscape15.tags = "山水,风景"
        landscape15.authorId = 21151219
        landscape15.cover =
            "https://i1.hdslb.com/bfs/archive/d92ad610376c724a6932b1cc04d2c649de1b0a4e.jpg"
        landscape15.vertical = false
        landscape15.videoType = 0
        list.add(landscape15)

        val landscape16 = PetVideo()
        landscape16.type = VideoType.LANDSCAPE.ordinal
        landscape16.fileName = "landscape_16"
        landscape16.code = 461
        landscape16.duration = 235
        landscape16.star = true
        landscape16.title = "你好，我是湖北"
        landscape16.releaseTime = 1618199105
        landscape16.originalUrl = "https://www.bilibili.com/video/BV1oK411w7si"
        landscape16.tags = "山水,风景"
        landscape16.authorId = 21151219
        landscape16.cover =
            "https://i0.hdslb.com/bfs/archive/25ea548501010818a4a519fc97bf9a150f2b9d57.jpg"
        landscape16.vertical = false
        landscape16.videoType = 0
        list.add(landscape16)

        val landscape17 = PetVideo()
        landscape17.type = VideoType.LANDSCAPE.ordinal
        landscape17.fileName = "landscape_17"
        landscape17.code = 462
        landscape17.duration = 143
        landscape17.star = true
        landscape17.title = "谁说大海只能是蓝色，这里是大连庄河红海滩"
        landscape17.releaseTime = 1637235449
        landscape17.originalUrl = "https://www.bilibili.com/video/BV1gr4y1k7Fo"
        landscape17.tags = "山水,风景"
        landscape17.authorId = 21151219
        landscape17.cover =
            "https://i2.hdslb.com/bfs/archive/43d3cdd482bb19e08c4c398bb4cf210239df9dc0.jpg"
        landscape17.vertical = false
        landscape17.videoType = 0
        list.add(landscape17)

        val landscape18 = PetVideo()
        landscape18.type = VideoType.LANDSCAPE.ordinal
        landscape18.fileName = "landscape_18"
        landscape18.code = 463
        landscape18.duration = 200
        landscape18.star = true
        landscape18.title = "【4K】世界最大的红海滩，在中国"
        landscape18.releaseTime = 1602678907
        landscape18.originalUrl = "https://www.bilibili.com/video/BV1zK4y1h72N"
        landscape18.tags = "山水,风景"
        landscape18.authorId = 21151219
        landscape18.cover =
            "https://i1.hdslb.com/bfs/archive/a0ee37786891c7f4274372b1d8d2dafcbd04303c.jpg"
        landscape18.vertical = false
        landscape18.videoType = 0
        list.add(landscape18)

        val landscape19 = PetVideo()
        landscape19.type = VideoType.LANDSCAPE.ordinal
        landscape19.fileName = "landscape_19"
        landscape19.code = 464
        landscape19.duration = 217
        landscape19.star = true
        landscape19.title = "禾 木 村 雪 夜【4K•航拍】"
        landscape19.releaseTime = 1633675167
        landscape19.originalUrl = "https://www.bilibili.com/video/BV1hq4y1V76W"
        landscape19.tags = "山水,风景"
        landscape19.authorId = 25246967
        landscape19.cover =
            "https://i1.hdslb.com/bfs/archive/4f9190e57d0a42af72ef4069895b83b4baa708be.jpg"
        landscape19.vertical = false
        landscape19.videoType = 0
        list.add(landscape19)

        val landscape20 = PetVideo()
        landscape20.type = VideoType.LANDSCAPE.ordinal
        landscape20.fileName = "landscape_20"
        landscape20.code = 465
        landscape20.duration = 259
        landscape20.star = true
        landscape20.title = "垂枝梅丨美的不可思议"
        landscape20.releaseTime = 1617188412
        landscape20.originalUrl = "https://www.bilibili.com/video/BV1T64y1Q7dd"
        landscape20.tags = "山水,风景"
        landscape20.authorId = 333121929
        landscape20.cover =
            "https://i1.hdslb.com/bfs/archive/8e6beb07291e184815de314a5105535f1a3740cd.jpg"
        landscape20.vertical = false
        landscape20.videoType = 0
        list.add(landscape20)

        val landscape21 = PetVideo()
        landscape21.type = VideoType.LANDSCAPE.ordinal
        landscape21.fileName = "landscape_21"
        landscape21.code = 466
        landscape21.duration = 221
        landscape21.star = true
        landscape21.title = "新疆2021之旅：领略一场冰与火之舞"
        landscape21.releaseTime = 1641375011
        landscape21.originalUrl = "https://www.bilibili.com/video/BV1zu411U7Rn"
        landscape21.tags = "山水,风景"
        landscape21.authorId = 21151219
        landscape21.cover =
            "https://i2.hdslb.com/bfs/archive/82efe75222378076fc327b10fe782190931efdd6.jpg"
        landscape21.vertical = false
        landscape21.videoType = 0
        list.add(landscape21)

        val landscape22 = PetVideo()
        landscape22.type = VideoType.LANDSCAPE.ordinal
        landscape22.fileName = "landscape_22"
        landscape22.code = 467
        landscape22.duration = 32
        landscape22.star = true
        landscape22.title = "江西武功山日落云海延时摄影记录"
        landscape22.releaseTime = 1559190291
        landscape22.originalUrl = "https://www.bilibili.com/video/BV1E4411H7U5"
        landscape22.tags = "山水,风景"
        landscape22.authorId = 352623716
        landscape22.cover =
            "https://i1.hdslb.com/bfs/archive/27563dd484db4fe6e196c3ec868798f5cfa1ce09.jpg"
        landscape22.vertical = false
        landscape22.videoType = 0
        list.add(landscape22)

        val landscape23 = PetVideo()
        landscape23.type = VideoType.LANDSCAPE.ordinal
        landscape23.fileName = "landscape_23"
        landscape23.code = 468
        landscape23.duration = 15
        landscape23.star = true
        landscape23.title = "2022年武功山的第一个壮观云海"
        landscape23.releaseTime = 1641544189
        landscape23.originalUrl = "https://www.bilibili.com/video/BV1vS4y1T7MG"
        landscape23.tags = "山水,风景"
        landscape23.authorId = 588435603
        landscape23.cover =
            "https://i0.hdslb.com/bfs/archive/5fb5effefb004f5a1084e757c502044e62130e8f.jpg"
        landscape23.vertical = false
        landscape23.videoType = 0
        list.add(landscape23)

        val landscape24 = PetVideo()
        landscape24.type = VideoType.LANDSCAPE.ordinal
        landscape24.fileName = "landscape_24"
        landscape24.code = 469
        landscape24.duration = 242
        landscape24.star = true
        landscape24.title = "上海城市宣传片（我见过最好的）"
        landscape24.releaseTime = 1527917991
        landscape24.originalUrl = "https://www.bilibili.com/video/BV1uW411N729"
        landscape24.tags = "山水,风景"
        landscape24.authorId = 59182276
        landscape24.cover =
            "https://i1.hdslb.com/bfs/archive/9b896cd9cadf2f8fc93421c3750ca629adf9d223.jpg"
        landscape24.vertical = false
        landscape24.videoType = 0
        list.add(landscape24)

        val landscape25 = PetVideo()
        landscape25.type = VideoType.LANDSCAPE.ordinal
        landscape25.fileName = "landscape_25"
        landscape25.code = 470
        landscape25.duration = 27
        landscape25.star = true
        landscape25.title = "通向蔚蓝的街道～威海-火炬八街"
        landscape25.releaseTime = 1622876406
        landscape25.originalUrl = "https://www.bilibili.com/video/BV1SU4y1V759"
        landscape25.tags = "山水,风景"
        landscape25.authorId = 13055231
        landscape25.cover =
            "https://i1.hdslb.com/bfs/archive/07db953b2f7577664293cd71b652f83a6b7f1ba1.jpg"
        landscape25.vertical = false
        landscape25.videoType = 0
        list.add(landscape25)

        val landscape26 = PetVideo()
        landscape26.type = VideoType.LANDSCAPE.ordinal
        landscape26.fileName = "landscape_26"
        landscape26.code = 472
        landscape26.duration = 199
        landscape26.star = true
        landscape26.title = "“今日只与先生煮酒赏雪，不谈风月”"
        landscape26.releaseTime = 1609389249
        landscape26.originalUrl = "https://www.bilibili.com/video/BV1Tp4y1B7db"
        landscape26.tags = "山水,风景"
        landscape26.authorId = 82571698
        landscape26.cover =
            "https://i1.hdslb.com/bfs/archive/be12ec0f89ed9cbbedf86db64b1398f7e31d1656.jpg"
        landscape26.vertical = false
        landscape26.videoType = 0
        list.add(landscape26)

        val landscape27 = PetVideo()
        landscape27.type = VideoType.LANDSCAPE.ordinal
        landscape27.fileName = "landscape_27"
        landscape27.code = 473
        landscape27.duration = 92
        landscape27.star = true
        landscape27.title = "【闹元宵| 灯会合集】人间不值得 | 欢快版变奏"
        landscape27.releaseTime = 1614084605
        landscape27.originalUrl = "https://www.bilibili.com/video/BV14y4y1J79R"
        landscape27.tags = "山水,风景"
        landscape27.authorId = 344446955
        landscape27.cover =
            "https://i1.hdslb.com/bfs/archive/23f3922b92c1482b8fc5405499b978582584a46b.jpg"
        landscape27.vertical = false
        landscape27.videoType = 0
        list.add(landscape27)

        val landscape28 = PetVideo()
        landscape28.type = VideoType.LANDSCAPE.ordinal
        landscape28.fileName = "landscape_28"
        landscape28.code = 476
        landscape28.duration = 254
        landscape28.star = true
        landscape28.title = "“先去你的塞外，再回我的江南”——《浮光》"
        landscape28.releaseTime = 1633791084
        landscape28.originalUrl = "https://www.bilibili.com/video/BV1HP4y187AZ"
        landscape28.tags = "山水,风景"
        landscape28.authorId = 1866448992
        landscape28.cover =
            "https://i1.hdslb.com/bfs/archive/17568708ccef774f2ec1b904a0d41f6d196801ca.jpg"
        landscape28.vertical = false
        landscape28.videoType = 0
        list.add(landscape28)

        val landscape29 = PetVideo()
        landscape29.type = VideoType.LANDSCAPE.ordinal
        landscape29.fileName = "landscape_29"
        landscape29.code = 477
        landscape29.duration = 161
        landscape29.star = true
        landscape29.title = "“忽人间已晚，山河已秋”"
        landscape29.releaseTime = 1633154320
        landscape29.originalUrl = "https://www.bilibili.com/video/BV1FP4y187Rg"
        landscape29.tags = "山水,风景"
        landscape29.authorId = 505824119
        landscape29.cover =
            "https://i2.hdslb.com/bfs/archive/66cb027e130fb6bc8f96e03b52904af479003d10.jpg"
        landscape29.vertical = false
        landscape29.videoType = 0
        list.add(landscape29)

        val landscape30 = PetVideo()
        landscape30.type = VideoType.LANDSCAPE.ordinal
        landscape30.fileName = "landscape_30"
        landscape30.code = 478
        landscape30.duration = 48
        landscape30.star = true
        landscape30.title = "阳春三月，邂逅伊犁杏花沟"
        landscape30.releaseTime = 1616121329
        landscape30.originalUrl = "https://www.bilibili.com/video/BV1zX4y137XB"
        landscape30.tags = "山水,风景"
        landscape30.authorId = 652192271
        landscape30.cover =
            "https://i0.hdslb.com/bfs/archive/0e92a6c0a92e24b4973a520cd48a70cb9c3c0372.jpg"
        landscape30.vertical = false
        landscape30.videoType = 0
        list.add(landscape30)

        val landscape31 = PetVideo()
        landscape31.type = VideoType.LANDSCAPE.ordinal
        landscape31.fileName = "landscape_31"
        landscape31.code = 479
        landscape31.duration = 145
        landscape31.star = true
        landscape31.title = "漫步洱海"
        landscape31.releaseTime = 1639052595
        landscape31.originalUrl = "https://www.bilibili.com/video/BV1sb4y1i7SC"
        landscape31.tags = "山水,风景"
        landscape31.authorId = 597897892
        landscape31.cover =
            "https://i2.hdslb.com/bfs/archive/c1fde1704142c8924b1985c1a4ed33e369e07bd2.jpg"
        landscape31.vertical = false
        landscape31.videoType = 0
        list.add(landscape31)

        val landscape32 = PetVideo()
        landscape32.type = VideoType.LANDSCAPE.ordinal
        landscape32.fileName = "landscape_32"
        landscape32.code = 480
        landscape32.duration = 12
        landscape32.star = true
        landscape32.title = "大理洱海，人间仙境"
        landscape32.releaseTime = 1572317641
        landscape32.originalUrl = "https://www.bilibili.com/video/BV1vE411h7yR"
        landscape32.tags = "山水,风景"
        landscape32.authorId = 356188277
        landscape32.cover =
            "https://i1.hdslb.com/bfs/archive/b9e127e7b488cd44c5bf1c022c6be69bfa7a594a.jpg"
        landscape32.vertical = false
        landscape32.videoType = 0
        list.add(landscape32)

        val landscape33 = PetVideo()
        landscape33.type = VideoType.LANDSCAPE.ordinal
        landscape33.fileName = "landscape_33"
        landscape33.code = 481
        landscape33.duration = 312
        landscape33.star = true
        landscape33.title = "云顶天宫：老君山最新航拍【4K版】"
        landscape33.releaseTime = 1606890730
        landscape33.originalUrl = "https://www.bilibili.com/video/BV1ca411F7PU"
        landscape33.tags = "山水,风景"
        landscape33.authorId = 307050375
        landscape33.cover =
            "https://i1.hdslb.com/bfs/archive/0019038199ed421f1f778d5bb2abdea532ed111c.jpg"
        landscape33.vertical = false
        landscape33.videoType = 0
        list.add(landscape33)

        val landscape34 = PetVideo()
        landscape34.type = VideoType.LANDSCAPE.ordinal
        landscape34.fileName = "landscape_34"
        landscape34.code = 482
        landscape34.duration = 179
        landscape34.star = true
        landscape34.title = "这，真的是人间吗？老君山【4K】摄影"
        landscape34.releaseTime = 1607521410
        landscape34.originalUrl = "https://www.bilibili.com/video/BV1Dv411b7Ee"
        landscape34.tags = "山水,风景"
        landscape34.authorId = 21151219
        landscape34.cover =
            "https://i2.hdslb.com/bfs/archive/f17b8a7b5a2b086b9ca5f01e9edf634ed1750aba.jpg"
        landscape34.vertical = false
        landscape34.videoType = 0
        list.add(landscape34)

        val landscape35 = PetVideo()
        landscape35.type = VideoType.LANDSCAPE.ordinal
        landscape35.fileName = "landscape_35"
        landscape35.code = 483
        landscape35.duration = 24
        landscape35.star = true
        landscape35.title = "仙气飘飘，美若天宫，老君山风景区"
        landscape35.releaseTime = 1602654201
        landscape35.originalUrl = "https://www.bilibili.com/video/BV1cp4y1k7En"
        landscape35.tags = "山水,风景"
        landscape35.authorId = 478609404
        landscape35.cover =
            "https://i2.hdslb.com/bfs/archive/8e5f1b64a88b67cb635b9f3bfae26c379da2bd15.jpg"
        landscape35.vertical = true
        landscape35.videoType = 0
        list.add(landscape35)

        val landscape36 = PetVideo()
        landscape36.type = VideoType.LANDSCAPE.ordinal
        landscape36.fileName = "landscape_36"
        landscape36.code = 484
        landscape36.duration = 10
        landscape36.star = true
        landscape36.title = "这不是特效！下雪后的庐山，简直就是人间仙境！"
        landscape36.releaseTime = 1544324865
        landscape36.originalUrl = "https://www.bilibili.com/video/BV1dt411i7Vv"
        landscape36.tags = "山水,风景"
        landscape36.authorId = 92998
        landscape36.cover =
            "https://i0.hdslb.com/bfs/archive/84974a77ef7010b28ddbce88e39a49bafd58cf02.jpg"
        landscape36.vertical = false
        landscape36.videoType = 0
        list.add(landscape36)

        val landscape37 = PetVideo()
        landscape37.type = VideoType.LANDSCAPE.ordinal
        landscape37.fileName = "landscape_37"
        landscape37.code = 485
        landscape37.duration = 212
        landscape37.star = true
        landscape37.title = "“姑苏城外寒山寺”"
        landscape37.releaseTime = 1639143138
        landscape37.originalUrl = "https://www.bilibili.com/video/BV1WF411z7Wc"
        landscape37.tags = "山水,风景"
        landscape37.authorId = 1866448992
        landscape37.cover =
            "https://i0.hdslb.com/bfs/archive/b91b1e0ea4907b4877f1244b3a8dfabacb83c6bc.jpg"
        landscape37.vertical = false
        landscape37.videoType = 0
        list.add(landscape37)

        val landscape38 = PetVideo()
        landscape38.type = VideoType.LANDSCAPE.ordinal
        landscape38.fileName = "landscape_38"
        landscape38.code = 486
        landscape38.duration = 209
        landscape38.star = true
        landscape38.title = "“你是姑苏檐下雨，亦是人间惊鸿客”"
        landscape38.releaseTime = 1634188311
        landscape38.originalUrl = "https://www.bilibili.com/video/BV1Hq4y157Xt"
        landscape38.tags = "山水,风景"
        landscape38.authorId = 1084938507
        landscape38.cover =
            "https://i2.hdslb.com/bfs/archive/39289415a0cf814525cf92b948ad1e5b8329dcbc.jpg"
        landscape38.vertical = false
        landscape38.videoType = 0
        list.add(landscape38)

        val landscape39 = PetVideo()
        landscape39.type = VideoType.LANDSCAPE.ordinal
        landscape39.fileName = "landscape_39"
        landscape39.code = 487
        landscape39.duration = 248
        landscape39.star = true
        landscape39.title = "旅行：“见天地，见众生，见自己”"
        landscape39.releaseTime = 1629823025
        landscape39.originalUrl = "https://www.bilibili.com/video/BV1Jf4y1N7Tq"
        landscape39.tags = "山水,风景"
        landscape39.authorId = 82571698
        landscape39.cover =
            "https://i1.hdslb.com/bfs/archive/6b7663c1b5ddefa1001d56d5de3e5b7f2615aa85.jpg"
        landscape39.vertical = false
        landscape39.videoType = 0
        list.add(landscape39)

        val landscape40 = PetVideo()
        landscape40.type = VideoType.LANDSCAPE.ordinal
        landscape40.fileName = "landscape_40"
        landscape40.code = 488
        landscape40.duration = 227
        landscape40.star = true
        landscape40.title = "“一川烟草，满城风絮，梅子黄时雨”"
        landscape40.releaseTime = 1617989283
        landscape40.originalUrl = "https://www.bilibili.com/video/BV1x64y1m7TA"
        landscape40.tags = "山水,风景"
        landscape40.authorId = 82571698
        landscape40.cover =
            "https://i1.hdslb.com/bfs/archive/cb30c82effc3fc0ae0c5f6e69a0c228aaba6020f.jpg"
        landscape40.vertical = false
        landscape40.videoType = 0
        list.add(landscape40)

        val landscape41 = PetVideo()
        landscape41.type = VideoType.LANDSCAPE.ordinal
        landscape41.fileName = "landscape_41"
        landscape41.code = 489
        landscape41.duration = 236
        landscape41.star = true
        landscape41.title = "“小楼一夜听春雨，深巷明朝卖杏花”"
        landscape41.releaseTime = 1615898129
        landscape41.originalUrl = "https://www.bilibili.com/video/BV1CK4y1U7Lc"
        landscape41.tags = "山水,风景"
        landscape41.authorId = 82571698
        landscape41.cover =
            "https://i0.hdslb.com/bfs/archive/781091148b8dd9cc1d6ee03359f3a021d81f6f28.jpg"
        landscape41.vertical = false
        landscape41.videoType = 0
        list.add(landscape41)

        val landscape42 = PetVideo()
        landscape42.type = VideoType.LANDSCAPE.ordinal
        landscape42.fileName = "landscape_42"
        landscape42.code = 490
        landscape42.duration = 94
        landscape42.star = true
        landscape42.title = "梦醒人间看微雨，江山还似旧温柔。"
        landscape42.releaseTime = 1632298312
        landscape42.originalUrl = "https://www.bilibili.com/video/BV1T3411m7EL"
        landscape42.tags = "山水,风景"
        landscape42.authorId = 8374271
        landscape42.cover =
            "https://i1.hdslb.com/bfs/archive/94d8d885a0fc562d22da3567b2fe9aaca2aaed3d.jpg"
        landscape42.vertical = false
        landscape42.videoType = 0
        list.add(landscape42)

        val landscape43 = PetVideo()
        landscape43.type = VideoType.LANDSCAPE.ordinal
        landscape43.fileName = "landscape_43"
        landscape43.code = 1363
        landscape43.duration = 213
        landscape43.star = true
        landscape43.title = "冬奥会开幕式24节气倒计时[4K50P无水印纯净版]<北京龙江波影视>"
        landscape43.releaseTime = 1643998515
        landscape43.originalUrl = "https://www.bilibili.com/video/BV17q4y1b793"
        landscape43.tags = "山水,风景,中国美景"
        landscape43.authorId = 286957274
        landscape43.cover =
            "https://i2.hdslb.com/bfs/archive/1044cd84bcd188bbc1ad7f76ad4b60103c749cb8.jpg"
        landscape43.vertical = false
        landscape43.videoType = 0
        list.add(landscape43)

        val landscape44 = PetVideo()
        landscape44.type = VideoType.LANDSCAPE.ordinal
        landscape44.fileName = "landscape_44"
        landscape44.code = 1364
        landscape44.duration = 121
        landscape44.star = true
        landscape44.title = "双奥之城城市之光第九部正片《北京再相逢》正式发布！"
        landscape44.releaseTime = 1643594403
        landscape44.originalUrl = "https://www.bilibili.com/video/BV1zS4y1V77j"
        landscape44.tags = "山水,风景,中国美景"
        landscape44.authorId = 565388139
        landscape44.cover =
            "https://i1.hdslb.com/bfs/archive/eea1a56b5a32bf25049620454c67897804ee9a84.jpg"
        landscape44.vertical = false
        landscape44.videoType = 0
        list.add(landscape44)

        val landscape45 = PetVideo()
        landscape45.type = VideoType.LANDSCAPE.ordinal
        landscape45.fileName = "landscape_45"
        landscape45.code = 1365
        landscape45.duration = 19
        landscape45.star = true
        landscape45.title = "来看看暴雨后的早晨，会出现什么奇观，50公里外的津沽棒清晰可见！"
        landscape45.releaseTime = 1632559602
        landscape45.originalUrl = "https://www.bilibili.com/video/BV1bq4y1o7vq"
        landscape45.tags = "山水,风景,中国美景"
        landscape45.authorId = 483932025
        landscape45.cover =
            "https://i2.hdslb.com/bfs/archive/3a90b77d949d8efa5a3dd2607fd1d1f79c0cccab.jpg"
        landscape45.vertical = false
        landscape45.videoType = 0
        list.add(landscape45)

        val landscape46 = PetVideo()
        landscape46.type = VideoType.LANDSCAPE.ordinal
        landscape46.fileName = "landscape_46"
        landscape46.code = 1366
        landscape46.duration = 33
        landscape46.star = true
        landscape46.title = "武汉暴雨后天地相连"
        landscape46.releaseTime = 1564723382
        landscape46.originalUrl = "https://www.bilibili.com/video/BV1Dt411F7xi"
        landscape46.tags = "山水,风景,中国美景"
        landscape46.authorId = 452508014
        landscape46.cover =
            "https://i2.hdslb.com/bfs/archive/e5f0f6209d4db9500cebe0d85c5e4165e6162c2a.jpg"
        landscape46.vertical = false
        landscape46.videoType = 0
        list.add(landscape46)

        val landscape47 = PetVideo()
        landscape47.type = VideoType.LANDSCAPE.ordinal
        landscape47.fileName = "landscape_47"
        landscape47.code = 1367
        landscape47.duration = 12
        landscape47.star = true
        landscape47.title = "这是末日来临吗？不，这只是武汉下雨🌧️"
        landscape47.releaseTime = 1620636589
        landscape47.originalUrl = "https://www.bilibili.com/video/BV1bq4y177hY"
        landscape47.tags = "山水,风景,中国美景"
        landscape47.authorId = 8726577
        landscape47.cover =
            "https://i0.hdslb.com/bfs/archive/b60f5de9c1863b1c4acac7cc5b144ccb99c354ec.png"
        landscape47.vertical = false
        landscape47.videoType = 0
        list.add(landscape47)

        val landscape48 = PetVideo()
        landscape48.type = VideoType.LANDSCAPE.ordinal
        landscape48.fileName = "landscape_48"
        landscape48.code = 1368
        landscape48.duration = 64
        landscape48.star = true
        landscape48.title = "仲夏武汉：遇到超级魔幻的云"
        landscape48.releaseTime = 1565182674
        landscape48.originalUrl = "https://www.bilibili.com/video/BV1tt411T7WY"
        landscape48.tags = "山水,风景,中国美景"
        landscape48.authorId = 21151219
        landscape48.cover =
            "https://i1.hdslb.com/bfs/archive/ae64672828caf571ab4317927b12f631a1993a60.jpg"
        landscape48.vertical = false
        landscape48.videoType = 0
        list.add(landscape48)

        val landscape49 = PetVideo()
        landscape49.type = VideoType.LANDSCAPE.ordinal
        landscape49.fileName = "landscape_49"
        landscape49.code = 1369
        landscape49.duration = 154
        landscape49.star = true
        landscape49.title = "【4K治愈】真实存在的动漫场景，在新疆！《伊犁的童话II：鹰的国》"
        landscape49.releaseTime = 1626496209
        landscape49.originalUrl = "https://www.bilibili.com/video/BV1Hv411n7oc"
        landscape49.tags = "山水,风景,中国美景"
        landscape49.authorId = 299451003
        landscape49.cover =
            "https://i1.hdslb.com/bfs/archive/f82e94c3ae55ce3e8dd91b541f484976d8a77a24.jpg"
        landscape49.vertical = false
        landscape49.videoType = 0
        list.add(landscape49)

        val landscape50 = PetVideo()
        landscape50.type = VideoType.LANDSCAPE.ordinal
        landscape50.fileName = "landscape_50"
        landscape50.code = 1991
        landscape50.duration = 172
        landscape50.star = true
        landscape50.title = "送君一场姑苏雨，可否还我一句江南词…"
        landscape50.releaseTime = 1646134502
        landscape50.originalUrl = "https://www.bilibili.com/video/BV1pY411G7DW"
        landscape50.tags = "山水,风景,中国美景"
        landscape50.authorId = 1151868166
        landscape50.cover =
            "https://i2.hdslb.com/bfs/archive/54f765f94edb18d72c56902917977a48890564f2.jpg"
        landscape50.vertical = false
        landscape50.videoType = 0
        list.add(landscape50)

        val landscape51 = PetVideo()
        landscape51.type = VideoType.LANDSCAPE.ordinal
        landscape51.fileName = "landscape_51"
        landscape51.code = 1992
        landscape51.duration = 94
        landscape51.star = true
        landscape51.title = "“雪是大浪漫，你是小人间”"
        landscape51.releaseTime = 1645939482
        landscape51.originalUrl = "https://www.bilibili.com/video/BV1Xb4y1s7U7"
        landscape51.tags = "山水,风景,中国美景"
        landscape51.authorId = 360321868
        landscape51.cover =
            "https://i1.hdslb.com/bfs/archive/e4ea4ff1001d2e448ec2d18aea181427d3690bf2.jpg"
        landscape51.vertical = false
        landscape51.videoType = 0
        list.add(landscape51)

        val landscape52 = PetVideo()
        landscape52.type = VideoType.LANDSCAPE.ordinal
        landscape52.fileName = "landscape_52"
        landscape52.code = 1993
        landscape52.duration = 133
        landscape52.star = true
        landscape52.title = "“白雪纷纷醉红梅，惹人向往不自知”"
        landscape52.releaseTime = 1645785098
        landscape52.originalUrl = "https://www.bilibili.com/video/BV193411L759"
        landscape52.tags = "山水,风景,中国美景"
        landscape52.authorId = 1813574272
        landscape52.cover =
            "https://i0.hdslb.com/bfs/archive/ea66bde806ec116129d30729c4c61738466749a4.jpg"
        landscape52.vertical = false
        landscape52.videoType = 0
        list.add(landscape52)

        val landscape53 = PetVideo()
        landscape53.type = VideoType.LANDSCAPE.ordinal
        landscape53.fileName = "landscape_53"
        landscape53.code = 1994
        landscape53.duration = 125
        landscape53.star = true
        landscape53.title = "用120秒，爱上这个冰雪世界！"
        landscape53.releaseTime = 1645772021
        landscape53.originalUrl = "https://www.bilibili.com/video/BV14u411D7B1"
        landscape53.tags = "山水,风景,中国美景"
        landscape53.authorId = 41665075
        landscape53.cover =
            "https://i2.hdslb.com/bfs/archive/b9ce561c44f434abcbf813c2b3dfdf060499cad7.jpg"
        landscape53.vertical = false
        landscape53.videoType = 0
        list.add(landscape53)

        val landscape54 = PetVideo()
        landscape54.type = VideoType.LANDSCAPE.ordinal
        landscape54.fileName = "landscape_54"
        landscape54.code = 1995
        landscape54.duration = 32
        landscape54.star = true
        landscape54.title = "【明故宫】海棠春深，飞花满城"
        landscape54.releaseTime = 1590336184
        landscape54.originalUrl = "https://www.bilibili.com/video/BV1Wz4y1d7AT"
        landscape54.tags = "山水,风景,中国美景"
        landscape54.authorId = 28374744
        landscape54.cover =
            "https://i0.hdslb.com/bfs/archive/ef8df01baec0816fd35196abe868e279d83b56d5.jpg"
        landscape54.vertical = false
        landscape54.videoType = 0
        list.add(landscape54)

        val landscape55 = PetVideo()
        landscape55.type = VideoType.LANDSCAPE.ordinal
        landscape55.fileName = "landscape_55"
        landscape55.code = 1996
        landscape55.duration = 133
        landscape55.star = true
        landscape55.title = "梅开春烂漫~ | 探寻87版《红楼梦》取景地~"
        landscape55.releaseTime = 1644677709
        landscape55.originalUrl = "https://www.bilibili.com/video/BV1ti4y1f7Ur"
        landscape55.tags = "山水,风景,中国美景"
        landscape55.authorId = 348483302
        landscape55.cover =
            "https://i1.hdslb.com/bfs/archive/2726d32941d2fe9f13a489e2b5191bccb6c4b67f.png"
        landscape55.vertical = false
        landscape55.videoType = 0
        list.add(landscape55)

        val landscape56 = PetVideo()
        landscape56.type = VideoType.LANDSCAPE.ordinal
        landscape56.fileName = "landscape_56"
        landscape56.code = 1997
        landscape56.duration = 73
        landscape56.star = true
        landscape56.title = "恰是江南落雪时"
        landscape56.releaseTime = 1644244377
        landscape56.originalUrl = "https://www.bilibili.com/video/BV1WF411J79r"
        landscape56.tags = "山水,风景,中国美景"
        landscape56.authorId = 523707706
        landscape56.cover =
            "https://i1.hdslb.com/bfs/archive/10d9bf5e476df1733f495df54c64e4c9bb527ff7.jpg"
        landscape56.vertical = false
        landscape56.videoType = 0
        list.add(landscape56)

        return list
    }

    private fun getPandaKnowledge(): MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = VideoType.PANDA.ordinal
        panda1.fileName = "panda_knowledge1"
        panda1.code = 1021
        panda1.duration = 255
        panda1.star = false
        panda1.title = "《舌尖上的斧头山》第5集 盆盆奶"
        panda1.releaseTime = 1601962517
        panda1.originalUrl = "https://www.bilibili.com/video/BV1Ky4y1C7AD"
        panda1.tags = "熊猫,科普,萌宠"
        panda1.authorId = 12444306
        panda1.cover =
            "https://i0.hdslb.com/bfs/archive/4932476ebb58a8cda88916f34b6ec75211b9171d.jpg"
        panda1.vertical = false
        panda1.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = VideoType.PANDA.ordinal
        panda2.fileName = "panda_knowledge2"
        panda2.code = 1022
        panda2.duration = 205
        panda2.star = false
        panda2.title = "《舌尖上的斧头山》第4集 窝窝头"
        panda2.releaseTime = 1600676402
        panda2.originalUrl = "https://www.bilibili.com/video/BV15t4y1q7VQ"
        panda2.tags = "熊猫,科普,萌宠"
        panda2.authorId = 12444306
        panda2.cover =
            "https://i1.hdslb.com/bfs/archive/f39061f388c773b7dd51da533995ef6ebbbf1d44.jpg"
        panda2.vertical = false
        panda2.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = VideoType.PANDA.ordinal
        panda3.fileName = "panda_knowledge3"
        panda3.code = 1023
        panda3.duration = 227
        panda3.star = false
        panda3.title = "《舌尖上的斧头山》 第3集 午后甜点"
        panda3.releaseTime = 1599467454
        panda3.originalUrl = "https://www.bilibili.com/video/BV1ED4y1o7vB"
        panda3.tags = "熊猫,科普,萌宠"
        panda3.authorId = 12444306
        panda3.cover =
            "https://i2.hdslb.com/bfs/archive/5b8b1e0787a35863b61a78d4f699fe1a4a348c14.jpg"
        panda3.vertical = false
        panda3.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = VideoType.PANDA.ordinal
        panda4.fileName = "panda_knowledge4"
        panda4.code = 1024
        panda4.duration = 167
        panda4.star = false
        panda4.title = "《舌尖上的斧头山》第2集 竹"
        panda4.releaseTime = 1598266851
        panda4.originalUrl = "https://www.bilibili.com/video/BV1sa4y177SD"
        panda4.tags = "熊猫,科普,萌宠"
        panda4.authorId = 12444306
        panda4.cover =
            "https://i0.hdslb.com/bfs/archive/6414be33221d8c52e786c64e9ed9bbb64a10927f.jpg"
        panda4.vertical = false
        panda4.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = VideoType.PANDA.ordinal
        panda5.fileName = "panda_knowledge5"
        panda5.code = 1025
        panda5.duration = 154
        panda5.star = false
        panda5.title = "《舌尖上的斧头山》第1集 美食江湖"
        panda5.releaseTime = 1597658561
        panda5.originalUrl = "https://www.bilibili.com/video/BV1Xp4y1v7cc"
        panda5.tags = "熊猫,科普,萌宠"
        panda5.authorId = 12444306
        panda5.cover =
            "https://i1.hdslb.com/bfs/archive/9ccb306ca016b571a6cc070d0047c945e92ccbc6.jpg"
        panda5.vertical = false
        panda5.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = VideoType.PANDA.ordinal
        panda6.fileName = "panda_knowledge6"
        panda6.code = 1026
        panda6.duration = 220
        panda6.star = false
        panda6.title = "端午了，你们吃粽子，我们有“铛铛铛”！"
        panda6.releaseTime = 1623648915
        panda6.originalUrl = "https://www.bilibili.com/video/BV1BK4y1X7Jm"
        panda6.tags = "熊猫,科普,萌宠"
        panda6.authorId = 12444306
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/fb1d2f9593ddd7ecf19ad4e07543b64f59be88e2.jpg"
        panda6.vertical = false
        panda6.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = VideoType.PANDA.ordinal
        panda7.fileName = "panda_knowledge7"
        panda7.code = 1027
        panda7.duration = 231
        panda7.star = false
        panda7.title = "“长江后浪”推前浪，一代更比一代胖"
        panda7.releaseTime = 1631338205
        panda7.originalUrl = "https://www.bilibili.com/video/BV1i34y1Q7xH"
        panda7.tags = "熊猫,科普,萌宠"
        panda7.authorId = 12444306
        panda7.cover =
            "https://i2.hdslb.com/bfs/archive/c70e74b75bf42444a34f5904c1bbf2989d0679a3.jpg"
        panda7.vertical = false
        panda7.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = VideoType.PANDA.ordinal
        panda8.fileName = "panda_knowledge8"
        panda8.code = 1028
        panda8.duration = 210
        panda8.star = false
        panda8.title = "黑白熊怎么就变成“胖哒儿”了？"
        panda8.releaseTime = 1631424603
        panda8.originalUrl = "https://www.bilibili.com/video/BV1p64y1h7PT"
        panda8.tags = "熊猫,科普,萌宠"
        panda8.authorId = 12444306
        panda8.cover =
            "https://i2.hdslb.com/bfs/archive/9a57a27496a86cfa38b9d1b2e488ff972c782a5a.jpg"
        panda8.vertical = false
        panda8.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = VideoType.PANDA.ordinal
        panda9.fileName = "panda_knowledge9"
        panda9.code = 1029
        panda9.duration = 215
        panda9.star = false
        panda9.title = "大熊猫不愧是用萌力传递友谊的使者！"
        panda9.releaseTime = 1631499362
        panda9.originalUrl = "https://www.bilibili.com/video/BV11q4y1Z7gG"
        panda9.tags = "熊猫,科普,萌宠"
        panda9.authorId = 12444306
        panda9.cover =
            "https://i2.hdslb.com/bfs/archive/45532ef9daf0abfb1e8a961ea3c67ea1b490aeb9.jpg"
        panda9.vertical = false
        panda9.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = VideoType.PANDA.ordinal
        panda10.fileName = "panda_knowledge10"
        panda10.code = 1030
        panda10.duration = 221
        panda10.star = false
        panda10.title = "大熊猫为什么只在川陕甘地区活动？是社恐吗？"
        panda10.releaseTime = 1631584800
        panda10.originalUrl = "https://www.bilibili.com/video/BV1Th411p7Y1"
        panda10.tags = "熊猫,科普,萌宠"
        panda10.authorId = 12444306
        panda10.cover =
            "https://i1.hdslb.com/bfs/archive/bdbb7c01e1d01502182c3c922f2caead3eb2d721.jpg"
        panda10.vertical = false
        panda10.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda10)

        val panda11 = PetVideo()
        panda11.type = VideoType.PANDA.ordinal
        panda11.fileName = "panda_knowledge11"
        panda11.code = 1031
        panda11.duration = 207
        panda11.star = false
        panda11.title = "大熊猫的“相亲相爱一家人”群里都有谁？"
        panda11.releaseTime = 1631671213
        panda11.originalUrl = "https://www.bilibili.com/video/BV1Yf4y1J7Th"
        panda11.tags = "熊猫,科普,萌宠"
        panda11.authorId = 12444306
        panda11.cover =
            "https://i2.hdslb.com/bfs/archive/7ffef3debb4954dc98d16e15e5a4bb777311b690.jpg"
        panda11.vertical = false
        panda11.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda11)

        val panda12 = PetVideo()
        panda12.type = VideoType.PANDA.ordinal
        panda12.fileName = "panda_knowledge12"
        panda12.code = 1032
        panda12.duration = 226
        panda12.star = false
        panda12.title = "诶！严寒的冬天，就是玩~"
        panda12.releaseTime = 1631770213
        panda12.originalUrl = "https://www.bilibili.com/video/BV1rP4y1h7Ls"
        panda12.tags = "熊猫,科普,萌宠"
        panda12.authorId = 12444306
        panda12.cover =
            "https://i2.hdslb.com/bfs/archive/d3ede2807172b3d4f4f5723b64a37e3f666a5d6d.jpg"
        panda12.vertical = false
        panda12.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = VideoType.PANDA.ordinal
        panda13.fileName = "panda_knowledge13"
        panda13.code = 1033
        panda13.duration = 260
        panda13.star = false
        panda13.title = "小熊猫真不是大熊猫的崽！"
        panda13.releaseTime = 1631856605
        panda13.originalUrl = "https://www.bilibili.com/video/BV1E341127BB"
        panda13.tags = "熊猫,科普,萌宠"
        panda13.authorId = 12444306
        panda13.cover =
            "https://i0.hdslb.com/bfs/archive/b5757eab088e241ef62ad8b559aafb37fe311494.jpg"
        panda13.vertical = false
        panda13.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = VideoType.PANDA.ordinal
        panda14.fileName = "panda_knowledge14"
        panda14.code = 1034
        panda14.duration = 251
        panda14.star = false
        panda14.title = "大熊猫吃竹是基操，而特殊食谱还有此等功效与作用？"
        panda14.releaseTime = 1631930419
        panda14.originalUrl = "https://www.bilibili.com/video/BV1LU4y1A7wn"
        panda14.tags = "熊猫,科普,萌宠"
        panda14.authorId = 12444306
        panda14.cover =
            "https://i1.hdslb.com/bfs/archive/b38625292f3663f9a06bdfe3afa1e3ad89ed2eca.jpg"
        panda14.vertical = false
        panda14.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = VideoType.PANDA.ordinal
        panda15.fileName = "panda_knowledge15"
        panda15.code = 1035
        panda15.duration = 230
        panda15.star = false
        panda15.title = "想和大熊猫握握手吗？"
        panda15.releaseTime = 1632016814
        panda15.originalUrl = "https://www.bilibili.com/video/BV1Vq4y1f7a1"
        panda15.tags = "熊猫,科普,萌宠"
        panda15.authorId = 12444306
        panda15.cover =
            "https://i2.hdslb.com/bfs/archive/447141102b1e19eeabc829f6f99c7c8b3a783e54.jpg"
        panda15.vertical = false
        panda15.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = VideoType.PANDA.ordinal
        panda16.fileName = "panda_knowledge16"
        panda16.code = 1036
        panda16.duration = 224
        panda16.star = false
        panda16.title = "一口竹子嘎嘣脆"
        panda16.releaseTime = 1632103212
        panda16.originalUrl = "https://www.bilibili.com/video/BV1Bh411p7Sv"
        panda16.tags = "熊猫,科普,萌宠"
        panda16.authorId = 12444306
        panda16.cover =
            "https://i2.hdslb.com/bfs/archive/c78a48641a17ad57ad607b6325faebd27abb1d2e.jpg"
        panda16.vertical = false
        panda16.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda16)

        val panda17 = PetVideo()
        panda17.type = VideoType.PANDA.ordinal
        panda17.fileName = "panda_knowledge17"
        panda17.code = 1037
        panda17.duration = 208
        panda17.star = false
        panda17.title = "别看我是“素食主义者”，但我可是地地道道的食肉目动物！"
        panda17.releaseTime = 1632189611
        panda17.originalUrl = "https://www.bilibili.com/video/BV1iP4y1Y7X6"
        panda17.tags = "熊猫,科普,萌宠"
        panda17.authorId = 12444306
        panda17.cover =
            "https://i2.hdslb.com/bfs/archive/5a4c4bf2366f322d5fde173e82ac716c92b1c10e.jpg"
        panda17.vertical = false
        panda17.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = VideoType.PANDA.ordinal
        panda18.fileName = "panda_knowledge18"
        panda18.code = 1038
        panda18.duration = 215
        panda18.star = false
        panda18.title = "本国宝的生活，是你们这些两脚兽羡慕不来的！"
        panda18.releaseTime = 1632276006
        panda18.originalUrl = "https://www.bilibili.com/video/BV1MP4y1h7jc"
        panda18.tags = "熊猫,科普,萌宠"
        panda18.authorId = 12444306
        panda18.cover =
            "https://i0.hdslb.com/bfs/archive/856824ebe11e2a9f9f1bea97e3d5cda25a5da892.jpg"
        panda18.vertical = false
        panda18.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda18)

        val panda19 = PetVideo()
        panda19.type = VideoType.PANDA.ordinal
        panda19.fileName = "panda_knowledge19"
        panda19.code = 1039
        panda19.duration = 225
        panda19.star = false
        panda19.title = "小小青团大学问，这竟然也是宝贝？！"
        panda19.releaseTime = 1632362414
        panda19.originalUrl = "https://www.bilibili.com/video/BV1ub4y1171x"
        panda19.tags = "熊猫,科普,萌宠"
        panda19.authorId = 12444306
        panda19.cover =
            "https://i1.hdslb.com/bfs/archive/696b5c5b15b7f1ad24ad5b1bacf7fcbf2e5a9850.jpg"
        panda19.vertical = false
        panda19.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda19)

        val panda20 = PetVideo()
        panda20.type = VideoType.PANDA.ordinal
        panda20.fileName = "panda_knowledge20"
        panda20.code = 1040
        panda20.duration = 222
        panda20.star = false
        panda20.title = "熊家的尾巴只是不明显，不能说我没尾巴啊！"
        panda20.releaseTime = 1632448800
        panda20.originalUrl = "https://www.bilibili.com/video/BV1Bh411n7US"
        panda20.tags = "熊猫,科普,萌宠"
        panda20.authorId = 12444306
        panda20.cover =
            "https://i1.hdslb.com/bfs/archive/1f3e91839b6ecc1e36cb4e8296e7ccb492208918.jpg"
        panda20.vertical = false
        panda20.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda20)

        val panda21 = PetVideo()
        panda21.type = VideoType.PANDA.ordinal
        panda21.fileName = "panda_knowledge21"
        panda21.code = 1041
        panda21.duration = 223
        panda21.star = false
        panda21.title = "厉害吧！我们国宝间的交流就是这样朴实无华"
        panda21.releaseTime = 1632535202
        panda21.originalUrl = "https://www.bilibili.com/video/BV18q4y1K7n9"
        panda21.tags = "熊猫,科普,萌宠"
        panda21.authorId = 12444306
        panda21.cover =
            "https://i0.hdslb.com/bfs/archive/25fe86b88486ffc5a5938032fb0b9fef75b3c607.jpg"
        panda21.vertical = false
        panda21.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda21)

        val panda22 = PetVideo()
        panda22.type = VideoType.PANDA.ordinal
        panda22.fileName = "panda_knowledge22"
        panda22.code = 1042
        panda22.duration = 268
        panda22.star = false
        panda22.title = "大熊猫是怎么从粉红“小老鼠”变成黑白分明的大团子的呢？"
        panda22.releaseTime = 1632621606
        panda22.originalUrl = "https://www.bilibili.com/video/BV1FL4y1h76w"
        panda22.tags = "熊猫,科普,萌宠"
        panda22.authorId = 12444306
        panda22.cover =
            "https://i1.hdslb.com/bfs/archive/de3a6aadce7066d0ea8c7636efe56aa345b9349d.jpg"
        panda22.vertical = false
        panda22.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda22)

        val panda23 = PetVideo()
        panda23.type = VideoType.PANDA.ordinal
        panda23.fileName = "panda_knowledge23"
        panda23.code = 1043
        panda23.duration = 206
        panda23.star = false
        panda23.title = "没想到我们的行为举止也会影响到熊猫的生活？"
        panda23.releaseTime = 1632967213
        panda23.originalUrl = "https://www.bilibili.com/video/BV1XL411W7uS"
        panda23.tags = "熊猫,科普,萌宠"
        panda23.authorId = 12444306
        panda23.cover =
            "https://i2.hdslb.com/bfs/archive/8bad0080ae0ae12af91c357a1742ea328a19f7bf.jpg"
        panda23.vertical = false
        panda23.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda23)

        val panda24 = PetVideo()
        panda24.type = VideoType.PANDA.ordinal
        panda24.fileName = "panda_knowledge24"
        panda24.code = 1044
        panda24.duration = 249
        panda24.star = false
        panda24.title = "母爱如同“山体滑坡”，看大熊猫妈妈如何教导熊猫宝宝成为一只真正的大熊猫"
        panda24.releaseTime = 1632708013
        panda24.originalUrl = "https://www.bilibili.com/video/BV1Bf4y1E7pY"
        panda24.tags = "熊猫,科普,萌宠"
        panda24.authorId = 12444306
        panda24.cover =
            "https://i2.hdslb.com/bfs/archive/1014a8fa30a2bb8487d6a9f6e9a402615716e0b8.jpg"
        panda24.vertical = false
        panda24.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = VideoType.PANDA.ordinal
        panda25.fileName = "panda_knowledge25"
        panda25.code = 1045
        panda25.duration = 267
        panda25.star = false
        panda25.title = "快来翻译翻译，这些嘤嘤怪们都在说什么？"
        panda25.releaseTime = 1632794409
        panda25.originalUrl = "https://www.bilibili.com/video/BV1gM4y137vQ"
        panda25.tags = "熊猫,科普,萌宠"
        panda25.authorId = 12444306
        panda25.cover =
            "https://i1.hdslb.com/bfs/archive/ad659eff6084fd6535e04a533d3353eee3f58116.jpg"
        panda25.vertical = false
        panda25.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda25)

        val panda26 = PetVideo()
        panda26.type = VideoType.PANDA.ordinal
        panda26.fileName = "panda_knowledge26"
        panda26.code = 1046
        panda26.duration = 286
        panda26.star = false
        panda26.title = "国宝也是会生病的！不要再嘲笑熊家的“脱裤照”了！"
        panda26.releaseTime = 1632880814
        panda26.originalUrl = "https://www.bilibili.com/video/BV1ET4y1Z7vy"
        panda26.tags = "熊猫,科普,萌宠"
        panda26.authorId = 12444306
        panda26.cover =
            "https://i1.hdslb.com/bfs/archive/630cdd0a53113afa80fa7e5c6df6571ba43488d9.jpg"
        panda26.vertical = false
        panda26.period = PeriodType.KNOWLEDGE.ordinal
        list.add(panda26)

        val panda27 = PetVideo()
        panda27.type = VideoType.PANDA.ordinal
        panda27.fileName = "panda_knowledge27"
        panda27.code = 3656
        panda27.duration = 58
        panda27.period = PeriodType.KNOWLEDGE.ordinal
        panda27.star = false
        panda27.vertical = false
        panda27.title = "熊猫怎么认｜大家好，我是干饭脏脏熊香果🐼"
        panda27.releaseTime = 1663992900
        panda27.originalUrl = "https://www.bilibili.com/video/BV1TW4y1v7xt"
        panda27.tags = "大熊猫,萌宠,动物圈"
        panda27.authorId = 486483424
        panda27.cover =
            "https://i2.hdslb.com/bfs/archive/f6acdb0f3515362d9305f8b1f8eaf2c333d29d71.jpg"
        list.add(panda27)

        val panda28 = PetVideo()
        panda28.type = VideoType.PANDA.ordinal
        panda28.fileName = "panda_knowledge28"
        panda28.code = 3657
        panda28.duration = 65
        panda28.period = PeriodType.KNOWLEDGE.ordinal
        panda28.star = false
        panda28.vertical = false
        panda28.title = "熊猫怎么认｜大家好，我是大脸小可爱宝元😊"
        panda28.releaseTime = 1662177600
        panda28.originalUrl = "https://www.bilibili.com/video/BV1KD4y1z7AA"
        panda28.tags = "大熊猫,萌宠,动物圈"
        panda28.authorId = 486483424
        panda28.cover =
            "https://i2.hdslb.com/bfs/archive/775e099ee42fd792f40229f44283832a8e4d36bc.jpg"
        list.add(panda28)

        val panda29 = PetVideo()
        panda29.type = VideoType.PANDA.ordinal
        panda29.fileName = "panda_knowledge29"
        panda29.code = 3658
        panda29.duration = 43
        panda29.period = PeriodType.KNOWLEDGE.ordinal
        panda29.star = false
        panda29.vertical = false
        panda29.title = "熊猫怎么认｜大家好，我是雅颂🐷🐷"
        panda29.releaseTime = 1657339200
        panda29.originalUrl = "https://www.bilibili.com/video/BV11W4y1U7YX"
        panda29.tags = "大熊猫,萌宠,动物圈"
        panda29.authorId = 486483424
        panda29.cover =
            "https://i0.hdslb.com/bfs/archive/681eeb01f34b93a6a0abf03e253f6b542dfe7011.jpg"
        list.add(panda29)

        val panda30 = PetVideo()
        panda30.type = VideoType.PANDA.ordinal
        panda30.fileName = "panda_knowledge30"
        panda30.code = 3659
        panda30.duration = 189
        panda30.period = PeriodType.KNOWLEDGE.ordinal
        panda30.star = false
        panda30.vertical = false
        panda30.title = "熊猫的尾巴有多可爱？也就是想疯狂rua的程度吧！"
        panda30.releaseTime = 1611923401
        panda30.originalUrl = "https://www.bilibili.com/video/BV1fy4y1H7h4"
        panda30.tags = "大熊猫,萌宠,动物圈"
        panda30.authorId = 1998535
        panda30.cover =
            "https://i2.hdslb.com/bfs/archive/fafc24c89fbc5824600f76bedbc3678f1f1aabbd.jpg"
        list.add(panda30)

        val panda31 = PetVideo()
        panda31.type = VideoType.PANDA.ordinal
        panda31.fileName = "panda_knowledge31"
        panda31.code = 3660
        panda31.duration = 408
        panda31.period = PeriodType.KNOWLEDGE.ordinal
        panda31.star = false
        panda31.vertical = false
        panda31.title = "被叫做“爷爷”的熊猫饲养员，是另一种隔辈亲"
        panda31.releaseTime = 1652508000
        panda31.originalUrl = "https://www.bilibili.com/video/BV1LU4y1m7Yo"
        panda31.tags = "大熊猫,萌宠,动物圈"
        panda31.authorId = 12444306
        panda31.cover =
            "https://i1.hdslb.com/bfs/archive/8f082ce44b408158a1754286a30858f8ddc939ad.jpg"
        list.add(panda31)

        val panda32 = PetVideo()
        panda32.type = VideoType.PANDA.ordinal
        panda32.fileName = "panda_knowledge32"
        panda32.code = 3661
        panda32.duration = 87
        panda32.period = PeriodType.KNOWLEDGE.ordinal
        panda32.star = false
        panda32.vertical = true
        panda32.title = "大熊猫怎么认？21级的熊猫宝宝了解一下"
        panda32.releaseTime = 1647746070
        panda32.originalUrl = "https://www.bilibili.com/video/BV1KR4y1c75u"
        panda32.tags = "大熊猫,萌宠,动物圈"
        panda32.authorId = 1025949925
        panda32.cover =
            "https://i1.hdslb.com/bfs/archive/15942e63e0d41cea3db91a6d464e049d19e0ae21.jpg"
        list.add(panda32)

        val panda33 = PetVideo()
        panda33.type = VideoType.PANDA.ordinal
        panda33.fileName = "panda_knowledge33"
        panda33.code = 3662
        panda33.duration = 112
        panda33.period = PeriodType.KNOWLEDGE.ordinal
        panda33.star = false
        panda33.vertical = true
        panda33.title = "大熊猫怎么认？（入门篇）"
        panda33.releaseTime = 1646883318
        panda33.originalUrl = "https://www.bilibili.com/video/BV1UL4y1u7LR"
        panda33.tags = "大熊猫,萌宠,动物圈"
        panda33.authorId = 1025949925
        panda33.cover =
            "https://i0.hdslb.com/bfs/archive/fbf423de51af7000db76a89600decf3c330ef710.jpg"
        list.add(panda33)

        val panda34 = PetVideo()
        panda34.type = VideoType.PANDA.ordinal
        panda34.fileName = "panda_knowledge34"
        panda34.code = 3663
        panda34.duration = 102
        panda34.period = PeriodType.KNOWLEDGE.ordinal
        panda34.star = false
        panda34.vertical = false
        panda34.title = "熊猫有痒痒肉吗"
        panda34.releaseTime = 1487827324
        panda34.originalUrl = "https://www.bilibili.com/video/BV1Yx411y7BS"
        panda34.tags = "大熊猫,萌宠,动物圈"
        panda34.authorId = 4038416
        panda34.cover =
            "https://i0.hdslb.com/bfs/archive/c3bc60cfd195f34a57b25c92a94fa5a791c96a19.png"
        list.add(panda34)

        val panda35 = PetVideo()
        panda35.type = VideoType.PANDA.ordinal
        panda35.fileName = "panda_knowledge35"
        panda35.code = 3724
        panda35.duration = 82
        panda35.period = PeriodType.KNOWLEDGE.ordinal
        panda35.star = false
        panda35.vertical = false
        panda35.title = "【萌兰和花花和美兰到底是什么关系】总有人把萌兰认成花花的爸爸，美兰要气吐血了"
        panda35.releaseTime = 1663232635
        panda35.originalUrl = "https://www.bilibili.com/video/BV15V4y1M7e2"
        panda35.tags = "大熊猫,萌宠,动物圈"
        panda35.authorId = 397311515
        panda35.cover =
            "https://i1.hdslb.com/bfs/archive/3cb6cd161553e3c5e3bc67892f064719f69ccab8.jpg"
        list.add(panda35)

        val panda36 = PetVideo()
        panda36.type = VideoType.PANDA.ordinal
        panda36.fileName = "panda_knowledge36"
        panda36.code = 3725
        panda36.duration = 109
        panda36.period = PeriodType.KNOWLEDGE.ordinal
        panda36.star = false
        panda36.vertical = true
        panda36.title = "中西熊猫行为训练师，小熊们的欢乐课堂"
        panda36.releaseTime = 1660360199
        panda36.originalUrl = "https://www.bilibili.com/video/BV1EW4y1Y7Uj"
        panda36.tags = "大熊猫,萌宠,动物圈"
        panda36.authorId = 1025949925
        panda36.cover =
            "https://i0.hdslb.com/bfs/archive/78807d41672b8485fcae9eb366aa921189c2d18c.jpg"
        list.add(panda36)

        val panda37 = PetVideo()
        panda37.type = VideoType.PANDA.ordinal
        panda37.fileName = "panda_knowledge37"
        panda37.code = 3726
        panda37.duration = 120
        panda37.period = PeriodType.KNOWLEDGE.ordinal
        panda37.star = false
        panda37.vertical = false
        panda37.title = "大熊猫美兰7个老婆23个娃（更新一版截止2021年）2022的新娃还没公布 不等了，各位熊粉请参考"
        panda37.releaseTime = 1659975220
        panda37.originalUrl = "https://www.bilibili.com/video/BV1Ld4y1m7RW"
        panda37.tags = "大熊猫,萌宠,动物圈"
        panda37.authorId = 439042524
        panda37.cover =
            "https://i1.hdslb.com/bfs/archive/b36f6a6b00bdbd35ffd1c646d599e81c20299241.jpg"
        list.add(panda37)

        val panda38 = PetVideo()
        panda38.type = VideoType.PANDA.ordinal
        panda38.fileName = "panda_knowledge38"
        panda38.code = 3727
        panda38.duration = 137
        panda38.period = PeriodType.KNOWLEDGE.ordinal
        panda38.star = false
        panda38.vertical = false
        panda38.title = "萌系家族，大熊猫萌萌、萌大、萌二、萌兰、萌宝、萌玉。"
        panda38.releaseTime = 1658287904
        panda38.originalUrl = "https://www.bilibili.com/video/BV1U34y1J7hQ"
        panda38.tags = "大熊猫,萌宠,动物圈"
        panda38.authorId = 439042524
        panda38.cover =
            "https://i0.hdslb.com/bfs/archive/64f7205952da17a6743a61d64737e87fc7ef7458.jpg"
        list.add(panda38)

        val panda39 = PetVideo()
        panda39.type = VideoType.PANDA.ordinal
        panda39.fileName = "panda_knowledge39"
        panda39.code = 3728
        panda39.duration = 57
        panda39.period = PeriodType.KNOWLEDGE.ordinal
        panda39.star = false
        panda39.vertical = true
        panda39.title = "熊猫幼年园五小只怎么认？"
        panda39.releaseTime = 1647574242
        panda39.originalUrl = "https://www.bilibili.com/video/BV1hq4y1e7hS"
        panda39.tags = "大熊猫,萌宠,动物圈"
        panda39.authorId = 1025949925
        panda39.cover =
            "https://i1.hdslb.com/bfs/archive/06730d2434682cc40b2a7240b4518af43df6b438.jpg"
        list.add(panda39)



        return list
    }

    private fun getPenguinData(): MutableList<PetVideo> {

        val penguin1 = PetVideo()
        penguin1.type = VideoType.PENGUIN.ordinal
        penguin1.fileName = "penguin1"
        penguin1.code = 1047
        penguin1.duration = 156
        penguin1.star = true
        penguin1.title = "“没头脑和不高兴”"
        penguin1.releaseTime = 1642216067
        penguin1.originalUrl = "https://www.bilibili.com/video/BV1tb4y1J7wu"
        penguin1.tags = "企鹅,萌宠"
        penguin1.authorId = 676931176
        penguin1.cover =
            "https://i0.hdslb.com/bfs/archive/21a3b47ec1ca6fd35de8079f877297ea220ddca4.png"
        penguin1.vertical = false
        list.add(penguin1)

        val penguin2 = PetVideo()
        penguin2.type = VideoType.PENGUIN.ordinal
        penguin2.fileName = "penguin2"
        penguin2.code = 1048
        penguin2.duration = 154
        penguin2.star = true
        penguin2.title = "超清企鹅爸爸夹着企鹅宝宝艰难前行。还有别的企鹅崽崽看中他这个自行车，企图钻进去"
        penguin2.releaseTime = 1642825538
        penguin2.originalUrl = "https://www.bilibili.com/video/BV1gT4y127Cm"
        penguin2.tags = "企鹅,萌宠"
        penguin2.authorId = 63014203
        penguin2.cover =
            "https://i2.hdslb.com/bfs/archive/dcb820099163630466517b25c233e9f6acb2d8f4.jpg"
        penguin2.vertical = true
        list.add(penguin2)

        val penguin3 = PetVideo()
        penguin3.type = VideoType.PENGUIN.ordinal
        penguin3.fileName = "penguin3"
        penguin3.code = 1049
        penguin3.duration = 95
        penguin3.star = true
        penguin3.title = "帝企鹅幼崽与爸爸走散，独自在寒风中瑟瑟发抖，最后一幕太治愈了！|《企鹅家族》"
        penguin3.releaseTime = 1626780068
        penguin3.originalUrl = "https://www.bilibili.com/video/BV1ZM4y1K7Kx"
        penguin3.tags = "企鹅,萌宠"
        penguin3.authorId = 10625615
        penguin3.cover =
            "https://i2.hdslb.com/bfs/archive/e35662f8b9e32506af47507f9c60d5ce17d4ac01.jpg"
        penguin3.vertical = false
        list.add(penguin3)

        val penguin4 = PetVideo()
        penguin4.type = VideoType.PENGUIN.ordinal
        penguin4.fileName = "penguin4"
        penguin4.code = 1050
        penguin4.duration = 128
        penguin4.star = true
        penguin4.title = "【BBC纪录片】摄影组为救出被困企鹅，放弃原则出手干涉"
        penguin4.releaseTime = 1542881772
        penguin4.originalUrl = "https://www.bilibili.com/video/BV1ct411y7Em"
        penguin4.tags = "企鹅,萌宠"
        penguin4.authorId = 65985762
        penguin4.cover =
            "https://i1.hdslb.com/bfs/archive/00130c00af27f4990266b0a84d1ad120fb823fce.jpg"
        penguin4.vertical = false
        list.add(penguin4)

        val penguin5 = PetVideo()
        penguin5.type = VideoType.PENGUIN.ordinal
        penguin5.fileName = "penguin5"
        penguin5.code = 1051
        penguin5.duration = 371
        penguin5.star = true
        penguin5.title = "机器卧底混入企鹅群，记录了小企鹅的逆袭之路，超萌的纪录片。"
        penguin5.releaseTime = 1642052805
        penguin5.originalUrl = "https://www.bilibili.com/video/BV1Tu411m71i"
        penguin5.tags = "企鹅,萌宠"
        penguin5.authorId = 498074492
        penguin5.cover =
            "https://i2.hdslb.com/bfs/archive/c7b2d3f0fdc8047ad2174901e511f9d74259a978.jpg"
        penguin5.vertical = false
        list.add(penguin5)

        val penguin6 = PetVideo()
        penguin6.type = VideoType.PENGUIN.ordinal
        penguin6.fileName = "penguin6"
        penguin6.code = 1052
        penguin6.duration = 47
        penguin6.star = true
        penguin6.title = "【企鹅宝宝】妈妈我饿了……"
        penguin6.releaseTime = 1571317277
        penguin6.originalUrl = "https://www.bilibili.com/video/BV1gE411y7zA"
        penguin6.tags = "企鹅,萌宠"
        penguin6.authorId = 814507
        penguin6.cover =
            "https://i1.hdslb.com/bfs/archive/2bbc00ad39883588c3d3cd2612dc2cf461e74016.jpg"
        penguin6.vertical = false
        list.add(penguin6)

        val penguin7 = PetVideo()
        penguin7.type = VideoType.PENGUIN.ordinal
        penguin7.fileName = "penguin7"
        penguin7.code = 1053
        penguin7.duration = 27
        penguin7.star = true
        penguin7.title = "胎毛还没褪的企鹅崽崽跟爸爸出去浪。。"
        penguin7.releaseTime = 1614428236
        penguin7.originalUrl = "https://www.bilibili.com/video/BV1y54y1h7A5"
        penguin7.tags = "企鹅,萌宠"
        penguin7.authorId = 1277415
        penguin7.cover =
            "https://i1.hdslb.com/bfs/archive/a3406b59885a8d40dad1ad06ded30a1a0062286e.png"
        penguin7.vertical = true
        list.add(penguin7)

        val penguin8 = PetVideo()
        penguin8.type = VideoType.PENGUIN.ordinal
        penguin8.fileName = "penguin8"
        penguin8.code = 1054
        penguin8.duration = 445
        penguin8.star = true
        penguin8.title =
            "企鹅崽崽们每天在大本营做什么:登高，边跑边扑棱翅膀，吃雪，挠痒痒，踩着鹅爸前行，爬雪山，乱认亲，吃饭，打呵欠，撒娇，发呆，站着睡觉，闻闻身上臭不臭，全程高萌"
        penguin8.releaseTime = 1643207542
        penguin8.originalUrl = "https://www.bilibili.com/video/BV1Rb4y177Mq"
        penguin8.tags = "企鹅,萌宠"
        penguin8.authorId = 63014203
        penguin8.cover =
            "https://i1.hdslb.com/bfs/archive/cde67bcdd0a05d4836dece5094650d76ba71c622.jpg"
        penguin8.vertical = false
        list.add(penguin8)

        val penguin9 = PetVideo()
        penguin9.type = VideoType.PENGUIN.ordinal
        penguin9.fileName = "penguin9"
        penguin9.code = 1055
        penguin9.duration = 136
        penguin9.star = true
        penguin9.title = "超可爱，帝企鹅宝宝跟着妈妈出去散步"
        penguin9.releaseTime = 1643114370
        penguin9.originalUrl = "https://www.bilibili.com/video/BV1im4y1S7xN"
        penguin9.tags = "企鹅,萌宠"
        penguin9.authorId = 63014203
        penguin9.cover =
            "https://i1.hdslb.com/bfs/archive/2c30d7177fd06d937671eb473ee0e7331f945247.jpg"
        penguin9.vertical = false
        list.add(penguin9)

        val penguin10 = PetVideo()
        penguin10.type = VideoType.PENGUIN.ordinal
        penguin10.fileName = "penguin10"
        penguin10.code = 1056
        penguin10.duration = 107
        penguin10.star = true
        penguin10.title = "【孤独的企鹅】《在世界尽头相遇》 中的企鹅自杀片段，一只企鹅离开大部队，义无反顾地向群山走去，漫漫长路，等待着它的只有死亡……"
        penguin10.releaseTime = 1541839458
        penguin10.originalUrl = "https://www.bilibili.com/video/BV1vt411m7b1"
        penguin10.tags = "企鹅,萌宠"
        penguin10.authorId = 11670579
        penguin10.cover =
            "https://i1.hdslb.com/bfs/archive/73447a0435971d46c3a070fb86b7f4dd65b0bd27.png"
        penguin10.vertical = false
        list.add(penguin10)

        val penguin11 = PetVideo()
        penguin11.type = VideoType.PENGUIN.ordinal
        penguin11.fileName = "penguin11"
        penguin11.code = 1057
        penguin11.duration = 151
        penguin11.star = true
        penguin11.title = "[英字]鹅砸!!阿德利叔叔来救你们了!"
        penguin11.releaseTime = 1566478754
        penguin11.originalUrl = "https://www.bilibili.com/video/BV1Z441197ha"
        penguin11.tags = "企鹅,萌宠"
        penguin11.authorId = 344194038
        penguin11.cover =
            "https://i2.hdslb.com/bfs/archive/dd5b65514801d3aefe2b88bd6a4bf498948dc431.jpg"
        penguin11.vertical = false
        list.add(penguin11)

        val penguin12 = PetVideo()
        penguin12.type = VideoType.PENGUIN.ordinal
        penguin12.fileName = "penguin12"
        penguin12.code = 1058
        penguin12.duration = 119
        penguin12.star = true
        penguin12.title = "【BBC】企鹅宝宝对阵巨鹱鸟"
        penguin12.releaseTime = 1595492745
        penguin12.originalUrl = "https://www.bilibili.com/video/BV1Sf4y1R7p9"
        penguin12.tags = "企鹅,萌宠"
        penguin12.authorId = 487511093
        penguin12.cover =
            "https://i2.hdslb.com/bfs/archive/5443ddcd1827c28642fc41b5bcfd8176445fc63f.jpg"
        penguin12.vertical = false
        list.add(penguin12)

        val penguin13 = PetVideo()
        penguin13.type = VideoType.PENGUIN.ordinal
        penguin13.fileName = "penguin13"
        penguin13.code = 1059
        penguin13.duration = 140
        penguin13.star = true
        penguin13.title = "帝企鹅的崽崽最可爱了！！"
        penguin13.releaseTime = 1614794546
        penguin13.originalUrl = "https://www.bilibili.com/video/BV1Kz4y117su"
        penguin13.tags = "企鹅,萌宠"
        penguin13.authorId = 147850806
        penguin13.cover =
            "https://i1.hdslb.com/bfs/archive/6f69bc26f782882c25897e19996b1dabe7e17b89.jpg"
        penguin13.vertical = false
        list.add(penguin13)

        val penguin14 = PetVideo()
        penguin14.type = VideoType.PENGUIN.ordinal
        penguin14.fileName = "penguin14"
        penguin14.code = 1060
        penguin14.duration = 125
        penguin14.star = true
        penguin14.title = "企鹅真的不是什么好鹅！别被它的外表骗了."
        penguin14.releaseTime = 1569319330
        penguin14.originalUrl = "https://www.bilibili.com/video/BV1FJ411u7do"
        penguin14.tags = "企鹅,萌宠"
        penguin14.authorId = 20121722
        penguin14.cover =
            "https://i1.hdslb.com/bfs/archive/916175a4b22de556a3b58440de6ca67010a10b5a.jpg"
        penguin14.vertical = false
        list.add(penguin14)

        val penguin15 = PetVideo()
        penguin15.type = VideoType.PENGUIN.ordinal
        penguin15.fileName = "penguin15"
        penguin15.code = 1061
        penguin15.duration = 125
        penguin15.star = true
        penguin15.title = "大型企鹅翻车现场...鹅咂: 我太难了"
        penguin15.releaseTime = 1571551193
        penguin15.originalUrl = "https://www.bilibili.com/video/BV1GE41167JH"
        penguin15.tags = "企鹅,萌宠"
        penguin15.authorId = 344194038
        penguin15.cover =
            "https://i1.hdslb.com/bfs/archive/a6cf9cee1d99141c99741c86146e18398c620539.jpg"
        penguin15.vertical = false
        list.add(penguin15)

        val penguin16 = PetVideo()
        penguin16.type = VideoType.PENGUIN.ordinal
        penguin16.fileName = "penguin16"
        penguin16.code = 1062
        penguin16.duration = 29
        penguin16.star = true
        penguin16.title = "超治愈！被这只毛茸茸的小企鹅萌到了！太可爱了吧！！！"
        penguin16.releaseTime = 1542787434
        penguin16.originalUrl = "https://www.bilibili.com/video/BV1qt411C7ZU"
        penguin16.tags = "企鹅,萌宠"
        penguin16.authorId = 49017255
        penguin16.cover =
            "https://i0.hdslb.com/bfs/archive/8552c7c6df51a0a82e83229188939ba52df69f44.jpg"
        penguin16.vertical = false
        list.add(penguin16)

        val penguin17 = PetVideo()
        penguin17.type = VideoType.PENGUIN.ordinal
        penguin17.fileName = "penguin17"
        penguin17.code = 1370
        penguin17.duration = 58
        penguin17.star = false
        penguin17.title = "揣进毛茸茸的小裤兜"
        penguin17.releaseTime = 1632715817
        penguin17.originalUrl = "https://www.bilibili.com/video/BV1iQ4y1z7RK"
        penguin17.tags = "企鹅"
        penguin17.authorId = 1229013561
        penguin17.cover =
            "https://i2.hdslb.com/bfs/archive/a27db041ca7af069e12ead43c35e11a45a44bb86.jpg"
        penguin17.vertical = false
        list.add(penguin17)

        val penguin18 = PetVideo()
        penguin18.type = VideoType.PENGUIN.ordinal
        penguin18.fileName = "penguin18"
        penguin18.code = 430
        penguin18.duration = 80
        penguin18.star = true
        penguin18.title = "【企鹅】泥嚎！谁说这是滕讯实习生？他们就是坠可爱的崽！！！"
        penguin18.releaseTime = 1643107055
        penguin18.originalUrl = "https://www.bilibili.com/video/BV13Y41187Xa"
        penguin18.tags = "萌宠,企鹅,动物圈"
        penguin18.authorId = 1967191690
        penguin18.cover =
            "https://i0.hdslb.com/bfs/archive/8f526c9802ddc0bdc52b514751a984fe0a68633e.jpg"
        penguin18.vertical = false
        list.add(penguin18)

        return list
    }

    private fun getbearData(): MutableList<PetVideo> {

        val bear1 = PetVideo()
        bear1.type = VideoType.BEAR.ordinal
        bear1.fileName = "pet_bear1"
        bear1.code = 1077
        bear1.duration = 261
        bear1.star = false
        bear1.title = "北极熊妈携幼崽艰难度日，漫长的无冰夏季让生存挑战愈发严峻！"
        bear1.releaseTime = 1643274608
        bear1.originalUrl = "https://www.bilibili.com/video/BV1Sr4y1e7J6"
        bear1.tags = "熊,北极熊,萌宠,动物圈"
        bear1.authorId = 473499434
        bear1.cover =
            "https://i2.hdslb.com/bfs/archive/40bc615010991450f3c41e0d2c76258b44d65058.jpg"
        bear1.vertical = false
        list.add(bear1)

        val bear2 = PetVideo()
        bear2.type = VideoType.BEAR.ordinal
        bear2.fileName = "pet_bear2"
        bear2.code = 1078
        bear2.duration = 98
        bear2.star = false
        bear2.title = "【白熊】小北极熊：我不想起床呀"
        bear2.releaseTime = 1636388701
        bear2.originalUrl = "https://www.bilibili.com/video/BV1xv411M7YK"
        bear2.tags = "熊,北极熊,萌宠,动物圈"
        bear2.authorId = 12159209
        bear2.cover =
            "https://i1.hdslb.com/bfs/archive/326f3ac22b4dce00a42a2ca81955c1321d90cc78.jpg"
        bear2.vertical = false
        list.add(bear2)

        val bear3 = PetVideo()
        bear3.type = VideoType.BEAR.ordinal
        bear3.fileName = "pet_bear3"
        bear3.code = 1079
        bear3.duration = 75
        bear3.star = false
        bear3.title = "40℃的高温天气下，北极熊的命都是冰块给的！"
        bear3.releaseTime = 1500972434
        bear3.originalUrl = "https://www.bilibili.com/video/BV1Lx411q7PS"
        bear3.tags = "熊,北极熊,萌宠,动物圈"
        bear3.authorId = 7489695
        bear3.cover =
            "https://i2.hdslb.com/bfs/archive/871b0d4be50779212b4db2ebac9a019d79613c17.jpg"
        bear3.vertical = false
        list.add(bear3)

        val bear4 = PetVideo()
        bear4.type = VideoType.BEAR.ordinal
        bear4.fileName = "pet_bear4"
        bear4.code = 1080
        bear4.duration = 57
        bear4.star = false
        bear4.title = "饲养员给北极熊准备了一桶冰 给熊高兴坏了"
        bear4.releaseTime = 1548304340
        bear4.originalUrl = "https://www.bilibili.com/video/BV1Et411b73k"
        bear4.tags = "熊,北极熊,萌宠,动物圈"
        bear4.authorId = 814507
        bear4.cover =
            "https://i0.hdslb.com/bfs/archive/1cec5ac9f3ab7a5fcb12838e440e04b4b75a94de.jpg"
        bear4.vertical = false
        list.add(bear4)

        val bear5 = PetVideo()
        bear5.type = VideoType.BEAR.ordinal
        bear5.fileName = "pet_bear5"
        bear5.code = 1081
        bear5.duration = 121
        bear5.star = false
        bear5.title = "【北极熊】麻麻在挖洞 我在旁边乖乖的"
        bear5.releaseTime = 1601206249
        bear5.originalUrl = "https://www.bilibili.com/video/BV1Vk4y117Te"
        bear5.tags = "熊,北极熊,萌宠,动物圈"
        bear5.authorId = 12159209
        bear5.cover =
            "https://i1.hdslb.com/bfs/archive/46ab34d5e472476e1f362b71107ab46898da597b.jpg"
        bear5.vertical = false
        list.add(bear5)

        val bear6 = PetVideo()
        bear6.type = VideoType.BEAR.ordinal
        bear6.fileName = "pet_bear6"
        bear6.code = 1082
        bear6.duration = 162
        bear6.star = false
        bear6.title = "北极熊牌靠枕"
        bear6.releaseTime = 1629105894
        bear6.originalUrl = "https://www.bilibili.com/video/BV1N3411677y"
        bear6.tags = "熊,北极熊,萌宠,动物圈"
        bear6.authorId = 19132130
        bear6.cover =
            "https://i1.hdslb.com/bfs/archive/d33fcbbd98287bb502486ec55f3af9bd490fb504.jpg"
        bear6.vertical = false
        list.add(bear6)

        val bear7 = PetVideo()
        bear7.type = VideoType.BEAR.ordinal
        bear7.fileName = "pet_bear7"
        bear7.code = 1083
        bear7.duration = 68
        bear7.star = false
        bear7.title = "小北极熊纳努和她的弟弟"
        bear7.releaseTime = 1633491835
        bear7.originalUrl = "https://www.bilibili.com/video/BV1tP4y187kt"
        bear7.tags = "熊,北极熊,萌宠,动物圈"
        bear7.authorId = 409847630
        bear7.cover =
            "https://i2.hdslb.com/bfs/archive/f1b2103c7c0229bf56ebd1c379834336a588b5bf.png"
        bear7.vertical = false
        list.add(bear7)

        val bear8 = PetVideo()
        bear8.type = VideoType.BEAR.ordinal
        bear8.fileName = "pet_bear8"
        bear8.code = 1084
        bear8.duration = 106
        bear8.star = false
        bear8.title = "两岁的小北极熊纳努终于被妈妈赶走了"
        bear8.releaseTime = 1636444370
        bear8.originalUrl = "https://www.bilibili.com/video/BV15q4y1k75D"
        bear8.tags = "熊,北极熊,萌宠,动物圈"
        bear8.authorId = 409847630
        bear8.cover =
            "https://i2.hdslb.com/bfs/archive/821de6e05667ae5443031d86e2af979ccb63209e.jpg"
        bear8.vertical = false
        list.add(bear8)

        val bear9 = PetVideo()
        bear9.type = VideoType.BEAR.ordinal
        bear9.fileName = "pet_bear9"
        bear9.code = 1085
        bear9.duration = 107
        bear9.star = false
        bear9.title = "小海豹宝宝被北极熊一口叼走，小海豹妈妈只能眼睁睁的看着"
        bear9.releaseTime = 1583578730
        bear9.originalUrl = "https://www.bilibili.com/video/BV15E411p7kC"
        bear9.tags = "熊,北极熊,萌宠,动物圈"
        bear9.authorId = 141681294
        bear9.cover =
            "https://i1.hdslb.com/bfs/archive/dbd247e8d301b05359e74ca70f727faee7b8eab4.jpg"
        bear9.vertical = false
        list.add(bear9)

        val bear10 = PetVideo()
        bear10.type = VideoType.BEAR.ordinal
        bear10.fileName = "pet_bear10"
        bear10.code = 1086
        bear10.duration = 239
        bear10.star = false
        bear10.title = "熊妈妈亲自带宝宝打野   熊宝宝吃了100条鱼"
        bear10.releaseTime = 1609523469
        bear10.originalUrl = "https://www.bilibili.com/video/BV16y4y1U7CS"
        bear10.tags = "熊,北极熊,萌宠,动物圈"
        bear10.authorId = 33954255
        bear10.cover =
            "https://i2.hdslb.com/bfs/archive/e96235347ae6899681f70357cc3b351330a108d3.jpg"
        bear10.vertical = false
        list.add(bear10)

        val bear11 = PetVideo()
        bear11.type = VideoType.BEAR.ordinal
        bear11.fileName = "pet_bear11"
        bear11.code = 1087
        bear11.duration = 157
        bear11.star = false
        bear11.title = "北极熊妈妈带着两崽子找到一头死去的大鲸鱼，放开吃"
        bear11.releaseTime = 1587871311
        bear11.originalUrl = "https://www.bilibili.com/video/BV1q5411x7Hd"
        bear11.tags = "熊,北极熊,萌宠,动物圈"
        bear11.authorId = 316788826
        bear11.cover =
            "https://i0.hdslb.com/bfs/archive/aca8c7e447ebc866f318557765ff16f96a61d12f.png"
        bear11.vertical = false
        list.add(bear11)

        val bear12 = PetVideo()
        bear12.type = VideoType.BEAR.ordinal
        bear12.fileName = "pet_bear12"
        bear12.code = 1088
        bear12.duration = 111
        bear12.star = false
        bear12.title = "冬眠结束~三只北极熊宝宝第一次爬出雪洞看世界！！！"
        bear12.releaseTime = 1584698568
        bear12.originalUrl = "https://www.bilibili.com/video/BV1AE411N7be"
        bear12.tags = "熊,北极熊,萌宠,动物圈"
        bear12.authorId = 18860831
        bear12.cover =
            "https://i2.hdslb.com/bfs/archive/4aa6f7f0bcf67bea70930a6725b6cb41afcafd93.jpg"
        bear12.vertical = false
        list.add(bear12)

        val bear13 = PetVideo()
        bear13.type = VideoType.BEAR.ordinal
        bear13.fileName = "pet_bear13"
        bear13.code = 1089
        bear13.duration = 299
        bear13.star = false
        bear13.title = "【精彩片段】北极熊猎杀白鲸，鲸肉大餐！"
        bear13.releaseTime = 1597501492
        bear13.originalUrl = "https://www.bilibili.com/video/BV1x54y1i7sZ"
        bear13.tags = "熊,北极熊,萌宠,动物圈"
        bear13.authorId = 21129014
        bear13.cover =
            "https://i1.hdslb.com/bfs/archive/e9ba25ef685a9153c5dafaecdba46a708075bd62.jpg"
        bear13.vertical = false
        list.add(bear13)

        val bear14 = PetVideo()
        bear14.type = VideoType.BEAR.ordinal
        bear14.fileName = "pet_bear14"
        bear14.code = 1090
        bear14.duration = 312
        bear14.star = false
        bear14.title = "北极熊开阔水面爆头秒杀白鲸"
        bear14.releaseTime = 1642515516
        bear14.originalUrl = "https://www.bilibili.com/video/BV1mR4y1M7si"
        bear14.tags = "熊,北极熊,萌宠,动物圈"
        bear14.authorId = 441405989
        bear14.cover =
            "https://i1.hdslb.com/bfs/archive/21ade638a8ef8cb3a30c8bb63fd30232f64afa66.jpg"
        bear14.vertical = false
        list.add(bear14)

        val bear15 = PetVideo()
        bear15.type = VideoType.BEAR.ordinal
        bear15.fileName = "pet_bear15"
        bear15.code = 1091
        bear15.duration = 310
        bear15.star = false
        bear15.title = "北极熊活吃鞍背海豹"
        bear15.releaseTime = 1573902010
        bear15.originalUrl = "https://www.bilibili.com/video/BV1CE411e7CB"
        bear15.tags = "熊,北极熊,萌宠,动物圈"
        bear15.authorId = 27209013
        bear15.cover =
            "https://i0.hdslb.com/bfs/archive/96467d1ae71df72da62d0e7cf65320e2c99bae4f.jpg"
        bear15.vertical = false
        list.add(bear15)

        val bear16 = PetVideo()
        bear16.type = VideoType.BEAR.ordinal
        bear16.fileName = "pet_bear16"
        bear16.code = 1092
        bear16.duration = 59
        bear16.star = false
        bear16.title = "小灰熊和小北极熊一起玩耍"
        bear16.releaseTime = 1632852831
        bear16.originalUrl = "https://www.bilibili.com/video/BV1Sr4y1173H"
        bear16.tags = "熊,北极熊,萌宠,动物圈"
        bear16.authorId = 19132130
        bear16.cover =
            "https://i1.hdslb.com/bfs/archive/c687747a1f86aef92dc4bf13339844019f6c34f8.jpg"
        bear16.vertical = false
        list.add(bear16)

        val bear17 = PetVideo()
        bear17.type = VideoType.BEAR.ordinal
        bear17.fileName = "pet_bear17"
        bear17.code = 1093
        bear17.duration = 66
        bear17.star = false
        bear17.title = "#北极熊# 啊啊啊可爱坏了！北极熊宝宝被突然钻出来的海豹吓到"
        bear17.releaseTime = 1570877788
        bear17.originalUrl = "https://www.bilibili.com/video/BV14E411Z7nx"
        bear17.tags = "熊,北极熊,萌宠,动物圈"
        bear17.authorId = 25314939
        bear17.cover =
            "https://i2.hdslb.com/bfs/archive/b391bf0f6672ecfc749ed1c665a41848a79f1ecb.jpg"
        bear17.vertical = false
        list.add(bear17)

        val bear18 = PetVideo()
        bear18.type = VideoType.BEAR.ordinal
        bear18.fileName = "pet_bear18"
        bear18.code = 1094
        bear18.duration = 415
        bear18.star = false
        bear18.title = "[奥狄斯X亚历山大]北极熊篇-《你打算萌死我吗》-莫如归原著"
        bear18.releaseTime = 1611513670
        bear18.originalUrl = "https://www.bilibili.com/video/BV1Ro4y1o7md"
        bear18.tags = "熊,北极熊,萌宠,动物圈"
        bear18.authorId = 159287792
        bear18.cover =
            "https://i2.hdslb.com/bfs/archive/6e863bf83b61823887944e60a4c12b08f9357790.jpg"
        bear18.vertical = false
        list.add(bear18)

        val bear19 = PetVideo()
        bear19.type = VideoType.BEAR.ordinal
        bear19.fileName = "pet_bear19"
        bear19.code = 1095
        bear19.duration = 306
        bear19.star = false
        bear19.title = "你听过小北极熊的叫声吗？"
        bear19.releaseTime = 1575533393
        bear19.originalUrl = "https://www.bilibili.com/video/BV1PJ411i7yk"
        bear19.tags = "熊,北极熊,萌宠,动物圈"
        bear19.authorId = 340784582
        bear19.cover =
            "https://i2.hdslb.com/bfs/archive/b90941e8f5a06346e679e96bd903fa2122038f7a.jpg"
        bear19.vertical = false
        list.add(bear19)

        val bear20 = PetVideo()
        bear20.type = VideoType.BEAR.ordinal
        bear20.fileName = "pet_bear20"
        bear20.code = 1096
        bear20.duration = 114
        bear20.star = false
        bear20.title = "北极熊：北极熊宝宝是黏在妈妈屁股上的小跟屁"
        bear20.releaseTime = 1634548146
        bear20.originalUrl = "https://www.bilibili.com/video/BV1kU4y1F7Dk"
        bear20.tags = "熊,北极熊,萌宠,动物圈"
        bear20.authorId = 31762728
        bear20.cover =
            "https://i2.hdslb.com/bfs/archive/f1242657c843475898357e783da668d4201d78e7.jpg"
        bear20.vertical = false
        list.add(bear20)

        val bear21 = PetVideo()
        bear21.type = VideoType.BEAR.ordinal
        bear21.fileName = "pet_bear21"
        bear21.code = 1097
        bear21.duration = 90
        bear21.star = false
        bear21.title = "男鹿水族馆 水边玩耍的北极熊"
        bear21.releaseTime = 1643045106
        bear21.originalUrl = "https://www.bilibili.com/video/BV19Z4y1f7Kw"
        bear21.tags = "熊,北极熊,萌宠,动物圈"
        bear21.authorId = 16752607
        bear21.cover =
            "https://i2.hdslb.com/bfs/archive/89ea440974c0a5f4eb3107af9eb433bd05ff95e6.jpg"
        bear21.vertical = false
        list.add(bear21)

        val bear22 = PetVideo()
        bear22.type = VideoType.BEAR.ordinal
        bear22.fileName = "pet_bear22"
        bear22.code = 1098
        bear22.duration = 184
        bear22.star = false
        bear22.title = "【北极熊】饲养员给白熊宝宝jiojio抹护肤霜"
        bear22.releaseTime = 1635673280
        bear22.originalUrl = "https://www.bilibili.com/video/BV1Rb4y1b7sH"
        bear22.tags = "熊,北极熊,萌宠,动物圈"
        bear22.authorId = 383365604
        bear22.cover =
            "https://i1.hdslb.com/bfs/archive/f76e963519bc0fc584c11a4694cd9e2675ebbed9.jpg"
        bear22.vertical = false
        list.add(bear22)

        val bear23 = PetVideo()
        bear23.type = VideoType.BEAR.ordinal
        bear23.fileName = "pet_bear23"
        bear23.code = 1099
        bear23.duration = 152
        bear23.star = false
        bear23.title = "【白熊】小北极熊熊生第一次看到雪！"
        bear23.releaseTime = 1641808811
        bear23.originalUrl = "https://www.bilibili.com/video/BV17u411D7Ux"
        bear23.tags = "熊,北极熊,萌宠,动物圈"
        bear23.authorId = 12159209
        bear23.cover =
            "https://i2.hdslb.com/bfs/archive/2716e989f2b91b7f63ce42161a1947a334a9cd74.jpg"
        bear23.vertical = false
        list.add(bear23)

        val bear24 = PetVideo()
        bear24.type = VideoType.BEAR.ordinal
        bear24.fileName = "pet_bear24"
        bear24.code = 1100
        bear24.duration = 15
        bear24.star = false
        bear24.title = "【小熊】熊熊玛尼娅 摆出了有些诱惑的姿势"
        bear24.releaseTime = 1641551413
        bear24.originalUrl = "https://www.bilibili.com/video/BV1MM4y1w79d"
        bear24.tags = "熊,北极熊,萌宠,动物圈"
        bear24.authorId = 12159209
        bear24.cover =
            "https://i1.hdslb.com/bfs/archive/e7b87673791665f77549e1a2621b6861fa2470e6.jpg"
        bear24.vertical = true
        list.add(bear24)

        val bear25 = PetVideo()
        bear25.type = VideoType.BEAR.ordinal
        bear25.fileName = "pet_bear25"
        bear25.code = 1101
        bear25.duration = 104
        bear25.star = false
        bear25.title = "【白熊】没办法 孩子太可爱了 必须要抱在怀里疯狂rua"
        bear25.releaseTime = 1601033460
        bear25.originalUrl = "https://www.bilibili.com/video/BV1wh41197Ej"
        bear25.tags = "熊,北极熊,萌宠,动物圈"
        bear25.authorId = 12159209
        bear25.cover =
            "https://i2.hdslb.com/bfs/archive/948414b4de1fe54dac8daba54fffc6bc28faf7d1.jpg"
        bear25.vertical = false
        list.add(bear25)

        val bear26 = PetVideo()
        bear26.type = VideoType.BEAR.ordinal
        bear26.fileName = "pet_bear26"
        bear26.code = 1102
        bear26.duration = 69
        bear26.star = false
        bear26.title = "小北极熊：贴紧我的麻麻～"
        bear26.releaseTime = 1610099865
        bear26.originalUrl = "https://www.bilibili.com/video/BV1ii4y1F7Rt"
        bear26.tags = "熊,北极熊,萌宠,动物圈"
        bear26.authorId = 19132130
        bear26.cover =
            "https://i0.hdslb.com/bfs/archive/00abde84752a34cc57df624d67d40b68f8d3d2e3.jpg"
        bear26.vertical = false
        list.add(bear26)

        val bear27 = PetVideo()
        bear27.type = VideoType.BEAR.ordinal
        bear27.fileName = "pet_bear27"
        bear27.code = 1103
        bear27.duration = 16
        bear27.star = false
        bear27.title = "海豹不小心吓到了北极熊宝宝，太可爱了"
        bear27.releaseTime = 1597830013
        bear27.originalUrl = "https://www.bilibili.com/video/BV1Dt4y1U73T"
        bear27.tags = "熊,北极熊,萌宠,动物圈"
        bear27.authorId = 99020217
        bear27.cover =
            "https://i2.hdslb.com/bfs/archive/dd4a99a29fdcbf12fb8b8386b0282e1d4906c505.png"
        bear27.vertical = false
        list.add(bear27)

        val bear28 = PetVideo()
        bear28.type = VideoType.BEAR.ordinal
        bear28.fileName = "pet_bear28"
        bear28.code = 1104
        bear28.duration = 66
        bear28.star = false
        bear28.title = "小北极熊第一次玩冰块，场面一发不可收拾，憋住千万别笑！"
        bear28.releaseTime = 1641295405
        bear28.originalUrl = "https://www.bilibili.com/video/BV13Z4y1S7G2"
        bear28.tags = "熊,北极熊,萌宠,动物圈"
        bear28.authorId = 1556523172
        bear28.cover =
            "https://i1.hdslb.com/bfs/archive/ce0200642e76a2b558cac7d78ae80f7665a12f48.jpg"
        bear28.vertical = false
        list.add(bear28)

        val bear29 = PetVideo()
        bear29.type = VideoType.BEAR.ordinal
        bear29.fileName = "pet_bear29"
        bear29.code = 1105
        bear29.duration = 120
        bear29.star = false
        bear29.title = "小熊：我有狗了！"
        bear29.releaseTime = 1640661004
        bear29.originalUrl = "https://www.bilibili.com/video/BV1MR4y1s73f"
        bear29.tags = "熊,北极熊,萌宠,动物圈"
        bear29.authorId = 508141704
        bear29.cover =
            "https://i1.hdslb.com/bfs/archive/8d0ff486edf3139b899e463d441dac43a609c728.jpg"
        bear29.vertical = false
        list.add(bear29)

        val bear30 = PetVideo()
        bear30.type = VideoType.BEAR.ordinal
        bear30.fileName = "pet_bear30"
        bear30.code = 1106
        bear30.duration = 76
        bear30.star = false
        bear30.title = "出生不久的小狮子和小老虎，发出的声音很有趣"
        bear30.releaseTime = 1590061155
        bear30.originalUrl = "https://www.bilibili.com/video/BV14t4y1C7UF"
        bear30.tags = "熊,北极熊,萌宠,动物圈"
        bear30.authorId = 590490400
        bear30.cover =
            "https://i0.hdslb.com/bfs/archive/ee88a5da1360deb386231fdc315adeb46fc7f3b0.jpg"
        bear30.vertical = false
        list.add(bear30)

        val bear31 = PetVideo()
        bear31.type = VideoType.BEAR.ordinal
        bear31.fileName = "pet_bear31"
        bear31.code = 1107
        bear31.duration = 132
        bear31.star = false
        bear31.title = "【白熊】小北极熊Nora 出生7天到83天的变化"
        bear31.releaseTime = 1608973209
        bear31.originalUrl = "https://www.bilibili.com/video/BV1di4y1c74e"
        bear31.tags = "熊,北极熊,萌宠,动物圈"
        bear31.authorId = 12159209
        bear31.cover =
            "https://i2.hdslb.com/bfs/archive/059fbfb596156bcefea25632fe6934981cd9f5c6.jpg"
        bear31.vertical = false
        list.add(bear31)

        val bear32 = PetVideo()
        bear32.type = VideoType.BEAR.ordinal
        bear32.fileName = "pet_bear32"
        bear32.code = 1108
        bear32.duration = 166
        bear32.star = false
        bear32.title = "北极熊也太可爱了吧？毛茸茸的大白狗"
        bear32.releaseTime = 1639365481
        bear32.originalUrl = "https://www.bilibili.com/video/BV1kr4y1D7iQ"
        bear32.tags = "熊,北极熊,萌宠,动物圈"
        bear32.authorId = 336799564
        bear32.cover =
            "https://i0.hdslb.com/bfs/archive/c51ac2fbe69775fbacc724d5251fb288d53e721f.jpg"
        bear32.vertical = false
        list.add(bear32)

        val bear33 = PetVideo()
        bear33.type = VideoType.BEAR.ordinal
        bear33.fileName = "pet_bear33"
        bear33.code = 1356
        bear33.duration = 441
        bear33.star = true
        bear33.title = "【小熊】胆小的小公主普扎"
        bear33.releaseTime = 1607591408
        bear33.originalUrl = "https://www.bilibili.com/video/BV1Xf4y1v7GW"
        bear33.tags = "熊,萌宠,动物圈"
        bear33.authorId = 12159209
        bear33.cover =
            "https://i1.hdslb.com/bfs/archive/e0658ec7719630ef16437eb7d88becf7729466ee.jpg"
        bear33.vertical = false
        list.add(bear33)

        val bear34 = PetVideo()
        bear34.type = VideoType.BEAR.ordinal
        bear34.fileName = "pet_bear34"
        bear34.code = 1357
        bear34.duration = 32
        bear34.star = false
        bear34.title = "贴好秋膘啦，准备过冬噜"
        bear34.releaseTime = 1570972125
        bear34.originalUrl = "https://www.bilibili.com/video/BV1JE411d7VM"
        bear34.tags = "熊,萌宠,动物圈"
        bear34.authorId = 814507
        bear34.cover =
            "https://i1.hdslb.com/bfs/archive/bb3197adffa1e89a498b9e1a3d8ed03c70c89bd0.jpg"
        bear34.vertical = false
        list.add(bear34)

        val bear35 = PetVideo()
        bear35.type = VideoType.BEAR.ordinal
        bear35.fileName = "pet_bear35"
        bear35.code = 1358
        bear35.duration = 72
        bear35.star = false
        bear35.title = "【熊】当肥肥姐妹花向你拱来......"
        bear35.releaseTime = 1636797610
        bear35.originalUrl = "https://www.bilibili.com/video/BV13q4y1k7hj"
        bear35.tags = "熊,萌宠,动物圈"
        bear35.authorId = 12159209
        bear35.cover =
            "https://i0.hdslb.com/bfs/archive/edbd812750c730711e0118be825ce30a1396acd9.jpg"
        bear35.vertical = false
        list.add(bear35)

        val bear36 = PetVideo()
        bear36.type = VideoType.BEAR.ordinal
        bear36.fileName = "pet_bear36"
        bear36.code = 3683
        bear36.duration = 107
        bear36.star = false
        bear36.vertical = false
        bear36.title = "可爱的小熊在野外嬉戏打闹"
        bear36.releaseTime = 1646325783
        bear36.originalUrl = "https://www.bilibili.com/video/BV1Bb4y147Sf"
        bear36.tags = "熊,萌宠,动物圈"
        bear36.authorId = 16752607
        bear36.cover =
            "https://i0.hdslb.com/bfs/archive/8e501141bd297a675851466fa05a2e3125d591a4.jpg"
        list.add(bear36)

        val bear37 = PetVideo()
        bear37.type = VideoType.BEAR.ordinal
        bear37.fileName = "pet_bear37"
        bear37.code = 3684
        bear37.duration = 284
        bear37.star = false
        bear37.vertical = false
        bear37.title = "【白熊】小北极熊太贪玩 把自己搞的超级脏兮兮"
        bear37.releaseTime = 1645002009
        bear37.originalUrl = "https://www.bilibili.com/video/BV1NS4y1G72Q"
        bear37.tags = "熊,萌宠,动物圈"
        bear37.authorId = 12159209
        bear37.cover =
            "https://i1.hdslb.com/bfs/archive/71ebb661173e18367e851a8d5b9b502f8df1c1f1.jpg"
        list.add(bear37)

        val bear38 = PetVideo()
        bear38.type = VideoType.BEAR.ordinal
        bear38.fileName = "pet_bear38"
        bear38.code = 3685
        bear38.duration = 52
        bear38.star = false
        bear38.vertical = false
        bear38.title = "【熊】熊熊一家蹭树止痒 憨乎乎"
        bear38.releaseTime = 1644829202
        bear38.originalUrl = "https://www.bilibili.com/video/BV1RY41157hR"
        bear38.tags = "熊,萌宠,动物圈"
        bear38.authorId = 12159209
        bear38.cover =
            "https://i2.hdslb.com/bfs/archive/13abffdc6818a18ed54d0a18c59fbe142d677cfd.jpg"
        list.add(bear38)

        val bear39 = PetVideo()
        bear39.type = VideoType.BEAR.ordinal
        bear39.fileName = "pet_bear39"
        bear39.code = 3693
        bear39.duration = 128
        bear39.star = false
        bear39.vertical = false
        bear39.title = "熊妈妈:我儿子好乖好可爱"
        bear39.releaseTime = 1648992054
        bear39.originalUrl = "https://www.bilibili.com/video/BV1tF41137Hk"
        bear39.tags = "熊,萌宠,动物圈"
        bear39.authorId = 63014203
        bear39.cover =
            "https://i0.hdslb.com/bfs/archive/35a6946cff599a9a0d12243122a53a29f030596e.jpg"
        list.add(bear39)

        val bear40 = PetVideo()
        bear40.type = VideoType.BEAR.ordinal
        bear40.fileName = "pet_bear40"
        bear40.code = 3694
        bear40.duration = 228
        bear40.star = false
        bear40.vertical = false
        bear40.title = "北极熊带娃"
        bear40.releaseTime = 1635736625
        bear40.originalUrl = "https://www.bilibili.com/video/BV1uR4y1E7tj"
        bear40.tags = "熊,萌宠,动物圈"
        bear40.authorId = 1419564108
        bear40.cover =
            "https://i1.hdslb.com/bfs/archive/46418811e58925a2ca09ca2b7a4f216410d033b7.jpg"
        list.add(bear40)

        val bear41 = PetVideo()
        bear41.type = VideoType.BEAR.ordinal
        bear41.fileName = "pet_bear41"
        bear41.code = 3695
        bear41.duration = 84
        bear41.star = false
        bear41.vertical = false
        bear41.title = "熊宝宝们好乖呀"
        bear41.releaseTime = 1653209680
        bear41.originalUrl = "https://www.bilibili.com/video/BV1954y1d73X"
        bear41.tags = "熊,萌宠,动物圈"
        bear41.authorId = 63014203
        bear41.cover =
            "https://i2.hdslb.com/bfs/archive/c7b1cf1baf6def17fb03d5b3526ce4c9b5b38118.jpg"
        list.add(bear41)

        val bear42 = PetVideo()
        bear42.type = VideoType.BEAR.ordinal
        bear42.fileName = "pet_bear42"
        bear42.code = 3696
        bear42.duration = 182
        bear42.star = false
        bear42.vertical = false
        bear42.title = "男鹿水族馆 和妈妈一起睡午觉的埋汰熊"
        bear42.releaseTime = 1651853400
        bear42.originalUrl = "https://www.bilibili.com/video/BV1P44y1u7f5"
        bear42.tags = "熊,萌宠,动物圈"
        bear42.authorId = 16752607
        bear42.cover =
            "https://i1.hdslb.com/bfs/archive/13886331f2eb072e876ebb69e28b82ca1ad4e6ef.jpg"
        list.add(bear42)


        return list
    }

    private fun getMonkey(): MutableList<PetVideo> {

        val monkey1 = PetVideo()
        monkey1.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey1.fileName = "pet_monkey1"
        monkey1.code = 1109
        monkey1.duration = 104
        monkey1.star = true
        monkey1.title = "侏儒狨猴：世界上最小的猴子，可以让你体验佛祖的感受"
        monkey1.releaseTime = 1637749990
        monkey1.originalUrl = "https://www.bilibili.com/video/BV18r4y1Q7g2"
        monkey1.tags = "金丝猴,萌宠,动物圈"
        monkey1.authorId = 31762728
        monkey1.cover =
            "https://i1.hdslb.com/bfs/archive/2ad38cda9d445f82250eaa3746760e4ac822401e.jpg"
        monkey1.vertical = false
        list.add(monkey1)

        val monkey2 = PetVideo()
        monkey2.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey2.fileName = "pet_monkey2"
        monkey2.code = 1110
        monkey2.duration = 22
        monkey2.star = true
        monkey2.title = "【金丝猴】这 意 境 绝 了，不 愧 是 国 宝"
        monkey2.releaseTime = 1582642688
        monkey2.originalUrl = "https://www.bilibili.com/video/BV1u7411M7u6"
        monkey2.tags = "金丝猴,萌宠,动物圈"
        monkey2.authorId = 280422925
        monkey2.cover =
            "https://i0.hdslb.com/bfs/archive/6bb9554e8b9615019b4be1e9aa8aef621b1f0588.jpg"
        monkey2.vertical = true
        list.add(monkey2)

        val monkey3 = PetVideo()
        monkey3.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey3.fileName = "pet_monkey3"
        monkey3.code = 1111
        monkey3.duration = 122
        monkey3.star = true
        monkey3.title = "可能是全站最好看的金丝猴宝宝优雅吃苹果，猴中皇族的颜值巅峰"
        monkey3.releaseTime = 1613878107
        monkey3.originalUrl = "https://www.bilibili.com/video/BV1Xh411r7Zk"
        monkey3.tags = "金丝猴,萌宠,动物圈"
        monkey3.authorId = 355152944
        monkey3.cover =
            "https://i2.hdslb.com/bfs/archive/281155469f15e365115b763c5b25cebf610de300.jpg"
        monkey3.vertical = false
        list.add(monkey3)

        val monkey4 = PetVideo()
        monkey4.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey4.fileName = "pet_monkey4"
        monkey4.code = 1112
        monkey4.duration = 129
        monkey4.star = true
        monkey4.title = "川金丝猴：集灵秀、高贵和仙气于一身"
        monkey4.releaseTime = 1597765282
        monkey4.originalUrl = "https://www.bilibili.com/video/BV1Ei4y1M71d"
        monkey4.tags = "金丝猴,萌宠,动物圈"
        monkey4.authorId = 16498742
        monkey4.cover =
            "https://i2.hdslb.com/bfs/archive/8553500fb6b7b8281b19231e3c71e643267e5c40.jpg"
        monkey4.vertical = false
        list.add(monkey4)

        val monkey5 = PetVideo()
        monkey5.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey5.fileName = "pet_monkey5"
        monkey5.code = 1113
        monkey5.duration = 51
        monkey5.star = true
        monkey5.title = "猴中贵族，国宝美猴王- 金丝猴"
        monkey5.releaseTime = 1602821324
        monkey5.originalUrl = "https://www.bilibili.com/video/BV1ei4y1j7xt"
        monkey5.tags = "金丝猴,萌宠,动物圈"
        monkey5.authorId = 474706138
        monkey5.cover =
            "https://i0.hdslb.com/bfs/archive/99be7b3338cec4ae64a3bc5fa560f95d4ba2677b.jpg"
        monkey5.vertical = false
        list.add(monkey5)

        val monkey6 = PetVideo()
        monkey6.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey6.fileName = "pet_monkey6"
        monkey6.code = 1388
        monkey6.duration = 28
        monkey6.star = true
        monkey6.title = "传说中孙悟空的原型长这样"
        monkey6.releaseTime = 1643079602
        monkey6.originalUrl = "https://www.bilibili.com/video/BV1MY41187wv"
        monkey6.tags = "金丝猴,萌宠,动物圈"
        monkey6.authorId = 1402209327
        monkey6.cover =
            "https://i2.hdslb.com/bfs/archive/b397a7117f29173ccc02c311a55082cc48965017.jpg"
        monkey6.vertical = false
        list.add(monkey6)

        val monkey7 = PetVideo()
        monkey7.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey7.fileName = "pet_monkey7"
        monkey7.code = 1389
        monkey7.duration = 219
        monkey7.star = true
        monkey7.title = "金丝猴一家的年夜饭"
        monkey7.releaseTime = 1643620699
        monkey7.originalUrl = "https://www.bilibili.com/video/BV1WS4y1y7eA"
        monkey7.tags = "金丝猴,萌宠,动物圈"
        monkey7.authorId = 20657
        monkey7.cover =
            "https://i2.hdslb.com/bfs/archive/5e15638e3c79a269b0e6994f2207f9cee15365af.jpg"
        monkey7.vertical = false
        list.add(monkey7)

        val monkey8 = PetVideo()
        monkey8.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey8.fileName = "pet_monkey8"
        monkey8.code = 1390
        monkey8.duration = 21
        monkey8.star = true
        monkey8.title = "今天大雪偶遇金丝猴国道上寻找食物"
        monkey8.releaseTime = 1640428763
        monkey8.originalUrl = "https://www.bilibili.com/video/BV1ZF411q7Fu"
        monkey8.tags = "金丝猴,萌宠,动物圈"
        monkey8.authorId = 1435076062
        monkey8.cover =
            "https://i1.hdslb.com/bfs/archive/14e663a62c8191b6ec3469bbd1d3ce647c1ccf39.jpg"
        monkey8.vertical = true
        list.add(monkey8)

        val monkey9 = PetVideo()
        monkey9.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey9.fileName = "pet_monkey9"
        monkey9.code = 3393
        monkey9.duration = 40
        monkey9.star = false
        monkey9.title = "千奇百怪的睡姿！"
        monkey9.releaseTime = 1664111411
        monkey9.originalUrl = "https://www.bilibili.com/video/BV1UB4y1J7yV"
        monkey9.tags = "金丝猴,萌宠,动物圈"
        monkey9.authorId = 501194140
        monkey9.vertical = true
        monkey9.cover =
            "https://i0.hdslb.com/bfs/archive/baa305470476dbc2529890756e62aa53c82a3b70.jpg"
        list.add(monkey9)

        val monkey10 = PetVideo()
        monkey10.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey10.fileName = "pet_monkey10"
        monkey10.code = 3394
        monkey10.duration = 20
        monkey10.star = false
        monkey10.title = "滑杆界的鼻祖～"
        monkey10.releaseTime = 1662685119
        monkey10.originalUrl = "https://www.bilibili.com/video/BV1kU4y1z7Hf"
        monkey10.tags = "金丝猴,萌宠,动物圈"
        monkey10.authorId = 501194140
        monkey10.vertical = true
        monkey10.cover =
            "https://i0.hdslb.com/bfs/archive/29d714fc52f9f4418791f532c2972ba4457c4122.jpg"
        list.add(monkey10)

        val monkey11 = PetVideo()
        monkey11.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey11.fileName = "pet_monkey11"
        monkey11.code = 3395
        monkey11.duration = 178
        monkey11.star = false
        monkey11.title = "毛孩子皮起来有多无奈！还是两只毛孩子～"
        monkey11.releaseTime = 1661168938
        monkey11.originalUrl = "https://www.bilibili.com/video/BV1ya41157NH"
        monkey11.tags = "金丝猴,萌宠,动物圈"
        monkey11.authorId = 501194140
        monkey11.vertical = true
        monkey11.cover =
            "https://i0.hdslb.com/bfs/archive/6940f124206bbd899039731157ed641745fd613e.jpg"
        list.add(monkey11)

        val monkey12 = PetVideo()
        monkey12.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey12.fileName = "pet_monkey12"
        monkey12.code = 3396
        monkey12.duration = 76
        monkey12.star = false
        monkey12.title = "窜天猴！"
        monkey12.releaseTime = 1660534514
        monkey12.originalUrl = "https://www.bilibili.com/video/BV1Eg411C7X4"
        monkey12.tags = "金丝猴,萌宠,动物圈"
        monkey12.authorId = 501194140
        monkey12.vertical = true
        monkey12.cover =
            "https://i2.hdslb.com/bfs/archive/990071f9709fc2c73f8b6db5a90a9b34c41d0b11.jpg"
        list.add(monkey12)

        val monkey13 = PetVideo()
        monkey13.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey13.fileName = "pet_monkey13"
        monkey13.code = 3397
        monkey13.duration = 86
        monkey13.star = false
        monkey13.title = "雨过天晴！毛发顺～"
        monkey13.releaseTime = 1660535052
        monkey13.originalUrl = "https://www.bilibili.com/video/BV1LS4y1x7CQ"
        monkey13.tags = "金丝猴,萌宠,动物圈"
        monkey13.authorId = 501194140
        monkey13.vertical = true
        monkey13.cover =
            "https://i1.hdslb.com/bfs/archive/843c149af6d23058d3f54492a3887b1d5ef48b53.jpg"
        list.add(monkey13)

        val monkey14 = PetVideo()
        monkey14.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey14.fileName = "pet_monkey14"
        monkey14.code = 3398
        monkey14.duration = 350
        monkey14.star = false
        monkey14.title = "爱与接纳！川金丝猴家庭日志。"
        monkey14.releaseTime = 1659353077
        monkey14.originalUrl = "https://www.bilibili.com/video/BV1jT41177qP"
        monkey14.tags = "金丝猴,萌宠,动物圈"
        monkey14.authorId = 501194140
        monkey14.vertical = true
        monkey14.cover =
            "https://i2.hdslb.com/bfs/archive/5bd10ed8057e9d43d4b3225fefd9ec645a0ea743.jpg"
        list.add(monkey14)

        val monkey15 = PetVideo()
        monkey15.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey15.fileName = "pet_monkey15"
        monkey15.code = 3399
        monkey15.duration = 70
        monkey15.star = false
        monkey15.title = "没有点功夫都不好意思出门…"
        monkey15.releaseTime = 1658723564
        monkey15.originalUrl = "https://www.bilibili.com/video/BV1JU4y1q7EV"
        monkey15.tags = "金丝猴,萌宠,动物圈"
        monkey15.authorId = 501194140
        monkey15.vertical = true
        monkey15.cover =
            "https://i0.hdslb.com/bfs/archive/b42bfbf2c1fcd16483b2f8afa4e015a833ca1b6a.jpg"
        list.add(monkey15)

        val monkey16 = PetVideo()
        monkey16.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey16.fileName = "pet_monkey16"
        monkey16.code = 3400
        monkey16.duration = 98
        monkey16.star = false
        monkey16.title = "当你遇见一群看眼趴墙的邻居，你会生气么？"
        monkey16.releaseTime = 1658723481
        monkey16.originalUrl = "https://www.bilibili.com/video/BV1zT411E77i"
        monkey16.tags = "金丝猴,萌宠,动物圈"
        monkey16.authorId = 501194140
        monkey16.vertical = true
        monkey16.cover =
            "https://i2.hdslb.com/bfs/archive/2331eaf4501f2c2362114d0cb5c7e4149c2d0835.jpg"
        list.add(monkey16)

        val monkey17 = PetVideo()
        monkey17.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey17.fileName = "pet_monkey17"
        monkey17.code = 3401
        monkey17.duration = 20
        monkey17.star = false
        monkey17.title = "天气变凉快，黑猩猩开心惨了"
        monkey17.releaseTime = 1658221502
        monkey17.originalUrl = "https://www.bilibili.com/video/BV1Jt4y1t76W"
        monkey17.tags = "金丝猴,萌宠,动物圈"
        monkey17.authorId = 673795467
        monkey17.vertical = true
        monkey17.cover =
            "https://i0.hdslb.com/bfs/archive/349d99905ba0c5f12921671a842df732186f95b9.jpg"
        list.add(monkey17)

        val monkey18 = PetVideo()
        monkey18.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey18.fileName = "pet_monkey18"
        monkey18.code = 3402
        monkey18.duration = 93
        monkey18.star = false
        monkey18.title = "避暑山庄！"
        monkey18.releaseTime = 1658145774
        monkey18.originalUrl = "https://www.bilibili.com/video/BV1bB4y1a72h"
        monkey18.tags = "金丝猴,萌宠,动物圈"
        monkey18.authorId = 501194140
        monkey18.vertical = true
        monkey18.cover =
            "https://i2.hdslb.com/bfs/archive/d1af01adaa2934782e1eb926c03d342f256a5b04.jpg"
        list.add(monkey18)

        val monkey19 = PetVideo()
        monkey19.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey19.fileName = "pet_monkey19"
        monkey19.code = 3403
        monkey19.duration = 68
        monkey19.star = false
        monkey19.title = "四宝：看娃的一天。"
        monkey19.releaseTime = 1657540879
        monkey19.originalUrl = "https://www.bilibili.com/video/BV1N34y1H7C4"
        monkey19.tags = "金丝猴,萌宠,动物圈"
        monkey19.authorId = 501194140
        monkey19.cover =
            "https://i1.hdslb.com/bfs/archive/2da9ddc836d6b12dd6a8280c8b7c2929448d4fe0.jpg"
        list.add(monkey19)

        val monkey20 = PetVideo()
        monkey20.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey20.fileName = "pet_monkey20"
        monkey20.code = 3404
        monkey20.duration = 28
        monkey20.star = false
        monkey20.title = "三媳妇最懂得三胖的坚实臂膀！"
        monkey20.releaseTime = 1656680872
        monkey20.originalUrl = "https://www.bilibili.com/video/BV1ot4y187J3"
        monkey20.tags = "金丝猴,萌宠,动物圈"
        monkey20.authorId = 501194140
        monkey20.cover =
            "https://i0.hdslb.com/bfs/archive/0847fbd8ebc6f7c6b8218613c4ced705f98676ab.jpg"
        list.add(monkey20)

        val monkey21 = PetVideo()
        monkey21.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey21.fileName = "pet_monkey21"
        monkey21.code = 3405
        monkey21.duration = 30
        monkey21.star = false
        monkey21.title = "阿炳：不用回头，跑就对了！"
        monkey21.releaseTime = 1655557343
        monkey21.originalUrl = "https://www.bilibili.com/video/BV1V34y157nU"
        monkey21.tags = "金丝猴,萌宠,动物圈"
        monkey21.authorId = 501194140
        monkey21.cover =
            "https://i1.hdslb.com/bfs/archive/ca165c8eb15325b63b11d35a7a8cbf63a821b9e3.jpg"
        list.add(monkey21)

        val monkey22 = PetVideo()
        monkey22.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey22.fileName = "pet_monkey22"
        monkey22.code = 3406
        monkey22.duration = 66
        monkey22.star = false
        monkey22.title = "大宝：吃完香蕉举高高！"
        monkey22.releaseTime = 1656333892
        monkey22.originalUrl = "https://www.bilibili.com/video/BV1zf4y1f7A6"
        monkey22.tags = "金丝猴,萌宠,动物圈"
        monkey22.authorId = 501194140
        monkey22.vertical = true
        monkey22.cover =
            "https://i2.hdslb.com/bfs/archive/7b045990f3affd2e29b9442e86c518831497d7bf.jpg"
        list.add(monkey22)

        val monkey23 = PetVideo()
        monkey23.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey23.fileName = "pet_monkey23"
        monkey23.code = 3407
        monkey23.duration = 271
        monkey23.star = false
        monkey23.title = "三宝你用的什么牌子的洗发水！"
        monkey23.releaseTime = 1654401592
        monkey23.originalUrl = "https://www.bilibili.com/video/BV1Va41177LJ"
        monkey23.tags = "金丝猴,萌宠,动物圈"
        monkey23.authorId = 501194140
        monkey23.cover =
            "https://i2.hdslb.com/bfs/archive/b2ae28298cb1a92393ec577155b0cd273d91ee88.jpg"
        list.add(monkey23)

        val monkey24 = PetVideo()
        monkey24.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey24.fileName = "pet_monkey24"
        monkey24.code = 3408
        monkey24.duration = 42
        monkey24.star = false
        monkey24.title = "三宝：这就是猴王的待遇！来自三媳妇和姑娘阿炳全方面伺候。"
        monkey24.releaseTime = 1655725887
        monkey24.originalUrl = "https://www.bilibili.com/video/BV1FU4y197To"
        monkey24.tags = "金丝猴,萌宠,动物圈"
        monkey24.authorId = 501194140
        monkey24.cover =
            "https://i0.hdslb.com/bfs/archive/8d7492ab0b2610f271392526f1932152bbdd4bc8.jpg"
        list.add(monkey24)

        val monkey25 = PetVideo()
        monkey25.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey25.fileName = "pet_monkey25"
        monkey25.code = 3409
        monkey25.duration = 108
        monkey25.star = false
        monkey25.title = "听说大家想二宝了！"
        monkey25.releaseTime = 1656156963
        monkey25.originalUrl = "https://www.bilibili.com/video/BV1uB4y1x79i"
        monkey25.tags = "金丝猴,萌宠,动物圈"
        monkey25.authorId = 501194140
        monkey25.cover =
            "https://i1.hdslb.com/bfs/archive/c9e481c7b44f814b4353a6837c7e779f98d82c87.jpg"
        list.add(monkey25)

        val monkey26 = PetVideo()
        monkey26.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey26.fileName = "pet_monkey26"
        monkey26.code = 3410
        monkey26.duration = 90
        monkey26.star = false
        monkey26.title = "调皮并不耽误我可爱！"
        monkey26.releaseTime = 1656163248
        monkey26.originalUrl = "https://www.bilibili.com/video/BV1NZ4y1i78E"
        monkey26.tags = "金丝猴,萌宠,动物圈"
        monkey26.authorId = 501194140
        monkey26.cover =
            "https://i1.hdslb.com/bfs/archive/8ead52c51a49541780b4608f630781fa9c6098d1.jpg"
        list.add(monkey26)

        val monkey27 = PetVideo()
        monkey27.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey27.fileName = "pet_monkey27"
        monkey27.code = 3411
        monkey27.duration = 137
        monkey27.star = false
        monkey27.title = "秦岭金丝猴宝宝都在托儿所里干啥"
        monkey27.releaseTime = 1656150210
        monkey27.originalUrl = "https://www.bilibili.com/video/BV1tL4y1P7pV"
        monkey27.tags = "金丝猴,萌宠,动物圈"
        monkey27.authorId = 72209046
        monkey27.cover =
            "https://i0.hdslb.com/bfs/archive/324a84735f885e46c60e9d3cb7e652a435488f74.jpg"
        list.add(monkey27)

        val monkey28 = PetVideo()
        monkey28.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey28.fileName = "pet_monkey28"
        monkey28.code = 3412
        monkey28.duration = 147
        monkey28.star = true
        monkey28.title = "心痛！金丝猴母亲抱着死亡的孩子抱了两个月"
        monkey28.releaseTime = 1656157499
        monkey28.originalUrl = "https://www.bilibili.com/video/BV1ur4y1g7qY"
        monkey28.tags = "金丝猴,萌宠,动物圈"
        monkey28.authorId = 72209046
        monkey28.cover =
            "https://i0.hdslb.com/bfs/archive/8fa7b5a5d9aa6a22ac7657251a96fa66f5140ab5.jpg"
        list.add(monkey28)

        val monkey29 = PetVideo()
        monkey29.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey29.fileName = "pet_monkey29"
        monkey29.code = 3413
        monkey29.duration = 81
        monkey29.star = false
        monkey29.title = "吃桔子的金丝猴，漂亮可爱！"
        monkey29.releaseTime = 1612386535
        monkey29.originalUrl = "https://www.bilibili.com/video/BV1Gf4y1r776"
        monkey29.tags = "金丝猴,萌宠,动物圈"
        monkey29.authorId = 686856282
        monkey29.vertical = true
        monkey29.cover =
            "https://i0.hdslb.com/bfs/archive/944329c2408f41e4bba056e6f5181dc4805f8438.jpg"
        list.add(monkey29)

        val monkey30 = PetVideo()
        monkey30.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey30.fileName = "pet_monkey30"
        monkey30.code = 3414
        monkey30.duration = 64
        monkey30.star = false
        monkey30.title = "我拍到了会微笑的金丝猴，国家一级保护动物！#滇金丝猴"
        monkey30.releaseTime = 1654771124
        monkey30.originalUrl = "https://www.bilibili.com/video/BV1pB4y1Q7eg"
        monkey30.tags = "金丝猴,萌宠,动物圈"
        monkey30.authorId = 1523830423
        monkey30.cover =
            "https://i2.hdslb.com/bfs/archive/40a5cfa433154026fe8ee0ab1a51fa6d3a74f3fe.jpg"
        list.add(monkey30)

        val monkey31 = PetVideo()
        monkey31.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey31.fileName = "pet_monkey31"
        monkey31.code = 3415
        monkey31.duration = 460
        monkey31.star = false
        monkey31.title = "猴宝宝当然也要过六一儿童节呀！（视频里面🈶五个品种的猴宝宝，你们数到了几只猴子🐒呀？😎）"
        monkey31.releaseTime = 1654096645
        monkey31.originalUrl = "https://www.bilibili.com/video/BV1fY411T7rg"
        monkey31.tags = "金丝猴,萌宠,动物圈"
        monkey31.authorId = 1372847120
        monkey31.cover =
            "https://i0.hdslb.com/bfs/archive/bb99c6963c0ef138e93c8df481746e6b126c241a.jpg"
        list.add(monkey31)

        val monkey32 = PetVideo()
        monkey32.type = VideoType.GOLDEN_MONKEY.ordinal
        monkey32.fileName = "pet_monkey32"
        monkey32.code = 3416
        monkey32.duration = 91
        monkey32.star = false
        monkey32.title = "川金丝猴——神农架国家公园的旗舰物种、明星物种"
        monkey32.releaseTime = 1646392854
        monkey32.originalUrl = "https://www.bilibili.com/video/BV1LU4y1f7NX"
        monkey32.tags = "金丝猴,萌宠,动物圈"
        monkey32.authorId = 1835882347
        monkey32.cover =
            "https://i2.hdslb.com/bfs/archive/22f15321e9b23e50c34ce52b9e9ac8b754f32db5.jpg"
        list.add(monkey32)


        return list
    }

    private fun getRedPanda(): MutableList<PetVideo> {

        val red_panda1 = PetVideo()
        red_panda1.type = VideoType.RED_PANDA.ordinal
        red_panda1.fileName = "red_panda1"
        red_panda1.code = 1173
        red_panda1.duration = 64
        red_panda1.star = true
        red_panda1.title = "这是小熊猫爸爸一个悲伤的故事——"
        red_panda1.releaseTime = 1641953619
        red_panda1.originalUrl = "https://www.bilibili.com/video/BV11Y41187hY"
        red_panda1.tags = "红熊猫,小熊猫,萌宠"
        red_panda1.authorId = 145707726
        red_panda1.cover =
            "https://i2.hdslb.com/bfs/archive/9c4a479efd77bb363f47801e3ad17221944cbbd9.jpg"
        red_panda1.vertical = false
        list.add(red_panda1)

        val red_panda2 = PetVideo()
        red_panda2.type = VideoType.RED_PANDA.ordinal
        red_panda2.fileName = "red_panda2"
        red_panda2.code = 1174
        red_panda2.duration = 37
        red_panda2.star = true
        red_panda2.title = "【小熊猫奶油】叼着竹叶的奶油也是很社会了～(￣▽￣～)~"
        red_panda2.releaseTime = 1642251322
        red_panda2.originalUrl = "https://www.bilibili.com/video/BV1v3411a7DG"
        red_panda2.tags = "红熊猫,小熊猫,萌宠"
        red_panda2.authorId = 14012576
        red_panda2.cover =
            "https://i0.hdslb.com/bfs/archive/e7706c050c879e64ebbbeb4c9ae30a7d8518ac1d.png"
        red_panda2.vertical = false
        list.add(red_panda2)

        val red_panda3 = PetVideo()
        red_panda3.type = VideoType.RED_PANDA.ordinal
        red_panda3.fileName = "red_panda3"
        red_panda3.code = 1175
        red_panda3.duration = 41
        red_panda3.star = true
        red_panda3.title = "请勿在两脚兽看不见的地方干架蟹蟹"
        red_panda3.releaseTime = 1642690818
        red_panda3.originalUrl = "https://www.bilibili.com/video/BV1E3411Y7PY"
        red_panda3.tags = "红熊猫,小熊猫,萌宠"
        red_panda3.authorId = 357115
        red_panda3.cover =
            "https://i1.hdslb.com/bfs/archive/878347cf255e99830c9c5ba2f599e52505373a7f.jpg"
        red_panda3.vertical = false
        list.add(red_panda3)

        val red_panda4 = PetVideo()
        red_panda4.type = VideoType.RED_PANDA.ordinal
        red_panda4.fileName = "red_panda4"
        red_panda4.code = 1176
        red_panda4.duration = 43
        red_panda4.star = true
        red_panda4.title = "【小胖】又厚又大的大脚板！"
        red_panda4.releaseTime = 1636196986
        red_panda4.originalUrl = "https://www.bilibili.com/video/BV1Nr4y1y7Fv"
        red_panda4.tags = "红熊猫,小熊猫,萌宠"
        red_panda4.authorId = 1372847120
        red_panda4.cover =
            "https://i1.hdslb.com/bfs/archive/64aac865fe4a0cc1bca9760b334166802d5fb5ac.jpg"
        red_panda4.vertical = false
        list.add(red_panda4)

        val red_panda5 = PetVideo()
        red_panda5.type = VideoType.RED_PANDA.ordinal
        red_panda5.fileName = "red_panda5"
        red_panda5.code = 1177
        red_panda5.duration = 31
        red_panda5.star = true
        red_panda5.title = "【小熊猫】南瓜午后"
        red_panda5.releaseTime = 1642091099
        red_panda5.originalUrl = "https://www.bilibili.com/video/BV1Aq4y117qy"
        red_panda5.tags = "红熊猫,小熊猫,萌宠"
        red_panda5.authorId = 102275905
        red_panda5.cover =
            "https://i1.hdslb.com/bfs/archive/a64f7c634e27f77a3727a513470001f09ad51771.jpg"
        red_panda5.vertical = false
        list.add(red_panda5)

        val red_panda6 = PetVideo()
        red_panda6.type = VideoType.RED_PANDA.ordinal
        red_panda6.fileName = "red_panda6"
        red_panda6.code = 1178
        red_panda6.duration = 92
        red_panda6.star = true
        red_panda6.title = "前腿淹没在草丛中的嘟嘟【小熊猫】爱眯眼的吃货：我就静静看着你"
        red_panda6.releaseTime = 1642770891
        red_panda6.originalUrl = "https://www.bilibili.com/video/BV1jY411b7da"
        red_panda6.tags = "红熊猫,小熊猫,萌宠"
        red_panda6.authorId = 355152944
        red_panda6.cover =
            "https://i0.hdslb.com/bfs/archive/c93f30a905b7f613600ce3f434778d43a73c4326.jpg"
        red_panda6.vertical = false
        list.add(red_panda6)

        val red_panda7 = PetVideo()
        red_panda7.type = VideoType.RED_PANDA.ordinal
        red_panda7.fileName = "red_panda7"
        red_panda7.code = 1179
        red_panda7.duration = 85
        red_panda7.star = true
        red_panda7.title = "钏路市动物园 跑跑跳跳的双胞胎小熊猫宝宝"
        red_panda7.releaseTime = 1641921612
        red_panda7.originalUrl = "https://www.bilibili.com/video/BV1cR4y1g7SG"
        red_panda7.tags = "红熊猫,小熊猫,萌宠"
        red_panda7.authorId = 16752607
        red_panda7.cover =
            "https://i1.hdslb.com/bfs/archive/f4b65378dfd05b242c505503ad4618f5a22c0408.jpg"
        red_panda7.vertical = false
        list.add(red_panda7)

        val red_panda8 = PetVideo()
        red_panda8.type = VideoType.RED_PANDA.ordinal
        red_panda8.fileName = "red_panda8"
        red_panda8.code = 1180
        red_panda8.duration = 82
        red_panda8.star = true
        red_panda8.title = "【小熊猫】除了可爱我都不知道能说什么了"
        red_panda8.releaseTime = 1643174273
        red_panda8.originalUrl = "https://www.bilibili.com/video/BV1QF411p7tY"
        red_panda8.tags = "红熊猫,小熊猫,萌宠"
        red_panda8.authorId = 268869409
        red_panda8.cover =
            "https://i2.hdslb.com/bfs/archive/8eea21d5859dc8d3e8b9e5f8327368cb0ee1c520.jpg"
        red_panda8.vertical = false
        list.add(red_panda8)

        val red_panda9 = PetVideo()
        red_panda9.type = VideoType.RED_PANDA.ordinal
        red_panda9.fileName = "red_panda9"
        red_panda9.code = 1181
        red_panda9.duration = 128
        red_panda9.star = true
        red_panda9.title = "雪山飞能"
        red_panda9.releaseTime = 1621665740
        red_panda9.originalUrl = "https://www.bilibili.com/video/BV19h411v7zo"
        red_panda9.tags = "红熊猫,小熊猫,萌宠"
        red_panda9.authorId = 148194763
        red_panda9.cover =
            "https://i1.hdslb.com/bfs/archive/c01d73050a68161e88cbb36ba58976da47d37a82.png"
        red_panda9.vertical = false
        list.add(red_panda9)

        val red_panda10 = PetVideo()
        red_panda10.type = VideoType.RED_PANDA.ordinal
        red_panda10.fileName = "red_panda10"
        red_panda10.code = 1182
        red_panda10.duration = 39
        red_panda10.star = true
        red_panda10.title = "【小熊猫】我堂堂“灰大王”，一能吃一大盘，不过分吧！"
        red_panda10.releaseTime = 1642051120
        red_panda10.originalUrl = "https://www.bilibili.com/video/BV1jb4y1J7T4"
        red_panda10.tags = "红熊猫,小熊猫,萌宠"
        red_panda10.authorId = 1372847120
        red_panda10.cover =
            "https://i2.hdslb.com/bfs/archive/3d3f38707936ce490d68e3ae6440a63c1382c844.jpg"
        red_panda10.vertical = false
        list.add(red_panda10)

        val red_panda11 = PetVideo()
        red_panda11.type = VideoType.RED_PANDA.ordinal
        red_panda11.fileName = "red_panda11"
        red_panda11.code = 1183
        red_panda11.duration = 24
        red_panda11.star = true
        red_panda11.title = "【小熊猫】优雅永不过时！"
        red_panda11.releaseTime = 1641464457
        red_panda11.originalUrl = "https://www.bilibili.com/video/BV12L411V7z8"
        red_panda11.tags = "红熊猫,小熊猫,萌宠"
        red_panda11.authorId = 1372847120
        red_panda11.cover =
            "https://i1.hdslb.com/bfs/archive/4b8206faaf6c830a62d2dd54b99986bc1a50cd00.jpg"
        red_panda11.vertical = false
        list.add(red_panda11)

        val red_panda12 = PetVideo()
        red_panda12.type = VideoType.RED_PANDA.ordinal
        red_panda12.fileName = "red_panda12"
        red_panda12.code = 1184
        red_panda12.duration = 343
        red_panda12.star = true
        red_panda12.title = "糖霜小熊猫【cattail Sapporo】"
        red_panda12.releaseTime = 1640008117
        red_panda12.originalUrl = "https://www.bilibili.com/video/BV19g411w71C"
        red_panda12.tags = "红熊猫,小熊猫,萌宠"
        red_panda12.authorId = 37729489
        red_panda12.cover =
            "https://i1.hdslb.com/bfs/archive/59b41458c0c55c7275b608a235bbda525a236fbc.jpg"
        red_panda12.vertical = false
        list.add(red_panda12)

        val red_panda13 = PetVideo()
        red_panda13.type = VideoType.RED_PANDA.ordinal
        red_panda13.fileName = "red_panda13"
        red_panda13.code = 1185
        red_panda13.duration = 24
        red_panda13.star = true
        red_panda13.title = "[小熊猫]唉嘿嘿，一起来玩雪呀（看我期盼的小眼神）"
        red_panda13.releaseTime = 1627876414
        red_panda13.originalUrl = "https://www.bilibili.com/video/BV14y4y157ae"
        red_panda13.tags = "红熊猫,小熊猫,萌宠"
        red_panda13.authorId = 5739237
        red_panda13.cover =
            "https://i1.hdslb.com/bfs/archive/03d456fe3dade8413263e0755a3c85708cec0d9a.jpg"
        red_panda13.vertical = false
        list.add(red_panda13)

        val red_panda14 = PetVideo()
        red_panda14.type = VideoType.RED_PANDA.ordinal
        red_panda14.fileName = "red_panda14"
        red_panda14.code = 1186
        red_panda14.duration = 135
        red_panda14.star = true
        red_panda14.title = "当小熊猫笑起来，还有什么值得我们烦躁的呢"
        red_panda14.releaseTime = 1643078967
        red_panda14.originalUrl = "https://www.bilibili.com/video/BV1bu411174s"
        red_panda14.tags = "红熊猫,小熊猫,萌宠"
        red_panda14.authorId = 145707726
        red_panda14.cover =
            "https://i2.hdslb.com/bfs/archive/e861ebf2e6f6b4ce1cc31ca06e6cf11e15434c63.jpg"
        red_panda14.vertical = false
        list.add(red_panda14)

        val red_panda15 = PetVideo()
        red_panda15.type = VideoType.RED_PANDA.ordinal
        red_panda15.fileName = "red_panda15"
        red_panda15.code = 1187
        red_panda15.duration = 58
        red_panda15.star = true
        red_panda15.title = "【油管搬运】猛男必看！柏林动物园的小能苗"
        red_panda15.releaseTime = 1598259821
        red_panda15.originalUrl = "https://www.bilibili.com/video/BV1aC4y1t7q3"
        red_panda15.tags = "红熊猫,小熊猫,萌宠"
        red_panda15.authorId = 6128722
        red_panda15.cover =
            "https://i1.hdslb.com/bfs/archive/c719dfa44f14fc99615f8bf82a7604962314f304.jpg"
        red_panda15.vertical = false
        list.add(red_panda15)

        val red_panda16 = PetVideo()
        red_panda16.type = VideoType.RED_PANDA.ordinal
        red_panda16.fileName = "red_panda16"
        red_panda16.code = 1188
        red_panda16.duration = 51
        red_panda16.star = true
        red_panda16.title = "[小熊猫]就想静静的趴着看你"
        red_panda16.releaseTime = 1631612441
        red_panda16.originalUrl = "https://www.bilibili.com/video/BV19h411H7Gq"
        red_panda16.tags = "红熊猫,小熊猫,萌宠"
        red_panda16.authorId = 5739237
        red_panda16.cover =
            "https://i2.hdslb.com/bfs/archive/376d0be73db39479bdf439ba6e0b5938c274aa85.jpg"
        red_panda16.vertical = false
        list.add(red_panda16)

        val red_panda17 = PetVideo()
        red_panda17.type = VideoType.RED_PANDA.ordinal
        red_panda17.fileName = "red_panda17"
        red_panda17.code = 1189
        red_panda17.duration = 125
        red_panda17.star = true
        red_panda17.title = "阿伟快来受死，感受下两只奶能的双重暴击"
        red_panda17.releaseTime = 1620323564
        red_panda17.originalUrl = "https://www.bilibili.com/video/BV1gB4y1w7Fc"
        red_panda17.tags = "红熊猫,小熊猫,萌宠"
        red_panda17.authorId = 148194763
        red_panda17.cover =
            "https://i1.hdslb.com/bfs/archive/e773e153f7fa7f8d1e18023139589e9d0f956772.png"
        red_panda17.vertical = false
        list.add(red_panda17)

        val red_panda18 = PetVideo()
        red_panda18.type = VideoType.RED_PANDA.ordinal
        red_panda18.fileName = "red_panda18"
        red_panda18.code = 1190
        red_panda18.duration = 61
        red_panda18.star = true
        red_panda18.title = "小熊猫妈妈和刚出生的小宝贝 第二辑"
        red_panda18.releaseTime = 1594605645
        red_panda18.originalUrl = "https://www.bilibili.com/video/BV1Ti4y1V7K8"
        red_panda18.tags = "红熊猫,小熊猫,萌宠"
        red_panda18.authorId = 268869409
        red_panda18.cover =
            "https://i2.hdslb.com/bfs/archive/0934997f4e85b9bb04ef6e0f4c3604ccae1a47f8.jpg"
        red_panda18.vertical = false
        list.add(red_panda18)

        val red_panda19 = PetVideo()
        red_panda19.type = VideoType.RED_PANDA.ordinal
        red_panda19.fileName = "red_panda19"
        red_panda19.code = 1191
        red_panda19.duration = 110
        red_panda19.star = true
        red_panda19.title = "【小小能】黑胖头！又奶又凶，超大只，巨可爱"
        red_panda19.releaseTime = 1639323851
        red_panda19.originalUrl = "https://www.bilibili.com/video/BV1Ji4y1d7uB"
        red_panda19.tags = "红熊猫,小熊猫,萌宠"
        red_panda19.authorId = 4560057
        red_panda19.cover =
            "https://i0.hdslb.com/bfs/archive/0fc121e98c0c049c3f863ad0d3d3de25606778ab.jpg"
        red_panda19.vertical = false
        list.add(red_panda19)

        val red_panda20 = PetVideo()
        red_panda20.type = VideoType.RED_PANDA.ordinal
        red_panda20.fileName = "red_panda20"
        red_panda20.code = 1192
        red_panda20.duration = 108
        red_panda20.star = true
        red_panda20.title = "【小小能】轮胎秋千再现江湖之 三能同乘"
        red_panda20.releaseTime = 1624123539
        red_panda20.originalUrl = "https://www.bilibili.com/video/BV1Xg411g7fm"
        red_panda20.tags = "红熊猫,小熊猫,萌宠"
        red_panda20.authorId = 4560057
        red_panda20.cover =
            "https://i0.hdslb.com/bfs/archive/77d899234c5f5d83df503021715ce1772bb61bcf.jpg"
        red_panda20.vertical = false
        list.add(red_panda20)

        val red_panda21 = PetVideo()
        red_panda21.type = VideoType.RED_PANDA.ordinal
        red_panda21.fileName = "red_panda21"
        red_panda21.code = 1193
        red_panda21.duration = 64
        red_panda21.star = true
        red_panda21.title = "【初雾】小甜甜有多可爱？趴个棍儿也能把人萌哭"
        red_panda21.releaseTime = 1639661641
        red_panda21.originalUrl = "https://www.bilibili.com/video/BV1W44y1J74C"
        red_panda21.tags = "红熊猫,小熊猫,萌宠"
        red_panda21.authorId = 4560057
        red_panda21.cover =
            "https://i2.hdslb.com/bfs/archive/e252eb3f703b51990a6e05d2998d96109b8c45d7.jpg"
        red_panda21.vertical = false
        list.add(red_panda21)

        val red_panda22 = PetVideo()
        red_panda22.type = VideoType.RED_PANDA.ordinal
        red_panda22.fileName = "red_panda22"
        red_panda22.code = 1194
        red_panda22.duration = 42
        red_panda22.star = true
        red_panda22.title = "【小熊猫】初雾，只要我去的够勤快，你就当从没离开过"
        red_panda22.releaseTime = 1640775600
        red_panda22.originalUrl = "https://www.bilibili.com/video/BV1cL411L7o1"
        red_panda22.tags = "红熊猫,小熊猫,萌宠"
        red_panda22.authorId = 102275905
        red_panda22.cover =
            "https://i0.hdslb.com/bfs/archive/2f80184ed50b252a63c775fbd268b2705f8497e9.jpg"
        red_panda22.vertical = false
        list.add(red_panda22)

        val red_panda23 = PetVideo()
        red_panda23.type = VideoType.RED_PANDA.ordinal
        red_panda23.fileName = "red_panda23"
        red_panda23.code = 1195
        red_panda23.duration = 1148
        red_panda23.star = true
        red_panda23.title = "【小熊猫】金牛湖的那些能"
        red_panda23.releaseTime = 1641830520
        red_panda23.originalUrl = "https://www.bilibili.com/video/BV1BY41187x9"
        red_panda23.tags = "红熊猫,小熊猫,萌宠"
        red_panda23.authorId = 102275905
        red_panda23.cover =
            "https://i1.hdslb.com/bfs/archive/6f61cba8bfd98c07f60696e4195626558e0f6ef7.jpg"
        red_panda23.vertical = false
        list.add(red_panda23)

        val red_panda24 = PetVideo()
        red_panda24.type = VideoType.RED_PANDA.ordinal
        red_panda24.fileName = "red_panda24"
        red_panda24.code = 1196
        red_panda24.duration = 25
        red_panda24.star = true
        red_panda24.title = "可爱捏"
        red_panda24.releaseTime = 1633857377
        red_panda24.originalUrl = "https://www.bilibili.com/video/BV1Kf4y1g7qg"
        red_panda24.tags = "红熊猫,小熊猫,萌宠"
        red_panda24.authorId = 1414054828
        red_panda24.cover =
            "https://i1.hdslb.com/bfs/archive/0cd2571a44a6c5ba46cd76a224b5519470b9d05c.jpg"
        red_panda24.vertical = true
        list.add(red_panda24)

        val red_panda25 = PetVideo()
        red_panda25.type = VideoType.RED_PANDA.ordinal
        red_panda25.fileName = "red_panda25"
        red_panda25.code = 1197
        red_panda25.duration = 12
        red_panda25.star = true
        red_panda25.title = "修能能，你的小脑袋瓜在想啥呢"
        red_panda25.releaseTime = 1634630242
        red_panda25.originalUrl = "https://www.bilibili.com/video/BV1kF411Y7S5"
        red_panda25.tags = "红熊猫,小熊猫,萌宠"
        red_panda25.authorId = 1414054828
        red_panda25.cover =
            "https://i0.hdslb.com/bfs/archive/9445c39e6d23c206a505d626328ba4a443fbeba3.jpg"
        red_panda25.vertical = true
        list.add(red_panda25)

        val red_panda26 = PetVideo()
        red_panda26.type = VideoType.RED_PANDA.ordinal
        red_panda26.fileName = "red_panda26"
        red_panda26.code = 1198
        red_panda26.duration = 30
        red_panda26.star = true
        red_panda26.title = "是小熊猫呀！"
        red_panda26.releaseTime = 1629178875
        red_panda26.originalUrl = "https://www.bilibili.com/video/BV1sq4y1M7rR"
        red_panda26.tags = "红熊猫,小熊猫,萌宠"
        red_panda26.authorId = 34332930
        red_panda26.cover =
            "https://i2.hdslb.com/bfs/archive/7aa6bc6a6fc2d77c1095d7b5c18e1f4165aff90a.jpg"
        red_panda26.vertical = true
        list.add(red_panda26)

        val red_panda27 = PetVideo()
        red_panda27.type = VideoType.RED_PANDA.ordinal
        red_panda27.fileName = "red_panda27"
        red_panda27.code = 1199
        red_panda27.duration = 141
        red_panda27.star = true
        red_panda27.title = "【小熊猫】灰总如厕&标记领地"
        red_panda27.releaseTime = 1642945992
        red_panda27.originalUrl = "https://www.bilibili.com/video/BV1qS4y1L7dT"
        red_panda27.tags = "红熊猫,小熊猫,萌宠"
        red_panda27.authorId = 1372847120
        red_panda27.cover =
            "https://i0.hdslb.com/bfs/archive/61076b9a4a44413d9aa58cd690bfd14fdec1245b.jpg"
        red_panda27.vertical = false
        list.add(red_panda27)

        val red_panda28 = PetVideo()
        red_panda28.type = VideoType.RED_PANDA.ordinal
        red_panda28.fileName = "red_panda28"
        red_panda28.code = 1200
        red_panda28.duration = 487
        red_panda28.star = true
        red_panda28.title = "【小熊猫】谁说要看灰灰吃竹叶呢？（去拍的时候灰灰它们已经吃的差不多了，所以看起来不是那么尽兴，哈哈哈哈哈）"
        red_panda28.releaseTime = 1640687302
        red_panda28.originalUrl = "https://www.bilibili.com/video/BV11P4y1J7Yt"
        red_panda28.tags = "红熊猫,小熊猫,萌宠"
        red_panda28.authorId = 1372847120
        red_panda28.cover =
            "https://i1.hdslb.com/bfs/archive/1940d7d95002fc48c5086c8d2c3d3d659be9dbda.jpg"
        red_panda28.vertical = false
        list.add(red_panda28)

        val red_panda29 = PetVideo()
        red_panda29.type = VideoType.RED_PANDA.ordinal
        red_panda29.fileName = "red_panda29"
        red_panda29.code = 1201
        red_panda29.duration = 93
        red_panda29.star = true
        red_panda29.title = "开小灶的男朋友(好帅，好帅)"
        red_panda29.releaseTime = 1640704746
        red_panda29.originalUrl = "https://www.bilibili.com/video/BV1SF411B7Ys"
        red_panda29.tags = "红熊猫,小熊猫,萌宠"
        red_panda29.authorId = 145707726
        red_panda29.cover =
            "https://i2.hdslb.com/bfs/archive/09944787fb90c85e70955d239a2751f4315bedab.jpg"
        red_panda29.vertical = false
        list.add(red_panda29)

        val red_panda30 = PetVideo()
        red_panda30.type = VideoType.RED_PANDA.ordinal
        red_panda30.fileName = "red_panda30"
        red_panda30.code = 1202
        red_panda30.duration = 187
        red_panda30.star = true
        red_panda30.title = "好想揪一下它的小舌头！"
        red_panda30.releaseTime = 1625367239
        red_panda30.originalUrl = "https://www.bilibili.com/video/BV1v64y1Q7fH"
        red_panda30.tags = "红熊猫,小熊猫,萌宠"
        red_panda30.authorId = 316735334
        red_panda30.cover =
            "https://i0.hdslb.com/bfs/archive/a6efe0ff41d51f9b7acd6fe034626929125df3d5.jpg"
        red_panda30.vertical = false
        list.add(red_panda30)

        val red_panda31 = PetVideo()
        red_panda31.type = VideoType.RED_PANDA.ordinal
        red_panda31.fileName = "red_panda31"
        red_panda31.code = 1203
        red_panda31.duration = 111
        red_panda31.star = true
        red_panda31.title = "别再问我为什么叫小能了，看封面"
        red_panda31.releaseTime = 1624373631
        red_panda31.originalUrl = "https://www.bilibili.com/video/BV1uw411o7Py"
        red_panda31.tags = "红熊猫,小熊猫,萌宠"
        red_panda31.authorId = 148194763
        red_panda31.cover =
            "https://i2.hdslb.com/bfs/archive/19298f9902ca950e6d5d8a9593985bd3ce248e43.png"
        red_panda31.vertical = false
        list.add(red_panda31)

        val red_panda32 = PetVideo()
        red_panda32.type = VideoType.RED_PANDA.ordinal
        red_panda32.fileName = "red_panda32"
        red_panda32.code = 1204
        red_panda32.duration = 148
        red_panda32.star = true
        red_panda32.title = "【添添、小灰灰】小灰灰想找添添玩，添添只想困觉(இдஇ; )（前几天的库存）"
        red_panda32.releaseTime = 1634622323
        red_panda32.originalUrl = "https://www.bilibili.com/video/BV1Tb4y1h71w"
        red_panda32.tags = "红熊猫,小熊猫,萌宠"
        red_panda32.authorId = 1372847120
        red_panda32.cover =
            "https://i0.hdslb.com/bfs/archive/9da9faadd3a468cb1fea52fedcfa355db97d227b.jpg"
        red_panda32.vertical = false
        list.add(red_panda32)

        val red_panda33 = PetVideo()
        red_panda33.type = VideoType.RED_PANDA.ordinal
        red_panda33.fileName = "red_panda33"
        red_panda33.code = 1205
        red_panda33.duration = 106
        red_panda33.star = true
        red_panda33.title = "你敢打我阿姨!你打我啊!别拍我头，会变笨的"
        red_panda33.releaseTime = 1641826109
        red_panda33.originalUrl = "https://www.bilibili.com/video/BV17L4y1b7E1"
        red_panda33.tags = "红熊猫,小熊猫,萌宠"
        red_panda33.authorId = 145707726
        red_panda33.cover =
            "https://i1.hdslb.com/bfs/archive/129b230821168a7834b71a22b3a8096d7e416acd.png"
        red_panda33.vertical = false
        list.add(red_panda33)

        val red_panda34 = PetVideo()
        red_panda34.type = VideoType.RED_PANDA.ordinal
        red_panda34.fileName = "red_panda34"
        red_panda34.code = 1206
        red_panda34.duration = 178
        red_panda34.star = true
        red_panda34.title = "[小熊猫大佬]你别这样看着我，我会忍不住心动的"
        red_panda34.releaseTime = 1641466895
        red_panda34.originalUrl = "https://www.bilibili.com/video/BV1iu411U7w1"
        red_panda34.tags = "红熊猫,小熊猫,萌宠"
        red_panda34.authorId = 145707726
        red_panda34.cover =
            "https://i2.hdslb.com/bfs/archive/c0a0ed42fe81b5a30e8eda23c0daed92cc1434d6.jpg"
        red_panda34.vertical = false
        list.add(red_panda34)

        val red_panda35 = PetVideo()
        red_panda35.type = VideoType.RED_PANDA.ordinal
        red_panda35.fileName = "red_panda35"
        red_panda35.code = 1382
        red_panda35.duration = 29
        red_panda35.star = true
        red_panda35.title = "【小灰灰】灰灰：我被“不明物”撞了一下腰！"
        red_panda35.releaseTime = 1633781196
        red_panda35.originalUrl = "https://www.bilibili.com/video/BV1Lr4y127FU"
        red_panda35.tags = "红熊猫,小熊猫,萌宠"
        red_panda35.authorId = 1372847120
        red_panda35.cover =
            "https://i2.hdslb.com/bfs/archive/0b3f622689aac93840bb220974280ae0c762df81.jpg"
        red_panda35.vertical = true
        list.add(red_panda35)

        val red_panda36 = PetVideo()
        red_panda36.type = VideoType.RED_PANDA.ordinal
        red_panda36.fileName = "red_panda36"
        red_panda36.code = 1383
        red_panda36.duration = 57
        red_panda36.star = true
        red_panda36.title = "灰灰来啦！"
        red_panda36.releaseTime = 1632023235
        red_panda36.originalUrl = "https://www.bilibili.com/video/BV1W341127wx"
        red_panda36.tags = "红熊猫,小熊猫,萌宠"
        red_panda36.authorId = 1372847120
        red_panda36.cover =
            "https://i2.hdslb.com/bfs/archive/493ea039646ed3c316f1c06c05d15224402e40b5.jpg"
        red_panda36.vertical = false
        list.add(red_panda36)

        val redPanda37 = PetVideo()
        redPanda37.type = VideoType.RED_PANDA.ordinal
        redPanda37.fileName = "red_panda37"
        redPanda37.code = 3319
        redPanda37.duration = 88
        redPanda37.star = false
        redPanda37.vertical = false
        redPanda37.title = "【小熊猫】单身狗勿进！😂（别问我为什么……）"
        redPanda37.releaseTime = 1663677952
        redPanda37.originalUrl = "https://www.bilibili.com/video/BV1eg41127Xc"
        redPanda37.tags = "红熊猫,小熊猫,萌宠"
        redPanda37.authorId = 1372847120
        redPanda37.cover =
            "https://i1.hdslb.com/bfs/archive/cc58a25c3470aa1f579d67225194d4a39a771f9a.jpg"
        list.add(redPanda37)

        val redPanda38 = PetVideo()
        redPanda38.type = VideoType.RED_PANDA.ordinal
        redPanda38.fileName = "red_panda38"
        redPanda38.code = 3320
        redPanda38.duration = 145
        redPanda38.star = false
        redPanda38.vertical = false
        redPanda38.title = "【小熊猫】“飓风”将整个小熊猫馆的运动气氛直接拉满！跑了几圈我已经数不清了！（不行！看样子还得分开😅，又想和小伙伴玩，又找不到合适的方式！）"
        redPanda38.releaseTime = 1663154157
        redPanda38.originalUrl = "https://www.bilibili.com/video/BV1QT411M7hL"
        redPanda38.tags = "红熊猫,小熊猫,萌宠"
        redPanda38.authorId = 1372847120
        redPanda38.cover =
            "https://i1.hdslb.com/bfs/archive/8432a67154552fb75a6e417cc0c4eb176f725ce8.jpg"
        list.add(redPanda38)

        val redPanda39 = PetVideo()
        redPanda39.type = VideoType.RED_PANDA.ordinal
        redPanda39.fileName = "red_panda39"
        redPanda39.code = 3321
        redPanda39.duration = 52
        redPanda39.star = false
        redPanda39.vertical = false
        redPanda39.title = "【小熊猫】要人家同意才能贴贴嘛～不然会挨揍的…呜呜……"
        redPanda39.releaseTime = 1661827843
        redPanda39.originalUrl = "https://www.bilibili.com/video/BV1aP4y1f7Zi"
        redPanda39.tags = "红熊猫,小熊猫,萌宠"
        redPanda39.authorId = 1372847120
        redPanda39.cover =
            "https://i1.hdslb.com/bfs/archive/7745d7b264f07f62ab49a3a88d6f71dde27301e7.jpg"
        list.add(redPanda39)

        val redPanda40 = PetVideo()
        redPanda40.type = VideoType.RED_PANDA.ordinal
        redPanda40.fileName = "red_panda40"
        redPanda40.code = 3322
        redPanda40.duration = 91
        redPanda40.star = false
        redPanda40.vertical = false
        redPanda40.title = "活泼可爱的小萌脸来啦~【小熊猫】济南动物园"
        redPanda40.releaseTime = 1660914222
        redPanda40.originalUrl = "https://www.bilibili.com/video/BV17a411d7T4"
        redPanda40.tags = "红熊猫,小熊猫,萌宠"
        redPanda40.authorId = 355152944
        redPanda40.cover =
            "https://i1.hdslb.com/bfs/archive/cbafc9b84d814a2a0c7dfba13522d1b81238e819.jpg"
        list.add(redPanda40)

        val redPanda41 = PetVideo()
        redPanda41.type = VideoType.RED_PANDA.ordinal
        redPanda41.fileName = "red_panda41"
        redPanda41.code = 3323
        redPanda41.duration = 122
        redPanda41.star = false
        redPanda41.vertical = false
        redPanda41.title = "【小熊猫】无动于衷，非常烦能！（00:47别碰我！）"
        redPanda41.releaseTime = 1659940919
        redPanda41.originalUrl = "https://www.bilibili.com/video/BV1SW4y1a7tV"
        redPanda41.tags = "红熊猫,小熊猫,萌宠"
        redPanda41.authorId = 1372847120
        redPanda41.cover =
            "https://i2.hdslb.com/bfs/archive/8bbe5db9cf2b8f32a547b31c9a2558f5e06ead3e.jpg"
        list.add(redPanda41)

        val redPanda42 = PetVideo()
        redPanda42.type = VideoType.RED_PANDA.ordinal
        redPanda42.fileName = "red_panda42"
        redPanda42.code = 3324
        redPanda42.duration = 86
        redPanda42.star = false
        redPanda42.vertical = false
        redPanda42.title = "【小熊猫】两个月大的小能苗最好rua😍（分别是布丁、悠悠、黑鬼的宝宝）"
        redPanda42.releaseTime = 1660988341
        redPanda42.originalUrl = "https://www.bilibili.com/video/BV1Qa4y1f79c"
        redPanda42.tags = "红熊猫,小熊猫,萌宠"
        redPanda42.authorId = 1372847120
        redPanda42.cover =
            "https://i1.hdslb.com/bfs/archive/cbbca79adb8e3a40d4500f75cf9a77a0f06d65d4.jpg"
        list.add(redPanda42)

        val redPanda43 = PetVideo()
        redPanda43.type = VideoType.RED_PANDA.ordinal
        redPanda43.fileName = "red_panda43"
        redPanda43.code = 3325
        redPanda43.duration = 78
        redPanda43.star = false
        redPanda43.vertical = false
        redPanda43.title = "毛特曼：首先！我没有不待见谁！只是太困了…😅【小熊猫】"
        redPanda43.releaseTime = 1660305800
        redPanda43.originalUrl = "https://www.bilibili.com/video/BV1GV4y1s7nB"
        redPanda43.tags = "红熊猫,小熊猫,萌宠"
        redPanda43.authorId = 1372847120
        redPanda43.cover =
            "https://i2.hdslb.com/bfs/archive/166eb8b6621dc57d7144151b970f49b5d9ad0d57.jpg"
        list.add(redPanda43)

        val redPanda44 = PetVideo()
        redPanda44.type = VideoType.RED_PANDA.ordinal
        redPanda44.fileName = "red_panda44"
        redPanda44.code = 3326
        redPanda44.duration = 73
        redPanda44.star = false
        redPanda44.vertical = false
        redPanda44.title = "【小熊猫】欢迎收看武术表演赛"
        redPanda44.releaseTime = 1659882697
        redPanda44.originalUrl = "https://www.bilibili.com/video/BV11d4y1N7Zr"
        redPanda44.tags = "红熊猫,小熊猫,萌宠"
        redPanda44.authorId = 268869409
        redPanda44.cover =
            "https://i2.hdslb.com/bfs/archive/689e35289a8aedac7c86fabfb5ad636f6be9f1ff.jpg"
        list.add(redPanda44)

        val redPanda45 = PetVideo()
        redPanda45.type = VideoType.RED_PANDA.ordinal
        redPanda45.fileName = "red_panda45"
        redPanda45.code = 3327
        redPanda45.duration = 106
        redPanda45.star = true
        redPanda45.vertical = false
        redPanda45.title = "【小熊猫】胖姐：眼保健操！"
        redPanda45.releaseTime = 1659270565
        redPanda45.originalUrl = "https://www.bilibili.com/video/BV1UV4y1j7vT"
        redPanda45.tags = "红熊猫,小熊猫,萌宠"
        redPanda45.authorId = 1372847120
        redPanda45.cover =
            "https://i0.hdslb.com/bfs/archive/12aa109add35bfffdd7d3a3fda6a7a4f20e864ce.jpg"
        list.add(redPanda45)

        val redPanda46 = PetVideo()
        redPanda46.type = VideoType.RED_PANDA.ordinal
        redPanda46.fileName = "red_panda46"
        redPanda46.code = 3328
        redPanda46.duration = 43
        redPanda46.star = false
        redPanda46.vertical = false
        redPanda46.title = "【小熊猫】当当当 木耳来咯"
        redPanda46.releaseTime = 1659019387
        redPanda46.originalUrl = "https://www.bilibili.com/video/BV1EV4y1E7nz"
        redPanda46.tags = "红熊猫,小熊猫,萌宠"
        redPanda46.authorId = 268869409
        redPanda46.cover =
            "https://i1.hdslb.com/bfs/archive/c91823a048e35df31ceb3b880cbd0422c171edb5.jpg"
        list.add(redPanda46)

        val redPanda47 = PetVideo()
        redPanda47.type = VideoType.RED_PANDA.ordinal
        redPanda47.fileName = "red_panda47"
        redPanda47.code = 3329
        redPanda47.duration = 80
        redPanda47.star = false
        redPanda47.vertical = false
        redPanda47.title = "【小熊猫】今日的灰总，满眼皆是添添！😍（当然还有竹叶和我🤪）"
        redPanda47.releaseTime = 1658760588
        redPanda47.originalUrl = "https://www.bilibili.com/video/BV1ye4y1Q7VH"
        redPanda47.tags = "红熊猫,小熊猫,萌宠"
        redPanda47.authorId = 1372847120
        redPanda47.cover =
            "https://i1.hdslb.com/bfs/archive/f8d250574f78b737803ed3ca080f4d152d04512d.jpg"
        list.add(redPanda47)

        val redPanda48 = PetVideo()
        redPanda48.type = VideoType.RED_PANDA.ordinal
        redPanda48.fileName = "red_panda48"
        redPanda48.code = 3330
        redPanda48.duration = 60
        redPanda48.star = false
        redPanda48.vertical = false
        redPanda48.title = "【小熊猫】看猪猪侠吃昆虫吧！（在路边捡到一只飞不起来的蝉，估计是刚蜕壳出来的吧！把它献给爱吃昆虫的猪猪侠！）"
        redPanda48.releaseTime = 1657024510
        redPanda48.originalUrl = "https://www.bilibili.com/video/BV1YB4y1i7sH"
        redPanda48.tags = "红熊猫,小熊猫,萌宠"
        redPanda48.authorId = 1372847120
        redPanda48.cover =
            "https://i2.hdslb.com/bfs/archive/1818d9caf739bae4737c7e1b10ce754338c6a632.jpg"
        list.add(redPanda48)

        val redPanda49 = PetVideo()
        redPanda49.type = VideoType.RED_PANDA.ordinal
        redPanda49.fileName = "red_panda49"
        redPanda49.code = 3331
        redPanda49.duration = 31
        redPanda49.star = false
        redPanda49.vertical = false
        redPanda49.title = "愿意把尾巴给我撸，真是一只大大方方的小能苗啊！感动(ಥ_ಥ)"
        redPanda49.releaseTime = 1631974338
        redPanda49.originalUrl = "https://www.bilibili.com/video/BV1eL411x7tX"
        redPanda49.tags = "红熊猫,小熊猫,萌宠"
        redPanda49.authorId = 1372847120
        redPanda49.cover =
            "https://i2.hdslb.com/bfs/archive/25d305c2b25b9a11721077f57be76c85ed258446.jpg"
        list.add(redPanda49)

        val redPanda50 = PetVideo()
        redPanda50.type = VideoType.RED_PANDA.ordinal
        redPanda50.fileName = "red_panda50"
        redPanda50.code = 3332
        redPanda50.duration = 59
        redPanda50.star = true
        redPanda50.vertical = false
        redPanda50.title = "【小熊猫】弃疗灰！😅"
        redPanda50.releaseTime = 1658329891
        redPanda50.originalUrl = "https://www.bilibili.com/video/BV1xG411n7CN"
        redPanda50.tags = "红熊猫,小熊猫,萌宠"
        redPanda50.authorId = 1372847120
        redPanda50.cover =
            "https://i1.hdslb.com/bfs/archive/2a24678d19fbd0a9e4a48f9c48d0854fcb1bee79.jpg"
        list.add(redPanda50)

        val redPanda51 = PetVideo()
        redPanda51.type = VideoType.RED_PANDA.ordinal
        redPanda51.fileName = "red_panda51"
        redPanda51.code = 3333
        redPanda51.duration = 129
        redPanda51.star = false
        redPanda51.vertical = false
        redPanda51.title = "【小熊猫】慢点跑啊！镜头跟不上啦！（跑酷小精灵）"
        redPanda51.releaseTime = 1658154099
        redPanda51.originalUrl = "https://www.bilibili.com/video/BV1NN4y1M7FS"
        redPanda51.tags = "红熊猫,小熊猫,萌宠"
        redPanda51.authorId = 1372847120
        redPanda51.cover =
            "https://i0.hdslb.com/bfs/archive/9990c936040f0472f373a08da8c1cecc073bc862.jpg"
        list.add(redPanda51)

        val redPanda52 = PetVideo()
        redPanda52.type = VideoType.RED_PANDA.ordinal
        redPanda52.fileName = "red_panda52"
        redPanda52.code = 3334
        redPanda52.duration = 76
        redPanda52.star = false
        redPanda52.vertical = false
        redPanda52.title = "小熊猫版本“退！退！退！”（灰总居然凶添添！）"
        redPanda52.releaseTime = 1657540806
        redPanda52.originalUrl = "https://www.bilibili.com/video/BV1gf4y1o7Vt"
        redPanda52.tags = "红熊猫,小熊猫,萌宠"
        redPanda52.authorId = 1372847120
        redPanda52.cover =
            "https://i1.hdslb.com/bfs/archive/a30bc5288d46ac6a63ee607e79add198e5d5bbc4.jpg"
        list.add(redPanda52)

        val redPanda53 = PetVideo()
        redPanda53.type = VideoType.RED_PANDA.ordinal
        redPanda53.fileName = "red_panda53"
        redPanda53.code = 3335
        redPanda53.duration = 77
        redPanda53.star = false
        redPanda53.vertical = true
        redPanda53.title = "【小宝墩墩】可可爱爱，一直存在！"
        redPanda53.releaseTime = 1633883183
        redPanda53.originalUrl = "https://www.bilibili.com/video/BV1rF411Y7eQ"
        redPanda53.tags = "红熊猫,小熊猫,萌宠"
        redPanda53.authorId = 1372847120
        redPanda53.cover =
            "https://i2.hdslb.com/bfs/archive/fb031bcac1f7cf01fee2b1d05047d7cb040612bb.jpg"
        list.add(redPanda53)

        val redPanda54 = PetVideo()
        redPanda54.type = VideoType.RED_PANDA.ordinal
        redPanda54.fileName = "red_panda54"
        redPanda54.code = 3336
        redPanda54.duration = 127
        redPanda54.star = false
        redPanda54.vertical = false
        redPanda54.title = "嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟【小熊猫】"
        redPanda54.releaseTime = 1636461897
        redPanda54.originalUrl = "https://www.bilibili.com/video/BV1vU4y1g7Va"
        redPanda54.tags = "红熊猫,小熊猫,萌宠"
        redPanda54.authorId = 355152944
        redPanda54.cover =
            "https://i0.hdslb.com/bfs/archive/6db35dd4e8580f00bd476daaa8c7aef5c4e9a6a2.jpg"
        list.add(redPanda54)

        val redPanda55 = PetVideo()
        redPanda55.type = VideoType.RED_PANDA.ordinal
        redPanda55.fileName = "red_panda55"
        redPanda55.code = 3337
        redPanda55.duration = 72
        redPanda55.star = false
        redPanda55.vertical = false
        redPanda55.title = "你肚子底下的苹果比较甜【小熊猫】"
        redPanda55.releaseTime = 1655298042
        redPanda55.originalUrl = "https://www.bilibili.com/video/BV1W94y127ds"
        redPanda55.tags = "红熊猫,小熊猫,萌宠"
        redPanda55.authorId = 355152944
        redPanda55.cover =
            "https://i1.hdslb.com/bfs/archive/75361bed1f097c73be32c5e2c3efbb6642773cf6.jpg"
        list.add(redPanda55)

        val redPanda56 = PetVideo()
        redPanda56.type = VideoType.RED_PANDA.ordinal
        redPanda56.fileName = "red_panda56"
        redPanda56.code = 3338
        redPanda56.duration = 49
        redPanda56.star = false
        redPanda56.vertical = false
        redPanda56.title = "【小熊猫】咱们灰总热得遭不住啦！（大热天的在树上挂起，不去房间里面乘凉，也不捂冰！愁死个人！）"
        redPanda56.releaseTime = 1657199475
        redPanda56.originalUrl = "https://www.bilibili.com/video/BV1nB4y1e7jv"
        redPanda56.tags = "红熊猫,小熊猫,萌宠"
        redPanda56.authorId = 1372847120
        redPanda56.cover =
            "https://i1.hdslb.com/bfs/archive/ddad9eeb7d925de24fa1f9a176f4245d965a7211.jpg"
        list.add(redPanda56)

        val redPanda57 = PetVideo()
        redPanda57.type = VideoType.RED_PANDA.ordinal
        redPanda57.fileName = "red_panda57"
        redPanda57.code = 3339
        redPanda57.duration = 21
        redPanda57.star = false
        redPanda57.vertical = true
        redPanda57.title = "【滚滚】这这这……么现实？！"
        redPanda57.releaseTime = 1637239590
        redPanda57.originalUrl = "https://www.bilibili.com/video/BV1pb4y1b7M4"
        redPanda57.tags = "红熊猫,小熊猫,萌宠"
        redPanda57.authorId = 1372847120
        redPanda57.cover =
            "https://i2.hdslb.com/bfs/archive/cde0c108f53e64de491a3d55f4e7590ce03f6430.jpg"
        list.add(redPanda57)

        val redPanda58 = PetVideo()
        redPanda58.type = VideoType.RED_PANDA.ordinal
        redPanda58.fileName = "red_panda58"
        redPanda58.code = 3340
        redPanda58.duration = 36
        redPanda58.star = false
        redPanda58.vertical = false
        redPanda58.title = "小熊猫：不可以这样的哦～"
        redPanda58.releaseTime = 1657104081
        redPanda58.originalUrl = "https://www.bilibili.com/video/BV13Z4y1Y7X7"
        redPanda58.tags = "红熊猫,小熊猫,萌宠"
        redPanda58.authorId = 1372847120
        redPanda58.cover =
            "https://i2.hdslb.com/bfs/archive/0827a0912bfbe715c15af5592dbe413cd7b27d74.jpg"
        list.add(redPanda58)

        val redPanda59 = PetVideo()
        redPanda59.type = VideoType.RED_PANDA.ordinal
        redPanda59.fileName = "red_panda59"
        redPanda59.code = 3341
        redPanda59.duration = 30
        redPanda59.star = false
        redPanda59.vertical = false
        redPanda59.title = "【小熊猫】我的爱笑女能——添添公主👸"
        redPanda59.releaseTime = 1656761902
        redPanda59.originalUrl = "https://www.bilibili.com/video/BV1if4y1Z7BY"
        redPanda59.tags = "红熊猫,小熊猫,萌宠"
        redPanda59.authorId = 1372847120
        redPanda59.cover =
            "https://i1.hdslb.com/bfs/archive/1419f25e08cc1907c8ed7c370a1c5825556c3437.jpg"
        list.add(redPanda59)

        val redPanda60 = PetVideo()
        redPanda60.type = VideoType.RED_PANDA.ordinal
        redPanda60.fileName = "red_panda60"
        redPanda60.code = 3342
        redPanda60.duration = 67
        redPanda60.star = false
        redPanda60.vertical = false
        redPanda60.title = "【小熊猫】球球又不胖，干嘛要减肥呢！"
        redPanda60.releaseTime = 1656599214
        redPanda60.originalUrl = "https://www.bilibili.com/video/BV11U4y1Q7Yz"
        redPanda60.tags = "红熊猫,小熊猫,萌宠"
        redPanda60.authorId = 1372847120
        redPanda60.cover =
            "https://i0.hdslb.com/bfs/archive/af113dc0f607ba0af69cafb1749064a48e4834a1.jpg"
        list.add(redPanda60)

        val redPanda61 = PetVideo()
        redPanda61.type = VideoType.RED_PANDA.ordinal
        redPanda61.fileName = "red_panda61"
        redPanda61.code = 3343
        redPanda61.duration = 26
        redPanda61.star = false
        redPanda61.vertical = false
        redPanda61.title = "【小熊猫】睡在房梁上的小能苗！（今天有点热呢，房间里那么凉快为什么不进内舍👀）"
        redPanda61.releaseTime = 1656467907
        redPanda61.originalUrl = "https://www.bilibili.com/video/BV1Dt4y187ZF"
        redPanda61.tags = "红熊猫,小熊猫,萌宠"
        redPanda61.authorId = 1372847120
        redPanda61.cover =
            "https://i0.hdslb.com/bfs/archive/377a410b2fc630eb951f691b0d7b8da5e967bf30.jpg"
        list.add(redPanda61)

        val redPanda62 = PetVideo()
        redPanda62.type = VideoType.RED_PANDA.ordinal
        redPanda62.fileName = "red_panda62"
        redPanda62.code = 3344
        redPanda62.duration = 191
        redPanda62.star = false
        redPanda62.vertical = false
        redPanda62.title = "【小熊猫】嫩竹竿比竹叶好吃吗？房间里面的竹叶看都不看一眼😅，跑出来追竹竿竿（00：25添添都努力到劈叉了！）"
        redPanda62.releaseTime = 1656341512
        redPanda62.originalUrl = "https://www.bilibili.com/video/BV1yB4y1p7cg"
        redPanda62.tags = "红熊猫,小熊猫,萌宠"
        redPanda62.authorId = 1372847120
        redPanda62.cover =
            "https://i0.hdslb.com/bfs/archive/9f5b1758f5c42937fcdd9a593fa09f32306e71f2.jpg"
        list.add(redPanda62)

        val redPanda63 = PetVideo()
        redPanda63.type = VideoType.RED_PANDA.ordinal
        redPanda63.fileName = "red_panda63"
        redPanda63.code = 3345
        redPanda63.duration = 94
        redPanda63.star = false
        redPanda63.vertical = false
        redPanda63.title = "【小熊猫】葡萄提子都炫能嘴里啊！"
        redPanda63.releaseTime = 1655899808
        redPanda63.originalUrl = "https://www.bilibili.com/video/BV1Nt4y1a7s2"
        redPanda63.tags = "红熊猫,小熊猫,萌宠"
        redPanda63.authorId = 1372847120
        redPanda63.cover =
            "https://i2.hdslb.com/bfs/archive/fb134c3da1d019d6f0f92c6de7564e3a6108b304.jpg"
        list.add(redPanda63)

        val redPanda64 = PetVideo()
        redPanda64.type = VideoType.RED_PANDA.ordinal
        redPanda64.fileName = "red_panda64"
        redPanda64.code = 3346
        redPanda64.duration = 116
        redPanda64.star = true
        redPanda64.vertical = false
        redPanda64.title = "【小熊猫】催眠（不是）！"
        redPanda64.releaseTime = 1655641943
        redPanda64.originalUrl = "https://www.bilibili.com/video/BV1eN4y137dM"
        redPanda64.tags = "红熊猫,小熊猫,萌宠"
        redPanda64.authorId = 1372847120
        redPanda64.cover =
            "https://i2.hdslb.com/bfs/archive/d2fdd99b3f2c93ab91f978ace58f85bf0fddc60c.jpg"
        list.add(redPanda64)

        val redPanda65 = PetVideo()
        redPanda65.type = VideoType.RED_PANDA.ordinal
        redPanda65.fileName = "red_panda65"
        redPanda65.code = 3347
        redPanda65.duration = 41
        redPanda65.star = false
        redPanda65.vertical = false
        redPanda65.title = "小能苗也有自己形影不离的好朋友呢！就像复制粘贴的一样！【小熊猫】"
        redPanda65.releaseTime = 1655084952
        redPanda65.originalUrl = "https://www.bilibili.com/video/BV1Hv4y1G7Nm"
        redPanda65.tags = "红熊猫,小熊猫,萌宠"
        redPanda65.authorId = 1372847120
        redPanda65.cover =
            "https://i0.hdslb.com/bfs/archive/ec3c0b338b3065ad953f4b53eae48d8f1c697c8a.jpg"
        list.add(redPanda65)

        val redPanda66 = PetVideo()
        redPanda66.type = VideoType.RED_PANDA.ordinal
        redPanda66.fileName = "red_panda66"
        redPanda66.code = 3348
        redPanda66.duration = 66
        redPanda66.star = false
        redPanda66.vertical = false
        redPanda66.title = "【小熊猫】童颜胖姐真的很享受头部按摩呢！"
        redPanda66.releaseTime = 1654778216
        redPanda66.originalUrl = "https://www.bilibili.com/video/BV1RU4y197PQ"
        redPanda66.tags = "红熊猫,小熊猫,萌宠"
        redPanda66.authorId = 1372847120
        redPanda66.cover =
            "https://i0.hdslb.com/bfs/archive/50afed1a506803cb847f6e47a3d405e86b2a1edd.jpg"
        list.add(redPanda66)

        val redPanda67 = PetVideo()
        redPanda67.type = VideoType.RED_PANDA.ordinal
        redPanda67.fileName = "red_panda67"
        redPanda67.code = 3349
        redPanda67.duration = 189
        redPanda67.star = false
        redPanda67.vertical = true
        redPanda67.title = "【小灰灰】是的！可爱的我又来了！"
        redPanda67.releaseTime = 1632295354
        redPanda67.originalUrl = "https://www.bilibili.com/video/BV1D341127bW"
        redPanda67.tags = "红熊猫,小熊猫,萌宠"
        redPanda67.authorId = 1372847120
        redPanda67.cover =
            "https://i2.hdslb.com/bfs/archive/24c0d499da1b8be89d37265e4782a05dfe97a63f.jpg"
        list.add(redPanda67)

        val redPanda68 = PetVideo()
        redPanda68.type = VideoType.RED_PANDA.ordinal
        redPanda68.fileName = "red_panda68"
        redPanda68.code = 3350
        redPanda68.duration = 60
        redPanda68.star = false
        redPanda68.vertical = false
        redPanda68.title = "【小熊猫】贝塔：住手！不能摸头哦～摸头会变傻！"
        redPanda68.releaseTime = 1654695686
        redPanda68.originalUrl = "https://www.bilibili.com/video/BV1ZU4y197j1"
        redPanda68.tags = "红熊猫,小熊猫,萌宠"
        redPanda68.authorId = 1372847120
        redPanda68.cover =
            "https://i2.hdslb.com/bfs/archive/7bd4963a1abce1637db2d7e877c22b8067e7798c.jpg"
        list.add(redPanda68)

        val redPanda69 = PetVideo()
        redPanda69.type = VideoType.RED_PANDA.ordinal
        redPanda69.fileName = "red_panda69"
        redPanda69.code = 3351
        redPanda69.duration = 78
        redPanda69.star = false
        redPanda69.vertical = false
        redPanda69.title = "【小熊猫】偶尔换换新口味吧～😘"
        redPanda69.releaseTime = 1654608327
        redPanda69.originalUrl = "https://www.bilibili.com/video/BV1Ag41197dM"
        redPanda69.tags = "红熊猫,小熊猫,萌宠"
        redPanda69.authorId = 1372847120
        redPanda69.cover =
            "https://i2.hdslb.com/bfs/archive/c5b4be03937f6b6090d1efbe57d221e4314a6c1a.jpg"
        list.add(redPanda69)

        val redPanda70 = PetVideo()
        redPanda70.type = VideoType.RED_PANDA.ordinal
        redPanda70.fileName = "red_panda70"
        redPanda70.code = 3352
        redPanda70.duration = 191
        redPanda70.star = false
        redPanda70.vertical = true
        redPanda70.title = "【小灰灰】要努力锻炼啊！树桩爬不好的话，将来怎么能在树上旋转跳跃呢？！万一打架了怎么脱得了身啊！自己动手，丰衣足食呢（10月初）"
        redPanda70.releaseTime = 1636713673
        redPanda70.originalUrl = "https://www.bilibili.com/video/BV1hq4y1k7g4"
        redPanda70.tags = "红熊猫,小熊猫,萌宠"
        redPanda70.authorId = 1372847120
        redPanda70.cover =
            "https://i1.hdslb.com/bfs/archive/e3a6ba2ad508bf06de93bfb47ed8f7b4a799b5c7.jpg"
        list.add(redPanda70)

        val redPanda71 = PetVideo()
        redPanda71.type = VideoType.RED_PANDA.ordinal
        redPanda71.fileName = "red_panda71"
        redPanda71.code = 3353
        redPanda71.duration = 141
        redPanda71.star = false
        redPanda71.vertical = false
        redPanda71.title = "【小熊猫】双向奔赴耶！"
        redPanda71.releaseTime = 1639658689
        redPanda71.originalUrl = "https://www.bilibili.com/video/BV1bL4y1J7oe"
        redPanda71.tags = "红熊猫,小熊猫,萌宠"
        redPanda71.authorId = 1372847120
        redPanda71.cover =
            "https://i0.hdslb.com/bfs/archive/77ddc4cf2cfe4fc8aa39daf3edb20e68e81656a0.jpg"
        list.add(redPanda71)

        val redPanda72 = PetVideo()
        redPanda72.type = VideoType.RED_PANDA.ordinal
        redPanda72.fileName = "red_panda72"
        redPanda72.code = 3354
        redPanda72.duration = 16
        redPanda72.star = false
        redPanda72.vertical = true
        redPanda72.title = "【滚滚】爱你感动吗？感动但又不敢动！"
        redPanda72.releaseTime = 1638405774
        redPanda72.originalUrl = "https://www.bilibili.com/video/BV1VF41187ri"
        redPanda72.tags = "红熊猫,小熊猫,萌宠"
        redPanda72.authorId = 1372847120
        redPanda72.cover =
            "https://i1.hdslb.com/bfs/archive/e49e63f412b55ada6b773e2f29079179975e928c.jpg"
        list.add(redPanda72)

        val redPanda73 = PetVideo()
        redPanda73.type = VideoType.RED_PANDA.ordinal
        redPanda73.fileName = "red_panda73"
        redPanda73.code = 3355
        redPanda73.duration = 30
        redPanda73.star = false
        redPanda73.vertical = true
        redPanda73.title = "【滚滚】淑女能"
        redPanda73.releaseTime = 1632839704
        redPanda73.originalUrl = "https://www.bilibili.com/video/BV1mr4y117WE"
        redPanda73.tags = "红熊猫,小熊猫,萌宠"
        redPanda73.authorId = 1372847120
        redPanda73.cover =
            "https://i0.hdslb.com/bfs/archive/6fdf6428ac88acf06a2ddc9d1af2f0a545693eae.jpg"
        list.add(redPanda73)

        val redPanda74 = PetVideo()
        redPanda74.type = VideoType.RED_PANDA.ordinal
        redPanda74.fileName = "red_panda74"
        redPanda74.code = 3356
        redPanda74.duration = 96
        redPanda74.star = false
        redPanda74.vertical = false
        redPanda74.title = "【小熊猫】00:36咱们灰总终于硬气了！"
        redPanda74.releaseTime = 1638961057
        redPanda74.originalUrl = "https://www.bilibili.com/video/BV1qR4y1s756"
        redPanda74.tags = "红熊猫,小熊猫,萌宠"
        redPanda74.authorId = 1372847120
        redPanda74.cover =
            "https://i1.hdslb.com/bfs/archive/f915d8a9c81674622c103a7315872655098a5c55.jpg"
        list.add(redPanda74)

        val redPanda75 = PetVideo()
        redPanda75.type = VideoType.RED_PANDA.ordinal
        redPanda75.fileName = "red_panda75"
        redPanda75.code = 3357
        redPanda75.duration = 69
        redPanda75.star = false
        redPanda75.vertical = false
        redPanda75.title = "【小熊猫】救命啊！铲屎官被小能包围啦～"
        redPanda75.releaseTime = 1649851286
        redPanda75.originalUrl = "https://www.bilibili.com/video/BV1oS4y1w7PX"
        redPanda75.tags = "红熊猫,小熊猫,萌宠"
        redPanda75.authorId = 1372847120
        redPanda75.cover =
            "https://i1.hdslb.com/bfs/archive/d0d037409c10ee102f1a20838196bc87b07f88f0.jpg"
        list.add(redPanda75)

        val redPanda76 = PetVideo()
        redPanda76.type = VideoType.RED_PANDA.ordinal
        redPanda76.fileName = "red_panda76"
        redPanda76.code = 3358
        redPanda76.duration = 127
        redPanda76.star = false
        redPanda76.vertical = false
        redPanda76.title = "【猪猪侠】谁……谁在叫我！"
        redPanda76.releaseTime = 1647004279
        redPanda76.originalUrl = "https://www.bilibili.com/video/BV1844y1K7BN"
        redPanda76.tags = "红熊猫,小熊猫,萌宠"
        redPanda76.authorId = 1372847120
        redPanda76.cover =
            "https://i1.hdslb.com/bfs/archive/c75ad9021e1428a9f10e7cdcb04268fe1cd232df.jpg"
        list.add(redPanda76)

        val redPanda77 = PetVideo()
        redPanda77.type = VideoType.RED_PANDA.ordinal
        redPanda77.fileName = "red_panda77"
        redPanda77.code = 3359
        redPanda77.duration = 27
        redPanda77.star = false
        redPanda77.vertical = false
        redPanda77.title = "【小熊猫】小精灵的脸脸很好捏呢！😍"
        redPanda77.releaseTime = 1654176187
        redPanda77.originalUrl = "https://www.bilibili.com/video/BV1Qa41157Bh"
        redPanda77.tags = "红熊猫,小熊猫,萌宠"
        redPanda77.authorId = 1372847120
        redPanda77.cover =
            "https://i2.hdslb.com/bfs/archive/a4f33557c0f8c0c2b6590d32351434db75cdcbac.jpg"
        list.add(redPanda77)

        val redPanda78 = PetVideo()
        redPanda78.type = VideoType.RED_PANDA.ordinal
        redPanda78.fileName = "red_panda78"
        redPanda78.code = 3360
        redPanda78.duration = 97
        redPanda78.star = false
        redPanda78.vertical = false
        redPanda78.title = "【小熊猫】端午已至，祝大家幸福安康！小熊猫们提前迎接端午啦～"
        redPanda78.releaseTime = 1654171883
        redPanda78.originalUrl = "https://www.bilibili.com/video/BV1GY411g7qE"
        redPanda78.tags = "红熊猫,小熊猫,萌宠"
        redPanda78.authorId = 1372847120
        redPanda78.cover =
            "https://i1.hdslb.com/bfs/archive/e81df1e2c40762dd64a4481a6e5fb51ca4b60fb9.jpg"
        list.add(redPanda78)

        val redPanda79 = PetVideo()
        redPanda79.type = VideoType.RED_PANDA.ordinal
        redPanda79.fileName = "red_panda79"
        redPanda79.code = 3361
        redPanda79.duration = 87
        redPanda79.star = false
        redPanda79.vertical = false
        redPanda79.title = "嘟嘟又被老冤家盼盼甩开了。。【小熊猫】"
        redPanda79.releaseTime = 1654088539
        redPanda79.originalUrl = "https://www.bilibili.com/video/BV1Tg411d7xA"
        redPanda79.tags = "红熊猫,小熊猫,萌宠"
        redPanda79.authorId = 355152944
        redPanda79.cover =
            "https://i2.hdslb.com/bfs/archive/0ca444fa2c2dab097cbadd174a41ca818262e6d0.jpg"
        list.add(redPanda79)

        val redPanda80 = PetVideo()
        redPanda80.type = VideoType.RED_PANDA.ordinal
        redPanda80.fileName = "red_panda80"
        redPanda80.code = 3362
        redPanda80.duration = 103
        redPanda80.star = false
        redPanda80.vertical = true
        redPanda80.title = "【小熊猫】今天是小灰灰呀！"
        redPanda80.releaseTime = 1651493004
        redPanda80.originalUrl = "https://www.bilibili.com/video/BV1Kv4y1K7rD"
        redPanda80.tags = "红熊猫,小熊猫,萌宠"
        redPanda80.authorId = 1372847120
        redPanda80.cover =
            "https://i2.hdslb.com/bfs/archive/6f49233225639ab46a9b880ce73e9e9cd23b0d3a.jpg"
        list.add(redPanda80)

        val redPanda81 = PetVideo()
        redPanda81.type = VideoType.RED_PANDA.ordinal
        redPanda81.fileName = "red_panda81"
        redPanda81.code = 3363
        redPanda81.duration = 80
        redPanda81.star = false
        redPanda81.vertical = false
        redPanda81.title = "【小灰灰】胆小的灰崽需要安慰！没关系，每个小伙伴都会经历的，偶尔吵架打闹也是正常的，不要总是依赖我们哦，要自己学会面对！"
        redPanda81.releaseTime = 1634297622
        redPanda81.originalUrl = "https://www.bilibili.com/video/BV1244y1x7EZ"
        redPanda81.tags = "红熊猫,小熊猫,萌宠"
        redPanda81.authorId = 1372847120
        redPanda81.cover =
            "https://i0.hdslb.com/bfs/archive/8da1641bcd48950301fed80a99518a60ba69e498.jpg"
        list.add(redPanda81)

        val redPanda82 = PetVideo()
        redPanda82.type = VideoType.RED_PANDA.ordinal
        redPanda82.fileName = "red_panda82"
        redPanda82.code = 3364
        redPanda82.duration = 105
        redPanda82.star = false
        redPanda82.vertical = false
        redPanda82.title = "【小熊猫】在竹笋面前，苹果都不香了！😅"
        redPanda82.releaseTime = 1653826347
        redPanda82.originalUrl = "https://www.bilibili.com/video/BV1iZ4y147TH"
        redPanda82.tags = "红熊猫,小熊猫,萌宠"
        redPanda82.authorId = 1372847120
        redPanda82.cover =
            "https://i0.hdslb.com/bfs/archive/1562784a52ab4aaf92805a82510ffab9d944970b.jpg"
        list.add(redPanda82)

        val redPanda83 = PetVideo()
        redPanda83.type = VideoType.RED_PANDA.ordinal
        redPanda83.fileName = "red_panda83"
        redPanda83.code = 3365
        redPanda83.duration = 51
        redPanda83.star = false
        redPanda83.vertical = false
        redPanda83.title = "【小熊猫】今日运动量已达标！累瘫！（在草丛里跳来跳去！）"
        redPanda83.releaseTime = 1652265404
        redPanda83.originalUrl = "https://www.bilibili.com/video/BV1WR4y1A7au"
        redPanda83.tags = "红熊猫,小熊猫,萌宠"
        redPanda83.authorId = 1372847120
        redPanda83.cover =
            "https://i2.hdslb.com/bfs/archive/8806da5d1a5eb57a686ad3bf923886a4bad332e5.jpg"
        list.add(redPanda83)

        val redPanda84 = PetVideo()
        redPanda84.type = VideoType.RED_PANDA.ordinal
        redPanda84.fileName = "red_panda84"
        redPanda84.code = 3366
        redPanda84.duration = 37
        redPanda84.star = true
        redPanda84.vertical = false
        redPanda84.title = "【小灰灰】这个角度挺好！显腿长呀🤪"
        redPanda84.releaseTime = 1646573127
        redPanda84.originalUrl = "https://www.bilibili.com/video/BV1ui4y1176R"
        redPanda84.tags = "红熊猫,小熊猫,萌宠"
        redPanda84.authorId = 1372847120
        redPanda84.cover =
            "https://i0.hdslb.com/bfs/archive/d7a12cc75cb6b6b8396153d01a34ee20925e729f.jpg"
        list.add(redPanda84)

        val redPanda85 = PetVideo()
        redPanda85.type = VideoType.RED_PANDA.ordinal
        redPanda85.fileName = "red_panda85"
        redPanda85.code = 3367
        redPanda85.duration = 88
        redPanda85.star = false
        redPanda85.vertical = false
        redPanda85.title = "小熊猫：到点卖萌"
        redPanda85.releaseTime = 1646212585
        redPanda85.originalUrl = "https://www.bilibili.com/video/BV1SR4y157ZZ"
        redPanda85.tags = "红熊猫,小熊猫,萌宠"
        redPanda85.authorId = 491191019
        redPanda85.cover =
            "https://i2.hdslb.com/bfs/archive/cfe888b3abc0579ea9badf5860478a25ef74ae84.jpg"
        list.add(redPanda85)

        val redPanda86 = PetVideo()
        redPanda86.type = VideoType.RED_PANDA.ordinal
        redPanda86.fileName = "red_panda86"
        redPanda86.code = 3368
        redPanda86.duration = 29
        redPanda86.star = false
        redPanda86.vertical = true
        redPanda86.title = "【添添、灰灰】鲜花🌸赠美能！（果然女能更喜欢花花）"
        redPanda86.releaseTime = 1646291496
        redPanda86.originalUrl = "https://www.bilibili.com/video/BV12r4y1z7Pt"
        redPanda86.tags = "红熊猫,小熊猫,萌宠"
        redPanda86.authorId = 1372847120
        redPanda86.cover =
            "https://i2.hdslb.com/bfs/archive/bdbb1c1d5e54b9cb47e13f958f3a20a24a43933b.jpg"
        list.add(redPanda86)

        val redPanda87 = PetVideo()
        redPanda87.type = VideoType.RED_PANDA.ordinal
        redPanda87.fileName = "red_panda87"
        redPanda87.code = 3369
        redPanda87.duration = 247
        redPanda87.star = false
        redPanda87.vertical = false
        redPanda87.title = "【小熊猫】雪中灰"
        redPanda87.releaseTime = 1645416881
        redPanda87.originalUrl = "https://www.bilibili.com/video/BV1Pi4y127dn"
        redPanda87.tags = "红熊猫,小熊猫,萌宠"
        redPanda87.authorId = 1372847120
        redPanda87.cover =
            "https://i2.hdslb.com/bfs/archive/467106203f58661747c999ec0c0028db1d89480f.jpg"
        list.add(redPanda87)

        return list
    }
}