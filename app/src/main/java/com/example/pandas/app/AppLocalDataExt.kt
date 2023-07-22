package com.example.pandas.app;

import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo


//给本地视频文件目录设定的名字和封面图
val fileDesc = mapOf(
    "all" to "https://i0.hdslb.com/bfs/archive/483368feffdc0edcd09ea1dcff50e0c66e38c730.jpg",
    "baby" to "https://i1.hdslb.com/bfs/archive/451fa422bd1d721ff0ddd4790cccc20cc3043c57.jpg",
    "group" to "https://i1.hdslb.com/bfs/archive/d791f0eb581f5ba885dd5604cd28767ac1ef4de7.jpg",
    "mom" to "https://i0.hdslb.com/bfs/archive/f687398b040af3d6f08b5a995920a67bef983bba.jpg",
    "single" to "https://i2.hdslb.com/bfs/archive/5f04a15762b54f27bf9a79995bdf055065a6e2f6.jpg",
    "knowledge" to "https://i2.hdslb.com/bfs/archive/1014a8fa30a2bb8487d6a9f6e9a402615716e0b8.jpg",
    "art" to "https://i0.hdslb.com/bfs/archive/cd2661ecb62a563fa5cd2bb1ab837192516d858d.jpg",
    "beauty" to "https://i0.hdslb.com/bfs/archive/805049f0c40a14bcbcd3c3fdd312ea0db31390e1.jpg",
    "honglou" to "https://i1.hdslb.com/bfs/archive/b8e17de5829f4e80be94ffed86f7d46909aabdcf.jpg",
    "human_baby" to "https://i1.hdslb.com/bfs/archive/3ff9843ac7c088c541d56b7f1fb642486651b7da.jpg",
    "landscape" to "https://i2.hdslb.com/bfs/archive/66cb027e130fb6bc8f96e03b52904af479003d10.jpg",
    "music" to "https://imge.kugou.com/stdmusic/20170731/20170731155506994245.jpg",
    "bear" to "https://i2.hdslb.com/bfs/archive/6e863bf83b61823887944e60a4c12b08f9357790.jpg",
    "bird" to "https://i1.hdslb.com/bfs/archive/526fad4c5722a3f162adcbe878f77183d57202ec.jpg",
    "cat" to "https://i0.hdslb.com/bfs/archive/0c174e87b43a0356094baeb84d04fc49181de0cf.jpg",
    "fox" to "https://i1.hdslb.com/bfs/archive/30b259a24c170e6e27d9eeb315cce28345cec181.jpg",
    "monkey" to "https://i2.hdslb.com/bfs/archive/8553500fb6b7b8281b19231e3c71e643267e5c40.jpg",
    "penguin" to "https://i0.hdslb.com/bfs/archive/8f526c9802ddc0bdc52b514751a984fe0a68633e.jpg",
    "red_panda" to "https://i1.hdslb.com/bfs/archive/e773e153f7fa7f8d1e18023139589e9d0f956772.png",
    "football" to "https://i0.hdslb.com/bfs/archive/56101cc1a83c3eb4ed72968761c096204a9f6299.jpg",
    "hamster" to "https://i2.hdslb.com/bfs/archive/a8d3c2a940d19308df4fad3fa10e54c6911f65e8.jpg",
    "rabbit" to "https://i2.hdslb.com/bfs/archive/2ac141479631186ba89a4cc27221b2f63c5f6ef9.jpg",
    "tiger" to "https://i1.hdslb.com/bfs/archive/da0ec0f4b52e1ca967442d32ead4093bc7eacaea.jpg",
    "short" to "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/okAhNkWBei5DAQ89IvICtHACXcgb0AeZPamEEn~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003414400&x-signature=nshUsqhLUfFjiD23%2BMG74TbU3vw%3D",
)

public enum class FileExtName(private var fileName: String, private var uiName: String) {

