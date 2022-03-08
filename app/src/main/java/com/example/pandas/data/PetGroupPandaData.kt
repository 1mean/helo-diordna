import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/8/22 7:35 下午
 * @version: v1.0
 */
object PetGroupPandaData {

    private val list = mutableListOf<PetVideo>()

    fun getPetGroupPandaData(): MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = VideoType.PANDA.ordinal
        panda1.fileName = "panda_group_panda1"
        panda1.code = 337
        panda1.duration = 69
        panda1.period = PeriodType.GROUP.ordinal
        panda1.isStar = false
        panda1.title = "双倍可爱！全球首次拍到野生大熊猫亚成体双胞胎"
        panda1.releaseTime = "2019-12-19 15:42:34"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1rJ411t7wJ"
        panda1.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda1.authorName = "央视网"
        panda1.cover =
            "https://i2.hdslb.com/bfs/archive/ff7209ffe040bfe58e81bce9950f72334cf3724b.jpg"
        list.add(panda1)


        val panda2 = PetVideo()
        panda2.type = VideoType.PANDA.ordinal
        panda2.fileName = "panda_group_panda2"
        panda2.code = 338
        panda2.duration = 72
        panda2.period = PeriodType.GROUP.ordinal
        panda2.isStar = true
        panda2.title = "和花：打架不叫我，急死熊啦"
        panda2.releaseTime = "2021-12-12 09:00:13"
        panda2.originalUrl = "https://www.bilibili.com/video/BV13i4y1d7uh"
        panda2.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda2.authorName = "胖哒哒不月半"
        panda2.cover =
            "https://i0.hdslb.com/bfs/archive/7bf5b95b50ddc225413847c814a7583657bbed6b.jpg"
        list.add(panda2)


        val panda3 = PetVideo()
        panda3.type = VideoType.PANDA.ordinal
        panda3.fileName = "panda_group_panda3"
        panda3.code = 339
        panda3.duration = 27
        panda3.period = PeriodType.GROUP.ordinal
        panda3.isStar = false
        panda3.title = "大熊猫艾玖：妹儿，少熊不宜把眼睛闭上和花：放开我，我要吃瓜"
        panda3.releaseTime = "2021-12-13 13:27:19"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1HL411E7z9"
        panda3.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda3.authorName = "胖哒哒不月半"
        panda3.cover =
            "https://i2.hdslb.com/bfs/archive/631d52fb6cb66511bfdeedd8ceb2912c84c02192.jpg"
        list.add(panda3)


        val panda4 = PetVideo()
        panda4.type = VideoType.PANDA.ordinal
        panda4.fileName = "panda_group_panda4"
        panda4.code = 340
        panda4.duration = 48
        panda4.period = PeriodType.GROUP.ordinal
        panda4.isStar = false
        panda4.title = "大熊猫和花教你如何在不经意间抢走竹子还不伤感情"
        panda4.releaseTime = "2021-12-14 11:28:52"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1VL411E7vb"
        panda4.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda4.authorName = "胖哒哒不月半"
        panda4.cover =
            "https://i1.hdslb.com/bfs/archive/1b2d898871b249104d7ab6bdf39e0893abed194c.jpg"
        list.add(panda4)


        val panda5 = PetVideo()
        panda5.type = VideoType.PANDA.ordinal
        panda5.fileName = "panda_group_panda5"
        panda5.code = 341
        panda5.duration = 53
        panda5.period = PeriodType.GROUP.ordinal
        panda5.isStar = false
        panda5.title = "和花要参加奥运会为国争光天天埋头苦练"
        panda5.releaseTime = "2021-12-14 20:00:04"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1NL411j7yV"
        panda5.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda5.authorName = "胖哒哒不月半"
        panda5.cover =
            "https://i2.hdslb.com/bfs/archive/1b0b52e04a2994128778f15badcb602960c50743.jpg"
        list.add(panda5)


        val panda6 = PetVideo()
        panda6.type = VideoType.PANDA.ordinal
        panda6.fileName = "panda_group_panda6"
        panda6.code = 342
        panda6.duration = 169
        panda6.period = PeriodType.GROUP.ordinal
        panda6.isStar = false
        panda6.title = "和花被干妈和姐姐前后夹击，rua成了小熊饼干"
        panda6.releaseTime = "2021-12-21 14:29:58"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1Q44y1E7sj"
        panda6.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda6.authorName = "胖哒哒不月半"
        panda6.cover =
            "https://i2.hdslb.com/bfs/archive/fb370b20b460aa0f6844164a1edaf49720d9da10.jpg"
        list.add(panda6)


        val panda7 = PetVideo()
        panda7.type = VideoType.PANDA.ordinal
        panda7.fileName = "panda_group_panda7"
        panda7.code = 343
        panda7.duration = 71
        panda7.period = PeriodType.GROUP.ordinal
        panda7.isStar = false
        panda7.title = "【和花&和叶】小卖部快点开门！哎，别插队呀！"
        panda7.releaseTime = "2022-01-05 17:03:30"
        panda7.originalUrl = "https://www.bilibili.com/video/BV17m4y1X7FZ"
        panda7.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda7.authorName = "胖哒哒不月半"
        panda7.cover =
            "https://i0.hdslb.com/bfs/archive/9fdaa22ecb5c5c0051c848fe8c47f671829c23d6.jpg"
        list.add(panda7)


        val panda8 = PetVideo()
        panda8.type = VideoType.PANDA.ordinal
        panda8.fileName = "panda_group_panda8"
        panda8.code = 344
        panda8.duration = 72
        panda8.period = PeriodType.GROUP.ordinal
        panda8.isStar = true
        panda8.title = "【和花&艾玖】没有熊一起玩，那就自己下沟里溜达吧"
        panda8.releaseTime = "2022-01-07 14:51:54"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Ji4y197vt"
        panda8.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda8.authorName = "胖哒哒不月半"
        panda8.cover =
            "https://i2.hdslb.com/bfs/archive/289847f714f70eb3e1ab69ecec942a415a111f19.jpg"
        list.add(panda8)


        val panda9 = PetVideo()
        panda9.type = VideoType.PANDA.ordinal
        panda9.fileName = "panda_group_panda9"
        panda9.code = 345
        panda9.duration = 58
        panda9.period = PeriodType.GROUP.ordinal
        panda9.isStar = true
        panda9.title = "这么黏熊可爱的和花，你难道不心动吗？"
        panda9.releaseTime = "2021-12-20 22:07:01"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1ub4y1v7Ai"
        panda9.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda9.authorName = "胖哒哒不月半"
        panda9.cover =
            "https://i0.hdslb.com/bfs/archive/631e360291bec14ff01be22b126f2c22803df56f.jpg"
        list.add(panda9)


        val panda10 = PetVideo()
        panda10.type = VideoType.PANDA.ordinal
        panda10.fileName = "panda_group_panda10"
        panda10.code = 346
        panda10.duration = 453
        panda10.period = PeriodType.GROUP.ordinal
        panda10.isStar = true
        panda10.title = "好家伙！这场音乐会居然集齐了全国宝阵容？"
        panda10.releaseTime = "2022-01-01 12:00:03"
        panda10.originalUrl = "https://www.bilibili.com/video/BV14r4y1m7uR"
        panda10.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda10.authorName = "iPanda熊猫频道"
        panda10.cover =
            "https://i2.hdslb.com/bfs/archive/0a8f7a3d92d730dee574d325b35ed2325e13e961.jpg"
        list.add(panda10)


        val panda11 = PetVideo()
        panda11.type = VideoType.PANDA.ordinal
        panda11.fileName = "panda_group_panda11"
        panda11.code = 347
        panda11.duration = 122
        panda11.period = PeriodType.GROUP.ordinal
        panda11.isStar = true
        panda11.title = "叔姨们的魔性解说"
        panda11.releaseTime = "2022-01-05 16:22:41"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1ZD4y1F7Pp"
        panda11.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda11.authorName = "婕玉玉儿"
        panda11.cover =
            "https://i1.hdslb.com/bfs/archive/05adfbb412c872e52c95beb9d7204928ddb8feae.jpg"
        list.add(panda11)


        val panda12 = PetVideo()
        panda12.type = VideoType.PANDA.ordinal
        panda12.fileName = "panda_group_panda12"
        panda12.code = 68
        panda12.duration = 67
        panda12.period = PeriodType.GROUP.ordinal
        panda12.title = "【大熊猫和花】爷爷等等我，我偶尔也是可以倍速播放的"
        panda12.releaseTime = "2022-01-02 22:23:43"
        panda12.originalUrl = "https://www.bilibili.com/video/BV11b4y1n7yd?share_source=copy_web"
        panda12.tags = "萌宠,和花,动物,熊猫"
        panda12.authorName = "胖哒哒不月半"
        panda12.cover =
            "https://i2.hdslb.com/bfs/archive/711945b30d6bdd958b5140e5954c68d6b0f52f1e.jpg"
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = VideoType.PANDA.ordinal
        panda13.fileName = "panda_group_panda13"
        panda13.code = 69
        panda13.duration = 68
        panda13.period = PeriodType.GROUP.ordinal
        panda13.title = "熊猫和花:回家 or 继续耍，这或许是个问题"
        panda13.releaseTime = "2022-01-04 22:09:05"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1RR4y1u7Kc?share_source=copy_web"
        panda13.tags = "萌宠,和花,动物,熊猫"
        panda13.authorName = "胖哒哒不月半"
        panda13.cover =
            "https://i1.hdslb.com/bfs/archive/7ad9900d155d8047999fa4c581b2a15eba641e21.jpg"
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = VideoType.PANDA.ordinal
        panda14.fileName = "panda_group_panda14"
        panda14.code = 70
        panda14.duration = 113
        panda14.period = PeriodType.GROUP.ordinal
        panda14.title = "【大熊猫和花】任凭爷爷呼喊依然慢吞吞的花花"
        panda14.releaseTime = "2022-01-05 01:17:44"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1Fm4y1D7je?share_source=copy_web"
        panda14.tags = "萌宠,和花,动物,熊猫"
        panda14.authorName = "胖哒哒不月半"
        panda14.isStar = true
        panda14.cover =
            "https://i1.hdslb.com/bfs/archive/6659f4f5221f6d004c015ce5d44e9788957decb5.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = VideoType.PANDA.ordinal
        panda15.fileName = "panda_group_panda15"
        panda15.code = 71
        panda15.duration = 133
        panda15.period = PeriodType.GROUP.ordinal
        panda15.title = "和花现在不仅跑得快，还会“急刹”"
        panda15.releaseTime = "2022-01-04 23:08:40"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1qD4y1F7Rd?share_source=copy_web"
        panda15.tags = "大熊猫和花、和叶、艾玖、润玥"
        panda15.authorName = "胖哒哒不月半"
        panda15.isStar = true
        panda15.cover =
            "https://i0.hdslb.com/bfs/archive/6c8a7b2c45bd204a1f2698e9ff88439f902f7ba0.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = VideoType.PANDA.ordinal
        panda16.fileName = "panda_group_panda16"
        panda16.code = 337
        panda16.duration = 34
        panda16.period = PeriodType.GROUP.ordinal
        panda16.isStar = true
        panda16.title = "北川绝美睡颜"
        panda16.releaseTime = "2020-09-21 18:29:20"
        panda16.originalUrl = "https://www.bilibili.com/video/BV17h411X7sH/"
        panda16.tags = "北川,萌宠,萌萌哒,可爱,动物圈"
        panda16.authorName = "迩後咩"
        panda16.cover =
            "https://i2.hdslb.com/bfs/archive/310d407ea7a93e5cd90ffa41da847dc607e1eeca.jpg"
        list.add(panda16)


        val panda17 = PetVideo()
        panda17.type = VideoType.PANDA.ordinal
        panda17.fileName = "panda_group_panda17"
        panda17.code = 492
        panda17.duration = 135
        panda17.period = PeriodType.GROUP.ordinal
        panda17.isStar = false
        panda17.title = "萌头萌脑小包包，有点乖哦！"
        panda17.releaseTime = "2022-01-12 18:33:16"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1cb4y1H7Rr"
        panda17.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda17.authorName = "辛辛糖包"
        panda17.cover =
            "https://i1.hdslb.com/bfs/archive/b10de96933ab561eff7e38ad573d2891b60159b3.jpg"
        panda17.videoType = 0
        list.add(panda17)


        val panda18 = PetVideo()
        panda18.type = VideoType.PANDA.ordinal
        panda18.fileName = "panda_group_panda18"
        panda18.code = 493
        panda18.duration = 64
        panda18.period = PeriodType.GROUP.ordinal
        panda18.isStar = false
        panda18.title = "奇一和福来一起睡觉真有意思，奇一还特意把福来脸掰过来。【大熊猫奇一和福来】"
        panda18.releaseTime = "2022-01-18 00:24:41"
        panda18.originalUrl = "https://www.bilibili.com/video/BV18m4y1U7Kx"
        panda18.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda18.authorName = "青檬鱼看熊猫儿"
        panda18.cover =
            "https://i1.hdslb.com/bfs/archive/1ef020dc372a3452f3c806ca84acbd24af8a51b5.jpg"
        panda18.videoType = 0
        list.add(panda18)


        val panda19 = PetVideo()
        panda19.type = VideoType.PANDA.ordinal
        panda19.fileName = "panda_group_panda19"
        panda19.code = 494
        panda19.duration = 85
        panda19.period = PeriodType.GROUP.ordinal
        panda19.isStar = true
        panda19.title = "【大熊猫和花】和花脚一滑摔个底朝天，马上去找润玥撒娇求安慰"
        panda19.releaseTime = "2022-02-03 18:14:46"
        panda19.originalUrl = "https://www.bilibili.com/video/BV1QZ4y1d7my"
        panda19.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda19.authorName = "安娜丽丝k"
        panda19.cover =
            "https://i0.hdslb.com/bfs/archive/aedecae418fe9d6276a5142474fb677927b20dde.png"
        panda19.videoType = 0
        list.add(panda19)


        val panda20 = PetVideo()
        panda20.type = VideoType.PANDA.ordinal
        panda20.fileName = "panda_group_panda20"
        panda20.code = 495
        panda20.duration = 68
        panda20.period = PeriodType.GROUP.ordinal
        panda20.isStar = true
        panda20.title = "【大熊猫和花】和花花之沉浸式揉朵朵！"
        panda20.releaseTime = "2022-02-02 00:18:31"
        panda20.originalUrl = "https://www.bilibili.com/video/BV1kb4y1E7Hf"
        panda20.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda20.authorName = "安娜丽丝k"
        panda20.cover =
            "https://i1.hdslb.com/bfs/archive/d2097b361d0ef6725be32a3617653b8a6ca6db1b.jpg"
        panda20.videoType = 0
        list.add(panda20)


        val panda21 = PetVideo()
        panda21.type = VideoType.PANDA.ordinal
        panda21.fileName = "panda_group_panda21"
        panda21.code = 496
        panda21.duration = 96
        panda21.period = PeriodType.GROUP.ordinal
        panda21.isStar = false
        panda21.title = "【胖哒高能时刻】和花:幸好屁股肉多，不然就摔疼了"
        panda21.releaseTime = "2022-01-26 11:00:01"
        panda21.originalUrl = "https://www.bilibili.com/video/BV1PS4y1L7K6"
        panda21.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda21.authorName = "胖哒哒不月半"
        panda21.cover =
            "https://i1.hdslb.com/bfs/archive/f20f39819d49d71f41774c3214daa4db96c396b8.jpg"
        panda21.videoType = 0
        list.add(panda21)


        val panda22 = PetVideo()
        panda22.type = VideoType.PANDA.ordinal
        panda22.fileName = "panda_group_panda22"
        panda22.code = 497
        panda22.duration = 246
        panda22.period = PeriodType.GROUP.ordinal
        panda22.isStar = false
        panda22.title = "萌家三兄妹"
        panda22.releaseTime = "2021-05-19 15:13:05"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1qb4y1o7bB"
        panda22.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda22.authorName = "小兔纸月儿"
        panda22.cover =
            "https://i0.hdslb.com/bfs/archive/993b69930654fb6d1074268d085f792e63143d21.jpg"
        panda22.videoType = 0
        list.add(panda22)


        val panda23 = PetVideo()
        panda23.type = VideoType.PANDA.ordinal
        panda23.fileName = "panda_group_panda23"
        panda23.code = 498
        panda23.duration = 76
        panda23.period = PeriodType.GROUP.ordinal
        panda23.isStar = true
        panda23.title = "大熊猫和花：PP抱枕很舒服！"
        panda23.releaseTime = "2022-01-16 18:05:09"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1L34y1i7ss"
        panda23.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda23.authorName = "水果小分队的椰子"
        panda23.cover =
            "https://i0.hdslb.com/bfs/archive/35ef9a96ae602c5e087795fd3e767bda35c23146.jpg"
        panda23.videoType = 0
        list.add(panda23)


        val panda24 = PetVideo()
        panda24.type = VideoType.PANDA.ordinal
        panda24.fileName = "panda_group_panda24"
        panda24.code = 499
        panda24.duration = 65
        panda24.period = PeriodType.GROUP.ordinal
        panda24.isStar = false
        panda24.title = "大熊猫和花最新BGM——我是花花侠"
        panda24.releaseTime = "2022-01-22 18:05:16"
        panda24.originalUrl = "https://www.bilibili.com/video/BV11b4y1J79b"
        panda24.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda24.authorName = "水果小分队的椰子"
        panda24.cover =
            "https://i2.hdslb.com/bfs/archive/c80e5e2604786fea53aabbcf7fa8dcab31f4a9d7.jpg"
        panda24.videoType = 0
        list.add(panda24)


        val panda25 = PetVideo()
        panda25.type = VideoType.PANDA.ordinal
        panda25.fileName = "panda_group_panda25"
        panda25.code = 500
        panda25.duration = 69
        panda25.period = PeriodType.GROUP.ordinal
        panda25.isStar = false
        panda25.title = "大熊猫和花：我是无敌的小坏坏！"
        panda25.releaseTime = "2022-01-24 18:05:12"
        panda25.originalUrl = "https://www.bilibili.com/video/BV15S4y177zd"
        panda25.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda25.authorName = "水果小分队的椰子"
        panda25.cover =
            "https://i0.hdslb.com/bfs/archive/455f834ad14ef5c5860a8b80d38e5813d5e373a0.jpg"
        panda25.videoType = 0
        list.add(panda25)


        val panda26 = PetVideo()
        panda26.type = VideoType.PANDA.ordinal
        panda26.fileName = "panda_group_panda26"
        panda26.code = 501
        panda26.duration = 83
        panda26.period = PeriodType.GROUP.ordinal
        panda26.isStar = false
        panda26.title = "大熊猫和花：一咬二扒三上嘴，打架我在行"
        panda26.releaseTime = "2022-01-27 18:05:14"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1Wb4y1n7di"
        panda26.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda26.authorName = "水果小分队的椰子"
        panda26.cover =
            "https://i2.hdslb.com/bfs/archive/e35e5f5f525e2cbeffdc8142ba338e6ae0cdff33.jpg"
        panda26.videoType = 0
        list.add(panda26)


        val panda27 = PetVideo()
        panda27.type = VideoType.PANDA.ordinal
        panda27.fileName = "panda_group_panda27"
        panda27.code = 502
        panda27.duration = 90
        panda27.period = PeriodType.GROUP.ordinal
        panda27.isStar = false
        panda27.title = "大熊猫和花：我陪着你吃饭饭！"
        panda27.releaseTime = "2022-02-01 18:05:03"
        panda27.originalUrl = "https://www.bilibili.com/video/BV1mq4y1h77z"
        panda27.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda27.authorName = "水果小分队的椰子"
        panda27.cover =
            "https://i1.hdslb.com/bfs/archive/2368ba7f51e91f89e0e2b8c278d31cfc606e2fb4.jpg"
        panda27.videoType = 0
        list.add(panda27)


        val panda28 = PetVideo()
        panda28.type = VideoType.PANDA.ordinal
        panda28.fileName = "panda_group_panda28"
        panda28.code = 503
        panda28.duration = 90
        panda28.period = PeriodType.GROUP.ordinal
        panda28.isStar = true
        panda28.title = "【大熊猫和花】花花自己找了一根竹竿吃得有滋有味"
        panda28.releaseTime = "2022-01-31 00:43:13"
        panda28.originalUrl = "https://www.bilibili.com/video/BV1mb4y1E7bt"
        panda28.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda28.authorName = "空调轰轰响"
        panda28.cover =
            "https://i0.hdslb.com/bfs/archive/f5f6ab803d3d08b086b67c2cbe39e616e47439cc.jpg"
        panda28.videoType = 0
        list.add(panda28)


        val panda29 = PetVideo()
        panda29.type = VideoType.PANDA.ordinal
        panda29.fileName = "panda_group_panda29"
        panda29.code = 504
        panda29.duration = 71
        panda29.period = PeriodType.GROUP.ordinal
        panda29.isStar = false
        panda29.title = "大熊猫和花：过年啦，开饭啦，抢苹果了！全都是我的~"
        panda29.releaseTime = "2022-01-31 18:05:04"
        panda29.originalUrl = "https://www.bilibili.com/video/BV1YY411t7xZ"
        panda29.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda29.authorName = "水果小分队的椰子"
        panda29.cover =
            "https://i2.hdslb.com/bfs/archive/67e32773a748ef0d5f68887a0d7755b8ea9fd9cf.jpg"
        panda29.videoType = 0
        list.add(panda29)


        val panda30 = PetVideo()
        panda30.type = VideoType.PANDA.ordinal
        panda30.fileName = "panda_group_panda30"
        panda30.code = 505
        panda30.duration = 184
        panda30.period = PeriodType.GROUP.ordinal
        panda30.isStar = true
        panda30.title = "20161212奥莉奥、淼淼、园润三宝钓猫"
        panda30.releaseTime = "2016-12-26 21:48:49"
        panda30.originalUrl = "https://www.bilibili.com/video/BV11s411a7AG"
        panda30.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda30.authorName = "咪呜咪呜酱"
        panda30.cover =
            "https://i0.hdslb.com/bfs/archive/cd4e7cfa274b5af6d57b8b74b3c69439ad21be1a.jpg"
        panda30.videoType = 0
        list.add(panda30)


        val panda31 = PetVideo()
        panda31.type = VideoType.PANDA.ordinal
        panda31.fileName = "panda_group_panda31"
        panda31.code = 506
        panda31.duration = 183
        panda31.period = PeriodType.GROUP.ordinal
        panda31.isStar = false
        panda31.title = "奥莉奥、圆润、淼淼 钓猫【超清】"
        panda31.releaseTime = "2017-03-23 20:47:14"
        panda31.originalUrl = "https://www.bilibili.com/video/BV1Lx411k7qp"
        panda31.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda31.authorName = "胖达滾滾来"
        panda31.cover =
            "https://i2.hdslb.com/bfs/archive/e78378c58974ebf120bfd087f9ca9d3b77c375ed.jpg"
        panda31.videoType = 0
        list.add(panda31)


        val panda32 = PetVideo()
        panda32.type = VideoType.PANDA.ordinal
        panda32.fileName = "panda_group_panda32"
        panda32.code = 507
        panda32.duration = 97
        panda32.period = PeriodType.GROUP.ordinal
        panda32.isStar = true
        panda32.title = "【润淼】润润：淼淼起来吧，窝给泥拿竹子来了"
        panda32.releaseTime = "2018-07-12 12:11:30"
        panda32.originalUrl = "https://www.bilibili.com/video/BV1bs411H7iT"
        panda32.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda32.authorName = "次奥商"
        panda32.cover =
            "https://i0.hdslb.com/bfs/archive/4d05b9c368f4a84321e5b89402abfbba1d929544.jpg"
        panda32.videoType = 0
        list.add(panda32)


