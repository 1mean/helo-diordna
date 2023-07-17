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

    JIXIAO(
        "绩笑",
        1171,
        "https://i0.hdslb.com/bfs/face/7d7f331cf31da0f0f87a2adeea9f687a391f0c34.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "绩笑，大熊猫，雌性。2019年6月5日出生于在成都大熊猫繁育研究基地太阳产房，初生体重166.8g。2019年全球首只圈养大熊猫。是成家班的一员，也是只“小灰灰”。母亲大熊猫绩丽。\n" +
                    "2019年10月21日，江中食疗宣布终身认养了大熊猫“绩笑”，改名为“稀稀”，取自大熊猫系珍稀动物和江中猴姑米稀之意。"
        }
    },
    MEILAN(
        "梅兰",
        991,
        "https://i2.hdslb.com/bfs/face/88494fac3738d1a351def35c25c1fd293ed8e03f.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "梅兰，雌性大熊猫，小名“梅菜扣肉”，爱称“肉肉”，谱系号991。2016年5月29日出生在成都大熊猫繁育研究基地，父亲是大熊猫勇勇，母亲是海归大熊猫梅浜。肉肉的毛色比同龄小伙伴更黄，头大毛蓬。喜欢玩水，喜欢跟饲养员玩耍，特别爱撒娇。\n 2018年12月14日 肉肉正式从幼年园毕业搬到都江堰熊猫谷居住。"
        }
    },
    MENGLAN(
        "萌兰",
        954,
        "https://i1.hdslb.com/bfs/face/db501d0c398816b9cadfb88890de949211487d2c.jpg"
    ) {
        override fun getPandaDesc(): String {
            return "萌兰，大熊猫，谱系号954，雄性。2015年7月4日22:13分出生于成都大熊猫繁育研究基地，出生体重179.8g，小名么么儿，是白德耀斯和蓬蓬脸家族的明星成员之一。\n" +
                    "2017年9月21日，萌兰乘飞机返回北京。10月16日，在北京动物园与游客正式见面，现居北京动物园。"
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