    All("all", "成长记录") {
        override fun getFileName() = "panda/all"
    },
    BABY("baby", "幼崽") {
        override fun getFileName() = "panda/baby"
    },
    GROUP("group", "幼年班") {
        override fun getFileName() = "panda/group"
    },
    MOM("mom", "母子") {
        override fun getFileName() = "panda/mom"
    },
    SINGLE("single", "成年") {
        override fun getFileName() = "panda/single"
    },
    KNOWLEDGE("knowledge", "科普") {
        override fun getFileName() = "panda/knowledge"
    },
    ART("art", "艺术") {
        override fun getFileName() = "entertainment/art"
    },
    BEAUTY("beauty", "美人") {
        override fun getFileName() = "entertainment/beauty"
    },
    HONGLOU("honglou", "红楼") {
        override fun getFileName() = "culture/honglou"
    },
    HUMAN_BABY("human_baby", "宝宝") {
        override fun getFileName() = "entertainment/human_baby"
    },
    LANDSCAPE("landscape", "山水") {
        override fun getFileName() = "China/landscape"
    },
    MUSIC("music", "音乐") {
        override fun getFileName() = "entertainment/music"
    },
    BEAR("bear", "熊") {
        override fun getFileName() = "animal/bear"
    },
    BIRD("bird", "鸟") {
        override fun getFileName() = "animal/bird"
    },
    CAT("cat", "猫") {
        override fun getFileName() = "animal/cat"
    },
    FOX("fox", "狐狸") {
        override fun getFileName() = "animal/fox"
    },
    HAMSTER("hamster", "仓鼠") {
        override fun getFileName() = "animal/hamster"
    },
    MONKEY("monkey", "金丝猴") {
        override fun getFileName() = "animal/monkey"
    },
    PENGUIN("penguin", "企鹅") {
        override fun getFileName() = "animal/penguin"
    },
    RABBIT("rabbit", "兔兔") {
        override fun getFileName() = "animal/rabbit"
    },
    RED_PANDA("red_panda", "小熊猫") {
        override fun getFileName() = "animal/red_panda"
    },
    TIGER("tiger", "老虎") {
        override fun getFileName() = "animal/tiger"
    },
    FOOTBALL("football", "足球") {
        override fun getFileName() = "sports/football"
    },
    TV("tv", "电视剧") {
        override fun getFileName() = "entertainment/tv"
    },
    CHINA("China", "中国") {
        override fun getFileName() = "China"
    },
    ANIMAL("animal", "动物") {
        override fun getFileName() = "animal"
    },
    SHORT("short", "短视频") {
        override fun getFileName() = "other/short"
    },
    OTHER("other", "其他") {
        override fun getFileName() = "other"
    },
    SPORTS("sports", "体育") {
        override fun getFileName() = "sports"
    },
    ENTERTAINMENT("entertainment", "娱乐") {
        override fun getFileName() = "entertainment"
    },
    CULTURE("culture", "文化") {
        override fun getFileName() = "culture"
    },
    PANDA("panda", "熊猫") {
        override fun getFileName() = "panda"
    };

    abstract fun getFileName(): String

    companion object {
        fun getUiName(fileName: String): String {
            values().forEach {
                if (it.fileName == fileName) {
                    return it.uiName
                }
            }
            return ""
        }

        fun getFileName(fileName: String): String {
            values().forEach {
                if (it.fileName == fileName) {
                    return it.getFileName()
                }
            }
            return ""
        }
    }
}

enum class EnumTest(var cover: String) {

    ONE("one") {
        override fun desc() {
            print("value of one")
        }
    };

    abstract fun desc()

    companion object {
        fun getDesc(test: EnumTest): String {
            return ""
        }
    }
}

fun getFileCover(fileName: String): String {
    val cover = fileDesc[fileName]
    return cover ?: //key不存在
    "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp"
}

fun getUiName(fileName: String): String = FileExtName.getUiName(fileName)

fun getExtFilePath(fileName: String): String = FileExtName.getFileName(fileName)

private val titleName = mapOf(
    "music" to "音乐视频",
    "all" to "大熊猫成长记录",
    "baby" to "大熊猫宝宝",
    "bear" to "北极熊",
    "beauty" to "美人如玉",
    "bird" to "中国最美的鸟",
    "fox" to "白狐",
    "knowledge" to "大熊猫百科",
    "landscape" to "中国山水记",
    "monkey" to "川金丝猴",
    "penguin" to "企鹅",
    "red_panda" to "小熊猫(红熊猫)",
    "single" to "独居大熊猫",
    "group" to "幼年大熊猫",
    "mom" to "大熊猫妈妈",
    "cat" to "喵喵喵",
    "honglou" to "红楼梦",
    "human_baby" to "可爱的人类小宝宝",
    "art" to "艺术",
    "tv" to "电视剧",
    "football" to "足球"
)

val descMap = mapOf(
    "music" to "成长阶段陪伴的音乐",
    "all" to "每一届大熊猫成长的记录",
    "baby" to "大熊猫宝宝，最可爱",
    "bear" to "极其濒危的可爱动物",
    "beauty" to "美人如玉隔云端",
    "bird" to "丹顶鹤、红腹锦鸡...",
    "fox" to "美人为什么叫狐狸精？",
    "knowledge" to "关于大熊猫的百科知识",
    "landscape" to "中国最美山水",
    "monkey" to "国家一级保护动物，濒危",
    "penguin" to "生活在南极",
    "red_panda" to "大熊猫的弟弟小熊猫",
    "single" to "独居、成年大熊猫",
    "group" to "和同级小伙伴生活在一起",
    "mom" to "妈妈会陪伴宝宝到一岁半",
    "cat" to "单身居家好伴侣",
    "honglou" to "封建社会的百科全书",
    "human_baby" to "谁都想有个小宝宝",
    "art" to "艺术的本质是一种精神",
    "tv" to "艺术的本质是一种精神",
    "football" to "艺术的本质是一种精神"
)

