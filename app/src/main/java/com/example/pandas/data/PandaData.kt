import com.example.pandas.bean.pet.PeriodType
import com.example.pandas.bean.pet.PetType
import com.example.pandas.bean.pet.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 9:10 下午
 * @version: v1.0
 */
public class PandaData {

    private val list = mutableListOf<PetVideo>()

    fun getBabyHeHua() {

        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_baby_1"
        panda.code = 1
        panda.duration = 53
        panda.period = PeriodType.BABY.ordinal
        panda.originalUrl = "https://www.bilibili.com/video/BV1Sh411h7tG?share_source=copy_web"
        panda.releaseTime = "2021-07-11 15:40:24"
        panda.title = "奶爸在线教学rua和花，你学废了吗？"
        panda.tags = "萌宠,大熊猫,熊猫宝宝,和花,熊猫基地,奶爸"
        panda.authorName = "瘦瘦爱吃粘豆包"
        panda.cover = "http://i1.hdslb.com/bfs/archive/f67baa59ade92acfb8397527e4453f7d19fe55b0.jpg"
        list.add(panda)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_baby_2"
        panda2.code = 2
        panda2.duration = 56
        panda2.period = PeriodType.BABY.ordinal
        panda2.originalUrl = "https://www.bilibili.com/video/BV13L411H76G?share_source=copy_web"
        panda2.releaseTime = "2021-07-12 17:42:40"
        panda2.title = "第一次上树摔下来的花花又被奶爸一顿狂宠。【大熊猫和花】"
        panda2.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地,奶爸"
        panda2.authorName = "隽一一"
        panda2.cover =
            "http://i2.hdslb.com/bfs/archive/a1bc7070d4ca09cce27e10281260cf6fe1ac2cfe.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_baby_3"
        panda3.code = 3
        panda3.duration = 12
        panda3.period = PeriodType.BABY.ordinal
        panda3.originalUrl = "https://www.bilibili.com/video/BV1R54y1n7Xb?share_source=copy_web"
        panda3.releaseTime = "2021-07-12 19:12:03"
        panda3.title = "和花在线求抱抱，谁不想拥有呢"
        panda3.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地,奶爸"
        panda3.authorName = "开饭了大熊猫V"
        panda3.cover =
            "http://i1.hdslb.com/bfs/archive/0522bcacb51e908a72000134ec3a98ca810cfac7.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_baby_4"
        panda4.code = 4
        panda4.duration = 9
        panda4.period = PeriodType.BABY.ordinal
        panda4.originalUrl = "https://www.bilibili.com/video/BV1G5411M7g7?share_source=copy_web"
        panda4.releaseTime = "2021-06-02 21:51:40"
        panda4.title = "大熊猫和花：哼！我是别人家的小宝贝了！"
        panda4.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地"
        panda4.authorName = "西柚熊猫官方账号"
        panda4.cover =
            "http://i1.hdslb.com/bfs/archive/5609a81a05f3cf902442754cd1e90830af9cb3c9.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_baby_5"
        panda5.code = 5
        panda5.duration = 169
        panda5.period = PeriodType.BABY.ordinal
        panda5.originalUrl = "https://www.bilibili.com/video/BV1W54y1Y7xw?share_source=copy_web"
        panda5.releaseTime = "2021-02-15 15:20:57"
        panda5.title = "和花：这是我地盘，金喜弟弟你再上打你哈~"
        panda5.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,金喜,熊猫基地"
        panda5.authorName = "迩後咩"
        panda5.cover =
            "http://i2.hdslb.com/bfs/archive/d5f1983ddc962f2539be88e6757cbc8387448ff5.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_baby_6"
        panda6.code = 6
        panda6.duration = 33
        panda6.period = PeriodType.BABY.ordinal
        panda6.originalUrl = "https://www.bilibili.com/video/BV1dp4y1s7Pd?share_source=copy_web"
        panda6.releaseTime = "2021-01-12 13:00:17"
        panda6.title = "和花，新的一天，新的可爱"
        panda6.tags = "萌宠,动物圈,大熊猫,滚滚,熊猫宝宝,和花,熊猫基地"
        panda6.authorName = "iPanda熊猫频道"
        panda6.cover =
            "http://i0.hdslb.com/bfs/archive/8201696bd505a92f542b1259855919845b75ffcd.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_baby_7"
        panda7.code = 7
        panda7.duration = 60
        panda7.period = PeriodType.BABY.ordinal
        panda7.originalUrl = "https://www.bilibili.com/video/BV17K4y1M77Y?share_source=copy_web"
        panda7.releaseTime = "2021-07-07 22:00:05"
        panda7.title = "【大熊猫和花】这么会撒娇的女鹅，谁不想拥有"
        panda7.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地"
        panda7.authorName = "小香妞爱熊猫"
        panda7.cover =
            "http://i2.hdslb.com/bfs/archive/b9723b282127682a2ed3013179411ab5ead3a75d.jpg"
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = PetType.PANDA.ordinal
        panda8.fileName = "panda_baby_8"
        panda8.code = 8
        panda8.duration = 41
        panda8.period = PeriodType.BABY.ordinal
        panda8.originalUrl = "https://www.bilibili.com/video/BV1hq4y1P7Lc?share_source=copy_web"
        panda8.releaseTime = "2021-10-01 09:30:04"
        panda8.title = "小和花撒娇求摸摸"
        panda8.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地,奶妈"
        panda8.authorName = "爱熊猫aipanda"
        panda8.cover =
            "http://i2.hdslb.com/bfs/archive/55a766e99022f133a3f9de546626f069afccb2e5.jpg"
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_baby_9"
        panda9.code = 9
        panda9.duration = 186
        panda9.period = PeriodType.BABY.ordinal
        panda9.originalUrl = "https://www.bilibili.com/video/BV1e64y1a71b?share_source=copy_web"
        panda9.releaseTime = "2021-08-25 20:00:13"
        panda9.title = "大熊猫和花睡觉有多可爱？也就看了亿遍吧！"
        panda9.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地,睡眠"
        panda9.authorName = "iPanda熊猫频道"
        panda9.cover =
            "http://i1.hdslb.com/bfs/archive/4a56147f2ebd5e89b434a9bf5b3ad920339f14eb.jpg"
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = PetType.PANDA.ordinal
        panda10.fileName = "panda_baby_10"
        panda10.code = 10
        panda10.duration = 258
        panda10.period = PeriodType.BABY.ordinal
        panda10.originalUrl = "https://www.bilibili.com/video/BV18K4y1g7Th?share_source=copy_web"
        panda10.releaseTime = "2021-07-04 13:35:04"
        panda10.title = "和花叶叶一岁养成记！今后请继续散发萌力！"
        panda10.tags = "萌宠,动物圈,大熊猫,熊猫宝宝,和花,熊猫基地"
        panda10.authorName = "pandapia熊猫乌托邦"
        panda10.cover =
            "http://i1.hdslb.com/bfs/archive/5d9c3e2ab49a927d84f5efd699470818c3f1f856.jpg"
        list.add(panda10)

        val panda11 = PetVideo()
        panda11.type = PetType.PANDA.ordinal
        panda11.fileName = "panda_baby_11"
        panda11.code = 11
        panda11.duration = 184
        panda11.period = PeriodType.BABY.ordinal
        panda11.originalUrl = "https://www.bilibili.com/video/BV1LM4y1u7Dp?share_source=copy_web"
        panda11.releaseTime = "2021-06-18 20:30:18"
        panda11.title = "养大一只“小和花”，需要多少瓶瓶奶？"
        panda11.tags = "萌宠,萌宠星探官,熊猫基地,和花,萌萌哒,原创,呆萌,滚滚,可爱,熊猫宝宝,大熊猫和花,动物圈,大熊猫"
        panda11.authorName = "iPanda熊猫频道"
        panda11.cover =
            "http://i0.hdslb.com/bfs/archive/2ea77fd269bb42cd21529f2d5a554cfc1c20f56e.jpg"
        list.add(panda11)

        val panda12 = PetVideo()
        panda12.type = PetType.PANDA.ordinal
        panda12.fileName = "panda_baby_12"
        panda12.code = 12
        panda12.duration = 69
        panda12.period = PeriodType.BABY.ordinal
        panda12.originalUrl = "https://www.bilibili.com/video/BV19V411U7nX?share_source=copy_web"
        panda12.releaseTime = "2020-08-21 18:53:52"
        panda12.title = "炸毛小和花"
        panda12.tags = "大熊猫,和花,观察动物,打卡挑战,动物圈,大熊猫"
        panda12.authorName = "迩後咩"
        panda12.cover =
            "http://i2.hdslb.com/bfs/archive/9c927f380c1190e03cb9826b84b29d8a79b16b3b.jpg"
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = PetType.PANDA.ordinal
        panda13.fileName = "panda_baby_13"
        panda13.code = 13
        panda13.duration = 26
        panda13.period = PeriodType.BABY.ordinal
        panda13.originalUrl = "https://www.bilibili.com/video/BV1mU4y137M6?share_source=copy_web"
        panda13.releaseTime = "2021-07-13 19:49:06"
        panda13.title = "大熊猫和花~花花性格真的好好啊，摔了还卖萌心动了"
        panda13.tags = "大熊猫,萌宠,和花,滚滚,卖萌,可爱,动物圈,大熊猫"
        panda13.authorName = "大威德冥王"
        panda13.cover =
            "http://i2.hdslb.com/bfs/archive/774a251c33c105799a32293020f307338b206990.jpg"
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_baby_14"
        panda14.code = 14
        panda14.duration = 29
        panda14.period = PeriodType.BABY.ordinal
        panda14.originalUrl = "https://www.bilibili.com/video/BV1Q54y1z7vY?share_source=copy_web"
        panda14.releaseTime = "2020-11-27 17:30:08"
        panda14.title = "有没有人看见和花的朵朵，它好像不见了～"
        panda14.tags = "大熊猫,萌宠,搞笑,温暖这个冬天,动物,可爱,日常,动物圈,萌宠vlog,动物圈,大熊猫"
        panda14.authorName = "iPanda熊猫频道"
        panda14.cover =
            "http://i0.hdslb.com/bfs/archive/1a02a69fa4a8d1782ddebb3831b3d8ad0247994d.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_baby_15"
        panda15.code = 15
        panda15.duration = 11
        panda15.period = PeriodType.BABY.ordinal
        panda15.originalUrl = "https://www.bilibili.com/video/BV1xp4y1W7N6?share_source=copy_web"
        panda15.releaseTime = "2021-01-26 16:56:33"
        panda15.title = "我有了一个大胆的想法，大熊猫和花"
        panda15.tags = "大熊猫和花,大熊猫,国宝,可爱,熊猫宝宝,打卡挑战,动物圈"
        panda15.authorName = "熊猫能量社区"
        panda15.cover =
            "http://i1.hdslb.com/bfs/archive/f8b5ba0f2bc870bb2dd333bd71a47707b4c4c401.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
        panda16.fileName = "panda_baby_16"
        panda16.code = 16
        panda16.duration = 83
        panda16.period = PeriodType.BABY.ordinal
        panda16.title = "【大熊猫和花】来吧，萌翻你~"
        panda16.releaseTime = "2021-01-14 16:45:11"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1S5411n7YU?share_source=copy_web"
        panda16.tags = "大熊猫,萌宠,日常,呆萌,国宝,可爱,萌萌哒,动物圈,大熊猫和花"
        panda16.authorName = "辛辛糖包"
        panda16.cover =
            "http://i0.hdslb.com/bfs/archive/1c7d81b991b5c68ca2d24be9087061d88ae6e9e1.jpg"
        list.add(panda16)

        val panda17 = PetVideo()
        panda17.type = PetType.PANDA.ordinal
        panda17.fileName = "panda_baby_17"
        panda17.code = 17
        panda17.duration = 120
        panda17.period = PeriodType.BABY.ordinal
        panda17.title = "【大熊猫和花】牙牙都还没长齐，就学吃竹子啦？"
        panda17.releaseTime = "2021-01-07 20:17:41"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1D64y1Z7zW?share_source=copy_web"
        panda17.tags = "大熊猫,萌宠,必剪创作,滚滚,国宝,日常,可爱,呆萌,动物圈,大熊猫和花"
        panda17.authorName = "辛辛糖包"
        panda17.isStar = true
        panda17.cover =
            "http://i1.hdslb.com/bfs/archive/aa002fb41c6efe49402b5131dfbfc5db40466f8f.jpg"
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_baby_18"
        panda18.code = 18
        panda18.duration = 170
        panda18.period = PeriodType.BABY.ordinal
        panda18.title = "【大熊猫和花】翻身困难户~"
        panda18.releaseTime = "2020-12-06 16:51:34"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1XT4y1T7G6?share_source=copy_web"
        panda18.tags = "大熊猫,国宝,动物圈,打卡挑战,大熊猫和花"
        panda18.authorName = "辛辛糖包"
        panda18.cover =
            "http://i2.hdslb.com/bfs/archive/071f7432f32c60b4753377cda026dc30ba3894b8.jpg"
        list.add(panda18)

        val panda19 = PetVideo()
        panda19.type = PetType.PANDA.ordinal
        panda19.fileName = "panda_baby_19"
        panda19.code = 19
        panda19.duration = 110
        panda19.period = PeriodType.BABY.ordinal
        panda19.title = "【大熊猫和花】脑袋太沉了，一不小心就倒栽葱"
        panda19.releaseTime = "2021-01-23 15:56:04"
        panda19.originalUrl = "https://www.bilibili.com/video/BV1xy4y1p7ay?share_source=copy_web"
        panda19.tags = "大熊猫,萌宠,搞笑,国宝,日常,动物圈,萌宠vlog,大熊猫和花,动物圈"
        panda19.authorName = "辛辛糖包"
        panda19.cover =
            "http://i2.hdslb.com/bfs/archive/effaf89e1d1605320b7c880f483dffbb5c609758.jpg"
        list.add(panda19)

        val panda20 = PetVideo()
        panda20.type = PetType.PANDA.ordinal
        panda20.fileName = "panda_baby_20"
        panda20.code = 20
        panda20.duration = 157
        panda20.period = PeriodType.BABY.ordinal
        panda20.title = "【大熊猫和花】这位小熊友，你是坐着？跪着？还是蹲着的"
        panda20.releaseTime = "2020-12-09 18:59:36"
        panda20.originalUrl = "https://www.bilibili.com/video/BV1Lp4y1z74v?share_source=copy_web"
        panda20.tags = "大熊猫,萌宠,搞笑,大熊猫和花,可爱,小短腿,国宝,动物圈"
        panda20.authorName = "辛辛糖包"
        panda20.cover =
            "http://i2.hdslb.com/bfs/archive/fef42809f5fbbd10e810029b80cd85a22437038b.jpg"
        list.add(panda20)

        val panda21 = PetVideo()
        panda21.type = PetType.PANDA.ordinal
        panda21.fileName = "panda_baby_21"
        panda21.code = 21
        panda21.duration = 129
        panda21.period = PeriodType.BABY.ordinal
        panda21.title = "哈哈和花胆肥了，敢碰瓷艾玖姐姐了，打完了跑，看没事又去"
        panda21.releaseTime = "2021-02-10 13:50:53"
        panda21.originalUrl = "https://www.bilibili.com/video/BV11K4y1p779?share_source=copy_web"
        panda21.tags = "大熊猫,和花,艾玖,动物圈"
        panda21.authorName = "迩後咩"
        panda21.cover =
            "http://i2.hdslb.com/bfs/archive/9255a6dc22ee1ff65be59c063da88a52e402eef4.jpg"
        list.add(panda21)

        val panda22 = PetVideo()
        panda22.type = PetType.PANDA.ordinal
        panda22.fileName = "panda_baby_22"
        panda22.code = 22
        panda22.duration = 211
        panda22.period = PeriodType.BABY.ordinal
        panda22.title = "【大熊猫和花】滚下木架爬不上去了，嘤嘤嘤小奶音好捉急"
        panda22.releaseTime = "2020-11-15 22:25:33"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1At4y1v7K2?share_source=copy_web"
        panda22.tags = "大熊猫,萌宠,和花,可爱,动物圈"
        panda22.authorName = "辛辛糖包"
        panda22.cover =
            "http://i0.hdslb.com/bfs/archive/fc2d88118a2d7b99fc555b66957fa8f914fdf968.jpg"
        list.add(panda22)

        val panda23 = PetVideo()
        panda23.type = PetType.PANDA.ordinal
        panda23.fileName = "panda_baby_23"
        panda23.code = 23
        panda23.duration = 119
        panda23.period = PeriodType.BABY.ordinal
        panda23.title = "【大熊猫和花】累了就停下休息一会，休息好了再继续努力~"
        panda23.releaseTime = "2021-09-02 01:13:06"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1gP4y1W7w7?share_source=copy_web"
        panda23.tags = "大熊猫,萌宠,治愈,萌萌哒,励志,大熊猫和花,动物圈"
        panda23.authorName = "辛辛糖包"
        panda23.cover =
            "http://i0.hdslb.com/bfs/archive/3da2754848c34e9e131bb746a554e3d53aaa1944.jpg"
        list.add(panda23)

        val panda24 = PetVideo()
        panda24.type = PetType.PANDA.ordinal
        panda24.fileName = "panda_baby_24"
        panda24.code = 24
        panda24.duration = 18
        panda24.period = PeriodType.BABY.ordinal
        panda24.title = "【和花】小花花被生活了提溜起来！"
        panda24.releaseTime = "2021-09-06 22:36:33"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1Yf4y1J7jq?share_source=copy_web"
        panda24.tags = "大熊猫,萌宠,国宝,滚滚,花花,可爱,熊猫宝宝,动物圈"
        panda24.authorName = "英语一不过六十不改名"
        panda24.cover =
            "http://i1.hdslb.com/bfs/archive/7cdf06b2157f70f5a32083c64ef84c61f716cfe4.jpg"
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = PetType.PANDA.ordinal
        panda25.fileName = "panda_baby_25"
        panda25.code = 25
        panda25.duration = 15
        panda25.period = PeriodType.BABY.ordinal
        panda25.title = "和花小时候还在学爬的时候"
        panda25.releaseTime = "2021-04-24 19:10:16"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1r54y1L7mr?share_source=copy_web"
        panda25.tags = "大熊猫,国宝,动物圈,熊猫,熊猫宝宝"
        panda25.authorName = "开饭了大熊猫V"
        panda25.cover =
            "http://i0.hdslb.com/bfs/archive/ce98b180efe750726e4c69125cadcfdd19105600.jpg"
        list.add(panda25)

        val panda26 = PetVideo()
        panda26.type = PetType.PANDA.ordinal
        panda26.fileName = "panda_baby_26"
        panda26.code = 26
        panda26.duration = 87
        panda26.period = PeriodType.BABY.ordinal
        panda26.title = "小熊猫和花吃饱饱，在角落磨牙牙～"
        panda26.releaseTime = "2021-02-08 18:09:14"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1iz4y1U7j9?share_source=copy_web"
        panda26.tags = "萌宠,可爱,铲屎官,国宝,滚滚,动物圈,大熊猫"
        panda26.authorName = "古惟寞其铭"
        panda26.cover =
            "http://i1.hdslb.com/bfs/archive/2cef2fee9e7b1b14a302dc4804ce0c222bc9262d.jpg"
        list.add(panda26)

        val panda27 = PetVideo()
        panda27.type = PetType.PANDA.ordinal
        panda27.fileName = "panda_baby_27"
        panda27.code = 27
        panda27.duration = 28
        panda27.period = PeriodType.BABY.ordinal
        panda27.title = "和花技能都点在颜值上面了吧"
        panda27.releaseTime = "2021-01-18 17:30:09"
        panda27.originalUrl = "https://www.bilibili.com/video/BV14U4y147Qx?share_source=copy_web"
        panda27.tags = "大熊猫,萌宠,搞笑,滚滚,日常,原创,卖萌,动物圈,萌宠vlog"
        panda27.authorName = "iPanda熊猫频道"
        panda27.cover =
            "http://i1.hdslb.com/bfs/archive/2e6b202c2c296f189caba7c3b4e5620a2c2bfb17.jpg"
        list.add(panda27)

        val panda28 = PetVideo()
        panda28.type = PetType.PANDA.ordinal
        panda28.fileName = "panda_baby_28"
        panda28.code = 28
        panda28.duration = 167
        panda28.period = PeriodType.BABY.ordinal
        panda28.title = "【大熊猫和花】有这颜值，还要啥战斗力啊"
        panda28.releaseTime = "2021-01-28 19:25:10"
        panda28.originalUrl = "https://www.bilibili.com/video/BV1Hv411e7GR?share_source=copy_web"
        panda28.tags = "大熊猫,萌宠,日常,国宝,动物圈,大熊猫和花"
        panda28.authorName = "辛辛糖包"
        panda28.cover =
            "http://i1.hdslb.com/bfs/archive/74a00f779aa2d37d4c3722263e97c163335e8c8c.jpg"
        list.add(panda28)

        val panda29 = PetVideo()
        panda29.type = PetType.PANDA.ordinal
        panda29.fileName = "panda_baby_29"
        panda29.code = 29
        panda29.duration = 67
        panda29.period = PeriodType.BABY.ordinal
        panda29.title = "看着小花花入睡也是种幸福【大熊猫和花】"
        panda29.releaseTime = "2020-12-28 13:47:55"
        panda29.originalUrl = "https://www.bilibili.com/video/BV1Ry4y1i7bY?share_source=copy_web"
        panda29.tags = "大熊猫,和花,动物圈"
        panda29.authorName = "迩後咩"
        panda29.cover =
            "http://i2.hdslb.com/bfs/archive/357bba58c225b35e1dc438ff5ada5640a7c52302.jpg"
        list.add(panda29)

        val panda30 = PetVideo()
        panda30.type = PetType.PANDA.ordinal
        panda30.fileName = "panda_baby_30"
        panda30.code = 30
        panda30.duration = 180
        panda30.period = PeriodType.BABY.ordinal
        panda30.title = "【熊猫和花】整理女儿和花所有美丽的瞬间，拥有这个视频，你就拥有了和花"
        panda30.releaseTime = "2021-06-13 18:40:01"
        panda30.originalUrl = "https://www.bilibili.com/video/BV1R64y1R7A1?share_source=copy_web"
        panda30.tags = "大熊猫,萌宠,搞笑,可爱,萌萌哒,熊猫基地,熊猫宝宝,动物圈"
        panda30.authorName = "水果小分队的椰子"
        panda30.cover =
            "http://i1.hdslb.com/bfs/archive/7b5ab4f58bc8652f16c7f370064afe1813196950.jpg"
        list.add(panda30)

        val panda31 = PetVideo()
        panda31.type = PetType.PANDA.ordinal
        panda31.fileName = "panda_baby_31"
        panda31.code = 31
        panda31.duration = 180
        panda31.period = PeriodType.BABY.ordinal
        panda31.title = "【熊猫和花】女儿的精彩瞬间，看完整个人都酥敷了！"
        panda31.releaseTime = "2021-04-07 18:05:17"
        panda31.originalUrl = "https://www.bilibili.com/video/BV1J54y1h7Ve?share_source=copy_web"
        panda31.tags = "萌宠,搞笑,日常,治愈,可爱,熊猫,动物圈,动物圈,大熊猫"
        panda31.authorName = "水果小分队的椰子"
        panda31.cover =
            "http://i1.hdslb.com/bfs/archive/c7af518e0a1fefd5b0f79248d4d9ca86786716af.jpg"
        list.add(panda31)

        val panda32 = PetVideo()
        panda32.type = PetType.PANDA.ordinal
        panda32.fileName = "panda_baby_32"
        panda32.code = 32
        panda32.duration = 44
        panda32.period = PeriodType.BABY.ordinal
        panda32.title = "小天使“和花”刚满三月的调皮日记"
        panda32.releaseTime = "2021-05-04 17:50:15"
        panda32.originalUrl = "https://www.bilibili.com/video/BV1764y1275t?share_source=copy_web"
        panda32.tags = "大熊猫,萌宠,搞笑,萌萌哒,生活,可爱,日常,动物圈"
        panda32.authorName = "水果小分队的椰子"
        panda32.cover =
            "http://i2.hdslb.com/bfs/archive/8e0414e5a33f85f22e8865401d7bfbafc30e6f35.jpg"
        list.add(panda32)

        val panda33 = PetVideo()
        panda33.type = PetType.PANDA.ordinal
        panda33.fileName = "panda_baby_33"
        panda33.code = 57
        panda33.duration = 18
        panda33.period = PeriodType.BABY.ordinal
        panda33.title = "你如果是奶爸，能顶地住吗？"
        panda33.releaseTime = "2021-07-05 19:49:41"
        panda33.originalUrl = "https://www.bilibili.com/video/BV14K4y1g71o?share_source=copy_web"
        panda33.tags = "大熊猫,萌宠,搞笑,萌萌哒,生活,可爱,日常,动物圈"
        panda33.authorName = "SEEU西柚熊猫"
        panda33.cover =
            "http://i0.hdslb.com/bfs/archive/a71090881640e6fc1ec18f06235ab7b6a9b19a92.jpg"
        list.add(panda33)

        val panda34 = PetVideo()
        panda34.type = PetType.PANDA.ordinal
        panda34.fileName = "panda_baby_34"
        panda34.code = 72
        panda34.duration = 60
        panda34.period = PeriodType.BABY.ordinal
        panda34.title = "又是被小和花萌醒的一天【大熊猫】"
        panda34.releaseTime = "2020-11-13 09:30:46"
        panda34.originalUrl = "https://www.bilibili.com/video/BV1zz4y1y7r9?share_source=copy_web"
        panda34.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda34.authorName = "迩後咩"
        panda34.cover =
            "http://i1.hdslb.com/bfs/archive/777b0fe5fe8f2b70321dc2a100fc02d907851208.jpg"
        list.add(panda34)

        val panda35 = PetVideo()
        panda35.type = PetType.PANDA.ordinal
        panda35.fileName = "panda_baby_35"
        panda35.code = 73
        panda35.duration = 75
        panda35.period = PeriodType.BABY.ordinal
        panda35.title = "小和花会翻小木架啦～甚是欣慰～"
        panda35.releaseTime = "2020-11-20 10:31:13"
        panda35.originalUrl = "https://www.bilibili.com/video/BV1qf4y1q7Mu?share_source=copy_web"
        panda35.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda35.authorName = "迩後咩"
        panda35.cover =
            "http://i2.hdslb.com/bfs/archive/6f7dd7d4c9e08884d3d1421f689df5910124a5dc.jpg"
        list.add(panda35)

        val panda36 = PetVideo()
        panda36.type = PetType.PANDA.ordinal
        panda36.fileName = "panda_baby_36"
        panda36.code = 74
        panda36.duration = 64
        panda36.period = PeriodType.BABY.ordinal
        panda36.title = "小和花要翻面～艾玖姐姐在一旁给妹妹加油"
        panda36.releaseTime = "2020-11-23 10:06:09"
        panda36.originalUrl = "https://www.bilibili.com/video/BV1sV411a7Wh?share_source=copy_web"
        panda36.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,艾玖,动物圈"
        panda36.authorName = "迩後咩"
        panda36.cover =
            "http://i1.hdslb.com/bfs/archive/3e3b91a876d301155c7c24df06c697a7a88713c0.jpg"
        list.add(panda36)

        val panda37 = PetVideo()
        panda37.type = PetType.PANDA.ordinal
        panda37.fileName = "panda_baby_37"
        panda37.code = 75
        panda37.duration = 86
        panda37.period = PeriodType.BABY.ordinal
        panda37.title = "大熊猫和花～扑腾的小短腿"
        panda37.releaseTime = "2020-12-03 20:53:39"
        panda37.originalUrl = "https://www.bilibili.com/video/BV1L54y167KP?share_source=copy_web"
        panda37.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda37.authorName = "迩後咩"
        panda37.cover =
            "http://i1.hdslb.com/bfs/archive/3cf6cd86db0acbaaa4c69cef1fa75bffa090d65a.jpg"
        list.add(panda37)

        val panda38 = PetVideo()
        panda38.type = PetType.PANDA.ordinal
        panda38.fileName = "panda_baby_38"
        panda38.code = 76
        panda38.duration = 57
        panda38.period = PeriodType.BABY.ordinal
        panda38.title = "和花妹妹自娱自乐被自己撂倒两次"
        panda38.releaseTime = "2020-12-17 13:38:36"
        panda38.originalUrl = "https://www.bilibili.com/video/BV11h411Z7CK?share_source=copy_web"
        panda38.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda38.authorName = "迩後咩"
        panda38.cover =
            "http://i1.hdslb.com/bfs/archive/3e74631c52e88a32e9dbbface286ac75088b7892.jpg"
        list.add(panda38)

        val panda39 = PetVideo()
        panda39.type = PetType.PANDA.ordinal
        panda39.fileName = "panda_baby_39"
        panda39.code = 77
        panda39.duration = 40
        panda39.period = PeriodType.BABY.ordinal
        panda39.title = "可爱三连击系列之“和花”"
        panda39.releaseTime = "2021-01-19 21:30:09"
        panda39.originalUrl = "https://www.bilibili.com/video/BV1mt4y1z7VQ?share_source=copy_web"
        panda39.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda39.authorName = "iPanda熊猫频道"
        panda39.cover =
            "http://i0.hdslb.com/bfs/archive/339f9de993a579260e5fd5c53e27b539df40e56d.jpg"
        list.add(panda39)

        val panda40 = PetVideo()
        panda40.type = PetType.PANDA.ordinal
        panda40.fileName = "panda_baby_40"
        panda40.code = 78
        panda40.duration = 127
        panda40.period = PeriodType.BABY.ordinal
        panda40.title = "小fafa是棉花糖吧【大熊猫和花】"
        panda40.releaseTime = "2021-01-15 13:38:07"
        panda40.originalUrl = "https://www.bilibili.com/video/BV1Et4y1z76Q?share_source=copy_web"
        panda40.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda40.authorName = "迩後咩"
        panda40.cover =
            "http://i1.hdslb.com/bfs/archive/a20b16d3ce68d1ed8cf6f7a3accdfd5d84e240b0.jpg"
        list.add(panda40)

        val panda41 = PetVideo()
        panda41.type = PetType.PANDA.ordinal
        panda41.fileName = "panda_baby_41"
        panda41.code = 79
        panda41.duration = 117
        panda41.period = PeriodType.BABY.ordinal
        panda41.title = "和花和金双妹妹一起探小门，奈何都太软萌易倒"
        panda41.releaseTime = "2021-01-26 17:12:31"
        panda41.originalUrl = "https://www.bilibili.com/video/BV1df4y1k7sD?share_source=copy_web"
        panda41.tags = "和花,金双,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda41.authorName = "迩後咩"
        panda41.cover =
            "http://i1.hdslb.com/bfs/archive/5089d66ef0ea32ad350b7bf38674a78f8e45cd35.jpg"
        list.add(panda41)

        val panda42 = PetVideo()
        panda42.type = PetType.PANDA.ordinal
        panda42.fileName = "panda_baby_42"
        panda42.code = 80
        panda42.duration = 39
        panda42.period = PeriodType.BABY.ordinal
        panda42.title = "阳光下花花闪闪发光～大熊猫和花"
        panda42.releaseTime = "2021-03-06 18:01:29"
        panda42.originalUrl = "https://www.bilibili.com/video/BV1Ey4y1E7ak?share_source=copy_web"
        panda42.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda42.authorName = "迩後咩"
        panda42.cover =
            "http://i1.hdslb.com/bfs/archive/34dce93d903ae4d23294b2a02d0f379cb7eb066d.jpg"
        list.add(panda42)

        val panda43 = PetVideo()
        panda43.type = PetType.PANDA.ordinal
        panda43.fileName = "panda_baby_43"
        panda43.code = 81
        panda43.duration = 64
        panda43.period = PeriodType.BABY.ordinal
        panda43.title = "fafa呀~大熊猫和花"
        panda43.releaseTime = "2021-03-27 14:50:10"
        panda43.originalUrl = "https://www.bilibili.com/video/BV1UK4y127BU?share_source=copy_web"
        panda43.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda43.authorName = "迩後咩"
        panda43.cover =
            "http://i1.hdslb.com/bfs/archive/e1473c9958bc0e33abd259ea9f4abda9e5b6bbef.jpg"
        list.add(panda43)

        val panda44 = PetVideo()
        panda44.type = PetType.PANDA.ordinal
        panda44.fileName = "panda_baby_44"
        panda44.code = 82
        panda44.duration = 18
        panda44.period = PeriodType.BABY.ordinal
        panda44.title = "花花可爱小片段【大熊猫和花】"
        panda44.releaseTime = "2021-05-20 17:09:00"
        panda44.originalUrl = "https://www.bilibili.com/video/BV19A411G7jE?share_source=copy_web"
        panda44.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda44.authorName = "迩後咩"
        panda44.cover =
            "http://i0.hdslb.com/bfs/archive/0f560c43ee0f7d4656c8ca41207cb80584ec393f.jpg"
        list.add(panda44)

        val panda45 = PetVideo()
        panda45.type = PetType.PANDA.ordinal
        panda45.fileName = "panda_baby_45"
        panda45.code = 83
        panda45.duration = 106
        panda45.period = PeriodType.BABY.ordinal
        panda45.title = "和花：捂着框框，奶爸就干不了活了吧"
        panda45.releaseTime = "2021-04-21 12:31:07"
        panda45.originalUrl = "https://www.bilibili.com/video/BV1eh411S7p3?share_source=copy_web"
        panda45.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda45.authorName = "迩後咩"
        panda45.cover =
            "http://i2.hdslb.com/bfs/archive/677d9356b9d3ac05d3e3e5d972af0d5a3a808e77.jpg"
        list.add(panda45)

        val panda46 = PetVideo()
        panda46.type = PetType.PANDA.ordinal
        panda46.fileName = "panda_baby_46"
        panda46.code = 84
        panda46.duration = 21
        panda46.period = PeriodType.BABY.ordinal
        panda46.title = "和花花无心营业，任奶爸摆放"
        panda46.releaseTime = "2021-05-14 16:53:05"
        panda46.originalUrl = "https://www.bilibili.com/video/BV1mK4y1A7zJ?share_source=copy_web"
        panda46.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda46.authorName = "迩後咩"
        panda46.cover =
            "http://i0.hdslb.com/bfs/archive/48f690ce03043e414a9cf443b443b80abe554e63.jpg"
        list.add(panda46)

        //720p
        val panda47 = PetVideo()
        panda47.type = PetType.PANDA.ordinal
        panda47.fileName = "panda_baby_47"
        panda47.code = 85
        panda47.duration = 37
        panda47.period = PeriodType.BABY.ordinal
        panda47.title = "大头花被福禄娃来回碾压210327(大熊猫和花)"
        panda47.releaseTime = "2021-03-28 10:31:58"
        panda47.originalUrl = "https://www.bilibili.com/video/BV1eK4y1T76m?share_source=copy_web"
        panda47.tags = "和花,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda47.authorName = "和花花真好看"
        panda47.cover =
            "http://i2.hdslb.com/bfs/archive/525b3b15da2fe501f3d956bfa305e6929d06cc6f.jpg"
        list.add(panda47)

        //720p
        val panda48 = PetVideo()
        panda48.type = PetType.PANDA.ordinal
        panda48.fileName = "panda_baby_48"
        panda48.code = 86
        panda48.duration = 32
        panda48.period = PeriodType.BABY.ordinal
        panda48.title = "战五渣和花被弟弟妹妹围殴210327(大熊猫和花)"
        panda48.releaseTime = "2021-03-28 00:37:25"
        panda48.originalUrl = "https://www.bilibili.com/video/BV1di4y1P7C8?share_source=copy_web"
        panda48.tags = "和花,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda48.authorName = "和花花真好看"
        panda48.cover =
            "http://i1.hdslb.com/bfs/archive/55dc10e011097a39f485c790d17a945169a450f9.jpg"
        list.add(panda48)

        val panda49 = PetVideo()
        panda49.type = PetType.PANDA.ordinal
        panda49.fileName = "panda_baby_49"
        panda49.code = 87
        panda49.duration = 75
        panda49.period = PeriodType.BABY.ordinal
        panda49.title = "温柔的月嫂和花照顾重阳弟弟(大熊猫和花)pandapia录屏"
        panda49.releaseTime = "2021-02-26 15:10:08"
        panda49.originalUrl = "https://www.bilibili.com/video/BV1FK4y1D7Dv?share_source=copy_web"
        panda49.tags = "和花,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda49.authorName = "和花花真好看"
        panda49.cover =
            "http://i1.hdslb.com/bfs/archive/8705c031953b27589e449759fe081656672264fb.jpg"
        list.add(panda49)

        val panda50 = PetVideo()
        panda50.type = PetType.PANDA.ordinal
        panda50.fileName = "panda_baby_50"
        panda50.code = 88
        panda50.duration = 110
        panda50.period = PeriodType.BABY.ordinal
        panda50.title = "和花花的小短腿一次看个够"
        panda50.releaseTime = "2021-02-20 10:26:19"
        panda50.originalUrl = "https://www.bilibili.com/video/BV1jv411Y7HS?share_source=copy_web"
        panda50.tags = "和花,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda50.authorName = "迩後咩"
        panda50.cover =
            "http://i1.hdslb.com/bfs/archive/68ae089e8e567935036d6dbebeed00edd74cff77.jpg"
        list.add(panda50)

        val panda51 = PetVideo()
        panda51.type = PetType.PANDA.ordinal
        panda51.fileName = "panda_baby_51"
        panda51.code = 89
        panda51.duration = 88
        panda51.period = PeriodType.BABY.ordinal
        panda51.title = "小和花：划水太难了"
        panda51.releaseTime = "2020-09-29 23:59:47"
        panda51.originalUrl = "https://www.bilibili.com/video/BV1fy4y1k7gX?share_source=copy_web"
        panda51.tags = "和花,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda51.authorName = "迩後咩"
        panda51.cover =
            "http://i2.hdslb.com/bfs/archive/fdbd4c1582c52dec421f762062322424d73225ac.jpg"
        list.add(panda51)

        val panda52 = PetVideo()
        panda52.type = PetType.PANDA.ordinal
        panda52.fileName = "panda_baby_52"
        panda52.code = 90
        panda52.duration = 163
        panda52.period = PeriodType.BABY.ordinal
        panda52.title = "大熊猫和花：学会的翻身突然又不会了，宝宝心里苦"
        panda52.releaseTime = "2020-11-07 16:16:50"
        panda52.originalUrl = "https://www.bilibili.com/video/BV19y4y1z7M4?share_source=copy_web"
        panda52.tags = "和花,大熊猫,萌宠,搞笑,萌萌哒,可爱,动物圈"
        panda52.authorName = "迩後咩"
        panda52.cover =
            "http://i1.hdslb.com/bfs/archive/fd50d315ea5af15b4518a0620160fe715f6e46f7.jpg"
        list.add(panda52)

        val panda53 = PetVideo()
        panda53.type = PetType.PANDA.ordinal
        panda53.fileName = "panda_baby_53"
        panda53.code = 91
        panda53.duration = 110
        panda53.period = PeriodType.BABY.ordinal
        panda53.title = "和花和叶·团子卖吗？"
        panda53.releaseTime = "2020-09-11 00:03:39"
        panda53.originalUrl = "https://www.bilibili.com/video/BV1X54y1C7BK?share_source=copy_web"
        panda53.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda53.authorName = "迩後咩"
        panda53.cover =
            "http://i2.hdslb.com/bfs/archive/e1d392a5c8a70f31a2eb5e9ff159cd9062d6f24a.jpg"
        list.add(panda53)

        val panda54 = PetVideo()
        panda54.type = PetType.PANDA.ordinal
        panda54.fileName = "panda_baby_54"
        panda54.code = 92
        panda54.duration = 65
        panda54.period = PeriodType.BABY.ordinal
        panda54.title = "花花：弟弟就是用来当垫jio的【和花和叶】"
        panda54.releaseTime = "2021-05-25 17:45:46"
        panda54.originalUrl = "https://www.bilibili.com/video/BV1aU4y1L7Kk?share_source=copy_web"
        panda54.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda54.authorName = "迩後咩"
        panda54.cover =
            "http://i2.hdslb.com/bfs/archive/0a4a7bbeeab1d9f727e46e34da6e32b48e1b2c03.jpg"
        list.add(panda54)

        val panda55 = PetVideo()
        panda55.type = PetType.PANDA.ordinal
        panda55.fileName = "panda_baby_55"
        panda55.code = 93
        panda55.duration = 112
        panda55.period = PeriodType.BABY.ordinal
        panda55.title = "和花：每天必修课——上窗台下窗台"
        panda55.releaseTime = "2021-06-04 17:30:08"
        panda55.originalUrl = "https://www.bilibili.com/video/BV1Cv411V7Hv?share_source=copy_web"
        panda55.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda55.authorName = "迩後咩"
        panda55.cover =
            "http://i2.hdslb.com/bfs/archive/2986fe2624cb8e3dc6241409201d0c91e16a751f.jpg"
        list.add(panda55)

        val panda56 = PetVideo()
        panda56.type = PetType.PANDA.ordinal
        panda56.fileName = "panda_baby_56"
        panda56.code = 94
        panda56.duration = 65
        panda56.period = PeriodType.BABY.ordinal
        panda56.title = "绝世小甜心日常卖萌。。【大熊猫和花】"
        panda56.releaseTime = "2021-09-23 16:36:12"
        panda56.originalUrl = "https://www.bilibili.com/video/BV1Ab4y117Vx?share_source=copy_web"
        panda56.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda56.authorName = "隽一一"
        panda56.cover =
            "http://i0.hdslb.com/bfs/archive/2b64335704471bd8e100eab31ea722905d5d13ab.jpg"
        list.add(panda56)

        val panda57 = PetVideo()
        panda57.type = PetType.PANDA.ordinal
        panda57.fileName = "panda_baby_57"
        panda57.code = 95
        panda57.duration = 166
        panda57.period = PeriodType.BABY.ordinal
        panda57.title = "【大熊猫和花】班花魅力无限，游客连连惊呼太可爱了(清明节库存)"
        panda57.releaseTime = "2021-04-07 23:19:57"
        panda57.originalUrl = "https://www.bilibili.com/video/BV1RU4y187AC?share_source=copy_web"
        panda57.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda57.authorName = "和花花真好看"
        panda57.cover =
            "http://i0.hdslb.com/bfs/archive/267fb90af06949890a17649c652798ef761b4b81.jpg"
        list.add(panda57)

        val panda58 = PetVideo()
        panda58.type = PetType.PANDA.ordinal
        panda58.fileName = "panda_baby_58"
        panda58.code = 96
        panda58.duration = 223
        panda58.period = PeriodType.BABY.ordinal
        panda58.title = "和花：你们不要嘲笑我，我听得见！！"
        panda58.releaseTime = "2021-06-24 21:24:41"
        panda58.originalUrl = "https://www.bilibili.com/video/BV1r54y1H7FD?share_source=copy_web"
        panda58.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda58.authorName = "熊猫会有的吖"
        panda58.cover =
            "http://i1.hdslb.com/bfs/archive/4199be05353ebc73436432539dde67183236f09c.jpg"
        list.add(panda58)

        val panda59 = PetVideo()
        panda59.type = PetType.PANDA.ordinal
        panda59.fileName = "panda_baby_59"
        panda59.code = 97
        panda59.duration = 97
        panda59.period = PeriodType.BABY.ordinal
        panda59.title = "【大熊猫和花】幼儿园里不好好吃饭的小熊友"
        panda59.releaseTime = "2021-05-02 18:24:49"
        panda59.originalUrl = "https://www.bilibili.com/video/BV1vZ4y1F7G2?share_source=copy_web"
        panda59.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda59.authorName = "和花花真好看"
        panda59.cover =
            "http://i0.hdslb.com/bfs/archive/045fe8a656e82ad625c09e452798b660f4bfda49.jpg"
        list.add(panda59)

        val panda60 = PetVideo()
        panda60.type = PetType.PANDA.ordinal
        panda60.fileName = "panda_baby_60"
        panda60.code = 98
        panda60.duration = 19
        panda60.period = PeriodType.BABY.ordinal
        panda60.title = "有些孩子啊，耳朵在听课，脑子在神游。。"
        panda60.releaseTime = "2021-03-19 19:03:41"
        panda60.originalUrl = "https://www.bilibili.com/video/BV1Uf4y1s7b9?share_source=copy_web"
        panda60.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda60.authorName = "隽一一"
        panda60.cover =
            "http://i1.hdslb.com/bfs/archive/bff19d813dae370ed93c8d0622a6e967f08e88c8.jpg"
        list.add(panda60)

        val panda61 = PetVideo()
        panda61.type = PetType.PANDA.ordinal
        panda61.fileName = "panda_baby_61"
        panda61.code = 99
        panda61.duration = 27
        panda61.period = PeriodType.BABY.ordinal
        panda61.title = "【大熊猫和花】唬姐姐把地板扑的“砰砰”的，真凶萌！"
        panda61.releaseTime = "2021-02-03 16:13:52"
        panda61.originalUrl = "https://www.bilibili.com/video/BV1c54y1W7jX?share_source=copy_web"
        panda61.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda61.authorName = "隽一一"
        panda61.cover =
            "http://i1.hdslb.com/bfs/archive/cb1b805c931c61bfe8cef3dbd9a8a0bc1d20d730.jpg"
        list.add(panda61)

        val panda62 = PetVideo()
        panda62.type = PetType.PANDA.ordinal
        panda62.fileName = "panda_baby_62"
        panda62.code = 100
        panda62.duration = 28
        panda62.period = PeriodType.BABY.ordinal
        panda62.title = "【大熊猫和花】小花花手打团子，你值得拥有（内场时期库存）"
        panda62.releaseTime = "2021-04-07 22:35:44"
        panda62.originalUrl = "https://www.bilibili.com/video/BV13U4y1Y7ix?share_source=copy_web"
        panda62.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda62.authorName = "和花花真好看"
        panda62.cover =
            "http://i1.hdslb.com/bfs/archive/3d9aadda754495ec20c9c64e51cc251318cd30d2.jpg"
        list.add(panda62)

        val panda63 = PetVideo()
        panda63.type = PetType.PANDA.ordinal
        panda63.fileName = "panda_baby_63"
        panda63.code = 101
        panda63.duration = 68
        panda63.period = PeriodType.BABY.ordinal
        panda63.title = "和花贵妃躺姿 小和花库存视频（大熊猫和花）"
        panda63.releaseTime = "2021-03-13 11:59:19"
        panda63.originalUrl = "https://www.bilibili.com/video/BV1gp4y1h7Xy?share_source=copy_web"
        panda63.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda63.authorName = "和花花真好看"
        panda63.cover =
            "http://i0.hdslb.com/bfs/archive/768211ab1d0900beb83ab557ca336681bccb209e.jpg"
        list.add(panda63)

        val panda64 = PetVideo()
        panda64.type = PetType.PANDA.ordinal
        panda64.fileName = "panda_baby_64"
        panda64.code = 102
        panda64.duration = 77
        panda64.period = PeriodType.BABY.ordinal
        panda64.title = "和花花放学前变身霸王花（原速）"
        panda64.releaseTime = "2021-06-06 19:39:40"
        panda64.originalUrl = "https://www.bilibili.com/video/BV1kU4y1V7E8?share_source=copy_web"
        panda64.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda64.authorName = "迩後咩"
        panda64.cover =
            "http://i2.hdslb.com/bfs/archive/11e92d1eaaaf448009d909f962d48ac47c802140.jpg"
        list.add(panda64)

        val panda65 = PetVideo()
        panda65.type = PetType.PANDA.ordinal
        panda65.fileName = "panda_baby_65"
        panda65.code = 103
        panda65.duration = 63
        panda65.period = PeriodType.BABY.ordinal
        panda65.title = "【大熊猫和花】花花越来越调皮了，不想回家还搞破坏"
        panda65.releaseTime = "2021-06-07 23:00:03"
        panda65.originalUrl = "https://www.bilibili.com/video/BV1eK4y1X7tV?share_source=copy_web"
        panda65.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda65.authorName = "小香妞爱熊猫"
        panda65.cover =
            "http://i2.hdslb.com/bfs/archive/4ade5af554db244617ff3976765555c24924344b.jpg"
        list.add(panda65)

        val panda66 = PetVideo()
        panda66.type = PetType.PANDA.ordinal
        panda66.fileName = "panda_baby_66"
        panda66.code = 104
        panda66.duration = 101
        panda66.period = PeriodType.BABY.ordinal
        panda66.title = "和花专注喝水的样子好乖"
        panda66.releaseTime = "2021-03-01 11:10:13"
        panda66.originalUrl = "https://www.bilibili.com/video/BV1Jz4y1m7rQ?share_source=copy_web"
        panda66.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda66.authorName = "迩後咩"
        panda66.cover =
            "http://i0.hdslb.com/bfs/archive/0117f98687a751abf496f9fa7e80deef540d6c15.jpg"
        list.add(panda66)

        val panda67 = PetVideo()
        panda67.type = PetType.PANDA.ordinal
        panda67.fileName = "panda_baby_67"
        panda67.code = 105
        panda67.duration = 139
        panda67.period = PeriodType.BABY.ordinal
        panda67.title = "花花终于爬上大木架了，激动的热泪盈眶，给和花打call~"
        panda67.releaseTime = "2021-01-30 17:27:57"
        panda67.originalUrl = "https://www.bilibili.com/video/BV1Sf4y167wv?share_source=copy_web"
        panda67.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda67.authorName = "迩後咩"
        panda67.cover =
            "http://i2.hdslb.com/bfs/archive/394ef01470bbb134031411cc62360e1a55439ad2.jpg"
        list.add(panda67)

        val panda68 = PetVideo()
        panda68.type = PetType.PANDA.ordinal
        panda68.fileName = "panda_baby_68"
        panda68.code = 106
        panda68.duration = 26
        panda68.period = PeriodType.BABY.ordinal
        panda68.title = "小花猫模样可爱极了【大熊猫和花】"
        panda68.releaseTime = "2021-07-03 22:16:56"
        panda68.originalUrl = "https://www.bilibili.com/video/BV1a64y1b7dz?share_source=copy_web"
        panda68.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda68.authorName = "迩後咩"
        panda68.cover =
            "http://i0.hdslb.com/bfs/archive/9e3c77f4e35a39cac561e3592268a1a358f93f9a.jpg"
        list.add(panda68)

        val panda69 = PetVideo()
        panda69.type = PetType.PANDA.ordinal
        panda69.fileName = "panda_baby_69"
        panda69.code = 107
        panda69.duration = 71
        panda69.period = PeriodType.BABY.ordinal
        panda69.title = "【和花金喜】花花：弟弟冷不冷，给你盖被被～金喜：大可不必"
        panda69.releaseTime = "2021-08-02 18:18:47"
        panda69.originalUrl = "https://www.bilibili.com/video/BV1oU4y1E7B1?share_source=copy_web"
        panda69.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda69.authorName = "迩後咩"
        panda69.cover =
            "http://i1.hdslb.com/bfs/archive/a3f712f223dc9bfe48602f6a36d9d3347a723660.jpg"
        list.add(panda69)

        val panda70 = PetVideo()
        panda70.type = PetType.PANDA.ordinal
        panda70.fileName = "panda_baby_70"
        panda70.code = 108
        panda70.duration = 186
        panda70.period = PeriodType.BABY.ordinal
        panda70.title = "【大熊猫金喜&和花&和叶】小和花被压得不能动弹，连金喜都能欺负你啦"
        panda70.releaseTime = "2021-01-16 12:13:54"
        panda70.originalUrl = "https://www.bilibili.com/video/BV1my4y1H7QK?share_source=copy_web"
        panda70.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda70.authorName = "辛辛糖包"
        panda70.cover =
            "http://i0.hdslb.com/bfs/archive/2f10a2eba45764b850377d5a2c4fbd889300bf23.jpg"
        list.add(panda70)

        val panda71 = PetVideo()
        panda71.type = PetType.PANDA.ordinal
        panda71.fileName = "panda_baby_71"
        panda71.code = 109
        panda71.duration = 74
        panda71.period = PeriodType.BABY.ordinal
        panda71.title = "小fafa：我没有欺负弟弟妹妹哦，我只是喊他们起床了【大熊猫和花金双金喜】"
        panda71.releaseTime = "2021-01-05 14:30:08"
        panda71.originalUrl = "https://www.bilibili.com/video/BV1cK411u7mf?share_source=copy_web"
        panda71.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda71.authorName = "迩後咩"
        panda71.cover =
            "http://i2.hdslb.com/bfs/archive/ffa1c6e509d8e90e86f73eed200c91c19022abf3.jpg"
        list.add(panda71)

        val panda72 = PetVideo()
        panda72.type = PetType.PANDA.ordinal
        panda72.fileName = "panda_baby_72"
        panda72.code = 110
        panda72.duration = 152
        panda72.period = PeriodType.BABY.ordinal
        panda72.title = "金喜弟弟暴走rua和花，花花被rua叫，金双妹妹闻讯赶来帮姐姐"
        panda72.releaseTime = "2021-02-18 15:04:29"
        panda72.originalUrl = "https://www.bilibili.com/video/BV1Db4y197o4?share_source=copy_web"
        panda72.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda72.authorName = "迩後咩"
        panda72.cover =
            "http://i1.hdslb.com/bfs/archive/9a5f6626776726526a3d91b91700ee54ad22c58f.jpg"
        list.add(panda72)

        val panda73 = PetVideo()
        panda73.type = PetType.PANDA.ordinal
        panda73.fileName = "panda_baby_73"
        panda73.code = 111
        panda73.duration = 62
        panda73.period = PeriodType.BABY.ordinal
        panda73.title = "看着你傻傻笑，一见花就笑~大熊猫和花"
        panda73.releaseTime = "2021-03-22 21:09:38"
        panda73.originalUrl = "https://www.bilibili.com/video/BV1Ji4y1P7DT?share_source=copy_web"
        panda73.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda73.authorName = "迩後咩"
        panda73.cover =
            "http://i0.hdslb.com/bfs/archive/b8b5711dd70b5fc1d5dfbb845b4f5fdc9e486393.jpg"
        list.add(panda73)

        val panda74 = PetVideo()
        panda74.type = PetType.PANDA.ordinal
        panda74.fileName = "panda_baby_74"
        panda74.code = 112
        panda74.duration = 45
        panda74.period = PeriodType.BABY.ordinal
        panda74.title = "【大熊猫和花】想洗脚jiojio够不到水水的花花"
        panda74.releaseTime = "2021-05-14 17:37:05"
        panda74.originalUrl = "https://www.bilibili.com/video/BV1o64y127ys?share_source=copy_web"
        panda74.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda74.authorName = "和花花真好看"
        panda74.cover =
            "http://i1.hdslb.com/bfs/archive/8902634ab6e7b3abaed39e1feb7bf13bc8e37fd3.jpg"
        list.add(panda74)

        val panda75 = PetVideo()
        panda75.type = PetType.PANDA.ordinal
        panda75.fileName = "panda_baby_75"
        panda75.code = 113
        panda75.duration = 72
        panda75.period = PeriodType.BABY.ordinal
        panda75.title = "【大熊猫和花】雨停了，花花在散步"
        panda75.releaseTime = "2021-09-17 19:09:32"
        panda75.originalUrl = "https://www.bilibili.com/video/BV1cR4y1p7GG?share_source=copy_web"
        panda75.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda75.authorName = "朙雨"
        panda75.cover =
            "http://i0.hdslb.com/bfs/archive/64fb7a262aa0ef0a95faf081d3bce0ce9d73c664.jpg"
        list.add(panda75)

        val panda76 = PetVideo()
        panda76.type = PetType.PANDA.ordinal
        panda76.fileName = "panda_baby_76"
        panda76.code = 114
        panda76.duration = 72
        panda76.period = PeriodType.BABY.ordinal
        panda76.title = "和花花快一岁了，是不是该谈个对象了～"
        panda76.releaseTime = "2021-04-04 12:46:35"
        panda76.originalUrl = "https://www.bilibili.com/video/BV1GA411K7FZ?share_source=copy_web"
        panda76.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,动物圈"
        panda76.authorName = "stwtidus"
        panda76.cover =
            "http://i1.hdslb.com/bfs/archive/d31878cc8b17e959b82160e27439961165ddd86d.jpg"
        list.add(panda76)

        val panda77 = PetVideo()
        panda77.type = PetType.PANDA.ordinal
        panda77.fileName = "panda_baby_77"
        panda77.code = 115
        panda77.duration = 67
        panda77.period = PeriodType.BABY.ordinal
        panda77.title = "小和花和叶：ma~ma~~【熊猫叫声】"
        panda77.releaseTime = "2020-10-17 15:01:32"
        panda77.originalUrl = "https://www.bilibili.com/video/BV1ga4y1L7oC?share_source=copy_web"
        panda77.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,和叶,动物圈"
        panda77.authorName = "迩後咩"
        panda77.cover =
            "http://i1.hdslb.com/bfs/archive/4f8621a877c5ea678cf09e434a8e57a447fcd0dc.jpg"
        list.add(panda77)

        val panda78 = PetVideo()
        panda78.type = PetType.PANDA.ordinal
        panda78.fileName = "panda_baby_78"
        panda78.code = 116
        panda78.duration = 143
        panda78.period = PeriodType.BABY.ordinal
        panda78.title = "俩趴趴糯米团子【大熊猫和花和叶】"
        panda78.releaseTime = "2020-10-27 20:10:44"
        panda78.originalUrl = "https://www.bilibili.com/video/BV14y4y1B7oR?share_source=copy_web"
        panda78.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和花,和叶,动物圈"
        panda78.authorName = "迩後咩"
        panda78.cover =
            "http://i2.hdslb.com/bfs/archive/99ae5c15b4518c4adb0ce52eb2eeecd9c7179160.jpg"
        list.add(panda78)

        val panda79 = PetVideo()
        panda79.type = PetType.PANDA.ordinal
        panda79.fileName = "panda_baby_79"
        panda79.code = 117
        panda79.duration = 104
        panda79.period = PeriodType.BABY.ordinal
        panda79.title = "小和叶喝neinei，jiojio开心的扭来扭去【大熊猫】"
        panda79.releaseTime = "2020-11-14 09:01:02"
        panda79.originalUrl = "https://www.bilibili.com/video/BV1ea4y1p7uX?share_source=copy_web"
        panda79.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和叶,动物圈"
        panda79.authorName = "迩後咩"
        panda79.cover =
            "http://i1.hdslb.com/bfs/archive/5d0caa5f1acb89be71f92e0edbd5978b2583040c.jpg"
        list.add(panda79)

        val panda80 = PetVideo()
        panda80.type = PetType.PANDA.ordinal
        panda80.fileName = "panda_baby_80"
        panda80.code = 118
        panda80.duration = 50
        panda80.period = PeriodType.BABY.ordinal
        panda80.title = "小可爱突然上线【大熊猫和叶】"
        panda80.releaseTime = "2020-11-18 17:18:11"
        panda80.originalUrl = "https://www.bilibili.com/video/BV17V411a7nk?share_source=copy_web"
        panda80.tags = "大熊猫,萌宠,搞笑,萌萌哒,可爱,和叶,动物圈"
        panda80.authorName = "迩後咩"
        panda80.cover =
            "http://i1.hdslb.com/bfs/archive/c8abc41651bc4d683476cd8f67941481c82a632d.jpg"
        list.add(panda80)

        val panda81 = PetVideo()
        panda81.type = PetType.PANDA.ordinal
        panda81.fileName = "panda_baby_81"
        panda81.code = 119
        panda81.duration = 39
        panda81.period = PeriodType.BABY.ordinal
        panda81.title = "【熊猫】争气的和叶已经熟练的在树上撒欢儿"
        panda81.releaseTime = "2020-12-26 02:00:47"
        panda81.originalUrl = "https://www.bilibili.com/video/BV1tv411t7dQ?share_source=copy_web"
        panda81.tags = "和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda81.authorName = "飞飞要做人生努力组\n"
        panda81.cover =
            "http://i2.hdslb.com/bfs/archive/1bb8f198c190c197b37860ce4c61b47ed6bcb3a7.jpg"
        list.add(panda81)

        val panda82 = PetVideo()
        panda82.type = PetType.PANDA.ordinal
        panda82.fileName = "panda_baby_82"
        panda82.code = 120
        panda82.duration = 62
        panda82.period = PeriodType.BABY.ordinal
        panda82.title = "和叶把和花拽入草丛，连滚几个回合后跑了"
        panda82.releaseTime = "2020-12-05 16:38:50"
        panda82.originalUrl = "https://www.bilibili.com/video/BV1TV411h7d7?share_source=copy_web"
        panda82.tags = "和花,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda82.authorName = "迩後咩"
        panda82.cover =
            "http://i2.hdslb.com/bfs/archive/3c2e8043356fe8e89969612c84eeb5c94a6055cf.jpg"
        list.add(panda82)

        val panda83 = PetVideo()
        panda83.type = PetType.PANDA.ordinal
        panda83.fileName = "panda_baby_83"
        panda83.code = 121
        panda83.duration = 88
        panda83.period = PeriodType.BABY.ordinal
        panda83.title = "小和花龟速移动找弟弟"
        panda83.releaseTime = "2020-12-20 15:54:10"
        panda83.originalUrl = "https://www.bilibili.com/video/BV1cp4y167eC?share_source=copy_web"
        panda83.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda83.authorName = "迩後咩"
        panda83.cover =
            "http://i2.hdslb.com/bfs/archive/9c927f380c1190e03cb9826b84b29d8a79b16b3b.jpg"
        list.add(panda83)

        val panda84 = PetVideo()
        panda84.type = PetType.PANDA.ordinal
        panda84.fileName = "panda_baby_84"
        panda84.code = 122
        panda84.duration = 128
        panda84.period = PeriodType.BABY.ordinal
        panda84.title = "【大熊猫和花】和花和叶家庭成员汇总"
        panda84.releaseTime = "2021-05-22 16:07:08"
        panda84.originalUrl = "https://www.bilibili.com/video/BV1wU4y1L7gi?share_source=copy_web"
        panda84.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda84.authorName = "迩後咩"
        panda84.cover =
            "http://i2.hdslb.com/bfs/archive/2cb0cb11611f3b5c7f5d03d9e80ab2d526837887.jpg"
        list.add(panda84)

        val panda85 = PetVideo()
        panda85.type = PetType.PANDA.ordinal
        panda85.fileName = "panda_baby_85"
        panda85.code = 123
        panda85.duration = 81
        panda85.period = PeriodType.BABY.ordinal
        panda85.title = "【大熊猫和花】趴趴熊转弯找弟弟"
        panda85.releaseTime = "2021-08-11 18:07:01"
        panda85.originalUrl = "https://www.bilibili.com/video/BV1Bg411j7D4?share_source=copy_web"
        panda85.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda85.authorName = "迩後咩"
        panda85.cover =
            "http://i2.hdslb.com/bfs/archive/2ac8140a02e8d61f1f7408ab14006ef49e694ac4.jpg"
        list.add(panda85)

        val panda86 = PetVideo()
        panda86.type = PetType.PANDA.ordinal
        panda86.fileName = "panda_baby_86"
        panda86.code = 124
        panda86.duration = 30
        panda86.period = PeriodType.BABY.ordinal
        panda86.title = "【大熊猫和花、和叶】臭弟弟，居然无视我！"
        panda86.releaseTime = "2021-02-18 15:08:48"
        panda86.originalUrl = "https://www.bilibili.com/video/BV1F54y1Y7kg?share_source=copy_web"
        panda86.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda86.authorName = "迩後咩"
        panda86.cover =
            "http://i1.hdslb.com/bfs/archive/812866909512c131e5ace7099ee6a8d35492a6e4.jpg"
        list.add(panda86)

        val panda87 = PetVideo()
        panda87.type = PetType.PANDA.ordinal
        panda87.fileName = "panda_baby_87"
        panda87.code = 125
        panda87.duration = 41
        panda87.period = PeriodType.BABY.ordinal
        panda87.title = "【大熊猫和花】和叶弟弟：我申请换个姐姐"
        panda87.releaseTime = "2021-03-23 21:00:09"
        panda87.originalUrl = "https://www.bilibili.com/video/BV1LV411e7qW?share_source=copy_web"
        panda87.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda87.authorName = "小香妞爱熊猫"
        panda87.cover =
            "http://i2.hdslb.com/bfs/archive/e37710e9de23855daee18f792eae0f471b6e9436.jpg"
        list.add(panda87)

        val panda88 = PetVideo()
        panda88.type = PetType.PANDA.ordinal
        panda88.fileName = "panda_baby_88"
        panda88.code = 126
        panda88.duration = 45
        panda88.period = PeriodType.BABY.ordinal
        panda88.title = "【大熊猫和花】花儿欺负弟弟和叶，懂事的弟弟让着姐姐，不还手"
        panda88.releaseTime = "2021-03-22 21:00:13"
        panda88.originalUrl = "https://www.bilibili.com/video/BV1uv411877j?share_source=copy_web"
        panda88.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda88.authorName = "小香妞爱熊猫"
        panda88.cover =
            "http://i1.hdslb.com/bfs/archive/73ce54bcbe395363e107f996d846e087c28b1265.jpg"
        list.add(panda88)

        val panda89 = PetVideo()
        panda89.type = PetType.PANDA.ordinal
        panda89.fileName = "panda_baby_89"
        panda89.code = 127
        panda89.duration = 37
        panda89.period = PeriodType.BABY.ordinal
        panda89.title = "【大熊猫和花、和叶】有个小熊友，自己翻不了身，就拿弟弟发脾气。"
        panda89.releaseTime = "2021-02-10 16:57:15"
        panda89.originalUrl = "https://www.bilibili.com/video/BV1kK4y1n7i4?share_source=copy_web"
        panda89.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda89.authorName = "小香妞爱熊猫"
        panda89.cover =
            "http://i1.hdslb.com/bfs/archive/ed04bc882a4a41b10dcd495c9f8ba21451e8e6e7.jpg"
        list.add(panda89)

        val panda90 = PetVideo()
        panda90.type = PetType.PANDA.ordinal
        panda90.fileName = "panda_baby_90"
        panda90.code = 128
        panda90.duration = 37
        panda90.period = PeriodType.BABY.ordinal
        panda90.title = "【大熊猫和花】小胖花和和叶弟弟吵架了，好可爱的两姐弟呀"
        panda90.releaseTime = "2021-03-16 21:00:06"
        panda90.originalUrl = "https://www.bilibili.com/video/BV1Ap4y1h7qR?share_source=copy_web"
        panda90.tags = "和花,和叶,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda90.authorName = "小香妞爱熊猫"
        panda90.cover =
            "http://i1.hdslb.com/bfs/archive/978e4d3e197bf7278b0c9a19eaf39c8c5f1dffe6.jpg"
        list.add(panda90)

        val panda91 = PetVideo()
        panda91.type = PetType.PANDA.ordinal
        panda91.fileName = "panda_baby_91"
        panda91.code = 129
        panda91.duration = 104
        panda91.period = PeriodType.BABY.ordinal
        panda91.title = "大宝、小宝的笋笋争夺战"
        panda91.releaseTime = "2020-08-28 19:10:03"
        panda91.originalUrl = "https://www.bilibili.com/video/BV1ZV41127te?share_source=copy_web"
        panda91.tags = "大宝,小宝,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda91.authorName = "迩後咩"
        panda91.cover =
            "http://i1.hdslb.com/bfs/archive/04397bacf1f9fb086d9549c04d66dd97907b6dbe.jpg"
        list.add(panda91)

        val panda92 = PetVideo()
        panda92.type = PetType.PANDA.ordinal
        panda92.fileName = "panda_baby_92"
        panda92.code = 130
        panda92.duration = 40
        panda92.period = PeriodType.BABY.ordinal
        panda92.title = "小吧嗒走单杠【大熊猫爱莲】"
        panda92.releaseTime = "2020-11-12 18:47:02"
        panda92.originalUrl = "https://www.bilibili.com/video/BV1yt4y1e7bU?share_source=copy_web"
        panda92.tags = "爱莲,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda92.authorName = "迩後咩"
        panda92.cover =
            "http://i2.hdslb.com/bfs/archive/23ad9ed056c1466b082fe203cd8a886d4b802a82.jpg"
        list.add(panda92)

        val panda93 = PetVideo()
        panda93.type = PetType.PANDA.ordinal
        panda93.fileName = "panda_baby_93"
        panda93.code = 131
        panda93.duration = 172
        panda93.period = PeriodType.BABY.ordinal
        panda93.title = "想拥有这个钓猫神器，把金双妹妹抱回家"
        panda93.releaseTime = "2021-01-24 12:30:03"
        panda93.originalUrl = "https://www.bilibili.com/video/BV12r4y1N7Ds?share_source=copy_web"
        panda93.tags = "金双,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda93.authorName = "迩後咩"
        panda93.cover =
            "http://i0.hdslb.com/bfs/archive/6c6404810cd9ccb015d68188b535e1d13e5cff5d.jpg"
        list.add(panda93)

        val panda94 = PetVideo()
        panda94.type = PetType.PANDA.ordinal
        panda94.fileName = "panda_baby_94"
        panda94.code = 132
        panda94.duration = 94
        panda94.period = PeriodType.BABY.ordinal
        panda94.title = "熊团锦簇~来吃柠檬了~"
        panda94.releaseTime = "2021-10-09 16:52:38"
        panda94.originalUrl = "https://www.bilibili.com/video/BV1fr4y117WW?share_source=copy_web"
        panda94.tags = "和花,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda94.authorName = "迩後咩"
        panda94.cover =
            "http://i1.hdslb.com/bfs/archive/3f635a8a8ba5c2feb1f03d6c5ab6eefaaebd182a.jpg"
        list.add(panda94)

        val panda95 = PetVideo()
        panda95.type = PetType.PANDA.ordinal
        panda95.fileName = "panda_baby_95"
        panda95.code = 133
        panda95.duration = 141
        panda95.period = PeriodType.BABY.ordinal
        panda95.title = "【大熊猫宝新&雅颂】奶爸，我就看看妹妹，不动手，你别扒拉我~"
        panda95.releaseTime = "2021-11-08 22:02:11"
        panda95.originalUrl = "https://www.bilibili.com/video/BV12q4y1r7MZ?share_source=copy_web"
        panda95.tags = "和花,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda95.authorName = "辛辛糖包"
        panda95.cover =
            "http://i1.hdslb.com/bfs/archive/bb091b18c16d2c0acdcc6d03de8407c9cd62b416.jpg"
        list.add(panda95)

        val panda96 = PetVideo()
        panda96.type = PetType.PANDA.ordinal
        panda96.fileName = "panda_baby_96"
        panda96.code = 134
        panda96.duration = 70
        panda96.period = PeriodType.BABY.ordinal
        panda96.title = "【宝新雅颂】两个小可爱盖着小红毯告告"
        panda96.releaseTime = "2021-10-15 16:54:49"
        panda96.originalUrl = "https://www.bilibili.com/video/BV14T4y1o7M3?share_source=copy_web"
        panda96.tags = "宝新,雅颂,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda96.authorName = "迩後咩"
        panda96.cover =
            "http://i1.hdslb.com/bfs/archive/e8c385ab4640ddab65842e3bd6c0dcb9339355db.jpg"
        list.add(panda96)

        val panda97 = PetVideo()
        panda97.type = PetType.PANDA.ordinal
        panda97.fileName = "panda_baby_97"
        panda97.code = 135
        panda97.duration = 112
        panda97.period = PeriodType.BABY.ordinal
        panda97.title = "大熊猫宝新~月嫂上线带娃，弟弟妹妹挨个rua"
        panda97.releaseTime = "2021-11-06 18:02:18"
        panda97.originalUrl = "https://www.bilibili.com/video/BV1EU4y1M7ko?share_source=copy_web"
        panda97.tags = "宝新,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda97.authorName = "迩後咩"
        panda97.cover =
            "http://i0.hdslb.com/bfs/archive/73660b69f180ee5af93bca28af95124661c2a5fe.jpg"
        list.add(panda97)

        val panda98 = PetVideo()
        panda98.type = PetType.PANDA.ordinal
        panda98.fileName = "panda_baby_98"
        panda98.code = 136
        panda98.duration = 84
        panda98.period = PeriodType.BABY.ordinal
        panda98.title = "晒熊猫~轮辉雅颂金宵"
        panda98.releaseTime = "2021-11-08 18:29:14"
        panda98.originalUrl = "https://www.bilibili.com/video/BV1Aq4y1k7sr?share_source=copy_web"
        panda98.tags = "轮辉,雅颂,金宵,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda98.authorName = "迩後咩"
        panda98.cover =
            "http://i1.hdslb.com/bfs/archive/aa795eee90e4d7b64d806c106d9106a069a3480f.jpg"
        list.add(panda98)

        val panda99 = PetVideo()
        panda99.type = PetType.PANDA.ordinal
        panda99.fileName = "panda_baby_99"
        panda99.code = 137
        panda99.duration = 87
        panda99.period = PeriodType.BABY.ordinal
        panda99.title = "匍匐前进→步履蹒跚→健步如飞【宝新金宵轮辉雅颂】"
        panda99.releaseTime = "2021-11-17 17:54:04"
        panda99.originalUrl = "https://www.bilibili.com/video/BV1n34y1d7My?share_source=copy_web"
        panda99.tags = "宝新,金宵,轮辉,雅颂,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda99.authorName = "迩後咩"
        panda99.cover =
            "http://i2.hdslb.com/bfs/archive/c5d900123f45b0c0b6a979f77fa575d27ad0c7e7.jpg"
        list.add(panda99)

        val panda100 = PetVideo()
        panda100.type = PetType.PANDA.ordinal
        panda100.fileName = "panda_baby_100"
        panda100.code = 138
        panda100.duration = 68
        panda100.period = PeriodType.BABY.ordinal
        panda100.title = "俩趴趴熊路还不会走，就会撩架了【轮辉雅颂】"
        panda100.releaseTime = "2021-11-21 18:00:24"
        panda100.originalUrl = "https://www.bilibili.com/video/BV1f341187qK?share_source=copy_web"
        panda100.tags = "轮辉,雅颂,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda100.authorName = "迩後咩"
        panda100.cover =
            "http://i2.hdslb.com/bfs/archive/0c7601cbff488bf00c131d6681833d6d9886559d.jpg"
        list.add(panda100)

        val panda101 = PetVideo()
        panda101.type = PetType.PANDA.ordinal
        panda101.fileName = "panda_baby_101"
        panda101.code = 139
        panda101.duration = 82
        panda101.period = PeriodType.BABY.ordinal
        panda101.title = "【轮辉】被扭来扭去的小屁屁萌晕"
        panda101.releaseTime = "2021-11-29 17:36:22"
        panda101.originalUrl = "https://www.bilibili.com/video/BV1wr4y1X7Gg?share_source=copy_web"
        panda101.tags = "轮辉,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda101.authorName = "迩後咩"
        panda101.cover =
            "http://i1.hdslb.com/bfs/archive/5ad140947ee188c4943b42cf98ffc3672df4613d.jpg"
        list.add(panda101)

        val panda102 = PetVideo()
        panda102.type = PetType.PANDA.ordinal
        panda102.fileName = "panda_baby_102"
        panda102.code = 140
        panda102.duration = 31
        panda102.period = PeriodType.BABY.ordinal
        panda102.title = "大熊猫喜妹的小儿子皓月要萌翻天了"
        panda102.releaseTime = "2019-07-01 02:08:22"
        panda102.originalUrl = "https://www.bilibili.com/video/BV1ix411R7Ks?share_source=copy_web"
        panda102.tags = "皓月,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda102.authorName = "奇异果家的顺来会fly"
        panda102.isStar = true
        panda102.cover =
            "http://i1.hdslb.com/bfs/archive/040db4429d0c4e5078716925d9a391a6eb1f711a.jpg"
        list.add(panda102)

        val panda103 = PetVideo()
        panda103.type = PetType.PANDA.ordinal
        panda103.fileName = "panda_baby_103"
        panda103.code = 141
        panda103.duration = 69
        panda103.period = PeriodType.BABY.ordinal
        panda103.title = "【熊猫贤贤】这颜值在熊猫中属于什么水平？"
        panda103.releaseTime = "2021-03-03 22:00:12"
        panda103.originalUrl = "https://www.bilibili.com/video/BV1254y1h7Hr?share_source=copy_web"
        panda103.tags = "贤贤,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda103.authorName = "迩後咩"
        panda103.isStar = true
        panda103.cover =
            "http://i0.hdslb.com/bfs/archive/0b86e4b3d7ffcfdaf82de459904b634548e9e750.jpg"
        list.add(panda103)

        val panda104 = PetVideo()
        panda104.type = PetType.PANDA.ordinal
        panda104.fileName = "panda_baby_104"
        panda104.code = 142
        panda104.duration = 72
        panda104.period = PeriodType.BABY.ordinal
        panda104.title = "熊猫宝宝成精实锤！都开始练习直立行走啦！"
        panda104.releaseTime = "2021-09-15 19:53:38"
        panda104.originalUrl = "https://www.bilibili.com/video/BV1hq4y1f7Ab?share_source=copy_web"
        panda104.tags = "旅日熊猫,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda104.authorName = "旅日熊猫和朋友们"
        panda104.cover =
            "http://i1.hdslb.com/bfs/archive/2268f45c61140ad549d148856f2f26f579aadb9c.jpg"
        list.add(panda104)

        val panda105 = PetVideo()
        panda105.type = PetType.PANDA.ordinal
        panda105.fileName = "panda_baby_105"
        panda105.code = 143
        panda105.duration = 45
        panda105.period = PeriodType.BABY.ordinal
        panda105.title = "熊猫宝宝爬不上台阶着急得大叫"
        panda105.releaseTime = "2017-01-28 00:08:14"
        panda105.originalUrl = "https://www.bilibili.com/video/BV1Gs41187us?share_source=copy_web"
        panda105.tags = "和花,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda105.authorName = "虾滑虾滑好好吃"
        panda105.cover =
            "http://i1.hdslb.com/bfs/archive/8ea440ccc4ab87a7dff071d4b52255dc5607d435.jpg"
        list.add(panda105)

        val panda106 = PetVideo()
        panda106.type = PetType.PANDA.ordinal
        panda106.fileName = "panda_baby_106"
        panda106.code = 144
        panda106.duration = 64
        panda106.period = PeriodType.BABY.ordinal
        panda106.title = "【下雪】小屁屁粘糖霜"
        panda106.releaseTime = "2021-02-13 14:22:02"
        panda106.originalUrl = "https://www.bilibili.com/video/BV1gy4y1e79s?share_source=copy_web"
        panda106.tags = "和花,大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda106.authorName = "迩後咩"
        panda106.isStar = true
        panda106.cover =
            "http://i2.hdslb.com/bfs/archive/b51951ebec444f970ccb0e002673bc11499a6670.jpg"
        list.add(panda106)

        val panda107 = PetVideo()
        panda107.type = PetType.PANDA.ordinal
        panda107.fileName = "panda_baby_107"
        panda107.code = 145
        panda107.duration = 86
        panda107.period = PeriodType.BABY.ordinal
        panda107.title = "【下雪】大熊猫糯米团子结伴同行～"
        panda107.releaseTime = "2021-12-29 12:16:29"
        panda107.originalUrl = "https://www.bilibili.com/video/BV1VF411i7CT?share_source=copy_web"
        panda107.tags = "大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda107.authorName = "迩後咩"
        panda107.isStar = true
        panda107.cover =
            "http://i1.hdslb.com/bfs/archive/83a5fdd20b8ee3efd8d68c06897571fa77c79bde.jpg"
        list.add(panda107)

        val panda108 = PetVideo()
        panda108.type = PetType.PANDA.ordinal
        panda108.fileName = "panda_baby_108"
        panda108.code = 146
        panda108.duration = 90
        panda108.period = PeriodType.BABY.ordinal
        panda108.title = "【下雪】小月牙红唇宝宝：麻麻等等我~"
        panda108.releaseTime = "2021-02-28 10:53:31"
        panda108.originalUrl = "https://www.bilibili.com/video/BV1eV411v7GB?share_source=copy_web"
        panda108.tags = "大熊猫,萌宠,萌萌哒,可爱,动物圈"
        panda108.authorName = "迩後咩"
        panda108.cover =
            "http://i1.hdslb.com/bfs/archive/5fba155abb8c785837791e95899abf776ad86e05.jpg"
        list.add(panda108)

        val panda109 = PetVideo()
        panda109.type = PetType.PANDA.ordinal
        panda109.fileName = "panda_baby_109"
        panda109.code = 147
        panda109.duration = 91
        panda109.period = PeriodType.BABY.ordinal
        panda109.title = "【下雪】爱莲爬树比哥哥姐姐都厉害"
        panda109.releaseTime = "2021-07-22 19:39:21"
        panda109.originalUrl = "https://www.bilibili.com/video/BV1Bb4y167Zq?share_source=copy_web"
        panda109.tags = "爱莲,萌宠,萌萌哒,可爱,动物圈"
        panda109.authorName = "迩後咩"
        panda109.cover =
            "http://i2.hdslb.com/bfs/archive/eaf01672f166eaf376ceb76ca728f98451812977.jpg"
        list.add(panda109)

        val panda110 = PetVideo()
        panda110.type = PetType.PANDA.ordinal
        panda110.fileName = "panda_baby_110"
        panda110.code = 148
        panda110.duration = 202
        panda110.period = PeriodType.BABY.ordinal
        panda110.title = "小透明和叶的一岁成长记录"
        panda110.releaseTime = "2021-07-04 22:51:44"
        panda110.originalUrl = "https://www.bilibili.com/video/BV1w64y1b7KR?share_source=copy_web"
        panda110.tags = "和叶,萌宠,萌萌哒,可爱,动物圈"
        panda110.authorName = "迩後咩"
        panda110.isStar = true
        panda110.cover =
            "http://i0.hdslb.com/bfs/archive/ff6f865b1a8d46363966e5cd8b4fe579463d9d6e.jpg"
        list.add(panda110)

        val panda111 = PetVideo()
        panda111.type = PetType.PANDA.ordinal
        panda111.fileName = "panda_baby_111"
        panda111.code = 149
        panda111.duration = 91
        panda111.period = PeriodType.BABY.ordinal
        panda111.title = "等比例长大的和花小可爱能"
        panda111.releaseTime = "2021-12-23 14:26:51"
        panda111.originalUrl = "https://www.bilibili.com/video/BV1E44y177TS?share_source=copy_web"
        panda111.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda111.authorName = "ccitoo"
        panda111.cover =
            "http://i1.hdslb.com/bfs/archive/a021af98c6737bc51c4abbebf78ef8dd412693d8.jpg"
        list.add(panda111)

        val panda112 = PetVideo()
        panda112.type = PetType.PANDA.ordinal
        panda112.fileName = "panda_baby_112"
        panda112.code = 150
        panda112.duration = 25
        panda112.period = PeriodType.BABY.ordinal
        panda112.title = "担心有两脚兽把熟睡的弟弟妹妹偷走，和花姐姐尽职尽责地放哨"
        panda112.releaseTime = "2021-03-31 00:15:32"
        panda112.originalUrl = "https://www.bilibili.com/video/BV1Ui4y1P73F?share_source=copy_web"
        panda112.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda112.authorName = "和花花真好看"
        panda112.cover =
            "http://i0.hdslb.com/bfs/archive/7adb309f099e9aa2cd2a9751d4a45253e429168d.jpg"
        list.add(panda112)

        val panda113 = PetVideo()
        panda113.type = PetType.PANDA.ordinal
        panda113.fileName = "panda_baby_113"
        panda113.code = 151
        panda113.duration = 168
        panda113.period = PeriodType.BABY.ordinal
        panda113.title = "花花：我躺平了，金喜迪迪你咋还不来找我玩？【大熊猫和花、金喜】"
        panda113.releaseTime = "2021-09-01 13:12:45"
        panda113.originalUrl = "https://www.bilibili.com/video/BV1tg411L7Xq?share_source=copy_web"
        panda113.tags = "和花,金喜,萌宠,萌萌哒,可爱,动物圈"
        panda113.authorName = "隽一一"
        panda113.cover =
            "http://i1.hdslb.com/bfs/archive/f86ccb3dd3a96d0b2f69161e81b4633cd8b1fdf2.jpg"
        list.add(panda113)

        val panda114 = PetVideo()
        panda114.type = PetType.PANDA.ordinal
        panda114.fileName = "panda_baby_114"
        panda114.code = 152
        panda114.duration = 67
        panda114.period = PeriodType.BABY.ordinal
        panda114.title = "最萌最可爱的逗号～“花式”葛优瘫刷笋皮啃笋头。【大熊猫和花】"
        panda114.releaseTime = "2021-07-27 17:04:47"
        panda114.originalUrl = "https://www.bilibili.com/video/BV1pb4y1r7cj?share_source=copy_web"
        panda114.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda114.authorName = "隽一一"
        panda114.cover =
            "http://i2.hdslb.com/bfs/archive/acd8fa7577d2f9c2f5512225615f28b5ab0509a0.jpg"
        list.add(panda114)

        val panda115 = PetVideo()
        panda115.type = PetType.PANDA.ordinal
        panda115.fileName = "panda_baby_115"
        panda115.code = 153
        panda115.duration = 60
        panda115.period = PeriodType.BABY.ordinal
        panda115.title = "一朵招蜂引蝶的小花花正走向你。。【大熊猫和花】"
        panda115.releaseTime = "2021-10-31 20:07:24"
        panda115.originalUrl = "https://www.bilibili.com/video/BV1QU4y1u7Qc?share_source=copy_web"
        panda115.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda115.authorName = "迩後咩"
        panda115.isStar = true
        panda115.cover =
            "http://i0.hdslb.com/bfs/archive/e9125ff63a4b45ae1a78f8d92019c27d09baecaa.jpg"
        list.add(panda115)

        val panda116 = PetVideo()
        panda116.type = PetType.PANDA.ordinal
        panda116.fileName = "panda_baby_116"
        panda116.code = 154
        panda116.duration = 72
        panda116.period = PeriodType.BABY.ordinal
        panda116.title = "【大熊猫和花】花花从石坡上下来，并四处张望"
        panda116.releaseTime = "2021-10-10 12:53:45"
        panda116.originalUrl = "https://www.bilibili.com/video/BV1GQ4y1z7bh?share_source=copy_web"
        panda116.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda116.authorName = "空调轰轰响"
        panda116.isStar = true
        panda116.cover =
            "http://i1.hdslb.com/bfs/archive/efe30f1edf228c98dbd6d3aef0bd2248e27ca650.jpg"
        list.add(panda116)

        val panda117 = PetVideo()
        panda117.type = PetType.PANDA.ordinal
        panda117.fileName = "panda_baby_117"
        panda117.code = 155
        panda117.duration = 240
        panda117.period = PeriodType.BABY.ordinal
        panda117.title = "茱萸：是和花姐先动手的！"
        panda117.releaseTime = "2021-08-02 17:08:23"
        panda117.originalUrl = "https://www.bilibili.com/video/BV1Ph41167Jo?share_source=copy_web"
        panda117.tags = "茱萸,和花,萌宠,萌萌哒,可爱,动物圈"
        panda117.authorName = "隽一一"
        panda117.cover =
            "http://i1.hdslb.com/bfs/archive/92f9e161995cf4855f7f7c5ad418b7aeec855e4e.jpg"
        list.add(panda117)

        val panda118 = PetVideo()
        panda118.type = PetType.PANDA.ordinal
        panda118.fileName = "panda_baby_118"
        panda118.code = 156
        panda118.duration = 22
        panda118.period = PeriodType.BABY.ordinal
        panda118.title = "【大熊猫和花、金喜】快来人，把这个欺负姐姐的凑弟弟抱走"
        panda118.releaseTime = "2021-02-04 17:23:21"
        panda118.originalUrl = "https://www.bilibili.com/video/BV1Bv411e7AY?share_source=copy_web"
        panda118.tags = "金喜,和花,萌宠,萌萌哒,可爱,动物圈"
        panda118.authorName = "隽一一"
        panda118.isStar = true
        panda118.cover =
            "http://i1.hdslb.com/bfs/archive/394d02c0bd844ecc361d2643cebe45650acd6c11.jpg"
        list.add(panda118)

        val panda119 = PetVideo()
        panda119.type = PetType.PANDA.ordinal
        panda119.fileName = "panda_baby_119"
        panda119.code = 157
        panda119.duration = 29
        panda119.period = PeriodType.BABY.ordinal
        panda119.title = "你能能祟祟的躲在花后面干嘛？～大熊猫和花"
        panda119.releaseTime = "2021-05-15 10:12:44"
        panda119.originalUrl = "https://www.bilibili.com/video/BV1tb4y1f7LW?share_source=copy_web"
        panda119.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda119.authorName = "隽一一"
        panda119.cover =
            "http://i1.hdslb.com/bfs/archive/d90b4d3a26d0070bf6483c1a7f63a8f61d266c68.jpg"
        list.add(panda119)


        val panda120 = PetVideo()
        panda120.type = PetType.PANDA.ordinal
        panda120.fileName = "panda_baby_120"
        panda120.code = 158
        panda120.duration = 19
        panda120.period = PeriodType.BABY.ordinal
        panda120.title = "小仙女下架子时还不忘秀一波颜值（大熊猫和花）"
        panda120.releaseTime = "2021-02-25 07:42:02"
        panda120.originalUrl = "https://www.bilibili.com/video/BV1yy4y1h7j4?share_source=copy_web"
        panda120.tags = ",萌宠,萌萌哒,可爱,动物圈"
        panda120.authorName = "和花花真好看"
        panda120.cover =
            "http://i2.hdslb.com/bfs/archive/b2c19b530c03d031cc6755c11be825e23c4faccc.jpg"
        list.add(panda120)

        val panda121 = PetVideo()
        panda121.type = PetType.PANDA.ordinal
        panda121.fileName = "panda_baby_panda121"
        panda121.code = 159
        panda121.duration = 54
        panda121.period = PeriodType.BABY.ordinal
        panda121.isStar = false
        panda121.title = "【大熊猫和花】和花第一次爬上木架最高层，太可爱了"
        panda121.releaseTime = "2021-12-16 18:45:09"
        panda121.originalUrl = "https://www.bilibili.com/video/BV13L411j7Ay/"
        panda121.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda121.authorName = "青栀香如酥_"
        panda121.cover =
            "http://i1.hdslb.com/bfs/archive/e3367ceb6045a4efd4f62dfd6558153dfb27dd8b.jpg"
        list.add(panda121)

        val panda122 = PetVideo()
        panda122.type = PetType.PANDA.ordinal
        panda122.fileName = "panda_baby_panda122"
        panda122.code = 160
        panda122.duration = 15
        panda122.period = PeriodType.BABY.ordinal
        panda122.isStar = true
        panda122.title = "又甜又媚的小狐狸就是我们仙女花本花啦（大熊猫和花）"
        panda122.releaseTime = "2021-02-19 20:49:00"
        panda122.originalUrl = "https://www.bilibili.com/video/BV19v411a7x6/"
        panda122.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda122.authorName = "和花花真好看"
        panda122.cover =
            "http://i2.hdslb.com/bfs/archive/680d781e0658779143cbc5397911740311e2e585.jpg"
        list.add(panda122)

        val panda123 = PetVideo()
        panda123.type = PetType.PANDA.ordinal
        panda123.fileName = "panda_baby_panda123"
        panda123.code = 161
        panda123.duration = 66
        panda123.period = PeriodType.BABY.ordinal
        panda123.isStar = false
        panda123.title = "小和花用小短tei挠痒痒（大熊猫和花）"
        panda123.releaseTime = "2021-02-21 12:01:01"
        panda123.originalUrl = "https://www.bilibili.com/video/BV1nv411Y7nC/"
        panda123.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda123.authorName = "和花花真好看"
        panda123.cover =
            "http://i1.hdslb.com/bfs/archive/ed2b60a7e00d52c95554c96f15b9d09011fe107c.jpg"
        list.add(panda123)


        val panda124 = PetVideo()
        panda124.type = PetType.PANDA.ordinal
        panda124.fileName = "panda_baby_panda124"
        panda124.code = 162
        panda124.duration = 38
        panda124.period = PeriodType.BABY.ordinal
        panda124.isStar = false
        panda124.title = "【大熊猫和花】阳光下的一朵小熊花"
        panda124.releaseTime = "2021-02-01 16:37:17"
        panda124.originalUrl = "https://www.bilibili.com/video/BV1Uz4y1m73f/"
        panda124.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda124.authorName = "隽一一"
        panda124.cover =
            "http://i2.hdslb.com/bfs/archive/d080471db413f3c94b03a6dfd3c7b26c182829f5.jpg"
        list.add(panda124)

        val panda125 = PetVideo()
        panda125.type = PetType.PANDA.ordinal
        panda125.fileName = "panda_baby_panda125"
        panda125.code = 163
        panda125.duration = 42
        panda125.period = PeriodType.BABY.ordinal
        panda125.isStar = false
        panda125.title = "天太热，和花花躺着一直在流口水和鼻水。"
        panda125.releaseTime = "2021-06-19 18:07:13"
        panda125.originalUrl = "https://www.bilibili.com/video/BV1Sb4y1d7UQ/"
        panda125.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda125.authorName = "隽一一"
        panda125.cover =
            "http://i1.hdslb.com/bfs/archive/fa01cde3e244ab1b4c72aa5b1bad27c0a72fc5d3.jpg"
        list.add(panda125)

        val panda126 = PetVideo()
        panda126.type = PetType.PANDA.ordinal
        panda126.fileName = "panda_baby_panda126"
        panda126.code = 164
        panda126.duration = 42
        panda126.period = PeriodType.BABY.ordinal
        panda126.isStar = false
        panda126.title = "【大熊猫和花】你是在挠痒痒还是在卖萌？"
        panda126.releaseTime = "2021-06-16 18:12:47"
        panda126.originalUrl = "https://www.bilibili.com/video/BV1Q54y1G7bi/"
        panda126.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda126.authorName = "隽一一"
        panda126.cover =
            "http://i2.hdslb.com/bfs/archive/1e7d2efd3370e36fcbba7b72cd23c21fc8be7e3e.png"
        list.add(panda126)

        val panda127 = PetVideo()
        panda127.type = PetType.PANDA.ordinal
        panda127.fileName = "panda_baby_panda127"
        panda127.code = 165
        panda127.duration = 73
        panda127.period = PeriodType.BABY.ordinal
        panda127.isStar = true
        panda127.title = "终于长出点熊样了。【大熊猫和花】"
        panda127.releaseTime = "2021-07-03 09:56:46"
        panda127.originalUrl = "https://www.bilibili.com/video/BV1Sv411H7wc/"
        panda127.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda127.authorName = "隽一一"
        panda127.cover =
            "http://i0.hdslb.com/bfs/archive/2371de3ae736f651dc510a145e8edffcbb2cc310.jpg"
        list.add(panda127)

        val panda128 = PetVideo()
        panda128.type = PetType.PANDA.ordinal
        panda128.fileName = "panda_baby_panda128"
        panda128.code = 166
        panda128.duration = 110
        panda128.period = PeriodType.BABY.ordinal
        panda128.isStar = false
        panda128.title = "谁是松狮小花的成长见证？-大木床！不同时期同一位置的花花。【大熊猫和花】"
        panda128.releaseTime = "2021-09-05 19:07:30"
        panda128.originalUrl = "https://www.bilibili.com/video/BV1nq4y1T7hy/"
        panda128.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda128.authorName = "隽一一"
        panda128.cover =
            "http://i2.hdslb.com/bfs/archive/a1e5820b07178e118eef32db142a6db37baac284.jpg"
        list.add(panda128)

        val panda129 = PetVideo()
        panda129.type = PetType.PANDA.ordinal
        panda129.fileName = "panda_baby_panda129"
        panda129.code = 167
        panda129.duration = 50
        panda129.period = PeriodType.BABY.ordinal
        panda129.isStar = true
        panda129.title = "像不像抱着零食罐子的你？【大熊猫和花】"
        panda129.releaseTime = "2021-05-25 19:13:36"
        panda129.originalUrl = "https://www.bilibili.com/video/BV1wo4y1271Y/"
        panda129.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda129.authorName = "隽一一"
        panda129.cover =
            "http://i2.hdslb.com/bfs/archive/5423ace07a769232e38eeb1dbd2622f4c478c20a.jpg"
        list.add(panda129)

        val panda130 = PetVideo()
        panda130.type = PetType.PANDA.ordinal
        panda130.fileName = "panda_baby_panda130"
        panda130.code = 168
        panda130.duration = 20
        panda130.period = PeriodType.BABY.ordinal
        panda130.isStar = false
        panda130.title = "【大熊猫和花】这小姑娘连睡觉都在卖萌"
        panda130.releaseTime = "2021-01-28 17:46:24"
        panda130.originalUrl = "https://www.bilibili.com/video/BV1aN411o7S8/"
        panda130.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda130.authorName = "隽一一"
        panda130.cover =
            "http://i1.hdslb.com/bfs/archive/c772e041b6f90ecaa927c716f1d84a95a8b7e568.jpg"
        list.add(panda130)

        val panda131 = PetVideo()
        panda131.type = PetType.PANDA.ordinal
        panda131.fileName = "panda_baby_panda131"
        panda131.code = 169
        panda131.duration = 72
        panda131.period = PeriodType.BABY.ordinal
        panda131.isStar = true
        panda131.title = "二狗：和fafa，奉劝你不要太飘。【大熊猫和花、润玥】"
        panda131.releaseTime = "2021-09-17 14:42:26"
        panda131.originalUrl = "https://www.bilibili.com/video/BV1zR4y1H77E/"
        panda131.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda131.authorName = "隽一一"
        panda131.cover =
            "http://i2.hdslb.com/bfs/archive/6ba2275afe581061ba2e371eb5af86e03bb57a10.jpg"
        list.add(panda131)

        val panda132 = PetVideo()
        panda132.type = PetType.PANDA.ordinal
        panda132.fileName = "panda_baby_panda132"
        panda132.code = 170
        panda132.duration = 19
        panda132.period = PeriodType.BABY.ordinal
        panda132.isStar = true
        panda132.title = "功夫熊猫是怎样睡成的？【大熊猫金喜】"
        panda132.releaseTime = "2021-07-08 20:14:28"
        panda132.originalUrl = "https://www.bilibili.com/video/BV1c54y1n7k6/"
        panda132.tags = "金喜,萌宠,萌萌哒,可爱,动物圈"
        panda132.authorName = "隽一一"
        panda132.cover =
            "http://i1.hdslb.com/bfs/archive/2642c980e4f232503b666fa08dcd4318cb14d637.jpg"
        list.add(panda132)

        val panda133 = PetVideo()
        panda133.type = PetType.PANDA.ordinal
        panda133.fileName = "panda_baby_panda133"
        panda133.code = 171
        panda133.duration = 60
        panda133.period = PeriodType.BABY.ordinal
        panda133.isStar = true
        panda133.title = "淼淼仔金喜：和花姐姐挤到我了 打你屁屁哼~"
        panda133.releaseTime = "2020-12-06 17:06:10"
        panda133.originalUrl = "https://www.bilibili.com/video/BV1Hf4y1i7sM/"
        panda133.tags = "金喜,萌宠,萌萌哒,可爱,动物圈"
        panda133.authorName = "羽川゚"
        panda133.cover =
            "http://i0.hdslb.com/bfs/archive/049c56c66dbdf3157c1fbe93768ac24f06d1f42c.jpg"
        list.add(panda133)

        val panda134 = PetVideo()
        panda134.type = PetType.PANDA.ordinal
        panda134.fileName = "panda_baby_panda134"
        panda134.code = 172
        panda134.duration = 94
        panda134.period = PeriodType.BABY.ordinal
        panda134.isStar = true
        panda134.title = "【大熊猫雅颂】盖被被，睡觉觉"
        panda134.releaseTime = "2021-11-02 18:17:09"
        panda134.originalUrl = "https://www.bilibili.com/video/BV1iP4y1L7n3/"
        panda134.tags = "雅颂,萌宠,萌萌哒,可爱,动物圈"
        panda134.authorName = "辛辛糖包"
        panda134.cover =
            "http://i2.hdslb.com/bfs/archive/370710878bca5492ddf22eb3ad0548d668b33b22.jpg"
        list.add(panda134)

        val panda135 = PetVideo()
        panda135.type = PetType.PANDA.ordinal
        panda135.fileName = "panda_baby_panda135"
        panda135.code = 173
        panda135.duration = 108
        panda135.period = PeriodType.BABY.ordinal
        panda135.isStar = true
        panda135.title = "【大熊猫金宵】奶妈说这是个“自带美颜”的宝宝"
        panda135.releaseTime = "2021-11-03 19:25:45"
        panda135.originalUrl = "https://www.bilibili.com/video/BV1ZF411a731/"
        panda135.tags = "金宵,萌宠,萌萌哒,可爱,动物圈"
        panda135.authorName = "辛辛糖包"
        panda135.cover =
            "http://i0.hdslb.com/bfs/archive/9fd55e997fb297e22fd235f8458bf4d94a5d1bf6.jpg"
        list.add(panda135)

        val panda136 = PetVideo()
        panda136.type = PetType.PANDA.ordinal
        panda136.fileName = "panda_baby_panda136"
        panda136.code = 174
        panda136.duration = 30
        panda136.period = PeriodType.BABY.ordinal
        panda136.isStar = false
        panda136.title = "小公主上学摸鱼的样子真可爱。【大熊猫金宵】"
        panda136.releaseTime = "2021-12-28 19:09:45"
        panda136.originalUrl = "https://www.bilibili.com/video/BV15L411L7fr/"
        panda136.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda136.authorName = "隽一一"
        panda136.cover =
            "http://i0.hdslb.com/bfs/archive/9761e6820ccc6b409d3bc7f3d9d12bcd78187464.jpg"
        list.add(panda136)

        val panda137 = PetVideo()
        panda137.type = PetType.PANDA.ordinal
        panda137.fileName = "panda_baby_panda137"
        panda137.code = 175
        panda137.duration = 31
        panda137.period = PeriodType.BABY.ordinal
        panda137.isStar = false
        panda137.title = "包包:奶妈等等我～"
        panda137.releaseTime = "2021-05-11 16:16:23"
        panda137.originalUrl = "https://www.bilibili.com/video/BV1iK4y1d7PS/"
        panda137.tags = "包包,萌宠,萌萌哒,可爱,动物圈"
        panda137.authorName = "迩後咩"
        panda137.cover =
            "http://i0.hdslb.com/bfs/archive/d8ba775e96bbe9faafc6030d78039eaa3ebc6892.jpg"
        list.add(panda137)

        val panda138 = PetVideo()
        panda138.type = PetType.PANDA.ordinal
        panda138.fileName = "panda_baby_panda138"
        panda138.code = 176
        panda138.duration = 134
        panda138.period = PeriodType.BABY.ordinal
        panda138.isStar = false
        panda138.title = "一家能靠着绝不坐着，把兜兜弟弟压得只剩一头半身【兜兜一家】"
        panda138.releaseTime = "2021-07-10 22:31:46"
        panda138.originalUrl = "https://www.bilibili.com/video/BV16y4y1K74k/"
        panda138.tags = "兜兜,萌宠,萌萌哒,可爱,动物圈"
        panda138.authorName = "迩後咩"
        panda138.cover =
            "http://i1.hdslb.com/bfs/archive/c6e559c9c7ef8ec2117bc75c819a5a5f57e9fcb2.jpg"
        list.add(panda138)

        val panda139 = PetVideo()
        panda139.type = PetType.PANDA.ordinal
        panda139.fileName = "panda_baby_panda139"
        panda139.code = 177
        panda139.duration = 77
        panda139.period = PeriodType.BABY.ordinal
        panda139.isStar = true
        panda139.title = "陪练包&战神兜 日常互rua，大熊猫包包兜兜"
        panda139.releaseTime = "2021-09-26 15:23:20"
        panda139.originalUrl = "https://www.bilibili.com/video/BV1UL411W78E/"
        panda139.tags = "包包,兜兜,萌宠,萌萌哒,可爱,动物圈"
        panda139.authorName = "迩後咩"
        panda139.cover =
            "http://i0.hdslb.com/bfs/archive/4a2975c3f709487c626bb3a0003aead9020c01f5.jpg"
        list.add(panda139)

        val panda140 = PetVideo()
        panda140.type = PetType.PANDA.ordinal
        panda140.fileName = "panda_baby_panda140"
        panda140.code = 178
        panda140.duration = 75
        panda140.period = PeriodType.BABY.ordinal
        panda140.isStar = true
        panda140.title = "【下雪】熊猫宝宝学妈妈吃草，不得要领【绅宾】"
        panda140.releaseTime = "2021-12-04 17:56:24"
        panda140.originalUrl = "https://www.bilibili.com/video/BV1Uf4y1K7uY/"
        panda140.tags = "绅宾,萌宠,萌萌哒,可爱,动物圈"
        panda140.authorName = "迩後咩"
        panda140.cover =
            "http://i1.hdslb.com/bfs/archive/d26a330ac4a3032d8f43dc7b306e000079b0c799.jpg"
        list.add(panda140)

        val panda141 = PetVideo()
        panda141.type = PetType.PANDA.ordinal
        panda141.fileName = "panda_baby_panda141"
        panda141.code = 179
        panda141.duration = 79
        panda141.period = PeriodType.BABY.ordinal
        panda141.isStar = true
        panda141.title = "【下雪】大熊猫芊芊：把娃裹起糖霜给奶爸换果果"
        panda141.releaseTime = "2021-01-10 16:40:47"
        panda141.originalUrl = "https://www.bilibili.com/video/BV1gK4y1W7L7/"
        panda141.tags = "芊芊,萌宠,萌萌哒,可爱,动物圈"
        panda141.authorName = "迩後咩"
        panda141.cover =
            "http://i1.hdslb.com/bfs/archive/09aecde0ef0523cea0879b146b38a99b0b30c3b1.jpg"
        list.add(panda141)

    }

