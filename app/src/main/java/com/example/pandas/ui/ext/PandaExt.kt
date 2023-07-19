package com.example.pandas.ui.ext;

//展示熊猫 相关的信息

fun getPandaInfo(name: String) {


}

/**
 * 大熊猫个体的相关信息
 */
enum class PandaInfo(
    private var pandaName: String,//大熊猫名字
    private var pandaCode: Int, //大熊猫谱系号
    private var header: String //大熊猫头像
) {

    HEHUA(
        "和花",
        1237,
        "https://i2.hdslb.com/bfs/face/58cb6cf0745c12d8a70e429568bdadde1098624e.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "和花，雌性大熊猫，谱系号1237，2020年7月4日与双胞胎弟弟和叶出生在成都大熊猫繁育研究基地月亮产房，初生体重200g，为辨识度和颜值都很高的一只熊猫。母亲为“洁癖公主”成功，父亲是海归大熊猫美兰 \n" +
                    "2023年，和花在各大社交平台爆火，“熊猫和花”先后登上多个平台热搜第一，并长时间霸榜，被网友称为“熊猫界的顶流女明星”。"
        }
    },
    HEYE(
        "和叶",
        1238,
        "https://i2.hdslb.com/bfs/face/58c324d554f34387490986ee5c9ae25eac299e79.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "和叶，雄性大熊猫，谱系号1238 ，于2020年7月4日与双胞胎姐姐和花出生在成都大熊猫繁育研究基地月亮产房，初生体重162.6g，性格乖巧，有些敏感。\n" +
                    "母亲为“洁癖公主”大熊猫成功，出生于2000年9月11日，现居成都大熊猫繁育研究基地。\n" +
                    "2022年1月11日，广东思宝不锈钢制品有限公司在其官方公众号发表文章《大熊猫“思宝”和“盼奥”的来信》，宣布于2020年7月4日认养了大熊猫双胞胎和花、和叶，认养名分别为思宝、盼奥"
        }
    },
    RUNYUE(
        "润玥",
        1233,
        "https://i2.hdslb.com/bfs/face/204391225df8d2fec279439e96b80fef6a9049b0.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "润玥，大熊猫，雌性，谱系号1233。2020年6月5日出生在成都大熊猫繁育研究基地月亮产房，初生体重172.6g。母亲是大熊猫园润，为园润的第二个孩子。\n" +
                    "是备受欢迎的大熊猫组合“玖菜花叶”中的一员。2021年5月25日，饭扫光集团认养大熊猫润玥，认养名为“菜菜” 。"
        }
    },
    AIJIU(
        "艾玖",
        1235,
        "https://i2.hdslb.com/bfs/face/cb1b02b2ffbb593387d6f008a0c6cba898ff3613.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "大熊猫艾玖，雌性，谱系号1235 。2020年6月5日中午13点06分出生在成都大熊猫繁育研究基地月亮产房，初生体重219g。母亲是大熊猫艾莉，父亲是大熊猫功仔。\n" +
                    "艾玖是成都熊猫基地有记录以来，初生体重最重的幼仔"
        }
    },
    JIXIAO(
        "绩笑",
        1171,
        "https://i0.hdslb.com/bfs/face/356ff0f1c971b048f7c3df4c605fc7ba13a0560b.jpg@240w_240h_1c_1s.webp"
    ) {
        override fun getPandaDesc(): String {
            return "绩笑，大熊猫，雌性。2019年6月5日出生于在成都大熊猫繁育研究基地太阳产房，初生体重166.8g。2019年全球首只圈养大熊猫。是成家班的一员，也是只“小灰灰”。母亲大熊猫绩丽。\n" +
                    "2019年10月21日，江中食疗宣布终身认养了大熊猫“绩笑”，改名为“稀稀”，取自大熊猫系珍稀动物和江中猴姑米稀之意。"
        }
    },
    FEIYUN(
        "飞云",
        774,
        "https://i2.hdslb.com/bfs/face/9bf8808df7dfa7d25cf09149aade2ddcb6273cb3.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "飞云，雌性，2010年7月30日出生于雅安碧峰峡基地，谱系号774，父亲是大熊猫芦芦，母亲是大熊猫妃妃。\n" +
                    "2012年9月21日，飞云和金虎、妙音搬家至大连森林动物园生活。"
        }
    },
    MEILAN(
        "梅兰",
        991,
        "https://i2.hdslb.com/bfs/face/88494fac3738d1a351def35c25c1fd293ed8e03f.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "梅兰，雌性大熊猫，小名“梅菜扣肉”，爱称“肉肉”，谱系号991。2016年5月29日出生在成都大熊猫繁育研究基地，父亲是大熊猫勇勇，母亲是海归大熊猫梅浜。肉肉的毛色比同龄小伙伴更黄，头大毛蓬。喜欢玩水，喜欢跟饲养员玩耍，特别爱撒娇。\n2018年12月14日 肉肉正式从幼年园毕业搬到都江堰熊猫谷居住。"
        }
    },
    MENGLAN(
        "萌兰",
        954,
        "https://i2.hdslb.com/bfs/face/b759e615d30ec52dc454c4980aa1cfa6d6643a3a.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "萌兰，大熊猫，谱系号954，雄性。2015年7月4日22:13分出生于成都大熊猫繁育研究基地，出生体重179.8g，小名么么儿，是白德耀斯和蓬蓬脸家族的明星成员之一。\n" +
                    "2017年9月21日，萌兰乘飞机返回北京。10月16日，在北京动物园与游客正式见面，现居北京动物园。"
        }
    },
    CHENCHEN(
        "辰辰",
        954,
        "https://i2.hdslb.com/bfs/face/3d7eb4305dc8ee10155b94ec83b74c849d6c6898.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "辰辰，雄性大熊猫，2021年6月10日出生在重庆动物园。母亲是大熊猫莽仔，同胞兄弟“星星”"
        }
    },
    PANDA_BABY(
        "熊猫宝宝",
        99999,
        "https://i2.hdslb.com/bfs/face/2084053890a74ebccdc2879b92fe8a4113f0c064.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "大熊猫幼崽"
        }
    };

    abstract fun getPandaDesc(): String

    companion object {
        fun getPandaCode(pandaName: String): Int {
            values().forEach {
                if (it.pandaName == pandaName) {
                    return it.pandaCode
                }
            }
            return -1
        }

        fun getPandaDesc(pandaName: String): String {
            values().forEach {
                if (it.pandaName == pandaName) {
                    return it.getPandaDesc()
                }
            }
            return ""
        }

        fun getHeader(pandaName: String): String {
            values().forEach {
                if (it.pandaName == pandaName) {
                    return it.header
                }
            }
            return ""
        }

        fun getPandaName(pandaCode: Int): String {
            values().forEach {
                if (it.pandaCode == pandaCode) {
                    return it.pandaName
                }
            }
            return ""
        }
    }
}