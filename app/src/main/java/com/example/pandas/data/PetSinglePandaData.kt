package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/12/22 1:58 下午
 * @version: v1.0
 */
object PetSinglePandaData {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getSinglePandaData()
        getGrowData()
        return list
    }

    private fun getSinglePandaData(): MutableList<PetVideo> {
        val panda1 = PetVideo()
        panda1.type = VideoType.PANDA.ordinal
        panda1.fileName = "single1"
        panda1.code = 1288
        panda1.duration = 12
        panda1.period = PeriodType.SINGLE.ordinal
        panda1.isStar = false
        panda1.title = "【大熊猫萌兰】你惨啦，你坠入爱河啦←_←"
        panda1.releaseTime = "2021-12-18 10:32:15"
        panda1.originalUrl = "https://www.bilibili.com/video/BV11L4y1J7qg"
        panda1.tags = "大熊猫,萌宠,动物圈"
        panda1.authorId = 34677299
        panda1.cover =
            "https://i2.hdslb.com/bfs/archive/4280f2f815d9f208bb619d749174811704a2008a.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = VideoType.PANDA.ordinal
        panda2.fileName = "single2"
        panda2.code = 1289
        panda2.duration = 44
        panda2.period = PeriodType.SINGLE.ordinal
        panda2.isStar = false
        panda2.title = "【大熊猫萌兰】雪中奔跑的萌兰。2022.01.20.摄于北京动物园"
        panda2.releaseTime = "2022-01-20 23:24:06"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1n3411Y7MU"
        panda2.tags = "大熊猫,萌宠,动物圈"
        panda2.authorId = 518424413
        panda2.cover =
            "https://i1.hdslb.com/bfs/archive/1f78fd53fdb34f841051ff0e3941adc49670553a.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = VideoType.PANDA.ordinal
        panda3.fileName = "single3"
        panda3.code = 1290
        panda3.duration = 56
        panda3.period = PeriodType.SINGLE.ordinal
        panda3.isStar = false
        panda3.title = "快来围观棕色大熊猫七仔做体能训练"
        panda3.releaseTime = "2022-02-08 18:21:45"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1nY411L791"
        panda3.tags = "大熊猫,萌宠,动物圈"
        panda3.authorId = 90548795
        panda3.cover =
            "https://i1.hdslb.com/bfs/archive/8102e1d57b15e6bcfd53bb6960d496daaa595662.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = VideoType.PANDA.ordinal
        panda4.fileName = "single4"
        panda4.code = 1291
        panda4.duration = 16
        panda4.period = PeriodType.SINGLE.ordinal
        panda4.isStar = false
        panda4.title = "三岁了声音还是这么奶"
        panda4.releaseTime = "2018-08-04 19:02:35"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1Ns411G7Vz"
        panda4.tags = "大熊猫,萌宠,动物圈"
        panda4.authorId = 5349202
        panda4.cover =
            "https://i0.hdslb.com/bfs/archive/cfefaab68da3af08585ae6f535767de1946aac49.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = VideoType.PANDA.ordinal
        panda5.fileName = "single5"
        panda5.code = 1292
        panda5.duration = 31
        panda5.period = PeriodType.SINGLE.ordinal
        panda5.isStar = false
        panda5.title = "原来熊猫也有梳头？？？"
        panda5.releaseTime = "2021-03-23 18:28:09"
        panda5.originalUrl = "https://www.bilibili.com/video/BV16U4y1a7An"
        panda5.tags = "大熊猫,萌宠,动物圈"
        panda5.authorId = 37053244
        panda5.cover =
            "https://i0.hdslb.com/bfs/archive/03c89559ef1cca568b238300e1936f99cd39a194.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = VideoType.PANDA.ordinal
        panda6.fileName = "single6"
        panda6.code = 1293
        panda6.duration = 53
        panda6.period = PeriodType.SINGLE.ordinal
        panda6.isStar = false
        panda6.title = "毛茸茸的，躺上面已经很酥胡！"
        panda6.releaseTime = "2022-01-11 20:52:42"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1Zb4y1n7Hq"
        panda6.tags = "大熊猫,萌宠,动物圈"
        panda6.authorId = 37053244
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/dae3732891314d285bedf7ac9c537d72cbc00157.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = VideoType.PANDA.ordinal
        panda7.fileName = "single7"
        panda7.code = 1294
        panda7.duration = 86
        panda7.period = PeriodType.SINGLE.ordinal
        panda7.isStar = false
        panda7.title = "么么儿不胖，么么儿只是肉多"
        panda7.releaseTime = "2020-05-12 21:44:07"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1ka4y1i7dj"
        panda7.tags = "大熊猫,萌宠,动物圈"
        panda7.authorId = 11950577
        panda7.cover =
            "https://i1.hdslb.com/bfs/archive/6de04b85f855a9301005ad06d94d7e8fc7e30ed7.jpg"
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = VideoType.PANDA.ordinal
        panda8.fileName = "single8"
        panda8.code = 1295
        panda8.duration = 20
        panda8.period = PeriodType.SINGLE.ordinal
        panda8.isStar = false
        panda8.title = "【小馨】瞬间树叶落完了"
        panda8.releaseTime = "2021-11-15 22:16:36"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Y34y1d7hi"
        panda8.tags = "大熊猫,萌宠,动物圈"
        panda8.authorId = 1435076062
        panda8.cover =
            "https://i0.hdslb.com/bfs/archive/8d0518846bcb85161c2f3b366b768c2a640cfbde.jpg"
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = VideoType.PANDA.ordinal
        panda9.fileName = "single9"
        panda9.code = 1296
        panda9.duration = 71
        panda9.period = PeriodType.SINGLE.ordinal
        panda9.isStar = false
        panda9.title = "【小馨】贴秋膘的季节来啦"
        panda9.releaseTime = "2021-10-30 00:18:44"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1iQ4y1q7cE"
        panda9.tags = "大熊猫,萌宠,动物圈"
        panda9.authorId = 1435076062
        panda9.cover =
            "https://i0.hdslb.com/bfs/archive/ce6b25cdd29458be5cd28d8354e1f144c9c7916f.jpg"
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = VideoType.PANDA.ordinal
        panda10.fileName = "single10"
        panda10.code = 1297
        panda10.duration = 44
        panda10.period = PeriodType.SINGLE.ordinal
        panda10.isStar = false
        panda10.title = "【小馨】它昨天生日，今天补发一下"
        panda10.releaseTime = "2021-07-27 10:36:09"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1NL411n7D7"
        panda10.tags = "大熊猫,萌宠,动物圈"
        panda10.authorId = 1435076062
        panda10.cover =
            "https://i2.hdslb.com/bfs/archive/13c32c7d6bac87bf4aa0936f9694cfcb64180757.jpg"
        list.add(panda10)

        val panda11 = PetVideo()
        panda11.type = VideoType.PANDA.ordinal
        panda11.fileName = "single11"
        panda11.code = 1298
        panda11.duration = 72
        panda11.period = PeriodType.SINGLE.ordinal
        panda11.isStar = false
        panda11.title = "【小馨】秦岭深处的宝贝生活状态怎么样"
        panda11.releaseTime = "2021-05-15 01:19:01"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1hK4y197Vu"
        panda11.tags = "大熊猫,萌宠,动物圈"
        panda11.authorId = 1435076062
        panda11.cover =
            "https://i0.hdslb.com/bfs/archive/9fd1d4f5cf1448eb3d64d41703c6419263657e85.jpg"
        list.add(panda11)

        val panda12 = PetVideo()
        panda12.type = VideoType.PANDA.ordinal
        panda12.fileName = "single12"
        panda12.code = 1299
        panda12.duration = 22
        panda12.period = PeriodType.SINGLE.ordinal
        panda12.isStar = false
        panda12.title = "偶遇熊猫树上扮树梢"
        panda12.releaseTime = "2021-06-01 00:57:19"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1u64y1R7TT"
        panda12.tags = "大熊猫,萌宠,动物圈"
        panda12.authorId = 1435076062
        panda12.cover =
            "https://i2.hdslb.com/bfs/archive/a3cb59a321c276b341b6ce05d496303935579da0.jpg"
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = VideoType.PANDA.ordinal
        panda13.fileName = "single13"
        panda13.code = 1300
        panda13.duration = 18
        panda13.period = PeriodType.SINGLE.ordinal
        panda13.isStar = false
        panda13.title = "偶遇睡觉的国宝"
        panda13.releaseTime = "2022-01-25 19:01:46"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1ia411m7iy"
        panda13.tags = "大熊猫,萌宠,动物圈"
        panda13.authorId = 1435076062
        panda13.cover =
            "https://i1.hdslb.com/bfs/archive/69a8c9d6f5c53f1912cf03995ca9b85d3b9d0d06.jpg"
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = VideoType.PANDA.ordinal
        panda14.fileName = "single14"
        panda14.code = 1301
        panda14.duration = 11
        panda14.period = PeriodType.SINGLE.ordinal
        panda14.isStar = false
        panda14.title = "《 熊 猫 的 迷 惑 睡 姿 大 赏 》"
        panda14.releaseTime = "2022-01-19 20:10:27"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1TR4y1u7iG"
        panda14.tags = "大熊猫,萌宠,动物圈"
        panda14.authorId = 486483424
        panda14.cover =
            "https://i1.hdslb.com/bfs/archive/39b7d698bbc1ce0b7d521281b6db3d4c5e1d7a32.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = VideoType.PANDA.ordinal
        panda15.fileName = "single15"
        panda15.code = 1302
        panda15.duration = 50
        panda15.period = PeriodType.SINGLE.ordinal
        panda15.isStar = false
        panda15.title = "【大熊猫梅兰】【梅兰肉肉】肉姐被异常刺耳的声音吓到了又开始紧张了"
        panda15.releaseTime = "2021-10-11 23:35:33"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1JL4y167e6"
        panda15.tags = "大熊猫,萌宠,动物圈"
        panda15.authorId = 17473867
        panda15.cover =
            "https://i2.hdslb.com/bfs/archive/bb7757406c6cdaf6cad1161bbf1305855fcf84cb.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = VideoType.PANDA.ordinal
        panda16.fileName = "single16"
        panda16.code = 1303
        panda16.duration = 84
        panda16.period = PeriodType.SINGLE.ordinal
        panda16.isStar = false
        panda16.title = "【梅兰肉肉】一位喜欢跳舞的小公举～～～"
        panda16.releaseTime = "2022-01-19 11:55:35"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1iS4y1o78P"
        panda16.tags = "大熊猫,萌宠,动物圈"
        panda16.authorId = 31122700
        panda16.cover =
            "https://i1.hdslb.com/bfs/archive/243eccf40d59a7a7d6423f1a5b717104dd9b423d.jpg"
        list.add(panda16)

        val panda17 = PetVideo()
        panda17.type = VideoType.PANDA.ordinal
        panda17.fileName = "single17"
        panda17.code = 1304
        panda17.duration = 34
        panda17.period = PeriodType.SINGLE.ordinal
        panda17.isStar = false
        panda17.title = "【梅兰肉肉】【大熊猫梅兰】缩成一座肉肉山的肉宝宝也太可爱了吧，今天也想偷孩子！"
        panda17.releaseTime = "2022-01-04 18:19:58"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1hi4y197GF"
        panda17.tags = "大熊猫,萌宠,动物圈"
        panda17.authorId = 4082865
        panda17.cover =
            "https://i1.hdslb.com/bfs/archive/21f0afac0711612f0512ef45aead8de4f0ca5f2e.jpg"
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = VideoType.PANDA.ordinal
        panda18.fileName = "single18"
        panda18.code = 1305
        panda18.duration = 64
        panda18.period = PeriodType.SINGLE.ordinal
        panda18.isStar = false
        panda18.title = "【梅兰肉肉】【大熊猫梅兰】没看见胖委屈的小公举吗？怎么没有人拿南瓜来哄哄窝呀！"
        panda18.releaseTime = "2021-11-12 13:42:49"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1zv411M7yE"
        panda18.tags = "大熊猫,萌宠,动物圈"
        panda18.authorId = 31122700
        panda18.cover =
            "https://i2.hdslb.com/bfs/archive/0e1986f8fdd431e15a756fd394764e8c01dbbb0f.jpg"
        list.add(panda18)

        val panda19 = PetVideo()
        panda19.type = VideoType.PANDA.ordinal
        panda19.fileName = "single19"
        panda19.code = 1306
        panda19.duration = 28
        panda19.period = PeriodType.SINGLE.ordinal
        panda19.isStar = false
        panda19.title = "【梅兰肉肉】父慈女孝名场面，奶爸抱竹子给勇爹投喂，路过肉崽崽的院子。肉姐惊呆了，追着撵过去了～～～"
        panda19.releaseTime = "2022-01-22 19:23:47"
        panda19.originalUrl = "https://www.bilibili.com/video/BV1ra41127sk"
        panda19.tags = "大熊猫,萌宠,动物圈"
        panda19.authorId = 31122700
        panda19.cover =
            "https://i0.hdslb.com/bfs/archive/6789f25b1856382d5437e51133d28f1857ff7024.jpg"
        list.add(panda19)

        val panda20 = PetVideo()
        panda20.type = VideoType.PANDA.ordinal
        panda20.fileName = "single20"
        panda20.code = 1307
        panda20.duration = 224
        panda20.period = PeriodType.SINGLE.ordinal
        panda20.isStar = false
        panda20.title = "【大熊猫萌兰】雪中吃播。2021.11.7.摄于北京动物园"
        panda20.releaseTime = "2022-01-04 23:35:39"
        panda20.originalUrl = "https://www.bilibili.com/video/BV1M3411e7zU"
        panda20.tags = "大熊猫,萌宠,动物圈"
        panda20.authorId = 518424413
        panda20.cover =
            "https://i0.hdslb.com/bfs/archive/e94b0c8f0e97a981165801ea7639e948c4478bb2.jpg"
        list.add(panda20)

        val panda21 = PetVideo()
        panda21.type = VideoType.PANDA.ordinal
        panda21.fileName = "single21"
        panda21.code = 1308
        panda21.duration = 76
        panda21.period = PeriodType.SINGLE.ordinal
        panda21.isStar = false
        panda21.title = "【大熊猫囡囡】炸矿了！白富美熊设崩塌"
        panda21.releaseTime = "2020-03-30 11:10:02"
        panda21.originalUrl = "https://www.bilibili.com/video/BV157411D7Zf"
        panda21.tags = "大熊猫,萌宠,动物圈"
        panda21.authorId = 4120384
        panda21.cover =
            "https://i1.hdslb.com/bfs/archive/6bbbda827351963fdb162b41f33b859ef13ae01c.jpg"
        list.add(panda21)

        val panda22 = PetVideo()
        panda22.type = VideoType.PANDA.ordinal
        panda22.fileName = "single22"
        panda22.code = 1309
        panda22.duration = 51
        panda22.period = PeriodType.SINGLE.ordinal
        panda22.isStar = false
        panda22.title = "囡囡特殊的上树方式"
        panda22.releaseTime = "2018-02-12 20:08:34"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1EW411E7Wu"
        panda22.tags = "大熊猫,萌宠,动物圈"
        panda22.authorId = 12444306
        panda22.cover =
            "https://i2.hdslb.com/bfs/archive/93b7676862e79148bd7e031d52605dd957a46c96.jpg"
        list.add(panda22)

        val panda23 = PetVideo()
        panda23.type = VideoType.PANDA.ordinal
        panda23.fileName = "single23"
        panda23.code = 1310
        panda23.duration = 107
        panda23.period = PeriodType.SINGLE.ordinal
        panda23.isStar = false
        panda23.title = "【梅兰肉肉】肉某邪魅一笑，靠到起心爱的小竹筐吃笋笋"
        panda23.releaseTime = "2019-12-14 01:25:09"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1fJ411C7ji"
        panda23.tags = "大熊猫,萌宠,动物圈"
        panda23.authorId = 4824125
        panda23.cover =
            "https://i0.hdslb.com/bfs/archive/b61d6bf45eb2f2e10d3abf1da9664066cbfaa61d.jpg"
        list.add(panda23)

        val panda24 = PetVideo()
        panda24.type = VideoType.PANDA.ordinal
        panda24.fileName = "single24"
        panda24.code = 1311
        panda24.duration = 67
        panda24.period = PeriodType.SINGLE.ordinal
        panda24.isStar = false
        panda24.title = "小润润吃竹子。1.18 【大熊猫园润】"
        panda24.releaseTime = "2022-01-19 21:06:23"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1PT4y1271y"
        panda24.tags = "大熊猫,萌宠,动物圈"
        panda24.authorId = 514531996
        panda24.cover =
            "https://i2.hdslb.com/bfs/archive/46c5331f6e719c75c3a482aede811ca7c043b5e9.jpg"
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = VideoType.PANDA.ordinal
        panda25.fileName = "single25"
        panda25.code = 1312
        panda25.duration = 99
        panda25.period = PeriodType.SINGLE.ordinal
        panda25.isStar = false
        panda25.title = "【大熊猫奥莉奥】这就叫猪圆玉润！总裁气质不是一般熊能比的~"
        panda25.releaseTime = "2020-02-12 11:15:48"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1u7411L7mc"
        panda25.tags = "大熊猫,萌宠,动物圈"
        panda25.authorId = 4120384
        panda25.cover =
            "https://i2.hdslb.com/bfs/archive/a26ec8e4c599c48fd6a46c3b89df83723ba39746.jpg"
        list.add(panda25)

        val panda26 = PetVideo()
        panda26.type = VideoType.PANDA.ordinal
        panda26.fileName = "single26"
        panda26.code = 1313
        panda26.duration = 170
        panda26.period = PeriodType.SINGLE.ordinal
        panda26.isStar = false
        panda26.title = "【大熊猫肉肉】洗澡澡，过新年咯！"
        panda26.releaseTime = "2021-02-11 17:50:40"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1ef4y1z7Ps"
        panda26.tags = "大熊猫,萌宠,动物圈"
        panda26.authorId = 43296249
        panda26.cover =
            "https://i1.hdslb.com/bfs/archive/ac38e8c03b5f9742367404b7c8e413d330ccbae8.jpg"
        list.add(panda26)

        val panda27 = PetVideo()
        panda27.type = VideoType.PANDA.ordinal
        panda27.fileName = "single27"
        panda27.code = 1314
        panda27.duration = 63
        panda27.period = PeriodType.SINGLE.ordinal
        panda27.isStar = false
        panda27.title = "【绩兰】当奶妈没有按照“约定”放置窝窝头后，胖兰发脾气了"
        panda27.releaseTime = "2022-01-11 13:00:18"
        panda27.originalUrl = "https://www.bilibili.com/video/BV1gL4y1b7sG"
        panda27.tags = "大熊猫,萌宠,动物圈"
        panda27.authorId = 373529092
        panda27.cover =
            "https://i0.hdslb.com/bfs/archive/7eace834f483011786884ad7b6b7ab9b966c5908.jpg"
        list.add(panda27)

        val panda28 = PetVideo()
        panda28.type = VideoType.PANDA.ordinal
        panda28.fileName = "single28"
        panda28.code = 1315
        panda28.duration = 213
        panda28.period = PeriodType.SINGLE.ordinal
        panda28.isStar = false
        panda28.title = "【大熊猫萌兰】叫熊家“脏脏包”泥萌良心不会痛么←_←"
        panda28.releaseTime = "2019-02-18 19:23:12"
        panda28.originalUrl = "https://www.bilibili.com/video/BV11b411178f"
        panda28.tags = "大熊猫,萌宠,动物圈"
        panda28.authorId = 34677299
        panda28.cover =
            "https://i0.hdslb.com/bfs/archive/90f9f912c81b6a2361d7bd43c6602b28d9ccc84d.jpg"
        list.add(panda28)

        val panda29 = PetVideo()
        panda29.type = VideoType.PANDA.ordinal
        panda29.fileName = "single29"
        panda29.code = 1316
        panda29.duration = 207
        panda29.period = PeriodType.SINGLE.ordinal
        panda29.isStar = false
        panda29.title = "【大熊猫萌兰】胖妹儿，过来！看哥给你表演一个"
        panda29.releaseTime = "2021-12-17 18:59:07"
        panda29.originalUrl = "https://www.bilibili.com/video/BV1ER4y1W71X"
        panda29.tags = "大熊猫,萌宠,动物圈"
        panda29.authorId = 34677299
        panda29.cover =
            "https://i2.hdslb.com/bfs/archive/96c88000779215ec24b375a74376eaf1412282cf.jpg"
        list.add(panda29)

        val panda30 = PetVideo()
        panda30.type = VideoType.PANDA.ordinal
        panda30.fileName = "single30"
        panda30.code = 1317
        panda30.duration = 79
        panda30.period = PeriodType.SINGLE.ordinal
        panda30.isStar = true
        panda30.title = "【大熊猫奥莉奥】奥总裁吃窝头"
        panda30.releaseTime = "2020-04-29 12:40:21"
        panda30.originalUrl = "https://www.bilibili.com/video/BV1ak4y1r7E6"
        panda30.tags = "大熊猫,萌宠,动物圈"
        panda30.authorId = 19715714
        panda30.cover =
            "https://i2.hdslb.com/bfs/archive/333d17352ca5fe00f17c6d2123a4227f440f4659.jpg"
        list.add(panda30)

        val panda31 = PetVideo()
        panda31.type = VideoType.PANDA.ordinal
        panda31.fileName = "single31"
        panda31.code = 1318
        panda31.duration = 23
        panda31.period = PeriodType.SINGLE.ordinal
        panda31.isStar = false
        panda31.title = "【大熊猫皓月】你是哪里来的小仙童？睡觉也要露出甜甜的笑容！！"
        panda31.releaseTime = "2019-10-02 13:00:54"
        panda31.originalUrl = "https://www.bilibili.com/video/BV1PE411Q75p"
        panda31.tags = "大熊猫,萌宠,动物圈"
        panda31.authorId = 13987057
        panda31.cover =
            "https://i0.hdslb.com/bfs/archive/bdeb9f8772e958fe21241726d94d93d58b927174.jpg"
        list.add(panda31)

        val panda32 = PetVideo()
        panda32.type = VideoType.PANDA.ordinal
        panda32.fileName = "single32"
        panda32.code = 1319
        panda32.duration = 13
        panda32.period = PeriodType.SINGLE.ordinal
        panda32.isStar = false
        panda32.title = "你肉傻笑暴击（大熊猫梅兰）"
        panda32.releaseTime = "2018-05-12 13:00:30"
        panda32.originalUrl = "https://www.bilibili.com/video/BV1PW411F7WU"
        panda32.tags = "大熊猫,萌宠,动物圈"
        panda32.authorId = 281381350
        panda32.cover =
            "https://i1.hdslb.com/bfs/archive/cfd7ea43af5ef75c58b590787274525bc25d3331.jpg"
        list.add(panda32)

        val panda33 = PetVideo()
        panda33.type = VideoType.PANDA.ordinal
        panda33.fileName = "single33"
        panda33.code = 1320
        panda33.duration = 30
        panda33.period = PeriodType.SINGLE.ordinal
        panda33.isStar = false
        panda33.title = "【梅兰肉肉】熊掌的味道肉肉知道！"
        panda33.releaseTime = "2019-11-10 06:53:12"
        panda33.originalUrl = "https://www.bilibili.com/video/BV1rE411v7Zg"
        panda33.tags = "大熊猫,萌宠,动物圈"
        panda33.authorId = 4824125
        panda33.cover =
            "https://i2.hdslb.com/bfs/archive/d2b70c87326b5f5567b694145f21e450da12dc1c.jpg"
        list.add(panda33)

        val panda34 = PetVideo()
        panda34.type = VideoType.PANDA.ordinal
        panda34.fileName = "single34"
        panda34.code = 1321
        panda34.duration = 22
        panda34.period = PeriodType.SINGLE.ordinal
        panda34.isStar = false
        panda34.title = "戏精大熊猫肉肉和山竹"
        panda34.releaseTime = "2021-04-27 14:57:13"
        panda34.originalUrl = "https://www.bilibili.com/video/BV1xB4y1c7NM"
        panda34.tags = "大熊猫,萌宠,动物圈"
        panda34.authorId = 484657707
        panda34.cover =
            "https://i2.hdslb.com/bfs/archive/ca4fae1be4eaa2d51cfcbac03dfda715d148c6f6.jpg"
        list.add(panda34)

        val panda35 = PetVideo()
        panda35.type = VideoType.PANDA.ordinal
        panda35.fileName = "single35"
        panda35.code = 1322
        panda35.duration = 38
        panda35.period = PeriodType.SINGLE.ordinal
        panda35.isStar = false
        panda35.title = "【大熊猫梅兰】无声的卖萌 我已晕倒"
        panda35.releaseTime = "2020-10-24 20:48:32"
        panda35.originalUrl = "https://www.bilibili.com/video/BV1ut4y1e7hP"
        panda35.tags = "大熊猫,萌宠,动物圈"
        panda35.authorId = 17473867
        panda35.cover =
            "https://i2.hdslb.com/bfs/archive/2e52cd3589592cb5c6bc58f1622c6c486e2443c4.jpg"
        list.add(panda35)

        val panda36 = PetVideo()
        panda36.type = VideoType.PANDA.ordinal
        panda36.fileName = "single36"
        panda36.code = 1323
        panda36.duration = 101
        panda36.period = PeriodType.SINGLE.ordinal
        panda36.isStar = false
        panda36.title = "【大熊猫莉莉】27岁“不老”女神 希望你健康快乐"
        panda36.releaseTime = "2019-08-09 11:10:35"
        panda36.originalUrl = "https://www.bilibili.com/video/BV1Nt411K7NK"
        panda36.tags = "大熊猫,萌宠,动物圈"
        panda36.authorId = 4120384
        panda36.cover =
            "https://i1.hdslb.com/bfs/archive/e83e014183c3fd6eb523364ad2f823fdee678424.jpg"
        list.add(panda36)

        val panda37 = PetVideo()
        panda37.type = VideoType.PANDA.ordinal
        panda37.fileName = "single37"
        panda37.code = 1324
        panda37.duration = 47
        panda37.period = PeriodType.SINGLE.ordinal
        panda37.isStar = false
        panda37.title = "正在吃饭，竹筐突然弹过来，把大熊猫迎迎吓坏了"
        panda37.releaseTime = "2019-08-11 13:30:07"
        panda37.originalUrl = "https://www.bilibili.com/video/BV1f4411Q7K7"
        panda37.tags = "大熊猫,萌宠,动物圈"
        panda37.authorId = 12444306
        panda37.cover =
            "https://i0.hdslb.com/bfs/archive/b5ffada081078ac120eb2b0774c98e8704b148b2.jpg"
        list.add(panda37)

        val panda38 = PetVideo()
        panda38.type = VideoType.PANDA.ordinal
        panda38.fileName = "single38"
        panda38.code = 1325
        panda38.duration = 95
        panda38.period = PeriodType.SINGLE.ordinal
        panda38.isStar = false
        panda38.title = "囡囡：我！不！胖！！！！！！"
        panda38.releaseTime = "2018-01-02 21:00:54"
        panda38.originalUrl = "https://www.bilibili.com/video/BV1ZW411q7JD"
        panda38.tags = "大熊猫,萌宠,动物圈"
        panda38.authorId = 12444306
        panda38.cover =
            "https://i2.hdslb.com/bfs/archive/167a10acf2e4ffc0a75f2e0e8c7ca6cb3ffde0f6.jpg"
        list.add(panda38)

        val panda39 = PetVideo()
        panda39.type = VideoType.PANDA.ordinal
        panda39.fileName = "single39"
        panda39.code = 1326
        panda39.duration = 66
        panda39.period = PeriodType.SINGLE.ordinal
        panda39.isStar = false
        panda39.title = "囡囡是怎么长胖的？"
        panda39.releaseTime = "2017-09-24 20:05:08"
        panda39.originalUrl = "https://www.bilibili.com/video/BV18x411x796"
        panda39.tags = "大熊猫,萌宠,动物圈"
        panda39.authorId = 12444306
        panda39.cover =
            "https://i2.hdslb.com/bfs/archive/8a325e7a5e5832628a51b6f25d3a724dfba430ed.jpg"
        list.add(panda39)

        val panda40 = PetVideo()
        panda40.type = VideoType.PANDA.ordinal
        panda40.fileName = "single40"
        panda40.code = 1327
        panda40.duration = 42
        panda40.period = PeriodType.SINGLE.ordinal
        panda40.isStar = false
        panda40.title = "【大熊猫成就】九九，有什么心事吗？"
        panda40.releaseTime = "2022-01-05 21:22:34"
        panda40.originalUrl = "https://www.bilibili.com/video/BV1AT4y1m7Qu"
        panda40.tags = "大熊猫,萌宠,动物圈"
        panda40.authorId = 34677299
        panda40.cover =
            "https://i2.hdslb.com/bfs/archive/b50dd830cc6db66bada6f9e4c7a7ba5f3f0d82b8.jpg"
        list.add(panda40)

        val panda41 = PetVideo()
        panda41.type = VideoType.PANDA.ordinal
        panda41.fileName = "single41"
        panda41.code = 1916
        panda41.duration = 208
        panda41.period = PeriodType.SINGLE.ordinal
        panda41.isStar = false
        panda41.title = "【大熊猫福星】今天上午胖大海再次趴在吊篮上狼吞虎咽吃笋"
        panda41.releaseTime = "2022-03-11 13:22:24"
        panda41.originalUrl = "https://www.bilibili.com/video/BV1Li4y1C7Gr"
        panda41.tags = "大熊猫,萌宠,动物圈"
        panda41.authorId = 3232184
        panda41.cover =
            "https://i2.hdslb.com/bfs/archive/dffaabbd2e19c0c15ca4db8a774adf988bb99e18.jpg"
        list.add(panda41)

        val panda42 = PetVideo()
        panda42.type = VideoType.PANDA.ordinal
        panda42.fileName = "single42"
        panda42.code = 1917
        panda42.duration = 18
        panda42.period = PeriodType.SINGLE.ordinal
        panda42.isStar = false
        panda42.title = "炸弹炸过的朵朵（小丫）"
        panda42.releaseTime = "2021-06-01 23:42:05"
        panda42.originalUrl = "https://www.bilibili.com/video/BV1L64y1R7iZ"
        panda42.tags = "大熊猫,萌宠,动物圈"
        panda42.authorId = 231314384
        panda42.cover =
            "https://i2.hdslb.com/bfs/archive/557bf43402213b8fa95f3fb8c511cdc86f6f7b93.jpg"
        list.add(panda42)

        val panda43 = PetVideo()
        panda43.type = VideoType.PANDA.ordinal
        panda43.fileName = "single43"
        panda43.code = 1918
        panda43.duration = 91
        panda43.period = PeriodType.SINGLE.ordinal
        panda43.isStar = false
        panda43.title = "北京动物园-大熊猫福星【胖大海】"
        panda43.releaseTime = "2022-02-28 21:28:57"
        panda43.originalUrl = "https://www.bilibili.com/video/BV1HR4y157iK"
        panda43.tags = "大熊猫,萌宠,动物圈"
        panda43.authorId = 175546072
        panda43.cover =
            "https://i0.hdslb.com/bfs/archive/cb3aa10fd7a4e19bf8529d678c6096d291145b79.jpg"
        list.add(panda43)

        val panda44 = PetVideo()
        panda44.type = VideoType.PANDA.ordinal
        panda44.fileName = "single44"
        panda44.code = 1919
        panda44.duration = 23
        panda44.period = PeriodType.SINGLE.ordinal
        panda44.isStar = false
        panda44.title = "两手不空吃到嗨翻天【小馨】"
        panda44.releaseTime = "2022-03-07 22:25:34"
        panda44.originalUrl = "https://www.bilibili.com/video/BV12T4y1S7vG"
        panda44.tags = "大熊猫,萌宠,动物圈"
        panda44.authorId = 1435076062
        panda44.cover =
            "https://i2.hdslb.com/bfs/archive/1e14dc15cd1933b2a8896feb6259fde10ca56f5d.jpg"
        list.add(panda44)

        val panda45 = PetVideo()
        panda45.type = VideoType.PANDA.ordinal
        panda45.fileName = "single45"
        panda45.code = 1920
        panda45.duration = 66
        panda45.period = PeriodType.SINGLE.ordinal
        panda45.isStar = false
        panda45.title = "奇一泡澡可爱到不行，众游客惊呼绝了，太可爱了"
        panda45.releaseTime = "2021-08-09 10:58:10"
        panda45.originalUrl = "https://www.bilibili.com/video/BV19g411L7x4"
        panda45.tags = "大熊猫,萌宠,动物圈"
        panda45.authorId = 627116323
        panda45.cover =
            "https://i2.hdslb.com/bfs/archive/26faa501f51d76b65d8bb7bf8cdb66598a0b4008.jpg"
        list.add(panda45)

        val panda46 = PetVideo()
        panda46.type = VideoType.PANDA.ordinal
        panda46.fileName = "single46"
        panda46.code = 1921
        panda46.duration = 73
        panda46.period = PeriodType.SINGLE.ordinal
        panda46.isStar = false
        panda46.title = "【大熊猫萌萌】萌三岁，你真的有三岁吗？？？"
        panda46.releaseTime = "2019-08-31 00:18:44"
        panda46.originalUrl = "https://www.bilibili.com/video/BV1v441127Qs"
        panda46.tags = "大熊猫,萌宠,动物圈"
        panda46.authorId = 34677299
        panda46.cover =
            "https://i1.hdslb.com/bfs/archive/70db446ffd35e4dff68839f3bf638aa2ab332322.jpg"
        list.add(panda46)

        val panda47 = PetVideo()
        panda47.type = VideoType.PANDA.ordinal
        panda47.fileName = "single47"
        panda47.code = 1922
        panda47.duration = 98
        panda47.period = PeriodType.SINGLE.ordinal
        panda47.isStar = false
        panda47.title = "【梅兰肉肉】没见过胖熊猫上树吗？肉姐真是一身肉啊"
        panda47.releaseTime = "2019-09-10 11:10:03"
        panda47.originalUrl = "https://www.bilibili.com/video/BV11J411N7WK"
        panda47.tags = "大熊猫,萌宠,动物圈"
        panda47.authorId = 4120384
        panda47.cover =
            "https://i2.hdslb.com/bfs/archive/5f04a15762b54f27bf9a79995bdf055065a6e2f6.jpg"
        list.add(panda47)

        val panda48 = PetVideo()
        panda48.type = VideoType.PANDA.ordinal
        panda48.fileName = "single48"
        panda48.code = 1923
        panda48.duration = 21
        panda48.period = PeriodType.SINGLE.ordinal
        panda48.isStar = false
        panda48.title = "【大熊猫囡囡】震惊！！堂堂国宝为了五斤笋笋，竟屈膝求食，不料惨遭饲养员无视"
        panda48.releaseTime = "2020-10-04 19:50:22"
        panda48.originalUrl = "https://www.bilibili.com/video/BV1iZ4y157nq"
        panda48.tags = "大熊猫,萌宠,动物圈"
        panda48.authorId = 288516776
        panda48.cover =
            "https://i2.hdslb.com/bfs/archive/d25c7ebcefb1b72a4e6d4e923480fd1bc56707c0.jpg"
        list.add(panda48)

        val panda49 = PetVideo()
        panda49.type = VideoType.PANDA.ordinal
        panda49.fileName = "single49"
        panda49.code = 1924
        panda49.duration = 15
        panda49.period = PeriodType.SINGLE.ordinal
        panda49.isStar = false
        panda49.title = "【大熊猫】飞云这是要走演艺路线吗？啥音乐都能驾驭！"
        panda49.releaseTime = "2019-05-21 10:47:49"
        panda49.originalUrl = "https://www.bilibili.com/video/BV1X4411j7EL"
        panda49.tags = "大熊猫,萌宠,动物圈"
        panda49.authorId = 374231948
        panda49.cover =
            "https://i0.hdslb.com/bfs/archive/f459a8ea0e5eaa3efba2e27f638f1e51f44b0d72.jpg"
        list.add(panda49)

        val panda50 = PetVideo()
        panda50.type = VideoType.PANDA.ordinal
        panda50.fileName = "single50"
        panda50.code = 1925
        panda50.duration = 16
        panda50.period = PeriodType.SINGLE.ordinal
        panda50.isStar = false
        panda50.title = "【大熊猫】请欣赏我家舞蹈课代表_飞云的舞姿"
        panda50.releaseTime = "2020-04-26 12:27:08"
        panda50.originalUrl = "https://www.bilibili.com/video/BV1qK4y1k723"
        panda50.tags = "大熊猫,萌宠,动物圈"
        panda50.authorId = 374231948
        panda50.cover =
            "https://i2.hdslb.com/bfs/archive/b24d88738aa32168dd2df004f12ba81f542e62a2.jpg"
        list.add(panda50)

        val panda51 = PetVideo()
        panda51.type = VideoType.PANDA.ordinal
        panda51.fileName = "single51"
        panda51.code = 1926
        panda51.duration = 27
        panda51.period = PeriodType.SINGLE.ordinal
        panda51.isStar = false
        panda51.title = "【大熊猫】这可是飞云宝宝最大的运动量啦！"
        panda51.releaseTime = "2019-04-29 10:14:59"
        panda51.originalUrl = "https://www.bilibili.com/video/BV1u4411874M"
        panda51.tags = "大熊猫,萌宠,动物圈"
        panda51.authorId = 374231948
        panda51.cover =
            "https://i0.hdslb.com/bfs/archive/e759239db24649c4ab9b9c9fa349647638d8cba2.jpg"
        list.add(panda51)

        val panda52 = PetVideo()
        panda52.type = VideoType.PANDA.ordinal
        panda52.fileName = "single52"
        panda52.code = 1927
        panda52.duration = 29
        panda52.period = PeriodType.SINGLE.ordinal
        panda52.isStar = false
        panda52.title = "原来熊猫也爱吃这个【小馨】"
        panda52.releaseTime = "2021-09-27 22:59:17"
        panda52.originalUrl = "https://www.bilibili.com/video/BV1aq4y1o7x9"
        panda52.tags = "大熊猫,萌宠,动物圈"
        panda52.authorId = 1435076062
        panda52.cover =
            "https://i0.hdslb.com/bfs/archive/8715c0010ce74762e1eb3abf9c0af2a5c7bbd1d1.jpg"
        list.add(panda52)

        val panda53 = PetVideo()
        panda53.type = VideoType.PANDA.ordinal
        panda53.fileName = "single53"
        panda53.code = 1928
        panda53.duration = 102
        panda53.period = PeriodType.SINGLE.ordinal
        panda53.isStar = false
        panda53.title = "熊猫的叫声真的很个性【小馨】"
        panda53.releaseTime = "2021-12-16 00:46:35"
        panda53.originalUrl = "https://www.bilibili.com/video/BV1BF411z7Ri"
        panda53.tags = "大熊猫,萌宠,动物圈"
        panda53.authorId = 1435076062
        panda53.cover =
            "https://i1.hdslb.com/bfs/archive/810c1abd0216a8b2cb0cb44b9261c9247dccb403.jpg"
        list.add(panda53)

        val panda54 = PetVideo()
        panda54.type = VideoType.PANDA.ordinal
        panda54.fileName = "single54"
        panda54.code = 1929
        panda54.duration = 26
        panda54.period = PeriodType.SINGLE.ordinal
        panda54.isStar = false
        panda54.title = "冰墩墩吃个瓜瓜【小馨】"
        panda54.releaseTime = "2022-02-11 21:09:28"
        panda54.originalUrl = "https://www.bilibili.com/video/BV1uF411n7n7"
        panda54.tags = "大熊猫,萌宠,动物圈"
        panda54.authorId = 1435076062
        panda54.cover =
            "https://i0.hdslb.com/bfs/archive/70123ac96b1cd3c7b6d38856a56ce48343f5801f.jpg"
        list.add(panda54)

        val panda55 = PetVideo()
        panda55.type = VideoType.PANDA.ordinal
        panda55.fileName = "single55"
        panda55.code = 1930
        panda55.duration = 27
        panda55.period = PeriodType.SINGLE.ordinal
        panda55.isStar = false
        panda55.title = "又是思念永永的一天，心疼七仔"
        panda55.releaseTime = "2021-09-12 10:43:27"
        panda55.originalUrl = "https://www.bilibili.com/video/BV1Ng41157J2"
        panda55.tags = "大熊猫,萌宠,动物圈"
        panda55.authorId = 231314384
        panda55.cover =
            "https://i2.hdslb.com/bfs/archive/580c5e6db7561ab64f307bac1609e84e8a29f443.jpg"
        list.add(panda55)

        val panda56 = PetVideo()
        panda56.type = VideoType.PANDA.ordinal
        panda56.fileName = "single56"
        panda56.code = 1931
        panda56.duration = 22
        panda56.period = PeriodType.SINGLE.ordinal
        panda56.isStar = false
        panda56.title = "可爱的七仔，又去守脑婆了"
        panda56.releaseTime = "2021-11-21 18:18:15"
        panda56.originalUrl = "https://www.bilibili.com/video/BV1z34y1d7Ac"
        panda56.tags = "大熊猫,萌宠,动物圈"
        panda56.authorId = 551467383
        panda56.cover =
            "https://i1.hdslb.com/bfs/archive/5a690b5ef8596648717896f15186e20ec07f9353.jpg"
        list.add(panda56)

        val panda57 = PetVideo()
        panda57.type = VideoType.PANDA.ordinal
        panda57.fileName = "single57"
        panda57.code = 1932
        panda57.duration = 49
        panda57.period = PeriodType.SINGLE.ordinal
        panda57.isStar = false
        panda57.title = "【大熊猫七仔】巧克力熊等脑婆"
        panda57.releaseTime = "2022-01-31 16:37:05"
        panda57.originalUrl = "https://www.bilibili.com/video/BV1sq4y1h7eD"
        panda57.tags = "大熊猫,萌宠,动物圈"
        panda57.authorId = 551467383
        panda57.cover =
            "https://i2.hdslb.com/bfs/archive/892210930af75f3fd8d2649713fa1493f38ad2ec.png"
        list.add(panda57)

        val panda58 = PetVideo()
        panda58.type = VideoType.PANDA.ordinal
        panda58.fileName = "single58"
        panda58.code = 1933
        panda58.duration = 69
        panda58.period = PeriodType.SINGLE.ordinal
        panda58.isStar = false
        panda58.title = "原来大熊猫这样滑雪"
        panda58.releaseTime = "2022-02-21 17:39:10"
        panda58.originalUrl = "https://www.bilibili.com/video/BV1EZ4y1k7E9"
        panda58.tags = "大熊猫,萌宠,动物圈"
        panda58.authorId = 90548795
        panda58.cover =
            "https://i1.hdslb.com/bfs/archive/a7716a43abbda731d414ff1266d4e1ccf8fec60f.jpg"
        list.add(panda58)

        val panda59 = PetVideo()
        panda59.type = VideoType.PANDA.ordinal
        panda59.fileName = "single59"
        panda59.code = 1934
        panda59.duration = 51
        panda59.period = PeriodType.SINGLE.ordinal
        panda59.isStar = false
        panda59.title = "小树：这次真的顶不住了！【肉肉】"
        panda59.releaseTime = "2019-03-06 18:20:14"
        panda59.originalUrl = "https://www.bilibili.com/video/BV1gb411q7pc"
        panda59.tags = "大熊猫,萌宠,动物圈"
        panda59.authorId = 12444306
        panda59.cover =
            "https://i2.hdslb.com/bfs/archive/b712c4b322e56a09fa9324b8eccca5ca832a9071.jpg"
        list.add(panda59)

        val panda60 = PetVideo()
        panda60.type = VideoType.PANDA.ordinal
        panda60.fileName = "single60"
        panda60.code = 1935
        panda60.duration = 137
        panda60.period = PeriodType.SINGLE.ordinal
        panda60.isStar = false
        panda60.title = "【绩兰】玩累了，上房顶歇会儿"
        panda60.releaseTime = "2022-02-26 13:00:15"
        panda60.originalUrl = "https://www.bilibili.com/video/BV1z44y1n7n3"
        panda60.tags = "大熊猫,萌宠,动物圈"
        panda60.authorId = 373529092
        panda60.cover =
            "https://i1.hdslb.com/bfs/archive/4d092e2c8ed766f6fbbc471982cc90abd89ee17a.jpg"
        list.add(panda60)

        val panda61 = PetVideo()
        panda61.type = VideoType.PANDA.ordinal
        panda61.fileName = "single61"
        panda61.code = 1936
        panda61.duration = 197
        panda61.period = PeriodType.SINGLE.ordinal
        panda61.isStar = false
        panda61.title = "【大熊猫萌玉】萌到炸裂的大脸，这是什么神仙小可爱啊~"
        panda61.releaseTime = "2019-10-21 22:05:39"
        panda61.originalUrl = "https://www.bilibili.com/video/BV1KE411r7gk"
        panda61.tags = "大熊猫,萌宠,动物圈"
        panda61.authorId = 34677299
        panda61.cover =
            "https://i0.hdslb.com/bfs/archive/5867dea53bc63ed92b6ab86d1b9c4a0b61e451d7.jpg"
        list.add(panda61)

        val panda62 = PetVideo()
        panda62.type = VideoType.PANDA.ordinal
        panda62.fileName = "single62"
        panda62.code = 1937
        panda62.duration = 93
        panda62.period = PeriodType.SINGLE.ordinal
        panda62.isStar = false
        panda62.title = "聆听雨声的小可爱【小馨】"
        panda62.releaseTime = "2021-07-06 23:35:24"
        panda62.originalUrl = "https://www.bilibili.com/video/BV1KU4y137Yb"
        panda62.tags = "大熊猫,萌宠,动物圈"
        panda62.authorId = 1435076062
        panda62.cover =
            "https://i0.hdslb.com/bfs/archive/af49c7dd34eaa76f6ec76a21b1b86aabc4a6633c.jpg"
        list.add(panda62)

        val panda63 = PetVideo()
        panda63.type = VideoType.PANDA.ordinal
        panda63.fileName = "single63"
        panda63.code = 1938
        panda63.duration = 114
        panda63.period = PeriodType.SINGLE.ordinal
        panda63.isStar = true
        panda63.title = "【梅兰肉肉】你的头为什么这么大？"
        panda63.releaseTime = "2020-02-06 11:15:12"
        panda63.originalUrl = "https://www.bilibili.com/video/BV187411H7kr"
        panda63.tags = "大熊猫,萌宠,动物圈"
        panda63.authorId = 4120384
        panda63.cover =
            "https://i1.hdslb.com/bfs/archive/0f5d9495f83754d69965bfdd77cc3324eb568775.jpg"
        list.add(panda63)

        val panda64 = PetVideo()
        panda64.type = VideoType.PANDA.ordinal
        panda64.fileName = "single64"
        panda64.code = 1939
        panda64.duration = 37
        panda64.period = PeriodType.SINGLE.ordinal
        panda64.isStar = true
        panda64.title = "全村唯一去过夜店的熊猫 蹦迪高手珍不高兴"
        panda64.releaseTime = "2020-12-20 16:31:14"
        panda64.originalUrl = "https://www.bilibili.com/video/BV1Wy4y1i7ME"
        panda64.tags = "大熊猫,萌宠,动物圈"
        panda64.authorId = 4120384
        panda64.cover =
            "https://i0.hdslb.com/bfs/archive/ba04819ff3cc3c23de66b9321be459894c60504c.jpg"
        list.add(panda64)

        val panda65 = PetVideo()
        panda65.type = VideoType.PANDA.ordinal
        panda65.fileName = "single65"
        panda65.code = 1940
        panda65.duration = 105
        panda65.period = PeriodType.SINGLE.ordinal
        panda65.isStar = false
        panda65.title = "一眼万年，史上长相最秀美的大熊猫"
        panda65.releaseTime = "2020-01-22 18:20:15"
        panda65.originalUrl = "https://www.bilibili.com/video/BV1f7411v7j1"
        panda65.tags = "大熊猫,萌宠,动物圈"
        panda65.authorId = 1524195
        panda65.cover =
            "https://i2.hdslb.com/bfs/archive/9e4996796e11cc2fed2623795f624c4dde9d3f37.jpg"
        list.add(panda65)

        val panda66 = PetVideo()
        panda66.type = VideoType.PANDA.ordinal
        panda66.fileName = "single66"
        panda66.code = 1941
        panda66.duration = 104
        panda66.period = PeriodType.SINGLE.ordinal
        panda66.isStar = false
        panda66.title = "【梅兰肉肉】不胖只是有点肿 大口吃饭超香哒"
        panda66.releaseTime = "2019-10-24 11:05:36"
        panda66.originalUrl = "https://www.bilibili.com/video/BV1tE411y7Kf"
        panda66.tags = "大熊猫,萌宠,动物圈"
        panda66.authorId = 4120384
        panda66.cover =
            "https://i0.hdslb.com/bfs/archive/90b61123d59c58a2d2ef60e54b9dacd335f651f3.jpg"
        list.add(panda66)

        val panda67 = PetVideo()
        panda67.type = VideoType.PANDA.ordinal
        panda67.fileName = "single67"
        panda67.code = 1942
        panda67.duration = 47
        panda67.period = PeriodType.SINGLE.ordinal
        panda67.isStar = false
        panda67.title = "陕西佛坪熊猫乐园，小馨（安安就是小馨，被佛坪改的名字）摇花枝。这是一个奶爸在去年春天拍到的。很美。看到官媒播放，不用申请授权，毫不犹豫地占为己有。"
        panda67.releaseTime = "2022-02-07 22:48:22"
        panda67.originalUrl = "https://www.bilibili.com/video/BV1bT4y1C7TX"
        panda67.tags = "大熊猫,萌宠,动物圈"
        panda67.authorId = 96124762
        panda67.cover =
            "https://i0.hdslb.com/bfs/archive/afde555cadcba40059ed17d6aea12692f7f6a46b.jpg"
        list.add(panda67)

        val panda68 = PetVideo()
        panda68.type = VideoType.PANDA.ordinal
        panda68.fileName = "single68"
        panda68.code = 1943
        panda68.duration = 73
        panda68.period = PeriodType.SINGLE.ordinal
        panda68.isStar = false
        panda68.title = "小润狗狗挑竹子。【大熊猫园润】"
        panda68.releaseTime = "2022-02-13 17:06:48"
        panda68.originalUrl = "https://www.bilibili.com/video/BV1Hr4y167P1"
        panda68.tags = "大熊猫,萌宠,动物圈"
        panda68.authorId = 514531996
        panda68.cover =
            "https://i2.hdslb.com/bfs/archive/2a55a3f8a8600e2f5a32b280d3ba2a3e11d09d68.jpg"
        list.add(panda68)

        return list
    }

    private fun getGrowData(): MutableList<PetVideo> {
        val panda1 = PetVideo()
        panda1.type = VideoType.PANDA.ordinal
        panda1.fileName = "panda_all_panda1"
        panda1.code = 1246
        panda1.duration = 274
        panda1.period = PeriodType.ALL.ordinal
        panda1.isStar = true
        panda1.title = "【17级熊孩子成长记】团宠的小馨妹妹"
        panda1.releaseTime = "2019-07-26 14:07:37"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1Rt411j7nB"
        panda1.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda1.authorId = 12444306
        panda1.cover =
            "https://i2.hdslb.com/bfs/archive/8e398558b217c16ce0dd22434581cf009b469fa9.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = VideoType.PANDA.ordinal
        panda2.fileName = "panda_all_panda2"
        panda2.code = 1247
        panda2.duration = 277
        panda2.period = PeriodType.ALL.ordinal
        panda2.isStar = true
        panda2.title = "【17级熊孩子成长记】快跑！芝家兄弟来追你啦"
        panda2.releaseTime = "2019-04-24 16:00:33"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1qb411G7RR"
        panda2.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda2.authorId = 12444306
        panda2.cover =
            "https://i0.hdslb.com/bfs/archive/483368feffdc0edcd09ea1dcff50e0c66e38c730.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = VideoType.PANDA.ordinal
        panda3.fileName = "panda_all_panda3"
        panda3.code = 1248
        panda3.duration = 202
        panda3.period = PeriodType.ALL.ordinal
        panda3.isStar = true
        panda3.title = "【18级熊孩子成长记】是爱泡澡的鱼摆摆，也是爱麻麻的小金鱼"
        panda3.releaseTime = "2022-01-26 13:30:09"
        panda3.originalUrl = "https://www.bilibili.com/video/BV17u41117eA"
        panda3.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda3.authorId = 12444306
        panda3.cover =
            "https://i0.hdslb.com/bfs/archive/2216b7e03ac2743a537e5f31d919bc9689b3615b.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = VideoType.PANDA.ordinal
        panda4.fileName = "panda_all_panda4"
        panda4.code = 1249
        panda4.duration = 267
        panda4.period = PeriodType.ALL.ordinal
        panda4.isStar = true
        panda4.title = "【18级熊孩子成长记】斧头山“润九爷”的名号，你听过没？"
        panda4.releaseTime = "2022-01-19 13:30:07"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1F34y1q7q6"
        panda4.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda4.authorId = 12444306
        panda4.cover =
            "https://i1.hdslb.com/bfs/archive/c19de6d9acc8eddc1edabd7d7bfaf1c962f40d57.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = VideoType.PANDA.ordinal
        panda5.fileName = "panda_all_panda5"
        panda5.code = 1250
        panda5.duration = 303
        panda5.period = PeriodType.ALL.ordinal
        panda5.isStar = true
        panda5.title = "好燃！乘风破浪的大熊猫，就在这刻浪起来"
        panda5.releaseTime = "2020-06-17 19:50:15"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1ma4y1Y7Vr"
        panda5.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda5.authorId = 12444306
        panda5.cover =
            "https://i1.hdslb.com/bfs/archive/5a172129f323fd078ae73992188c03b8e0390b42.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = VideoType.PANDA.ordinal
        panda6.fileName = "panda_all_panda6"
        panda6.code = 1251
        panda6.duration = 147
        panda6.period = PeriodType.ALL.ordinal
        panda6.isStar = true
        panda6.title = "如果熊猫开黑玩王者，战况会如何？"
        panda6.releaseTime = "2021-08-24 17:10:36"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1rf4y1n7rS"
        panda6.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda6.authorId = 12444306
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/aed050f1e5fb7a0d2dab51168c9732b989b4dc9d.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = VideoType.PANDA.ordinal
        panda7.fileName = "panda_all_panda7"
        panda7.code = 1252
        panda7.duration = 190
        panda7.period = PeriodType.ALL.ordinal
        panda7.isStar = false
        panda7.title = "你思念的那个远方的人，应该也在思念你吧"
        panda7.releaseTime = "2021-09-21 13:30:00"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1aq4y1f7n5"
        panda7.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda7.authorId = 12444306
        panda7.cover =
            "https://i1.hdslb.com/bfs/archive/008b52ee9c0dd7f8b324ff7bb222bb7e053c2946.jpg"
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = VideoType.PANDA.ordinal
        panda8.fileName = "panda_all_panda8"
        panda8.code = 1253
        panda8.duration = 108
        panda8.period = PeriodType.ALL.ordinal
        panda8.isStar = false
        panda8.title = "藏好麻袋好吗！熊猫基地2021级熊猫云亮相大集合来啦！"
        panda8.releaseTime = "2021-09-30 18:16:56"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1cq4y1N7nK"
        panda8.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda8.authorId = 12444306
        panda8.cover =
            "https://i1.hdslb.com/bfs/archive/ccb1bbc4242f7195a1c4fb94391e107974727dd5.jpg"
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = VideoType.PANDA.ordinal
        panda9.fileName = "panda_all_panda9"
        panda9.code = 1254
        panda9.duration = 87
        panda9.period = PeriodType.ALL.ordinal
        panda9.isStar = false
        panda9.title = "大熊猫能吃吗？当然啦！"
        panda9.releaseTime = "2021-10-21 12:50:33"
        panda9.originalUrl = "https://www.bilibili.com/video/BV15b4y1h7v9"
        panda9.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda9.authorId = 12444306
        panda9.cover =
            "https://i1.hdslb.com/bfs/archive/ef7e14231b3bb6101c0612189d49e100cd7b320e.jpg"
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = VideoType.PANDA.ordinal
        panda10.fileName = "panda_all_panda10"
        panda10.code = 1255
        panda10.duration = 225
        panda10.period = PeriodType.ALL.ordinal
        panda10.isStar = true
        panda10.title = "强强国国成长记：一周岁生日到啦！"
        panda10.releaseTime = "2021-10-25 09:00:11"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1vT4y1o7nz"
        panda10.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda10.authorId = 1534642081
        panda10.cover =
            "https://i1.hdslb.com/bfs/archive/80e548cd47ab571586a2c6c33be115a7541ee0f4.jpg"
        list.add(panda10)

        val panda11 = PetVideo()
        panda11.type = VideoType.PANDA.ordinal
        panda11.fileName = "panda_all_panda11"
        panda11.code = 1256
        panda11.duration = 277
        panda11.period = PeriodType.ALL.ordinal
        panda11.isStar = true
        panda11.title = "【18级熊孩子成长记】学霸仔姐语言技能点满，看完直呼佩服！"
        panda11.releaseTime = "2021-12-09 13:30:25"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1fM4y1w7A3"
        panda11.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda11.authorId = 12444306
        panda11.cover =
            "https://i1.hdslb.com/bfs/archive/0733ee60d1c5b35501af4264ea4e9cd3fa0dff46.jpg"
        list.add(panda11)

        val panda12 = PetVideo()
        panda12.type = VideoType.PANDA.ordinal
        panda12.fileName = "panda_all_panda12"
        panda12.code = 1257
        panda12.duration = 282
        panda12.period = PeriodType.ALL.ordinal
        panda12.isStar = true
        panda12.title = "【18级熊孩子成长记】家里有和自己同样可爱的姐妹，是种怎样的体验？"
        panda12.releaseTime = "2021-12-15 15:34:10"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1oa411r7Aa"
        panda12.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda12.authorId = 12444306
        panda12.cover =
            "https://i0.hdslb.com/bfs/archive/a91249c97e3b9192ad18306f524f95c2cc5353ec.jpg"
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = VideoType.PANDA.ordinal
        panda13.fileName = "panda_all_panda13"
        panda13.code = 1258
        panda13.duration = 412
        panda13.period = PeriodType.ALL.ordinal
        panda13.isStar = true
        panda13.title = "请查收滚滚们的2021年终总结！"
        panda13.releaseTime = "2021-12-31 16:24:43"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1U34y1z7GU"
        panda13.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda13.authorId = 12444306
        panda13.cover =
            "https://i0.hdslb.com/bfs/archive/a2246ec8b1ec6020f099faef48527761bd6d0216.jpg"
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = VideoType.PANDA.ordinal
        panda14.fileName = "panda_all_panda14"
        panda14.code = 1259
        panda14.duration = 250
        panda14.period = PeriodType.ALL.ordinal
        panda14.isStar = true
        panda14.title = "滚滚新年送祝福！一家人不说两家话，看看谁最会吹彩虹屁？"
        panda14.releaseTime = "2022-01-01 13:30:18"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1dq4y1178s"
        panda14.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda14.authorId = 12444306
        panda14.cover =
            "https://i2.hdslb.com/bfs/archive/849e01d664ca0c5d610efed50a638c2cfd37bd48.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = VideoType.PANDA.ordinal
        panda15.fileName = "panda_all_panda15"
        panda15.code = 1260
        panda15.duration = 254
        panda15.period = PeriodType.ALL.ordinal
        panda15.isStar = true
        panda15.title = "【18级熊孩子成长记】曾经两只小帅熊！如今挖煤好员工~"
        panda15.releaseTime = "2021-12-29 13:35:01"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1TL4y1E7o9"
        panda15.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda15.authorId = 12444306
        panda15.cover =
            "https://i2.hdslb.com/bfs/archive/73897aa3441560daf5994368d5f50fe57eee7e20.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = VideoType.PANDA.ordinal
        panda16.fileName = "panda_all_panda16"
        panda16.code = 1261
        panda16.duration = 204
        panda16.period = PeriodType.ALL.ordinal
        panda16.isStar = true
        panda16.title = "熊猫频道记录：我们超可爱的胖花花呀"
        panda16.releaseTime = "2021-12-24 06:26:30"
        panda16.originalUrl = "https://www.bilibili.com/video/BV15a411672g"
        panda16.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda16.authorId = 471522471
        panda16.cover =
            "https://i0.hdslb.com/bfs/archive/fb45aa45c197c5a6ab607b8d548c0f7abbda4f91.jpg"
        list.add(panda16)

        val panda17 = PetVideo()
        panda17.type = VideoType.PANDA.ordinal
        panda17.fileName = "panda_all_panda17"
        panda17.code = 1262
        panda17.duration = 185
        panda17.period = PeriodType.ALL.ordinal
        panda17.isStar = true
        panda17.title = "大熊猫“绩笑”的成长日常，有多好笑你自己看！"
        panda17.releaseTime = "2020-02-19 21:30:58"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1w7411j7fx"
        panda17.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda17.authorId = 1998535
        panda17.cover =
            "https://i1.hdslb.com/bfs/archive/7b486d69a1577cbc8b2de50f322b4730de0cfdf5.jpg"
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = VideoType.PANDA.ordinal
        panda18.fileName = "panda_all_panda18"
        panda18.code = 1263
        panda18.duration = 253
        panda18.period = PeriodType.ALL.ordinal
        panda18.isStar = true
        panda18.title = "【成家三姐妹】成浪、成风、绩笑超萌混剪 01"
        panda18.releaseTime = "2020-02-10 03:11:33"
        panda18.originalUrl = "https://www.bilibili.com/video/BV13741147og"
        panda18.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda18.authorId = 20296405
        panda18.cover =
            "https://i2.hdslb.com/bfs/archive/a54d7f4ff62248d4971bb8dd7a5b0976629c5c70.jpg"
        list.add(panda18)

        val panda19 = PetVideo()
        panda19.type = VideoType.PANDA.ordinal
        panda19.fileName = "panda_all_panda19"
        panda19.code = 1264
        panda19.duration = 259
        panda19.period = PeriodType.ALL.ordinal
        panda19.isStar = true
        panda19.title = "【18级熊孩子成长记】虽然出生“少点墨”，调皮捣蛋可不输任何熊"
        panda19.releaseTime = "2021-12-22 13:35:01"
        panda19.originalUrl = "https://www.bilibili.com/video/BV1Ub4y1v7oo"
        panda19.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda19.authorId = 12444306
        panda19.cover =
            "https://i2.hdslb.com/bfs/archive/956c48eff4af0da8e97609e3699eff638111da69.jpg"
        list.add(panda19)

        val panda20 = PetVideo()
        panda20.type = VideoType.PANDA.ordinal
        panda20.fileName = "panda_all_panda20"
        panda20.code = 1820
        panda20.duration = 341
        panda20.period = PeriodType.ALL.ordinal
        panda20.isStar = false
        panda20.title = "【20级熊孩子成长记】芝家战神帅春生，可盐可甜手艺棒！"
        panda20.releaseTime = "2022-03-09 13:30:00"
        panda20.originalUrl = "https://www.bilibili.com/video/BV1KT4y1D7tg"
        panda20.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda20.authorId = 12444306
        panda20.cover =
            "https://i0.hdslb.com/bfs/archive/982f67ab891dacc367030e438037f8db0298d0db.jpg"
        list.add(panda20)

        val panda21 = PetVideo()
        panda21.type = VideoType.PANDA.ordinal
        panda21.fileName = "panda_all_panda21"
        panda21.code = 1821
        panda21.duration = 62
        panda21.period = PeriodType.ALL.ordinal
        panda21.isStar = false
        panda21.title = "大熊猫“奇一”从小到大的颜值变化"
        panda21.releaseTime = "2020-11-14 21:30:00"
        panda21.originalUrl = "https://www.bilibili.com/video/BV1QD4y1Q7uS"
        panda21.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda21.authorId = 1998535
        panda21.cover =
            "https://i2.hdslb.com/bfs/archive/20c0710457b3a96f59a929c9905b208e85c908ba.jpg"
        list.add(panda21)

        val panda22 = PetVideo()
        panda22.type = VideoType.PANDA.ordinal
        panda22.fileName = "panda_all_panda22"
        panda22.code = 1822
        panda22.duration = 327
        panda22.period = PeriodType.ALL.ordinal
        panda22.isStar = false
        panda22.title = "【20级熊孩子成长记 热干面 蛋烘糕】虽然有一点禾几，但是我们依旧是两个帅熊！"
        panda22.releaseTime = "2022-03-02 13:35:17"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1dr4y1z74i"
        panda22.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda22.authorId = 12444306
        panda22.cover =
            "https://i2.hdslb.com/bfs/archive/c931b4d61c0e8b521d5346c2f45a4be4e935d1f1.jpg"
        list.add(panda22)

        val panda23 = PetVideo()
        panda23.type = VideoType.PANDA.ordinal
        panda23.fileName = "panda_all_panda23"
        panda23.code = 1823
        panda23.duration = 155
        panda23.period = PeriodType.ALL.ordinal
        panda23.isStar = false
        panda23.title = " 《童年时光机》第1集 熊孩子们的出生"
        panda23.releaseTime = "2015-07-31 17:09:29"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1us411m7Yt"
        panda23.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda23.authorId = 12444306
        panda23.cover =
            "https://i2.hdslb.com/bfs/archive/ad944d8742521c3d223f51faa3e090ddd17db02f.jpg"
        list.add(panda23)

        val panda24 = PetVideo()
        panda24.type = VideoType.PANDA.ordinal
        panda24.fileName = "panda_all_panda24"
        panda24.code = 1824
        panda24.duration = 158
        panda24.period = PeriodType.ALL.ordinal
        panda24.isStar = false
        panda24.title = " 《童年时光机》第2集 为什么受伤的总是我"
        panda24.releaseTime = "2015-07-31 17:22:16"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1us411m7au"
        panda24.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda24.authorId = 12444306
        panda24.cover =
            "https://i2.hdslb.com/bfs/archive/090827124dce8df7b39ee90f279d5914104cf3d6.jpg"
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = VideoType.PANDA.ordinal
        panda25.fileName = "panda_all_panda25"
        panda25.code = 1825
        panda25.duration = 206
        panda25.period = PeriodType.ALL.ordinal
        panda25.isStar = false
        panda25.title = " 《童年时光机》第3集 我们的时代"
        panda25.releaseTime = "2015-08-01 14:57:43"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1Gs411m7QU"
        panda25.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda25.authorId = 12444306
        panda25.cover =
            "https://i2.hdslb.com/bfs/archive/53fede3635e815551d778926bc905b64cb596e0f.jpg"
        list.add(panda25)

        val panda26 = PetVideo()
        panda26.type = VideoType.PANDA.ordinal
        panda26.fileName = "panda_all_panda26"
        panda26.code = 1826
        panda26.duration = 184
        panda26.period = PeriodType.ALL.ordinal
        panda26.isStar = false
        panda26.title = " 《童年时光机》第4集 星语的烦恼"
        panda26.releaseTime = "2015-08-01 15:01:23"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1Gs411m7Di"
        panda26.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda26.authorId = 12444306
        panda26.cover =
            "https://i1.hdslb.com/bfs/archive/1756a6e8601b50a76ea90fc76511b955e8b9df6a.jpg"
        list.add(panda26)

        val panda27 = PetVideo()
        panda27.type = VideoType.PANDA.ordinal
        panda27.fileName = "panda_all_panda27"
        panda27.code = 1827
        panda27.duration = 221
        panda27.period = PeriodType.ALL.ordinal
        panda27.isStar = false
        panda27.title = " 《童年时光机》第5集 成就的逆袭"
        panda27.releaseTime = "2015-08-01 16:19:53"
        panda27.originalUrl = "https://www.bilibili.com/video/BV1Gs411m79T"
        panda27.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda27.authorId = 12444306
        panda27.cover =
            "https://i2.hdslb.com/bfs/archive/c8db0b3a6b86cb56ccf7c8714d6288606601c2e7.jpg"
        list.add(panda27)

        val panda28 = PetVideo()
        panda28.type = VideoType.PANDA.ordinal
        panda28.fileName = "panda_all_panda28"
        panda28.code = 1828
        panda28.duration = 247
        panda28.period = PeriodType.ALL.ordinal
        panda28.isStar = false
        panda28.title = " 《童年时光机》第6集 孤独患者"
        panda28.releaseTime = "2015-08-01 16:23:31"
        panda28.originalUrl = "https://www.bilibili.com/video/BV1Gs411m7s5"
        panda28.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda28.authorId = 12444306
        panda28.cover =
            "https://i1.hdslb.com/bfs/archive/279b0ffe21c2da9783ae343fffbf056ea7d3cdcb.jpg"
        list.add(panda28)

        val panda29 = PetVideo()
        panda29.type = VideoType.PANDA.ordinal
        panda29.fileName = "panda_all_panda29"
        panda29.code = 1829
        panda29.duration = 259
        panda29.period = PeriodType.ALL.ordinal
        panda29.isStar = false
        panda29.title = "《童年时光机》 第7集 分开的距离"
        panda29.releaseTime = "2015-09-28 11:18:55"
        panda29.originalUrl = "https://www.bilibili.com/video/BV19s411177P"
        panda29.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda29.authorId = 12444306
        panda29.cover =
            "https://i0.hdslb.com/bfs/archive/e19aebe4d031fa8a10d97a5a26436bec6e408ec1.png"
        list.add(panda29)

        val panda30 = PetVideo()
        panda30.type = VideoType.PANDA.ordinal
        panda30.fileName = "panda_all_panda30"
        panda30.code = 1830
        panda30.duration = 179
        panda30.period = PeriodType.ALL.ordinal
        panda30.isStar = false
        panda30.title = " 《童年的时光机》第8集 No Zuo No Die"
        panda30.releaseTime = "2015-08-01 18:21:17"
        panda30.originalUrl = "https://www.bilibili.com/video/BV1Gs411m7a2"
        panda30.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda30.authorId = 12444306
        panda30.cover =
            "https://i2.hdslb.com/bfs/archive/c0c359967acdd6a7acf79a1692d274805683d9f3.jpg"
        list.add(panda30)

        val panda31 = PetVideo()
        panda31.type = VideoType.PANDA.ordinal
        panda31.fileName = "panda_all_panda31"
        panda31.code = 1831
        panda31.duration = 192
        panda31.period = PeriodType.ALL.ordinal
        panda31.isStar = false
        panda31.title = " 《童年时光机》第9集 绝世好哥哥"
        panda31.releaseTime = "2015-08-01 18:23:26"
        panda31.originalUrl = "https://www.bilibili.com/video/BV1Gs411m7av"
        panda31.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda31.authorId = 12444306
        panda31.cover =
            "https://i0.hdslb.com/bfs/archive/dde8021e6105cebc2db491057b4d5c99f7271e18.jpg"
        list.add(panda31)

        val panda32 = PetVideo()
        panda32.type = VideoType.PANDA.ordinal
        panda32.fileName = "panda_all_panda32"
        panda32.code = 1832
        panda32.duration = 162
        panda32.period = PeriodType.ALL.ordinal
        panda32.isStar = false
        panda32.title = " 《童年时光机》第10集 那些熊孩子们 1"
        panda32.releaseTime = "2015-07-30 13:10:39"
        panda32.originalUrl = "https://www.bilibili.com/video/BV1fs41127K3"
        panda32.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda32.authorId = 12444306
        panda32.cover =
            "https://i2.hdslb.com/bfs/archive/8700a28e003f9bcf9ce416efc58debe7f37e0596.jpg"
        list.add(panda32)

        val panda33 = PetVideo()
        panda33.type = VideoType.PANDA.ordinal
        panda33.fileName = "panda_all_panda33"
        panda33.code = 1833
        panda33.duration = 182
        panda33.period = PeriodType.ALL.ordinal
        panda33.isStar = false
        panda33.title = " 《童年时光机》第11集－那些熊孩子2"
        panda33.releaseTime = "2015-07-30 12:21:50"
        panda33.originalUrl = "https://www.bilibili.com/video/BV1fs41127cz"
        panda33.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda33.authorId = 12444306
        panda33.cover =
            "https://i0.hdslb.com/bfs/archive/d2333073a7a70b9ae86486cd2be14c1c1baaa3bd.jpg"
        list.add(panda33)

        val panda34 = PetVideo()
        panda34.type = VideoType.PANDA.ordinal
        panda34.fileName = "panda_all_panda34"
        panda34.code = 1834
        panda34.duration = 295
        panda34.period = PeriodType.ALL.ordinal
        panda34.isStar = false
        panda34.title = " 《童年时光机》第12集　大结局"
        panda34.releaseTime = "2015-08-03 14:02:40"
        panda34.originalUrl = "https://www.bilibili.com/video/BV1Ns411m7cm"
        panda34.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda34.authorId = 12444306
        panda34.cover =
            "https://i1.hdslb.com/bfs/archive/c110460b8c6fe553ef1af3d64b42afa4213686c0.jpg"
        list.add(panda34)

        val panda35 = PetVideo()
        panda35.type = VideoType.PANDA.ordinal
        panda35.fileName = "panda_all_panda35"
        panda35.code = 1835
        panda35.duration = 292
        panda35.period = PeriodType.ALL.ordinal
        panda35.isStar = false
        panda35.title = "温馨治愈向～《童年时光机》系列主题曲 原创MV"
        panda35.releaseTime = "2015-10-08 18:59:03"
        panda35.originalUrl = "https://www.bilibili.com/video/BV1ps411277u"
        panda35.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda35.authorId = 12444306
        panda35.cover =
            "https://i0.hdslb.com/bfs/archive/c026397cb7edecc9cb66a568985d2159d877506d.jpg"
        list.add(panda35)

        val panda36 = PetVideo()
        panda36.type = VideoType.PANDA.ordinal
        panda36.fileName = "panda_all_panda36"
        panda36.code = 1836
        panda36.duration = 298
        panda36.period = PeriodType.ALL.ordinal
        panda36.isStar = false
        panda36.title = "【熊孩子成长记】一盆分量很足的梅菜扣肉"
        panda36.releaseTime = "2018-05-29 13:19:11"
        panda36.originalUrl = "https://www.bilibili.com/video/BV1Gp411d7PK"
        panda36.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda36.authorId = 12444306
        panda36.cover =
            "https://i2.hdslb.com/bfs/archive/7080a197fd09b4adeda859a5b766edcf8f38f0a4.jpg"
        list.add(panda36)

        val panda37 = PetVideo()
        panda37.type = VideoType.PANDA.ordinal
        panda37.fileName = "panda_all_panda37"
        panda37.code = 1837
        panda37.duration = 151
        panda37.period = PeriodType.ALL.ordinal
        panda37.isStar = false
        panda37.title = "【熊孩子成长记】无敌是多么的寂寞"
        panda37.releaseTime = "2018-06-14 20:30:47"
        panda37.originalUrl = "https://www.bilibili.com/video/BV1DW411w7k4"
        panda37.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda37.authorId = 12444306
        panda37.cover =
            "https://i0.hdslb.com/bfs/archive/fed8b236bb4102078a2f18c5c6c920c66dac22cb.jpg"
        list.add(panda37)

        val panda38 = PetVideo()
        panda38.type = VideoType.PANDA.ordinal
        panda38.fileName = "panda_all_panda38"
        panda38.code = 1838
        panda38.duration = 181
        panda38.period = PeriodType.ALL.ordinal
        panda38.isStar = false
        panda38.title = "【熊孩子成长记】绩美美和地道兰的成长“黑历史”"
        panda38.releaseTime = "2018-06-27 19:25:57"
        panda38.originalUrl = "https://www.bilibili.com/video/BV1Gs411j7LY"
        panda38.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda38.authorId = 12444306
        panda38.cover =
            "https://i2.hdslb.com/bfs/archive/5fb8f53f91fe5369bc59774bf53ba6e393a74bda.jpg"
        list.add(panda38)

        val panda39 = PetVideo()
        panda39.type = VideoType.PANDA.ordinal
        panda39.fileName = "panda_all_panda39"
        panda39.code = 1839
        panda39.duration = 197
        panda39.period = PeriodType.ALL.ordinal
        panda39.isStar = false
        panda39.title = "【熊孩子成长记】一对会“说话”的大熊猫姐妹花"
        panda39.releaseTime = "2018-06-29 20:00:34"
        panda39.originalUrl = "https://www.bilibili.com/video/BV1Rs411V7Ay"
        panda39.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda39.authorId = 12444306
        panda39.cover =
            "https://i1.hdslb.com/bfs/archive/148d54dbe4ad4c16e03f107cdb27e03a05c86ca7.jpg"
        list.add(panda39)

        val panda40 = PetVideo()
        panda40.type = VideoType.PANDA.ordinal
        panda40.fileName = "panda_all_panda40"
        panda40.code = 1840
        panda40.duration = 334
        panda40.period = PeriodType.ALL.ordinal
        panda40.isStar = false
        panda40.title = "【熊孩子成长记】奇一重大黑历史流出！还有会耍赖的奇果果！"
        panda40.releaseTime = "2018-07-01 11:00:56"
        panda40.originalUrl = "https://www.bilibili.com/video/BV1vs41157uV"
        panda40.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda40.authorId = 12444306
        panda40.cover =
            "https://i1.hdslb.com/bfs/archive/99426c2707d7257f4e4d5cd0611dd619a573b75a.jpg"
        list.add(panda40)

        val panda41 = PetVideo()
        panda41.type = VideoType.PANDA.ordinal
        panda41.fileName = "panda_all_panda41"
        panda41.code = 1841
        panda41.duration = 277
        panda41.period = PeriodType.ALL.ordinal
        panda41.isStar = false
        panda41.title = "【熊孩子成长记】国际顺锅和福来妹儿的成长日常～"
        panda41.releaseTime = "2018-07-14 21:00:04"
        panda41.originalUrl = "https://www.bilibili.com/video/BV1qs411J7eD"
        panda41.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda41.authorId = 12444306
        panda41.cover =
            "https://i0.hdslb.com/bfs/archive/94ad362b8b5a39329d528331865fa9b0658fd08e.jpg"
        list.add(panda41)

        val panda42 = PetVideo()
        panda42.type = VideoType.PANDA.ordinal
        panda42.fileName = "panda_all_panda42"
        panda42.code = 1842
        panda42.duration = 204
        panda42.period = PeriodType.ALL.ordinal
        panda42.isStar = false
        panda42.title = "【熊孩子成长记】你浑得很！社会熊毛浩南&黄桃篇～"
        panda42.releaseTime = "2018-07-26 14:00:47"
        panda42.originalUrl = "https://www.bilibili.com/video/BV1Ms411N7ep"
        panda42.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda42.authorId = 12444306
        panda42.cover =
            "https://i2.hdslb.com/bfs/archive/2a3be35695382a1b5ede9b12dd4d6c16e69c4755.jpg"
        list.add(panda42)

        val panda43 = PetVideo()
        panda43.type = VideoType.PANDA.ordinal
        panda43.fileName = "panda_all_panda43"
        panda43.code = 1843
        panda43.duration = 205
        panda43.period = PeriodType.ALL.ordinal
        panda43.isStar = false
        panda43.title = "【熊孩子成长记】白袜子“小疯子”和妹妹的童年"
        panda43.releaseTime = "2018-08-09 20:00:57"
        panda43.originalUrl = "https://www.bilibili.com/video/BV1hs411M7o4"
        panda43.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda43.authorId = 12444306
        panda43.cover =
            "https://i0.hdslb.com/bfs/archive/2020bc637424f831c5e44ca3b58d00b53b1be450.jpg"
        list.add(panda43)

        val panda44 = PetVideo()
        panda44.type = VideoType.PANDA.ordinal
        panda44.fileName = "panda_all_panda44"
        panda44.code = 1844
        panda44.duration = 165
        panda44.period = PeriodType.ALL.ordinal
        panda44.isStar = false
        panda44.title = "【熊孩子成长记】喝奶之王养成记"
        panda44.releaseTime = "2018-08-10 11:36:33"
        panda44.originalUrl = "https://www.bilibili.com/video/BV1Ns411u7x6"
        panda44.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda44.authorId = 12444306
        panda44.cover =
            "https://i0.hdslb.com/bfs/archive/aca75cd2f1fad2562e66c9b662b22fc8da42c51f.jpg"
        list.add(panda44)

        val panda45 = PetVideo()
        panda45.type = VideoType.PANDA.ordinal
        panda45.fileName = "panda_all_panda45"
        panda45.code = 1845
        panda45.duration = 182
        panda45.period = PeriodType.ALL.ordinal
        panda45.isStar = false
        panda45.title = "【熊孩子成长记】歌神史大辉和“心烦”妹妹的养成记"
        panda45.releaseTime = "2018-08-12 13:00:09"
        panda45.originalUrl = "https://www.bilibili.com/video/BV1Js411u7Q2"
        panda45.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda45.authorId = 12444306
        panda45.cover =
            "https://i2.hdslb.com/bfs/archive/43f93eba15ba65492c1fdd1908509786523d420e.jpg"
        list.add(panda45)

        val panda46 = PetVideo()
        panda46.type = VideoType.PANDA.ordinal
        panda46.fileName = "panda_all_panda46"
        panda46.code = 1846
        panda46.duration = 166
        panda46.period = PeriodType.ALL.ordinal
        panda46.isStar = false
        panda46.title = "【熊孩子成长记】熊猫喊不回来？原来他有一个无熊超越的本领！"
        panda46.releaseTime = "2018-08-15 13:57:18"
        panda46.originalUrl = "https://www.bilibili.com/video/BV1uW411R7zt"
        panda46.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda46.authorId = 12444306
        panda46.cover =
            "https://i1.hdslb.com/bfs/archive/06c7e7227103f56157589d894e17cb83d586243d.jpg"
        list.add(panda46)

        val panda47 = PetVideo()
        panda47.type = VideoType.PANDA.ordinal
        panda47.fileName = "panda_all_panda47"
        panda47.code = 1847
        panda47.duration = 192
        panda47.period = PeriodType.ALL.ordinal
        panda47.isStar = false
        panda47.title = "【熊孩子成长记】快看那只熊猫！灰不溜秋的！"
        panda47.releaseTime = "2018-08-19 19:05:03"
        panda47.originalUrl = "https://www.bilibili.com/video/BV1CW411X78q"
        panda47.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda47.authorId = 12444306
        panda47.cover =
            "https://i1.hdslb.com/bfs/archive/7a18170e870c106063a4afcdd941c24cb3de5c87.jpg"
        list.add(panda47)

        val panda48 = PetVideo()
        panda48.type = VideoType.PANDA.ordinal
        panda48.fileName = "panda_all_panda48"
        panda48.code = 1848
        panda48.duration = 215
        panda48.period = PeriodType.ALL.ordinal
        panda48.isStar = false
        panda48.title = "【熊孩子成长记】软萌哥哥和霸气妹妹的成长日常"
        panda48.releaseTime = "2018-06-25 15:47:57"
        panda48.originalUrl = "https://www.bilibili.com/video/BV1ms411L7WW"
        panda48.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda48.authorId = 12444306
        panda48.cover =
            "https://i0.hdslb.com/bfs/archive/979399ad9e6ee0c4fd86693903cc7a7884dc4409.jpg"
        list.add(panda48)

        val panda49 = PetVideo()
        panda49.type = VideoType.PANDA.ordinal
        panda49.fileName = "panda_all_panda49"
        panda49.code = 1849
        panda49.duration = 236
        panda49.period = PeriodType.ALL.ordinal
        panda49.isStar = false
        panda49.title = "【17级熊孩子成长记】没想到吧，这对姐弟中出了个“带崽母猫”！"
        panda49.releaseTime = "2019-06-27 15:30:15"
        panda49.originalUrl = "https://www.bilibili.com/video/BV1Px411d79M"
        panda49.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda49.authorId = 12444306
        panda49.cover =
            "https://i0.hdslb.com/bfs/archive/641b96ace7d3bb738d5e05757505bba7527aa125.jpg"
        list.add(panda49)

        val panda50 = PetVideo()
        panda50.type = VideoType.PANDA.ordinal
        panda50.fileName = "panda_all_panda50"
        panda50.code = 1850
        panda50.duration = 247
        panda50.period = PeriodType.ALL.ordinal
        panda50.isStar = false
        panda50.title = "【17级熊孩子成长记】大熊猫晶亮宝宝小时候竟然不敢滑滑梯？"
        panda50.releaseTime = "2019-07-10 14:55:58"
        panda50.originalUrl = "https://www.bilibili.com/video/BV1Fx411f7vd"
        panda50.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda50.authorId = 12444306
        panda50.cover =
            "https://i0.hdslb.com/bfs/archive/34f01fd761fc75985c18a8b138bc3c3ead2a1908.jpg"
        list.add(panda50)

        val panda51 = PetVideo()
        panda51.type = VideoType.PANDA.ordinal
        panda51.fileName = "panda_all_panda51"
        panda51.code = 1851
        panda51.duration = 231
        panda51.period = PeriodType.ALL.ordinal
        panda51.isStar = false
        panda51.title = "【17级熊孩子成长记】大小姐三优是“真懒”还是“真胖”呢"
        panda51.releaseTime = "2019-07-15 15:40:35"
        panda51.originalUrl = "https://www.bilibili.com/video/BV1Vt41157ez"
        panda51.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda51.authorId = 12444306
        panda51.cover =
            "https://i2.hdslb.com/bfs/archive/794fa61b0e80823b666d917c17e99edf0e2dc4fa.jpg"
        list.add(panda51)

        val panda52 = PetVideo()
        panda52.type = VideoType.PANDA.ordinal
        panda52.fileName = "panda_all_panda52"
        panda52.code = 1852
        panda52.duration = 235
        panda52.period = PeriodType.ALL.ordinal
        panda52.isStar = false
        panda52.title = "【17级熊孩子成长记】哥哥熊实在是太调皮了，身为妹妹的辣辣也很无奈"
        panda52.releaseTime = "2019-07-20 15:30:29"
        panda52.originalUrl = "https://www.bilibili.com/video/BV16t411n7zp"
        panda52.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda52.authorId = 12444306
        panda52.cover =
            "https://i1.hdslb.com/bfs/archive/31ea5f2d4f5e361aa483e58eab4af70ccdc29ec3.jpg"
        list.add(panda52)

        val panda53 = PetVideo()
        panda53.type = VideoType.PANDA.ordinal
        panda53.fileName = "panda_all_panda53"
        panda53.code = 1853
        panda53.duration = 294
        panda53.period = PeriodType.ALL.ordinal
        panda53.isStar = false
        panda53.title = "【17级熊孩子成长记】社会你青姐，就是这么有实力！"
        panda53.releaseTime = "2019-07-22 17:35:23"
        panda53.originalUrl = "https://www.bilibili.com/video/BV1st411J7XV"
        panda53.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda53.authorId = 12444306
        panda53.cover =
            "https://i1.hdslb.com/bfs/archive/88e3d25dbaf5f6103e436c294011312cf8cc29e6.jpg"
        list.add(panda53)

        val panda54 = PetVideo()
        panda54.type = VideoType.PANDA.ordinal
        panda54.fileName = "panda_all_panda54"
        panda54.code = 1854
        panda54.duration = 270
        panda54.period = PeriodType.ALL.ordinal
        panda54.isStar = false
        panda54.title = "【18级熊孩子成长记】说谁像藏狐呢！"
        panda54.releaseTime = "2022-01-05 13:36:59"
        panda54.originalUrl = "https://www.bilibili.com/video/BV1T3411e7Ci"
        panda54.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda54.authorId = 12444306
        panda54.cover =
            "https://i2.hdslb.com/bfs/archive/5e91824ca5c214cee992dc857641b014b3cc324b.jpg"
        list.add(panda54)

        val panda55 = PetVideo()
        panda55.type = VideoType.PANDA.ordinal
        panda55.fileName = "panda_all_panda55"
        panda55.code = 1855
        panda55.duration = 254
        panda55.period = PeriodType.ALL.ordinal
        panda55.isStar = false
        panda55.title = "【18级熊孩子成长记】二代“庆大”&“庆小”，傻傻分不清啊～"
        panda55.releaseTime = "2022-01-12 14:30:19"
        panda55.originalUrl = "https://www.bilibili.com/video/BV1hu41127xb"
        panda55.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda55.authorId = 12444306
        panda55.cover =
            "https://i0.hdslb.com/bfs/archive/d7003c8ce0529d9c401eb120bd5dabf76ea72f00.jpg"
        list.add(panda55)

        val panda56 = PetVideo()
        panda56.type = VideoType.PANDA.ordinal
        panda56.fileName = "panda_all_panda56"
        panda56.code = 1856
        panda56.duration = 327
        panda56.period = PeriodType.ALL.ordinal
        panda56.isStar = false
        panda56.title = "【19级熊孩子成长记】绩笑来啦！请查收你的新年第一份“绩效”哦！"
        panda56.releaseTime = "2022-02-02 11:00:11"
        panda56.originalUrl = "https://www.bilibili.com/video/BV1Bq4y1h7Hb"
        panda56.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda56.authorId = 12444306
        panda56.cover =
            "https://i0.hdslb.com/bfs/archive/5187296d93d9132910c480ba32abfd2a03200591.jpg"
        list.add(panda56)

        val panda57 = PetVideo()
        panda57.type = VideoType.PANDA.ordinal
        panda57.fileName = "panda_all_panda57"
        panda57.code = 1857
        panda57.duration = 218
        panda57.period = PeriodType.ALL.ordinal
        panda57.isStar = true
        panda57.title = "【熊孩子成长记】熊猫界猪猪女孩养成记，雅竹雅韵"
        panda57.releaseTime = "2018-06-20 17:42:32"
        panda57.originalUrl = "https://www.bilibili.com/video/BV1rs411j79o"
        panda57.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda57.authorId = 12444306
        panda57.cover =
            "https://i1.hdslb.com/bfs/archive/bc36fd7997cfdf1fd3d3742da67d9c65164cf30e.jpg"
        list.add(panda57)

        val panda58 = PetVideo()
        panda58.type = VideoType.PANDA.ordinal
        panda58.fileName = "panda_all_panda58"
        panda58.code = 1858
        panda58.duration = 297
        panda58.period = PeriodType.ALL.ordinal
        panda58.isStar = false
        panda58.title = "【19级熊孩子成长记】潦草熊猫长成这样一定是有原因的！"
        panda58.releaseTime = "2022-02-23 13:30:16"
        panda58.originalUrl = "https://www.bilibili.com/video/BV1ci4y127Ue"
        panda58.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda58.authorId = 12444306
        panda58.cover =
            "https://i1.hdslb.com/bfs/archive/d162130e35b4903b442c31ed6e9ee5e1a3bc33e0.jpg"
        list.add(panda58)

        val panda59 = PetVideo()
        panda59.type = VideoType.PANDA.ordinal
        panda59.fileName = "panda_all_panda59"
        panda59.code = 1859
        panda59.duration = 414
        panda59.period = PeriodType.ALL.ordinal
        panda59.isStar = false
        panda59.title = "【19级熊孩子成长记】熊猫宝宝第一次被妈妈接纳，饲养员简直欣喜不已！"
        panda59.releaseTime = "2022-02-09 12:16:46"
        panda59.originalUrl = "https://www.bilibili.com/video/BV1AS4y1C79W"
        panda59.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda59.authorId = 12444306
        panda59.cover =
            "https://i0.hdslb.com/bfs/archive/096040cb4b0e3456d71729fbc57ddf334a54bd98.jpg"
        list.add(panda59)

        return list
    }
}