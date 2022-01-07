import com.example.pandas.bean.pet.PeriodType
import com.example.pandas.bean.pet.PetType
import com.example.pandas.bean.pet.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/8/22 12:22 上午
 * @version: v1.0
 */
public class PandaData2 {

    private val list = mutableListOf<PetVideo>()

    fun getPanda() {

        val panda1 = PetVideo()
        panda1.type = PetType.PANDA.ordinal
        panda1.fileName = "panda_baby_panda1"
        panda1.code = 180
        panda1.duration = 60
        panda1.period = PeriodType.MOM.ordinal
        panda1.isStar = false
        panda1.title = "【大熊猫艾莉和叶】我和我的艾莉妈妈是不是越来越像了呢？"
        panda1.releaseTime = "2021-09-26 12:25:57"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1df4y1w7Zz/"
        panda1.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda1.authorName = "空调轰轰响"
        panda1.cover =
            "http://i2.hdslb.com/bfs/archive/af619c6b1e4429fa8cca2a675dd9b0d9d1aeb96f.jpg"
        list.add(panda1)

        val panda2 = PetVideo()
        panda2.type = PetType.PANDA.ordinal
        panda2.fileName = "panda_baby_panda2"
        panda2.code = 181
        panda2.duration = 379
        panda2.period = PeriodType.MOM.ordinal
        panda2.isStar = false
        panda2.title = "艾莉∶小叶子真好rua！和叶∶救命！"
        panda2.releaseTime = "2021-09-11 13:40:19"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1fq4y1Z74a/"
        panda2.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda2.authorName = "瘦瘦爱吃粘豆包"
        panda2.cover =
            "http://i1.hdslb.com/bfs/archive/18ec84505855d4aa508c2837267cc9af793b9543.jpg"
        list.add(panda2)


        val panda3 = PetVideo()
        panda3.type = PetType.PANDA.ordinal
        panda3.fileName = "panda_baby_panda3"
        panda3.code = 182
        panda3.duration = 64
        panda3.period = PeriodType.MOM.ordinal
        panda3.isStar = true
        panda3.title = "艾莉妈妈跟女儿艾玖撒完娇，又去吸干儿子和叶。【大熊猫】"
        panda3.releaseTime = "2021-11-01 17:50:10"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1pL41137KJ/"
        panda3.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda3.authorName = "隽一一"
        panda3.cover =
            "http://i1.hdslb.com/bfs/archive/be56f493ba3da013a8cb861d360152d62f229eb4.jpg"
        list.add(panda3)

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "panda_baby_panda4"
        panda4.code = 183
        panda4.duration = 66
        panda4.period = PeriodType.MOM.ordinal
        panda4.isStar = false
        panda4.title = "小叶子弟弟也飘了，都敢骑妈妈山了【大熊猫和叶】"
        panda4.releaseTime = "2021-09-23 21:00:03"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1Bb4y1y7kT/"
        panda4.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda4.authorName = "小香妞爱熊猫"
        panda4.cover =
            "http://i2.hdslb.com/bfs/archive/84df87f55aacf9838fde6926e7a289fe253f829c.jpg"
        list.add(panda4)

        val panda5 = PetVideo()
        panda5.type = PetType.PANDA.ordinal
        panda5.fileName = "panda_baby_panda5"
        panda5.code = 184
        panda5.duration = 37
        panda5.period = PeriodType.MOM.ordinal
        panda5.isStar = true
        panda5.title = "大熊猫艾莉：妈妈亲自接女儿艾玖放学，好有爱呀"
        panda5.releaseTime = "2021-08-05 21:00:11"
        panda5.originalUrl = "https://www.bilibili.com/video/BV1tM4y1T7oQ/"
        panda5.tags = "艾莉,艾玖,萌宠,萌萌哒,可爱,动物圈"
        panda5.authorName = "小香妞爱熊猫"
        panda5.cover =
            "http://i0.hdslb.com/bfs/archive/441038bf47cf52d055f98e21c316357a2de5f61f.jpg"
        list.add(panda5)

        val panda6 = PetVideo()
        panda6.type = PetType.PANDA.ordinal
        panda6.fileName = "panda_baby_panda6"
        panda6.code = 185
        panda6.duration = 48
        panda6.period = PeriodType.MOM.ordinal
        panda6.isStar = true
        panda6.title = "好有爱的艾莉妈妈，专门上树叫和叶回家"
        panda6.releaseTime = "2021-10-06 22:00:12"
        panda6.originalUrl = "https://www.bilibili.com/video/BV1RL411W7Jm/"
        panda6.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda6.authorName = "小香妞爱熊猫"
        panda6.cover =
            "http://i0.hdslb.com/bfs/archive/fd905e4d161004b974fea6565e2807d409817f19.jpg"
        list.add(panda6)

        val panda7 = PetVideo()
        panda7.type = PetType.PANDA.ordinal
        panda7.fileName = "panda_baby_panda7"
        panda7.code = 186
        panda7.duration = 60
        panda7.period = PeriodType.MOM.ordinal
        panda7.isStar = true
        panda7.title = "和叶和艾莉玩，回家慢半拍，紧赶慢赶门还是关了"
        panda7.releaseTime = "2021-10-02 13:33:47"
        panda7.originalUrl = "https://www.bilibili.com/video/BV1GL411s74Q/"
        panda7.tags = "艾莉,和叶,萌宠,萌萌哒,可爱,动物圈"
        panda7.authorName = "迩後咩"
        panda7.cover =
            "http://i0.hdslb.com/bfs/archive/49e869bce4215ea9e10d55a0a76f4e0267d66eae.jpg"
        list.add(panda7)


        val panda9 = PetVideo()
        panda9.type = PetType.PANDA.ordinal
        panda9.fileName = "panda_baby_panda9"
        panda9.code = 188
        panda9.duration =30
        panda9.period = PeriodType.MOM.ordinal
        panda9.isStar = true
        panda9.title = "【大熊猫莽仔】搓汤圆，搓汤圆，莽仔搓的汤圆是圆又圆"
        panda9.releaseTime = "2021-11-25 16:36:06"
        panda9.originalUrl = "https://www.bilibili.com/video/BV1cg411K799/"
        panda9.tags = "莽仔,萌宠,萌萌哒,可爱,动物圈"
        panda9.authorName = "猴哥某熊铁锤都退役了"
        panda9.cover = "http://i2.hdslb.com/bfs/archive/d5e6783a832c6c2048ffa584737efc3c4a3fa5de.jpg"
        list.add(panda9)


    }
}