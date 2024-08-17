package com.example.pandas.data.sql

import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.entity.PetVideo

object LandscapeData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        val landscape57 = PetVideo()
        landscape57.type = VideoType.LANDSCAPE.ordinal
        landscape57.fileName = "landscape_57"
        landscape57.code = 3785
        landscape57.duration = 10
        landscape57.title = "我本一身傲骨，怎奈世道无常。曾鲜衣怒马，仗剑天涯。也曾当剑卖马，许她一世繁华，奈何人心不可量，悬崖不可丈。"
        landscape57.releaseTime = 1650686169
        landscape57.tags = "山水,风景,中国美景"
        landscape57.authorId = 36468432
        landscape57.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/04559ba713164b7299f8149f68e1fa40_1649936823~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986994800&x-signature=%2BOitDXiPoxZOLOjfS7cWxya%2BSfE%3D"
        landscape57.vertical = true
        list.add(landscape57)

//        val landscape58 = PetVideo()
//        landscape58.type = VideoType.LANDSCAPE.ordinal
//        landscape58.fileName = "landscape_58"
//        landscape58.code = 3786
//        landscape58.duration = 10
//        landscape58.title = "一人一马一江湖，一世薄凉人间苦。知己别离天涯路，惊觉相思已入骨。"
//        landscape58.releaseTime = 1651474569
//        landscape58.tags = "山水,风景,中国美景"
//        landscape58.authorId = 36468432
//        landscape58.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/22c5a3e9cea84c7e81b4e32aa1c34c9c~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=x%2Br1IfYNi%2Fk%2FD6z%2Frf5LZ1U0QGE%3D"
//        landscape58.vertical = true
//        list.add(landscape58)

//        val landscape59 = PetVideo()
//        landscape59.type = VideoType.LANDSCAPE.ordinal
//        landscape59.fileName = "landscape_59"
//        landscape59.code = 3787
//        landscape59.duration = 10
//        landscape59.title = "紫气东来"
//        landscape59.releaseTime = 1652084769
//        landscape59.tags = "山水,风景,中国美景"
//        landscape59.authorId = 36468432
//        landscape59.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/159577f106314c4daefdd0dc5ebb8bb8~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=P6gQ2o8luk%2Bz60H%2Foq9zxHfVfJ4%3D"
//        landscape59.vertical = true
//        list.add(landscape59)

//        val landscape60 = PetVideo()
//        landscape60.type = VideoType.LANDSCAPE.ordinal
//        landscape60.fileName = "landscape_60"
//        landscape60.code = 3788
//        landscape60.duration = 10
//        landscape60.title = "充满古诗韵味"
//        landscape60.releaseTime = 1656833169
//        landscape60.tags = "山水,风景,中国美景"
//        landscape60.authorId = 36468432
//        landscape60.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/b77cd7db51be416793e0daddedf5bd1c~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=cJ0aLq0MR9QVmpdPPF5zCZz2IxM%3D"
//        landscape60.vertical = true
//        list.add(landscape60)

//        val landscape61 = PetVideo()
//        landscape61.type = VideoType.LANDSCAPE.ordinal
//        landscape61.fileName = "landscape_61"
//        landscape61.code = 3789
//        landscape61.duration = 10
//        landscape61.title = "比起诗和远方，我还是更喜欢这朴实的人间烟火，夜晚漫天的星光璀璨，和努力向上不逃避生活的人。"
//        landscape61.releaseTime = 1660271169
//        landscape61.tags = "山水,风景,中国美景"
//        landscape61.authorId = 36468432
//        landscape61.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/5f08334af2f14a1b933b02f5191bb5a9~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=POmMpx%2BL3lObAYzz7PlbSFBkPfI%3D"
//        landscape61.vertical = true
//        list.add(landscape61)

