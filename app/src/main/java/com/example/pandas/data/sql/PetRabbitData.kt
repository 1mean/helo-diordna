package com.example.pandas.data.sql

import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.entity.PetVideo

object PetRabbitData {
    private val list = mutableListOf<PetVideo>()
    fun getAll(): MutableList<PetVideo> {
        getRabbitData()
        return list
    }

    private fun getRabbitData(): MutableList<PetVideo> {

        val rabbit1 = PetVideo()
        rabbit1.type = VideoType.RABBIT.ordinal
        rabbit1.fileName = "rabbit_1"
        rabbit1.code = 3592
        rabbit1.duration = 11
        rabbit1.star = true
        rabbit1.vertical = true
        rabbit1.title = "放我下来，我要生气了"
        rabbit1.releaseTime = 1624951194
        rabbit1.originalUrl = "https://www.bilibili.com/video/BV1E64y1Q7vK"
        rabbit1.tags = "猫咪"
        rabbit1.authorId = 404598860
        rabbit1.cover =
            "https://i2.hdslb.com/bfs/archive/2ac141479631186ba89a4cc27221b2f63c5f6ef9.jpg"
        list.add(rabbit1)

        val rabbit2 = PetVideo()
        rabbit2.type = VideoType.RABBIT.ordinal
        rabbit2.fileName = "rabbit_2"
        rabbit2.code = 3593
        rabbit2.duration = 31
        rabbit2.star = true
        rabbit2.vertical = false
        rabbit2.title = "一只小可爱朝你奔来"
        rabbit2.releaseTime = 1661950770
        rabbit2.originalUrl = "https://www.bilibili.com/video/BV1bD4y1B7Po"
        rabbit2.tags = "兔兔"
        rabbit2.authorId = 1796815902
        rabbit2.cover =
            "https://i2.hdslb.com/bfs/archive/7a5deb90d480fe862da5134277471aa918efa853.jpg"
        list.add(rabbit2)

        val rabbit3 = PetVideo()
        rabbit3.type = VideoType.RABBIT.ordinal
        rabbit3.fileName = "rabbit_3"
        rabbit3.code = 3594
        rabbit3.duration = 18
        rabbit3.star = true
        rabbit3.vertical = false
        rabbit3.title = "小兔子们集体放风啦"
        rabbit3.releaseTime = 1661272875
        rabbit3.originalUrl = "https://www.bilibili.com/video/BV1LB4y157VM"
        rabbit3.tags = "兔兔"
        rabbit3.authorId = 1993553865
        rabbit3.cover =
            "https://i2.hdslb.com/bfs/archive/3b173c13a64bb5294b6f89f36fd751a04057e12d.jpg"
        list.add(rabbit3)

//        val rabbit4 = PetVideo()
//        rabbit4.type = VideoType.RABBIT.ordinal
//        rabbit4.fileName = "rabbit_4"
//        rabbit4.code = 3595
//        rabbit4.duration = 31
//        rabbit4.star = true
//        rabbit4.vertical = false
//        rabbit4.title = "已失效视频"
//        rabbit4.releaseTime = 1662889279
//        rabbit4.originalUrl = "https://www.bilibili.com/video/BV13e4y1a77U"
//        rabbit4.tags = "兔兔"
//        rabbit4.authorId = 66008990
//        rabbit4.cover =
//            "https://i0.hdslb.com/bfs/archive/be27fd62c99036dce67efface486fb0a88ffed06.jpg"
//        list.add(rabbit4)

        val rabbit5 = PetVideo()
        rabbit5.type = VideoType.RABBIT.ordinal
        rabbit5.fileName = "rabbit_5"
        rabbit5.code = 3596
        rabbit5.duration = 155
        rabbit5.star = true
        rabbit5.vertical = false
        rabbit5.title = "兔兔这么可爱"
        rabbit5.releaseTime = 1641575421
        rabbit5.originalUrl = "https://www.bilibili.com/video/BV1HL4y1b7TR"
        rabbit5.tags = "兔兔"
        rabbit5.authorId = 22342583
        rabbit5.cover =
            "https://i1.hdslb.com/bfs/archive/7e95f765cf3e5d2b48362f121061ea37b032d6e8.jpg"
        list.add(rabbit5)

        val rabbit6 = PetVideo()
        rabbit6.type = VideoType.RABBIT.ordinal
        rabbit6.fileName = "rabbit_6"
        rabbit6.code = 3597
        rabbit6.duration = 20
        rabbit6.star = true
        rabbit6.vertical = false
        rabbit6.title = "胖胖和孩纸"
        rabbit6.releaseTime = 1651414435
        rabbit6.originalUrl = "https://www.bilibili.com/video/BV1Fu411r7Qp"
        rabbit6.tags = "兔兔"
        rabbit6.authorId = 1993553865
        rabbit6.cover =
            "https://i2.hdslb.com/bfs/archive/079a06085c4cb987b39f94eae6e0506848b4df9c.jpg"
        list.add(rabbit6)

        val rabbit7 = PetVideo()
        rabbit7.type = VideoType.RABBIT.ordinal
        rabbit7.fileName = "rabbit_7"
        rabbit7.code = 3598
        rabbit7.duration = 24
        rabbit7.star = true
        rabbit7.vertical = false
        rabbit7.title = "胖胖亲了一口宝宝"
        rabbit7.releaseTime = 1648035946
        rabbit7.originalUrl = "https://www.bilibili.com/video/BV1DZ4y1B7Ve"
        rabbit7.tags = "兔兔"
        rabbit7.authorId = 1993553865
        rabbit7.cover =
            "https://i1.hdslb.com/bfs/archive/6e637d9d78f98257bde86904b09067eab17725e9.jpg"
        list.add(rabbit7)

        val rabbit8 = PetVideo()
        rabbit8.type = VideoType.RABBIT.ordinal
        rabbit8.fileName = "rabbit_8"
        rabbit8.code = 3599
        rabbit8.duration = 13
        rabbit8.star = true
        rabbit8.vertical = false
        rabbit8.title = "胖胖和胖丁"
        rabbit8.releaseTime = 1663073175
        rabbit8.originalUrl = "https://www.bilibili.com/video/BV1FP411H7zo"
        rabbit8.tags = "兔兔"
        rabbit8.authorId = 1993553865
        rabbit8.cover =
            "https://i0.hdslb.com/bfs/archive/fee71c2bccb53ffe7e62c4856941227da7d13918.jpg"
        list.add(rabbit8)

        val rabbit9 = PetVideo()
        rabbit9.type = VideoType.RABBIT.ordinal
        rabbit9.fileName = "rabbit_9"
        rabbit9.code = 3600
        rabbit9.duration = 73
        rabbit9.star = true
        rabbit9.vertical = false
        rabbit9.title = "展示一下我的小兔叽！祝大家中秋节快乐呀～   （我是摄影师还没有出镜）"
        rabbit9.releaseTime = 1662820403
        rabbit9.originalUrl = "https://www.bilibili.com/video/BV1it4y1L7hT"
        rabbit9.tags = "兔兔"
        rabbit9.authorId = 510451321
        rabbit9.cover =
            "https://i0.hdslb.com/bfs/archive/6007a1073f2f1d8d88f88fb37cc190829392aee9.jpg"
        list.add(rabbit9)

        val rabbit10 = PetVideo()
        rabbit10.type = VideoType.RABBIT.ordinal
        rabbit10.fileName = "rabbit_10"
        rabbit10.code = 3601
        rabbit10.duration = 29
        rabbit10.star = true
        rabbit10.vertical = false
        rabbit10.title = "一大波小可爱来袭"
        rabbit10.releaseTime = 1659796087
        rabbit10.originalUrl = "https://www.bilibili.com/video/BV1rG411b7Vt"
        rabbit10.tags = "兔兔"
        rabbit10.authorId = 1993553865
        rabbit10.cover =
            "https://i0.hdslb.com/bfs/archive/a2a54e16f3d70a7079c35812220bd011dc969c65.jpg"
        list.add(rabbit10)

        val rabbit11 = PetVideo()
        rabbit11.type = VideoType.RABBIT.ordinal
        rabbit11.fileName = "rabbit_11"
        rabbit11.code = 3602
        rabbit11.duration = 16
        rabbit11.star = true
        rabbit11.vertical = false
        rabbit11.title = "白色小垂耳"
        rabbit11.releaseTime = 1634366630
        rabbit11.originalUrl = "https://www.bilibili.com/video/BV1jf4y1g7c3"
        rabbit11.tags = "兔兔"
        rabbit11.authorId = 1970124143
        rabbit11.cover =
            "https://i1.hdslb.com/bfs/archive/0f5d0ce16fd61693cce6b50d3d2eb6f851c0041b.jpg"
        list.add(rabbit11)

        val rabbit12 = PetVideo()
        rabbit12.type = VideoType.RABBIT.ordinal
        rabbit12.fileName = "rabbit_12"
        rabbit12.code = 3603
        rabbit12.duration = 61
        rabbit12.star = true
        rabbit12.vertical = false
        rabbit12.title = "【兔子】吃成这个样子😂笑死了"
        rabbit12.releaseTime = 1597756941
        rabbit12.originalUrl = "https://www.bilibili.com/video/BV1Xf4y197Ki"
        rabbit12.tags = "兔兔"
        rabbit12.authorId = 319744193
        rabbit12.cover =
            "https://i1.hdslb.com/bfs/archive/f42125ceca03ebd11be4e935de99fe29987db7c9.jpg"
        list.add(rabbit12)

        val rabbit13 = PetVideo()
        rabbit13.type = VideoType.RABBIT.ordinal
        rabbit13.fileName = "rabbit_13"
        rabbit13.code = 3604
        rabbit13.duration = 42
        rabbit13.star = true
        rabbit13.vertical = false
        rabbit13.title = "兔兔洗脸，洗了，但没完全洗"
        rabbit13.releaseTime = 1659784632
        rabbit13.originalUrl = "https://www.bilibili.com/video/BV1qT411L7nh"
        rabbit13.tags = "兔兔"
        rabbit13.authorId = 1479905
        rabbit13.cover =
            "https://i0.hdslb.com/bfs/archive/3791cfcb256ca193a769f0a0d6c3be95e1893c1e.jpg"
        list.add(rabbit13)

        val rabbit14 = PetVideo()
        rabbit14.type = VideoType.RABBIT.ordinal
        rabbit14.fileName = "rabbit_14"
        rabbit14.code = 3605
        rabbit14.duration = 51
        rabbit14.star = true
        rabbit14.vertical = false
        rabbit14.title = "小兔沉浸式炫草"
        rabbit14.releaseTime = 1659430800
        rabbit14.originalUrl = "https://www.bilibili.com/video/BV1zB4y147Gb"
        rabbit14.tags = "兔兔"
        rabbit14.authorId = 1020422022
        rabbit14.cover =
            "https://i2.hdslb.com/bfs/archive/a27ef9eb9bf7e2a376850de36e08838e281caccc.jpg"
        list.add(rabbit14)

        val rabbit15 = PetVideo()
        rabbit15.type = VideoType.RABBIT.ordinal
        rabbit15.fileName = "rabbit_15"
        rabbit15.code = 3606
        rabbit15.duration = 25
        rabbit15.star = true
        rabbit15.vertical = false
        rabbit15.title = "宝宝们出来玩了"
        rabbit15.releaseTime = 1659016087
        rabbit15.originalUrl = "https://www.bilibili.com/video/BV1FF411A71R"
        rabbit15.tags = "兔兔"
        rabbit15.authorId = 1993553865
        rabbit15.cover =
            "https://i1.hdslb.com/bfs/archive/3bd3f44817174d6d473781f3fd944bc7c8f51d4b.jpg"
        list.add(rabbit15)

        val rabbit16 = PetVideo()
        rabbit16.type = VideoType.RABBIT.ordinal
        rabbit16.fileName = "rabbit_16"
        rabbit16.code = 3607
        rabbit16.duration = 13
        rabbit16.star = true
        rabbit16.vertical = false
        rabbit16.title = "不可以色色！"
        rabbit16.releaseTime = 1645236464
        rabbit16.originalUrl = "https://www.bilibili.com/video/BV1Ai4y127Mk"
        rabbit16.tags = "兔兔"
        rabbit16.authorId = 21229597
        rabbit16.cover =
            "https://i2.hdslb.com/bfs/archive/3882d4dd5b2b82cecec4b2d827a8414d4f5837b4.jpg"
        list.add(rabbit16)

        val rabbit17 = PetVideo()
        rabbit17.type = VideoType.RABBIT.ordinal
        rabbit17.fileName = "rabbit_17"
        rabbit17.code = 3608
        rabbit17.duration = 40
        rabbit17.star = true
        rabbit17.vertical = false
        rabbit17.title = "欺负小圆面包bonbon"
        rabbit17.releaseTime = 1647847432
        rabbit17.originalUrl = "https://www.bilibili.com/video/BV1GP4y1T7Kv"
        rabbit17.tags = "兔兔"
        rabbit17.authorId = 21229597
        rabbit17.cover =
            "https://i2.hdslb.com/bfs/archive/77114cc78c1fdc9a18fef7f9a6f88d2277e9bd55.jpg"
        list.add(rabbit17)

        val rabbit18 = PetVideo()
        rabbit18.type = VideoType.RABBIT.ordinal
        rabbit18.fileName = "rabbit_18"
        rabbit18.code = 3609
        rabbit18.duration = 33
        rabbit18.star = true
        rabbit18.vertical = false
        rabbit18.title = "这是怀了？"
        rabbit18.releaseTime = 1649923474
        rabbit18.originalUrl = "https://www.bilibili.com/video/BV1wA4y1R7HK"
        rabbit18.tags = "兔兔"
        rabbit18.authorId = 391581564
        rabbit18.cover =
            "https://i0.hdslb.com/bfs/archive/70c6adb8ecb2e449371a3b48f7585a99aba11083.jpg"
        list.add(rabbit18)

        val rabbit19 = PetVideo()
        rabbit19.type = VideoType.RABBIT.ordinal
        rabbit19.fileName = "rabbit_19"
        rabbit19.code = 3610
        rabbit19.duration = 14
        rabbit19.star = true
        rabbit19.vertical = false
        rabbit19.title = "兔兔睡觉"
        rabbit19.releaseTime = 1653871504
        rabbit19.originalUrl = "https://www.bilibili.com/video/BV1wa41177n8"
        rabbit19.tags = "兔兔"
        rabbit19.authorId = 193046
        rabbit19.cover =
            "https://i0.hdslb.com/bfs/archive/5cb4d925a2b12364d881bc561ace85a1eea208d8.jpg"
        list.add(rabbit19)

        val rabbit20 = PetVideo()
        rabbit20.type = VideoType.RABBIT.ordinal
        rabbit20.fileName = "rabbit_20"
        rabbit20.code = 3611
        rabbit20.duration = 11
        rabbit20.star = true
        rabbit20.vertical = false
        rabbit20.title = "你一定没听过兔子的叫声"
        rabbit20.releaseTime = 1639731893
        rabbit20.originalUrl = "https://www.bilibili.com/video/BV1gF41167aU"
        rabbit20.tags = "兔兔"
        rabbit20.authorId = 596111781
        rabbit20.cover =
            "https://i1.hdslb.com/bfs/archive/5b95f4b46dac93324d63710183e8460a91e165b7.jpg"
        list.add(rabbit20)

        val rabbit21 = PetVideo()
        rabbit21.type = VideoType.RABBIT.ordinal
        rabbit21.fileName = "rabbit_21"
        rabbit21.code = 3612
        rabbit21.duration = 17
        rabbit21.star = true
        rabbit21.vertical = false
        rabbit21.title = "表演一个兔兔生气"
        rabbit21.releaseTime = 1652168602
        rabbit21.originalUrl = "https://www.bilibili.com/video/BV1DT4y167dX"
        rabbit21.tags = "兔兔"
        rabbit21.authorId = 98084457
        rabbit21.cover =
            "https://i2.hdslb.com/bfs/archive/e21e61691d6ff938049c4648d99c10434fda029f.jpg"
        list.add(rabbit21)

        val rabbit22 = PetVideo()
        rabbit22.type = VideoType.RABBIT.ordinal
        rabbit22.fileName = "rabbit_22"
        rabbit22.code = 3613
        rabbit22.duration = 42
        rabbit22.star = true
        rabbit22.vertical = false
        rabbit22.title = "兔兔特写镜头！糯米团子兔星人( ･᷄ὢ･᷅ )也太可爱了吧！"
        rabbit22.releaseTime = 1652596846
        rabbit22.originalUrl = "https://www.bilibili.com/video/BV1LZ4y187aw"
        rabbit22.tags = "兔兔"
        rabbit22.authorId = 14569053
        rabbit22.cover =
            "https://i0.hdslb.com/bfs/archive/7f4dc4c28bb0976d48facc0e56d35add80b833d4.jpg"
        list.add(rabbit22)

        val rabbit23 = PetVideo()
        rabbit23.type = VideoType.RABBIT.ordinal
        rabbit23.fileName = "rabbit_23"
        rabbit23.code = 3614
        rabbit23.duration = 91
        rabbit23.star = true
        rabbit23.vertical = false
        rabbit23.title = "（超小体兔兔的日常）妈妈太凶了！哼！找干妈去玩！"
        rabbit23.releaseTime = 1650250787
        rabbit23.originalUrl = "https://www.bilibili.com/video/BV1w34y1i7Af"
        rabbit23.tags = "兔兔"
        rabbit23.authorId = 14569053
        rabbit23.cover =
            "https://i1.hdslb.com/bfs/archive/02a05dd10ea06b8705675630a8e2fde9b87ff452.jpg"
        list.add(rabbit23)

        val rabbit24 = PetVideo()
        rabbit24.type = VideoType.RABBIT.ordinal
        rabbit24.fileName = "rabbit_24"
        rabbit24.code = 3615
        rabbit24.duration = 110
        rabbit24.star = true
        rabbit24.vertical = false
        rabbit24.title = "初生兔兔不怕猫"
        rabbit24.releaseTime = 1636681933
        rabbit24.originalUrl = "https://www.bilibili.com/video/BV1Vr4y1y7hJ"
        rabbit24.tags = "兔兔"
        rabbit24.authorId = 574344960
        rabbit24.cover =
            "https://i0.hdslb.com/bfs/archive/83b9d9bd057f666ff2c8674470808f54c1a68a11.jpg"
        list.add(rabbit24)

        val rabbit25 = PetVideo()
        rabbit25.type = VideoType.RABBIT.ordinal
        rabbit25.fileName = "rabbit_25"
        rabbit25.code = 3616
        rabbit25.duration = 148
        rabbit25.star = true
        rabbit25.vertical = false
        rabbit25.title = "小乖乖兔萌翻了"
        rabbit25.releaseTime = 1636547364
        rabbit25.originalUrl = "https://www.bilibili.com/video/BV14F411Y7rV"
        rabbit25.tags = "兔兔"
        rabbit25.authorId = 574344960
        rabbit25.cover =
            "https://i1.hdslb.com/bfs/archive/3cdf0c4b3da4fd4250ec611099d16664dc870877.jpg"
        list.add(rabbit25)

        val rabbit26 = PetVideo()
        rabbit26.type = VideoType.RABBIT.ordinal
        rabbit26.fileName = "rabbit_26"
        rabbit26.code = 3617
        rabbit26.duration = 32
        rabbit26.star = true
        rabbit26.vertical = false
        rabbit26.title = "这俩整天亲来舔去的"
        rabbit26.releaseTime = 1634174966
        rabbit26.originalUrl = "https://www.bilibili.com/video/BV1dh411J7uM"
        rabbit26.tags = "兔兔"
        rabbit26.authorId = 1973810190
        rabbit26.cover =
            "https://i2.hdslb.com/bfs/archive/ed3237a90230b1643b40a6f4c4324022fc0ca4b3.jpg"
        list.add(rabbit26)

        val rabbit27 = PetVideo()
        rabbit27.type = VideoType.RABBIT.ordinal
        rabbit27.fileName = "rabbit_27"
        rabbit27.code = 3618
        rabbit27.duration = 58
        rabbit27.star = true
        rabbit27.vertical = false
        rabbit27.title = "小兔兔坐着吃草"
        rabbit27.releaseTime = 1653963058
        rabbit27.originalUrl = "https://www.bilibili.com/video/BV1ig411R7yr"
        rabbit27.tags = "兔兔"
        rabbit27.authorId = 509795633
        rabbit27.cover =
            "https://i1.hdslb.com/bfs/archive/1ef44d2940382ca659dc8a07fcb40e7042161d2f.jpg"
        list.add(rabbit27)

        val rabbit28 = PetVideo()
        rabbit28.type = VideoType.RABBIT.ordinal
        rabbit28.fileName = "rabbit_28"
        rabbit28.code = 3619
        rabbit28.duration = 29
        rabbit28.star = true
        rabbit28.vertical = false
        rabbit28.title = "天呐！太可爱了，好久没有rua小幼兔，duangduangduang( ･᷄ὢ･᷅ )"
        rabbit28.releaseTime = 1651318070
        rabbit28.originalUrl = "https://www.bilibili.com/video/BV1Pi4y1U7iz"
        rabbit28.tags = "兔兔"
        rabbit28.authorId = 14569053
        rabbit28.cover =
            "https://i1.hdslb.com/bfs/archive/7db8b398f79f4c39e150caa88eee01791a49e8ac.jpg"
        list.add(rabbit28)

        val rabbit29 = PetVideo()
        rabbit29.type = VideoType.RABBIT.ordinal
        rabbit29.fileName = "rabbit_29"
        rabbit29.code = 3620
        rabbit29.duration = 16
        rabbit29.star = true
        rabbit29.vertical = false
        rabbit29.title = "它啃我！"
        rabbit29.releaseTime = 1644590758
        rabbit29.originalUrl = "https://www.bilibili.com/video/BV1ri4y1f7f4"
        rabbit29.tags = "兔兔"
        rabbit29.authorId = 21229597
        rabbit29.cover =
            "https://i1.hdslb.com/bfs/archive/221d3c1e217dffe2bb620195fe701a3a88024467.jpg"
        list.add(rabbit29)

        val rabbit30 = PetVideo()
        rabbit30.type = VideoType.RABBIT.ordinal
        rabbit30.fileName = "rabbit_30"
        rabbit30.code = 3621
        rabbit30.duration = 50
        rabbit30.star = true
        rabbit30.vertical = false
        rabbit30.title = "小兔子睡觉"
        rabbit30.releaseTime = 1659975321
        rabbit30.originalUrl = "https://www.bilibili.com/video/BV1uW4y1Y7sE"
        rabbit30.tags = "兔兔"
        rabbit30.authorId = 1222783105
        rabbit30.cover =
            "https://i2.hdslb.com/bfs/archive/2e88df207125af2d081e112b516f1d9b7b814352.jpg"
        list.add(rabbit30)


        return list
    }
}