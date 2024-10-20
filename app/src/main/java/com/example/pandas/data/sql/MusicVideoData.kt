package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object MusicVideoData {
    private val list = mutableListOf<PetVideo>()
    fun getMusicVideoData(): MutableList<PetVideo> {

        val music1 = PetVideo()
        music1.type = VideoType.MUSIC.ordinal
        music1.fileName = "music1"
        music1.code = 1131
        music1.duration = 228
        music1.star = true
        music1.title = "【4K修复】王心凌《DADADA》 do do do lu lu lu Da da da「2006 No.1 庆功演唱会」"
        music1.releaseTime = 1616256703
        music1.originalUrl = "https://www.bilibili.com/video/BV1zA411N7ct"
        music1.tags = "音乐,歌曲,MV"
        music1.authorId = 326838748
        music1.cover =
            "https://i2.hdslb.com/bfs/archive/207c89db37528513180f6cf495a0790598b41417.png"
        music1.vertical = false
        list.add(music1)

        val music2 = PetVideo()
        music2.type = VideoType.MUSIC.ordinal
        music2.fileName = "music2"
        music2.code = 1132
        music2.duration = 267
        music2.star = true
        music2.title = "人道渺渺，仙道莽莽，鬼道乐兮"
        music2.releaseTime = 1562093655
        music2.originalUrl = "https://www.bilibili.com/video/BV1Nx411975J"
        music2.tags = "音乐,歌曲,MV"
        music2.authorId = 3966859
        music2.cover =
            "https://i2.hdslb.com/bfs/archive/dc84d0f95dd7adff43241de151e341c111b986b0.jpg"
        music2.vertical = false
        list.add(music2)

        val music3 = PetVideo()
        music3.type = VideoType.MUSIC.ordinal
        music3.fileName = "music3"
        music3.code = 1133
        music3.duration = 287
        music3.star = true
        music3.title = "【4K60FPS】成龙、金喜善《美丽的神话》王炸神曲！真的很感人！"
        music3.releaseTime = 1628424687
        music3.originalUrl = "https://www.bilibili.com/video/BV1ty4y1L78S"
        music3.tags = "音乐,歌曲,MV"
        music3.authorId = 229733301
        music3.cover =
            "https://i1.hdslb.com/bfs/archive/66981dec88b9f9a4fc31b33243364977b530074d.jpg"
        music3.vertical = false
        list.add(music3)

        val music4 = PetVideo()
        music4.type = VideoType.MUSIC.ordinal
        music4.fileName = "music4"
        music4.code = 1134
        music4.duration = 274
        music4.star = true
        music4.title = "【4K60FPS】席琳·迪翁《我心永恒》奥斯卡金曲！《泰坦尼克号》主题曲！"
        music4.releaseTime = 1628683680
        music4.originalUrl = "https://www.bilibili.com/video/BV1P341167qB"
        music4.tags = "音乐,歌曲,MV"
        music4.authorId = 229733301
        music4.cover =
            "https://i2.hdslb.com/bfs/archive/c2727f3cd8a08ff4d64505699c85663411fdecdd.jpg"
        music4.vertical = false
        list.add(music4)

        val music5 = PetVideo()
        music5.type = VideoType.MUSIC.ordinal
        music5.fileName = "music5"
        music5.code = 1135
        music5.duration = 508
        music5.star = true
        music5.title = "【1080p重置】王心凌《花的嫁纱》爱，在孤独中绝望，在绝望中坚强「2004 爱在星光演唱会」"
        music5.releaseTime = 1616161581
        music5.originalUrl = "https://www.bilibili.com/video/BV1SV411Y7aB"
        music5.tags = "音乐,歌曲,MV"
        music5.authorId = 326838748
        music5.cover =
            "https://i0.hdslb.com/bfs/archive/58fa1a145201f8de18c9b5c989e86f419f0f8461.png"
        music5.vertical = false
        list.add(music5)

        val music6 = PetVideo()
        music6.type = VideoType.MUSIC.ordinal
        music6.fileName = "music6"
        music6.code = 1136
        music6.duration = 227
        music6.star = true
        music6.title = "【绝版】超级爱！王心凌《第一次爱的人》现场LIVE"
        music6.releaseTime = 1583661611
        music6.originalUrl = "https://www.bilibili.com/video/BV1SE411p7du"
        music6.tags = "音乐,歌曲,MV"
        music6.authorId = 229733301
        music6.cover =
            "https://i1.hdslb.com/bfs/archive/f3f0794d746a5573c152987fa77375cf257d728d.jpg"
        music6.vertical = false
        list.add(music6)

        val music7 = PetVideo()
        music7.type = VideoType.MUSIC.ordinal
        music7.fileName = "music7"
        music7.code = 1137
        music7.duration = 155
        music7.star = true
        music7.title = "《喀秋莎》，本人超喜欢的一个版本"
        music7.releaseTime = 1600250325
        music7.originalUrl = "https://www.bilibili.com/video/BV1PV411m73F"
        music7.tags = "音乐,歌曲,MV"
        music7.authorId = 217921940
        music7.cover =
            "https://i2.hdslb.com/bfs/archive/33e5f549bfb8d7ec71b1377eab109cc181d5c110.jpg"
        music7.vertical = false
        list.add(music7)

        val music8 = PetVideo()
        music8.type = VideoType.MUSIC.ordinal
        music8.fileName = "music8"
        music8.code = 1138
        music8.duration = 210
        music8.star = true
        music8.title = "【4K修复】王心凌《Honey》猛男必看，甜蜜情歌「2006No.1 庆功演唱会」"
        music8.releaseTime = 1616405528
        music8.originalUrl = "https://www.bilibili.com/video/BV1Cp4y1h7H4"
        music8.tags = "音乐,歌曲,MV"
        music8.authorId = 326838748
        music8.cover =
            "https://i2.hdslb.com/bfs/archive/d9e480897482d2a145ef5ac98b17c56c2a7b6365.png"
        music8.vertical = false
        list.add(music8)

        val music9 = PetVideo()
        music9.type = VideoType.MUSIC.ordinal
        music9.fileName = "music9"
        music9.code = 1139
        music9.duration = 603
        music9.star = true
        music9.title = "【4K修复】王心凌《当你》当你的眼睛眯着笑「2006No.1 庆功演唱会」"
        music9.releaseTime = 1616405301
        music9.originalUrl = "https://www.bilibili.com/video/BV16b4y19728"
        music9.tags = "音乐,歌曲,MV"
        music9.authorId = 326838748
        music9.cover =
            "https://i1.hdslb.com/bfs/archive/39c0e958687971efcd5c954d514169144bde472d.png"
        music9.vertical = false
        list.add(music9)

        val music10 = PetVideo()
        music10.type = VideoType.MUSIC.ordinal
        music10.fileName = "music10"
        music10.code = 1140
        music10.duration = 446
        music10.star = true
        music10.title = "【4K60FPS】王心凌《第一次爱的人》 一点点慢慢的死掉「2004梦幻游园地演唱会」"
        music10.releaseTime = 1616126181
        music10.originalUrl = "https://www.bilibili.com/video/BV1LV411e74T"
        music10.tags = "音乐,歌曲,MV"
        music10.authorId = 326838748
        music10.cover =
            "https://i0.hdslb.com/bfs/archive/2178929eb186a1c3b74368e1e0f8e9c6dbb3326b.png"
        music10.vertical = false
        list.add(music10)

        val music11 = PetVideo()
        music11.type = VideoType.MUSIC.ordinal
        music11.fileName = "music11"
        music11.code = 1141
        music11.duration = 495
        music11.star = true
        music11.title = "【4K修复】王心凌《睫毛弯弯》眼睛眨啊眨「2006No.1 庆功演唱会」"
        music11.releaseTime = 1616075749
        music11.originalUrl = "https://www.bilibili.com/video/BV1Dy4y187X6"
        music11.tags = "音乐,歌曲,MV"
        music11.authorId = 326838748
        music11.cover =
            "https://i1.hdslb.com/bfs/archive/627d9c414509392f4022fedde52749b40d2dc711.png"
        music11.vertical = false
        list.add(music11)

        val music12 = PetVideo()
        music12.type = VideoType.MUSIC.ordinal
        music12.fileName = "music12"
        music12.code = 1142
        music12.duration = 235
        music12.star = true
        music12.title = "【4K修复】王心凌《梦的光点》神兵小将！我追着梦的光点「2006No.1 庆功演唱会」"
        music12.releaseTime = 1616405323
        music12.originalUrl = "https://www.bilibili.com/video/BV1J64y1D7Qs"
        music12.tags = "音乐,歌曲,MV"
        music12.authorId = 326838748
        music12.cover =
            "https://i1.hdslb.com/bfs/archive/35b94b9ee6f77307c99b2f27b10a7ed68f46db99.png"
        music12.vertical = false
        list.add(music12)

        val music13 = PetVideo()
        music13.type = VideoType.MUSIC.ordinal
        music13.fileName = "music13"
        music13.code = 1143
        music13.duration = 172
        music13.star = true
        music13.title = "有酒乐逍遥，无酒我亦颠—— 记酒剑仙谢君豪（仙剑经典BGM）"
        music13.releaseTime = 1462294857
        music13.originalUrl = "https://www.bilibili.com/video/BV1Rs411q7bA"
        music13.tags = "音乐,歌曲,MV"
        music13.authorId = 13272167
        music13.cover =
            "https://i2.hdslb.com/bfs/archive/530debdb3d844e045a4ced37b6c430da16562b74.jpg"
        music13.vertical = false
        list.add(music13)

        val music14 = PetVideo()
        music14.type = VideoType.MUSIC.ordinal
        music14.fileName = "music14"
        music14.code = 1144
        music14.duration = 227
        music14.star = true
        music14.title = "“天上剑仙三百万，遇我也需尽低眉”"
        music14.releaseTime = 1580115125
        music14.originalUrl = "https://www.bilibili.com/video/BV1q741167W5"
        music14.tags = "音乐,歌曲,MV"
        music14.authorId = 34840587
        music14.cover =
            "https://i0.hdslb.com/bfs/archive/95122b294dcf0aea3d770af311117f521d36422b.jpg"
        music14.vertical = false
        list.add(music14)

        val music15 = PetVideo()
        music15.type = VideoType.MUSIC.ordinal
        music15.fileName = "music15"
        music15.code = 1145
        music15.duration = 315
        music15.star = true
        music15.title = "逍遥叹"
        music15.releaseTime = 1553349134
        music15.originalUrl = "https://www.bilibili.com/video/BV1zb411779E"
        music15.tags = "音乐,歌曲,MV"
        music15.authorId = 21120530
        music15.cover =
            "https://i1.hdslb.com/bfs/archive/c864f3322201078aee300ab5a4a600e3408af87f.jpg"
        music15.vertical = false
        list.add(music15)

        val music16 = PetVideo()
        music16.type = VideoType.MUSIC.ordinal
        music16.fileName = "music16"
        music16.code = 1146
        music16.duration = 201
        music16.star = true
        music16.title = "【刘亦菲】仙剑奇侠传一（莫失莫忘）"
        music16.releaseTime = 1489763108
        music16.originalUrl = "https://www.bilibili.com/video/BV1qx411r7tN"
        music16.tags = "音乐,歌曲,MV"
        music16.authorId = 13966989
        music16.cover =
            "https://i1.hdslb.com/bfs/archive/925a71cab1c07cb4935858de02057cff63464104.jpg"
        music16.vertical = false
        list.add(music16)

        val music17 = PetVideo()
        music17.type = VideoType.MUSIC.ordinal
        music17.fileName = "music17"
        music17.code = 1147
        music17.duration = 231
        music17.star = true
        music17.title = "【桃花岛】仙剑奇侠传一首死亡bgm，神曲不解释"
        music17.releaseTime = 1493279705
        music17.originalUrl = "https://www.bilibili.com/video/BV1ox411U7Lx"
        music17.tags = "音乐,歌曲,MV"
        music17.authorId = 31656568
        music17.cover =
            "https://i1.hdslb.com/bfs/archive/11e5dd812bb3eef1fb7ee603237b2c582655723f.jpg"
        music17.vertical = false
        list.add(music17)

        val music18 = PetVideo()
        music18.type = VideoType.MUSIC.ordinal
        music18.fileName = "music18"
        music18.code = 1148
        music18.duration = 221
        music18.star = true
        music18.title = "《珍珠港》电影原声主题曲———「tennessee」"
        music18.releaseTime = 1541287196
        music18.originalUrl = "https://www.bilibili.com/video/BV1ab411w7tm"
        music18.tags = "音乐,歌曲,MV"
        music18.authorId = 306815937
        music18.cover =
            "https://i1.hdslb.com/bfs/archive/c310750d8e87edc1c8a4493d0d0fafb20f94f401.png"
        music18.vertical = false
        list.add(music18)

        val music19 = PetVideo()
        music19.type = VideoType.MUSIC.ordinal
        music19.fileName = "music19"
        music19.code = 1149
        music19.duration = 293
        music19.star = true
        music19.title = "【仙剑一】十五年后，再听灵儿叫一声逍遥哥哥"
        music19.releaseTime = 1584701452
        music19.originalUrl = "https://www.bilibili.com/video/BV1m7411R7cr"
        music19.tags = "音乐,歌曲,MV"
        music19.authorId = 351141843
        music19.cover =
            "https://i1.hdslb.com/bfs/archive/78fc44827e4d88b5785f418a34a26a930f315e00.jpg"
        music19.vertical = false
        list.add(music19)

        val music20 = PetVideo()
        music20.type = VideoType.MUSIC.ordinal
        music20.fileName = "music20"
        music20.code = 1150
        music20.duration = 576
        music20.star = true
        music20.title = "【4K60FPS】《仙剑奇侠传三》王炸神曲合集！每一首都是回忆！"
        music20.releaseTime = 1633172734
        music20.originalUrl = "https://www.bilibili.com/video/BV13L411s79L"
        music20.tags = "音乐,歌曲,MV"
        music20.authorId = 229733301
        music20.cover =
            "https://i2.hdslb.com/bfs/archive/a7a1542e831ff0ef7901b76e927db3d8043fb86f.jpg"
        music20.vertical = false
        list.add(music20)

        val music21 = PetVideo()
        music21.type = VideoType.MUSIC.ordinal
        music21.fileName = "music21"
        music21.code = 1151
        music21.duration = 248
        music21.star = true
        music21.title = "金莎 - 星月神话 官方版"
        music21.releaseTime = 1494506805
        music21.originalUrl = "https://www.bilibili.com/video/BV1dx411m7s9"
        music21.tags = "音乐,歌曲,MV"
        music21.authorId = 755969
        music21.cover =
            "https://i0.hdslb.com/bfs/archive/323887173f17989b0d46c97f2d3cb4903c4cc9dd.jpg"
        music21.vertical = false
        list.add(music21)

        val music22 = PetVideo()
        music22.type = VideoType.MUSIC.ordinal
        music22.fileName = "music22"
        music22.code = 1152
        music22.duration = 284
        music22.star = true
        music22.title = "胡杨林-香水有毒"
        music22.releaseTime = 1503944615
        music22.originalUrl = "https://www.bilibili.com/video/BV1dx41147tr"
        music22.tags = "音乐,歌曲,MV"
        music22.authorId = 23307646
        music22.cover =
            "https://i2.hdslb.com/bfs/archive/3c9abc6449382bdb00ad5d87cdd0c89e6d04b49a.jpg"
        music22.vertical = false
        list.add(music22)

        val music23 = PetVideo()
        music23.type = VideoType.MUSIC.ordinal
        music23.fileName = "music23"
        music23.code = 1153
        music23.duration = 216
        music23.star = true
        music23.title = "【4K60FPS】杨千嬅《可惜我是水瓶座》史上最甜版本！这女人太美了"
        music23.releaseTime = 1600351949
        music23.originalUrl = "https://www.bilibili.com/video/BV1Rv41117JG"
        music23.tags = "音乐,歌曲,MV"
        music23.authorId = 229733301
        music23.cover =
            "https://i0.hdslb.com/bfs/archive/f6c44dedd9883385cf88fa6f716952d295590e85.jpg"
        music23.vertical = false
        list.add(music23)

        val music24 = PetVideo()
        music24.type = VideoType.MUSIC.ordinal
        music24.fileName = "music24"
        music24.code = 1154
        music24.duration = 232
        music24.star = true
        music24.title = "【4K60FPS】陈奕迅《K歌之王》神级现场！忘词和杨千嬅都来了"
        music24.releaseTime = 1605354283
        music24.originalUrl = "https://www.bilibili.com/video/BV1yp4y167a5"
        music24.tags = "音乐,歌曲,MV"
        music24.authorId = 229733301
        music24.cover =
            "https://i0.hdslb.com/bfs/archive/9a5636c8d24f9cfa93e367bd1b1a04c8be8ccec7.jpg"
        music24.vertical = false
        list.add(music24)

        val music25 = PetVideo()
        music25.type = VideoType.MUSIC.ordinal
        music25.fileName = "music25"
        music25.code = 1155
        music25.duration = 298
        music25.star = true
        music25.title = "阿刁-张韶涵  你是自由的鸟"
        music25.releaseTime = 1569203309
        music25.originalUrl = "https://www.bilibili.com/video/BV16J411g7Y2"
        music25.tags = "音乐,歌曲,MV"
        music25.authorId = 286175030
        music25.cover =
            "https://i2.hdslb.com/bfs/archive/f042641aae29074e22a8910513c2e6eb670a367e.png"
        music25.vertical = false
        list.add(music25)

        val music26 = PetVideo()
        music26.type = VideoType.MUSIC.ordinal
        music26.fileName = "music26"
        music26.code = 1156
        music26.duration = 225
        music26.star = true
        music26.title = "【影视金曲分享-《大男人》】腾格尔唱出了所有男人的不容易"
        music26.releaseTime = 1630488581
        music26.originalUrl = "https://www.bilibili.com/video/BV1cA411w79Y"
        music26.tags = "音乐,歌曲,MV"
        music26.authorId = 1618687574
        music26.cover =
            "https://i1.hdslb.com/bfs/archive/eded16b6992faf64efe6737dd878f9490feb3c31.jpg"
        music26.vertical = false
        list.add(music26)

        val music27 = PetVideo()
        music27.type = VideoType.MUSIC.ordinal
        music27.fileName = "music27"
        music27.code = 1157
        music27.duration = 251
        music27.star = true
        music27.title = "【4K60FPS】梅艳芳《夕阳之歌 》告别现场！这是一个传奇！"
        music27.releaseTime = 1637497693
        music27.originalUrl = "https://www.bilibili.com/video/BV1j34y1o7SK"
        music27.tags = "音乐,歌曲,MV"
        music27.authorId = 229733301
        music27.cover =
            "https://i1.hdslb.com/bfs/archive/92a02c73ed0e241ae715bf234a7e3a72b5406cbd.jpg"
        music27.vertical = false
        list.add(music27)

        val music28 = PetVideo()
        music28.type = VideoType.MUSIC.ordinal
        music28.fileName = "music28"
        music28.code = 1158
        music28.duration = 180
        music28.star = true
        music28.title = "【4K60FPS】韩磊《向天再借五百年》经典神曲！《康熙王朝》主题曲！"
        music28.releaseTime = 1627906806
        music28.originalUrl = "https://www.bilibili.com/video/BV13q4y197t7"
        music28.tags = "音乐,歌曲,MV"
        music28.authorId = 229733301
        music28.cover =
            "https://i2.hdslb.com/bfs/archive/2039dbc06a1790df23e3e2239f6cd83369f7ce11.jpg"
        music28.vertical = false
        list.add(music28)

        val music29 = PetVideo()
        music29.type = VideoType.MUSIC.ordinal
        music29.fileName = "music29"
        music29.code = 1159
        music29.duration = 317
        music29.star = true
        music29.title = "【4K60FPS】上杉升、织田哲郎《直到世界的尽头》核爆现场！《灌篮高手》片尾曲！"
        music29.releaseTime = 1617716113
        music29.originalUrl = "https://www.bilibili.com/video/BV19V411n7L3"
        music29.tags = "音乐,歌曲,MV"
        music29.authorId = 229733301
        music29.cover =
            "https://i0.hdslb.com/bfs/archive/3121e152560d6bb976fad4b1dd3a0a0ba0fc8ca4.jpg"
        music29.vertical = false
        list.add(music29)

        val music30 = PetVideo()
        music30.type = VideoType.MUSIC.ordinal
        music30.fileName = "music30"
        music30.code = 1160
        music30.duration = 257
        music30.star = true
        music30.title = "凤凰传奇这首《奢香夫人》又火了，柔情又不失豪迈，太好听了"
        music30.releaseTime = 1614511815
        music30.originalUrl = "https://www.bilibili.com/video/BV1eb4y1X7fK"
        music30.tags = "音乐,歌曲,MV"
        music30.authorId = 560320560
        music30.cover =
            "https://i0.hdslb.com/bfs/archive/b6a14c0db10e3adcf3c28a8aff504538238ecb89.jpg"
        music30.vertical = false
        list.add(music30)

        val music31 = PetVideo()
        music31.type = VideoType.MUSIC.ordinal
        music31.fileName = "music31"
        music31.code = 1161
        music31.duration = 245
        music31.star = true
        music31.title = "凤凰传奇翻唱《海底》"
        music31.releaseTime = 1619283428
        music31.originalUrl = "https://www.bilibili.com/video/BV1qp4y1t7DJ"
        music31.tags = "音乐,歌曲,MV"
        music31.authorId = 504672822
        music31.cover =
            "https://i2.hdslb.com/bfs/archive/8a96eeb1e9068f5a3eae132ea6075622170fc981.jpg"
        music31.vertical = false
        list.add(music31)

        val music32 = PetVideo()
        music32.type = VideoType.MUSIC.ordinal
        music32.fileName = "music32"
        music32.code = 1162
        music32.duration = 262
        music32.star = true
        music32.title = "【邓紫棋x张靓颖】惊艳演绎《雨蝶》，开口跪！"
        music32.releaseTime = 1544791455
        music32.originalUrl = "https://www.bilibili.com/video/BV1Vt411i7kb"
        music32.tags = "音乐,歌曲,MV"
        music32.authorId = 20849066
        music32.cover =
            "https://i2.hdslb.com/bfs/archive/aa12192e1e42117b0df257e42bdcda5c096aec31.jpg"
        music32.vertical = false
        list.add(music32)

        val music33 = PetVideo()
        music33.type = VideoType.MUSIC.ordinal
        music33.fileName = "music33"
        music33.code = 1163
        music33.duration = 209
        music33.star = true
        music33.title = "【VITAS】Vitas维塔斯封神高音《奉献》高清HD. 我母亲的歌演唱会. 2003/11/01."
        music33.releaseTime = 1584198608
        music33.originalUrl = "https://www.bilibili.com/video/BV14E411V7TD"
        music33.tags = "音乐,歌曲,MV"
        music33.authorId = 241047317
        music33.cover =
            "https://i1.hdslb.com/bfs/archive/246c7b4cd48079da502f357a05f716a224cf6a98.jpg"
        music33.vertical = false
        list.add(music33)

        val music34 = PetVideo()
        music34.type = VideoType.MUSIC.ordinal
        music34.fileName = "music34"
        music34.code = 1164
        music34.duration = 518
        music34.star = true
        music34.title = "【龚琳娜】小河淌水 - 超清 - 无台标无观众背景杂音"
        music34.releaseTime = 1474047145
        music34.originalUrl = "https://www.bilibili.com/video/BV1Ns411t7UW"
        music34.tags = "音乐,歌曲,MV"
        music34.authorId = 8864685
        music34.cover =
            "https://i1.hdslb.com/bfs/archive/90c29d0025dce785ee375a0791af1e2e5039b328.jpg"
        music34.vertical = false
        list.add(music34)

        val music35 = PetVideo()
        music35.type = VideoType.MUSIC.ordinal
        music35.fileName = "music35"
        music35.code = 1165
        music35.duration = 301
        music35.star = true
        music35.title = "全网最清晰迈克尔杰克逊Michael Jackson1995年MTV现场Dangerous经典机械舞危险舞蹈高清修复版太空步侧滑步mj珍贵视频"
        music35.releaseTime = 1580482117
        music35.originalUrl = "https://www.bilibili.com/video/BV1Z7411B7uD"
        music35.tags = "音乐,歌曲,MV"
        music35.authorId = 449604910
        music35.cover =
            "https://i1.hdslb.com/bfs/archive/68ab8c41c39dbdf5f9ae489251b06d94fb9468e2.jpg"
        music35.vertical = false
        list.add(music35)

        val music36 = PetVideo()
        music36.type = VideoType.MUSIC.ordinal
        music36.fileName = "music36"
        music36.code = 1166
        music36.duration = 278
        music36.star = true
        music36.title = "【4K60FPS】和田光司《Butter-Fly》核爆现场！永远的无限大！"
        music36.releaseTime = 1617369309
        music36.originalUrl = "https://www.bilibili.com/video/BV1ey4y1t7cy"
        music36.tags = "音乐,歌曲,MV"
        music36.authorId = 229733301
        music36.cover =
            "https://i1.hdslb.com/bfs/archive/1cab2583eed01373fcac0501d9a105404cb019a7.jpg"
        music36.vertical = false
        list.add(music36)

        val music37 = PetVideo()
        music37.type = VideoType.MUSIC.ordinal
        music37.fileName = "music37"
        music37.code = 1167
        music37.duration = 338
        music37.star = true
        music37.title = "WANDS-《直到世界尽头》最经典的现场版"
        music37.releaseTime = 1547054535
        music37.originalUrl = "https://www.bilibili.com/video/BV1ct411x7ED"
        music37.tags = "音乐,歌曲,MV"
        music37.authorId = 23202793
        music37.cover =
            "https://i0.hdslb.com/bfs/archive/7914c7a5f34dd0cf73a60b31520d4830b0bdcd44.jpg"
        music37.vertical = false
        list.add(music37)

        val music38 = PetVideo()
        music38.type = VideoType.MUSIC.ordinal
        music38.fileName = "music38"
        music38.code = 1168
        music38.duration = 321
        music38.star = true
        music38.title = "【4K顶级画质】灌篮高手片尾曲《直到世界的尽头》现场，依旧那么好听！！！"
        music38.releaseTime = 1641905530
        music38.originalUrl = "https://www.bilibili.com/video/BV11F411v7p6"
        music38.tags = "音乐,歌曲,MV"
        music38.authorId = 8843146
        music38.cover =
            "https://i2.hdslb.com/bfs/archive/60f609dead784ef9854b7a6e3fb446e9908125a8.png"
        music38.vertical = false
        list.add(music38)

        val music39 = PetVideo()
        music39.type = VideoType.MUSIC.ordinal
        music39.fileName = "music39"
        music39.code = 1169
        music39.duration = 210
        music39.star = true
        music39.title = "相信自己----零点乐队"
        music39.releaseTime = 1516076774
        music39.originalUrl = "https://www.bilibili.com/video/BV1GW411v7wE"
        music39.tags = "音乐,歌曲,MV"
        music39.authorId = 71486832
        music39.cover =
            "https://i1.hdslb.com/bfs/archive/55c2d68a6573c4bf3baca91d1d2c7868c9c1329c.jpg"
        music39.vertical = false
        list.add(music39)

        val music40 = PetVideo()
        music40.type = VideoType.MUSIC.ordinal
        music40.fileName = "music40"
        music40.code = 1170
        music40.duration = 262
        music40.star = true
        music40.title = "爱我就跟我走－王鹤铮"
        music40.releaseTime = 1576364450
        music40.originalUrl = "https://www.bilibili.com/video/BV1aJ411C7Pn"
        music40.tags = "音乐,歌曲,MV"
        music40.authorId = 330248540
        music40.cover =
            "https://i2.hdslb.com/bfs/archive/1a114fc88d0484f4ac7e83cbd059ecfc7ef1663c.jpg"
        music40.vertical = false
        list.add(music40)

        val music41 = PetVideo()
        music41.type = VideoType.MUSIC.ordinal
        music41.fileName = "music41"
        music41.code = 1171
        music41.duration = 235
        music41.star = true
        music41.title = "曾风靡全球的一首《Cry On My Shoulder》，经典的旋律，百听不厌"
        music41.releaseTime = 1616750816
        music41.originalUrl = "https://www.bilibili.com/video/BV1jv41187YV"
        music41.tags = "音乐,歌曲,MV"
        music41.authorId = 513487743
        music41.cover =
            "https://i0.hdslb.com/bfs/archive/ca6e883c2f5a30529c87361d1000f9c58c62b4d3.jpg"
        music41.vertical = false
        list.add(music41)

        val music42 = PetVideo()
        music42.type = VideoType.MUSIC.ordinal
        music42.fileName = "music42"
        music42.code = 1172
        music42.duration = 200
        music42.star = true
        music42.title = "曾经学生时代听过的英文歌曲之一《Gotta Have You》"
        music42.releaseTime = 1642916073
        music42.originalUrl = "https://www.bilibili.com/video/BV115411f7DM"
        music42.tags = "音乐,歌曲,MV"
        music42.authorId = 702453625
        music42.cover =
            "https://i0.hdslb.com/bfs/archive/5cd086696e2dec9b75109a1818ae175efc2c7989.jpg"
        music42.vertical = false
        list.add(music42)

        val music43 = PetVideo()
        music43.type = VideoType.MUSIC.ordinal
        music43.fileName = "music43"
        music43.code = 1359
        music43.duration = 408
        music43.star = true
        music43.title = "央视版【意难忘】片头片尾曲"
        music43.releaseTime = 1546698471
        music43.originalUrl = "https://www.bilibili.com/video/BV1Xt411x7of"
        music43.tags = "音乐,歌曲,MV"
        music43.authorId = 39833741
        music43.cover =
            "https://i1.hdslb.com/bfs/archive/5c509e86b580cd0ecf87190d1048c373bf28f779.jpg"
        music43.vertical = false
        list.add(music43)

        val music44 = PetVideo()
        music44.type = VideoType.MUSIC.ordinal
        music44.fileName = "music44"
        music44.code = 1360
        music44.duration = 373
        music44.star = true
        music44.title = "【国产/电视剧主题曲】水浒后传-片头曲《卧虎藏龙》及片尾曲《背叛情歌》"
        music44.releaseTime = 1504549517
        music44.originalUrl = "https://www.bilibili.com/video/BV1Yx411x7QU"
        music44.tags = "音乐,歌曲,MV"
        music44.authorId = 74441805
        music44.cover =
            "https://i2.hdslb.com/bfs/archive/4ac7b38a8818ecb774fbf5ea46e47b332e3a3137.jpg"
        music44.vertical = false
        list.add(music44)

        val music45 = PetVideo()
        music45.type = VideoType.MUSIC.ordinal
        music45.fileName = "music45"
        music45.code = 1361
        music45.duration = 262
        music45.star = true
        music45.title = "《天下有情人》粤语版，带你回味95年《神雕侠侣》，古天乐后再无杨过"
        music45.releaseTime = 1575109457
        music45.originalUrl = "https://www.bilibili.com/video/BV1UJ411Q7sa"
        music45.tags = "音乐,歌曲,MV"
        music45.authorId = 95936167
        music45.cover =
            "https://i0.hdslb.com/bfs/archive/bd86005da633b05b9a24ee2a59ddd092d7e1eafb.jpg"
        music45.vertical = false
        list.add(music45)

        val music46 = PetVideo()
        music46.type = VideoType.MUSIC.ordinal
        music46.fileName = "music46"
        music46.code = 1362
        music46.duration = 277
        music46.star = true
        music46.title = "《东游记》主题曲《逍遥游》，经典好听，秒杀太多电视剧主题曲了"
        music46.releaseTime = 1623675942
        music46.originalUrl = "https://www.bilibili.com/video/BV1UK4y137R4"
        music46.tags = "音乐,歌曲,MV"
        music46.authorId = 1675531666
        music46.cover =
            "https://i1.hdslb.com/bfs/archive/52fa8fac262364fdf5b366605e7d1c3e630842e7.jpg"
        music46.vertical = false
        list.add(music46)

        val music47 = PetVideo()
        music47.type = VideoType.MUSIC.ordinal
        music47.fileName = "music47"
        music47.code = 1973
        music47.duration = 242
        music47.star = false
        music47.title = "【林志炫】凤凰花开的路口，现场演唱版720P。"
        music47.releaseTime = 1456833911
        music47.originalUrl = "https://www.bilibili.com/video/BV1us411Q7Nz"
        music47.tags = "音乐,歌曲,MV"
        music47.authorId = 11888621
        music47.cover =
            "https://i1.hdslb.com/bfs/archive/2ce576634cba1d55540b86c9e40cffece72ea65b.jpg"
        music47.vertical = false
        list.add(music47)

        val music48 = PetVideo()
        music48.type = VideoType.MUSIC.ordinal
        music48.fileName = "music48"
        music48.code = 1974
        music48.duration = 222
        music48.star = false
        music48.title = "【4K修复.Live】郑中基《可惜我是水瓶座》完美现场！长岛冰茶的味道"
        music48.releaseTime = 1618663752
        music48.originalUrl = "https://www.bilibili.com/video/BV1MQ4y1Z7SB"
        music48.tags = "音乐,歌曲,MV"
        music48.authorId = 326838748
        music48.cover =
            "https://i2.hdslb.com/bfs/archive/6ada1cf9c67d5956238dd1748b76545986c1b1a6.png"
        music48.vertical = false
        list.add(music48)

        val music49 = PetVideo()
        music49.type = VideoType.MUSIC.ordinal
        music49.fileName = "music49"
        music49.code = 1975
        music49.duration = 209
        music49.star = false
        music49.title = "【4K修复】阿杜《他一定很爱你》我应该在车底「醇情歌演唱会」"
        music49.releaseTime = 1616904693
        music49.originalUrl = "https://www.bilibili.com/video/BV1bi4y1P7Xi"
        music49.tags = "音乐,歌曲,MV"
        music49.authorId = 326838748
        music49.cover =
            "https://i2.hdslb.com/bfs/archive/3325b853739ddb8321ca179724e3b38d555b37ff.png"
        music49.vertical = false
        list.add(music49)

        val music50 = PetVideo()
        music50.type = VideoType.MUSIC.ordinal
        music50.fileName = "music50"
        music50.code = 1976
        music50.duration = 146
        music50.star = false
        music50.title = "北京冬奥会，再见！"
        music50.releaseTime = 1645369621
        music50.originalUrl = "https://www.bilibili.com/video/BV1kT4y1D7Z8"
        music50.tags = "音乐,歌曲,MV"
        music50.authorId = 20165629
        music50.cover =
            "https://i1.hdslb.com/bfs/archive/db1f1ef390b1972445a25701339a446d646a40ca.jpg"
        music50.vertical = false
        list.add(music50)

        val music51 = PetVideo()
        music51.type = VideoType.MUSIC.ordinal
        music51.fileName = "music51"
        music51.code = 1977
        music51.duration = 233
        music51.star = false
        music51.title = "当下最火的俄语歌《Колыбельная》，战争是残酷的，和平来之不易！"
        music51.releaseTime = 1606133548
        music51.originalUrl = "https://www.bilibili.com/video/BV1ap4y1r7L8"
        music51.tags = "音乐,歌曲,MV"
        music51.authorId = 40656188
        music51.cover =
            "https://i1.hdslb.com/bfs/archive/c3e49c0d3acb829de9878924d78caa72772cffbb.jpg"
        music51.vertical = false
        list.add(music51)

        val music52 = PetVideo()
        music52.type = VideoType.MUSIC.ordinal
        music52.fileName = "music52"
        music52.code = 3651
        music52.duration = 225
        music52.star = true
        music52.title = "吉他再弹500英里，已是白发"
        music52.releaseTime = 1588596945
        music52.originalUrl = "https://www.bilibili.com/video/BV1Ha4y1i7MT"
        music52.tags = "音乐,歌曲,MV"
        music52.authorId = 383009679
        music52.cover =
            "https://i0.hdslb.com/bfs/archive/2e21e44c7f189e1af63c51b503443c4890b3bcf0.jpg"
        list.add(music52)

        val music53 = PetVideo()
        music53.type = VideoType.MUSIC.ordinal
        music53.fileName = "music53"
        music53.code = 3652
        music53.duration = 174
        music53.star = true
        music53.title = "再唱披头士，已是白头"
        music53.releaseTime = 1636015644
        music53.originalUrl = "https://www.bilibili.com/video/BV1mT4y1d7qR"
        music53.tags = "音乐,歌曲,MV"
        music53.authorId = 434438705
        music53.cover =
            "https://i0.hdslb.com/bfs/archive/3952c1ca8a1cbca5610949e9446fe3a59d91bce1.jpg"
        list.add(music53)

        val music54 = PetVideo()
        music54.type = VideoType.MUSIC.ordinal
        music54.fileName = "music54"
        music54.code = 3653
        music54.duration = 1083
        music54.star = true
        music54.title = "酷盘点丨多年未听却依然能脱口而出的旋律，你还记得这些“冷门”歌么？"
        music54.releaseTime = 1628342348
        music54.originalUrl = "https://www.bilibili.com/video/BV13f4y1V78o"
        music54.tags = "音乐,歌曲,MV"
        music54.authorId = 518888859
        music54.cover =
            "https://i0.hdslb.com/bfs/archive/b70c22b3cf19ece328cca80d89d95d0f35aaeb1a.jpg"
        list.add(music54)

        val music55 = PetVideo()
        music55.type = VideoType.MUSIC.ordinal
        music55.fileName = "music55"
        music55.code = 3654
        music55.duration = 287
        music55.star = true
        music55.title = "杨宗纬《我想要》心碎到了极致的嗓音！"
        music55.releaseTime = 1649559600
        music55.originalUrl = "https://www.bilibili.com/video/BV1U34y1e7qH"
        music55.tags = "音乐,歌曲,MV"
        music55.authorId = 518888859
        music55.cover =
            "https://i1.hdslb.com/bfs/archive/a7e8dbcaa3b0946c76e1e808eb5b39a972428b43.jpg"
        list.add(music55)

        val music56 = PetVideo()
        music56.type = VideoType.MUSIC.ordinal
        music56.fileName = "music56"
        music56.code = 3655
        music56.duration = 282
        music56.star = true
        music56.title = "2017最妖孽单曲《Despacito》，YouTube史上首支点击超30亿视频！原版"
        music56.releaseTime = 1502644672
        music56.originalUrl = "https://www.bilibili.com/video/BV1Gx411H7z6"
        music56.tags = "音乐,歌曲,MV"
        music56.authorId = 10063560
        music56.cover =
            "https://i1.hdslb.com/bfs/archive/879b46f789fced2158decf90e4e23973ebef8782.jpg"
        list.add(music56)

        val music57 = PetVideo()
        music57.type = VideoType.MUSIC.ordinal
        music57.fileName = "music57"
        music57.code = 3686
        music57.duration = 253
        music57.star = true
        music57.title = "任贤齐的一首《死不了》，前奏简直太好听了，音乐一响热泪盈眶。"
        music57.releaseTime = 1629348140
        music57.originalUrl = "https://www.bilibili.com/video/BV1hq4y1S7LL"
        music57.tags = "音乐,歌曲,MV"
        music57.authorId = 357688804
        music57.cover =
            "https://i2.hdslb.com/bfs/archive/7fdadd10e6e31617dfdc6a08439b3bd6ac59163a.jpg"
        list.add(music57)

        val music58 = PetVideo()
        music58.type = VideoType.MUSIC.ordinal
        music58.fileName = "music58"
        music58.code = 3687
        music58.duration = 275
        music58.star = true
        music58.title = "【何仙姑X牡丹】 放下"
        music58.releaseTime = 1493810550
        music58.originalUrl = "https://www.bilibili.com/video/BV1Rx411276V"
        music58.tags = "音乐,歌曲,MV"
        music58.authorId = 4283371
        music58.cover =
            "https://i0.hdslb.com/bfs/archive/0e1eb56364edd509afe7825b5c9e93e807e98f43.jpg"
        list.add(music58)

        val music59 = PetVideo()
        music59.type = VideoType.MUSIC.ordinal
        music59.fileName = "music59"
        music59.code = 3688
        music59.duration = 290
        music59.star = true
        music59.title = "【吕白】可念不可说"
        music59.releaseTime = 1452934965
        music59.originalUrl = "https://www.bilibili.com/video/BV1bs411R7d2"
        music59.tags = "音乐,歌曲,MV"
        music59.authorId = 2119421
        music59.cover =
            "https://i1.hdslb.com/bfs/archive/6bc3979e89ac35f9b22d9cd8a7ed34c27e65ac12.jpg"
        list.add(music59)

        val music60 = PetVideo()
        music60.type = VideoType.MUSIC.ordinal
        music60.fileName = "music60"
        music60.code = 3689
        music60.duration = 180
        music60.star = true
        music60.title = "【东游记】吕洞宾X白牡丹||既是如此冷静为何动了情||天地不容"
        music60.releaseTime = 1583836807
        music60.originalUrl = "https://www.bilibili.com/video/BV1EE411T7p3"
        music60.tags = "音乐,歌曲,MV"
        music60.authorId = 515125208
        music60.cover =
            "https://i2.hdslb.com/bfs/archive/397a6ca57d13433f4b6892506d77c212d28efe2e.jpg"
        list.add(music60)



        return list
    }
}