        val panda33 = PetVideo()
        panda33.type = VideoType.PANDA.ordinal
        panda33.fileName = "panda_group_panda33"
        panda33.code = 508
        panda33.duration = 96
        panda33.period = PeriodType.GROUP.ordinal
        panda33.isStar = false
        panda33.title = "【大熊猫和花】谢谢艾玖的特制磨牙棒！01.30"
        panda33.releaseTime = "2022-01-31 09:13:55"
        panda33.originalUrl = "https://www.bilibili.com/video/BV1Zb4y1E77V"
        panda33.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda33.authorName = "安娜丽丝k"
        panda33.cover =
            "https://i0.hdslb.com/bfs/archive/77ff33deca7c0845bdab1fbce225304c060f6d56.jpg"
        panda33.videoType = 0
        list.add(panda33)


        val panda34 = PetVideo()
        panda34.type = VideoType.PANDA.ordinal
        panda34.fileName = "panda_group_panda34"
        panda34.code = 509
        panda34.duration = 101
        panda34.period = PeriodType.GROUP.ordinal
        panda34.isStar = true
        panda34.title = "爷爷没得事，你们聊你们的，我玩我的！【大熊猫和花】"
        panda34.releaseTime = "2022-01-15 15:14:36"
        panda34.originalUrl = "https://www.bilibili.com/video/BV1F44y1L7Xg"
        panda34.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda34.authorName = "安娜丽丝k"
        panda34.cover =
            "https://i0.hdslb.com/bfs/archive/25ced3cf5aa119e628db951299cd7fdbbae206e5.jpg"
        panda34.videoType = 0
        list.add(panda34)


        val panda35 = PetVideo()
        panda35.type = VideoType.PANDA.ordinal
        panda35.fileName = "panda_group_panda35"
        panda35.code = 510
        panda35.duration = 110
        panda35.period = PeriodType.GROUP.ordinal
        panda35.isStar = false
        panda35.title = "和花榨汁“实锤”了，最后还duang了两下！【大熊猫和花】"
        panda35.releaseTime = "2022-01-29 22:51:09"
        panda35.originalUrl = "https://www.bilibili.com/video/BV1YP4y1N7cs"
        panda35.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda35.authorName = "安娜丽丝k"
        panda35.cover =
            "https://i1.hdslb.com/bfs/archive/e9806632e91322c0c30e3b98d8caea03c1b3eb47.jpg"
        panda35.videoType = 0
        list.add(panda35)


        val panda36 = PetVideo()
        panda36.type = VideoType.PANDA.ordinal
        panda36.fileName = "panda_group_panda36"
        panda36.code = 511
        panda36.duration = 164
        panda36.period = PeriodType.GROUP.ordinal
        panda36.isStar = false
        panda36.title = "菜总吃竹子，主任和姐姐撒娇，贴贴摊摊滚滚。。【大熊猫和花、润玥】"
        panda36.releaseTime = "2022-01-30 16:38:19"
        panda36.originalUrl = "https://www.bilibili.com/video/BV1cR4y1M7cg"
        panda36.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda36.authorName = "隽一一"
        panda36.cover =
            "https://i0.hdslb.com/bfs/archive/6ee6880510bb4df6c1681e7264512bf8e86e9f51.jpg"
        panda36.videoType = 0
        list.add(panda36)


        val panda37 = PetVideo()
        panda37.type = VideoType.PANDA.ordinal
        panda37.fileName = "panda_group_panda37"
        panda37.code = 512
        panda37.duration = 71
        panda37.period = PeriodType.GROUP.ordinal
        panda37.isStar = true
        panda37.title = "和花：猪八戒“耍”金箍棒，早晚要还“大师兄”"
        panda37.releaseTime = "2022-01-29 18:31:43"
        panda37.originalUrl = "https://www.bilibili.com/video/BV1H34y127Dj"
        panda37.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda37.authorName = "讷言小筑"
        panda37.cover =
            "https://i2.hdslb.com/bfs/archive/ca04048a555821248a824689185903892460e992.jpg"
        panda37.videoType = 0
        list.add(panda37)


        val panda38 = PetVideo()
        panda38.type = VideoType.PANDA.ordinal
        panda38.fileName = "panda_group_panda38"
        panda38.code = 513
        panda38.duration = 24
        panda38.period = PeriodType.GROUP.ordinal
        panda38.isStar = false
        panda38.title = "【七巧七喜】我感觉这是两个小朋友穿的熊猫装～还会推的！"
        panda38.releaseTime = "2022-01-21 23:56:16"
        panda38.originalUrl = "https://www.bilibili.com/video/BV1Jm4y1S7K3"
        panda38.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda38.authorName = "熊一只猫丶"
        panda38.cover =
            "https://i1.hdslb.com/bfs/archive/08caff3a9c9255179dde9536733e2c8bed9de0c1.jpg"
        panda38.videoType = 0
        list.add(panda38)


        val panda39 = PetVideo()
        panda39.type = VideoType.PANDA.ordinal
        panda39.fileName = "panda_group_panda39"
        panda39.code = 514
        panda39.duration = 68
        panda39.period = PeriodType.GROUP.ordinal
        panda39.isStar = false
        panda39.title = "幼年三嘟围追奶爸，和花又没赶上趟！01.29【大熊猫和花&和叶&润玥&艾玖】"
        panda39.releaseTime = "2022-01-30 00:46:59"
        panda39.originalUrl = "https://www.bilibili.com/video/BV1XZ4y1Z7zm"
        panda39.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda39.authorName = "安娜丽丝k"
        panda39.cover =
            "https://i1.hdslb.com/bfs/archive/ba45276a210d04dfa24dc15b4f178e77f8a194bb.jpg"
        panda39.videoType = 0
        list.add(panda39)


        val panda40 = PetVideo()
        panda40.type = VideoType.PANDA.ordinal
        panda40.fileName = "panda_group_panda40"
        panda40.code = 515
        panda40.duration = 169
        panda40.period = PeriodType.GROUP.ordinal
        panda40.isStar = true
        panda40.title = "“玖菜花”刚睡醒，小木架快挤不下了【大熊猫艾玖&菜菜&和花】"
        panda40.releaseTime = "2021-09-23 18:25:19"
        panda40.originalUrl = "https://www.bilibili.com/video/BV1Xf4y1w7qS"
        panda40.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda40.authorName = "朙雨"
        panda40.cover =
            "https://i1.hdslb.com/bfs/archive/b369c316178bd1605902ac31c2e7a5a930ca390a.jpg"
        panda40.videoType = 0
        list.add(panda40)


        val panda41 = PetVideo()
        panda41.type = VideoType.PANDA.ordinal
        panda41.fileName = "panda_group_panda41"
        panda41.code = 516
        panda41.duration = 170
        panda41.period = PeriodType.GROUP.ordinal
        panda41.isStar = true
        panda41.title = "四嘟围追奶爸，场面一度失控01.29【大熊猫和花、和叶、润玥、艾玖】"
        panda41.releaseTime = "2022-01-30 00:12:11"
        panda41.originalUrl = "https://www.bilibili.com/video/BV1LP4y1N7CK"
        panda41.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda41.authorName = "朙雨"
        panda41.cover =
            "https://i2.hdslb.com/bfs/archive/d8fd204aa2958e817abd735ee7a8f8743b1ee7a5.jpg"
        panda41.videoType = 0
        list.add(panda41)


        val panda42 = PetVideo()
        panda42.type = VideoType.PANDA.ordinal
        panda42.fileName = "panda_group_panda42"
        panda42.code = 517
        panda42.duration = 94
        panda42.period = PeriodType.GROUP.ordinal
        panda42.isStar = true
        panda42.title = "【大熊猫润玥】【大熊猫艾玖】润二狗大战艾玖，到底谁先着地呢？"
        panda42.releaseTime = "2021-08-10 20:36:37"
        panda42.originalUrl = "https://www.bilibili.com/video/BV1Mb4y1674P"
        panda42.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda42.authorName = "梅肉小熊最可爱"
        panda42.cover =
            "https://i0.hdslb.com/bfs/archive/2f8f2c0555de72b97d0737a3782b2692acc5e6c2.jpg"
        panda42.videoType = 0
        list.add(panda42)


        val panda43 = PetVideo()
        panda43.type = VideoType.PANDA.ordinal
        panda43.fileName = "panda_group_panda43"
        panda43.code = 518
        panda43.duration = 52
        panda43.period = PeriodType.GROUP.ordinal
        panda43.isStar = false
        panda43.title = "【大熊猫润玥/艾玖】好家伙，功仔都要说声了不起"
        panda43.releaseTime = "2021-03-07 17:35:23"
        panda43.originalUrl = "https://www.bilibili.com/video/BV1or4y1A7BD"
        panda43.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda43.authorName = "嗯嗯嗯对嗯"
        panda43.cover =
            "https://i0.hdslb.com/bfs/archive/db084c0a8bdf7c0987c16f78e52e0984436e7d63.jpg"
        panda43.videoType = 0
        list.add(panda43)


        val panda44 = PetVideo()
        panda44.type = VideoType.PANDA.ordinal
        panda44.fileName = "panda_group_panda44"
        panda44.code = 519
        panda44.duration = 128
        panda44.period = PeriodType.GROUP.ordinal
        panda44.isStar = false
        panda44.title = "【和花成长日记】“它好像知道自己很可爱欸！”"
        panda44.releaseTime = "2022-01-29 00:24:48"
        panda44.originalUrl = "https://www.bilibili.com/video/BV1vR4y1T7AZ"
        panda44.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda44.authorName = "胖哒哒不月半"
        panda44.cover =
            "https://i0.hdslb.com/bfs/archive/69bd98b7d6c7703feeba1cc094d0c9a2cf28e3bc.jpg"
        panda44.videoType = 0
        list.add(panda44)


        val panda45 = PetVideo()
        panda45.type = VideoType.PANDA.ordinal
        panda45.fileName = "panda_group_panda45"
        panda45.code = 520
        panda45.duration = 40
        panda45.period = PeriodType.GROUP.ordinal
        panda45.isStar = false
        panda45.title = "陪小树君玩耍，和花花真是个乖宝宝"
        panda45.releaseTime = "2022-01-28 14:43:08"
        panda45.originalUrl = "https://www.bilibili.com/video/BV19S4y1o7yt"
        panda45.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda45.authorName = "黑白宝宝小捣蛋"
        panda45.cover =
            "https://i1.hdslb.com/bfs/archive/2b3eda2acee4d2dc467ba235dc5579fcae242ca0.jpg"
        panda45.videoType = 0
        list.add(panda45)


        val panda46 = PetVideo()
        panda46.type = VideoType.PANDA.ordinal
        panda46.fileName = "panda_group_panda46"
        panda46.code = 521
        panda46.duration = 98
        panda46.period = PeriodType.GROUP.ordinal
        panda46.isStar = true
        panda46.title = "猪猪熊们回家干饭啦"
        panda46.releaseTime = "2022-01-28 12:35:14"
        panda46.originalUrl = "https://www.bilibili.com/video/BV1x3411h729"
        panda46.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda46.authorName = "开饭了大熊猫V"
        panda46.cover =
            "https://i2.hdslb.com/bfs/archive/252939cd88d14d90a75187527b8cd458bb2df5b2.jpg"
        panda46.videoType = 0
        list.add(panda46)


        val panda47 = PetVideo()
        panda47.type = VideoType.PANDA.ordinal
        panda47.fileName = "panda_group_panda47"
        panda47.code = 522
        panda47.duration = 71
        panda47.period = PeriodType.GROUP.ordinal
        panda47.isStar = false
        panda47.title = "你在干嘛呀？大熊猫和花：我在吃笋笋！“吃饭专用”"
        panda47.releaseTime = "2022-01-28 18:05:29"
        panda47.originalUrl = "https://www.bilibili.com/video/BV19F411n7pP"
        panda47.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda47.authorName = "水果小分队的椰子"
        panda47.cover =
            "https://i1.hdslb.com/bfs/archive/7fed8a17db6e95cc8d87738c6a6f85c81ba079ed.jpg"
        panda47.videoType = 0
        list.add(panda47)


        val panda48 = PetVideo()
        panda48.type = VideoType.PANDA.ordinal
        panda48.fileName = "panda_group_panda48"
        panda48.code = 523
        panda48.duration = 191
        panda48.period = PeriodType.GROUP.ordinal
        panda48.isStar = false
        panda48.title = "【绩笑】小姨我来了！"
        panda48.releaseTime = "2020-07-17 08:30:24"
        panda48.originalUrl = "https://www.bilibili.com/video/BV1LD4y1D7YM"
        panda48.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda48.authorName = "绩笑笑最可爱啦"
        panda48.cover =
            "https://i0.hdslb.com/bfs/archive/ca6a3567071ee5cbbb3560f8245065bdcdf131c6.jpg"
        panda48.videoType = 0
        list.add(panda48)


        val panda49 = PetVideo()
        panda49.type = VideoType.PANDA.ordinal
        panda49.fileName = "panda_group_panda49"
        panda49.code = 524
        panda49.duration = 159
        panda49.period = PeriodType.GROUP.ordinal
        panda49.isStar = true
        panda49.title = "【大熊猫和花】好可爱哦！花花在灌木丛中打盹儿休息"
        panda49.releaseTime = "2021-12-17 20:19:31"
        panda49.originalUrl = "https://www.bilibili.com/video/BV1Q44y1E7Xd"
        panda49.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda49.authorName = "朙雨"
        panda49.cover =
            "https://i2.hdslb.com/bfs/archive/6028f613d83626be8dff5f1cd5fdfc24abf5bc0d.jpg"
        panda49.videoType = 0
        list.add(panda49)


        val panda50 = PetVideo()
        panda50.type = VideoType.PANDA.ordinal
        panda50.fileName = "panda_group_panda50"
        panda50.code = 525
        panda50.duration = 184
        panda50.period = PeriodType.GROUP.ordinal
        panda50.isStar = false
        panda50.title = "【大熊猫和花】花花好会摆pose，边走边摆，还对着镜头笑"
        panda50.releaseTime = "2022-01-28 10:01:54"
        panda50.originalUrl = "https://www.bilibili.com/video/BV1ab4y1E7Lb"
        panda50.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda50.authorName = "朙雨"
        panda50.cover =
            "https://i0.hdslb.com/bfs/archive/c426ba48f3c57a3d3a5af7a36d50cf027729c1b2.jpg"
        panda50.videoType = 0
        list.add(panda50)


        val panda51 = PetVideo()
        panda51.type = VideoType.PANDA.ordinal
        panda51.fileName = "panda_group_panda51"
        panda51.code = 526
        panda51.duration = 267
        panda51.period = PeriodType.GROUP.ordinal
        panda51.isStar = true
        panda51.title = "【大熊猫和花 艾玖】花花想要碰瓷艾玖姐姐，被姐姐识破后失落离开"
        panda51.releaseTime = "2022-01-26 18:40:00"
        panda51.originalUrl = "https://www.bilibili.com/video/BV1Wm4y1S7XW"
        panda51.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda51.authorName = "瑞壑"
        panda51.cover =
            "https://i1.hdslb.com/bfs/archive/3a46179f05410ebd353632768bff2d6743dedfaf.jpg"
        panda51.videoType = 0
        list.add(panda51)


        val panda52 = PetVideo()
        panda52.type = VideoType.PANDA.ordinal
        panda52.fileName = "panda_group_panda52"
        panda52.code = 527
        panda52.duration = 159
        panda52.period = PeriodType.GROUP.ordinal
        panda52.isStar = true
        panda52.title = "【大熊猫】和花古风（淑女版）"
        panda52.releaseTime = "2022-01-26 20:55:45"
        panda52.originalUrl = "https://www.bilibili.com/video/BV1yY41147Yj"
        panda52.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda52.authorName = "摄影师动物米"
        panda52.cover =
            "https://i1.hdslb.com/bfs/archive/5ad3e79b4087e2290a10f1c389d5984046d9aa9b.jpg"
        panda52.videoType = 0
        list.add(panda52)


        val panda53 = PetVideo()
        panda53.type = VideoType.PANDA.ordinal
        panda53.fileName = "panda_group_panda53"
        panda53.code = 528
        panda53.duration = 80
        panda53.period = PeriodType.GROUP.ordinal
        panda53.isStar = true
        panda53.title = "【大熊猫和花】和花吃竹子~~~皮儿"
        panda53.releaseTime = "2022-01-27 00:05:49"
        panda53.originalUrl = "https://www.bilibili.com/video/BV1b3411h7BG"
        panda53.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda53.authorName = "abigail-Sher"
        panda53.cover =
            "https://i2.hdslb.com/bfs/archive/1cdf4803c32be0345d6f458e603f73f335aa9bea.jpg"
        panda53.videoType = 0
        list.add(panda53)


        val panda54 = PetVideo()
        panda54.type = VideoType.PANDA.ordinal
        panda54.fileName = "panda_group_panda54"
        panda54.code = 529
        panda54.duration = 34
        panda54.period = PeriodType.GROUP.ordinal
        panda54.isStar = false
        panda54.title = "大熊猫和花和叶-臭迪迪竟然趁我不备偷偷爬树，得想个办法把他拉下来"
        panda54.releaseTime = "2022-01-26 18:47:34"
        panda54.originalUrl = "https://www.bilibili.com/video/BV1ha411m7XL"
        panda54.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda54.authorName = "和和和花花"
        panda54.cover =
            "https://i2.hdslb.com/bfs/archive/74b020b609c25186dcdcef3a02cf47c45e333acc.jpg"
        panda54.videoType = 0
        list.add(panda54)


        val panda55 = PetVideo()
        panda55.type = VideoType.PANDA.ordinal
        panda55.fileName = "panda_group_panda55"
        panda55.code = 530
        panda55.duration = 44
        panda55.period = PeriodType.GROUP.ordinal
        panda55.isStar = true
        panda55.title = "巡视领地成和花"
        panda55.releaseTime = "2022-01-27 23:18:32"
        panda55.originalUrl = "https://www.bilibili.com/video/BV1nZ4y1Z7Wc"
        panda55.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda55.authorName = "和和和花花"
        panda55.cover =
            "https://i1.hdslb.com/bfs/archive/8dbaf16f062fb533497012fc005b2248d19ece12.jpg"
        panda55.videoType = 0
        list.add(panda55)


        val panda56 = PetVideo()
        panda56.type = VideoType.PANDA.ordinal
        panda56.fileName = "panda_group_panda56"
        panda56.code = 531
        panda56.duration = 85
        panda56.period = PeriodType.GROUP.ordinal
        panda56.isStar = false
        panda56.title = "【大熊猫七巧、七喜】大阿福家草原姐妹花的温馨小日子"
        panda56.releaseTime = "2021-10-30 11:30:09"
        panda56.originalUrl = "https://www.bilibili.com/video/BV1Yq4y1G7nv"
        panda56.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda56.authorName = "好喜欢金虎和大阿福"
        panda56.cover =
            "https://i1.hdslb.com/bfs/archive/4b87e83166b415902527f1bab3b2fc20569a3b57.jpg"
        panda56.videoType = 0
        list.add(panda56)


        val panda57 = PetVideo()
        panda57.type = VideoType.PANDA.ordinal
        panda57.fileName = "panda_group_panda57"
        panda57.code = 532
        panda57.duration = 59
        panda57.period = PeriodType.GROUP.ordinal
        panda57.isStar = true
        panda57.title = "七巧七喜与新滑梯"
        panda57.releaseTime = "2020-11-02 23:34:11"
        panda57.originalUrl = "https://www.bilibili.com/video/BV1JV411172Y"
        panda57.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda57.authorName = "盆盆脸"
        panda57.cover =
            "https://i1.hdslb.com/bfs/archive/21eedb6dd2da03307c675bc72c58f51b5f9250be.jpg"
        panda57.videoType = 0
        list.add(panda57)


        val panda58 = PetVideo()
        panda58.type = VideoType.PANDA.ordinal
        panda58.fileName = "panda_group_panda58"
        panda58.code = 533
        panda58.duration = 213
        panda58.period = PeriodType.GROUP.ordinal
        panda58.isStar = false
        panda58.title = "【原创】【七巧七喜】给我最爱姐妹花"
        panda58.releaseTime = "2016-09-26 10:48:47"
        panda58.originalUrl = "https://www.bilibili.com/video/BV1zs411t76B"
        panda58.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda58.authorName = "汽水吧唧"
        panda58.cover =
            "https://i1.hdslb.com/bfs/archive/ed5f653905343ebef3d9070e6623a24845ec8eff.jpg"
        panda58.videoType = 0
        list.add(panda58)


        val panda59 = PetVideo()
        panda59.type = VideoType.PANDA.ordinal
        panda59.fileName = "panda_group_panda59"
        panda59.code = 534
        panda59.duration = 80
        panda59.period = PeriodType.GROUP.ordinal
        panda59.isStar = false
        panda59.title = "【大熊猫七巧、七喜】小汽水又吵姐姐睡觉了"
        panda59.releaseTime = "2021-02-10 11:47:11"
        panda59.originalUrl = "https://www.bilibili.com/video/BV1T54y1W7Zt"
        panda59.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda59.authorName = "好喜欢金虎和大阿福"
        panda59.cover =
            "https://i2.hdslb.com/bfs/archive/d0ba1bb65f697db8b797866ab837f85eeab77626.jpg"
        panda59.videoType = 0
        list.add(panda59)


        val panda60 = PetVideo()
        panda60.type = VideoType.PANDA.ordinal
        panda60.fileName = "panda_group_panda60"
        panda60.code = 535
        panda60.duration = 67
        panda60.period = PeriodType.GROUP.ordinal
        panda60.isStar = true
        panda60.title = "【大熊猫七巧七喜】今天也是汽水欠rua的一天，等姐姐睡醒教你做熊"
        panda60.releaseTime = "2020-01-02 22:54:35"
        panda60.originalUrl = "https://www.bilibili.com/video/BV1uJ411j7to"
        panda60.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda60.authorName = "好喜欢金虎和大阿福"
        panda60.cover =
            "https://i1.hdslb.com/bfs/archive/137848ec6ab1ab6bed52cf97186831d462ca060e.jpg"
        panda60.videoType = 0
        list.add(panda60)


        val panda61 = PetVideo()
        panda61.type = VideoType.PANDA.ordinal
        panda61.fileName = "panda_group_panda61"
        panda61.code = 536
        panda61.duration = 92
        panda61.period = PeriodType.GROUP.ordinal
        panda61.isStar = true
        panda61.title = "【大熊猫七巧、七喜】奇福的两个大胖闺女，巧喜姐妹花今天6岁啦"
        panda61.releaseTime = "2020-08-02 09:30:56"
        panda61.originalUrl = "https://www.bilibili.com/video/BV1bk4y1m77F"
        panda61.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda61.authorName = "好喜欢金虎和大阿福"
        panda61.cover =
            "https://i1.hdslb.com/bfs/archive/7486701f6b472a90e95c1508bfad0b06a0002edd.jpg"
        panda61.videoType = 0
        list.add(panda61)


        val panda62 = PetVideo()
        panda62.type = VideoType.PANDA.ordinal
        panda62.fileName = "panda_group_panda62"
        panda62.code = 537
        panda62.duration = 36
        panda62.period = PeriodType.GROUP.ordinal
        panda62.isStar = false
        panda62.title = "【大熊猫七巧、七喜】饭饭抢着吃才香～"
        panda62.releaseTime = "2021-02-02 13:15:13"
        panda62.originalUrl = "https://www.bilibili.com/video/BV1br4y1K7Zi"
        panda62.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda62.authorName = "好喜欢金虎和大阿福"
        panda62.cover =
            "https://i1.hdslb.com/bfs/archive/df69a77976ff162804b7fcebdbcd6b4ca64a11b0.jpg"
        panda62.videoType = 0
        list.add(panda62)


