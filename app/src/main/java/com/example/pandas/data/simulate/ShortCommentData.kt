package com.example.pandas.data.simulate

import com.android.android_sqlite.entity.VideoComment


object ShortCommentData {

    fun getList(): MutableList<VideoComment> {
        val list = mutableListOf<VideoComment>()

        val comment = VideoComment()
        comment.videoCode = 3800
        comment.content = "秋风清，秋月明，\n" +
                "落叶聚还散，寒鸦栖复惊。\n" +
                "相思相见知何日？此时此夜难为情！"
        comment.type = 1
        comment.fromUserCode = 523707706
        comment.commitTime = 1671618607
        comment.likeNum = (0..100).random()
        comment.upLike = true
        comment.commentId = 33
        list.add(comment)

        val comment61 = VideoComment()
        comment61.videoCode = 3800
        comment61.content = "好诗好诗"
        comment61.type = 2
        comment61.fromUserCode = 1813574272
        comment61.commitTime = 1671618620
        comment61.topCommentId = 33
        comment61.likeNum = (0..100).random()
        comment61.commentId = 61
        list.add(comment61)

        val comment62 = VideoComment()
        comment62.videoCode = 3800
        comment62.content = "有才👍"
        comment62.type = 2
        comment62.fromUserCode = 1247719104
        comment62.commitTime = 1671618644
        comment62.topCommentId = 33
        comment62.likeNum = (0..100).random()
        comment62.commentId = 62
        list.add(comment62)

        val comment63 = VideoComment()
        comment63.videoCode = 3800
        comment63.content = "还得是你"
        comment63.type = 3
        comment63.fromUserCode = 18329821
        comment63.toUserCode = 1247719104
        comment63.toUserName = "熊猫幼崽社区"
        comment63.commitTime = 1671618710
        comment63.topCommentId = 33
        comment63.likeNum = (0..100).random()
        comment63.commentId = 63
        list.add(comment63)

        val comment64 = VideoComment()
        comment64.videoCode = 3800
        comment64.content = "[:ecr][:ecr]"
        comment64.type = 2
        comment64.fromUserCode = 523707706
        comment64.toUserName = "陈童鞋want如愿"
        comment64.commitTime = 1671618715
        comment64.topCommentId = 33
        comment64.likeNum = (0..100).random()
        comment64.commentId = 64
        list.add(comment64)

        val comment65 = VideoComment()
        comment65.videoCode = 3800
        comment65.content = "秋风清，秋月明，\n" +
                "落叶聚还散，寒鸦栖复惊。\n" +
                "相思相见知何日？此时此夜难为情！"
        comment65.type = 2
        comment65.fromUserCode = 523707706
        comment65.commitTime = 1671618725
        comment65.topCommentId = 33
        comment65.likeNum = (0..100).random()
        comment65.commentId = 65
        list.add(comment65)

        val comment66 = VideoComment()
        comment66.videoCode = 3800
        comment66.content = "[:edi]"
        comment66.type = 2
        comment66.fromUserCode = 324568428
        comment66.commitTime = 1671618810
        comment66.topCommentId = 33
        comment66.likeNum = (0..100).random()
        comment66.commentId = 66
        list.add(comment66)

        val comment67 = VideoComment()
        comment67.videoCode = 3800
        comment67.content = "真好"
        comment67.type = 2
        comment67.fromUserCode = 200634377
        comment67.commitTime = 1671618920
        comment67.topCommentId = 33
        comment67.likeNum = (0..100).random()
        comment67.commentId = 67
        list.add(comment67)

        val comment68 = VideoComment()
        comment68.videoCode = 3800
        comment68.content = "我也喜欢"
        comment68.type = 2
        comment68.fromUserCode = 42448991
        comment68.commitTime = 1671618950
        comment68.topCommentId = 33
        comment68.likeNum = (0..100).random()
        comment68.commentId = 68
        list.add(comment68)

        val comment69 = VideoComment()
        comment69.videoCode = 3800
        comment69.content = "哈哈，好"
        comment69.type = 2
        comment69.fromUserCode = 276536331
        comment69.commitTime = 1671618970
        comment69.topCommentId = 33
        comment69.likeNum = (0..100).random()
        comment69.commentId = 69
        list.add(comment69)

        val comment1 = VideoComment()
        comment1.videoCode = 3800
        comment1.content = "我来了，加油[:edi]"
        comment1.type = 1
        comment1.fromUserCode = 348483302
        comment1.commitTime = 1671622520
        comment1.likeNum = (0..100).random()
        comment1.upLike = true
        comment1.commentId = 34
        list.add(comment1)

        val comment2 = VideoComment()
        comment2.videoCode = 3800
        comment2.content = "我发现你的每一个视频都非常用心，就是看的人不是很多，难受[:ecy]，希望看的人能越来越多"
        comment2.type = 1
        comment2.fromUserCode = 28374744
        comment2.commitTime = 1671622620
        comment2.likeNum = (0..100).random()
        comment2.upLike = true
        comment2.commentId = 35
        list.add(comment2)

        val comment3 = VideoComment()
        comment3.videoCode = 3800
        comment3.content = "[:ecr][:ecr][:ecr]"
        comment3.type = 1
        comment3.fromUserCode = 41665075
        comment3.commitTime = 1671623620
        comment3.likeNum = (0..100).random()
        comment3.upLike = false
        comment3.commentId = 36
        list.add(comment3)

        val comment4 = VideoComment()
        comment4.videoCode = 3800
        comment4.content = "喜欢"
        comment4.type = 1
        comment4.fromUserCode = 1813574272
        comment4.commitTime = 1671623920
        comment4.likeNum = (0..100).random()
        comment4.upLike = false
        comment4.commentId = 37
        list.add(comment4)

        val comment5 = VideoComment()
        comment5.videoCode = 3800
        comment5.content = "比上一个视频更精彩"
        comment5.type = 1
        comment5.fromUserCode = 360321868
        comment5.commitTime = 1671624920
        comment5.likeNum = (0..100).random()
        comment5.upLike = false
        comment5.commentId = 38
        list.add(comment5)

        val comment6 = VideoComment()
        comment6.videoCode = 3800
        comment6.content = "👍👍👍"
        comment6.type = 1
        comment6.fromUserCode = 1151868166
        comment6.commitTime = 1671626920
        comment6.likeNum = (0..100).random()
        comment6.upLike = false
        comment6.commentId = 39
        list.add(comment6)

        val comment7 = VideoComment()
        comment7.videoCode = 3800
        comment7.content = "哇塞哇塞！！好好看"
        comment7.type = 1
        comment7.fromUserCode = 34677299
        comment7.commitTime = 1671627920
        comment7.likeNum = (0..100).random()
        comment7.upLike = true
        comment7.commentId = 40
        list.add(comment7)

        val comment8 = VideoComment()
        comment8.videoCode = 3800
        comment8.content = "太美了"
        comment8.type = 1
        comment8.fromUserCode = 335419800
        comment8.commitTime = 1671629920
        comment8.likeNum = (0..100).random()
        comment8.upLike = false
        comment8.commentId = 41
        list.add(comment8)

        val comment9 = VideoComment()
        comment9.videoCode = 3800
        comment9.content = "可爱[:ebv]"
        comment9.type = 1
        comment9.fromUserCode = 7782934
        comment9.commitTime = 1671639920
        comment9.likeNum = (0..100).random()
        comment9.upLike = false
        comment9.commentId = 42
        list.add(comment9)

        val comment10 = VideoComment()
        comment10.videoCode = 3800
        comment10.content = "好可爱好可爱好可爱"
        comment10.type = 1
        comment10.fromUserCode = 478823961
        comment10.commitTime = 1671639950
        comment10.likeNum = (0..100).random()
        comment10.upLike = false
        comment10.commentId = 43
        list.add(comment10)

        val comment11 = VideoComment()
        comment11.videoCode = 3800
        comment11.content = "这是什么？"
        comment11.type = 1
        comment11.fromUserCode = 18329821
        comment11.commitTime = 1671640020
        comment11.likeNum = (0..100).random()
        comment11.upLike = false
        comment11.commentId = 44
        list.add(comment11)

        val comment12 = VideoComment()
        comment12.videoCode = 3800
        comment12.content = "好喜欢"
        comment12.type = 1
        comment12.fromUserCode = 39546503
        comment12.commitTime = 1671640120
        comment12.likeNum = (0..100).random()
        comment12.upLike = false
        comment12.commentId = 45
        list.add(comment12)

        val comment13 = VideoComment()
        comment13.videoCode = 3800
        comment13.content = "路过，支持🌹"
        comment13.type = 1
        comment13.fromUserCode = 1998535
        comment13.commitTime = 1671640220
        comment13.likeNum = (0..100).random()
        comment13.upLike = false
        comment13.commentId = 46
        list.add(comment13)

        val comment14 = VideoComment()
        comment14.videoCode = 3800
        comment14.content = "刚刚"
        comment14.type = 1
        comment14.fromUserCode = 66688464
        comment14.commitTime = 1671641220
        comment14.likeNum = (0..100).random()
        comment14.upLike = false
        comment14.commentId = 47
        list.add(comment14)

        val comment15 = VideoComment()
        comment15.videoCode = 3800
        comment15.content = "[:ebj][:ebj][:ebj]"
        comment15.type = 1
        comment15.fromUserCode = 40656188
        comment15.commitTime = 1671642220
        comment15.likeNum = (0..100).random()
        comment15.upLike = false
        comment15.commentId = 48
        list.add(comment15)

        val comment16 = VideoComment()
        comment16.videoCode = 3800
        comment16.content = "[:ecq]"
        comment16.type = 1
        comment16.fromUserCode = 92694869
        comment16.commitTime = 1671643220
        comment16.likeNum = (0..100).random()
        comment16.upLike = true
        comment16.commentId = 49
        list.add(comment16)

        val comment17 = VideoComment()
        comment17.videoCode = 3800
        comment17.content = "来了"
        comment17.type = 1
        comment17.fromUserCode = 36814636
        comment17.commitTime = 1671643228
        comment17.likeNum = (0..100).random()
        comment17.upLike = false
        comment17.commentId = 50
        list.add(comment17)

        val comment18 = VideoComment()
        comment18.videoCode = 3800
        comment18.content = "普普通通"
        comment18.type = 1
        comment18.fromUserCode = 98093909
        comment18.commitTime = 1671643328
        comment18.likeNum = (0..100).random()
        comment18.upLike = false
        comment18.commentId = 51
        list.add(comment18)

        val comment19 = VideoComment()
        comment19.videoCode = 3800
        comment19.content = "怎么能这么好看啊"
        comment19.type = 1
        comment19.fromUserCode = 20429499
        comment19.commitTime = 1671644328
        comment19.likeNum = (0..100).random()
        comment19.upLike = false
        comment19.commentId = 52
        list.add(comment19)

        val comment20 = VideoComment()
        comment20.videoCode = 3800
        comment20.content = "每次都能刷到你，太有缘分了吧，哈哈哈哈哈[:ebg]"
        comment20.type = 1
        comment20.fromUserCode = 293243325
        comment20.commitTime = 1671644358
        comment20.likeNum = (0..100).random()
        comment20.upLike = false
        comment20.commentId = 53
        list.add(comment20)

        val comment21 = VideoComment()
        comment21.videoCode = 3800
        comment21.content = "已经很棒了"
        comment21.type = 1
        comment21.fromUserCode = 2087432052
        comment21.commitTime = 1671644658
        comment21.likeNum = (0..100).random()
        comment21.upLike = false
        comment21.commentId = 54
        list.add(comment21)

        val comment22 = VideoComment()
        comment22.videoCode = 3800
        comment22.content = "本来想整两句的，还是算了[:ebh]"
        comment22.type = 1
        comment22.fromUserCode = 396343652
        comment22.commitTime = 1671644958
        comment22.likeNum = (0..100).random()
        comment22.upLike = true
        comment22.commentId = 55
        list.add(comment22)

        val comment23 = VideoComment()
        comment23.videoCode = 3800
        comment23.content = "点赞点赞"
        comment23.type = 1
        comment23.fromUserCode = 384395600
        comment23.commitTime = 1671645958
        comment23.likeNum = (0..100).random()
        comment23.upLike = false
        comment23.commentId = 56
        list.add(comment23)

        val comment24 = VideoComment()
        comment24.videoCode = 3800
        comment24.content = "还是很漂亮的"
        comment24.type = 1
        comment24.fromUserCode = 30738231
        comment24.commitTime = 1671655958
        comment24.likeNum = (0..100).random()
        comment24.upLike = false
        comment24.commentId = 57
        list.add(comment24)

        val comment25 = VideoComment()
        comment25.videoCode = 3800
        comment25.content = "[:edi]"
        comment25.type = 1
        comment25.fromUserCode = 404523870
        comment25.commitTime = 1671657958
        comment25.likeNum = (0..100).random()
        comment25.upLike = false
        comment25.commentId = 58
        list.add(comment25)

        val comment26 = VideoComment()
        comment26.videoCode = 3800
        comment26.content = "太美啦"
        comment26.type = 1
        comment26.fromUserCode = 1307515
        comment26.commitTime = 1671657978
        comment26.likeNum = (0..100).random()
        comment26.upLike = false
        comment26.commentId = 59
        list.add(comment26)

        val comment27 = VideoComment()
        comment27.videoCode = 3800
        comment27.content = "哈哈哈哈"
        comment27.type = 1
        comment27.fromUserCode = 1025949925
        comment27.commitTime = 1671658378
        comment27.likeNum = (0..100).random()
        comment27.upLike = false
        comment27.commentId = 60
        list.add(comment27)

        return list
    }