fun getHehuaBanner(): MutableList<PetVideo> {

    val list = mutableListOf<PetVideo>()
    val panda385 = PetVideo()
    panda385.type = VideoType.PANDA.ordinal
    panda385.period = PeriodType.BABY.ordinal
    panda385.fileName = "panda_baby_panda385"
    panda385.code = 1577
    panda385.duration = 209
    panda385.star = true
    panda385.title = "整理所有“大熊猫和花”的超可爱模样，收藏版"
    panda385.releaseTime = 1646561102
    panda385.originalUrl = "https://www.bilibili.com/video/BV1yZ4y167nq"
    panda385.tags = "大熊猫,熊猫宝宝,萌宠,动物圈"
    panda385.authorId = 21330840
    panda385.cover =
        "https://i1.hdslb.com/bfs/archive/e58750e65d6d5db007946e850b7be4c230d02270.jpg"
    panda385.vertical = false
    list.add(panda385)

    val panda305 = PetVideo()
    panda305.type = VideoType.PANDA.ordinal
    panda305.fileName = "panda_mom_panda305"
    panda305.code = 1391
    panda305.duration = 314
    panda305.star = true
    panda305.title = "【大熊猫和花&和叶】花花和小叶子玩秋千"
    panda305.releaseTime = 1642325083
    panda305.period = PeriodType.MOM.ordinal
    panda305.originalUrl = "https://www.bilibili.com/video/BV1tL4y147s1"
    panda305.tags = "熊猫,宝宝,熊猫妈妈,萌宠"
    panda305.authorId = 230382720
    panda305.cover =
        "https://i0.hdslb.com/bfs/archive/98bb2df99d65be6ee79161ec00c4e72c94b059c4.jpg"
    panda305.vertical = false
    list.add(panda305)

    val panda322 = PetVideo()
    panda322.type = VideoType.PANDA.ordinal
    panda322.fileName = "panda_group_panda322"
    panda322.code = 1569
    panda322.duration = 94
    panda322.star = true
    panda322.title = "和花真的是最美好最可爱最萌最好看的熊猫了！【大熊猫和花】"
    panda322.releaseTime = 1644883442
    panda322.period = PeriodType.GROUP.ordinal
    panda322.originalUrl = "https://www.bilibili.com/video/BV1Wb4y147om"
    panda322.tags = "大熊猫,萌宠,动物圈"
    panda322.authorId = 16468440
    panda322.cover =
        "https://i2.hdslb.com/bfs/archive/04a5af25015682855b108c819f86e33eda22c486.jpg"
    panda322.vertical = false
    list.add(panda322)

    val panda244 = PetVideo()
    panda244.type = VideoType.PANDA.ordinal
    panda244.fileName = "panda_group_panda244"
    panda244.code = 1491
    panda244.duration = 343
    panda244.star = true
    panda244.title = "两个可爱调皮鬼茱萸和花花互rua【大熊猫和花&庆茱萸】"
    panda244.releaseTime = 1637498138
    panda244.period = PeriodType.GROUP.ordinal
    panda244.originalUrl = "https://www.bilibili.com/video/BV1tQ4y1U7sK"
    panda244.tags = "大熊猫,萌宠,动物圈"
    panda244.authorId = 230382720
    panda244.cover =
        "https://i1.hdslb.com/bfs/archive/73269b1a0197042dcf5e23d758bfe262924d8a98.jpg"
    panda244.vertical = false
    list.add(panda244)

    val panda188 = PetVideo()
    panda188.type = VideoType.PANDA.ordinal
    panda188.fileName = "panda_group_panda188"
    panda188.code = 1127
    panda188.duration = 11
    panda188.star = true
    panda188.videoType = 1
    panda188.title = "【大熊猫和花】冰墩墩本墩"
    panda188.releaseTime = 1644155101
    panda188.period = PeriodType.GROUP.ordinal
    panda188.originalUrl = "https://www.bilibili.com/video/BV19R4y1j74q"
    panda188.tags = "大熊猫,萌宠,动物圈"
    panda188.authorId = 327377672
    panda188.cover =
        "https://i2.hdslb.com/bfs/archive/2f07270ffbd83be139baac23b9c5246127ffbd65.jpg"
    panda188.vertical = false
    list.add(panda188)

    return list
}