        val panda63 = PetVideo()
        panda63.type = VideoType.PANDA.ordinal
        panda63.fileName = "panda_group_panda63"
        panda63.code = 538
        panda63.duration = 30
        panda63.period = PeriodType.GROUP.ordinal
        panda63.isStar = true
        panda63.title = "【大熊猫七巧七喜】寒来暑往 秋收冬藏"
        panda63.releaseTime = "2021-11-07 11:15:21"
        panda63.originalUrl = "https://www.bilibili.com/video/BV1mg411K7Nf"
        panda63.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda63.authorName = "好喜欢金虎和大阿福"
        panda63.cover =
            "https://i0.hdslb.com/bfs/archive/1bbaed29107f7a3de23a055ddb307705d12cb8a7.jpg"
        panda63.videoType = 0
        list.add(panda63)


        val panda64 = PetVideo()
        panda64.type = VideoType.PANDA.ordinal
        panda64.fileName = "panda_group_panda64"
        panda64.code = 539
        panda64.duration = 84
        panda64.period = PeriodType.GROUP.ordinal
        panda64.isStar = false
        panda64.title = "【大熊猫七巧、七喜】第一次看巧儿生气，汽水该打pp啦～"
        panda64.releaseTime = "2020-05-26 18:16:56"
        panda64.originalUrl = "https://www.bilibili.com/video/BV1r54y1D7cW"
        panda64.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda64.authorName = "好喜欢金虎和大阿福"
        panda64.cover =
            "https://i1.hdslb.com/bfs/archive/85d5249f454615033e5f21dbeead868aa4871b1b.jpg"
        panda64.videoType = 0
        list.add(panda64)


        val panda65 = PetVideo()
        panda65.type = VideoType.PANDA.ordinal
        panda65.fileName = "panda_group_panda65"
        panda65.code = 540
        panda65.duration = 215
        panda65.period = PeriodType.GROUP.ordinal
        panda65.isStar = true
        panda65.title = "【大熊猫七巧、七喜】30秒左右高能 打雪仗的巧喜姐妹花"
        panda65.releaseTime = "2019-11-30 11:32:01"
        panda65.originalUrl = "https://www.bilibili.com/video/BV1CJ411Q7Bm"
        panda65.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda65.authorName = "好喜欢金虎和大阿福"
        panda65.cover =
            "https://i0.hdslb.com/bfs/archive/3f7208616abed5eda4191f63f2efff9c21eee400.jpg"
        panda65.videoType = 0
        list.add(panda65)


        val panda66 = PetVideo()
        panda66.type = VideoType.PANDA.ordinal
        panda66.fileName = "panda_group_panda66"
        panda66.code = 541
        panda66.duration = 51
        panda66.period = PeriodType.GROUP.ordinal
        panda66.isStar = false
        panda66.title = "宠妹的七巧撒娇的七喜"
        panda66.releaseTime = "2020-04-03 15:29:05"
        panda66.originalUrl = "https://www.bilibili.com/video/BV1vp4y117Gd"
        panda66.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda66.authorName = "盆盆脸"
        panda66.cover =
            "https://i1.hdslb.com/bfs/archive/797d3b0909a562de0fdc41b8184af1c036f0d26d.jpg"
        panda66.videoType = 0
        list.add(panda66)


        val panda67 = PetVideo()
        panda67.type = VideoType.PANDA.ordinal
        panda67.fileName = "panda_group_panda67"
        panda67.code = 542
        panda67.duration = 60
        panda67.period = PeriodType.GROUP.ordinal
        panda67.isStar = true
        panda67.title = "七巧七喜吊篮悠闲晒太阳"
        panda67.releaseTime = "2021-01-13 19:01:30"
        panda67.originalUrl = "https://www.bilibili.com/video/BV1cr4y1M7WB"
        panda67.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda67.authorName = "盆盆脸"
        panda67.cover =
            "https://i2.hdslb.com/bfs/archive/0a17532b39fafb025b7b49dd5d36a49786962e01.jpg"
        panda67.videoType = 0
        list.add(panda67)


        val panda68 = PetVideo()
        panda68.type = VideoType.PANDA.ordinal
        panda68.fileName = "panda_group_panda68"
        panda68.code = 543
        panda68.duration = 51
        panda68.period = PeriodType.GROUP.ordinal
        panda68.isStar = true
        panda68.title = "【大熊猫七巧、七喜】麻麻不在身边，巧胖胖照顾汽水妹妹"
        panda68.releaseTime = "2020-04-07 21:30:29"
        panda68.originalUrl = "https://www.bilibili.com/video/BV12c411h7nK"
        panda68.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda68.authorName = "好喜欢金虎和大阿福"
        panda68.cover =
            "https://i0.hdslb.com/bfs/archive/5583f3d4bce6fdef84a47318ab13700e860a0c48.jpg"
        panda68.videoType = 0
        list.add(panda68)


        val panda69 = PetVideo()
        panda69.type = VideoType.PANDA.ordinal
        panda69.fileName = "panda_group_panda69"
        panda69.code = 544
        panda69.duration = 18
        panda69.period = PeriodType.GROUP.ordinal
        panda69.isStar = false
        panda69.title = "【大熊猫七巧.七喜】汽水妹妹喜欢黏着姐姐坐"
        panda69.releaseTime = "2020-10-10 20:28:31"
        panda69.originalUrl = "https://www.bilibili.com/video/BV1P541177DR"
        panda69.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda69.authorName = "好喜欢金虎和大阿福"
        panda69.cover =
            "https://i0.hdslb.com/bfs/archive/0304ce9626bf2bbbf75ad6cd548431657fd5798d.jpg"
        panda69.videoType = 0
        list.add(panda69)


        val panda70 = PetVideo()
        panda70.type = VideoType.PANDA.ordinal
        panda70.fileName = "panda_group_panda70"
        panda70.code = 545
        panda70.duration = 32
        panda70.period = PeriodType.GROUP.ordinal
        panda70.isStar = true
        panda70.title = "【大熊猫七巧、七喜】姐妹俩面对面吃饭饭"
        panda70.releaseTime = "2021-05-15 19:00:01"
        panda70.originalUrl = "https://www.bilibili.com/video/BV1Lv41157Yv"
        panda70.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda70.authorName = "好喜欢金虎和大阿福"
        panda70.cover =
            "https://i2.hdslb.com/bfs/archive/e90c06f245cdd3b391ebdebcfdea4e32ac148629.jpg"
        panda70.videoType = 0
        list.add(panda70)


        val panda71 = PetVideo()
        panda71.type = VideoType.PANDA.ordinal
        panda71.fileName = "panda_group_panda71"
        panda71.code = 546
        panda71.duration = 40
        panda71.period = PeriodType.GROUP.ordinal
        panda71.isStar = true
        panda71.title = "【大熊猫七巧七喜】姐妹俩靠在一起睡觉 躺着也对着睡"
        panda71.releaseTime = "2020-01-10 22:10:04"
        panda71.originalUrl = "https://www.bilibili.com/video/BV1mJ411H7UZ"
        panda71.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda71.authorName = "好喜欢金虎和大阿福"
        panda71.cover =
            "https://i2.hdslb.com/bfs/archive/9df0b34b1f3a8c55d2bb8fa09aa29ac1d4d797d5.jpg"
        panda71.videoType = 0
        list.add(panda71)


        val panda72 = PetVideo()
        panda72.type = VideoType.PANDA.ordinal
        panda72.fileName = "panda_group_panda72"
        panda72.code = 547
        panda72.duration = 99
        panda72.period = PeriodType.GROUP.ordinal
        panda72.isStar = false
        panda72.title = "【大熊猫七巧、七喜】巧胖胖的摸脸杀"
        panda72.releaseTime = "2021-11-04 12:49:01"
        panda72.originalUrl = "https://www.bilibili.com/video/BV1yF411a7oZ"
        panda72.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda72.authorName = "好喜欢金虎和大阿福"
        panda72.cover =
            "https://i1.hdslb.com/bfs/archive/23f13b29ae782cfed741de31fff614358d005f0a.jpg"
        panda72.videoType = 0
        list.add(panda72)


        val panda73 = PetVideo()
        panda73.type = VideoType.PANDA.ordinal
        panda73.fileName = "panda_group_panda73"
        panda73.code = 548
        panda73.duration = 600
        panda73.period = PeriodType.GROUP.ordinal
        panda73.isStar = false
        panda73.title = "【和花和叶】中午是弟弟陪花花在木架上玩，给姐姐rua，然后陪姐姐睡午觉！和叶真是暖心的弟弟！"
        panda73.releaseTime = "2022-01-11 15:30:04"
        panda73.originalUrl = "https://www.bilibili.com/video/BV1oS4y1Z7LD"
        panda73.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda73.authorName = "里予妞妞"
        panda73.cover =
            "https://i2.hdslb.com/bfs/archive/902075d5a39f68cfd854ff9ea0fe7c7f521c5934.jpg"
        panda73.videoType = 0
        list.add(panda73)


        val panda74 = PetVideo()
        panda74.type = VideoType.PANDA.ordinal
        panda74.fileName = "panda_group_panda74"
        panda74.code = 549
        panda74.duration = 72
        panda74.period = PeriodType.GROUP.ordinal
        panda74.isStar = false
        panda74.title = "女明星喝水肯定要悄悄咪咪的！【大熊猫和花】"
        panda74.releaseTime = "2022-01-12 18:32:51"
        panda74.originalUrl = "https://www.bilibili.com/video/BV1gR4y1g7ej"
        panda74.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda74.authorName = "安娜丽丝k"
        panda74.cover =
            "https://i2.hdslb.com/bfs/archive/c45f04ded886b40923745bce525860d66e363f0a.jpg"
        panda74.videoType = 0
        list.add(panda74)


        val panda75 = PetVideo()
        panda75.type = VideoType.PANDA.ordinal
        panda75.fileName = "panda_group_panda75"
        panda75.code = 550
        panda75.duration = 68
        panda75.period = PeriodType.GROUP.ordinal
        panda75.isStar = false
        panda75.title = "【大熊猫】和花后空翻 和花快乐乱剪  和花特写（悍女版）"
        panda75.releaseTime = "2022-01-22 20:00:12"
        panda75.originalUrl = "https://www.bilibili.com/video/BV17R4y1u7BH"
        panda75.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda75.authorName = "摄影师动物米"
        panda75.cover =
            "https://i2.hdslb.com/bfs/archive/4b96bdf3bfa01c996ce7e80877b626e73a70ed9b.jpg"
        panda75.videoType = 0
        list.add(panda75)


        val panda76 = PetVideo()
        panda76.type = VideoType.PANDA.ordinal
        panda76.fileName = "panda_group_panda76"
        panda76.code = 551
        panda76.duration = 79
        panda76.period = PeriodType.GROUP.ordinal
        panda76.isStar = false
        panda76.title = "来熊啊～快把姐姐们拉走！“底层浪”实锤【大熊猫成浪成风绩笑】"
        panda76.releaseTime = "2022-01-14 20:56:41"
        panda76.originalUrl = "https://www.bilibili.com/video/BV1Bq4y1y7AN"
        panda76.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda76.authorName = "元宝纹的小锦鲤"
        panda76.cover =
            "https://i2.hdslb.com/bfs/archive/f91e7a0ea6135ffba73a42bbb1ff4a507a29426c.jpg"
        panda76.videoType = 0
        list.add(panda76)


        val panda77 = PetVideo()
        panda77.type = VideoType.PANDA.ordinal
        panda77.fileName = "panda_group_panda77"
        panda77.code = 552
        panda77.duration = 212
        panda77.period = PeriodType.GROUP.ordinal
        panda77.isStar = true
        panda77.title = "【大熊猫和花 和叶 润玥 艾玖】下班途中，和叶请润玥做新发型（或许是被迫？）"
        panda77.releaseTime = "2022-01-25 18:15:35"
        panda77.originalUrl = "https://www.bilibili.com/video/BV15b4y1n7qr"
        panda77.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda77.authorName = "瑞壑"
        panda77.cover =
            "https://i0.hdslb.com/bfs/archive/331aff1cb160cfd91b5afdedee49bbfb440dddb7.jpg"
        panda77.videoType = 0
        list.add(panda77)


        val panda78 = PetVideo()
        panda78.type = VideoType.PANDA.ordinal
        panda78.fileName = "panda_group_panda78"
        panda78.code = 553
        panda78.duration = 45
        panda78.period = PeriodType.GROUP.ordinal
        panda78.isStar = false
        panda78.title = "一根小木棍和花花也可以玩好久，猫孩子能多点玩具多好啊"
        panda78.releaseTime = "2022-01-25 22:28:11"
        panda78.originalUrl = "https://www.bilibili.com/video/BV1S34y117r9"
        panda78.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda78.authorName = "黑白宝宝小捣蛋"
        panda78.cover =
            "https://i2.hdslb.com/bfs/archive/3b112d196f189ecf9540504771bcd4ba69b5fbe2.jpg"
        panda78.videoType = 0
        list.add(panda78)


        val panda79 = PetVideo()
        panda79.type = VideoType.PANDA.ordinal
        panda79.fileName = "panda_group_panda79"
        panda79.code = 554
        panda79.duration = 80
        panda79.period = PeriodType.GROUP.ordinal
        panda79.isStar = false
        panda79.title = "大冬天泡澡的成风，出浴后还在妹妹身上擦水。【大熊猫成风、成浪】"
        panda79.releaseTime = "2022-01-25 13:00:18"
        panda79.originalUrl = "https://www.bilibili.com/video/BV1su41117rX"
        panda79.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda79.authorName = "隽一一"
        panda79.cover =
            "https://i1.hdslb.com/bfs/archive/bdf523e5c19ef8180ba9d82d0e9a2b021406e5bc.jpg"
        panda79.videoType = 0
        list.add(panda79)


        val panda80 = PetVideo()
        panda80.type = VideoType.PANDA.ordinal
        panda80.fileName = "panda_group_panda80"
        panda80.code = 555
        panda80.duration = 104
        panda80.period = PeriodType.GROUP.ordinal
        panda80.isStar = false
        panda80.title = "认真吃竹子的小乖乖。【大熊猫和花】"
        panda80.releaseTime = "2022-01-25 20:02:33"
        panda80.originalUrl = "https://www.bilibili.com/video/BV1eq4y187vW"
        panda80.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda80.authorName = "隽一一"
        panda80.cover =
            "https://i0.hdslb.com/bfs/archive/052fa505207c217560e14a60da6685b1f955dfc1.jpg"
        panda80.videoType = 0
        list.add(panda80)


        val panda81 = PetVideo()
        panda81.type = VideoType.PANDA.ordinal
        panda81.fileName = "panda_group_panda81"
        panda81.code = 556
        panda81.duration = 75
        panda81.period = PeriodType.GROUP.ordinal
        panda81.isStar = true
        panda81.title = "大熊猫和花花今天精神饱满，适合被我牵走"
        panda81.releaseTime = "2022-01-02 18:05:06"
        panda81.originalUrl = "https://www.bilibili.com/video/BV1yb4y1Y7aM"
        panda81.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda81.authorName = "水果小分队的椰子"
        panda81.cover =
            "https://i0.hdslb.com/bfs/archive/61d25614e40c32cf6e16f279429ccfce75ae7e29.jpg"
        panda81.videoType = 0
        list.add(panda81)


        val panda82 = PetVideo()
        panda82.type = VideoType.PANDA.ordinal
        panda82.fileName = "panda_group_panda82"
        panda82.code = 557
        panda82.duration = 259
        panda82.period = PeriodType.GROUP.ordinal
        panda82.isStar = false
        panda82.title = "【大熊猫福双】双儿今天和小熊友们玩得开心吗？"
        panda82.releaseTime = "2022-01-25 21:53:42"
        panda82.originalUrl = "https://www.bilibili.com/video/BV1ru41117B6"
        panda82.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda82.authorName = "丶祀很宔"
        panda82.cover =
            "https://i1.hdslb.com/bfs/archive/2c29ac81400608c574fbe6ee22427a0097c7cd0c.jpg"
        panda82.videoType = 0
        list.add(panda82)


        val panda83 = PetVideo()
        panda83.type = VideoType.PANDA.ordinal
        panda83.fileName = "panda_group_panda83"
        panda83.code = 558
        panda83.duration = 721
        panda83.period = PeriodType.GROUP.ordinal
        panda83.isStar = false
        panda83.title = "【大熊猫和花 润玥 和叶】决战小木架之巅：除了叶子弟弟是傻子，其它剧情我不告诉你"
        panda83.releaseTime = "2022-01-24 16:37:08"
        panda83.originalUrl = "https://www.bilibili.com/video/BV1TP4y1N7Xb"
        panda83.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda83.authorName = "瑞壑"
        panda83.cover =
            "https://i0.hdslb.com/bfs/archive/3810402573810b0b348e654c064a4de2c524b4d3.jpg"
        panda83.videoType = 0
        list.add(panda83)


        val panda84 = PetVideo()
        panda84.type = VideoType.PANDA.ordinal
        panda84.fileName = "panda_group_panda84"
        panda84.code = 559
        panda84.duration = 146
        panda84.period = PeriodType.GROUP.ordinal
        panda84.isStar = false
        panda84.title = "【和花&和叶&润玥】喜欢凑热闹的小和花"
        panda84.releaseTime = "2022-01-21 11:30:08"
        panda84.originalUrl = "https://www.bilibili.com/video/BV1H44y1L7c8"
        panda84.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda84.authorName = "胖哒哒不月半"
        panda84.cover =
            "https://i2.hdslb.com/bfs/archive/e0287387a7c0c67dc1f34a519640c6b0fd3da549.jpg"
        panda84.videoType = 0
        list.add(panda84)


        val panda85 = PetVideo()
        panda85.type = VideoType.PANDA.ordinal
        panda85.fileName = "panda_group_panda85"
        panda85.code = 560
        panda85.duration = 138
        panda85.period = PeriodType.GROUP.ordinal
        panda85.isStar = true
        panda85.title = "【和花成长日记】熟悉新场地的和花，一不留神脚底打滑摔下小木架"
        panda85.releaseTime = "2022-01-23 11:30:17"
        panda85.originalUrl = "https://www.bilibili.com/video/BV1Ef4y1F7kK"
        panda85.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda85.authorName = "胖哒哒不月半"
        panda85.cover =
            "https://i1.hdslb.com/bfs/archive/6b85db91c10f5799f5659014aed20e2ffa63a81f.jpg"
        panda85.videoType = 0
        list.add(panda85)


        val panda86 = PetVideo()
        panda86.type = VideoType.PANDA.ordinal
        panda86.fileName = "panda_group_panda86"
        panda86.code = 561
        panda86.duration = 72
        panda86.period = PeriodType.GROUP.ordinal
        panda86.isStar = true
        panda86.title = "爷爷用苹果引花花回家。【大熊猫和花】"
        panda86.releaseTime = "2022-01-23 18:10:57"
        panda86.originalUrl = "https://www.bilibili.com/video/BV1NT4y1y7AK"
        panda86.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda86.authorName = "隽一一"
        panda86.cover =
            "https://i0.hdslb.com/bfs/archive/2782e88d1ceb7d2b142ed5fbbbeee507b2ec5bb9.jpg"
        panda86.videoType = 0
        list.add(panda86)


        val panda87 = PetVideo()
        panda87.type = VideoType.PANDA.ordinal
        panda87.fileName = "panda_group_panda87"
        panda87.code = 562
        panda87.duration = 198
        panda87.period = PeriodType.GROUP.ordinal
        panda87.isStar = false
        panda87.title = "大熊猫和花、和叶、润玥、艾玖—月亮四嘟回家记"
        panda87.releaseTime = "2022-01-23 18:36:42"
        panda87.originalUrl = "https://www.bilibili.com/video/BV1Uq4y1C7zw"
        panda87.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda87.authorName = "和和和花花"
        panda87.cover =
            "https://i0.hdslb.com/bfs/archive/fb85c607f6f4e0b8e1ef30e433b9a158fcc7cb98.jpg"
        panda87.videoType = 0
        list.add(panda87)


        val panda88 = PetVideo()
        panda88.type = VideoType.PANDA.ordinal
        panda88.fileName = "panda_group_panda88"
        panda88.code = 563
        panda88.duration = 51
        panda88.period = PeriodType.GROUP.ordinal
        panda88.isStar = true
        panda88.title = "【大熊猫和花和叶艾玖】三姐弟对待下班的三种态度，你下班是属于哪种呢"
        panda88.releaseTime = "2022-01-22 23:00:10"
        panda88.originalUrl = "https://www.bilibili.com/video/BV1f44y1W7tN"
        panda88.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda88.authorName = "小香妞爱熊猫"
        panda88.cover =
            "https://i1.hdslb.com/bfs/archive/1d9730908b9903a653b6a510f9b8beec9f4a3fd6.jpg"
        panda88.videoType = 0
        list.add(panda88)


        val panda89 = PetVideo()
        panda89.type = VideoType.PANDA.ordinal
        panda89.fileName = "panda_group_panda89"
        panda89.code = 564
        panda89.duration = 64
        panda89.period = PeriodType.GROUP.ordinal
        panda89.isStar = false
        panda89.title = "大熊猫和花~竟然这样喝水水！"
        panda89.releaseTime = "2022-01-23 18:05:06"
        panda89.originalUrl = "https://www.bilibili.com/video/BV1FL4y1t7iV"
        panda89.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda89.authorName = "水果小分队的椰子"
        panda89.cover =
            "https://i1.hdslb.com/bfs/archive/3437f1d7fd040a2a00279a3a5ded384cd4430cc7.jpg"
        panda89.videoType = 0
        list.add(panda89)


        val panda90 = PetVideo()
        panda90.type = VideoType.PANDA.ordinal
        panda90.fileName = "panda_group_panda90"
        panda90.code = 565
        panda90.duration = 84
        panda90.period = PeriodType.GROUP.ordinal
        panda90.isStar = false
        panda90.title = "“大熊猫和花”今天心情很好哦！"
        panda90.releaseTime = "2022-01-18 18:05:03"
        panda90.originalUrl = "https://www.bilibili.com/video/BV1xZ4y1f77X"
        panda90.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda90.authorName = "水果小分队的椰子"
        panda90.cover =
            "https://i2.hdslb.com/bfs/archive/7fa1a135bdb3d809e125190da785ea5a31663e37.jpg"
        panda90.videoType = 0
        list.add(panda90)


        val panda91 = PetVideo()
        panda91.type = VideoType.PANDA.ordinal
        panda91.fileName = "panda_group_panda91"
        panda91.code = 566
        panda91.duration = 66
        panda91.period = PeriodType.GROUP.ordinal
        panda91.isStar = true
        panda91.title = "【大熊猫和花】这样的小熊毯子给我来一打！！"
        panda91.releaseTime = "2022-01-22 23:57:14"
        panda91.originalUrl = "https://www.bilibili.com/video/BV1KL411w7PT"
        panda91.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda91.authorName = "安娜丽丝k"
        panda91.cover =
            "https://i0.hdslb.com/bfs/archive/822393cd410639ee1f1d41fe4951e7b66268ecd7.jpg"
        panda91.videoType = 0
        list.add(panda91)


        val panda92 = PetVideo()
        panda92.type = VideoType.PANDA.ordinal
        panda92.fileName = "panda_group_panda92"
        panda92.code = 567
        panda92.duration = 56
        panda92.period = PeriodType.GROUP.ordinal
        panda92.isStar = true
        panda92.title = "【胖哒高能时刻】和花:尴尬却不失迷人的脚底一滑"
        panda92.releaseTime = "2022-01-22 22:37:13"
        panda92.originalUrl = "https://www.bilibili.com/video/BV1Qq4y1c7Lj"
        panda92.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda92.authorName = "胖哒哒不月半"
        panda92.cover =
            "https://i2.hdslb.com/bfs/archive/13affd5c3fc90047c57fe8140bb6e4b8e5159c13.jpg"
        panda92.videoType = 0
        list.add(panda92)


