package com.example.pandas.data

import com.example.pandas.bean.pet.PetType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object CutePetBannerData {

    private var list = mutableListOf<PetVideo>()

    fun getBannerData(): MutableList<PetVideo> {

        val panda6 = PetVideo()
        panda6.type = PetType.BIRD.ordinal
        panda6.fileName = "pet_banner1"
        panda6.code = 427
        panda6.duration = 210
        panda6.period = PeriodType.SINGLE.ordinal
        panda6.isStar = true
        panda6.title = "【鹤科混剪】鹤之舞 或许这就是神仙之姿吧 （野生鸟片系列）"
        panda6.releaseTime = "2020-03-23 18:23:38"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1WE411F7p9"
        panda6.tags = "鹤,丹顶鹤,萌宠,动物圈"
        panda6.authorName = "爱福西西一级学者"
        panda6.cover =
            "http://i0.hdslb.com/bfs/archive/7643dcb1726a5ec7b0f446edc015b5f7042476bf.jpg"
        panda6.videoType = 3
        list.add(panda6)

        val panda8 = PetVideo()
        panda8.type = PetType.FOX.ordinal
        panda8.fileName = "pet_banner2"
        panda8.code = 428
        panda8.duration = 73
        panda8.period = PeriodType.SINGLE.ordinal
        panda8.isStar = true
        panda8.title = "【北极狐】雪中精灵"
        panda8.releaseTime = "2021-05-24 18:07:20"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Gq4y1j7d5"
        panda8.tags = "萌宠,动物圈,北极狐,狐狸"
        panda8.authorName = "力度PowerC"
        panda8.cover =
            "http://i1.hdslb.com/bfs/archive/30b259a24c170e6e27d9eeb315cce28345cec181.jpg"
        panda8.videoType = 3
        list.add(panda8)

        val panda2 = PetVideo()
        panda2.type = PetType.BEAR.ordinal
        panda2.fileName = "pet_banner3"
        panda2.code = 429
        panda2.duration = 65
        panda2.period = PeriodType.SINGLE.ordinal
        panda2.isStar = true
        panda2.title = "#北极熊# 啊啊啊可爱坏了！北极熊宝宝被突然钻出来的海豹吓到"
        panda2.releaseTime = "2019-10-12 18:56:28"
        panda2.originalUrl = "https://www.bilibili.com/video/BV14E411Z7nx"
        panda2.tags = "萌宠,动物圈,北极熊"
        panda2.authorName = "Once-a-king"
        panda2.cover =
            "http://i2.hdslb.com/bfs/archive/b391bf0f6672ecfc749ed1c665a41848a79f1ecb.jpg"
        panda2.videoType = 3
        list.add(panda2)


        val panda9 = PetVideo()
        panda9.type = PetType.PENGUIN.ordinal
        panda9.fileName = "pet_banner4"
        panda9.code = 430
        panda9.duration = 80
        panda9.period = PeriodType.BABY.ordinal
        panda9.isStar = true
        panda9.title = "【企鹅】泥嚎！谁说这是滕讯实习生？他们就是坠可爱的崽！！！"
        panda9.releaseTime = "2022-01-25 18:37:35"
        panda9.originalUrl = "https://www.bilibili.com/video/BV13Y41187Xa"
        panda9.tags = "萌宠,企鹅,动物圈"
        panda9.authorName = "哔哩动物乐园"
        panda9.cover =
            "http://i0.hdslb.com/bfs/archive/8f526c9802ddc0bdc52b514751a984fe0a68633e.jpg"
        panda9.videoType = 3
        list.add(panda9)


        val panda1 = PetVideo()
        panda1.type = PetType.DEER.ordinal
        panda1.fileName = "pet_banner5"
        panda1.code = 431
        panda1.duration = 199
        panda1.period = PeriodType.SINGLE.ordinal
        panda1.isStar = true
        panda1.title = "【鹿科混剪】森之精灵"
        panda1.releaseTime = "2020-05-13 18:30:11"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1yp4y1Q7ot"
        panda1.tags = "鹿,萌宠,动物圈"
        panda1.authorName = "爱福西西一级学者"
        panda1.cover =
            "http://i2.hdslb.com/bfs/archive/b6d08e30536827c139ee059e8f165ccb732a2aed.jpg"
        panda1.videoType = 3
        list.add(panda1)


        return list
    }
}