    fun getHeHuaHeYe() {

        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_hehua_heye_1"
        panda.code = 33
        panda.duration = 17
        panda.period = PeriodType.BABY.ordinal
        panda.title = "【和花与和叶】和叶：姐姐，亲亲"
        panda.releaseTime = "2021-12-27 20:14:57"
        panda.originalUrl = "https://www.bilibili.com/video/BV1N34y1z7Xd?share_source=copy_web"
        panda.tags = "大熊猫,动物圈,宠物,大熊猫和花,大熊猫和叶"
        panda.authorName = "Pandaful熊猫社区"
        panda.cover = "http://i0.hdslb.com/bfs/archive/6ed0425fb3a503d8fa63b3cafc096e6be1ade880.jpg"
        list.add(panda)

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_hehua_heye_2"
        panda1.code = 34
        panda1.duration = 114
        panda1.period = PeriodType.GROUP.ordinal
        panda1.title = "【大熊猫和花和叶】姐弟俩的吃播～感觉有点生疏了，坐这么远"
        panda1.releaseTime = "2021-09-10 12:28:12"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1pb4y127fV?share_source=copy_web"
        panda1.tags = "和花,和叶,呆萌,滚滚,国宝,熊猫基地,熊猫宝宝,动物圈,大熊猫"
        panda1.authorName = "空调轰轰响"
        panda1.cover =
            "http://i2.hdslb.com/bfs/archive/8c8b14a9f6ad5e7401a8e3e5900fb5f071a6a581.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_hehua_heye_3"
        panda2.code = 35
        panda2.duration = 109
        panda2.period = PeriodType.GROUP.ordinal
        panda2.title = "我的霸道姐姐。【大熊猫和花、和叶】"
        panda2.releaseTime = "2021-11-11 18:48:51"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1Sb4y187nF?share_source=copy_web"
        panda2.tags = "和花,和叶,萌宠,萌萌哒,可爱,熊猫,动物圈,大熊猫"
        panda2.authorName = "隽一一"
        panda2.cover =
            "http://i2.hdslb.com/bfs/archive/09d78221fcdbbe73fc4cbef675818283ef53665b.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_hehua_heye_4"
        panda3.code = 36
        panda3.duration = 114
        panda3.period = PeriodType.GROUP.ordinal
        panda3.title = "【大熊猫和花和叶】生活不易，叶子叹气：自己的姐姐只有宠着"
        panda3.releaseTime = "2021-09-29 12:22:33"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1Nv411G7im?share_source=copy_web"
        panda3.tags = "和花,和叶,大熊猫,萌宠,国宝,滚滚,呆萌,熊猫基地,熊猫宝宝,动物圈"
        panda3.authorName = "空调轰轰响"
        panda3.cover =
            "http://i1.hdslb.com/bfs/archive/7f544245e97b756e5782d5f2f4bc945ef279acbc.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_hehua_heye_5"
        panda4.code = 37
        panda4.duration = 58
        panda4.period = PeriodType.GROUP.ordinal
        panda4.title = "【大熊猫和花和叶】断奶后第一次亮相，弟弟怎么也逃不出花花的世界，哈哈哈"
        panda4.releaseTime = "2021-11-21 23:00:19"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1fq4y16786?share_source=copy_web"
        panda4.tags = "和花,和叶,萌宠,搞笑,动物,熊猫,动物圈"
        panda4.authorName = "小香妞爱熊猫"
        panda4.cover =
            "http://i2.hdslb.com/bfs/archive/8adfa70f9c1fe4ec5930134d3f962fd12257136d.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_hehua_heye_6"
        panda5.code = 38
        panda5.duration = 52
        panda5.period = PeriodType.GROUP.ordinal
        panda5.title = "【大熊猫和花和叶】贴贴我的臭弟弟，抱着臭弟弟一起睡觉觉"
        panda5.releaseTime = "2021-11-22 23:00:18"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1fq4y1u7CG?share_source=copy_web"
        panda5.tags = "和花,和叶,萌宠,搞笑,动物,熊猫,动物圈"
        panda5.authorName = "小香妞爱熊猫"
        panda5.cover =
            "http://i1.hdslb.com/bfs/archive/e08d9c693fbe9e69de24c70bb01a71ac766f6692.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_hehua_heye_7"
        panda6.code = 39
        panda6.duration = 59
        panda6.period = PeriodType.GROUP.ordinal
        panda6.title = "和花：弟弟，靠靠。和叶：姐姐，抱抱。【大熊猫】"
        panda6.releaseTime = "2021-12-02 19:09:12"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1dR4y1475R?share_source=copy_web"
        panda6.tags = "和花,和叶,萌萌哒,动物圈,大熊猫"
        panda6.authorName = "隽一一"
        panda6.cover =
            "http://i0.hdslb.com/bfs/archive/adb2c3c91ee6f80660c78ccc3529b9af9ecdcabd.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_hehua_heye_8"
        panda7.code = 40
        panda7.duration = 145
        panda7.period = PeriodType.GROUP.ordinal
        panda7.title = "我姐姐叫和花，我爱她，而且你知道吗?她也爱我！（永远爱我）【大熊猫和花】【大熊猫和叶】"
        panda7.releaseTime = "2021-12-16 19:38:53"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1XL4y1J7bp?share_source=copy_web"
        panda7.tags = "大熊猫,和花,和叶,,动物圈"
        panda7.authorName = "安娜丽丝k"
        panda7.cover =
            "http://i1.hdslb.com/bfs/archive/93795a5755980e5948a137500cf537f31f9b6f6c.png"
        list.add(panda7)
    }

