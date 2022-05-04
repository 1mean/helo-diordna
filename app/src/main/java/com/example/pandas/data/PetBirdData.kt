package com.example.pandas.data

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object PetBirdData {
    private val list = mutableListOf<PetVideo>()
    fun getPetBirdData(): MutableList<PetVideo> {
        val bird1 = PetVideo()
        bird1.type = VideoType.BIRD.ordinal
        bird1.fileName = "bird1"
        bird1.code = 877
        bird1.duration = 113
        bird1.isStar = true
        bird1.title = "鹦鹉妈妈给树洞中的两只小鹦鹉喂食"
        bird1.releaseTime = "2022-02-04 22:54:11"
        bird1.originalUrl = "https://www.bilibili.com/video/BV1ga411y7uR"
        bird1.tags = "鸟,萌宠"
        bird1.authorId = 415315637
        bird1.cover =
            "https://i2.hdslb.com/bfs/archive/ccefab89a28466761ae74acb6e3e6ecd7193b157.jpg"
        bird1.videoType = 0
        list.add(bird1)

        val bird2 = PetVideo()
        bird2.type = VideoType.BIRD.ordinal
        bird2.fileName = "bird2"
        bird2.code = 878
        bird2.duration = 133
        bird2.isStar = true
        bird2.title = "新年最喜欢的8种鸟叫声：八哥说恭喜发财，金鸡报喜，喜鹊报喜"
        bird2.releaseTime = "2022-02-02 20:42:37"
        bird2.originalUrl = "https://www.bilibili.com/video/BV1m44y1p7Tt"
        bird2.tags = "鸟,萌宠"
        bird2.authorId = 354022352
        bird2.cover =
            "https://i2.hdslb.com/bfs/archive/0965af132bcf1ad6edda79215167f90d7ebc8cae.jpg"
        bird2.videoType = 0
        list.add(bird2)

        val bird3 = PetVideo()
        bird3.type = VideoType.BIRD.ordinal
        bird3.fileName = "bird3"
        bird3.code = 879
        bird3.duration = 13
        bird3.isStar = true
        bird3.title = "太原白鹭4K让你看个清楚够"
        bird3.releaseTime = "2022-01-29 23:19:19"
        bird3.originalUrl = "https://www.bilibili.com/video/BV1kS4y1L7Fo"
        bird3.tags = "鸟,萌宠"
        bird3.authorId = 229878172
        bird3.cover =
            "https://i2.hdslb.com/bfs/archive/7e4d79c66f22e8f0565cf2122c2248d95e17a557.jpg"
        bird3.videoType = 0
        list.add(bird3)

        val bird4 = PetVideo()
        bird4.type = VideoType.BIRD.ordinal
        bird4.fileName = "bird4"
        bird4.code = 880
        bird4.duration = 55
        bird4.isStar = true
        bird4.title = "优雅的鹳大爷"
        bird4.releaseTime = "2022-01-25 00:14:22"
        bird4.originalUrl = "https://www.bilibili.com/video/BV1dL4y1s7KY"
        bird4.tags = "鸟,萌宠"
        bird4.authorId = 2110400309
        bird4.cover =
            "https://i2.hdslb.com/bfs/archive/3f4f36763720a6ebccd303856a1f661a01d9a850.jpg"
        bird4.videoType = 0
        list.add(bird4)

        val bird5 = PetVideo()
        bird5.type = VideoType.BIRD.ordinal
        bird5.fileName = "bird5"
        bird5.code = 881
        bird5.duration = 155
        bird5.isStar = true
        bird5.title = "窗前有一副画：很美，很生动。"
        bird5.releaseTime = "2022-01-13 06:00:25"
        bird5.originalUrl = "https://www.bilibili.com/video/BV1wL411576w"
        bird5.tags = "鸟,萌宠"
        bird5.authorId = 324015942
        bird5.cover =
            "https://i1.hdslb.com/bfs/archive/c5ca9de0137c1168a0fb50f65c43e399e8fe8cba.jpg"
        bird5.videoType = 0
        list.add(bird5)

        val bird6 = PetVideo()
        bird6.type = VideoType.BIRD.ordinal
        bird6.fileName = "bird6"
        bird6.code = 882
        bird6.duration = 363
        bird6.isStar = true
        bird6.title = "最美鸟类排行榜：羽毛色彩绚丽，美妙绝伦！"
        bird6.releaseTime = "2022-01-29 11:57:05"
        bird6.originalUrl = "https://www.bilibili.com/video/BV1H44y1s7yv"
        bird6.tags = "鸟,萌宠"
        bird6.authorId = 282239993
        bird6.cover =
            "https://i0.hdslb.com/bfs/archive/a715301e38994dcc2608e836a089cf13f508d9fd.jpg"
        bird6.videoType = 0
        list.add(bird6)

        val bird7 = PetVideo()
        bird7.type = VideoType.BIRD.ordinal
        bird7.fileName = "bird7"
        bird7.code = 883
        bird7.duration = 90
        bird7.isStar = true
        bird7.title = "这只熊猫喜欢和孔雀一起玩耍, 它们之间太逗了!_高清"
        bird7.releaseTime = "2017-07-02 17:12:06"
        bird7.originalUrl = "https://www.bilibili.com/video/BV1qx411B7Ai"
        bird7.tags = "鸟,萌宠"
        bird7.authorId = 137051596
        bird7.cover =
            "https://i1.hdslb.com/bfs/archive/1f07b4dd06f89bba3cbc30feb7836fc7d5e52a8b.jpg"
        bird7.videoType = 0
        list.add(bird7)

        val bird8 = PetVideo()
        bird8.type = VideoType.BIRD.ordinal
        bird8.fileName = "bird8"
        bird8.code = 884
        bird8.duration = 108
        bird8.isStar = true
        bird8.title = "【孔雀】开屏什么的你见多了，孔雀飞你见过吗？"
        bird8.releaseTime = "2017-07-07 21:00:49"
        bird8.originalUrl = "https://www.bilibili.com/video/BV1Yx411z7rU"
        bird8.tags = "鸟,萌宠"
        bird8.authorId = 112798860
        bird8.cover =
            "https://i2.hdslb.com/bfs/archive/26a7c0fb4d52206cfcb756355aeb7d028753a654.jpg"
        bird8.videoType = 0
        list.add(bird8)

        val bird9 = PetVideo()
        bird9.type = VideoType.BIRD.ordinal
        bird9.fileName = "bird9"
        bird9.code = 885
        bird9.duration = 167
        bird9.isStar = true
        bird9.title = "罕见的一幕：雌绿孔雀开屏"
        bird9.releaseTime = "2021-02-02 12:20:59"
        bird9.originalUrl = "https://www.bilibili.com/video/BV1Rt4y1q75g"
        bird9.tags = "鸟,萌宠"
        bird9.authorId = 415544230
        bird9.cover =
            "https://i0.hdslb.com/bfs/archive/fb3d3d2eb8c2e59d8d5d1d64fe95ed4ee4280f09.jpg"
        bird9.videoType = 0
        list.add(bird9)

        val bird10 = PetVideo()
        bird10.type = VideoType.BIRD.ordinal
        bird10.fileName = "bird10"
        bird10.code = 886
        bird10.duration = 272
        bird10.isStar = true
        bird10.title = "神似凤凰的绿孔雀"
        bird10.releaseTime = "2020-08-16 03:09:10"
        bird10.originalUrl = "https://www.bilibili.com/video/BV1YT4y1L74u"
        bird10.tags = "鸟,萌宠"
        bird10.authorId = 415544230
        bird10.cover =
            "https://i0.hdslb.com/bfs/archive/d6546e00be16d56db587129168f890ace37d2e95.jpg"
        bird10.videoType = 0
        list.add(bird10)

        val bird11 = PetVideo()
        bird11.type = VideoType.BIRD.ordinal
        bird11.fileName = "bird11"
        bird11.code = 887
        bird11.duration = 286
        bird11.isStar = true
        bird11.title = "【绿孔雀|混剪】孔雀辞-在中国仅剩300只的绿孔雀"
        bird11.releaseTime = "2020-02-22 07:37:13"
        bird11.originalUrl = "https://www.bilibili.com/video/BV1z7411F7KU"
        bird11.tags = "鸟,萌宠"
        bird11.authorId = 1583050
        bird11.cover =
            "https://i1.hdslb.com/bfs/archive/ac0aa95bc0bfb5848ff9066399f38e31d411d2fd.jpg"
        bird11.videoType = 0
        list.add(bird11)

        val bird12 = PetVideo()
        bird12.type = VideoType.BIRD.ordinal
        bird12.fileName = "bird12"
        bird12.code = 888
        bird12.duration = 19
        bird12.isStar = true
        bird12.title = "孔雀飞起来真的好美"
        bird12.releaseTime = "2020-02-15 23:33:51"
        bird12.originalUrl = "https://www.bilibili.com/video/BV1S7411J7mE"
        bird12.tags = "鸟,萌宠"
        bird12.authorId = 28388380
        bird12.cover =
            "https://i0.hdslb.com/bfs/archive/234fef461b4218efaa5f989c11b9dd8007882ec5.jpg"
        bird12.videoType = 0
        list.add(bird12)

        val bird13 = PetVideo()
        bird13.type = VideoType.BIRD.ordinal
        bird13.fileName = "bird13"
        bird13.code = 889
        bird13.duration = 15
        bird13.isStar = true
        bird13.title = "孔雀飞起来就变成凤凰了。"
        bird13.releaseTime = "2019-10-16 21:51:55"
        bird13.originalUrl = "https://www.bilibili.com/video/BV1kE411C7Hy"
        bird13.tags = "鸟,萌宠"
        bird13.authorId = 22513986
        bird13.cover =
            "https://i0.hdslb.com/bfs/archive/85d9d0a8c9cc28e2a4ab75dc1068661acf37cfdb.jpg"
        bird13.videoType = 0
        list.add(bird13)

        val bird14 = PetVideo()
        bird14.type = VideoType.BIRD.ordinal
        bird14.fileName = "bird14"
        bird14.code = 890
        bird14.duration = 146
        bird14.isStar = true
        bird14.title = "黑天鹅一家出游赏花，难得一见天鹅戏桃花"
        bird14.releaseTime = "2020-04-14 17:45:43"
        bird14.originalUrl = "https://www.bilibili.com/video/BV1d54y197Fa"
        bird14.tags = "鸟,萌宠"
        bird14.authorId = 394283223
        bird14.cover =
            "https://i0.hdslb.com/bfs/archive/ab719da20e13e5ed0c3ec260bc461bc259c00037.jpg"
        bird14.videoType = 0
        list.add(bird14)

        val bird15 = PetVideo()
        bird15.type = VideoType.BIRD.ordinal
        bird15.fileName = "bird15"
        bird15.code = 891
        bird15.duration = 148
        bird15.isStar = true
        bird15.title = "黑天鹅家族再添丁，这次只孵出一只小宝宝，黑天鹅爸妈疼爱有加！"
        bird15.releaseTime = "2020-06-22 13:51:07"
        bird15.originalUrl = "https://www.bilibili.com/video/BV1FD4y1Q7cN"
        bird15.tags = "鸟,萌宠"
        bird15.authorId = 394283223
        bird15.cover =
            "https://i0.hdslb.com/bfs/archive/cccb3eb504f603095f08ae34c62a49b852a22883.jpg"
        bird15.videoType = 0
        list.add(bird15)

        val bird16 = PetVideo()
        bird16.type = VideoType.BIRD.ordinal
        bird16.fileName = "bird16"
        bird16.code = 892
        bird16.duration = 171
        bird16.isStar = true
        bird16.title = "出生第三天，小天鹅趴在妈妈背上出游觅食"
        bird16.releaseTime = "2020-04-25 19:53:58"
        bird16.originalUrl = "https://www.bilibili.com/video/BV1xC4y1W7YA"
        bird16.tags = "鸟,萌宠"
        bird16.authorId = 394283223
        bird16.cover =
            "https://i1.hdslb.com/bfs/archive/fccf7e3adfe5e7817941d13497951078caffbf94.jpg"
        bird16.videoType = 0
        list.add(bird16)

        val bird17 = PetVideo()
        bird17.type = VideoType.BIRD.ordinal
        bird17.fileName = "bird17"
        bird17.code = 893
        bird17.duration = 60
        bird17.isStar = true
        bird17.title = "圆明园公园，网红黑天鹅夫妇携6只小宝宝冰上行，萌萌哒"
        bird17.releaseTime = "2020-01-12 22:14:53"
        bird17.originalUrl = "https://www.bilibili.com/video/BV1HJ411n7cC"
        bird17.tags = "鸟,萌宠"
        bird17.authorId = 394283223
        bird17.cover =
            "https://i1.hdslb.com/bfs/archive/644c9b30a4fc20718620d40b88cb084227527b36.jpg"
        bird17.videoType = 0
        list.add(bird17)

        val bird18 = PetVideo()
        bird18.type = VideoType.BIRD.ordinal
        bird18.fileName = "bird18"
        bird18.code = 894
        bird18.duration = 48
        bird18.isStar = true
        bird18.title = "【观鸟记录】大天鹅的脖子到底有多灵活"
        bird18.releaseTime = "2022-01-17 16:28:46"
        bird18.originalUrl = "https://www.bilibili.com/video/BV1PF411i7kX"
        bird18.tags = "鸟,萌宠"
        bird18.authorId = 1967453
        bird18.cover =
            "https://i0.hdslb.com/bfs/archive/7146a53201eac42d992b4bec113a4c251f4bd979.jpg"
        bird18.videoType = 0
        list.add(bird18)

        val bird19 = PetVideo()
        bird19.type = VideoType.BIRD.ordinal
        bird19.fileName = "bird19"
        bird19.code = 895
        bird19.duration = 121
        bird19.isStar = true
        bird19.title = "白天鹅：优雅，永不过时"
        bird19.releaseTime = "2022-01-26 11:10:11"
        bird19.originalUrl = "https://www.bilibili.com/video/BV1ka411m7Yv"
        bird19.tags = "鸟,萌宠"
        bird19.authorId = 598320616
        bird19.cover =
            "https://i0.hdslb.com/bfs/archive/a9712eb797e1b3458b5380c31d5510c80151b093.jpg"
        bird19.videoType = 0
        list.add(bird19)

        val bird20 = PetVideo()
        bird20.type = VideoType.BIRD.ordinal
        bird20.fileName = "bird20"
        bird20.code = 896
        bird20.duration = 74
        bird20.isStar = true
        bird20.title = "黄臀鹎在细雨中整理羽毛"
        bird20.releaseTime = "2021-07-16 09:00:05"
        bird20.originalUrl = "https://www.bilibili.com/video/BV1EK4y1u7Af"
        bird20.tags = "鸟,萌宠"
        bird20.authorId = 15693799
        bird20.cover =
            "https://i0.hdslb.com/bfs/archive/aa37ea40714e85fb72641b7a847cdcb68e904de1.jpg"
        bird20.videoType = 0
        list.add(bird20)

        val bird21 = PetVideo()
        bird21.type = VideoType.BIRD.ordinal
        bird21.fileName = "bird21"
        bird21.code = 897
        bird21.duration = 82
        bird21.isStar = true
        bird21.title = "超迷你小老虎来了！红头长尾山雀集体出动"
        bird21.releaseTime = "2022-01-14 09:00:02"
        bird21.originalUrl = "https://www.bilibili.com/video/BV1bS4y1f7c6"
        bird21.tags = "鸟,萌宠"
        bird21.authorId = 15693799
        bird21.cover =
            "https://i1.hdslb.com/bfs/archive/c828776ac69cb61b776e61451d11d4ba46b2a96e.jpg"
        bird21.videoType = 0
        list.add(bird21)

        val bird22 = PetVideo()
        bird22.type = VideoType.BIRD.ordinal
        bird22.fileName = "bird22"
        bird22.code = 898
        bird22.duration = 313
        bird22.isStar = true
        bird22.title = "[冠蓝鸦] 蓝色的鸦鸦"
        bird22.releaseTime = "2022-01-04 19:00:00"
        bird22.originalUrl = "https://www.bilibili.com/video/BV18L41157rS"
        bird22.tags = "鸟,萌宠"
        bird22.authorId = 205319947
        bird22.cover =
            "https://i2.hdslb.com/bfs/archive/e392429fb95ad4d8642f374765a6d315a0256c03.jpg"
        bird22.videoType = 0
        list.add(bird22)

        val bird23 = PetVideo()
        bird23.type = VideoType.BIRD.ordinal
        bird23.fileName = "bird23"
        bird23.code = 899
        bird23.duration = 150
        bird23.isStar = true
        bird23.title = "原来绿鹦嘴鹎长这样"
        bird23.releaseTime = "2018-12-07 20:39:15"
        bird23.originalUrl = "https://www.bilibili.com/video/BV1rt411S7iW"
        bird23.tags = "鸟,萌宠"
        bird23.authorId = 282239993
        bird23.cover =
            "https://i0.hdslb.com/bfs/archive/7b5d907e63b1a1d48942c5c5345f8820e7a580e0.jpg"
        bird23.videoType = 0
        list.add(bird23)

        val bird24 = PetVideo()
        bird24.type = VideoType.BIRD.ordinal
        bird24.fileName = "bird24"
        bird24.code = 900
        bird24.duration = 120
        bird24.isStar = true
        bird24.title = "文须雀"
        bird24.releaseTime = "2018-10-15 14:31:26"
        bird24.originalUrl = "https://www.bilibili.com/video/BV14t411Z7dP"
        bird24.tags = "鸟,萌宠"
        bird24.authorId = 282239993
        bird24.cover =
            "https://i1.hdslb.com/bfs/archive/5d29b7307a3346123186011bfa94ea8897f67303.jpg"
        bird24.videoType = 0
        list.add(bird24)

        val bird25 = PetVideo()
        bird25.type = VideoType.BIRD.ordinal
        bird25.fileName = "bird25"
        bird25.code = 901
        bird25.duration = 147
        bird25.isStar = true
        bird25.title = "疣鼻天鹅每年春秋季，都要在繁殖地和越冬地之间，来回迁徙上千米"
        bird25.releaseTime = "2019-01-16 14:03:07"
        bird25.originalUrl = "https://www.bilibili.com/video/BV17t411p7ot"
        bird25.tags = "鸟,萌宠"
        bird25.authorId = 282239993
        bird25.cover =
            "https://i1.hdslb.com/bfs/archive/72e3a6f4dad48f6e0a55e47ad30866f6c7723a83.jpg"
        bird25.videoType = 0
        list.add(bird25)

        val bird26 = PetVideo()
        bird26.type = VideoType.BIRD.ordinal
        bird26.fileName = "bird26"
        bird26.code = 902
        bird26.duration = 83
        bird26.isStar = true
        bird26.title = "天鹅见得多了，但黑色的天鹅还真是第一次见，不要见笑哈！"
        bird26.releaseTime = "2019-01-18 18:49:52"
        bird26.originalUrl = "https://www.bilibili.com/video/BV1ut411a7ce"
        bird26.tags = "鸟,萌宠"
        bird26.authorId = 282239993
        bird26.cover =
            "https://i2.hdslb.com/bfs/archive/26f846afba098905bd236f9d5ceb7406bb7bb166.jpg"
        bird26.videoType = 0
        list.add(bird26)

        val bird27 = PetVideo()
        bird27.type = VideoType.BIRD.ordinal
        bird27.fileName = "bird27"
        bird27.code = 903
        bird27.duration = 155
        bird27.isStar = true
        bird27.title = "超美腻的蓝绿鹊在广西安家啦，还带了一窝小可爱"
        bird27.releaseTime = "2020-07-06 21:50:47"
        bird27.originalUrl = "https://www.bilibili.com/video/BV1Gz411v7LD"
        bird27.tags = "鸟,萌宠"
        bird27.authorId = 545480869
        bird27.cover =
            "https://i0.hdslb.com/bfs/archive/8768eb7902d176d6565c4b1029537a07bd9b7d48.jpg"
        bird27.videoType = 0
        list.add(bird27)

        val bird28 = PetVideo()
        bird28.type = VideoType.BIRD.ordinal
        bird28.fileName = "bird28"
        bird28.code = 904
        bird28.duration = 93
        bird28.isStar = true
        bird28.title = "实拍傍晚野公鸡带在找吃的，羽毛色彩斑斓，美极了！"
        bird28.releaseTime = "2019-03-29 20:36:45"
        bird28.originalUrl = "https://www.bilibili.com/video/BV1Rb411x7zd"
        bird28.tags = "鸟,萌宠"
        bird28.authorId = 282239993
        bird28.cover =
            "https://i1.hdslb.com/bfs/archive/ae21ea10882a2c6fd0a0da83c5ef58916d6781d6.jpg"
        bird28.videoType = 0
        list.add(bird28)

        val bird29 = PetVideo()
        bird29.type = VideoType.BIRD.ordinal
        bird29.fileName = "bird29"
        bird29.code = 905
        bird29.duration = 26
        bird29.isStar = true
        bird29.title = "蓝喉歌鸲优美的鸣声"
        bird29.releaseTime = "2019-04-04 18:04:27"
        bird29.originalUrl = "https://www.bilibili.com/video/BV1Nb411g7EQ"
        bird29.tags = "鸟,萌宠"
        bird29.authorId = 282239993
        bird29.cover =
            "https://i2.hdslb.com/bfs/archive/f2a3dd0bc13dcdd99867b168ca62002e8dd00c55.jpg"
        bird29.videoType = 0
        list.add(bird29)

        val bird30 = PetVideo()
        bird30.type = VideoType.BIRD.ordinal
        bird30.fileName = "bird30"
        bird30.code = 906
        bird30.duration = 11
        bird30.isStar = true
        bird30.title = "盘尾树鹊太贵族了"
        bird30.releaseTime = "2019-04-22 19:25:17"
        bird30.originalUrl = "https://www.bilibili.com/video/BV1mb41137QJ"
        bird30.tags = "鸟,萌宠"
        bird30.authorId = 282239993
        bird30.cover =
            "https://i1.hdslb.com/bfs/archive/5925184303525b3eee219e82697cf5b99a331704.jpg"
        bird30.videoType = 0
        list.add(bird30)

        val bird31 = PetVideo()
        bird31.type = VideoType.BIRD.ordinal
        bird31.fileName = "bird31"
        bird31.code = 907
        bird31.duration = 22
        bird31.isStar = true
        bird31.title = "叉尾太阳鸟在枝头吸吮冬红花蜜"
        bird31.releaseTime = "2021-02-10 18:35:04"
        bird31.originalUrl = "https://www.bilibili.com/video/BV1aK4y1p7ft"
        bird31.tags = "鸟,萌宠"
        bird31.authorId = 1508960036
        bird31.cover =
            "https://i1.hdslb.com/bfs/archive/35f01ef637f7d2c63d06001781fdec1dd0317e00.jpg"
        bird31.videoType = 0
        list.add(bird31)

        val bird32 = PetVideo()
        bird32.type = VideoType.BIRD.ordinal
        bird32.fileName = "bird32"
        bird32.code = 908
        bird32.duration = 76
        bird32.isStar = true
        bird32.title = "一只雄性“叉尾的太阳鸟”在飞行中吮吸花蜜（慢动作）"
        bird32.releaseTime = "2019-05-13 16:47:07"
        bird32.originalUrl = "https://www.bilibili.com/video/BV1a4411a7vX"
        bird32.tags = "鸟,萌宠"
        bird32.authorId = 282239993
        bird32.cover =
            "https://i2.hdslb.com/bfs/archive/d7fdea9f15c436ab5a0f0b16442d5cad2c284810.jpg"
        bird32.videoType = 0
        list.add(bird32)

        val bird33 = PetVideo()
        bird33.type = VideoType.BIRD.ordinal
        bird33.fileName = "bird33"
        bird33.code = 909
        bird33.duration = 46
        bird33.isStar = true
        bird33.title = "印支绿鹊把色彩发挥到了极致，颜羽集于一身"
        bird33.releaseTime = "2019-05-15 21:54:54"
        bird33.originalUrl = "https://www.bilibili.com/video/BV1H4411J7fF"
        bird33.tags = "鸟,萌宠"
        bird33.authorId = 282239993
        bird33.cover =
            "https://i1.hdslb.com/bfs/archive/025f9a0bcbb2cf06cb955b1cbb90152ebc3c60b4.jpg"
        bird33.videoType = 0
        list.add(bird33)

        val bird34 = PetVideo()
        bird34.type = VideoType.BIRD.ordinal
        bird34.fileName = "bird34"
        bird34.code = 910
        bird34.duration = 78
        bird34.isStar = true
        bird34.title = "难得一见的白鹇，看起来颇有仙鸟的气质"
        bird34.releaseTime = "2019-05-15 23:36:25"
        bird34.originalUrl = "https://www.bilibili.com/video/BV1s4411J78S"
        bird34.tags = "鸟,萌宠"
        bird34.authorId = 282239993
        bird34.cover =
            "https://i1.hdslb.com/bfs/archive/725bd9b93798d2c5c027adcaa687e9e202700dbe.jpg"
        bird34.videoType = 0
        list.add(bird34)

        val bird35 = PetVideo()
        bird35.type = VideoType.BIRD.ordinal
        bird35.fileName = "bird35"
        bird35.code = 911
        bird35.duration = 58
        bird35.isStar = true
        bird35.title = "云雀高歌天籁之音，听后耳朵怀孕了"
        bird35.releaseTime = "2019-05-20 08:56:19"
        bird35.originalUrl = "https://www.bilibili.com/video/BV1p4411j7Eq"
        bird35.tags = "鸟,萌宠"
        bird35.authorId = 282239993
        bird35.cover =
            "https://i1.hdslb.com/bfs/archive/5ea498e6118608767de76bab1ab7d0d3540a7643.jpg"
        bird35.videoType = 0
        list.add(bird35)

        val bird36 = PetVideo()
        bird36.type = VideoType.BIRD.ordinal
        bird36.fileName = "bird36"
        bird36.code = 912
        bird36.duration = 53
        bird36.isStar = true
        bird36.title = "胡言乱语的剑嘴鹛，不时地发出三音一度"
        bird36.releaseTime = "2019-05-21 18:32:39"
        bird36.originalUrl = "https://www.bilibili.com/video/BV1R4411j7gA"
        bird36.tags = "鸟,萌宠"
        bird36.authorId = 282239993
        bird36.cover =
            "https://i1.hdslb.com/bfs/archive/aee1e1c2df351d06282fac515afd4cd070d826aa.jpg"
        bird36.videoType = 0
        list.add(bird36)

        val bird37 = PetVideo()
        bird37.type = VideoType.BIRD.ordinal
        bird37.fileName = "bird37"
        bird37.code = 913
        bird37.duration = 68
        bird37.isStar = true
        bird37.title = "黑颈长尾雉，鸡 你太美了"
        bird37.releaseTime = "2019-05-22 21:52:04"
        bird37.originalUrl = "https://www.bilibili.com/video/BV12441157Zp"
        bird37.tags = "鸟,萌宠"
        bird37.authorId = 282239993
        bird37.cover =
            "https://i2.hdslb.com/bfs/archive/bea99316de61cbbc0c164439b5201c53a0451608.jpg"
        bird37.videoType = 0
        list.add(bird37)

        val bird38 = PetVideo()
        bird38.type = VideoType.BIRD.ordinal
        bird38.fileName = "bird38"
        bird38.code = 914
        bird38.duration = 120
        bird38.isStar = true
        bird38.title = "红扑扑的脸颊，一定做羞羞的事了"
        bird38.releaseTime = "2019-06-03 12:11:33"
        bird38.originalUrl = "https://www.bilibili.com/video/BV1X4411n7dN"
        bird38.tags = "鸟,萌宠"
        bird38.authorId = 282239993
        bird38.cover =
            "https://i2.hdslb.com/bfs/archive/5280754401ce7eaa14b6edce8ea6cba7a9809ef3.jpg"
        bird38.videoType = 0
        list.add(bird38)

        val bird39 = PetVideo()
        bird39.type = VideoType.BIRD.ordinal
        bird39.fileName = "bird39"
        bird39.code = 915
        bird39.duration = 167
        bird39.isStar = true
        bird39.title = "常常听其声不见其影的赤尾噪鹛，拥有一身华丽的羽毛"
        bird39.releaseTime = "2019-07-30 17:15:45"
        bird39.originalUrl = "https://www.bilibili.com/video/BV13t411c7Rj"
        bird39.tags = "鸟,萌宠"
        bird39.authorId = 282239993
        bird39.cover =
            "https://i2.hdslb.com/bfs/archive/a4795ed21366ecb6f2671efec5931a3489d3d77f.jpg"
        bird39.videoType = 0
        list.add(bird39)

        val bird40 = PetVideo()
        bird40.type = VideoType.BIRD.ordinal
        bird40.fileName = "bird40"
        bird40.code = 916
        bird40.duration = 167
        bird40.isStar = true
        bird40.title = "灰雁家的一天，毛茸茸的小灰雁觅食"
        bird40.releaseTime = "2019-08-13 12:02:09"
        bird40.originalUrl = "https://www.bilibili.com/video/BV144411S7xx"
        bird40.tags = "鸟,萌宠"
        bird40.authorId = 282239993
        bird40.cover =
            "https://i2.hdslb.com/bfs/archive/244af068e4c115396b584f8cf0d648e1aa45fb33.jpg"
        bird40.videoType = 0
        list.add(bird40)

        val bird41 = PetVideo()
        bird41.type = VideoType.BIRD.ordinal
        bird41.fileName = "bird41"
        bird41.code = 917
        bird41.duration = 178
        bird41.isStar = true
        bird41.title = "一级保护动物，孔雀的迷你版本"
        bird41.releaseTime = "2019-08-24 17:50:48"
        bird41.originalUrl = "https://www.bilibili.com/video/BV184411r7SE"
        bird41.tags = "鸟,萌宠"
        bird41.authorId = 282239993
        bird41.cover =
            "https://i0.hdslb.com/bfs/archive/1766b8cf3b1e8d8fbbfc23c8eecccaed95e75c7f.jpg"
        bird41.videoType = 0
        list.add(bird41)

        val bird42 = PetVideo()
        bird42.type = VideoType.BIRD.ordinal
        bird42.fileName = "bird42"
        bird42.code = 918
        bird42.duration = 120
        bird42.isStar = true
        bird42.title = "凤头雀嘴鹎的发型碉堡了"
        bird42.releaseTime = "2019-09-02 17:45:04"
        bird42.originalUrl = "https://www.bilibili.com/video/BV1Y441117xq"
        bird42.tags = "鸟,萌宠"
        bird42.authorId = 282239993
        bird42.cover =
            "https://i2.hdslb.com/bfs/archive/6007db722948e3f232c6ed757d755313d81b2601.jpg"
        bird42.videoType = 0
        list.add(bird42)

        val bird43 = PetVideo()
        bird43.type = VideoType.BIRD.ordinal
        bird43.fileName = "bird43"
        bird43.code = 919
        bird43.duration = 320
        bird43.isStar = true
        bird43.title = "白冠噪鹛的叫声，像山歌一样欢快！"
        bird43.releaseTime = "2019-09-13 17:35:45"
        bird43.originalUrl = "https://www.bilibili.com/video/BV1rJ411K7bv"
        bird43.tags = "鸟,萌宠"
        bird43.authorId = 282239993
        bird43.cover =
            "https://i2.hdslb.com/bfs/archive/8f9d26e3a2615c49d3135855cbfeeac253c1d5b2.jpg"
        bird43.videoType = 0
        list.add(bird43)

        val bird44 = PetVideo()
        bird44.type = VideoType.BIRD.ordinal
        bird44.fileName = "bird44"
        bird44.code = 920
        bird44.duration = 156
        bird44.isStar = true
        bird44.title = "探纪自然：苍鹰把鸽子踩在脚下，一口一口的拔毛！"
        bird44.releaseTime = "2019-10-01 09:30:34"
        bird44.originalUrl = "https://www.bilibili.com/video/BV18E411X76o"
        bird44.tags = "鸟,萌宠"
        bird44.authorId = 282239993
        bird44.cover =
            "https://i1.hdslb.com/bfs/archive/ce54aa6c9b258b9aa84f16e7d935768b435c25da.jpg"
        bird44.videoType = 0
        list.add(bird44)

        val bird45 = PetVideo()
        bird45.type = VideoType.BIRD.ordinal
        bird45.fileName = "bird45"
        bird45.code = 921
        bird45.duration = 160
        bird45.isStar = true
        bird45.title = "（安静系列）丛林知更鸟"
        bird45.releaseTime = "2019-10-16 18:04:47"
        bird45.originalUrl = "https://www.bilibili.com/video/BV1WE411C7Qu"
        bird45.tags = "鸟,萌宠"
        bird45.authorId = 282239993
        bird45.cover =
            "https://i1.hdslb.com/bfs/archive/a7b3f3302ce5e3868f7dfc5ee16abc7603a477ec.jpg"
        bird45.videoType = 0
        list.add(bird45)

        val bird46 = PetVideo()
        bird46.type = VideoType.BIRD.ordinal
        bird46.fileName = "bird46"
        bird46.code = 922
        bird46.duration = 138
        bird46.isStar = true
        bird46.title = "好看的皮囊你玩不起，有思想的灵魂不理你，不如来看赤尾噪鹛"
        bird46.releaseTime = "2019-11-29 10:23:58"
        bird46.originalUrl = "https://www.bilibili.com/video/BV1RJ411D7fH"
        bird46.tags = "鸟,萌宠"
        bird46.authorId = 282239993
        bird46.cover =
            "https://i2.hdslb.com/bfs/archive/f891cb7bfa471cd8c5410e649c25665205a05b7c.jpg"
        bird46.videoType = 0
        list.add(bird46)

        val bird47 = PetVideo()
        bird47.type = VideoType.BIRD.ordinal
        bird47.fileName = "bird47"
        bird47.code = 923
        bird47.duration = 100
        bird47.isStar = true
        bird47.title = "留 八 字 胡 须 的 鸟"
        bird47.releaseTime = "2019-12-04 13:30:07"
        bird47.originalUrl = "https://www.bilibili.com/video/BV1FJ411B7Lp"
        bird47.tags = "鸟,萌宠"
        bird47.authorId = 282239993
        bird47.cover =
            "https://i2.hdslb.com/bfs/archive/9d319c0290f55b86d9d7e23e5f864f3582944c36.jpg"
        bird47.videoType = 0
        list.add(bird47)

        val bird48 = PetVideo()
        bird48.type = VideoType.BIRD.ordinal
        bird48.fileName = "bird48"
        bird48.code = 924
        bird48.duration = 66
        bird48.isStar = true
        bird48.title = "一种喜欢倒立觅食的鸟（栗臀䴓）"
        bird48.releaseTime = "2019-12-07 21:45:06"
        bird48.originalUrl = "https://www.bilibili.com/video/BV1XJ411e7Nk"
        bird48.tags = "鸟,萌宠"
        bird48.authorId = 282239993
        bird48.cover =
            "https://i1.hdslb.com/bfs/archive/d923c2bec78998ee8dceff76992fd1e3f9bad581.jpg"
        bird48.videoType = 0
        list.add(bird48)

        val bird49 = PetVideo()
        bird49.type = VideoType.BIRD.ordinal
        bird49.fileName = "bird49"
        bird49.code = 925
        bird49.duration = 108
        bird49.isStar = true
        bird49.title = "中国特有鸟：褐 马 鸡"
        bird49.releaseTime = "2019-12-17 11:23:30"
        bird49.originalUrl = "https://www.bilibili.com/video/BV1zJ41167k1"
        bird49.tags = "鸟,萌宠"
        bird49.authorId = 282239993
        bird49.cover =
            "https://i1.hdslb.com/bfs/archive/943e106e382675692c776428ba47540755e3c73c.jpg"
        bird49.videoType = 0
        list.add(bird49)

        val bird50 = PetVideo()
        bird50.type = VideoType.BIRD.ordinal
        bird50.fileName = "bird50"
        bird50.code = 926
        bird50.duration = 78
        bird50.isStar = true
        bird50.title = "奶凶小猫头鹰表情包大放送【Toto观鸟·斑头鸺鹠】"
        bird50.releaseTime = "2021-11-20 18:49:13"
        bird50.originalUrl = "https://www.bilibili.com/video/BV1iP4y1G7Dk"
        bird50.tags = "鸟,萌宠"
        bird50.authorId = 287111590
        bird50.cover =
            "https://i2.hdslb.com/bfs/archive/de6d78f9eef4ed7585137af96235aa87919fb98d.jpg"
        bird50.videoType = 0
        list.add(bird50)

        val bird51 = PetVideo()
        bird51.type = VideoType.BIRD.ordinal
        bird51.fileName = "bird51"
        bird51.code = 927
        bird51.duration = 145
        bird51.isStar = true
        bird51.title = "国画上走下来的鸟类，尾巴近2米长"
        bird51.releaseTime = "2020-01-03 12:09:05"
        bird51.originalUrl = "https://www.bilibili.com/video/BV1iJ411j7Bo"
        bird51.tags = "鸟,萌宠"
        bird51.authorId = 282239993
        bird51.cover =
            "https://i1.hdslb.com/bfs/archive/5d99c5ede0dc28e5e5fa39eec24f4f1d27a0c9ec.jpg"
        bird51.videoType = 0
        list.add(bird51)

        val bird52 = PetVideo()
        bird52.type = VideoType.BIRD.ordinal
        bird52.fileName = "bird52"
        bird52.code = 928
        bird52.duration = 138
        bird52.isStar = true
        bird52.title = "动物也很忙，胖胖的野生勺鸡觅食"
        bird52.releaseTime = "2020-01-05 10:53:42"
        bird52.originalUrl = "https://www.bilibili.com/video/BV1MJ411L7DD"
        bird52.tags = "鸟,萌宠"
        bird52.authorId = 282239993
        bird52.cover =
            "https://i1.hdslb.com/bfs/archive/f5fb0d063eca1c51c62addfd4f5ba47b26475465.jpg"
        bird52.videoType = 0
        list.add(bird52)

        val bird53 = PetVideo()
        bird53.type = VideoType.BIRD.ordinal
        bird53.fileName = "bird53"
        bird53.code = 929
        bird53.duration = 163
        bird53.isStar = true
        bird53.title = "鸟类排行第一美！中国特有鸟类-红腹锦鸡"
        bird53.releaseTime = "2020-01-17 17:18:16"
        bird53.originalUrl = "https://www.bilibili.com/video/BV1vJ411E7jd"
        bird53.tags = "鸟,萌宠"
        bird53.authorId = 282239993
        bird53.cover =
            "https://i0.hdslb.com/bfs/archive/07b188bc5413cd23a3a5fd7e27a31f6f2a5dc633.jpg"
        bird53.videoType = 0
        list.add(bird53)

        val bird54 = PetVideo()
        bird54.type = VideoType.BIRD.ordinal
        bird54.fileName = "bird54"
        bird54.code = 930
        bird54.duration = 178
        bird54.isStar = true
        bird54.title = "凤凰的原型鸟，太美了！美得像一幅画"
        bird54.releaseTime = "2020-01-18 11:57:32"
        bird54.originalUrl = "https://www.bilibili.com/video/BV167411i7CM"
        bird54.tags = "鸟,萌宠"
        bird54.authorId = 282239993
        bird54.cover =
            "https://i0.hdslb.com/bfs/archive/7f92381b153ea7c13f4758e7cb6cc35fa37877ef.jpg"
        bird54.videoType = 0
        list.add(bird54)

        val bird55 = PetVideo()
        bird55.type = VideoType.BIRD.ordinal
        bird55.fileName = "bird55"
        bird55.code = 931
        bird55.duration = 122
        bird55.isStar = true
        bird55.title = "【探纪自然】普通朱雀不仅长得好看，鸣声更是清脆悦耳！"
        bird55.releaseTime = "2020-04-05 15:29:35"
        bird55.originalUrl = "https://www.bilibili.com/video/BV1454y1d7Qa"
        bird55.tags = "鸟,萌宠"
        bird55.authorId = 282239993
        bird55.cover =
            "https://i1.hdslb.com/bfs/archive/9448a57101ed8fe315f07617e85f0a83e9c1bab1.jpg"
        bird55.videoType = 0
        list.add(bird55)

        val bird56 = PetVideo()
        bird56.type = VideoType.BIRD.ordinal
        bird56.fileName = "bird56"
        bird56.code = 932
        bird56.duration = 98
        bird56.isStar = true
        bird56.title = "黄色的球球鸟：我只是毛茸茸，不是胖嘟嘟"
        bird56.releaseTime = "2020-04-15 11:19:44"
        bird56.originalUrl = "https://www.bilibili.com/video/BV1ZQ4y1K7ki"
        bird56.tags = "鸟,萌宠"
        bird56.authorId = 282239993
        bird56.cover =
            "https://i1.hdslb.com/bfs/archive/5eade462fb3a7e8323aaca0e111945a6111fa08c.jpg"
        bird56.videoType = 0
        list.add(bird56)

        val bird57 = PetVideo()
        bird57.type = VideoType.BIRD.ordinal
        bird57.fileName = "bird57"
        bird57.code = 933
        bird57.duration = 167
        bird57.isStar = true
        bird57.title = "前方高能！！！ 这是真的，一只鸟的叫声，专治 耳 鸣 耳 聋"
        bird57.releaseTime = "2020-04-29 13:16:48"
        bird57.originalUrl = "https://www.bilibili.com/video/BV16A41147nm"
        bird57.tags = "鸟,萌宠"
        bird57.authorId = 282239993
        bird57.cover =
            "https://i0.hdslb.com/bfs/archive/eb32b373eaf2f32499c7944dd83a82d5b92571fc.jpg"
        bird57.videoType = 0
        list.add(bird57)

        val bird58 = PetVideo()
        bird58.type = VideoType.BIRD.ordinal
        bird58.fileName = "bird58"
        bird58.code = 934
        bird58.duration = 153
        bird58.isStar = true
        bird58.title = "为什么一只鸟，成天叫着：不哭 不哭 ！"
        bird58.releaseTime = "2020-05-09 10:23:23"
        bird58.originalUrl = "https://www.bilibili.com/video/BV1De411p7Ry"
        bird58.tags = "鸟,萌宠"
        bird58.authorId = 282239993
        bird58.cover =
            "https://i0.hdslb.com/bfs/archive/e68b711a0d27a105d2752685a6258ed7fd91af4a.jpg"
        bird58.videoType = 0
        list.add(bird58)

        val bird59 = PetVideo()
        bird59.type = VideoType.BIRD.ordinal
        bird59.fileName = "bird59"
        bird59.code = 935
        bird59.duration = 306
        bird59.isStar = true
        bird59.title = "全网最火的叫声，耳朵又一次怀孕了"
        bird59.releaseTime = "2020-05-15 20:36:06"
        bird59.originalUrl = "https://www.bilibili.com/video/BV1iZ4y1s7Lt"
        bird59.tags = "鸟,萌宠"
        bird59.authorId = 282239993
        bird59.cover =
            "https://i1.hdslb.com/bfs/archive/ce78ea24271ae340df5d2da9119d2911c850cb7a.jpg"
        bird59.videoType = 0
        list.add(bird59)

        val bird60 = PetVideo()
        bird60.type = VideoType.BIRD.ordinal
        bird60.fileName = "bird60"
        bird60.code = 936
        bird60.duration = 178
        bird60.isStar = true
        bird60.title = "原来传说中的夜莺，叫声这么好听，百听不厌啊！"
        bird60.releaseTime = "2020-06-09 12:26:25"
        bird60.originalUrl = "https://www.bilibili.com/video/BV1K54y1Q7FH"
        bird60.tags = "鸟,萌宠"
        bird60.authorId = 282239993
        bird60.cover =
            "https://i2.hdslb.com/bfs/archive/0bbd49a85d25d9743a89ab61170e4edd2c6037a6.jpg"
        bird60.videoType = 0
        list.add(bird60)

        val bird61 = PetVideo()
        bird61.type = VideoType.BIRD.ordinal
        bird61.fileName = "bird61"
        bird61.code = 937
        bird61.duration = 156
        bird61.isStar = true
        bird61.title = "古诗里的黄鹂鸟，很多人知道它的名字，却没见过长啥样！"
        bird61.releaseTime = "2020-06-18 07:32:28"
        bird61.originalUrl = "https://www.bilibili.com/video/BV16K411p7Ch"
        bird61.tags = "鸟,萌宠"
        bird61.authorId = 282239993
        bird61.cover =
            "https://i0.hdslb.com/bfs/archive/fc2f329f2f2de83cfef1726debb847e17157d2f3.jpg"
        bird61.videoType = 0
        list.add(bird61)

        val bird62 = PetVideo()
        bird62.type = VideoType.BIRD.ordinal
        bird62.fileName = "bird62"
        bird62.code = 938
        bird62.duration = 189
        bird62.isStar = true
        bird62.title = "10种让人想家的鸟叫声，响亮动听，满满的童年回忆！"
        bird62.releaseTime = "2021-11-18 22:40:03"
        bird62.originalUrl = "https://www.bilibili.com/video/BV1pQ4y1v7rp"
        bird62.tags = "鸟,萌宠"
        bird62.authorId = 354022352
        bird62.cover =
            "https://i1.hdslb.com/bfs/archive/37dab1cf4c78192d9ad176956ba31bd55f10fb75.jpg"
        bird62.videoType = 0
        list.add(bird62)

        val bird63 = PetVideo()
        bird63.type = VideoType.BIRD.ordinal
        bird63.fileName = "bird63"
        bird63.code = 939
        bird63.duration = 64
        bird63.isStar = true
        bird63.title = "拍到了难得一见的四声杜鹃叫声，它究竟说了什么？"
        bird63.releaseTime = "2020-06-22 17:09:19"
        bird63.originalUrl = "https://www.bilibili.com/video/BV1qT4y1J7bo"
        bird63.tags = "鸟,萌宠"
        bird63.authorId = 282239993
        bird63.cover =
            "https://i1.hdslb.com/bfs/archive/a7b5ce7abb5044ffa4b07b0d6a77d620f3961681.jpg"
        bird63.videoType = 0
        list.add(bird63)

        val bird64 = PetVideo()
        bird64.type = VideoType.BIRD.ordinal
        bird64.fileName = "bird64"
        bird64.code = 940
        bird64.duration = 62
        bird64.isStar = true
        bird64.title = "你 喂 过 野 生 鸟 吗 ？"
        bird64.releaseTime = "2020-06-30 11:50:55"
        bird64.originalUrl = "https://www.bilibili.com/video/BV1xA411i7V1"
        bird64.tags = "鸟,萌宠"
        bird64.authorId = 282239993
        bird64.cover =
            "https://i1.hdslb.com/bfs/archive/a99bbc559ba8e5e0ec50ae7b39f20919690c9b8d.jpg"
        bird64.videoType = 0
        list.add(bird64)

        val bird65 = PetVideo()
        bird65.type = VideoType.BIRD.ordinal
        bird65.fileName = "bird65"
        bird65.code = 941
        bird65.duration = 115
        bird65.isStar = true
        bird65.title = "【探纪自然】活泼可爱的小方尾鹟，叽叽喳喳叫不停"
        bird65.releaseTime = "2020-07-09 11:02:59"
        bird65.originalUrl = "https://www.bilibili.com/video/BV1oi4y1g7Bw"
        bird65.tags = "鸟,萌宠"
        bird65.authorId = 282239993
        bird65.cover =
            "https://i0.hdslb.com/bfs/archive/c5da998796454e1d2b3709393260dac0defa97a3.jpg"
        bird65.videoType = 0
        list.add(bird65)

        val bird66 = PetVideo()
        bird66.type = VideoType.BIRD.ordinal
        bird66.fileName = "bird66"
        bird66.code = 942
        bird66.duration = 7
        bird66.isStar = true
        bird66.title = "太阳鸟配灯笼花的悬停哟"
        bird66.releaseTime = "2019-02-14 05:12:05"
        bird66.originalUrl = "https://www.bilibili.com/video/BV1Hb411U774"
        bird66.tags = "鸟,萌宠"
        bird66.authorId = 2045510
        bird66.cover =
            "https://i1.hdslb.com/bfs/archive/e77f4493567d5f0abbd2e8169096addc9f843892.jpg"
        bird66.videoType = 0
        list.add(bird66)

        val bird67 = PetVideo()
        bird67.type = VideoType.BIRD.ordinal
        bird67.fileName = "bird67"
        bird67.code = 943
        bird67.duration = 93
        bird67.isStar = true
        bird67.title = "古诗词中难住今人的“绿毛夭凤”，原来就是：绿喉太阳鸟"
        bird67.releaseTime = "2020-07-11 11:20:14"
        bird67.originalUrl = "https://www.bilibili.com/video/BV1qD4y1S7Uv"
        bird67.tags = "鸟,萌宠"
        bird67.authorId = 282239993
        bird67.cover =
            "https://i0.hdslb.com/bfs/archive/e8399fcce636516b85f3435c723d1e56f1b559b8.jpg"
        bird67.videoType = 0
        list.add(bird67)

        val bird68 = PetVideo()
        bird68.type = VideoType.BIRD.ordinal
        bird68.fileName = "bird68"
        bird68.code = 944
        bird68.duration = 94
        bird68.isStar = true
        bird68.title = "该死！斑鸠打着呼噜在求爱，让我给打搅了"
        bird68.releaseTime = "2020-10-21 13:02:44"
        bird68.originalUrl = "https://www.bilibili.com/video/BV1Rf4y1B7eF"
        bird68.tags = "鸟,萌宠"
        bird68.authorId = 282239993
        bird68.cover =
            "https://i2.hdslb.com/bfs/archive/ff939b99a7b67d3e3e5ccb808a17b0f760e64a49.jpg"
        bird68.videoType = 0
        list.add(bird68)

        val bird69 = PetVideo()
        bird69.type = VideoType.BIRD.ordinal
        bird69.fileName = "bird69"
        bird69.code = 945
        bird69.duration = 93
        bird69.isStar = true
        bird69.title = "来听听长脚秧鸡的漏电叫声，绝对是独一无二的电音，强烈建议收藏！"
        bird69.releaseTime = "2020-10-24 10:05:32"
        bird69.originalUrl = "https://www.bilibili.com/video/BV1GD4y1974k"
        bird69.tags = "鸟,萌宠"
        bird69.authorId = 282239993
        bird69.cover =
            "https://i0.hdslb.com/bfs/archive/2788a43f069d5d0271bb76ea5ac3b490d630ee6f.jpg"
        bird69.videoType = 0
        list.add(bird69)

        val bird70 = PetVideo()
        bird70.type = VideoType.BIRD.ordinal
        bird70.fileName = "bird70"
        bird70.code = 946
        bird70.duration = 142
        bird70.isStar = true
        bird70.title = "一只胖乎乎的知更鸟，在蓝天下放声高歌"
        bird70.releaseTime = "2020-10-28 19:01:10"
        bird70.originalUrl = "https://www.bilibili.com/video/BV1Ha411A7UH"
        bird70.tags = "鸟,萌宠"
        bird70.authorId = 282239993
        bird70.cover =
            "https://i1.hdslb.com/bfs/archive/4baa738cb86613f4f6904b861f48250c682fe769.jpg"
        bird70.videoType = 0
        list.add(bird70)

        val bird71 = PetVideo()
        bird71.type = VideoType.BIRD.ordinal
        bird71.fileName = "bird71"
        bird71.code = 947
        bird71.duration = 203
        bird71.isStar = true
        bird71.title = "听说是世界上被捕猎最多的鸟，是真的吗？"
        bird71.releaseTime = "2020-12-22 10:54:09"
        bird71.originalUrl = "https://www.bilibili.com/video/BV1mh411Z7aH"
        bird71.tags = "鸟,萌宠"
        bird71.authorId = 282239993
        bird71.cover =
            "https://i2.hdslb.com/bfs/archive/f64211768b163e3e8c0644057f974f7f3ba524d3.jpg"
        bird71.videoType = 0
        list.add(bird71)

        val bird72 = PetVideo()
        bird72.type = VideoType.BIRD.ordinal
        bird72.fileName = "bird72"
        bird72.code = 948
        bird72.duration = 124
        bird72.isStar = true
        bird72.title = "这婉转悠扬的叫声，真的是太好听啦！"
        bird72.releaseTime = "2020-12-24 12:48:04"
        bird72.originalUrl = "https://www.bilibili.com/video/BV1Zt4y1k7Ph"
        bird72.tags = "鸟,萌宠"
        bird72.authorId = 282239993
        bird72.cover =
            "https://i2.hdslb.com/bfs/archive/02fba9c349f579bfd46f442bb5945ed06ee4a836.jpg"
        bird72.videoType = 0
        list.add(bird72)

        val bird73 = PetVideo()
        bird73.type = VideoType.BIRD.ordinal
        bird73.fileName = "bird73"
        bird73.code = 949
        bird73.duration = 261
        bird73.isStar = true
        bird73.title = "叫声好特别的柳莺鸟，3分钟悦耳鸣声，值得收藏！"
        bird73.releaseTime = "2020-12-31 11:28:40"
        bird73.originalUrl = "https://www.bilibili.com/video/BV1hV411b7gc"
        bird73.tags = "鸟,萌宠"
        bird73.authorId = 282239993
        bird73.cover =
            "https://i1.hdslb.com/bfs/archive/93e33d9c892b05f2d27d0b5d03c90b29c18fa3eb.jpg"
        bird73.videoType = 0
        list.add(bird73)

        val bird74 = PetVideo()
        bird74.type = VideoType.BIRD.ordinal
        bird74.fileName = "bird74"
        bird74.code = 950
        bird74.duration = 68
        bird74.isStar = true
        bird74.title = "顶级掠食者，一鹗抓双鱼"
        bird74.releaseTime = "2021-01-19 19:50:16"
        bird74.originalUrl = "https://www.bilibili.com/video/BV15T4y1K7VV"
        bird74.tags = "鸟,萌宠"
        bird74.authorId = 282239993
        bird74.cover =
            "https://i2.hdslb.com/bfs/archive/47dfb3f57428d08b7e2a0e1fd07ed88caa4f9e5d.jpg"
        bird74.videoType = 0
        list.add(bird74)

        val bird75 = PetVideo()
        bird75.type = VideoType.BIRD.ordinal
        bird75.fileName = "bird75"
        bird75.code = 951
        bird75.duration = 145
        bird75.isStar = true
        bird75.title = "鱼鹰为什么能捕到鱼？鱼：我这辈子没有飞过这么高！"
        bird75.releaseTime = "2021-10-09 07:04:50"
        bird75.originalUrl = "https://www.bilibili.com/video/BV1tT4y1f7Wp"
        bird75.tags = "鸟,萌宠"
        bird75.authorId = 354022352
        bird75.cover =
            "https://i2.hdslb.com/bfs/archive/a47ecaccc0d1a151d55ec0622a4f5aca00755097.jpg"
        bird75.videoType = 0
        list.add(bird75)

        val bird76 = PetVideo()
        bird76.type = VideoType.BIRD.ordinal
        bird76.fileName = "bird76"
        bird76.code = 952
        bird76.duration = 133
        bird76.isStar = true
        bird76.title = "【雉科】高颜值，鸡 你太美！"
        bird76.releaseTime = "2019-08-30 23:50:45"
        bird76.originalUrl = "https://www.bilibili.com/video/BV1Y441127Rj"
        bird76.tags = "鸟,萌宠"
        bird76.authorId = 282239993
        bird76.cover =
            "https://i0.hdslb.com/bfs/archive/1d56074ba59ca364b60e1d96c80070cc24372965.jpg"
        bird76.videoType = 0
        list.add(bird76)

        val bird77 = PetVideo()
        bird77.type = VideoType.BIRD.ordinal
        bird77.fileName = "bird77"
        bird77.code = 953
        bird77.duration = 180
        bird77.isStar = true
        bird77.title = "全世界最漂亮的鸡，主要分布在中国"
        bird77.releaseTime = "2019-05-31 14:40:05"
        bird77.originalUrl = "https://www.bilibili.com/video/BV1S4411H7kp"
        bird77.tags = "鸟,萌宠"
        bird77.authorId = 282239993
        bird77.cover =
            "https://i2.hdslb.com/bfs/archive/36bc20a3ac80ba5248b4a5a0303201c81d7b6e06.jpg"
        bird77.videoType = 0
        list.add(bird77)

        val bird78 = PetVideo()
        bird78.type = VideoType.BIRD.ordinal
        bird78.fileName = "bird78"
        bird78.code = 954
        bird78.duration = 80
        bird78.isStar = true
        bird78.title = "高清近拍国家二类保护动物———普通鵟，真是振奋人心！"
        bird78.releaseTime = "2021-02-10 09:08:16"
        bird78.originalUrl = "https://www.bilibili.com/video/BV1Py4y1Y7eX"
        bird78.tags = "鸟,萌宠"
        bird78.authorId = 282239993
        bird78.cover =
            "https://i0.hdslb.com/bfs/archive/98d333ee1a815f8ae1e21c6d4e80487b0d4a9f7d.jpg"
        bird78.videoType = 0
        list.add(bird78)

        val bird79 = PetVideo()
        bird79.type = VideoType.BIRD.ordinal
        bird79.fileName = "bird79"
        bird79.code = 955
        bird79.duration = 248
        bird79.isStar = true
        bird79.title = "屠夫伯劳鸟，喜欢把猎物刺死在树枝上，撕碎而食！"
        bird79.releaseTime = "2019-09-26 18:48:30"
        bird79.originalUrl = "https://www.bilibili.com/video/BV1nJ411T7Rm"
        bird79.tags = "鸟,萌宠"
        bird79.authorId = 282239993
        bird79.cover =
            "https://i0.hdslb.com/bfs/archive/aa17c85d5dc0118beff25d122fb8e1dbe58250f6.jpg"
        bird79.videoType = 0
        list.add(bird79)

        val bird80 = PetVideo()
        bird80.type = VideoType.BIRD.ordinal
        bird80.fileName = "bird80"
        bird80.code = 956
        bird80.duration = 145
        bird80.isStar = true
        bird80.title = "[红背伯劳]鸟类中的墨镜哥"
        bird80.releaseTime = "2021-11-06 11:00:16"
        bird80.originalUrl = "https://www.bilibili.com/video/BV1p44y1e7Zg"
        bird80.tags = "鸟,萌宠"
        bird80.authorId = 282239993
        bird80.cover =
            "https://i0.hdslb.com/bfs/archive/f813d41c0b13a2e9b0a68803d3eb21c0d7417643.jpg"
        bird80.videoType = 0
        list.add(bird80)

        val bird81 = PetVideo()
        bird81.type = VideoType.BIRD.ordinal
        bird81.fileName = "bird81"
        bird81.code = 957
        bird81.duration = 231
        bird81.isStar = true
        bird81.title = "鸟中屠夫：伯劳鸟把大山雀挂在树上，大口吃肉"
        bird81.releaseTime = "2021-02-13 12:46:04"
        bird81.originalUrl = "https://www.bilibili.com/video/BV1TU4y1W7ya"
        bird81.tags = "鸟,萌宠"
        bird81.authorId = 282239993
        bird81.cover =
            "https://i1.hdslb.com/bfs/archive/9c41098322f01f85047deb8c6c63352dbdfa2b7a.jpg"
        bird81.videoType = 0
        list.add(bird81)

        val bird82 = PetVideo()
        bird82.type = VideoType.BIRD.ordinal
        bird82.fileName = "bird82"
        bird82.code = 958
        bird82.duration = 130
        bird82.isStar = true
        bird82.title = "伯劳鸟：有天使的外表，魔鬼的嘴"
        bird82.releaseTime = "2021-02-23 14:17:06"
        bird82.originalUrl = "https://www.bilibili.com/video/BV1eA411M7tQ"
        bird82.tags = "鸟,萌宠"
        bird82.authorId = 282239993
        bird82.cover =
            "https://i2.hdslb.com/bfs/archive/a291239b2137c0b85defc48ec326fb2236b918b0.jpg"
        bird82.videoType = 0
        list.add(bird82)

        val bird83 = PetVideo()
        bird83.type = VideoType.BIRD.ordinal
        bird83.fileName = "bird83"
        bird83.code = 959
        bird83.duration = 154
        bird83.isStar = true
        bird83.title = "竹鸡大声叫：美国坏，美国坏！"
        bird83.releaseTime = "2021-03-29 11:00:07"
        bird83.originalUrl = "https://www.bilibili.com/video/BV1jv41187Xg"
        bird83.tags = "鸟,萌宠"
        bird83.authorId = 282239993
        bird83.cover =
            "https://i2.hdslb.com/bfs/archive/f5b3fdb6d9538f4123310b6597694292e3c56c01.jpg"
        bird83.videoType = 0
        list.add(bird83)

        val bird84 = PetVideo()
        bird84.type = VideoType.BIRD.ordinal
        bird84.fileName = "bird84"
        bird84.code = 960
        bird84.duration = 123
        bird84.isStar = true
        bird84.title = "普通杜鹃在清明时节，高声鸣叫，提醒人们：播谷 播谷！"
        bird84.releaseTime = "2021-04-05 10:47:09"
        bird84.originalUrl = "https://www.bilibili.com/video/BV1jh411D7oq"
        bird84.tags = "鸟,萌宠"
        bird84.authorId = 282239993
        bird84.cover =
            "https://i2.hdslb.com/bfs/archive/8b24ce0b5814d44251c4991e69037d0394940efa.jpg"
        bird84.videoType = 0
        list.add(bird84)

        val bird85 = PetVideo()
        bird85.type = VideoType.BIRD.ordinal
        bird85.fileName = "bird85"
        bird85.code = 961
        bird85.duration = 109
        bird85.isStar = true
        bird85.title = "全网最好听的叫声，听完耳朵怀孕啦！"
        bird85.releaseTime = "2021-05-11 14:21:50"
        bird85.originalUrl = "https://www.bilibili.com/video/BV1Vh411v7LF"
        bird85.tags = "鸟,萌宠"
        bird85.authorId = 282239993
        bird85.cover =
            "https://i2.hdslb.com/bfs/archive/9240bcc797f8e2c487e0b27d6c3e61ba93201449.jpg"
        bird85.videoType = 0
        list.add(bird85)

        val bird86 = PetVideo()
        bird86.type = VideoType.BIRD.ordinal
        bird86.fileName = "bird86"
        bird86.code = 962
        bird86.duration = 73
        bird86.isStar = true
        bird86.title = "布谷鸟叫晚了"
        bird86.releaseTime = "2021-05-14 19:37:27"
        bird86.originalUrl = "https://www.bilibili.com/video/BV1Vh411v7BL"
        bird86.tags = "鸟,萌宠"
        bird86.authorId = 282239993
        bird86.cover =
            "https://i2.hdslb.com/bfs/archive/96332da8fa71e6f09162afbae0545052e7d5d069.jpg"
        bird86.videoType = 0
        list.add(bird86)

        val bird87 = PetVideo()
        bird87.type = VideoType.BIRD.ordinal
        bird87.fileName = "bird87"
        bird87.code = 963
        bird87.duration = 205
        bird87.isStar = true
        bird87.title = "稀有鸟类黑琴鸡的叫声，你听过吗？"
        bird87.releaseTime = "2021-05-16 08:26:30"
        bird87.originalUrl = "https://www.bilibili.com/video/BV1Jv411572p"
        bird87.tags = "鸟,萌宠"
        bird87.authorId = 282239993
        bird87.cover =
            "https://i0.hdslb.com/bfs/archive/25a1c441dbc5e1b2a772dc3ab9e9910669e80d4a.jpg"
        bird87.videoType = 0
        list.add(bird87)

        val bird88 = PetVideo()
        bird88.type = VideoType.BIRD.ordinal
        bird88.fileName = "bird88"
        bird88.code = 964
        bird88.duration = 74
        bird88.isStar = true
        bird88.title = "高清实拍蓝额红尾鸲，叫声酷像铃铛"
        bird88.releaseTime = "2021-05-22 12:05:03"
        bird88.originalUrl = "https://www.bilibili.com/video/BV1164y1d7U9"
        bird88.tags = "鸟,萌宠"
        bird88.authorId = 282239993
        bird88.cover =
            "https://i0.hdslb.com/bfs/archive/0e96e68baee41ce183d52b2f691d625e4fc698da.jpg"
        bird88.videoType = 0
        list.add(bird88)

        val bird89 = PetVideo()
        bird89.type = VideoType.BIRD.ordinal
        bird89.fileName = "bird89"
        bird89.code = 965
        bird89.duration = 178
        bird89.isStar = true
        bird89.title = "全网最火的叫声，舌端万变百鸟啼"
        bird89.releaseTime = "2021-06-13 10:57:40"
        bird89.originalUrl = "https://www.bilibili.com/video/BV1eQ4y197ht"
        bird89.tags = "鸟,萌宠"
        bird89.authorId = 282239993
        bird89.cover =
            "https://i2.hdslb.com/bfs/archive/925f5f9b59f05530496d88a04a2d6e09474e71eb.jpg"
        bird89.videoType = 0
        list.add(bird89)

        val bird90 = PetVideo()
        bird90.type = VideoType.BIRD.ordinal
        bird90.fileName = "bird90"
        bird90.code = 966
        bird90.duration = 316
        bird90.isStar = true
        bird90.title = "夜莺诗一般的叫声，真是好听又放松！"
        bird90.releaseTime = "2021-06-14 11:05:38"
        bird90.originalUrl = "https://www.bilibili.com/video/BV11w411Z7nD"
        bird90.tags = "鸟,萌宠"
        bird90.authorId = 282239993
        bird90.cover =
            "https://i0.hdslb.com/bfs/archive/d2c790386748657c8cc0d610dad190d4f73b5362.jpg"
        bird90.videoType = 0
        list.add(bird90)

        val bird91 = PetVideo()
        bird91.type = VideoType.BIRD.ordinal
        bird91.fileName = "bird91"
        bird91.code = 967
        bird91.duration = 334
        bird91.isStar = true
        bird91.title = "翠鸟捕鱼：快、准、狠，吃鱼一口一条！"
        bird91.releaseTime = "2021-01-27 10:47:11"
        bird91.originalUrl = "https://www.bilibili.com/video/BV1Zf4y1k78Z"
        bird91.tags = "鸟,萌宠"
        bird91.authorId = 282239993
        bird91.cover =
            "https://i0.hdslb.com/bfs/archive/42b82caf8291098e176bb14de7993d8a65c2f1b7.jpg"
        bird91.videoType = 0
        list.add(bird91)

        val bird92 = PetVideo()
        bird92.type = VideoType.BIRD.ordinal
        bird92.fileName = "bird92"
        bird92.code = 968
        bird92.duration = 20
        bird92.isStar = true
        bird92.title = "喜马拉雅雪鸡叫声"
        bird92.releaseTime = "2021-06-23 13:31:21"
        bird92.originalUrl = "https://www.bilibili.com/video/BV1ZU4y1G746"
        bird92.tags = "鸟,萌宠"
        bird92.authorId = 282239993
        bird92.cover =
            "https://i1.hdslb.com/bfs/archive/e8301a7965484fa11d333cdf4080d43ee8991236.jpg"
        bird92.videoType = 0
        list.add(bird92)

        val bird93 = PetVideo()
        bird93.type = VideoType.BIRD.ordinal
        bird93.fileName = "bird93"
        bird93.code = 969
        bird93.duration = 240
        bird93.isStar = true
        bird93.title = "大苇莺在芦苇丛中，大声欢唱，声音很有特色!"
        bird93.releaseTime = "2021-06-27 10:06:42"
        bird93.originalUrl = "https://www.bilibili.com/video/BV15g41137iJ"
        bird93.tags = "鸟,萌宠"
        bird93.authorId = 282239993
        bird93.cover =
            "https://i0.hdslb.com/bfs/archive/518ddf7c7344c0e1bbe36d031d3291281921a70b.jpg"
        bird93.videoType = 0
        list.add(bird93)

        val bird94 = PetVideo()
        bird94.type = VideoType.BIRD.ordinal
        bird94.fileName = "bird94"
        bird94.code = 970
        bird94.duration = 180
        bird94.isStar = true
        bird94.title = "这就是你经常见的大山雀，鸣声尖锐多变，好听又放松！"
        bird94.releaseTime = "2021-01-29 11:10:57"
        bird94.originalUrl = "https://www.bilibili.com/video/BV1Nf4y1C7Ww"
        bird94.tags = "鸟,萌宠"
        bird94.authorId = 282239993
        bird94.cover =
            "https://i2.hdslb.com/bfs/archive/18b67192e4be05822c5341d854a6104618c4b24a.jpg"
        bird94.videoType = 0
        list.add(bird94)

        val bird95 = PetVideo()
        bird95.type = VideoType.BIRD.ordinal
        bird95.fileName = "bird95"
        bird95.code = 971
        bird95.duration = 312
        bird95.isStar = true
        bird95.title = "一只鸟婉转悠扬的叫声，这也太好听了吧！"
        bird95.releaseTime = "2021-07-15 19:05:33"
        bird95.originalUrl = "https://www.bilibili.com/video/BV1Mq4y1W7Nu"
        bird95.tags = "鸟,萌宠"
        bird95.authorId = 282239993
        bird95.cover =
            "https://i1.hdslb.com/bfs/archive/9d0ce2dc29cb1d67bd5fedb5eca5b745963b5ab0.jpg"
        bird95.videoType = 0
        list.add(bird95)

        val bird96 = PetVideo()
        bird96.type = VideoType.BIRD.ordinal
        bird96.fileName = "bird96"
        bird96.code = 972
        bird96.duration = 156
        bird96.isStar = true
        bird96.title = "夜莺鸟婉转悠扬的鸣声真好听，建议偷偷收藏！"
        bird96.releaseTime = "2021-07-25 10:23:23"
        bird96.originalUrl = "https://www.bilibili.com/video/BV1Mg41177w7"
        bird96.tags = "鸟,萌宠"
        bird96.authorId = 282239993
        bird96.cover =
            "https://i1.hdslb.com/bfs/archive/2ab77a005460a134f754a73fe47c617c5675f3c3.jpg"
        bird96.videoType = 0
        list.add(bird96)

        val bird97 = PetVideo()
        bird97.type = VideoType.BIRD.ordinal
        bird97.fileName = "bird97"
        bird97.code = 973
        bird97.duration = 201
        bird97.isStar = true
        bird97.title = "金头扇尾莺的叫声太有趣啦！"
        bird97.releaseTime = "2021-09-29 11:30:09"
        bird97.originalUrl = "https://www.bilibili.com/video/BV183411y734"
        bird97.tags = "鸟,萌宠"
        bird97.authorId = 282239993
        bird97.cover =
            "https://i1.hdslb.com/bfs/archive/687454f2bfce1cb412464dae19b7dd9518cf5d06.jpg"
        bird97.videoType = 0
        list.add(bird97)

        val bird98 = PetVideo()
        bird98.type = VideoType.BIRD.ordinal
        bird98.fileName = "bird98"
        bird98.code = 974
        bird98.duration = 304
        bird98.isStar = true
        bird98.title = "【雉亚科】鸡你太美！野鸡里的的颜值担当，20种野鸡颜值大赏！"
        bird98.releaseTime = "2020-10-28 10:17:22"
        bird98.originalUrl = "https://www.bilibili.com/video/BV1Zt4y1Y79T"
        bird98.tags = "鸟,萌宠"
        bird98.authorId = 66903212
        bird98.cover =
            "https://i1.hdslb.com/bfs/archive/526fad4c5722a3f162adcbe878f77183d57202ec.jpg"
        bird98.videoType = 0
        list.add(bird98)

        val bird99 = PetVideo()
        bird99.type = VideoType.BIRD.ordinal
        bird99.fileName = "bird99"
        bird99.code = 975
        bird99.duration = 84
        bird99.isStar = true
        bird99.title = "娃 娃 鸡"
        bird99.releaseTime = "2021-11-22 12:38:09"
        bird99.originalUrl = "https://www.bilibili.com/video/BV1GU4y1u7vx"
        bird99.tags = "鸟,萌宠"
        bird99.authorId = 282239993
        bird99.cover =
            "https://i1.hdslb.com/bfs/archive/366ccc1b49f0d55f5aee05d0c3413517c186c866.jpg"
        bird99.videoType = 0
        list.add(bird99)

        val bird100 = PetVideo()
        bird100.type = VideoType.BIRD.ordinal
        bird100.fileName = "bird100"
        bird100.code = 976
        bird100.duration = 381
        bird100.isStar = true
        bird100.title = "夜莺婉转悠扬的歌声，真是太好听了，先收藏起来！"
        bird100.releaseTime = "2021-11-24 12:23:18"
        bird100.originalUrl = "https://www.bilibili.com/video/BV1HL4y1p7a1"
        bird100.tags = "鸟,萌宠"
        bird100.authorId = 282239993
        bird100.cover =
            "https://i1.hdslb.com/bfs/archive/427f2b5f13e2b3b6b7e8e582b5232410ac96aade.jpg"
        bird100.videoType = 0
        list.add(bird100)

        val bird101 = PetVideo()
        bird101.type = VideoType.BIRD.ordinal
        bird101.fileName = "bird101"
        bird101.code = 977
        bird101.duration = 96
        bird101.isStar = true
        bird101.title = "雄翠鸟送鱼给雌翠鸟"
        bird101.releaseTime = "2021-04-16 12:11:47"
        bird101.originalUrl = "https://www.bilibili.com/video/BV1Mf4y1s7HA"
        bird101.tags = "鸟,萌宠"
        bird101.authorId = 24672152
        bird101.cover =
            "https://i2.hdslb.com/bfs/archive/52e61cf5f69bd4b3b5c6e4a6c4fe8ecea2c34c4a.jpg"
        bird101.videoType = 0
        list.add(bird101)

        val bird102 = PetVideo()
        bird102.type = VideoType.BIRD.ordinal
        bird102.fileName = "bird102"
        bird102.code = 978
        bird102.duration = 219
        bird102.isStar = true
        bird102.title = "翠鸟捕鱼一条又一条，吃鱼时更讲究：将鱼摔晕后，吃鱼先吃头！"
        bird102.releaseTime = "2021-11-28 15:16:44"
        bird102.originalUrl = "https://www.bilibili.com/video/BV1y34y197yP"
        bird102.tags = "鸟,萌宠"
        bird102.authorId = 282239993
        bird102.cover =
            "https://i1.hdslb.com/bfs/archive/203a9999e03b39ab927feedaad2b4dad9a74c02a.jpg"
        bird102.videoType = 0
        list.add(bird102)

        val bird103 = PetVideo()
        bird103.type = VideoType.BIRD.ordinal
        bird103.fileName = "bird103"
        bird103.code = 979
        bird103.duration = 359
        bird103.isStar = true
        bird103.title = "原来漂亮的鸡在中国，都是神仙颜值！"
        bird103.releaseTime = "2019-08-27 16:28:57"
        bird103.originalUrl = "https://www.bilibili.com/video/BV1r4411B72M"
        bird103.tags = "鸟,萌宠"
        bird103.authorId = 282239993
        bird103.cover =
            "https://i1.hdslb.com/bfs/archive/9eec6f9f89a8f829fe4b74809d0e46d7cb9e9c23.jpg"
        bird103.videoType = 0
        list.add(bird103)

        val bird104 = PetVideo()
        bird104.type = VideoType.BIRD.ordinal
        bird104.fileName = "bird104"
        bird104.code = 980
        bird104.duration = 202
        bird104.isStar = true
        bird104.title = "成群出没的仙鸟，白鹇鸟美丽又高贵，人见人爱！"
        bird104.releaseTime = "2021-12-05 12:53:58"
        bird104.originalUrl = "https://www.bilibili.com/video/BV1qY411p7qd"
        bird104.tags = "鸟,萌宠"
        bird104.authorId = 282239993
        bird104.cover =
            "https://i2.hdslb.com/bfs/archive/a165af22e8a552c66c27320ac0d37646c0bf8306.jpg"
        bird104.videoType = 0
        list.add(bird104)

        val bird105 = PetVideo()
        bird105.type = VideoType.BIRD.ordinal
        bird105.fileName = "bird105"
        bird105.code = 981
        bird105.duration = 170
        bird105.isStar = true
        bird105.title = "这就是传说中的凤凰吗？原来大自然真有啊，也太漂亮了吧！"
        bird105.releaseTime = "2021-12-08 12:51:43"
        bird105.originalUrl = "https://www.bilibili.com/video/BV1fL41177A1"
        bird105.tags = "鸟,萌宠"
        bird105.authorId = 282239993
        bird105.cover =
            "https://i1.hdslb.com/bfs/archive/3288a43c10663899183bee026e9171a9e104a5dd.jpg"
        bird105.videoType = 0
        list.add(bird105)

        val bird106 = PetVideo()
        bird106.type = VideoType.BIRD.ordinal
        bird106.fileName = "bird106"
        bird106.code = 982
        bird106.duration = 35
        bird106.isStar = true
        bird106.title = "狼吞虎咽的红耳鹎"
        bird106.releaseTime = "2021-09-30 19:35:03"
        bird106.originalUrl = "https://www.bilibili.com/video/BV1Hu411f7XP"
        bird106.tags = "鸟,萌宠"
        bird106.authorId = 1508960036
        bird106.cover =
            "https://i0.hdslb.com/bfs/archive/5a1a50bb850fb30dc0ca688cfc344c51ff208732.jpg"
        bird106.videoType = 0
        list.add(bird106)

        val bird107 = PetVideo()
        bird107.type = VideoType.BIRD.ordinal
        bird107.fileName = "bird107"
        bird107.code = 983
        bird107.duration = 254
        bird107.isStar = true
        bird107.title = "一 串 长尾山雀"
        bird107.releaseTime = "2021-09-18 10:35:05"
        bird107.originalUrl = "https://www.bilibili.com/video/BV16g411c7P1"
        bird107.tags = "鸟,萌宠"
        bird107.authorId = 282239993
        bird107.cover =
            "https://i0.hdslb.com/bfs/archive/7a2ff8f4b081545423717fbf650645998ebbab7f.jpg"
        bird107.videoType = 0
        list.add(bird107)

        val bird108 = PetVideo()
        bird108.type = VideoType.BIRD.ordinal
        bird108.fileName = "bird108"
        bird108.code = 984
        bird108.duration = 114
        bird108.isStar = true
        bird108.title = "自古黑白出萌物，又出史上最萌鸟类"
        bird108.releaseTime = "2020-03-18 00:19:33"
        bird108.originalUrl = "https://www.bilibili.com/video/BV1k7411Z7tA"
        bird108.tags = "鸟,萌宠"
        bird108.authorId = 282239993
        bird108.cover =
            "https://i0.hdslb.com/bfs/archive/7c1c9352442c20324a9e8d58426acf2c23d4f688.jpg"
        bird108.videoType = 0
        list.add(bird108)

        val bird109 = PetVideo()
        bird109.type = VideoType.BIRD.ordinal
        bird109.fileName = "bird109"
        bird109.code = 985
        bird109.duration = 50
        bird109.isStar = true
        bird109.title = "鸟界大熊猫，萌面杀手白腿小隼"
        bird109.releaseTime = "2019-05-20 16:29:35"
        bird109.originalUrl = "https://www.bilibili.com/video/BV1a4411j7FE"
        bird109.tags = "鸟,萌宠"
        bird109.authorId = 282239993
        bird109.cover =
            "https://i1.hdslb.com/bfs/archive/58d301c56e86fd2cf7316c023daa1aca9480f21d.jpg"
        bird109.videoType = 0
        list.add(bird109)

        val bird110 = PetVideo()
        bird110.type = VideoType.BIRD.ordinal
        bird110.fileName = "bird110"
        bird110.code = 986
        bird110.duration = 139
        bird110.isStar = true
        bird110.title = "这就是会飞的“熊猫”，号称世上最小萌禽，数量极少！"
        bird110.releaseTime = "2021-12-21 17:18:19"
        bird110.originalUrl = "https://www.bilibili.com/video/BV1MF41167KJ"
        bird110.tags = "鸟,萌宠"
        bird110.authorId = 282239993
        bird110.cover =
            "https://i0.hdslb.com/bfs/archive/968efacd13d8ca3800396eab67e5c99e31fae4a6.jpg"
        bird110.videoType = 0
        list.add(bird110)

        val bird111 = PetVideo()
        bird111.type = VideoType.BIRD.ordinal
        bird111.fileName = "bird111"
        bird111.code = 987
        bird111.duration = 360
        bird111.isStar = true
        bird111.title = "一只胖乎乎的红腹灰雀，在秋高气爽的天气里 吃 野 果 子"
        bird111.releaseTime = "2020-10-17 12:00:27"
        bird111.originalUrl = "https://www.bilibili.com/video/BV1Mv411k7ae"
        bird111.tags = "鸟,萌宠"
        bird111.authorId = 282239993
        bird111.cover =
            "https://i0.hdslb.com/bfs/archive/e9d196222dfc4471f861bb45aab6cf90615142a0.jpg"
        bird111.videoType = 0
        list.add(bird111)

        val bird112 = PetVideo()
        bird112.type = VideoType.BIRD.ordinal
        bird112.fileName = "bird112"
        bird112.code = 988
        bird112.duration = 163
        bird112.isStar = true
        bird112.title = "[红腹灰雀]雪中一抹红团子"
        bird112.releaseTime = "2021-10-18 19:00:01"
        bird112.originalUrl = "https://www.bilibili.com/video/BV12L411s7an"
        bird112.tags = "鸟,萌宠"
        bird112.authorId = 205319947
        bird112.cover =
            "https://i1.hdslb.com/bfs/archive/82d7893c9f5f092a8abaa7f4b113db4402c9663f.jpg"
        bird112.videoType = 0
        list.add(bird112)

        val bird113 = PetVideo()
        bird113.type = VideoType.BIRD.ordinal
        bird113.fileName = "bird113"
        bird113.code = 989
        bird113.duration = 173
        bird113.isStar = true
        bird113.title = "【虹雉属】坠入凡间的彩虹"
        bird113.releaseTime = "2021-03-13 15:31:22"
        bird113.originalUrl = "https://www.bilibili.com/video/BV1W5411K78u"
        bird113.tags = "鸟,萌宠"
        bird113.authorId = 66903212
        bird113.cover =
            "https://i2.hdslb.com/bfs/archive/7d8f95dc9132d8000484531a08ab6a8db8357fa8.jpg"
        bird113.videoType = 0
        list.add(bird113)

        val bird114 = PetVideo()
        bird114.type = VideoType.BIRD.ordinal
        bird114.fileName = "bird114"
        bird114.code = 990
        bird114.duration = 127
        bird114.isStar = true
        bird114.title = "【观鸟记录】新年的羽毛朋友们"
        bird114.releaseTime = "2022-01-01 17:37:59"
        bird114.originalUrl = "https://www.bilibili.com/video/BV1Qm4y1Q7qY"
        bird114.tags = "鸟,萌宠"
        bird114.authorId = 4860510
        bird114.cover =
            "https://i2.hdslb.com/bfs/archive/ba2231f8bc90bcc1811bc0c7d09e2b3b18f20d3e.jpg"
        bird114.videoType = 0
        list.add(bird114)

        val bird115 = PetVideo()
        bird115.type = VideoType.BIRD.ordinal
        bird115.fileName = "bird115"
        bird115.code = 991
        bird115.duration = 15
        bird115.isStar = true
        bird115.title = "【领岩鹨】在山顶邂逅的不怕人走地鸟"
        bird115.releaseTime = "2021-12-19 23:42:31"
        bird115.originalUrl = "https://www.bilibili.com/video/BV13i4y1o7wh"
        bird115.tags = "鸟,萌宠"
        bird115.authorId = 674272488
        bird115.cover =
            "https://i0.hdslb.com/bfs/archive/606b990f7fd169bb0ea7f210cc6373140c67dd17.jpg"
        bird115.videoType = 0
        list.add(bird115)

        val bird116 = PetVideo()
        bird116.type = VideoType.BIRD.ordinal
        bird116.fileName = "bird116"
        bird116.code = 992
        bird116.duration = 151
        bird116.isStar = true
        bird116.title = "麻雀：我有快到模糊的跑步技巧"
        bird116.releaseTime = "2022-01-06 15:19:23"
        bird116.originalUrl = "https://www.bilibili.com/video/BV1Vr4y1U7kb"
        bird116.tags = "鸟,萌宠"
        bird116.authorId = 333882
        bird116.cover =
            "https://i1.hdslb.com/bfs/archive/3e8c529bce0840e6e5ed7498b2d7d68d2db4c28d.jpg"
        bird116.videoType = 0
        list.add(bird116)

        val bird117 = PetVideo()
        bird117.type = VideoType.BIRD.ordinal
        bird117.fileName = "bird117"
        bird117.code = 993
        bird117.duration = 134
        bird117.isStar = true
        bird117.title = "【鹤之舞】终于知道丹顶鹤为什么叫仙鹤了"
        bird117.releaseTime = "2021-11-19 19:25:07"
        bird117.originalUrl = "https://www.bilibili.com/video/BV1134y1d7K9"
        bird117.tags = "鸟,萌宠"
        bird117.authorId = 163894281
        bird117.cover =
            "https://i2.hdslb.com/bfs/archive/6c73b792394c367e530842c452d16bd589182f53.jpg"
        bird117.videoType = 0
        list.add(bird117)

        val bird118 = PetVideo()
        bird118.type = VideoType.BIRD.ordinal
        bird118.fileName = "bird118"
        bird118.code = 994
        bird118.duration = 171
        bird118.isStar = true
        bird118.title = "【白孔雀】天仙下凡～美得很～"
        bird118.releaseTime = "2018-12-11 18:18:16"
        bird118.originalUrl = "https://www.bilibili.com/video/BV1rt411q748"
        bird118.tags = "鸟,萌宠"
        bird118.authorId = 44525061
        bird118.cover =
            "https://i2.hdslb.com/bfs/archive/eb4fce6b03358a2e047479ae121dcd1833e1f83c.jpg"
        bird118.videoType = 0
        list.add(bird118)

        val bird119 = PetVideo()
        bird119.type = VideoType.BIRD.ordinal
        bird119.fileName = "bird119"
        bird119.code = 995
        bird119.duration = 23
        bird119.isStar = true
        bird119.title = "天 鹅 之 美"
        bird119.releaseTime = "2022-01-25 13:06:31"
        bird119.originalUrl = "https://www.bilibili.com/video/BV1xb4y1n7yL"
        bird119.tags = "鸟,萌宠"
        bird119.authorId = 282239993
        bird119.cover =
            "https://i2.hdslb.com/bfs/archive/644fa1751b798c8fc517c337b156be1ca96d3ab5.jpg"
        bird119.videoType = 0
        list.add(bird119)

        val bird120 = PetVideo()
        bird120.type = VideoType.BIRD.ordinal
        bird120.fileName = "bird120"
        bird120.code = 996
        bird120.duration = 98
        bird120.isStar = true
        bird120.title = "疯狂拔草（有点过年的气氛了）"
        bird120.releaseTime = "2022-01-22 21:17:37"
        bird120.originalUrl = "https://www.bilibili.com/video/BV1rL4y1479B"
        bird120.tags = "鸟,萌宠"
        bird120.authorId = 73292437
        bird120.cover =
            "https://i2.hdslb.com/bfs/archive/456f8f102799c02907b29dd42f8351447d69082e.jpg"
        bird120.videoType = 0
        list.add(bird120)

        val bird121 = PetVideo()
        bird121.type = VideoType.BIRD.ordinal
        bird121.fileName = "bird121"
        bird121.code = 997
        bird121.duration = 79
        bird121.isStar = true
        bird121.title = "一群排队洗澡的绣眼鸟，像极了抹茶团子，太可爱了啊"
        bird121.releaseTime = "2021-08-28 16:48:55"
        bird121.originalUrl = "https://www.bilibili.com/video/BV1eQ4y117kw"
        bird121.tags = "鸟,萌宠"
        bird121.authorId = 282239993
        bird121.cover =
            "https://i2.hdslb.com/bfs/archive/8e7e227303ea3b315b09b7838ccf61ec6ad243fe.jpg"
        bird121.videoType = 0
        list.add(bird121)

        val bird122 = PetVideo()
        bird122.type = VideoType.BIRD.ordinal
        bird122.fileName = "bird122"
        bird122.code = 998
        bird122.duration = 91
        bird122.isStar = true
        bird122.title = "文须雀：我不是肥嘟嘟，是毛茸茸！"
        bird122.releaseTime = "2020-02-22 12:15:25"
        bird122.originalUrl = "https://www.bilibili.com/video/BV1o7411A7ZQ"
        bird122.tags = "鸟,萌宠"
        bird122.authorId = 282239993
        bird122.cover =
            "https://i0.hdslb.com/bfs/archive/643df971a35f0594d3d7f4d9380c801625fe5f65.jpg"
        bird122.videoType = 0
        list.add(bird122)

        val bird123 = PetVideo()
        bird123.type = VideoType.BIRD.ordinal
        bird123.fileName = "bird123"
        bird123.code = 999
        bird123.duration = 130
        bird123.isStar = true
        bird123.title = "让俺康康是谁还没来看我"
        bird123.releaseTime = "2021-09-18 17:51:18"
        bird123.originalUrl = "https://www.bilibili.com/video/BV1E341127yP"
        bird123.tags = "鸟,萌宠"
        bird123.authorId = 1229013561
        bird123.cover =
            "https://i2.hdslb.com/bfs/archive/20b4c8510299d00b73b0e48fbc47ba6669157a0e.jpg"
        bird123.videoType = 0
        list.add(bird123)

        val bird124 = PetVideo()
        bird124.type = VideoType.BIRD.ordinal
        bird124.fileName = "bird124"
        bird124.code = 1000
        bird124.duration = 152
        bird124.isStar = true
        bird124.title = "木棉花和鸟儿的好天气"
        bird124.releaseTime = "2021-03-07 16:07:25"
        bird124.originalUrl = "https://www.bilibili.com/video/BV1iz4y117F3"
        bird124.tags = "鸟,萌宠"
        bird124.authorId = 67141118
        bird124.cover =
            "https://i1.hdslb.com/bfs/archive/adad7a66d94765db60b5215fc004217d1d432510.jpg"
        bird124.videoType = 0
        list.add(bird124)

        val bird125 = PetVideo()
        bird125.type = VideoType.BIRD.ordinal
        bird125.fileName = "bird125"
        bird125.code = 1001
        bird125.duration = 91
        bird125.isStar = true
        bird125.title = "“鸟界顶流”齐出镜！美貌“小凤凰”、优雅大天鹅、高贵黑颈鹤，谁是你最爱？【资讯】【英字】"
        bird125.releaseTime = "2021-01-31 16:51:10"
        bird125.originalUrl = "https://www.bilibili.com/video/BV1qU4y1s7a9"
        bird125.tags = "鸟,萌宠"
        bird125.authorId = 545480869
        bird125.cover =
            "https://i2.hdslb.com/bfs/archive/10d145f7ae0c12ac74ab0f389bcbb89444521b46.jpg"
        bird125.videoType = 0
        list.add(bird125)

        val bird126 = PetVideo()
        bird126.type = VideoType.BIRD.ordinal
        bird126.fileName = "bird126"
        bird126.code = 1002
        bird126.duration = 26
        bird126.isStar = true
        bird126.title = "甘肃省省鸟：红腹锦鸡"
        bird126.releaseTime = "2020-10-06 15:30:07"
        bird126.originalUrl = "https://www.bilibili.com/video/BV1J54y1y7ke"
        bird126.tags = "鸟,萌宠"
        bird126.authorId = 514470783
        bird126.cover =
            "https://i0.hdslb.com/bfs/archive/c790e462daca5c0a8701145af719644917632fc4.jpg"
        bird126.videoType = 0
        list.add(bird126)

        val bird127 = PetVideo()
        bird127.type = VideoType.BIRD.ordinal
        bird127.fileName = "bird127"
        bird127.code = 1003
        bird127.duration = 29
        bird127.isStar = true
        bird127.title = "风雪中的白腹锦鸡"
        bird127.releaseTime = "2021-01-05 13:48:31"
        bird127.originalUrl = "https://www.bilibili.com/video/BV1Vo4y1f7Tb"
        bird127.tags = "鸟,萌宠"
        bird127.authorId = 1955155996
        bird127.cover =
            "https://i1.hdslb.com/bfs/archive/893a41500478a412fdcffbe842473f7ea4612305.jpg"
        bird127.videoType = 0
        list.add(bird127)

        val bird128 = PetVideo()
        bird128.type = VideoType.BIRD.ordinal
        bird128.fileName = "bird128"
        bird128.code = 1004
        bird128.duration = 64
        bird128.isStar = true
        bird128.title = "红腹锦鸡雪地飞舞，太美了！美得像一幅工笔画"
        bird128.releaseTime = "2019-12-05 15:50:55"
        bird128.originalUrl = "https://www.bilibili.com/video/BV1PJ411i7B6"
        bird128.tags = "鸟,萌宠"
        bird128.authorId = 289526217
        bird128.cover =
            "https://i2.hdslb.com/bfs/archive/0be8bbd4c3cd5d4790ce36cc8a58692acba5b928.jpg"
        bird128.videoType = 0
        list.add(bird128)

        val bird129 = PetVideo()
        bird129.type = VideoType.BIRD.ordinal
        bird129.fileName = "bird129"
        bird129.code = 1005
        bird129.duration = 16
        bird129.isStar = true
        bird129.title = "此鸟一出，万事太平"
        bird129.releaseTime = "2020-02-05 13:26:11"
        bird129.originalUrl = "https://www.bilibili.com/video/BV1T7411H7Hs"
        bird129.tags = "鸟,萌宠"
        bird129.authorId = 424063928
        bird129.cover =
            "https://i0.hdslb.com/bfs/archive/10a9df714cda9b30e2c670b869a8db937bba15ed.jpg"
        bird129.videoType = 0
        list.add(bird129)

        val bird130 = PetVideo()
        bird130.type = VideoType.BIRD.ordinal
        bird130.fileName = "bird130"
        bird130.code = 1006
        bird130.duration = 112
        bird130.isStar = true
        bird130.title = "幽居山谷，必是美物|野性中国在行动：绿孔雀4K生活，美到不可方物"
        bird130.releaseTime = "2020-02-24 14:27:44"
        bird130.originalUrl = "https://www.bilibili.com/video/BV1G7411F7C3"
        bird130.tags = "鸟,萌宠"
        bird130.authorId = 488244800
        bird130.cover =
            "https://i2.hdslb.com/bfs/archive/8fd9403f17f67fa70edd2361b6efeae430a04d2a.jpg"
        bird130.videoType = 0
        list.add(bird130)

        val bird131 = PetVideo()
        bird131.type = VideoType.BIRD.ordinal
        bird131.fileName = "bird131"
        bird131.code = 1007
        bird131.duration = 24
        bird131.isStar = true
        bird131.title = "中国本土绿孔雀的仙美之姿"
        bird131.releaseTime = "2020-11-12 21:21:52"
        bird131.originalUrl = "https://www.bilibili.com/video/BV1d5411V73E"
        bird131.tags = "鸟,萌宠"
        bird131.authorId = 224462833
        bird131.cover =
            "https://i1.hdslb.com/bfs/archive/dcacd11bc1edc9bbbfd95721fbfaaacd01608363.jpg"
        bird131.videoType = 0
        list.add(bird131)

        val bird132 = PetVideo()
        bird132.type = VideoType.BIRD.ordinal
        bird132.fileName = "bird132"
        bird132.code = 1008
        bird132.duration = 153
        bird132.isStar = true
        bird132.title = "【鹤类混剪】云中之君，仙人之姿！"
        bird132.releaseTime = "2021-07-16 14:31:02"
        bird132.originalUrl = "https://www.bilibili.com/video/BV1ff4y1L7As"
        bird132.tags = "鸟,萌宠"
        bird132.authorId = 24751035
        bird132.cover =
            "https://i2.hdslb.com/bfs/archive/da808d992f0dac53e376dbe6499f6df2e5c6e5de.jpg"
        bird132.videoType = 0
        list.add(bird132)

        val bird133 = PetVideo()
        bird133.type = VideoType.BIRD.ordinal
        bird133.fileName = "bird133"
        bird133.code = 1009
        bird133.duration = 46
        bird133.isStar = true
        bird133.title = "解压"
        bird133.releaseTime = "2022-01-01 02:14:47"
        bird133.originalUrl = "https://www.bilibili.com/video/BV1jY411a7Xe"
        bird133.tags = "鸟,萌宠"
        bird133.authorId = 162726537
        bird133.cover =
            "https://i1.hdslb.com/bfs/archive/f7bd52e3757fac181eeb0ddeb6600a98fb7203df.jpg"
        bird133.videoType = 0
        list.add(bird133)

        val bird134 = PetVideo()
        bird134.type = VideoType.BIRD.ordinal
        bird134.fileName = "bird134"
        bird134.code = 1010
        bird134.duration = 26
        bird134.isStar = true
        bird134.title = "鸭妈：好有压力鸭"
        bird134.releaseTime = "2019-11-27 03:52:54"
        bird134.originalUrl = "https://www.bilibili.com/video/BV1tJ411X7sN"
        bird134.tags = "鸟,萌宠"
        bird134.authorId = 165511
        bird134.cover =
            "https://i2.hdslb.com/bfs/archive/0ef7e0c5907aa66c4b94e8e8ac84e212114c706f.jpg"
        bird134.videoType = 0
        list.add(bird134)

        val bird135 = PetVideo()
        bird135.type = VideoType.BIRD.ordinal
        bird135.fileName = "bird135"
        bird135.code = 1011
        bird135.duration = 244
        bird135.isStar = true
        bird135.title = "“这就是我这么喜欢鸟类的原因”"
        bird135.releaseTime = "2022-01-24 18:46:53"
        bird135.originalUrl = "https://www.bilibili.com/video/BV1rF411p7Ai"
        bird135.tags = "鸟,萌宠"
        bird135.authorId = 362831543
        bird135.cover =
            "https://i1.hdslb.com/bfs/archive/32cb8ca8067d5ca7d24f09b7f309e892b1f934b3.jpg"
        bird135.videoType = 0
        list.add(bird135)

        val bird136 = PetVideo()
        bird136.type = VideoType.BIRD.ordinal
        bird136.fileName = "bird136"
        bird136.code = 1012
        bird136.duration = 247
        bird136.isStar = true
        bird136.title = "[红腹灰雀] 圣诞快乐~"
        bird136.releaseTime = "2021-12-27 19:00:12"
        bird136.originalUrl = "https://www.bilibili.com/video/BV1yR4y1W7F5"
        bird136.tags = "鸟,萌宠"
        bird136.authorId = 205319947
        bird136.cover =
            "https://i1.hdslb.com/bfs/archive/b57fdcc828f263611cb124b87a91dbf60d691c2a.jpg"
        bird136.videoType = 0
        list.add(bird136)

        val bird137 = PetVideo()
        bird137.type = VideoType.BIRD.ordinal
        bird137.fileName = "bird137"
        bird137.code = 1013
        bird137.duration = 206
        bird137.isStar = true
        bird137.title = "这么可爱的肥啾咱们国家能见到吗？"
        bird137.releaseTime = "2020-03-11 12:36:11"
        bird137.originalUrl = "https://www.bilibili.com/video/BV1GE411K7Gz"
        bird137.tags = "鸟,萌宠"
        bird137.authorId = 362831543
        bird137.cover =
            "https://i0.hdslb.com/bfs/archive/6490900ea5b3cc8b2951644f8d5be997b3663068.jpg"
        bird137.videoType = 0
        list.add(bird137)

        val bird138 = PetVideo()
        bird138.type = VideoType.BIRD.ordinal
        bird138.fileName = "bird138"
        bird138.code = 1014
        bird138.duration = 88
        bird138.isStar = true
        bird138.title = "最萌人心的鸟类：灰 蓝 山 雀"
        bird138.releaseTime = "2020-04-03 12:44:12"
        bird138.originalUrl = "https://www.bilibili.com/video/BV1p741197wp"
        bird138.tags = "鸟,萌宠"
        bird138.authorId = 282239993
        bird138.cover =
            "https://i0.hdslb.com/bfs/archive/b51ec16fe0b48bfdda1ac01116f85a182bdb2a93.jpg"
        bird138.videoType = 0
        list.add(bird138)

        val bird139 = PetVideo()
        bird139.type = VideoType.BIRD.ordinal
        bird139.fileName = "bird139"
        bird139.code = 1015
        bird139.duration = 118
        bird139.isStar = true
        bird139.title = "[灰蓝山雀]冬天的雪团子"
        bird139.releaseTime = "2022-01-15 19:00:15"
        bird139.originalUrl = "https://www.bilibili.com/video/BV1d3411e7bM"
        bird139.tags = "鸟,萌宠"
        bird139.authorId = 205319947
        bird139.cover =
            "https://i0.hdslb.com/bfs/archive/863c171c849b388255a240084a4a106184071264.jpg"
        bird139.videoType = 0
        list.add(bird139)

        val bird140 = PetVideo()
        bird140.type = VideoType.BIRD.ordinal
        bird140.fileName = "bird140"
        bird140.code = 1016
        bird140.duration = 159
        bird140.isStar = true
        bird140.title = "今天让你们见识一下鸟类的真正天籁之音，听完先收藏起来"
        bird140.releaseTime = "2019-03-26 17:32:26"
        bird140.originalUrl = "https://www.bilibili.com/video/BV1Vb411t7Sy"
        bird140.tags = "鸟,萌宠"
        bird140.authorId = 282239993
        bird140.cover =
            "https://i1.hdslb.com/bfs/archive/bcd65c382056db6544e03eaee1ab620b04f490ad.jpg"
        bird140.videoType = 0
        list.add(bird140)

        val bird141 = PetVideo()
        bird141.type = VideoType.BIRD.ordinal
        bird141.fileName = "bird141"
        bird141.code = 1017
        bird141.duration = 468
        bird141.isStar = true
        bird141.title = "【红腹灰雀】一群吃货小胖子"
        bird141.releaseTime = "2022-01-01 13:58:04"
        bird141.originalUrl = "https://www.bilibili.com/video/BV1c44y1E7FY"
        bird141.tags = "鸟,萌宠"
        bird141.authorId = 282239993
        bird141.cover =
            "https://i1.hdslb.com/bfs/archive/49fc96318222e7479413f1a70c0a7955a3cb95ae.jpg"
        bird141.videoType = 0
        list.add(bird141)

        val bird142 = PetVideo()
        bird142.type = VideoType.BIRD.ordinal
        bird142.fileName = "bird142"
        bird142.code = 1018
        bird142.duration = 116
        bird142.isStar = true
        bird142.title = "小肥啾北长尾山雀，小丸子来啦！"
        bird142.releaseTime = "2022-01-05 12:05:21"
        bird142.originalUrl = "https://www.bilibili.com/video/BV1db4y1e7kE"
        bird142.tags = "鸟,萌宠"
        bird142.authorId = 282239993
        bird142.cover =
            "https://i2.hdslb.com/bfs/archive/317f767bdf17ca4d555050f6f8f1938668151590.jpg"
        bird142.videoType = 0
        list.add(bird142)

        val bird143 = PetVideo()
        bird143.type = VideoType.BIRD.ordinal
        bird143.fileName = "bird143"
        bird143.code = 1019
        bird143.duration = 57
        bird143.isStar = true
        bird143.title = "麻薯团子小肥啾，奶凶奶凶惹人爱"
        bird143.releaseTime = "2021-02-10 16:32:24"
        bird143.originalUrl = "https://www.bilibili.com/video/BV1nv4y1Z7N3"
        bird143.tags = "鸟,萌宠"
        bird143.authorId = 449342345
        bird143.cover =
            "https://i2.hdslb.com/bfs/archive/0d0000949a4d66c3f8f7f2b0d68cc47813b1d85e.jpg"
        bird143.videoType = 0
        list.add(bird143)

        val bird144 = PetVideo()
        bird144.type = VideoType.BIRD.ordinal
        bird144.fileName = "bird144"
        bird144.code = 1020
        bird144.duration = 83
        bird144.isStar = true
        bird144.title = "摇头晃脑杀"
        bird144.releaseTime = "2020-10-15 23:49:26"
        bird144.originalUrl = "https://www.bilibili.com/video/BV1gy4y1r7ih"
        bird144.tags = "鸟,萌宠"
        bird144.authorId = 601626592
        bird144.cover =
            "https://i1.hdslb.com/bfs/archive/0af4ebd35da9035635f23a2decbe4c5f98e2b7a7.jpg"
        bird144.videoType = 0
        list.add(bird144)

        val bird145 = PetVideo()
        bird145.type = VideoType.BIRD.ordinal
        bird145.fileName = "bird145"
        bird145.code = 427
        bird145.duration = 210
        bird145.period = PeriodType.SINGLE.ordinal
        bird145.isStar = true
        bird145.title = "【鹤科混剪】鹤之舞 或许这就是神仙之姿吧 （野生鸟片系列）"
        bird145.releaseTime = "2020-03-23 18:23:38"
        bird145.originalUrl = "https://www.bilibili.com/video/BV1WE411F7p9"
        bird145.tags = "鹤,丹顶鹤,萌宠,动物圈"
        bird145.authorId = 1583050
        bird145.cover =
            "https://i0.hdslb.com/bfs/archive/7643dcb1726a5ec7b0f446edc015b5f7042476bf.jpg"
        bird145.videoType = 3
        list.add(bird145)

        return list
    }
}