        val panda93 = PetVideo()
        panda93.type = VideoType.PANDA.ordinal
        panda93.fileName = "panda_group_panda93"
        panda93.code = 568
        panda93.duration = 45
        panda93.period = PeriodType.GROUP.ordinal
        panda93.isStar = false
        panda93.title =
            "小树君：我终于倒下去了，不用再天天受折磨了，怡云战神，算你狠"
        panda93.releaseTime = "2022-01-18 08:31:19"
        panda93.originalUrl = "https://www.bilibili.com/video/BV1rS4y1j7Tj"
        panda93.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda93.authorName = "黑白宝宝小捣蛋"
        panda93.cover =
            "https://i1.hdslb.com/bfs/archive/35b3f02c94a5aefe35f967c67f2c9a4907fc06d7.jpg"
        panda93.videoType = 0
        list.add(panda93)


        val panda94 = PetVideo()
        panda94.type = VideoType.PANDA.ordinal
        panda94.fileName = "panda_group_panda94"
        panda94.code = 569
        panda94.duration = 69
        panda94.period = PeriodType.GROUP.ordinal
        panda94.isStar = true
        panda94.title = "姐姐们有多宠和花？"
        panda94.releaseTime = "2022-01-04 18:05:10"
        panda94.originalUrl = "https://www.bilibili.com/video/BV1634y1q7fA"
        panda94.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda94.authorName = "水果小分队的椰子"
        panda94.cover =
            "https://i1.hdslb.com/bfs/archive/1eb85230635ddacdd32005663afdd67f0b3ba121.jpg"
        panda94.videoType = 0
        list.add(panda94)


        val panda95 = PetVideo()
        panda95.type = VideoType.PANDA.ordinal
        panda95.fileName = "panda_group_panda95"
        panda95.code = 570
        panda95.duration = 34
        panda95.period = PeriodType.GROUP.ordinal
        panda95.isStar = false
        panda95.title = "大熊猫和花和叶-趴趴熊和懵懵熊"
        panda95.releaseTime = "2022-01-21 15:34:30"
        panda95.originalUrl = "https://www.bilibili.com/video/BV1Jf4y1F75U"
        panda95.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda95.authorName = "和和和花花"
        panda95.cover =
            "https://i1.hdslb.com/bfs/archive/5a258de3450f1107537ea381c72c671b2c6adcb0.jpg"
        panda95.videoType = 0
        list.add(panda95)


        val panda96 = PetVideo()
        panda96.type = VideoType.PANDA.ordinal
        panda96.fileName = "panda_group_panda96"
        panda96.code = 571
        panda96.duration = 44
        panda96.period = PeriodType.GROUP.ordinal
        panda96.isStar = true
        panda96.title = "兜兜：哥哥是我最大的依靠【大熊猫包包兜兜】"
        panda96.releaseTime = "2020-11-15 15:31:03"
        panda96.originalUrl = "https://www.bilibili.com/video/BV1Pp4y1r7jw"
        panda96.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda96.authorName = "迩後咩"
        panda96.cover =
            "https://i2.hdslb.com/bfs/archive/78fdca6cfc901229f870af470d7ca697114d8ccd.jpg"
        panda96.videoType = 0
        list.add(panda96)


        val panda97 = PetVideo()
        panda97.type = VideoType.PANDA.ordinal
        panda97.fileName = "panda_group_panda97"
        panda97.code = 572
        panda97.duration = 71
        panda97.period = PeriodType.GROUP.ordinal
        panda97.isStar = true
        panda97.title = "奇一生胖气，整个腮帮子气鼓鼓，一看就是哄不好的那种！"
        panda97.releaseTime = "2021-10-08 18:32:33"
        panda97.originalUrl = "https://www.bilibili.com/video/BV1UL411379X"
        panda97.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda97.authorName = "青檬鱼看熊猫儿"
        panda97.cover =
            "https://i0.hdslb.com/bfs/archive/a11f1af40f2e703a945717b380b53b3020640468.jpg"
        panda97.videoType = 0
        list.add(panda97)


        val panda98 = PetVideo()
        panda98.type = VideoType.PANDA.ordinal
        panda98.fileName = "panda_group_panda98"
        panda98.code = 573
        panda98.duration = 66
        panda98.period = PeriodType.GROUP.ordinal
        panda98.isStar = true
        panda98.title = "大熊猫是独居动物。奇一和福来：但我们是相亲相爱一家熊！"
        panda98.releaseTime = "2021-10-13 20:28:22"
        panda98.originalUrl = "https://www.bilibili.com/video/BV1g3411C7WT"
        panda98.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda98.authorName = "青檬鱼看熊猫儿"
        panda98.cover =
            "https://i1.hdslb.com/bfs/archive/7ae9da43584332f144ca49b557f2e11c08ed5393.png"
        panda98.videoType = 0
        list.add(panda98)


        val panda99 = PetVideo()
        panda99.type = VideoType.PANDA.ordinal
        panda99.fileName = "panda_group_panda99"
        panda99.code = 574
        panda99.duration = 64
        panda99.period = PeriodType.GROUP.ordinal
        panda99.isStar = true
        panda99.title = "奇一哄睡来来，俩宝宝相依相偎，真好"
        panda99.releaseTime = "2021-10-23 19:22:35"
        panda99.originalUrl = "https://www.bilibili.com/video/BV1Ju411f7r6"
        panda99.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda99.authorName = "watercathy"
        panda99.cover =
            "https://i0.hdslb.com/bfs/archive/b4562cbf1baa30adc56ff70bc2744c6b80f2b9e9.jpg"
        panda99.videoType = 0
        list.add(panda99)


        val panda100 = PetVideo()
        panda100.type = VideoType.PANDA.ordinal
        panda100.fileName = "panda_group_panda100"
        panda100.code = 575
        panda100.duration = 15
        panda100.period = PeriodType.GROUP.ordinal
        panda100.isStar = true
        panda100.title = "【奇一福来】我兔兔来来又是腻腻歪歪～亲亲抱抱～甜甜贴贴的一天（真是要疯了我，柠檬树几亩地都不够种！）"
        panda100.releaseTime = "2021-10-26 13:56:07"
        panda100.originalUrl = "https://www.bilibili.com/video/BV1sq4y1R7oC"
        panda100.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda100.authorName = "Junney山顶囤猫粮"
        panda100.cover =
            "https://i1.hdslb.com/bfs/archive/64c346ca83233c2e661a3ac49bf945dd2178649e.jpg"
        panda100.videoType = 0
        list.add(panda100)


        val panda101 = PetVideo()
        panda101.type = VideoType.PANDA.ordinal
        panda101.fileName = "panda_group_panda101"
        panda101.code = 576
        panda101.duration = 42
        panda101.period = PeriodType.GROUP.ordinal
        panda101.isStar = true
        panda101.title = "大熊猫和花和叶-迪迪贴贴姐姐"
        panda101.releaseTime = "2022-01-20 02:47:33"
        panda101.originalUrl = "https://www.bilibili.com/video/BV1rm4y1U7ff"
        panda101.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda101.authorName = "和和和花花"
        panda101.cover =
            "https://i2.hdslb.com/bfs/archive/3088546bb7713f028460f95403c29bac135dd34f.jpg"
        panda101.videoType = 0
        list.add(panda101)


        val panda102 = PetVideo()
        panda102.type = VideoType.PANDA.ordinal
        panda102.fileName = "panda_group_panda102"
        panda102.code = 577
        panda102.duration = 150
        panda102.period = PeriodType.GROUP.ordinal
        panda102.isStar = false
        panda102.title = "主任和叶总的姐弟感情有多好。【大熊猫和花、和叶】"
        panda102.releaseTime = "2022-01-20 18:23:11"
        panda102.originalUrl = "https://www.bilibili.com/video/BV1cS4y1o7CL"
        panda102.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda102.authorName = "隽一一"
        panda102.cover =
            "https://i0.hdslb.com/bfs/archive/7becec630b3166b3b3374049332c1ab876d8d234.jpg"
        panda102.videoType = 0
        list.add(panda102)


        val panda103 = PetVideo()
        panda103.type = VideoType.PANDA.ordinal
        panda103.fileName = "panda_group_panda103"
        panda103.code = 578
        panda103.duration = 127
        panda103.period = PeriodType.GROUP.ordinal
        panda103.isStar = false
        panda103.title = "小树杈上长熊猫蛋了，幼儿园的奶团子又开战啦"
        panda103.releaseTime = "2021-12-31 12:29:40"
        panda103.originalUrl = "https://www.bilibili.com/video/BV1134y1z7Wa"
        panda103.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda103.authorName = "开饭了大熊猫V"
        panda103.cover =
            "https://i1.hdslb.com/bfs/archive/243bf3f1fc854f1506ebcbd18d87e383c580caf5.jpg"
        panda103.videoType = 0
        list.add(panda103)


        val panda104 = PetVideo()
        panda104.type = VideoType.PANDA.ordinal
        panda104.fileName = "panda_group_panda104"
        panda104.code = 579
        panda104.duration = 165
        panda104.period = PeriodType.GROUP.ordinal
        panda104.isStar = true
        panda104.title = "大熊猫--姐姐们有多“宠”和花？"
        panda104.releaseTime = "2021-12-28 11:00:03"
        panda104.originalUrl = "https://www.bilibili.com/video/BV1ii4y1R7f7"
        panda104.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda104.authorName = "大熊猫繁育研究基金会"
        panda104.cover =
            "https://i1.hdslb.com/bfs/archive/3b5294bb058075a535ee6d989bbe9a4cd4664c4c.jpg"
        panda104.videoType = 0
        list.add(panda104)


        val panda105 = PetVideo()
        panda105.type = VideoType.PANDA.ordinal
        panda105.fileName = "panda_group_panda105"
        panda105.code = 580
        panda105.duration = 32
        panda105.period = PeriodType.GROUP.ordinal
        panda105.isStar = false
        panda105.title = "大熊猫和花-这小熊玩偶怎么会动的"
        panda105.releaseTime = "2022-01-18 19:02:20"
        panda105.originalUrl = "https://www.bilibili.com/video/BV1h3411Y78E"
        panda105.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda105.authorName = "和和和花花"
        panda105.cover =
            "https://i0.hdslb.com/bfs/archive/b8e59e49c4ada9f5b5bf7c1f08ffd3c6edcd0008.jpg"
        panda105.videoType = 0
        list.add(panda105)


        val panda106 = PetVideo()
        panda106.type = VideoType.PANDA.ordinal
        panda106.fileName = "panda_group_panda106"
        panda106.code = 581
        panda106.duration = 104
        panda106.period = PeriodType.GROUP.ordinal
        panda106.isStar = false
        panda106.title = "小叶子战神初养成！菜总滑铁卢~和花睡大觉！【大熊猫和叶 润玥】"
        panda106.releaseTime = "2022-01-19 17:15:09"
        panda106.originalUrl = "https://www.bilibili.com/video/BV1B5411f7iK"
        panda106.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda106.authorName = "安娜丽丝k"
        panda106.cover =
            "https://i2.hdslb.com/bfs/archive/6d516afd765a1c5bb57634d164dddb30d993d3ab.jpg"
        panda106.videoType = 0
        list.add(panda106)


        val panda107 = PetVideo()
        panda107.type = VideoType.PANDA.ordinal
        panda107.fileName = "panda_group_panda107"
        panda107.code = 582
        panda107.duration = 24
        panda107.period = PeriodType.GROUP.ordinal
        panda107.isStar = true
        panda107.title = "我可爱的 会奔跑 会卖萌的煤气罐罐：和花🌸"
        panda107.releaseTime = "2022-01-17 13:49:07"
        panda107.originalUrl = "https://www.bilibili.com/video/BV1nY411h7W8"
        panda107.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda107.authorName = "Junney山顶囤猫粮"
        panda107.cover =
            "https://i0.hdslb.com/bfs/archive/4317b074b8c9d27b6edb18ca3847e6ef53b26bb6.jpg"
        panda107.videoType = 0
        list.add(panda107)


        val panda108 = PetVideo()
        panda108.type = VideoType.PANDA.ordinal
        panda108.fileName = "panda_group_panda108"
        panda108.code = 583
        panda108.duration = 246
        panda108.period = PeriodType.GROUP.ordinal
        panda108.isStar = false
        panda108.title = "【和花】【艾玖】这是相差一个月的体型差吗？？！和花，你要加油干饭啦！！"
        panda108.releaseTime = "2022-01-17 19:00:00"
        panda108.originalUrl = "https://www.bilibili.com/video/BV1m34y1B7Mj"
        panda108.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda108.authorName = "里予妞妞"
        panda108.cover =
            "https://i1.hdslb.com/bfs/archive/9b2129ab581a55d228bd1e121194d39aedc779a2.jpg"
        panda108.videoType = 0
        list.add(panda108)


        val panda109 = PetVideo()
        panda109.type = VideoType.PANDA.ordinal
        panda109.fileName = "panda_group_panda109"
        panda109.code = 584
        panda109.duration = 37
        panda109.period = PeriodType.GROUP.ordinal
        panda109.isStar = false
        panda109.title = "[润玥]二狗学花花堵在小卖部的洞里"
        panda109.releaseTime = "2022-01-18 22:29:59"
        panda109.originalUrl = "https://www.bilibili.com/video/BV1Hq4y1C7GU"
        panda109.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda109.authorName = "多元化之无尽的梦魇"
        panda109.cover =
            "https://i2.hdslb.com/bfs/archive/4385bb6d5b9623212928166cde95b85193786805.jpg"
        panda109.videoType = 0
        list.add(panda109)


        val panda110 = PetVideo()
        panda110.type = VideoType.PANDA.ordinal
        panda110.fileName = "panda_group_panda110"
        panda110.code = 585
        panda110.duration = 301
        panda110.period = PeriodType.GROUP.ordinal
        panda110.isStar = true
        panda110.title = "【大熊猫和花、润玥、和叶】爷爷叫崽崽们加餐，花花和菜菜在前台开始吃播01.17"
        panda110.releaseTime = "2022-01-18 21:08:52"
        panda110.originalUrl = "https://www.bilibili.com/video/BV1W34y1i7v8"
        panda110.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda110.authorName = "朙雨"
        panda110.cover =
            "https://i1.hdslb.com/bfs/archive/669548ddf2144f4a0dc2d6bda70eb944b8dcca79.jpg"
        panda110.videoType = 0
        list.add(panda110)


        val panda111 = PetVideo()
        panda111.type = VideoType.PANDA.ordinal
        panda111.fileName = "panda_group_panda111"
        panda111.code = 586
        panda111.duration = 57
        panda111.period = PeriodType.GROUP.ordinal
        panda111.isStar = true
        panda111.title = "【和花】胖fa睡醒有点懵，愣了一会，找了姐姐当枕头继续睡"
        panda111.releaseTime = "2022-01-16 18:38:19"
        panda111.originalUrl = "https://www.bilibili.com/video/BV11r4y1Y7Wc"
        panda111.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda111.authorName = "讷言小筑"
        panda111.cover =
            "https://i0.hdslb.com/bfs/archive/798a430bae9bf2703e3c450414e23bd5ab6681b1.jpg"
        panda111.videoType = 0
        list.add(panda111)


        val panda112 = PetVideo()
        panda112.type = VideoType.PANDA.ordinal
        panda112.fileName = "panda_group_panda112"
        panda112.code = 587
        panda112.duration = 56
        panda112.period = PeriodType.GROUP.ordinal
        panda112.isStar = false
        panda112.title = "【奇一】熊猫闺蜜关系多好啊！比心❤️"
        panda112.releaseTime = "2021-11-19 16:11:30"
        panda112.originalUrl = "https://www.bilibili.com/video/BV1ng411N71i"
        panda112.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda112.authorName = "ccitoo"
        panda112.cover =
            "https://i1.hdslb.com/bfs/archive/cf41006276249de91c67a5ee99cf4b2341bd63e3.jpg"
        panda112.videoType = 0
        list.add(panda112)


        val panda113 = PetVideo()
        panda113.type = VideoType.PANDA.ordinal
        panda113.fileName = "panda_group_panda113"
        panda113.code = 588
        panda113.duration = 39
        panda113.period = PeriodType.GROUP.ordinal
        panda113.isStar = true
        panda113.title = "【大熊猫奇一】来来躺在兔兔肚肚上睡觉觉，两娃娃可太温馨了"
        panda113.releaseTime = "2021-10-07 17:32:08"
        panda113.originalUrl = "https://www.bilibili.com/video/BV1h44y1t7Ns"
        panda113.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda113.authorName = "丶祀很宔"
        panda113.cover =
            "https://i0.hdslb.com/bfs/archive/2f57ed7f1a4a5cb274e880868e64c95326a3989d.jpg"
        panda113.videoType = 0
        list.add(panda113)


        val panda114 = PetVideo()
        panda114.type = VideoType.PANDA.ordinal
        panda114.fileName = "panda_group_panda114"
        panda114.code = 589
        panda114.duration = 15
        panda114.period = PeriodType.GROUP.ordinal
        panda114.isStar = true
        panda114.title = "大熊猫奇一：抱紧我的小来来，福顺：我也要抱抱"
        panda114.releaseTime = "2021-05-30 11:24:13"
        panda114.originalUrl = "https://www.bilibili.com/video/BV1H54y1V7Jy"
        panda114.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda114.authorName = "丶大熊猫奇一"
        panda114.cover =
            "https://i0.hdslb.com/bfs/archive/49b0a56f1d1d63dd6c983fa7ffe7bf0a4da6839a.jpg"
        panda114.videoType = 0
        list.add(panda114)


        val panda115 = PetVideo()
        panda115.type = VideoType.PANDA.ordinal
        panda115.fileName = "panda_group_panda115"
        panda115.code = 590
        panda115.duration = 33
        panda115.period = PeriodType.GROUP.ordinal
        panda115.isStar = true
        panda115.title = "【大熊猫奇一】翻滚吧，兔兔来来"
        panda115.releaseTime = "2022-01-16 11:13:34"
        panda115.originalUrl = "https://www.bilibili.com/video/BV15Z4y1f7Yb"
        panda115.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda115.authorName = "丶祀很宔"
        panda115.cover =
            "https://i0.hdslb.com/bfs/archive/c3904a534c6fe38d68daabcd74859ae272ed869d.jpg"
        panda115.videoType = 0
        list.add(panda115)


        val panda116 = PetVideo()
        panda116.type = VideoType.PANDA.ordinal
        panda116.fileName = "panda_group_panda116"
        panda116.code = 591
        panda116.duration = 72
        panda116.period = PeriodType.GROUP.ordinal
        panda116.isStar = true
        panda116.title = "你在干嘛呀？大熊猫和花：我在装可爱！"
        panda116.releaseTime = "2022-01-17 18:05:18"
        panda116.originalUrl = "https://www.bilibili.com/video/BV1RT4y117Ah"
        panda116.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda116.authorName = "水果小分队的椰子"
        panda116.cover =
            "https://i1.hdslb.com/bfs/archive/4b7d0c4977749cbeaff6ef73c3ad12eff7908ede.jpg"
        panda116.videoType = 0
        list.add(panda116)


        val panda117 = PetVideo()
        panda117.type = VideoType.PANDA.ordinal
        panda117.fileName = "panda_group_panda117"
        panda117.code = 592
        panda117.duration = 124
        panda117.period = PeriodType.GROUP.ordinal
        panda117.isStar = true
        panda117.title = "【大熊猫和花】雪中悍刀行之“林中焊花行” 和花捉拿和叶"
        panda117.releaseTime = "2022-01-17 22:01:37"
        panda117.originalUrl = "https://www.bilibili.com/video/BV1gu411m7zB"
        panda117.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda117.authorName = "摄影师动物米"
        panda117.cover =
            "https://i2.hdslb.com/bfs/archive/1e6febfff222f7814a1bce2dbeaf78cf8b9be513.jpg"
        panda117.videoType = 0
        list.add(panda117)


        val panda118 = PetVideo()
        panda118.type = VideoType.PANDA.ordinal
        panda118.fileName = "panda_group_panda118"
        panda118.code = 593
        panda118.duration = 75
        panda118.period = PeriodType.GROUP.ordinal
        panda118.isStar = true
        panda118.title = "【大熊猫和花】菜菜姐对神烦花有多好？换只熊可能早被胖揍了"
        panda118.releaseTime = "2022-01-17 23:00:16"
        panda118.originalUrl = "https://www.bilibili.com/video/BV1AS4y1j7iJ"
        panda118.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda118.authorName = "小香妞爱熊猫"
        panda118.cover =
            "https://i2.hdslb.com/bfs/archive/5552804f393bd7c273d29b81fe574a8b11086cc3.jpg"
        panda118.videoType = 0
        list.add(panda118)


        val panda119 = PetVideo()
        panda119.type = VideoType.PANDA.ordinal
        panda119.fileName = "panda_group_panda119"
        panda119.code = 594
        panda119.duration = 65
        panda119.period = PeriodType.GROUP.ordinal
        panda119.isStar = false
        panda119.title = "[和花  和叶  润玥  艾玖]四只小可爱一起吃竹子"
        panda119.releaseTime = "2022-01-16 22:19:12"
        panda119.originalUrl = "https://www.bilibili.com/video/BV1wm4y1Q7Lr"
        panda119.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda119.authorName = "多元化之无尽的梦魇"
        panda119.cover =
            "https://i1.hdslb.com/bfs/archive/2f7b8c12861eda356f64172267cd7e4f0ba1624e.png"
        panda119.videoType = 0
        list.add(panda119)


        val panda120 = PetVideo()
        panda120.type = VideoType.PANDA.ordinal
        panda120.fileName = "panda_group_panda120"
        panda120.code = 595
        panda120.duration = 50
        panda120.period = PeriodType.GROUP.ordinal
        panda120.isStar = false
        panda120.title = "【大熊猫和叶】“大衣”破了又如何，我依旧是这条街最靓的仔"
        panda120.releaseTime = "2022-01-16 11:00:19"
        panda120.originalUrl = "https://www.bilibili.com/video/BV1im4y1U7NQ"
        panda120.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda120.authorName = "胖哒哒不月半"
        panda120.cover =
            "https://i2.hdslb.com/bfs/archive/b82806f731ed59ce0c22741a4b47ced4e9642d6c.jpg"
        panda120.videoType = 0
        list.add(panda120)


        val panda121 = PetVideo()
        panda121.type = VideoType.PANDA.ordinal
        panda121.fileName = "panda_group_panda121"
        panda121.code = 596
        panda121.duration = 108
        panda121.period = PeriodType.GROUP.ordinal
        panda121.isStar = false
        panda121.title = "爷爷咋还不喊花花呢，人家今天乖得很哦！【大熊猫和花】"
        panda121.releaseTime = "2022-01-16 18:09:22"
        panda121.originalUrl = "https://www.bilibili.com/video/BV1vR4y1M7zA"
        panda121.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda121.authorName = "安娜丽丝k"
        panda121.cover =
            "https://i1.hdslb.com/bfs/archive/4cc83332d14d5d1842e4ca35f9ae25f54978e471.jpg"
        panda121.videoType = 0
        list.add(panda121)


        val panda122 = PetVideo()
        panda122.type = VideoType.PANDA.ordinal
        panda122.fileName = "panda_group_panda122"
        panda122.code = 597
        panda122.duration = 68
        panda122.period = PeriodType.GROUP.ordinal
        panda122.isStar = true
        panda122.title = "八只团子的笋笋时间，总觉得别人手里笋最香"
        panda122.releaseTime = "2020-12-07 16:33:20"
        panda122.originalUrl = "https://www.bilibili.com/video/BV18v411b7U5"
        panda122.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda122.authorName = "迩後咩"
        panda122.cover =
            "https://i2.hdslb.com/bfs/archive/0c8d19569edb5cbdd6c8268a1a82b513b35448eb.jpg"
        panda122.videoType = 0
        list.add(panda122)


