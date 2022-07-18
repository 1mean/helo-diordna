package com.example.pandas.app;

import com.example.pandas.utils.FileUtils

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
    "football" to "https://i0.hdslb.com/bfs/archive/56101cc1a83c3eb4ed72968761c096204a9f6299.jpg"
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
    MONKEY("monkey", "金丝猴") {
        override fun getFileName() = "animal/monkey"
    },
    PENGUIN("penguin", "企鹅") {
        override fun getFileName() = "animal/penguin"
    },
    RED_PANDA("red_panda", "小熊猫") {
        override fun getFileName() = "animal/red_panda"
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

        fun getFileName(fileName: String):String{
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