    fun yuanrun_hehua() {

        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_hehua_family_1"
        panda.code = 41
        panda.duration = 142
        panda.period = PeriodType.MOM.ordinal
        panda.title = "【大熊猫和花】花花不会爬树把表姐气晕倒啦！最后表姐还是蹭蹭花花表示安慰"
        panda.releaseTime = "2021-05-15 13:28:51"
        panda.originalUrl = "https://www.bilibili.com/video/BV1sq4y177zJ?share_source=copy_web"
        panda.tags = "大熊猫,萌宠,萌萌哒,滚滚,熊猫基地,呆萌,熊猫,熊猫宝宝,动物圈"
        panda.authorName = "和花花真好看"
        panda.cover = "http://i2.hdslb.com/bfs/archive/c7dc01ce5bef2e59e0ac960fca587984ee3b8554.jpg"
        list.add(panda)

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_hehua_family_2"
        panda1.code = 42
        panda1.duration = 102
        panda1.period = PeriodType.MOM.ordinal
        panda1.title = "【熊猫和花】我已经把花花堵在角落里了，快拿麻袋"
        panda1.releaseTime = "2021-10-30 18:05:10"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1Wv411u7sg?share_source=copy_web"
        panda1.tags = "大熊猫,萌宠,搞笑,熊猫基地,可爱,萌萌哒,动物圈,熊猫宝宝,动物圈"
        panda1.authorName = "水果小分队的椰子"
        panda1.cover =
            "http://i2.hdslb.com/bfs/archive/cbcaa3fce41edaf2a57edfc531122cf4bd8c86ac.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_hehua_family_3"
        panda2.code = 43
        panda2.duration = 90
        panda2.period = PeriodType.MOM.ordinal
        panda2.title = "【大熊猫和花】10.29 曾经我有一个红苹果，然而…请看到最后！"
        panda2.releaseTime = "2021-10-29 23:00:41"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1tF411e76t?share_source=copy_web"
        panda2.tags = "大熊猫,萌宠,和花,熊猫基地,动物圈"
        panda2.authorName = "安娜丽丝k"
        panda2.cover =
            "http://i2.hdslb.com/bfs/archive/e7696f6e6ed4f0bbe8b343167355542033e6f426.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_hehua_family_4"
        panda3.code = 44
        panda3.duration = 15
        panda3.period = PeriodType.MOM.ordinal
        panda3.title = "您订购的一只和花正向您跑来"
        panda3.releaseTime = "2021-09-23 21:33:30"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1j64y187aS?share_source=copy_web"
        panda3.tags = "萌宠,熊猫基地,熊猫宝宝,大熊猫和花,动物圈,大熊猫"
        panda3.authorName = "Miss菜V"
        panda3.cover =
            "http://i0.hdslb.com/bfs/archive/abc67e03f053f799b004682563f38a1c5a0aca72.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_hehua_family_5"
        panda4.code = 45
        panda4.duration = 35
        panda4.period = PeriodType.MOM.ordinal
        panda4.title = "花花跑起来有多Q弹【大熊猫和花】"
        panda4.releaseTime = "2021-10-21 12:21:54"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1SF411Y73U?share_source=copy_web"
        panda4.tags = "萌宠,熊猫基地,萌萌哒,可爱,国宝,大熊猫成长记录,大熊猫和花,动物圈,大熊猫"
        panda4.authorName = "朙雨"
        panda4.cover =
            "http://i0.hdslb.com/bfs/archive/417f726303dd2dfe86baaae784c253f16df54411.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_hehua_family_6"
        panda5.code = 46
        panda5.duration = 73
        panda5.period = PeriodType.MOM.ordinal
        panda5.title = "放学了，和花花自己回家，坐在门口卖萌"
        panda5.releaseTime = "2021-06-04 21:19:36"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1LK4y137pR?share_source=copy_web"
        panda5.tags = "和花,动物,熊猫,动物圈"
        panda5.authorName = "隽一一"
        panda5.cover =
            "http://i2.hdslb.com/bfs/archive/52e01d32ee0b2b0c4f1dec46126ceb85ec955ac6.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_hehua_family_7"
        panda6.code = 47
        panda6.duration = 65
        panda6.period = PeriodType.MOM.ordinal
        panda6.title = "妈妈我不想回家！ 这事儿你个小孩子说了不算！"
        panda6.releaseTime = "2021-08-25 16:00:16"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1fP4y1H7aB?share_source=copy_web"
        panda6.tags = "萌宠,搞笑,滚滚,熊猫基地,熊猫,动物圈"
        panda6.authorName = "pandapia熊猫乌托邦"
        panda6.cover =
            "http://i2.hdslb.com/bfs/archive/0b1f0f13614751744c48bf570a163f8e78a145b3.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_hehua_family_8"
        panda7.code = 48
        panda7.duration = 165
        panda7.period = PeriodType.MOM.ordinal
        panda7.title = "【大熊猫和花】跟着园润妈妈学吃笋，花花好乖呀"
        panda7.releaseTime = "2021-06-20 22:00:00"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1Jq4y1L7hp?share_source=copy_web"
        panda7.tags = "搞笑,动物,生活,熊猫,影视,熊猫宝宝,宠物,大熊猫和花,动物圈"
        panda7.authorName = "小香妞爱熊猫"
        panda7.cover =
            "http://i0.hdslb.com/bfs/archive/c34d1d795f6d1630403eedd4f62a7aa9daf09e2a.jpg"
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = PetType.PANDA.ordinal
        panda8.fileName = "panda_hehua_family_9"
        panda8.code = 49
        panda8.duration = 41
        panda8.period = PeriodType.MOM.ordinal
        panda8.title = "【大熊猫和花】润玥姐姐欺负了fafa，园润妈妈火速赶到，替花花撑腰"
        panda8.releaseTime = "2021-04-27 22:00:07"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Bi4y1A7fK?share_source=copy_web"
        panda8.tags = "萌宠,动物,日常,熊猫,宠物,动物圈,大熊猫"
        panda8.authorName = "小香妞爱熊猫"
        panda8.cover =
            "http://i2.hdslb.com/bfs/archive/1fc8b950f87a0fbf381790acb0eb400f4f6f2215.jpg"
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_hehua_family_10"
        panda9.code = 50
        panda9.duration = 119
        panda9.period = PeriodType.MOM.ordinal
        panda9.title = "【大熊猫和花】园润喂花花喝neinei了，有干妈宠着的花花好幸福"
        panda9.releaseTime = "2021-04-14 22:00:14"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1FX4y137NP?share_source=copy_web"
        panda9.tags = "萌宠,搞笑,动物,生活,日常,熊猫,动物圈"
        panda9.authorName = "小香妞爱熊猫"
        panda9.cover =
            "http://i2.hdslb.com/bfs/archive/9a140f865263f27134d2e35f326f1af47e047c54.jpg"
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = PetType.PANDA.ordinal
        panda10.fileName = "panda_hehua_family_11"
        panda10.code = 51
        panda10.duration = 45
        panda10.period = PeriodType.MOM.ordinal
        panda10.title = "大熊猫和花：陈园润，到点喂我奶了。"
        panda10.releaseTime = "2021-05-02 17:55:42"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1fK4y1o7wG?share_source=copy_web"
        panda10.tags = "萌宠,和花,动物,园润,熊猫"
        panda10.authorName = "隽一一"
        panda10.cover =
            "http://i2.hdslb.com/bfs/archive/bd9e176439ca2aea80326b364feebae2c7986974.jpg"
        list.add(panda10)

        val panda11 = PetVideo()
        panda11.type = PetType.PANDA.ordinal
        panda11.fileName = "panda_hehua_family_12"
        panda11.code = 52
        panda11.duration = 33
        panda11.period = PeriodType.MOM.ordinal
        panda11.title = "【大熊猫园润和花】润润：花花来，姐姐给你亲亲抱抱举高高"
        panda11.releaseTime = "2021-05-01 14:01:47"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1u64y1U772?share_source=copy_web"
        panda11.tags = "萌宠,和花,动物,园润,熊猫"
        panda11.authorName = "丶祀很宔"
        panda11.cover =
            "http://i1.hdslb.com/bfs/archive/542ef17d9a74e57d3fe417109836bf6c7bc4d0f4.jpg"
        list.add(panda11)

        val panda12 = PetVideo()
        panda12.type = PetType.PANDA.ordinal
        panda12.fileName = "panda_hehua_family_13"
        panda12.code = 53
        panda12.duration = 117
        panda12.period = PeriodType.MOM.ordinal
        panda12.title = "和花花真棒，把园润表姐都哄睡着了，自己还醒着"
        panda12.releaseTime = "2021-05-02 14:58:38"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1UB4y1c7uh?share_source=copy_web"
        panda12.tags = "萌宠,和花,动物,园润,熊猫"
        panda12.authorName = "迩後咩"
        panda12.cover =
            "http://i0.hdslb.com/bfs/archive/60bd76446c93b4f1b0024f83cc5bd90840455a05.jpg"
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = PetType.PANDA.ordinal
        panda13.fileName = "panda_hehua_family_14"
        panda13.code = 54
        panda13.duration = 9
        panda13.period = PeriodType.MOM.ordinal
        panda13.title = "和花揍园润的屁屁"
        panda13.releaseTime = "2021-05-24 00:39:39"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1wA411V77F?share_source=copy_web"
        panda13.tags = "萌宠,和花,动物,园润,熊猫"
        panda13.authorName = "奇异果家的顺来会fly"
        panda13.cover =
            "http://i2.hdslb.com/bfs/archive/a36ecc39b78657250d0153e883630aa54510a5bb.jpg"
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_hehua_family_15"
        panda14.code = 55
        panda14.duration = 12
        panda14.period = PeriodType.MOM.ordinal
        panda14.title = "和花被园润坐了，气得捶了园润一顿"
        panda14.releaseTime = "2021-07-17 10:32:34"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1Tv411n7ZQ?share_source=copy_web"
        panda14.tags = "萌宠,和花,动物,园润,熊猫"
        panda14.authorName = "奇异果家的顺来会fly"
        panda14.cover =
            "http://i0.hdslb.com/bfs/archive/c9c6b48d25a5e0b06455d909ee7fbecbedbd23ce.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_hehua_family_16"
        panda15.code = 56
        panda15.duration = 63
        panda15.period = PeriodType.MOM.ordinal
        panda15.title = "出现了！吃笋皮吐笋肉的新品种大熊猫！"
        panda15.releaseTime = "2021-09-28 20:00:17"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1KQ4y167p1?share_source=copy_web"
        panda15.tags = "萌宠,和花,动物,熊猫"
        panda15.authorName = "iPanda熊猫频道"
        panda15.cover =
            "http://i2.hdslb.com/bfs/archive/1f01bb0c8591e0d0634eefb474993f91a5feb6b0.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
        panda16.fileName = "panda_hehua_family_17"
        panda16.code = 58
        panda16.duration = 179
        panda16.period = PeriodType.MOM.ordinal
        panda16.title = "花花已经能真吃一点笋了，还边吃边做仰卧起坐【大熊猫和花】"
        panda16.releaseTime = "2021-10-27 12:15:00"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1eF411e7Kx?share_source=copy_web"
        panda16.tags = "萌宠,和花,动物,润玥,熊猫"
        panda16.authorName = "朙雨"
        panda16.cover =
            "http://i1.hdslb.com/bfs/archive/0b59e5a1c572025f497767f0b23b3382f04d2a59.jpg"
        list.add(panda16)

        val panda17 = PetVideo()
        panda17.type = PetType.PANDA.ordinal
        panda17.fileName = "panda_hehua_family_18"
        panda17.code = 59
        panda17.duration = 142
        panda17.period = PeriodType.MOM.ordinal
        panda17.title = "不好好吃饭的和花，一天被奶爸抱进去三次加餐，喝盆盆奶喝到身上都是，出来还一直回味"
        panda17.releaseTime = "2021-12-07 13:59:30"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1BR4y1s7oo?share_source=copy_web"
        panda17.tags = "萌宠,熊猫基地,熊猫宝宝,大熊猫和花,动物圈"
        panda17.authorName = "Miss菜V"
        panda17.cover =
            "http://i0.hdslb.com/bfs/archive/1298bef5e9542f06e6f22d25a36496e2e375b9b9.jpg"
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_hehua_family_19"
        panda18.code = 60
        panda18.duration = 119
        panda18.period = PeriodType.MOM.ordinal
        panda18.title = "【大熊猫和花】花花困了又醒了，这状态切换好迅速"
        panda18.releaseTime = "2021-11-28 17:05:14"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1Rq4y167yo?share_source=copy_web"
        panda18.tags = "萌宠,和花,动物,熊猫"
        panda18.authorName = "朙雨"
        panda18.cover =
            "http://i1.hdslb.com/bfs/archive/8382d448a2b4351ec6dec9bf5c97a99bf77f2fe9.jpg"
        list.add(panda18)

        val panda19 = PetVideo()
        panda19.type = PetType.PANDA.ordinal
        panda19.fileName = "panda_hehua_family_20"
        panda19.code = 61
        panda19.duration = 32
        panda19.period = PeriodType.MOM.ordinal
        panda19.title = "萌兽觉醒，小西叽fafa肥来啦【大熊猫和花】"
        panda19.releaseTime = "2021-10-17 14:01:20"
        panda19.originalUrl = "https://www.bilibili.com/video/BV16r4y1y7Rs?share_source=copy_web"
        panda19.tags = "萌宠,和花,动物,熊猫"
        panda19.authorName = "朙雨"
        panda19.cover =
            "http://i2.hdslb.com/bfs/archive/d09695dcab5609a6355b08b5b24bf83839068ecd.jpg"
        list.add(panda19)

        val panda20 = PetVideo()
        panda20.type = PetType.PANDA.ordinal
        panda20.fileName = "panda_hehua_family_21"
        panda20.code = 62
        panda20.duration = 43
        panda20.period = PeriodType.MOM.ordinal
        panda20.title = "和花:最搞笑萌的吃播，吃着吃着睡着了"
        panda20.releaseTime = "2021-09-29 19:00:17"
        panda20.originalUrl = "https://www.bilibili.com/video/BV15q4y1Z7Cg?share_source=copy_web"
        panda20.tags = "萌宠,和花,动物,熊猫"
        panda20.authorName = "熊猫幼崽社区"
        panda20.cover =
            "http://i0.hdslb.com/bfs/archive/3c0cfb73b223e74890b878c1a5c2e2792a207dd2.jpg"
        list.add(panda20)

        val panda21 = PetVideo()
        panda21.type = PetType.PANDA.ordinal
        panda21.fileName = "panda_hehua_family_22"
        panda21.code = 63
        panda21.duration = 71
        panda21.period = PeriodType.MOM.ordinal
        panda21.title = "收煤气罐罐啦，花花每次被抱走乖的像假熊"
        panda21.releaseTime = "2021-11-11 19:15:12"
        panda21.originalUrl = "https://www.bilibili.com/video/BV1pg411K7aN?share_source=copy_web"
        panda21.tags = "萌宠,和花,动物,熊猫"
        panda21.authorName = "爱熊猫aipanda"
        panda21.cover =
            "http://i0.hdslb.com/bfs/archive/1b11a617d55019723006ea8af5c1d96a99dd565f.jpg"
        list.add(panda21)

        val panda22 = PetVideo()
        panda22.type = PetType.PANDA.ordinal
        panda22.fileName = "panda_hehua_family_23"
        panda22.code = 64
        panda22.duration = 39
        panda22.period = PeriodType.GROUP.ordinal
        panda22.title = "同样是熊猫，这俩长相区别好大【大熊猫和花&艾玖】"
        panda22.releaseTime = "2021-12-11 13:15:16"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1eh411x7FD?share_source=copy_web"
        panda22.tags = "萌宠,和花,动物,熊猫"
        panda22.authorName = "朙雨"
        panda22.cover =
            "http://i0.hdslb.com/bfs/archive/bbb4f4cba676bd065a0e34c3ac45451d62462308.jpg"
        list.add(panda22)

        val panda23 = PetVideo()
        panda23.type = PetType.PANDA.ordinal
        panda23.fileName = "panda_hehua_family_24"
        panda23.code = 65
        panda23.duration = 58
        panda23.period = PeriodType.MOM.ordinal
        panda23.title = "【大熊猫 】润玥悔不该得罪那和花呀 惨遭撕咬。。。"
        panda23.releaseTime = "2022-01-02 19:08:57"
        panda23.originalUrl = "https://www.bilibili.com/video/BV13Z4y1Q7Vc?share_source=copy_web"
        panda23.tags = "萌宠,和花,动物,熊猫"
        panda23.authorName = "动物米"
        panda23.cover =
            "http://i2.hdslb.com/bfs/archive/9d95310217ea81c31896fc51d2fb947369d9cda9.jpg"
        list.add(panda23)

        val panda24 = PetVideo()
        panda24.type = PetType.PANDA.ordinal
        panda24.fileName = "panda_hehua_family_25"
        panda24.code = 66
        panda24.duration = 30
        panda24.period = PeriodType.MOM.ordinal
        panda24.title = "长得这么好看，合理吗？"
        panda24.releaseTime = "2021-05-08 18:15:08"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1t64y127Hi?share_source=copy_web"
        panda24.tags = "萌宠,和花,动物,熊猫"
        panda24.authorName = "iPanda熊猫频道"
        panda24.cover =
            "http://i1.hdslb.com/bfs/archive/be6a5f103dd9da506739c7b878412d0c7fa01142.jpg"
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = PetType.PANDA.ordinal
        panda25.fileName = "panda_hehua_family_26"
        panda25.code = 67
        panda25.duration = 48
        panda25.period = PeriodType.MOM.ordinal
        panda25.title = "睡得迷糊的和花被抱去喝neinei，没喝够嗯嗯叫表示抗议"
        panda25.releaseTime = "2022-01-01 20:48:05"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1WL411L7T6?share_source=copy_web"
        panda25.tags = "萌宠,和花,动物,熊猫"
        panda25.authorName = "胖哒哒不月半"
        panda25.cover =
            "http://i1.hdslb.com/bfs/archive/43e3a383e0fc799627fcf617dfaaca1b2d3a2965.jpg"
        list.add(panda25)
    }