        val panda123 = PetVideo()
        panda123.type = VideoType.PANDA.ordinal
        panda123.fileName = "panda_group_panda123"
        panda123.code = 598
        panda123.duration = 155
        panda123.period = PeriodType.GROUP.ordinal
        panda123.isStar = true
        panda123.title = "八只团子饭后的悠闲时光"
        panda123.releaseTime = "2021-01-19 13:02:47"
        panda123.originalUrl = "https://www.bilibili.com/video/BV1qp4y1x7Dn"
        panda123.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda123.authorName = "迩後咩"
        panda123.cover =
            "https://i1.hdslb.com/bfs/archive/0793b1fa397b89c0f00497439cb6e621068c074b.jpg"
        panda123.videoType = 0
        list.add(panda123)


        val panda124 = PetVideo()
        panda124.type = VideoType.PANDA.ordinal
        panda124.fileName = "panda_group_panda124"
        panda124.code = 599
        panda124.duration = 196
        panda124.period = PeriodType.GROUP.ordinal
        panda124.isStar = false
        panda124.title = "大熊猫是怎么下班的，和花解锁新姿势"
        panda124.releaseTime = "2021-12-27 19:48:29"
        panda124.originalUrl = "https://www.bilibili.com/video/BV1er4y1S7Lz"
        panda124.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda124.authorName = "开饭了大熊猫V"
        panda124.cover =
            "https://i2.hdslb.com/bfs/archive/198633b9a8e0a3cf6f22dd92d9e24db2bb55d7d9.jpg"
        panda124.videoType = 0
        list.add(panda124)


        val panda125 = PetVideo()
        panda125.type = VideoType.PANDA.ordinal
        panda125.fileName = "panda_group_panda125"
        panda125.code = 600
        panda125.duration = 44
        panda125.period = PeriodType.GROUP.ordinal
        panda125.isStar = true
        panda125.title = "【和花润玥和叶】趁着弟弟和姐姐睡着，胖fa开始了一顿输出，结果……"
        panda125.releaseTime = "2022-01-12 18:16:29"
        panda125.originalUrl = "https://www.bilibili.com/video/BV1uR4y1g7Fg"
        panda125.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda125.authorName = "讷言小筑"
        panda125.cover =
            "https://i1.hdslb.com/bfs/archive/b504e39488ca7174ca196ce23f1b3b6d00bd4e77.jpg"
        panda125.videoType = 0
        list.add(panda125)


        val panda126 = PetVideo()
        panda126.type = VideoType.PANDA.ordinal
        panda126.fileName = "panda_group_panda126"
        panda126.code = 601
        panda126.duration = 120
        panda126.period = PeriodType.GROUP.ordinal
        panda126.isStar = true
        panda126.title = "【大熊猫和花】头有点重，撑着歇一下"
        panda126.releaseTime = "2022-01-14 22:52:25"
        panda126.originalUrl = "https://www.bilibili.com/video/BV1vq4y1k7TG"
        panda126.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda126.authorName = "朙雨"
        panda126.cover =
            "https://i0.hdslb.com/bfs/archive/7cb63d9d645633b65e14666f0403e364d813eb89.jpg"
        panda126.videoType = 0
        list.add(panda126)


        val panda127 = PetVideo()
        panda127.type = VideoType.PANDA.ordinal
        panda127.fileName = "panda_group_panda127"
        panda127.code = 602
        panda127.duration = 142
        panda127.period = PeriodType.GROUP.ordinal
        panda127.isStar = false
        panda127.title = "和叶：一觉醒来，发现姐姐在认真干饭，一整个惊艳住了！"
        panda127.releaseTime = "2022-01-14 11:21:12"
        panda127.originalUrl = "https://www.bilibili.com/video/BV14m4y1U7Sq"
        panda127.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda127.authorName = "里予妞妞"
        panda127.cover =
            "https://i0.hdslb.com/bfs/archive/9c1c72122b988cd0f1fb074eaa0b9e875a51c063.jpg"
        panda127.videoType = 0
        list.add(panda127)


        val panda128 = PetVideo()
        panda128.type = VideoType.PANDA.ordinal
        panda128.fileName = "panda_group_panda128"
        panda128.code = 603
        panda128.duration = 244
        panda128.period = PeriodType.GROUP.ordinal
        panda128.isStar = true
        panda128.title = "【和花和叶】花花追着叶子打，有本事别上树啊！"
        panda128.releaseTime = "2022-01-14 13:35:17"
        panda128.originalUrl = "https://www.bilibili.com/video/BV1RL411c7Hi"
        panda128.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda128.authorName = "pandapia熊猫乌托邦"
        panda128.cover =
            "https://i0.hdslb.com/bfs/archive/bb4c204aed9000df981a8d0cda4f3af886300002.jpg"
        panda128.videoType = 0
        list.add(panda128)


        val panda129 = PetVideo()
        panda129.type = VideoType.PANDA.ordinal
        panda129.fileName = "panda_group_panda129"
        panda129.code = 604
        panda129.duration = 62
        panda129.period = PeriodType.GROUP.ordinal
        panda129.isStar = true
        panda129.title = "可爱的乔兜兜"
        panda129.releaseTime = "2021-01-01 19:23:01"
        panda129.originalUrl = "https://www.bilibili.com/video/BV1ez4y1z7U1"
        panda129.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda129.authorName = "奇异果家的顺来会fly"
        panda129.cover =
            "https://i0.hdslb.com/bfs/archive/067d8cc7bab16454fe6bf662611380c4da8ba32d.jpg"
        panda129.videoType = 0
        list.add(panda129)


        val panda130 = PetVideo()
        panda130.type = VideoType.PANDA.ordinal
        panda130.fileName = "panda_group_panda130"
        panda130.code = 605
        panda130.duration = 27
        panda130.period = PeriodType.GROUP.ordinal
        panda130.isStar = true
        panda130.title = "心上熊兜兜子2"
        panda130.releaseTime = "2021-04-18 10:41:02"
        panda130.originalUrl = "https://www.bilibili.com/video/BV1b64y1i7No"
        panda130.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda130.authorName = "熊猫能量社区"
        panda130.cover =
            "https://i0.hdslb.com/bfs/archive/57e960a8a970e07ec8a72c3c4ba128784617a7d1.jpg"
        panda130.videoType = 0
        list.add(panda130)


        val panda131 = PetVideo()
        panda131.type = VideoType.PANDA.ordinal
        panda131.fileName = "panda_group_panda131"
        panda131.code = 606
        panda131.duration = 13
        panda131.period = PeriodType.GROUP.ordinal
        panda131.isStar = true
        panda131.title = "大熊猫包包：你们看Tony兜给我扎的头发漂不漂亮？"
        panda131.releaseTime = "2021-06-25 22:57:17"
        panda131.originalUrl = "https://www.bilibili.com/video/BV1Dv411n7Cn"
        panda131.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda131.authorName = "熊猫滚滚社区"
        panda131.cover =
            "https://i2.hdslb.com/bfs/archive/f80b81ae69d845714a97f9cb7b691e30f25838fc.jpg"
        panda131.videoType = 0
        list.add(panda131)


        val panda132 = PetVideo()
        panda132.type = VideoType.PANDA.ordinal
        panda132.fileName = "panda_group_panda132"
        panda132.code = 607
        panda132.duration = 16
        panda132.period = PeriodType.GROUP.ordinal
        panda132.isStar = false
        panda132.title = "兜兜子四处偷笋，太太太搞笑了!"
        panda132.releaseTime = "2021-06-11 15:35:14"
        panda132.originalUrl = "https://www.bilibili.com/video/BV1i54y1G7PM"
        panda132.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda132.authorName = "熊猫滚滚社区"
        panda132.cover =
            "https://i2.hdslb.com/bfs/archive/78da9ba8d453bf1e5728ac7f4ba467d53345f748.jpg"
        panda132.videoType = 0
        list.add(panda132)


        val panda133 = PetVideo()
        panda133.type = VideoType.PANDA.ordinal
        panda133.fileName = "panda_group_panda133"
        panda133.code = 608
        panda133.duration = 31
        panda133.period = PeriodType.GROUP.ordinal
        panda133.isStar = true
        panda133.title = "大熊猫包包：今天又被弟弟做了新发型"
        panda133.releaseTime = "2021-05-07 23:54:15"
        panda133.originalUrl = "https://www.bilibili.com/video/BV1Uq4y1f7g4"
        panda133.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda133.authorName = "熊猫能量社区"
        panda133.cover =
            "https://i1.hdslb.com/bfs/archive/fba8e7e84ee8b05ca2dbfa48a17ef4233397f263.jpg"
        panda133.videoType = 0
        list.add(panda133)


        val panda134 = PetVideo()
        panda134.type = VideoType.PANDA.ordinal
        panda134.fileName = "panda_group_panda134"
        panda134.code = 609
        panda134.duration = 183
        panda134.period = PeriodType.GROUP.ordinal
        panda134.isStar = true
        panda134.title = "【大熊猫和花】饲养员:这次把小苹果藏好，不然又……"
        panda134.releaseTime = "2022-01-14 13:00:03"
        panda134.originalUrl = "https://www.bilibili.com/video/BV13q4y117Cj"
        panda134.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda134.authorName = "胖哒哒不月半"
        panda134.cover =
            "https://i2.hdslb.com/bfs/archive/dfade3f2807db7e1a4e16d3fbf245b25ef2ae2f4.jpg"
        panda134.videoType = 0
        list.add(panda134)

        //已失效视频
//        val panda135 = PetVideo()
//        panda135.code = 610
//        panda135.title = "已失效视频"
//        list.add(panda135)


        val panda136 = PetVideo()
        panda136.type = VideoType.PANDA.ordinal
        panda136.fileName = "panda_group_panda136"
        panda136.code = 611
        panda136.duration = 31
        panda136.period = PeriodType.GROUP.ordinal
        panda136.isStar = true
        panda136.title = "大熊猫奇一：又是努力卖萌的一天"
        panda136.releaseTime = "2021-12-16 11:47:58"
        panda136.originalUrl = "https://www.bilibili.com/video/BV1qq4y1q7aB"
        panda136.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda136.authorName = "丶大熊猫奇一"
        panda136.cover =
            "https://i1.hdslb.com/bfs/archive/deb923ac3c28d29e78e3b15c7f15ad82c22817d2.jpg"
        panda136.videoType = 0
        list.add(panda136)


        val panda137 = PetVideo()
        panda137.type = VideoType.PANDA.ordinal
        panda137.fileName = "panda_group_panda137"
        panda137.code = 612
        panda137.duration = 20
        panda137.period = PeriodType.GROUP.ordinal
        panda137.isStar = true
        panda137.title = "大熊猫奇一：来跟我们抱团取暖啊"
        panda137.releaseTime = "2021-04-17 19:01:17"
        panda137.originalUrl = "https://www.bilibili.com/video/BV1DK411F712"
        panda137.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda137.authorName = "丶大熊猫奇一"
        panda137.cover =
            "https://i1.hdslb.com/bfs/archive/d791f0eb581f5ba885dd5604cd28767ac1ef4de7.jpg"
        panda137.videoType = 0
        list.add(panda137)


        val panda138 = PetVideo()
        panda138.type = VideoType.PANDA.ordinal
        panda138.fileName = "panda_group_panda138"
        panda138.code = 613
        panda138.duration = 57
        panda138.period = PeriodType.GROUP.ordinal
        panda138.isStar = false
        panda138.title = "现都说和花花这一届最不好带，我看谭爷爷还没喊，一起都跑到门口开始等放学了，谭爷爷的果赖模式就稍微启动了一下"
        panda138.releaseTime = "2022-01-12 12:25:53"
        panda138.originalUrl = "https://www.bilibili.com/video/BV1eS4y1Z7jG"
        panda138.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda138.authorName = "妙蛙種孓"
        panda138.cover =
            "https://i2.hdslb.com/bfs/archive/7b06b0929c844cfb172eaa13cd7fe6ca377ee0fd.jpg"
        panda138.videoType = 0
        list.add(panda138)


        val panda139 = PetVideo()
        panda139.type = VideoType.PANDA.ordinal
        panda139.fileName = "panda_group_panda139"
        panda139.code = 614
        panda139.duration = 99
        panda139.period = PeriodType.GROUP.ordinal
        panda139.isStar = false
        panda139.title = "包兜干架！！【大熊猫乔包包&乔兜兜】"
        panda139.releaseTime = "2022-01-12 22:01:09"
        panda139.originalUrl = "https://www.bilibili.com/video/BV1iY41187Gu"
        panda139.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda139.authorName = "安娜丽丝k"
        panda139.cover =
            "https://i1.hdslb.com/bfs/archive/ea3d8b9a81caa91d5c37f21d79b5363b37a8f7e4.jpg"
        panda139.videoType = 0
        list.add(panda139)


        val panda140 = PetVideo()
        panda140.type = VideoType.PANDA.ordinal
        panda140.fileName = "panda_group_panda140"
        panda140.code = 615
        panda140.duration = 95
        panda140.period = PeriodType.GROUP.ordinal
        panda140.isStar = false
        panda140.title = "[和花  润玥]花花和二狗一起蹲守小卖部"
        panda140.releaseTime = "2022-01-10 23:07:54"
        panda140.originalUrl = "https://www.bilibili.com/video/BV1hS4y1Z7Wo"
        panda140.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda140.authorName = "多元化之无尽的梦魇"
        panda140.cover =
            "https://i2.hdslb.com/bfs/archive/945585ea9f3ddca49d4d70502f4fc2e8e106f55e.jpg"
        panda140.videoType = 0
        list.add(panda140)


        val panda141 = PetVideo()
        panda141.type = VideoType.PANDA.ordinal
        panda141.fileName = "panda_group_panda141"
        panda141.code = 616
        panda141.duration = 172
        panda141.period = PeriodType.GROUP.ordinal
        panda141.isStar = false
        panda141.title = "熊猫是为什么稀有？“拯救”大熊猫福双"
        panda141.releaseTime = "2022-01-08 12:35:13"
        panda141.originalUrl = "https://www.bilibili.com/video/BV1eu41127ed"
        panda141.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda141.authorName = "开饭了大熊猫V"
        panda141.cover =
            "https://i1.hdslb.com/bfs/archive/c594bb7f2343d6d4b70ea99e56599c610030224c.jpg"
        panda141.videoType = 0
        list.add(panda141)


        val panda142 = PetVideo()
        panda142.type = VideoType.PANDA.ordinal
        panda142.fileName = "panda_group_panda142"
        panda142.code = 617
        panda142.duration = 62
        panda142.period = PeriodType.GROUP.ordinal
        panda142.isStar = false
        panda142.title = "[和花]这里就是为花花量身打造的"
        panda142.releaseTime = "2022-01-11 22:00:36"
        panda142.originalUrl = "https://www.bilibili.com/video/BV1tF411v7Kz"
        panda142.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda142.authorName = "多元化之无尽的梦魇"
        panda142.cover =
            "https://i2.hdslb.com/bfs/archive/c151b387206deceb31db93d5457d32c6a884d4f4.jpg"
        panda142.videoType = 0
        list.add(panda142)


        val panda143 = PetVideo()
        panda143.type = VideoType.PANDA.ordinal
        panda143.fileName = "panda_group_panda143"
        panda143.code = 618
        panda143.duration = 142
        panda143.period = PeriodType.GROUP.ordinal
        panda143.isStar = true
        panda143.title = "【大熊猫】超震撼--和花爬上超高树！全过程 。励志"
        panda143.releaseTime = "2022-01-11 22:11:20"
        panda143.originalUrl = "https://www.bilibili.com/video/BV1C3411e7yo"
        panda143.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda143.authorName = "摄影师动物米"
        panda143.cover =
            "https://i0.hdslb.com/bfs/archive/17cdee66f71911690d9fe071a6e3c1c5fa83dbf1.jpg"
        panda143.videoType = 0
        list.add(panda143)


        val panda144 = PetVideo()
        panda144.type = VideoType.PANDA.ordinal
        panda144.fileName = "panda_group_panda144"
        panda144.code = 619
        panda144.duration = 154
        panda144.period = PeriodType.GROUP.ordinal
        panda144.isStar = false
        panda144.title = "【大熊猫和花】把四肢吃掉，变成一个汤圆"
        panda144.releaseTime = "2021-12-20 09:45:13"
        panda144.originalUrl = "https://www.bilibili.com/video/BV1g3411x7hB"
        panda144.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda144.authorName = "熊猫幼崽社区"
        panda144.cover =
            "https://i2.hdslb.com/bfs/archive/2601a357ee919d7c2cfd97431a4ba7be88713c45.jpg"
        panda144.videoType = 0
        list.add(panda144)

        val panda145 = PetVideo()
        panda145.type = VideoType.PANDA.ordinal
        panda145.fileName = "panda_group_panda145"
        panda145.code = 620
        panda145.duration = 175
        panda145.period = PeriodType.GROUP.ordinal
        panda145.isStar = true
        panda145.title = "【绩笑】你的头那么重，别靠我身上啊啊啊啊啊啊！"
        panda145.releaseTime = "2021-06-18 13:30:16"
        panda145.originalUrl = "https://www.bilibili.com/video/BV14o4y1k7Zt"
        panda145.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda145.authorName = "pandapia熊猫乌托邦"
        panda145.cover =
            "https://i1.hdslb.com/bfs/archive/685f84998053780323cdcf42c88a80aa62a808b6.jpg"
        panda145.videoType = 0
        list.add(panda145)

        val panda146 = PetVideo()
        panda146.type = VideoType.PANDA.ordinal
        panda146.fileName = "panda_group_panda146"
        panda146.code = 621
        panda146.duration = 147
        panda146.period = PeriodType.GROUP.ordinal
        panda146.isStar = true
        panda146.title = "第一次见证和花爬高高！热泪盈眶了！【大熊猫和花】"
        panda146.releaseTime = "2022-01-03 01:06:23"
        panda146.originalUrl = "https://www.bilibili.com/video/BV19D4y1F79M"
        panda146.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda146.authorName = "安娜丽丝k"
        panda146.cover =
            "https://i1.hdslb.com/bfs/archive/71600bb7c1abbbaeb7be757b22a8883f91c0cb18.png"
        panda146.videoType = 0
        list.add(panda146)

        val panda147 = PetVideo()
        panda147.type = VideoType.PANDA.ordinal
        panda147.fileName = "panda_group_panda147"
        panda147.code = 622
        panda147.duration = 166
        panda147.period = PeriodType.GROUP.ordinal
        panda147.isStar = false
        panda147.title = "和花生胖气，艾玖全程懵！最后谁才是底层熊??【大熊猫和花】"
        panda147.releaseTime = "2022-01-03 12:04:58"
        panda147.originalUrl = "https://www.bilibili.com/video/BV1aL4y1t7eN"
        panda147.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda147.authorName = "安娜丽丝k"
        panda147.cover =
            "https://i2.hdslb.com/bfs/archive/6f145a2f1723cc5b8ba15d5a04eb3fa402c2ee01.jpg"
        panda147.videoType = 0
        list.add(panda147)

        val panda148 = PetVideo()
        panda148.type = VideoType.PANDA.ordinal
        panda148.fileName = "panda_group_panda148"
        panda148.code = 623
        panda148.duration = 69
        panda148.period = PeriodType.GROUP.ordinal
        panda148.isStar = true
        panda148.title = "12.31花叶搬家前的菜菜，等花来！【大熊猫润玥】"
        panda148.releaseTime = "2022-01-04 17:53:58"
        panda148.originalUrl = "https://www.bilibili.com/video/BV1dq4y1C7F2"
        panda148.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda148.authorName = "安娜丽丝k"
        panda148.cover =
            "https://i0.hdslb.com/bfs/archive/2d31620a3ee48f48fdda607fa55bfe81c1fbcf6b.jpg"
        panda148.videoType = 0
        list.add(panda148)

        val panda149 = PetVideo()
        panda149.type = VideoType.PANDA.ordinal
        panda149.fileName = "panda_group_panda149"
        panda149.code = 624
        panda149.duration = 72
        panda149.period = PeriodType.GROUP.ordinal
        panda149.isStar = true
        panda149.title = "和花亲自演示什么叫滚滚，萌萌哒滚滚！【大熊猫和花】"
        panda149.releaseTime = "2022-01-08 14:39:05"
        panda149.originalUrl = "https://www.bilibili.com/video/BV1b44y1571j"
        panda149.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda149.authorName = "安娜丽丝k"
        panda149.cover =
            "https://i1.hdslb.com/bfs/archive/6efab5fabe55366062a96f1d913e3698492c249c.jpg"
        panda149.videoType = 0
        list.add(panda149)

        val panda150 = PetVideo()
        panda150.type = VideoType.PANDA.ordinal
        panda150.fileName = "panda_group_panda150"
        panda150.code = 625
        panda150.duration = 67
        panda150.period = PeriodType.GROUP.ordinal
        panda150.isStar = true
        panda150.title = "和花倒栽葱，暖心菜菜姐速来救驾！【大熊猫和花 润玥】"
        panda150.releaseTime = "2022-01-09 23:00:22"
        panda150.originalUrl = "https://www.bilibili.com/video/BV1F3411v7Gv"
        panda150.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda150.authorName = "安娜丽丝k"
        panda150.cover =
            "https://i1.hdslb.com/bfs/archive/e3d6041ff52d65e87fc857e15f8c7e3fd23ca0e7.jpg"
        panda150.videoType = 0
        list.add(panda150)

        val panda151 = PetVideo()
        panda151.type = VideoType.PANDA.ordinal
        panda151.fileName = "panda_group_panda151"
        panda151.code = 626
        panda151.duration = 226
        panda151.period = PeriodType.GROUP.ordinal
        panda151.isStar = true
        panda151.title = "和花的回家大戏：花花，我怀疑你在遛爷爷和骗抱抱"
        panda151.releaseTime = "2022-01-05 23:00:13"
        panda151.originalUrl = "https://www.bilibili.com/video/BV1K34y167B4"
        panda151.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda151.authorName = "小香妞爱熊猫"
        panda151.cover =
            "https://i2.hdslb.com/bfs/archive/bbfed87d59c81bcde3add5f2dc0658704c4be65a.jpg"
        panda151.videoType = 0
        list.add(panda151)

        val panda152 = PetVideo()
        panda152.type = VideoType.PANDA.ordinal
        panda152.fileName = "panda_group_panda152"
        panda152.code = 627
        panda152.duration = 62
        panda152.period = PeriodType.GROUP.ordinal
        panda152.isStar = true
        panda152.title = "【大熊猫和花】小时候卡头，长大了卡背，花花你真的决定走谐星路线吗"
        panda152.releaseTime = "2022-01-06 23:00:09"
        panda152.originalUrl = "https://www.bilibili.com/video/BV15u411U7Ux"
        panda152.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda152.authorName = "小香妞爱熊猫"
        panda152.cover =
            "https://i2.hdslb.com/bfs/archive/12d5e19b1efe0e3e4f61aadea427b52cbdd8cdfe.jpg"
        panda152.videoType = 0
        list.add(panda152)

        val panda153 = PetVideo()
        panda153.type = VideoType.PANDA.ordinal
        panda153.fileName = "panda_group_panda153"
        panda153.code = 628
        panda153.duration = 60
        panda153.period = PeriodType.GROUP.ordinal
        panda153.isStar = true
        panda153.title = "【大熊猫和花】伸懒腰的花花，也太可爱了吧"
        panda153.releaseTime = "2022-01-10 23:00:09"
        panda153.originalUrl = "https://www.bilibili.com/video/BV1SL411V7pM"
        panda153.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda153.authorName = "小香妞爱熊猫"
        panda153.cover =
            "https://i0.hdslb.com/bfs/archive/55edc47d9d38673108e54cf39bf1827763a1493f.jpg"
        panda153.videoType = 0
        list.add(panda153)

