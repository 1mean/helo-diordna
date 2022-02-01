import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.bean.pet.PetType
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2022/1/8 3:27 下午
 * @version: v1.0
 */
object PandaGroupData {

    private val list = mutableListOf<PetVideo>()

    fun getData():MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
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
        panda2.type = PetType.PANDA.ordinal
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
        panda3.type = PetType.PANDA.ordinal
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
        panda4.type = PetType.PANDA.ordinal
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
        panda5.type = PetType.PANDA.ordinal
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
        panda6.type = PetType.PANDA.ordinal
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
        panda7.type = PetType.PANDA.ordinal
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
        panda8.type = PetType.PANDA.ordinal
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
        panda9.type = PetType.PANDA.ordinal
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
        panda10.type = PetType.PANDA.ordinal
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
        panda11.type = PetType.PANDA.ordinal
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
        panda12.type = PetType.PANDA.ordinal
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
        panda13.type = PetType.PANDA.ordinal
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
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_group_panda14"
        panda14.code = 70
        panda14.duration = 113
        panda14.period = PeriodType.GROUP.ordinal
        panda14.title = "【大熊猫和花】任凭爷爷呼喊依然慢吞吞的花花"
        panda14.releaseTime = "2022-01-05 01:17:44"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1Fm4y1D7je?share_source=copy_web"
        panda14.tags = "萌宠,和花,动物,熊猫"
        panda14.authorName = "胖哒哒不月半"
        panda14.cover =
            "https://i1.hdslb.com/bfs/archive/6659f4f5221f6d004c015ce5d44e9788957decb5.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_group_panda15"
        panda15.code = 71
        panda15.duration = 133
        panda15.period = PeriodType.GROUP.ordinal
        panda15.title = "和花现在不仅跑得快，还会“急刹”"
        panda15.releaseTime = "2022-01-04 23:08:40"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1qD4y1F7Rd?share_source=copy_web"
        panda15.tags = "大熊猫和花、和叶、艾玖、润玥"
        panda15.authorName = "胖哒哒不月半"
        panda15.cover =
            "https://i0.hdslb.com/bfs/archive/6c8a7b2c45bd204a1f2698e9ff88439f902f7ba0.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
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
        panda16.cover = "https://i2.hdslb.com/bfs/archive/310d407ea7a93e5cd90ffa41da847dc607e1eeca.jpg"
        list.add(panda16)

        return list
    }
}