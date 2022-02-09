import com.example.pandas.bean.pet.PetType
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

        getRecoBanner()
        getBannerData()
        getFoxData()
        getPandaKnowledge()
        getLandScapeData()
        getPenguinData()
        getBearData()
        return list
    }

    private fun getRecoBanner(): MutableList<PetVideo> {

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "video_banner1"
        panda4.code = 423
        panda4.duration = 61
        panda4.period = PeriodType.BABY.ordinal
        panda4.videoType = 1
        panda4.title = "毛茸茸的小可爱谁不想拥有一只"
        panda4.releaseTime = "2021-12-27 19:00:12"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1bL4y1E7L8"
        panda4.tags = "熊猫,冰雪"
        panda4.authorName = "北京2022年冬奥会"
        panda4.cover =
            "https://i1.hdslb.com/bfs/archive/8c551b4ec8aad66ddafc523dbef16b180b85d27d.jpg"
        list.add(panda4)

        val panda3 = PetVideo()
        panda3.type = PetType.CHINA.ordinal
        panda3.fileName = "video_banner2"
        panda3.code = 424
        panda3.duration = 59
        panda3.videoType = 1
        panda3.title = "今天，雪中的橘子洲头"
        panda3.releaseTime = "2021-12-26 22:52:52"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1v3411v7Hi"
        panda3.tags = "中国,湖南,橘子洲头,雪"
        panda3.authorName = "中国青年报"
        panda3.cover =
            "https://i2.hdslb.com/bfs/archive/96ab6c6fc7474a67de916c75397161fcc9297095.jpg"
        list.add(panda3)

        val panda1 = PetVideo()
        panda1.type = PetType.PENGUIN.ordinal
        panda1.fileName = "video_banner3"
        panda1.code = 425
        panda1.duration = 58
        panda1.period = PeriodType.BABY.ordinal
        panda1.videoType = 1
        panda1.title = "揣进毛茸茸的小裤兜"
        panda1.releaseTime = "2021-09-27 12:10:17"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1iQ4y1z7RK"
        panda1.tags = "企鹅"
        panda1.authorName = "冻冻sama"
        panda1.cover =
            "https://i2.hdslb.com/bfs/archive/a27db041ca7af069e12ead43c35e11a45a44bb86.jpg"
        list.add(panda1)


        val panda2 = PetVideo()
        panda2.type = PetType.HUMAN.ordinal
        panda2.fileName = "video_banner4"
        panda2.code = 426
        panda2.duration = 62
        panda2.videoType = 1
        panda2.title = "飞天的四月，无人机视角"
        panda2.releaseTime = "2021-12-01 13:19:42"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1v44y1h7jw"
        panda2.tags = "四月,飞天"
        panda2.authorName = "摄影师黄永强"
        panda2.cover =
            "https://i0.hdslb.com/bfs/archive/21dc90239bd1e237ef080604e7295dc9a59088be.jpg"
        list.add(panda2)

        return list
    }

    private fun getBannerData(): MutableList<PetVideo> {

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
            "https://i0.hdslb.com/bfs/archive/7643dcb1726a5ec7b0f446edc015b5f7042476bf.jpg"
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
            "https://i1.hdslb.com/bfs/archive/30b259a24c170e6e27d9eeb315cce28345cec181.jpg"
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
            "https://i2.hdslb.com/bfs/archive/b391bf0f6672ecfc749ed1c665a41848a79f1ecb.jpg"
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
            "https://i0.hdslb.com/bfs/archive/8f526c9802ddc0bdc52b514751a984fe0a68633e.jpg"
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
            "https://i2.hdslb.com/bfs/archive/b6d08e30536827c139ee059e8f165ccb732a2aed.jpg"
        panda1.videoType = 3
        list.add(panda1)

        return list
    }

    private fun getFoxData(): MutableList<PetVideo> {

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
            "https://i0.hdslb.com/bfs/archive/234ca476f500eaeb386e6ba95d32277a4a7df60b.jpg"
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
            "https://i2.hdslb.com/bfs/archive/0215a036e2d26af6b9e0f13e92556db4be0ded93.jpg"
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
            "https://i1.hdslb.com/bfs/archive/ab79a89823f227574f663269a6e86667cb8b7510.jpg"
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
            "https://i1.hdslb.com/bfs/archive/30b259a24c170e6e27d9eeb315cce28345cec181.jpg"
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
            "https://i1.hdslb.com/bfs/archive/1b869e4b839145968304aeafb64042c219058fbf.png"
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
            "https://i0.hdslb.com/bfs/archive/c917011116fbe1dda527e580532b639514c47899.jpg"
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
            "https://i0.hdslb.com/bfs/archive/ec7d418f4165f5175a159285d4f5d5339eb851b7.jpg"
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
            "https://i0.hdslb.com/bfs/archive/85dcd1eb4c32ea12d64e7a8db4b42a58743151fd.jpg"
        panda8.videoType = 0
        list.add(panda8)

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
            "https://i0.hdslb.com/bfs/archive/cbad79065d7fded5a3d296fe2dfa0eff44a54f1e.jpg"
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
            "https://i0.hdslb.com/bfs/archive/213435510f2714c4e42323a2ae1111e9e7a27898.jpg"
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
            "https://i0.hdslb.com/bfs/archive/f211ff7de227f7fcee9aa997cd15bf783f7a9942.jpg"
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
            "https://i2.hdslb.com/bfs/archive/ee69b6c14b97fd00c65faeb392eacacb94906cd9.jpg"
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
            "https://i1.hdslb.com/bfs/archive/af90279722702e740d77d1c6b071ae594750d539.jpg"
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
            "https://i2.hdslb.com/bfs/archive/3fe6af2b710b04daf5ed2f1b3fdf7c172da8218e.jpg"
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
            "https://i2.hdslb.com/bfs/archive/773d0f3854e3dc28604649b26e83e1acae6e1e4a.jpg"
        panda16.videoType = 0
        list.add(panda16)

        val panda18 = PetVideo()
        panda18.type = PetType.FOX.ordinal
        panda18.fileName = "pet_fox17"
        panda18.code = 448
        panda18.duration = 136
        panda18.period = PeriodType.SINGLE.ordinal
        panda18.isStar = true
        panda18.title = "传说中狡猾的狐狸——赤狐，居然会如此安静！"
        panda18.releaseTime = "2021-10-08 19:48:09"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1JQ4y1B7qv"
        panda18.tags = "狐,萌宠,动物圈"
        panda18.authorName = "探纪自然"
        panda18.cover =
            "https://i0.hdslb.com/bfs/archive/4f106ec17ba2902005fd0192ee8ac7cf8c5c408b.jpg"
        panda18.videoType = 0
        list.add(panda18)

        val fox19 = PetVideo()
        fox19.type = PetType.FOX.ordinal
        fox19.fileName = "pet_fox19"
        fox19.code = 1063
        fox19.duration = 23
        fox19.period = PeriodType.SINGLE.ordinal
        fox19.isStar = true
        fox19.title = "【狐狸】你获得纣王体验卡一张"
        fox19.releaseTime = "2022-02-05 13:00:31"
        fox19.originalUrl = "https://www.bilibili.com/video/BV1Nb4y177Aw"
        fox19.tags = "狐狸,萌宠,动物圈"
        fox19.authorName = "探纪自然"
        fox19.cover =
            "https://i1.hdslb.com/bfs/archive/0561694384bc44f60a74ed0eddcc05405343c3e0.jpg"
        fox19.videoType = 0
        list.add(fox19)

        val fox20 = PetVideo()
        fox20.type = PetType.FOX.ordinal
        fox20.fileName = "pet_fox20"
        fox20.code = 1064
        fox20.duration = 31
        fox20.period = PeriodType.SINGLE.ordinal
        fox20.isStar = true
        fox20.title = "大雪中趴窝休息的暖暖狐 ©itseriksen"
        fox20.releaseTime = "2022-02-03 18:22:57"
        fox20.originalUrl = "https://www.bilibili.com/video/BV1d44y1p74N"
        fox20.tags = "狐狸,萌宠,动物圈"
        fox20.authorName = "狐狸社社长乱狐"
        fox20.cover =
            "https://i1.hdslb.com/bfs/archive/f0ca6ad1e049ab3cab66005b3e848527e8d1c4bf.jpg"
        fox20.videoType = 0
        list.add(fox20)

        val fox21 = PetVideo()
        fox21.type = PetType.FOX.ordinal
        fox21.fileName = "pet_fox21"
        fox21.code = 1065
        fox21.duration = 27
        fox21.period = PeriodType.SINGLE.ordinal
        fox21.isStar = true
        fox21.title = "【赤狐】狐狸躺在地上吵架"
        fox21.releaseTime = "2021-12-31 12:14:01"
        fox21.originalUrl = "https://www.bilibili.com/video/BV1Yr4y1m7hF"
        fox21.tags = "狐狸,萌宠,动物圈"
        fox21.authorName = "天天的茶叶"
        fox21.cover =
            "https://i1.hdslb.com/bfs/archive/a050797a51e46f34254ad7860746f07a99338fb9.jpg"
        fox21.videoType = 0
        list.add(fox21)

        val fox22 = PetVideo()
        fox22.type = PetType.FOX.ordinal
        fox22.fileName = "pet_fox22"
        fox22.code = 1066
        fox22.duration = 53
        fox22.period = PeriodType.SINGLE.ordinal
        fox22.isStar = true
        fox22.title = "【赤狐】带个对象回家看饲养员"
        fox22.releaseTime = "2022-01-30 23:39:29"
        fox22.originalUrl = "https://www.bilibili.com/video/BV1oS4y1y7bo"
        fox22.tags = "狐狸,萌宠,动物圈"
        fox22.authorName = "天天的茶叶"
        fox22.cover =
            "https://i1.hdslb.com/bfs/archive/2d87e6fc2e9b02aace8c7b392b31d0567d1dcfa5.jpg"
        fox22.videoType = 0
        list.add(fox22)

        val fox23 = PetVideo()
        fox23.type = PetType.FOX.ordinal
        fox23.fileName = "pet_fox23"
        fox23.code = 1067
        fox23.duration = 217
        fox23.period = PeriodType.SINGLE.ordinal
        fox23.isStar = true
        fox23.title = "【狐狸村】茶狐.茶色白金狐小合集"
        fox23.releaseTime = "2022-01-05 00:58:54"
        fox23.originalUrl = "https://www.bilibili.com/video/BV17a411z77N"
        fox23.tags = "狐狸,萌宠,动物圈"
        fox23.authorName = "狐狸社社长乱狐"
        fox23.cover =
            "https://i0.hdslb.com/bfs/archive/d45ea8c0410af997ec4f82200bc65df35b9f63da.jpg"
        fox23.videoType = 0
        list.add(fox23)

        val fox24 = PetVideo()
        fox24.type = PetType.FOX.ordinal
        fox24.fileName = "pet_fox24"
        fox24.code = 1068
        fox24.duration = 21
        fox24.period = PeriodType.SINGLE.ordinal
        fox24.isStar = true
        fox24.title = "狐狐试图舔掉自己的糖霜 ©itseriksen"
        fox24.releaseTime = "2022-02-01 14:48:14"
        fox24.originalUrl = "https://www.bilibili.com/video/BV1hr4y1Y7T5"
        fox24.tags = "狐狸,萌宠,动物圈"
        fox24.authorName = "狐狸社社长乱狐"
        fox24.cover =
            "https://i0.hdslb.com/bfs/archive/e3fc7dc0deb9ffe001550e765e406e78f3b8d9e9.jpg"
        fox24.videoType = 0
        list.add(fox24)

        val fox25 = PetVideo()
        fox25.type = PetType.FOX.ordinal
        fox25.fileName = "pet_fox25"
        fox25.code = 1069
        fox25.duration = 58
        fox25.period = PeriodType.SINGLE.ordinal
        fox25.isStar = true
        fox25.title = "和小盆友van耍的小狐狸"
        fox25.releaseTime = "2020-01-26 18:51:49"
        fox25.originalUrl = "https://www.bilibili.com/video/BV1B7411k7b9"
        fox25.tags = "狐狸,萌宠,动物圈"
        fox25.authorName = "冰糖雪狸不是梨"
        fox25.cover =
            "https://i2.hdslb.com/bfs/archive/23247b14bda1eec534bf84a2a48967a4857b556c.jpg"
        fox25.videoType = 0
        list.add(fox25)

        val fox26 = PetVideo()
        fox26.type = PetType.FOX.ordinal
        fox26.fileName = "pet_fox26"
        fox26.code = 1070
        fox26.duration = 208
        fox26.period = PeriodType.SINGLE.ordinal
        fox26.isStar = true
        fox26.title = "近日的Alisa和阿奇"
        fox26.releaseTime = "2021-02-27 16:09:01"
        fox26.originalUrl = "https://www.bilibili.com/video/BV1CZ4y1A79n"
        fox26.tags = "狐狸,萌宠,动物圈"
        fox26.authorName = "冰糖雪狸不是梨"
        fox26.cover =
            "https://i1.hdslb.com/bfs/archive/0ecd5b106b703eb85007cdcee379e07094543648.jpg"
        fox26.videoType = 0
        list.add(fox26)

        val fox27 = PetVideo()
        fox27.type = PetType.FOX.ordinal
        fox27.fileName = "pet_fox27"
        fox27.code = 1071
        fox27.duration = 17
        fox27.period = PeriodType.SINGLE.ordinal
        fox27.isStar = true
        fox27.title = "【赤狐】总之就是很委屈的狐狸（1）"
        fox27.releaseTime = "2021-12-26 20:28:03"
        fox27.originalUrl = "https://www.bilibili.com/video/BV1hb4y1v7RF"
        fox27.tags = "狐狸,萌宠,动物圈"
        fox27.authorName = "天天的茶叶"
        fox27.cover =
            "https://i2.hdslb.com/bfs/archive/8ce5c0d27e0a2895bb1a51cb756272c1c91b4a4d.jpg"
        fox27.videoType = 0
        list.add(fox27)

        val fox28 = PetVideo()
        fox28.type = PetType.FOX.ordinal
        fox28.fileName = "pet_fox28"
        fox28.code = 1072
        fox28.duration = 115
        fox28.period = PeriodType.SINGLE.ordinal
        fox28.isStar = true
        fox28.title = "晚安北极狐zzzZZZ"
        fox28.releaseTime = "2022-01-13 03:39:38"
        fox28.originalUrl = "https://www.bilibili.com/video/BV1Xm4y1D7Vu"
        fox28.tags = "狐狸,萌宠,动物圈"
        fox28.authorName = "狐狸社社长乱狐"
        fox28.cover =
            "https://i1.hdslb.com/bfs/archive/ea1b01b378f551f5f926044e5a3c882b51fd5c39.jpg"
        fox28.videoType = 0
        list.add(fox28)

        val fox29 = PetVideo()
        fox29.type = PetType.FOX.ordinal
        fox29.fileName = "pet_fox29"
        fox29.code = 1073
        fox29.duration = 103
        fox29.period = PeriodType.SINGLE.ordinal
        fox29.isStar = true
        fox29.title = "【秋日童话】邂逅武汉大学的小狐狸“珞珞”"
        fox29.releaseTime = "2019-11-06 20:30:55"
        fox29.originalUrl = "https://www.bilibili.com/video/BV1VE411i7gR"
        fox29.tags = "狐狸,萌宠,动物圈"
        fox29.authorName = "Frozen影像"
        fox29.cover =
            "https://i1.hdslb.com/bfs/archive/00b1971c4444fb8492a4da0ab56e5afbd83375a2.jpg"
        fox29.videoType = 0
        list.add(fox29)

        val fox30 = PetVideo()
        fox30.type = PetType.FOX.ordinal
        fox30.fileName = "pet_fox30"
        fox30.code = 1074
        fox30.duration = 277
        fox30.period = PeriodType.SINGLE.ordinal
        fox30.isStar = true
        fox30.title = "【狐狸】旭山动物园的北极狐和赤狐"
        fox30.releaseTime = "2022-01-26 20:02:48"
        fox30.originalUrl = "https://www.bilibili.com/video/BV1JZ4y1Z7LU"
        fox30.tags = "狐狸,萌宠,动物圈"
        fox30.authorName = "狐狸社社长乱狐"
        fox30.cover =
            "https://i2.hdslb.com/bfs/archive/414b1548d68095a3ac57fc284b359f755c454283.jpg"
        fox30.videoType = 0
        list.add(fox30)

        val fox31 = PetVideo()
        fox31.type = PetType.FOX.ordinal
        fox31.fileName = "pet_fox31"
        fox31.code = 1075
        fox31.duration = 48
        fox31.period = PeriodType.SINGLE.ordinal
        fox31.isStar = true
        fox31.title = "小狐狸吵架吵输了"
        fox31.releaseTime = "2021-11-19 19:39:39"
        fox31.originalUrl = "https://www.bilibili.com/video/BV1Ag411N7nq"
        fox31.tags = "狐狸,萌宠,动物圈"
        fox31.authorName = "七海悠仁"
        fox31.cover =
            "https://i1.hdslb.com/bfs/archive/d616a4b03d571f8b68769ab1c3c9844ac756b56d.jpg"
        fox31.videoType = 0
        list.add(fox31)

        val fox32 = PetVideo()
        fox32.type = PetType.FOX.ordinal
        fox32.fileName = "pet_fox32"
        fox32.code = 1076
        fox32.duration = 21
        fox32.period = PeriodType.SINGLE.ordinal
        fox32.isStar = true
        fox32.title = "北狐牧场 呆呆狐和雪"
        fox32.releaseTime = "2021-12-04 13:36:51"
        fox32.originalUrl = "https://www.bilibili.com/video/BV1qg411A7HZ"
        fox32.tags = "狐狸,萌宠,动物圈"
        fox32.authorName = "天天的茶叶"
        fox32.cover =
            "https://i2.hdslb.com/bfs/archive/5b1931617ffbe0c5e86875b38cc1d79500aa4941.jpg"
        fox32.videoType = 0
        list.add(fox32)

        return list
    }

    private fun getLandScapeData(): MutableList<PetVideo> {

        val landscape25 = PetVideo()
        landscape25.type = PetType.LANDSCAPE.ordinal
        landscape25.fileName = "landscape_25"
        landscape25.code = 471
        landscape25.duration = 235
        landscape25.isStar = true
        landscape25.title = "我于人间，赏山河，踏风雪"
        landscape25.releaseTime = "2021-12-28 23:35:01"
        landscape25.originalUrl = "https://www.bilibili.com/video/BV1j3411v7pc"
        landscape25.tags = "山水,风景"
        landscape25.authorName = "被生活治愈的小人物"
        landscape25.cover =
            "https://i1.hdslb.com/bfs/archive/022e4b497e5834502daf5f3d117ffefe3345b680.jpg"
        landscape25.videoType = 1
        list.add(landscape25)

        val landscape22 = PetVideo()
        landscape22.type = PetType.LANDSCAPE.ordinal
        landscape22.fileName = "landscape_22"
        landscape22.code = 474
        landscape22.duration = 64
        landscape22.isStar = true
        landscape22.title = "紫禁城的大寒瑞雪 和故宫一起冰雪过大年！"
        landscape22.releaseTime = "2022-01-20 14:57:09"
        landscape22.originalUrl = "https://www.bilibili.com/video/BV1yL4y14718"
        landscape22.tags = "山水,风景"
        landscape22.authorName = "故宫博物院"
        landscape22.cover =
            "https://i0.hdslb.com/bfs/archive/12f804f213b250289c5954a71fefa0596ff88725.jpg"
        landscape22.videoType = 1
        list.add(landscape22)

        val landscape42 = PetVideo()
        landscape42.type = PetType.LANDSCAPE.ordinal
        landscape42.fileName = "landscape_42"
        landscape42.code = 475
        landscape42.duration = 88
        landscape42.isStar = true
        landscape42.title = "“檐上三寸雪   人间惊鸿客”"
        landscape42.releaseTime = "2022-01-05 18:07:29"
        landscape42.originalUrl = "https://www.bilibili.com/video/BV1P34y167B9"
        landscape42.tags = "山水,风景"
        landscape42.authorName = "唐唐和唐"
        landscape42.cover =
            "https://i1.hdslb.com/bfs/archive/25986a6f2f742fa145be75df46469af4d547f30d.jpg"
        landscape42.videoType = 1
        list.add(landscape42)

        val landscape26 = PetVideo()
        landscape26.type = PetType.LANDSCAPE.ordinal
        landscape26.fileName = "landscape_26"
        landscape26.code = 491
        landscape26.duration = 237
        landscape26.isStar = true
        landscape26.title = "“忽有故人心上过，回首山河已入冬。两处相思同淋雪，此生也算共白头。”"
        landscape26.releaseTime = "2020-11-25 14:26:45"
        landscape26.originalUrl = "https://www.bilibili.com/video/BV13K41137oz"
        landscape26.tags = "山水,风景"
        landscape26.authorName = "知三冬"
        landscape26.cover =
            "https://i2.hdslb.com/bfs/archive/78d0190e621962220f3e9f54be250f7b4f21e82b.jpg"
        landscape26.videoType = 1
        list.add(landscape26)

        val landscape1 = PetVideo()
        landscape1.type = PetType.LANDSCAPE.ordinal
        landscape1.fileName = "landscape_1"
        landscape1.code = 450
        landscape1.duration = 31
        landscape1.isStar = true
        landscape1.title = "灵隐寺雪景｜夜深知雪重，时闻折竹声"
        landscape1.releaseTime = "2022-01-30 21:14:40"
        landscape1.originalUrl = "https://www.bilibili.com/video/BV12b4y1E7zT"
        landscape1.tags = "山水,风景"
        landscape1.authorName = "摄影的小和尚"
        landscape1.cover =
            "https://i2.hdslb.com/bfs/archive/630e71f34f6ed6adbbd7cb7bbbd37bcf15eb8869.jpg"
        landscape1.videoType = 0
        list.add(landscape1)


        val landscape2 = PetVideo()
        landscape2.type = PetType.LANDSCAPE.ordinal
        landscape2.fileName = "landscape_2"
        landscape2.code = 451
        landscape2.duration = 61
        landscape2.isStar = true
        landscape2.title = "【临安·雪】绝美杭州西湖雪景  红衣和雪景最配呀~"
        landscape2.releaseTime = "2019-01-06 01:13:32"
        landscape2.originalUrl = "https://www.bilibili.com/video/BV1At411478b"
        landscape2.tags = "山水,风景"
        landscape2.authorName = "知竹zZ"
        landscape2.cover =
            "https://i0.hdslb.com/bfs/archive/1f85742bbef5669d29849f9af1021f3d306ab83c.jpg"
        landscape2.videoType = 0
        list.add(landscape2)


        val landscape3 = PetVideo()
        landscape3.type = PetType.LANDSCAPE.ordinal
        landscape3.fileName = "landscape_3"
        landscape3.code = 452
        landscape3.duration = 26
        landscape3.isStar = true
        landscape3.title = "航拍雪中的西湖，你可以永远相信杭州的雪景"
        landscape3.releaseTime = "2022-01-30 01:10:43"
        landscape3.originalUrl = "https://www.bilibili.com/video/BV1hq4y1w773"
        landscape3.tags = "山水,风景"
        landscape3.authorName = "张力视觉"
        landscape3.cover =
            "https://i0.hdslb.com/bfs/archive/c8ff8422ee044b208d7722eb5b65898689f8d317.jpg"
        landscape3.videoType = 0
        list.add(landscape3)


        val landscape4 = PetVideo()
        landscape4.type = PetType.LANDSCAPE.ordinal
        landscape4.fileName = "landscape_4"
        landscape4.code = 453
        landscape4.duration = 268
        landscape4.isStar = true
        landscape4.title = "【忆江南】这群老戏骨 把“富春山居图”演活了"
        landscape4.releaseTime = "2022-02-01 14:14:54"
        landscape4.originalUrl = "https://www.bilibili.com/video/BV1RR4y1T7A9"
        landscape4.tags = "山水,风景"
        landscape4.authorName = "央视新闻"
        landscape4.cover =
            "https://i1.hdslb.com/bfs/archive/33a8d3faa30a5c2cc50e01d2b02e12a8842dad0d.jpg"
        landscape4.videoType = 0
        list.add(landscape4)


        val landscape5 = PetVideo()
        landscape5.type = PetType.LANDSCAPE.ordinal
        landscape5.fileName = "landscape_5"
        landscape5.code = 454
        landscape5.duration = 65
        landscape5.isStar = true
        landscape5.title = "2022央视春晚最美节目《只此青绿》沙画版复刻来了！"
        landscape5.releaseTime = "2022-02-02 12:20:59"
        landscape5.originalUrl = "https://www.bilibili.com/video/BV1N3411E7fS"
        landscape5.tags = "山水,风景"
        landscape5.authorName = "央视网"
        landscape5.cover =
            "https://i0.hdslb.com/bfs/archive/aa4911d1ba8c25c5650aeb83d163ea7ec616d73f.jpg"
        landscape5.videoType = 0
        list.add(landscape5)


        val landscape6 = PetVideo()
        landscape6.type = PetType.LANDSCAPE.ordinal
        landscape6.fileName = "landscape_6"
        landscape6.code = 455
        landscape6.duration = 17
        landscape6.isStar = true
        landscape6.title = "滕王阁"
        landscape6.releaseTime = "2021-07-02 18:35:17"
        landscape6.originalUrl = "https://www.bilibili.com/video/BV1sf4y1b7Mb"
        landscape6.tags = "山水,风景"
        landscape6.authorName = "涂文斌"
        landscape6.cover =
            "https://i0.hdslb.com/bfs/archive/842f3c7133fa8c227e6dc1ea5227d16ed5ed2de5.jpg"
        landscape6.videoType = 0
        list.add(landscape6)


        val landscape7 = PetVideo()
        landscape7.type = PetType.LANDSCAPE.ordinal
        landscape7.fileName = "landscape_7"
        landscape7.code = 456
        landscape7.duration = 12
        landscape7.isStar = true
        landscape7.title = "夜晚滕王阁"
        landscape7.releaseTime = "2021-07-04 18:25:00"
        landscape7.originalUrl = "https://www.bilibili.com/video/BV1NV411W73S"
        landscape7.tags = "山水,风景"
        landscape7.authorName = "涂文斌"
        landscape7.cover =
            "https://i1.hdslb.com/bfs/archive/d0b638263e535b7cc699777155da59b505bc0f1f.jpg"
        landscape7.videoType = 0
        list.add(landscape7)


        val landscape8 = PetVideo()
        landscape8.type = PetType.LANDSCAPE.ordinal
        landscape8.fileName = "landscape_8"
        landscape8.code = 457
        landscape8.duration = 89
        landscape8.isStar = true
        landscape8.title = "2022年看见的第一座雪山竟然在苏州？姑苏夜雪，穹窿山一夜白头"
        landscape8.releaseTime = "2022-01-29 19:54:23"
        landscape8.originalUrl = "https://www.bilibili.com/video/BV1UL411F7wo"
        landscape8.tags = "山水,风景"
        landscape8.authorName = "偶尔拍照的johnson"
        landscape8.cover =
            "https://i1.hdslb.com/bfs/archive/082cfced59becd42508e599e24647387f89976bc.jpg"
        landscape8.videoType = 0
        list.add(landscape8)


        val landscape9 = PetVideo()
        landscape9.type = PetType.LANDSCAPE.ordinal
        landscape9.fileName = "landscape_9"
        landscape9.code = 458
        landscape9.duration = 97
        landscape9.isStar = true
        landscape9.title = "最美的雪是一起看过的雪，快看乌镇下雪了，雪花纷纷飘落的时候，恰逢思念最浓"
        landscape9.releaseTime = "2022-01-29 12:57:39"
        landscape9.originalUrl = "https://www.bilibili.com/video/BV11a41117iv"
        landscape9.tags = "山水,风景"
        landscape9.authorName = "乌镇旅游景区"
        landscape9.cover =
            "https://i1.hdslb.com/bfs/archive/09f05026b225c7aa99a9ea44ea1f2ec812435307.jpg"
        landscape9.videoType = 0
        list.add(landscape9)


        val landscape10 = PetVideo()
        landscape10.type = PetType.LANDSCAPE.ordinal
        landscape10.fileName = "landscape_10"
        landscape10.code = 459
        landscape10.duration = 102
        landscape10.isStar = true
        landscape10.title = "九寨沟 诺日朗瀑布"
        landscape10.releaseTime = "2022-01-09 14:47:03"
        landscape10.originalUrl = "https://www.bilibili.com/video/BV1NL411c71K"
        landscape10.tags = "山水,风景"
        landscape10.authorName = "多吉施甸"
        landscape10.cover =
            "https://i1.hdslb.com/bfs/archive/f98e80c061b08e927fdee66e3da453ca6895267d.jpg"
        landscape10.videoType = 0
        list.add(landscape10)


        val landscape11 = PetVideo()
        landscape11.type = PetType.LANDSCAPE.ordinal
        landscape11.fileName = "landscape_11"
        landscape11.code = 460
        landscape11.duration = 364
        landscape11.isStar = true
        landscape11.title = "【4K】襄阳视界：拍摄历时四年，6分钟带你看尽千年古城襄阳"
        landscape11.releaseTime = "2021-12-09 21:09:04"
        landscape11.originalUrl = "https://www.bilibili.com/video/BV1CP4y137zb"
        landscape11.tags = "山水,风景"
        landscape11.authorName = "8KRAW"
        landscape11.cover =
            "https://i1.hdslb.com/bfs/archive/d92ad610376c724a6932b1cc04d2c649de1b0a4e.jpg"
        landscape11.videoType = 0
        list.add(landscape11)


        val landscape12 = PetVideo()
        landscape12.type = PetType.LANDSCAPE.ordinal
        landscape12.fileName = "landscape_12"
        landscape12.code = 461
        landscape12.duration = 235
        landscape12.isStar = true
        landscape12.title = "你好，我是湖北"
        landscape12.releaseTime = "2021-04-12 11:45:05"
        landscape12.originalUrl = "https://www.bilibili.com/video/BV1oK411w7si"
        landscape12.tags = "山水,风景"
        landscape12.authorName = "8KRAW"
        landscape12.cover =
            "https://i0.hdslb.com/bfs/archive/25ea548501010818a4a519fc97bf9a150f2b9d57.jpg"
        landscape12.videoType = 0
        list.add(landscape12)


        val landscape13 = PetVideo()
        landscape13.type = PetType.LANDSCAPE.ordinal
        landscape13.fileName = "landscape_13"
        landscape13.code = 462
        landscape13.duration = 143
        landscape13.isStar = true
        landscape13.title = "谁说大海只能是蓝色，这里是大连庄河红海滩"
        landscape13.releaseTime = "2021-11-18 19:37:29"
        landscape13.originalUrl = "https://www.bilibili.com/video/BV1gr4y1k7Fo"
        landscape13.tags = "山水,风景"
        landscape13.authorName = "8KRAW"
        landscape13.cover =
            "https://i2.hdslb.com/bfs/archive/43d3cdd482bb19e08c4c398bb4cf210239df9dc0.jpg"
        landscape13.videoType = 0
        list.add(landscape13)


        val landscape14 = PetVideo()
        landscape14.type = PetType.LANDSCAPE.ordinal
        landscape14.fileName = "landscape_14"
        landscape14.code = 463
        landscape14.duration = 200
        landscape14.isStar = true
        landscape14.title = "【4K】世界最大的红海滩，在中国"
        landscape14.releaseTime = "2020-10-14 20:35:07"
        landscape14.originalUrl = "https://www.bilibili.com/video/BV1zK4y1h72N"
        landscape14.tags = "山水,风景"
        landscape14.authorName = "8KRAW"
        landscape14.cover =
            "https://i1.hdslb.com/bfs/archive/a0ee37786891c7f4274372b1d8d2dafcbd04303c.jpg"
        landscape14.videoType = 0
        list.add(landscape14)


        val landscape15 = PetVideo()
        landscape15.type = PetType.LANDSCAPE.ordinal
        landscape15.fileName = "landscape_15"
        landscape15.code = 464
        landscape15.duration = 217
        landscape15.isStar = true
        landscape15.title = "禾 木 村 雪 夜【4K•航拍】"
        landscape15.releaseTime = "2021-10-08 14:39:27"
        landscape15.originalUrl = "https://www.bilibili.com/video/BV1hq4y1V76W"
        landscape15.tags = "山水,风景"
        landscape15.authorName = "LukeLiz"
        landscape15.cover =
            "https://i1.hdslb.com/bfs/archive/4f9190e57d0a42af72ef4069895b83b4baa708be.jpg"
        landscape15.videoType = 0
        list.add(landscape15)


        val landscape16 = PetVideo()
        landscape16.type = PetType.LANDSCAPE.ordinal
        landscape16.fileName = "landscape_16"
        landscape16.code = 465
        landscape16.duration = 259
        landscape16.isStar = true
        landscape16.title = "垂枝梅丨美的不可思议"
        landscape16.releaseTime = "2021-03-31 19:00:12"
        landscape16.originalUrl = "https://www.bilibili.com/video/BV1T64y1Q7dd"
        landscape16.tags = "山水,风景"
        landscape16.authorName = "棠圃"
        landscape16.cover =
            "https://i1.hdslb.com/bfs/archive/8e6beb07291e184815de314a5105535f1a3740cd.jpg"
        landscape16.videoType = 0
        list.add(landscape16)


        val landscape17 = PetVideo()
        landscape17.type = PetType.LANDSCAPE.ordinal
        landscape17.fileName = "landscape_17"
        landscape17.code = 466
        landscape17.duration = 221
        landscape17.isStar = true
        landscape17.title = "新疆2021之旅：领略一场冰与火之舞"
        landscape17.releaseTime = "2022-01-05 17:30:11"
        landscape17.originalUrl = "https://www.bilibili.com/video/BV1zu411U7Rn"
        landscape17.tags = "山水,风景"
        landscape17.authorName = "8KRAW"
        landscape17.cover =
            "https://i2.hdslb.com/bfs/archive/82efe75222378076fc327b10fe782190931efdd6.jpg"
        landscape17.videoType = 0
        list.add(landscape17)


        val landscape18 = PetVideo()
        landscape18.type = PetType.LANDSCAPE.ordinal
        landscape18.fileName = "landscape_18"
        landscape18.code = 467
        landscape18.duration = 32
        landscape18.isStar = true
        landscape18.title = "江西武功山日落云海延时摄影记录"
        landscape18.releaseTime = "2019-05-30 12:24:51"
        landscape18.originalUrl = "https://www.bilibili.com/video/BV1E4411H7U5"
        landscape18.tags = "山水,风景"
        landscape18.authorName = "麦子_小邬"
        landscape18.cover =
            "https://i1.hdslb.com/bfs/archive/27563dd484db4fe6e196c3ec868798f5cfa1ce09.jpg"
        landscape18.videoType = 0
        list.add(landscape18)


        val landscape19 = PetVideo()
        landscape19.type = PetType.LANDSCAPE.ordinal
        landscape19.fileName = "landscape_19"
        landscape19.code = 468
        landscape19.duration = 15
        landscape19.isStar = true
        landscape19.title = "2022年武功山的第一个壮观云海"
        landscape19.releaseTime = "2022-01-07 16:29:49"
        landscape19.originalUrl = "https://www.bilibili.com/video/BV1vS4y1T7MG"
        landscape19.tags = "山水,风景"
        landscape19.authorName = "一只爰旅行的胖子"
        landscape19.cover =
            "https://i0.hdslb.com/bfs/archive/5fb5effefb004f5a1084e757c502044e62130e8f.jpg"
        landscape19.videoType = 0
        list.add(landscape19)


        val landscape20 = PetVideo()
        landscape20.type = PetType.LANDSCAPE.ordinal
        landscape20.fileName = "landscape_20"
        landscape20.code = 469
        landscape20.duration = 242
        landscape20.isStar = true
        landscape20.title = "上海城市宣传片（我见过最好的）"
        landscape20.releaseTime = "2018-06-02 13:39:51"
        landscape20.originalUrl = "https://www.bilibili.com/video/BV1uW411N729"
        landscape20.tags = "山水,风景"
        landscape20.authorName = "boboli123456"
        landscape20.cover =
            "https://i1.hdslb.com/bfs/archive/9b896cd9cadf2f8fc93421c3750ca629adf9d223.jpg"
        landscape20.videoType = 0
        list.add(landscape20)


        val landscape21 = PetVideo()
        landscape21.type = PetType.LANDSCAPE.ordinal
        landscape21.fileName = "landscape_21"
        landscape21.code = 470
        landscape21.duration = 27
        landscape21.isStar = true
        landscape21.title = "通向蔚蓝的街道～威海-火炬八街"
        landscape21.releaseTime = "2021-06-05 15:00:06"
        landscape21.originalUrl = "https://www.bilibili.com/video/BV1SU4y1V759"
        landscape21.tags = "山水,风景"
        landscape21.authorName = "小林到处跑_Lin"
        landscape21.cover =
            "https://i1.hdslb.com/bfs/archive/07db953b2f7577664293cd71b652f83a6b7f1ba1.jpg"
        landscape21.videoType = 0
        list.add(landscape21)

        val landscape23 = PetVideo()
        landscape23.type = PetType.LANDSCAPE.ordinal
        landscape23.fileName = "landscape_23"
        landscape23.code = 472
        landscape23.duration = 199
        landscape23.isStar = true
        landscape23.title = "“今日只与先生煮酒赏雪，不谈风月”"
        landscape23.releaseTime = "2020-12-31 12:34:09"
        landscape23.originalUrl = "https://www.bilibili.com/video/BV1Tp4y1B7db"
        landscape23.tags = "山水,风景"
        landscape23.authorName = "知三冬"
        landscape23.cover =
            "https://i1.hdslb.com/bfs/archive/be12ec0f89ed9cbbedf86db64b1398f7e31d1656.jpg"
        landscape23.videoType = 0
        list.add(landscape23)


        val landscape24 = PetVideo()
        landscape24.type = PetType.LANDSCAPE.ordinal
        landscape24.fileName = "landscape_24"
        landscape24.code = 473
        landscape24.duration = 92
        landscape24.isStar = true
        landscape24.title = "【闹元宵| 灯会合集】人间不值得 | 欢快版变奏"
        landscape24.releaseTime = "2021-02-23 20:50:05"
        landscape24.originalUrl = "https://www.bilibili.com/video/BV14y4y1J79R"
        landscape24.tags = "山水,风景"
        landscape24.authorName = "hurricanehits"
        landscape24.cover =
            "https://i1.hdslb.com/bfs/archive/23f3922b92c1482b8fc5405499b978582584a46b.jpg"
        landscape24.videoType = 0
        list.add(landscape24)

        val landscape27 = PetVideo()
        landscape27.type = PetType.LANDSCAPE.ordinal
        landscape27.fileName = "landscape_27"
        landscape27.code = 476
        landscape27.duration = 254
        landscape27.isStar = true
        landscape27.title = "“先去你的塞外，再回我的江南”——《浮光》"
        landscape27.releaseTime = "2021-10-09 22:51:24"
        landscape27.originalUrl = "https://www.bilibili.com/video/BV1HP4y187AZ"
        landscape27.tags = "山水,风景"
        landscape27.authorName = "被生活治愈的小人物"
        landscape27.cover =
            "https://i1.hdslb.com/bfs/archive/17568708ccef774f2ec1b904a0d41f6d196801ca.jpg"
        landscape27.videoType = 0
        list.add(landscape27)


        val landscape28 = PetVideo()
        landscape28.type = PetType.LANDSCAPE.ordinal
        landscape28.fileName = "landscape_28"
        landscape28.code = 477
        landscape28.duration = 161
        landscape28.isStar = true
        landscape28.title = "“忽人间已晚，山河已秋”"
        landscape28.releaseTime = "2021-10-02 13:58:40"
        landscape28.originalUrl = "https://www.bilibili.com/video/BV1FP4y187Rg"
        landscape28.tags = "山水,风景"
        landscape28.authorName = "喵喵君想吃肉蟹煲"
        landscape28.cover =
            "https://i2.hdslb.com/bfs/archive/66cb027e130fb6bc8f96e03b52904af479003d10.jpg"
        landscape28.videoType = 0
        list.add(landscape28)


        val landscape29 = PetVideo()
        landscape29.type = PetType.LANDSCAPE.ordinal
        landscape29.fileName = "landscape_29"
        landscape29.code = 478
        landscape29.duration = 48
        landscape29.isStar = true
        landscape29.title = "阳春三月，邂逅伊犁杏花沟"
        landscape29.releaseTime = "2021-03-19 10:35:29"
        landscape29.originalUrl = "https://www.bilibili.com/video/BV1zX4y137XB"
        landscape29.tags = "山水,风景"
        landscape29.authorName = "一起来旅行吧"
        landscape29.cover =
            "https://i0.hdslb.com/bfs/archive/0e92a6c0a92e24b4973a520cd48a70cb9c3c0372.jpg"
        landscape29.videoType = 0
        list.add(landscape29)


        val landscape30 = PetVideo()
        landscape30.type = PetType.LANDSCAPE.ordinal
        landscape30.fileName = "landscape_30"
        landscape30.code = 479
        landscape30.duration = 145
        landscape30.isStar = true
        landscape30.title = "漫步洱海"
        landscape30.releaseTime = "2021-12-09 20:23:15"
        landscape30.originalUrl = "https://www.bilibili.com/video/BV1sb4y1i7SC"
        landscape30.tags = "山水,风景"
        landscape30.authorName = "肯尼_v"
        landscape30.cover =
            "https://i2.hdslb.com/bfs/archive/c1fde1704142c8924b1985c1a4ed33e369e07bd2.jpg"
        landscape30.videoType = 0
        list.add(landscape30)


        val landscape31 = PetVideo()
        landscape31.type = PetType.LANDSCAPE.ordinal
        landscape31.fileName = "landscape_31"
        landscape31.code = 480
        landscape31.duration = 12
        landscape31.isStar = true
        landscape31.title = "大理洱海，人间仙境"
        landscape31.releaseTime = "2019-10-29 10:54:01"
        landscape31.originalUrl = "https://www.bilibili.com/video/BV1vE411h7yR"
        landscape31.tags = "山水,风景"
        landscape31.authorName = "亮亮亮亮亮阿气"
        landscape31.cover =
            "https://i1.hdslb.com/bfs/archive/b9e127e7b488cd44c5bf1c022c6be69bfa7a594a.jpg"
        landscape31.videoType = 0
        list.add(landscape31)


        val landscape32 = PetVideo()
        landscape32.type = PetType.LANDSCAPE.ordinal
        landscape32.fileName = "landscape_32"
        landscape32.code = 481
        landscape32.duration = 312
        landscape32.isStar = true
        landscape32.title = "云顶天宫：老君山最新航拍【4K版】"
        landscape32.releaseTime = "2020-12-02 14:32:10"
        landscape32.originalUrl = "https://www.bilibili.com/video/BV1ca411F7PU"
        landscape32.tags = "山水,风景"
        landscape32.authorName = "WenPhoto_真实"
        landscape32.cover =
            "https://i1.hdslb.com/bfs/archive/0019038199ed421f1f778d5bb2abdea532ed111c.jpg"
        landscape32.videoType = 0
        list.add(landscape32)


        val landscape33 = PetVideo()
        landscape33.type = PetType.LANDSCAPE.ordinal
        landscape33.fileName = "landscape_33"
        landscape33.code = 482
        landscape33.duration = 179
        landscape33.isStar = true
        landscape33.title = "这，真的是人间吗？老君山【4K】摄影"
        landscape33.releaseTime = "2020-12-09 21:43:30"
        landscape33.originalUrl = "https://www.bilibili.com/video/BV1Dv411b7Ee"
        landscape33.tags = "山水,风景"
        landscape33.authorName = "8KRAW"
        landscape33.cover =
            "https://i2.hdslb.com/bfs/archive/f17b8a7b5a2b086b9ca5f01e9edf634ed1750aba.jpg"
        landscape33.videoType = 0
        list.add(landscape33)


        val landscape34 = PetVideo()
        landscape34.type = PetType.LANDSCAPE.ordinal
        landscape34.fileName = "landscape_34"
        landscape34.code = 483
        landscape34.duration = 24
        landscape34.isStar = true
        landscape34.title = "仙气飘飘，美若天宫，老君山风景区"
        landscape34.releaseTime = "2020-10-14 13:43:21"
        landscape34.originalUrl = "https://www.bilibili.com/video/BV1cp4y1k7En"
        landscape34.tags = "山水,风景"
        landscape34.authorName = "z安予"
        landscape34.cover =
            "https://i2.hdslb.com/bfs/archive/8e5f1b64a88b67cb635b9f3bfae26c379da2bd15.jpg"
        landscape34.videoType = 0
        list.add(landscape34)


        val landscape35 = PetVideo()
        landscape35.type = PetType.LANDSCAPE.ordinal
        landscape35.fileName = "landscape_35"
        landscape35.code = 484
        landscape35.duration = 10
        landscape35.isStar = true
        landscape35.title = "这不是特效！下雪后的庐山，简直就是人间仙境！"
        landscape35.releaseTime = "2018-12-09 11:07:45"
        landscape35.originalUrl = "https://www.bilibili.com/video/BV1dt411i7Vv"
        landscape35.tags = "山水,风景"
        landscape35.authorName = "赫莉乌斯"
        landscape35.cover =
            "https://i0.hdslb.com/bfs/archive/84974a77ef7010b28ddbce88e39a49bafd58cf02.jpg"
        landscape35.videoType = 0
        list.add(landscape35)


        val landscape36 = PetVideo()
        landscape36.type = PetType.LANDSCAPE.ordinal
        landscape36.fileName = "landscape_36"
        landscape36.code = 485
        landscape36.duration = 212
        landscape36.isStar = true
        landscape36.title = "“姑苏城外寒山寺”"
        landscape36.releaseTime = "2021-12-10 21:32:18"
        landscape36.originalUrl = "https://www.bilibili.com/video/BV1WF411z7Wc"
        landscape36.tags = "山水,风景"
        landscape36.authorName = "被生活治愈的小人物"
        landscape36.cover =
            "https://i0.hdslb.com/bfs/archive/b91b1e0ea4907b4877f1244b3a8dfabacb83c6bc.jpg"
        landscape36.videoType = 0
        list.add(landscape36)


        val landscape37 = PetVideo()
        landscape37.type = PetType.LANDSCAPE.ordinal
        landscape37.fileName = "landscape_37"
        landscape37.code = 486
        landscape37.duration = 209
        landscape37.isStar = true
        landscape37.title = "“你是姑苏檐下雨，亦是人间惊鸿客”"
        landscape37.releaseTime = "2021-10-14 13:11:51"
        landscape37.originalUrl = "https://www.bilibili.com/video/BV1Hq4y157Xt"
        landscape37.tags = "山水,风景"
        landscape37.authorName = "张九舟"
        landscape37.cover =
            "https://i2.hdslb.com/bfs/archive/39289415a0cf814525cf92b948ad1e5b8329dcbc.jpg"
        landscape37.videoType = 0
        list.add(landscape37)


        val landscape38 = PetVideo()
        landscape38.type = PetType.LANDSCAPE.ordinal
        landscape38.fileName = "landscape_38"
        landscape38.code = 487
        landscape38.duration = 248
        landscape38.isStar = true
        landscape38.title = "旅行：“见天地，见众生，见自己”"
        landscape38.releaseTime = "2021-08-25 00:37:05"
        landscape38.originalUrl = "https://www.bilibili.com/video/BV1Jf4y1N7Tq"
        landscape38.tags = "山水,风景"
        landscape38.authorName = "知三冬"
        landscape38.cover =
            "https://i1.hdslb.com/bfs/archive/6b7663c1b5ddefa1001d56d5de3e5b7f2615aa85.jpg"
        landscape38.videoType = 0
        list.add(landscape38)


        val landscape39 = PetVideo()
        landscape39.type = PetType.LANDSCAPE.ordinal
        landscape39.fileName = "landscape_39"
        landscape39.code = 488
        landscape39.duration = 227
        landscape39.isStar = true
        landscape39.title = "“一川烟草，满城风絮，梅子黄时雨”"
        landscape39.releaseTime = "2021-04-10 01:28:03"
        landscape39.originalUrl = "https://www.bilibili.com/video/BV1x64y1m7TA"
        landscape39.tags = "山水,风景"
        landscape39.authorName = "知三冬"
        landscape39.cover =
            "https://i1.hdslb.com/bfs/archive/cb30c82effc3fc0ae0c5f6e69a0c228aaba6020f.jpg"
        landscape39.videoType = 0
        list.add(landscape39)

        val landscape40 = PetVideo()
        landscape40.type = PetType.LANDSCAPE.ordinal
        landscape40.fileName = "landscape_40"
        landscape40.code = 489
        landscape40.duration = 236
        landscape40.isStar = true
        landscape40.title = "“小楼一夜听春雨，深巷明朝卖杏花”"
        landscape40.releaseTime = "2021-03-16 20:35:29"
        landscape40.originalUrl = "https://www.bilibili.com/video/BV1CK4y1U7Lc"
        landscape40.tags = "山水,风景"
        landscape40.authorName = "知三冬"
        landscape40.cover =
            "https://i0.hdslb.com/bfs/archive/781091148b8dd9cc1d6ee03359f3a021d81f6f28.jpg"
        landscape40.videoType = 0
        list.add(landscape40)

        val landscape41 = PetVideo()
        landscape41.type = PetType.LANDSCAPE.ordinal
        landscape41.fileName = "landscape_41"
        landscape41.code = 490
        landscape41.duration = 94
        landscape41.isStar = true
        landscape41.title = "梦醒人间看微雨，江山还似旧温柔。"
        landscape41.releaseTime = "2021-09-22 16:11:52"
        landscape41.originalUrl = "https://www.bilibili.com/video/BV1T3411m7EL"
        landscape41.tags = "山水,风景"
        landscape41.authorName = "不问天天天天"
        landscape41.cover =
            "https://i1.hdslb.com/bfs/archive/94d8d885a0fc562d22da3567b2fe9aaca2aaed3d.jpg"
        landscape41.videoType = 0
        list.add(landscape41)

        return list
    }

    private fun getPandaKnowledge(): MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_knowledge1"
        panda1.code = 1021
        panda1.duration = 255
        panda1.period = PeriodType.BABY.ordinal
        panda1.isStar = true
        panda1.title = "《舌尖上的斧头山》第5集 盆盆奶"
        panda1.releaseTime = "2020-10-06 13:35:17"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1Ky4y1C7AD"
        panda1.tags = "熊猫,科普,萌宠"
        panda1.authorName = "pandapia熊猫乌托邦"
        panda1.cover =
            "https://i0.hdslb.com/bfs/archive/4932476ebb58a8cda88916f34b6ec75211b9171d.jpg"
        panda1.videoType = 4
        list.add(panda1)


        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_knowledge2"
        panda2.code = 1022
        panda2.duration = 205
        panda2.period = PeriodType.BABY.ordinal
        panda2.isStar = true
        panda2.title = "《舌尖上的斧头山》第4集 窝窝头"
        panda2.releaseTime = "2020-09-21 16:20:02"
        panda2.originalUrl = "https://www.bilibili.com/video/BV15t4y1q7VQ"
        panda2.tags = "熊猫,科普,萌宠"
        panda2.authorName = "pandapia熊猫乌托邦"
        panda2.cover =
            "https://i1.hdslb.com/bfs/archive/f39061f388c773b7dd51da533995ef6ebbbf1d44.jpg"
        panda2.videoType = 4
        list.add(panda2)


        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_knowledge3"
        panda3.code = 1023
        panda3.duration = 227
        panda3.period = PeriodType.BABY.ordinal
        panda3.isStar = true
        panda3.title = "《舌尖上的斧头山》 第3集 午后甜点"
        panda3.releaseTime = "2020-09-07 16:30:54"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1ED4y1o7vB"
        panda3.tags = "熊猫,科普,萌宠"
        panda3.authorName = "pandapia熊猫乌托邦"
        panda3.cover =
            "https://i2.hdslb.com/bfs/archive/5b8b1e0787a35863b61a78d4f699fe1a4a348c14.jpg"
        panda3.videoType = 4
        list.add(panda3)


        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_knowledge4"
        panda4.code = 1024
        panda4.duration = 167
        panda4.period = PeriodType.BABY.ordinal
        panda4.isStar = true
        panda4.title = "《舌尖上的斧头山》第2集 竹"
        panda4.releaseTime = "2020-08-24 19:00:51"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1sa4y177SD"
        panda4.tags = "熊猫,科普,萌宠"
        panda4.authorName = "pandapia熊猫乌托邦"
        panda4.cover =
            "https://i0.hdslb.com/bfs/archive/6414be33221d8c52e786c64e9ed9bbb64a10927f.jpg"
        panda4.videoType = 4
        list.add(panda4)


        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_knowledge5"
        panda5.code = 1025
        panda5.duration = 154
        panda5.period = PeriodType.BABY.ordinal
        panda5.isStar = true
        panda5.title = "《舌尖上的斧头山》第1集 美食江湖"
        panda5.releaseTime = "2020-08-17 18:02:41"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1Xp4y1v7cc"
        panda5.tags = "熊猫,科普,萌宠"
        panda5.authorName = "pandapia熊猫乌托邦"
        panda5.cover =
            "https://i1.hdslb.com/bfs/archive/9ccb306ca016b571a6cc070d0047c945e92ccbc6.jpg"
        panda5.videoType = 4
        list.add(panda5)


        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_knowledge6"
        panda6.code = 1026
        panda6.duration = 220
        panda6.period = PeriodType.BABY.ordinal
        panda6.isStar = true
        panda6.title = "端午了，你们吃粽子，我们有“铛铛铛”！"
        panda6.releaseTime = "2021-06-14 13:35:15"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1BK4y1X7Jm"
        panda6.tags = "熊猫,科普,萌宠"
        panda6.authorName = "pandapia熊猫乌托邦"
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/fb1d2f9593ddd7ecf19ad4e07543b64f59be88e2.jpg"
        panda6.videoType = 4
        list.add(panda6)


        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_knowledge7"
        panda7.code = 1027
        panda7.duration = 231
        panda7.period = PeriodType.BABY.ordinal
        panda7.isStar = true
        panda7.title = "“长江后浪”推前浪，一代更比一代胖"
        panda7.releaseTime = "2021-09-11 13:30:05"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1i34y1Q7xH"
        panda7.tags = "熊猫,科普,萌宠"
        panda7.authorName = "pandapia熊猫乌托邦"
        panda7.cover =
            "https://i2.hdslb.com/bfs/archive/c70e74b75bf42444a34f5904c1bbf2989d0679a3.jpg"
        panda7.videoType = 4
        list.add(panda7)


        val panda8 = PetVideo()
        panda8.type = PetType.PANDA.ordinal
        panda8.fileName = "panda_knowledge8"
        panda8.code = 1028
        panda8.duration = 210
        panda8.period = PeriodType.BABY.ordinal
        panda8.isStar = true
        panda8.title = "黑白熊怎么就变成“胖哒儿”了？"
        panda8.releaseTime = "2021-09-12 13:30:03"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1p64y1h7PT"
        panda8.tags = "熊猫,科普,萌宠"
        panda8.authorName = "pandapia熊猫乌托邦"
        panda8.cover =
            "https://i2.hdslb.com/bfs/archive/9a57a27496a86cfa38b9d1b2e488ff972c782a5a.jpg"
        panda8.videoType = 4
        list.add(panda8)


        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_knowledge9"
        panda9.code = 1029
        panda9.duration = 215
        panda9.period = PeriodType.BABY.ordinal
        panda9.isStar = true
        panda9.title = "大熊猫不愧是用萌力传递友谊的使者！"
        panda9.releaseTime = "2021-09-13 10:16:02"
        panda9.originalUrl = "https://www.bilibili.com/video/BV11q4y1Z7gG"
        panda9.tags = "熊猫,科普,萌宠"
        panda9.authorName = "pandapia熊猫乌托邦"
        panda9.cover =
            "https://i2.hdslb.com/bfs/archive/45532ef9daf0abfb1e8a961ea3c67ea1b490aeb9.jpg"
        panda9.videoType = 4
        list.add(panda9)


        val panda10 = PetVideo()
        panda10.type = PetType.PANDA.ordinal
        panda10.fileName = "panda_knowledge10"
        panda10.code = 1030
        panda10.duration = 221
        panda10.period = PeriodType.BABY.ordinal
        panda10.isStar = true
        panda10.title = "大熊猫为什么只在川陕甘地区活动？是社恐吗？"
        panda10.releaseTime = "2021-09-14 10:00:00"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1Th411p7Y1"
        panda10.tags = "熊猫,科普,萌宠"
        panda10.authorName = "pandapia熊猫乌托邦"
        panda10.cover =
            "https://i1.hdslb.com/bfs/archive/bdbb7c01e1d01502182c3c922f2caead3eb2d721.jpg"
        panda10.videoType = 4
        list.add(panda10)


        val panda11 = PetVideo()
        panda11.type = PetType.PANDA.ordinal
        panda11.fileName = "panda_knowledge11"
        panda11.code = 1031
        panda11.duration = 207
        panda11.period = PeriodType.BABY.ordinal
        panda11.isStar = true
        panda11.title = "大熊猫的“相亲相爱一家人”群里都有谁？"
        panda11.releaseTime = "2021-09-15 10:00:13"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1Yf4y1J7Th"
        panda11.tags = "熊猫,科普,萌宠"
        panda11.authorName = "pandapia熊猫乌托邦"
        panda11.cover =
            "https://i2.hdslb.com/bfs/archive/7ffef3debb4954dc98d16e15e5a4bb777311b690.jpg"
        panda11.videoType = 4
        list.add(panda11)


        val panda12 = PetVideo()
        panda12.type = PetType.PANDA.ordinal
        panda12.fileName = "panda_knowledge12"
        panda12.code = 1032
        panda12.duration = 226
        panda12.period = PeriodType.BABY.ordinal
        panda12.isStar = true
        panda12.title = "诶！严寒的冬天，就是玩~"
        panda12.releaseTime = "2021-09-16 13:30:13"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1rP4y1h7Ls"
        panda12.tags = "熊猫,科普,萌宠"
        panda12.authorName = "pandapia熊猫乌托邦"
        panda12.cover =
            "https://i2.hdslb.com/bfs/archive/d3ede2807172b3d4f4f5723b64a37e3f666a5d6d.jpg"
        panda12.videoType = 4
        list.add(panda12)


        val panda13 = PetVideo()
        panda13.type = PetType.PANDA.ordinal
        panda13.fileName = "panda_knowledge13"
        panda13.code = 1033
        panda13.duration = 260
        panda13.period = PeriodType.BABY.ordinal
        panda13.isStar = true
        panda13.title = "小熊猫真不是大熊猫的崽！"
        panda13.releaseTime = "2021-09-17 13:30:05"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1E341127BB"
        panda13.tags = "熊猫,科普,萌宠"
        panda13.authorName = "pandapia熊猫乌托邦"
        panda13.cover =
            "https://i0.hdslb.com/bfs/archive/b5757eab088e241ef62ad8b559aafb37fe311494.jpg"
        panda13.videoType = 4
        list.add(panda13)


        val panda14 = PetVideo()
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_knowledge14"
        panda14.code = 1034
        panda14.duration = 251
        panda14.period = PeriodType.BABY.ordinal
        panda14.isStar = true
        panda14.title = "大熊猫吃竹是基操，而特殊食谱还有此等功效与作用？"
        panda14.releaseTime = "2021-09-18 10:00:19"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1LU4y1A7wn"
        panda14.tags = "熊猫,科普,萌宠"
        panda14.authorName = "pandapia熊猫乌托邦"
        panda14.cover =
            "https://i1.hdslb.com/bfs/archive/b38625292f3663f9a06bdfe3afa1e3ad89ed2eca.jpg"
        panda14.videoType = 4
        list.add(panda14)


        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_knowledge15"
        panda15.code = 1035
        panda15.duration = 230
        panda15.period = PeriodType.BABY.ordinal
        panda15.isStar = true
        panda15.title = "想和大熊猫握握手吗？"
        panda15.releaseTime = "2021-09-19 10:00:14"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1Vq4y1f7a1"
        panda15.tags = "熊猫,科普,萌宠"
        panda15.authorName = "pandapia熊猫乌托邦"
        panda15.cover =
            "https://i2.hdslb.com/bfs/archive/447141102b1e19eeabc829f6f99c7c8b3a783e54.jpg"
        panda15.videoType = 4
        list.add(panda15)


        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
        panda16.fileName = "panda_knowledge16"
        panda16.code = 1036
        panda16.duration = 224
        panda16.period = PeriodType.BABY.ordinal
        panda16.isStar = true
        panda16.title = "一口竹子嘎嘣脆"
        panda16.releaseTime = "2021-09-20 10:00:12"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1Bh411p7Sv"
        panda16.tags = "熊猫,科普,萌宠"
        panda16.authorName = "pandapia熊猫乌托邦"
        panda16.cover =
            "https://i2.hdslb.com/bfs/archive/c78a48641a17ad57ad607b6325faebd27abb1d2e.jpg"
        panda16.videoType = 4
        list.add(panda16)


        val panda17 = PetVideo()
        panda17.type = PetType.PANDA.ordinal
        panda17.fileName = "panda_knowledge17"
        panda17.code = 1037
        panda17.duration = 208
        panda17.period = PeriodType.BABY.ordinal
        panda17.isStar = true
        panda17.title = "别看我是“素食主义者”，但我可是地地道道的食肉目动物！"
        panda17.releaseTime = "2021-09-21 10:00:11"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1iP4y1Y7X6"
        panda17.tags = "熊猫,科普,萌宠"
        panda17.authorName = "pandapia熊猫乌托邦"
        panda17.cover =
            "https://i2.hdslb.com/bfs/archive/5a4c4bf2366f322d5fde173e82ac716c92b1c10e.jpg"
        panda17.videoType = 4
        list.add(panda17)


        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_knowledge18"
        panda18.code = 1038
        panda18.duration = 215
        panda18.period = PeriodType.BABY.ordinal
        panda18.isStar = true
        panda18.title = "本国宝的生活，是你们这些两脚兽羡慕不来的！"
        panda18.releaseTime = "2021-09-22 10:00:06"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1MP4y1h7jc"
        panda18.tags = "熊猫,科普,萌宠"
        panda18.authorName = "pandapia熊猫乌托邦"
        panda18.cover =
            "https://i0.hdslb.com/bfs/archive/856824ebe11e2a9f9f1bea97e3d5cda25a5da892.jpg"
        panda18.videoType = 4
        list.add(panda18)


        val panda19 = PetVideo()
        panda19.type = PetType.PANDA.ordinal
        panda19.fileName = "panda_knowledge19"
        panda19.code = 1039
        panda19.duration = 225
        panda19.period = PeriodType.BABY.ordinal
        panda19.isStar = true
        panda19.title = "小小青团大学问，这竟然也是宝贝？！"
        panda19.releaseTime = "2021-09-23 10:00:14"
        panda19.originalUrl = "https://www.bilibili.com/video/BV1ub4y1171x"
        panda19.tags = "熊猫,科普,萌宠"
        panda19.authorName = "pandapia熊猫乌托邦"
        panda19.cover =
            "https://i1.hdslb.com/bfs/archive/696b5c5b15b7f1ad24ad5b1bacf7fcbf2e5a9850.jpg"
        panda19.videoType = 4
        list.add(panda19)


        val panda20 = PetVideo()
        panda20.type = PetType.PANDA.ordinal
        panda20.fileName = "panda_knowledge20"
        panda20.code = 1040
        panda20.duration = 222
        panda20.period = PeriodType.BABY.ordinal
        panda20.isStar = true
        panda20.title = "熊家的尾巴只是不明显，不能说我没尾巴啊！"
        panda20.releaseTime = "2021-09-24 10:00:00"
        panda20.originalUrl = "https://www.bilibili.com/video/BV1Bh411n7US"
        panda20.tags = "熊猫,科普,萌宠"
        panda20.authorName = "pandapia熊猫乌托邦"
        panda20.cover =
            "https://i1.hdslb.com/bfs/archive/1f3e91839b6ecc1e36cb4e8296e7ccb492208918.jpg"
        panda20.videoType = 4
        list.add(panda20)


        val panda21 = PetVideo()
        panda21.type = PetType.PANDA.ordinal
        panda21.fileName = "panda_knowledge21"
        panda21.code = 1041
        panda21.duration = 223
        panda21.period = PeriodType.BABY.ordinal
        panda21.isStar = true
        panda21.title = "厉害吧！我们国宝间的交流就是这样朴实无华"
        panda21.releaseTime = "2021-09-25 10:00:02"
        panda21.originalUrl = "https://www.bilibili.com/video/BV18q4y1K7n9"
        panda21.tags = "熊猫,科普,萌宠"
        panda21.authorName = "pandapia熊猫乌托邦"
        panda21.cover =
            "https://i0.hdslb.com/bfs/archive/25fe86b88486ffc5a5938032fb0b9fef75b3c607.jpg"
        panda21.videoType = 4
        list.add(panda21)


        val panda22 = PetVideo()
        panda22.type = PetType.PANDA.ordinal
        panda22.fileName = "panda_knowledge22"
        panda22.code = 1042
        panda22.duration = 268
        panda22.period = PeriodType.BABY.ordinal
        panda22.isStar = true
        panda22.title = "大熊猫是怎么从粉红“小老鼠”变成黑白分明的大团子的呢？"
        panda22.releaseTime = "2021-09-26 10:00:06"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1FL4y1h76w"
        panda22.tags = "熊猫,科普,萌宠"
        panda22.authorName = "pandapia熊猫乌托邦"
        panda22.cover =
            "https://i1.hdslb.com/bfs/archive/de3a6aadce7066d0ea8c7636efe56aa345b9349d.jpg"
        panda22.videoType = 4
        list.add(panda22)


        val panda23 = PetVideo()
        panda23.type = PetType.PANDA.ordinal
        panda23.fileName = "panda_knowledge23"
        panda23.code = 1043
        panda23.duration = 206
        panda23.period = PeriodType.BABY.ordinal
        panda23.isStar = true
        panda23.title = "没想到我们的行为举止也会影响到熊猫的生活？"
        panda23.releaseTime = "2021-09-30 10:00:13"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1XL411W7uS"
        panda23.tags = "熊猫,科普,萌宠"
        panda23.authorName = "pandapia熊猫乌托邦"
        panda23.cover =
            "https://i2.hdslb.com/bfs/archive/8bad0080ae0ae12af91c357a1742ea328a19f7bf.jpg"
        panda23.videoType = 4
        list.add(panda23)


        val panda24 = PetVideo()
        panda24.type = PetType.PANDA.ordinal
        panda24.fileName = "panda_knowledge24"
        panda24.code = 1044
        panda24.duration = 249
        panda24.period = PeriodType.BABY.ordinal
        panda24.isStar = true
        panda24.title = "母爱如同“山体滑坡”，看大熊猫妈妈如何教导熊猫宝宝成为一只真正的大熊猫"
        panda24.releaseTime = "2021-09-27 10:00:13"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1Bf4y1E7pY"
        panda24.tags = "熊猫,科普,萌宠"
        panda24.authorName = "pandapia熊猫乌托邦"
        panda24.cover =
            "https://i2.hdslb.com/bfs/archive/1014a8fa30a2bb8487d6a9f6e9a402615716e0b8.jpg"
        panda24.videoType = 4
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = PetType.PANDA.ordinal
        panda25.fileName = "panda_knowledge25"
        panda25.code = 1045
        panda25.duration = 267
        panda25.period = PeriodType.BABY.ordinal
        panda25.isStar = true
        panda25.title = "快来翻译翻译，这些嘤嘤怪们都在说什么？"
        panda25.releaseTime = "2021-09-28 10:00:09"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1gM4y137vQ"
        panda25.tags = "熊猫,科普,萌宠"
        panda25.authorName = "pandapia熊猫乌托邦"
        panda25.cover =
            "https://i1.hdslb.com/bfs/archive/ad659eff6084fd6535e04a533d3353eee3f58116.jpg"
        panda25.videoType = 4
        list.add(panda25)

        val panda26 = PetVideo()
        panda26.type = PetType.PANDA.ordinal
        panda26.fileName = "panda_knowledge26"
        panda26.code = 1046
        panda26.duration = 286
        panda26.period = PeriodType.BABY.ordinal
        panda26.isStar = true
        panda26.title = "国宝也是会生病的！不要再嘲笑熊家的“脱裤照”了！"
        panda26.releaseTime = "2021-09-29 10:00:14"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1ET4y1Z7vy"
        panda26.tags = "熊猫,科普,萌宠"
        panda26.authorName = "pandapia熊猫乌托邦"
        panda26.cover =
            "https://i1.hdslb.com/bfs/archive/630cdd0a53113afa80fa7e5c6df6571ba43488d9.jpg"
        panda26.videoType = 4
        list.add(panda26)

        return list
    }

    private fun getPenguinData(): MutableList<PetVideo> {

        val penguin1 = PetVideo()
        penguin1.type = PetType.PENGUIN.ordinal
        penguin1.fileName = "penguin1"
        penguin1.code = 1047
        penguin1.duration = 156
        penguin1.period = PeriodType.GROUP.ordinal
        penguin1.isStar = true
        penguin1.title = "“没头脑和不高兴”"
        penguin1.releaseTime = "2022-01-15 11:07:47"
        penguin1.originalUrl = "https://www.bilibili.com/video/BV1tb4y1J7wu"
        penguin1.tags = "企鹅,萌宠"
        penguin1.authorName = "喵柚兽"
        penguin1.cover =
            "https://i0.hdslb.com/bfs/archive/21a3b47ec1ca6fd35de8079f877297ea220ddca4.png"
        penguin1.videoType = 0
        list.add(penguin1)


        val penguin2 = PetVideo()
        penguin2.type = PetType.PENGUIN.ordinal
        penguin2.fileName = "penguin2"
        penguin2.code = 1048
        penguin2.duration = 154
        penguin2.period = PeriodType.GROUP.ordinal
        penguin2.isStar = true
        penguin2.title = "超清企鹅爸爸夹着企鹅宝宝艰难前行。还有别的企鹅崽崽看中他这个自行车，企图钻进去"
        penguin2.releaseTime = "2022-01-22 12:25:38"
        penguin2.originalUrl = "https://www.bilibili.com/video/BV1gT4y127Cm"
        penguin2.tags = "企鹅,萌宠"
        penguin2.authorName = "大哥hong"
        penguin2.cover =
            "https://i2.hdslb.com/bfs/archive/dcb820099163630466517b25c233e9f6acb2d8f4.jpg"
        penguin2.videoType = 0
        list.add(penguin2)


        val penguin3 = PetVideo()
        penguin3.type = PetType.PENGUIN.ordinal
        penguin3.fileName = "penguin3"
        penguin3.code = 1049
        penguin3.duration = 95
        penguin3.period = PeriodType.GROUP.ordinal
        penguin3.isStar = true
        penguin3.title = "帝企鹅幼崽与爸爸走散，独自在寒风中瑟瑟发抖，最后一幕太治愈了！|《企鹅家族》"
        penguin3.releaseTime = "2021-07-20 19:21:08"
        penguin3.originalUrl = "https://www.bilibili.com/video/BV1ZM4y1K7Kx"
        penguin3.tags = "企鹅,萌宠"
        penguin3.authorName = "腾讯纪录片"
        penguin3.cover =
            "https://i2.hdslb.com/bfs/archive/e35662f8b9e32506af47507f9c60d5ce17d4ac01.jpg"
        penguin3.videoType = 0
        list.add(penguin3)


        val penguin4 = PetVideo()
        penguin4.type = PetType.PENGUIN.ordinal
        penguin4.fileName = "penguin4"
        penguin4.code = 1050
        penguin4.duration = 128
        penguin4.period = PeriodType.GROUP.ordinal
        penguin4.isStar = true
        penguin4.title = "【BBC纪录片】摄影组为救出被困企鹅，放弃原则出手干涉"
        penguin4.releaseTime = "2018-11-22 18:16:12"
        penguin4.originalUrl = "https://www.bilibili.com/video/BV1ct411y7Em"
        penguin4.tags = "企鹅,萌宠"
        penguin4.authorName = "无料公社"
        penguin4.cover =
            "https://i1.hdslb.com/bfs/archive/00130c00af27f4990266b0a84d1ad120fb823fce.jpg"
        penguin4.videoType = 0
        list.add(penguin4)


        val penguin5 = PetVideo()
        penguin5.type = PetType.PENGUIN.ordinal
        penguin5.fileName = "penguin5"
        penguin5.code = 1051
        penguin5.duration = 371
        penguin5.period = PeriodType.GROUP.ordinal
        penguin5.isStar = true
        penguin5.title = "机器卧底混入企鹅群，记录了小企鹅的逆袭之路，超萌的纪录片。"
        penguin5.releaseTime = "2022-01-13 13:46:45"
        penguin5.originalUrl = "https://www.bilibili.com/video/BV1Tu411m71i"
        penguin5.tags = "企鹅,萌宠"
        penguin5.authorName = "探险橘"
        penguin5.cover =
            "https://i2.hdslb.com/bfs/archive/c7b2d3f0fdc8047ad2174901e511f9d74259a978.jpg"
        penguin5.videoType = 0
        list.add(penguin5)


        val penguin6 = PetVideo()
        penguin6.type = PetType.PENGUIN.ordinal
        penguin6.fileName = "penguin6"
        penguin6.code = 1052
        penguin6.duration = 47
        penguin6.period = PeriodType.GROUP.ordinal
        penguin6.isStar = true
        penguin6.title = "【企鹅宝宝】妈妈我饿了……"
        penguin6.releaseTime = "2019-10-17 21:01:17"
        penguin6.originalUrl = "https://www.bilibili.com/video/BV1gE411y7zA"
        penguin6.tags = "企鹅,萌宠"
        penguin6.authorName = "肉山大魔王酱酱菌"
        penguin6.cover =
            "https://i1.hdslb.com/bfs/archive/2bbc00ad39883588c3d3cd2612dc2cf461e74016.jpg"
        penguin6.videoType = 0
        list.add(penguin6)


        val penguin7 = PetVideo()
        penguin7.type = PetType.PENGUIN.ordinal
        penguin7.fileName = "penguin7"
        penguin7.code = 1053
        penguin7.duration = 27
        penguin7.period = PeriodType.GROUP.ordinal
        penguin7.isStar = true
        penguin7.title = "胎毛还没褪的企鹅崽崽跟爸爸出去浪。。"
        penguin7.releaseTime = "2021-02-27 20:17:16"
        penguin7.originalUrl = "https://www.bilibili.com/video/BV1y54y1h7A5"
        penguin7.tags = "企鹅,萌宠"
        penguin7.authorName = "熊抹了"
        penguin7.cover =
            "https://i1.hdslb.com/bfs/archive/a3406b59885a8d40dad1ad06ded30a1a0062286e.png"
        penguin7.videoType = 0
        list.add(penguin7)


        val penguin8 = PetVideo()
        penguin8.type = PetType.PENGUIN.ordinal
        penguin8.fileName = "penguin8"
        penguin8.code = 1054
        penguin8.duration = 445
        penguin8.period = PeriodType.GROUP.ordinal
        penguin8.isStar = true
        penguin8.title =
            "企鹅崽崽们每天在大本营做什么:登高，边跑边扑棱翅膀，吃雪，挠痒痒，踩着鹅爸前行，爬雪山，乱认亲，吃饭，打呵欠，撒娇，发呆，站着睡觉，闻闻身上臭不臭，全程高萌"
        penguin8.releaseTime = "2022-01-26 22:32:22"
        penguin8.originalUrl = "https://www.bilibili.com/video/BV1Rb4y177Mq"
        penguin8.tags = "企鹅,萌宠"
        penguin8.authorName = "大哥hong"
        penguin8.cover =
            "https://i1.hdslb.com/bfs/archive/cde67bcdd0a05d4836dece5094650d76ba71c622.jpg"
        penguin8.videoType = 0
        list.add(penguin8)


        val penguin9 = PetVideo()
        penguin9.type = PetType.PENGUIN.ordinal
        penguin9.fileName = "penguin9"
        penguin9.code = 1055
        penguin9.duration = 136
        penguin9.period = PeriodType.GROUP.ordinal
        penguin9.isStar = true
        penguin9.title = "超可爱，帝企鹅宝宝跟着妈妈出去散步"
        penguin9.releaseTime = "2022-01-25 20:39:30"
        penguin9.originalUrl = "https://www.bilibili.com/video/BV1im4y1S7xN"
        penguin9.tags = "企鹅,萌宠"
        penguin9.authorName = "大哥hong"
        penguin9.cover =
            "https://i1.hdslb.com/bfs/archive/2c30d7177fd06d937671eb473ee0e7331f945247.jpg"
        penguin9.videoType = 0
        list.add(penguin9)


        val penguin10 = PetVideo()
        penguin10.type = PetType.PENGUIN.ordinal
        penguin10.fileName = "penguin10"
        penguin10.code = 1056
        penguin10.duration = 107
        penguin10.period = PeriodType.GROUP.ordinal
        penguin10.isStar = true
        penguin10.title = "【孤独的企鹅】《在世界尽头相遇》 中的企鹅自杀片段，一只企鹅离开大部队，义无反顾地向群山走去，漫漫长路，等待着它的只有死亡……"
        penguin10.releaseTime = "2018-11-10 16:44:18"
        penguin10.originalUrl = "https://www.bilibili.com/video/BV1vt411m7b1"
        penguin10.tags = "企鹅,萌宠"
        penguin10.authorName = "传达不到的未来"
        penguin10.cover =
            "https://i1.hdslb.com/bfs/archive/73447a0435971d46c3a070fb86b7f4dd65b0bd27.png"
        penguin10.videoType = 0
        list.add(penguin10)


        val penguin11 = PetVideo()
        penguin11.type = PetType.PENGUIN.ordinal
        penguin11.fileName = "penguin11"
        penguin11.code = 1057
        penguin11.duration = 151
        penguin11.period = PeriodType.GROUP.ordinal
        penguin11.isStar = true
        penguin11.title = "[英字]鹅砸!!阿德利叔叔来救你们了!"
        penguin11.releaseTime = "2019-08-22 20:59:14"
        penguin11.originalUrl = "https://www.bilibili.com/video/BV1Z441197ha"
        penguin11.tags = "企鹅,萌宠"
        penguin11.authorName = "Kiwi是个字幕君"
        penguin11.cover =
            "https://i2.hdslb.com/bfs/archive/dd5b65514801d3aefe2b88bd6a4bf498948dc431.jpg"
        penguin11.videoType = 0
        list.add(penguin11)


        val penguin12 = PetVideo()
        penguin12.type = PetType.PENGUIN.ordinal
        penguin12.fileName = "penguin12"
        penguin12.code = 1058
        penguin12.duration = 119
        penguin12.period = PeriodType.GROUP.ordinal
        penguin12.isStar = true
        penguin12.title = "【BBC】企鹅宝宝对阵巨鹱鸟"
        penguin12.releaseTime = "2020-07-23 16:25:45"
        penguin12.originalUrl = "https://www.bilibili.com/video/BV1Sf4y1R7p9"
        penguin12.tags = "企鹅,萌宠"
        penguin12.authorName = "YouTube精选字幕组"
        penguin12.cover =
            "https://i2.hdslb.com/bfs/archive/5443ddcd1827c28642fc41b5bcfd8176445fc63f.jpg"
        penguin12.videoType = 0
        list.add(penguin12)


        val penguin13 = PetVideo()
        penguin13.type = PetType.PENGUIN.ordinal
        penguin13.fileName = "penguin13"
        penguin13.code = 1059
        penguin13.duration = 140
        penguin13.period = PeriodType.GROUP.ordinal
        penguin13.isStar = true
        penguin13.title = "帝企鹅的崽崽最可爱了！！"
        penguin13.releaseTime = "2021-03-04 02:02:26"
        penguin13.originalUrl = "https://www.bilibili.com/video/BV1Kz4y117su"
        penguin13.tags = "企鹅,萌宠"
        penguin13.authorName = "可乐百利甜"
        penguin13.cover =
            "https://i1.hdslb.com/bfs/archive/6f69bc26f782882c25897e19996b1dabe7e17b89.jpg"
        penguin13.videoType = 0
        list.add(penguin13)


        val penguin14 = PetVideo()
        penguin14.type = PetType.PENGUIN.ordinal
        penguin14.fileName = "penguin14"
        penguin14.code = 1060
        penguin14.duration = 125
        penguin14.period = PeriodType.GROUP.ordinal
        penguin14.isStar = true
        penguin14.title = "企鹅真的不是什么好鹅！别被它的外表骗了."
        penguin14.releaseTime = "2019-09-24 18:02:10"
        penguin14.originalUrl = "https://www.bilibili.com/video/BV1FJ411u7do"
        penguin14.tags = "企鹅,萌宠"
        penguin14.authorName = "拙石居"
        penguin14.cover =
            "https://i1.hdslb.com/bfs/archive/916175a4b22de556a3b58440de6ca67010a10b5a.jpg"
        penguin14.videoType = 0
        list.add(penguin14)


        val penguin15 = PetVideo()
        penguin15.type = PetType.PENGUIN.ordinal
        penguin15.fileName = "penguin15"
        penguin15.code = 1061
        penguin15.duration = 125
        penguin15.period = PeriodType.GROUP.ordinal
        penguin15.isStar = true
        penguin15.title = "大型企鹅翻车现场...鹅咂: 我太难了"
        penguin15.releaseTime = "2019-10-20 13:59:53"
        penguin15.originalUrl = "https://www.bilibili.com/video/BV1GE41167JH"
        penguin15.tags = "企鹅,萌宠"
        penguin15.authorName = "Kiwi是个字幕君"
        penguin15.cover =
            "https://i1.hdslb.com/bfs/archive/a6cf9cee1d99141c99741c86146e18398c620539.jpg"
        penguin15.videoType = 0
        list.add(penguin15)


        val penguin16 = PetVideo()
        penguin16.type = PetType.PENGUIN.ordinal
        penguin16.fileName = "penguin16"
        penguin16.code = 1062
        penguin16.duration = 29
        penguin16.period = PeriodType.GROUP.ordinal
        penguin16.isStar = true
        penguin16.title = "超治愈！被这只毛茸茸的小企鹅萌到了！太可爱了吧！！！"
        penguin16.releaseTime = "2018-11-21 16:03:54"
        penguin16.originalUrl = "https://www.bilibili.com/video/BV1qt411C7ZU"
        penguin16.tags = "企鹅,萌宠"
        penguin16.authorName = "首席花吹"
        penguin16.cover =
            "https://i0.hdslb.com/bfs/archive/8552c7c6df51a0a82e83229188939ba52df69f44.jpg"
        penguin16.videoType = 0
        list.add(penguin16)

        return list
    }

    private fun getBearData(): MutableList<PetVideo> {

        val BEAR1 = PetVideo()
        BEAR1.type = PetType.BEAR.ordinal
        BEAR1.fileName = "pet_bear1"
        BEAR1.code = 1077
        BEAR1.duration = 261
        BEAR1.period = PeriodType.GROUP.ordinal
        BEAR1.isStar = false
        BEAR1.title = "北极熊妈携幼崽艰难度日，漫长的无冰夏季让生存挑战愈发严峻！"
        BEAR1.releaseTime = "2022-01-27 17:10:08"
        BEAR1.originalUrl = "https://www.bilibili.com/video/BV1Sr4y1e7J6"
        BEAR1.tags = "熊,北极熊,萌宠,动物圈"
        BEAR1.authorName = "纪录片之家爱自然"
        BEAR1.cover =
            "https://i2.hdslb.com/bfs/archive/40bc615010991450f3c41e0d2c76258b44d65058.jpg"
        BEAR1.videoType = 0
        list.add(BEAR1)

        val BEAR2 = PetVideo()
        BEAR2.type = PetType.BEAR.ordinal
        BEAR2.fileName = "pet_bear2"
        BEAR2.code = 1078
        BEAR2.duration = 98
        BEAR2.period = PeriodType.GROUP.ordinal
        BEAR2.isStar = false
        BEAR2.title = "【白熊】小北极熊：我不想起床呀"
        BEAR2.releaseTime = "2021-11-09 00:25:01"
        BEAR2.originalUrl = "https://www.bilibili.com/video/BV1xv411M7YK"
        BEAR2.tags = "熊,北极熊,萌宠,动物圈"
        BEAR2.authorName = "饿了想吃小熊"
        BEAR2.cover =
            "https://i1.hdslb.com/bfs/archive/326f3ac22b4dce00a42a2ca81955c1321d90cc78.jpg"
        BEAR2.videoType = 0
        list.add(BEAR2)

        val BEAR3 = PetVideo()
        BEAR3.type = PetType.BEAR.ordinal
        BEAR3.fileName = "pet_bear3"
        BEAR3.code = 1079
        BEAR3.duration = 75
        BEAR3.period = PeriodType.GROUP.ordinal
        BEAR3.isStar = false
        BEAR3.title = "40℃的高温天气下，北极熊的命都是冰块给的！"
        BEAR3.releaseTime = "2017-07-25 16:47:14"
        BEAR3.originalUrl = "https://www.bilibili.com/video/BV1Lx411q7PS"
        BEAR3.tags = "熊,北极熊,萌宠,动物圈"
        BEAR3.authorName = "gaoli3008"
        BEAR3.cover =
            "https://i2.hdslb.com/bfs/archive/871b0d4be50779212b4db2ebac9a019d79613c17.jpg"
        BEAR3.videoType = 0
        list.add(BEAR3)

        val BEAR4 = PetVideo()
        BEAR4.type = PetType.BEAR.ordinal
        BEAR4.fileName = "pet_bear4"
        BEAR4.code = 1080
        BEAR4.duration = 57
        BEAR4.period = PeriodType.GROUP.ordinal
        BEAR4.isStar = false
        BEAR4.title = "饲养员给北极熊准备了一桶冰 给熊高兴坏了"
        BEAR4.releaseTime = "2019-01-24 12:32:20"
        BEAR4.originalUrl = "https://www.bilibili.com/video/BV1Et411b73k"
        BEAR4.tags = "熊,北极熊,萌宠,动物圈"
        BEAR4.authorName = "肉山大魔王酱酱菌"
        BEAR4.cover =
            "https://i0.hdslb.com/bfs/archive/1cec5ac9f3ab7a5fcb12838e440e04b4b75a94de.jpg"
        BEAR4.videoType = 0
        list.add(BEAR4)

        val BEAR5 = PetVideo()
        BEAR5.type = PetType.BEAR.ordinal
        BEAR5.fileName = "pet_bear5"
        BEAR5.code = 1081
        BEAR5.duration = 121
        BEAR5.period = PeriodType.GROUP.ordinal
        BEAR5.isStar = false
        BEAR5.title = "【北极熊】麻麻在挖洞 我在旁边乖乖的"
        BEAR5.releaseTime = "2020-09-27 19:30:49"
        BEAR5.originalUrl = "https://www.bilibili.com/video/BV1Vk4y117Te"
        BEAR5.tags = "熊,北极熊,萌宠,动物圈"
        BEAR5.authorName = "饿了想吃小熊"
        BEAR5.cover =
            "https://i1.hdslb.com/bfs/archive/46ab34d5e472476e1f362b71107ab46898da597b.jpg"
        BEAR5.videoType = 0
        list.add(BEAR5)

        val BEAR6 = PetVideo()
        BEAR6.type = PetType.BEAR.ordinal
        BEAR6.fileName = "pet_bear6"
        BEAR6.code = 1082
        BEAR6.duration = 162
        BEAR6.period = PeriodType.GROUP.ordinal
        BEAR6.isStar = false
        BEAR6.title = "北极熊牌靠枕"
        BEAR6.releaseTime = "2021-08-16 17:24:54"
        BEAR6.originalUrl = "https://www.bilibili.com/video/BV1N3411677y"
        BEAR6.tags = "熊,北极熊,萌宠,动物圈"
        BEAR6.authorName = "乌苏里熊"
        BEAR6.cover =
            "https://i1.hdslb.com/bfs/archive/d33fcbbd98287bb502486ec55f3af9bd490fb504.jpg"
        BEAR6.videoType = 0
        list.add(BEAR6)

        val BEAR7 = PetVideo()
        BEAR7.type = PetType.BEAR.ordinal
        BEAR7.fileName = "pet_bear7"
        BEAR7.code = 1083
        BEAR7.duration = 68
        BEAR7.period = PeriodType.GROUP.ordinal
        BEAR7.isStar = false
        BEAR7.title = "小北极熊纳努和她的弟弟"
        BEAR7.releaseTime = "2021-10-06 11:43:55"
        BEAR7.originalUrl = "https://www.bilibili.com/video/BV1tP4y187kt"
        BEAR7.tags = "熊,北极熊,萌宠,动物圈"
        BEAR7.authorName = "八步金"
        BEAR7.cover =
            "https://i2.hdslb.com/bfs/archive/f1b2103c7c0229bf56ebd1c379834336a588b5bf.png"
        BEAR7.videoType = 0
        list.add(BEAR7)

        val BEAR8 = PetVideo()
        BEAR8.type = PetType.BEAR.ordinal
        BEAR8.fileName = "pet_bear8"
        BEAR8.code = 1084
        BEAR8.duration = 106
        BEAR8.period = PeriodType.GROUP.ordinal
        BEAR8.isStar = false
        BEAR8.title = "两岁的小北极熊纳努终于被妈妈赶走了"
        BEAR8.releaseTime = "2021-11-09 15:52:50"
        BEAR8.originalUrl = "https://www.bilibili.com/video/BV15q4y1k75D"
        BEAR8.tags = "熊,北极熊,萌宠,动物圈"
        BEAR8.authorName = "八步金"
        BEAR8.cover =
            "https://i2.hdslb.com/bfs/archive/821de6e05667ae5443031d86e2af979ccb63209e.jpg"
        BEAR8.videoType = 0
        list.add(BEAR8)

        val BEAR9 = PetVideo()
        BEAR9.type = PetType.BEAR.ordinal
        BEAR9.fileName = "pet_bear9"
        BEAR9.code = 1085
        BEAR9.duration = 107
        BEAR9.period = PeriodType.GROUP.ordinal
        BEAR9.isStar = false
        BEAR9.title = "小海豹宝宝被北极熊一口叼走，小海豹妈妈只能眼睁睁的看着"
        BEAR9.releaseTime = "2020-03-07 18:58:50"
        BEAR9.originalUrl = "https://www.bilibili.com/video/BV15E411p7kC"
        BEAR9.tags = "熊,北极熊,萌宠,动物圈"
        BEAR9.authorName = "爱丽卡与卡洛茜"
        BEAR9.cover =
            "https://i1.hdslb.com/bfs/archive/dbd247e8d301b05359e74ca70f727faee7b8eab4.jpg"
        BEAR9.videoType = 0
        list.add(BEAR9)

        val BEAR10 = PetVideo()
        BEAR10.type = PetType.BEAR.ordinal
        BEAR10.fileName = "pet_bear10"
        BEAR10.code = 1086
        BEAR10.duration = 239
        BEAR10.period = PeriodType.GROUP.ordinal
        BEAR10.isStar = false
        BEAR10.title = "熊妈妈亲自带宝宝打野   熊宝宝吃了100条鱼"
        BEAR10.releaseTime = "2021-01-02 01:51:09"
        BEAR10.originalUrl = "https://www.bilibili.com/video/BV16y4y1U7CS"
        BEAR10.tags = "熊,北极熊,萌宠,动物圈"
        BEAR10.authorName = "狗熊の尾巴"
        BEAR10.cover =
            "https://i2.hdslb.com/bfs/archive/e96235347ae6899681f70357cc3b351330a108d3.jpg"
        BEAR10.videoType = 0
        list.add(BEAR10)

        val BEAR11 = PetVideo()
        BEAR11.type = PetType.BEAR.ordinal
        BEAR11.fileName = "pet_bear11"
        BEAR11.code = 1087
        BEAR11.duration = 157
        BEAR11.period = PeriodType.GROUP.ordinal
        BEAR11.isStar = false
        BEAR11.title = "北极熊妈妈带着两崽子找到一头死去的大鲸鱼，放开吃"
        BEAR11.releaseTime = "2020-04-26 11:21:51"
        BEAR11.originalUrl = "https://www.bilibili.com/video/BV1q5411x7Hd"
        BEAR11.tags = "熊,北极熊,萌宠,动物圈"
        BEAR11.authorName = "小修是条狗"
        BEAR11.cover =
            "https://i0.hdslb.com/bfs/archive/aca8c7e447ebc866f318557765ff16f96a61d12f.png"
        BEAR11.videoType = 0
        list.add(BEAR11)

        val BEAR12 = PetVideo()
        BEAR12.type = PetType.BEAR.ordinal
        BEAR12.fileName = "pet_bear12"
        BEAR12.code = 1088
        BEAR12.duration = 111
        BEAR12.period = PeriodType.GROUP.ordinal
        BEAR12.isStar = false
        BEAR12.title = "冬眠结束~三只北极熊宝宝第一次爬出雪洞看世界！！！"
        BEAR12.releaseTime = "2020-03-20 18:02:48"
        BEAR12.originalUrl = "https://www.bilibili.com/video/BV1AE411N7be"
        BEAR12.tags = "熊,北极熊,萌宠,动物圈"
        BEAR12.authorName = "和嵐Sama甩甩尾巴"
        BEAR12.cover =
            "https://i2.hdslb.com/bfs/archive/4aa6f7f0bcf67bea70930a6725b6cb41afcafd93.jpg"
        BEAR12.videoType = 0
        list.add(BEAR12)

        val BEAR13 = PetVideo()
        BEAR13.type = PetType.BEAR.ordinal
        BEAR13.fileName = "pet_bear13"
        BEAR13.code = 1089
        BEAR13.duration = 299
        BEAR13.period = PeriodType.GROUP.ordinal
        BEAR13.isStar = false
        BEAR13.title = "【精彩片段】北极熊猎杀白鲸，鲸肉大餐！"
        BEAR13.releaseTime = "2020-08-15 22:24:52"
        BEAR13.originalUrl = "https://www.bilibili.com/video/BV1x54y1i7sZ"
        BEAR13.tags = "熊,北极熊,萌宠,动物圈"
        BEAR13.authorName = "真理豹"
        BEAR13.cover =
            "https://i1.hdslb.com/bfs/archive/e9ba25ef685a9153c5dafaecdba46a708075bd62.jpg"
        BEAR13.videoType = 0
        list.add(BEAR13)

        val BEAR14 = PetVideo()
        BEAR14.type = PetType.BEAR.ordinal
        BEAR14.fileName = "pet_bear14"
        BEAR14.code = 1090
        BEAR14.duration = 312
        BEAR14.period = PeriodType.GROUP.ordinal
        BEAR14.isStar = false
        BEAR14.title = "北极熊开阔水面爆头秒杀白鲸"
        BEAR14.releaseTime = "2022-01-18 22:18:36"
        BEAR14.originalUrl = "https://www.bilibili.com/video/BV1mR4y1M7si"
        BEAR14.tags = "熊,北极熊,萌宠,动物圈"
        BEAR14.authorName = "博物wiki"
        BEAR14.cover =
            "https://i1.hdslb.com/bfs/archive/21ade638a8ef8cb3a30c8bb63fd30232f64afa66.jpg"
        BEAR14.videoType = 0
        list.add(BEAR14)

        val BEAR15 = PetVideo()
        BEAR15.type = PetType.BEAR.ordinal
        BEAR15.fileName = "pet_bear15"
        BEAR15.code = 1091
        BEAR15.duration = 310
        BEAR15.period = PeriodType.GROUP.ordinal
        BEAR15.isStar = false
        BEAR15.title = "北极熊活吃鞍背海豹"
        BEAR15.releaseTime = "2019-11-16 19:00:10"
        BEAR15.originalUrl = "https://www.bilibili.com/video/BV1CE411e7CB"
        BEAR15.tags = "熊,北极熊,萌宠,动物圈"
        BEAR15.authorName = "满PING都是马赛克"
        BEAR15.cover =
            "https://i0.hdslb.com/bfs/archive/96467d1ae71df72da62d0e7cf65320e2c99bae4f.jpg"
        BEAR15.videoType = 0
        list.add(BEAR15)

        val BEAR16 = PetVideo()
        BEAR16.type = PetType.BEAR.ordinal
        BEAR16.fileName = "pet_bear16"
        BEAR16.code = 1092
        BEAR16.duration = 59
        BEAR16.period = PeriodType.GROUP.ordinal
        BEAR16.isStar = false
        BEAR16.title = "小灰熊和小北极熊一起玩耍"
        BEAR16.releaseTime = "2021-09-29 02:13:51"
        BEAR16.originalUrl = "https://www.bilibili.com/video/BV1Sr4y1173H"
        BEAR16.tags = "熊,北极熊,萌宠,动物圈"
        BEAR16.authorName = "乌苏里熊"
        BEAR16.cover =
            "https://i1.hdslb.com/bfs/archive/c687747a1f86aef92dc4bf13339844019f6c34f8.jpg"
        BEAR16.videoType = 0
        list.add(BEAR16)

        val BEAR17 = PetVideo()
        BEAR17.type = PetType.BEAR.ordinal
        BEAR17.fileName = "pet_bear17"
        BEAR17.code = 1093
        BEAR17.duration = 66
        BEAR17.period = PeriodType.GROUP.ordinal
        BEAR17.isStar = false
        BEAR17.title = "#北极熊# 啊啊啊可爱坏了！北极熊宝宝被突然钻出来的海豹吓到"
        BEAR17.releaseTime = "2019-10-12 18:56:28"
        BEAR17.originalUrl = "https://www.bilibili.com/video/BV14E411Z7nx"
        BEAR17.tags = "熊,北极熊,萌宠,动物圈"
        BEAR17.authorName = "Once-a-king"
        BEAR17.cover =
            "https://i2.hdslb.com/bfs/archive/b391bf0f6672ecfc749ed1c665a41848a79f1ecb.jpg"
        BEAR17.videoType = 0
        list.add(BEAR17)

        val BEAR18 = PetVideo()
        BEAR18.type = PetType.BEAR.ordinal
        BEAR18.fileName = "pet_bear18"
        BEAR18.code = 1094
        BEAR18.duration = 415
        BEAR18.period = PeriodType.GROUP.ordinal
        BEAR18.isStar = false
        BEAR18.title = "[奥狄斯X亚历山大]北极熊篇-《你打算萌死我吗》-莫如归原著"
        BEAR18.releaseTime = "2021-01-25 02:41:10"
        BEAR18.originalUrl = "https://www.bilibili.com/video/BV1Ro4y1o7md"
        BEAR18.tags = "熊,北极熊,萌宠,动物圈"
        BEAR18.authorName = "-茉莉奶绿-"
        BEAR18.cover =
            "https://i2.hdslb.com/bfs/archive/6e863bf83b61823887944e60a4c12b08f9357790.jpg"
        BEAR18.videoType = 0
        list.add(BEAR18)

        val BEAR19 = PetVideo()
        BEAR19.type = PetType.BEAR.ordinal
        BEAR19.fileName = "pet_bear19"
        BEAR19.code = 1095
        BEAR19.duration = 306
        BEAR19.period = PeriodType.GROUP.ordinal
        BEAR19.isStar = false
        BEAR19.title = "你听过小北极熊的叫声吗？"
        BEAR19.releaseTime = "2019-12-05 16:09:53"
        BEAR19.originalUrl = "https://www.bilibili.com/video/BV1PJ411i7yk"
        BEAR19.tags = "熊,北极熊,萌宠,动物圈"
        BEAR19.authorName = "小张-小张自有主张"
        BEAR19.cover =
            "https://i2.hdslb.com/bfs/archive/b90941e8f5a06346e679e96bd903fa2122038f7a.jpg"
        BEAR19.videoType = 0
        list.add(BEAR19)

        val BEAR20 = PetVideo()
        BEAR20.type = PetType.BEAR.ordinal
        BEAR20.fileName = "pet_bear20"
        BEAR20.code = 1096
        BEAR20.duration = 114
        BEAR20.period = PeriodType.GROUP.ordinal
        BEAR20.isStar = false
        BEAR20.title = "北极熊：北极熊宝宝是黏在妈妈屁股上的小跟屁"
        BEAR20.releaseTime = "2021-10-18 17:09:06"
        BEAR20.originalUrl = "https://www.bilibili.com/video/BV1kU4y1F7Dk"
        BEAR20.tags = "熊,北极熊,萌宠,动物圈"
        BEAR20.authorName = "嗑叔磕动物"
        BEAR20.cover =
            "https://i2.hdslb.com/bfs/archive/f1242657c843475898357e783da668d4201d78e7.jpg"
        BEAR20.videoType = 0
        list.add(BEAR20)

        val BEAR21 = PetVideo()
        BEAR21.type = PetType.BEAR.ordinal
        BEAR21.fileName = "pet_bear21"
        BEAR21.code = 1097
        BEAR21.duration = 90
        BEAR21.period = PeriodType.GROUP.ordinal
        BEAR21.isStar = false
        BEAR21.title = "男鹿水族馆 水边玩耍的北极熊"
        BEAR21.releaseTime = "2022-01-25 01:25:06"
        BEAR21.originalUrl = "https://www.bilibili.com/video/BV19Z4y1f7Kw"
        BEAR21.tags = "熊,北极熊,萌宠,动物圈"
        BEAR21.authorName = "伊奈那岐"
        BEAR21.cover =
            "https://i2.hdslb.com/bfs/archive/89ea440974c0a5f4eb3107af9eb433bd05ff95e6.jpg"
        BEAR21.videoType = 0
        list.add(BEAR21)

        val BEAR22 = PetVideo()
        BEAR22.type = PetType.BEAR.ordinal
        BEAR22.fileName = "pet_bear22"
        BEAR22.code = 1098
        BEAR22.duration = 184
        BEAR22.period = PeriodType.GROUP.ordinal
        BEAR22.isStar = false
        BEAR22.title = "【北极熊】饲养员给白熊宝宝jiojio抹护肤霜"
        BEAR22.releaseTime = "2021-10-31 17:41:20"
        BEAR22.originalUrl = "https://www.bilibili.com/video/BV1Rb4y1b7sH"
        BEAR22.tags = "熊,北极熊,萌宠,动物圈"
        BEAR22.authorName = "终极本能"
        BEAR22.cover =
            "https://i1.hdslb.com/bfs/archive/f76e963519bc0fc584c11a4694cd9e2675ebbed9.jpg"
        BEAR22.videoType = 0
        list.add(BEAR22)

        val BEAR23 = PetVideo()
        BEAR23.type = PetType.BEAR.ordinal
        BEAR23.fileName = "pet_bear23"
        BEAR23.code = 1099
        BEAR23.duration = 152
        BEAR23.period = PeriodType.GROUP.ordinal
        BEAR23.isStar = false
        BEAR23.title = "【白熊】小北极熊熊生第一次看到雪！"
        BEAR23.releaseTime = "2022-01-10 18:00:11"
        BEAR23.originalUrl = "https://www.bilibili.com/video/BV17u411D7Ux"
        BEAR23.tags = "熊,北极熊,萌宠,动物圈"
        BEAR23.authorName = "饿了想吃小熊"
        BEAR23.cover =
            "https://i2.hdslb.com/bfs/archive/2716e989f2b91b7f63ce42161a1947a334a9cd74.jpg"
        BEAR23.videoType = 0
        list.add(BEAR23)

        val BEAR24 = PetVideo()
        BEAR24.type = PetType.BEAR.ordinal
        BEAR24.fileName = "pet_bear24"
        BEAR24.code = 1100
        BEAR24.duration = 15
        BEAR24.period = PeriodType.GROUP.ordinal
        BEAR24.isStar = false
        BEAR24.title = "【小熊】熊熊玛尼娅 摆出了有些诱惑的姿势"
        BEAR24.releaseTime = "2022-01-07 18:30:13"
        BEAR24.originalUrl = "https://www.bilibili.com/video/BV1MM4y1w79d"
        BEAR24.tags = "熊,北极熊,萌宠,动物圈"
        BEAR24.authorName = "饿了想吃小熊"
        BEAR24.cover =
            "https://i1.hdslb.com/bfs/archive/e7b87673791665f77549e1a2621b6861fa2470e6.jpg"
        BEAR24.videoType = 0
        list.add(BEAR24)

        val BEAR25 = PetVideo()
        BEAR25.type = PetType.BEAR.ordinal
        BEAR25.fileName = "pet_bear25"
        BEAR25.code = 1101
        BEAR25.duration = 104
        BEAR25.period = PeriodType.GROUP.ordinal
        BEAR25.isStar = false
        BEAR25.title = "【白熊】没办法 孩子太可爱了 必须要抱在怀里疯狂rua"
        BEAR25.releaseTime = "2020-09-25 19:31:00"
        BEAR25.originalUrl = "https://www.bilibili.com/video/BV1wh41197Ej"
        BEAR25.tags = "熊,北极熊,萌宠,动物圈"
        BEAR25.authorName = "饿了想吃小熊"
        BEAR25.cover =
            "https://i2.hdslb.com/bfs/archive/948414b4de1fe54dac8daba54fffc6bc28faf7d1.jpg"
        BEAR25.videoType = 0
        list.add(BEAR25)

        val BEAR26 = PetVideo()
        BEAR26.type = PetType.BEAR.ordinal
        BEAR26.fileName = "pet_bear26"
        BEAR26.code = 1102
        BEAR26.duration = 69
        BEAR26.period = PeriodType.GROUP.ordinal
        BEAR26.isStar = false
        BEAR26.title = "小北极熊：贴紧我的麻麻～"
        BEAR26.releaseTime = "2021-01-08 17:57:45"
        BEAR26.originalUrl = "https://www.bilibili.com/video/BV1ii4y1F7Rt"
        BEAR26.tags = "熊,北极熊,萌宠,动物圈"
        BEAR26.authorName = "乌苏里熊"
        BEAR26.cover =
            "https://i0.hdslb.com/bfs/archive/00abde84752a34cc57df624d67d40b68f8d3d2e3.jpg"
        BEAR26.videoType = 0
        list.add(BEAR26)

        val BEAR27 = PetVideo()
        BEAR27.type = PetType.BEAR.ordinal
        BEAR27.fileName = "pet_bear27"
        BEAR27.code = 1103
        BEAR27.duration = 16
        BEAR27.period = PeriodType.GROUP.ordinal
        BEAR27.isStar = false
        BEAR27.title = "海豹不小心吓到了北极熊宝宝，太可爱了"
        BEAR27.releaseTime = "2020-08-19 17:40:13"
        BEAR27.originalUrl = "https://www.bilibili.com/video/BV1Dt4y1U73T"
        BEAR27.tags = "熊,北极熊,萌宠,动物圈"
        BEAR27.authorName = "纱雾画画素材库"
        BEAR27.cover =
            "https://i2.hdslb.com/bfs/archive/dd4a99a29fdcbf12fb8b8386b0282e1d4906c505.png"
        BEAR27.videoType = 0
        list.add(BEAR27)

        val BEAR28 = PetVideo()
        BEAR28.type = PetType.BEAR.ordinal
        BEAR28.fileName = "pet_bear28"
        BEAR28.code = 1104
        BEAR28.duration = 66
        BEAR28.period = PeriodType.GROUP.ordinal
        BEAR28.isStar = false
        BEAR28.title = "小北极熊第一次玩冰块，场面一发不可收拾，憋住千万别笑！"
        BEAR28.releaseTime = "2022-01-04 19:23:25"
        BEAR28.originalUrl = "https://www.bilibili.com/video/BV13Z4y1S7G2"
        BEAR28.tags = "熊,北极熊,萌宠,动物圈"
        BEAR28.authorName = "小猪动物说"
        BEAR28.cover =
            "https://i1.hdslb.com/bfs/archive/ce0200642e76a2b558cac7d78ae80f7665a12f48.jpg"
        BEAR28.videoType = 0
        list.add(BEAR28)

        val BEAR29 = PetVideo()
        BEAR29.type = PetType.BEAR.ordinal
        BEAR29.fileName = "pet_bear29"
        BEAR29.code = 1105
        BEAR29.duration = 120
        BEAR29.period = PeriodType.GROUP.ordinal
        BEAR29.isStar = false
        BEAR29.title = "小熊：我有狗了！"
        BEAR29.releaseTime = "2021-12-28 11:10:04"
        BEAR29.originalUrl = "https://www.bilibili.com/video/BV1MR4y1s73f"
        BEAR29.tags = "熊,北极熊,萌宠,动物圈"
        BEAR29.authorName = "大熊苏尔"
        BEAR29.cover =
            "https://i1.hdslb.com/bfs/archive/8d0ff486edf3139b899e463d441dac43a609c728.jpg"
        BEAR29.videoType = 0
        list.add(BEAR29)

        val BEAR30 = PetVideo()
        BEAR30.type = PetType.BEAR.ordinal
        BEAR30.fileName = "pet_bear30"
        BEAR30.code = 1106
        BEAR30.duration = 76
        BEAR30.period = PeriodType.GROUP.ordinal
        BEAR30.isStar = false
        BEAR30.title = "出生不久的小狮子和小老虎，发出的声音很有趣"
        BEAR30.releaseTime = "2020-05-21 19:39:15"
        BEAR30.originalUrl = "https://www.bilibili.com/video/BV14t4y1C7UF"
        BEAR30.tags = "熊,北极熊,萌宠,动物圈"
        BEAR30.authorName = "克里米亚野生动物园"
        BEAR30.cover =
            "https://i0.hdslb.com/bfs/archive/ee88a5da1360deb386231fdc315adeb46fc7f3b0.jpg"
        BEAR30.videoType = 0
        list.add(BEAR30)

        val BEAR31 = PetVideo()
        BEAR31.type = PetType.BEAR.ordinal
        BEAR31.fileName = "pet_bear31"
        BEAR31.code = 1107
        BEAR31.duration = 132
        BEAR31.period = PeriodType.GROUP.ordinal
        BEAR31.isStar = false
        BEAR31.title = "【白熊】小北极熊Nora 出生7天到83天的变化"
        BEAR31.releaseTime = "2020-12-26 17:00:09"
        BEAR31.originalUrl = "https://www.bilibili.com/video/BV1di4y1c74e"
        BEAR31.tags = "熊,北极熊,萌宠,动物圈"
        BEAR31.authorName = "饿了想吃小熊"
        BEAR31.cover =
            "https://i2.hdslb.com/bfs/archive/059fbfb596156bcefea25632fe6934981cd9f5c6.jpg"
        BEAR31.videoType = 0
        list.add(BEAR31)

        val BEAR32 = PetVideo()
        BEAR32.type = PetType.BEAR.ordinal
        BEAR32.fileName = "pet_bear32"
        BEAR32.code = 1108
        BEAR32.duration = 166
        BEAR32.period = PeriodType.GROUP.ordinal
        BEAR32.isStar = false
        BEAR32.title = "北极熊也太可爱了吧？毛茸茸的大白狗"
        BEAR32.releaseTime = "2021-12-13 11:18:01"
        BEAR32.originalUrl = "https://www.bilibili.com/video/BV1kr4y1D7iQ"
        BEAR32.tags = "熊,北极熊,萌宠,动物圈"
        BEAR32.authorName = "姜不错ya"
        BEAR32.cover =
            "https://i0.hdslb.com/bfs/archive/c51ac2fbe69775fbacc724d5251fb288d53e721f.jpg"
        BEAR32.videoType = 0
        list.add(BEAR32)

        return list
    }

    private fun getMonkey(): MutableList<PetVideo> {


        val monkey1 = PetVideo()
        monkey1.type = PetType.GOLDEN_MONKEY.ordinal
        monkey1.fileName = "pet_monkey1"
        monkey1.code = 1109
        monkey1.duration = 104
        monkey1.period = PeriodType.GROUP.ordinal
        monkey1.isStar = true
        monkey1.title = "侏儒狨猴：世界上最小的猴子，可以让你体验佛祖的感受"
        monkey1.releaseTime = "2021-11-24 18:33:10"
        monkey1.originalUrl = "https://www.bilibili.com/video/BV18r4y1Q7g2"
        monkey1.tags = "熊,北极熊,萌宠,动物圈"
        monkey1.authorName = "嗑叔磕动物"
        monkey1.cover =
            "https://i1.hdslb.com/bfs/archive/2ad38cda9d445f82250eaa3746760e4ac822401e.jpg"
        monkey1.videoType = 0
        list.add(monkey1)

        val monkey2 = PetVideo()
        monkey2.type = PetType.GOLDEN_MONKEY.ordinal
        monkey2.fileName = "pet_monkey2"
        monkey2.code = 1110
        monkey2.duration = 22
        monkey2.period = PeriodType.GROUP.ordinal
        monkey2.isStar = true
        monkey2.title = "【金丝猴】这 意 境 绝 了，不 愧 是 国 宝"
        monkey2.releaseTime = "2020-02-25 22:58:08"
        monkey2.originalUrl = "https://www.bilibili.com/video/BV1u7411M7u6"
        monkey2.tags = "熊,北极熊,萌宠,动物圈"
        monkey2.authorName = "邹空文"
        monkey2.cover =
            "https://i0.hdslb.com/bfs/archive/6bb9554e8b9615019b4be1e9aa8aef621b1f0588.jpg"
        monkey2.videoType = 0
        list.add(monkey2)

        val monkey3 = PetVideo()
        monkey3.type = PetType.GOLDEN_MONKEY.ordinal
        monkey3.fileName = "pet_monkey3"
        monkey3.code = 1111
        monkey3.duration = 122
        monkey3.period = PeriodType.GROUP.ordinal
        monkey3.isStar = true
        monkey3.title = "可能是全站最好看的金丝猴宝宝优雅吃苹果，猴中皇族的颜值巅峰"
        monkey3.releaseTime = "2021-02-21 11:28:27"
        monkey3.originalUrl = "https://www.bilibili.com/video/BV1Xh411r7Zk"
        monkey3.tags = "熊,北极熊,萌宠,动物圈"
        monkey3.authorName = "野生摄像-萌萌小动物"
        monkey3.cover =
            "https://i2.hdslb.com/bfs/archive/281155469f15e365115b763c5b25cebf610de300.jpg"
        monkey3.videoType = 0
        list.add(monkey3)

        val monkey4 = PetVideo()
        monkey4.type = PetType.GOLDEN_MONKEY.ordinal
        monkey4.fileName = "pet_monkey4"
        monkey4.code = 1112
        monkey4.duration = 129
        monkey4.period = PeriodType.GROUP.ordinal
        monkey4.isStar = true
        monkey4.title = "川金丝猴：集灵秀、高贵和仙气于一身"
        monkey4.releaseTime = "2020-08-18 23:41:22"
        monkey4.originalUrl = "https://www.bilibili.com/video/BV1Ei4y1M71d"
        monkey4.tags = "熊,北极熊,萌宠,动物圈"
        monkey4.authorName = "糖霜虎皮卷"
        monkey4.cover =
            "https://i2.hdslb.com/bfs/archive/8553500fb6b7b8281b19231e3c71e643267e5c40.jpg"
        monkey4.videoType = 0
        list.add(monkey4)

        val monkey5 = PetVideo()
        monkey5.type = PetType.GOLDEN_MONKEY.ordinal
        monkey5.fileName = "pet_monkey5"
        monkey5.code = 1113
        monkey5.duration = 51
        monkey5.period = PeriodType.GROUP.ordinal
        monkey5.isStar = true
        monkey5.title = "猴中贵族，国宝美猴王- 金丝猴"
        monkey5.releaseTime = "2020-10-16 12:08:44"
        monkey5.originalUrl = "https://www.bilibili.com/video/BV1ei4y1j7xt"
        monkey5.tags = "熊,北极熊,萌宠,动物圈"
        monkey5.authorName = "哇喔Wow-"
        monkey5.cover =
            "https://i0.hdslb.com/bfs/archive/99be7b3338cec4ae64a3bc5fa560f95d4ba2677b.jpg"
        monkey5.videoType = 0
        list.add(monkey5)

        return list
    }
}