        val panda154 = PetVideo()
        panda154.type = VideoType.PANDA.ordinal
        panda154.fileName = "panda_group_panda154"
        panda154.code = 629
        panda154.duration = 147
        panda154.period = PeriodType.GROUP.ordinal
        panda154.isStar = false
        panda154.title = "火花（花花）下班实录，艾灸小吃醋啦"
        panda154.releaseTime = "2022-01-09 12:35:12"
        panda154.originalUrl = "https://www.bilibili.com/video/BV1sr4y1v7Bx"
        panda154.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda154.authorName = "开饭了大熊猫V"
        panda154.cover =
            "https://i1.hdslb.com/bfs/archive/6ae83b6472bf85dc4ecdcacdf3da92a24e468080.jpg"
        panda154.videoType = 0
        list.add(panda154)

        val panda155 = PetVideo()
        panda155.type = VideoType.PANDA.ordinal
        panda155.fileName = "panda_group_panda155"
        panda155.code = 630
        panda155.duration = 101
        panda155.period = PeriodType.GROUP.ordinal
        panda155.isStar = false
        panda155.title = "【大熊猫和花】和花憋了一天，终于有机会胖揍小伙伴了"
        panda155.releaseTime = "2022-01-10 22:57:37"
        panda155.originalUrl = "https://www.bilibili.com/video/BV18S4y1j7Fa"
        panda155.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda155.authorName = "何小玩"
        panda155.cover =
            "https://i0.hdslb.com/bfs/archive/eadd24b0b640e61da907054a8fb9929ca4362ac4.jpg"
        panda155.videoType = 0
        list.add(panda155)

        val panda156 = PetVideo()
        panda156.type = VideoType.PANDA.ordinal
        panda156.fileName = "panda_group_panda156"
        panda156.code = 631
        panda156.duration = 83
        panda156.period = PeriodType.GROUP.ordinal
        panda156.isStar = true
        panda156.title = "fa主任：你的小可爱滚过来了，你的小可爱又滚走了。【大熊猫和花】"
        panda156.releaseTime = "2022-01-10 22:14:29"
        panda156.originalUrl = "https://www.bilibili.com/video/BV19S4y1Z7KM"
        panda156.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda156.authorName = "隽一一"
        panda156.cover =
            "https://i0.hdslb.com/bfs/archive/07920ae5dee3b50b1e8ff5c463111275d56bc1c9.jpg"
        panda156.videoType = 0
        list.add(panda156)

        val panda157 = PetVideo()
        panda157.type = VideoType.PANDA.ordinal
        panda157.fileName = "panda_group_panda157"
        panda157.code = 632
        panda157.duration = 47
        panda157.period = PeriodType.GROUP.ordinal
        panda157.isStar = false
        panda157.title = "大熊猫和花-韭菜花三姐妹蹲守小卖部！"
        panda157.releaseTime = "2022-01-10 20:32:49"
        panda157.originalUrl = "https://www.bilibili.com/video/BV1hL4y1b7Aq"
        panda157.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda157.authorName = "和和和花花"
        panda157.cover =
            "https://i0.hdslb.com/bfs/archive/097a6fe324ae5bc4b5dec8e526e19d6a518b4100.jpg"
        panda157.videoType = 0
        list.add(panda157)

        val panda158 = PetVideo()
        panda158.type = VideoType.PANDA.ordinal
        panda158.fileName = "panda_group_panda158"
        panda158.code = 633
        panda158.duration = 42
        panda158.period = PeriodType.GROUP.ordinal
        panda158.isStar = true
        panda158.title = "【大熊猫和花】本来不想笑的，但是和花你太搞笑了"
        panda158.releaseTime = "2022-01-10 10:15:07"
        panda158.originalUrl = "https://www.bilibili.com/video/BV1gP4y1J7gu"
        panda158.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda158.authorName = "熊猫幼崽社区"
        panda158.cover =
            "https://i0.hdslb.com/bfs/archive/91614214884a1791eb4a8a5edfdff958a8dbc959.jpg"
        panda158.videoType = 0
        list.add(panda158)

        val panda159 = PetVideo()
        panda159.type = VideoType.PANDA.ordinal
        panda159.fileName = "panda_group_panda159"
        panda159.code = 634
        panda159.duration = 92
        panda159.period = PeriodType.GROUP.ordinal
        panda159.isStar = true
        panda159.title = "【大熊猫润玥】爪爪的史诗级打包"
        panda159.releaseTime = "2021-12-16 00:54:25"
        panda159.originalUrl = "https://www.bilibili.com/video/BV11P4y1n7ud"
        panda159.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda159.authorName = "空调轰轰响"
        panda159.cover =
            "https://i0.hdslb.com/bfs/archive/2f2fc65dd5cd3ee47b28d6d60a39191db631b5ff.jpg"
        panda159.videoType = 0
        list.add(panda159)

        val panda160 = PetVideo()
        panda160.type = VideoType.PANDA.ordinal
        panda160.fileName = "panda_group_panda160"
        panda160.code = 635
        panda160.duration = 116
        panda160.period = PeriodType.GROUP.ordinal
        panda160.isStar = false
        panda160.title = "绩笑成风虐树"
        panda160.releaseTime = "2022-01-08 14:58:49"
        panda160.originalUrl = "https://www.bilibili.com/video/BV1Q34y1q7Tt"
        panda160.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda160.authorName = "迩後咩"
        panda160.cover =
            "https://i1.hdslb.com/bfs/archive/c3ad3db9224bbaf837e6cfb25e16c60f50cc8e81.jpg"
        panda160.videoType = 0
        list.add(panda160)

        val panda161 = PetVideo()
        panda161.type = VideoType.PANDA.ordinal
        panda161.fileName = "panda_group_panda161"
        panda161.code = 636
        panda161.duration = 97
        panda161.period = PeriodType.GROUP.ordinal
        panda161.isStar = true
        panda161.title = "穿行于树林间的小精灵>>>画风突变！【大熊猫和花 和叶】"
        panda161.releaseTime = "2022-01-10 13:14:30"
        panda161.originalUrl = "https://www.bilibili.com/video/BV1ym4y1D77s"
        panda161.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda161.authorName = "安娜丽丝k"
        panda161.cover =
            "https://i0.hdslb.com/bfs/archive/96e2a65a6162f09b612f887496bd7ecc60af685c.jpg"
        panda161.videoType = 0
        list.add(panda161)

        val panda162 = PetVideo()
        panda162.type = VideoType.PANDA.ordinal
        panda162.fileName = "panda_group_panda162"
        panda162.code = 637
        panda162.duration = 738
        panda162.period = PeriodType.GROUP.ordinal
        panda162.isStar = false
        panda162.title = "和叶弟弟欺负姐姐和花"
        panda162.releaseTime = "2021-12-20 04:45:32"
        panda162.originalUrl = "https://www.bilibili.com/video/BV1pb4y1q7Kh"
        panda162.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda162.authorName = "yy爱你的心"
        panda162.cover =
            "https://i2.hdslb.com/bfs/archive/eecee607a67d46d8f0ccb20fd0bb3b74c56ad5b8.jpg"
        panda162.videoType = 0
        list.add(panda162)

        val panda163 = PetVideo()
        panda163.type = VideoType.PANDA.ordinal
        panda163.fileName = "panda_group_panda163"
        panda163.code = 638
        panda163.duration = 139
        panda163.period = PeriodType.GROUP.ordinal
        panda163.isStar = true
        panda163.title = "肉肉：就没见过这么神烦的熊猫"
        panda163.releaseTime = "2021-11-06 13:30:11"
        panda163.originalUrl = "https://www.bilibili.com/video/BV1qv411T73h"
        panda163.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda163.authorName = "pandapia熊猫乌托邦"
        panda163.cover =
            "https://i1.hdslb.com/bfs/archive/1d17befeb3536da4b8289d9348ad0296b4bd1275.jpg"
        panda163.videoType = 0
        list.add(panda163)

        val panda164 = PetVideo()
        panda164.type = VideoType.PANDA.ordinal
        panda164.fileName = "panda_group_panda164"
        panda164.code = 639
        panda164.duration = 55
        panda164.period = PeriodType.GROUP.ordinal
        panda164.isStar = true
        panda164.title = "大熊猫肉肉头套被踩变松狮"
        panda164.releaseTime = "2019-09-02 19:05:10"
        panda164.originalUrl = "https://www.bilibili.com/video/BV1H441117gq"
        panda164.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda164.authorName = "pandapia熊猫乌托邦"
        panda164.cover =
            "https://i1.hdslb.com/bfs/archive/c2b5a992cff55a12e759615ed56b3d2cbfc922f8.jpg"
        panda164.videoType = 0
        list.add(panda164)

        val panda165 = PetVideo()
        panda165.type = VideoType.PANDA.ordinal
        panda165.fileName = "panda_group_panda165"
        panda165.code = 640
        panda165.duration = 143
        panda165.period = PeriodType.GROUP.ordinal
        panda165.isStar = true
        panda165.title = "【大熊猫乔包包】长得这么甜美可爱，竟然是个男孩纸呀"
        panda165.releaseTime = "2020-11-13 22:21:40"
        panda165.originalUrl = "https://www.bilibili.com/video/BV1or4y1F7xU"
        panda165.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda165.authorName = "辛辛糖包"
        panda165.cover =
            "https://i1.hdslb.com/bfs/archive/fe1e0110bd5b89ff5b7e93c8b1130eeb65bcc53d.jpg"
        panda165.videoType = 0
        list.add(panda165)

        val panda166 = PetVideo()
        panda166.type = VideoType.PANDA.ordinal
        panda166.fileName = "panda_group_panda166"
        panda166.code = 641
        panda166.duration = 125
        panda166.period = PeriodType.GROUP.ordinal
        panda166.isStar = true
        panda166.title = "【大熊猫乔包包&乔兜兜】大脸兄弟，脸一个比一个大，萌感十足"
        panda166.releaseTime = "2020-11-27 01:35:04"
        panda166.originalUrl = "https://www.bilibili.com/video/BV1At4y1Y7sE"
        panda166.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda166.authorName = "辛辛糖包"
        panda166.cover =
            "https://i2.hdslb.com/bfs/archive/a6c7c4aa0e5ee061e9682945a2a5491cc048197a.jpg"
        panda166.videoType = 0
        list.add(panda166)

        val panda167 = PetVideo()
        panda167.type = VideoType.PANDA.ordinal
        panda167.fileName = "panda_group_panda167"
        panda167.code = 642
        panda167.duration = 154
        panda167.period = PeriodType.GROUP.ordinal
        panda167.isStar = true
        panda167.title = "水沟小公主 和花 从哪儿掉下去，就在哪儿歇会儿吧，还能找到小玩具自娱自乐"
        panda167.releaseTime = "2021-12-15 12:35:37"
        panda167.originalUrl = "https://www.bilibili.com/video/BV1oa411r7b9"
        panda167.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda167.authorName = "Miss菜V"
        panda167.cover =
            "https://i1.hdslb.com/bfs/archive/0a6bc764284336732140dcdd3dd24080854fd26c.jpg"
        panda167.videoType = 0
        list.add(panda167)

        val panda168 = PetVideo()
        panda168.type = VideoType.PANDA.ordinal
        panda168.fileName = "panda_group_panda168"
        panda168.code = 643
        panda168.duration = 63
        panda168.period = PeriodType.GROUP.ordinal
        panda168.isStar = false
        panda168.title = "润玥：我只想好好吃个竹子，成和花你别搞我"
        panda168.releaseTime = "2021-11-19 22:32:15"
        panda168.originalUrl = "https://www.bilibili.com/video/BV1EL411M7TX"
        panda168.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda168.authorName = "辛辛糖包"
        panda168.cover =
            "https://i2.hdslb.com/bfs/archive/e4ffe8f997c191f959c834c2fc43de30806e37cf.jpg"
        panda168.videoType = 0
        list.add(panda168)

        val panda169 = PetVideo()
        panda169.type = VideoType.PANDA.ordinal
        panda169.fileName = "panda_group_panda169"
        panda169.code = 644
        panda169.duration = 36
        panda169.period = PeriodType.GROUP.ordinal
        panda169.isStar = true
        panda169.title = "【大熊猫和花】我是只倔强的熊，怎么喊我都不理"
        panda169.releaseTime = "2022-01-09 20:35:50"
        panda169.originalUrl = "https://www.bilibili.com/video/BV1zm4y1D7Pz"
        panda169.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda169.authorName = "胖哒哒不月半"
        panda169.cover =
            "https://i2.hdslb.com/bfs/archive/50c061bef1194428e2d05f0ce2b27e0dd8c24f8c.jpg"
        panda169.videoType = 0
        list.add(panda169)

        val panda170 = PetVideo()
        panda170.type = VideoType.PANDA.ordinal
        panda170.fileName = "panda_group_panda170"
        panda170.code = 645
        panda170.duration = 132
        panda170.period = PeriodType.GROUP.ordinal
        panda170.isStar = false
        panda170.title = "进击吧，我的滚滚"
        panda170.releaseTime = "2017-06-10 19:43:42"
        panda170.originalUrl = "https://www.bilibili.com/video/BV1Ax411Y7fY"
        panda170.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda170.authorName = "pandapia熊猫乌托邦"
        panda170.cover =
            "https://i0.hdslb.com/bfs/archive/38ef6dfca513b1f0da470853b91968c1f3b2a368.jpg"
        panda170.videoType = 0
        list.add(panda170)

        val panda171 = PetVideo()
        panda171.type = VideoType.PANDA.ordinal
        panda171.fileName = "panda_group_panda171"
        panda171.code = 646
        panda171.duration = 27
        panda171.period = PeriodType.GROUP.ordinal
        panda171.isStar = false
        panda171.title = "对不起我胆子太小，下次打喷嚏能提前说声不？"
        panda171.releaseTime = "2017-04-17 18:49:27"
        panda171.originalUrl = "https://www.bilibili.com/video/BV18x411D7H4"
        panda171.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda171.authorName = "pandapia熊猫乌托邦"
        panda171.cover =
            "https://i1.hdslb.com/bfs/archive/73a990b4cf6f9514bc82aa63abaf1fdabb2d5407.jpg"
        panda171.videoType = 0
        list.add(panda171)

        val panda172 = PetVideo()
        panda172.type = VideoType.PANDA.ordinal
        panda172.fileName = "panda_group_panda172"
        panda172.code = 647
        panda172.duration = 210
        panda172.period = PeriodType.GROUP.ordinal
        panda172.isStar = true
        panda172.title = "为了实现菜总的伟大计划，和花甘做垫脚熊！【大熊猫和花 润玥】"
        panda172.releaseTime = "2022-01-08 00:12:01"
        panda172.originalUrl = "https://www.bilibili.com/video/BV1kY411a7fh"
        panda172.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda172.authorName = "安娜丽丝k"
        panda172.cover =
            "https://i2.hdslb.com/bfs/archive/ca17adcd0a3b95e32a616d256e666ba60a05b747.jpg"
        panda172.videoType = 0
        list.add(panda172)

        val panda173 = PetVideo()
        panda173.type = VideoType.PANDA.ordinal
        panda173.fileName = "panda_group_panda173"
        panda173.code = 648
        panda173.duration = 65
        panda173.period = PeriodType.GROUP.ordinal
        panda173.isStar = true
        panda173.title = "润玥：麻麻告诉过窝，要照顾好和花妹妹！"
        panda173.releaseTime = "2022-01-02 17:35:24"
        panda173.originalUrl = "https://www.bilibili.com/video/BV1iT4y1274S"
        panda173.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda173.authorName = "花叶玖玥"
        panda173.cover =
            "https://i0.hdslb.com/bfs/archive/b139c121da07b33c96da7d31487d6934cc342d17.jpg"
        panda173.videoType = 0
        list.add(panda173)

        val panda174 = PetVideo()
        panda174.type = VideoType.PANDA.ordinal
        panda174.fileName = "panda_group_panda174"
        panda174.code = 649
        panda174.duration = 40
        panda174.period = PeriodType.GROUP.ordinal
        panda174.isStar = true
        panda174.title = "梅兰肉肉蹭架蹭的很开心"
        panda174.releaseTime = "2018-09-19 12:11:04"
        panda174.originalUrl = "https://www.bilibili.com/video/BV1rW41167HS"
        panda174.tags = "月亮四熊,和花，和叶，润玥，艾玖"
        panda174.authorName = "梅吃饱"
        panda174.cover =
            "https://i0.hdslb.com/bfs/archive/6b4c009f0f4c9c7896cd39df493ddb6793fd9ac1.png"
        panda174.videoType = 0
        list.add(panda174)

        val panda175 = PetVideo()
        panda175.type = VideoType.PANDA.ordinal
        panda175.fileName = "panda_group_panda175"
        panda175.code = 1114
        panda175.duration = 34
        panda175.period = PeriodType.GROUP.ordinal
        panda175.isStar = false
        panda175.title = "超会营业的兜兜子，c位预定~耿达熊猫幼儿园"
        panda175.releaseTime = "2022-01-12 23:00:18"
        panda175.originalUrl = "https://www.bilibili.com/video/BV1tT4y1m7w2"
        panda175.tags = "大熊猫,萌宠,动物圈"
        panda175.authorName = "小香妞爱熊猫"
        panda175.cover =
            "https://i2.hdslb.com/bfs/archive/5186f836885f4f51f40a3342f34688c4806b7ebe.jpg"
        panda175.videoType = 0
        list.add(panda175)

        val panda176 = PetVideo()
        panda176.type = VideoType.PANDA.ordinal
        panda176.fileName = "panda_group_panda176"
        panda176.code = 1115
        panda176.duration = 11
        panda176.period = PeriodType.GROUP.ordinal
        panda176.isStar = true
        panda176.title = "生龙活虎的场面，总有一只熊猫与众不同"
        panda176.releaseTime = "2022-01-30 12:35:00"
        panda176.originalUrl = "https://www.bilibili.com/video/BV1Ba41117Je"
        panda176.tags = "大熊猫,萌宠,动物圈"
        panda176.authorName = "开饭了大熊猫V"
        panda176.cover =
            "https://i2.hdslb.com/bfs/archive/8c146e8f8861e00504f23c9ec3b643f7107e504b.jpg"
        panda176.videoType = 0
        list.add(panda176)

        val panda177 = PetVideo()
        panda177.type = VideoType.PANDA.ordinal
        panda177.fileName = "panda_group_panda177"
        panda177.code = 1116
        panda177.duration = 393
        panda177.period = PeriodType.GROUP.ordinal
        panda177.isStar = false
        panda177.title = "【大熊猫和花】20220207 花花再一次征服了大树枝"
        panda177.releaseTime = "2022-02-08 11:42:08"
        panda177.originalUrl = "https://www.bilibili.com/video/BV1ET4y1C7LL"
        panda177.tags = "大熊猫,萌宠,动物圈"
        panda177.authorName = "大本命不存在"
        panda177.cover =
            "https://i2.hdslb.com/bfs/archive/f29256b51157a1dba0f38953b462ae2ff013efdb.jpg"
        panda177.videoType = 0
        list.add(panda177)

        val panda178 = PetVideo()
        panda178.type = VideoType.PANDA.ordinal
        panda178.fileName = "panda_group_panda178"
        panda178.code = 1117
        panda178.duration = 193
        panda178.period = PeriodType.GROUP.ordinal
        panda178.isStar = true
        panda178.title = "【和花】冰滚滚不是冰墩墩"
        panda178.releaseTime = "2022-02-04 11:00:17"
        panda178.originalUrl = "https://www.bilibili.com/video/BV1sr4y1Y7UA"
        panda178.tags = "大熊猫,萌宠,动物圈"
        panda178.authorName = "pandapia熊猫乌托邦"
        panda178.cover =
            "https://i2.hdslb.com/bfs/archive/496777ba95f378c4242def69f9b0cd6283612a53.jpg"
        panda178.videoType = 0
        list.add(panda178)

        val panda179 = PetVideo()
        panda179.type = VideoType.PANDA.ordinal
        panda179.fileName = "panda_group_panda179"
        panda179.code = 1118
        panda179.duration = 48
        panda179.period = PeriodType.GROUP.ordinal
        panda179.isStar = true
        panda179.title = "【大熊猫和花】花花是个好姐姐，主动给弟弟当垫jio石"
        panda179.releaseTime = "2022-01-25 22:00:08"
        panda179.originalUrl = "https://www.bilibili.com/video/BV1T3411Y7rQ"
        panda179.tags = "大熊猫,萌宠,动物圈"
        panda179.authorName = "小香妞爱熊猫"
        panda179.cover =
            "https://i0.hdslb.com/bfs/archive/bfdad90b95823550ba8d45764b6cc8b7cb0a3e8d.jpg"
        panda179.videoType = 0
        list.add(panda179)

        val panda180 = PetVideo()
        panda180.type = VideoType.PANDA.ordinal
        panda180.fileName = "panda_group_panda180"
        panda180.code = 1119
        panda180.duration = 30
        panda180.period = PeriodType.GROUP.ordinal
        panda180.isStar = true
        panda180.title = "滚滚兄妹🐼在雪山喝冰镇盆盆奶"
        panda180.releaseTime = "2021-10-08 14:06:23"
        panda180.originalUrl = "https://www.bilibili.com/video/BV1bb4y1a7n5"
        panda180.tags = "大熊猫,萌宠,动物圈"
        panda180.authorName = "FlintWalk燧石行"
        panda180.cover =
            "https://i1.hdslb.com/bfs/archive/fe2259441ad876489004c44d197926bfc4431279.jpg"
        panda180.videoType = 0
        list.add(panda180)

        val panda181 = PetVideo()
        panda181.type = VideoType.PANDA.ordinal
        panda181.fileName = "panda_group_panda181"
        panda181.code = 1120
        panda181.duration = 35
        panda181.period = PeriodType.GROUP.ordinal
        panda181.isStar = true
        panda181.title = "太古里3d熊猫"
        panda181.releaseTime = "2022-01-30 20:21:26"
        panda181.originalUrl = "https://www.bilibili.com/video/BV1zL4y1W7xw"
        panda181.tags = "大熊猫,萌宠,动物圈"
        panda181.authorName = "顶叮顶叮"
        panda181.cover =
            "https://i0.hdslb.com/bfs/archive/4a129867ac595d671d14ebf3e1521d11edacd158.jpg"
        panda181.videoType = 0
        list.add(panda181)

        val panda182 = PetVideo()
        panda182.type = VideoType.PANDA.ordinal
        panda182.fileName = "panda_group_panda182"
        panda182.code = 1121
        panda182.duration = 83
        panda182.period = PeriodType.GROUP.ordinal
        panda182.isStar = true
        panda182.title = "菜总威武，奶爸撒腿就跑～！【大熊猫润玥】"
        panda182.releaseTime = "2022-02-06 00:22:17"
        panda182.originalUrl = "https://www.bilibili.com/video/BV1bS4y1571P"
        panda182.tags = "大熊猫,萌宠,动物圈"
        panda182.authorName = "安娜丽丝k"
        panda182.cover =
            "https://i0.hdslb.com/bfs/archive/6243a406327b26030622c2d71e343b7ac3df5c62.jpg"
        panda182.videoType = 0
        list.add(panda182)