    val userCode = arrayListOf(
        66688464,
        40656188,
        92694869,
        36814636,
        98093909,
        20429499,
        293243325,
        2087432052,
        396343652,
        404523870,
        42448991,
        19429622,
        2024662,
        44341427,
        435041418,
        200634377,
        9370995,
        27306175,
        373529092,
        12444306,
        90548795,
        551467383,
        231314384,
        1435076062,
        374231948,
        288516776,
        4120384,
        627116323,
        175546072,
        3232184,
        404842697,
        346324250,
        30738231,
        43296249,
        668149765,
        3107068,
        179512321,
        549090612,
        312245686,
        27120931,
        1984573756,
        2106730041,
        514531996,
        4038416,
        1370008,
        16468440,
        1025949925,
        384395600,
        3917675,
        269899367,
        476733832,
        281381350,
        1307515,
        444796647,
        396450082,
        1499649009,
        580108645,
        591240042,
        272434852,
        66204694,
        493908108,
        255618361,
        1251374263,
        15287042,
        324568428,
        1968693474,
        406863853,
        388687723,
        276536331,
        13870029,
        176605331,
        373867,
        430127427,
        551961363,
        72209046,
        1247719104,
        488055582,
        1098561796,
        37053244,
        523707706,
        348483302,
        28374744,
        41665075,
        1813574272,
        360321868,
        1151868166,
        34677299,
        335419800,
        7782934,
        478823961,
        18329821,
        39546503,
        1998535,
    )
}