import com.example.pandas.bean.pet.PetType
import com.example.pandas.sql.entity.PeriodType
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/22/22 6:06 下午
 * @version: v1.0
 */
object PetBanner {

    private var list = mutableListOf<PetVideo>()

    fun getAllBanner(): MutableList<PetVideo> {

        val panda4 = PetVideo()
        panda4.type = PetType.PANDA.ordinal
        panda4.fileName = "video_banner1"
        panda4.code = 423
        panda4.duration = 61
        panda4.period = PeriodType.BABY.ordinal
        panda4.videoType = 1
        panda4.title = "毛茸茸的小可爱谁不想拥有一只"
        panda4.releaseTime = "2021-12-27 19:00:12"
        panda4.originalUrl = "https://www.bilibili.com/video/BV1bL4y1E7L8"
        panda4.tags = "熊猫,冰雪"
        panda4.authorName = "北京2022年冬奥会"
        panda4.cover =
            "http://i1.hdslb.com/bfs/archive/8c551b4ec8aad66ddafc523dbef16b180b85d27d.jpg"
        list.add(panda4)

        val panda3 = PetVideo()
        panda3.type = PetType.CHINA.ordinal
        panda3.fileName = "video_banner2"
        panda3.code = 424
        panda3.duration = 59
        panda3.videoType = 1
        panda3.title = "今天，雪中的橘子洲头"
        panda3.releaseTime = "2021-12-26 22:52:52"
        panda3.originalUrl = "https://www.bilibili.com/video/BV1v3411v7Hi"
        panda3.tags = "中国,湖南,橘子洲头,雪"
        panda3.authorName = "中国青年报"
        panda3.cover =
            "http://i2.hdslb.com/bfs/archive/96ab6c6fc7474a67de916c75397161fcc9297095.jpg"
        list.add(panda3)

        val panda1 = PetVideo()
        panda1.type = PetType.PENGUIN.ordinal
        panda1.fileName = "video_banner3"
        panda1.code = 425
        panda1.duration = 58
        panda1.period = PeriodType.BABY.ordinal
        panda1.videoType = 1
        panda1.title = "揣进毛茸茸的小裤兜"
        panda1.releaseTime = "2021-09-27 12:10:17"
        panda1.originalUrl = "https://www.bilibili.com/video/BV1iQ4y1z7RK"
        panda1.tags = "企鹅"
        panda1.authorName = "冻冻sama"
        panda1.cover =
            "http://i2.hdslb.com/bfs/archive/a27db041ca7af069e12ead43c35e11a45a44bb86.jpg"
        list.add(panda1)


        val panda2 = PetVideo()
        panda2.type = PetType.HUMAN.ordinal
        panda2.fileName = "video_banner4"
        panda2.code = 426
        panda2.duration = 62
        panda2.videoType = 1
        panda2.title = "飞天的四月，无人机视角"
        panda2.releaseTime = "2021-12-01 13:19:42"
        panda2.originalUrl = "https://www.bilibili.com/video/BV1v44y1h7jw"
        panda2.tags = "四月,飞天"
        panda2.authorName = "摄影师黄永强"
        panda2.cover =
            "http://i0.hdslb.com/bfs/archive/21dc90239bd1e237ef080604e7295dc9a59088be.jpg"
        list.add(panda2)

        return list
    }

}