//        val landscape62 = PetVideo()
//        landscape62.type = VideoType.LANDSCAPE.ordinal
//        landscape62.fileName = "landscape_62"
//        landscape62.code = 3790
//        landscape62.duration = 10
//        landscape62.title = "彼岸花有名曼珠沙华，它的花语是：见花不见叶，花叶永不相见，它象征着永恒的思念"
//        landscape62.releaseTime = 1660671502
//        landscape62.tags = "山水,风景,中国美景"
//        landscape62.authorId = 36468432
//        landscape62.cover =
//            "https://p6-sign.douyinpic.com/tos-cn-i-dy/7551cc2da44c47c69be6c8aa0896c7c1~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=06eZGTUEb%2BvCYOQvY2XAhlf5XPU%3D"
//        landscape62.vertical = true
//        list.add(landscape62)

        val landscape63 = PetVideo()
        landscape63.type = VideoType.LANDSCAPE.ordinal
        landscape63.fileName = "landscape_63"
        landscape63.code = 3791
        landscape63.duration = 10
        landscape63.title = "月是故乡圆，情是故乡浓，故乡的一切都在这一轮明月中..."
        landscape63.releaseTime = 1662745102
        landscape63.tags = "山水,风景,中国美景"
        landscape63.authorId = 36468432
        landscape63.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/95bf86bf557e44c097d982a1133c7c99_1662812323~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986994800&x-signature=cbx1r6VwE09tg9sMsrk140Y0oZg%3D"
        landscape63.vertical = true
        list.add(landscape63)

//        val landscape64 = PetVideo()
//        landscape64.type = VideoType.LANDSCAPE.ordinal
//        landscape64.fileName = "landscape_64"
//        landscape64.code = 3792
//        landscape64.duration = 10
//        landscape64.title = "本是青灯不归客，却因浊酒恋红尘。 赶路已有清风伴，莫叹岁月不饶人。"
//        landscape64.releaseTime = 1662953902
//        landscape64.tags = "山水,风景,中国美景"
//        landscape64.authorId = 36468432
//        landscape64.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/58abb46311ef4e4dad60ab21dfa0cca9~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=fSbkYpSYTSpMNyqyB2n3DS3YM%2B8%3D"
//        landscape64.vertical = true
//        list.add(landscape64)

//        val landscape65 = PetVideo()
//        landscape65.type = VideoType.LANDSCAPE.ordinal
//        landscape65.fileName = "landscape_65"
//        landscape65.code = 3793
//        landscape65.duration = 10
//        landscape65.title = "留下你最想跟10年前的自己说的话"
//        landscape65.releaseTime = 1663562302
//        landscape65.tags = "山水,风景,中国美景"
//        landscape65.authorId = 36468432
//        landscape65.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/3c911154b329485d91d696733332edbe~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=3gxo%2FHW2UKZKWqQAjg7IeCMh1vE%3D"
//        landscape65.vertical = true
//        list.add(landscape65)

//        val landscape66 = PetVideo()
//        landscape66.type = VideoType.LANDSCAPE.ordinal
//        landscape66.fileName = "landscape_66"
//        landscape66.code = 3794
//        landscape66.duration = 10
//        landscape66.title = "请用你现有的文化描述此景."
//        landscape66.releaseTime = 1669745302
//        landscape66.tags = "山水,风景,中国美景"
//        landscape66.authorId = 36468432
//        landscape66.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/fb7805bfcd4244c3aac355ba952ce3d2~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=1tFaqsMbc3%2FeNaW62JrDFv%2BMOv4%3D"
//        landscape66.vertical = true
//        list.add(landscape66)

//        val landscape67 = PetVideo()
//        landscape67.type = VideoType.LANDSCAPE.ordinal
//        landscape67.fileName = "landscape_67"
//        landscape67.code = 3795
//        landscape67.duration = 10
//        landscape67.title = "总有一段路要一个人走，总有一些事要一个人扛，也总有一份孤独 需要自己一个人去承受。"
//        landscape67.releaseTime = 1670387282
//        landscape67.tags = "山水,风景,中国美景"
//        landscape67.authorId = 36468432
//        landscape67.cover =
//            "https://p3-sign.douyinpic.com/tos-cn-i-dy/4560556f4ba84e1891a2851aea40caef~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=kV6SPnd7uCKm8eTLyXeVwzbiNk0%3D"
//        landscape67.vertical = true
//        list.add(landscape67)