    fun panda_four() {

        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_hehua_four_1"
        panda.code = 68
        panda.duration = 67
        panda.period = PeriodType.GROUP.ordinal
        panda.title = "【大熊猫和花】爷爷等等我，我偶尔也是可以倍速播放的"
        panda.releaseTime = "2022-01-02 22:23:43"
        panda.originalUrl = "https://www.bilibili.com/video/BV11b4y1n7yd?share_source=copy_web"
        panda.tags = "萌宠,和花,动物,熊猫"
        panda.authorName = "胖哒哒不月半"
        panda.cover = "http://i2.hdslb.com/bfs/archive/711945b30d6bdd958b5140e5954c68d6b0f52f1e.jpg"
        list.add(panda)

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_hehua_four_2"
        panda1.code = 69
        panda1.duration = 68
        panda1.period = PeriodType.GROUP.ordinal
        panda1.title = "熊猫和花:回家 or 继续耍，这或许是个问题"
        panda1.releaseTime = "2022-01-04 22:09:05"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1RR4y1u7Kc?share_source=copy_web"
        panda1.tags = "萌宠,和花,动物,熊猫"
        panda1.authorName = "胖哒哒不月半"
        panda1.cover =
            "http://i1.hdslb.com/bfs/archive/7ad9900d155d8047999fa4c581b2a15eba641e21.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_hehua_four_3"
        panda2.code = 70
        panda2.duration = 113
        panda2.period = PeriodType.GROUP.ordinal
        panda2.title = "【大熊猫和花】任凭爷爷呼喊依然慢吞吞的花花"
        panda2.releaseTime = "2022-01-05 01:17:44"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1Fm4y1D7je?share_source=copy_web"
        panda2.tags = "萌宠,和花,动物,熊猫"
        panda2.authorName = "胖哒哒不月半"
        panda2.cover =
            "http://i1.hdslb.com/bfs/archive/6659f4f5221f6d004c015ce5d44e9788957decb5.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_hehua_four_4"
        panda3.code = 71
        panda3.duration = 133
        panda3.period = PeriodType.GROUP.ordinal
        panda3.title = "和花现在不仅跑得快，还会“急刹”"
        panda3.releaseTime = "2022-01-04 23:08:40"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1qD4y1F7Rd?share_source=copy_web"
        panda3.tags = "大熊猫和花、和叶、艾玖、润玥"
        panda3.authorName = "胖哒哒不月半"
        panda3.cover =
            "http://i0.hdslb.com/bfs/archive/6c8a7b2c45bd204a1f2698e9ff88439f902f7ba0.jpg"
        list.add(panda3)

    }
}