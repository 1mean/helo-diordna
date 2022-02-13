package com.example.pandas.data

import com.example.pandas.bean.pet.PetType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetMomPandaData {

    private val list = mutableListOf<PetVideo>()

    fun getPetMomPandaData(): MutableList<PetVideo> {

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_mom_panda1"
        panda1.code = 180
        panda1.duration = 60
        panda1.period = PeriodType.MOM.ordinal
        panda1.isStar = false
        panda1.title = "【大熊猫艾莉和叶】我和我的艾莉妈妈是不是越来越像了呢？"
        panda1.releaseTime = "2021-09-26 12:25:57"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1df4y1w7Zz/"
        panda1.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda1.authorName = "空调轰轰响"
        panda1.cover =
            "https://i2.hdslb.com/bfs/archive/af619c6b1e4429fa8cca2a675dd9b0d9d1aeb96f.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_mom_panda2"
        panda2.code = 181
        panda2.duration = 379
        panda2.period = PeriodType.MOM.ordinal
        panda2.isStar = false
        panda2.title = "艾莉∶小叶子真好rua！和叶∶救命！"
        panda2.releaseTime = "2021-09-11 13:40:19"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1fq4y1Z74a/"
        panda2.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda2.authorName = "瘦瘦爱吃粘豆包"
        panda2.cover =
            "https://i1.hdslb.com/bfs/archive/18ec84505855d4aa508c2837267cc9af793b9543.jpg"
        list.add(panda2)


        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_mom_panda3"
        panda3.code = 182
        panda3.duration = 64
        panda3.period = PeriodType.MOM.ordinal
        panda3.isStar = true
        panda3.title = "艾莉妈妈跟女儿艾玖撒完娇，又去吸干儿子和叶。【大熊猫】"
        panda3.releaseTime = "2021-11-01 17:50:10"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1pL41137KJ/"
        panda3.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda3.authorName = "隽一一"
        panda3.cover =
            "https://i1.hdslb.com/bfs/archive/be56f493ba3da013a8cb861d360152d62f229eb4.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_mom_panda4"
        panda4.code = 183
        panda4.duration = 66
        panda4.period = PeriodType.MOM.ordinal
        panda4.isStar = false
        panda4.title = "小叶子弟弟也飘了，都敢骑妈妈山了【大熊猫和叶】"
        panda4.releaseTime = "2021-09-23 21:00:03"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1Bb4y1y7kT/"
        panda4.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda4.authorName = "小香妞爱熊猫"
        panda4.cover =
            "https://i2.hdslb.com/bfs/archive/84df87f55aacf9838fde6926e7a289fe253f829c.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_mom_panda5"
        panda5.code = 184
        panda5.duration = 37
        panda5.period = PeriodType.MOM.ordinal
        panda5.isStar = true
        panda5.title = "大熊猫艾莉：妈妈亲自接女儿艾玖放学，好有爱呀"
        panda5.releaseTime = "2021-08-05 21:00:11"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1tM4y1T7oQ/"
        panda5.tags = "艾莉,艾玖,萌宠,萌萌哒,可爱,动物圈"
        panda5.authorName = "小香妞爱熊猫"
        panda5.cover =
            "https://i0.hdslb.com/bfs/archive/441038bf47cf52d055f98e21c316357a2de5f61f.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_mom_panda6"
        panda6.code = 185
        panda6.duration = 48
        panda6.period = PeriodType.MOM.ordinal
        panda6.isStar = true
        panda6.title = "好有爱的艾莉妈妈，专门上树叫和叶回家"
        panda6.releaseTime = "2021-10-06 22:00:12"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1RL411W7Jm/"
        panda6.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda6.authorName = "小香妞爱熊猫"
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/fd905e4d161004b974fea6565e2807d409817f19.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_mom_panda7"
        panda7.code = 186
        panda7.duration = 60
        panda7.period = PeriodType.MOM.ordinal
        panda7.isStar = true
        panda7.title = "和叶和艾莉玩，回家慢半拍，紧赶慢赶门还是关了"
        panda7.releaseTime = "2021-10-02 13:33:47"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1GL411s74Q/"
        panda7.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda7.authorName = "迩後咩"
        panda7.cover =
            "https://i0.hdslb.com/bfs/archive/49e869bce4215ea9e10d55a0a76f4e0267d66eae.jpg"
        list.add(panda7)


        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_mom_panda9"
        panda9.code = 188
        panda9.duration = 30
        panda9.period = PeriodType.MOM.ordinal
        panda9.isStar = true
        panda9.title = "【大熊猫莽仔】搓汤圆，搓汤圆，莽仔搓的汤圆是圆又圆"
        panda9.releaseTime = "2021-11-25 16:36:06"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1cg411K799/"
        panda9.tags = "莽仔,萌宠,萌萌哒,可爱,动物圈"
        panda9.authorName = "猴哥某熊铁锤都退役了"
        panda9.cover =
            "https://i2.hdslb.com/bfs/archive/d5e6783a832c6c2048ffa584737efc3c4a3fa5de.jpg"
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = PetType.PANDA.ordinal
        panda10.fileName = "panda_mom_panda10"
        panda10.code = 189
        panda10.duration = 95
        panda10.period = PeriodType.MOM.ordinal
        panda10.isStar = false
        panda10.title = "【大熊猫和花润玥】花花费二狗（仗着姐姐宠你）"
        panda10.releaseTime = "2021-09-29 20:38:00"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1Yf4y1F7Uz"
        panda10.tags = "和花,润玥,萌宠,萌萌哒,可爱,动物圈"
        panda10.authorName = "大熊猫和花和叶"
        panda10.cover =
            "https://i2.hdslb.com/bfs/archive/fa388df0e1fcd4609616b741cec9eea21208ad5d.jpg"
        list.add(panda10)


        val panda11 = PetVideo()
        panda11.type = PetType.PANDA.ordinal
        panda11.fileName = "panda_mom_panda11"
        panda11.code = 190
        panda11.duration = 66
        panda11.period = PeriodType.MOM.ordinal
        panda11.isStar = false
        panda11.title = "和花帮干妈收拾二狗姐姐"
        panda11.releaseTime = "2021-11-05 16:24:09"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1PT4y1d7KE?share_source=copy_web"
        panda11.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda11.authorName = "奇异果家的顺来会fly"
        panda11.cover =
            "https://i1.hdslb.com/bfs/archive/6c01a5014926ad18d0ca3a8d9ec5c6a0416311e0.jpg"
        list.add(panda11)


        val panda12 = PetVideo()
        panda12.type = PetType.PANDA.ordinal
        panda12.fileName = "panda_mom_panda12"
        panda12.code = 191
        panda12.duration = 78
        panda12.period = PeriodType.MOM.ordinal
        panda12.isStar = true
        panda12.title = "园润收拾和花和二狗"
        panda12.releaseTime = "2021-12-20 16:16:40"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1Mi4y1o7bH?share_source=copy_web"
        panda12.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda12.authorName = "奇异果家的顺来会fly"
        panda12.cover =
            "https://i0.hdslb.com/bfs/archive/e1f205a68bc779146668ff609e33f693a36dd931.jpg"
        list.add(panda12)


        val panda13 = PetVideo()
        panda13.type = PetType.PANDA.ordinal
        panda13.fileName = "panda_mom_panda13"
        panda13.code = 192
        panda13.duration = 78
        panda13.period = PeriodType.MOM.ordinal
        panda13.isStar = true
        panda13.title = "【大熊猫和花】虽然不是大长腿，但也能用jiojio挠耳朵"
        panda13.releaseTime = "2021-12-24 20:34:25"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1rR4y1W7nU?share_source=copy_web"
        panda13.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda13.authorName = "朙雨"
        panda13.cover =
            "https://i0.hdslb.com/bfs/archive/03613da6a69639f5220b988e1e88ea15f8201267.jpg"
        list.add(panda13)


        val panda14 = PetVideo()
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_mom_panda14"
        panda14.code = 193
        panda14.duration = 81
        panda14.period = PeriodType.MOM.ordinal
        panda14.isStar = false
        panda14.title = "大熊猫润玥：陈园润，你自己去耍，不要一直守到我。"
        panda14.releaseTime = "2021-06-19 09:41:41"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1HV411s7Q3?share_source=copy_web"
        panda14.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda14.authorName = "隽一一"
        panda14.cover =
            "https://i2.hdslb.com/bfs/archive/11e7c28646e51021f02b0aba7296d539a6f7e8f7.png"
        list.add(panda14)


        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_mom_panda15"
        panda15.code = 194
        panda15.duration = 34
        panda15.period = PeriodType.MOM.ordinal
        panda15.isStar = true
        panda15.title = "和花：我想睡觉了，小舌头你替我卖会儿萌。【大熊猫】"
        panda15.releaseTime = "2021-09-07 18:13:42"
        panda15.originalUrl = "https://www.bilibili.com/video/BV15h411s7Va?share_source=copy_web"
        panda15.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda15.authorName = "隽一一"
        panda15.cover =
            "https://i1.hdslb.com/bfs/archive/49b8e0d0e588cb3abd0fb26c138a258afc80becd.jpg"
        list.add(panda15)


        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
        panda16.fileName = "panda_mom_panda16"
        panda16.code = 195
        panda16.duration = 97
        panda16.period = PeriodType.MOM.ordinal
        panda16.isStar = true
        panda16.title = "【大熊猫园润&和花】花园吃播"
        panda16.releaseTime = "2021-07-28 14:19:11"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1bo4y1Q7yt?share_source=copy_web"
        panda16.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda16.authorName = "朙雨"
        panda16.cover =
            "https://i0.hdslb.com/bfs/archive/e9f57ac6b9b102ab8420ea6c87364480f1e029b5.jpg"
        list.add(panda16)


        val panda17 = PetVideo()
        panda17.type = PetType.PANDA.ordinal
        panda17.fileName = "panda_mom_panda17"
        panda17.code = 196
        panda17.duration = 61
        panda17.period = PeriodType.MOM.ordinal
        panda17.isStar = false
        panda17.title = "仙女都不喝奶，仙女卖萌发憨就可以了。～温馨菜花园。【大熊猫和花、园润、润玥】"
        panda17.releaseTime = "2021-10-05 17:15:29"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1aP4y187k2?share_source=copy_web"
        panda17.tags = "和花,园润,润玥,萌宠,萌萌哒,可爱,动物圈"
        panda17.authorName = "隽一一"
        panda17.cover =
            "https://i0.hdslb.com/bfs/archive/9f001320256a3c1077546252dd7f8c4356494755.jpg"
        list.add(panda17)


        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_mom_panda18"
        panda18.code = 197
        panda18.duration = 27
        panda18.period = PeriodType.MOM.ordinal
        panda18.isStar = false
        panda18.title = "【大熊猫和花】暴雨天营业的花花"
        panda18.releaseTime = "2021-07-20 16:15:40"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1NV411p75N?share_source=copy_web"
        panda18.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda18.authorName = "和花花真好看"
        panda18.cover =
            "https://i1.hdslb.com/bfs/archive/197d578b672302baeb8c38257a48516e9af4bc87.jpg"
        list.add(panda18)


        val panda19 = PetVideo()
        panda19.type = PetType.PANDA.ordinal
        panda19.fileName = "panda_mom_panda19"
        panda19.code = 198
        panda19.duration = 30
        panda19.period = PeriodType.MOM.ordinal
        panda19.isStar = true
        panda19.title = "我的甜心小宝贝，不要走。【大熊猫园润、和花】"
        panda19.releaseTime = "2021-09-08 17:57:56"
        panda19.originalUrl = "https://www.bilibili.com/video/BV13P4y1Y7nF?share_source=copy_web"
        panda19.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda19.authorName = "隽一一"
        panda19.cover =
            "https://i2.hdslb.com/bfs/archive/b328f504a7e81909f5e1f39a4eda16d9e7a2a048.jpg"
        list.add(panda19)


        val panda20 = PetVideo()
        panda20.type = PetType.PANDA.ordinal
        panda20.fileName = "panda_mom_panda20"
        panda20.code = 199
        panda20.duration = 30
        panda20.period = PeriodType.MOM.ordinal
        panda20.isStar = true
        panda20.title = "园润：和花花，不要到处翻。这些熊孩子，越大越难管。"
        panda20.releaseTime = "2021-05-12 19:30:38"
        panda20.originalUrl = "https://www.bilibili.com/video/BV1mN411o7H7?share_source=copy_web"
        panda20.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda20.authorName = "隽一一"
        panda20.cover =
            "https://i1.hdslb.com/bfs/archive/f8c06fb3a89d07c75aafd8a2f96f7cfc82140294.jpg"
        list.add(panda20)


        val panda21 = PetVideo()
        panda21.type = PetType.PANDA.ordinal
        panda21.fileName = "panda_mom_panda21"
        panda21.code = 200
        panda21.duration = 88
        panda21.period = PeriodType.MOM.ordinal
        panda21.isStar = true
        panda21.title = "定格承欢膝下母慈女孝的小美好。【大熊猫和花、园润】"
        panda21.releaseTime = "2021-10-18 20:12:25"
        panda21.originalUrl = "https://www.bilibili.com/video/BV1Fb4y1h77p?share_source=copy_web"
        panda21.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda21.authorName = "隽一一"
        panda21.cover =
            "https://i1.hdslb.com/bfs/archive/2cd4b21fc82ecb1eed9b1ddb6ecd360abe1bd370.jpg"
        list.add(panda21)


        val panda22 = PetVideo()
        panda22.type = PetType.PANDA.ordinal
        panda22.fileName = "panda_mom_panda22"
        panda22.code = 201
        panda22.duration = 53
        panda22.period = PeriodType.MOM.ordinal
        panda22.isStar = true
        panda22.title = "【大熊猫和花】婀娜多姿和花花"
        panda22.releaseTime = "2021-10-06 22:58:07"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1oL4y1z7Ec?share_source=copy_web"
        panda22.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda22.authorName = "和花花真好看"
        panda22.cover =
            "https://i2.hdslb.com/bfs/archive/8a9f4337626e38ef4c3285311e61dd58f72e6721.jpg"
        list.add(panda22)


        val panda23 = PetVideo()
        panda23.type = PetType.PANDA.ordinal
        panda23.fileName = "panda_mom_panda23"
        panda23.code = 202
        panda23.duration = 55
        panda23.period = PeriodType.MOM.ordinal
        panda23.isStar = false
        panda23.title = "小树丛中的“圆”丁花花【大熊猫和花】"
        panda23.releaseTime = "2021-10-20 10:28:03"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1Fv411u71F?share_source=copy_web"
        panda23.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda23.authorName = "朙雨"
        panda23.cover =
            "https://i2.hdslb.com/bfs/archive/37c02a1d055a658dcf35797a5ac493b51300a302.jpg"
        list.add(panda23)


        val panda24 = PetVideo()
        panda24.type = PetType.PANDA.ordinal
        panda24.fileName = "panda_mom_panda24"
        panda24.code = 203
        panda24.duration = 37
        panda24.period = PeriodType.MOM.ordinal
        panda24.isStar = true
        panda24.title = "【大熊猫和花】花花啃着小树枝入睡，会睡得更香咩"
        panda24.releaseTime = "2021-10-14 16:30:14"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1ZP4y187Li?share_source=copy_web"
        panda24.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda24.authorName = "朙雨"
        panda24.cover =
            "https://i1.hdslb.com/bfs/archive/711100dea0ff3939ea23f7f677e7f1d608491e81.jpg"
        list.add(panda24)


        val panda25 = PetVideo()
        panda25.type = PetType.PANDA.ordinal
        panda25.fileName = "panda_mom_panda25"
        panda25.code = 204
        panda25.duration = 145
        panda25.period = PeriodType.MOM.ordinal
        panda25.isStar = true
        panda25.title = "陈园润，你的小可爱来了。～荔枝花自己上木架找干妈，陪干妈睡觉。【大熊猫和花、园润】"
        panda25.releaseTime = "2021-08-28 14:32:01"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1rA411c7Aj?share_source=copy_web"
        panda25.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda25.authorName = "隽一一"
        panda25.cover =
            "https://i1.hdslb.com/bfs/archive/0b568c393b4eb075e8b09490dd09b0bcf9fd0b49.jpg"
        list.add(panda25)


        val panda26 = PetVideo()
        panda26.type = PetType.PANDA.ordinal
        panda26.fileName = "panda_mom_panda26"
        panda26.code = 205
        panda26.duration = 33
        panda26.period = PeriodType.MOM.ordinal
        panda26.isStar = true
        panda26.title = "干妈不松口，你就不准走。园润拔腿助长！【大熊猫和花、园润】"
        panda26.releaseTime = "2021-04-30 11:39:17"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1684y1F727?share_source=copy_web"
        panda26.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda26.authorName = "隽一一"
        panda26.cover =
            "https://i0.hdslb.com/bfs/archive/973ea9dff7e7e3bd99a604765004bd79cdf4075f.jpg"
        list.add(panda26)


        val panda27 = PetVideo()
        panda27.type = PetType.PANDA.ordinal
        panda27.fileName = "panda_mom_panda27"
        panda27.code = 206
        panda27.duration = 74
        panda27.period = PeriodType.MOM.ordinal
        panda27.isStar = false
        panda27.title = "花姐成功破竹。彩虹P要不要吹起来？【大熊猫和花】"
        panda27.releaseTime = "2021-12-17 18:24:34"
        panda27.originalUrl = "https://www.bilibili.com/video/BV14a411k7fU?share_source=copy_web"
        panda27.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda27.authorName = "隽一一"
        panda27.cover =
            "https://i0.hdslb.com/bfs/archive/94cf360747ccf26f072e25fa8a8c91356682e864.jpg"
        list.add(panda27)


        val panda28 = PetVideo()
        panda28.type = PetType.PANDA.ordinal
        panda28.fileName = "panda_mom_panda28"
        panda28.code = 207
        panda28.duration = 63
        panda28.period = PeriodType.MOM.ordinal
        panda28.isStar = false
        panda28.title = "我妈太幼稚～润润玩爪爪 【大熊猫园润、润玥】"
        panda28.releaseTime = "2021-07-30 16:59:07"
        panda28.originalUrl = "https://www.bilibili.com/video/BV1nq4y1p7CL?share_source=copy_web"
        panda28.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda28.authorName = "隽一一"
        panda28.cover =
            "https://i0.hdslb.com/bfs/archive/906003724cfd8f5aea9152099c71fa2f9580ccd1.jpg"
        list.add(panda28)


        val panda29 = PetVideo()
        panda29.type = PetType.PANDA.ordinal
        panda29.fileName = "panda_mom_panda29"
        panda29.code = 208
        panda29.duration = 46
        panda29.period = PeriodType.MOM.ordinal
        panda29.isStar = true
        panda29.title = "这突如其来的母爱。。【大熊猫和花、园润】"
        panda29.releaseTime = "2021-06-23 18:18:48"
        panda29.originalUrl = "https://www.bilibili.com/video/BV1cy4y1M7Jr?share_source=copy_web"
        panda29.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda29.authorName = "隽一一"
        panda29.cover =
            "https://i2.hdslb.com/bfs/archive/c97147de426b22e54ac44ce23f37abadfa3ada58.jpg"
        list.add(panda29)

        val panda30 = PetVideo()
        panda30.type = PetType.PANDA.ordinal
        panda30.fileName = "panda_mom_panda30"
        panda30.code = 209
        panda30.duration = 64
        panda30.period = PeriodType.MOM.ordinal
        panda30.isStar = false
        panda30.title = "【大熊猫和花】润润妈妈真好，两个女儿都要照顾到，一个都不能漏"
        panda30.releaseTime = "2021-04-20 21:00:12"
        panda30.originalUrl = "https://www.bilibili.com/video/BV17V411H7z6"
        panda30.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda30.authorName = "小香妞爱熊猫"
        panda30.cover =
            "https://i1.hdslb.com/bfs/archive/0ebcc0676a5e05346f60897e192c5f993a7b62a7.jpg"
        list.add(panda30)


        val panda31 = PetVideo()
        panda31.type = PetType.PANDA.ordinal
        panda31.fileName = "panda_mom_panda31"
        panda31.code = 210
        panda31.duration = 72
        panda31.period = PeriodType.MOM.ordinal
        panda31.isStar = true
        panda31.title = "大熊猫园润：乖女儿呀，好东西要懂得一起分享"
        panda31.releaseTime = "2021-09-27 21:00:03"
        panda31.originalUrl = "https://www.bilibili.com/video/BV1wL4y1h7kj"
        panda31.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda31.authorName = "小香妞爱熊猫"
        panda31.cover =
            "https://i1.hdslb.com/bfs/archive/9857e4487f40f30a969ccfd07104cf6febc4f189.jpg"
        list.add(panda31)


        val panda32 = PetVideo()
        panda32.type = PetType.PANDA.ordinal
        panda32.fileName = "panda_mom_panda32"
        panda32.code = 211
        panda32.duration = 71
        panda32.period = PeriodType.MOM.ordinal
        panda32.isStar = false
        panda32.title = "干饭母女熊。～陈园润带润二狗吃播 【大熊猫园润、润玥】"
        panda32.releaseTime = "2021-09-28 20:33:06"
        panda32.originalUrl = "https://www.bilibili.com/video/BV1C64y187mj"
        panda32.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda32.authorName = "隽一一"
        panda32.cover =
            "https://i1.hdslb.com/bfs/archive/eec1be163a73834f0f27362df463c762188fd902.jpg"
        list.add(panda32)


        val panda33 = PetVideo()
        panda33.type = PetType.PANDA.ordinal
        panda33.fileName = "panda_mom_panda33"
        panda33.code = 212
        panda33.duration = 196
        panda33.period = PeriodType.MOM.ordinal
        panda33.isStar = false
        panda33.title = "苹果、窝头、营养液，润润的首选是？【大熊猫园润】"
        panda33.releaseTime = "2020-11-11 15:53:19"
        panda33.originalUrl = "https://www.bilibili.com/video/BV13D4y1R773"
        panda33.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda33.authorName = "迩後咩"
        panda33.cover =
            "https://i1.hdslb.com/bfs/archive/70bd29788a9f7b4355dc5fa3c61a467ad2f4a215.jpg"
        list.add(panda33)


        val panda34 = PetVideo()
        panda34.type = PetType.PANDA.ordinal
        panda34.fileName = "panda_mom_panda34"
        panda34.code = 213
        panda34.duration = 95
        panda34.period = PeriodType.MOM.ordinal
        panda34.isStar = false
        panda34.title = "戏精母女的窝头苹果之争。【大熊猫园润、润玥】"
        panda34.releaseTime = "2021-11-05 17:33:22"
        panda34.originalUrl = "https://www.bilibili.com/video/BV1344y1i7H1"
        panda34.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda34.authorName = "隽一一"
        panda34.cover =
            "https://i0.hdslb.com/bfs/archive/af8315387ddd10c5b2a1f9fa40e75accf735f14f.jpg"
        list.add(panda34)


        val panda35 = PetVideo()
        panda35.type = PetType.PANDA.ordinal
        panda35.fileName = "panda_mom_panda35"
        panda35.code = 214
        panda35.duration = 47
        panda35.period = PeriodType.MOM.ordinal
        panda35.isStar = false
        panda35.title = "永远的菜花园。【大熊猫园润、润玥、和花】"
        panda35.releaseTime = "2021-11-22 19:54:58"
        panda35.originalUrl = "https://www.bilibili.com/video/BV1w3411h7Hx"
        panda35.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda35.authorName = "隽一一"
        panda35.cover =
            "https://i0.hdslb.com/bfs/archive/9630c7ac8ab4261fa6693bb11e2c1b8280d4f0b7.jpg"
        list.add(panda35)


        val panda36 = PetVideo()
        panda36.type = PetType.PANDA.ordinal
        panda36.fileName = "panda_mom_panda36"
        panda36.code = 215
        panda36.duration = 71
        panda36.period = PeriodType.MOM.ordinal
        panda36.isStar = true
        panda36.title = "冬日的暖阳+软萌的小姑娘=慵懒而美好。【大熊猫和花】"
        panda36.releaseTime = "2021-12-25 16:34:58"
        panda36.originalUrl = "https://www.bilibili.com/video/BV1PY411p7SA"
        panda36.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda36.authorName = "隽一一"
        panda36.cover =
            "https://i0.hdslb.com/bfs/archive/56233033e7da91055a6d453c2795bfa7907fedde.jpg"
        list.add(panda36)


        val panda37 = PetVideo()
        panda37.type = PetType.PANDA.ordinal
        panda37.fileName = "panda_mom_panda37"
        panda37.code = 216
        panda37.duration = 50
        panda37.period = PeriodType.MOM.ordinal
        panda37.isStar = false
        panda37.title = "【大熊猫和花】10.29 花花秘籍：多喝水才能皮肤好哦！"
        panda37.releaseTime = "2021-10-30 12:28:01"
        panda37.originalUrl = "https://www.bilibili.com/video/BV1P34y1U7on"
        panda37.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda37.authorName = "安娜丽丝k"
        panda37.cover =
            "https://i0.hdslb.com/bfs/archive/511f8bd3cf381fd6a3a121d7df9109e7691ca15c.jpg"
        list.add(panda37)


        val panda38 = PetVideo()
        panda38.type = PetType.PANDA.ordinal
        panda38.fileName = "panda_mom_panda38"
        panda38.code = 217
        panda38.duration = 29
        panda38.period = PeriodType.MOM.ordinal
        panda38.isStar = false
        panda38.title = "【大熊猫和花】10.29 花花的苹果，快拿来！"
        panda38.releaseTime = "2021-11-01 00:02:42"
        panda38.originalUrl = "https://www.bilibili.com/video/BV14Q4y1S7JF"
        panda38.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda38.authorName = "安娜丽丝k"
        panda38.cover =
            "https://i0.hdslb.com/bfs/archive/f517f6b173a384f73ad625e776d023f7e6c171aa.jpg"
        list.add(panda38)


        val panda39 = PetVideo()
        panda39.type = PetType.PANDA.ordinal
        panda39.fileName = "panda_mom_panda39"
        panda39.code = 218
        panda39.duration = 58
        panda39.period = PeriodType.MOM.ordinal
        panda39.isStar = true
        panda39.title = "【大熊猫和花】10.29 和花花萌翻了！真的翻了"
        panda39.releaseTime = "2021-11-06 15:50:31"
        panda39.originalUrl = "https://www.bilibili.com/video/BV1JL4y1v7qi"
        panda39.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda39.authorName = "安娜丽丝k"
        panda39.cover =
            "https://i0.hdslb.com/bfs/archive/8b7f5379eaf19623af88f47768cc1100ef32e0f9.jpg"
        list.add(panda39)


        val panda40 = PetVideo()
        panda40.type = PetType.PANDA.ordinal
        panda40.fileName = "panda_mom_panda40"
        panda40.code = 219
        panda40.duration = 70
        panda40.period = PeriodType.MOM.ordinal
        panda40.isStar = false
        panda40.title = "【大熊猫和花】10.29  我活花绝不认输！"
        panda40.releaseTime = "2021-11-07 20:27:28"
        panda40.originalUrl = "https://www.bilibili.com/video/BV1LF411Y7Vx"
        panda40.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda40.authorName = "安娜丽丝k"
        panda40.cover =
            "https://i0.hdslb.com/bfs/archive/e7b1848ac0647baa0b6ca62f334d474e8fa7467e.jpg"
        list.add(panda40)


        val panda41 = PetVideo()
        panda41.type = PetType.PANDA.ordinal
        panda41.fileName = "panda_mom_panda41"
        panda41.code = 220
        panda41.duration = 66
        panda41.period = PeriodType.MOM.ordinal
        panda41.isStar = false
        panda41.title = "【大熊猫和花】10.29 花花要我抱抱才能起来"
        panda41.releaseTime = "2021-11-08 19:14:08"
        panda41.originalUrl = "https://www.bilibili.com/video/BV1Ur4y1C7z1"
        panda41.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda41.authorName = "安娜丽丝k"
        panda41.cover =
            "https://i1.hdslb.com/bfs/archive/47fe48e494c27b4b53129591002851dbaff153d1.jpg"
        list.add(panda41)


        val panda42 = PetVideo()
        panda42.type = PetType.PANDA.ordinal
        panda42.fileName = "panda_mom_panda42"
        panda42.code = 221
        panda42.duration = 282
        panda42.period = PeriodType.MOM.ordinal
        panda42.isStar = false
        panda42.title = "【大熊猫和花】锻炼身体增强免疫力，快来和花花一起运动呀！"
        panda42.releaseTime = "2021-11-10 19:11:19"
        panda42.originalUrl = "https://www.bilibili.com/video/BV1AP4y157du"
        panda42.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda42.authorName = "安娜丽丝k"
        panda42.cover =
            "https://i2.hdslb.com/bfs/archive/545d5af5c353a40fd28d55f69077fa10f45780de.jpg"
        list.add(panda42)


        val panda43 = PetVideo()
        panda43.type = PetType.PANDA.ordinal
        panda43.fileName = "panda_mom_panda43"
        panda43.code = 222
        panda43.duration = 208
        panda43.period = PeriodType.MOM.ordinal
        panda43.isStar = true
        panda43.title = "【大熊猫和花】11.20 花花呀，到嘴的苹果又飞了！（手抖见谅）"
        panda43.releaseTime = "2021-11-21 14:47:18"
        panda43.originalUrl = "https://www.bilibili.com/video/BV1MU4y1u7E9"
        panda43.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda43.authorName = "安娜丽丝k"
        panda43.cover =
            "https://i2.hdslb.com/bfs/archive/98b24d4ec36231ff8b0a260c28a2ccb78137898b.jpg"
        list.add(panda43)


        val panda44 = PetVideo()
        panda44.type = PetType.PANDA.ordinal
        panda44.fileName = "panda_mom_panda44"
        panda44.code = 223
        panda44.duration = 257
        panda44.period = PeriodType.MOM.ordinal
        panda44.isStar = true
        panda44.title = "【大熊猫和花】11.28 花花的小肚皮，是大家的小饭桌。必须打扫得干干净净！"
        panda44.releaseTime = "2021-11-29 08:24:52"
        panda44.originalUrl = "https://www.bilibili.com/video/BV1Cf4y1K7y7"
        panda44.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda44.authorName = "安娜丽丝k"
        panda44.cover =
            "https://i2.hdslb.com/bfs/archive/e9a5f094eea35d94fcd463a2d59e2336777c4429.jpg"
        list.add(panda44)


        val panda45 = PetVideo()
        panda45.type = PetType.PANDA.ordinal
        panda45.fileName = "panda_mom_panda45"
        panda45.code = 224
        panda45.duration = 27
        panda45.period = PeriodType.MOM.ordinal
        panda45.isStar = false
        panda45.title = "【大熊猫和花】11.30 只拍到一秒揉小耳朵的花花( •̥́ ˍ •̀ू )好可爱！"
        panda45.releaseTime = "2021-12-01 10:15:14"
        panda45.originalUrl = "https://www.bilibili.com/video/BV1mb4y1B7Qf"
        panda45.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda45.authorName = "安娜丽丝k"
        panda45.cover =
            "https://i2.hdslb.com/bfs/archive/73e3afcfac8bfca6e5edae162565266a52bca9b4.jpg"
        list.add(panda45)


        val panda46 = PetVideo()
        panda46.type = PetType.PANDA.ordinal
        panda46.fileName = "panda_mom_panda46"
        panda46.code = 225
        panda46.duration = 166
        panda46.period = PeriodType.MOM.ordinal
        panda46.isStar = false
        panda46.title = "【大熊猫和花】11.28 自律女明星，早睡早起做早操！Fight！"
        panda46.releaseTime = "2021-12-02 08:52:07"
        panda46.originalUrl = "https://www.bilibili.com/video/BV1RM4y1P7xE"
        panda46.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda46.authorName = "安娜丽丝k"
        panda46.cover =
            "https://i2.hdslb.com/bfs/archive/9466609b88b4c3ab99499fb4f848b5230f33282a.jpg"
        list.add(panda46)


        val panda47 = PetVideo()
        panda47.type = PetType.PANDA.ordinal
        panda47.fileName = "panda_mom_panda47"
        panda47.code = 226
        panda47.duration = 128
        panda47.period = PeriodType.MOM.ordinal
        panda47.isStar = false
        panda47.title = "【大熊猫和花】12.09 花花打奶嗝，艾玖来帮忙！"
        panda47.releaseTime = "2021-12-11 23:20:06"
        panda47.originalUrl = "https://www.bilibili.com/video/BV1Ci4y1d7xi"
        panda47.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda47.authorName = "安娜丽丝k"
        panda47.cover =
            "https://i2.hdslb.com/bfs/archive/7e8fb815d8e728797db048643e04e057b4dedc1b.jpg"
        list.add(panda47)


        val panda48 = PetVideo()
        panda48.type = PetType.PANDA.ordinal
        panda48.fileName = "panda_mom_panda48"
        panda48.code = 227
        panda48.duration = 95
        panda48.period = PeriodType.MOM.ordinal
        panda48.isStar = true
        panda48.title = "花姐的主业之五:撩架！?【大熊猫和花】"
        panda48.releaseTime = "2021-12-21 12:04:00"
        panda48.originalUrl = "https://www.bilibili.com/video/BV1tM4y1c7xU"
        panda48.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda48.authorName = "安娜丽丝k"
        panda48.cover =
            "https://i0.hdslb.com/bfs/archive/bcb6c4122f6323899286ef2bd28149dbb213cef3.jpg"
        list.add(panda48)


        val panda49 = PetVideo()
        panda49.type = PetType.PANDA.ordinal
        panda49.fileName = "panda_mom_panda49"
        panda49.code = 228
        panda49.duration = 129
        panda49.period = PeriodType.MOM.ordinal
        panda49.isStar = true
        panda49.title = "和花一边瞌睡，一边卖萌！【大熊猫和花】"
        panda49.releaseTime = "2021-12-27 19:04:03"
        panda49.originalUrl = "https://www.bilibili.com/video/BV1oT4y1f74R"
        panda49.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda49.authorName = "安娜丽丝k"
        panda49.cover =
            "https://i0.hdslb.com/bfs/archive/cf1a610f3cb2d33f1d649f31d561d8692bd34da4.png"
        list.add(panda49)


        val panda50 = PetVideo()
        panda50.type = PetType.PANDA.ordinal
        panda50.fileName = "panda_mom_panda50"
        panda50.code = 229
        panda50.duration = 65
        panda50.period = PeriodType.MOM.ordinal
        panda50.isStar = false
        panda50.title = "花姐的副业之四 : 睡播！【大熊猫和花】"
        panda50.releaseTime = "2021-12-26 10:30:18"
        panda50.originalUrl = "https://www.bilibili.com/video/BV1PY411p7ay"
        panda50.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda50.authorName = "安娜丽丝k"
        panda50.cover =
            "https://i1.hdslb.com/bfs/archive/cac6960f30c48a8478c7460b58ac8831518b98b4.jpg"
        list.add(panda50)


        val panda51 = PetVideo()
        panda51.type = PetType.PANDA.ordinal
        panda51.fileName = "panda_mom_panda51"
        panda51.code = 230
        panda51.duration = 119
        panda51.period = PeriodType.MOM.ordinal
        panda51.isStar = false
        panda51.title = "【大熊猫和花】她真的太会营业啦！！！"
        panda51.releaseTime = "2021-12-13 11:47:41"
        panda51.originalUrl = "https://www.bilibili.com/video/BV1RL4y1H7DJ"
        panda51.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda51.authorName = "空调轰轰响"
        panda51.cover =
            "https://i2.hdslb.com/bfs/archive/cefffe62cbc8b2e76b335f7ada131693dc170bb7.jpg"
        list.add(panda51)


        val panda52 = PetVideo()
        panda52.type = PetType.PANDA.ordinal
        panda52.fileName = "panda_mom_panda52"
        panda52.code = 231
        panda52.duration = 195
        panda52.period = PeriodType.MOM.ordinal
        panda52.isStar = false
        panda52.title = "奶爸：这个也控制不住了呀！～迄今为止我见过的最搞笑的收和花现场 【大熊猫】"
        panda52.releaseTime = "2021-12-15 17:11:44"
        panda52.originalUrl = "https://www.bilibili.com/video/BV1pr4y1D7FE"
        panda52.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda52.authorName = "隽一一"
        panda52.cover =
            "https://i0.hdslb.com/bfs/archive/fc1ee60e12f15cc6758aef931bc58386f52cfadd.jpg"
        list.add(panda52)


        val panda53 = PetVideo()
        panda53.type = PetType.PANDA.ordinal
        panda53.fileName = "panda_mom_panda53"
        panda53.code = 232
        panda53.duration = 48
        panda53.period = PeriodType.MOM.ordinal
        panda53.isStar = true
        panda53.title = "大熊猫和花高八度的海豚音，你听过吗？"
        panda53.releaseTime = "2021-12-23 14:13:50"
        panda53.originalUrl = "https://www.bilibili.com/video/BV1K44y177qX"
        panda53.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda53.authorName = "胖哒哒不月半"
        panda53.cover =
            "https://i2.hdslb.com/bfs/archive/e460746b3caa6338a492b1d29bb09768e81bb83a.jpg"
        list.add(panda53)


        val panda54 = PetVideo()
        panda54.type = PetType.PANDA.ordinal
        panda54.fileName = "panda_mom_panda54"
        panda54.code = 233
        panda54.duration = 40
        panda54.period = PeriodType.MOM.ordinal
        panda54.isStar = true
        panda54.title = "【大熊猫和花】花花嘴边挂着奶渍和观众打招呼，还舔手手"
        panda54.releaseTime = "2021-09-14 15:09:07"
        panda54.originalUrl = "https://www.bilibili.com/video/BV1xb4y127Bv"
        panda54.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda54.authorName = "空调轰轰响"
        panda54.cover =
            "https://i0.hdslb.com/bfs/archive/2c1fddc8548191068db4fb0d06ab6dfe879ccc41.jpg"
        list.add(panda54)


        val panda55 = PetVideo()
        panda55.type = PetType.PANDA.ordinal
        panda55.fileName = "panda_mom_panda55"
        panda55.code = 234
        panda55.duration = 132
        panda55.period = PeriodType.MOM.ordinal
        panda55.isStar = false
        panda55.title = "【大熊猫和花】重大视频流出！某花喝盆盆奶的高清大头录像来啦～"
        panda55.releaseTime = "2021-09-15 11:31:39"
        panda55.originalUrl = "https://www.bilibili.com/video/BV1RA411F7wP"
        panda55.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda55.authorName = "空调轰轰响"
        panda55.cover =
            "https://i0.hdslb.com/bfs/archive/adbb2e5dd009e8011e26e0db0f7b2f728926c13a.jpg"
        list.add(panda55)


        val panda56 = PetVideo()
        panda56.type = PetType.PANDA.ordinal
        panda56.fileName = "panda_mom_panda56"
        panda56.code = 235
        panda56.duration = 321
        panda56.period = PeriodType.MOM.ordinal
        panda56.isStar = false
        panda56.title = "【大熊猫和花】因为经常在沟里蹦跶，所以花花又多了一个绰号叫“水沟公主”"
        panda56.releaseTime = "2021-12-10 12:24:42"
        panda56.originalUrl = "https://www.bilibili.com/video/BV1ZY411s7uC"
        panda56.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda56.authorName = "朙雨"
        panda56.cover =
            "https://i0.hdslb.com/bfs/archive/8412b2a327260f6b19e487c0ac22b053bb49e006.jpg"
        list.add(panda56)


        val panda57 = PetVideo()
        panda57.type = PetType.PANDA.ordinal
        panda57.fileName = "panda_mom_panda57"
        panda57.code = 236
        panda57.duration = 70
        panda57.period = PeriodType.MOM.ordinal
        panda57.isStar = false
        panda57.title = "花花变身小乌龟在木架上划水【大熊猫和花】"
        panda57.releaseTime = "2021-02-11 19:57:36"
        panda57.originalUrl = "https://www.bilibili.com/video/BV1uX4y157BW"
        panda57.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda57.authorName = "迩後咩"
        panda57.cover =
            "https://i2.hdslb.com/bfs/archive/d0fb63c2117efd36b9161a1e0d8e5e66636b9158.jpg"
        list.add(panda57)


        val panda58 = PetVideo()
        panda58.type = PetType.PANDA.ordinal
        panda58.fileName = "panda_mom_panda58"
        panda58.code = 237
        panda58.duration = 80
        panda58.period = PeriodType.MOM.ordinal
        panda58.isStar = true
        panda58.title = "和花花：陈园润和二狗来了，我要把我的木头桩桩捂紧点。【大熊猫】"
        panda58.releaseTime = "2021-09-26 17:39:16"
        panda58.originalUrl = "https://www.bilibili.com/video/BV1vQ4y1k7V5"
        panda58.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda58.authorName = "隽一一"
        panda58.cover =
            "https://i2.hdslb.com/bfs/archive/11bb0c96659c8eec5f6544b2ca010248c4f5f9dd.jpg"
        list.add(panda58)


        val panda59 = PetVideo()
        panda59.type = PetType.PANDA.ordinal
        panda59.fileName = "panda_mom_panda59"
        panda59.code = 238
        panda59.duration = 139
        panda59.period = PeriodType.MOM.ordinal
        panda59.isStar = true
        panda59.title = "【大熊猫润玥和花】花花拿了一根大笋，然后。。。二狗：谢谢妹妹，拿来吧你！"
        panda59.releaseTime = "2021-09-18 13:13:36"
        panda59.originalUrl = "https://www.bilibili.com/video/BV13P4y1h7vV"
        panda59.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda59.authorName = "空调轰轰响"
        panda59.cover =
            "https://i0.hdslb.com/bfs/archive/4a3bc75c12d8df398a014a7e8d1c312e4796e349.jpg"
        list.add(panda59)


        val panda60 = PetVideo()
        panda60.type = PetType.PANDA.ordinal
        panda60.fileName = "panda_mom_panda60"
        panda60.code = 239
        panda60.duration = 144
        panda60.period = PeriodType.MOM.ordinal
        panda60.isStar = false
        panda60.title = "润玥：我可是爬树小能手，这颗树不行就再换一颗"
        panda60.releaseTime = "2021-02-26 16:47:30"
        panda60.originalUrl = "https://www.bilibili.com/video/BV1Ey4y177Bv"
        panda60.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda60.authorName = "迩後咩"
        panda60.cover =
            "https://i1.hdslb.com/bfs/archive/0a16b2d547be849ff72c41ccd4cd9aa2e40099f2.jpg"
        list.add(panda60)


        val panda61 = PetVideo()
        panda61.type = PetType.PANDA.ordinal
        panda61.fileName = "panda_mom_panda61"
        panda61.code = 240
        panda61.duration = 34
        panda61.period = PeriodType.MOM.ordinal
        panda61.isStar = false
        panda61.title = "润玥偷亲奶妈"
        panda61.releaseTime = "2021-04-09 11:23:07"
        panda61.originalUrl = "https://www.bilibili.com/video/BV1iK4y1m7Ef"
        panda61.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda61.authorName = "迩後咩"
        panda61.cover =
            "https://i2.hdslb.com/bfs/archive/892cc090647fcc90aa098dd9d51753e7332f4a67.jpg"
        list.add(panda61)


        val panda62 = PetVideo()
        panda62.type = PetType.PANDA.ordinal
        panda62.fileName = "panda_mom_panda62"
        panda62.code = 241
        panda62.duration = 31
        panda62.period = PeriodType.MOM.ordinal
        panda62.isStar = false
        panda62.title = "墙角文艺花～大熊猫和花"
        panda62.releaseTime = "2021-05-07 15:48:13"
        panda62.originalUrl = "https://www.bilibili.com/video/BV1j84y1c7KS"
        panda62.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda62.authorName = "迩後咩"
        panda62.cover =
            "https://i2.hdslb.com/bfs/archive/b34b82301e55a41e83cf061a0368dedd4a34f06e.jpg"
        list.add(panda62)


        val panda63 = PetVideo()
        panda63.type = PetType.PANDA.ordinal
        panda63.fileName = "panda_mom_panda63"
        panda63.code = 242
        panda63.duration = 63
        panda63.period = PeriodType.MOM.ordinal
        panda63.isStar = false
        panda63.title = "和花擦嘴巴（手机倒过来看有一点点好笑）"
        panda63.releaseTime = "2021-05-16 14:50:29"
        panda63.originalUrl = "https://www.bilibili.com/video/BV1Po4y1m71n"
        panda63.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda63.authorName = "迩後咩"
        panda63.cover =
            "https://i0.hdslb.com/bfs/archive/fc824f1b0124985f6006806bc80352281e9dacbd.jpg"
        list.add(panda63)


        val panda64 = PetVideo()
        panda64.type = PetType.PANDA.ordinal
        panda64.fileName = "panda_mom_panda64"
        panda64.code = 243
        panda64.duration = 16
        panda64.period = PeriodType.MOM.ordinal
        panda64.isStar = true
        panda64.title = "和花：我超凶哒～嗷呜～"
        panda64.releaseTime = "2021-05-18 15:52:52"
        panda64.originalUrl = "https://www.bilibili.com/video/BV1PU4y1L7gv"
        panda64.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda64.authorName = "迩後咩"
        panda64.cover =
            "https://i1.hdslb.com/bfs/archive/bbeac525b0ee9fef2f43de65f0442e0339487e80.jpg"
        list.add(panda64)


        val panda65 = PetVideo()
        panda65.type = PetType.PANDA.ordinal
        panda65.fileName = "panda_mom_panda65"
        panda65.code = 244
        panda65.duration = 52
        panda65.period = PeriodType.MOM.ordinal
        panda65.isStar = false
        panda65.title = "大熊猫园润：润玥，你别挡道，我要去跟我干女儿和花聊天了"
        panda65.releaseTime = "2021-04-19 11:00:14"
        panda65.originalUrl = "https://www.bilibili.com/video/BV13K4y1K7JX"
        panda65.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda65.authorName = "小香妞爱熊猫"
        panda65.cover =
            "https://i1.hdslb.com/bfs/archive/42fdced2e65579edd33b92192020a621fe1ff14b.jpg"
        list.add(panda65)


        val panda66 = PetVideo()
        panda66.type = PetType.PANDA.ordinal
        panda66.fileName = "panda_mom_panda66"
        panda66.code = 245
        panda66.duration = 121
        panda66.period = PeriodType.MOM.ordinal
        panda66.isStar = true
        panda66.title = "【大熊猫园润和花】面对喝奶不积极的花花，润润好无奈啊！"
        panda66.releaseTime = "2021-10-20 19:25:39"
        panda66.originalUrl = "https://www.bilibili.com/video/BV14L4y1B7YE"
        panda66.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda66.authorName = "空调轰轰响"
        panda66.cover =
            "https://i0.hdslb.com/bfs/archive/e3737ce08bb8febdb9ac789266a07427b83a7588.jpg"
        list.add(panda66)


        val panda67 = PetVideo()
        panda67.type = PetType.PANDA.ordinal
        panda67.fileName = "panda_mom_panda67"
        panda67.code = 246
        panda67.duration = 124
        panda67.period = PeriodType.MOM.ordinal
        panda67.isStar = true
        panda67.title = "和花花差点被二狗推下去  花花生气后疯狂输出  润润替花花出气  把二狗推下去了"
        panda67.releaseTime = "2021-11-01 19:23:44"
        panda67.originalUrl = "https://www.bilibili.com/video/BV1av411T7Uk"
        panda67.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda67.authorName = "thebabyfatso"
        panda67.cover =
            "https://i1.hdslb.com/bfs/archive/18a6768e0be918c549bb66df669f5b3086bf572c.jpg"
        list.add(panda67)


        val panda68 = PetVideo()
        panda68.type = PetType.PANDA.ordinal
        panda68.fileName = "panda_mom_panda68"
        panda68.code = 247
        panda68.duration = 107
        panda68.period = PeriodType.MOM.ordinal
        panda68.isStar = false
        panda68.title = "【大熊猫和花】润妈妈又揍二狗了，不敢管了不敢管了"
        panda68.releaseTime = "2021-09-12 21:00:18"
        panda68.originalUrl = "https://www.bilibili.com/video/BV14U4y1P7f4"
        panda68.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda68.authorName = "小香妞爱熊猫"
        panda68.cover =
            "https://i2.hdslb.com/bfs/archive/2038ed0870ba10c06d5dd8a708a991892180a942.jpg"
        list.add(panda68)


        val panda69 = PetVideo()
        panda69.type = PetType.PANDA.ordinal
        panda69.fileName = "panda_mom_panda69"
        panda69.code = 248
        panda69.duration = 111
        panda69.period = PeriodType.MOM.ordinal
        panda69.isStar = false
        panda69.title = "【大熊猫和花】园润错把花花认成二狗了，于是一顿猛操作"
        panda69.releaseTime = "2021-08-30 21:00:04"
        panda69.originalUrl = "https://www.bilibili.com/video/BV1264y1e7Rc"
        panda69.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda69.authorName = "小香妞爱熊猫"
        panda69.cover =
            "https://i0.hdslb.com/bfs/archive/f7934ad04d9a3ced7825a2f17f09ec94caa5f3b0.jpg"
        list.add(panda69)


        val panda70 = PetVideo()
        panda70.type = PetType.PANDA.ordinal
        panda70.fileName = "panda_mom_panda70"
        panda70.code = 249
        panda70.duration = 90
        panda70.period = PeriodType.MOM.ordinal
        panda70.isStar = true
        panda70.title = "【熊猫】陈园润被女儿气得气得败坏了，心里默念：亲生的，亲生的！"
        panda70.releaseTime = "2021-05-27 21:30:06"
        panda70.originalUrl = "https://www.bilibili.com/video/BV1o44y167Hn"
        panda70.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda70.authorName = "小香妞爱熊猫"
        panda70.cover =
            "https://i2.hdslb.com/bfs/archive/84fc43555032f779f5b986dd95ac51fe73e90d32.jpg"
        list.add(panda70)


        val panda71 = PetVideo()
        panda71.type = PetType.PANDA.ordinal
        panda71.fileName = "panda_mom_panda71"
        panda71.code = 250
        panda71.duration = 73
        panda71.period = PeriodType.MOM.ordinal
        panda71.isStar = true
        panda71.title = "园润和花～大团子和小团子～"
        panda71.releaseTime = "2021-06-09 21:17:57"
        panda71.originalUrl = "https://www.bilibili.com/video/BV1Gh411a72v"
        panda71.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda71.authorName = "迩後咩"
        panda71.cover =
            "https://i1.hdslb.com/bfs/archive/d3d979e4bc9c0f08944745be87aba37002846952.jpg"
        list.add(panda71)


        val panda72 = PetVideo()
        panda72.type = PetType.PANDA.ordinal
        panda72.fileName = "panda_mom_panda72"
        panda72.code = 251
        panda72.duration = 12
        panda72.period = PeriodType.MOM.ordinal
        panda72.isStar = false
        panda72.title = "大熊猫和花:想我没？"
        panda72.releaseTime = "2021-06-13 16:25:49"
        panda72.originalUrl = "https://www.bilibili.com/video/BV1oB4y1T7BU"
        panda72.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda72.authorName = "迩後咩"
        panda72.cover =
            "https://i2.hdslb.com/bfs/archive/5bd996d97d4b704bb91429bc86dcb2ab16b6593f.jpg"
        list.add(panda72)


        val panda73 = PetVideo()
        panda73.type = PetType.PANDA.ordinal
        panda73.fileName = "panda_mom_panda73"
        panda73.code = 252
        panda73.duration = 26
        panda73.period = PeriodType.MOM.ordinal
        panda73.isStar = false
        panda73.title = "和花想用jiojio挠痒痒无奈够不到，真是既心疼又好笑"
        panda73.releaseTime = "2021-06-15 17:45:24"
        panda73.originalUrl = "https://www.bilibili.com/video/BV1bw411f7D5"
        panda73.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda73.authorName = "迩後咩"
        panda73.cover =
            "https://i1.hdslb.com/bfs/archive/153846c2c6c1c897e09c07b572f0703545012018.jpg"
        list.add(panda73)


        val panda74 = PetVideo()
        panda74.type = PetType.PANDA.ordinal
        panda74.fileName = "panda_mom_panda74"
        panda74.code = 253
        panda74.duration = 69
        panda74.period = PeriodType.MOM.ordinal
        panda74.isStar = false
        panda74.title = "【大熊猫和花】这也许是最好收的小熊之一了吧！不用抱不用叫自动送上熊头！"
        panda74.releaseTime = "2021-09-07 11:33:06"
        panda74.originalUrl = "https://www.bilibili.com/video/BV1n64y1Y7bV"
        panda74.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda74.authorName = "空调轰轰响"
        panda74.cover =
            "https://i2.hdslb.com/bfs/archive/8df707a835d539cb472c3f6de99c79924cfc018e.jpg"
        list.add(panda74)


        val panda75 = PetVideo()
        panda75.type = PetType.PANDA.ordinal
        panda75.fileName = "panda_mom_panda75"
        panda75.code = 254
        panda75.duration = 78
        panda75.period = PeriodType.MOM.ordinal
        panda75.isStar = true
        panda75.title = "【大熊猫和花】能能祟祟是在干嘛呀！"
        panda75.releaseTime = "2021-06-10 12:59:14"
        panda75.originalUrl = "https://www.bilibili.com/video/BV1F64y1d7Xf"
        panda75.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda75.authorName = "空调轰轰响"
        panda75.cover =
            "https://i1.hdslb.com/bfs/archive/bc4b6f9b59751de2456529400d6e92d7b04bf78c.jpg"
        list.add(panda75)


        val panda76 = PetVideo()
        panda76.type = PetType.PANDA.ordinal
        panda76.fileName = "panda_mom_panda76"
        panda76.code = 255
        panda76.duration = 180
        panda76.period = PeriodType.MOM.ordinal
        panda76.isStar = false
        panda76.title = "【大熊猫和花】fafa终于自己爬上木架了～泪奔～撒花～"
        panda76.releaseTime = "2021-06-24 12:22:50"
        panda76.originalUrl = "https://www.bilibili.com/video/BV1Ty4y1M75r"
        panda76.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda76.authorName = "迩後咩"
        panda76.cover =
            "https://i0.hdslb.com/bfs/archive/a7003f55097f961db2ffc4e1194c73ac61eb6fee.jpg"
        list.add(panda76)


        val panda77 = PetVideo()
        panda77.type = PetType.PANDA.ordinal
        panda77.fileName = "panda_mom_panda77"
        panda77.code = 256
        panda77.duration = 43
        panda77.period = PeriodType.MOM.ordinal
        panda77.isStar = true
        panda77.title = "【大熊猫和花园润】fafa:我也可以木架上喝奶啦"
        panda77.releaseTime = "2021-06-26 11:01:47"
        panda77.originalUrl = "https://www.bilibili.com/video/BV1uo4y1C7g3"
        panda77.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda77.authorName = "迩後咩"
        panda77.cover =
            "https://i1.hdslb.com/bfs/archive/0218e36a4a8de756e8471c37d146d4337fc5a13a.jpg"
        list.add(panda77)


        val panda78 = PetVideo()
        panda78.type = PetType.PANDA.ordinal
        panda78.fileName = "panda_mom_panda78"
        panda78.code = 257
        panda78.duration = 99
        panda78.period = PeriodType.MOM.ordinal
        panda78.isStar = false
        panda78.title = "小花猫出息了还想征战大宝座～大熊猫和花"
        panda78.releaseTime = "2021-06-30 16:25:06"
        panda78.originalUrl = "https://www.bilibili.com/video/BV1YK4y1g78i"
        panda78.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda78.authorName = "迩後咩"
        panda78.cover =
            "https://i1.hdslb.com/bfs/archive/3eec0b980fa11bb65627d0098bec4f1eef815570.jpg"
        list.add(panda78)


        val panda79 = PetVideo()
        panda79.type = PetType.PANDA.ordinal
        panda79.fileName = "panda_mom_panda79"
        panda79.code = 258
        panda79.duration = 122
        panda79.period = PeriodType.MOM.ordinal
        panda79.isStar = false
        panda79.title = "大熊猫园润：女鹅下班了，快下来！润润终于摘娃成功了。"
        panda79.releaseTime = "2021-05-14 20:01:23"
        panda79.originalUrl = "https://www.bilibili.com/video/BV1HQ4y1o7r4"
        panda79.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda79.authorName = "隽一一"
        panda79.cover =
            "https://i2.hdslb.com/bfs/archive/3177f92e3a59797c4f21c62957e8bcf61acd7ee1.jpg"
        list.add(panda79)


        val panda80 = PetVideo()
        panda80.type = PetType.PANDA.ordinal
        panda80.fileName = "panda_mom_panda80"
        panda80.code = 259
        panda80.duration = 92
        panda80.period = PeriodType.MOM.ordinal
        panda80.isStar = true
        panda80.title = "园润终于成功摘下菜二狗，还不赶紧啃几口【园润润玥】"
        panda80.releaseTime = "2021-07-03 15:48:51"
        panda80.originalUrl = "https://www.bilibili.com/video/BV1RL411p72E"
        panda80.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda80.authorName = "迩後咩"
        panda80.cover =
            "https://i1.hdslb.com/bfs/archive/6cae1210b85c6096a58ff3f948bbb4af8aa49067.jpg"
        list.add(panda80)


        val panda81 = PetVideo()
        panda81.type = PetType.PANDA.ordinal
        panda81.fileName = "panda_mom_panda81"
        panda81.code = 260
        panda81.duration = 61
        panda81.period = PeriodType.MOM.ordinal
        panda81.isStar = false
        panda81.title = "fafa：小仙女睡觉觉啦【大熊猫和花】"
        panda81.releaseTime = "2021-07-18 21:29:55"
        panda81.originalUrl = "https://www.bilibili.com/video/BV1Mg411M74U"
        panda81.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda81.authorName = "迩後咩"
        panda81.cover =
            "https://i2.hdslb.com/bfs/archive/c339f215ec5e32a629c81155722675a757d8e78b.jpg"
        list.add(panda81)


        val panda82 = PetVideo()
        panda82.type = PetType.PANDA.ordinal
        panda82.fileName = "panda_mom_panda82"
        panda82.code = 261
        panda82.duration = 88
        panda82.period = PeriodType.MOM.ordinal
        panda82.isStar = false
        panda82.title = "和花：表姐吃啥好吃的，给尝尝嘛～园润：窝头润可不是白叫的～"
        panda82.releaseTime = "2021-07-25 15:21:41"
        panda82.originalUrl = "https://www.bilibili.com/video/BV18y4y1j7F2"
        panda82.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda82.authorName = "迩後咩"
        panda82.cover =
            "https://i2.hdslb.com/bfs/archive/f3dc2567611456a1e8b779629d96acfc7eebd638.jpg"
        list.add(panda82)


        val panda83 = PetVideo()
        panda83.type = PetType.PANDA.ordinal
        panda83.fileName = "panda_mom_panda83"
        panda83.code = 262
        panda83.duration = 86
        panda83.period = PeriodType.MOM.ordinal
        panda83.isStar = false
        panda83.title = "和花：把润玥姐姐推下木架的感觉真爽"
        panda83.releaseTime = "2021-08-18 13:49:39"
        panda83.originalUrl = "https://www.bilibili.com/video/BV16g411j7BX"
        panda83.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda83.authorName = "迩後咩"
        panda83.cover =
            "https://i2.hdslb.com/bfs/archive/6f0c2c4f5f9bfaa156f4f7ced040757c7fa0d1b0.jpg"
        list.add(panda83)


        val panda84 = PetVideo()
        panda84.type = PetType.PANDA.ordinal
        panda84.fileName = "panda_mom_panda84"
        panda84.code = 263
        panda84.duration = 91
        panda84.period = PeriodType.MOM.ordinal
        panda84.isStar = false
        panda84.title = "【大熊猫和花】花儿太倔了，奶爸奶妈轮番上阵劝说，均宣告失败"
        panda84.releaseTime = "2021-03-27 20:00:04"
        panda84.originalUrl = "https://www.bilibili.com/video/BV1YK4y1T7Nx"
        panda84.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda84.authorName = "小香妞爱熊猫"
        panda84.cover =
            "https://i0.hdslb.com/bfs/archive/1ce228bb261617f31dfda19f129b3244bc43ef61.jpg"
        list.add(panda84)


        val panda85 = PetVideo()
        panda85.type = PetType.PANDA.ordinal
        panda85.fileName = "panda_mom_panda85"
        panda85.code = 264
        panda85.duration = 144
        panda85.period = PeriodType.MOM.ordinal
        panda85.isStar = true
        panda85.title = "【大熊猫和花】笋比熊高，fafa太不容易了，手脚并用，最后还是啃了个寂寞"
        panda85.releaseTime = "2021-05-28 22:00:07"
        panda85.originalUrl = "https://www.bilibili.com/video/BV1Db4y1f7nD"
        panda85.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda85.authorName = "小香妞爱熊猫"
        panda85.cover =
            "https://i1.hdslb.com/bfs/archive/e55fb72dfbacd2701f3125a3e1b4b6ca1565a802.jpg"
        list.add(panda85)


        val panda86 = PetVideo()
        panda86.type = PetType.PANDA.ordinal
        panda86.fileName = "panda_mom_panda86"
        panda86.code = 265
        panda86.duration = 124
        panda86.period = PeriodType.MOM.ordinal
        panda86.isStar = false
        panda86.title = "【大熊猫和花】fafa，你怎么可以这么萌？这样很容易被偷走的"
        panda86.releaseTime = "2021-05-03 21:00:19"
        panda86.originalUrl = "https://www.bilibili.com/video/BV1g84y1F776"
        panda86.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda86.authorName = "小香妞爱熊猫"
        panda86.cover =
            "https://i2.hdslb.com/bfs/archive/8bdad0c6bd9bcbda1c02516886572e8f63467f38.jpg"
        list.add(panda86)


        val panda87 = PetVideo()
        panda87.type = PetType.PANDA.ordinal
        panda87.fileName = "panda_mom_panda87"
        panda87.code = 266
        panda87.duration = 61
        panda87.period = PeriodType.MOM.ordinal
        panda87.isStar = false
        panda87.title = "【大熊猫和花】吃草花"
        panda87.releaseTime = "2021-08-24 15:42:26"
        panda87.originalUrl = "https://www.bilibili.com/video/BV1mQ4y1Y7R7"
        panda87.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda87.authorName = "迩後咩"
        panda87.cover =
            "https://i0.hdslb.com/bfs/archive/cf19dd3cd1f2a8f13a8f8b806b375602118711dd.jpg"
        list.add(panda87)


        val panda88 = PetVideo()
        panda88.type = PetType.PANDA.ordinal
        panda88.fileName = "panda_mom_panda88"
        panda88.code = 267
        panda88.duration = 75
        panda88.period = PeriodType.MOM.ordinal
        panda88.isStar = false
        panda88.title = "和花重了，奶妈都抱不动了，只好自己走回去"
        panda88.releaseTime = "2021-09-04 17:05:09"
        panda88.originalUrl = "https://www.bilibili.com/video/BV1v64y1Y78U"
        panda88.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda88.authorName = "迩後咩"
        panda88.cover =
            "https://i1.hdslb.com/bfs/archive/a31797d7c1d5ebdf9de46cad5dbde6db728a5965.jpg"
        list.add(panda88)


        val panda89 = PetVideo()
        panda89.type = PetType.PANDA.ordinal
        panda89.fileName = "panda_mom_panda89"
        panda89.code = 268
        panda89.duration = 63
        panda89.period = PeriodType.MOM.ordinal
        panda89.isStar = true
        panda89.title = "和花：电量不足，小憩一会儿"
        panda89.releaseTime = "2021-09-07 10:38:14"
        panda89.originalUrl = "https://www.bilibili.com/video/BV1Qb4y117EG"
        panda89.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda89.authorName = "迩後咩"
        panda89.cover =
            "https://i1.hdslb.com/bfs/archive/59b9a7fbb2273415d9a2743197c4092eaa2cc5b8.jpg"
        list.add(panda89)


        val panda90 = PetVideo()
        panda90.type = PetType.PANDA.ordinal
        panda90.fileName = "panda_mom_panda90"
        panda90.code = 269
        panda90.duration = 61
        panda90.period = PeriodType.MOM.ordinal
        panda90.isStar = false
        panda90.title = "和花吓奶妈，兔子跳追奶妈"
        panda90.releaseTime = "2021-09-10 16:35:17"
        panda90.originalUrl = "https://www.bilibili.com/video/BV1gv411w79k"
        panda90.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda90.authorName = "迩後咩"
        panda90.cover =
            "https://i0.hdslb.com/bfs/archive/41a3539ef1274d4c26327241c5e228514f28ef0e.jpg"
        list.add(panda90)


        val panda91 = PetVideo()
        panda91.type = PetType.PANDA.ordinal
        panda91.fileName = "panda_mom_panda91"
        panda91.code = 270
        panda91.duration = 70
        panda91.period = PeriodType.MOM.ordinal
        panda91.isStar = false
        panda91.title = "大熊猫和花：听说朵朵rua多了会变大？腿腿蹬多了会变长？"
        panda91.releaseTime = "2021-09-19 17:53:13"
        panda91.originalUrl = "https://www.bilibili.com/video/BV1jP4y1h7Yg"
        panda91.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda91.authorName = "迩後咩"
        panda91.cover =
            "https://i2.hdslb.com/bfs/archive/5d568a91c33ac3fc99df7a8d37ed9d3bd78142a7.jpg"
        list.add(panda91)


        val panda92 = PetVideo()
        panda92.type = PetType.PANDA.ordinal
        panda92.fileName = "panda_mom_panda92"
        panda92.code = 271
        panda92.duration = 72
        panda92.period = PeriodType.MOM.ordinal
        panda92.isStar = true
        panda92.title = "大熊猫和花~自嗨花"
        panda92.releaseTime = "2021-09-28 21:54:26"
        panda92.originalUrl = "https://www.bilibili.com/video/BV16T4y1Z72d"
        panda92.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda92.authorName = "迩後咩"
        panda92.cover =
            "https://i2.hdslb.com/bfs/archive/4e58ae17686636082677d92e30929223cd1a12ce.jpg"
        list.add(panda92)


        val panda93 = PetVideo()
        panda93.type = PetType.PANDA.ordinal
        panda93.fileName = "panda_mom_panda93"
        panda93.code = 272
        panda93.duration = 61
        panda93.period = PeriodType.MOM.ordinal
        panda93.isStar = false
        panda93.title = "大熊猫和花：我还没回呢？门咋又关了，要不加班卖个萌吧"
        panda93.releaseTime = "2021-10-02 13:27:22"
        panda93.originalUrl = "https://www.bilibili.com/video/BV1mf4y1F7LA"
        panda93.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda93.authorName = "迩後咩"
        panda93.cover =
            "https://i1.hdslb.com/bfs/archive/eb2f83a3df4fa85207e42ca397b2a252968116cc.jpg"
        list.add(panda93)


        val panda94 = PetVideo()
        panda94.type = PetType.PANDA.ordinal
        panda94.fileName = "panda_mom_panda94"
        panda94.code = 273
        panda94.duration = 151
        panda94.period = PeriodType.MOM.ordinal
        panda94.isStar = false
        panda94.title = "大熊猫和花：此路不通，我还是原路返回吧~顾涌~顾涌~哎呀脚滑了"
        panda94.releaseTime = "2021-10-10 15:55:55"
        panda94.originalUrl = "https://www.bilibili.com/video/BV1Rr4y127R1"
        panda94.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda94.authorName = "迩後咩"
        panda94.cover =
            "https://i2.hdslb.com/bfs/archive/11bf541fb75b08c786e58ffeb147dce1b012d79c.jpg"
        list.add(panda94)


        val panda95 = PetVideo()
        panda95.type = PetType.PANDA.ordinal
        panda95.fileName = "panda_mom_panda95"
        panda95.code = 274
        panda95.duration = 66
        panda95.period = PeriodType.MOM.ordinal
        panda95.isStar = true
        panda95.title = "园润抱和花【大熊猫】"
        panda95.releaseTime = "2021-11-15 08:12:03"
        panda95.originalUrl = "https://www.bilibili.com/video/BV1j34y1d7tc"
        panda95.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda95.authorName = "迩後咩"
        panda95.cover =
            "https://i0.hdslb.com/bfs/archive/ee92ada2c6dc35f78f95ab56fb3bfaab7474623e.jpg"
        list.add(panda95)


        val panda96 = PetVideo()
        panda96.type = PetType.PANDA.ordinal
        panda96.fileName = "panda_mom_panda96"
        panda96.code = 275
        panda96.duration = 118
        panda96.period = PeriodType.MOM.ordinal
        panda96.isStar = false
        panda96.title = "和花：啃了那么多树枝，竹竿可难不倒我"
        panda96.releaseTime = "2021-11-19 19:52:56"
        panda96.originalUrl = "https://www.bilibili.com/video/BV1VR4y1b7Qt"
        panda96.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda96.authorName = "迩後咩"
        panda96.cover =
            "https://i2.hdslb.com/bfs/archive/9edcb898315475202d4b939a54beffd9d11238b6.jpg"
        list.add(panda96)


        val panda97 = PetVideo()
        panda97.type = PetType.PANDA.ordinal
        panda97.fileName = "panda_mom_panda97"
        panda97.code = 276
        panda97.duration = 50
        panda97.period = PeriodType.MOM.ordinal
        panda97.isStar = true
        panda97.title = "花花热得直喘气，像刚跑完四百米【大熊猫和花】"
        panda97.releaseTime = "2021-04-28 11:12:37"
        panda97.originalUrl = "https://www.bilibili.com/video/BV18p4y1b7ui"
        panda97.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda97.authorName = "迩後咩"
        panda97.cover =
            "https://i2.hdslb.com/bfs/archive/99f09013599b41745b22953eada208faf0d07d88.jpg"
        list.add(panda97)


        val panda98 = PetVideo()
        panda98.type = PetType.PANDA.ordinal
        panda98.fileName = "panda_mom_panda98"
        panda98.code = 277
        panda98.duration = 83
        panda98.period = PeriodType.MOM.ordinal
        panda98.isStar = false
        panda98.title = "和叶老嗨了，怼润玥怼亲姐【大熊猫和花和叶润玥】"
        panda98.releaseTime = "2021-11-23 17:06:26"
        panda98.originalUrl = "https://www.bilibili.com/video/BV1U34y197pd"
        panda98.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda98.authorName = "迩後咩"
        panda98.cover =
            "https://i2.hdslb.com/bfs/archive/7107c175dbb536f107c506d7a2f9555182cf8dbe.jpg"
        list.add(panda98)


        val panda99 = PetVideo()
        panda99.type = PetType.PANDA.ordinal
        panda99.fileName = "panda_mom_panda99"
        panda99.code = 278
        panda99.duration = 17
        panda99.period = PeriodType.MOM.ordinal
        panda99.isStar = false
        panda99.title = "和花一字马倒挂金钩"
        panda99.releaseTime = "2021-12-04 14:31:52"
        panda99.originalUrl = "https://www.bilibili.com/video/BV1cr4y1X792"
        panda99.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda99.authorName = "迩後咩"
        panda99.cover =
            "https://i2.hdslb.com/bfs/archive/60c12a1930e06a8f599fc17a333e8128763ce322.jpg"
        list.add(panda99)


        val panda100 = PetVideo()
        panda100.type = PetType.PANDA.ordinal
        panda100.fileName = "panda_mom_panda100"
        panda100.code = 279
        panda100.duration = 61
        panda100.period = PeriodType.MOM.ordinal
        panda100.isStar = true
        panda100.title = "【园润和花】那时岁月静好，润润幸福地打拍子"
        panda100.releaseTime = "2021-12-11 15:36:07"
        panda100.originalUrl = "https://www.bilibili.com/video/BV1F34y1975G"
        panda100.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda100.authorName = "迩後咩"
        panda100.cover =
            "https://i0.hdslb.com/bfs/archive/f687398b040af3d6f08b5a995920a67bef983bba.jpg"
        list.add(panda100)


        val panda101 = PetVideo()
        panda101.type = PetType.PANDA.ordinal
        panda101.fileName = "panda_mom_panda101"
        panda101.code = 280
        panda101.duration = 68
        panda101.period = PeriodType.MOM.ordinal
        panda101.isStar = false
        panda101.title = "园润误以为和花被卡来救援，花花懵圈三秒后气呼呼"
        panda101.releaseTime = "2021-10-04 20:53:21"
        panda101.originalUrl = "https://www.bilibili.com/video/BV1e44y1t7LX"
        panda101.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda101.authorName = "迩後咩"
        panda101.cover =
            "https://i1.hdslb.com/bfs/archive/fc38164a606ddf2c5362f712f107e19ae7640464.jpg"
        list.add(panda101)


        val panda102 = PetVideo()
        panda102.type = PetType.PANDA.ordinal
        panda102.fileName = "panda_mom_panda102"
        panda102.code = 281
        panda102.duration = 51
        panda102.period = PeriodType.MOM.ordinal
        panda102.isStar = false
        panda102.title = "园润：娃都不回家好无奈，能拖一个是一个～和花：？"
        panda102.releaseTime = "2021-04-12 18:43:09"
        panda102.originalUrl = "https://www.bilibili.com/video/BV1V5411c7sJ"
        panda102.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda102.authorName = "迩後咩"
        panda102.cover =
            "https://i2.hdslb.com/bfs/archive/0fc77fee03221e8040317630df2744f1515c600d.jpg"
        list.add(panda102)


        val panda103 = PetVideo()
        panda103.type = PetType.PANDA.ordinal
        panda103.fileName = "panda_mom_panda103"
        panda103.code = 282
        panda103.duration = 41
        panda103.period = PeriodType.MOM.ordinal
        panda103.isStar = true
        panda103.title = "【大熊猫和花园润】花花玩累了，躺在润润身上"
        panda103.releaseTime = "2021-05-09 13:38:17"
        panda103.originalUrl = "https://www.bilibili.com/video/BV11V411777p"
        panda103.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda103.authorName = "丶祀很宔"
        panda103.cover =
            "https://i1.hdslb.com/bfs/archive/b6763d531d588cbe81cc30f6a6e08523f547eb83.jpg"
        list.add(panda103)


        val panda104 = PetVideo()
        panda104.type = PetType.PANDA.ordinal
        panda104.fileName = "panda_mom_panda104"
        panda104.code = 283
        panda104.duration = 49
        panda104.period = PeriodType.MOM.ordinal
        panda104.isStar = true
        panda104.title = "【大熊猫圆润/和花】无效吃笋VS有效吃笋"
        panda104.releaseTime = "2021-10-02 15:00:09"
        panda104.originalUrl = "https://www.bilibili.com/video/BV1LQ4y167ZW"
        panda104.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda104.authorName = "嗯嗯嗯对嗯"
        panda104.cover =
            "https://i1.hdslb.com/bfs/archive/81c252982d3c7ac304b37cda30bd5936f67562e2.jpg"
        list.add(panda104)


        val panda105 = PetVideo()
        panda105.type = PetType.PANDA.ordinal
        panda105.fileName = "panda_mom_panda105"
        panda105.code = 284
        panda105.duration = 95
        panda105.period = PeriodType.MOM.ordinal
        panda105.isStar = false
        panda105.title = "和花：拜拜我回去啦～骗你的，我又出来啦～"
        panda105.releaseTime = "2021-10-27 14:43:27"
        panda105.originalUrl = "https://www.bilibili.com/video/BV15r4y117oa"
        panda105.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda105.authorName = "迩後咩"
        panda105.cover =
            "https://i1.hdslb.com/bfs/archive/1f8bdc89702f4b0438e8e4b2764e5d42bd07aefc.jpg"
        list.add(panda105)


        val panda106 = PetVideo()
        panda106.type = PetType.PANDA.ordinal
        panda106.fileName = "panda_mom_panda106"
        panda106.code = 285
        panda106.duration = 117
        panda106.period = PeriodType.MOM.ordinal
        panda106.isStar = false
        panda106.title = "【大熊猫和花】看着这个楚楚可怜的孩子，你忍心不接她下班吗？"
        panda106.releaseTime = "2021-10-12 12:57:16"
        panda106.originalUrl = "https://www.bilibili.com/video/BV1FP4y1h7AT"
        panda106.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda106.authorName = "空调轰轰响"
        panda106.cover =
            "https://i2.hdslb.com/bfs/archive/9cddca590af06432daf13db3f2e6a983bffa9b2b.jpg"
        list.add(panda106)


        val panda107 = PetVideo()
        panda107.type = PetType.PANDA.ordinal
        panda107.fileName = "panda_mom_panda107"
        panda107.code = 286
        panda107.duration = 111
        panda107.period = PeriodType.MOM.ordinal
        panda107.isStar = true
        panda107.title = "【大熊猫和花】花花变成桂花糕需要几步呢？"
        panda107.releaseTime = "2021-09-05 12:00:18"
        panda107.originalUrl = "https://www.bilibili.com/video/BV1JU4y1P77r"
        panda107.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda107.authorName = "空调轰轰响"
        panda107.cover =
            "https://i1.hdslb.com/bfs/archive/fa4e1961ceab65bfd4e70b040b14b6586fdacc6b.jpg"
        list.add(panda107)


        val panda108 = PetVideo()
        panda108.type = PetType.PANDA.ordinal
        panda108.fileName = "panda_mom_panda108"
        panda108.code = 287
        panda108.duration = 162
        panda108.period = PeriodType.MOM.ordinal
        panda108.isStar = true
        panda108.title = "【大熊猫和花】一个胖娃娃，筐筐装不下"
        panda108.releaseTime = "2021-10-05 15:23:11"
        panda108.originalUrl = "https://www.bilibili.com/video/BV1L44y1t7mu"
        panda108.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda108.authorName = "朙雨"
        panda108.cover =
            "https://i1.hdslb.com/bfs/archive/f48337d82555b94a2708238d28b87298ff1990af.jpg"
        list.add(panda108)

        val panda109 = PetVideo()
        panda109.type = PetType.PANDA.ordinal
        panda109.fileName = "panda_mom_panda109"
        panda109.code = 288
        panda109.duration = 270
        panda109.period = PeriodType.MOM.ordinal
        panda109.isStar = true
        panda109.title = "【大熊猫润玥&和花】“这个苹果我好像拥有过，又好像不曾拥有”"
        panda109.releaseTime = "2021-10-05 15:23:11"
        panda109.originalUrl = "https://www.bilibili.com/video/BV1gR4y1E77c"
        panda109.tags = "和花,润玥,萌宠,萌萌哒,可爱,动物圈"
        panda109.authorName = "辛辛糖包"
        panda109.cover =
            "https://i2.hdslb.com/bfs/archive/7707f1a4ebcb7d90d32a9cec8dfda33ecbd9e628.jpg"
        list.add(panda109)

        val panda110 = PetVideo()
        panda110.type = PetType.PANDA.ordinal
        panda110.fileName = "panda_mom_panda110"
        panda110.code = 348
        panda110.duration = 28
        panda110.period = PeriodType.MOM.ordinal
        panda110.isStar = true
        panda110.title = "【大熊猫和花】吃手手，晃jio jio的花主任，安逸得很"
        panda110.releaseTime = "2021-11-03 13:58:59"
        panda110.originalUrl = "https://www.bilibili.com/video/BV1Yf4y1u7PQ"
        panda110.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda110.authorName = "胖哒哒不月半"
        panda110.cover =
            "https://i2.hdslb.com/bfs/archive/851834be08b9eb63fcccca13c83d0f07eb904555.jpg"
        list.add(panda110)


        val panda111 = PetVideo()
        panda111.type = PetType.PANDA.ordinal
        panda111.fileName = "panda_mom_panda111"
        panda111.code = 349
        panda111.duration = 54
        panda111.period = PeriodType.MOM.ordinal
        panda111.isStar = true
        panda111.title = "【和花】【园润】爱撩的花花使出洪荒之力也抵不过婴儿润的一直jio"
        panda111.releaseTime = "2021-10-30 20:39:53"
        panda111.originalUrl = "https://www.bilibili.com/video/BV1hQ4y1S75N"
        panda111.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda111.authorName = "胖哒哒不月半"
        panda111.cover =
            "https://i0.hdslb.com/bfs/archive/76a6fd6b5cef8dd7f0f3215b3fdca1b4233832de.jpg"
        list.add(panda111)


        val panda112 = PetVideo()
        panda112.type = PetType.PANDA.ordinal
        panda112.fileName = "panda_mom_panda112"
        panda112.code = 350
        panda112.duration = 75
        panda112.period = PeriodType.MOM.ordinal
        panda112.isStar = true
        panda112.title = "园润：花花这个崽越吸越上头"
        panda112.releaseTime = "2021-10-30 14:18:28"
        panda112.originalUrl = "https://www.bilibili.com/video/BV1mQ4y1q71A"
        panda112.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda112.authorName = "胖哒哒不月半"
        panda112.cover =
            "https://i1.hdslb.com/bfs/archive/ba766ded371b92d41f35c3520b47c8d400dd223b.jpg"
        list.add(panda112)


        val panda113 = PetVideo()
        panda113.type = PetType.PANDA.ordinal
        panda113.fileName = "panda_mom_panda113"
        panda113.code = 351
        panda113.duration = 38
        panda113.period = PeriodType.MOM.ordinal
        panda113.isStar = false
        panda113.title = "上了电视身价过百窝窝头的陈园润抠起脚来都是那么文静"
        panda113.releaseTime = "2021-11-08 11:35:33"
        panda113.originalUrl = "https://www.bilibili.com/video/BV1kb4y187be"
        panda113.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda113.authorName = "胖哒哒不月半"
        panda113.cover =
            "https://i0.hdslb.com/bfs/archive/ce24d18b255816c60581361105918ccd09f14055.jpg"
        list.add(panda113)


        val panda114 = PetVideo()
        panda114.type = PetType.PANDA.ordinal
        panda114.fileName = "panda_mom_panda114"
        panda114.code = 352
        panda114.duration = 25
        panda114.period = PeriodType.MOM.ordinal
        panda114.isStar = false
        panda114.title = "不愿下班的花花一脸蒙圈的被奶爸提溜回家"
        panda114.releaseTime = "2021-11-22 15:00:04"
        panda114.originalUrl = "https://www.bilibili.com/video/BV1Mq4y1g7jo"
        panda114.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda114.authorName = "胖哒哒不月半"
        panda114.cover =
            "https://i0.hdslb.com/bfs/archive/38d9a44225c749f1b28f5a93fe4991ccbfc7552e.jpg"
        list.add(panda114)


        val panda115 = PetVideo()
        panda115.type = PetType.PANDA.ordinal
        panda115.fileName = "panda_mom_panda115"
        panda115.code = 353
        panda115.duration = 35
        panda115.period = PeriodType.MOM.ordinal
        panda115.isStar = true
        panda115.title = "假吃花花遇到夺笋干妈"
        panda115.releaseTime = "2021-11-23 11:50:27"
        panda115.originalUrl = "https://www.bilibili.com/video/BV1Yq4y167ou"
        panda115.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda115.authorName = "胖哒哒不月半"
        panda115.cover =
            "https://i1.hdslb.com/bfs/archive/afc893571785df4c5882714e046a788b2db0418d.jpg"
        list.add(panda115)


        val panda116 = PetVideo()
        panda116.type = PetType.PANDA.ordinal
        panda116.fileName = "panda_mom_panda116"
        panda116.code = 354
        panda116.duration = 101
        panda116.period = PeriodType.MOM.ordinal
        panda116.isStar = true
        panda116.title = "三熊三个心思，润润忘情的抠脚吃笋，爪爪靠着胖花享受地吃笋，花花奋力大喊我不是肉垫"
        panda116.releaseTime = "2021-11-26 14:35:38"
        panda116.originalUrl = "https://www.bilibili.com/video/BV19b4y1q7oe"
        panda116.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda116.authorName = "胖哒哒不月半"
        panda116.cover =
            "https://i0.hdslb.com/bfs/archive/40e0ea6427f6f98ecd2eb2985a7ca939aee76261.jpg"
        list.add(panda116)


        val panda117 = PetVideo()
        panda117.type = PetType.PANDA.ordinal
        panda117.fileName = "panda_mom_panda117"
        panda117.code = 355
        panda117.duration = 35
        panda117.period = PeriodType.MOM.ordinal
        panda117.isStar = true
        panda117.title = "麻麻和妹妹齐上阵给爪爪来了个苏胡的马杀鸡"
        panda117.releaseTime = "2021-12-02 15:23:56"
        panda117.originalUrl = "https://www.bilibili.com/video/BV1WM4y1w7PS"
        panda117.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda117.authorName = "胖哒哒不月半"
        panda117.cover =
            "https://i0.hdslb.com/bfs/archive/ba679498ace19daf917f2556acecc0d903fa0b8c.jpg"
        list.add(panda117)


        val panda118 = PetVideo()
        panda118.type = PetType.PANDA.ordinal
        panda118.fileName = "panda_mom_panda118"
        panda118.code = 356
        panda118.duration = 106
        panda118.period = PeriodType.MOM.ordinal
        panda118.isStar = true
        panda118.title = "【大熊猫园润&和花】陈园润，我已经长大了，你再这样拖我，我生气了"
        panda118.releaseTime = "2021-12-11 20:25:01"
        panda118.originalUrl = "https://www.bilibili.com/video/BV1Ni4y1d76X"
        panda118.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda118.authorName = "辛辛糖包"
        panda118.cover =
            "https://i1.hdslb.com/bfs/archive/190faa750dbc72f3323b131db6142184e5f3d567.jpg"
        list.add(panda118)
        return list
    }

    private fun getMomPanda2(): MutableList<PetVideo> {

        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_mom_panda119"
        panda.code = 41
        panda.duration = 142
        panda.period = PeriodType.MOM.ordinal
        panda.title = "【大熊猫和花】花花不会爬树把表姐气晕倒啦！最后表姐还是蹭蹭花花表示安慰"
        panda.releaseTime = "2021-05-15 13:28:51"
        panda.originalUrl = "https://www.bilibili.com/video/BV1sq4y177zJ?share_source=copy_web"
        panda.tags = "大熊猫,萌宠,萌萌哒,滚滚,熊猫基地,呆萌,熊猫,熊猫宝宝,动物圈"
        panda.authorName = "和花花真好看"
        panda.cover =
            "https://i2.hdslb.com/bfs/archive/c7dc01ce5bef2e59e0ac960fca587984ee3b8554.jpg"
        list.add(panda)


        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_mom_panda120"
        panda2.code = 43
        panda2.duration = 90
        panda2.period = PeriodType.MOM.ordinal
        panda2.title = "【大熊猫和花】10.29 曾经我有一个红苹果，然而…请看到最后！"
        panda2.releaseTime = "2021-10-29 23:00:41"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1tF411e76t?share_source=copy_web"
        panda2.tags = "大熊猫,萌宠,和花,熊猫基地,动物圈"
        panda2.authorName = "安娜丽丝k"
        panda2.cover =
            "https://i2.hdslb.com/bfs/archive/e7696f6e6ed4f0bbe8b343167355542033e6f426.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_mom_panda121"
        panda3.code = 44
        panda3.duration = 15
        panda3.period = PeriodType.MOM.ordinal
        panda3.title = "您订购的一只和花正向您跑来"
        panda3.releaseTime = "2021-09-23 21:33:30"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1j64y187aS?share_source=copy_web"
        panda3.tags = "萌宠,熊猫基地,熊猫宝宝,大熊猫和花,动物圈,大熊猫"
        panda3.authorName = "Miss菜V"
        panda3.cover =
            "https://i0.hdslb.com/bfs/archive/abc67e03f053f799b004682563f38a1c5a0aca72.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_mom_panda122"
        panda4.code = 45
        panda4.duration = 35
        panda4.period = PeriodType.MOM.ordinal
        panda4.title = "花花跑起来有多Q弹【大熊猫和花】"
        panda4.releaseTime = "2021-10-21 12:21:54"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1SF411Y73U?share_source=copy_web"
        panda4.tags = "萌宠,熊猫基地,萌萌哒,可爱,国宝,大熊猫成长记录,大熊猫和花,动物圈,大熊猫"
        panda4.authorName = "朙雨"
        panda4.cover =
            "https://i0.hdslb.com/bfs/archive/417f726303dd2dfe86baaae784c253f16df54411.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_mom_panda123"
        panda5.code = 46
        panda5.duration = 73
        panda5.period = PeriodType.MOM.ordinal
        panda5.title = "放学了，和花花自己回家，坐在门口卖萌"
        panda5.releaseTime = "2021-06-04 21:19:36"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1LK4y137pR?share_source=copy_web"
        panda5.tags = "和花,动物,熊猫,动物圈"
        panda5.authorName = "隽一一"
        panda5.cover =
            "https://i2.hdslb.com/bfs/archive/52e01d32ee0b2b0c4f1dec46126ceb85ec955ac6.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_mom_panda124"
        panda6.code = 47
        panda6.duration = 65
        panda6.period = PeriodType.MOM.ordinal
        panda6.title = "妈妈我不想回家！ 这事儿你个小孩子说了不算！"
        panda6.releaseTime = "2021-08-25 16:00:16"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1fP4y1H7aB?share_source=copy_web"
        panda6.tags = "萌宠,搞笑,滚滚,熊猫基地,熊猫,动物圈"
        panda6.authorName = "pandapia熊猫乌托邦"
        panda6.cover =
            "https://i2.hdslb.com/bfs/archive/0b1f0f13614751744c48bf570a163f8e78a145b3.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_mom_panda125"
        panda7.code = 48
        panda7.duration = 165
        panda7.period = PeriodType.MOM.ordinal
        panda7.title = "【大熊猫和花】跟着园润妈妈学吃笋，花花好乖呀"
        panda7.releaseTime = "2021-06-20 22:00:00"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1Jq4y1L7hp?share_source=copy_web"
        panda7.tags = "搞笑,动物,生活,熊猫,影视,熊猫宝宝,宠物,大熊猫和花,动物圈"
        panda7.authorName = "小香妞爱熊猫"
        panda7.cover =
            "https://i0.hdslb.com/bfs/archive/c34d1d795f6d1630403eedd4f62a7aa9daf09e2a.jpg"
        list.add(panda7)

        val panda8 = PetVideo()
        panda8.type = PetType.PANDA.ordinal
        panda8.fileName = "panda_mom_panda126"
        panda8.code = 49
        panda8.duration = 41
        panda8.period = PeriodType.MOM.ordinal
        panda8.title = "【大熊猫和花】润玥姐姐欺负了fafa，园润妈妈火速赶到，替花花撑腰"
        panda8.releaseTime = "2021-04-27 22:00:07"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1Bi4y1A7fK?share_source=copy_web"
        panda8.tags = "萌宠,动物,日常,熊猫,宠物,动物圈,大熊猫"
        panda8.authorName = "小香妞爱熊猫"
        panda8.cover =
            "https://i2.hdslb.com/bfs/archive/1fc8b950f87a0fbf381790acb0eb400f4f6f2215.jpg"
        list.add(panda8)

        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_mom_panda127"
        panda9.code = 50
        panda9.duration = 119
        panda9.period = PeriodType.MOM.ordinal
        panda9.title = "【大熊猫和花】园润喂花花喝neinei了，有干妈宠着的花花好幸福"
        panda9.releaseTime = "2021-04-14 22:00:14"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1FX4y137NP?share_source=copy_web"
        panda9.tags = "萌宠,搞笑,动物,生活,日常,熊猫,动物圈"
        panda9.authorName = "小香妞爱熊猫"
        panda9.cover =
            "https://i2.hdslb.com/bfs/archive/9a140f865263f27134d2e35f326f1af47e047c54.jpg"
        list.add(panda9)

        val panda10 = PetVideo()
        panda10.type = PetType.PANDA.ordinal
        panda10.fileName = "panda_mom_panda128"
        panda10.code = 51
        panda10.duration = 45
        panda10.period = PeriodType.MOM.ordinal
        panda10.title = "大熊猫和花：陈园润，到点喂我奶了。"
        panda10.releaseTime = "2021-05-02 17:55:42"
        panda10.originalUrl = "https://www.bilibili.com/video/BV1fK4y1o7wG?share_source=copy_web"
        panda10.tags = "萌宠,和花,动物,园润,熊猫"
        panda10.authorName = "隽一一"
        panda10.cover =
            "https://i2.hdslb.com/bfs/archive/bd9e176439ca2aea80326b364feebae2c7986974.jpg"
        list.add(panda10)

        val panda11 = PetVideo()
        panda11.type = PetType.PANDA.ordinal
        panda11.fileName = "panda_mom_panda129"
        panda11.code = 52
        panda11.duration = 33
        panda11.period = PeriodType.MOM.ordinal
        panda11.title = "【大熊猫园润和花】润润：花花来，姐姐给你亲亲抱抱举高高"
        panda11.releaseTime = "2021-05-01 14:01:47"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1u64y1U772?share_source=copy_web"
        panda11.tags = "萌宠,和花,动物,园润,熊猫"
        panda11.authorName = "丶祀很宔"
        panda11.cover =
            "https://i1.hdslb.com/bfs/archive/542ef17d9a74e57d3fe417109836bf6c7bc4d0f4.jpg"
        list.add(panda11)

        val panda12 = PetVideo()
        panda12.type = PetType.PANDA.ordinal
        panda12.fileName = "panda_mom_panda130"
        panda12.code = 53
        panda12.duration = 117
        panda12.period = PeriodType.MOM.ordinal
        panda12.title = "和花花真棒，把园润表姐都哄睡着了，自己还醒着"
        panda12.releaseTime = "2021-05-02 14:58:38"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1UB4y1c7uh?share_source=copy_web"
        panda12.tags = "萌宠,和花,动物,园润,熊猫"
        panda12.authorName = "迩後咩"
        panda12.cover =
            "https://i0.hdslb.com/bfs/archive/60bd76446c93b4f1b0024f83cc5bd90840455a05.jpg"
        list.add(panda12)

        val panda13 = PetVideo()
        panda13.type = PetType.PANDA.ordinal
        panda13.fileName = "panda_mom_panda131"
        panda13.code = 54
        panda13.duration = 9
        panda13.period = PeriodType.MOM.ordinal
        panda13.title = "和花揍园润的屁屁"
        panda13.releaseTime = "2021-05-24 00:39:39"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1wA411V77F?share_source=copy_web"
        panda13.tags = "萌宠,和花,动物,园润,熊猫"
        panda13.authorName = "奇异果家的顺来会fly"
        panda13.cover =
            "https://i2.hdslb.com/bfs/archive/a36ecc39b78657250d0153e883630aa54510a5bb.jpg"
        list.add(panda13)

        val panda14 = PetVideo()
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_mom_panda132"
        panda14.code = 55
        panda14.duration = 12
        panda14.period = PeriodType.MOM.ordinal
        panda14.title = "和花被园润坐了，气得捶了园润一顿"
        panda14.releaseTime = "2021-07-17 10:32:34"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1Tv411n7ZQ?share_source=copy_web"
        panda14.tags = "萌宠,和花,动物,园润,熊猫"
        panda14.authorName = "奇异果家的顺来会fly"
        panda14.cover =
            "https://i0.hdslb.com/bfs/archive/c9c6b48d25a5e0b06455d909ee7fbecbedbd23ce.jpg"
        list.add(panda14)

        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_mom_panda133"
        panda15.code = 56
        panda15.duration = 63
        panda15.period = PeriodType.MOM.ordinal
        panda15.title = "出现了！吃笋皮吐笋肉的新品种大熊猫！"
        panda15.releaseTime = "2021-09-28 20:00:17"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1KQ4y167p1?share_source=copy_web"
        panda15.tags = "萌宠,和花,动物,熊猫"
        panda15.authorName = "iPanda熊猫频道"
        panda15.cover =
            "https://i2.hdslb.com/bfs/archive/1f01bb0c8591e0d0634eefb474993f91a5feb6b0.jpg"
        list.add(panda15)

        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
        panda16.fileName = "panda_mom_panda134"
        panda16.code = 58
        panda16.duration = 179
        panda16.period = PeriodType.MOM.ordinal
        panda16.title = "花花已经能真吃一点笋了，还边吃边做仰卧起坐【大熊猫和花】"
        panda16.releaseTime = "2021-10-27 12:15:00"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1eF411e7Kx?share_source=copy_web"
        panda16.tags = "萌宠,和花,动物,润玥,熊猫"
        panda16.authorName = "朙雨"
        panda16.cover =
            "https://i1.hdslb.com/bfs/archive/0b59e5a1c572025f497767f0b23b3382f04d2a59.jpg"
        list.add(panda16)

        val panda17 = PetVideo()
        panda17.type = PetType.PANDA.ordinal
        panda17.fileName = "panda_mom_panda135"
        panda17.code = 59
        panda17.duration = 142
        panda17.period = PeriodType.MOM.ordinal
        panda17.title = "不好好吃饭的和花，一天被奶爸抱进去三次加餐，喝盆盆奶喝到身上都是，出来还一直回味"
        panda17.releaseTime = "2021-12-07 13:59:30"
        panda17.originalUrl = "https://www.bilibili.com/video/BV1BR4y1s7oo?share_source=copy_web"
        panda17.tags = "萌宠,熊猫基地,熊猫宝宝,大熊猫和花,动物圈"
        panda17.authorName = "Miss菜V"
        panda17.cover =
            "https://i0.hdslb.com/bfs/archive/1298bef5e9542f06e6f22d25a36496e2e375b9b9.jpg"
        list.add(panda17)

        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_mom_panda136"
        panda18.code = 60
        panda18.duration = 119
        panda18.period = PeriodType.MOM.ordinal
        panda18.title = "【大熊猫和花】花花困了又醒了，这状态切换好迅速"
        panda18.releaseTime = "2021-11-28 17:05:14"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1Rq4y167yo?share_source=copy_web"
        panda18.tags = "萌宠,和花,动物,熊猫"
        panda18.authorName = "朙雨"
        panda18.cover =
            "https://i1.hdslb.com/bfs/archive/8382d448a2b4351ec6dec9bf5c97a99bf77f2fe9.jpg"
        list.add(panda18)

        val panda19 = PetVideo()
        panda19.type = PetType.PANDA.ordinal
        panda19.fileName = "panda_mom_panda137"
        panda19.code = 61
        panda19.duration = 32
        panda19.period = PeriodType.MOM.ordinal
        panda19.title = "萌兽觉醒，小西叽fafa肥来啦【大熊猫和花】"
        panda19.releaseTime = "2021-10-17 14:01:20"
        panda19.originalUrl = "https://www.bilibili.com/video/BV16r4y1y7Rs?share_source=copy_web"
        panda19.tags = "萌宠,和花,动物,熊猫"
        panda19.authorName = "朙雨"
        panda19.cover =
            "https://i2.hdslb.com/bfs/archive/d09695dcab5609a6355b08b5b24bf83839068ecd.jpg"
        list.add(panda19)

        val panda20 = PetVideo()
        panda20.type = PetType.PANDA.ordinal
        panda20.fileName = "panda_mom_panda138"
        panda20.code = 62
        panda20.duration = 43
        panda20.period = PeriodType.MOM.ordinal
        panda20.title = "和花:最搞笑萌的吃播，吃着吃着睡着了"
        panda20.releaseTime = "2021-09-29 19:00:17"
        panda20.originalUrl = "https://www.bilibili.com/video/BV15q4y1Z7Cg?share_source=copy_web"
        panda20.tags = "萌宠,和花,动物,熊猫"
        panda20.authorName = "熊猫幼崽社区"
        panda20.cover =
            "https://i0.hdslb.com/bfs/archive/3c0cfb73b223e74890b878c1a5c2e2792a207dd2.jpg"
        list.add(panda20)

        val panda21 = PetVideo()
        panda21.type = PetType.PANDA.ordinal
        panda21.fileName = "panda_mom_panda139"
        panda21.code = 63
        panda21.duration = 71
        panda21.period = PeriodType.MOM.ordinal
        panda21.title = "收煤气罐罐啦，花花每次被抱走乖的像假熊"
        panda21.releaseTime = "2021-11-11 19:15:12"
        panda21.originalUrl = "https://www.bilibili.com/video/BV1pg411K7aN?share_source=copy_web"
        panda21.tags = "萌宠,和花,动物,熊猫"
        panda21.authorName = "爱熊猫aipanda"
        panda21.cover =
            "https://i0.hdslb.com/bfs/archive/1b11a617d55019723006ea8af5c1d96a99dd565f.jpg"
        list.add(panda21)

        val panda22 = PetVideo()
        panda22.type = PetType.PANDA.ordinal
        panda22.fileName = "panda_mom_panda140"
        panda22.code = 64
        panda22.duration = 39
        panda22.period = PeriodType.GROUP.ordinal
        panda22.title = "同样是熊猫，这俩长相区别好大【大熊猫和花&艾玖】"
        panda22.releaseTime = "2021-12-11 13:15:16"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1eh411x7FD?share_source=copy_web"
        panda22.tags = "萌宠,和花,动物,熊猫"
        panda22.authorName = "朙雨"
        panda22.cover =
            "https://i0.hdslb.com/bfs/archive/bbb4f4cba676bd065a0e34c3ac45451d62462308.jpg"
        list.add(panda22)

        val panda23 = PetVideo()
        panda23.type = PetType.PANDA.ordinal
        panda23.fileName = "panda_mom_panda141"
        panda23.code = 65
        panda23.duration = 58
        panda23.period = PeriodType.MOM.ordinal
        panda23.title = "【大熊猫 】润玥悔不该得罪那和花呀 惨遭撕咬。。。"
        panda23.releaseTime = "2022-01-02 19:08:57"
        panda23.originalUrl = "https://www.bilibili.com/video/BV13Z4y1Q7Vc?share_source=copy_web"
        panda23.tags = "萌宠,和花,动物,熊猫"
        panda23.authorName = "动物米"
        panda23.cover =
            "https://i2.hdslb.com/bfs/archive/9d95310217ea81c31896fc51d2fb947369d9cda9.jpg"
        list.add(panda23)

        val panda24 = PetVideo()
        panda24.type = PetType.PANDA.ordinal
        panda24.fileName = "panda_mom_panda142"
        panda24.code = 66
        panda24.duration = 30
        panda24.period = PeriodType.MOM.ordinal
        panda24.title = "长得这么好看，合理吗？"
        panda24.releaseTime = "2021-05-08 18:15:08"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1t64y127Hi?share_source=copy_web"
        panda24.tags = "萌宠,和花,动物,熊猫"
        panda24.authorName = "iPanda熊猫频道"
        panda24.cover =
            "https://i1.hdslb.com/bfs/archive/be6a5f103dd9da506739c7b878412d0c7fa01142.jpg"
        list.add(panda24)

        val panda25 = PetVideo()
        panda25.type = PetType.PANDA.ordinal
        panda25.fileName = "panda_mom_panda143"
        panda25.code = 67
        panda25.duration = 48
        panda25.period = PeriodType.MOM.ordinal
        panda25.title = "睡得迷糊的和花被抱去喝neinei，没喝够嗯嗯叫表示抗议"
        panda25.releaseTime = "2022-01-01 20:48:05"
        panda25.originalUrl = "https://www.bilibili.com/video/BV1WL411L7T6?share_source=copy_web"
        panda25.tags = "萌宠,和花,动物,熊猫"
        panda25.authorName = "胖哒哒不月半"
        panda25.cover =
            "https://i1.hdslb.com/bfs/archive/43e3a383e0fc799627fcf617dfaaca1b2d3a2965.jpg"
        list.add(panda25)
        return list
    }

    private fun getMomPanda3(): MutableList<PetVideo> {
        val panda = PetVideo()
        panda.type = PetType.PANDA.ordinal
        panda.fileName = "panda_mom_panda144"
        panda.code = 33
        panda.duration = 17
        panda.period = PeriodType.MOM.ordinal
        panda.title = "【和花与和叶】和叶：姐姐，亲亲"
        panda.releaseTime = "2021-12-27 20:14:57"
        panda.originalUrl = "https://www.bilibili.com/video/BV1N34y1z7Xd?share_source=copy_web"
        panda.tags = "大熊猫,动物圈,宠物,大熊猫和花,大熊猫和叶"
        panda.authorName = "Pandaful熊猫社区"
        panda.cover =
            "https://i0.hdslb.com/bfs/archive/6ed0425fb3a503d8fa63b3cafc096e6be1ade880.jpg"
        list.add(panda)

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_mom_panda145"
        panda1.code = 34
        panda1.duration = 114
        panda1.period = PeriodType.MOM.ordinal
        panda1.title = "【大熊猫和花和叶】姐弟俩的吃播～感觉有点生疏了，坐这么远"
        panda1.releaseTime = "2021-09-10 12:28:12"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1pb4y127fV?share_source=copy_web"
        panda1.tags = "和花,和叶,呆萌,滚滚,国宝,熊猫基地,熊猫宝宝,动物圈,大熊猫"
        panda1.authorName = "空调轰轰响"
        panda1.cover =
            "https://i2.hdslb.com/bfs/archive/8c8b14a9f6ad5e7401a8e3e5900fb5f071a6a581.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_mom_panda146"
        panda2.code = 35
        panda2.duration = 109
        panda2.period = PeriodType.MOM.ordinal
        panda2.title = "我的霸道姐姐。【大熊猫和花、和叶】"
        panda2.releaseTime = "2021-11-11 18:48:51"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1Sb4y187nF?share_source=copy_web"
        panda2.tags = "和花,和叶,萌宠,萌萌哒,可爱,熊猫,动物圈,大熊猫"
        panda2.authorName = "隽一一"
        panda2.cover =
            "https://i2.hdslb.com/bfs/archive/09d78221fcdbbe73fc4cbef675818283ef53665b.jpg"
        list.add(panda2)

        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_mom_panda147"
        panda3.code = 36
        panda3.duration = 114
        panda3.period = PeriodType.MOM.ordinal
        panda3.title = "【大熊猫和花和叶】生活不易，叶子叹气：自己的姐姐只有宠着"
        panda3.releaseTime = "2021-09-29 12:22:33"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1Nv411G7im?share_source=copy_web"
        panda3.tags = "和花,和叶,大熊猫,萌宠,国宝,滚滚,呆萌,熊猫基地,熊猫宝宝,动物圈"
        panda3.authorName = "空调轰轰响"
        panda3.cover =
            "https://i1.hdslb.com/bfs/archive/7f544245e97b756e5782d5f2f4bc945ef279acbc.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_mom_panda148"
        panda4.code = 37
        panda4.duration = 58
        panda4.period = PeriodType.MOM.ordinal
        panda4.title = "【大熊猫和花和叶】断奶后第一次亮相，弟弟怎么也逃不出花花的世界，哈哈哈"
        panda4.releaseTime = "2021-11-21 23:00:19"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1fq4y16786?share_source=copy_web"
        panda4.tags = "和花,和叶,萌宠,搞笑,动物,熊猫,动物圈"
        panda4.authorName = "小香妞爱熊猫"
        panda4.cover =
            "https://i2.hdslb.com/bfs/archive/8adfa70f9c1fe4ec5930134d3f962fd12257136d.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_mom_panda149"
        panda5.code = 38
        panda5.duration = 52
        panda5.period = PeriodType.MOM.ordinal
        panda5.title = "【大熊猫和花和叶】贴贴我的臭弟弟，抱着臭弟弟一起睡觉觉"
        panda5.releaseTime = "2021-11-22 23:00:18"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1fq4y1u7CG?share_source=copy_web"
        panda5.tags = "和花,和叶,萌宠,搞笑,动物,熊猫,动物圈"
        panda5.authorName = "小香妞爱熊猫"
        panda5.cover =
            "https://i1.hdslb.com/bfs/archive/e08d9c693fbe9e69de24c70bb01a71ac766f6692.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_mom_panda150"
        panda6.code = 39
        panda6.duration = 59
        panda6.period = PeriodType.MOM.ordinal
        panda6.title = "和花：弟弟，靠靠。和叶：姐姐，抱抱。【大熊猫】"
        panda6.releaseTime = "2021-12-02 19:09:12"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1dR4y1475R?share_source=copy_web"
        panda6.tags = "和花,和叶,萌萌哒,动物圈,大熊猫"
        panda6.authorName = "隽一一"
        panda6.cover =
            "https://i0.hdslb.com/bfs/archive/adb2c3c91ee6f80660c78ccc3529b9af9ecdcabd.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_mom_panda151"
        panda7.code = 40
        panda7.duration = 145
        panda7.period = PeriodType.MOM.ordinal
        panda7.title = "我姐姐叫和花，我爱她，而且你知道吗?她也爱我！（永远爱我）【大熊猫和花】【大熊猫和叶】"
        panda7.releaseTime = "2021-12-16 19:38:53"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1XL4y1J7bp?share_source=copy_web"
        panda7.tags = "大熊猫,和花,和叶,,动物圈"
        panda7.authorName = "安娜丽丝k"
        panda7.cover =
            "https://i1.hdslb.com/bfs/archive/93795a5755980e5948a137500cf537f31f9b6f6c.png"
        list.add(panda7)


        val panda8 = PetVideo()
        panda8.type = PetType.PANDA.ordinal
        panda8.fileName = "panda_mom_panda152"
        panda8.code = 387
        panda8.duration = 103
        panda8.period = PeriodType.MOM.ordinal
        panda8.isStar = false
        panda8.title = "【莽星星莽辰辰】不知道在哪里学的格斗招数，都用在妈妈身上了"
        panda8.releaseTime = "2022-01-01 20:03:11"
        panda8.originalUrl = "https://www.bilibili.com/video/BV1dq4y117te"
        panda8.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda8.authorName = "猴哥某熊铁锤都退役了"
        panda8.cover =
            "https://i0.hdslb.com/bfs/archive/b174c26fd967d2d0b85cc646266ceb2c424511c5.jpg"
        list.add(panda8)


        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_mom_panda153"
        panda9.code = 388
        panda9.duration = 93
        panda9.period = PeriodType.MOM.ordinal
        panda9.isStar = false
        panda9.title = "熊猫母子泡澡，一大一小太有爱啦！"
        panda9.releaseTime = "2019-04-18 11:08:34"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1Qb411577y"
        panda9.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda9.authorName = "pandapia熊猫乌托邦"
        panda9.cover =
            "https://i2.hdslb.com/bfs/archive/73385e430779a58e97f81a1691ebb8f99c11bda7.jpg"
        list.add(panda9)


        val panda10 = PetVideo()
        panda10.type = PetType.PANDA.ordinal
        panda10.fileName = "panda_mom_panda154"
        panda10.code = 389
        panda10.duration = 162
        panda10.period = PeriodType.MOM.ordinal
        panda10.isStar = false
        panda10.title = "金双：嘤嘤嘤要喝neinei~而淼淼想吃笋~几个回合后，金喜也来闹奶，淼淼只好妥协"
        panda10.releaseTime = "2021-11-03 17:20:00"
        panda10.originalUrl = "https://www.bilibili.com/video/BV113411k7SL"
        panda10.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda10.authorName = "迩後咩"
        panda10.cover =
            "https://i2.hdslb.com/bfs/archive/64c457748d954b8c7de5970684cd38409b44324e.jpg"
        list.add(panda10)


        val panda11 = PetVideo()
        panda11.type = PetType.PANDA.ordinal
        panda11.fileName = "panda_mom_panda155"
        panda11.code = 390
        panda11.duration = 42
        panda11.period = PeriodType.MOM.ordinal
        panda11.isStar = false
        panda11.title = "淼淼:小屁孩就是要多收拾，才不会乱说～金双:麻麻最美了（被迫的）～"
        panda11.releaseTime = "2021-05-10 14:03:04"
        panda11.originalUrl = "https://www.bilibili.com/video/BV1Jy4y1W7H4"
        panda11.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda11.authorName = "迩後咩"
        panda11.cover =
            "https://i2.hdslb.com/bfs/archive/f69bbf67cd27d5d3640587e2f7261bae8c0695d2.jpg"
        list.add(panda11)


        val panda12 = PetVideo()
        panda12.type = PetType.PANDA.ordinal
        panda12.fileName = "panda_mom_panda156"
        panda12.code = 391
        panda12.duration = 135
        panda12.period = PeriodType.MOM.ordinal
        panda12.isStar = false
        panda12.title = "淼淼胖揍金喜"
        panda12.releaseTime = "2021-12-01 14:27:12"
        panda12.originalUrl = "https://www.bilibili.com/video/BV1yS4y1X7Q2"
        panda12.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda12.authorName = "胖达雅雅乌"
        panda12.cover =
            "https://i1.hdslb.com/bfs/archive/21387e9eecf21a3619189ab6a95159165b509707.jpg"
        list.add(panda12)


        val panda13 = PetVideo()
        panda13.type = PetType.PANDA.ordinal
        panda13.fileName = "panda_mom_panda157"
        panda13.code = 392
        panda13.duration = 70
        panda13.period = PeriodType.MOM.ordinal
        panda13.isStar = false
        panda13.title = "【大熊猫园润淼淼】20171208向淼淼撒娇的润姐姐"
        panda13.releaseTime = "2018-01-05 12:21:13"
        panda13.originalUrl = "https://www.bilibili.com/video/BV1sW411B7Cm"
        panda13.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda13.authorName = "ningning胖饼饼"
        panda13.cover =
            "https://i0.hdslb.com/bfs/archive/6db3a02c3fa5cc307c66365e91c19c5d268734e9.jpg"
        list.add(panda13)


        val panda14 = PetVideo()
        panda14.type = PetType.PANDA.ordinal
        panda14.fileName = "panda_mom_panda158"
        panda14.code = 393
        panda14.duration = 47
        panda14.period = PeriodType.MOM.ordinal
        panda14.isStar = false
        panda14.title = "上木架脚滑，必须揍个娃缓解一下尴尬。【大熊猫淼淼、金喜】"
        panda14.releaseTime = "2021-11-27 10:07:43"
        panda14.originalUrl = "https://www.bilibili.com/video/BV1fF411b7Ld"
        panda14.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda14.authorName = "隽一一"
        panda14.cover =
            "https://i0.hdslb.com/bfs/archive/9e90051c04ccb64ba31aa62887e7df95fc6a24ad.jpg"
        list.add(panda14)


        val panda15 = PetVideo()
        panda15.type = PetType.PANDA.ordinal
        panda15.fileName = "panda_mom_panda159"
        panda15.code = 394
        panda15.duration = 26
        panda15.period = PeriodType.MOM.ordinal
        panda15.isStar = false
        panda15.title = "游客：“这小熊猫成长轨迹还是有阴影的”。～淼淼使出拳击揍儿子。【大熊猫淼淼、金喜】"
        panda15.releaseTime = "2021-11-07 20:15:55"
        panda15.originalUrl = "https://www.bilibili.com/video/BV1or4y1C775"
        panda15.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda15.authorName = "隽一一"
        panda15.cover =
            "https://i2.hdslb.com/bfs/archive/332e091e8e9c922da407c39fa24a2b0cc5f467b8.jpg"
        list.add(panda15)


        val panda16 = PetVideo()
        panda16.type = PetType.PANDA.ordinal
        panda16.fileName = "panda_mom_panda160"
        panda16.code = 395
        panda16.duration = 127
        panda16.period = PeriodType.MOM.ordinal
        panda16.isStar = false
        panda16.title = "【大熊猫淼淼&金双&金喜】想拍个母慈子孝，然而，淼淼你为啥画风突变……"
        panda16.releaseTime = "2021-11-08 18:11:06"
        panda16.originalUrl = "https://www.bilibili.com/video/BV1JL4y1v7fj"
        panda16.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda16.authorName = "辛辛糖包"
        panda16.cover =
            "https://i0.hdslb.com/bfs/archive/fb46158766974b380f562e019888f92d445b7fce.jpg"
        list.add(panda16)


        val panda17 = PetVideo()
        panda17.type = PetType.PANDA.ordinal
        panda17.fileName = "panda_mom_panda161"
        panda17.code = 396
        panda17.duration = 60
        panda17.period = PeriodType.MOM.ordinal
        panda17.isStar = false
        panda17.title = "金喜给了淼淼一小木头，淼淼气的站起来。金喜曰：就你会站吗？我也会【大熊猫金喜】【大熊猫淼淼】"
        panda17.releaseTime = "2021-10-31 14:57:17"
        panda17.originalUrl = "https://www.bilibili.com/video/BV15L4y1q7UL"
        panda17.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda17.authorName = "熊猫记录册"
        panda17.cover =
            "https://i2.hdslb.com/bfs/archive/3c50e091c08e9ca9f978d4c730503b6c9e525e59.jpg"
        list.add(panda17)


        val panda18 = PetVideo()
        panda18.type = PetType.PANDA.ordinal
        panda18.fileName = "panda_mom_panda162"
        panda18.code = 397
        panda18.duration = 248
        panda18.period = PeriodType.MOM.ordinal
        panda18.isStar = false
        panda18.title = "啾啾大战淼淼！被推落后气到站起（大熊猫润九 淼淼）20190831"
        panda18.releaseTime = "2019-09-02 18:30:15"
        panda18.originalUrl = "https://www.bilibili.com/video/BV1E441117vt"
        panda18.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda18.authorName = "日常嗑猫C咩酱"
        panda18.cover =
            "https://i0.hdslb.com/bfs/archive/f7ff8d31a42bf114ec809d3fbd88e2cec0e643f4.jpg"
        list.add(panda18)


        val panda19 = PetVideo()
        panda19.type = PetType.PANDA.ordinal
        panda19.fileName = "panda_mom_panda163"
        panda19.code = 398
        panda19.duration = 182
        panda19.period = PeriodType.MOM.ordinal
        panda19.isStar = false
        panda19.title = "润九：被妈从树上摔五次是怎样一种体验"
        panda19.releaseTime = "2019-02-03 12:37:19"
        panda19.originalUrl = "https://www.bilibili.com/video/BV1db411674e"
        panda19.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda19.authorName = "羽川゚"
        panda19.cover =
            "https://i1.hdslb.com/bfs/archive/0c7e6bd4138c68f4d2b5f178fd83cd43199fdebc.jpg"
        list.add(panda19)


        val panda20 = PetVideo()
        panda20.type = PetType.PANDA.ordinal
        panda20.fileName = "panda_mom_panda164"
        panda20.code = 399
        panda20.duration = 118
        panda20.period = PeriodType.MOM.ordinal
        panda20.isStar = false
        panda20.title = "大方的花主任，请姐姐们吃自助苹果。【大熊猫和花、润玥、艾玖】"
        panda20.releaseTime = "2021-12-11 13:46:36"
        panda20.originalUrl = "https://www.bilibili.com/video/BV173411t7hG"
        panda20.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda20.authorName = "隽一一"
        panda20.cover =
            "https://i2.hdslb.com/bfs/archive/e3f667f837b09d9046f24eb96b0a7223ac63b624.jpg"
        list.add(panda20)


        val panda21 = PetVideo()
        panda21.type = PetType.PANDA.ordinal
        panda21.fileName = "panda_mom_panda165"
        panda21.code = 400
        panda21.duration = 75
        panda21.period = PeriodType.MOM.ordinal
        panda21.isStar = false
        panda21.title = "熊猫的手是什么味道，舔得那么忘情"
        panda21.releaseTime = "2021-12-08 12:53:39"
        panda21.originalUrl = "https://www.bilibili.com/video/BV1mU4y1N7Ps"
        panda21.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda21.authorName = "胖哒哒不月半"
        panda21.cover =
            "https://i0.hdslb.com/bfs/archive/0bb8905d404cfe6600e4150a328f2d3c77e717fe.jpg"
        list.add(panda21)


        val panda22 = PetVideo()
        panda22.type = PetType.PANDA.ordinal
        panda22.fileName = "panda_mom_panda166"
        panda22.code = 401
        panda22.duration = 55
        panda22.period = PeriodType.MOM.ordinal
        panda22.isStar = false
        panda22.title = "不好好吃饭的小和花要被打屁屁了"
        panda22.releaseTime = "2021-12-30 22:12:40"
        panda22.originalUrl = "https://www.bilibili.com/video/BV1hZ4y1D7kf"
        panda22.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda22.authorName = "胖哒哒不月半"
        panda22.cover =
            "https://i0.hdslb.com/bfs/archive/f650dadbd1a3ba418e87b1f4906ddd2d073d7200.jpg"
        list.add(panda22)


        val panda23 = PetVideo()
        panda23.type = PetType.PANDA.ordinal
        panda23.fileName = "panda_mom_panda167"
        panda23.code = 402
        panda23.duration = 13
        panda23.period = PeriodType.MOM.ordinal
        panda23.isStar = false
        panda23.title = "熊猫妈妈一拖二，被熊孩子烦死了（小白兔与双胞胎兔哥兔妹）"
        panda23.releaseTime = "2021-12-25 22:30:04"
        panda23.originalUrl = "https://www.bilibili.com/video/BV1PS4y1M75j"
        panda23.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda23.authorName = "黑白宝宝小捣蛋"
        panda23.cover =
            "https://i2.hdslb.com/bfs/archive/28725191235aaa9ca86dbc35fc257b7c1ab1b2f0.jpg"
        list.add(panda23)


        val panda24 = PetVideo()
        panda24.type = PetType.PANDA.ordinal
        panda24.fileName = "panda_mom_panda168"
        panda24.code = 403
        panda24.duration = 35
        panda24.period = PeriodType.MOM.ordinal
        panda24.isStar = false
        panda24.title = "饭团和花的一天，摸摸头抱回家"
        panda24.releaseTime = "2021-06-10 18:55:44"
        panda24.originalUrl = "https://www.bilibili.com/video/BV1HB4y1M7ST"
        panda24.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda24.authorName = "开饭了大熊猫V"
        panda24.cover =
            "https://i2.hdslb.com/bfs/archive/72c799f21cb5671d83b80bcc84960a8573d5a0f0.jpg"
        list.add(panda24)


        val panda25 = PetVideo()
        panda25.type = PetType.PANDA.ordinal
        panda25.fileName = "panda_mom_panda169"
        panda25.code = 404
        panda25.duration = 59
        panda25.period = PeriodType.MOM.ordinal
        panda25.isStar = false
        panda25.title = "花花：谁在说我胖嘟嘟，我只是毛毛蓬"
        panda25.releaseTime = "2021-12-24 12:02:09"
        panda25.originalUrl = "https://www.bilibili.com/video/BV113411x7FA"
        panda25.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda25.authorName = "丶祀很宔"
        panda25.cover =
            "https://i0.hdslb.com/bfs/archive/8c1a7c3ca3838dded4355aa774e415659960228a.jpg"
        list.add(panda25)


        val panda26 = PetVideo()
        panda26.type = PetType.PANDA.ordinal
        panda26.fileName = "panda_mom_panda170"
        panda26.code = 405
        panda26.duration = 144
        panda26.period = PeriodType.MOM.ordinal
        panda26.isStar = false
        panda26.title = "【大熊猫圆润和淼淼】园小润把娇淼淼拉进沟沟，饭点到了催着吃饭，果然是好闺蜜"
        panda26.releaseTime = "2020-01-02 13:31:16"
        panda26.originalUrl = "https://www.bilibili.com/video/BV1jJ411876r"
        panda26.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda26.authorName = "黑白萌团子"
        panda26.cover =
            "https://i0.hdslb.com/bfs/archive/c085902feabf79f22ddc52495c492c4cb928dcb0.jpg"
        list.add(panda26)


        val panda27 = PetVideo()
        panda27.type = PetType.PANDA.ordinal
        panda27.fileName = "panda_mom_panda171"
        panda27.code = 406
        panda27.duration = 104
        panda27.period = PeriodType.MOM.ordinal
        panda27.isStar = false
        panda27.title = "【大熊猫莽仔】开始争宠了，争宠了！"
        panda27.releaseTime = "2021-11-27 18:59:22"
        panda27.originalUrl = "https://www.bilibili.com/video/BV1pi4y1o7xu"
        panda27.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda27.authorName = "猴哥某熊铁锤都退役了"
        panda27.cover =
            "https://i2.hdslb.com/bfs/archive/39dc05138e262bab0d00990ec89f891d30e058e0.jpg"
        list.add(panda27)


        val panda28 = PetVideo()
        panda28.type = PetType.PANDA.ordinal
        panda28.fileName = "panda_mom_panda172"
        panda28.code = 407
        panda28.duration = 82
        panda28.period = PeriodType.MOM.ordinal
        panda28.isStar = false
        panda28.title = "和花花惹毛了艾玖姐姐，姐姐“温柔”地进行了惩罚"
        panda28.releaseTime = "2021-12-12 21:30:16"
        panda28.originalUrl = "https://www.bilibili.com/video/BV1hU4y1K7Sj"
        panda28.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda28.authorName = "Miss菜V"
        panda28.cover =
            "https://i1.hdslb.com/bfs/archive/a371d785ed447ee921c1b37448a148d247256daa.jpg"
        list.add(panda28)


        val panda29 = PetVideo()
        panda29.type = PetType.PANDA.ordinal
        panda29.fileName = "panda_mom_panda173"
        panda29.code = 408
        panda29.duration = 67
        panda29.period = PeriodType.MOM.ordinal
        panda29.isStar = false
        panda29.title = "二狗和妈妈园润"
        panda29.releaseTime = "2022-01-08 11:10:52"
        panda29.originalUrl = "https://www.bilibili.com/video/BV1D44y1j7mC"
        panda29.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda29.authorName = "奇异果家的顺来会fly"
        panda29.cover =
            "https://i0.hdslb.com/bfs/archive/9438acce76a2d41f8eb964d2107343a052dd071e.jpg"
        list.add(panda29)


        val panda30 = PetVideo()
        panda30.type = PetType.PANDA.ordinal
        panda30.fileName = "panda_mom_panda174"
        panda30.code = 409
        panda30.duration = 95
        panda30.period = PeriodType.MOM.ordinal
        panda30.isStar = false
        panda30.title = "爪爪：陈园润你可真是我亲妈（二狗rua花花，被润润胖揍）"
        panda30.releaseTime = "2021-12-14 11:03:47"
        panda30.originalUrl = "https://www.bilibili.com/video/BV1Ji4y1d7yw"
        panda30.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda30.authorName = "丶祀很宔"
        panda30.cover =
            "https://i2.hdslb.com/bfs/archive/e1a7b741a7655c34383badd5ed9331accab8426c.jpg"
        list.add(panda30)


        val panda31 = PetVideo()
        panda31.type = PetType.PANDA.ordinal
        panda31.fileName = "panda_mom_panda175"
        panda31.code = 410
        panda31.duration = 134
        panda31.period = PeriodType.MOM.ordinal
        panda31.isStar = false
        panda31.title = "【大熊猫莽仔】小崽在挨打的边缘，一直挑衅妈妈"
        panda31.releaseTime = "2021-11-28 19:36:21"
        panda31.originalUrl = "https://www.bilibili.com/video/BV1fq4y1B7SG"
        panda31.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda31.authorName = "猴哥某熊铁锤都退役了"
        panda31.cover =
            "https://i0.hdslb.com/bfs/archive/f2d5df2faac16aa7b2b4d2c05502d40220ffdc86.jpg"
        list.add(panda31)


        val panda32 = PetVideo()
        panda32.type = PetType.PANDA.ordinal
        panda32.fileName = "panda_mom_panda176"
        panda32.code = 411
        panda32.duration = 213
        panda32.period = PeriodType.MOM.ordinal
        panda32.isStar = false
        panda32.title = "【大熊猫和花】吃饱了吗？嗝嗝嗝，剔剔牙，顺便卖卖萌~"
        panda32.releaseTime = "2022-01-02 12:08:12"
        panda32.originalUrl = "https://www.bilibili.com/video/BV13Z4y1Q75M"
        panda32.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda32.authorName = "辛辛糖包"
        panda32.cover =
            "https://i1.hdslb.com/bfs/archive/f828d1c526e947a549c965a53b4ac3d728485b04.jpg"
        list.add(panda32)


        val panda33 = PetVideo()
        panda33.type = PetType.PANDA.ordinal
        panda33.fileName = "panda_mom_panda177"
        panda33.code = 412
        panda33.duration = 229
        panda33.period = PeriodType.MOM.ordinal
        panda33.isStar = false
        panda33.title = "【大熊猫和花】“你好可爱，你好乖，你是谁的梦中情喵”"
        panda33.releaseTime = "2021-11-12 18:10:36"
        panda33.originalUrl = "https://www.bilibili.com/video/BV1Mr4y1k7pm"
        panda33.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda33.authorName = "辛辛糖包"
        panda33.cover =
            "https://i1.hdslb.com/bfs/archive/ef6ef3431e22e2694a516778c5c44411f898242f.jpg"
        list.add(panda33)


        val panda34 = PetVideo()
        panda34.type = PetType.PANDA.ordinal
        panda34.fileName = "panda_mom_panda178"
        panda34.code = 413
        panda34.duration = 33
        panda34.period = PeriodType.MOM.ordinal
        panda34.isStar = false
        panda34.title = "大熊猫和花-真正的女明星，无惧怼脸拍摄"
        panda34.releaseTime = "2021-12-12 16:21:01"
        panda34.originalUrl = "https://www.bilibili.com/video/BV1x44y1E7nk"
        panda34.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda34.authorName = "和和和花花"
        panda34.cover =
            "https://i1.hdslb.com/bfs/archive/69a473cd27fd355f0191d182ef260684ca526f8c.jpg"
        list.add(panda34)


        val panda35 = PetVideo()
        panda35.type = PetType.PANDA.ordinal
        panda35.fileName = "panda_mom_panda179"
        panda35.code = 414
        panda35.duration = 59
        panda35.period = PeriodType.MOM.ordinal
        panda35.isStar = false
        panda35.title = "[和花]花花:爬树好累呀，还是坐着舒服（爬了一小截）"
        panda35.releaseTime = "2021-12-26 20:00:23"
        panda35.originalUrl = "https://www.bilibili.com/video/BV1ab4y1v7PU"
        panda35.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda35.authorName = "多元化之无尽的梦魇"
        panda35.cover =
            "https://i2.hdslb.com/bfs/archive/ba573221c07cdca238b26211d4313006c8f89761.jpg"
        list.add(panda35)


        val panda36 = PetVideo()
        panda36.type = PetType.PANDA.ordinal
        panda36.fileName = "panda_mom_panda180"
        panda36.code = 415
        panda36.duration = 196
        panda36.period = PeriodType.MOM.ordinal
        panda36.isStar = false
        panda36.title = "【大熊猫莽仔】莽小：屁股帮忙托一下，靴靴！"
        panda36.releaseTime = "2021-12-14 18:48:18"
        panda36.originalUrl = "https://www.bilibili.com/video/BV1bU4y1K7uj"
        panda36.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda36.authorName = "猴哥某熊铁锤都退役了"
        panda36.cover =
            "https://i1.hdslb.com/bfs/archive/203ef60491a609fe0379105e609aa35cef7b3dd6.jpg"
        list.add(panda36)


        val panda37 = PetVideo()
        panda37.type = PetType.PANDA.ordinal
        panda37.fileName = "panda_mom_panda181"
        panda37.code = 416
        panda37.duration = 133
        panda37.period = PeriodType.MOM.ordinal
        panda37.isStar = false
        panda37.title = "【莽星星】莽大：正宗泰式踩背，妈妈试了都说好，客人您来几个钟的？"
        panda37.releaseTime = "2021-12-22 18:58:19"
        panda37.originalUrl = "https://www.bilibili.com/video/BV1X3411x7Bb"
        panda37.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda37.authorName = "猴哥某熊铁锤都退役了"
        panda37.cover =
            "https://i0.hdslb.com/bfs/archive/72be7fc42431f73c312e06598184b363f6988134.jpg"
        list.add(panda37)


        val panda38 = PetVideo()
        panda38.type = PetType.PANDA.ordinal
        panda38.fileName = "panda_mom_panda182"
        panda38.code = 417
        panda38.duration = 16
        panda38.period = PeriodType.MOM.ordinal
        panda38.isStar = false
        panda38.title = "岁月静好"
        panda38.releaseTime = "2020-08-07 16:21:40"
        panda38.originalUrl = "https://www.bilibili.com/video/BV1Dv411v7tZ"
        panda38.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda38.authorName = "奶爸铲屎官"
        panda38.cover =
            "https://i0.hdslb.com/bfs/archive/bcc36f2100f8822733d38bc0d58558c417d8bb40.jpg"
        list.add(panda38)


        val panda39 = PetVideo()
        panda39.type = PetType.PANDA.ordinal
        panda39.fileName = "panda_mom_panda183"
        panda39.code = 418
        panda39.duration = 222
        panda39.period = PeriodType.MOM.ordinal
        panda39.isStar = false
        panda39.title = "打弟弟要趁早"
        panda39.releaseTime = "2022-01-09 12:35:16"
        panda39.originalUrl = "https://www.bilibili.com/video/BV1XS4y1Z7NR"
        panda39.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda39.authorName = "pandapia熊猫乌托邦"
        panda39.cover =
            "https://i0.hdslb.com/bfs/archive/ed107ee3d5683cdc319eb40256ef099f31cfec54.jpg"
        list.add(panda39)


        val panda40 = PetVideo()
        panda40.type = PetType.PANDA.ordinal
        panda40.fileName = "panda_mom_panda184"
        panda40.code = 419
        panda40.duration = 89
        panda40.period = PeriodType.MOM.ordinal
        panda40.isStar = false
        panda40.title = "和花和她的南瓜！别滚了！【大熊猫和花】"
        panda40.releaseTime = "2021-12-29 13:37:09"
        panda40.originalUrl = "https://www.bilibili.com/video/BV12q4y1m7FN"
        panda40.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda40.authorName = "安娜丽丝k"
        panda40.cover =
            "https://i0.hdslb.com/bfs/archive/5f1fa27470bad326058659edea35c751c2a37051.png"
        list.add(panda40)


        val panda41 = PetVideo()
        panda41.type = PetType.PANDA.ordinal
        panda41.fileName = "panda_mom_panda185"
        panda41.code = 420
        panda41.duration = 160
        panda41.period = PeriodType.MOM.ordinal
        panda41.isStar = false
        panda41.title = "公正的教育家淼淼"
        panda41.releaseTime = "2021-12-24 10:05:00"
        panda41.originalUrl = "https://www.bilibili.com/video/BV1U34y167rG"
        panda41.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda41.authorName = "大熊猫繁育研究基金会"
        panda41.cover =
            "https://i0.hdslb.com/bfs/archive/efa82d04152e47099ff001ea1d09f0d0d2eaa47b.jpg"
        list.add(panda41)


        val panda42 = PetVideo()
        panda42.type = PetType.PANDA.ordinal
        panda42.fileName = "panda_mom_panda186"
        panda42.code = 421
        panda42.duration = 79
        panda42.period = PeriodType.MOM.ordinal
        panda42.isStar = false
        panda42.title = "花花讨奶喝，太可爱了【大熊猫和花】"
        panda42.releaseTime = "2022-01-06 08:46:01"
        panda42.originalUrl = "https://www.bilibili.com/video/BV1YY411a72Y"
        panda42.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda42.authorName = "萌面可爱多_"
        panda42.cover =
            "https://i0.hdslb.com/bfs/archive/f251ac688156f412757a4ce3c1b56e4a3f4e9bbd.jpg"
        list.add(panda42)


        val panda43 = PetVideo()
        panda43.type = PetType.PANDA.ordinal
        panda43.fileName = "panda_mom_panda187"
        panda43.code = 422
        panda43.duration = 85
        panda43.period = PeriodType.MOM.ordinal
        panda43.isStar = false
        panda43.title = "和叶，小娃儿挨打都是自找的哦！【大熊猫和花】【大熊猫和叶】"
        panda43.releaseTime = "2021-12-25 17:04:04"
        panda43.originalUrl = "https://www.bilibili.com/video/BV1VM4y1w7mE"
        panda43.tags = "和花,萌宠,萌萌哒,可爱,动物圈"
        panda43.authorName = "安娜丽丝k"
        panda43.cover =
            "https://i2.hdslb.com/bfs/archive/399ef29fbe879e4fd78a6cc0b5712f7867acd334.jpg"
        list.add(panda43)


        val panda188 = PetVideo()
        panda188.type = PetType.PANDA.ordinal
        panda188.fileName = "panda_mom_panda188"
        panda188.code = 789
        panda188.duration = 236
        panda188.period = PeriodType.MOM.ordinal
        panda188.isStar = false
        panda188.title = "【奇珍奇宝】好奇带崽出外场啦！"
        panda188.releaseTime = "2022-02-02 18:39:51"
        panda188.originalUrl = "https://www.bilibili.com/video/BV1VP4y1A7f8"
        panda188.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda188.authorName = "猴哥某熊铁锤都退役了"
        panda188.cover =
            "https://i1.hdslb.com/bfs/archive/2df11560c552d10236ec45a62233f025bc3544b6.jpg"
        panda188.videoType = 0
        list.add(panda188)


        val panda189 = PetVideo()
        panda189.type = PetType.PANDA.ordinal
        panda189.fileName = "panda_mom_panda189"
        panda189.code = 790
        panda189.duration = 77
        panda189.period = PeriodType.MOM.ordinal
        panda189.isStar = false
        panda189.title = "不出意外的话，下一秒她就要开口说话了"
        panda189.releaseTime = "2022-02-01 13:25:19"
        panda189.originalUrl = "https://www.bilibili.com/video/BV19L411F7VN"
        panda189.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda189.authorName = "旅日熊猫和朋友们"
        panda189.cover =
            "https://i0.hdslb.com/bfs/archive/528fc8b289c5aabd47e38ea2ed046803524efdfa.jpg"
        panda189.videoType = 0
        list.add(panda189)


        val panda190 = PetVideo()
        panda190.type = PetType.PANDA.ordinal
        panda190.fileName = "panda_mom_panda190"
        panda190.code = 791
        panda190.duration = 113
        panda190.period = PeriodType.MOM.ordinal
        panda190.isStar = false
        panda190.title = "【重庆动物园】莽仔：星猪儿可劲rua我，辰猪儿夺我的笋，我太难了"
        panda190.releaseTime = "2022-01-17 11:20:00"
        panda190.originalUrl = "https://www.bilibili.com/video/BV1bL4y147po"
        panda190.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda190.authorName = "丶祀很宔"
        panda190.cover =
            "https://i1.hdslb.com/bfs/archive/2e00184dc2570b4455c7065ef56d31a0147e8c02.jpg"
        panda190.videoType = 0
        list.add(panda190)


        val panda191 = PetVideo()
        panda191.type = PetType.PANDA.ordinal
        panda191.fileName = "panda_mom_panda191"
        panda191.code = 792
        panda191.duration = 21
        panda191.period = PeriodType.MOM.ordinal
        panda191.isStar = false
        panda191.title = "福多多和妈妈的治愈时刻"
        panda191.releaseTime = "2022-02-02 12:35:08"
        panda191.originalUrl = "https://www.bilibili.com/video/BV1BS4y1V71m"
        panda191.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda191.authorName = "开饭了大熊猫V"
        panda191.cover =
            "https://i0.hdslb.com/bfs/archive/ba4db8b6ab7328f5830bbe5fd442cb2788f6da57.jpg"
        panda191.videoType = 0
        list.add(panda191)


        val panda192 = PetVideo()
        panda192.type = PetType.PANDA.ordinal
        panda192.fileName = "panda_mom_panda192"
        panda192.code = 793
        panda192.duration = 76
        panda192.period = PeriodType.MOM.ordinal
        panda192.isStar = false
        panda192.title = "【大熊猫和花】好会卖萌，但又好像对自己的可爱一无所知"
        panda192.releaseTime = "2022-01-20 08:04:13"
        panda192.originalUrl = "https://www.bilibili.com/video/BV1iq4y1k7Ty"
        panda192.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda192.authorName = "辛辛糖包"
        panda192.cover =
            "https://i0.hdslb.com/bfs/archive/9e8b6c8c3864f26b527cd8b071ce1353fff7a0ae.jpg"
        panda192.videoType = 0
        list.add(panda192)


        val panda193 = PetVideo()
        panda193.type = PetType.PANDA.ordinal
        panda193.fileName = "panda_mom_panda193"
        panda193.code = 794
        panda193.duration = 61
        panda193.period = PeriodType.MOM.ordinal
        panda193.isStar = false
        panda193.title = "小优：妈妈等等我，我跟不上了"
        panda193.releaseTime = "2022-02-02 09:40:05"
        panda193.originalUrl = "https://www.bilibili.com/video/BV1SP4y1N7CZ"
        panda193.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda193.authorName = "迩後咩"
        panda193.cover =
            "https://i0.hdslb.com/bfs/archive/b8afc0009662a2dba356aff66f31f5cf4369c86e.jpg"
        panda193.videoType = 0
        list.add(panda193)


        val panda194 = PetVideo()
        panda194.type = PetType.PANDA.ordinal
        panda194.fileName = "panda_mom_panda194"
        panda194.code = 795
        panda194.duration = 147
        panda194.period = PeriodType.MOM.ordinal
        panda194.isStar = false
        panda194.title = "【大熊猫萌萌】抱着女儿做仰卧起坐"
        panda194.releaseTime = "2019-02-28 11:10:08"
        panda194.originalUrl = "https://www.bilibili.com/video/BV1yb411t7ii"
        panda194.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda194.authorName = "羽川゚"
        panda194.cover =
            "https://i2.hdslb.com/bfs/archive/4362ced9186cbaca05b846a9e428b87fb1e739f5.jpg"
        panda194.videoType = 0
        list.add(panda194)


        val panda195 = PetVideo()
        panda195.type = PetType.PANDA.ordinal
        panda195.fileName = "panda_mom_panda195"
        panda195.code = 796
        panda195.duration = 114
        panda195.period = PeriodType.MOM.ordinal
        panda195.isStar = false
        panda195.title = "一个神烦的熊孩子"
        panda195.releaseTime = "2016-09-19 15:10:30"
        panda195.originalUrl = "https://www.bilibili.com/video/BV1js411t7ej"
        panda195.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda195.authorName = "pandapia熊猫乌托邦"
        panda195.cover =
            "https://i1.hdslb.com/bfs/archive/fa138d58ed7d5f72fd5404d6ad637b0ec6950619.jpg"
        panda195.videoType = 0
        list.add(panda195)


        val panda196 = PetVideo()
        panda196.type = PetType.PANDA.ordinal
        panda196.fileName = "panda_mom_panda196"
        panda196.code = 797
        panda196.duration = 67
        panda196.period = PeriodType.MOM.ordinal
        panda196.isStar = false
        panda196.title = "萌萌   萌兰"
        panda196.releaseTime = "2017-02-24 20:23:52"
        panda196.originalUrl = "https://www.bilibili.com/video/BV1rx411y7zD"
        panda196.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda196.authorName = "萌の兰"
        panda196.cover =
            "https://i0.hdslb.com/bfs/archive/24dd3ec4e32cf07692474ba7e480ccdfdcb13733.jpg"
        panda196.videoType = 0
        list.add(panda196)


        val panda197 = PetVideo()
        panda197.type = PetType.PANDA.ordinal
        panda197.fileName = "panda_mom_panda197"
        panda197.code = 798
        panda197.duration = 117
        panda197.period = PeriodType.MOM.ordinal
        panda197.isStar = false
        panda197.title = "萌妈的烦心儿子萌三三"
        panda197.releaseTime = "2016-10-20 16:21:13"
        panda197.originalUrl = "https://www.bilibili.com/video/BV1zs41147jP"
        panda197.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda197.authorName = "咪呜咪呜酱"
        panda197.cover =
            "https://i1.hdslb.com/bfs/archive/283e48a5a820808a1ca8d5f25ed053d96d51fdeb.jpg"
        panda197.videoType = 0
        list.add(panda197)


        val panda198 = PetVideo()
        panda198.type = PetType.PANDA.ordinal
        panda198.fileName = "panda_mom_panda198"
        panda198.code = 799
        panda198.duration = 114
        panda198.period = PeriodType.MOM.ordinal
        panda198.isStar = false
        panda198.title = "【大熊猫萌萌&萌宝&萌玉】萌萌姐森气了，两个女鹅玩竟然不带上她←_←"
        panda198.releaseTime = "2019-07-27 17:05:53"
        panda198.originalUrl = "https://www.bilibili.com/video/BV1ht411P7E7"
        panda198.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda198.authorName = "辛辛糖包"
        panda198.cover =
            "https://i2.hdslb.com/bfs/archive/b9345ee48bc6162ef91ce95ca3c88841d5c6e677.jpg"
        panda198.videoType = 0
        list.add(panda198)


        val panda199 = PetVideo()
        panda199.type = PetType.PANDA.ordinal
        panda199.fileName = "panda_mom_panda199"
        panda199.code = 800
        panda199.duration = 247
        panda199.period = PeriodType.MOM.ordinal
        panda199.isStar = false
        panda199.title = "【大熊猫萌萌&萌玉】大美萌接五五下树，亲亲抱抱举高高^O^"
        panda199.releaseTime = "2019-01-08 20:59:09"
        panda199.originalUrl = "https://www.bilibili.com/video/BV1at411s7KK"
        panda199.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda199.authorName = "辛辛糖包"
        panda199.cover =
            "https://i1.hdslb.com/bfs/archive/5680d550c69359708cde4446a1ceb0d0fab7b17f.jpg"
        panda199.videoType = 0
        list.add(panda199)


        val panda200 = PetVideo()
        panda200.type = PetType.PANDA.ordinal
        panda200.fileName = "panda_mom_panda200"
        panda200.code = 801
        panda200.duration = 476
        panda200.period = PeriodType.MOM.ordinal
        panda200.isStar = false
        panda200.title = "大熊猫福宝 又标记妈妈的脸 然后出现了极度舒适的画面（我先笑为敬 哈哈） 220111"
        panda200.releaseTime = "2022-01-11 21:14:47"
        panda200.originalUrl = "https://www.bilibili.com/video/BV1Ra411q7uG"
        panda200.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda200.authorName = "浪花花呀0611"
        panda200.cover =
            "https://i0.hdslb.com/bfs/archive/dbf20c8a0e251f731ac640e4f05e2fa1b6cbcb30.jpg"
        panda200.videoType = 0
        list.add(panda200)


        val panda201 = PetVideo()
        panda201.type = PetType.PANDA.ordinal
        panda201.fileName = "panda_mom_panda201"
        panda201.code = 802
        panda201.duration = 13
        panda201.period = PeriodType.MOM.ordinal
        panda201.isStar = false
        panda201.title = "冯巩老师是个好妈妈（昭美：野熊，2014年从四川凉山彝族自治州昭觉县和美姑县的山区救助）"
        panda201.releaseTime = "2022-01-11 08:28:02"
        panda201.originalUrl = "https://www.bilibili.com/video/BV1dZ4y1S7Cp"
        panda201.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda201.authorName = "黑白宝宝小捣蛋"
        panda201.cover =
            "https://i2.hdslb.com/bfs/archive/19d03b7d5d4ce16b5408e5cc7248af41854aac8e.jpg"
        panda201.videoType = 0
        list.add(panda201)


        val panda202 = PetVideo()
        panda202.type = PetType.PANDA.ordinal
        panda202.fileName = "panda_mom_panda202"
        panda202.code = 803
        panda202.duration = 94
        panda202.period = PeriodType.MOM.ordinal
        panda202.isStar = false
        panda202.title = "怡然：看什么看，没看过吸猫吗？"
        panda202.releaseTime = "2022-01-27 18:07:13"
        panda202.originalUrl = "https://www.bilibili.com/video/BV1Sq4y1c7pE"
        panda202.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda202.authorName = "迩後咩"
        panda202.cover =
            "https://i1.hdslb.com/bfs/archive/41dfa62629e39291427d948b7c48341762401122.jpg"
        panda202.videoType = 0
        list.add(panda202)


        val panda203 = PetVideo()
        panda203.type = PetType.PANDA.ordinal
        panda203.fileName = "panda_mom_panda203"
        panda203.code = 804
        panda203.duration = 130
        panda203.period = PeriodType.MOM.ordinal
        panda203.isStar = false
        panda203.title = "大熊猫和花：fafa和园润妈妈在一起的温馨时刻集锦，画面极度舒适"
        panda203.releaseTime = "2021-05-26 22:30:00"
        panda203.originalUrl = "https://www.bilibili.com/video/BV1Ab4y1f73Z"
        panda203.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda203.authorName = "小香妞爱熊猫"
        panda203.cover =
            "https://i1.hdslb.com/bfs/archive/6b9bcf4002acfbf0d4f236161bb1ba0a435e09ff.jpg"
        panda203.videoType = 0
        list.add(panda203)


        val panda204 = PetVideo()
        panda204.type = PetType.PANDA.ordinal
        panda204.fileName = "panda_mom_panda204"
        panda204.code = 805
        panda204.duration = 48
        panda204.period = PeriodType.MOM.ordinal
        panda204.isStar = false
        panda204.title = "花花：园润表姐你太重了【园润和花】"
        panda204.releaseTime = "2021-04-13 16:37:20"
        panda204.originalUrl = "https://www.bilibili.com/video/BV11K411F7XM"
        panda204.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda204.authorName = "迩後咩"
        panda204.cover =
            "https://i2.hdslb.com/bfs/archive/cb1432ed23d31dc2ce7828936f3743461a55e36a.jpg"
        panda204.videoType = 0
        list.add(panda204)


        val panda205 = PetVideo()
        panda205.type = PetType.PANDA.ordinal
        panda205.fileName = "panda_mom_panda205"
        panda205.code = 806
        panda205.duration = 73
        panda205.period = PeriodType.MOM.ordinal
        panda205.isStar = false
        panda205.title = "【大熊猫华妮&福宝】开始神烦妈妈的福宝"
        panda205.releaseTime = "2021-01-02 20:03:42"
        panda205.originalUrl = "https://www.bilibili.com/video/BV1sf4y1C7uX"
        panda205.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda205.authorName = "苹果乔"
        panda205.cover =
            "https://i2.hdslb.com/bfs/archive/6e33e7d0d187a5a8fdad9321cca9b5ea5198d049.jpg"
        panda205.videoType = 0
        list.add(panda205)


        val panda206 = PetVideo()
        panda206.type = PetType.PANDA.ordinal
        panda206.fileName = "panda_mom_panda206"
        panda206.code = 807
        panda206.duration = 852
        panda206.period = PeriodType.MOM.ordinal
        panda206.isStar = false
        panda206.title = "大熊猫华妮福宝 母女大战 220125"
        panda206.releaseTime = "2022-01-25 21:01:59"
        panda206.originalUrl = "https://www.bilibili.com/video/BV1UF411p74Y"
        panda206.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda206.authorName = "浪花花呀0611"
        panda206.cover =
            "https://i0.hdslb.com/bfs/archive/5c8b36531692e087519c76de756afba214401347.jpg"
        panda206.videoType = 0
        list.add(panda206)


        val panda207 = PetVideo()
        panda207.type = PetType.PANDA.ordinal
        panda207.fileName = "panda_mom_panda207"
        panda207.code = 808
        panda207.duration = 48
        panda207.period = PeriodType.MOM.ordinal
        panda207.isStar = false
        panda207.title = "成主任出gai！闲人勿近！"
        panda207.releaseTime = "2022-01-05 20:02:11"
        panda207.originalUrl = "https://www.bilibili.com/video/BV1kT4y12743"
        panda207.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda207.authorName = "和和和花花"
        panda207.cover =
            "https://i0.hdslb.com/bfs/archive/a6b33704567e2fb49a3b468d2b668e077dd2598e.jpg"
        panda207.videoType = 0
        list.add(panda207)


        val panda208 = PetVideo()
        panda208.type = PetType.PANDA.ordinal
        panda208.fileName = "panda_mom_panda208"
        panda208.code = 809
        panda208.duration = 40
        panda208.period = PeriodType.MOM.ordinal
        panda208.isStar = false
        panda208.title = "【大熊猫和花】fafa甜甜一笑融化所有人"
        panda208.releaseTime = "2022-01-11 14:29:34"
        panda208.originalUrl = "https://www.bilibili.com/video/BV1LR4y1g7FH"
        panda208.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda208.authorName = "地主家的小胖墩"
        panda208.cover =
            "https://i1.hdslb.com/bfs/archive/1141bd5866c9b6f011847e67510ff8d0ec947167.jpg"
        panda208.videoType = 0
        list.add(panda208)


        val panda209 = PetVideo()
        panda209.type = PetType.PANDA.ordinal
        panda209.fileName = "panda_mom_panda209"
        panda209.code = 810
        panda209.duration = 77
        panda209.period = PeriodType.MOM.ordinal
        panda209.isStar = false
        panda209.title = "爪爪：妈咪在和花花玩，我也要和花花玩；润润：你们都下去玩。"
        panda209.releaseTime = "2022-01-05 18:14:00"
        panda209.originalUrl = "https://www.bilibili.com/video/BV1QD4y1F7TS"
        panda209.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda209.authorName = "丶祀很宔"
        panda209.cover =
            "https://i0.hdslb.com/bfs/archive/397381301029781c55d18a3c3aba74233ffe7e1c.jpg"
        panda209.videoType = 0
        list.add(panda209)


        val panda210 = PetVideo()
        panda210.type = PetType.PANDA.ordinal
        panda210.fileName = "panda_mom_panda210"
        panda210.code = 811
        panda210.duration = 104
        panda210.period = PeriodType.MOM.ordinal
        panda210.isStar = false
        panda210.title = "【大熊猫园润和花】润润给花花喂奶，还摸摸花花的脑袋"
        panda210.releaseTime = "2021-05-07 19:32:59"
        panda210.originalUrl = "https://www.bilibili.com/video/BV1zo4y127nd"
        panda210.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda210.authorName = "空调轰轰响"
        panda210.cover =
            "https://i2.hdslb.com/bfs/archive/db25651b79f561c3da224008028d119adf91ae7c.jpg"
        panda210.videoType = 0
        list.add(panda210)


        val panda211 = PetVideo()
        panda211.type = PetType.PANDA.ordinal
        panda211.fileName = "panda_mom_panda211"
        panda211.code = 812
        panda211.duration = 239
        panda211.period = PeriodType.MOM.ordinal
        panda211.isStar = false
        panda211.title = "【大熊猫和花】润润妈妈太负责了，守着小花花，还给她排便便"
        panda211.releaseTime = "2021-04-24 22:00:06"
        panda211.originalUrl = "https://www.bilibili.com/video/BV1Ny4y147ut"
        panda211.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda211.authorName = "小香妞爱熊猫"
        panda211.cover =
            "https://i0.hdslb.com/bfs/archive/d0e19bf1c5a648c81a75e14ea3ad94dab2a62129.jpg"
        panda211.videoType = 0
        list.add(panda211)


        val panda212 = PetVideo()
        panda212.type = PetType.PANDA.ordinal
        panda212.fileName = "panda_mom_panda212"
        panda212.code = 813
        panda212.duration = 73
        panda212.period = PeriodType.MOM.ordinal
        panda212.isStar = false
        panda212.title = "【重庆动物园】莽星星：新年第一天，我不想上班"
        panda212.releaseTime = "2022-01-01 18:49:50"
        panda212.originalUrl = "https://www.bilibili.com/video/BV1Ha411z7jq"
        panda212.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda212.authorName = "丶祀很宔"
        panda212.cover =
            "https://i0.hdslb.com/bfs/archive/2746e8e29597f77ae0329da1690f765129ca4ab0.jpg"
        panda212.videoType = 0
        list.add(panda212)


        val panda213 = PetVideo()
        panda213.type = PetType.PANDA.ordinal
        panda213.fileName = "panda_mom_panda213"
        panda213.code = 814
        panda213.duration = 47
        panda213.period = PeriodType.MOM.ordinal
        panda213.isStar = false
        panda213.title =
            "爬妈妈山咯（珍珍：野熊冬冬后代，白云女儿。2018年参加野外引种时下山，挨家挨户溜达上央视新闻。珍厉害：大名新新，在四川甲勿海。珍不高兴：大名兴安，在湖南凤凰）"
        panda213.releaseTime = "2022-01-03 09:14:29"
        panda213.originalUrl = "https://www.bilibili.com/video/BV1VZ4y1S7qc"
        panda213.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda213.authorName = "黑白宝宝小捣蛋"
        panda213.cover =
            "https://i2.hdslb.com/bfs/archive/a362844379a43f96d2453d036ad7341b4714401c.jpg"
        panda213.videoType = 0
        list.add(panda213)


        val panda214 = PetVideo()
        panda214.type = PetType.PANDA.ordinal
        panda214.fileName = "panda_mom_panda214"
        panda214.code = 815
        panda214.duration = 37
        panda214.period = PeriodType.MOM.ordinal
        panda214.isStar = false
        panda214.title = "和花🌸：是我不可爱了吗？奶爸都没有理我伤心💔💔💔"
        panda214.releaseTime = "2022-01-17 19:21:54"
        panda214.originalUrl = "https://www.bilibili.com/video/BV1fq4y1y71t"
        panda214.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda214.authorName = "saber256"
        panda214.cover =
            "https://i0.hdslb.com/bfs/archive/d4c265f58e5355c451d54bac497b10822baacb4f.png"
        panda214.videoType = 0
        list.add(panda214)


        val panda215 = PetVideo()
        panda215.type = PetType.PANDA.ordinal
        panda215.fileName = "panda_mom_panda215"
        panda215.code = 816
        panda215.duration = 16
        panda215.period = PeriodType.MOM.ordinal
        panda215.isStar = false
        panda215.title = "温馨（野熊永巴后代，锦心与孩子念念、知路）"
        panda215.releaseTime = "2022-01-01 10:21:19"
        panda215.originalUrl = "https://www.bilibili.com/video/BV1C3411v73U"
        panda215.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda215.authorName = "黑白宝宝小捣蛋"
        panda215.cover =
            "https://i2.hdslb.com/bfs/archive/5095d8419807c96452dc6ff811326f5ed688e6ba.jpg"
        panda215.videoType = 0
        list.add(panda215)


        val panda216 = PetVideo()
        panda216.type = PetType.PANDA.ordinal
        panda216.fileName = "panda_mom_panda216"
        panda216.code = 817
        panda216.duration = 37
        panda216.period = PeriodType.MOM.ordinal
        panda216.isStar = false
        panda216.title = "[大熊猫和花]回家困难户的花花，没有奶妈抱天热也不回家"
        panda216.releaseTime = "2021-12-27 18:04:31"
        panda216.originalUrl = "https://www.bilibili.com/video/BV1sm4y1Q7iJ"
        panda216.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda216.authorName = "胖哒哒不月半"
        panda216.cover =
            "https://i0.hdslb.com/bfs/archive/d0287e87a1c564b81787e29b87abcc6e54dd6cfb.jpg"
        panda216.videoType = 0
        list.add(panda216)


        val panda217 = PetVideo()
        panda217.type = PetType.PANDA.ordinal
        panda217.fileName = "panda_mom_panda217"
        panda217.code = 818
        panda217.duration = 99
        panda217.period = PeriodType.MOM.ordinal
        panda217.isStar = false
        panda217.title = "【大熊猫莽仔】莽仔：你们打你们的，莫挨老娘！"
        panda217.releaseTime = "2022-01-20 20:09:29"
        panda217.originalUrl = "https://www.bilibili.com/video/BV1rZ4y1f7L2"
        panda217.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda217.authorName = "猴哥某熊铁锤都退役了"
        panda217.cover =
            "https://i0.hdslb.com/bfs/archive/498bdbd20ffc6330c132aee145572567ba2344c4.jpg"
        panda217.videoType = 0
        list.add(panda217)


        val panda218 = PetVideo()
        panda218.type = PetType.PANDA.ordinal
        panda218.fileName = "panda_mom_panda218"
        panda218.code = 819
        panda218.duration = 64
        panda218.period = PeriodType.MOM.ordinal
        panda218.isStar = false
        panda218.title = "被宠爱的孩子都有持无恐，死亡凝视都没用！福宝继续标记妈妈"
        panda218.releaseTime = "2022-01-21 00:15:38"
        panda218.originalUrl = "https://www.bilibili.com/video/BV1kP4y177E5"
        panda218.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda218.authorName = "阿狸爱胖达_微博同名"
        panda218.cover =
            "https://i1.hdslb.com/bfs/archive/46aa894f0a9d5d22febe7d68cf124c69f1d12965.jpg"
        panda218.videoType = 0
        list.add(panda218)


        val panda219 = PetVideo()
        panda219.type = PetType.PANDA.ordinal
        panda219.fileName = "panda_mom_panda219"
        panda219.code = 820
        panda219.duration = 19
        panda219.period = PeriodType.MOM.ordinal
        panda219.isStar = false
        panda219.title = "大熊猫福宝 疯狂标记麻麻的脸 被华妮麻麻咬尾巴 另一个角度（无声短视频） 220120"
        panda219.releaseTime = "2022-01-20 22:08:40"
        panda219.originalUrl = "https://www.bilibili.com/video/BV1Q34y1i7iT"
        panda219.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda219.authorName = "浪花花呀0611"
        panda219.cover =
            "https://i1.hdslb.com/bfs/archive/41bf86266fa5f4dca9d312bc64084c60c2ab8064.jpg"
        panda219.videoType = 0
        list.add(panda219)


        val panda220 = PetVideo()
        panda220.type = PetType.PANDA.ordinal
        panda220.fileName = "panda_mom_panda220"
        panda220.code = 821
        panda220.duration = 101
        panda220.period = PeriodType.MOM.ordinal
        panda220.isStar = false
        panda220.title = "【大熊猫莽仔】两个小家伙已经对妈妈的竹子感兴趣啦！"
        panda220.releaseTime = "2021-11-25 17:55:39"
        panda220.originalUrl = "https://www.bilibili.com/video/BV1kf4y1K77F"
        panda220.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda220.authorName = "猴哥某熊铁锤都退役了"
        panda220.cover =
            "https://i0.hdslb.com/bfs/archive/0942140b097ff289bed71570a1778abce1cb5d81.jpg"
        panda220.videoType = 0
        list.add(panda220)


        val panda221 = PetVideo()
        panda221.type = PetType.PANDA.ordinal
        panda221.fileName = "panda_mom_panda221"
        panda221.code = 822
        panda221.duration = 84
        panda221.period = PeriodType.MOM.ordinal
        panda221.isStar = false
        panda221.title = "【重庆动物园】星猪儿辰猪儿，快让你们妈咪好好吃饭"
        panda221.releaseTime = "2022-01-19 10:39:00"
        panda221.originalUrl = "https://www.bilibili.com/video/BV1mr4y1Y7SF"
        panda221.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda221.authorName = "丶祀很宔"
        panda221.cover =
            "https://i1.hdslb.com/bfs/archive/512a4fcae6e62614e227259da9a6810728746106.jpg"
        panda221.videoType = 0
        list.add(panda221)


        val panda222 = PetVideo()
        panda222.type = PetType.PANDA.ordinal
        panda222.fileName = "panda_mom_panda222"
        panda222.code = 823
        panda222.duration = 156
        panda222.period = PeriodType.MOM.ordinal
        panda222.isStar = false
        panda222.title = "“我是不是你最疼爱的崽啊”"
        panda222.releaseTime = "2022-01-18 15:05:13"
        panda222.originalUrl = "https://www.bilibili.com/video/BV1yS4y157VS"
        panda222.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda222.authorName = "ccitoo"
        panda222.cover =
            "https://i2.hdslb.com/bfs/archive/4ffd8d5397bdd5e450f30262033ef7152ee8e541.jpg"
        panda222.videoType = 0
        list.add(panda222)


        val panda223 = PetVideo()
        panda223.type = PetType.PANDA.ordinal
        panda223.fileName = "panda_mom_panda223"
        panda223.code = 824
        panda223.duration = 61
        panda223.period = PeriodType.MOM.ordinal
        panda223.isStar = false
        panda223.title = "汪佳和她的两个挖矿小童工"
        panda223.releaseTime = "2021-12-17 21:59:00"
        panda223.originalUrl = "https://www.bilibili.com/video/BV15P4y1G7w8"
        panda223.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda223.authorName = "黑白宝宝小捣蛋"
        panda223.cover =
            "https://i1.hdslb.com/bfs/archive/63e6b2034565dc92e1faf9a8beddbba037980be0.jpg"
        panda223.videoType = 0
        list.add(panda223)


        val panda224 = PetVideo()
        panda224.type = PetType.PANDA.ordinal
        panda224.fileName = "panda_mom_panda224"
        panda224.code = 825
        panda224.duration = 28
        panda224.period = PeriodType.MOM.ordinal
        panda224.isStar = false
        panda224.title = "【莽星星莽辰辰】崽啊，你是不是嘬错地方了？"
        panda224.releaseTime = "2022-01-19 21:01:59"
        panda224.originalUrl = "https://www.bilibili.com/video/BV12a41127LL"
        panda224.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda224.authorName = "猴哥某熊铁锤都退役了"
        panda224.cover =
            "https://i0.hdslb.com/bfs/archive/07b576df3856e9ac4fd2b7856707eb85aaf3bf8e.jpg"
        panda224.videoType = 0
        list.add(panda224)


        val panda225 = PetVideo()
        panda225.type = PetType.PANDA.ordinal
        panda225.fileName = "panda_mom_panda225"
        panda225.code = 826
        panda225.duration = 30
        panda225.period = PeriodType.MOM.ordinal
        panda225.isStar = false
        panda225.title = "没心没肺，吃完就睡"
        panda225.releaseTime = "2020-08-18 17:30:55"
        panda225.originalUrl = "https://www.bilibili.com/video/BV1UZ4y1K78U"
        panda225.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda225.authorName = "iPanda熊猫频道"
        panda225.cover =
            "https://i1.hdslb.com/bfs/archive/f9aaffc3bb53fe4382489a62b42e0be7ccdb5988.jpg"
        panda225.videoType = 0
        list.add(panda225)


        val panda226 = PetVideo()
        panda226.type = PetType.PANDA.ordinal
        panda226.fileName = "panda_mom_panda226"
        panda226.code = 827
        panda226.duration = 182
        panda226.period = PeriodType.MOM.ordinal
        panda226.isStar = false
        panda226.title = "太暖了！熊猫妈妈生下双胞胎后，长达一两个星期不吃不喝只为照顾小宝宝"
        panda226.releaseTime = "2021-12-22 18:45:00"
        panda226.originalUrl = "https://www.bilibili.com/video/BV1Yu411S7bX"
        panda226.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda226.authorName = "爱胖达Lovepanda"
        panda226.cover =
            "https://i1.hdslb.com/bfs/archive/7862ce21bebfae83e519baf67bf2a34a2b4e721f.jpg"
        panda226.videoType = 0
        list.add(panda226)


        val panda227 = PetVideo()
        panda227.type = PetType.PANDA.ordinal
        panda227.fileName = "panda_mom_panda227"
        panda227.code = 828
        panda227.duration = 32
        panda227.period = PeriodType.MOM.ordinal
        panda227.isStar = false
        panda227.title = "【大熊猫莽星星】莽仔：莫板！照相了！"
        panda227.releaseTime = "2022-01-18 19:50:23"
        panda227.originalUrl = "https://www.bilibili.com/video/BV11q4y1c71N"
        panda227.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda227.authorName = "猴哥某熊铁锤都退役了"
        panda227.cover =
            "https://i2.hdslb.com/bfs/archive/393f17c3f47d13defb796bb6f5bc9cf88b214053.jpg"
        panda227.videoType = 0
        list.add(panda227)


        val panda228 = PetVideo()
        panda228.type = PetType.PANDA.ordinal
        panda228.fileName = "panda_mom_panda228"
        panda228.code = 829
        panda228.duration = 63
        panda228.period = PeriodType.MOM.ordinal
        panda228.isStar = false
        panda228.title = "游客：趴在妈妈身上睡觉。奇一：抱着外甥女福来睡觉真踏实！"
        panda228.releaseTime = "2021-08-20 11:45:51"
        panda228.originalUrl = "https://www.bilibili.com/video/BV1PP4y1p7hU"
        panda228.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda228.authorName = "青檬鱼看熊猫儿"
        panda228.cover =
            "https://i2.hdslb.com/bfs/archive/fc1bcb021e9685820ce168630d4386cea555d00a.png"
        panda228.videoType = 0
        list.add(panda228)


        val panda229 = PetVideo()
        panda229.type = PetType.PANDA.ordinal
        panda229.fileName = "panda_mom_panda229"
        panda229.code = 830
        panda229.duration = 66
        panda229.period = PeriodType.MOM.ordinal
        panda229.isStar = false
        panda229.title = "【重庆动物园】莽星星喝完换莽辰辰，莽仔是好妈咪"
        panda229.releaseTime = "2022-01-04 17:31:11"
        panda229.originalUrl = "https://www.bilibili.com/video/BV1t44y1j7qJ"
        panda229.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda229.authorName = "丶祀很宔"
        panda229.cover =
            "https://i0.hdslb.com/bfs/archive/2f55db5d05f122d39b96d20ab66187ab16fa4242.jpg"
        panda229.videoType = 0
        list.add(panda229)


        val panda230 = PetVideo()
        panda230.type = PetType.PANDA.ordinal
        panda230.fileName = "panda_mom_panda230"
        panda230.code = 831
        panda230.duration = 81
        panda230.period = PeriodType.MOM.ordinal
        panda230.isStar = false
        panda230.title = "这算不算花花夺了二狗的笋？【大熊猫和花&润玥】"
        panda230.releaseTime = "2021-11-04 18:00:56"
        panda230.originalUrl = "https://www.bilibili.com/video/BV1Ch41187Hn"
        panda230.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda230.authorName = "朙雨"
        panda230.cover =
            "https://i1.hdslb.com/bfs/archive/da757b061c808e88937c5ca77e8449f72eede628.jpg"
        panda230.videoType = 0
        list.add(panda230)


        val panda231 = PetVideo()
        panda231.type = PetType.PANDA.ordinal
        panda231.fileName = "panda_mom_panda231"
        panda231.code = 832
        panda231.duration = 145
        panda231.period = PeriodType.MOM.ordinal
        panda231.isStar = false
        panda231.title = "【大熊猫园润润玥和花】菜花园一家靠在一起恰饭，场面一度十分温馨"
        panda231.releaseTime = "2021-11-04 14:20:50"
        panda231.originalUrl = "https://www.bilibili.com/video/BV1aq4y1r76c"
        panda231.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda231.authorName = "空调轰轰响"
        panda231.cover =
            "https://i1.hdslb.com/bfs/archive/2564b9b4fbed4b85aa9c06ed860f0d74f3ee009d.jpg"
        panda231.videoType = 0
        list.add(panda231)


        val panda232 = PetVideo()
        panda232.type = PetType.PANDA.ordinal
        panda232.fileName = "panda_mom_panda232"
        panda232.code = 833
        panda232.duration = 80
        panda232.period = PeriodType.MOM.ordinal
        panda232.isStar = false
        panda232.title = "【大熊猫园润润玥和花】事实证明，多喝奶多睡觉会变漂亮哦！"
        panda232.releaseTime = "2021-11-25 20:10:23"
        panda232.originalUrl = "https://www.bilibili.com/video/BV14b4y1b7Fs"
        panda232.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda232.authorName = "空调轰轰响"
        panda232.cover =
            "https://i2.hdslb.com/bfs/archive/e0c6d5fb6ec3a8110c97acb68cd59003d1fcd919.jpg"
        panda232.videoType = 0
        list.add(panda232)


        val panda233 = PetVideo()
        panda233.type = PetType.PANDA.ordinal
        panda233.fileName = "panda_mom_panda233"
        panda233.code = 834
        panda233.duration = 55
        panda233.period = PeriodType.MOM.ordinal
        panda233.isStar = false
        panda233.title = "【和花/园润】美好的时光"
        panda233.releaseTime = "2021-11-17 18:30:53"
        panda233.originalUrl = "https://www.bilibili.com/video/BV1VQ4y1U7YK"
        panda233.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda233.authorName = "讷言小筑"
        panda233.cover =
            "https://i1.hdslb.com/bfs/archive/74ddd80427ccb561f9adb2bf851a2befbbb1b9b6.jpg"
        panda233.videoType = 0
        list.add(panda233)


        val panda234 = PetVideo()
        panda234.type = PetType.PANDA.ordinal
        panda234.fileName = "panda_mom_panda234"
        panda234.code = 835
        panda234.duration = 150
        panda234.period = PeriodType.MOM.ordinal
        panda234.isStar = false
        panda234.title = "【大熊猫和花】萌头·萌脑·大脸ber"
        panda234.releaseTime = "2022-01-12 23:43:17"
        panda234.originalUrl = "https://www.bilibili.com/video/BV1Xa411q7a3"
        panda234.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda234.authorName = "辛辛糖包"
        panda234.cover =
            "https://i1.hdslb.com/bfs/archive/56f2bddb012b41da0ad6b8eb2141b010c09a58dd.jpg"
        panda234.videoType = 0
        list.add(panda234)


        val panda235 = PetVideo()
        panda235.type = PetType.PANDA.ordinal
        panda235.fileName = "panda_mom_panda235"
        panda235.code = 836
        panda235.duration = 34
        panda235.period = PeriodType.MOM.ordinal
        panda235.isStar = false
        panda235.title = "你妈还是你妈"
        panda235.releaseTime = "2021-08-02 14:45:22"
        panda235.originalUrl = "https://www.bilibili.com/video/BV1sv411J7yU"
        panda235.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda235.authorName = "爱胖达Lovepanda"
        panda235.cover =
            "https://i2.hdslb.com/bfs/archive/3ee36324926b6dced3522fc2767e7ea6ea3421c3.jpg"
        panda235.videoType = 0
        list.add(panda235)


        val panda236 = PetVideo()
        panda236.type = PetType.PANDA.ordinal
        panda236.fileName = "panda_mom_panda236"
        panda236.code = 837
        panda236.duration = 20
        panda236.period = PeriodType.MOM.ordinal
        panda236.isStar = false
        panda236.title = "麻麻，搭个车"
        panda236.releaseTime = "2019-12-19 21:29:08"
        panda236.originalUrl = "https://www.bilibili.com/video/BV1DJ411t7Sc"
        panda236.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda236.authorName = "阿肥瓜"
        panda236.cover =
            "https://i2.hdslb.com/bfs/archive/9cc4356b02519d9562ac3b76a80b9bc233559b8d.jpg"
        panda236.videoType = 0
        list.add(panda236)


        val panda237 = PetVideo()
        panda237.type = PetType.PANDA.ordinal
        panda237.fileName = "panda_mom_panda237"
        panda237.code = 838
        panda237.duration = 47
        panda237.period = PeriodType.MOM.ordinal
        panda237.isStar = false
        panda237.title = "在麻麻背上打架"
        panda237.releaseTime = "2019-12-11 21:14:26"
        panda237.originalUrl = "https://www.bilibili.com/video/BV1gJ41117ZU"
        panda237.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda237.authorName = "阿肥瓜"
        panda237.cover =
            "https://i0.hdslb.com/bfs/archive/40e696723b70863b19181616577708f53b05ef1b.jpg"
        panda237.videoType = 0
        list.add(panda237)


        val panda238 = PetVideo()
        panda238.type = PetType.PANDA.ordinal
        panda238.fileName = "panda_mom_panda238"
        panda238.code = 839
        panda238.duration = 25
        panda238.period = PeriodType.MOM.ordinal
        panda238.isStar = false
        panda238.title = "大熊猫和花-这整片草地，都被我成和花承包了！"
        panda238.releaseTime = "2021-09-23 19:26:17"
        panda238.originalUrl = "https://www.bilibili.com/video/BV1Av411G76g"
        panda238.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda238.authorName = "和和和花花"
        panda238.cover =
            "https://i2.hdslb.com/bfs/archive/017a0f9ce02912ec7130a3df99e0de250eb02b2e.jpg"
        panda238.videoType = 0
        list.add(panda238)


        val panda239 = PetVideo()
        panda239.type = PetType.PANDA.ordinal
        panda239.fileName = "panda_mom_panda239"
        panda239.code = 840
        panda239.duration = 37
        panda239.period = PeriodType.MOM.ordinal
        panda239.isStar = false
        panda239.title = "【大熊猫福禄福双】母女俩都小小只"
        panda239.releaseTime = "2021-05-30 23:04:39"
        panda239.originalUrl = "https://www.bilibili.com/video/BV14f4y1h7x5"
        panda239.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda239.authorName = "和花花真好看"
        panda239.cover =
            "https://i0.hdslb.com/bfs/archive/ebb02fe6b9eec68714b4fd156c85a5f8f3e97ef4.jpg"
        panda239.videoType = 0
        list.add(panda239)


        val panda240 = PetVideo()
        panda240.type = PetType.PANDA.ordinal
        panda240.fileName = "panda_mom_panda240"
        panda240.code = 841
        panda240.duration = 116
        panda240.period = PeriodType.MOM.ordinal
        panda240.isStar = false
        panda240.title = "从小熊熊口里夺笋，夺笋呐！"
        panda240.releaseTime = "2021-05-13 14:45:01"
        panda240.originalUrl = "https://www.bilibili.com/video/BV1X54y157su"
        panda240.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda240.authorName = "pandapia熊猫乌托邦"
        panda240.cover =
            "https://i1.hdslb.com/bfs/archive/435c1dd1bdae7940a789b81d3286f8f3439e57a7.jpg"
        panda240.videoType = 0
        list.add(panda240)


        val panda241 = PetVideo()
        panda241.type = PetType.PANDA.ordinal
        panda241.fileName = "panda_mom_panda241"
        panda241.code = 842
        panda241.duration = 80
        panda241.period = PeriodType.MOM.ordinal
        panda241.isStar = false
        panda241.title = "熊孩子缠的妈妈睡不着觉！"
        panda241.releaseTime = "2021-05-21 13:35:10"
        panda241.originalUrl = "https://www.bilibili.com/video/BV1EV411j7WS"
        panda241.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda241.authorName = "pandapia熊猫乌托邦"
        panda241.cover =
            "https://i2.hdslb.com/bfs/archive/877f654316c7d6c19e64527c649335c0bfa5bde8.jpg"
        panda241.videoType = 0
        list.add(panda241)


        val panda242 = PetVideo()
        panda242.type = PetType.PANDA.ordinal
        panda242.fileName = "panda_mom_panda242"
        panda242.code = 843
        panda242.duration = 71
        panda242.period = PeriodType.MOM.ordinal
        panda242.isStar = false
        panda242.title = "妈咪，可不可以温柔亿点点嘛~"
        panda242.releaseTime = "2021-05-23 13:30:17"
        panda242.originalUrl = "https://www.bilibili.com/video/BV1MK4y1G7TF"
        panda242.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda242.authorName = "pandapia熊猫乌托邦"
        panda242.cover =
            "https://i0.hdslb.com/bfs/archive/3ac09e2f410839882a2a716c76a7a8f69af004c9.jpg"
        panda242.videoType = 0
        list.add(panda242)


        val panda243 = PetVideo()
        panda243.type = PetType.PANDA.ordinal
        panda243.fileName = "panda_mom_panda243"
        panda243.code = 844
        panda243.duration = 93
        panda243.period = PeriodType.MOM.ordinal
        panda243.isStar = false
        panda243.title = "小熊的快乐很简单，被妈咪追的时候很狼狈！"
        panda243.releaseTime = "2021-06-04 14:54:04"
        panda243.originalUrl = "https://www.bilibili.com/video/BV1GV41147ys"
        panda243.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda243.authorName = "pandapia熊猫乌托邦"
        panda243.cover =
            "https://i2.hdslb.com/bfs/archive/eba66a52884d6925ca55890b500eee8469198c77.jpg"
        panda243.videoType = 0
        list.add(panda243)


        val panda244 = PetVideo()
        panda244.type = PetType.PANDA.ordinal
        panda244.fileName = "panda_mom_panda244"
        panda244.code = 845
        panda244.duration = 278
        panda244.period = PeriodType.MOM.ordinal
        panda244.isStar = false
        panda244.title = "吃饱没有呀小姑娘？"
        panda244.releaseTime = "2021-06-09 13:35:02"
        panda244.originalUrl = "https://www.bilibili.com/video/BV1Lv411p7mj"
        panda244.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda244.authorName = "pandapia熊猫乌托邦"
        panda244.cover =
            "https://i2.hdslb.com/bfs/archive/c3666902449c9417e88aec820da63f3517336094.jpg"
        panda244.videoType = 0
        list.add(panda244)


        val panda245 = PetVideo()
        panda245.type = PetType.PANDA.ordinal
        panda245.fileName = "panda_mom_panda245"
        panda245.code = 846
        panda245.duration = 207
        panda245.period = PeriodType.MOM.ordinal
        panda245.isStar = false
        panda245.title = "“妈咪，看我花式吃笋！”，淼淼：“四川话里你这叫悬脸皮……”"
        panda245.releaseTime = "2021-06-22 13:35:15"
        panda245.originalUrl = "https://www.bilibili.com/video/BV1Bq4y1L7zR"
        panda245.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda245.authorName = "pandapia熊猫乌托邦"
        panda245.cover =
            "https://i2.hdslb.com/bfs/archive/4984bec98a4e48a4ce7b49cb4e5712383f461a58.jpg"
        panda245.videoType = 0
        list.add(panda245)


        val panda246 = PetVideo()
        panda246.type = PetType.PANDA.ordinal
        panda246.fileName = "panda_mom_panda246"
        panda246.code = 847
        panda246.duration = 158
        panda246.period = PeriodType.MOM.ordinal
        panda246.isStar = false
        panda246.title = "谁偷了我的“私房钱”？？！（绩笑：小姨你听我说！听我说！）"
        panda246.releaseTime = "2021-09-19 18:00:05"
        panda246.originalUrl = "https://www.bilibili.com/video/BV1634y1S71a"
        panda246.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda246.authorName = "pandapia熊猫乌托邦"
        panda246.cover =
            "https://i1.hdslb.com/bfs/archive/08a8ec266fb271570a06879f1876d5bb16566967.jpg"
        panda246.videoType = 0
        list.add(panda246)


        val panda247 = PetVideo()
        panda247.type = PetType.PANDA.ordinal
        panda247.fileName = "panda_mom_panda247"
        panda247.code = 848
        panda247.duration = 84
        panda247.period = PeriodType.MOM.ordinal
        panda247.isStar = false
        panda247.title = "和花登顶小木桩！越来越棒！【大熊猫和花】"
        panda247.releaseTime = "2022-01-01 20:49:43"
        panda247.originalUrl = "https://www.bilibili.com/video/BV1Fb4y1e7cy"
        panda247.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda247.authorName = "安娜丽丝k"
        panda247.cover =
            "https://i2.hdslb.com/bfs/archive/85543ad72fa121878f14c63a71acb6f46ac09b6a.jpg"
        panda247.videoType = 0
        list.add(panda247)


        val panda248 = PetVideo()
        panda248.type = PetType.PANDA.ordinal
        panda248.fileName = "panda_mom_panda248"
        panda248.code = 849
        panda248.duration = 112
        panda248.period = PeriodType.MOM.ordinal
        panda248.isStar = false
        panda248.title = "瓜妃被绑架了，窝要解救它！【大熊猫和花】"
        panda248.releaseTime = "2022-01-02 13:13:06"
        panda248.originalUrl = "https://www.bilibili.com/video/BV1HP4y1n7rm"
        panda248.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda248.authorName = "安娜丽丝k"
        panda248.cover =
            "https://i2.hdslb.com/bfs/archive/40d1a3c3fc3915eacbc5134ae889216ea430dc44.jpg"
        panda248.videoType = 0
        list.add(panda248)


        val panda249 = PetVideo()
        panda249.type = PetType.PANDA.ordinal
        panda249.fileName = "panda_mom_panda249"
        panda249.code = 850
        panda249.duration = 64
        panda249.period = PeriodType.MOM.ordinal
        panda249.isStar = false
        panda249.title = "知女莫若母，园润给晒太阳得花花送来了热乎乎的青团"
        panda249.releaseTime = "2021-11-17 15:43:52"
        panda249.originalUrl = "https://www.bilibili.com/video/BV1nq4y1u7SV"
        panda249.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda249.authorName = "胖哒哒不月半"
        panda249.cover =
            "https://i0.hdslb.com/bfs/archive/fba858081bfafac817b223ed3d7598f064388c6c.jpg"
        panda249.videoType = 0
        list.add(panda249)


        val panda250 = PetVideo()
        panda250.type = PetType.PANDA.ordinal
        panda250.fileName = "panda_mom_panda250"
        panda250.code = 851
        panda250.duration = 32
        panda250.period = PeriodType.MOM.ordinal
        panda250.isStar = false
        panda250.title = "一只有小心思的大熊猫，要奶爸抱抱才回家"
        panda250.releaseTime = "2021-12-08 18:26:45"
        panda250.originalUrl = "https://www.bilibili.com/video/BV1eP4y137b6"
        panda250.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda250.authorName = "胖哒哒不月半"
        panda250.cover =
            "https://i2.hdslb.com/bfs/archive/742b6432571de175962bd5ce47875ce0e5fcbf4b.jpg"
        panda250.videoType = 0
        list.add(panda250)


        val panda251 = PetVideo()
        panda251.type = PetType.PANDA.ordinal
        panda251.fileName = "panda_mom_panda251"
        panda251.code = 852
        panda251.duration = 42
        panda251.period = PeriodType.MOM.ordinal
        panda251.isStar = false
        panda251.title = "花花教你怎么从容掩饰踩空台阶的尴尬"
        panda251.releaseTime = "2021-11-25 12:40:19"
        panda251.originalUrl = "https://www.bilibili.com/video/BV19R4y1x7fo"
        panda251.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda251.authorName = "胖哒哒不月半"
        panda251.cover =
            "https://i1.hdslb.com/bfs/archive/65487c1d165cec22a9668d90698df31348cfad39.jpg"
        panda251.videoType = 0
        list.add(panda251)


        val panda252 = PetVideo()
        panda252.type = PetType.PANDA.ordinal
        panda252.fileName = "panda_mom_panda252"
        panda252.code = 853
        panda252.duration = 42
        panda252.period = PeriodType.MOM.ordinal
        panda252.isStar = false
        panda252.title = "【大熊猫和花】fafa找干妈要neinei，但是好像找错地方了"
        panda252.releaseTime = "2021-04-26 22:00:17"
        panda252.originalUrl = "https://www.bilibili.com/video/BV18Q4y1Z762"
        panda252.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda252.authorName = "小香妞爱熊猫"
        panda252.cover =
            "https://i1.hdslb.com/bfs/archive/5728fbbf5ee49223a21e2eb516a751eec6a947b0.jpg"
        panda252.videoType = 0
        list.add(panda252)


        val panda253 = PetVideo()
        panda253.type = PetType.PANDA.ordinal
        panda253.fileName = "panda_mom_panda253"
        panda253.code = 854
        panda253.duration = 129
        panda253.period = PeriodType.MOM.ordinal
        panda253.isStar = false
        panda253.title = "【大熊猫和花】假装啃竹笋，演得可像真的了"
        panda253.releaseTime = "2021-04-23 22:00:15"
        panda253.originalUrl = "https://www.bilibili.com/video/BV1HV411H7sW"
        panda253.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda253.authorName = "小香妞爱熊猫"
        panda253.cover =
            "https://i0.hdslb.com/bfs/archive/fc6d2ef4840224767bd7179be50a4d8b9489aa35.jpg"
        panda253.videoType = 0
        list.add(panda253)


        val panda254 = PetVideo()
        panda254.type = PetType.PANDA.ordinal
        panda254.fileName = "panda_mom_panda254"
        panda254.code = 855
        panda254.duration = 62
        panda254.period = PeriodType.MOM.ordinal
        panda254.isStar = false
        panda254.title = "【大熊猫和花】花花终于又上树了，这次我们是自己上去的"
        panda254.releaseTime = "2021-07-25 17:41:17"
        panda254.originalUrl = "https://www.bilibili.com/video/BV1e64y1x73Y"
        panda254.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda254.authorName = "小香妞爱熊猫"
        panda254.cover =
            "https://i2.hdslb.com/bfs/archive/d68de47ecfacfd66198e8bfecff775890af9b764.jpg"
        panda254.videoType = 0
        list.add(panda254)


        val panda255 = PetVideo()
        panda255.type = PetType.PANDA.ordinal
        panda255.fileName = "panda_mom_panda255"
        panda255.code = 856
        panda255.duration = 68
        panda255.period = PeriodType.MOM.ordinal
        panda255.isStar = false
        panda255.title = "大熊猫和叶：下雨天营业，小叶子独自撑起全场"
        panda255.releaseTime = "2021-08-14 10:00:02"
        panda255.originalUrl = "https://www.bilibili.com/video/BV1s3411z7fw"
        panda255.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda255.authorName = "小香妞爱熊猫"
        panda255.cover =
            "https://i1.hdslb.com/bfs/archive/288f4d1e0b1ccba2ae35f75384cc1e4df6593fbe.jpg"
        panda255.videoType = 0
        list.add(panda255)


        val panda256 = PetVideo()
        panda256.type = PetType.PANDA.ordinal
        panda256.fileName = "panda_mom_panda256"
        panda256.code = 857
        panda256.duration = 158
        panda256.period = PeriodType.MOM.ordinal
        panda256.isStar = false
        panda256.title = "二狗胆儿肥了，敢扇妈妈耳光了，瞧把你能的(回忆篇，二狗，你一定很想妈妈吧)"
        panda256.releaseTime = "2021-11-14 22:30:09"
        panda256.originalUrl = "https://www.bilibili.com/video/BV1Yb4y187h1"
        panda256.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda256.authorName = "小香妞爱熊猫"
        panda256.cover =
            "https://i1.hdslb.com/bfs/archive/83234e1a1909db03bd1c0fd0180eaf7584e41fdf.jpg"
        panda256.videoType = 0
        list.add(panda256)


        val panda257 = PetVideo()
        panda257.type = PetType.PANDA.ordinal
        panda257.fileName = "panda_mom_panda257"
        panda257.code = 858
        panda257.duration = 75
        panda257.period = PeriodType.MOM.ordinal
        panda257.isStar = false
        panda257.title = "回忆篇:和叶艾玖跟妈妈在一起的快乐时光"
        panda257.releaseTime = "2021-11-16 22:30:06"
        panda257.originalUrl = "https://www.bilibili.com/video/BV1Bh411t7sn"
        panda257.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda257.authorName = "小香妞爱熊猫"
        panda257.cover =
            "https://i2.hdslb.com/bfs/archive/40bf73940dfa3ab391bd101c29882820cfde3800.jpg"
        panda257.videoType = 0
        list.add(panda257)


        val panda258 = PetVideo()
        panda258.type = PetType.PANDA.ordinal
        panda258.fileName = "panda_mom_panda258"
        panda258.code = 859
        panda258.duration = 72
        panda258.period = PeriodType.MOM.ordinal
        panda258.isStar = false
        panda258.title = "大熊猫和花：小v脸，曾经拥有过..."
        panda258.releaseTime = "2022-01-01 09:00:08"
        panda258.originalUrl = "https://www.bilibili.com/video/BV1d44y1L7c9"
        panda258.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda258.authorName = "小香妞爱熊猫"
        panda258.cover =
            "https://i0.hdslb.com/bfs/archive/e4feeac89c88839d19930dbc1e5dd6accc1aebab.jpg"
        panda258.videoType = 0
        list.add(panda258)


        val panda259 = PetVideo()
        panda259.type = PetType.PANDA.ordinal
        panda259.fileName = "panda_mom_panda259"
        panda259.code = 860
        panda259.duration = 37
        panda259.period = PeriodType.MOM.ordinal
        panda259.isStar = false
        panda259.title = "大熊猫和花：从小就苦练平衡木的花花选手,鼓掌"
        panda259.releaseTime = "2022-01-03 09:00:01"
        panda259.originalUrl = "https://www.bilibili.com/video/BV1JZ4y1Q7xs"
        panda259.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda259.authorName = "小香妞爱熊猫"
        panda259.cover =
            "https://i0.hdslb.com/bfs/archive/c11b46022ad203ada7e97960f625dd76eb4325a9.jpg"
        panda259.videoType = 0
        list.add(panda259)


        val panda260 = PetVideo()
        panda260.type = PetType.PANDA.ordinal
        panda260.fileName = "panda_mom_panda260"
        panda260.code = 861
        panda260.duration = 131
        panda260.period = PeriodType.MOM.ordinal
        panda260.isStar = false
        panda260.title = "二狗把和花打包进框子里，结果被园润给收拾了"
        panda260.releaseTime = "2021-12-31 19:33:16"
        panda260.originalUrl = "https://www.bilibili.com/video/BV1AM4y1F714"
        panda260.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda260.authorName = "柠夏初开__"
        panda260.cover =
            "https://i1.hdslb.com/bfs/archive/24a8e75b2ad4e163288828370b144627bbd13265.jpg"
        panda260.videoType = 0
        list.add(panda260)


        val panda261 = PetVideo()
        panda261.type = PetType.PANDA.ordinal
        panda261.fileName = "panda_mom_panda261"
        panda261.code = 862
        panda261.duration = 75
        panda261.period = PeriodType.MOM.ordinal
        panda261.isStar = false
        panda261.title = "号外！和花●破竹●了！！速来打call！12.14【大熊猫和花】"
        panda261.releaseTime = "2021-12-16 11:02:20"
        panda261.originalUrl = "https://www.bilibili.com/video/BV1mF411z7ZD"
        panda261.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda261.authorName = "安娜丽丝k"
        panda261.cover =
            "https://i1.hdslb.com/bfs/archive/87ec00466a9efa8dda14767dfc9a312e667a979a.png"
        panda261.videoType = 0
        list.add(panda261)


        val panda262 = PetVideo()
        panda262.type = PetType.PANDA.ordinal
        panda262.fileName = "panda_mom_panda262"
        panda262.code = 863
        panda262.duration = 67
        panda262.period = PeriodType.MOM.ordinal
        panda262.isStar = false
        panda262.title = "莽仔：熊小不要太嚣张，妈咪来教你做熊（莽大）"
        panda262.releaseTime = "2021-12-14 13:09:20"
        panda262.originalUrl = "https://www.bilibili.com/video/BV1m44y1E7xL"
        panda262.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda262.authorName = "丶祀很宔"
        panda262.cover =
            "https://i2.hdslb.com/bfs/archive/eb249a9b498bee568c35489279d5f1808e65845f.jpg"
        panda262.videoType = 0
        list.add(panda262)


        val panda263 = PetVideo()
        panda263.type = PetType.PANDA.ordinal
        panda263.fileName = "panda_mom_panda263"
        panda263.code = 864
        panda263.duration = 49
        panda263.period = PeriodType.MOM.ordinal
        panda263.isStar = false
        panda263.title = "【重庆动物园】莽仔担心娃娃们摔下去，赶紧走上去护住崽，真是好妈妈"
        panda263.releaseTime = "2022-01-09 21:26:04"
        panda263.originalUrl = "https://www.bilibili.com/video/BV1aL4y1b7Ci"
        panda263.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda263.authorName = "丶祀很宔"
        panda263.cover =
            "https://i0.hdslb.com/bfs/archive/0237c1da0701135bba01d1737eafb49f27768705.jpg"
        panda263.videoType = 0
        list.add(panda263)


        val panda264 = PetVideo()
        panda264.type = PetType.PANDA.ordinal
        panda264.fileName = "panda_mom_panda264"
        panda264.code = 865
        panda264.duration = 70
        panda264.period = PeriodType.MOM.ordinal
        panda264.isStar = false
        panda264.title = "绩丽长公主带娃培训班"
        panda264.releaseTime = "2021-06-26 00:41:10"
        panda264.originalUrl = "https://www.bilibili.com/video/BV1364y19745"
        panda264.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda264.authorName = "绩笑笑最可爱啦"
        panda264.cover =
            "https://i1.hdslb.com/bfs/archive/803e26075f2d5362bd8048e54a4e956b671d2b70.jpg"
        panda264.videoType = 0
        list.add(panda264)


        val panda265 = PetVideo()
        panda265.type = PetType.PANDA.ordinal
        panda265.fileName = "panda_mom_panda265"
        panda265.code = 866
        panda265.duration = 63
        panda265.period = PeriodType.MOM.ordinal
        panda265.isStar = false
        panda265.title = "【大熊猫绩丽/绩笑】惹事后逃跑一绝的笑笑"
        panda265.releaseTime = "2020-10-14 23:59:04"
        panda265.originalUrl = "https://www.bilibili.com/video/BV18D4y1d75J"
        panda265.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda265.authorName = "嗯嗯嗯对嗯"
        panda265.cover =
            "https://i2.hdslb.com/bfs/archive/aebc26c6fd2a76f351a0e9fbe2e64dfc57aa78b8.jpg"
        panda265.videoType = 0
        list.add(panda265)


        val panda266 = PetVideo()
        panda266.type = PetType.PANDA.ordinal
        panda266.fileName = "panda_mom_panda266"
        panda266.code = 867
        panda266.duration = 122
        panda266.period = PeriodType.MOM.ordinal
        panda266.isStar = false
        panda266.title = "风风摔下树找绩丽,结果..（大熊猫成风）"
        panda266.releaseTime = "2020-06-26 18:45:41"
        panda266.originalUrl = "https://www.bilibili.com/video/BV1sV411k78W"
        panda266.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda266.authorName = "日常嗑猫C咩酱"
        panda266.cover =
            "https://i0.hdslb.com/bfs/archive/af6e27e0a55df33f22cab0329c67f545d3a75ccc.jpg"
        panda266.videoType = 0
        list.add(panda266)


        val panda267 = PetVideo()
        panda267.type = PetType.PANDA.ordinal
        panda267.fileName = "panda_mom_panda267"
        panda267.code = 868
        panda267.duration = 30
        panda267.period = PeriodType.MOM.ordinal
        panda267.isStar = false
        panda267.title = "【绩丽绩笑】母女大打出手，不欢而散……(^_^＃)"
        panda267.releaseTime = "2020-10-12 20:44:11"
        panda267.originalUrl = "https://www.bilibili.com/video/BV1tK411A73D"
        panda267.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda267.authorName = "白告月笑憨憨"
        panda267.cover =
            "https://i1.hdslb.com/bfs/archive/58e94921c27812e2b0cb04d795c089e5c8b6d066.jpg"
        panda267.videoType = 0
        list.add(panda267)


        val panda268 = PetVideo()
        panda268.type = PetType.PANDA.ordinal
        panda268.fileName = "panda_mom_panda268"
        panda268.code = 869
        panda268.duration = 223
        panda268.period = PeriodType.MOM.ordinal
        panda268.isStar = false
        panda268.title = "绩丽带娃：你们闹可以，但是别在我眼前闹 成大大带娃：你们闹可以，但是要带上我"
        panda268.releaseTime = "2020-07-15 04:01:06"
        panda268.originalUrl = "https://www.bilibili.com/video/BV1LT4y1E7T3"
        panda268.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda268.authorName = "绩笑笑最可爱啦"
        panda268.cover =
            "https://i1.hdslb.com/bfs/archive/cb5ccb348369705ca6812d2189479396d4f08599.jpg"
        panda268.videoType = 0
        list.add(panda268)


        val panda269 = PetVideo()
        panda269.type = PetType.PANDA.ordinal
        panda269.fileName = "panda_mom_panda269"
        panda269.code = 870
        panda269.duration = 55
        panda269.period = PeriodType.MOM.ordinal
        panda269.isStar = false
        panda269.title = "成风成浪：姨姨发疯好阔怕"
        panda269.releaseTime = "2020-06-01 01:22:37"
        panda269.originalUrl = "https://www.bilibili.com/video/BV1La4y1v7nJ"
        panda269.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda269.authorName = "迩後咩"
        panda269.cover =
            "https://i0.hdslb.com/bfs/archive/951f8da82b2c76684eb91bb39d75c4f781bb9ff8.jpg"
        panda269.videoType = 0
        list.add(panda269)


        val panda270 = PetVideo()
        panda270.type = PetType.PANDA.ordinal
        panda270.fileName = "panda_mom_panda270"
        panda270.code = 871
        panda270.duration = 71
        panda270.period = PeriodType.MOM.ordinal
        panda270.isStar = false
        panda270.title = "绝世好妈绩丽，绝世好烦绩美绩兰"
        panda270.releaseTime = "2017-03-06 22:03:36"
        panda270.originalUrl = "https://www.bilibili.com/video/BV1Ax411C7H9"
        panda270.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda270.authorName = "咪呜咪呜酱"
        panda270.cover =
            "https://i1.hdslb.com/bfs/archive/46c0d8c20215e97b5ffea7bf0351682cf3feea7d.png"
        panda270.videoType = 0
        list.add(panda270)


        val panda271 = PetVideo()
        panda271.type = PetType.PANDA.ordinal
        panda271.fileName = "panda_mom_panda271"
        panda271.code = 872
        panda271.duration = 70
        panda271.period = PeriodType.MOM.ordinal
        panda271.isStar = false
        panda271.title = "大雪 绅宾妈妈给双胞胎崽崽喂奶 现场实拍【大熊猫绅宾】"
        panda271.releaseTime = "2020-12-31 11:36:03"
        panda271.originalUrl = "https://www.bilibili.com/video/BV1YX4y1T7NZ"
        panda271.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda271.authorName = "羽川゚"
        panda271.cover =
            "https://i2.hdslb.com/bfs/archive/1191dc93ecedfcb98971647bb82c6cf941b816ef.jpg"
        panda271.videoType = 0
        list.add(panda271)

        val panda272 = PetVideo()
        panda272.type = PetType.PANDA.ordinal
        panda272.fileName = "panda_mom_panda272"
        panda272.code = 873
        panda272.duration = 81
        panda272.period = PeriodType.MOM.ordinal
        panda272.isStar = false
        panda272.title = "花点点神烦麻麻"
        panda272.releaseTime = "2018-01-03 11:48:53"
        panda272.originalUrl = "https://www.bilibili.com/video/BV1TW411B7VX"
        panda272.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda272.authorName = "嗦粉才是正经事"
        panda272.cover =
            "https://i2.hdslb.com/bfs/archive/0f19697f0cb3de2fdc76518d885143d327a0bb9a.jpg"
        panda272.videoType = 0
        list.add(panda272)

        val panda273 = PetVideo()
        panda273.type = PetType.PANDA.ordinal
        panda273.fileName = "panda_mom_panda273"
        panda273.code = 874
        panda273.duration = 49
        panda273.period = PeriodType.MOM.ordinal
        panda273.isStar = false
        panda273.title = "莽大：妈咪快过来拍合照啦～；莽仔：乖，莫闹，睡觉。"
        panda273.releaseTime = "2021-12-29 15:31:07"
        panda273.originalUrl = "https://www.bilibili.com/video/BV1YL4y1E7sW"
        panda273.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda273.authorName = "丶祀很宔"
        panda273.cover =
            "https://i1.hdslb.com/bfs/archive/f40f5eb05737b8570afbfc33f8103d393ea196e2.jpg"
        panda273.videoType = 0
        list.add(panda273)

        val panda274 = PetVideo()
        panda274.type = PetType.PANDA.ordinal
        panda274.fileName = "panda_mom_panda274"
        panda274.code = 875
        panda274.duration = 147
        panda274.period = PeriodType.MOM.ordinal
        panda274.isStar = false
        panda274.title = "霸道小和花"
        panda274.releaseTime = "2021-11-06 18:20:03"
        panda274.originalUrl = "https://www.bilibili.com/video/BV1iL411u7ER"
        panda274.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda274.authorName = "摄影师动物米"
        panda274.cover =
            "https://i0.hdslb.com/bfs/archive/bcdc6aef7eac605bfebfa0100b8595dd356c2703.jpg"
        panda274.videoType = 0
        list.add(panda274)

        val panda275 = PetVideo()
        panda275.type = PetType.PANDA.ordinal
        panda275.fileName = "panda_mom_panda275"
        panda275.code = 876
        panda275.duration = 1084
        panda275.period = PeriodType.MOM.ordinal
        panda275.isStar = false
        panda275.title = "【熊猫和花、熊猫润玥、熊猫园润】永远的菜花园 part2纪录如此温馨的时刻 用procreate画出三只小熊详细流程（一定要看到最后）"
        panda275.releaseTime = "2022-01-09 21:05:35"
        panda275.originalUrl = "https://www.bilibili.com/video/BV14S4y1Z7VH"
        panda275.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda275.authorName = "贴贴小fafa"
        panda275.cover =
            "https://i2.hdslb.com/bfs/archive/a87c3b4649628f433b11484e87239765515b8efa.jpg"
        panda275.videoType = 0
        list.add(panda275)

        val panda276 = PetVideo()
        panda276.type = PetType.PANDA.ordinal
        panda276.fileName = "panda_mom_panda276"
        panda276.code = 1207
        panda276.duration = 25
        panda276.period = PeriodType.MOM.ordinal
        panda276.isStar = false
        panda276.title = "奶爸接和花花去加餐，结果耐着不走的花花变成嗯嗯怪（可爱死了）"
        panda276.releaseTime = "2021-12-22 21:36:48"
        panda276.originalUrl = "https://www.bilibili.com/video/BV1r34y167pD"
        panda276.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda276.authorName = "问杰森英文名字的龙崽"
        panda276.cover =
            "https://i2.hdslb.com/bfs/archive/a59add962c909d36e4fa68325f271baf67f0aa7d.jpg"
        list.add(panda276)

        val panda277 = PetVideo()
        panda277.type = PetType.PANDA.ordinal
        panda277.fileName = "panda_mom_panda277"
        panda277.code = 1208
        panda277.duration = 69
        panda277.period = PeriodType.MOM.ordinal
        panda277.isStar = false
        panda277.title = "【大熊猫和花】迪迪怎么也逃不出花花的世界"
        panda277.releaseTime = "2021-12-27 23:00:19"
        panda277.originalUrl = "https://www.bilibili.com/video/BV1yZ4y1X7t2"
        panda277.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda277.authorName = "小香妞爱熊猫"
        panda277.cover =
            "https://i2.hdslb.com/bfs/archive/4fb795f2978cb7baff8497b04936cf5c65a6113e.jpg"
        list.add(panda277)

        val panda278 = PetVideo()
        panda278.type = PetType.PANDA.ordinal
        panda278.fileName = "panda_mom_panda278"
        panda278.code = 1209
        panda278.duration = 104
        panda278.period = PeriodType.MOM.ordinal
        panda278.isStar = false
        panda278.title = "花姐的主业之二 : 专业卖萌～！！【大熊猫和花】"
        panda278.releaseTime = "2021-12-20 10:23:05"
        panda278.originalUrl = "https://www.bilibili.com/video/BV1A3411x7Lr"
        panda278.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda278.authorName = "安娜丽丝k"
        panda278.cover =
            "https://i0.hdslb.com/bfs/archive/2d150466609e4340df9489e9786f948ddf98a7c7.jpg"
        list.add(panda278)

        val panda279 = PetVideo()
        panda279.type = PetType.PANDA.ordinal
        panda279.fileName = "panda_mom_panda279"
        panda279.code = 1210
        panda279.duration = 100
        panda279.period = PeriodType.MOM.ordinal
        panda279.isStar = false
        panda279.title = "【大熊猫和花】胖能好圆好奶好萌好可爱啊"
        panda279.releaseTime = "2021-12-26 09:52:13"
        panda279.originalUrl = "https://www.bilibili.com/video/BV1Qi4y197HM"
        panda279.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda279.authorName = "爱熊猫aipanda"
        panda279.cover =
            "https://i2.hdslb.com/bfs/archive/ae254811fc422f7116f95ad25109f6618e0845b6.jpg"
        list.add(panda279)

        val panda280 = PetVideo()
        panda280.type = PetType.PANDA.ordinal
        panda280.fileName = "panda_mom_panda280"
        panda280.code = 1211
        panda280.duration = 35
        panda280.period = PeriodType.MOM.ordinal
        panda280.isStar = false
        panda280.title = "大熊猫和花-出现啦！导致国宝被批评的源头！"
        panda280.releaseTime = "2021-12-30 08:35:15"
        panda280.originalUrl = "https://www.bilibili.com/video/BV1644y177Uh"
        panda280.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda280.authorName = "和和和花花"
        panda280.cover =
            "https://i2.hdslb.com/bfs/archive/9b4c30c1fc35c617d0423ee22f622b4178881ed0.jpg"
        list.add(panda280)

        val panda281 = PetVideo()
        panda281.type = PetType.PANDA.ordinal
        panda281.fileName = "panda_mom_panda281"
        panda281.code = 1212
        panda281.duration = 58
        panda281.period = PeriodType.MOM.ordinal
        panda281.isStar = false
        panda281.title = "【大熊猫和花】我成和花专治腿比我长的"
        panda281.releaseTime = "2021-12-23 23:00:13"
        panda281.originalUrl = "https://www.bilibili.com/video/BV1i34y1677Z"
        panda281.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda281.authorName = "小香妞爱熊猫"
        panda281.cover =
            "https://i0.hdslb.com/bfs/archive/a8046d6b39fb771a515aba73086a20465b84cb60.jpg"
        list.add(panda281)

        val panda282 = PetVideo()
        panda282.type = PetType.PANDA.ordinal
        panda282.fileName = "panda_mom_panda282"
        panda282.code = 1213
        panda282.duration = 28
        panda282.period = PeriodType.MOM.ordinal
        panda282.isStar = false
        panda282.title = "【大熊猫和花】花花：竹子是什么？"
        panda282.releaseTime = "2021-12-20 23:00:06"
        panda282.originalUrl = "https://www.bilibili.com/video/BV1yF411q76m"
        panda282.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda282.authorName = "小香妞爱熊猫"
        panda282.cover =
            "https://i1.hdslb.com/bfs/archive/bf13437e9dea431bf3081f807992ef2cc46fcedc.jpg"
        list.add(panda282)

        val panda283 = PetVideo()
        panda283.type = PetType.PANDA.ordinal
        panda283.fileName = "panda_mom_panda283"
        panda283.code = 1214
        panda283.duration = 33
        panda283.period = PeriodType.MOM.ordinal
        panda283.isStar = false
        panda283.title = "花姐的副业之三: 镜头精达熊！！【大熊猫和花】"
        panda283.releaseTime = "2021-12-25 12:23:51"
        panda283.originalUrl = "https://www.bilibili.com/video/BV1am4y197DY"
        panda283.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda283.authorName = "安娜丽丝k"
        panda283.cover =
            "https://i0.hdslb.com/bfs/archive/3ddb90f3ef61e420d63e0c60235025ac983c4657.jpg"
        list.add(panda283)

        val panda284 = PetVideo()
        panda284.type = PetType.PANDA.ordinal
        panda284.fileName = "panda_mom_panda284"
        panda284.code = 1215
        panda284.duration = 34
        panda284.period = PeriodType.MOM.ordinal
        panda284.isStar = false
        panda284.title = "大熊猫和花-散步的小花花"
        panda284.releaseTime = "2021-12-24 18:16:12"
        panda284.originalUrl = "https://www.bilibili.com/video/BV1sZ4y1X7sk"
        panda284.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda284.authorName = "和和和花花"
        panda284.cover =
            "https://i1.hdslb.com/bfs/archive/ba2af87bb76a29742e361594f5516b3a6355ed01.jpg"
        list.add(panda284)

        val panda285 = PetVideo()
        panda285.type = PetType.PANDA.ordinal
        panda285.fileName = "panda_mom_panda285"
        panda285.code = 1216
        panda285.duration = 43
        panda285.period = PeriodType.MOM.ordinal
        panda285.isStar = false
        panda285.title = "【大熊猫和花】花花睡告告，腿腿噗噔噗噔"
        panda285.releaseTime = "2021-12-13 11:58:26"
        panda285.originalUrl = "https://www.bilibili.com/video/BV1Xq4y1q7px"
        panda285.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda285.authorName = "丶祀很宔"
        panda285.cover =
            "https://i2.hdslb.com/bfs/archive/8d7282af264fbf354ba317a74f21487f58f65990.jpg"
        list.add(panda285)

        val panda286 = PetVideo()
        panda286.type = PetType.PANDA.ordinal
        panda286.fileName = "panda_mom_panda286"
        panda286.code = 1217
        panda286.duration = 37
        panda286.period = PeriodType.MOM.ordinal
        panda286.isStar = false
        panda286.title = "【大熊猫和花】迪迪，你看我模仿得像不像"
        panda286.releaseTime = "2021-12-18 23:00:10"
        panda286.originalUrl = "https://www.bilibili.com/video/BV1P44y1J7ZD"
        panda286.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda286.authorName = "小香妞爱熊猫"
        panda286.cover =
            "https://i2.hdslb.com/bfs/archive/360d2960a4f875f107f23412e4ba5f9ad9520fba.jpg"
        list.add(panda286)

        val panda287 = PetVideo()
        panda287.type = PetType.PANDA.ordinal
        panda287.fileName = "panda_mom_panda287"
        panda287.code = 1218
        panda287.duration = 88
        panda287.period = PeriodType.MOM.ordinal
        panda287.isStar = false
        panda287.title = "【大熊猫和花】坚毅与可爱并存的花花"
        panda287.releaseTime = "2021-12-29 12:41:58"
        panda287.originalUrl = "https://www.bilibili.com/video/BV1Lr4y1S71Y"
        panda287.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda287.authorName = "空调轰轰响"
        panda287.cover =
            "https://i2.hdslb.com/bfs/archive/9b76ec1eff9edd94d4c16a488fb6deb91df5c120.jpg"
        list.add(panda287)

        val panda288 = PetVideo()
        panda288.type = PetType.PANDA.ordinal
        panda288.fileName = "panda_mom_panda288"
        panda288.code = 1219
        panda288.duration = 115
        panda288.period = PeriodType.MOM.ordinal
        panda288.isStar = false
        panda288.title = "【大熊猫和花和叶】奶爸抱和花回家，和花嘤嘤嘤反抗无效，和叶屁颠屁颠跟着跑回家"
        panda288.releaseTime = "2022-01-03 22:21:00"
        panda288.originalUrl = "https://www.bilibili.com/video/BV1Gq4y127Kc"
        panda288.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda288.authorName = "青檬鱼看熊猫儿"
        panda288.cover =
            "https://i2.hdslb.com/bfs/archive/face6c111ce0cc7eff91395ca3d9f2621f6ac78e.jpg"
        list.add(panda288)

        val panda289 = PetVideo()
        panda289.type = PetType.PANDA.ordinal
        panda289.fileName = "panda_mom_panda289"
        panda289.code = 1220
        panda289.duration = 64
        panda289.period = PeriodType.MOM.ordinal
        panda289.isStar = false
        panda289.title = "【大熊猫和花】和花：别人吃饭我调皮，我是快乐的小逗比"
        panda289.releaseTime = "2021-12-14 18:23:37"
        panda289.originalUrl = "https://www.bilibili.com/video/BV1Qb4y1i7wX"
        panda289.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda289.authorName = "青檬鱼看熊猫儿"
        panda289.cover =
            "https://i1.hdslb.com/bfs/archive/04aaae2e3b256343d3ab651e87b0c40ced0b8d40.jpg"
        list.add(panda289)

        val panda290 = PetVideo()
        panda290.type = PetType.PANDA.ordinal
        panda290.fileName = "panda_mom_panda290"
        panda290.code = 1221
        panda290.duration = 74
        panda290.period = PeriodType.MOM.ordinal
        panda290.isStar = false
        panda290.title = "莽仔：小兔崽子反了天了啊，妈咪来教你做熊"
        panda290.releaseTime = "2021-12-24 18:36:11"
        panda290.originalUrl = "https://www.bilibili.com/video/BV1fi4y197Ri"
        panda290.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda290.authorName = "丶祀很宔"
        panda290.cover =
            "https://i0.hdslb.com/bfs/archive/41cbbbc1faff59b12aa2a23d99ef8eda306c3d54.jpg"
        list.add(panda290)

        val panda291 = PetVideo()
        panda291.type = PetType.PANDA.ordinal
        panda291.fileName = "panda_mom_panda291"
        panda291.code = 1222
        panda291.duration = 35
        panda291.period = PeriodType.MOM.ordinal
        panda291.isStar = false
        panda291.title = "大熊猫和花-等比长大的小熊只有在有对比的时候才能发现她到底多大只"
        panda291.releaseTime = "2022-01-01 14:16:59"
        panda291.originalUrl = "https://www.bilibili.com/video/BV1oR4y137cm"
        panda291.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda291.authorName = "和和和花花"
        panda291.cover =
            "https://i2.hdslb.com/bfs/archive/9712f321db6d7aa28fc1a7c3c76175dae82bb41d.jpg"
        list.add(panda291)

        val panda292 = PetVideo()
        panda292.type = PetType.PANDA.ordinal
        panda292.fileName = "panda_mom_panda292"
        panda292.code = 1223
        panda292.duration = 64
        panda292.period = PeriodType.MOM.ordinal
        panda292.isStar = false
        panda292.title = "【大熊猫和花】软萌的花花躺吃笋笋"
        panda292.releaseTime = "2022-02-07 00:12:23"
        panda292.originalUrl = "https://www.bilibili.com/video/BV1ub4y177rc"
        panda292.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda292.authorName = "青檬鱼看熊猫儿"
        panda292.cover =
            "https://i0.hdslb.com/bfs/archive/07e596ee181151d4af15276580583fa75e6abd55.jpg"
        list.add(panda292)

        val panda293 = PetVideo()
        panda293.type = PetType.PANDA.ordinal
        panda293.fileName = "panda_mom_panda293"
        panda293.code = 1224
        panda293.duration = 95
        panda293.period = PeriodType.MOM.ordinal
        panda293.isStar = false
        panda293.title = "《 冰 墩 墩 的 制 作 办 法 瞒 不 住 了 》"
        panda293.releaseTime = "2022-02-09 19:49:53"
        panda293.originalUrl = "https://www.bilibili.com/video/BV1KS4y1C7u4"
        panda293.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda293.authorName = "Pandaful熊猫社区"
        panda293.cover =
            "https://i1.hdslb.com/bfs/archive/292c7558ade450298b9fc2227c362b82025cdee7.jpg"
        list.add(panda293)

        val panda294 = PetVideo()
        panda294.type = PetType.PANDA.ordinal
        panda294.fileName = "panda_mom_panda294"
        panda294.code = 1225
        panda294.duration = 63
        panda294.period = PeriodType.MOM.ordinal
        panda294.isStar = false
        panda294.title = "大滚滚抱小滚滚一起滚滚【帼平平】"
        panda294.releaseTime = "2022-02-09 09:30:12"
        panda294.originalUrl = "https://www.bilibili.com/video/BV1pP4y1P7Po"
        panda294.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda294.authorName = "迩後咩"
        panda294.cover =
            "https://i1.hdslb.com/bfs/archive/7418c593c4bd32db0f3f92c64a1a8bd573c95d0c.jpg"
        list.add(panda294)

        val panda295 = PetVideo()
        panda295.type = PetType.PANDA.ordinal
        panda295.fileName = "panda_mom_panda295"
        panda295.code = 1226
        panda295.duration = 82
        panda295.period = PeriodType.MOM.ordinal
        panda295.isStar = false
        panda295.title = "【重庆动物园】莽辰辰：妈咪非要在坑里rua我"
        panda295.releaseTime = "2022-02-10 12:04:07"
        panda295.originalUrl = "https://www.bilibili.com/video/BV15b4y177kh"
        panda295.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda295.authorName = "丶祀很宔"
        panda295.cover =
            "https://i2.hdslb.com/bfs/archive/3b0bfcfe41ef6bbcf8258d6702042744948692f6.jpg"
        list.add(panda295)

        val panda296 = PetVideo()
        panda296.type = PetType.PANDA.ordinal
        panda296.fileName = "panda_mom_panda296"
        panda296.code = 1227
        panda296.duration = 65
        panda296.period = PeriodType.MOM.ordinal
        panda296.isStar = false
        panda296.title = "【大熊猫和花】猫猫虫蠕动翻身，叼起一根笋开吃，努力证明自己不是假吃"
        panda296.releaseTime = "2022-02-04 14:33:58"
        panda296.originalUrl = "https://www.bilibili.com/video/BV1Vr4y1h7Ve"
        panda296.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda296.authorName = "地主家的小胖墩"
        panda296.cover =
            "https://i1.hdslb.com/bfs/archive/390e5dde45dc9cff2dba0fb25cb955f3e7d7643c.jpg"
        list.add(panda296)

        val panda297 = PetVideo()
        panda297.type = PetType.PANDA.ordinal
        panda297.fileName = "panda_mom_panda297"
        panda297.code = 1228
        panda297.duration = 67
        panda297.period = PeriodType.MOM.ordinal
        panda297.isStar = false
        panda297.title = "【重庆动物园】星星辰辰找好位置开始喝奶了"
        panda297.releaseTime = "2022-02-07 12:14:13"
        panda297.originalUrl = "https://www.bilibili.com/video/BV19b4y1j7Jp"
        panda297.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda297.authorName = "丶祀很宔"
        panda297.cover =
            "https://i2.hdslb.com/bfs/archive/d1dd87d0da434833c6ec52570607652a61fce49b.jpg"
        list.add(panda297)

        val panda298 = PetVideo()
        panda298.type = PetType.PANDA.ordinal
        panda298.fileName = "panda_mom_panda298"
        panda298.code = 1229
        panda298.duration = 77
        panda298.period = PeriodType.MOM.ordinal
        panda298.isStar = false
        panda298.title = "【重庆动物园】莽仔妈咪来劝架啦"
        panda298.releaseTime = "2022-02-06 12:51:43"
        panda298.originalUrl = "https://www.bilibili.com/video/BV19L4y1W7PF"
        panda298.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda298.authorName = "丶祀很宔"
        panda298.cover =
            "https://i0.hdslb.com/bfs/archive/cc766cefdd7515a6d1418f652bd91ecbbed4e956.jpg"
        list.add(panda298)

        val panda299 = PetVideo()
        panda299.type = PetType.PANDA.ordinal
        panda299.fileName = "panda_mom_panda299"
        panda299.code = 1371
        panda299.duration = 28
        panda299.period = PeriodType.MOM.ordinal
        panda299.isStar = false
        panda299.title = "【大熊猫和花】可爱小宝贝花花"
        panda299.releaseTime = "2022-02-11 10:35:00"
        panda299.originalUrl = "https://www.bilibili.com/video/BV1F34y1C7aH"
        panda299.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda299.authorName = "小嗷嗷妹妹"
        panda299.cover =
            "https://i2.hdslb.com/bfs/archive/3acd684081e81cf3b0d00df7a90a59bdd6fa9e3d.jpg"
        list.add(panda299)

        val panda300 = PetVideo()
        panda300.type = PetType.PANDA.ordinal
        panda300.fileName = "panda_mom_panda300"
        panda300.code = 1372
        panda300.duration = 132
        panda300.period = PeriodType.MOM.ordinal
        panda300.isStar = false
        panda300.title = "【莽星星莽辰辰】两个臭小子，不要打扰你妈吃饭！"
        panda300.releaseTime = "2022-02-13 20:33:20"
        panda300.originalUrl = "https://www.bilibili.com/video/BV1Ku411R7D1"
        panda300.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda300.authorName = "猴哥某熊铁锤都退役了"
        panda300.cover =
            "https://i2.hdslb.com/bfs/archive/f69f374f220aae94b26f8d01f2205259797c5078.jpg"
        list.add(panda300)

        val panda301 = PetVideo()
        panda301.type = PetType.PANDA.ordinal
        panda301.fileName = "panda_mom_panda301"
        panda301.code = 1373
        panda301.duration = 61
        panda301.period = PeriodType.MOM.ordinal
        panda301.isStar = false
        panda301.title = "【重庆动物园】好奇：我的好大儿每天只上一分钟的班，看完就散了把"
        panda301.releaseTime = "2022-02-12 12:24:54"
        panda301.originalUrl = "https://www.bilibili.com/video/BV1ZS4y1G7QT"
        panda301.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda301.authorName = "丶祀很宔"
        panda301.cover =
            "https://i0.hdslb.com/bfs/archive/964a041d27f8e1e4e4e991e175a572a4aca3c93a.jpg"
        list.add(panda301)

        val panda302 = PetVideo()
        panda302.type = PetType.PANDA.ordinal
        panda302.fileName = "panda_mom_panda302"
        panda302.code = 1374
        panda302.duration = 68
        panda302.period = PeriodType.MOM.ordinal
        panda302.isStar = false
        panda302.title = "【大熊猫莽仔】莽妞妞带崽辛苦啦，多吃点"
        panda302.releaseTime = "2022-01-26 21:55:53"
        panda302.originalUrl = "https://www.bilibili.com/video/BV1B44y1s7rq"
        panda302.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda302.authorName = "丶祀很宔"
        panda302.cover =
            "https://i1.hdslb.com/bfs/archive/e05026998dfdeb7e79f8f3d0f8b58e86b9333025.jpg"
        list.add(panda302)

        val panda303 = PetVideo()
        panda303.type = PetType.PANDA.ordinal
        panda303.fileName = "panda_mom_panda303"
        panda303.code = 1375
        panda303.duration = 259
        panda303.period = PeriodType.MOM.ordinal
        panda303.isStar = false
        panda303.title = "【大熊猫和花】下雨天，花花啃小树枝"
        panda303.releaseTime = "2022-02-11 21:06:30"
        panda303.originalUrl = "https://www.bilibili.com/video/BV1TR4y177jD"
        panda303.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda303.authorName = "朙雨"
        panda303.cover =
            "https://i2.hdslb.com/bfs/archive/5030bbf0981f7c3352c54ff5be66243a4f21c6ff.jpg"
        list.add(panda303)

        val panda304 = PetVideo()
        panda304.type = PetType.PANDA.ordinal
        panda304.fileName = "panda_mom_panda304"
        panda304.code = 1376
        panda304.duration = 91
        panda304.period = PeriodType.MOM.ordinal
        panda304.isStar = false
        panda304.title = "【重庆动物园】真是两熊孩子，莽仔妈咪操碎了心"
        panda304.releaseTime = "2022-02-11 12:12:23"
        panda304.originalUrl = "https://www.bilibili.com/video/BV1kb4y177fV"
        panda304.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
        panda304.authorName = "丶祀很宔"
        panda304.cover =
            "https://i0.hdslb.com/bfs/archive/aac89c0ed80b56c09f1896fa006910d5d5b7dd41.jpg"
        list.add(panda304)


        return list
    }
}