//        val landscape68 = PetVideo()
//        landscape68.type = VideoType.LANDSCAPE.ordinal
//        landscape68.fileName = "landscape_68"
//        landscape68.code = 3796
//        landscape68.duration = 10
//        landscape68.title = "让花成花，让树成树。把别人还给别人，把自己还给自己，从此山水一程再不相逢，愿来生，不见不欠不念。"
//        landscape68.releaseTime = 1670473682
//        landscape68.tags = "山水,风景,中国美景"
//        landscape68.authorId = 36468432
//        landscape68.cover =
//            "https://p9-sign.douyinpic.com/tos-cn-i-dy/ed29628058604b0ab98410cef3efdb2f~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=s2bS9E2LC98e7haEfd3NH16nMhc%3D"
//        landscape68.vertical = true
//        list.add(landscape68)

//        val landscape69 = PetVideo()
//        landscape69.type = VideoType.LANDSCAPE.ordinal
//        landscape69.fileName = "landscape_69"
//        landscape69.code = 3797
//        landscape69.duration = 10
//        landscape69.title = "当你心情不好烦躁不好的时候，就来翻翻我的作品，一定会让你的心慢慢平静下来。"
//        landscape69.releaseTime = 1670522902
//        landscape69.tags = "山水,风景,中国美景"
//        landscape69.authorId = 36468432
//        landscape69.cover =
//            "https://p9-sign.douyinpic.com/tos-cn-i-dy/8fb6a368b9fc4b2ab6fb6063af87a7d0~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=nIR8HUh58%2Be%2FWLqQlZNpXym4HBo%3D"
//        landscape69.vertical = true
//        list.add(landscape69)

//        val landscape70 = PetVideo()
//        landscape70.type = VideoType.LANDSCAPE.ordinal
//        landscape70.fileName = "landscape_70"
//        landscape70.code = 3798
//        landscape70.duration = 10
//        landscape70.title = "请用你现有的文化描述此景."
//        landscape70.releaseTime = 1671142693
//        landscape70.tags = "山水,风景,中国美景"
//        landscape70.authorId = 36468432
//        landscape70.cover =
//            "https://p3-sign.douyinpic.com/tos-cn-i-dy/dbb1e2e95b044206a048cd8a36c2cd81~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=lzJ8aYb%2BvkuTtrPZ7jvzSu3fgjk%3D"
//        landscape70.vertical = true
//        list.add(landscape70)

        val landscape71 = PetVideo()
        landscape71.type = VideoType.LANDSCAPE.ordinal
        landscape71.fileName = "landscape_71"
        landscape71.code = 3799
        landscape71.duration = 10
        landscape71.title = "古人诚不欺我，原来千里江山图是真实存在的，请用你现有的文化描述此景。"
        landscape71.releaseTime = 1671611303
        landscape71.tags = "山水,风景,中国美景"
        landscape71.authorId = 36468432
        landscape71.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/09abe098d77b405d9456cbd9e1318b7d_1671532275~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986994800&x-signature=dsDf5OK%2FoaBw4BlMG4iCLh%2B3BbY%3D"
        landscape71.vertical = true
        list.add(landscape71)

        val landscape72 = PetVideo()
        landscape72.type = VideoType.LANDSCAPE.ordinal
        landscape72.fileName = "landscape_72"
        landscape72.code = 3800
        landscape72.duration = 10
        landscape72.title = "接下来就是 元旦 期末 烟火 新年 分享给一个会陪你跨年的人吧。"
        landscape72.releaseTime = 1671614903
        landscape72.tags = "山水,风景,中国美景"
        landscape72.authorId = 36468432
        landscape72.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/453312870f14405dae7cdc99c8bfd918_1671542255~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986994800&x-signature=GIkfMi3ci3SbX0EqxNdYkxsdQbc%3D"
        landscape72.vertical = true
        list.add(landscape72)