        val panda183 = PetVideo()
        panda183.type = VideoType.PANDA.ordinal
        panda183.fileName = "panda_group_panda183"
        panda183.code = 1122
        panda183.duration = 149
        panda183.period = PeriodType.GROUP.ordinal
        panda183.isStar = false
        panda183.title = "基地熊第一次玩雪好开心！大熊猫绩笑被成风成浪rua得嗷嗷叫 220204"
        panda183.releaseTime = "2022-02-04 11:45:14"
        panda183.originalUrl = "https://www.bilibili.com/video/BV17b4y177Ni"
        panda183.tags = "大熊猫,萌宠,动物圈"
        panda183.authorName = "浪花花呀0611"
        panda183.cover =
            "https://i2.hdslb.com/bfs/archive/a859061ca0a6793421f4ef2d8bfa78d252d209ca.jpg"
        panda183.videoType = 0
        list.add(panda183)

        val panda184 = PetVideo()
        panda184.type = VideoType.PANDA.ordinal
        panda184.fileName = "panda_group_panda184"
        panda184.code = 1123
        panda184.duration = 23
        panda184.period = PeriodType.GROUP.ordinal
        panda184.isStar = false
        panda184.title = "没有巨美姐姐在身边的成兰...成为青青妹的垫脚凳～"
        panda184.releaseTime = "2019-05-22 16:50:10"
        panda184.originalUrl = "https://www.bilibili.com/video/BV1r44115781"
        panda184.tags = "大熊猫,萌宠,动物圈"
        panda184.authorName = "pandapia熊猫乌托邦"
        panda184.cover =
            "https://i0.hdslb.com/bfs/archive/ea11195b06b3d53dd3d2a8f8216459ac478ef559.jpg"
        panda184.videoType = 0
        list.add(panda184)

        val panda185 = PetVideo()
        panda185.type = VideoType.PANDA.ordinal
        panda185.fileName = "panda_group_panda185"
        panda185.code = 1124
        panda185.duration = 38
        panda185.period = PeriodType.GROUP.ordinal
        panda185.isStar = true
        panda185.title = "乔兜兜，你怎么长的这么甜呀"
        panda185.releaseTime = "2022-02-06 08:58:05"
        panda185.originalUrl = "https://www.bilibili.com/video/BV1GS4y117Uv"
        panda185.tags = "大熊猫,萌宠,动物圈"
        panda185.authorName = "黑白宝宝小捣蛋"
        panda185.cover =
            "https://i0.hdslb.com/bfs/archive/262537540c7444c7fc580789f873d773096ad561.jpg"
        panda185.videoType = 0
        list.add(panda185)

        val panda186 = PetVideo()
        panda186.type = VideoType.PANDA.ordinal
        panda186.fileName = "panda_group_panda186"
        panda186.code = 1125
        panda186.duration = 45
        panda186.period = PeriodType.GROUP.ordinal
        panda186.isStar = true
        panda186.title = "[和花]估计花花在思考下班的时候怎么骗谭爷爷的抱抱"
        panda186.releaseTime = "2022-01-13 21:42:02"
        panda186.originalUrl = "https://www.bilibili.com/video/BV1QF411H7BB"
        panda186.tags = "大熊猫,萌宠,动物圈"
        panda186.authorName = "多元化之无尽的梦魇"
        panda186.cover =
            "https://i0.hdslb.com/bfs/archive/1e14fd8b2c64447ffec78cdebf5d60a09e49a33e.png"
        panda186.videoType = 0
        list.add(panda186)

        val panda187 = PetVideo()
        panda187.type = VideoType.PANDA.ordinal
        panda187.fileName = "panda_group_panda187"
        panda187.code = 1126
        panda187.duration = 41
        panda187.period = PeriodType.GROUP.ordinal
        panda187.isStar = true
        panda187.title = "【大熊猫和花】fafa的起床气有多重？"
        panda187.releaseTime = "2022-01-19 22:00:08"
        panda187.originalUrl = "https://www.bilibili.com/video/BV18Z4y1f7bm"
        panda187.tags = "大熊猫,萌宠,动物圈"
        panda187.authorName = "小香妞爱熊猫"
        panda187.cover =
            "https://i1.hdslb.com/bfs/archive/a3b3284ff8403825e4a87b05b06b68f89ad45721.jpg"
        panda187.videoType = 0
        list.add(panda187)

        val panda188 = PetVideo()
        panda188.type = VideoType.PANDA.ordinal
        panda188.fileName = "panda_group_panda188"
        panda188.code = 1127
        panda188.duration = 11
        panda188.period = PeriodType.GROUP.ordinal
        panda188.isStar = true
        panda188.title = "【大熊猫和花】冰墩墩本墩"
        panda188.releaseTime = "2022-02-06 21:45:01"
        panda188.originalUrl = "https://www.bilibili.com/video/BV19R4y1j74q"
        panda188.tags = "大熊猫,萌宠,动物圈"
        panda188.authorName = "摄影师动物米"
        panda188.cover =
            "https://i2.hdslb.com/bfs/archive/2f07270ffbd83be139baac23b9c5246127ffbd65.jpg"
        panda188.videoType = 0
        list.add(panda188)

        val panda189 = PetVideo()
        panda189.type = VideoType.PANDA.ordinal
        panda189.fileName = "panda_group_panda189"
        panda189.code = 1128
        panda189.duration = 89
        panda189.period = PeriodType.GROUP.ordinal
        panda189.isStar = true
        panda189.title = "和花花又来萌洗你们啦！困了也要营业！【大熊猫和花】"
        panda189.releaseTime = "2022-01-21 17:20:28"
        panda189.originalUrl = "https://www.bilibili.com/video/BV18u411m791"
        panda189.tags = "大熊猫,萌宠,动物圈"
        panda189.authorName = "安娜丽丝k"
        panda189.cover =
            "https://i0.hdslb.com/bfs/archive/ab5e29964f73d0b5ea133c574f9e64a2f82719f2.jpg"
        panda189.videoType = 0
        list.add(panda189)

        val panda190 = PetVideo()
        panda190.type = VideoType.PANDA.ordinal
        panda190.fileName = "panda_group_panda190"
        panda190.code = 1129
        panda190.duration = 51
        panda190.period = PeriodType.GROUP.ordinal
        panda190.isStar = true
        panda190.title = "你俩怎么疑神疑鬼的？国宝的第六感，你不懂"
        panda190.releaseTime = "2019-08-10 19:00:55"
        panda190.originalUrl = "https://www.bilibili.com/video/BV1f4411Q7y2"
        panda190.tags = "大熊猫,萌宠,动物圈"
        panda190.authorName = "pandapia熊猫乌托邦"
        panda190.cover =
            "https://i0.hdslb.com/bfs/archive/98f60d563e0edda7ddb7a46ed2821504ca0441f7.jpg"
        panda190.videoType = 0
        list.add(panda190)

        val panda191 = PetVideo()
        panda191.type = VideoType.PANDA.ordinal
        panda191.fileName = "panda_group_panda191"
        panda191.code = 1130
        panda191.duration = 145
        panda191.period = PeriodType.GROUP.ordinal
        panda191.isStar = true
        panda191.title = "宠粉女明星和花亮相，快门声彩虹pi不绝于耳～【大熊猫和花】"
        panda191.releaseTime = "2022-02-05 00:25:12"
        panda191.originalUrl = "https://www.bilibili.com/video/BV1aF411J7E6"
        panda191.tags = "大熊猫,萌宠,动物圈"
        panda191.authorName = "安娜丽丝k"
        panda191.cover =
            "https://i1.hdslb.com/bfs/archive/a8461aeac0fc1fd227acb6cc9518e31a09ea328e.jpg"
        panda191.videoType = 0
        list.add(panda191)

        val panda192 = PetVideo()
        panda192.type = VideoType.PANDA.ordinal
        panda192.fileName = "panda_group_panda192"
        panda192.code = 1230
        panda192.duration = 76
        panda192.period = PeriodType.GROUP.ordinal
        panda192.isStar = false
        panda192.title = "熊猫画中游！国画+冬奥原来这么惊艳"
        panda192.releaseTime = "2022-02-06 18:50:06"
        panda192.originalUrl = "https://www.bilibili.com/video/BV1gr4y1h7Yq"
        panda192.tags = "大熊猫,萌宠,动物圈"
        panda192.authorName = "三又川"
        panda192.cover =
            "https://i1.hdslb.com/bfs/archive/de5bb7b44e14b7bdcc1668a6bbd4c09d392f2957.jpg"
        list.add(panda192)

        val panda193 = PetVideo()
        panda193.type = VideoType.PANDA.ordinal
        panda193.fileName = "panda_group_panda193"
        panda193.code = 1231
        panda193.duration = 134
        panda193.period = PeriodType.GROUP.ordinal
        panda193.isStar = false
        panda193.title = "和花：为了得到爷爷的抱抱，我可是煞费苦心😎"
        panda193.releaseTime = "2022-01-05 18:12:32"
        panda193.originalUrl = "https://www.bilibili.com/video/BV13F411v7fk"
        panda193.tags = "大熊猫,萌宠,动物圈"
        panda193.authorName = "讷言小筑"
        panda193.cover =
            "https://i0.hdslb.com/bfs/archive/cc080c266c2a401ee56065fe1e8b58b83a5122c3.jpg"
        list.add(panda193)

        val panda194 = PetVideo()
        panda194.type = VideoType.PANDA.ordinal
        panda194.fileName = "panda_group_panda194"
        panda194.code = 1232
        panda194.duration = 52
        panda194.period = PeriodType.GROUP.ordinal
        panda194.isStar = false
        panda194.title = "花花祝大家[冬至快乐]！都吃好喝好了吗?晚安！(≧∇≦)/【大熊猫和花】"
        panda194.releaseTime = "2021-12-21 23:11:14"
        panda194.originalUrl = "https://www.bilibili.com/video/BV11T4y1f7e8"
        panda194.tags = "大熊猫,萌宠,动物圈"
        panda194.authorName = "安娜丽丝k"
        panda194.cover =
            "https://i1.hdslb.com/bfs/archive/f28328e7dbcc7fab9c79ed416d91681c84ead4a6.jpg"
        list.add(panda194)

        val panda195 = PetVideo()
        panda195.type = VideoType.PANDA.ordinal
        panda195.fileName = "panda_group_panda195"
        panda195.code = 1233
        panda195.duration = 82
        panda195.period = PeriodType.GROUP.ordinal
        panda195.isStar = false
        panda195.title = "假吃播主和花VS真吃学霸润玥 哈哈 爪爪吃饭好幸福的样子，花花你要加油呀！"
        panda195.releaseTime = "2021-12-13 11:32:01"
        panda195.originalUrl = "https://www.bilibili.com/video/BV1ai4y1d7pd"
        panda195.tags = "大熊猫,萌宠,动物圈"
        panda195.authorName = "Miss菜V"
        panda195.cover =
            "https://i0.hdslb.com/bfs/archive/a00c4b29714364e78ebd7aef10c21c846c3063fa.jpg"
        list.add(panda195)

        val panda196 = PetVideo()
        panda196.type = VideoType.PANDA.ordinal
        panda196.fileName = "panda_group_panda196"
        panda196.code = 1234
        panda196.duration = 35
        panda196.period = PeriodType.GROUP.ordinal
        panda196.isStar = false
        panda196.title = "大熊猫和花-熊掌的味道，熊知道"
        panda196.releaseTime = "2022-01-06 19:01:34"
        panda196.originalUrl = "https://www.bilibili.com/video/BV1rb4y1n7Ld"
        panda196.tags = "大熊猫,萌宠,动物圈"
        panda196.authorName = "和和和花花"
        panda196.cover =
            "https://i1.hdslb.com/bfs/archive/ebebd49e3841889b130d19fe11fa2546aa6b2acf.jpg"
        list.add(panda196)

        val panda197 = PetVideo()
        panda197.type = VideoType.PANDA.ordinal
        panda197.fileName = "panda_group_panda197"
        panda197.code = 1235
        panda197.duration = 103
        panda197.period = PeriodType.GROUP.ordinal
        panda197.isStar = false
        panda197.title = "黑熊园分别前的钓猫，谭爷爷熟悉的声音又响起"
        panda197.releaseTime = "2021-12-19 23:00:15"
        panda197.originalUrl = "https://www.bilibili.com/video/BV1ci4y1o7bv"
        panda197.tags = "大熊猫,萌宠,动物圈"
        panda197.authorName = "小香妞爱熊猫"
        panda197.cover =
            "https://i0.hdslb.com/bfs/archive/b6a6daace734786cd5cd74851bdd12fd9f465950.jpg"
        list.add(panda197)

        val panda198 = PetVideo()
        panda198.type = VideoType.PANDA.ordinal
        panda198.fileName = "panda_group_panda198"
        panda198.code = 1236
        panda198.duration = 34
        panda198.period = PeriodType.GROUP.ordinal
        panda198.isStar = false
        panda198.title = "大熊猫和花-熊猫蛋是怎么孵出来的"
        panda198.releaseTime = "2021-12-30 17:54:19"
        panda198.originalUrl = "https://www.bilibili.com/video/BV1fu411S7oy"
        panda198.tags = "大熊猫,萌宠,动物圈"
        panda198.authorName = "和和和花花"
        panda198.cover =
            "https://i0.hdslb.com/bfs/archive/458385f28731e1c9bd4a17959bf53cfbec357a90.jpg"
        list.add(panda198)

        val panda199 = PetVideo()
        panda199.type = VideoType.PANDA.ordinal
        panda199.fileName = "panda_group_panda199"
        panda199.code = 1237
        panda199.duration = 66
        panda199.period = PeriodType.GROUP.ordinal
        panda199.isStar = false
        panda199.title = "萌兽 ✿✿ 【大熊猫和花】"
        panda199.releaseTime = "2022-01-11 13:04:19"
        panda199.originalUrl = "https://www.bilibili.com/video/BV1dS4y1Z7iW"
        panda199.tags = "大熊猫,萌宠,动物圈"
        panda199.authorName = "安娜丽丝k"
        panda199.cover =
            "https://i2.hdslb.com/bfs/archive/d28381e0abbfcd12132f12a642b154801eecaabc.jpg"
        list.add(panda199)

        val panda200 = PetVideo()
        panda200.type = VideoType.PANDA.ordinal
        panda200.fileName = "panda_group_panda200"
        panda200.code = 1238
        panda200.duration = 147
        panda200.period = PeriodType.GROUP.ordinal
        panda200.isStar = false
        panda200.title =
            "【20220210 收猫】 润玥带着花花去了小卖部，路上突然杀出了一只成和叶，然后菜叶时不时就一起滚成了一只球，花花从员工通道出来看热闹，和姐姐迪迪一起等下班。"
        panda200.releaseTime = "2022-02-11 00:15:34"
        panda200.originalUrl = "https://www.bilibili.com/video/BV1sb4y177DY"
        panda200.tags = "大熊猫,萌宠,动物圈"
        panda200.authorName = "梦羽凌霄"
        panda200.cover =
            "https://i1.hdslb.com/bfs/archive/61e40ff76f2c4dfc8ad00c9c0102c007b03aa8e9.jpg"
        list.add(panda200)

        val panda201 = PetVideo()
        panda201.type = VideoType.PANDA.ordinal
        panda201.fileName = "panda_group_panda201"
        panda201.code = 1239
        panda201.duration = 133
        panda201.period = PeriodType.GROUP.ordinal
        panda201.isStar = false
        panda201.title = "【大熊猫和花 润玥】菜花姐妹携小树枝祝亲妈新年快乐"
        panda201.releaseTime = "2022-01-31 19:56:13"
        panda201.originalUrl = "https://www.bilibili.com/video/BV1xm4y1o7ry"
        panda201.tags = "大熊猫,萌宠,动物圈"
        panda201.authorName = "瑞壑"
        panda201.cover =
            "https://i0.hdslb.com/bfs/archive/6348a454acce80419ef3ca27dea43b5ae5887ac2.jpg"
        list.add(panda201)

        val panda202 = PetVideo()
        panda202.type = VideoType.PANDA.ordinal
        panda202.fileName = "panda_group_panda202"
        panda202.code = 1240
        panda202.duration = 93
        panda202.period = PeriodType.GROUP.ordinal
        panda202.isStar = false
        panda202.title = "当你的小可爱突然坐到前台来表演“吃竹叽”。。【大熊猫和花】"
        panda202.releaseTime = "2022-02-10 21:32:08"
        panda202.originalUrl = "https://www.bilibili.com/video/BV1U3411j7KK"
        panda202.tags = "大熊猫,萌宠,动物圈"
        panda202.authorName = "隽一一"
        panda202.cover =
            "https://i2.hdslb.com/bfs/archive/5ddc27504d0283f412fa56e260ae1f28b2403b94.jpg"
        list.add(panda202)

        val panda203 = PetVideo()
        panda203.type = VideoType.PANDA.ordinal
        panda203.fileName = "panda_group_panda203"
        panda203.code = 1241
        panda203.duration = 106
        panda203.period = PeriodType.GROUP.ordinal
        panda203.isStar = false
        panda203.title = "新年了，需要来点热闹的！这个版本的《祝福你》真是句句高能！"
        panda203.releaseTime = "2022-02-01 11:00:00"
        panda203.originalUrl = "https://www.bilibili.com/video/BV153411E7NM"
        panda203.tags = "大熊猫,萌宠,动物圈"
        panda203.authorName = "pandapia熊猫乌托邦"
        panda203.cover =
            "https://i1.hdslb.com/bfs/archive/20f2e66ec93dea394fb0be8f561a54093b4fd392.jpg"
        list.add(panda203)

        val panda204 = PetVideo()
        panda204.type = VideoType.PANDA.ordinal
        panda204.fileName = "panda_group_panda204"
        panda204.code = 1242
        panda204.duration = 254
        panda204.period = PeriodType.GROUP.ordinal
        panda204.isStar = false
        panda204.title = "幼年4嘟的阳光下午茶，每一帧都有戏！【大熊猫和花.和叶.润玥.艾玖】"
        panda204.releaseTime = "2022-02-10 20:04:17"
        panda204.originalUrl = "https://www.bilibili.com/video/BV14m4y1Z7xS"
        panda204.tags = "大熊猫,萌宠,动物圈"
        panda204.authorName = "安娜丽丝k"
        panda204.cover =
            "https://i2.hdslb.com/bfs/archive/76f54378e6b6d2ea8698c71d2843dbc30772b08b.jpg"
        list.add(panda204)

        val panda205 = PetVideo()
        panda205.type = VideoType.PANDA.ordinal
        panda205.fileName = "panda_group_panda205"
        panda205.code = 1243
        panda205.duration = 124
        panda205.period = PeriodType.GROUP.ordinal
        panda205.isStar = false
        panda205.title = "大熊猫多瓶瓶奶少，这是我见过最手忙脚乱的年夜饭现场"
        panda205.releaseTime = "2022-01-31 19:00:06"
        panda205.originalUrl = "https://www.bilibili.com/video/BV1fa41117CW"
        panda205.tags = "大熊猫,萌宠,动物圈"
        panda205.authorName = "iPanda熊猫频道"
        panda205.cover =
            "https://i1.hdslb.com/bfs/archive/5cecef2a048024d1ff5de1eca6be613ca0a30d9c.jpg"
        list.add(panda205)

        val panda206 = PetVideo()
        panda206.type = VideoType.PANDA.ordinal
        panda206.fileName = "panda_group_panda206"
        panda206.code = 1244
        panda206.duration = 81
        panda206.period = PeriodType.GROUP.ordinal
        panda206.isStar = false
        panda206.title = "四川人民抱着今年刚分到的大熊猫，露出了满足的笑容"
        panda206.releaseTime = "2022-01-25 20:00:14"
        panda206.originalUrl = "https://www.bilibili.com/video/BV13S4y1L7dr"
        panda206.tags = "大熊猫,萌宠,动物圈"
        panda206.authorName = "iPanda熊猫频道"
        panda206.cover =
            "https://i0.hdslb.com/bfs/archive/7721324016f3acadaeef389cab8b9541ec29ecaf.jpg"
        list.add(panda206)

        val panda207 = PetVideo()
        panda207.type = VideoType.PANDA.ordinal
        panda207.fileName = "panda_group_panda207"
        panda207.code = 1245
        panda207.duration = 195
        panda207.period = PeriodType.GROUP.ordinal
        panda207.isStar = false
        panda207.title = "和花是永动熊，姐姐睡觉，反正她不睡。"
        panda207.releaseTime = "2022-02-07 14:28:32"
        panda207.originalUrl = "https://www.bilibili.com/video/BV1Tb4y177go"
        panda207.tags = "大熊猫,萌宠,动物圈"
        panda207.authorName = "和花花容月貌"
        panda207.cover =
            "https://i1.hdslb.com/bfs/archive/41617d2c227372d5ea350e20c8b7c929b54d967c.jpg"
        list.add(panda207)

        val panda208 = PetVideo()
        panda208.type = VideoType.PANDA.ordinal
        panda208.fileName = "panda_group_panda208"
        panda208.code = 1328
        panda208.duration = 74
        panda208.period = PeriodType.GROUP.ordinal
        panda208.isStar = false
        panda208.title = "你在干嘛呀？大熊猫和花：我在躲猫猫哦！"
        panda208.releaseTime = "2022-02-12 18:05:00"
        panda208.originalUrl = "https://www.bilibili.com/video/BV1NF411n7pF"
        panda208.tags = "大熊猫,萌宠,动物圈"
        panda208.authorName = "水果小分队的椰子"
        panda208.cover =
            "https://i0.hdslb.com/bfs/archive/8a3325153fe5484d1627482044516a41279f1247.jpg"
        list.add(panda208)

        val panda209 = PetVideo()
        panda209.type = VideoType.PANDA.ordinal
        panda209.fileName = "panda_group_panda209"
        panda209.code = 1329
        panda209.duration = 62
        panda209.period = PeriodType.GROUP.ordinal
        panda209.isStar = false
        panda209.title = "艾玖：花花，大竹片给姐姐帮你啃。和花：我呆了。。。【大熊猫】"
        panda209.releaseTime = "2022-02-12 18:53:19"
        panda209.originalUrl = "https://www.bilibili.com/video/BV14m4y1Z7rv"
        panda209.tags = "大熊猫,萌宠,动物圈"
        panda209.authorName = "隽一一"
        panda209.cover =
            "https://i2.hdslb.com/bfs/archive/a51a5d626b145a9106fedddc15deb209942bcd65.jpg"
        list.add(panda209)

        val panda210 = PetVideo()
        panda210.type = VideoType.PANDA.ordinal
        panda210.fileName = "panda_group_panda210"
        panda210.code = 1330
        panda210.duration = 34
        panda210.period = PeriodType.GROUP.ordinal
        panda210.isStar = false
        panda210.title = "【大熊猫】和花一字马跨栏在冬奥什么水平"
        panda210.releaseTime = "2022-02-11 21:35:19"
        panda210.originalUrl = "https://www.bilibili.com/video/BV1su41197xs"
        panda210.tags = "大熊猫,萌宠,动物圈"
        panda210.authorName = "摄影师动物米"
        panda210.cover =
            "https://i1.hdslb.com/bfs/archive/770b239bb535edfb820de81d132e7b908c866c52.jpg"
        list.add(panda210)

        val panda211 = PetVideo()
        panda211.type = VideoType.PANDA.ordinal
        panda211.fileName = "panda_group_panda211"
        panda211.code = 1331
        panda211.duration = 81
        panda211.period = PeriodType.GROUP.ordinal
        panda211.isStar = false
        panda211.title = "和叶，这还没开始钓猫，就自个儿练上了?！【大熊猫和叶】"
        panda211.releaseTime = "2022-02-12 10:50:26"
        panda211.originalUrl = "https://www.bilibili.com/video/BV1vL4y137aC"
        panda211.tags = "大熊猫,萌宠,动物圈"
        panda211.authorName = "安娜丽丝k"
        panda211.cover =
            "https://i2.hdslb.com/bfs/archive/24fd7a86a8ea104d16fb31c43eb729c382b97211.jpg"
        list.add(panda211)

