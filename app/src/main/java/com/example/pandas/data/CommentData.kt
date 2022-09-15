package com.example.pandas.data

import com.example.pandas.sql.entity.VideoComment

object CommentData {

    private val list = mutableListOf<VideoComment>()
    fun getList(): MutableList<VideoComment> {

        val comment = VideoComment()
        comment.videoCode = 1982
        comment.content = "真的太可爱了， 以前我都不会主动搜国宝， 花花真的又萌又励志"
        comment.type = 1
        comment.fromUserCode = 523707706
        comment.commitTime = 1653849393000
        comment.likeNum = (0..100).random()
        comment.upLike = true
        comment.commentId = 1
        list.add(comment)

        val comment1 = VideoComment()
        comment1.videoCode = 1982
        comment1.content = "优雅，上流😊"
        comment1.type = 1
        comment1.fromUserCode = 348483302
        comment1.commitTime = 1653869393000
        comment1.likeNum = (0..100).random()
        comment1.upLike = true
        comment1.commentId = 2
        list.add(comment1)

        val comment2 = VideoComment()
        comment2.videoCode = 1982
        comment2.content = "小能能要好好吃饭哦"
        comment2.type = 1
        comment2.fromUserCode = 28374744
        comment2.commitTime = 1653969393000
        comment2.likeNum = (0..100).random()
        comment2.upLike = true
        comment2.commentId = 3
        list.add(comment2)

        val comment3 = VideoComment()
        comment3.videoCode = 1982
        comment3.content = "淑女都是一片一片吃😂"
        comment3.type = 1
        comment3.fromUserCode = 41665075
        comment3.commitTime = 1653979393000
        comment3.likeNum = (0..100).random()
        comment3.upLike = false
        comment3.commentId = 4
        list.add(comment3)

        val comment4 = VideoComment()
        comment4.videoCode = 1982
        comment4.content = "花乖乖细嚼慢咽吃竹叶，真美真淑女😘😘"
        comment4.type = 1
        comment4.fromUserCode = 1813574272
        comment4.commitTime = 1653989393000
        comment4.likeNum = (0..100).random()
        comment4.upLike = false
        comment4.commentId = 5
        list.add(comment4)

        val comment5 = VideoComment()
        comment5.videoCode = 1982
        comment5.content = "这个大胖脸，真想抱着狠狠地rua"
        comment5.type = 1
        comment5.fromUserCode = 360321868
        comment5.commitTime = 1653989395000
        comment5.likeNum = (0..100).random()
        comment5.upLike = false
        comment5.commentId = 6
        list.add(comment5)

        val comment6 = VideoComment()
        comment6.videoCode = 1982
        comment6.content = "女明星的用餐礼仪😊😊😊"
        comment6.type = 1
        comment6.fromUserCode = 1151868166
        comment6.commitTime = 1653989397000
        comment6.likeNum = (0..100).random()
        comment6.upLike = false
        comment6.commentId = 7
        list.add(comment6)

        val comment7 = VideoComment()
        comment7.videoCode = 1982
        comment7.content = "花花还不会撸串不过起码不是假吃了，一直有进步"
        comment7.type = 1
        comment7.fromUserCode = 34677299
        comment7.commitTime = 1653989417000
        comment7.likeNum = (0..100).random()
        comment7.upLike = true
        comment7.commentId = 8
        list.add(comment7)

        val comment8 = VideoComment()
        comment8.videoCode = 1982
        comment8.content = "一片竹叶嚼了那么多下，两相比较，总热量还是损失的"
        comment8.type = 1
        comment8.fromUserCode = 335419800
        comment8.commitTime = 1653989427000
        comment8.likeNum = (0..100).random()
        comment8.upLike = false
        comment8.commentId = 9
        list.add(comment8)

        val comment9 = VideoComment()
        comment9.videoCode = 1982
        comment9.content = "宝宝给自己立个小目标，今年2岁生日前，笋笋吃得又快又多💪"
        comment9.type = 1
        comment9.fromUserCode = 7782934
        comment9.commitTime = 1653989467000
        comment9.likeNum = (0..100).random()
        comment9.upLike = false
        comment9.commentId = 10
        list.add(comment9)

        val comment10 = VideoComment()
        comment10.videoCode = 1982
        comment10.content = "好可爱好可爱好可爱"
        comment10.type = 1
        comment10.fromUserCode = 478823961
        comment10.commitTime = 1653989567000
        comment10.likeNum = (0..100).random()
        comment10.upLike = false
        comment10.commentId = 11
        list.add(comment10)

        val comment11 = VideoComment()
        comment11.videoCode = 1982
        comment11.content = "好可爱好可爱好可爱"
        comment11.type = 1
        comment11.fromUserCode = 18329821
        comment11.commitTime = 1653989667000
        comment11.likeNum = (0..100).random()
        comment11.upLike = false
        comment11.commentId = 12
        list.add(comment11)

        val comment12 = VideoComment()
        comment12.videoCode = 1982
        comment12.content = "痴汉笑制造机：成和花"
        comment12.type = 1
        comment12.fromUserCode = 39546503
        comment12.commitTime = 1653989677000
        comment12.likeNum = (0..100).random()
        comment12.upLike = false
        comment12.commentId = 13
        list.add(comment12)

        val comment13 = VideoComment()
        comment13.videoCode = 1982
        comment13.content = "好像三角饭团哦🍙🍙"
        comment13.type = 1
        comment13.fromUserCode = 1998535
        comment13.commitTime = 1653989687000
        comment13.likeNum = (0..100).random()
        comment13.upLike = false
        comment13.commentId = 14
        list.add(comment13)

        val comment14 = VideoComment()
        comment14.videoCode = 1982
        comment14.content = "花花是最可爱的熊猫不允许反驳😂"
        comment14.type = 1
        comment14.fromUserCode = 66688464
        comment14.commitTime = 1653989697000
        comment14.likeNum = (0..100).random()
        comment14.upLike = false
        comment14.commentId = 15
        list.add(comment14)

        val comment15 = VideoComment()
        comment15.videoCode = 1982
        comment15.content = "不知道为什么我觉得她跟其他熊猫长得不一样😂，我能认出她😊"
        comment15.type = 1
        comment15.fromUserCode = 40656188
        comment15.commitTime = 1653989717000
        comment15.likeNum = (0..100).random()
        comment15.upLike = false
        comment15.commentId = 16
        list.add(comment15)

        val comment16 = VideoComment()
        comment16.videoCode = 1982
        comment16.content = "这是我唯一能认出来的熊猫，这大脸盘子。"
        comment16.type = 1
        comment16.fromUserCode = 92694869
        comment16.commitTime = 1653989727000
        comment16.likeNum = (0..100).random()
        comment16.upLike = true
        comment16.commentId = 17
        list.add(comment16)

        val comment17 = VideoComment()
        comment17.videoCode = 1982
        comment17.content = "真是太萌♥太可爱了。如果电视上出一个熊猫频道24小时直播熊猫我都一定会看"
        comment17.type = 1
        comment17.fromUserCode = 36814636
        comment17.commitTime = 1653989747000
        comment17.likeNum = (0..100).random()
        comment17.upLike = false
        comment17.commentId = 18
        list.add(comment17)

        val comment18 = VideoComment()
        comment18.videoCode = 1982
        comment18.content = "其实有点担心花花，吃东西不太好…体重那么轻，同年龄段的熊都100多斤了吧"
        comment18.type = 1
        comment18.fromUserCode = 98093909
        comment18.commitTime = 1653989767000
        comment18.likeNum = (0..100).random()
        comment18.upLike = false
        comment18.commentId = 19
        list.add(comment18)

        val comment19 = VideoComment()
        comment19.videoCode = 1982
        comment19.content = "花花以前跟着润润的时候可是很喜欢笋笋的，每次自己抱着一根慢慢啃，被抢了也不生气，换一根继续啃，希望到了笋季以后花花能吃多多长大个！"
        comment19.type = 1
        comment19.fromUserCode = 20429499
        comment19.commitTime = 1653989787000
        comment19.likeNum = (0..100).random()
        comment19.upLike = false
        comment19.commentId = 20
        list.add(comment19)

        val comment20 = VideoComment()
        comment20.videoCode = 1982
        comment20.content = "乖宝宝，奶娃娃🥰"
        comment20.type = 1
        comment20.fromUserCode = 293243325
        comment20.commitTime = 1653989887000
        comment20.likeNum = (0..100).random()
        comment20.upLike = false
        comment20.commentId = 21
        list.add(comment20)

        val comment21 = VideoComment()
        comment21.videoCode = 1982
        comment21.content = "花宝 多吃点"
        comment21.type = 1
        comment21.fromUserCode = 2087432052
        comment21.commitTime = 1653990000000
        comment21.likeNum = (0..100).random()
        comment21.upLike = false
        comment21.commentId = 22
        list.add(comment21)

        val comment22 = VideoComment()
        comment22.videoCode = 1982
        comment22.content = "花宝每次吃东西都是眯着眼睛的，感觉妮品尝美味"
        comment22.type = 1
        comment22.fromUserCode = 396343652
        comment22.commitTime = 1653990002000
        comment22.likeNum = (0..100).random()
        comment22.upLike = true
        comment22.commentId = 23
        list.add(comment22)

        val comment23 = VideoComment()
        comment23.videoCode = 1982
        comment23.content = "坐着吃笋的花花真是可爱惨了。"
        comment23.type = 1
        comment23.fromUserCode = 384395600
        comment23.commitTime = 1653990012000
        comment23.likeNum = (0..100).random()
        comment23.upLike = false
        comment23.commentId = 24
        list.add(comment23)

        val comment24 = VideoComment()
        comment24.videoCode = 1982
        comment24.content = "16:9小能能"
        comment24.type = 1
        comment24.fromUserCode = 30738231
        comment24.commitTime = 1653990032000
        comment24.likeNum = (0..100).random()
        comment24.upLike = false
        comment24.commentId = 25
        list.add(comment24)

        val comment25 = VideoComment()
        comment25.videoCode = 1982
        comment25.content = "励志是我没想到的😂"
        comment25.type = 2
        comment25.fromUserCode = 404523870
        comment25.fromUserName = "南柯十一梦"
        comment25.toUserCode = 523707706
        comment25.toUserName = "猩猿猪"
        comment25.commitTime = 1653849394000
        comment25.likeNum = (0..100).random()
        comment25.upLike = false
        comment25.commentId = 26
        comment25.topCommentId = 1
        list.add(comment25)

        val comment26 = VideoComment()
        comment26.videoCode = 1982
        comment26.content = "毕竟腿那么短还能那么可爱😎😎😎"
        comment26.type = 3
        comment26.fromUserCode = 42448991
        comment26.fromUserName = "剪刀手瑜乔"
        comment26.toUserCode = 404523870
        comment26.toUserName = "南柯十一梦"
        comment26.commitTime = 1653849396000
        comment26.likeNum = (0..100).random()
        comment26.upLike = false
        comment26.commentId = 27
        comment26.topCommentId = 1
        list.add(comment26)

        val comment27 = VideoComment()
        comment27.videoCode = 1982
        comment27.content =
            "有一条腿外翻挺严重的，从小使不上力，所以爬不了树，又倔强想爬树都失败了，现在能爬树基本靠手臂的力量，而且牙齿发育比较慢，咬竹子之类的也慢， 现在慢慢变好了一点，所以励志"
        comment27.type = 3
        comment27.fromUserCode = 19429622
        comment27.fromUserName = "我跟白敬亭私奔了"
        comment27.toUserCode = 404523870
        comment27.toUserName = "南柯十一梦"
        comment27.commitTime = 1653849496000
        comment27.likeNum = (0..100).random()
        comment27.upLike = false
        comment27.commentId = 28
        comment27.topCommentId = 1
        list.add(comment27)

        val comment28 = VideoComment()
        comment28.videoCode = 1982
        comment28.content = "胖花最大看点不是肥美腿短假吃励志爬树么？"
        comment28.type = 3
        comment28.fromUserCode = 2024662
        comment28.fromUserName = "花池-"
        comment28.toUserCode = 404523870
        comment28.toUserName = "南柯十一梦"
        comment28.commitTime = 1653849596000
        comment28.likeNum = (0..100).random()
        comment28.upLike = false
        comment28.commentId = 29
        comment28.topCommentId = 1
        list.add(comment28)

        val comment29 = VideoComment()
        comment29.videoCode = 1982
        comment29.content =
            "确实励志。我是在花花还是个软趴趴的小熊时知道的她，明明那么小还腿短，但还是每天坚持翻那根木桩桩，看得人特别捉急但是又特别佩服。花花是唯一一只从小到大我一直在关注的小熊熊，年初看她爬上树的视频真的特别欣慰！！"
        comment29.type = 2
        comment29.fromUserCode = 44341427
        comment29.fromUserName = "話影小酱"
        comment29.toUserName = "猩猿猪"
        comment29.toUserCode = 523707706
        comment29.commitTime = 1653849696000
        comment29.likeNum = (0..100).random()
        comment29.upLike = false
        comment29.commentId = 30
        comment29.topCommentId = 1
        list.add(comment29)

        val comment30 = VideoComment()
        comment30.videoCode = 1982
        comment30.content = "现在花花吃苹果比以前好很多了！！再给她一点时间，我相信她慢慢的每件事情都能做好"
        comment30.type = 3
        comment30.fromUserCode = 435041418
        comment30.fromUserName = "来1碗小仙女Oo"
        comment30.toUserCode = 19429622
        comment30.toUserName = "我跟白敬亭私奔了"
        comment30.commitTime = 1653849896000
        comment30.likeNum = (0..100).random()
        comment30.upLike = false
        comment30.commentId = 31
        comment30.topCommentId = 1
        list.add(comment30)

        val comment31 = VideoComment()
        comment31.videoCode = 1982
        comment31.content = "还用搜？假粉，我首页刷一次一次新的🥸"
        comment31.type = 2
        comment31.fromUserCode = 200634377
        comment31.fromUserName = "山也知道"
        comment31.toUserName = "猩猿猪"
        comment31.toUserCode = 523707706
        comment31.commitTime = 1653859896000
        comment31.likeNum = (0..100).random()
        comment31.upLike = false
        comment31.commentId = 32
        comment31.topCommentId = 1
        list.add(comment31)

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