//        val landscape73 = PetVideo()
//        landscape73.type = VideoType.LANDSCAPE.ordinal
//        landscape73.fileName = "landscape_73"
//        landscape73.code = 3801
//        landscape73.duration = 10
//        landscape73.title = "“今年冬天可以相约一起看雪吗”"
//        landscape73.releaseTime = 1671674903
//        landscape73.tags = "山水,风景,中国美景"
//        landscape73.authorId = 36468432
//        landscape73.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-dy/40d763acfa58417898efd036249f7479~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=xbuF4nJujwadFVt%2B4%2BA5oYOY3rQ%3D"
//        landscape73.vertical = true
//        list.add(landscape73)

//        val landscape74 = PetVideo()
//        landscape74.type = VideoType.LANDSCAPE.ordinal
//        landscape74.fileName = "landscape_74"
//        landscape74.code = 3802
//        landscape74.duration = 10
//        landscape74.title = "愿新年胜旧年，愿将来胜过往，愿你与旧事归于尽，来年依旧迎花开。"
//        landscape74.releaseTime = 1613009303
//        landscape74.tags = "山水,风景,中国美景"
//        landscape74.authorId = 36468432
//        landscape74.cover =
//            "https://p26-sign.douyinpic.com/tos-cn-i-0813/27c40bfded864879bf2419ecf68b3085~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672844400&x-signature=fRZc%2BjCf%2BxZz6k%2FZlDwpNRe%2F16Y%3D"
//        landscape74.vertical = true
//        list.add(landscape74)

        val landscape75 = PetVideo()
        landscape75.type = VideoType.LANDSCAPE.ordinal
        landscape75.fileName = "landscape_75"
        landscape75.code = 3803
        landscape75.duration = 10
        landscape75.title = "“希望谁开心快乐一辈子 就艾特谁”"
        landscape75.releaseTime = 1664503703
        landscape75.tags = "山水,风景,中国美景"
        landscape75.authorId = 36468458
        landscape75.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/ffb5649e04444b648b122091b745a498~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986998400&x-signature=Z5ZoIULZdI%2FyZbsLQcvJc7mLmNY%3D"
        landscape75.vertical = true
        list.add(landscape75)

        val landscape76 = PetVideo()
        landscape76.type = VideoType.LANDSCAPE.ordinal
        landscape76.fileName = "landscape_76"
        landscape76.code = 3804
        landscape76.duration = 10
        landscape76.title = "好喜欢这个音乐,让我想到乡村,童年,傍晚和烟火,心里无比温暖,宁静和舒适."
        landscape76.releaseTime = 1671502103
        landscape76.tags = "山水,风景,中国美景"
        landscape76.authorId = 36468458
        landscape76.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/owAi5jFBJfxDAZ89c3QHedACEugbuwcAqloISn~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986998400&x-signature=VXpv8EeaDdlJzLJ%2FmB6os0rAJv8%3D"
        landscape76.vertical = true
        list.add(landscape76)

        val landscape77 = PetVideo()
        landscape77.type = VideoType.LANDSCAPE.ordinal
        landscape77.fileName = "landscape_77"
        landscape77.code = 3805
        landscape77.duration = 10
        landscape77.title = "“今年冬天可以相约一起看雪吗”"
        landscape77.releaseTime = 1668061703
        landscape77.tags = "山水,风景,中国美景"
        landscape77.authorId = 36468458
        landscape77.cover =
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/4c6dc2fc9ec0497e8e7b7ebb295eb148~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1986998400&x-signature=czQ4c%2FhCHXxRzbVf%2FbdVZnFrFvU%3D"
        landscape77.vertical = true
        list.add(landscape77)

