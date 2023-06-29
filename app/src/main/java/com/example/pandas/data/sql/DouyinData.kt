package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

object DouyinData {

    private val list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {

        val short1 = PetVideo()
        short1.type = VideoType.SHORT.ordinal
        short1.fileName = "short1"
        short1.code = 3814
        short1.duration = 17
        short1.star = false
        short1.vertical = true
        short1.title = "雅一大型粉丝见面会开始啦😂互动之前先表演个节目#大熊猫雅一 #大熊猫 #不止我一个想rua大熊猫 #萌宠出道计划"
        short1.releaseTime = 1688055984
        short1.tags = "大熊猫,萌宠,动物圈,雅一"
        short1.authorId = 36468959
        short1.width = 323
        short1.height = 430
        short1.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/o43mnbX9ADHNQS3wJCkgeBb2Io92AAl08AeWuj~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=3z6LbItSdqDBAhtoLvDcDoTGIKc%3D"
        list.add(short1)

        val short2 = PetVideo()
        short2.type = VideoType.SHORT.ordinal
        short2.fileName = "short2"
        short2.code = 3815
        short2.duration = 7
        short2.star = true
        short2.vertical = true
        short2.title = "明明她都那么乖了，可我还是忍不住的冲她发火，凶了她 也不哭，委屈的看着我 努力的挪到我身边要抱抱#带娃的日子 #只有宝妈才懂吧 #小煤气罐罐 #委屈巴巴"
        short2.releaseTime = 1688046855
        short2.authorId = 36468960
        short2.width = 323
        short2.height = 430
        short2.cover =
            "https://p6-pc-sign.douyinpic.com/tos-cn-p-0015/oYBBAPfnceKW2ADBEkDnAubAIXwlg7DTACclO9~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=JMf3R6qbYFVcZ%2FohA1OWUk4UUP4%3D"
        list.add(short2)


        val short3 = PetVideo()
        short3.type = VideoType.SHORT.ordinal
        short3.fileName = "short3"
        short3.code = 3816
        short3.duration = 13
        short3.star = true
        short3.vertical = true
        short3.title = "裴佳欣：排队中…#我收藏的夏天 #元气少女"
        short3.releaseTime = 1688047855
        short3.authorId = 36468961
        short3.width = 323
        short3.height = 430
        short3.cover =
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/okAhNkWBei5DAQ89IvICtHACXcgb0AeZPamEEn~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=nshUsqhLUfFjiD23%2BMG74TbU3vw%3D"
        list.add(short3)

        val short4 = PetVideo()
        short4.type = VideoType.SHORT.ordinal
        short4.fileName = "short4"
        short4.code = 3817
        short4.duration = 41
        short4.star = true
        short4.vertical = true
        short4.title = "小仓桑和小仓酱：情侣间那些小故事#情侣日常 #治愈系 #轻漫计划原创动漫"
        short4.releaseTime = 1688047955
        short4.authorId = 36468962
        short4.width = 323
        short4.height = 430
        short4.cover =
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/oAjz6PHRngisMTgoAk8ENe98hBbfkuAQDGgsAJ~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=W1nGpn1PGl4tWZhZuJUad6qab2Y%3D"
        list.add(short4)

        val short5 = PetVideo()
        short5.type = VideoType.SHORT.ordinal
        short5.fileName = "short5"
        short5.code = 3818
        short5.duration = 8
        short5.star = true
        short5.vertical = true
        short5.title = "夏の木：#日本女生 #初恋脸 #初恋"
        short5.releaseTime = 1688048955
        short5.authorId = 36468963
        short5.width = 323
        short5.height = 430
        short5.cover =
            "https://p9-pc-sign.douyinpic.com/tos-cn-p-0015/8390ae6af632409a9798956c231ea4f2_1687764941~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=fwhzufZvyCLWQInsoiuZfFm5dT4%3D"
        list.add(short5)

        val short6 = PetVideo()
        short6.type = VideoType.SHORT.ordinal
        short6.fileName = "short6"
        short6.code = 3819
        short6.duration = 12
        short6.star = true
        short6.vertical = true
        short6.title = "小爱同学一片岁月静好，小可就不好说……#熊猫日记"
        short6.releaseTime = 1688042955
        short6.authorId = 36468964
        short6.width = 323
        short6.height = 430
        short6.cover =
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/o4UHe84eIa3BaRMCoyhP2Be7F2A5G6vAE1qJQn~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=tG7AYPYbJ9q9AUFUT0G2x8c4SMI%3D"
        list.add(short6)

        val short7 = PetVideo()
        short7.type = VideoType.SHORT.ordinal
        short7.fileName = "short7"
        short7.code = 3820
        short7.duration = 13
        short7.star = true
        short7.vertical = true
        short7.title = "傍晚一家三口 骑骑电车吹吹晚风 好像也很浪漫#女儿控 #无忧无虑的童年"
        short7.releaseTime = 1688022955
        short7.authorId = 36468965
        short7.width = 323
        short7.height = 430
        short7.cover =
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/oEBzeqzWTWKtvR9RZYY0NithBoAfEAySAIgAEz~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=hescLoPkIZzboSGhtq0KU5HoYDQ%3D"
        list.add(short7)


        return list
    }
}