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
        panda17.title = "【大熊猫和花】牙牙都还没长齐，就学吃竹子啦？"
        panda17.releaseTime = "2021-01-07 20:17:41"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1D64y1Z7zW?share_source=copy_web"
        panda17.tags = "大熊猫,萌宠,必剪创作,滚滚,国宝,日常,可爱,呆萌,动物圈,大熊猫和花"
        panda17.authorName = "辛辛糖包"
        panda17.cover =
            "http://i1.hdslb.com/bfs/archive/aa002fb41c6efe49402b5131dfbfc5db40466f8f.jpg"
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_baby_18"
        panda18.code = 18
        panda18.duration = 170
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
        panda33.title = "你如果是奶爸，能顶地住吗？"
        panda33.releaseTime = "2021-07-05 19:49:41"
        panda33.originalUrl = "https://www.bilibili.com/video/BV14K4y1g71o?share_source=copy_web"
        panda33.tags = "大熊猫,萌宠,搞笑,萌萌哒,生活,可爱,日常,动物圈"
        panda33.authorName = "SEEU西柚熊猫"
        panda33.cover =
            "http://i0.hdslb.com/bfs/archive/a71090881640e6fc1ec18f06235ab7b6a9b19a92.jpg"
        list.add(panda33)

    }

    fun getHeHuaHeYe() {

        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_hehua_heye_1"
        panda.code = 33
        panda.duration = 17
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