//        val landscape78 = PetVideo()
//        landscape78.type = VideoType.LANDSCAPE.ordinal
//        landscape78.fileName = "landscape_78"
//        landscape78.code = 3806
//        landscape78.duration = 10
//        landscape78.title = "被人艾特看烟花真的是一件非常非常幸福的事，记得许愿！#向烟花许个愿"
//        landscape78.releaseTime = 1671212903
//        landscape78.tags = "山水,风景,中国美景"
//        landscape78.authorId = 36468432
//        landscape78.cover =
//            "https://p9-sign.douyinpic.com/tos-cn-i-dy/d295c7f00df841ae8920f05762bdf7d7~noop.jpeg?from=3213915784&s=PackSourceEnum_PUBLISH&sc=optimized_cover&se=false&x-expires=1672848000&x-signature=soFzeNaFUVo5cpuG32YcVWtaJ%2Fw%3D"
//        landscape78.vertical = true
//        list.add(landscape78)

        val landscape79 = PetVideo()
        landscape79.type = VideoType.LANDSCAPE.ordinal
        landscape79.fileName = "landscape_79"
        landscape79.code = 3807
        landscape79.duration = 10
        landscape79.title = "“借用你的才华描述一下此景”"
        landscape79.releaseTime = 1671700901
        landscape79.tags = "山水,风景,中国美景"
        landscape79.authorId = 36468958
        landscape79.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/oMeJP2fjoAQPA50ADIQwV9BBCnGbQwOGABmgIn~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=VKvvlSsaJdCt5f9QtPxL8UQfQtQ%3D"
        landscape79.vertical = true
        list.add(landscape79)

        val landscape80 = PetVideo()
        landscape80.type = VideoType.LANDSCAPE.ordinal
        landscape80.fileName = "landscape_80"
        landscape80.code = 3808
        landscape80.duration = 10
        landscape80.title = "来人间不过是看一场风雪"
        landscape80.releaseTime = 1671556901
        landscape80.tags = "山水,风景,中国美景"
        landscape80.authorId = 36468958
        landscape80.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/owOh9bVOjECZAWAEsBo88yNDIenAhaAeigbS2K~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=RN%2BaXWu%2F3A3Rn%2FA9uVW%2F0VAqDA4%3D"
        landscape80.vertical = true
        list.add(landscape80)