        val panda212 = PetVideo()
        panda212.type = VideoType.PANDA.ordinal
        panda212.fileName = "panda_group_panda212"
        panda212.code = 1332
        panda212.duration = 89
        panda212.period = PeriodType.GROUP.ordinal
        panda212.isStar = true
        panda212.title = "和叶对和花撒娇"
        panda212.releaseTime = "2022-01-02 14:55:33"
        panda212.originalUrl = "https://www.bilibili.com/video/BV1Wb4y1e7k4"
        panda212.tags = "大熊猫,萌宠,动物圈"
        panda212.authorName = "迩後咩"
        panda212.cover =
            "https://i0.hdslb.com/bfs/archive/923290e2a8c4c813a4e54f073e9efc37133077b9.jpg"
        list.add(panda212)

        val panda213 = PetVideo()
        panda213.type = VideoType.PANDA.ordinal
        panda213.fileName = "panda_group_panda213"
        panda213.code = 1333
        panda213.duration = 81
        panda213.period = PeriodType.GROUP.ordinal
        panda213.isStar = false
        panda213.title = "和叶追奶爸抱大腿"
        panda213.releaseTime = "2021-12-25 14:20:27"
        panda213.originalUrl = "https://www.bilibili.com/video/BV1cR4y1s7cV"
        panda213.tags = "大熊猫,萌宠,动物圈"
        panda213.authorName = "迩後咩"
        panda213.cover =
            "https://i2.hdslb.com/bfs/archive/e0c0016244881762f9f60c447f4429ea7bf30ab8.jpg"
        list.add(panda213)

        val panda214 = PetVideo()
        panda214.type = VideoType.PANDA.ordinal
        panda214.fileName = "panda_group_panda214"
        panda214.code = 1334
        panda214.duration = 180
        panda214.period = PeriodType.GROUP.ordinal
        panda214.isStar = false
        panda214.title = "发箍奶爸收和花和叶，姐弟俩一起耍耐皮"
        panda214.releaseTime = "2021-12-21 21:05:47"
        panda214.originalUrl = "https://www.bilibili.com/video/BV1VY411p7YU"
        panda214.tags = "大熊猫,萌宠,动物圈"
        panda214.authorName = "迩後咩"
        panda214.cover =
            "https://i2.hdslb.com/bfs/archive/ad004a57db7e2cb269e8e7d4466915f1f33cde8b.jpg"
        list.add(panda214)

        val panda215 = PetVideo()
        panda215.type = VideoType.PANDA.ordinal
        panda215.fileName = "panda_group_panda215"
        panda215.code = 1335
        panda215.duration = 54
        panda215.period = PeriodType.GROUP.ordinal
        panda215.isStar = false
        panda215.title = "[大熊猫和花和叶]2021年的最后一天，我们搬家啦"
        panda215.releaseTime = "2021-12-31 21:49:45"
        panda215.originalUrl = "https://www.bilibili.com/video/BV18T4y127cc"
        panda215.tags = "大熊猫,萌宠,动物圈"
        panda215.authorName = "胖哒哒不月半"
        panda215.cover =
            "https://i1.hdslb.com/bfs/archive/a0b03580513bce35d5bd5c2e14c5fdb773bcee6f.jpg"
        list.add(panda215)

        val panda216 = PetVideo()
        panda216.type = VideoType.PANDA.ordinal
        panda216.fileName = "panda_group_panda216"
        panda216.code = 1336
        panda216.duration = 81
        panda216.period = PeriodType.GROUP.ordinal
        panda216.isStar = false
        panda216.title = "和叶：窝姐挑的竹竿儿，绝对好吃！【大熊猫和花】【大熊猫和叶】"
        panda216.releaseTime = "2021-12-17 13:37:39"
        panda216.originalUrl = "https://www.bilibili.com/video/BV19Q4y1a7YF"
        panda216.tags = "大熊猫,萌宠,动物圈"
        panda216.authorName = "安娜丽丝k"
        panda216.cover =
            "https://i1.hdslb.com/bfs/archive/d6c591fd643bb13925e23ca5eff4bee8f34b90fa.png"
        list.add(panda216)

        val panda217 = PetVideo()
        panda217.type = VideoType.PANDA.ordinal
        panda217.fileName = "panda_group_panda217"
        panda217.code = 1337
        panda217.duration = 24
        panda217.period = PeriodType.GROUP.ordinal
        panda217.isStar = false
        panda217.title = "【大熊猫和花】11.20 我们是亲亲的姐弟，总会有一些心电感应！(*˘︶˘*).｡.:*♡"
        panda217.releaseTime = "2021-11-24 17:56:48"
        panda217.originalUrl = "https://www.bilibili.com/video/BV1vh41147Bj"
        panda217.tags = "大熊猫,萌宠,动物圈"
        panda217.authorName = "安娜丽丝k"
        panda217.cover =
            "https://i2.hdslb.com/bfs/archive/3efae51e975c995e59fd7dfa3acb08e08b137d64.jpg"
        list.add(panda217)

        val panda218 = PetVideo()
        panda218.type = VideoType.PANDA.ordinal
        panda218.fileName = "panda_group_panda218"
        panda218.code = 1338
        panda218.duration = 153
        panda218.period = PeriodType.GROUP.ordinal
        panda218.isStar = false
        panda218.title = "【大熊猫和花】11.20 和叶，再来再来！！！"
        panda218.releaseTime = "2021-11-22 20:03:45"
        panda218.originalUrl = "https://www.bilibili.com/video/BV1544y1Y774"
        panda218.tags = "大熊猫,萌宠,动物圈"
        panda218.authorName = "安娜丽丝k"
        panda218.cover =
            "https://i0.hdslb.com/bfs/archive/a1a5f382b3d02d29a1f1c922eefb951b6cb7500b.jpg"
        list.add(panda218)

        val panda219 = PetVideo()
        panda219.type = VideoType.PANDA.ordinal
        panda219.fileName = "panda_group_panda219"
        panda219.code = 1339
        panda219.duration = 78
        panda219.period = PeriodType.GROUP.ordinal
        panda219.isStar = false
        panda219.title = "弟弟，我是不是全宇宙最腻害的姐姐。【大熊猫和花、和叶】"
        panda219.releaseTime = "2021-12-30 18:54:13"
        panda219.originalUrl = "https://www.bilibili.com/video/BV14Z4y1D7Ax"
        panda219.tags = "大熊猫,萌宠,动物圈"
        panda219.authorName = "隽一一"
        panda219.cover =
            "https://i1.hdslb.com/bfs/archive/aa4a3d47a7d3cc389a82dd548d99fa3b1ca25c08.jpg"
        list.add(panda219)

        val panda220 = PetVideo()
        panda220.type = VideoType.PANDA.ordinal
        panda220.fileName = "panda_group_panda220"
        panda220.code = 1340
        panda220.duration = 64
        panda220.period = PeriodType.GROUP.ordinal
        panda220.isStar = true
        panda220.title = "是顺利收猫的一天。【大熊猫和花、和叶】"
        panda220.releaseTime = "2021-12-19 20:26:20"
        panda220.originalUrl = "https://www.bilibili.com/video/BV1GQ4y1Y7Rd"
        panda220.tags = "大熊猫,萌宠,动物圈"
        panda220.authorName = "隽一一"
        panda220.cover =
            "https://i0.hdslb.com/bfs/archive/df99dc7fd8036c445cee88252514799f69f9dc5b.jpg"
        list.add(panda220)

        val panda221 = PetVideo()
        panda221.type = VideoType.PANDA.ordinal
        panda221.fileName = "panda_group_panda221"
        panda221.code = 1341
        panda221.duration = 110
        panda221.period = PeriodType.GROUP.ordinal
        panda221.isStar = false
        panda221.title = "和花：弟弟，你感动吗？和叶：我不敢（想）动！【大熊猫】"
        panda221.releaseTime = "2021-11-19 13:11:45"
        panda221.originalUrl = "https://www.bilibili.com/video/BV1Th41147JR"
        panda221.tags = "大熊猫,萌宠,动物圈"
        panda221.authorName = "隽一一"
        panda221.cover =
            "https://i1.hdslb.com/bfs/archive/1eea654dce1aca8b48625ca0bc52193870348c86.jpg"
        list.add(panda221)

        val panda222 = PetVideo()
        panda222.type = VideoType.PANDA.ordinal
        panda222.fileName = "panda_group_panda222"
        panda222.code = 1342
        panda222.duration = 45
        panda222.period = PeriodType.GROUP.ordinal
        panda222.isStar = false
        panda222.title = "论女明星的自我修养。。被弟弟扑倒也不忘爬起来卖萌。【大熊猫和花、和叶】"
        panda222.releaseTime = "2021-11-04 17:25:19"
        panda222.originalUrl = "https://www.bilibili.com/video/BV1nQ4y1S7ji"
        panda222.tags = "大熊猫,萌宠,动物圈"
        panda222.authorName = "隽一一"
        panda222.cover =
            "https://i2.hdslb.com/bfs/archive/da45c401924369e6e4243056811385f808015a90.jpg"
        list.add(panda222)

        val panda223 = PetVideo()
        panda223.type = VideoType.PANDA.ordinal
        panda223.fileName = "panda_group_panda223"
        panda223.code = 1343
        panda223.duration = 143
        panda223.period = PeriodType.GROUP.ordinal
        panda223.isStar = true
        panda223.title = "一岁了，熊生顺遂，健康平安！～花叶生日会！【大熊猫和花、和叶】"
        panda223.releaseTime = "2021-07-04 18:05:14"
        panda223.originalUrl = "https://www.bilibili.com/video/BV1K54y1p7u9"
        panda223.tags = "大熊猫,萌宠,动物圈"
        panda223.authorName = "隽一一"
        panda223.cover =
            "https://i1.hdslb.com/bfs/archive/35989c83b060f88ac49ecb8b11f13175946f1806.jpg"
        list.add(panda223)

        val panda224 = PetVideo()
        panda224.type = VideoType.PANDA.ordinal
        panda224.fileName = "panda_group_panda224"
        panda224.code = 1344
        panda224.duration = 82
        panda224.period = PeriodType.GROUP.ordinal
        panda224.isStar = false
        panda224.title = "您有一万吨柠檬，请查收。。花叶生日会【大熊猫和花、和叶】"
        panda224.releaseTime = "2021-07-05 18:04:04"
        panda224.originalUrl = "https://www.bilibili.com/video/BV1Zy4y1M7r7"
        panda224.tags = "大熊猫,萌宠,动物圈"
        panda224.authorName = "隽一一"
        panda224.cover =
            "https://i2.hdslb.com/bfs/archive/f9ecc681e6056dfbeea8b74bc942a566a374d85f.jpg"
        list.add(panda224)

        val panda225 = PetVideo()
        panda225.type = VideoType.PANDA.ordinal
        panda225.fileName = "panda_group_panda225"
        panda225.code = 1345
        panda225.duration = 52
        panda225.period = PeriodType.GROUP.ordinal
        panda225.isStar = false
        panda225.title = "叶子：姐，我教你倒栽葱。胖花：好，看我的。【大熊猫和花、和叶】"
        panda225.releaseTime = "2021-09-15 21:33:08"
        panda225.originalUrl = "https://www.bilibili.com/video/BV1RL411x7j2"
        panda225.tags = "大熊猫,萌宠,动物圈"
        panda225.authorName = "隽一一"
        panda225.cover =
            "https://i0.hdslb.com/bfs/archive/6e94d374d918ce14ceb1f625d7d45fdc240f4ff1.jpg"
        list.add(panda225)

        val panda226 = PetVideo()
        panda226.type = VideoType.PANDA.ordinal
        panda226.fileName = "panda_group_panda226"
        panda226.code = 1346
        panda226.duration = 22
        panda226.period = PeriodType.GROUP.ordinal
        panda226.isStar = false
        panda226.title = "认真玩倒立的和花被跑过来的小熊友吓出了狗叫声"
        panda226.releaseTime = "2021-12-22 16:38:35"
        panda226.originalUrl = "https://www.bilibili.com/video/BV1GZ4y1D7Xr"
        panda226.tags = "大熊猫,萌宠,动物圈"
        panda226.authorName = "胖哒哒不月半"
        panda226.cover =
            "https://i1.hdslb.com/bfs/archive/c3eca6f6c98a70582a7187bcd1322358c5394374.jpg"
        list.add(panda226)

        val panda227 = PetVideo()
        panda227.type = VideoType.PANDA.ordinal
        panda227.fileName = "panda_group_panda227"
        panda227.code = 1347
        panda227.duration = 106
        panda227.period = PeriodType.GROUP.ordinal
        panda227.isStar = false
        panda227.title = "艾玖:活花，你不要过来呀！！我不带崽！(ー_ー)!!【大熊猫和花】【大熊猫艾玖】"
        panda227.releaseTime = "2021-12-19 09:30:00"
        panda227.originalUrl = "https://www.bilibili.com/video/BV1JQ4y1Y73F"
        panda227.tags = "大熊猫,萌宠,动物圈"
        panda227.authorName = "安娜丽丝k"
        panda227.cover =
            "https://i1.hdslb.com/bfs/archive/2c5dc59730e75ddd6b13a1f6c2b9d3a23ab69c8f.png"
        list.add(panda227)

        val panda228 = PetVideo()
        panda228.type = VideoType.PANDA.ordinal
        panda228.fileName = "panda_group_panda228"
        panda228.code = 1348
        panda228.duration = 83
        panda228.period = PeriodType.GROUP.ordinal
        panda228.isStar = false
        panda228.title = "爷爷：“火花，果赖，回来了”，花花：“爷爷喃？我要回去找爷爷。” ~1.3爷爷收和花【大熊猫】"
        panda228.releaseTime = "2022-01-03 19:38:10"
        panda228.originalUrl = "https://www.bilibili.com/video/BV1qL411V7VD"
        panda228.tags = "大熊猫,萌宠,动物圈"
        panda228.authorName = "隽一一"
        panda228.cover =
            "https://i0.hdslb.com/bfs/archive/8bcb68694a4d6561f66a8de3f60a60be8c228ef9.jpg"
        list.add(panda228)

        val panda229 = PetVideo()
        panda229.type = VideoType.PANDA.ordinal
        panda229.fileName = "panda_group_panda229"
        panda229.code = 1349
        panda229.duration = 62
        panda229.period = PeriodType.GROUP.ordinal
        panda229.isStar = false
        panda229.title = "快来康康，小猪们跟着谭爷爷出门啦!"
        panda229.releaseTime = "2019-11-17 18:05:12"
        panda229.originalUrl = "https://www.bilibili.com/video/BV14J411U7de"
        panda229.tags = "大熊猫,萌宠,动物圈"
        panda229.authorName = "pandapia熊猫乌托邦"
        panda229.cover =
            "https://i2.hdslb.com/bfs/archive/ac88c05ec152940a35c593d8a0908449bc079987.jpg"
        list.add(panda229)

        val panda230 = PetVideo()
        panda230.type = VideoType.PANDA.ordinal
        panda230.fileName = "panda_group_panda230"
        panda230.code = 1350
        panda230.duration = 52
        panda230.period = PeriodType.GROUP.ordinal
        panda230.isStar = false
        panda230.title = "花花：哪里跌倒就从哪里再战，还是不行那就换个目标【和花艾玖重阳金双】"
        panda230.releaseTime = "2021-08-10 15:56:44"
        panda230.originalUrl = "https://www.bilibili.com/video/BV1q3411r7Pe"
        panda230.tags = "大熊猫,萌宠,动物圈"
        panda230.authorName = "迩後咩"
        panda230.cover =
            "https://i2.hdslb.com/bfs/archive/c8fc6f67f0ef77814341b78822b029ddd9776f03.jpg"
        list.add(panda230)

        val panda231 = PetVideo()
        panda231.type = VideoType.PANDA.ordinal
        panda231.fileName = "panda_group_panda231"
        panda231.code = 1351
        panda231.duration = 61
        panda231.period = PeriodType.GROUP.ordinal
        panda231.isStar = false
        panda231.title = "有些岁月静好，是因为有最亲近的人相依相伴。【大熊猫和花、和叶】"
        panda231.releaseTime = "2022-01-06 23:10:39"
        panda231.originalUrl = "https://www.bilibili.com/video/BV1h44y1j74a"
        panda231.tags = "大熊猫,萌宠,动物圈"
        panda231.authorName = "隽一一"
        panda231.cover =
            "https://i1.hdslb.com/bfs/archive/ea227e7c9c9aa54acb2ce6a84bce7a7a11c69944.jpg"
        list.add(panda231)

        val panda232 = PetVideo()
        panda232.type = VideoType.PANDA.ordinal
        panda232.fileName = "panda_group_panda232"
        panda232.code = 1352
        panda232.duration = 184
        panda232.period = PeriodType.GROUP.ordinal
        panda232.isStar = false
        panda232.title = "花花能有什么小心思呢"
        panda232.releaseTime = "2022-01-07 13:17:43"
        panda232.originalUrl = "https://www.bilibili.com/video/BV1ZR4y1u7qd"
        panda232.tags = "大熊猫,萌宠,动物圈"
        panda232.authorName = "开饭了大熊猫V"
        panda232.cover =
            "https://i1.hdslb.com/bfs/archive/b62231161e1b6afd3960e4e4fbfa82cc5e30ada0.jpg"
        list.add(panda232)

        val panda233 = PetVideo()
        panda233.type = VideoType.PANDA.ordinal
        panda233.fileName = "panda_group_panda233"
        panda233.code = 1353
        panda233.duration = 52
        panda233.period = PeriodType.GROUP.ordinal
        panda233.isStar = false
        panda233.title = "奶妈用苹果引玖菜花出兽舍。【大熊猫和花、艾玖、润玥】"
        panda233.releaseTime = "2021-12-10 16:29:34"
        panda233.originalUrl = "https://www.bilibili.com/video/BV1Ti4y1Z7q8"
        panda233.tags = "大熊猫,萌宠,动物圈"
        panda233.authorName = "隽一一"
        panda233.cover =
            "https://i1.hdslb.com/bfs/archive/316cb7043841cd699611b94ed52642e97c0c12c7.jpg"
        list.add(panda233)

        val panda234 = PetVideo()
        panda234.type = VideoType.PANDA.ordinal
        panda234.fileName = "panda_group_panda234"
        panda234.code = 1354
        panda234.duration = 122
        panda234.period = PeriodType.GROUP.ordinal
        panda234.isStar = false
        panda234.title = "爷爷一直在喊“火花”，主任自顾自宠粉卖萌。【大熊猫和花】"
        panda234.releaseTime = "2022-01-05 18:58:39"
        panda234.originalUrl = "https://www.bilibili.com/video/BV1dr4y1m7PG"
        panda234.tags = "大熊猫,萌宠,动物圈"
        panda234.authorName = "隽一一"
        panda234.cover =
            "https://i1.hdslb.com/bfs/archive/1cdc5af7c74065190dff7d34671a2f18f0089326.jpg"
        list.add(panda234)

        val panda235 = PetVideo()
        panda235.type = VideoType.PANDA.ordinal
        panda235.fileName = "panda_group_panda235"
        panda235.code = 1355
        panda235.duration = 54
        panda235.period = PeriodType.GROUP.ordinal
        panda235.isStar = false
        panda235.title = "【和花】在小卖部门口挠耳朵的花花太可爱了"
        panda235.releaseTime = "2022-01-07 19:56:28"
        panda235.originalUrl = "https://www.bilibili.com/video/BV1QL411V71v"
        panda235.tags = "大熊猫,萌宠,动物圈"
        panda235.authorName = "胖哒哒不月半"
        panda235.cover =
            "https://i0.hdslb.com/bfs/archive/3f87e836bcad14617cbfdfc7cfa6d71eaf2d99c2.jpg"
        list.add(panda235)

        val panda236 = PetVideo()
        panda236.type = VideoType.PANDA.ordinal
        panda236.fileName = "panda_group_panda236"
        panda236.code = 1377
        panda236.duration = 34
        panda236.period = PeriodType.GROUP.ordinal
        panda236.isStar = false
        panda236.title = "大熊猫和花-跟着爷爷有果果吃"
        panda236.releaseTime = "2022-02-13 18:03:34"
        panda236.originalUrl = "https://www.bilibili.com/video/BV1NR4y1L7Pw"
        panda236.tags = "大熊猫,萌宠,动物圈"
        panda236.authorName = "和和和花花"
        panda236.cover =
            "https://i2.hdslb.com/bfs/archive/06f554a409f045f99782d268cada112190b55d29.jpg"
        list.add(panda236)

        val panda237 = PetVideo()
        panda237.type = VideoType.PANDA.ordinal
        panda237.fileName = "panda_group_panda237"
        panda237.code = 1378
        panda237.duration = 63
        panda237.period = PeriodType.GROUP.ordinal
        panda237.isStar = false
        panda237.title = "和花的啃树吃草基地"
        panda237.releaseTime = "2022-02-13 17:07:42"
        panda237.originalUrl = "https://www.bilibili.com/video/BV1UY411V7MV"
        panda237.tags = "大熊猫,萌宠,动物圈"
        panda237.authorName = "迩後咩"
        panda237.cover =
            "https://i2.hdslb.com/bfs/archive/8ddaae01d4950df1fb1379e8873ac19bd9ed4eb3.jpg"
        list.add(panda237)

        val panda238 = PetVideo()
        panda238.type = VideoType.PANDA.ordinal
        panda238.fileName = "panda_group_panda238"
        panda238.code = 1379
        panda238.duration = 9
        panda238.period = PeriodType.GROUP.ordinal
        panda238.isStar = false
        panda238.title = "熊猫喜欢贴贴的原因找到了"
        panda238.releaseTime = "2022-02-13 12:35:18"
        panda238.originalUrl = "https://www.bilibili.com/video/BV1nY411L7Q5"
        panda238.tags = "大熊猫,萌宠,动物圈"
        panda238.authorName = "开饭了大熊猫V"
        panda238.cover =
            "https://i1.hdslb.com/bfs/archive/0af07d3a072f1538751c16426ab9696a14dcf567.jpg"
        list.add(panda238)

        val panda239 = PetVideo()
        panda239.type = VideoType.PANDA.ordinal
        panda239.fileName = "panda_group_panda239"
        panda239.code = 1380
        panda239.duration = 31
        panda239.period = PeriodType.GROUP.ordinal
        panda239.isStar = false
        panda239.title = "冰墩墩和花花"
        panda239.releaseTime = "2022-02-10 11:19:25"
        panda239.originalUrl = "https://www.bilibili.com/video/BV14F411n7pj"
        panda239.tags = "大熊猫,萌宠,动物圈"
        panda239.authorName = "小嗷嗷妹妹"
        panda239.cover =
            "https://i2.hdslb.com/bfs/archive/b67e9ea3480988c5ebb2b47ef79c5c4f4e3cd3b7.jpg"
        list.add(panda239)

        val panda240 = PetVideo()
        panda240.type = VideoType.PANDA.ordinal
        panda240.fileName = "panda_group_panda240"
        panda240.code = 1381
        panda240.duration = 496
        panda240.period = PeriodType.GROUP.ordinal
        panda240.isStar = false
        panda240.title = "【大熊猫和花 和叶 润玥】花花对着镜头，展示学习成果"
        panda240.releaseTime = "2022-01-20 16:15:33"
        panda240.originalUrl = "https://www.bilibili.com/video/BV13f4y1F7HK"
        panda240.tags = "大熊猫,萌宠,动物圈"
        panda240.authorName = "瑞壑"
        panda240.cover =
            "https://i2.hdslb.com/bfs/archive/3e2c227f0ce784b7059101ceae4462cd5e34e121.jpg"
        list.add(panda240)


        return list
    }
}