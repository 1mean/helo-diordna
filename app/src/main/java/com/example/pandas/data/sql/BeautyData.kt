package com.example.pandas.data.sql

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PetVideo

object BeautyData {

    private val list = mutableListOf<PetVideo>()

    fun getBeauty(): MutableList<PetVideo> {

        val beauty1 = PetVideo()
        beauty1.type = VideoType.BEAUTY.ordinal
        beauty1.fileName = "beauty1"
        beauty1.code = 1384
        beauty1.duration = 22
        beauty1.star = true
        beauty1.title = "惊鸿一瞥的貂蝉"
        beauty1.releaseTime = "2020-12-02 14:51:58"
        beauty1.originalUrl = "https://www.bilibili.com/video/BV1hZ4y1G7fL"
        beauty1.tags = "美女"
        beauty1.authorId = 445048708
        beauty1.cover =
            "https://i1.hdslb.com/bfs/archive/9b90018d3acfe1a1c6a66e42fd658eb45dd8df03.jpg"
        list.add(beauty1)

        val beauty2 = PetVideo()
        beauty2.type = VideoType.BEAUTY.ordinal
        beauty2.fileName = "beauty2"
        beauty2.code = 1385
        beauty2.duration = 224
        beauty2.star = true
        beauty2.title = "【刘亦菲1080p超清美貌】镜头怼得越近老娘越美"
        beauty2.releaseTime = "2020-01-15 18:08:52"
        beauty2.originalUrl = "https://www.bilibili.com/video/BV11J411J7tr"
        beauty2.tags = "美女"
        beauty2.authorId = 140918720
        beauty2.cover =
            "https://i1.hdslb.com/bfs/archive/ba12739b8df0059596f414e8103c1a57d30b576b.jpg"
        list.add(beauty2)

        val beauty3 = PetVideo()
        beauty3.type = VideoType.BEAUTY.ordinal
        beauty3.fileName = "beauty3"
        beauty3.code = 1386
        beauty3.duration = 133
        beauty3.star = true
        beauty3.title = "这才是言情女主的正确打开方式！【刘亦菲】"
        beauty3.releaseTime = "2020-11-22 20:55:23"
        beauty3.originalUrl = "https://www.bilibili.com/video/BV1VV411a7CK"
        beauty3.tags = "美女"
        beauty3.authorId = 95669899
        beauty3.cover =
            "https://i0.hdslb.com/bfs/archive/af69e10ccc01d2850a47d1cb0e01845d44a28fe7.jpg"
        list.add(beauty3)

        val beauty4 = PetVideo()
        beauty4.type = VideoType.BEAUTY.ordinal
        beauty4.fileName = "beauty4"
        beauty4.code = 1387
        beauty4.duration = 44
        beauty4.star = true
        beauty4.title = "hu小说女主婚礼被虐现场"
        beauty4.releaseTime = "2022-02-08 22:03:48"
        beauty4.originalUrl = "https://www.bilibili.com/video/BV16r4y1h78V"
        beauty4.tags = "美女"
        beauty4.authorId = 485226408
        beauty4.cover =
            "https://i2.hdslb.com/bfs/archive/153db771d26904fc142a14daf5747039a16e81cc.jpg"
        list.add(beauty4)

        val beauty5 = PetVideo()
        beauty5.type = VideoType.BEAUTY.ordinal
        beauty5.fileName = "beauty5"
        beauty5.code = 1944
        beauty5.duration = 91
        beauty5.star = true
        beauty5.title = "姐姐！龙袍都穿了！还要什么男人啊！"
        beauty5.releaseTime = "2021-04-23 21:56:56"
        beauty5.originalUrl = "https://www.bilibili.com/video/BV1F54y187Xv"
        beauty5.tags = "美女"
        beauty5.authorId = 27306175
        beauty5.cover =
            "https://i0.hdslb.com/bfs/archive/3a4187bfb1075168dccedbbefd8686a16e40dadd.jpg"
        list.add(beauty5)

        val beauty6 = PetVideo()
        beauty6.type = VideoType.BEAUTY.ordinal
        beauty6.fileName = "beauty6"
        beauty6.code = 1945
        beauty6.duration = 181
        beauty6.star = true
        beauty6.title = "无   人   生   还"
        beauty6.releaseTime = "2020-02-15 18:08:08"
        beauty6.originalUrl = "https://www.bilibili.com/video/BV1v7411J73g"
        beauty6.tags = "美女"
        beauty6.authorId = 9370995
        beauty6.cover =
            "https://i2.hdslb.com/bfs/archive/6d8660336a4099c8e631f901ae6d0fe311dc3a3e.jpg"
        list.add(beauty6)

        val beauty7 = PetVideo()
        beauty7.type = VideoType.BEAUTY.ordinal
        beauty7.fileName = "beauty7"
        beauty7.code = 1946
        beauty7.duration = 68
        beauty7.star = true
        beauty7.title = "江玉燕问一个能打的都没有吗？于是她！她站出来了！！"
        beauty7.releaseTime = "2021-06-25 18:39:23"
        beauty7.originalUrl = "https://www.bilibili.com/video/BV1Jq4y1s7ob"
        beauty7.tags = "美女"
        beauty7.authorId = 200634377
        beauty7.cover =
            "https://i2.hdslb.com/bfs/archive/d3babf06e2cdb28d2502a72e1894c026c3dad58b.jpg"
        list.add(beauty7)

        val beauty8 = PetVideo()
        beauty8.type = VideoType.BEAUTY.ordinal
        beauty8.fileName = "beauty8"
        beauty8.code = 1947
        beauty8.duration = 128
        beauty8.star = true
        beauty8.title = "当年原著党都抵制这个角色！结果剧播出后最火的就是她！"
        beauty8.releaseTime = "2021-09-20 11:38:46"
        beauty8.originalUrl = "https://www.bilibili.com/video/BV1tf4y1n7D3"
        beauty8.tags = "美女"
        beauty8.authorId = 435041418
        beauty8.cover =
            "https://i0.hdslb.com/bfs/archive/e59ff07badeac9058373f79893ddc63c151077c6.jpg"
        list.add(beauty8)

        val beauty9 = PetVideo()
        beauty9.type = VideoType.BEAUTY.ordinal
        beauty9.fileName = "beauty9"
        beauty9.code = 1948
        beauty9.duration = 127
        beauty9.star = true
        beauty9.title = "这么年轻就演妈！你可知当年她可是最美公孙绿萼呀"
        beauty9.releaseTime = "2021-02-28 15:07:51"
        beauty9.originalUrl = "https://www.bilibili.com/video/BV1ii4y1N71U"
        beauty9.tags = "美女"
        beauty9.authorId = 44341427
        beauty9.cover =
            "https://i0.hdslb.com/bfs/archive/536ef7b424a3b04359ad51004d9d65981e51a09b.jpg"
        list.add(beauty9)

        val beauty10 = PetVideo()
        beauty10.type = VideoType.BEAUTY.ordinal
        beauty10.fileName = "beauty10"
        beauty10.code = 1949
        beauty10.duration = 133
        beauty10.star = true
        beauty10.title = "【全员美人|天龙八部】你可曾见过人均绝色的电视剧【第十五期】"
        beauty10.releaseTime = "2020-05-26 18:10:39"
        beauty10.originalUrl = "https://www.bilibili.com/video/BV1sf4y127j5"
        beauty10.tags = "美女"
        beauty10.authorId = 2024662
        beauty10.cover =
            "https://i2.hdslb.com/bfs/archive/5d46a74fe0dc948bb24b03b00ab4dd18a98cb61c.jpg"
        list.add(beauty10)

        val beauty11 = PetVideo()
        beauty11.type = VideoType.BEAUTY.ordinal
        beauty11.fileName = "beauty11"
        beauty11.code = 1950
        beauty11.duration = 147
        beauty11.star = true
        beauty11.title = "【全员美人|仙剑奇侠传一】你可曾见过人均绝色的电视剧【第十四期】"
        beauty11.releaseTime = "2020-05-18 18:30:18"
        beauty11.originalUrl = "https://www.bilibili.com/video/BV1pp4y1Q7vf"
        beauty11.tags = "美女"
        beauty11.authorId = 2024662
        beauty11.cover =
            "https://i0.hdslb.com/bfs/archive/0c0aa3f9e32c7c13f0bdcce37b246f6ac43679f4.jpg"
        list.add(beauty11)

        val beauty12 = PetVideo()
        beauty12.type = VideoType.BEAUTY.ordinal
        beauty12.fileName = "beauty12"
        beauty12.code = 1951
        beauty12.duration = 164
        beauty12.star = true
        beauty12.title = "仙 侠 女 主 的 巅 峰！！！这才是古偶剧该有的颜值"
        beauty12.releaseTime = "2020-09-18 09:00:19"
        beauty12.originalUrl = "https://www.bilibili.com/video/BV1pv411C7jh"
        beauty12.tags = "美女"
        beauty12.authorId = 19429622
        beauty12.cover =
            "https://i0.hdslb.com/bfs/archive/805049f0c40a14bcbcd3c3fdd312ea0db31390e1.jpg"
        list.add(beauty12)

        val beauty13 = PetVideo()
        beauty13.type = VideoType.BEAUTY.ordinal
        beauty13.fileName = "beauty13"
        beauty13.code = 1952
        beauty13.duration = 132
        beauty13.star = true
        beauty13.title = "卧槽！她们互看的这一段，鬼知道我看了多少遍！"
        beauty13.releaseTime = "2022-02-19 14:31:09"
        beauty13.originalUrl = "https://www.bilibili.com/video/BV18L411K7zU"
        beauty13.tags = "美女"
        beauty13.authorId = 42448991
        beauty13.cover =
            "https://i0.hdslb.com/bfs/archive/c4bcd4ea289017ae08dc9166d3f95547454a52f3.jpg"
        list.add(beauty13)

        val beauty14 = PetVideo()
        beauty14.type = VideoType.BEAUTY.ordinal
        beauty14.fileName = "beauty14"
        beauty14.code = 1953
        beauty14.duration = 139
        beauty14.star = true
        beauty14.title = "怪不得粉丝都叫她千金，这气质也太绝了？！"
        beauty14.releaseTime = "2022-02-05 02:08:36"
        beauty14.originalUrl = "https://www.bilibili.com/video/BV1uR4y17724"
        beauty14.tags = "美女"
        beauty14.authorId = 404523870
        beauty14.cover =
            "https://i0.hdslb.com/bfs/archive/15f9c7210b27e43f116605120e0f8658539b02fc.jpg"
        list.add(beauty14)

        val beauty15 = PetVideo()
        beauty15.type = VideoType.BEAUTY.ordinal
        beauty15.fileName = "beauty15"
        beauty15.code = 1954
        beauty15.duration = 185
        beauty15.star = true
        beauty15.title = "【4K纯享】追逐蝴蝶的少女,K宝全俄短节目获90+高分"
        beauty15.releaseTime = "2021-12-25 10:42:07"
        beauty15.originalUrl = "https://www.bilibili.com/video/BV1Lg411A7Lq"
        beauty15.tags = "美女"
        beauty15.authorId = 396343652
        beauty15.cover =
            "https://i2.hdslb.com/bfs/archive/d53ff854866edea9c3f5287dac81e9a55e4eb84e.jpg"
        list.add(beauty15)

        val beauty16 = PetVideo()
        beauty16.type = VideoType.BEAUTY.ordinal
        beauty16.fileName = "beauty16"
        beauty16.code = 1955
        beauty16.duration = 172
        beauty16.star = true
        beauty16.title = "【花滑千金】冰上时刻，2016年莫斯科锦标赛短节目表演"
        beauty16.releaseTime = "2022-03-05 19:39:04"
        beauty16.originalUrl = "https://www.bilibili.com/video/BV1ja411b7Uz"
        beauty16.tags = "美女"
        beauty16.authorId = 2087432052
        beauty16.cover =
            "https://i1.hdslb.com/bfs/archive/b91977033326ef1ac713d49d52ef6219c9101880.jpg"
        list.add(beauty16)

        val beauty17 = PetVideo()
        beauty17.type = VideoType.BEAUTY.ordinal
        beauty17.fileName = "beauty17"
        beauty17.code = 1956
        beauty17.duration = 69
        beauty17.star = true
        beauty17.title = "17岁的高圆圆？班主任 ：至少 10个班的男生 在追她！"
        beauty17.releaseTime = "2021-04-10 13:11:12"
        beauty17.originalUrl = "https://www.bilibili.com/video/BV1V5411c7jL"
        beauty17.tags = "美女"
        beauty17.authorId = 293243325
        beauty17.cover =
            "https://i1.hdslb.com/bfs/archive/7c984d7b2e572888466dafc4cdd2c668c862e176.jpg"
        list.add(beauty17)

        val beauty18 = PetVideo()
        beauty18.type = VideoType.BEAUTY.ordinal
        beauty18.fileName = "beauty18"
        beauty18.code = 1957
        beauty18.duration = 246
        beauty18.star = true
        beauty18.title = "【袁泉】19个角色|从少女到总裁"
        beauty18.releaseTime = "2020-01-05 13:50:08"
        beauty18.originalUrl = "https://www.bilibili.com/video/BV1WJ411L7MG"
        beauty18.tags = "美女"
        beauty18.authorId = 20429499
        beauty18.cover =
            "https://i2.hdslb.com/bfs/archive/310f5747a323dc0446ec05d622bc80c2fddb7881.jpg"
        list.add(beauty18)

        val beauty19 = PetVideo()
        beauty19.type = VideoType.BEAUTY.ordinal
        beauty19.fileName = "beauty19"
        beauty19.code = 1958
        beauty19.duration = 295
        beauty19.star = true
        beauty19.title = "【60后群像||85人】颜狗盛宴！上世纪大陆美人真的是百花齐放啊！"
        beauty19.releaseTime = "2020-11-28 12:00:10"
        beauty19.originalUrl = "https://www.bilibili.com/video/BV1YA411x7fV"
        beauty19.tags = "美女"
        beauty19.authorId = 44041977
        beauty19.cover =
            "https://i2.hdslb.com/bfs/archive/1d88898a6c9cb4de5a37bcdefdbb76ed0ee14ea1.jpg"
        list.add(beauty19)

        val beauty20 = PetVideo()
        beauty20.type = VideoType.BEAUTY.ordinal
        beauty20.fileName = "beauty20"
        beauty20.code = 1959
        beauty20.duration = 184
        beauty20.star = true
        beauty20.title = "这是六界聚会吗？从50到00的女神都来了"
        beauty20.releaseTime = "2022-01-02 14:33:25"
        beauty20.originalUrl = "https://www.bilibili.com/video/BV1b34y1z7rx"
        beauty20.tags = "美女"
        beauty20.authorId = 1151868166
        beauty20.cover =
            "https://i1.hdslb.com/bfs/archive/06c3936345e5ec2816176c3a171348495bda5f5b.jpg"
        list.add(beauty20)

        return list
    }
}