//        val landscape81 = PetVideo()
//        landscape81.type = VideoType.LANDSCAPE.ordinal
//        landscape81.fileName = "landscape_81"
//        landscape81.code = 3809
//        landscape81.duration = 10
//        landscape81.title = "“哀吾生之须臾”"
//        landscape81.releaseTime = 1671297701
//        landscape81.tags = "山水,风景,中国美景"
//        landscape81.authorId = 36468958
//        landscape81.cover =
//            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/oA0pECaVyzAOtVRd5tfHAexAqAjgABnzI8tjdh~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=k2GTXwgCwK74EZQhpn3Vn2lLgX4%3D"
//        landscape81.vertical = true
//        list.add(landscape81)

        val landscape82 = PetVideo()
        landscape82.type = VideoType.LANDSCAPE.ordinal
        landscape82.fileName = "landscape_82"
        landscape82.code = 3810
        landscape82.duration = 10
        landscape82.title = "风一更，雪一更。点点声声不忍听，心中无限情。"
        landscape82.releaseTime = 1668597701
        landscape82.tags = "山水,风景,中国美景"
        landscape82.authorId = 36468958
        landscape82.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/91295763e27e4dd0a8227bac6e81ffaf~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=d5Yd0w4gxPMGfv0UVqFjTdpYG8A%3D"
        landscape82.vertical = true
        list.add(landscape82)

        val landscape83 = PetVideo()
        landscape83.type = VideoType.LANDSCAPE.ordinal
        landscape83.fileName = "landscape_83"
        landscape83.code = 3811
        landscape83.duration = 10
        landscape83.title = "“煮一壶生死悲欢，祭少年郎”"
        landscape83.releaseTime = 1667388101
        landscape83.tags = "山水,风景,中国美景"
        landscape83.authorId = 36468958
        landscape83.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/3d51e384e28940df98815d0ea0c95288~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=FXyVClVRVbdrmY0T79S9rBl8nKQ%3D"
        landscape83.vertical = true
        list.add(landscape83)

        val landscape84 = PetVideo()
        landscape84.type = VideoType.LANDSCAPE.ordinal
        landscape84.fileName = "landscape_84"
        landscape84.code = 3812
        landscape84.duration = 10
        landscape84.title = "白首如新 倾盖如故"
        landscape84.releaseTime = 1667038901
        landscape84.tags = "山水,风景,中国美景"
        landscape84.authorId = 36468958
        landscape84.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/019590391d4d4aaf90f30177da3e6a51~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=ks%2FlQD27kqLqGy7T3rZxFoZAEGM%3D"
        landscape84.vertical = true
        list.add(landscape84)

        val landscape85 = PetVideo()
        landscape85.type = VideoType.LANDSCAPE.ordinal
        landscape85.fileName = "landscape_85"
        landscape85.code = 3813
        landscape85.duration = 10
        landscape85.title = "“悟已往之不谏”"
        landscape85.releaseTime = 1669455941
        landscape85.tags = "山水,风景,中国美景"
        landscape85.authorId = 36468958
        landscape85.cover =
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/74597652b463475d9654a693cf0c9237~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_PUBLISH&sc=cover&se=true&sh=323_430&x-expires=1987059600&x-signature=DgzQHt%2FG88YNIEvRnYkj55ttZ68%3D"
        landscape85.vertical = true
        list.add(landscape85)

        return list
    }

    private val poems = arrayListOf(
        "西江月·世事一场大梦 \n" +
                "苏轼 \n" +
                "世事一场大梦，人生几度秋凉 \n " +
                "夜来风叶已鸣廊，看取眉头鬓上 \n" +
                "酒贱常愁客少，月明多被云妨 \n" +
                "中秋谁与共孤光。把盏凄然北望",
        "清平调·其一 \n" +
                "李白 \n" +
                "云想衣裳花想容，春风拂槛露华浓 \n" +
                "若非群玉山头见，会向瑶台月下逢",
        "和董传留别 \n" +
                "苏轼 \n" +
                "粗缯大布裹生涯，腹有诗书气自华 \n" +
                "厌伴老儒烹瓠叶，强随举子踏槐花 \n" +
                "囊空不办寻春马，眼乱行看择婿车 \n" +
                "得意犹堪夸世俗，诏黄新湿字如鸦",
        "长相思·其一 \n" +
                "李白 \n" +
                "长相思，在长安 \n" +
                "络纬秋啼金井阑，微霜凄凄簟色寒 \n" +
                "孤灯不明思欲绝，卷帷望月空长叹 \n" +
                "美人如花隔云端！ \n" +
                "上有青冥之长天，下有渌水之波澜 \n" +
                "天长路远魂飞苦，梦魂不到关山难 \n" +
                "长相思，摧心肝！",
        "临江仙 \n" +
                "杨慎 \n" +
                "滚滚长江东逝水，浪花淘尽英雄 \n" +
                "是非成败转头空 \n" +
                "青山依旧在，几度夕阳红 \n" +
                "白发渔樵江渚上，惯看秋月春风 \n" +
                "一壶浊酒喜相逢 \n" +
                "古今多少事，都付笑谈中",
        "终南别业 \n" +
                "王维 \n" +
                "中岁颇好道，晚家南山陲 \n" +
                "兴来每独往，胜事空自知 \n" +
                "行到水穷处，坐看云起时 \n" +
                "偶然值林叟，谈笑无还期 \n",


        )
}