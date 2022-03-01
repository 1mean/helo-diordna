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
        panda1.authorName = "辛辛糖包"
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
        panda2.authorName = "巴顿洛洛"
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
        panda3.authorName = "陕西共青团"
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
        panda4.authorName = "软绵绵的北极星"
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
        panda5.authorName = "爱胖达Lovepanda"
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
        panda6.authorName = "爱胖达Lovepanda"
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
        panda7.authorName = "婧子819"
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
        panda8.title = "瞬间树叶落完了"
        panda8.releaseTime = "2021-11-15 22:16:36"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Y34y1d7hi"
        panda8.tags = "大熊猫,萌宠,动物圈"
        panda8.authorName = "熊猫的慢生活"
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
        panda9.title = "贴秋膘的季节来啦"
        panda9.releaseTime = "2021-10-30 00:18:44"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1iQ4y1q7cE"
        panda9.tags = "大熊猫,萌宠,动物圈"
        panda9.authorName = "熊猫的慢生活"
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
        panda10.title = "它昨天生日，今天补发一下"
        panda10.releaseTime = "2021-07-27 10:36:09"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1NL411n7D7"
        panda10.tags = "大熊猫,萌宠,动物圈"
        panda10.authorName = "熊猫的慢生活"
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
        panda11.title = "秦岭深处的宝贝生活状态怎么样"
        panda11.releaseTime = "2021-05-15 01:19:01"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1hK4y197Vu"
        panda11.tags = "大熊猫,萌宠,动物圈"
        panda11.authorName = "熊猫的慢生活"
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
        panda12.authorName = "熊猫的慢生活"
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
        panda13.authorName = "熊猫的慢生活"
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
        panda14.authorName = "Pandaful熊猫社区"
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
        panda15.authorName = "老奉的胖闺女小hun球"
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
        panda16.authorName = "秦墨年"
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
        panda17.authorName = "萌攻琤"
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
        panda18.authorName = "秦墨年"
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
        panda19.authorName = "秦墨年"
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
        panda20.authorName = "巴顿洛洛"
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
        panda21.authorName = "羽川゚"
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
        panda22.authorName = "pandapia熊猫乌托邦"
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
        panda23.authorName = "肉肉全地球最可爱"
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
        panda24.authorName = "隽一一"
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
        panda25.authorName = "羽川゚"
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
        panda26.title = "【大熊猫】洗澡澡，过新年咯！"
        panda26.releaseTime = "2021-02-11 17:50:40"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1ef4y1z7Ps"
        panda26.tags = "大熊猫,萌宠,动物圈"
        panda26.authorName = "古惟寞其铭"
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
        panda27.authorName = "滚滚观察员"
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
        panda28.authorName = "辛辛糖包"
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
        panda29.authorName = "辛辛糖包"
        panda29.cover =
            "https://i2.hdslb.com/bfs/archive/96c88000779215ec24b375a74376eaf1412282cf.jpg"
        list.add(panda29)

        val panda30 = PetVideo()
        panda30.type = VideoType.PANDA.ordinal
        panda30.fileName = "single30"
        panda30.code = 1317
        panda30.duration = 79
        panda30.period = PeriodType.SINGLE.ordinal
        panda30.isStar = false
        panda30.title = "【大熊猫奥莉奥】奥总裁吃窝头"
        panda30.releaseTime = "2020-04-29 12:40:21"
        panda30.originalUrl = "https://www.bilibili.com/video/BV1ak4y1r7E6"
        panda30.tags = "大熊猫,萌宠,动物圈"
        panda30.authorName = "迩後咩"
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
        panda31.authorName = "皓月是个小仙宝儿"
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
        panda32.authorName = "日常嗑猫C咩酱"
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
        panda33.authorName = "肉肉全地球最可爱"
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
        panda34.authorName = "熊猫能量社区"
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
        panda35.authorName = "老奉的胖闺女小hun球"
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
        panda36.authorName = "羽川゚"
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
        panda37.authorName = "pandapia熊猫乌托邦"
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
        panda38.title = "我！不！胖！！！！！！"
        panda38.releaseTime = "2018-01-02 21:00:54"
        panda38.originalUrl = "https://www.bilibili.com/video/BV1ZW411q7JD"
        panda38.tags = "大熊猫,萌宠,动物圈"
        panda38.authorName = "pandapia熊猫乌托邦"
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
        panda39.authorName = "pandapia熊猫乌托邦"
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
        panda40.authorName = "辛辛糖包"
        panda40.cover =
            "https://i2.hdslb.com/bfs/archive/b50dd830cc6db66bada6f9e4c7a7ba5f3f0d82b8.jpg"
        list.add(panda40)

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
        panda1.authorName = "pandapia熊猫乌托邦"
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
        panda2.authorName = "pandapia熊猫乌托邦"
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
        panda3.authorName = "pandapia熊猫乌托邦"
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
        panda4.authorName = "pandapia熊猫乌托邦"
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
        panda5.authorName = "pandapia熊猫乌托邦"
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
        panda6.authorName = "pandapia熊猫乌托邦"
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/aed050f1e5fb7a0d2dab51168c9732b989b4dc9d.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = VideoType.PANDA.ordinal
        panda7.fileName = "panda_all_panda7"
        panda7.code = 1252
        panda7.duration = 190
        panda7.period = PeriodType.ALL.ordinal
        panda7.isStar = true
        panda7.title = "你思念的那个远方的人，应该也在思念你吧"
        panda7.releaseTime = "2021-09-21 13:30:00"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1aq4y1f7n5"
        panda7.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda7.authorName = "pandapia熊猫乌托邦"
        panda7.cover =
            "https://i1.hdslb.com/bfs/archive/008b52ee9c0dd7f8b324ff7bb222bb7e053c2946.jpg"
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = VideoType.PANDA.ordinal
        panda8.fileName = "panda_all_panda8"
        panda8.code = 1253
        panda8.duration = 108
        panda8.period = PeriodType.ALL.ordinal
        panda8.isStar = true
        panda8.title = "藏好麻袋好吗！熊猫基地2021级熊猫云亮相大集合来啦！"
        panda8.releaseTime = "2021-09-30 18:16:56"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1cq4y1N7nK"
        panda8.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda8.authorName = "pandapia熊猫乌托邦"
        panda8.cover =
            "https://i1.hdslb.com/bfs/archive/ccb1bbc4242f7195a1c4fb94391e107974727dd5.jpg"
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = VideoType.PANDA.ordinal
        panda9.fileName = "panda_all_panda9"
        panda9.code = 1254
        panda9.duration = 87
        panda9.period = PeriodType.ALL.ordinal
        panda9.isStar = true
        panda9.title = "大熊猫能吃吗？当然啦！"
        panda9.releaseTime = "2021-10-21 12:50:33"
        panda9.originalUrl = "https://www.bilibili.com/video/BV15b4y1h7v9"
        panda9.tags = "大熊猫,成长,成长记录,萌宠,动物圈"
        panda9.authorName = "pandapia熊猫乌托邦"
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
        panda10.authorName = "学习强国"
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
        panda11.authorName = "pandapia熊猫乌托邦"
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
        panda12.authorName = "pandapia熊猫乌托邦"
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
        panda13.authorName = "pandapia熊猫乌托邦"
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
        panda14.authorName = "pandapia熊猫乌托邦"
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
        panda15.authorName = "pandapia熊猫乌托邦"
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
        panda16.authorName = "Junney山顶囤猫粮"
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
        panda17.authorName = "iPanda熊猫频道"
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
        panda18.authorName = "三物小白犀"
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
        panda19.authorName = "pandapia熊猫乌托邦"
        panda19.cover =
            "https://i2.hdslb.com/bfs/archive/956c48eff4af0da8e97609e3699eff638111da69.jpg"
        list.add(panda19)

        return list
    }
}